package net.acecraft.mod.container;

import net.acecraft.mod.crafting.AnvilCraftingManager;
import net.acecraft.mod.tileentity.TileEntityAnvil;
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

public class ContainerAnvilCrafting extends Container {
	
	public InventoryCrafting craftMatrix;
	public IInventory craftResult;
	private World worldObj;
	private int posX;
	private int posY;
	private int posZ;
	
	public ContainerAnvilCrafting(InventoryPlayer invPlayer, World world, int x, int y, int z) {
		craftMatrix = new InventoryCrafting(this, 4, 4);
		craftResult = new InventoryCraftResult();
		worldObj = world;
		posX = x;
		posY = y;
		posZ = z;
		this.addSlotToContainer(new SlotCrafting(invPlayer.player, craftMatrix, craftResult, 0, 141, 43));
		for (int i = 0; i < 4; i++) {
			for(int k = 0; k < 4; k++) {
				this.addSlotToContainer(new Slot(craftMatrix, k + i * 4, 16 + k * 18, 15 + i * 18));
			}
		}
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
	
	public ContainerAnvilCrafting(InventoryPlayer inventory, TileEntityAnvil entity) {
		craftMatrix = new InventoryCrafting(this, 4, 4);
		craftResult = new InventoryCraftResult();
		this.addSlotToContainer(new SlotCrafting(inventory.player, craftMatrix, craftResult, 0, 141, 43));
		for (int i = 0; i < 4; i++) {
			for(int k = 0; k < 4; k++) {
				this.addSlotToContainer(new Slot(craftMatrix, k + i * 4, 16 + k * 18, 15 + i * 18));
			}
		}
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
		craftResult.setInventorySlotContents(0, AnvilCraftingManager.getInstance().findMatchingRecipe(craftMatrix, worldObj));
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return true;
	}
	
	public void onContainerClosed(EntityPlayer par1EntityPlayer) {
        super.onContainerClosed(par1EntityPlayer);
        for(int i = 0; i < 16; ++i){
            ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);
            if(itemstack != null){
                par1EntityPlayer.dropPlayerItemWithRandomChoice(itemstack, false);
            }
        }
    }
	
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);
        if (slot != null && slot.getHasStack()){
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (par2 == 0){
                if (!this.mergeItemStack(itemstack1, 10, 46, true)){
                    return null;
                }
                slot.onSlotChange(itemstack1, itemstack);
            }else if (par2 >= 10 && par2 < 37){
                if (!this.mergeItemStack(itemstack1, 37, 46, false)){
                    return null;
                }
            }else if (par2 >= 37 && par2 < 46){
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
            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }
        return itemstack;
    }

}