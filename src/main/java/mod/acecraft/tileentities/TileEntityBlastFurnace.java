package mod.acecraft.tileentities;

import javax.annotation.Nullable;

import mod.acecraft.blocks.MachinaBlastFurnace;
import mod.acecraft.container.ContainerBlastFurnace;
import mod.acecraft.crafting.BlastFurnaceRecipes;
import mod.shared.tileentities.ITileEntityFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

public class TileEntityBlastFurnace extends ITileEntityFurnace implements ITickable, IInventory {
	
    /** Amount of Ticks the current Result is smelting **/
    protected int smeltTimeCurrent;
    /** Ticks he needs to smelt an Ingot **/
    protected int smeltTimeTotal = 500;
    protected int fuel = 0;
    protected int fuelMax = 12500;
    protected int fuelItem = 250;
    
    public TileEntityBlastFurnace() {
    	super(12);
    }
    
    /**
     * Returns the number of inventory in the inventory.
     */
    public int getSizeInventory(){
        return inventory.size();
    }
    
    /**
     * Returns the stack in the given slot.
     */
    @Nullable
    public ItemStack getStackInSlot(int index){
        return inventory.get(index);
    }
    
    /**
     * Removes up to a specified number of items from an inventory slot and returns them in a new stack.
     */
    @Nullable
    public ItemStack decrStackSize(int index, int count){
        return ItemStackHelper.getAndSplit(inventory, index, count);
    }
    
    /**
     * Removes a stack from the given slot and returns it.
     */
    @Nullable
    public ItemStack removeStackFromSlot(int index){
        return ItemStackHelper.getAndRemove(inventory, index);
    }
    
    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    /*public void setInventorySlotContents(int index, @Nullable ItemStack stack){
        boolean flag = stack != null && stack.isItemEqual(inventory.get(index)) && ItemStack.areItemStackTagsEqual(stack, inventory.get(index));
        inventory.get(index).item = stack;
        if (stack != null && stack.getCount() > this.getInventoryStackLimit()){
            stack.setCount(this.getInventoryStackLimit());
        }
        if (index == 0 && !flag){
            this.smeltTimeCurrent = 0;
            this.markDirty();
        }
    }*/
    
    /**
     * Get the name of this object. For players this returns their username
     */
    public String getName(){
        return "container.blastfurnace";
    }
    
    /**
     * Returns true if this thing is named
     */
    public boolean hasCustomName(){
        return false;
    }
    
    /*public void readFromNBT(NBTTagCompound compound){
    	super.readFromNBT(compound);
    	this.fuel = compound.getInteger("Fuel");
    	this.smeltTimeCurrent = compound.getInteger("SmeltTimeCurrent");
        this.smeltTimeTotal = compound.getInteger("SmeltTimeTotal");
        NBTTagList nbttaglist = compound.getTagList("Items", 10);
        inventory = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < nbttaglist.tagCount(); ++i){
            NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound.getByte("Slot");
            if (j >= 0 && j < inventory.length){
                inventory[j] = ItemStack.loadItemStackFromNBT(nbttagcompound);
            }
        }
    }
    
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
    	super.writeToNBT(compound);
    	compound.setInteger("Fuel", this.fuel);
        compound.setInteger("SmeltTimeCurrent", this.smeltTimeCurrent);
        compound.setInteger("SmeltTimeTotal", this.smeltTimeTotal);
        NBTTagList nbttaglist = new NBTTagList();
        for (int i = 0; i < inventory.length; ++i){
            if (inventory[i] != null){
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)i);
                inventory[i].writeToNBT(nbttagcompound);
                nbttaglist.appendTag(nbttagcompound);
            }
        }
        compound.setTag("Items", nbttaglist);
        return compound;
    }*/
    
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
        if (!this.world.isRemote){
        	if(isCoal(inventory.get(10)) && fuel <= (fuelMax-fuelItem)){
        		fuel+=fuelItem;
        		if(inventory.get(10) != null){
        			isDirty = true;
        			inventory.get(10).shrink(1);
					if(inventory.get(10).getMaxStackSize() == 0){
						inventory.set(10, inventory.get(10).getItem().getContainerItem(inventory.get(10)));
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
            MachinaBlastFurnace.setPowerState(this.isBurning(), this.world, this.pos);
        }
        if (isDirty){
            this.markDirty();
        }
    }
    
    private boolean isCoal(ItemStack item){
    	if(item == null) return false;
        return item.getItem() == Items.COAL;
    }
    
    /**
     * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canSmelt(){
        if (inventory.get(0) == null || inventory.get(1) == null || inventory.get(2) == null || inventory.get(3) == null || inventory.get(4) == null || inventory.get(5) == null || inventory.get(6) == null || inventory.get(7) == null || inventory.get(8) == null || inventory.get(9) == null){
            return false;
        } else {
            ItemStack itemstack = BlastFurnaceRecipes.instance().getSmeltingResult(inventory);
            if (itemstack == null) return false;
            if (inventory.get(11) == null) return true;
            if (!inventory.get(11).isItemEqual(itemstack)) return false;
            int result = inventory.get(11).getMaxStackSize() + itemstack.getMaxStackSize();
            return result <= getInventoryStackLimit() && result <= inventory.get(11).getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
        }
    }
    
    /**
     * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
     */
    public void smeltItem(){
        if (this.canSmelt()){
            ItemStack itemstack = BlastFurnaceRecipes.instance().getSmeltingResult(inventory);
            if (inventory.get(11) == null){
                inventory.set(11, itemstack);
            } else if (inventory.get(11).getItem() == itemstack.getItem()){
                inventory.get(11).grow(itemstack.getCount()); // Forge BugFix: Results may have multiple items
            }
            for(int i = 0; i < 10; i++){
            	inventory.get(i).shrink(1);
            	if(inventory.get(i).getCount() <= 0)
            		inventory.set(i, null);
            }
        }
    }
    
    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer player){
        return this.world.getTileEntity(this.pos) == this && player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
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
            return item == Items.WATER_BUCKET || item == Items.BUCKET;
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
        for (int i = 0; i < inventory.size(); ++i){
            inventory.set(i, null);
        }
    }
	
}
