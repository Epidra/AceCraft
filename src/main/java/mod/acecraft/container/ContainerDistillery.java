package mod.acecraft.container;

import mod.acecraft.ShopKeeper;
import mod.lucky77.container.ContainerBase;
import mod.lucky77.tileentities.TileBase;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ContainerDistillery extends ContainerBase {

    // ...




    //----------------------------------------CONSTRUCTOR----------------------------------------//

    /** Default Constructor **/
    public ContainerDistillery(int windowID, PlayerInventory playerInventory, TileBase tile) {
        super(ShopKeeper.CONTAINER_DISTILLERY.get(), windowID, playerInventory, tile);

    }

    /** Forge Registry Constructor **/
    public ContainerDistillery(int windowID, PlayerInventory playerInventory, PacketBuffer packetBuffer) {
        super(ShopKeeper.CONTAINER_DISTILLERY.get(), windowID, playerInventory, packetBuffer);
    }




    //----------------------------------------SUPPORT----------------------------------------//

    @Override
    protected void createInventory(TileBase tile, PlayerInventory player) {
        this.addSlot(new Slot(tile, 0,  37, 17)); // INPUT 1
        this.addSlot(new Slot(tile, 1,  56, 17)); // INPUT 2
        this.addSlot(new Slot(tile, 2,  56, 53)); // FUEL
        this.addSlot(new Slot(tile, 3, 116, 35)); // OUTPUT
        addPlayerSlots(player);
    }

    @OnlyIn(Dist.CLIENT)
    public int getLitProgress() {
        int i = this.data.get(2);
        int j = this.data.get(3);
        return j != 0 && i != 0 ? i * 24 / j : 0;
    }

    @OnlyIn(Dist.CLIENT)
    public int getBurnProgress() {
        int i = this.data.get(1);
        if (i == 0) {
            i = 200;
        }

        return this.data.get(0) * 13 / i;
    }

    @OnlyIn(Dist.CLIENT)
    public boolean isLit() {
        return this.data.get(0) > 0;
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
