package mod.acecraft.tileentities;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import mod.acecraft.ShopKeeper;
import mod.acecraft.crafting.RecipeDistillery;
import mod.lucky77.crafting.RecipeBase;
import mod.lucky77.tileentities.TileBase;
import mod.lucky77.util.LogicBase;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.*;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

import javax.annotation.Nullable;

public class TileDistillery extends TileBase<LogicBase> {

    private int litTime;
    private int litDuration;
    private int cookingProgress;
    private int cookingTotalTime;
    protected final IIntArray dataAccess = new IIntArray() {
        public int get(int value) {
            switch(value) {
                case  0: return TileDistillery.this.litTime;
                case  1: return TileDistillery.this.litDuration;
                case  2: return TileDistillery.this.cookingProgress;
                case  3: return TileDistillery.this.cookingTotalTime;
                default: return 0;
            }
        }
        public void set(int index, int value) {
            switch(index) {
                case 0: TileDistillery.this.litTime          = value; break;
                case 1: TileDistillery.this.litDuration      = value; break;
                case 2: TileDistillery.this.cookingProgress  = value; break;
                case 3: TileDistillery.this.cookingTotalTime = value; break;
            }
        }
        public int getCount() {
            return 4;
        }
    };

    private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();
    protected final IRecipeType<? extends RecipeBase> recipeType = ShopKeeper.RECIPE_DISTILLERY;





    //----------------------------------------CONSTRUCTOR----------------------------------------//

    public TileDistillery(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn, 4);
    }

    public TileDistillery() {
        this(ShopKeeper.TILE_DISTILLERY.get());
    }





    //----------------------------------------UPDATE----------------------------------------//

    public void tick() {
        boolean flag = this.isLit();
        boolean flag1 = false;
        if (this.isLit()) {
            --this.litTime;
        }
        if (!this.level.isClientSide) {
            ItemStack itemstack = this.inventory.get(2);
            if (this.isLit() || !itemstack.isEmpty() && !this.inventory.get(0).isEmpty() && !this.inventory.get(1).isEmpty()) {
                IRecipe<?> irecipe = this.level.getRecipeManager().getRecipeFor((IRecipeType<RecipeDistillery>)this.recipeType, this, this.level).orElse(null);
                if (!this.isLit() && this.canBurn(irecipe)) {
                    this.litTime = this.getBurnDuration(itemstack);
                    this.litDuration = this.litTime;
                    if (this.isLit()) {
                        flag1 = true;
                        if (itemstack.hasContainerItem())
                            this.inventory.set(1, itemstack.getContainerItem());
                        else
                        if (!itemstack.isEmpty()) {
                            Item item = itemstack.getItem();
                            itemstack.shrink(1);
                            if (itemstack.isEmpty()) {
                                this.inventory.set(1, itemstack.getContainerItem());
                            }
                        }
                    }
                }

                if (this.isLit() && this.canBurn(irecipe)) {
                    ++this.cookingProgress;
                    if (this.cookingProgress == this.cookingTotalTime) {
                        this.cookingProgress = 0;
                        this.cookingTotalTime = this.getTotalCookTime();
                        this.burn(irecipe);
                        flag1 = true;
                    }
                } else {
                    this.cookingProgress = 0;
                }
            } else if (!this.isLit() && this.cookingProgress > 0) {
                this.cookingProgress = MathHelper.clamp(this.cookingProgress - 2, 0, this.cookingTotalTime);
            }

            if (flag != this.isLit()) {
                flag1 = true;
                this.level.setBlock(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(AbstractFurnaceBlock.LIT, this.isLit()), 3);
            }
        }

        if (flag1) {
            this.setChanged();
        }

    }





    //----------------------------------------SAVE/LOAD----------------------------------------//

    public void load(BlockState p_230337_1_, CompoundNBT p_230337_2_) { //TODO: MARK
        super.load(p_230337_1_, p_230337_2_);
        this.litTime = p_230337_2_.getInt("BurnTime");
        this.cookingProgress = p_230337_2_.getInt("CookTime");
        this.cookingTotalTime = p_230337_2_.getInt("CookTimeTotal");
        this.litDuration = this.getBurnDuration(this.inventory.get(2));
        CompoundNBT compoundnbt = p_230337_2_.getCompound("RecipesUsed");
        for(String s : compoundnbt.getAllKeys()) {
            this.recipesUsed.put(new ResourceLocation(s), compoundnbt.getInt(s));
        }
    }

    public CompoundNBT save(CompoundNBT p_189515_1_) {
        super.save(p_189515_1_);
        p_189515_1_.putInt("BurnTime", this.litTime);
        p_189515_1_.putInt("CookTime", this.cookingProgress);
        p_189515_1_.putInt("CookTimeTotal", this.cookingTotalTime);
        CompoundNBT compoundnbt = new CompoundNBT();
        this.recipesUsed.forEach((p_235643_1_, p_235643_2_) -> {
            compoundnbt.putInt(p_235643_1_.toString(), p_235643_2_);
        });
        p_189515_1_.put("RecipesUsed", compoundnbt);
        return p_189515_1_;
    }





    //----------------------------------------NETWORK----------------------------------------//

    @Override
    @Nullable
    public SUpdateTileEntityPacket getUpdatePacket(){
        CompoundNBT nbtTagCompound = new CompoundNBT();
        save(nbtTagCompound);
        return new SUpdateTileEntityPacket(this.worldPosition, ShopKeeper.TILE_DISTILLERY.get().hashCode(), nbtTagCompound);
    }





    //----------------------------------------SUPPORT----------------------------------------//

    private boolean isLit() {
        return this.litTime > 0;
    }

    protected boolean canBurn(@Nullable IRecipe<?> recipe) {
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

    private void burn(@Nullable IRecipe<?> recipe) {
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
            return net.minecraftforge.common.ForgeHooks.getBurnTime(p_213997_1_);
        }
    }

    protected int getTotalCookTime() {
        return this.level.getRecipeManager().getRecipeFor((IRecipeType<RecipeDistillery>)this.recipeType, this, this.level).map(RecipeDistillery::getCookingTime).orElse(200);
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
    public IIntArray getIntArray() {
        return dataAccess;
    }

    @Override
    public ITextComponent getName() {
        return new TranslationTextComponent("tile.distillery.name");
    }

    public void setRecipeUsed(@Nullable IRecipe<?> p_193056_1_) {
        if (p_193056_1_ != null) {
            ResourceLocation resourcelocation = p_193056_1_.getId();
            this.recipesUsed.addTo(resourcelocation, 1);
        }
    }

    @Nullable
    public IRecipe<?> getRecipeUsed() {
        return null;
    }



}
