package net.acecraft.mod.container;

import javax.annotation.Nullable;

import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.crafting.SewingBenchRecipes;
import net.acecraft.mod.slot.SlotCraftSewingBench;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ContainerSewingBench extends Container{
    /** The crafting matrix inventory (3x4). */
    public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 4);
    public IInventory craftResult = new InventoryCraftResult();
    private final World worldObj;
    /** Position of the workbench */
    private final BlockPos pos;
    
    public ContainerSewingBench(InventoryPlayer playerInventory, World worldIn, BlockPos posIn){
        this.worldObj = worldIn;
        this.pos = posIn;
        this.addSlotToContainer(new SlotCraftSewingBench(playerInventory.player, this.craftMatrix, this.craftResult, 0, 124, 35));
        for (int i = 0; i < 4; ++i){
            for (int j = 0; j < 3; ++j){
                this.addSlotToContainer(new Slot(this.craftMatrix, j + i * 3, 34 + j * 18, 15 + i * 18));
            }
        }
        for (int k = 0; k < 3; ++k){
            for (int i1 = 0; i1 < 9; ++i1){
                this.addSlotToContainer(new Slot(playerInventory, i1 + k * 9 + 9, 8 + i1 * 18, 106 + k * 18));
            }
        }
        for (int l = 0; l < 9; ++l){
            this.addSlotToContainer(new Slot(playerInventory, l, 8 + l * 18, 164));
        }
        this.onCraftMatrixChanged(this.craftMatrix);
    }
    
    /**
     * Callback for when the crafting matrix is changed.
     */
    public void onCraftMatrixChanged(IInventory inventoryIn){
        this.craftResult.setInventorySlotContents(0, SewingBenchRecipes.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
    }
    
    /**
     * Called when the container is closed.
     */
    public void onContainerClosed(EntityPlayer playerIn){
        super.onContainerClosed(playerIn);
        if (!this.worldObj.isRemote){
            for (int i = 0; i < 12; ++i){
                ItemStack itemstack = this.craftMatrix.removeStackFromSlot(i);
                if (itemstack != null){
                    playerIn.dropItem(itemstack, false);
                }
            }
        }
    }
    
    public boolean canInteractWith(EntityPlayer playerIn){
        return this.worldObj.getBlockState(this.pos).getBlock() != ShopKeeper.machinaSewingBench ? false : playerIn.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    }
    
    /**
     * Take a stack from the specified inventory slot.
     */
    @Nullable
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index){
        ItemStack itemstack = null;
        return itemstack;
    }
    
    /**
     * Called to determine if the current slot is valid for the stack merging (double-click) code. The stack passed in
     * is null for the initial slot that was double-clicked.
     */
    public boolean canMergeSlot(ItemStack stack, Slot slotIn){
        return slotIn.inventory != this.craftResult && super.canMergeSlot(stack, slotIn);
    }
}