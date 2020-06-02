package net.acecraft.mod.tileentity;

import javax.annotation.Nullable;

import net.acecraft.mod.blocks.MachinaDestille;
import net.acecraft.mod.container.ContainerDistillery;
import net.acecraft.mod.crafting.DistilleryRecipes;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
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
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.walkers.ItemStackDataLists;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityDistillery extends ITileEntityFurnace implements ITickable, IInventory{
	
    /** The ItemStacks that hold the items currently being used in the furnace */
    public ItemStack[] furnaceItemStacks = new ItemStack[4];
    
    /** Returns the number of slots in the inventory. */
    public int getSizeInventory(){
        return this.furnaceItemStacks.length;
    }
    
    /** Returns the stack in the given slot. */
    @Nullable
    public ItemStack getStackInSlot(int index){
        return this.furnaceItemStacks[index];
    }
    
    /** Removes up to a specified number of items from an inventory slot and returns them in a new stack. */
    @Nullable
    public ItemStack decrStackSize(int index, int count){
        return ItemStackHelper.getAndSplit(this.furnaceItemStacks, index, count);
    }
    
    /** Removes a stack from the given slot and returns it. */
    @Nullable
    public ItemStack removeStackFromSlot(int index){
        return ItemStackHelper.getAndRemove(this.furnaceItemStacks, index);
    }
    
    /** Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections). */
    public void setInventorySlotContents(int index, @Nullable ItemStack stack){
        boolean flag = stack != null && stack.isItemEqual(this.furnaceItemStacks[index]) && ItemStack.areItemStackTagsEqual(stack, this.furnaceItemStacks[index]);
        this.furnaceItemStacks[index] = stack;
        if (stack != null && stack.stackSize > this.getInventoryStackLimit()){
            stack.stackSize = this.getInventoryStackLimit();
        }
        if (index == 0 && !flag){
            this.totalCookTime = this.getCookTime(stack);
            this.cookTime = 0;
            this.markDirty();
        }
    }
    
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        this.furnaceBurnTime = compound.getInteger("BurnTime");
        this.cookTime = compound.getInteger("CookTime");
        this.totalCookTime = compound.getInteger("CookTimeTotal");
        this.currentItemBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);
        NBTTagList nbttaglist = compound.getTagList("Items", 10);
        this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < nbttaglist.tagCount(); ++i){
            NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound.getByte("Slot");
            if (j >= 0 && j < this.furnaceItemStacks.length){
                this.furnaceItemStacks[j] = ItemStack.loadItemStackFromNBT(nbttagcompound);
            }
        }
    }
    
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        super.writeToNBT(compound);
        compound.setInteger("BurnTime", this.furnaceBurnTime);
        compound.setInteger("CookTime", this.cookTime);
        compound.setInteger("CookTimeTotal", this.totalCookTime);
        NBTTagList nbttaglist = new NBTTagList();
        for (int i = 0; i < this.furnaceItemStacks.length; ++i){
            if (this.furnaceItemStacks[i] != null){
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)i);
                this.furnaceItemStacks[i].writeToNBT(nbttagcompound);
                nbttaglist.appendTag(nbttagcompound);
            }
        }
        compound.setTag("Items", nbttaglist);
        return compound;
    }
    
    /**
     * Like the old updateEntity(), except more generic.
     */
    public void update(){
        boolean flag = this.isBurning();
        boolean flag1 = false;
        if (this.isBurning()){
            --this.furnaceBurnTime;
        }
        if (!this.worldObj.isRemote){
            if (this.isBurning() || this.furnaceItemStacks[1] != null && this.furnaceItemStacks[0] != null){
                if (!this.isBurning() && this.canSmelt()){
                    this.furnaceBurnTime = getItemBurnTime(this.furnaceItemStacks[2]);
                    this.currentItemBurnTime = this.furnaceBurnTime;
                    if (this.isBurning()){
                        flag1 = true;
                        if (this.furnaceItemStacks[2] != null){
                            --this.furnaceItemStacks[2].stackSize;
                            if (this.furnaceItemStacks[2].stackSize == 0){
                                this.furnaceItemStacks[2] = furnaceItemStacks[1].getItem().getContainerItem(furnaceItemStacks[1]);
                            }
                        }
                    }
                }
                if (this.isBurning() && this.canSmelt()){
                    ++this.cookTime;
                    if (this.cookTime == this.totalCookTime){
                        this.cookTime = 0;
                        this.totalCookTime = this.getCookTime(this.furnaceItemStacks[0]);
                        this.smeltItem();
                        flag1 = true;
                    }
                } else {
                    this.cookTime = 0;
                }
            } else if (!this.isBurning() && this.cookTime > 0){
                this.cookTime = MathHelper.clamp_int(this.cookTime - 2, 0, this.totalCookTime);
            }
            if (flag != this.isBurning()){
                flag1 = true;
                MachinaDestille.setPowerState(this.isBurning(), this.worldObj, this.pos);
            }
        }
        if (flag1){
            this.markDirty();
        }
    }
    
    /**
     * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canSmelt(){
        if (this.furnaceItemStacks[0] == null || this.furnaceItemStacks[1] == null || this.furnaceItemStacks[0].getItem() != Items.GLASS_BOTTLE){
            return false;
        } else {
            ItemStack itemstack = DistilleryRecipes.instance().getSmeltingResult(this.furnaceItemStacks[1]);
            if (itemstack == null) return false;
            if (this.furnaceItemStacks[3] == null) return true;
            if (!this.furnaceItemStacks[3].isItemEqual(itemstack)) return false;
            int result = furnaceItemStacks[3].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.furnaceItemStacks[3].getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
        }
    }
    
    /**
     * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
     */
    public void smeltItem(){
        if (this.canSmelt()){
            ItemStack itemstack = DistilleryRecipes.instance().getSmeltingResult(this.furnaceItemStacks[1]);
            if (this.furnaceItemStacks[3] == null){
                this.furnaceItemStacks[3] = itemstack.copy();
            } else if (this.furnaceItemStacks[3].getItem() == itemstack.getItem()){
                this.furnaceItemStacks[3].stackSize += itemstack.stackSize; // Forge BugFix: Results may have multiple items
            }
            --this.furnaceItemStacks[0].stackSize;
            if (this.furnaceItemStacks[0].stackSize <= 0){
                this.furnaceItemStacks[0] = null;
            }
            --this.furnaceItemStacks[1].stackSize;
            if (this.furnaceItemStacks[1].stackSize <= 0){
                this.furnaceItemStacks[1] = null;
            }
        }
    }
    
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn){
        return new ContainerDistillery(playerInventory, this);
    }
    
    public void clear(){
        for (int i = 0; i < this.furnaceItemStacks.length; ++i){
            this.furnaceItemStacks[i] = null;
        }
    }
}