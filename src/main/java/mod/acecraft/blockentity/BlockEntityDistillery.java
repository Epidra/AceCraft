package mod.acecraft.blockentity;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import mod.acecraft.ShopKeeper;
import mod.acecraft.crafting.RecipeDistillery;
import mod.lucky77.blockentity.BlockEntityBase;
import mod.lucky77.crafting.RecipeBase;
import mod.lucky77.util.Dummy;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class BlockEntityDistillery extends BlockEntityBase<Dummy> {

    private int litTime;
    private int litDuration;
    private int cookingProgress;
    private int cookingTotalTime;
    protected final ContainerData dataAccess = new ContainerData() {
        public int get(int value) {
            switch(value) {
                case  0: return BlockEntityDistillery.this.litTime;
                case  1: return BlockEntityDistillery.this.litDuration;
                case  2: return BlockEntityDistillery.this.cookingProgress;
                case  3: return BlockEntityDistillery.this.cookingTotalTime;
                default: return 0;
            }
        }
        public void set(int index, int value) {
            switch(index) {
                case 0: BlockEntityDistillery.this.litTime          = value; break;
                case 1: BlockEntityDistillery.this.litDuration      = value; break;
                case 2: BlockEntityDistillery.this.cookingProgress  = value; break;
                case 3: BlockEntityDistillery.this.cookingTotalTime = value; break;
            }
        }
        public int getCount() {
            return 4;
        }
    };

    private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();
    protected final RecipeType<? extends RecipeBase> recipeType = ShopKeeper.RECIPE_DISTILLERY;





    //----------------------------------------CONSTRUCTOR----------------------------------------//

    public BlockEntityDistillery(BlockEntityType<?> tileEntityTypeIn, BlockPos blockpos, BlockState blockstate) {
        super(tileEntityTypeIn, blockpos, blockstate, 4);
    }

    public BlockEntityDistillery(BlockPos blockpos, BlockState blockstate) {
        this(ShopKeeper.TILE_DISTILLERY.get(), blockpos, blockstate);
    }





    //----------------------------------------SERVER_TICK----------------------------------------//

    public static void serverTick(Level level, BlockPos pos, BlockState state, BlockEntityDistillery BE) {
        boolean flag = BE.isLit();
        boolean flag1 = false;
        if (BE.isLit()) {
            --BE.litTime;
        }
        if (!BE.level.isClientSide) {
            ItemStack itemstack = BE.inventory.get(2);
            if (BE.isLit() || !itemstack.isEmpty() && !BE.inventory.get(0).isEmpty() && !BE.inventory.get(1).isEmpty()) {
                Recipe<?> irecipe = BE.level.getRecipeManager().getRecipeFor((RecipeType<RecipeDistillery>)BE.recipeType, BE, BE.level).orElse(null);
                if (!BE.isLit() && BE.canBurn(irecipe)) {
                    BE.litTime = BE.getBurnDuration(itemstack);
                    BE.litDuration = BE.litTime;
                    if (BE.isLit()) {
                        flag1 = true;
                        if (itemstack.hasContainerItem())
                            BE.inventory.set(1, itemstack.getContainerItem());
                        else
                        if (!itemstack.isEmpty()) {
                            Item item = itemstack.getItem();
                            itemstack.shrink(1);
                            if (itemstack.isEmpty()) {
                                BE.inventory.set(1, itemstack.getContainerItem());
                            }
                        }
                    }
                }

                if (BE.isLit() && BE.canBurn(irecipe)) {
                    ++BE.cookingProgress;
                    if (BE.cookingProgress == BE.cookingTotalTime) {
                        BE.cookingProgress = 0;
                        BE.cookingTotalTime = BE.getTotalCookTime();
                        BE.burn(irecipe);
                        flag1 = true;
                    }
                } else {
                    BE.cookingProgress = 0;
                }
            } else if (!BE.isLit() && BE.cookingProgress > 0) {
                BE.cookingProgress = Mth.clamp(BE.cookingProgress - 2, 0, BE.cookingTotalTime);
            }

            if (flag != BE.isLit()) {
                flag1 = true;
                BE.level.setBlock(BE.worldPosition, BE.level.getBlockState(BE.worldPosition).setValue(AbstractFurnaceBlock.LIT, BE.isLit()), 3);
            }
        }

        if (flag1) {
            BE.setChanged();
        }

    }





    //----------------------------------------SAVE/LOAD----------------------------------------//

    public void load(CompoundTag p_230337_2_) { //TODO: MARK
        super.load(p_230337_2_);
        this.litTime = p_230337_2_.getInt("BurnTime");
        this.cookingProgress = p_230337_2_.getInt("CookTime");
        this.cookingTotalTime = p_230337_2_.getInt("CookTimeTotal");
        this.litDuration = this.getBurnDuration(this.inventory.get(2));
        CompoundTag compoundnbt = p_230337_2_.getCompound("RecipesUsed");
        for(String s : compoundnbt.getAllKeys()) {
            this.recipesUsed.put(new ResourceLocation(s), compoundnbt.getInt(s));
        }
    }

    public void saveAdditional(CompoundTag p_189515_1_) {
        super.saveAdditional(p_189515_1_);
        p_189515_1_.putInt("BurnTime", this.litTime);
        p_189515_1_.putInt("CookTime", this.cookingProgress);
        p_189515_1_.putInt("CookTimeTotal", this.cookingTotalTime);
        CompoundTag compoundnbt = new CompoundTag();
        this.recipesUsed.forEach((p_235643_1_, p_235643_2_) -> {
            compoundnbt.putInt(p_235643_1_.toString(), p_235643_2_);
        });
        p_189515_1_.put("RecipesUsed", compoundnbt);
    }





    //----------------------------------------NETWORK----------------------------------------//

    //@Override
    //@Nullable
    //public ClientboundBlockEntityDataPacket getUpdatePacket(){
    //    CompoundTag nbtTagCompound = new CompoundTag();
    //    save(nbtTagCompound);
    //    return new ClientboundBlockEntityDataPacket(this.worldPosition, ShopKeeper.TILE_DISTILLERY.get().hashCode(), nbtTagCompound);
    //}

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public CompoundTag getUpdateTag() {
        CompoundTag tag = this.saveWithoutMetadata();
        saveAdditional(tag);
        return tag;
    }





    //----------------------------------------SUPPORT----------------------------------------//

    private boolean isLit() {
        return this.litTime > 0;
    }

    protected boolean canBurn(@Nullable Recipe<?> recipe) {
        if (!this.inventory.get(0).isEmpty() && !this.inventory.get(1).isEmpty() && recipe != null) {
            ItemStack itemstack = recipe.getResultItem();
            if (itemstack.isEmpty()) {
                return false;
            } else {
                ItemStack itemstack1 = this.inventory.get(3);
                if (itemstack1.isEmpty()) {
                    return true;
                } else if (!itemstack1.sameItem(itemstack)) {
                    return false;
                } else if (itemstack1.getCount() + itemstack.getCount() <= this.getMaxStackSize() && itemstack1.getCount() + itemstack.getCount() <= itemstack1.getMaxStackSize()) { // Forge fix: make furnace respect stack sizes in furnace recipes
                    return true;
                } else {
                    return itemstack1.getCount() + itemstack.getCount() <= itemstack.getMaxStackSize(); // Forge fix: make furnace respect stack sizes in furnace recipes
                }
            }
        } else {
            return false;
        }
    }

    private void burn(@Nullable Recipe<?> recipe) {
        if (recipe != null && this.canBurn(recipe)) {
            ItemStack itemstack0 = this.inventory.get(0);
            ItemStack itemstack1 = this.inventory.get(1);
            ItemStack itemstack3 = this.inventory.get(3);
            ItemStack resultstack = recipe.getResultItem();
            if (itemstack3.isEmpty()) {
                this.inventory.set(3, resultstack.copy());
            } else if (itemstack3.getItem() == resultstack.getItem()) {
                itemstack3.grow(resultstack.getCount());
            }

            if (!this.level.isClientSide) {
                this.setRecipeUsed(recipe);
            }

            itemstack0.shrink(1);
            itemstack1.shrink(1);
        }
    }

    protected int getBurnDuration(ItemStack p_213997_1_) {
        if (p_213997_1_.isEmpty()) {
            return 0;
        } else {
            Item item = p_213997_1_.getItem();
            return net.minecraftforge.common.ForgeHooks.getBurnTime(p_213997_1_, recipeType);
        }
    }

    protected int getTotalCookTime() {
        return this.level.getRecipeManager().getRecipeFor((RecipeType<RecipeDistillery>)this.recipeType, this, this.level).map(RecipeDistillery::getCookingTime).orElse(200);
    }

    public void setItem(int p_70299_1_, ItemStack p_70299_2_) {
        ItemStack itemstack = this.inventory.get(p_70299_1_);
        boolean flag = !p_70299_2_.isEmpty() && p_70299_2_.sameItem(itemstack) && ItemStack.tagMatches(p_70299_2_, itemstack);
        this.inventory.set(p_70299_1_, p_70299_2_);
        if (p_70299_2_.getCount() > this.getMaxStackSize()) {
            p_70299_2_.setCount(this.getMaxStackSize());
        }
        if (p_70299_1_ == 0 && !flag) {
            this.cookingTotalTime = this.getTotalCookTime();
            this.cookingProgress = 0;
            this.setChanged();
        }
    }





    //----------------------------------------BASIC----------------------------------------//

    @Override
    public ContainerData getIntArray() {
        return dataAccess;
    }

    @Override
    public TextComponent getName() {
        return new TextComponent("tile.distillery.name");
    }

    public void setRecipeUsed(@Nullable Recipe<?> p_193056_1_) {
        if (p_193056_1_ != null) {
            ResourceLocation resourcelocation = p_193056_1_.getId();
            this.recipesUsed.addTo(resourcelocation, 1);
        }
    }

    @Nullable
    public Recipe<?> getRecipeUsed() {
        return null;
    }



}
