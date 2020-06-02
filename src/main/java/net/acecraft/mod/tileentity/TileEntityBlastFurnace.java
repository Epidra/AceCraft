package net.acecraft.mod.tileentity;

import javax.annotation.Nullable;

import net.acecraft.mod.blocks.MachinaBlastFurnace;
import net.acecraft.mod.blocks.MachinaCampfire;
import net.acecraft.mod.container.ContainerBlastFurnace;
import net.acecraft.mod.crafting.BlastFurnaceRecipes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.BlockJukebox;
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
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityBrewingStand;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityCommandBlock;
import net.minecraft.tileentity.TileEntityComparator;
import net.minecraft.tileentity.TileEntityDaylightDetector;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityDropper;
import net.minecraft.tileentity.TileEntityEnchantmentTable;
import net.minecraft.tileentity.TileEntityEndGateway;
import net.minecraft.tileentity.TileEntityEndPortal;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.tileentity.TileEntityFlowerPot;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.tileentity.TileEntityHopper;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.tileentity.TileEntityNote;
import net.minecraft.tileentity.TileEntityPiston;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.tileentity.TileEntityStructure;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.walkers.ItemStackDataLists;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityBlastFurnace extends ITileEntityFurnace implements ITickable, IInventory{
	
    /** The ItemStacks that hold the items currently being used in the furnace */
    protected ItemStack[] slots = new ItemStack[12];
    /** Amount of Ticks the current Result is smelting **/
    protected int smeltTimeCurrent;
    /** Ticks he needs to smelt an Ingot **/
    protected int smeltTimeTotal = 500;
    protected int fuel = 0;
    protected int fuelMax = 12500;
    protected int fuelItem = 250;
    
    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory(){
        return this.slots.length;
    }
    
    /**
     * Returns the stack in the given slot.
     */
    @Nullable
    public ItemStack getStackInSlot(int index){
        return this.slots[index];
    }
    
    /**
     * Removes up to a specified number of items from an inventory slot and returns them in a new stack.
     */
    @Nullable
    public ItemStack decrStackSize(int index, int count){
        return ItemStackHelper.getAndSplit(this.slots, index, count);
    }
    
    /**
     * Removes a stack from the given slot and returns it.
     */
    @Nullable
    public ItemStack removeStackFromSlot(int index){
        return ItemStackHelper.getAndRemove(this.slots, index);
    }
    
    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int index, @Nullable ItemStack stack){
        boolean flag = stack != null && stack.isItemEqual(this.slots[index]) && ItemStack.areItemStackTagsEqual(stack, this.slots[index]);
        this.slots[index] = stack;
        if (stack != null && stack.stackSize > this.getInventoryStackLimit()){
            stack.stackSize = this.getInventoryStackLimit();
        }
        if (index == 0 && !flag){
            this.smeltTimeCurrent = 0;
            this.markDirty();
        }
    }
    
    /**
     * Get the name of this object. For players this returns their username
     */
    public String getName(){
        return "container.furnace";
    }
    
    /**
     * Returns true if this thing is named
     */
    public boolean hasCustomName(){
        return false;
    }
    
    public void readFromNBT(NBTTagCompound compound){
    	super.readFromNBT(compound);
    	this.fuel = compound.getInteger("Fuel");
    	this.smeltTimeCurrent = compound.getInteger("SmeltTimeCurrent");
        this.smeltTimeTotal = compound.getInteger("SmeltTimeTotal");
        NBTTagList nbttaglist = compound.getTagList("Items", 10);
        this.slots = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < nbttaglist.tagCount(); ++i){
            NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound.getByte("Slot");
            if (j >= 0 && j < this.slots.length){
                this.slots[j] = ItemStack.loadItemStackFromNBT(nbttagcompound);
            }
        }
    }
    
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
    	super.writeToNBT(compound);
    	compound.setInteger("Fuel", this.fuel);
        compound.setInteger("SmeltTimeCurrent", this.smeltTimeCurrent);
        compound.setInteger("SmeltTimeTotal", this.smeltTimeTotal);
        NBTTagList nbttaglist = new NBTTagList();
        for (int i = 0; i < this.slots.length; ++i){
            if (this.slots[i] != null){
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)i);
                this.slots[i].writeToNBT(nbttagcompound);
                nbttaglist.appendTag(nbttagcompound);
            }
        }
        compound.setTag("Items", nbttaglist);
        return compound;
    }
    
    /**
     * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended.
     */
    public int getInventoryStackLimit(){
        return 64;
    }
    
    /** Furnace isBurning */
    public boolean isBurning(){
        return this.smeltTimeCurrent > 0;
    }
    
    /**
     * Like the old updateEntity(), except more generic.
     */
    public void update(){
    	boolean flag = this.isBurning();
        boolean isDirty = false;
        if (fuel > 0 && smeltTimeCurrent > 0){
            --fuel;
        }
        if (!this.worldObj.isRemote){
        	if(isCoal(slots[10]) && fuel <= (fuelMax-fuelItem)){
        		fuel+=fuelItem;
        		if(slots[10] != null){
        			isDirty = true;
        			this.slots[10].stackSize--;
					if(this.slots[10].stackSize == 0){
						this.slots[10] = this.slots[10].getItem().getContainerItem(this.slots[10]);
					}
        		}
        	}
        	
        	if(fuel > 0 && canSmelt()){
				smeltTimeCurrent++;
				if(smeltTimeCurrent == smeltTimeTotal){
					smeltTimeCurrent = 0;
					smeltItem();
					isDirty = true;
				}
			}else{
				if(smeltTimeCurrent > 0)
					smeltTimeCurrent--;
			}
        }
        if (flag != this.isBurning()){
            MachinaBlastFurnace.setPowerState(this.isBurning(), this.worldObj, this.pos);
        }
        if (isDirty){
            this.markDirty();
        }
    }
    
    private boolean isCoal(ItemStack item){
    	if(item == null) return false;
    	if(item.getItem() == Items.COAL) return true;
    	return false;
    }
    
    /**
     * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canSmelt(){
        if (slots[0] == null || slots[1] == null || slots[2] == null || slots[3] == null || slots[4] == null || slots[5] == null || slots[6] == null || slots[7] == null || slots[8] == null || slots[9] == null){
            return false;
        } else {
            ItemStack itemstack = BlastFurnaceRecipes.instance().getSmeltingResult(slots);
            if (itemstack == null) return false;
            if (this.slots[11] == null) return true;
            if (!this.slots[11].isItemEqual(itemstack)) return false;
            int result = slots[11].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.slots[11].getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
        }
    }
    
    /**
     * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
     */
    public void smeltItem(){
        if (this.canSmelt()){
            ItemStack itemstack = BlastFurnaceRecipes.instance().getSmeltingResult(slots);
            if (this.slots[11] == null){
                this.slots[11] = itemstack.copy();
            } else if (this.slots[11].getItem() == itemstack.getItem()){
                this.slots[11].stackSize += itemstack.stackSize; // Forge BugFix: Results may have multiple items
            }
            for(int i = 0; i < 10; i++){
            	--slots[i].stackSize;
            	if(slots[i].stackSize <= 0)
            		slots[i] = null;
            }
        }
    }
    
    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer player){
        return this.worldObj.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    }
    
    public void openInventory(EntityPlayer player){}
    public void closeInventory(EntityPlayer player){}
    
    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
    public boolean isItemValidForSlot(int index, ItemStack stack){
        if (index == 11){
            return false;
        } else if (index == 10){
            return isCoal(stack);
        } else {
            return true;
        }
    }
    
    /**
     * Returns true if automation can insert the given item in the given slot from the given side.
     */
    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction){
        return this.isItemValidForSlot(index, itemStackIn);
    }
    
    /**
     * Returns true if automation can extract the given item in the given slot from the given side.
     */
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction){
        if (direction == EnumFacing.DOWN && index == 1){
            Item item = stack.getItem();
            if (item != Items.WATER_BUCKET && item != Items.BUCKET){
                return false;
            }
        }
        return true;
    }
    
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn){
        return new ContainerBlastFurnace(playerInventory, this);
    }
    
    public int getField(int id){
        switch (id){
            case 0: return this.fuel;
            case 1: return this.fuelMax;
            case 2: return this.smeltTimeCurrent;
            case 3: return this.smeltTimeTotal;
            default: return 0;
        }
    }
    
    public void setField(int id, int value){
        switch (id){
            case 0: this.fuel = value; break;
            case 1: this.fuelMax = value; break;
            case 2: this.smeltTimeCurrent = value; break;
            case 3: this.smeltTimeTotal = value;
        }
    }
    
    public int getFieldCount(){
        return 4;
    }
    
    public void clear(){
        for (int i = 0; i < this.slots.length; ++i){
            this.slots[i] = null;
        }
    }
}