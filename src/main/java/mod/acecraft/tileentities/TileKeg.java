package mod.acecraft.tileentities;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.DoubleSidedInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.ChestType;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(
        value = Dist.CLIENT,
        _interface = IChestLid.class
)

public class TileKeg extends LockableLootTileEntity implements IChestLid, ITickableTileEntity {

    private NonNullList<ItemStack> chestContents = NonNullList.withSize(27, ItemStack.EMPTY);
    protected float lidAngle;
    protected float prevLidAngle;
    protected int numPlayersUsing;
    private int ticksSinceSync;
    private net.minecraftforge.common.util.LazyOptional<net.minecraftforge.items.IItemHandlerModifiable> chestHandler;

    protected TileKeg(TileEntityType<?> typeIn) {
        super(typeIn);
    }

    public TileKeg() {
        this(TileEntityType.CHEST);
    }

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory() {
        return 27;
    }

    public boolean isEmpty() {
        for(ItemStack itemstack : this.chestContents) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.chest");
    }

    public void read(CompoundNBT compound) {
        super.read(compound);
        this.chestContents = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
        if (!this.checkLootAndRead(compound)) {
            ItemStackHelper.loadAllItems(compound, this.chestContents);
        }

    }

    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        if (!this.checkLootAndWrite(compound)) {
            ItemStackHelper.saveAllItems(compound, this.chestContents);
        }

        return compound;
    }

    public void tick() {
        int i = this.pos.getX();
        int j = this.pos.getY();
        int k = this.pos.getZ();
        ++this.ticksSinceSync;
        this.numPlayersUsing = func_213977_a(this.world, this, this.ticksSinceSync, i, j, k, this.numPlayersUsing);
        this.prevLidAngle = this.lidAngle;
        float f = 0.1F;
        if (this.numPlayersUsing > 0 && this.lidAngle == 0.0F) {
            this.playSound(SoundEvents.BLOCK_CHEST_OPEN);
        }

        if (this.numPlayersUsing == 0 && this.lidAngle > 0.0F || this.numPlayersUsing > 0 && this.lidAngle < 1.0F) {
            float f1 = this.lidAngle;
            if (this.numPlayersUsing > 0) {
                this.lidAngle += 0.1F;
            } else {
                this.lidAngle -= 0.1F;
            }

            if (this.lidAngle > 1.0F) {
                this.lidAngle = 1.0F;
            }

            float f2 = 0.5F;
            if (this.lidAngle < 0.5F && f1 >= 0.5F) {
                this.playSound(SoundEvents.BLOCK_CHEST_CLOSE);
            }

            if (this.lidAngle < 0.0F) {
                this.lidAngle = 0.0F;
            }
        }

    }

    public static int func_213977_a(World p_213977_0_, LockableTileEntity p_213977_1_, int p_213977_2_, int p_213977_3_, int p_213977_4_, int p_213977_5_, int p_213977_6_) {
        if (!p_213977_0_.isRemote && p_213977_6_ != 0 && (p_213977_2_ + p_213977_3_ + p_213977_4_ + p_213977_5_) % 200 == 0) {
            p_213977_6_ = func_213976_a(p_213977_0_, p_213977_1_, p_213977_3_, p_213977_4_, p_213977_5_);
        }

        return p_213977_6_;
    }

    public static int func_213976_a(World p_213976_0_, LockableTileEntity p_213976_1_, int p_213976_2_, int p_213976_3_, int p_213976_4_) {
        int i = 0;
        float f = 5.0F;

        for(PlayerEntity playerentity : p_213976_0_.getEntitiesWithinAABB(PlayerEntity.class, new AxisAlignedBB((double)((float)p_213976_2_ - 5.0F), (double)((float)p_213976_3_ - 5.0F), (double)((float)p_213976_4_ - 5.0F), (double)((float)(p_213976_2_ + 1) + 5.0F), (double)((float)(p_213976_3_ + 1) + 5.0F), (double)((float)(p_213976_4_ + 1) + 5.0F)))) {
            if (playerentity.openContainer instanceof ChestContainer) {
                IInventory iinventory = ((ChestContainer)playerentity.openContainer).getLowerChestInventory();
                if (iinventory == p_213976_1_ || iinventory instanceof DoubleSidedInventory && ((DoubleSidedInventory)iinventory).isPartOfLargeChest(p_213976_1_)) {
                    ++i;
                }
            }
        }

        return i;
    }

    private void playSound(SoundEvent soundIn) {
        ChestType chesttype = this.getBlockState().get(ChestBlock.TYPE);
        if (chesttype != ChestType.LEFT) {
            double d0 = (double)this.pos.getX() + 0.5D;
            double d1 = (double)this.pos.getY() + 0.5D;
            double d2 = (double)this.pos.getZ() + 0.5D;
            if (chesttype == ChestType.RIGHT) {
                Direction direction = ChestBlock.getDirectionToAttached(this.getBlockState());
                d0 += (double)direction.getXOffset() * 0.5D;
                d2 += (double)direction.getZOffset() * 0.5D;
            }

            this.world.playSound((PlayerEntity)null, d0, d1, d2, soundIn, SoundCategory.BLOCKS, 0.5F, this.world.rand.nextFloat() * 0.1F + 0.9F);
        }
    }

    /**
     * See {@link Block#eventReceived} for more information. This must return true serverside before it is called
     * clientside.
     */
    public boolean receiveClientEvent(int id, int type) {
        if (id == 1) {
            this.numPlayersUsing = type;
            return true;
        } else {
            return super.receiveClientEvent(id, type);
        }
    }

    public void openInventory(PlayerEntity player) {
        if (!player.isSpectator()) {
            if (this.numPlayersUsing < 0) {
                this.numPlayersUsing = 0;
            }

            ++this.numPlayersUsing;
            this.onOpenOrClose();
        }

    }

    public void closeInventory(PlayerEntity player) {
        if (!player.isSpectator()) {
            --this.numPlayersUsing;
            this.onOpenOrClose();
        }

    }

    protected void onOpenOrClose() {
        Block block = this.getBlockState().getBlock();
        if (block instanceof ChestBlock) {
            this.world.addBlockEvent(this.pos, block, 1, this.numPlayersUsing);
            this.world.notifyNeighborsOfStateChange(this.pos, block);
        }

    }

    protected NonNullList<ItemStack> getItems() {
        return this.chestContents;
    }

    protected void setItems(NonNullList<ItemStack> itemsIn) {
        this.chestContents = itemsIn;
    }

    @OnlyIn(Dist.CLIENT)
    public float getLidAngle(float partialTicks) {
        return MathHelper.lerp(partialTicks, this.prevLidAngle, this.lidAngle);
    }

    public static int getPlayersUsing(IBlockReader reader, BlockPos posIn) {
        BlockState blockstate = reader.getBlockState(posIn);
        //if (blockstate.hasTileEntity()) {
        //    TileEntity tileentity = reader.getTileEntity(posIn);
        //    if (tileentity instanceof ChestTileEntity) {
        //        return ((ChestTileEntity)tileentity).numPlayersUsing;
        //    }
        //}

        return 0;
    }

    //public static void swapContents(ChestTileEntity chest, ChestTileEntity otherChest) {
    //    NonNullList<ItemStack> nonnulllist = chest.getItems();
    //    chest.setItems(otherChest.getItems());
    //    otherChest.setItems(nonnulllist);
    //}

    protected Container createMenu(int id, PlayerInventory player) {
        return ChestContainer.createGeneric9X3(id, player, this);
    }

    @Override
    public void updateContainingBlockInfo() {
        super.updateContainingBlockInfo();
        if (this.chestHandler != null) {
            this.chestHandler.invalidate();
            this.chestHandler = null;
        }
    }

    @Override
    public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> cap, Direction side) {
        if (!this.removed && cap == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            if (this.chestHandler == null) {
                this.chestHandler = net.minecraftforge.common.util.LazyOptional.of(this::createHandler);
            }
            return this.chestHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    private net.minecraftforge.items.IItemHandlerModifiable createHandler() {
        BlockState state = this.getBlockState();
        if (!(state.getBlock() instanceof ChestBlock)) {
            return new net.minecraftforge.items.wrapper.InvWrapper(this);
        }
        ChestType type = state.get(ChestBlock.TYPE);
        if (type != ChestType.SINGLE) {
            BlockPos opos = this.getPos().offset(ChestBlock.getDirectionToAttached(state));
            BlockState ostate = this.getWorld().getBlockState(opos);
            if (state.getBlock() == ostate.getBlock()) {
                ChestType otype = ostate.get(ChestBlock.TYPE);
                if (otype != ChestType.SINGLE && type != otype && state.get(ChestBlock.FACING) == ostate.get(ChestBlock.FACING)) {
                    TileEntity ote = this.getWorld().getTileEntity(opos);
                    if (ote instanceof ChestTileEntity) {
                        IInventory top    = type == ChestType.RIGHT ? this : (IInventory)ote;
                        IInventory bottom = type == ChestType.RIGHT ? (IInventory)ote : this;
                        return new net.minecraftforge.items.wrapper.CombinedInvWrapper(
                                new net.minecraftforge.items.wrapper.InvWrapper(top),
                                new net.minecraftforge.items.wrapper.InvWrapper(bottom));
                    }
                }
            }
        }
        return new net.minecraftforge.items.wrapper.InvWrapper(this);
    }

    /**
     * invalidates a tile entity
     */
    @Override
    public void remove() {
        super.remove();
        if (chestHandler != null)
            chestHandler.invalidate();
    }

}

//public class TileEntityKeg extends TileEntity implements ITickable, IInventory {
//
//    protected NonNullList<ItemStack> itemStacks = NonNullList.withSize(2, ItemStack.EMPTY);
//    public String content = "empty";
//    public int fillingLevel;
//    public int fillingMax = 25;
//    public int fermentCurrent;
//    public int fermentMax = 20;
//
//    public int getSizeInventory(){
//        return this.itemStacks.size();
//    }
//
//    public ItemStack getStackInSlot(int slot){
//        return this.itemStacks.get(slot);
//    }
//
//    private boolean Fermentable(){
//        if(0 == content.compareTo("Milk")) return true;
//        if(0 == content.compareTo("Apple")) return true;
//        if(0 == content.compareTo("Grapes")) return true;
//        if(0 == content.compareTo("Cherry")) return true;
//        return 0 == content.compareTo("Pineapple");
//    }
//
//    public void update() {
//        boolean flag1 = false;
//        if(!this.world.isRemote){
//            flag1 = this.UpdateContent();
//            if(fillingLevel == fillingMax){
//                if(Fermentable()){
//                    fermentCurrent++;
//                }
//            }else{
//                fermentCurrent = 0;
//            }
//            if(fermentCurrent == fermentMax){
//                if(0 == content.compareTo("Milk"))        content = "Cheese";
//                if(0 == content.compareTo("Apple"))       content = "Cider";
//                if(0 == content.compareTo("Grapes"))      content = "WineGrapes";
//                if(0 == content.compareTo("Cherry"))      content = "WineCherry";
//                if(0 == content.compareTo("Pineapple"))   content = "WinePineapple";
//            }
//        }
//        if (flag1){
//            this.markDirty();
//        }
//    }
//
//    /*public void readFromNBT(NBTTagCompound compound){
//        super.readFromNBT(compound);
//        this.content        = compound.getString("content");
//        this.fillingLevel   = compound.getShort("fillingLevel");
//        this.fermentCurrent = compound.getShort("fermentCurrent");
//        NBTTagList nbttaglist = compound.getTagList("Items", 2);
//        this.itemStacks = new ItemStack[this.getSizeInventory()];
//        for (int i = 0; i < nbttaglist.tagCount(); ++i){
//            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
//            byte b0 = nbttagcompound1.getByte("Slot");
//            if (b0 >= 0 && b0 < this.itemStacks.length){
//                this.itemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
//            }
//        }
//    }
//
//    public NBTTagCompound writeToNBT(NBTTagCompound compound){
//        super.writeToNBT(compound);
//        compound.setString("content",      (String)this.content);
//        compound.setShort("fillingLevel",   (short)this.fillingLevel);
//        compound.setShort("fermentCurrent", (short)this.fermentCurrent);
//        NBTTagList nbttaglist = new NBTTagList();
//        for (int i = 0; i < this.itemStacks.length; ++i){
//            if (this.itemStacks[i] != null){
//                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
//                nbttagcompound1.setByte("Slot", (byte)i);
//                this.itemStacks[i].writeToNBT(nbttagcompound1);
//                nbttaglist.appendTag(nbttagcompound1);
//            }
//        }
//        compound.setTag("Items", nbttaglist);
//        return compound;
//    }*/
//
//    public int getInventoryStackLimit(){
//        return 64;
//    }
//
//    @SideOnly(Side.CLIENT)
//    public String getContent(){
//        return content;
//    }
//
//    @SideOnly(Side.CLIENT)
//    public int getFillingLevel(){
//        return fillingLevel * 3;
//    }
//
//    @SideOnly(Side.CLIENT)
//    public int getFermentCurrent(int i){
//        return fermentCurrent;
//    }
//
//    private String GetStringFromBottle(Item item){
//        if(item == new ItemStack(Items.POTIONITEM,1,0).getItem()) return "Water";
//        //if(item == ShopKeeper.juiceOil)         return "Oil";
//        //if(item == ShopKeeper.juiceApple)       return "Apple";
//        //if(item == ShopKeeper.juiceBanana)      return "Banana";
//        //if(item == ShopKeeper.juiceCherries)    return "Cherry";
//        //if(item == ShopKeeper.juiceGrapes)      return "Grapes";
//        //if(item == ShopKeeper.juiceLemon)       return "Lemon";
//        //if(item == ShopKeeper.juiceMilk)        return "Milk";
//        //if(item == ShopKeeper.juiceOrange)      return "Orange";
//        //if(item == ShopKeeper.juicePeach)       return "Peach";
//        //if(item == ShopKeeper.juicePineapple)   return "Pinapple";
//        //if(item == ShopKeeper.liquorCider)      return "Cider";
//        //if(item == ShopKeeper.liquorRum)        return "Rum";
//        //if(item == ShopKeeper.liquorBeer)       return "Beer";
//        //if(item == ShopKeeper.liquorSalgam)     return "Salgam";
//        //if(item == ShopKeeper.liquorVodka)      return "Vodka";
//        //if(item == ShopKeeper.liquorSake)       return "Sake";
//        //if(item == ShopKeeper.liquorMead)       return "Mead";
//        //if(item == ShopKeeper.liquorWineGrapes) return "WineGrapes";
//        //if(item == ShopKeeper.liquorWineCherry) return "WineCherry";
//        //if(item == ShopKeeper.liquorWinePines)  return "WinePineapple";
//        return "";
//    }
//
//    private String GetStringFromBucket(Item item){
//        //if(item == Items.BUCKET)                return "empty";
//        if(item == Items.MILK_BUCKET)           return "Milk";
//        if(item == Items.WATER_BUCKET)          return "Water";
//        return "";
//    }
//
//    private int validInput(Item item){
//        if(0 == content.compareTo("empty")){
//            if("" != GetStringFromBottle(item)) return 2;
//            if("" != GetStringFromBucket(item)) return 1;
//        } else {
//            if(0 == content.compareTo(GetStringFromBottle(item))) return 2;
//            if(0 == content.compareTo(GetStringFromBucket(item))) return 1;
//        }
//        return 0;
//    }
//
//    private Item GetFilledBucket(){
//        if(content == "Milk")  return Items.MILK_BUCKET;
//        if(content == "Water") return Items.WATER_BUCKET;
//        return null;
//    }
//
//    private Item GetFilledBottle(){
//        if(0 == content.compareTo("Water")) return new ItemStack(Items.POTIONITEM,1,0).getItem();
//        //if(0 == content.compareTo("Oil")) return ShopKeeper.juiceOil;
//        //if(0 == content.compareTo("Apple")) return ShopKeeper.juiceApple;
//        //if(0 == content.compareTo("Banana")) return ShopKeeper.juiceBanana;
//        //if(0 == content.compareTo("Cherry")) return ShopKeeper.juiceCherries;
//        //if(0 == content.compareTo("Grapes")) return ShopKeeper.juiceGrapes;
//        //if(0 == content.compareTo("Lemon")) return ShopKeeper.juiceLemon;
//        //if(0 == content.compareTo("Milk")) return ShopKeeper.juiceMilk;
//        //if(0 == content.compareTo("Orange")) return ShopKeeper.juiceOrange;
//        //if(0 == content.compareTo("Peach")) return ShopKeeper.juicePeach;
//        //if(0 == content.compareTo("Pineapple")) return ShopKeeper.juicePineapple;
//        //if(0 == content.compareTo("Cider")) return ShopKeeper.liquorCider;
//        //if(0 == content.compareTo("Rum")) return ShopKeeper.liquorRum;
//        //if(0 == content.compareTo("Beer")) return ShopKeeper.liquorBeer;
//        //if(0 == content.compareTo("Salgam")) return ShopKeeper.liquorSalgam;
//        //if(0 == content.compareTo("Vodka")) return ShopKeeper.liquorVodka;
//        //if(0 == content.compareTo("Sake")) return ShopKeeper.liquorSake;
//        //if(0 == content.compareTo("Mead")) return ShopKeeper.liquorMead;
//        //if(0 == content.compareTo("WineGrapes")) return ShopKeeper.liquorWineGrapes;
//        //if(0 == content.compareTo("WineCherry")) return ShopKeeper.liquorWineCherry;
//        //if(0 == content.compareTo("WinePineapple")) return ShopKeeper.liquorWinePines;
//        return null;
//    }
//
//    public boolean UpdateContent(){
//        if(this.itemStacks.get(0) != null){
//            if(1 == validInput(itemStacks.get(0).getItem()) && fillingLevel <= fillingMax-3){ // Valid Bucket
//                if(itemStacks.get(1) == null){
//                    itemStacks.set(1, new ItemStack(Items.BUCKET));
//                } else {
//                    itemStacks.get(1).grow(1);
//                }
//                content = GetStringFromBucket(itemStacks.get(0).getItem());
//                itemStacks.get(0).shrink(1);
//                if(itemStacks.get(0).getCount() == 0) itemStacks.set(0, null);
//                fillingLevel += 3;
//                return true;
//            }
//            if(2 == validInput(itemStacks.get(0).getItem()) && fillingLevel <= fillingMax-1){ // Valid Bottle
//                if(itemStacks.get(1) == null){
//                    itemStacks.set(1, new ItemStack(Items.GLASS_BOTTLE));
//                } else {
//                    itemStacks.get(1).grow(1);
//                }
//                content = GetStringFromBottle(itemStacks.get(0).getItem());
//                itemStacks.get(0).shrink(1);
//                if(itemStacks.get(0).getCount() == 0) itemStacks.set(0, null);
//                fillingLevel += 1;
//                return true;
//            }
//            if(0 != content.compareTo("empty")){
//                if(itemStacks.get(0).getItem() == Items.BUCKET){
//                    if(fillingLevel >= 3){
//                        Item temp = GetFilledBucket();
//                        if(temp == null) return false;
//                        if(itemStacks.get(1) == null){
//                            itemStacks.set(1, new ItemStack(temp));
//                            itemStacks.get(0).shrink(1);
//                            if(itemStacks.get(0).getCount() == 0) itemStacks.set(0, null);
//                            fillingLevel -= 3;
//                            if(fillingLevel == 0) content = "empty";
//                            return true;
//                        } else if(itemStacks.get(1).getItem() == temp && itemStacks.get(1).getCount() + 1 <= itemStacks.get(1).getItem().getItemStackLimit()){
//                            itemStacks.get(1).grow(1);
//                            itemStacks.get(0).shrink(1);
//                            if(itemStacks.get(0).getCount() == 0) itemStacks.set(0, null);
//                            fillingLevel -= 3;
//                            if(fillingLevel == 0) content = "empty";
//                            return true;
//                        } else {
//                            return false;
//                        }
//                    }
//                }
//                if(itemStacks.get(0).getItem() == Items.GLASS_BOTTLE){
//                    if(fillingLevel >= 1){
//                        Item temp = GetFilledBottle();
//                        if(temp == null) return false;
//                        if(itemStacks.get(1) == null){
//                            itemStacks.set(1, new ItemStack(temp));
//                            itemStacks.get(0).shrink(1);
//                            if(itemStacks.get(0).getCount() == 0) itemStacks.set(0, null);
//                            fillingLevel -= 1;
//                            if(fillingLevel == 0) content = "empty";
//                            return true;
//                        } else if(itemStacks.get(1).getItem() == temp && itemStacks.get(1).getCount() + 1 <= itemStacks.get(1).getItem().getItemStackLimit()){
//                            itemStacks.get(1).grow(1);
//                            itemStacks.get(0).shrink(1);
//                            if(itemStacks.get(0).getCount() == 0) itemStacks.set(0, null);
//                            fillingLevel -= 1;
//                            if(fillingLevel == 0) content = "empty";
//                            return true;
//                        } else {
//                            return false;
//                        }
//                    }
//                }
//            }
//        }
//        return false;
//    }
//
//    public Item ChangeContent(Item input){
//        if(input != null){
//            if(1 == validInput(input) && fillingLevel <= fillingMax-3){ // Valid Bucket
//                content = GetStringFromBucket(input);
//                fillingLevel += 3;
//                return Items.BUCKET;
//            }
//            if(2 == validInput(input) && fillingLevel <= fillingMax-1){ // Valid Bottle
//                content = GetStringFromBottle(input);
//                fillingLevel += 1;
//                return Items.GLASS_BOTTLE;
//            }
//            if(0 != content.compareTo("empty")){
//                if(input == Items.BUCKET){
//                    Item output = GetFilledBucket();
//                    if(output != null && fillingLevel >= 3){
//                        fillingLevel -= 3;
//                        if(fillingLevel == 0) content = "empty";
//                        return output;
//                    } else {
//                        return null;
//                    }
//
//                }
//                if(input == Items.GLASS_BOTTLE){
//                    if(fillingLevel >= 1){
//                        Item output = GetFilledBottle();
//                        if(output != null){
//                            fillingLevel -= 1;
//                            if(fillingLevel == 0) content = "empty";
//                        }
//                        return output;
//                    }
//                }
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public String getName() {
//        return "acecraft:furnace";
//    }
//
//    @Override
//    public boolean hasCustomName() {
//        return false;
//    }
//
//    @Override
//    public ItemStack decrStackSize(int index, int count) {
//        return ItemStackHelper.getAndSplit(this.itemStacks, index, count);
//    }
//
//    @Override
//    public ItemStack removeStackFromSlot(int index) {
//        return ItemStackHelper.getAndRemove(this.itemStacks, index);
//    }
//
//    //@Override
//    //public void setInventorySlotContents(int index, ItemStack stack) {
//    //	boolean flag = stack != null && stack.isItemEqual(this.itemStacks[index]) && ItemStack.areItemStackTagsEqual(stack, this.itemStacks[index]);
//    //    this.itemStacks[index] = stack;
//    //    if (stack != null && stack.stackSize > this.getInventoryStackLimit()){
//    //        stack.stackSize = this.getInventoryStackLimit();
//    //    }
//    //    if (index == 0 && !flag){
//    //        //this.totalCookTime = this.getCookTime(stack);
//    //        //this.cookTime = 0;
//    //        this.markDirty();
//    //    }
//    //
//    //}
//
//    /** Do not make give this method the name canInteractWith because it clashes with Container */
//    public boolean isUseableByPlayer(EntityPlayer player){
//        return this.world.getTileEntity(this.pos) == this && player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
//    }
//
//    @Override
//    public void openInventory(EntityPlayer player) {
//
//    }
//
//    @Override
//    public void closeInventory(EntityPlayer player) {
//
//    }
//
//    @Override
//    public boolean isItemValidForSlot(int index, ItemStack stack) {
//        return true;
//    }
//
//    @Override
//    public int getField(int id) {
//        // TODO Auto-generated method stub
//        return 0;
//    }
//
//    @Override
//    public void setField(int id, int value) {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public int getFieldCount() {
//        // TODO Auto-generated method stub
//        return 0;
//    }
//
//    @Override
//    public void clear() {
//        for (int i = 0; i < this.itemStacks.size(); ++i){
//            this.itemStacks.set(i, null);
//        }
//    }
//
//    @Override
//    public boolean isEmpty() {
//        // TODO Auto-generated method stub
//        return false;
//    }
//
//    @Override
//    public boolean isUsableByPlayer(EntityPlayer player) {
//        // TODO Auto-generated method stub
//        return false;
//    }
//
//    @Override
//    public void setInventorySlotContents(int index, ItemStack stack) {
//        // TODO Auto-generated method stub
//
//    }
//
//}
