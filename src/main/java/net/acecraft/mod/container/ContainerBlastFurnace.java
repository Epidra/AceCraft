package net.acecraft.mod.container;

import net.acecraft.mod.slot.SlotBlastFurnace;
import net.acecraft.mod.tileentity.TileEntityBlastFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;

public class ContainerBlastFurnace extends Container {
	
private TileEntityBlastFurnace blastFurnace;
	
	private int dualCookTime;
	private int dualPower;
	private int lastBurnTime;
	private int lastItemBurnTime;
	private int lastCurrentItemBurnTime;
	private int lastCookTime;
	
	public ContainerBlastFurnace(InventoryPlayer inventory, TileEntityBlastFurnace tileentity){
		dualCookTime = 0;
		dualPower = 0;
		lastItemBurnTime = 0;
		this.blastFurnace = tileentity;
		this.addSlotToContainer(new Slot(tileentity,  0,   8,  7)); // Source 0
		this.addSlotToContainer(new Slot(tileentity,  1,  28,  7)); // Source 1
		this.addSlotToContainer(new Slot(tileentity,  2,  48,  7)); // Source 2
		this.addSlotToContainer(new Slot(tileentity,  3,  68,  7)); // Source 3
		this.addSlotToContainer(new Slot(tileentity,  4,  88,  7)); // Source 4
		this.addSlotToContainer(new Slot(tileentity,  5,   8, 27)); // Source 5
		this.addSlotToContainer(new Slot(tileentity,  6,  28, 27)); // Source 6
		this.addSlotToContainer(new Slot(tileentity,  7,  48, 27)); // Source 7
		this.addSlotToContainer(new Slot(tileentity,  8,  68, 27)); // Source 8
		this.addSlotToContainer(new Slot(tileentity,  9,  88, 27)); // Source 9
		this.addSlotToContainer(new Slot(tileentity, 11, 152, 63)); // Fuel
		this.addSlotToContainer(new SlotBlastFurnace(inventory.player, tileentity, 10, 76, 55)); // Output		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 9; j++){
				this.addSlotToContainer(new Slot(inventory, j + i*9 + 9, 8 + j*18, 84 + i*18)); // Inventory
			}
		}
		for(int i = 0; i < 9; i++){
			this.addSlotToContainer(new Slot(inventory, i, 8 + i*18, 142)); // Hold Inventory
		}
	}
	
	public void addCraftingToCrafters (ICrafting icrafting){
		super.addCraftingToCrafters(icrafting);
		icrafting.sendProgressBarUpdate(this, 0, this.blastFurnace.currentCookTime);
		icrafting.sendProgressBarUpdate(this, 1, this.blastFurnace.currentPower);
	}
	
	public boolean canInteractWith(EntityPlayer var1) {
		return true;
	}
	
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2){
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);
        if (slot != null && slot.getHasStack()){
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (par2 == 2){
                if (!this.mergeItemStack(itemstack1, 3, 39, true)){
                    return null;
                }
                slot.onSlotChange(itemstack1, itemstack);
            } else if (par2 != 1 && par2 != 0){
                if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null){
                    if (!this.mergeItemStack(itemstack1, 0, 1, false)){
                        return null;
                    }
                } else if (TileEntityFurnace.isItemFuel(itemstack1)){
                    if (!this.mergeItemStack(itemstack1, 1, 2, false)){
                        return null;
                    }
                } else if (par2 >= 3 && par2 < 30){
                    if (!this.mergeItemStack(itemstack1, 30, 39, false)){
                        return null;
                    }
                } else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)){
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
            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }
        return itemstack;
    }
	
	public void detectAndSendChanges(){
		super.detectAndSendChanges();
		for(int i = 0; i < this.crafters.size(); i++){
			ICrafting par1 = (ICrafting)this.crafters.get(i);
			if(this.dualCookTime != this.blastFurnace.currentCookTime){
				par1.sendProgressBarUpdate(this, 0, this.blastFurnace.currentCookTime);
			}
			if(this.dualPower != this.blastFurnace.currentPower){
				par1.sendProgressBarUpdate(this, 1, this.blastFurnace.currentPower);
			}
		}
		this.dualCookTime = this.blastFurnace.currentCookTime;
		this.dualPower    = this.blastFurnace.currentPower;
	}
	
	public void updateProgressBar(int i, int j){
		if(i == 0){
			blastFurnace.currentCookTime = j;
		}
		if(i == 1){
			blastFurnace.currentPower = j;
		}
	}

}