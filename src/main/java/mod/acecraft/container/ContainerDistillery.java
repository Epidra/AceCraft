package mod.acecraft.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerDistillery extends Container {
	
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
            IContainerListener icontainerlistener = this.listeners.get(i);
            if (this.cookTime != this.tileDistillery.getField(2)){
                icontainerlistener.sendWindowProperty(this, 2, this.tileDistillery.getField(2));
            }
            if (this.furnaceBurnTime != this.tileDistillery.getField(0)){
                icontainerlistener.sendWindowProperty(this, 0, this.tileDistillery.getField(0));
            }
            if (this.currentItemBurnTime != this.tileDistillery.getField(1)){
                icontainerlistener.sendWindowProperty(this, 1, this.tileDistillery.getField(1));
            }
            if (this.totalCookTime != this.tileDistillery.getField(3)){
                icontainerlistener.sendWindowProperty(this, 3, this.tileDistillery.getField(3));
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
        return this.tileDistillery.isUsableByPlayer(playerIn);
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
	
}
