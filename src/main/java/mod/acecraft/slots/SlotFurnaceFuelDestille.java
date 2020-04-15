package mod.acecraft.slots;

import mod.acecraft.container.ContainerDestilleAbstract;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class SlotFurnaceFuelDestille extends Slot {

    private ContainerDestilleAbstract container;

    public SlotFurnaceFuelDestille(ContainerDestilleAbstract container, IInventory inventory, int a, int b, int c) {
        super(inventory, a, b, c);
        this.container = container;
    }

    /**
     * Check if the stack is allowed to be placed in this slot, used for armor slots as well as furnace fuel.
     */
    public boolean isItemValid(ItemStack stack) {
        return this.container.isFuel(stack) || isBucket(stack);
    }

    public int getItemStackLimit(ItemStack stack) {
        return isBucket(stack) ? 1 : super.getItemStackLimit(stack);
    }

    public static boolean isBucket(ItemStack stack) {
        return stack.getItem() == Items.BUCKET;
    }

}
