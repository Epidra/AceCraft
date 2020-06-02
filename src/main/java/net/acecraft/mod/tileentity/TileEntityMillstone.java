package net.acecraft.mod.tileentity;

import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.crafting.MillstoneRecipes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityMillstone extends TileEntity implements ISidedInventory {
	
	private static final int[] slotsTop    = new int[] {0};
    private static final int[] slotsBottom = new int[] {1};
    private static final int[] slotsSides  = new int[] {1};
    private ItemStack[] itemStacks = new ItemStack[2];
    public int burnTime;
    public int currentItemBurnTime;
    public int cookTime;
    private String field;
    public int meta;
    public int energy = 0;
    
    public int getSizeInventory(){
        return this.itemStacks.length;
    }
    
    public ItemStack getStackInSlot(int slot){
        return this.itemStacks[slot];
    }
    
    public ItemStack decrStackSize(int slot, int value){
        if (this.itemStacks[slot] != null){
            ItemStack itemstack;
            if (this.itemStacks[slot].stackSize <= value){
                itemstack = this.itemStacks[slot];
                this.itemStacks[slot] = null;
                return itemstack;
            }else{
                itemstack = this.itemStacks[slot].splitStack(value);
                if (this.itemStacks[slot].stackSize == 0){
                    this.itemStacks[slot] = null;
                }
                return itemstack;
            }
        }else{
            return null;
        }
    }
    
    public ItemStack getStackInSlotOnClosing(int slot){
        if (this.itemStacks[slot] != null){
            ItemStack itemstack = this.itemStacks[slot];
            this.itemStacks[slot] = null;
            return itemstack;
        }else{
            return null;
        }
    }
    
    public void setInventorySlotContents(int slot, ItemStack stack){
        this.itemStacks[slot] = stack;
        if (stack != null && stack.stackSize > this.getInventoryStackLimit()){
            stack.stackSize = this.getInventoryStackLimit();
        }
    }
    
    public String getInventoryName(){
        return this.hasCustomInventoryName() ? this.field : "container.millstone";
    }
    
    public boolean hasCustomInventoryName(){
        return this.field != null && this.field.length() > 0;
    }
    
    public void func_145951_a(String p_145951_1_){
        this.field = p_145951_1_;
    }
    
    public void readFromNBT(NBTTagCompound nbt){
        super.readFromNBT(nbt);
        NBTTagList nbttaglist = nbt.getTagList("Items", 10);
        this.itemStacks = new ItemStack[this.getSizeInventory()];
        for (int i = 0; i < nbttaglist.tagCount(); ++i){
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");
            if (b0 >= 0 && b0 < this.itemStacks.length){
                this.itemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }
        this.meta     = nbt.getShort("meta");
        this.energy   = nbt.getShort("energy");
        this.burnTime = nbt.getShort("BurnTime");
        this.cookTime = nbt.getShort("CookTime");
        if (nbt.hasKey("CustomName", 8)){
            this.field = nbt.getString("CustomName");
        }
    }
    
    public void writeToNBT(NBTTagCompound nbt){
        super.writeToNBT(nbt);
        nbt.setShort("meta",     (short)this.meta);
        nbt.setShort("energy",   (short)this.energy);
        nbt.setShort("BurnTime", (short)this.burnTime);
        nbt.setShort("CookTime", (short)this.cookTime);
        NBTTagList nbttaglist = new NBTTagList();
        for (int i = 0; i < this.itemStacks.length; ++i){
            if (this.itemStacks[i] != null){
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.itemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }
        nbt.setTag("Items", nbttaglist);
        if (this.hasCustomInventoryName()){
            nbt.setString("CustomName", this.field);
        }
    }
    
    public int getInventoryStackLimit(){
        return 64;
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
    
    public void updateEntity(){
        boolean flag = this.burnTime > 0;
        boolean flag1 = false;
        if(worldObj.getBlock(xCoord, yCoord+3, zCoord) == ShopKeeper.machinaAxle){
			TileEntityAxle entityA = (TileEntityAxle) worldObj.getTileEntity(xCoord, yCoord+3, zCoord);
			energy = entityA.energy;
		}else
		if(worldObj.getBlock(xCoord, yCoord+3, zCoord) == ShopKeeper.machinaGearBox){
			TileEntityGearBox entityG = (TileEntityGearBox) worldObj.getTileEntity(xCoord, yCoord+3, zCoord);
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
    
    private boolean canSmelt(){
        if (this.itemStacks[0] == null){
            return false;
        }else{
            ItemStack itemstack = MillstoneRecipes.smelting().getSmeltingResult(this.itemStacks[0]);
            if (itemstack == null) return false;
            if (this.itemStacks[1] == null) return true;
            if (!this.itemStacks[1].isItemEqual(itemstack)) return false;
            int result = itemStacks[1].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.itemStacks[1].getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
        }
    }
    
    public void smeltItem(){
        if (this.canSmelt()){
            ItemStack itemstack = MillstoneRecipes.smelting().getSmeltingResult(this.itemStacks[0]);
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
    
    public boolean isUseableByPlayer(EntityPlayer player){
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }
    
    public void openInventory() {}
    public void closeInventory() {}
    
    public boolean isItemValidForSlot(int slot, ItemStack stack){
    	if(slot == 2){
    		return false;
    	}else{
    		return true;
    	}
    }
    
    public int[] getAccessibleSlotsFromSide(int slot){
        return slot == 0 ? slotsBottom : (slot == 1 ? slotsTop : slotsSides);
    }
    
    public boolean canInsertItem(int slot, ItemStack stack, int side){
        return this.isItemValidForSlot(slot, stack);
    }
    
    public boolean canExtractItem(int slot, ItemStack stack, int side){
        return side != 0 || slot != 1 || stack.getItem() == Items.bucket;
    }
    
	public void firstSetUp(int l, int e) {
		meta = l;
		energy = e;	
	}
	
	public int getEnergyScaled() {
		return energy / 4;
	}

}