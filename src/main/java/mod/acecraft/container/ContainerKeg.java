package mod.acecraft.container;

import mod.acecraft.tileentities.TileEntityKeg;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerKeg extends Container {
	
private final TileEntityKeg tileKeg;
    
    private String lastContent;
    private int lastFillingLevel;
    private int lastFermentCurrent;
    
    public ContainerKeg(InventoryPlayer playerInventory, IInventory furnaceInventory){
        this.tileKeg = (TileEntityKeg) furnaceInventory;
        this.addSlotToContainer(new Slot(furnaceInventory, 0, 134, 14)); // Bottle IN
        this.addSlotToContainer(new Slot(furnaceInventory, 1, 134, 50)); // Bottle OUT
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
        listener.sendAllWindowProperties(this, this.tileKeg);
    }
    
    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    public void detectAndSendChanges(){
    	super.detectAndSendChanges();
        for (int i = 0; i < this.listeners.size(); ++i){
        	IContainerListener icrafting = this.listeners.get(i);
            if (this.lastContent != this.tileKeg.content){
                icrafting.sendWindowProperty(this, 0, transmuteContent(this.tileKeg.content));
            }
            if (this.lastFillingLevel != this.tileKeg.fillingLevel){
                icrafting.sendWindowProperty(this, 1, this.tileKeg.fillingLevel);
            }
            if (this.lastFermentCurrent != this.tileKeg.fermentCurrent){
                icrafting.sendWindowProperty(this, 2, this.tileKeg.fermentCurrent);
            }
        }
        this.lastContent        = this.tileKeg.content;
        this.lastFillingLevel   = this.tileKeg.fillingLevel;
        this.lastFermentCurrent = this.tileKeg.fermentCurrent;
    }
    
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int value){
    	if (id == 0){ this.tileKeg.content        = transmuteContent(value); }
        if (id == 1){ this.tileKeg.fillingLevel   = value; }
        if (id == 2){ this.tileKeg.fermentCurrent = value; }
    }
    
    public boolean canInteractWith(EntityPlayer playerIn){
        return true;
    }
    
    /** Handle when the stack in slot {@code index} is shift-clicked. Normally this moves the stack between the player inventory and the other inventory(s). */
    // TAKEN FROM BIOMES'O'PLENTY
    @Override
    //@Nonnull
    public ItemStack transferStackInSlot(EntityPlayer player, int index){
        ItemStack oldStack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        //Ensure there is a slot at this index and it has an item in it
        if (slot != null && slot.getHasStack()){
            ItemStack mergedStack = slot.getStack();
            oldStack = mergedStack.copy();
            if (index < 15){
                if (!this.mergeItemStack(mergedStack, 15, this.inventorySlots.size(), true)){
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(mergedStack, 0, 15, false)){
                return ItemStack.EMPTY;
            }
            if (mergedStack.getCount() == 0){
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }
        return oldStack;
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
    	if(0 == s.compareTo("Cheese"))        return 25;
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
    	if(i == 25) return "Cheese";
    	return "empty";
    }
	
}
