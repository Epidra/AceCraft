package mod.acecraft.tileentities;

import mod.acecraft.ShopKeeper;
import mod.acecraft.crafting.RecipeDestille;
import mod.shared.util.BurnTimes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.RecipeWrapper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;
import java.util.function.Supplier;

import static mod.acecraft.AceCraft.MODID;

public class TileEntityDestille extends TileEntityDestilleAbstract {

    public static TileEntityType<TileEntity> TYPE = (TileEntityType<TileEntity>) TileEntityType.Builder.create((Supplier<TileEntity>) TileEntityDestille::new, ShopKeeper.MACHINA_DESTILLERY).build(null).setRegistryName(MODID, "destille");

    public static final int ITEMS = 4;
    private static final double PI2 = Math.PI * 2;
    //private static final int TICKS_TO_FINISH = 100;
    //private NonNullList<ItemStack> stacks = NonNullList.withSize(ITEMS, ItemStack.EMPTY);
    private final IItemHandlerModifiable nonSidedItemHandler = createNonSidedInventoryHandler(items);
    private final LazyOptional<IItemHandlerModifiable> sidedInventoryHandler = LazyOptional.of(() -> createSidedInventoryHandler(items));
    private final LazyOptional<IItemHandlerModifiable> nonSidedInventoryHandler = LazyOptional.of(() -> nonSidedItemHandler);
    private final RecipeWrapper inventoryWrapper = new RecipeWrapper(nonSidedItemHandler);
    private final IItemHandlerModifiable tmpItemHandler = new ItemStackHandler(1);
    private final RecipeWrapper tmpItemHandlerWrapper = new RecipeWrapper(tmpItemHandler);
    //private final IIntArray data = getData();

    //private int cookTime; // how long until result item appears
    //private int cookTimeTotal;

    private float rotation = 0f;

    private boolean active = false;

    private int partCnt = 0;

    private ItemStack result = ItemStack.EMPTY;

    @Override
    public ITextComponent getName() {
        return new TranslationTextComponent("tile.destille.name");
    }

    //@Override
    public IIntArray getIntArray() {
        return data;
    }


    public TileEntityDestille() {

        //noinspection ConstantConditions

        super(TYPE, RecipeDestille.destille);

    }

    @Override
    @Nullable
    public SUpdateTileEntityPacket getUpdatePacket(){
        CompoundNBT nbtTagCompound = new CompoundNBT();
        write(nbtTagCompound);
        return new SUpdateTileEntityPacket(this.pos, TYPE.hashCode(), nbtTagCompound);
    }

    /** ??? */
    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        read(pkt.getNbtCompound());
    }

    /** Creates a tag containing the TileEntity information, used by vanilla to transmit from server to client */
    @Override
    public CompoundNBT getUpdateTag(){
        CompoundNBT nbtTagCompound = new CompoundNBT();
        write(nbtTagCompound);
        return nbtTagCompound;
    }

    /** Populates this TileEntity with information from the tag, used by vanilla to transmit from server to client */
    @Override
    public void handleUpdateTag(CompoundNBT tag){
        this.read(tag);
    }



    //@Override
//
    //public void tick() {
//
    //    assert world != null;
//
//
//
    //    if (active) {
//
    //        float oldRot = rotation;
//
//
//
    //        if (world.rand.nextInt(5) == 0) {
//
    //            double d0 = pos.getX() + world.rand.nextFloat() / 2 + 0.25;
//
    //            double d1 = pos.getY() + 7 / 16f + 0.025D;
//
    //            double d2 = pos.getZ() + world.rand.nextFloat() / 2 + 0.25;
//
    //            world.addParticle(ParticleTypes.CRIT, d0, d1, d2, 0, world.rand.nextFloat(), 0);
//
    //        }
//
//
//
    //        rotation += PI2 / TICKS_TO_FINISH;
//
    //        rotation = (float) (rotation % PI2);
//
//
//
    //        if (partCnt > 0) {
//
    //            partCnt--;
//
    //        }
//
//
//
    //        if (rotation < oldRot) {
//
    //            active = false;
//
    //            partCnt = 0;
//
//
//
    //            if (!world.isRemote) {
//
    //                if (stacks.get(1).isEmpty()) {
//
    //                    stacks.set(1, result);
//
    //                } else {
//
    //                    stacks.get(1).grow(result.getCount());
//
    //                }
//
//
//
    //                result = ItemStack.EMPTY;
//
    //                world.notifyBlockUpdate(getPos(), getBlockState(), getBlockState(), 3);
//
    //            }
//
    //        } else {
//
    //            if (partCnt == 0) {
//
    //                active = false;
//
//
//
    //                if (!world.isRemote) {
//
    //                    world.notifyBlockUpdate(getPos(), getBlockState(), getBlockState(), 3);
//
    //                }
//
    //            }
//
    //        }
//
    //    }
//
    //}



    //@Nullable
//
    //@Override
//
    //public Container createMenu(int id, @Nonnull PlayerInventory inventory, @Nonnull PlayerEntity entity) {
//
    //    assert world != null;
//
    //    return new ContainerDestille(id, pos, world, inventory, entity);
//
    //}



    @Nonnull

    @Override

    public ITextComponent getDisplayName() {

        assert getType().getRegistryName() != null;

        return new StringTextComponent(getType().getRegistryName().getPath());

    }

    //@Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.destille");
    }


    @Nonnull

    //@Override

    public IInventory getInventory() {

        return inventoryWrapper;

    }



    @Override

    public void read(CompoundNBT tag) {

        //CompoundNBT invTag = tag.getCompound("inv");

        //ItemStackUtils.deserializeStacks(invTag, stacks);

        this.items = NonNullList.withSize(4, ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(tag, this.items);

        active = tag.getBoolean("active");

        rotation = tag.getFloat("rotation");

        partCnt = tag.getInt("partCnt");

        result = ItemStack.read(tag.getCompound("result"));

        super.read(tag);

    }



    @Override

    @Nonnull

    public CompoundNBT write(CompoundNBT tag) {

        //tag.put("inv", ItemStackUtils.serializeStacks(stacks));

        ItemStackHelper.saveAllItems(tag, this.items);

        tag.putBoolean("active", active);

        tag.putFloat("rotation", rotation);

        tag.putInt("partCnt", partCnt);

        CompoundNBT resTag = new CompoundNBT();

        result.write(resTag);

        tag.put("result", resTag);

        return super.write(tag);

    }



    //@Nullable
//
    //@Override
//
    //public SUpdateTileEntityPacket getUpdatePacket() {
//
    //    return new SUpdateTileEntityPacket(getPos(), getType().hashCode(), getUpdateTag());
//
    //}



    //@Nonnull
//
    //@Override
//
    //public CompoundNBT getUpdateTag() {
//
    //    return write(new CompoundNBT());
//
    //}



    //@Override
//
    //public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
//
    //    super.onDataPacket(net, pkt);
//
    //    read(pkt.getNbtCompound());
//
    //}



    @Nonnull

    @Override

    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {

        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {

            if (side != null) {

                return sidedInventoryHandler.cast();

            } else {

                return nonSidedInventoryHandler.cast();

            }

        }

        return super.getCapability(cap, side);

    }



    @Override

    public void remove() {

        sidedInventoryHandler.invalidate();

        nonSidedInventoryHandler.invalidate();

        super.remove();

    }



    ItemStack getResult() {

        return result;

    }



    int getPerc() {

        return (int) Math.round(rotation / PI2 * 100);

    }



    public boolean isItemValid(ItemStack itemStack) {

        return getRecipe(itemStack).isPresent();

    }



    private IItemHandlerModifiable createNonSidedInventoryHandler(@Nonnull NonNullList<ItemStack> stacks) {

        return new ItemStackHandler(stacks) {

            @Nonnull

            @Override

            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {

                if (TileEntityDestille.this.isItemValid(stack)) {

                    return super.insertItem(slot, stack, simulate);

                }



                return stack;

            }



            @Override

            protected void onContentsChanged(int slot) {

                assert world != null;

                markDirty();

                world.notifyBlockUpdate(getPos(), getBlockState(), getBlockState(), 3);

            }

        };

    }



    private IItemHandlerModifiable createSidedInventoryHandler(@Nonnull NonNullList<ItemStack> stacks) {

        return new ItemStackHandler(stacks) {

            @Nonnull

            @Override

            public ItemStack extractItem(int slot, int amount, boolean simulate) {

                if (slot == 1) {

                    return super.extractItem(slot, amount, simulate);

                }



                return ItemStack.EMPTY;

            }



            @Nonnull

            @Override

            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {

                if (slot == 0 && TileEntityDestille.this.isItemValid(stack)) {

                    return super.insertItem(slot, stack, simulate);

                }



                return stack;

            }



            @Override

            protected void onContentsChanged(int slot) {

                assert world != null;

                markDirty();

                world.notifyBlockUpdate(getPos(), getBlockState(), getBlockState(), 3);

            }

        };

    }



    //public float rotateAngle() {
//
    //    return rotation;
//
    //}
//
//
//
    //void onActivated() {
//
    //    assert world != null;
//
//
//
    //    if (!active) {
//
    //        if (result.isEmpty() && !stacks.get(0).isEmpty()) {
//
    //            getRecipe(stacks.get(0)).ifPresent(millstoneRecipe -> {
//
    //                ItemStack recipeResult = millstoneRecipe.getRecipeOutput().copy();
//
//
//
    //                if (stacks.get(1).isEmpty() || (stacks.get(1).getItem().equals(recipeResult.getItem()) &&
//
    //                        stacks.get(1).getCount() < stacks.get(1).getMaxStackSize() - recipeResult.getCount())) {
//
    //                    stacks.get(0).shrink(1);
//
//
//
    //                    result = recipeResult;
//
    //                    active = true;
//
    //                    partCnt = TICKS_TO_FINISH / 4;
//
//
//
    //                    world.playSound(null, getPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS, 0.5f, 1.0f);
//
    //                    world.notifyBlockUpdate(getPos(), getBlockState(), getBlockState(), 3);
//
    //                }
//
    //            });
//
    //        } else if (!result.isEmpty()) {
//
    //            active = true;
//
    //            partCnt = TICKS_TO_FINISH / 4;
//
//
//
    //            world.playSound(null, getPos(), SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.BLOCKS, 0.5f, 1.0f);
//
    //            world.notifyBlockUpdate(getPos(), getBlockState(), getBlockState(), 3);
//
    //        }
//
    //    }
//
    //}



    @Nonnull

    private Optional<RecipeDestille> getRecipe(@Nonnull ItemStack item) {

        assert world != null;

        tmpItemHandler.setStackInSlot(0, item);

        return world.getRecipeManager().getRecipe(RecipeDestille.destille, tmpItemHandlerWrapper, world);

    }


    //private IIntArray getData(){
    //    return new IIntArray() {
    //        public int get(int index) {
    //            switch(index) {
    //                case 0:
    //                    return TileEntityDestille.this.burnTime;
    //                case 1:
    //                    return TileEntityDestille.this.recipesUsed;
    //                 case 2:
    //                    return TileEntityDestille.this.cookTime;
    //                case 3:
    //                    return TileEntityDestille.this.cookTimeTotal;
    //                default:
    //                    return 0;
    //            }
    //        }
//
    //        public void set(int index, int value) {
    //            switch(index) {
    //                case 0:
    //                    TileEntityDestille.this.burnTime = value;
    //                    break;
    //                case 1:
    //                    TileEntityDestille.this.recipesUsed = value;
    //                    break;
    //                case 2:
    //                    TileEntityDestille.this.cookTime = value;
    //                    break;
    //                case 3:
    //                    TileEntityDestille.this.cookTimeTotal = value;
    //            }
//
    //        }
//
    //        public int size() {
    //            return 4;
    //        }
    //
    //}



    //@Nonnull
//
    //private IIntArray getData() {
//
    //    return new IIntArray() {
//
    //        @Override
//
    //        public int get(int index) {
//
    //            return Math.round(rotation * 15.9154943092f);
//
    //        }
//
//
//
    //        @Override
//
    //        public void set(int index, int value) {
//
    //            rotation = value * 0.0628318530718f;
//
    //        }
//
//
//
    //        @Override
//
    //        public int size() {
//
    //            return 4;
//
    //        }
//
    //    };
//
    //}










    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory() {
        return this.items.size();
    }

    public boolean isEmpty() {
        for(ItemStack itemstack : this.items) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns the stack in the given slot.
     */
    public ItemStack getStackInSlot(int index) {
        return this.items.get(index);
    }

    /**
     * Removes up to a specified number of items from an inventory slot and returns them in a new stack.
     */
    public ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(this.items, index, count);
    }

    /**
     * Removes a stack from the given slot and returns it.
     */
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.items, index);
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int index, ItemStack stack) {
        ItemStack itemstack = this.items.get(index);
        boolean flag = !stack.isEmpty() && stack.isItemEqual(itemstack) && ItemStack.areItemStackTagsEqual(stack, itemstack);
        this.items.set(index, stack);
        if (stack.getCount() > this.getInventoryStackLimit()) {
            stack.setCount(this.getInventoryStackLimit());
        }

        if (index == 0 && !flag) {
            this.cookTimeTotal = this.getTotalCookTime();
            this.cookTime = 0;
            this.markDirty();
        }

    }

    /**
     * Don't rename this method to canInteractWith due to conflicts with Container
     */
    public boolean isUsableByPlayer(PlayerEntity player) {
        if (this.world.getTileEntity(this.pos) != this) {
            return false;
        } else {
            return player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
        }
    }

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot. For
     * guis use Slot.isItemValid
     */
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        if (index == 2) {
            return false;
        } else if (index != 1) {
            return true;
        } else {
            ItemStack itemstack = this.items.get(1);
            return isFuel(stack) || stack.getItem() == Items.BUCKET && itemstack.getItem() != Items.BUCKET;
        }
    }

    public void clear() {
        this.items.clear();
    }


    protected int getBurnTime(ItemStack stack) {
        if (stack.isEmpty()) {
            return 0;
        } else {
            Item item = stack.getItem();
            int ret = stack.getBurnTime();
            return net.minecraftforge.event.ForgeEventFactory.getItemBurnTime(stack, ret == -1 ? BurnTimes.getBurnTimes().getOrDefault(item, 0) : ret);
        }
    }

    public static boolean isFuel(ItemStack stack) {
        int ret = stack.getBurnTime();
        return net.minecraftforge.event.ForgeEventFactory.getItemBurnTime(stack, ret == -1 ? BurnTimes.getBurnTimes().getOrDefault(stack.getItem(), 0) : ret) > 0;
    }

    protected int getTotalCookTime() {
        return 400;
    }

    @Nullable
    @Override
    public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
        return null;
    }

    //@Override
    protected Container createMenu(int id, PlayerInventory player) {
        return null;
    }
}
