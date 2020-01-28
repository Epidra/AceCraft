package mod.acecraft.container;

public class ContainerMillstone {

}

//public class ContainerMillstone extends Container {
//
//    private final IInventory tileMillstone;
//    private int cookTime;
//    private int totalCookTime;
//    private int furnaceBurnTime;
//    private int currentItemBurnTime;
//
//    public ContainerMillstone(InventoryPlayer playerInventory, IInventory furnaceInventory){
//        this.tileMillstone = furnaceInventory;
//        this.addSlotToContainer(new Slot(furnaceInventory, 0, 56, 35)); // Raw Input
//        this.addSlotToContainer(new SlotFurnaceOutput(playerInventory.player, furnaceInventory, 1, 116, 35));
//        for (int i = 0; i < 3; ++i){
//            for (int j = 0; j < 9; ++j){
//                this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
//            }
//        }
//        for (int k = 0; k < 9; ++k){
//            this.addSlotToContainer(new Slot(playerInventory, k, 8 + k * 18, 142));
//        }
//    }
//
//    public void addListener(IContainerListener listener){
//        super.addListener(listener);
//        listener.sendAllWindowProperties(this, this.tileMillstone);
//    }
//
//    /**
//     * Looks for changes made in the container, sends them to every listener.
//     */
//    public void detectAndSendChanges(){
//        super.detectAndSendChanges();
//        for (int i = 0; i < this.listeners.size(); ++i){
//            IContainerListener icontainerlistener = this.listeners.get(i);
//            if (this.cookTime != this.tileMillstone.getField(2)){
//                icontainerlistener.sendWindowProperty(this, 2, this.tileMillstone.getField(2));
//            }
//            if (this.furnaceBurnTime != this.tileMillstone.getField(0)){
//                icontainerlistener.sendWindowProperty(this, 0, this.tileMillstone.getField(0));
//            }
//            if (this.currentItemBurnTime != this.tileMillstone.getField(1)){
//                icontainerlistener.sendWindowProperty(this, 1, this.tileMillstone.getField(1));
//            }
//            if (this.totalCookTime != this.tileMillstone.getField(3)){
//                icontainerlistener.sendWindowProperty(this, 3, this.tileMillstone.getField(3));
//            }
//        }
//        this.cookTime = this.tileMillstone.getField(2);
//        this.furnaceBurnTime = this.tileMillstone.getField(0);
//        this.currentItemBurnTime = this.tileMillstone.getField(1);
//        this.totalCookTime = this.tileMillstone.getField(3);
//    }
//
//    @SideOnly(Side.CLIENT)
//    public void updateProgressBar(int id, int data){
//        this.tileMillstone.setField(id, data);
//    }
//
//    public boolean canInteractWith(EntityPlayer playerIn){
//        return this.tileMillstone.isUsableByPlayer(playerIn);
//    }
//
//    /** Handle when the stack in slot {@code index} is shift-clicked. Normally this moves the stack between the player inventory and the other inventory(s). */
//    // TAKEN FROM BIOMES'O'PLENTY
//    @Override
//    //@Nonnull
//    public ItemStack transferStackInSlot(EntityPlayer player, int index){
//        ItemStack oldStack = ItemStack.EMPTY;
//        Slot slot = this.inventorySlots.get(index);
//        //Ensure there is a slot at this index and it has an item in it
//        if (slot != null && slot.getHasStack()){
//            ItemStack mergedStack = slot.getStack();
//            oldStack = mergedStack.copy();
//            if (index < 15){
//                if (!this.mergeItemStack(mergedStack, 15, this.inventorySlots.size(), true)){
//                    return ItemStack.EMPTY;
//                }
//            } else if (!this.mergeItemStack(mergedStack, 0, 15, false)){
//                return ItemStack.EMPTY;
//            }
//            if (mergedStack.getCount() == 0){
//                slot.putStack(ItemStack.EMPTY);
//            } else {
//                slot.onSlotChanged();
//            }
//        }
//        return oldStack;
//    }
//
//}

