package mod.acecraft.container;

import mod.acecraft.AceCraft;
import mod.acecraft.tileentities.TileBlastFurnace;
import mod.acecraft.tileentities.TileEntityBase;
import mod.acecraft.util.SlotFuel;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.FurnaceResultSlot;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IIntArray;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.extensions.IForgeContainerType;

import javax.annotation.Nonnull;

import static mod.acecraft.tileentities.TileEntityDestille.ITEMS;

public class ContainerBlastFurnace extends ContainerBase {

    public static final ContainerType<ContainerBlastFurnace> TYPE = (ContainerType<ContainerBlastFurnace>) IForgeContainerType.create(ContainerBlastFurnace::new).setRegistryName(AceCraft.MODID, "blastfurnace");

    private final TileEntityBase tile;
    private final IIntArray data;
    private BlockPos pos = new BlockPos(0, 0, 0);
    public final IInventory inventory;
    private final World world;

    public ContainerBlastFurnace(ContainerType<?> type, int windowID, PlayerInventory playerInventory, PacketBuffer packetBuffer) {
        this(type, windowID, playerInventory, BlockPos.fromLong(packetBuffer.readLong()));
        //this.pos = BlockPos.fromLong(packetBuffer.readLong());
    }

    public ContainerBlastFurnace(ContainerType<?> type, int windowID, PlayerInventory playerInventory, BlockPos pos) {
        this(type, windowID, playerInventory, (TileBlastFurnace) playerInventory.player.getEntityWorld().getTileEntity(pos));
        this.pos = pos;
    }

    public ContainerBlastFurnace(ContainerType<?> type, int windowID, PlayerInventory playerInventory, TileEntityBase board) {
        super(type, windowID);
        this.inventory = board;
        this.world = playerInventory.player.world;
        this.addSlot(new Slot(board, 0,  88, 60)); // Item IN
        this.addSlot(new Slot(board, 1, 124, 60)); // Fuel
        this.addSlot(new Slot(board, 2, 123, 18)); // Result
        addPlayerSlots(playerInventory);
        this.data = board.getIntArray();
        this.tile = board;
        trackIntArray(data);

        //this.casinoData = board.casinoData;
        //this.boardData = board.boardData;
        //color = board.color;
    }

    public ContainerBlastFurnace(int windowID, PlayerInventory playerInventory, TileEntityBase board) {
        this(TYPE, windowID, playerInventory, board);
    }

    public ContainerBlastFurnace(int windowID, PlayerInventory playerInventory, PacketBuffer packetBuffer) { // Forge Registry
        this(TYPE, windowID, playerInventory, packetBuffer);
    }

    /** Adds Container Speific Blocks **/
    private void addOwnSlots(PlayerInventory playerInventory) { // for container specifig slots
        this.addSlot(new Slot(inventory, 0, 94, 5));
        this.addSlot(new SlotFuel(this, inventory, 1, 94, 60));
        this.addSlot(new FurnaceResultSlot(playerInventory.player, inventory, 2, 116, 35));
    }

    /** Adds Slots from Player Inventory at a specific Position **/
    protected void addPlayerSlots(PlayerInventory playerInventory, int inX, int inY) {
        // Slots for the hotbar
        for (int row = 0; row < 9; ++ row) {
            int x = inX + row * 18;
            int y = inY + 86;
            addSlot(new Slot(playerInventory, row, x, y));
        }
        // Slots for the main inventory
        for (int row = 1; row < 4; ++ row) {
            for (int col = 0; col < 9; ++ col) {
                int x = inX + col * 18;
                int y = row * 18 + (inY + 10);
                addSlot(new Slot(playerInventory, col + row * 9, x, y));
            }
        }
    }

    protected void addPlayerSlots(PlayerInventory playerInventory) {
        addPlayerSlots(playerInventory, 8, 56);
    }


    //@Override
    public String getName() {
        return "blastfurnace";
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return true;
    }

    @Nonnull
    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        Slot slot = inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack stack = slot.getStack();
            ItemStack itemstack = stack.copy();
            if (index < ITEMS) {
                if (!mergeItemStack(stack, ITEMS + 1, ITEMS + 36, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onSlotChange(stack, itemstack);
            } else {
                if (tile.isItemValid(stack) && !mergeItemStack(stack, 0, ITEMS, false)) {
                    return ItemStack.EMPTY;
                }
            }
            if (stack.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
            if (stack.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }
            slot.onTake(playerIn, stack);
        }
        return ItemStack.EMPTY;
    }

    @OnlyIn(Dist.CLIENT)
    public int getCookProgressionScaled() {
        int i = this.data.get(2);
        int j = this.data.get(3);
        return j != 0 && i != 0 ? i * 24 / j : 0;
    }

    @OnlyIn(Dist.CLIENT)
    public int getAmount() {
        return this.data.get(4);
    }

    @OnlyIn(Dist.CLIENT)
    public int getBurnLeftScaled() {
        int i = this.data.get(1);
        if (i == 0) {
            i = 200;
        }

        return this.data.get(0) * 13 / i;
    }

    @OnlyIn(Dist.CLIENT)
    public boolean func_217061_l() {
        return this.data.get(0) > 0;
    }
}
