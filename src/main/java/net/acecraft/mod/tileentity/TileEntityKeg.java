package net.acecraft.mod.tileentity;

import net.acecraft.mod.ShopKeeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityKeg extends TileEntity implements ITickable, IInventory {
	
    private ItemStack[] itemStacks = new ItemStack[2];
    public String content = "empty";
    public int fillingLevel;
    public int fillingMax = 25;
    public int fermentCurrent;
    public int fermentMax = 20;
    
    public int getSizeInventory(){
        return this.itemStacks.length;
    }
    
    public ItemStack getStackInSlot(int slot){
        return this.itemStacks[slot];
    }
    
    private boolean Fermentable(){
    	if(0 == content.compareTo("Milk")) return true;
    	if(0 == content.compareTo("Apple")) return true;
    	if(0 == content.compareTo("Grapes")) return true;
    	if(0 == content.compareTo("Cherry")) return true;
    	if(0 == content.compareTo("Pineapple")) return true;
    	return false;
    }
    
    public void update() {
    	boolean flag1 = false;
        if(!this.worldObj.isRemote){
            flag1 = this.UpdateContent();
            if(fillingLevel == fillingMax){
            	if(Fermentable()){
            		fermentCurrent++;
            	}
            }else{
            	fermentCurrent = 0;
            }
            if(fermentCurrent == fermentMax){
            	if(0 == content.compareTo("Milk"))        content = "Cheese";
            	if(0 == content.compareTo("Apple"))       content = "Cider";
            	if(0 == content.compareTo("Grapes"))      content = "WineGrapes";
            	if(0 == content.compareTo("Cherry"))      content = "WineCherry";
            	if(0 == content.compareTo("Pineapple"))   content = "WinePineapple";
            }
        }
        if (flag1){
            this.markDirty();
        }
	}
    
    public void readFromNBT(NBTTagCompound compound){
        super.readFromNBT(compound);
        this.content        = compound.getString("content");
        this.fillingLevel   = compound.getShort("fillingLevel");
        this.fermentCurrent = compound.getShort("fermentCurrent");
        NBTTagList nbttaglist = compound.getTagList("Items", 2);
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
        compound.setString("content",      (String)this.content);
        compound.setShort("fillingLevel",   (short)this.fillingLevel);
        compound.setShort("fermentCurrent", (short)this.fermentCurrent);
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
    
    public int getInventoryStackLimit(){
        return 64;
    }
    
    @SideOnly(Side.CLIENT)
    public String getContent(){
        return content;
    }
    
    @SideOnly(Side.CLIENT)
    public int getFillingLevel(){
        return fillingLevel * 3;
    }
    
    @SideOnly(Side.CLIENT)
    public int getFermentCurrent(int i){
        return fermentCurrent;
    }
    
    private String GetStringFromBottle(Item item){
    	if(item == new ItemStack(Items.POTIONITEM,1,0).getItem()) return "Water";
		if(item == ShopKeeper.juiceOil)         return "Oil";
		if(item == ShopKeeper.juiceApple)       return "Apple";
		if(item == ShopKeeper.juiceBanana)      return "Banana";
		if(item == ShopKeeper.juiceCherries)    return "Cherry";
		if(item == ShopKeeper.juiceGrapes)      return "Grapes";
		if(item == ShopKeeper.juiceLemon)       return "Lemon";
		if(item == ShopKeeper.juiceMilk)        return "Milk";
		if(item == ShopKeeper.juiceOrange)      return "Orange";
		if(item == ShopKeeper.juicePeach)       return "Peach";
		if(item == ShopKeeper.juicePineapple)   return "Pinapple";
		if(item == ShopKeeper.liquorCider)      return "Cider";
		if(item == ShopKeeper.liquorRum)        return "Rum";
		if(item == ShopKeeper.liquorBeer)       return "Beer";
		if(item == ShopKeeper.liquorSalgam)     return "Salgam";
		if(item == ShopKeeper.liquorVodka)      return "Vodka";
		if(item == ShopKeeper.liquorSake)       return "Sake";
		if(item == ShopKeeper.liquorMead)       return "Mead";
		if(item == ShopKeeper.liquorWineGrapes) return "WineGrapes";
		if(item == ShopKeeper.liquorWineCherry) return "WineCherry";
		if(item == ShopKeeper.liquorWinePines)  return "WinePineapple";
    	return "";
    }
    
    private String GetStringFromBucket(Item item){
		//if(item == Items.BUCKET)                return "empty";
		if(item == Items.MILK_BUCKET)           return "Milk";
		if(item == Items.WATER_BUCKET)          return "Water";
    	return "";
    }
    
    private int validInput(Item item){
    	if(0 == content.compareTo("empty")){
    		if("" != GetStringFromBottle(item)) return 2;
        	if("" != GetStringFromBucket(item)) return 1;
    	} else {
    		if(0 == content.compareTo(GetStringFromBottle(item))) return 2;
        	if(0 == content.compareTo(GetStringFromBucket(item))) return 1;	
    	}
    	return 0;
    }
    
    private Item GetFilledBucket(){
    	if(content == "Milk")  return Items.MILK_BUCKET;
    	if(content == "Water") return Items.WATER_BUCKET;
    	return null;
    }
    
    private Item GetFilledBottle(){
    	if(0 == content.compareTo("Water")) return new ItemStack(Items.POTIONITEM,1,0).getItem();
    	if(0 == content.compareTo("Oil")) return ShopKeeper.juiceOil;
    	if(0 == content.compareTo("Apple")) return ShopKeeper.juiceApple;
    	if(0 == content.compareTo("Banana")) return ShopKeeper.juiceBanana;
    	if(0 == content.compareTo("Cherry")) return ShopKeeper.juiceCherries;
    	if(0 == content.compareTo("Grapes")) return ShopKeeper.juiceGrapes;
    	if(0 == content.compareTo("Lemon")) return ShopKeeper.juiceLemon;
    	if(0 == content.compareTo("Milk")) return ShopKeeper.juiceMilk;
    	if(0 == content.compareTo("Orange")) return ShopKeeper.juiceOrange;
    	if(0 == content.compareTo("Peach")) return ShopKeeper.juicePeach;
    	if(0 == content.compareTo("Pineapple")) return ShopKeeper.juicePineapple;
    	if(0 == content.compareTo("Cider")) return ShopKeeper.liquorCider;
    	if(0 == content.compareTo("Rum")) return ShopKeeper.liquorRum;
    	if(0 == content.compareTo("Beer")) return ShopKeeper.liquorBeer;
    	if(0 == content.compareTo("Salgam")) return ShopKeeper.liquorSalgam;
    	if(0 == content.compareTo("Vodka")) return ShopKeeper.liquorVodka;
    	if(0 == content.compareTo("Sake")) return ShopKeeper.liquorSake;
    	if(0 == content.compareTo("Mead")) return ShopKeeper.liquorMead;
    	if(0 == content.compareTo("WineGrapes")) return ShopKeeper.liquorWineGrapes;
    	if(0 == content.compareTo("WineCherry")) return ShopKeeper.liquorWineCherry;
    	if(0 == content.compareTo("WinePineapple")) return ShopKeeper.liquorWinePines;
    	return null;
    }
    
    public boolean UpdateContent(){
    	if(this.itemStacks[0] != null){
    		if(1 == validInput(itemStacks[0].getItem()) && fillingLevel <= fillingMax-3){ // Valid Bucket
    			if(itemStacks[1] == null){
    				itemStacks[1] = new ItemStack(Items.BUCKET);
    			} else {
    				itemStacks[1].stackSize++;
    			}
    			content = GetStringFromBucket(itemStacks[0].getItem());
    			itemStacks[0].stackSize--;
    			if(itemStacks[0].stackSize == 0) itemStacks[0] = null;
    			fillingLevel += 3;
    			return true;
    		}
    		if(2 == validInput(itemStacks[0].getItem()) && fillingLevel <= fillingMax-1){ // Valid Bottle
    			if(itemStacks[1] == null){
    				itemStacks[1] = new ItemStack(Items.GLASS_BOTTLE);
    			} else {
    				itemStacks[1].stackSize++;
    			}
    			content = GetStringFromBottle(itemStacks[0].getItem());
    			itemStacks[0].stackSize--;
    			if(itemStacks[0].stackSize == 0) itemStacks[0] = null;
    			fillingLevel += 1;
    			return true;
    		}
    		if(0 != content.compareTo("empty")){
    			if(itemStacks[0].getItem() == Items.BUCKET){
    				if(fillingLevel >= 3){
    					Item temp = GetFilledBucket();
    					if(temp == null) return false;
    					if(itemStacks[1] == null){
    						itemStacks[1] = new ItemStack(temp);
    						itemStacks[0].stackSize--;
        	    			if(itemStacks[0].stackSize == 0) itemStacks[0] = null;
        	    			fillingLevel -= 3;
        	    			if(fillingLevel == 0) content = "empty";
        	    			return true;
    					} else if(itemStacks[1].getItem() == temp && itemStacks[1].stackSize + 1 <= itemStacks[1].getItem().getItemStackLimit()){
    						itemStacks[1].stackSize++;
    						itemStacks[0].stackSize--;
        	    			if(itemStacks[0].stackSize == 0) itemStacks[0] = null;
        	    			fillingLevel -= 3;
        	    			if(fillingLevel == 0) content = "empty";
        	    			return true;
    					} else {
    						return false;
    					}
    				}
    			}
    			if(itemStacks[0].getItem() == Items.GLASS_BOTTLE){
    				if(fillingLevel >= 1){
    					Item temp = GetFilledBottle();
    					if(temp == null) return false;
    					if(itemStacks[1] == null){
    						itemStacks[1] = new ItemStack(temp);
    						itemStacks[0].stackSize--;
        	    			if(itemStacks[0].stackSize == 0) itemStacks[0] = null;
        	    			fillingLevel -= 1;
        	    			if(fillingLevel == 0) content = "empty";
        	    			return true;
    					} else if(itemStacks[1].getItem() == temp && itemStacks[1].stackSize + 1 <= itemStacks[1].getItem().getItemStackLimit()){
    						itemStacks[1].stackSize++;
    						itemStacks[0].stackSize--;
        	    			if(itemStacks[0].stackSize == 0) itemStacks[0] = null;
        	    			fillingLevel -= 1;
        	    			if(fillingLevel == 0) content = "empty";
        	    			return true;
    					} else {
    						return false;
    					}
    				}
    			}
    		}
    	}
        return false;
    }
    
    public Item ChangeContent(Item input){
    	if(input != null){
    		if(1 == validInput(input) && fillingLevel <= fillingMax-3){ // Valid Bucket
    			content = GetStringFromBucket(input);
    			fillingLevel += 3;
    			return Items.BUCKET;
    		}
    		if(2 == validInput(input) && fillingLevel <= fillingMax-1){ // Valid Bottle
    			content = GetStringFromBottle(input);
    			fillingLevel += 1;
    			return Items.GLASS_BOTTLE;
    		}
    		if(0 != content.compareTo("empty")){
    			if(input == Items.BUCKET){
    				Item output = GetFilledBucket();
    				if(output != null && fillingLevel >= 3){
    					fillingLevel -= 3;
    	    			if(fillingLevel == 0) content = "empty";
    	    			return output;
    				} else {
    					return null;
    				}
    				
    			}
    			if(input == Items.GLASS_BOTTLE){
    				if(fillingLevel >= 1){
    					Item output = GetFilledBottle();
    					if(output != null){
    						fillingLevel -= 1;
        	    			if(fillingLevel == 0) content = "empty";
    					}
    	    			return output;
    				}
    			}
    		}
    	}
        return null;
    }

	@Override
	public String getName() {
		return "acecraft:furnace";
	}

	@Override
	public boolean hasCustomName() {
		return false;
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		return ItemStackHelper.getAndSplit(this.itemStacks, index, count);
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		return ItemStackHelper.getAndRemove(this.itemStacks, index);
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		boolean flag = stack != null && stack.isItemEqual(this.itemStacks[index]) && ItemStack.areItemStackTagsEqual(stack, this.itemStacks[index]);
        this.itemStacks[index] = stack;
        if (stack != null && stack.stackSize > this.getInventoryStackLimit()){
            stack.stackSize = this.getInventoryStackLimit();
        }
        if (index == 0 && !flag){
            //this.totalCookTime = this.getCookTime(stack);
            //this.cookTime = 0;
            this.markDirty();
        }
		
	}

	/** Do not make give this method the name canInteractWith because it clashes with Container */
    public boolean isUseableByPlayer(EntityPlayer player){
        return this.worldObj.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    }

	@Override
	public void openInventory(EntityPlayer player) {
		
	}

	@Override
	public void closeInventory(EntityPlayer player) {
		
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return true;
	}

	@Override
	public int getField(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		for (int i = 0; i < this.itemStacks.length; ++i){
            this.itemStacks[i] = null;
        }
	}

}