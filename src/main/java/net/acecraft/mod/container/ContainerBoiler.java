package net.acecraft.mod.container;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.acecraft.mod.slot.SlotBoiler;
import net.acecraft.mod.tileentity.TileEntityBoiler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;

public class ContainerBoiler extends Container {
	
	private TileEntityBoiler tileBoiler;
    private int lastCookTime;
    private int lastBurnTime;
    private int lastItemBurnTime;
    private static final String __OBFID = "CL_00001748";
    
    private int lastEnergy;
    private int lastEnergyCollected;
    
    public ContainerBoiler(InventoryPlayer inventory, TileEntityBoiler entity){
        this.tileBoiler = entity;
        this.addSlotToContainer(new Slot(entity, 0, 33, 41));
        int i;
        for (i = 0; i < 3; ++i){
            for (int j = 0; j < 9; ++j){
                this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (i = 0; i < 9; ++i){
            this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
        }
    }

    public void addCraftingToCrafters(ICrafting icrafting){
        super.addCraftingToCrafters(icrafting);
        icrafting.sendProgressBarUpdate(this, 0, this.tileBoiler.cookTime);
        icrafting.sendProgressBarUpdate(this, 1, this.tileBoiler.burnTime);
        icrafting.sendProgressBarUpdate(this, 2, this.tileBoiler.currentItemBurnTime);
        icrafting.sendProgressBarUpdate(this, 3, this.tileBoiler.energy);
        icrafting.sendProgressBarUpdate(this, 4, this.tileBoiler.energyCollected);
    }
    
    public void detectAndSendChanges(){
        super.detectAndSendChanges();
        for (int i = 0; i < this.crafters.size(); ++i){
            ICrafting icrafting = (ICrafting)this.crafters.get(i);
            if (this.lastCookTime != this.tileBoiler.cookTime){
                icrafting.sendProgressBarUpdate(this, 0, this.tileBoiler.cookTime);
            }
            if (this.lastBurnTime != this.tileBoiler.burnTime){
                icrafting.sendProgressBarUpdate(this, 1, this.tileBoiler.burnTime);
            }
            if (this.lastItemBurnTime != this.tileBoiler.currentItemBurnTime){
                icrafting.sendProgressBarUpdate(this, 2, this.tileBoiler.currentItemBurnTime);
            }
            if (this.lastEnergy != this.tileBoiler.energy){
                icrafting.sendProgressBarUpdate(this, 0, this.tileBoiler.energy);
            }
            if (this.lastEnergyCollected != this.tileBoiler.energyCollected){
                icrafting.sendProgressBarUpdate(this, 0, this.tileBoiler.energyCollected);
            }
        }
        this.lastCookTime        = this.tileBoiler.cookTime;
        this.lastBurnTime        = this.tileBoiler.burnTime;
        this.lastItemBurnTime    = this.tileBoiler.currentItemBurnTime;
        this.lastEnergy          = this.tileBoiler.energy;
        this.lastEnergyCollected = this.tileBoiler.energyCollected;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int value){
        if (id == 0){ this.tileBoiler.cookTime            = value; }
        if (id == 1){ this.tileBoiler.burnTime            = value; }
        if (id == 2){ this.tileBoiler.currentItemBurnTime = value; }
        if (id == 3){ this.tileBoiler.energy              = value; }
        if (id == 4){ this.tileBoiler.energyCollected     = value; }
    }
    
    public boolean canInteractWith(EntityPlayer player){
        return this.tileBoiler.isUseableByPlayer(player);
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
            }else if (i != 1 && i != 0){
                if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null){
                    if (!this.mergeItemStack(itemstack1, 0, 1, false)){
                        return null;
                    }
                }else if (TileEntityFurnace.isItemFuel(itemstack1)){
                    if (!this.mergeItemStack(itemstack1, 1, 2, false)){
                        return null;
                    }
                }else if (i >= 3 && i < 30){
                    if (!this.mergeItemStack(itemstack1, 30, 39, false)){
                        return null;
                    }
                }else if (i >= 30 && i < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)){
                    return null;
                }
            }else if (!this.mergeItemStack(itemstack1, 3, 39, false)){
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