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

public class ContainerCampfire extends Container {
	
	private final IInventory tileBonfire;
    private int cookTime;
    private int totalCookTime;
    private int furnaceBurnTime;
    private int currentItemBurnTime;
    
    public ContainerCampfire(InventoryPlayer playerInventory, IInventory furnaceInventory){
        this.tileBonfire = furnaceInventory;
        this.addSlotToContainer(new Slot(furnaceInventory, 0, 56, 17));
        this.addSlotToContainer(new SlotFurnaceFuel(furnaceInventory, 1, 56, 53));
        this.addSlotToContainer(new SlotFurnaceOutput(playerInventory.player, furnaceInventory, 2, 116, 35));
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
        listener.sendAllWindowProperties(this, this.tileBonfire);
    }
    
    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    public void detectAndSendChanges(){
        super.detectAndSendChanges();
        for (int i = 0; i < this.listeners.size(); ++i){
            IContainerListener icontainerlistener = this.listeners.get(i);
            if (this.cookTime != this.tileBonfire.getField(2)){
                icontainerlistener.sendWindowProperty(this, 2, this.tileBonfire.getField(2));
            }
            if (this.furnaceBurnTime != this.tileBonfire.getField(0)){
                icontainerlistener.sendWindowProperty(this, 0, this.tileBonfire.getField(0));
            }
            if (this.currentItemBurnTime != this.tileBonfire.getField(1)){
                icontainerlistener.sendWindowProperty(this, 1, this.tileBonfire.getField(1));
            }
            if (this.totalCookTime != this.tileBonfire.getField(3)){
                icontainerlistener.sendWindowProperty(this, 3, this.tileBonfire.getField(3));
            }
        }
        this.cookTime = this.tileBonfire.getField(2);
        this.furnaceBurnTime = this.tileBonfire.getField(0);
        this.currentItemBurnTime = this.tileBonfire.getField(1);
        this.totalCookTime = this.tileBonfire.getField(3);
    }
    
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data){
        this.tileBonfire.setField(id, data);
    }
    
    public boolean canInteractWith(EntityPlayer playerIn){
        return this.tileBonfire.isUsableByPlayer(playerIn);
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