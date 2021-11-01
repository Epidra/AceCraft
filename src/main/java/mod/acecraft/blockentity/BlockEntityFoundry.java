package mod.acecraft.blockentity;

import mod.acecraft.Config;
import mod.acecraft.ShopKeeper;
import mod.acecraft.util.FoundryContent;
import mod.acecraft.util.LogicFoundry;
import mod.lucky77.blockentity.BlockEntityBase;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.*;

public class BlockEntityFoundry extends BlockEntityBase<LogicFoundry> {

    private Item lastCheckedItem = Blocks.AIR.asItem();
    public int coalAmount = 0;
    public int cookTime = 0;
    public int cookTimeMax = 600;

    public final ContainerData data = new ContainerData() {
        public int get(int index) {
            switch(index) {
                default: return 0;
                case  0: return coalAmount;
                case  1: return cookTime;
                case  2: return cookTimeMax;
            }
        }
        public void set(int index, int value) {
            switch(index) {
                default:                     break;
                case 0: coalAmount  = value; break;
                case 1: cookTime    = value; break;
                case 2: cookTimeMax = value; break;
            }
        }
        public int getCount() {
            return 3;
        }
    };





    //----------------------------------------CONSTRUCTOR----------------------------------------//

    public BlockEntityFoundry(BlockEntityType<?> tileEntityTypeIn, BlockPos blockpos, BlockState blockstate) {
        super(tileEntityTypeIn, blockpos, blockstate, 6, new LogicFoundry());
    }

    public BlockEntityFoundry(BlockPos blockpos, BlockState blockstate) {
        this(ShopKeeper.TILE_FOUNDRY.get(), blockpos, blockstate);
    }





    //----------------------------------------SERVER_TICK----------------------------------------//

    public static void serverTick(Level level, BlockPos pos, BlockState state, BlockEntityFoundry BE){
        boolean isDirty = false;
        if(BE.cookTime == 0){
            if(!BE.inventory.get(0).isEmpty()){
                if(BE.lastCheckedItem != BE.inventory.get(0).getItem()){
                    isDirty = BE.searchForMaterial();
                    BE.lastCheckedItem = isDirty ? Blocks.AIR.asItem() : BE.inventory.get(0).getItem();
                }
            }
        } else {
            BE.cookTime++;
            if(BE.cookTime >= BE.cookTimeMax){
                BE.cookTime = 0;
                BE.logic().findBestMix();
            }
        }
        if (isDirty){
            BE.setChanged();
        }
    }





    //----------------------------------------SAVE/LOAD----------------------------------------//

    public void load(CompoundTag nbt){
        super.load(nbt);
        this.coalAmount = nbt.getInt("Coal");
        this.cookTime = nbt.getInt("CookTime");
        this.cookTimeMax = nbt.getInt("CookTimeMax");
        if(logic().content.isEmpty()){
            createMaterialMap();
        }
        logic().load(nbt.getString("Content"));
    }

    public CompoundTag save(CompoundTag compound){
        super.save(compound);
        compound.putInt("Coal", this.coalAmount);
        compound.putInt("CookTime", this.cookTime);
        compound.putInt("CookTimeMax", this.cookTimeMax);
        if(logic().content.isEmpty()){
            createMaterialMap();
        }
        compound.putString("Content", logic().save());
        return compound;
    }





    //----------------------------------------NETWORK----------------------------------------//

    @Override
    @Nullable
    public ClientboundBlockEntityDataPacket getUpdatePacket(){
        CompoundTag nbtTagCompound = new CompoundTag();
        save(nbtTagCompound);
        return new ClientboundBlockEntityDataPacket(this.worldPosition, ShopKeeper.TILE_FOUNDRY.get().hashCode(), nbtTagCompound);
    }





    //----------------------------------------SUPPORT----------------------------------------//

    private boolean searchForMaterial(){
        if(logic().content.isEmpty()){
            createMaterialMap();
        }
        if(inventory.get(0).getItem() == Items.COAL || inventory.get(0).getItem() == Items.CHARCOAL){
            coalAmount++;
            if(inventory.get(0).getCount() == 1){
                inventory.set(0, ItemStack.EMPTY);
            } else {
                inventory.get(0).shrink(1);
            }
            return true;
        }
        Collection<Recipe<?>> stuff = level.getRecipeManager().getRecipes();
        for(Recipe r : stuff){
            if(r.getResultItem().getItem() == inventory.get(0).getItem()){
                if(addItemsToFoundry(r.getIngredients())){
                    if(inventory.get(0).getCount() == 1){
                        inventory.set(0, ItemStack.EMPTY);
                    } else {
                        inventory.get(0).shrink(1);
                    }
                    return true;
                }
            }
        }
        if(addItemToFoundry(inventory.get(0).getItem())){
            if(inventory.get(0).getCount() == 1){
                inventory.set(0, ItemStack.EMPTY);
            } else {
                inventory.get(0).shrink(1);
            }
            return true;
        }
        return false;
    }

    // Searches through internal list if the given item is recognized by the foundry
    private boolean isFoundryItem(Item item){
        for(FoundryContent c : logic().content){
            if(c.tryToAddItem(item)){
                return true;
            }
        }
        return false;
    }

    // adds to internal reserve and clears ItemSlot
    private boolean addItemToFoundry(Item item){
        return isFoundryItem(item);
    }

    private boolean addItemsToFoundry(NonNullList<Ingredient> ingredients) {
        boolean foundMatch = false;
        for(Ingredient i : ingredients){
            ItemStack[] stack = i.getItems();
            for(int z = 0; z < stack.length; z++){
                if(isFoundryItem(stack[z].getItem())){
                    foundMatch = true;
                }
            }
        }
        return foundMatch;
    }

    private void createMaterialMap(){
        ArrayList<Item> subSlag = new ArrayList<>();
        subSlag.add(ShopKeeper.STUFF_SLAG.get());
        logic().content.add(new FoundryContent("slag", ShopKeeper.STUFF_SLAG.get(), subSlag, null));
        for(String s : Config.FOUNDRY.entry.get()){
            String[] split = s.split(",");
            String value = split[0];
            if(split.length > 1){
                Item item = Registry.ITEM.get(new ResourceLocation(split[1]));
                ArrayList<Item> subs = new ArrayList<>();
                for(int i = 1; i < split.length; i++){
                    Item tmp = Registry.ITEM.get(new ResourceLocation(split[i]));
                    if(tmp != Blocks.AIR.asItem()){
                        subs.add(tmp);
                    }
                }
                FoundryContent.Alloy alloy = findMatchingAlloy(value);
                logic().content.add(new FoundryContent(value, item, subs, alloy));
            }
        }
    }

    private FoundryContent.Alloy findMatchingAlloy(String value){
        for(String s : Config.FOUNDRY.smelt.get()){
            String[] split = s.split(",");
            if(split.length == 6 && split[0].matches(value)){
                return new FoundryContent.Alloy(Integer.parseInt(split[1]), Integer.parseInt(split[3]), split[2], split[4], Integer.parseInt(split[5]));
            }
        }
        return null;
    }

    private boolean isContentMaxed(){
        int i = 0;
        for(FoundryContent f : logic().content){
            i += f.amount;
        }
        return i >= 64;
    }

    public void ignite() {
        if(cookTime == 0){
            if(coalAmount > logic().count() / 8 + 1){
                coalAmount -= logic().count() / 8 + 1;
                cookTime = 1;
                cookTimeMax = logic().count() * 100;
            }
        }
    }

    public void eject(){
        if(cookTime == 0){
            int invPos = 1;
            for(int i = 1; i < 6; i++){
                if(inventory.get(i).isEmpty()){
                    break;
                } else {
                    invPos++;
                }
            }
            for(FoundryContent c : logic().content){
                if(c.amount > 0){
                    inventory.set(invPos, c.generateStack());
                    c.clear();
                    invPos++;
                    if(invPos == 6){
                        break;
                    }
                }
            }
        }
    }





    //----------------------------------------BASIC----------------------------------------//

    @Override
    public TextComponent getName() {
        return new TextComponent("tile.destillery.name");
    }

    @Override
    public ContainerData getIntArray() {
        return data;
    }

    private LogicFoundry logic(){
        return (LogicFoundry) logic;
    }



}
