package net.acecraft.mod.container;

import net.acecraft.mod.crafting.SewingStationCraftingManager;
import net.acecraft.mod.tileentity.TileEntitySewingStation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerSewingStation extends Container {
	
	public InventoryCrafting craftMatrix;
	public IInventory craftResult;
	private World worldObj;
	private int posX;
	private int posY;
	private int posZ;
	
	public ContainerSewingStation(InventoryPlayer invPlayer, World world, int x, int y, int z) {
		craftMatrix = new InventoryCrafting(this, 2, 5);
		craftResult = new InventoryCraftResult();
		worldObj = world;
		posX = x;
		posY = y;
		posZ = z;
		this.addSlotToContainer(new SlotCrafting(invPlayer.player, craftMatrix, craftResult, 0, 141, 43));
		for (int i = 0; i < 4; i++) {
			for(int k = 0; k < 2; k++) {
				this.addSlotToContainer(new Slot(craftMatrix, k + i * 2, 34 + k * 18, 15 + i * 18));
			}
		}
		this.addSlotToContainer(new Slot(craftMatrix, 8, 80, 23));
		this.addSlotToContainer(new Slot(craftMatrix, 9, 80, 41));
		for (int i = 0; i < 3; i++) {
			for(int k = 0; k < 9; k++) {
				this.addSlotToContainer(new Slot(invPlayer, k + i * 9 + 9, 8 + k * 18, 106 + i * 18));
			}
		}
		for (int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 164));
		}
		onCraftMatrixChanged(craftMatrix);
	}
	
	public ContainerSewingStation(InventoryPlayer inventory, TileEntitySewingStation entity) {
		craftMatrix = new InventoryCrafting(this, 2, 5);
		craftResult = new InventoryCraftResult();
		this.addSlotToContainer(new SlotCrafting(inventory.player, craftMatrix, craftResult, 0, 141, 43));
		for (int i = 0; i < 4; i++) {
			for(int k = 0; k < 2; k++) {
				this.addSlotToContainer(new Slot(craftMatrix, k + i * 2, 34 + k * 18, 15 + i * 18));
			}
		}
		this.addSlotToContainer(new Slot(craftMatrix, 8, 80, 23));
		this.addSlotToContainer(new Slot(craftMatrix, 9, 80, 41));
		for (int i = 0; i < 3; i++) {
			for(int k = 0; k < 9; k++) {
				this.addSlotToContainer(new Slot(inventory, k + i * 9 + 9, 8 + k * 18, 106 + i * 18));
			}
		}
		for (int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 164));
		}
		onCraftMatrixChanged(craftMatrix);
	}
	
	public void onCraftMatrixChanged(IInventory iiventory) {
		craftResult.setInventorySlotContents(0, SewingStationCraftingManager.getInstance().findMatchingRecipe(craftMatrix, worldObj));
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}
	
	public void onContainerClosed(EntityPlayer player) {
        super.onContainerClosed(player);
        for (int i = 0; i < 10; ++i){
            ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);
            if (itemstack != null){
                player.dropPlayerItemWithRandomChoice(itemstack, false);
            }
        }
    }
	
	public ItemStack transferStackInSlot(EntityPlayer player, int i) {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(i);
        if (slot != null && slot.getHasStack()){
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (i == 0){
                if (!this.mergeItemStack(itemstack1, 10, 46, true)){
                    return null;
                }
                slot.onSlotChange(itemstack1, itemstack);
            }else if (i >= 10 && i < 37){
                if (!this.mergeItemStack(itemstack1, 37, 46, false)){
                    return null;
                }
            }else if (i >= 37 && i < 46){
                if (!this.mergeItemStack(itemstack1, 10, 37, false)){
                    return null;
                }
            }else if (!this.mergeItemStack(itemstack1, 10, 46, false)){
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

}