package mod.acecraft.container;

import mod.acecraft.ShopKeeper;
import mod.acecraft.util.LogicFoundry;
import mod.lucky77.container.ContainerBase;
import mod.lucky77.tileentities.TileBase;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;

public class ContainerFoundry extends ContainerBase {

    // ...




    //----------------------------------------CONSTRUCTOR----------------------------------------//

    /** Default Constructor **/
    public ContainerFoundry(int windowID, PlayerInventory playerInventory, TileBase tile) {
        super(ShopKeeper.CONTAINER_FOUNDRY.get(), windowID, playerInventory, tile);
    }

    /** Forge Registry Constructor **/
    public ContainerFoundry(int windowID, PlayerInventory playerInventory, PacketBuffer packetBuffer) {
        super(ShopKeeper.CONTAINER_FOUNDRY.get(), windowID, playerInventory, packetBuffer);
    }




    //----------------------------------------SUPPORT----------------------------------------//

    @Override
    protected void createInventory(TileBase tile, PlayerInventory player) {
        this.addSlot(new Slot(tile, 0,  62, 11)); // INPUT
        this.addSlot(new Slot(tile, 1,  75, 57)); // OUTPUT 1
        this.addSlot(new Slot(tile, 2,  91, 57)); // OUTPUT 2
        this.addSlot(new Slot(tile, 3, 107, 57)); // OUTPUT 3
        this.addSlot(new Slot(tile, 4, 123, 57)); // OUTPUT 4
        this.addSlot(new Slot(tile, 5, 139, 57)); // OUTPUT 5
        addPlayerSlots(player);
    }

    public int getCoal(){
        return data.get(0);
    }

    public int getCookTime(){
        return data.get(1);
    }

    public int getCookTimeMax(){
        return data.get(2);
    }

    public BlockPos pos() {
        return pos;
    }

    public LogicFoundry logic(){
        return (LogicFoundry) this.logic;
    }

    public ItemStack quickMoveStack(PlayerEntity player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (index == 2) {
                if (!this.moveItemStackTo(itemstack1, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemstack1, itemstack);
            } else if (index != 1 && index != 0) {
                //if (this.canSmelt(itemstack1)) {
                if (!this.moveItemStackTo(itemstack1, 0, 3, false)) {
                    return ItemStack.EMPTY;
                }
                //} else if (this.isFuel(itemstack1)) {
                //    if (!this.moveItemStackTo(itemstack1, 1, 2, false)) {
                //        return ItemStack.EMPTY;
                //    }
                //} else
                if (index >= 3 && index < 30) {
                    if (!this.moveItemStackTo(itemstack1, 30, 39, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index >= 30 && index < 39 && !this.moveItemStackTo(itemstack1, 3, 30, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 3, 39, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemstack1);
        }

        return itemstack;
    }

}
