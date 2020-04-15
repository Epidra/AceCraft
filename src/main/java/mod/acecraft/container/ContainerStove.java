package mod.acecraft.container;

import mod.acecraft.AceCraft;
import mod.acecraft.crafting.RecipeStove;
import mod.acecraft.tileentities.TileEntityBase;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.CraftResultInventory;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.CraftingResultSlot;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.RecipeItemHelper;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.SSetSlotPacket;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.extensions.IForgeContainerType;

import javax.annotation.Nonnull;
import java.util.Optional;

public class ContainerStove extends ContainerBase {

    public static final ContainerType<ContainerStove> TYPE = (ContainerType<ContainerStove>) IForgeContainerType.create(ContainerStove::new).setRegistryName(AceCraft.MODID, "stove");

    //private final TileEntityBase tile;
    //private final PlayerEntity player;
    //private final IItemHandler inventory;
    //private  final IInventory inventory;
    //private final IIntArray data;
    private BlockPos pos = new BlockPos(0, 0, 0);
    //private final World world;
    private final CraftingInventory inventory = new CraftingInventory(this, 5, 1);
    private final CraftResultInventory inventoryResult = new CraftResultInventory();
    private IWorldPosCallable world = IWorldPosCallable.DUMMY;
    private final PlayerEntity player;

    public ContainerStove(ContainerType<?> type, int windowID, PlayerInventory playerInventory, PacketBuffer packetBuffer) {
        this(type, windowID, playerInventory, BlockPos.fromLong(packetBuffer.readLong()));
        //this.pos = BlockPos.fromLong(packetBuffer.readLong());
    }

    public ContainerStove(ContainerType<?> type, int windowID, PlayerInventory playerInventory, BlockPos pos) {
        this(type, windowID, playerInventory, (TileEntityBase) playerInventory.player.getEntityWorld().getTileEntity(pos));
        //this.pos = pos;
    }

    public ContainerStove(int windowID, PlayerInventory playerInventory, TileEntityBase board) {
        this(TYPE, windowID, playerInventory, board);
    }

    public ContainerStove(int windowID, PlayerInventory playerInventory, PacketBuffer packetBuffer) { // Forge Registry
        this(TYPE, windowID, playerInventory, packetBuffer);
    }

    public ContainerStove(ContainerType<?> type, int windowID, PlayerInventory playerInventory, TileEntityBase board) {
        super(type, windowID);
        //this.inventory = board; // not needed inv already defined
        //this.world = playerInventory.player.world;
        this.addSlot(new CraftingResultSlot(playerInventory.player, this.inventory, this.inventoryResult, 0,  81, 58)); // Result

        this.addSlot(new Slot(this.inventory, 0,  45, 11)); // Item1 IN
        this.addSlot(new Slot(this.inventory, 1,  63, 11)); // Item2 IN
        this.addSlot(new Slot(this.inventory, 2,  81, 11)); // Item3 IN
        this.addSlot(new Slot(this.inventory, 3,  99, 11)); // Item4 IN
        this.addSlot(new Slot(this.inventory, 4, 117, 11)); // Item5 IN

        addPlayerSlots(playerInventory);
        //this.casinoData = board.casinoData;
        //this.boardData = board.boardData;
        //color = board.color;
        //this.data = board.getIntArray();
        //this.tile = board;
        //trackIntArray(data);

        this.world = IWorldPosCallable.of(playerInventory.player.world, pos);
        this.player = playerInventory.player;
        //this.addSlot(new CraftingResultSlot(playerInventory.player, this.inventory, this.inventoryResult, 0, 124, 35));

        //for(int i = 0; i < 3; ++i) {
        //    for(int j = 0; j < 3; ++j) {
        //        this.addSlot(new Slot(this.inventory, j + i * 3, 30 + j * 18, 17 + i * 18));
        //    }
        //}



        for(int k = 0; k < 3; ++k) {
            for(int i1 = 0; i1 < 9; ++i1) {
                this.addSlot(new Slot(playerInventory, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18));
            }
        }


        for(int l = 0; l < 9; ++l) {
            this.addSlot(new Slot(playerInventory, l, 8 + l * 18, 142));
        }


    }

    @Override
    public String getName() {
        return "stove";
    }

    protected static void func_217066_a(int ID, World world, PlayerEntity player, CraftingInventory craftingInventory, CraftResultInventory craftResult) {
        if (!world.isRemote) {
            ServerPlayerEntity serverplayerentity = (ServerPlayerEntity)player;
            ItemStack itemstack = ItemStack.EMPTY;
            Optional<RecipeStove> optional = world.getServer().getRecipeManager().getRecipe(RecipeStove.stove, craftingInventory, world);
            if (optional.isPresent()) {
                RecipeStove icraftingrecipe = optional.get();
                if (craftResult.canUseRecipe(world, serverplayerentity, icraftingrecipe)) {
                    itemstack = icraftingrecipe.getCraftingResult(craftingInventory);
                }
            }

            craftResult.setInventorySlotContents(0, itemstack);
            serverplayerentity.connection.sendPacket(new SSetSlotPacket(ID, 0, itemstack));
        }
    }

    public void onCraftMatrixChanged(IInventory inventoryIn) {
        this.world.consume((world1, pos1) -> {
            func_217066_a(this.windowId, world1, this.player, this.inventory, this.inventoryResult);
        });
    }

    public void func_201771_a(RecipeItemHelper p_201771_1_) {
        this.inventory.fillStackedContents(p_201771_1_);
    }

    public void clear() {
        this.inventory.clear();
        this.inventoryResult.clear();
    }

    //@Override
    //public boolean matches(IRecipe<? super IInventory> recipeIn) {
    //    return recipeIn.matches(this.inventory, this.world);
    //}

    public boolean matches(IRecipe<? super CraftingInventory> recipeIn) {
        return recipeIn.matches(this.inventory, this.player.world);
    }

    public void onContainerClosed(PlayerEntity playerIn) {
        super.onContainerClosed(playerIn);
        this.world.consume((world2, pos2) -> {
            this.clearContainer(playerIn, world2, this.inventory);
        });
    }

    //public boolean canInteractWith(PlayerEntity playerIn) {
    //    return isWithinUsableDistance(this.world, playerIn, Blocks.CRAFTING_TABLE);
    //}

    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (index == 0) {
                this.world.consume((p_217067_2_, p_217067_3_) -> {
                    itemstack1.getItem().onCreated(itemstack1, p_217067_2_, playerIn);
                });
                if (!this.mergeItemStack(itemstack1, 10-4, 46-4, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            } else if (index >= 10-4 && index < 37-4) {
                if (!this.mergeItemStack(itemstack1, 37-4, 46-4, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= 37-4 && index < 46-4) {
                if (!this.mergeItemStack(itemstack1, 10-4, 37-4, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 10-4, 46-4, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            ItemStack itemstack2 = slot.onTake(playerIn, itemstack1);
            if (index == 0) {
                playerIn.dropItem(itemstack2, false);
            }
        }

        return itemstack;
    }

    public boolean canMergeSlot(ItemStack stack, Slot slotIn) {
        return slotIn.inventory != this.inventoryResult && super.canMergeSlot(stack, slotIn);
    }

    public int getOutputSlot() {
        return 0;
    }

    public int getWidth() {
        return this.inventory.getWidth();
    }

    public int getHeight() {
        return this.inventory.getHeight();
    }

    @OnlyIn(Dist.CLIENT)
    public int getSize() {
        return 6;
    }
































    //public ContainerStove(int id, BlockPos pos, World world, PlayerInventory inventory, PlayerEntity player, IIntArray data) {
    //    super(Subscriber.containerStove, id);
    //    tile = (TileEntityStove) world.getTileEntity(pos);
    //    this.player = player;
    //    this.inventory = new InvWrapper(inventory);
    //    this.data = data;
    //    if (tile == null) {
    //        throw new IllegalStateException("TileEntity does not exists!");
    //    }
    //    tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(h -> {
    //        addSlot(new SlotItemHandler(h, 0, 62, 35));
    //        addSlot(new SlotItemHandler(h, 1, 98, 35));
    //    });
    //    layoutPlayerInventorySlots(8, 84);
    //    trackIntArray(data);
    //}

    /** Adds Container Speific Blocks **/
    //private void addOwnSlots(PlayerInventory playerInventory) { // for container specifig slots
    //    this.addSlot(new Slot(inventory, 0, 94, 5));
    //    this.addSlot(new SlotFuel(this, inventory, 1, 94, 60));
    //    this.addSlot(new FurnaceResultSlot(playerInventory.player, inventory, 2, 116, 35));
    //}

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

    @Override
    public boolean canInteractWith(@Nonnull PlayerEntity playerIn) {
        return true;
        //if (tile == null || tile.getWorld() == null) {
        //    throw new IllegalStateException("Null pointer");
        //}
        //return isWithinUsableDistance(IWorldPosCallable.of(tile.getWorld(), tile.getPos()), playerIn, ShopKeeper.MACHINA_STOVE);
    }

    //@Nonnull
    //@Override
    //public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
    //    Slot slot = inventorySlots.get(index);
    //    if (slot != null && slot.getHasStack()) {
    //        ItemStack stack = slot.getStack();
    //        ItemStack itemstack = stack.copy();
    //        if (index < ITEMS) {
    //            if (!mergeItemStack(stack, ITEMS + 1, ITEMS + 36, true)) {
    //                return ItemStack.EMPTY;
    //            }
    //            slot.onSlotChange(stack, itemstack);
    //        } else {
    //            if (tile.isItemValid(stack) && !mergeItemStack(stack, 0, ITEMS, false)) {
    //                return ItemStack.EMPTY;
    //            }
    //        }
    //        if (stack.isEmpty()) {
    //            slot.putStack(ItemStack.EMPTY);
    //        } else {
    //            slot.onSlotChanged();
    //        }
    //        if (stack.getCount() == itemstack.getCount()) {
    //            return ItemStack.EMPTY;
    //        }
    //        slot.onTake(playerIn, stack);
    //    }
    //    return ItemStack.EMPTY;
    //}

    //private int addSlotRange(IItemHandler handler, int index, int x, int y, int amount, int dx) {
    //    for (int i = 0 ; i < amount ; i++) {
    //        addSlot(new SlotItemHandler(handler, index, x, y));
    //        x += dx;
    //        index++;
    //    }
    //    return index;
    //}

    //@SuppressWarnings("SameParameterValue")
    //private void addSlotBox(IItemHandler handler, int index, int x, int y, int horAmount, int dx, int verAmount, int dy) {
    //    for (int j = 0 ; j < verAmount ; j++) {
    //        index = addSlotRange(handler, index, x, y, horAmount, dx);
    //        y += dy;
    //    }
    //}

    //@SuppressWarnings("SameParameterValue")
    //private void layoutPlayerInventorySlots(int leftCol, int topRow) {
    //    addSlotBox(inventory, 9, leftCol, topRow, 9, 18, 3, 18);
    //    // Hotbar offset
    //    topRow += 58;
    //    addSlotRange(inventory, 0, leftCol, topRow, 9, 18);
    //}

    //public int getProgress() {
    //    return data.get(0);
    //}
}
