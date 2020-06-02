package net.acecraft.mod.container;

import net.acecraft.mod.slot.SlotBlastFurnace;
import net.acecraft.mod.tileentity.TileEntityDistillery;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;

public class ContainerDistillery extends Container {
	
private TileEntityDistillery distillery;
	
	private int dualCookTime;
	private int dualPower;
	private int lastBurnTime;
	private int lastItemBurnTime;
	private int lastCurrentItemBurnTime;
	private int lastCookTime;
	
	public ContainerDistillery(InventoryPlayer inventory, TileEntityDistillery tileentity){
		dualCookTime = 0;
		dualPower = 0;
		lastItemBurnTime = 0;
		this.distillery = tileentity;
		this.addSlotToContainer(new Slot(tileentity,  0, 56, 17)); // Source 0
		this.addSlotToContainer(new Slot(tileentity,  3, 37, 17)); // Source 1
		this.addSlotToContainer(new Slot(tileentity, 1, 56, 53)); // Fuel
		this.addSlotToContainer(new SlotBlastFurnace(inventory.player, tileentity, 2, 116, 35)); // Output
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 9; j++){
				this.addSlotToContainer(new Slot(inventory, j + i*9 + 9, 8 + j*18, 84 + i*18)); // Inventory
			}
		}
		for(int i = 0; i < 9; i++){
			this.addSlotToContainer(new Slot(inventory, i, 8 + i*18, 142)); // Hold Inventory
		}
	}
	
	public void addCraftingToCrafters(ICrafting icrafting)
    {
        super.addCraftingToCrafters(icrafting);
        icrafting.sendProgressBarUpdate(this, 0, this.distillery.furnaceCookTime);
        icrafting.sendProgressBarUpdate(this, 1, this.distillery.furnaceBurnTime);
        icrafting.sendProgressBarUpdate(this, 2, this.distillery.currentItemBurnTime);
    }
	
	public boolean canInteractWith(EntityPlayer var1) {
		return true;
	}
	
	public ItemStack transferStackInSlot(EntityPlayer player, int i){
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(i);
        if (slot != null && slot.getHasStack()){
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (i == 2){
                if (!this.mergeItemStack(itemstack1, 3, 39, true)){
                    return null;
                }
                slot.onSlotChange(itemstack1, itemstack);
            } else if (i != 1 && i != 0){
                if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null){
                    if (!this.mergeItemStack(itemstack1, 0, 1, false)){
                        return null;
                    }
                } else if (TileEntityFurnace.isItemFuel(itemstack1)){
                    if (!this.mergeItemStack(itemstack1, 1, 2, false)){
                        return null;
                    }
                } else if (i >= 3 && i < 30){
                    if (!this.mergeItemStack(itemstack1, 30, 39, false)){
                        return null;
                    }
                } else if (i >= 30 && i < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)){
                    return null;
                }
            } else if (!this.mergeItemStack(itemstack1, 3, 39, false)){
                return null;
            }
            if (itemstack1.stackSize == 0){
                slot.putStack((ItemStack)null);
            }else{
                slot.onSlotChanged();
            }
            if (itemstack1.stackSize == itemstack.stackSize){
                return null;
            }
            slot.onPickupFromSlot(player, itemstack1);
        }
        return itemstack;
    }
	
	public void detectAndSendChanges(){
        super.detectAndSendChanges();
        for (int i = 0; i < this.crafters.size(); ++i){
            ICrafting icrafting = (ICrafting)this.crafters.get(i);
            if (this.lastCookTime != this.distillery.furnaceCookTime){
                icrafting.sendProgressBarUpdate(this, 0, this.distillery.furnaceCookTime);
            }
            if (this.lastBurnTime != this.distillery.furnaceBurnTime){
                icrafting.sendProgressBarUpdate(this, 1, this.distillery.furnaceBurnTime);
            }
            if (this.lastItemBurnTime != this.distillery.currentItemBurnTime){
                icrafting.sendProgressBarUpdate(this, 2, this.distillery.currentItemBurnTime);
            }
        }
        this.lastCookTime     = this.distillery.furnaceCookTime;
        this.lastBurnTime     = this.distillery.furnaceBurnTime;
        this.lastItemBurnTime = this.distillery.currentItemBurnTime;
    }
	
	public void updateProgressBar(int id, int value){
        if (id == 0){ this.distillery.furnaceCookTime     = value; }
        if (id == 1){ this.distillery.furnaceBurnTime     = value; }
        if (id == 2){ this.distillery.currentItemBurnTime = value; }
    }

}