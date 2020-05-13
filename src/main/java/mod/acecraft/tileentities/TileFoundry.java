package mod.acecraft.tileentities;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import mod.acecraft.ShopKeeper;
import mod.acecraft.blocks.BlockFoundry;
import mod.acecraft.container.ContainerFoundry;
import mod.acecraft.util.BurnTimes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TileFoundry extends TileBase {

    //private final IIntArray data = getData();


    public TileFoundry() {
        super(ShopKeeper.TILE_FOUNDRY.get());
    }

    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.foundry");
    }

    protected ContainerFoundry createMenu(int id, PlayerInventory player) {
        return new ContainerFoundry(id, player, this);
    }

    @Override
    public ITextComponent getName() {
        return new TranslationTextComponent("tile.foundry.name");
    }

    @Override
    public IIntArray getIntArray() {
        return data;
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return true;
    }

    @Override
    @Nullable
    public SUpdateTileEntityPacket getUpdatePacket(){
        CompoundNBT nbtTagCompound = new CompoundNBT();
        write(nbtTagCompound);
        return new SUpdateTileEntityPacket(this.pos, ShopKeeper.TILE_FOUNDRY.get().hashCode(), nbtTagCompound);
    }

    /** ??? */
    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        read(pkt.getNbtCompound());
    }

    /** Creates a tag containing the TileEntity information, used by vanilla to transmit from server to client */
    @Override
    public CompoundNBT getUpdateTag(){
        CompoundNBT nbtTagCompound = new CompoundNBT();
        write(nbtTagCompound);
        return nbtTagCompound;
    }

    /** Populates this TileEntity with information from the tag, used by vanilla to transmit from server to client */
    @Override
    public void handleUpdateTag(CompoundNBT tag){
        this.read(tag);
    }





    public ITextComponent getDisplayName() {
        return new StringTextComponent(getType().getRegistryName().getPath());
    }

    public Container createMenu(int id, PlayerInventory player, PlayerEntity playerEntity) {
        Preconditions.checkArgument(getWorld() != null);
        return new ContainerFoundry(id, player, this);
    }

    private static final int[] SLOTS_UP = new int[]{0};
    private static final int[] SLOTS_DOWN = new int[]{2, 1};
    private static final int[] SLOTS_HORIZONTAL = new int[]{1};
    protected NonNullList<ItemStack> items = NonNullList.withSize(3, ItemStack.EMPTY);
    protected List<ItemStack> storage = new ArrayList<ItemStack>();
    private final Map<ResourceLocation, Integer> field_214022_n = Maps.newHashMap();
    //private ContainerContent materials = new FoundryContent();
    private int burnTime; // how long until fuel item is used up
    private int recipesUsed;
    private int cookTime; // how long until result item appears
    private int cookTimeTotal;

    protected final IIntArray data = new IIntArray() {
        public int get(int index) {
            switch(index) {
                case 0: return TileFoundry.this.burnTime;
                case 1: return TileFoundry.this.recipesUsed;
                case 2: return TileFoundry.this.cookTime;
                case 3: return TileFoundry.this.cookTimeTotal;
                case 4: return TileFoundry.this.storageAmount();
                default: return 0;
            }
        }

        public void set(int index, int value) {
            switch(index) {
                case 0: TileFoundry.this.burnTime      = value; break;
                case 1: TileFoundry.this.recipesUsed   = value; break;
                case 2: TileFoundry.this.cookTime      = value; break;
                case 3: TileFoundry.this.cookTimeTotal = value;
            }
        }

        public int size() {
            return 5;
        }
    };



    private boolean isBurning() {
        return this.burnTime > 0;
    }

    public void read(CompoundNBT compound) {
        super.read(compound);
        int storageSize = compound.getInt("StorageSize");

        NonNullList<ItemStack> itemsLoaded = NonNullList.withSize(3 + storageSize, ItemStack.EMPTY);
        this.items = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, itemsLoaded);
        this.burnTime = compound.getInt("BurnTime");
        this.cookTime = compound.getInt("CookTime");
        this.cookTimeTotal = compound.getInt("CookTimeTotal");

        items.set(0, itemsLoaded.get(0));
        items.set(1, itemsLoaded.get(1));
        items.set(2, itemsLoaded.get(2));

        storage.clear();
        for(int i = 0; i < storageSize; i++){
            storage.add(itemsLoaded.get(3+i));
        }



        //materials.read(compound);

    }

    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        compound.putInt("StorageSize", this.storage.size());
        compound.putInt("BurnTime", this.burnTime);
        compound.putInt("CookTime", this.cookTime);
        compound.putInt("CookTimeTotal", this.cookTimeTotal);

        NonNullList<ItemStack> itemsSaved = NonNullList.withSize(3 + this.storage.size(), ItemStack.EMPTY);

        itemsSaved.set(0, items.get(0));
        itemsSaved.set(1, items.get(1));
        itemsSaved.set(2, items.get(2));

        for(int i = 0; i < this.storage.size(); i++){
            itemsSaved.set(3 + i, this.storage.get(i));
        }

        ItemStackHelper.saveAllItems(compound, itemsSaved);

        //materials.write(compound);

        return compound;
    }

    private int storageAmount(){
        int amount = 0;
        for(ItemStack stack : storage){
            amount += stack.getCount();
        }
        return amount;
    }

    private boolean storageIsFull(){
        int amount = 0;
        for(ItemStack stack : storage){
            amount += stack.getCount();
        }
        return amount >= 64;
    }

    private boolean storageAdd(Item item){
        if(item == Items.COAL){ storageAdd2(Items.COAL, 1); return true; }
        if(item == Items.CHARCOAL){ storageAdd2(Items.COAL, 1); return true; }
        if(item == Items.COAL_BLOCK){ storageAdd2(Items.COAL_BLOCK, 9); return true; }

        if(item == ShopKeeper.NUGGET_IRON.get()        ){ storageAdd2(Items.IRON_INGOT, 1); return true; }
        if(item == Items.IRON_INGOT){ storageAdd2(Items.IRON_INGOT, 1); return true; }
        if(item == Items.IRON_BLOCK){ storageAdd2(Items.IRON_INGOT, 9); return true; }

        if(item == ShopKeeper.NUGGET_GOLD.get()        ){ storageAdd2(Items.GOLD_INGOT, 1); return true; }
        if(item == Items.GOLD_INGOT){ storageAdd2(Items.GOLD_INGOT, 1); return true; }
        if(item == Items.GOLD_BLOCK){ storageAdd2(Items.GOLD_INGOT, 9); return true; }

        if(item == ShopKeeper.NUGGET_COPPER.get()        ){ storageAdd2(ShopKeeper.ITEM_COPPER.get(), 1); return true; }
        if(item == ShopKeeper.ITEM_COPPER.get()         ){ storageAdd2(ShopKeeper.ITEM_COPPER.get(), 1); return true; }
        if(item == ShopKeeper.BLOCK_COPPER.get().asItem()){ storageAdd2(ShopKeeper.ITEM_COPPER.get(), 9); return true; }

        if(item == ShopKeeper.NUGGET_GILIUM.get()         ){ storageAdd2(ShopKeeper.ITEM_GILIUM.get(), 1); return true; }
        if(item == ShopKeeper. ITEM_GILIUM.get()         ){ storageAdd2(ShopKeeper.ITEM_GILIUM.get(), 1); return true; }
        if(item == ShopKeeper. BLOCK_GILIUM.get().asItem()){ storageAdd2(ShopKeeper.ITEM_GILIUM.get(), 9); return true; }

        //if(item == ShopKeeper.NUGGET_ADAMANTIUM         ){ storageAdd2(ShopKeeper.ITEM_ADAMANTIUM, 1); return true; }
        if(item == ShopKeeper. ITEM_ADAMANTIUM.get()         ){ storageAdd2(ShopKeeper.ITEM_ADAMANTIUM.get(), 1); return true; }
        if(item == ShopKeeper. BLOCK_ADAMANTIUM.get().asItem()){ storageAdd2(ShopKeeper.ITEM_ADAMANTIUM.get(), 9); return true; }

        //if(item == ShopKeeper.NUGGET_BRONZE         ){ storageAdd2(ShopKeeper.ITEM_BRONZE, 1); return true; }
        if(item == ShopKeeper. ITEM_BRONZE.get()         ){ storageAdd2(ShopKeeper.ITEM_BRONZE.get(), 1); return true; }
        if(item == ShopKeeper. BLOCK_BRONZE.get().asItem()){ storageAdd2(ShopKeeper.ITEM_BRONZE.get(), 9); return true; }

        //if(item == ShopKeeper.NUGGET_BRASS         ){ storageAdd2(ShopKeeper.ITEM_BRASS, 1); return true; }
        if(item == ShopKeeper. ITEM_BRASS.get()         ){ storageAdd2(ShopKeeper.ITEM_BRASS.get(), 1); return true; }
        if(item == ShopKeeper. BLOCK_BRASS.get().asItem()){ storageAdd2(ShopKeeper.ITEM_BRASS.get(), 9); return true; }

        if(item == ShopKeeper.NUGGET_MYTHRIL.get()         ){ storageAdd2(ShopKeeper.ITEM_MYTHRIL.get(), 1); return true; }
        if(item == ShopKeeper. ITEM_MYTHRIL.get()         ){ storageAdd2(ShopKeeper.ITEM_MYTHRIL.get(), 1); return true; }
        if(item == ShopKeeper. BLOCK_MYTHRIL.get().asItem()){ storageAdd2(ShopKeeper.ITEM_MYTHRIL.get(), 9); return true; }

        //if(item == ShopKeeper.NUGGET_ORICHALCUM         ){ storageAdd2(ShopKeeper.ITEM_ORICHALCUM, 1); return true; }
        if(item == ShopKeeper. ITEM_ORICHALCUM.get()         ){ storageAdd2(ShopKeeper.ITEM_ORICHALCUM.get(), 1); return true; }
        if(item == ShopKeeper. BLOCK_ORICHALCUM.get().asItem()){ storageAdd2(ShopKeeper.ITEM_ORICHALCUM.get(), 9); return true; }

        if(item == ShopKeeper.NUGGET_TIN.get()         ){ storageAdd2(ShopKeeper.ITEM_TIN.get(), 1); return true; }
        if(item == ShopKeeper. ITEM_TIN.get()         ){ storageAdd2(ShopKeeper.ITEM_TIN.get(), 1); return true; }
        if(item == ShopKeeper. BLOCK_TIN.get().asItem()){ storageAdd2(ShopKeeper.ITEM_TIN.get(), 9); return true; }

        if(item == ShopKeeper.NUGGET_ZINC.get()         ){ storageAdd2(ShopKeeper.ITEM_ZINC.get(), 1); return true; }
        if(item == ShopKeeper. ITEM_ZINC.get()         ){ storageAdd2(ShopKeeper.ITEM_ZINC.get(), 1); return true; }
        if(item == ShopKeeper. BLOCK_ZINC.get().asItem()){ storageAdd2(ShopKeeper.ITEM_ZINC.get(), 9); return true; }

        //if(item == ShopKeeper.NUGGET_STEEL         ){ storageAdd2(ShopKeeper.ITEM_STEEL, 1); return true; }
        if(item == ShopKeeper. ITEM_STEEL.get()         ){ storageAdd2(ShopKeeper.ITEM_STEEL.get(), 1); return true; }
        if(item == ShopKeeper. BLOCK_STEEL.get().asItem()){ storageAdd2(ShopKeeper.ITEM_STEEL.get(), 9); return true; }
        return false;
    }

    private void storageAdd2(Item item, int amount){
        boolean exists = false;
        for(ItemStack stack : storage){
            if(item == stack.getItem()){
                exists = true;
                stack.grow(amount);
            }
        }
        if(!exists){
            storage.add(new ItemStack(item, amount));
        }
    }

    public void tick() {
        boolean flag = this.isBurning();
        boolean flag1 = false;
        if (this.isBurning()) {
            --this.burnTime;
        }

        if(!items.get(0).isEmpty()){
            if(!storageIsFull()){
                if(storageAdd(items.get(0).getItem())){
                    items.get(0).shrink(1);
                }
            }
        }

        //if(!this.items.get(0).isEmpty()){
        //    materials.add(items.get(0).getDisplayName().getString());
        //}

        //if (!this.world.isRemote) {
            ItemStack fuelitem = this.items.get(1);
            if (this.isBurning() || !fuelitem.isEmpty() && storageAmount() > 0) {
                if (!this.isBurning() && this.canSmelt()) {
                    this.burnTime = this.getBurnTime(fuelitem);
                    this.recipesUsed = this.burnTime;
                    if (this.isBurning()) {
                        flag1 = true;
                        if (fuelitem.hasContainerItem())
                            this.items.set(1, fuelitem.getContainerItem());
                        else
                        if (!fuelitem.isEmpty()) {
                            Item item = fuelitem.getItem();
                            fuelitem.shrink(1);
                            if (fuelitem.isEmpty()) {
                                this.items.set(1, fuelitem.getContainerItem());
                            }
                        }
                    }
                }

                if (this.isBurning() && this.canSmelt()) {
                    ++this.cookTime;
                    if (this.cookTime == this.cookTimeTotal) {
                        this.cookTime = 0;
                        this.cookTimeTotal = this.getTotalCookTime();
                        this.func_214007_c();
                        flag1 = true;
                    }
                } else {
                    this.cookTime = 0;
                }
            } else if (!this.isBurning() && this.cookTime > 0) {
                this.cookTime = MathHelper.clamp(this.cookTime - 2, 0, this.cookTimeTotal);
            }

            if (flag != this.isBurning()) {
                flag1 = true;
                this.world.setBlockState(this.pos, this.world.getBlockState(this.pos).with(BlockFoundry.LIT, Boolean.valueOf(this.isBurning())), 3);
            }
        //}

        if (flag1) {
            this.markDirty();
        }

    }

    protected int getTotalCookTime() {
        return 200;
    }

    private int storageGet(Item item){
        for(ItemStack stack : storage){
            if(item == stack.getItem())
                return stack.getCount();
        }
        return 0;
    }


    protected boolean canSmelt() {

        int amount = storageAmount();

        if(storage.size() > 1){
            if(amount == 0){
                return false;
            }

            float countCoal = storageGet(Items.COAL) / (float)amount;
            float countIron = storageGet(Items.IRON_INGOT) / (float)amount;
            float countGold = storageGet(Items.GOLD_INGOT) / (float)amount;

            float countCopper     = storageGet(ShopKeeper.ITEM_COPPER.get()) / (float)amount;
            float countBronze     = storageGet(ShopKeeper.ITEM_BRONZE.get()) / (float)amount;
            float countBrass      = storageGet(ShopKeeper.ITEM_BRASS.get()) / (float)amount;
            float countGilium     = storageGet(ShopKeeper.ITEM_GILIUM.get()) / (float)amount;
            float countAdamantium = storageGet(ShopKeeper.ITEM_ADAMANTIUM.get()) / (float)amount;
            float countMythril    = storageGet(ShopKeeper.ITEM_MYTHRIL.get()) / (float)amount;
            float countOrichalcum = storageGet(ShopKeeper.ITEM_ORICHALCUM.get()) / (float)amount;
            float countSteel      = storageGet(ShopKeeper.ITEM_STEEL.get()) / (float)amount;
            float countTin        = storageGet(ShopKeeper.ITEM_TIN.get()) / (float)amount;
            float countZinc       = storageGet(ShopKeeper.ITEM_ZINC.get()) / (float)amount;

            if(countCopper > 0.85f && countCopper < 0.95f && countTin > 0.05f && countTin < 0.15f){ // Bronze
                storage.clear();
                storage.add(new ItemStack(ShopKeeper.ITEM_BRONZE.get(), amount));
            }
            else if(countCopper > 0.85f && countCopper < 0.95f && countZinc > 0.05f && countZinc < 0.15f){ // Brass
                storage.clear();
                storage.add(new ItemStack(ShopKeeper.ITEM_BRASS.get(), amount));
            }
            else if(countMythril > 0.85f && countMythril < 0.95f && countZinc > 0.05f && countZinc < 0.15f){ // Orichalcum
                storage.clear();
                storage.add(new ItemStack(ShopKeeper.ITEM_ORICHALCUM.get(), amount));
            }
            else if(countGilium > 0.85f && countGilium < 0.95f && countTin > 0.05f && countTin < 0.15f){ // Adamantium
                storage.clear();
                storage.add(new ItemStack(ShopKeeper.ITEM_ADAMANTIUM.get(), amount));
            }
            else if(countIron > 0.85f && countIron < 0.95f && countCoal > 0.05f && countCoal < 0.15f){ // Steel
                storage.clear();
                storage.add(new ItemStack(ShopKeeper.ITEM_STEEL.get(), amount));
            } else {
                Item item = Items.IRON_INGOT;
                float f = countIron;
                if(countGold       > f){ item = Items.GOLD_INGOT;            f = countGold; }
                if(countCopper     > f){ item = ShopKeeper.ITEM_COPPER.get();     f = countCopper; }
                if(countBronze     > f){ item = ShopKeeper.ITEM_BRONZE.get();     f = countBronze; }
                if(countBrass      > f){ item = ShopKeeper.ITEM_BRASS.get();      f = countBrass; }
                if(countGilium     > f){ item = ShopKeeper.ITEM_GILIUM.get();     f = countGilium; }
                if(countAdamantium > f){ item = ShopKeeper.ITEM_ADAMANTIUM.get(); f = countAdamantium; }
                if(countMythril    > f){ item = ShopKeeper.ITEM_MYTHRIL.get();    f = countMythril; }
                if(countOrichalcum > f){ item = ShopKeeper.ITEM_ORICHALCUM.get(); f = countOrichalcum; }
                if(countSteel      > f){ item = ShopKeeper.ITEM_STEEL.get();      f = countSteel; }
                if(countTin        > f){ item = ShopKeeper.ITEM_TIN.get();        f = countTin; }
                if(countZinc       > f){ item = ShopKeeper.ITEM_ZINC.get();       f = countZinc; }
                storage.clear();
                storage.add(new ItemStack(item, amount));
            }
        }

        ItemStack itemstack1 = this.items.get(2);
        if (itemstack1.isEmpty()) {
            return true;
        } else if (!itemstack1.isItemEqual(storage.get(0))) {
            return false;
        } else if (itemstack1.getCount() + storage.get(0).getCount() <= this.getInventoryStackLimit() && itemstack1.getCount() + storage.get(0).getCount() <= itemstack1.getMaxStackSize()) { // Forge fix: make furnace respect stack sizes in furnace recipes
            return true;
        } else {
            return itemstack1.getCount() + storage.get(0).getCount() <= storage.get(0).getMaxStackSize(); // Forge fix: make furnace respect stack sizes in furnace recipes
        }

    }

    private void func_214007_c() { // reduces ItemStacks ?
        //if (this.canSmelt()) {
            //ItemStack itemstack = this.items.get(0);
            //ItemStack itemstack1 = new ItemStack(Blocks.STONE); // set Recipe Result Here         p_214007_1_.getRecipeOutput();
            ItemStack itemstack2 = this.items.get(2);
            if (itemstack2.isEmpty()) {
                this.items.set(2, new ItemStack(storage.get(0).getItem()));

            } else if (itemstack2.getItem() == storage.get(0).getItem()) {
                itemstack2.grow(1);
            }

            if (!this.world.isRemote) {
                this.setRecipeUsed();
            }

            //if (itemstack.getItem() == Blocks.WET_SPONGE.asItem() && !this.items.get(1).isEmpty() && this.items.get(1).getItem() == Items.BUCKET) {
            //    this.items.set(1, new ItemStack(Items.WATER_BUCKET));
            //}
            storage.get(0).shrink(1);
            if(storage.get(0).isEmpty()){
                storage.clear();
            }
            //itemstack.shrink(1);
        //}
    }

    protected int getBurnTime(ItemStack stack) {
        if (stack.isEmpty()) {
            return 0;
        } else {
            Item item = stack.getItem();
            int ret = stack.getBurnTime();
            return net.minecraftforge.event.ForgeEventFactory.getItemBurnTime(stack, ret == -1 ? BurnTimes.getBurnTimes().getOrDefault(item, 0) : ret);
        }
    }

    public static boolean isFuel(ItemStack stack) {
        int ret = stack.getBurnTime();
        return net.minecraftforge.event.ForgeEventFactory.getItemBurnTime(stack, ret == -1 ? BurnTimes.getBurnTimes().getOrDefault(stack.getItem(), 0) : ret) > 0;
    }

    public int[] getSlotsForFace(Direction side) {
        if (side == Direction.DOWN) {
            return SLOTS_DOWN;
        } else {
            return side == Direction.UP ? SLOTS_UP : SLOTS_HORIZONTAL;
        }
    }

    /**
     * Returns true if automation can insert the given item in the given slot from the given side.
     */
    public boolean canInsertItem(int index, ItemStack itemStackIn, @Nullable Direction direction) {
        return this.isItemValidForSlot(index, itemStackIn);
    }

    /**
     * Returns true if automation can extract the given item in the given slot from the given side.
     */
    public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
        if (direction == Direction.DOWN && index == 1) {
            Item item = stack.getItem();
            if (item != Items.WATER_BUCKET && item != Items.BUCKET) {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory() {
        return this.items.size();
    }

    public boolean isEmpty() {
        for(ItemStack itemstack : this.items) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns the stack in the given slot.
     */
    public ItemStack getStackInSlot(int index) {
        return this.items.get(index);
    }

    /**
     * Removes up to a specified number of items from an inventory slot and returns them in a new stack.
     */
    public ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(this.items, index, count);
    }

    /**
     * Removes a stack from the given slot and returns it.
     */
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.items, index);
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int index, ItemStack stack) {
        ItemStack itemstack = this.items.get(index);
        boolean flag = !stack.isEmpty() && stack.isItemEqual(itemstack) && ItemStack.areItemStackTagsEqual(stack, itemstack);
        this.items.set(index, stack);
        if (stack.getCount() > this.getInventoryStackLimit()) {
            stack.setCount(this.getInventoryStackLimit());
        }

        if (index == 0 && !flag) {
            this.cookTimeTotal = this.getTotalCookTime();
            this.cookTime = 0;
            this.markDirty();
        }

    }

    /**
     * Don't rename this method to canInteractWith due to conflicts with Container
     */
    public boolean isUsableByPlayer(PlayerEntity player) {
        if (this.world.getTileEntity(this.pos) != this) {
            return false;
        } else {
            return player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
        }
    }

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot. For
     * guis use Slot.isItemValid
     */
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        if (index == 2) {
            return false;
        } else if (index != 1) {
            return true;
        } else {
            ItemStack itemstack = this.items.get(1);
            return isFuel(stack) || stack.getItem() == Items.BUCKET && itemstack.getItem() != Items.BUCKET;
        }
    }

    public void clear() {
        this.items.clear();
    }

    public void setRecipeUsed() {
        //if (recipe != null) {
        //    this.field_214022_n.compute(recipe.getId(), (p_214004_0_, p_214004_1_) -> {
        //        return 1 + (p_214004_1_ == null ? 0 : p_214004_1_);
        //    });
        //}

    }

    //net.minecraftforge.common.util.LazyOptional<? extends net.minecraftforge.items.IItemHandler>[] handlers =
    //        net.minecraftforge.items.wrapper.SidedInvWrapper.create(this, Direction.UP, Direction.DOWN, Direction.NORTH);

    //@Override
    //public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @Nullable Direction facing) {
    //    if (!this.removed && facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
    //        if (facing == Direction.UP)
    //            return handlers[0].cast();
    //        else if (facing == Direction.DOWN)
    //            return handlers[1].cast();
    //        else
    //            return handlers[2].cast();
    //    }
    //    return super.getCapability(capability, facing);
    //}

    /**
     * invalidates a tile entity
     */
    @Override
    public void remove() {
        super.remove();
       // for (int x = 0; x < handlers.length; x++)
       //     handlers[x].invalidate();
    }

    //private IIntArray getData() {
//
    //    return new IIntArray() {
//
    //        @Override
//
    //        public int get(int index) {
//
    //            return 1;
//
    //        }
//
//
//
    //        @Override
//
    //        public void set(int index, int value) {
//
//
//
    //        }
//
//
//
    //        @Override
//
    //        public int size() {
//
    //            return 1;
//
    //        }
//
    //    };
//
    //}

}
