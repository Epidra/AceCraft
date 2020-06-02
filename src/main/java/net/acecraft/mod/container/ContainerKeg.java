package net.acecraft.mod.container;

import net.acecraft.mod.slot.SlotBonfire;
import net.acecraft.mod.tileentity.TileEntityKeg;
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

public class ContainerKeg extends Container{
	
	private TileEntityKeg tileKeg;
    private int lastCookTime;
    private int lastBurnTime;
    private int lastItemBurnTime;
    private static final String __OBFID = "CL_00001748";
    
    private String lastContent;
    private int lastFillingLevel;
    private int lastFermentCurrent;
    
    public ContainerKeg(InventoryPlayer inventory, TileEntityKeg entity){
        this.tileKeg = entity;
        this.addSlotToContainer(new Slot(entity, 0, 134, 14));
        this.addSlotToContainer(new SlotBonfire(inventory.player, entity, 2, 134, 50));
        for (int i = 0; i < 3; ++i){
            for (int j = 0; j < 9; ++j){
                this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (int i = 0; i < 9; ++i){
            this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
        }
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
    
    public void addCraftingToCrafters(ICrafting icrafting){
        super.addCraftingToCrafters(icrafting);
        icrafting.sendProgressBarUpdate(this, 0, this.tileKeg.cookTime);
        icrafting.sendProgressBarUpdate(this, 1, this.tileKeg.burnTime);
        icrafting.sendProgressBarUpdate(this, 2, this.tileKeg.currentItemBurnTime);
        icrafting.sendProgressBarUpdate(this, 3, transmuteContent(this.tileKeg.content));
        icrafting.sendProgressBarUpdate(this, 4, this.tileKeg.fillingLevel);
        icrafting.sendProgressBarUpdate(this, 5, this.tileKeg.fermentCurrent);
    }
    
    public void detectAndSendChanges(){
        super.detectAndSendChanges();
        for (int i = 0; i < this.crafters.size(); ++i){
            ICrafting icrafting = (ICrafting)this.crafters.get(i);
            if (this.lastCookTime != this.tileKeg.cookTime){
                icrafting.sendProgressBarUpdate(this, 0, this.tileKeg.cookTime);
            }
            if (this.lastBurnTime != this.tileKeg.burnTime){
                icrafting.sendProgressBarUpdate(this, 1, this.tileKeg.burnTime);
            }
            if (this.lastItemBurnTime != this.tileKeg.currentItemBurnTime){
                icrafting.sendProgressBarUpdate(this, 2, this.tileKeg.currentItemBurnTime);
            }
            if (this.lastContent != this.tileKeg.content){
                icrafting.sendProgressBarUpdate(this, 3, transmuteContent(this.tileKeg.content));
            }
            if (this.lastFillingLevel != this.tileKeg.fillingLevel){
                icrafting.sendProgressBarUpdate(this, 4, this.tileKeg.fillingLevel);
            }
            if (this.lastFermentCurrent != this.tileKeg.fermentCurrent){
                icrafting.sendProgressBarUpdate(this, 5, this.tileKeg.fermentCurrent);
            }
        }
        this.lastCookTime       = this.tileKeg.cookTime;
        this.lastBurnTime       = this.tileKeg.burnTime;
        this.lastItemBurnTime   = this.tileKeg.currentItemBurnTime;
        this.lastContent        = this.tileKeg.content;
        this.lastFillingLevel   = this.tileKeg.fillingLevel;
        this.lastFermentCurrent = this.tileKeg.fermentCurrent;
    }
    
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int value){
        if (id == 0){ this.tileKeg.cookTime            = value; }
        if (id == 1){ this.tileKeg.burnTime            = value; }
        if (id == 2){ this.tileKeg.currentItemBurnTime = value; }
        if (id == 3){ this.tileKeg.content = transmuteContent(value); }
        if (id == 4){ this.tileKeg.fillingLevel        = value; }
        if (id == 5){ this.tileKeg.fermentCurrent      = value; }
    }

    public boolean canInteractWith(EntityPlayer player){
        return this.tileKeg.isUseableByPlayer(player);
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