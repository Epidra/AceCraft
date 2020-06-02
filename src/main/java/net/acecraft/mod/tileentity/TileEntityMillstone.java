package net.acecraft.mod.tileentity;

import javax.annotation.Nullable;

import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.container.ContainerMillstone;
import net.acecraft.mod.crafting.MillstoneRecipes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.walkers.ItemStackDataLists;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityMillstone extends ITileEntityEnergy implements ITickable, ISidedInventory{
	public static final int[] SLOTS_TOP    = new int[] {0};
	public static final int[] SLOTS_BOTTOM = new int[] {2, 1};
	public static final int[] SLOTS_SIDES  = new int[] {1};
    /** The ItemStacks that hold the items currently being used in the furnace */
	public ItemStack[] itemStacks = new ItemStack[3];
    /** The number of ticks that the furnace will keep burning */
	public int furnaceBurnTime;
    /** The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for */
	public int currentItemBurnTime;
    /** The number of ticks that the current item is already smelting */
	public int cookTime;
    /** The total number of ticks a item has to smelt before transforming */
	public int totalCookTime;
    /** ??? */
	public String furnaceCustomName;
	
    public int burnTime;
    private String field;
    public int meta;
    public int energy = 0;
	
	public TileEntityMillstone(){
		
	}
	
    /** Returns the number of slots in the inventory. */
    public int getSizeInventory(){
        return this.itemStacks.length;
    }
    
    /** Returns the stack in the given slot. */
    @Nullable
    public ItemStack getStackInSlot(int index){
        return this.itemStacks[index];
    }
    
    /** Removes up to a specified number of items from an inventory slot and returns them in a new stack. */
    @Nullable
    public ItemStack decrStackSize(int index, int count){
        return ItemStackHelper.getAndSplit(this.itemStacks, index, count);
    }
    
    /** Removes a stack from the given slot and returns it. */
    @Nullable
    public ItemStack removeStackFromSlot(int index){
        return ItemStackHelper.getAndRemove(this.itemStacks, index);
    }
    
    /** Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections). */
    public void setInventorySlotContents(int index, @Nullable ItemStack stack){
        boolean flag = stack != null && stack.isItemEqual(this.itemStacks[index]) && ItemStack.areItemStackTagsEqual(stack, this.itemStacks[index]);
        this.itemStacks[index] = stack;
        if (stack != null && stack.stackSize > this.getInventoryStackLimit()){
            stack.stackSize = this.getInventoryStackLimit();
        }
        if (index == 0 && !flag){
            this.totalCookTime = this.getCookTime(stack);
            this.cookTime = 0;
            this.markDirty();
        }
    }
    
    /** Get the name of this object. For players this returns their username */
    public String getName(){
        return this.hasCustomName() ? this.furnaceCustomName : "container.furnace";
    }
    
    /** Returns true if this thing is named */
    public boolean hasCustomName(){
        return this.furnaceCustomName != null && !this.furnaceCustomName.isEmpty();
    }
    
    public void readFromNBT(NBTTagCompound compound){
    	super.readFromNBT(compound);
        this.meta     = compound.getShort("meta");
        this.energy   = compound.getShort("energy");
        this.burnTime = compound.getShort("BurnTime");
        this.cookTime = compound.getShort("CookTime");
        NBTTagList nbttaglist = compound.getTagList("Items", 10);
        this.itemStacks = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < nbttaglist.tagCount(); ++i){
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");
            if (b0 >= 0 && b0 < this.itemStacks.length){
                this.itemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
    }
    
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
    	super.writeToNBT(compound);
    	compound.setShort("meta",     (short)this.meta);
    	compound.setShort("energy",   (short)this.energy);
    	compound.setShort("BurnTime", (short)this.burnTime);
    	compound.setShort("CookTime", (short)this.cookTime);
        NBTTagList nbttaglist = new NBTTagList();
        for (int i = 0; i < this.itemStacks.length; ++i){
            if (this.itemStacks[i] != null){
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.itemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }
        compound.setTag("Items", nbttaglist);
        return compound;
    }
    
    /** Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. */
    public int getInventoryStackLimit(){
        return 64;
    }
    
    /** Furnace isBurning */
    public boolean isBurning(){
        return this.furnaceBurnTime > 0;
    }
    
    @SideOnly(Side.CLIENT)
    public static boolean isBurning(IInventory inventory){
        return inventory.getField(0) > 0;
    }
    
    /** Like the old updateEntity(), except more generic. */
    public void update(){
    	boolean flag = this.burnTime > 0;
        boolean flag1 = false;
        if(worldObj.getBlockState(pos.up(3)).getBlock() == ShopKeeper.machinaAxle){
			TileEntityAxle entityA = (TileEntityAxle) worldObj.getTileEntity(pos.up(3));
			energy = entityA.energy;
		}else
		if(worldObj.getBlockState(pos.up(3)).getBlock() == ShopKeeper.machinaGearBox){
			TileEntityGearBox entityG = (TileEntityGearBox) worldObj.getTileEntity(pos.up(3));
			energy = entityG.energy;
		}else{
			energy = 0;
		}
        if (this.burnTime > 0){
            --this.burnTime;
        }
        if(!this.worldObj.isRemote){
        	if (this.hasEnergy() && this.canSmelt()){
                ++this.cookTime;
                if (this.cookTime == 300-energy){
                    this.cookTime = 0;
                    this.smeltItem();
                    flag1 = true;
                }
            }else{
                this.cookTime = 0;
            }
        }
        if (flag1){
            this.markDirty();
        }
    }
    
    public int getCookTime(@Nullable ItemStack stack){
        return 200;
    }
    
    /** Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc. */
    private boolean canSmelt(){
    	if (this.itemStacks[0] == null){
            return false;
        }else{
            ItemStack itemstack = MillstoneRecipes.instance().getSmeltingResult(this.itemStacks[0]);
            if (itemstack == null) return false;
            if (this.itemStacks[1] == null) return true;
            if (!this.itemStacks[1].isItemEqual(itemstack)) return false;
            int result = itemStacks[1].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.itemStacks[1].getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
        }
    }
    
    /** Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack */
    public void smeltItem(){
    	if (this.canSmelt()){
            ItemStack itemstack = MillstoneRecipes.instance().getSmeltingResult(this.itemStacks[0]);
            if (this.itemStacks[1] == null){
                this.itemStacks[1] = itemstack.copy();
            }else if (this.itemStacks[1].getItem() == itemstack.getItem()){
                this.itemStacks[1].stackSize += itemstack.stackSize;
            }
            --this.itemStacks[0].stackSize;
            if (this.itemStacks[0].stackSize <= 0){
                this.itemStacks[0] = null;
            }
        }
    }
    
    /** Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't fuel */
    public static int getItemBurnTime(ItemStack stack){
        if (stack == null){
            return 0;
        } else {
            Item item = stack.getItem();
            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR){
                Block block = Block.getBlockFromItem(item);
                if (block == Blocks.WOODEN_SLAB){
                    return 150;
                }
                if (block.getDefaultState().getMaterial() == Material.WOOD){
                    return 300;
                }
                if (block == Blocks.COAL_BLOCK){
                    return 16000;
                }
            }
            if (item instanceof ItemTool  && "WOOD".equals(((ItemTool)item) .getToolMaterialName())) return 200;
            if (item instanceof ItemSword && "WOOD".equals(((ItemSword)item).getToolMaterialName())) return 200;
            if (item instanceof ItemHoe   && "WOOD".equals(((ItemHoe)item)  .getMaterialName()))     return 200;
            if (item == Items.STICK) return 100;
            if (item == Items.COAL) return 1600;
            if (item == Items.LAVA_BUCKET) return 20000;
            if (item == Item.getItemFromBlock(Blocks.SAPLING)) return 100;
            if (item == Items.BLAZE_ROD) return 2400;
            return net.minecraftforge.fml.common.registry.GameRegistry.getFuelValue(stack);
        }
    }
    
    public static boolean isItemFuel(ItemStack stack){
        return getItemBurnTime(stack) > 0;
    }
    
    /** Do not make give this method the name canInteractWith because it clashes with Container */
    public boolean isUseableByPlayer(EntityPlayer player){
        return this.worldObj.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    }
    
    public void openInventory(EntityPlayer player){
    	
    }
    
    public void closeInventory(EntityPlayer player){
    	
    }
    
    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
    public boolean isItemValidForSlot(int index, ItemStack stack){
    	if(index == 2){
    		return false;
    	}else{
    		return true;
    	}
    }
    
    public int[] getSlotsForFace(EnumFacing side){
        return side == EnumFacing.DOWN ? SLOTS_BOTTOM : (side == EnumFacing.UP ? SLOTS_TOP : SLOTS_SIDES);
    }
    
    /** Returns true if automation can insert the given item in the given slot from the given side. */
    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction){
        return this.isItemValidForSlot(index, itemStackIn);
    }
    
    /** Returns true if automation can extract the given item in the given slot from the given side. */
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction){
        if (direction == EnumFacing.DOWN && index == 1){
            Item item = stack.getItem();
            if (item != Items.WATER_BUCKET && item != Items.BUCKET){
                return false;
            }
        }
        return true;
    }
    
    public String getGuiID(){
        return "acecraft:furnace";
    }
    
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn){
        return new ContainerMillstone(playerInventory, this);
    }
    
    public int getField(int id){
        switch (id){
            case 0: return this.furnaceBurnTime;
            case 1: return this.currentItemBurnTime;
            case 2: return this.cookTime;
            case 3: return this.totalCookTime;
            default:
                return 0;
        }
    }
    
    public void setField(int id, int value){
        switch (id){
            case 0: this.furnaceBurnTime = value; break;
            case 1: this.currentItemBurnTime = value; break;
            case 2: this.cookTime = value; break;
            case 3: this.totalCookTime = value; break;
        }
    }
    
    public int getFieldCount(){
        return 4;
    }
    
    public void clear(){
        for (int i = 0; i < this.itemStacks.length; ++i){
            this.itemStacks[i] = null;
        }
    }
    
    net.minecraftforge.items.IItemHandler handlerTop    = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.UP);
    net.minecraftforge.items.IItemHandler handlerBottom = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.DOWN);
    net.minecraftforge.items.IItemHandler handlerSide   = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.WEST);
    
    @SuppressWarnings("unchecked")
    @Override
    public <T> T getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, net.minecraft.util.EnumFacing facing){
        if (facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
            if (facing == EnumFacing.DOWN)
                return (T) handlerBottom;
            else if (facing == EnumFacing.UP)
                return (T) handlerTop;
            else
                return (T) handlerSide;
        return super.getCapability(capability, facing);
    }
    
    @SideOnly(Side.CLIENT)
    public int getCookProgressScaled(int value){
        return this.cookTime * value / (300-energy);
    }
    
    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int value){
        if (this.currentItemBurnTime == 0){
            this.currentItemBurnTime = 200;
        }
        return energy;
    }
    
    public boolean hasEnergy(){
        return this.energy > 0;
    }
	
	public int getEnergyScaled() {
		return energy / 4;
	}
}