package net.acecraft.mod.container;

import net.acecraft.mod.slot.SlotBonfire;
import net.acecraft.mod.tileentity.TileEntityMillstone;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerMillstone extends Container {
	
	private TileEntityMillstone tileMillstone;
    private int lastCookTime;
    private int lastBurnTime;
    private int lastItemBurnTime;
    private int lastEnergy;
    private static final String __OBFID = "CL_00001748";

    public ContainerMillstone(InventoryPlayer inventory, TileEntityMillstone entity){
        this.tileMillstone = entity;
        this.addSlotToContainer(new Slot(entity, 0, 56, 35));
        this.addSlotToContainer(new SlotBonfire(inventory.player, entity, 1, 116, 35));
        for (int i = 0; i < 3; ++i){
            for (int j = 0; j < 9; ++j){
                this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (int i = 0; i < 9; ++i){
            this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
        }
    }
    
    public void addCraftingToCrafters(ICrafting icrafting){
        super.addCraftingToCrafters(icrafting);
        icrafting.sendProgressBarUpdate(this, 0, this.tileMillstone.cookTime);
        icrafting.sendProgressBarUpdate(this, 1, this.tileMillstone.burnTime);
        icrafting.sendProgressBarUpdate(this, 2, this.tileMillstone.currentItemBurnTime);
        icrafting.sendProgressBarUpdate(this, 3, this.tileMillstone.energy);
    }
    
    public void detectAndSendChanges(){
        super.detectAndSendChanges();
        for (int i = 0; i < this.crafters.size(); ++i){
            ICrafting icrafting = (ICrafting)this.crafters.get(i);
            if (this.lastCookTime != this.tileMillstone.cookTime){
                icrafting.sendProgressBarUpdate(this, 0, this.tileMillstone.cookTime);
            }
            if (this.lastBurnTime != this.tileMillstone.burnTime){
                icrafting.sendProgressBarUpdate(this, 1, this.tileMillstone.burnTime);
            }
            if (this.lastItemBurnTime != this.tileMillstone.currentItemBurnTime){
                icrafting.sendProgressBarUpdate(this, 2, this.tileMillstone.currentItemBurnTime);
            }
            if (this.lastEnergy != this.tileMillstone.energy){
                icrafting.sendProgressBarUpdate(this, 3, this.tileMillstone.energy);
            }
        }
        this.lastCookTime     = this.tileMillstone.cookTime;
        this.lastBurnTime     = this.tileMillstone.burnTime;
        this.lastItemBurnTime = this.tileMillstone.currentItemBurnTime;
        this.lastEnergy       = this.tileMillstone.energy;
    }
    
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int value){
        if (id == 0){ this.tileMillstone.cookTime            = value; }
        if (id == 1){ this.tileMillstone.burnTime            = value; }
        if (id == 2){ this.tileMillstone.currentItemBurnTime = value; }
        if (id == 3){ this.tileMillstone.energy              = value; }
    }
    
    public boolean canInteractWith(EntityPlayer player){
        return this.tileMillstone.isUseableByPlayer(player);
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