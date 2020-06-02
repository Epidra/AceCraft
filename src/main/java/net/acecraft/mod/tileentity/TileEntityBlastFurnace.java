package net.acecraft.mod.tileentity;

import net.acecraft.mod.block.machina.BlastFurnace;
import net.acecraft.mod.crafting.BlastFurnaceRecipes;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityBlastFurnace extends TileEntity implements ISidedInventory {
	
	private String localizedName;
	private String customName;
	
	private static final int[] slots_top    = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	private static final int[] slots_bottom = new int[]{10};
	private static final int[] slots_side   = new int[]{11};
	
	private ItemStack[] slots = new ItemStack [12];
	
	public static final int furnaceSpeed = 530;
	public              int currentPower;
	public              int currentCookTime;
	public static final int maxPower = 10000;
	
	
	public int burnTime;
	public int currentItemBurnTime;
	public int cookTime;
	
	public void setGuiDisplayName(String displayName){
		this.localizedName = displayName;
	}
	
	public int getMasherProgressedScaled(int i){
		return (currentCookTime * i) / this.furnaceSpeed;
	}
	
	public int getPowerRemainingScaled(int i){
		return (currentPower * i) / maxPower;
	}
	
	private boolean canMash(){
		if(slots[0] == null || slots[1] == null || slots[2] == null || slots[3] == null || slots[4] == null || slots[5] == null || slots[6] == null || slots[7] == null || slots[8] == null || slots[9] == null){
			return false;
		}
		ItemStack itemstack = BlastFurnaceRecipes.getSmeltingResult(slots[0].getItem(), slots[1].getItem(), slots[2].getItem(), slots[3].getItem(), slots[4].getItem(), slots[5].getItem(), slots[6].getItem(), slots[7].getItem(), slots[8].getItem(), slots[9].getItem());
		if(itemstack == null){
			return false;
		}
		if(slots[10] == null){
			return true;
		}
		if(!slots[10].isItemEqual(itemstack)){
			return false;
		}
		if(slots[10].stackSize < getInventoryStackLimit() && slots[10].stackSize < slots[10].getMaxStackSize()){
			return true;
		}else{
			return slots[10].stackSize < itemstack.getMaxStackSize();
		}
	}
	
	private void mashItem(){
		if(canMash()){
			ItemStack itemstack = BlastFurnaceRecipes.getSmeltingResult(slots[0].getItem(), slots[1].getItem(), slots[2].getItem(), slots[3].getItem(), slots[4].getItem(), slots[5].getItem(), slots[6].getItem(), slots[7].getItem(), slots[8].getItem(), slots[9].getItem());
			if(slots[10] == null){
				slots[10] = itemstack.copy();
			}else if(slots[10].isItemEqual(itemstack)){
				slots[10].stackSize += itemstack.stackSize;
			}
			for(int i = 0; i < 10; i++){
				if (slots[i].stackSize <= 0){
					slots[i] = new ItemStack(slots[i].getItem().setFull3D());
				}else{
					slots[i].stackSize--;
				}
				if (slots[i].stackSize <= 0){
					slots[i] = null;
				}
			}
		}
	}
	
	public String getInventoryName(){
		return this.hasCustomInventoryName() ? this.localizedName : "container.blastFurnace";
	}

	public boolean hasCustomInventoryName() {
		return this.localizedName != null && this.localizedName.length() > 0;
	}
	
	public void setCustomName(String name){
		this.customName = name;
	}
	
	public int getSizeInventory(){
		return this.slots.length;
	}

	public ItemStack getStackInSlot(int var1) {
		return this.slots[var1];
	}

	public ItemStack decrStackSize(int var1, int var2) {
		if(this.slots[var1] != null){
			ItemStack itemstack;
			if(this.slots[var1].stackSize <= var2){
				itemstack = this.slots[var1];
				this.slots[var1] = null;
				return itemstack;
			}else{
				itemstack = this.slots[var1].splitStack(var2);
				if(this.slots[var1].stackSize == 0){
					this.slots[var1] = null;
				}
				return itemstack;
			}
		}else{
			return null;
		}
	}

	public ItemStack getStackInSlotOnClosing(int i) {
		if(this.slots[i] != null){
			ItemStack itemstack = this.slots[i];
			this.slots[i] = null;
			return itemstack;
		}
		return null;
	}

	public void setInventorySlotContents(int i, ItemStack itemstack) {
		this.slots[i] = itemstack;
		if(itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()){
			itemstack.stackSize = this.getInventoryStackLimit();
		}
		
	}

	public int getInventoryStackLimit() {
		return 640;
	}

	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : entityplayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	}

	public void openInventory() {}
	public void closeInventory() {}

	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return i == 2 ? false : (i == 1 ? hasItemPower(itemstack) : true);
	}
	
	public boolean hasItemPower(ItemStack itemstack){
		return getItemPower(itemstack) > 0;
	}
	
	private static int getItemPower(ItemStack itemstack){
		if(itemstack == null){
			return 0;
		}else{
			Item item = itemstack.getItem();
			if(item == Items.coal) return 1600;
			return 0;
		}
	}
	
	public static boolean isItemFuel(ItemStack itemstack){
		return getItemBurnTime(itemstack) > 0;
	}

	private static int getItemBurnTime(ItemStack itemstack) {
		if(itemstack == null){
			return 0;
		}else{
			Item item = itemstack.getItem();
			if(item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air){
				Block block = Block.getBlockFromItem(item);
				if(block == Blocks.sapling) return 10;
				if(block == Blocks.coal_block) return 1440;
			}
			if(item  == Items.coal) return 160;
			if(item  == Items.lava_bucket) return 2000;
			if(item  == Items.blaze_rod) return 240;
			return GameRegistry.getFuelValue(itemstack);
			}
	}
	
	public boolean isBurning(){
		return this.burnTime > 0;
	}
	
	public boolean hasPower(){
		return currentPower > 0;
	}
	
	public boolean isMashing(){
		return this.currentCookTime > 0;
	}
	
	public void updateEntity(){
		boolean flag  = this.hasPower();
		boolean flag1 = false;
		
		if(hasPower() && this.isMashing()){
			this.currentPower--;
		}
		if(!worldObj.isRemote){
			if(this.hasItemPower(this.slots[11]) && this.currentPower < (this.maxPower - this.getItemPower(this.slots[11]))){
				this.currentPower += getItemPower(this.slots[11]);
				
				if(this.slots[11] != null){
					flag1 = true;
					this.slots[11].stackSize--;
					if(this.slots[11].stackSize == 0){
						this.slots[11] = this.slots[11].getItem().getContainerItem(this.slots[11]);
					}
				}
			}
			if(hasPower() && canMash()){
				currentCookTime++;
				if(this.currentCookTime == this.furnaceSpeed){
					this.currentCookTime = 0;
					this.mashItem();
					flag1 = true;
					if(!this.canMash()){
						BlastFurnace.updateBlastFurnaceBlockState(this.isMashing(), this.worldObj, this.xCoord, this.yCoord, this.zCoord);
					}
				}
			}else{
				currentCookTime = 0;
			}
			if(this.isMashing()){
				flag1 = true;
				BlastFurnace.updateBlastFurnaceBlockState(this.isMashing(), this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
		}
		if(flag1){
			this.markDirty();
		}
	}
	
	public int[] getAccessibleSlotsFromSide(int var1) {
		return var1 == 0 ? slots_bottom : (var1 == 1 ? slots_top : slots_side);
	}

	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		return this.isItemValidForSlot(i, itemstack);
	}

	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		return j != 0 || i != 1 || itemstack.getItem() == Items.bucket;
	}
	
	public int getBurnTimeRemainingScaled(int i){
		if(this.currentItemBurnTime == 0){
			this.currentItemBurnTime = this.furnaceSpeed;
		}
		return this.burnTime * i / this.currentItemBurnTime;
	}
	
	public int getCookProgressScaled(int i){
		return this.cookTime * i / maxPower;
	}
	
	public void readFromNBT(NBTTagCompound nbt){
		super.readFromNBT(nbt);
		
		NBTTagList list = nbt.getTagList("Items", 10);
		this.slots = new ItemStack[this.getSizeInventory()];
		for(int i = 0; i < list.tagCount(); i++){
			NBTTagCompound compound = (NBTTagCompound) list.getCompoundTagAt(i);
			byte b = compound.getByte("Slot");
			if(b >= 0 && b < this.slots.length){
				this.slots[b] = ItemStack.loadItemStackFromNBT(compound);
			}
		}
		this.currentPower    = (int)nbt.getShort("Power");
		this.currentCookTime = (int)nbt.getShort("CookTime");
		if(nbt.hasKey("CustomName")){
			this.localizedName = nbt.getString("CustomName");
		}
	}
	
	public void writeToNBT(NBTTagCompound nbt){
		super.writeToNBT(nbt);
		nbt.setShort("Power",    (short)this.currentPower);
		nbt.setShort("CookTime", (short)this.currentCookTime);
		NBTTagList list = new NBTTagList();
		for(int i = 0; i < this.slots.length; i++){
			if(this.slots[i] != null){
				NBTTagCompound compound = new NBTTagCompound();
				compound.setByte("Slot", (byte)i);
				this.slots[i].writeToNBT(compound);
				list.appendTag(compound);
			}
		}
		nbt.setTag("Items", list);
		if(this.hasCustomInventoryName()){
			nbt.setString("CustomName", this.localizedName);
		}
	}

}