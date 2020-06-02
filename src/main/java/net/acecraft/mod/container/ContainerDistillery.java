package net.acecraft.mod.container;

import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerDistillery extends Container{
    private final IInventory tileDistillery;
    private int cookTime;
    private int totalCookTime;
    private int furnaceBurnTime;
    private int currentItemBurnTime;
    
    public ContainerDistillery(InventoryPlayer playerInventory, IInventory furnaceInventory){
        this.tileDistillery = furnaceInventory;
        this.addSlotToContainer(new Slot(furnaceInventory, 0, 37, 17)); // Glass Bottle
        this.addSlotToContainer(new Slot(furnaceInventory, 1, 56, 17)); // Raw Material
        this.addSlotToContainer(new SlotFurnaceFuel(furnaceInventory, 2, 56, 53));
        this.addSlotToContainer(new SlotFurnaceOutput(playerInventory.player, furnaceInventory, 3, 116, 35));
        for (int i = 0; i < 3; ++i){
            for (int j = 0; j < 9; ++j){
                this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (int k = 0; k < 9; ++k){
            this.addSlotToContainer(new Slot(playerInventory, k, 8 + k * 18, 142));
        }
    }
    
    public void addListener(IContainerListener listener){
        super.addListener(listener);
        listener.sendAllWindowProperties(this, this.tileDistillery);
    }
    
    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    public void detectAndSendChanges(){
        super.detectAndSendChanges();
        for (int i = 0; i < this.listeners.size(); ++i){
            IContainerListener icontainerlistener = (IContainerListener)this.listeners.get(i);
            if (this.cookTime != this.tileDistillery.getField(2)){
                icontainerlistener.sendProgressBarUpdate(this, 2, this.tileDistillery.getField(2));
            }
            if (this.furnaceBurnTime != this.tileDistillery.getField(0)){
                icontainerlistener.sendProgressBarUpdate(this, 0, this.tileDistillery.getField(0));
            }
            if (this.currentItemBurnTime != this.tileDistillery.getField(1)){
                icontainerlistener.sendProgressBarUpdate(this, 1, this.tileDistillery.getField(1));
            }
            if (this.totalCookTime != this.tileDistillery.getField(3)){
                icontainerlistener.sendProgressBarUpdate(this, 3, this.tileDistillery.getField(3));
            }
        }
        this.cookTime = this.tileDistillery.getField(2);
        this.furnaceBurnTime = this.tileDistillery.getField(0);
        this.currentItemBurnTime = this.tileDistillery.getField(1);
        this.totalCookTime = this.tileDistillery.getField(3);
    }
    
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data){
        this.tileDistillery.setField(id, data);
    }
    
    public boolean canInteractWith(EntityPlayer playerIn){
        return this.tileDistillery.isUseableByPlayer(playerIn);
    }
    
    /**
     * Take a stack from the specified inventory slot.
     */
    @Nullable
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index){
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()){
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (index == 2){
                if (!this.mergeItemStack(itemstack1, 3, 39, true)){
                    return null;
                }
                slot.onSlotChange(itemstack1, itemstack);
            } else if (index != 1 && index != 0){
                if (FurnaceRecipes.instance().getSmeltingResult(itemstack1) != null){
                    if (!this.mergeItemStack(itemstack1, 0, 1, false)){
                        return null;
                    }
                } else if (TileEntityFurnace.isItemFuel(itemstack1)){
                    if (!this.mergeItemStack(itemstack1, 1, 2, false)){
                        return null;
                    }
                } else if (index >= 3 && index < 30){
                    if (!this.mergeItemStack(itemstack1, 30, 39, false)){
                        return null;
                    }
                } else if (index >= 30 && index < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)){
                    return null;
                }
            } else if (!this.mergeItemStack(itemstack1, 3, 39, false)){
                return null;
            }
            if (itemstack1.stackSize == 0){
                slot.putStack((ItemStack)null);
            } else {
                slot.onSlotChanged();
            }
            if (itemstack1.stackSize == itemstack.stackSize){
                return null;
            }
            slot.onPickupFromSlot(playerIn, itemstack1);
        }
        return itemstack;
    }
}