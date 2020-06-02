package net.acecraft.mod.container;

import net.acecraft.mod.crafting.FruitPressRecipes;
import net.acecraft.mod.tileentity.TileEntityFruitPress;
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

import javax.annotation.Nullable;

public class ContainerFruitPress extends Container {
	
	private final TileEntityFruitPress tileFruitPress;
	private int lastCookTime;
    private int lastBurnTime;
    private int lastItemBurnTime;
    private String lastContent;
    private int lastFillingLevel;
    private int lastEnergy;
    
    public ContainerFruitPress(InventoryPlayer playerInventory, IInventory furnaceInventory){
        this.tileFruitPress = (TileEntityFruitPress) furnaceInventory;
        this.addSlotToContainer(new Slot(furnaceInventory, 0,  41, 34)); // Raw Input
        this.addSlotToContainer(new Slot(furnaceInventory, 1, 100, 16)); // Glass Bottle
        this.addSlotToContainer(new SlotFurnaceOutput(playerInventory.player, furnaceInventory, 2, 100, 52));
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
        listener.sendAllWindowProperties(this, this.tileFruitPress);
    }
    
    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    public void detectAndSendChanges(){
	    super.detectAndSendChanges();
	    for (int i = 0; i < this.listeners.size(); ++i){
	    	IContainerListener icrafting = (IContainerListener)this.listeners.get(i);
	        if (this.lastCookTime != this.tileFruitPress.cookTime){
	            icrafting.sendProgressBarUpdate(this, 0, this.tileFruitPress.cookTime);
	        }
	        if (this.lastBurnTime != this.tileFruitPress.burnTime){
	            icrafting.sendProgressBarUpdate(this, 1, this.tileFruitPress.burnTime);
	        }
	        if (this.lastItemBurnTime != this.tileFruitPress.currentItemBurnTime){
	            icrafting.sendProgressBarUpdate(this, 2, this.tileFruitPress.currentItemBurnTime);
	        }
	        if (this.lastContent != this.tileFruitPress.content){
	            icrafting.sendProgressBarUpdate(this, 3, transmuteContent(this.tileFruitPress.content));
	        }
	        if (this.lastFillingLevel != this.tileFruitPress.fillingLevel){
	            icrafting.sendProgressBarUpdate(this, 4, this.tileFruitPress.fillingLevel);
	        }
	        if (this.lastEnergy != this.tileFruitPress.energy){
	            icrafting.sendProgressBarUpdate(this, 5, this.tileFruitPress.energy);
	        }
	    }
	    this.lastCookTime     = this.tileFruitPress.cookTime; // CookTime
	    this.lastBurnTime     = this.tileFruitPress.burnTime; // BurnTime
	    this.lastItemBurnTime = this.tileFruitPress.currentItemBurnTime; // CurrentItemBurnTime
	    this.lastContent      = this.tileFruitPress.content; // Content
	    this.lastFillingLevel = this.tileFruitPress.fillingLevel; // FillingLevel
	    this.lastEnergy       = this.tileFruitPress.energy; // Energy
	}
    
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int value){
    	if (id == 0){ this.tileFruitPress.cookTime            = value; }
        if (id == 1){ this.tileFruitPress.burnTime            = value; }
        if (id == 2){ this.tileFruitPress.currentItemBurnTime = value; }
        if (id == 3){ this.tileFruitPress.content             = transmuteContent(value); }
        if (id == 4){ this.tileFruitPress.fillingLevel        = value; }
        if (id == 5){ this.tileFruitPress.energy              = value; }
    }
    
    public boolean canInteractWith(EntityPlayer playerIn){
        return this.tileFruitPress.isUseableByPlayer(playerIn);
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
    
    private int transmuteContent(String s){
    	if(0 == s.compareTo("empty"))         return  0;
    	if(0 == s.compareTo("Water"))         return  1;
    	if(0 == s.compareTo("Oil"))           return  2;
    	if(0 == s.compareTo("Apple"))         return  3;
    	if(0 == s.compareTo("CactusFruit"))   return  4;
    	if(0 == s.compareTo("Cherry"))        return  5;
    	if(0 == s.compareTo("Grapes"))        return  6;
    	if(0 == s.compareTo("Lemon"))         return  7;
    	if(0 == s.compareTo("Orange"))        return  8;
    	if(0 == s.compareTo("Peach"))         return  9;
    	if(0 == s.compareTo("Pineapple"))     return 10;
    	if(0 == s.compareTo("Milk"))          return 11;
    	if(0 == s.compareTo("CoconutMilk"))   return 12;
    	if(0 == s.compareTo("CoconutRum"))    return 13;
    	if(0 == s.compareTo("Cider"))         return 14;
    	if(0 == s.compareTo("Rum"))           return 15;
    	if(0 == s.compareTo("Beer"))          return 16;
    	if(0 == s.compareTo("Salgam"))        return 17;
    	if(0 == s.compareTo("Vodka"))         return 18;
    	if(0 == s.compareTo("CactusJack"))    return 19;
    	if(0 == s.compareTo("Sake"))          return 20;
    	if(0 == s.compareTo("Mead"))          return 21;
    	if(0 == s.compareTo("WineGrapes"))    return 22;
    	if(0 == s.compareTo("WineCherry"))    return 23;
    	if(0 == s.compareTo("WinePineapple")) return 24;
    	return 0;
    }
    
    private String transmuteContent(int i){
    	if(i ==  0) return "empty";
    	if(i ==  1) return "Water";
    	if(i ==  2) return "Oil";
    	if(i ==  3) return "Apple";
    	if(i ==  4) return "CactusFruit";
    	if(i ==  5) return "Cherry";
    	if(i ==  6) return "Grapes";
    	if(i ==  7) return "Lemon";
    	if(i ==  8) return "Orange";
    	if(i ==  9) return "Peach";
    	if(i == 10) return "Pineapple";
    	if(i == 11) return "Milk";
    	if(i == 12) return "CoconutMilk";
    	if(i == 13) return "CoconutRum";
    	if(i == 14) return "Cider";
    	if(i == 15) return "Rum";
    	if(i == 16) return "Beer";
    	if(i == 17) return "Salgam";
    	if(i == 18) return "Vodka";
    	if(i == 19) return "CactusJack";
    	if(i == 20) return "Sake";
    	if(i == 21) return "Mead";
    	if(i == 22) return "WineGrapes";
    	if(i == 23) return "WineCherry";
    	if(i == 24) return "WinePineapple";
    	return "empty";
    }
}