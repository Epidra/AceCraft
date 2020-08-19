package mod.acecraft.container;

import mod.acecraft.crafting.RecipeDestilleAbstract;
import mod.acecraft.slots.SlotFurnaceFuelDestille;
import mod.acecraft.slots.SlotFurnaceResultDestille;
import mod.acecraft.tileentities.TileEntityDestille;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.IRecipeHelperPopulator;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IntArray;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ContainerDestilleAbstract extends RecipeBookContainer<IInventory> {

    private final IInventory furnaceInventory;
    private final IIntArray field_217064_e;
    protected final World world;
    private final IRecipeType<? extends RecipeDestilleAbstract> recipeType;

    protected ContainerDestilleAbstract(ContainerType<?> containerTypeIn, IRecipeType<? extends RecipeDestilleAbstract> recipeTypeIn, int id, PlayerInventory playerInventoryIn) {
        this(containerTypeIn, recipeTypeIn, id, playerInventoryIn, new Inventory(3), new IntArray(4));
    }

    protected ContainerDestilleAbstract(ContainerType<?> containerTypeIn, IRecipeType<? extends RecipeDestilleAbstract> recipeTypeIn, int id, PlayerInventory playerInventoryIn, IInventory furnaceInventoryIn, IIntArray p_i50104_6_) {
        super(containerTypeIn, id);
        this.recipeType = recipeTypeIn;
        assertInventorySize(furnaceInventoryIn, 3);
        assertIntArraySize(p_i50104_6_, 4);
        this.furnaceInventory = furnaceInventoryIn;
        this.field_217064_e = p_i50104_6_;
        this.world = playerInventoryIn.player.world;
        this.addSlot(new Slot(furnaceInventoryIn, 0, 56, 17));
        this.addSlot(new SlotFurnaceFuelDestille(this, furnaceInventoryIn, 1, 56, 53));
        this.addSlot(new SlotFurnaceResultDestille(playerInventoryIn.player, furnaceInventoryIn, 2, 116, 35));

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventoryIn, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(playerInventoryIn, k, 8 + k * 18, 142));
        }

        this.trackIntArray(p_i50104_6_);
    }

    public void func_201771_a(RecipeItemHelper p_201771_1_) {
        if (this.furnaceInventory instanceof IRecipeHelperPopulator) {
            ((IRecipeHelperPopulator)this.furnaceInventory).fillStackedContents(p_201771_1_);
        }

    }

    public void clear() {
        this.furnaceInventory.clear();
    }

    public void func_217056_a(boolean p_217056_1_, IRecipe<?> p_217056_2_, ServerPlayerEntity p_217056_3_) {
        (new ServerRecipePlacerFurnace<>(this)).place(p_217056_3_, (IRecipe<IInventory>)p_217056_2_, p_217056_1_);
    }

    @Override
    public void fillStackedContents(RecipeItemHelper itemHelperIn) {

    }

    public boolean matches(IRecipe<? super IInventory> recipeIn) {
        return recipeIn.matches(this.furnaceInventory, this.world);
    }

    public int getOutputSlot() {
        return 2;
    }

    public int getWidth() {
        return 1;
    }

    public int getHeight() {
        return 1;
    }

    @OnlyIn(Dist.CLIENT)
    public int getSize() {
        return 3;
    }

    @Override
    public RecipeBookCategory func_241850_m() {
        return null;
    }

    public boolean canInteractWith(PlayerEntity playerIn) {
        return this.furnaceInventory.isUsableByPlayer(playerIn);
    }

    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (index == 2) {
                if (!this.mergeItemStack(itemstack1, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            } else if (index != 1 && index != 0) {
                if (this.func_217057_a(itemstack1)) {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (this.isFuel(itemstack1)) {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index >= 3 && index < 30) {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index >= 30 && index < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 3, 39, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, itemstack1);
        }

        return itemstack;
    }

    protected boolean func_217057_a(ItemStack p_217057_1_) {
        return this.world.getRecipeManager().getRecipe((IRecipeType)this.recipeType, new Inventory(p_217057_1_), this.world).isPresent();
    }

    public boolean isFuel(ItemStack p_217058_1_) {
        return false;
        //return TileEntityDestille.isFuel(p_217058_1_);
    }

    @OnlyIn(Dist.CLIENT)
    public int getCookProgressionScaled() {
        int i = this.field_217064_e.get(2);
        int j = this.field_217064_e.get(3);
        return j != 0 && i != 0 ? i * 24 / j : 0;
    }

    @OnlyIn(Dist.CLIENT)
    public int getBurnLeftScaled() {
        int i = this.field_217064_e.get(1);
        if (i == 0) {
            i = 200;
        }

        return this.field_217064_e.get(0) * 13 / i;
    }

    @OnlyIn(Dist.CLIENT)
    public boolean func_217061_l() {
        return this.field_217064_e.get(0) > 0;
    }

}
