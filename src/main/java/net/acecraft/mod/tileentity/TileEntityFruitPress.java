package net.acecraft.mod.tileentity;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityFruitPress extends TileEntity implements ISidedInventory {
	
	private static final int[] slotsTop    = new int[] {0};
    private static final int[] slotsBottom = new int[] {1};
    private static final int[] slotsSides  = new int[] {1};
    private ItemStack[] itemStacks = new ItemStack[3];
    public int burnTime;
    public int currentItemBurnTime;
    public int cookTime;
    private String field;
    public int meta;
    public int energy;
    public String content;
    public int fillingLevel;
    
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
        return this.hasCustomInventoryName() ? this.field : "container.fruitpress";
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
        this.meta         = nbt.getShort("meta");
        this.energy       = nbt.getShort("energy");
        this.burnTime     = nbt.getShort("BurnTime");
        this.cookTime     = nbt.getShort("CookTime");
        this.content      = nbt.getString("Content");
        this.fillingLevel = nbt.getShort("FillingLevel");
        if (nbt.hasKey("CustomName", 8)){
            this.field = nbt.getString("CustomName");
        }
    }
    
    public void writeToNBT(NBTTagCompound nbt){
        super.writeToNBT(nbt);
        nbt.setShort("meta",         (short)this.meta);
        nbt.setShort("energy",       (short)this.energy);
        nbt.setShort("BurnTime",     (short)this.burnTime);
        nbt.setShort("CookTime",     (short)this.cookTime);
        nbt.setString("Content",    (String)this.content);
        nbt.setShort("FillingLevel", (short)this.fillingLevel);
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
    public int getCookProgressScaled(){
        return (this.cookTime - energy) / 3;
    }
    
    @SideOnly(Side.CLIENT)
    public int getEnergyScaled(){
        return energy / 4;
    }
    
    public boolean hasEnergy(){
        return this.energy > 0;
    }
    
    public void updateEntity(){
        boolean flag1 = false;
        if(worldObj.getBlock(xCoord, yCoord+2, zCoord) == ShopKeeper.machinaAxle){
			TileEntityAxle entityA = (TileEntityAxle) worldObj.getTileEntity(xCoord, yCoord+2, zCoord);
			energy = entityA.energy;
		}else
		if(worldObj.getBlock(xCoord, yCoord+2, zCoord) == ShopKeeper.machinaGearBox){
			TileEntityGearBox entityG = (TileEntityGearBox) worldObj.getTileEntity(xCoord, yCoord+2, zCoord);
			energy = entityG.energy;
		}else{
			energy = 0;
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
        	if(fillingLevel > 4 && itemStacks[1] != null){
        		Item temp = changeBucket(itemStacks[1].getItem(), content);
        		if(itemStacks[1].getItem() != temp){
        			if(itemStacks[2] == null){
        				itemStacks[2] = new ItemStack(temp);
        				--this.itemStacks[1].stackSize;
        				if (this.itemStacks[1].stackSize <= 0) this.itemStacks[1] = null;
        				fillingLevel = fillingLevel - 5;
        				if(fillingLevel == 0) content = "empty";
        				flag1 = true;
        			}else
        			if(itemStacks[2].getItem() == temp && itemStacks[2].isStackable() && itemStacks[2].stackSize < 64){
        				++this.itemStacks[2].stackSize;
        				--this.itemStacks[1].stackSize;
        				if (this.itemStacks[1].stackSize <= 0) this.itemStacks[1] = null;
        				fillingLevel = fillingLevel - 5;
        				if(fillingLevel == 0) content = "empty";
        				flag1 = true;
        			}
        		}
        	}
        	if(fillingLevel > 0 && itemStacks[1] != null){
        		Item temp = changeBottle(itemStacks[1].getItem(), content);
        		if(itemStacks[1].getItem() != temp){
        			if(itemStacks[2] == null){
        				itemStacks[2] = new ItemStack(temp);
        				--this.itemStacks[1].stackSize;
        				if (this.itemStacks[1].stackSize <= 0) this.itemStacks[1] = null;
        				fillingLevel = fillingLevel - 1;
        				if(fillingLevel == 0) content = "empty";
        				flag1 = true;
        			}else
        			if(itemStacks[2].getItem() == temp && itemStacks[2].isStackable() && itemStacks[2].stackSize < 64){
        				++this.itemStacks[2].stackSize;
        				--this.itemStacks[1].stackSize;
        				if (this.itemStacks[1].stackSize <= 0) this.itemStacks[1] = null;
        				fillingLevel = fillingLevel - 1;
        				if(fillingLevel == 0) content = "empty";
        				flag1 = true;
        			}
        		}
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
        	if((0 == content.compareTo("Oil")         || 0 == content.compareTo("empty")) && fillingLevel < 25 && this.itemStacks[0].getItem() == new ItemStack(Blocks.double_plant, 1, 0).getItem()) return true;
        	if((0 == content.compareTo("Apple")       || 0 == content.compareTo("empty")) && fillingLevel < 25 && this.itemStacks[0].getItem() == Items.apple)                                        return true;
            if((0 == content.compareTo("Banana")      || 0 == content.compareTo("empty")) && fillingLevel < 25 && this.itemStacks[0].getItem() == ShopKeeper.foodBanana)                              return true;
            if((0 == content.compareTo("CactusFruit") || 0 == content.compareTo("empty")) && fillingLevel < 25 && this.itemStacks[0].getItem() == ShopKeeper.foodCactusFruit)                         return true;
            if((0 == content.compareTo("Cherry")      || 0 == content.compareTo("empty")) && fillingLevel < 25 && this.itemStacks[0].getItem() == ShopKeeper.foodCherry)                              return true;
            if((0 == content.compareTo("Grapes")      || 0 == content.compareTo("empty")) && fillingLevel < 25 && this.itemStacks[0].getItem() == ShopKeeper.foodGrapes)                              return true;
            if((0 == content.compareTo("Lemon")       || 0 == content.compareTo("empty")) && fillingLevel < 25 && this.itemStacks[0].getItem() == ShopKeeper.foodLemon)                               return true;
            if((0 == content.compareTo("Orange")      || 0 == content.compareTo("empty")) && fillingLevel < 25 && this.itemStacks[0].getItem() == ShopKeeper.foodOrange)                              return true;
            if((0 == content.compareTo("Peach")       || 0 == content.compareTo("empty")) && fillingLevel < 25 && this.itemStacks[0].getItem() == ShopKeeper.foodPeach)                               return true;
            if((0 == content.compareTo("Pineapple")   || 0 == content.compareTo("empty")) && fillingLevel < 25 && this.itemStacks[0].getItem() == ShopKeeper.foodPineapple)                           return true;
            if((0 == content.compareTo("Tomato")      || 0 == content.compareTo("empty")) && fillingLevel < 25 && this.itemStacks[0].getItem() == ShopKeeper.foodTomato)                              return true;
        }
        return false;
    }
    
    public void smeltItem(){
        if (this.canSmelt()){
        	if(this.itemStacks[0].getItem() == new ItemStack(Blocks.double_plant, 1, 0).getItem()){ fillingLevel++; if(0 == content.compareTo("empty")) content = "Oil"; }
            if(this.itemStacks[0].getItem() == Items.apple)                                       { fillingLevel++; if(0 == content.compareTo("empty")) content = "Apple"; }
            if(this.itemStacks[0].getItem() == ShopKeeper.foodBanana)                             { fillingLevel++; if(0 == content.compareTo("empty")) content = "Banana"; }
            if(this.itemStacks[0].getItem() == ShopKeeper.foodCactusFruit)                        { fillingLevel++; if(0 == content.compareTo("empty")) content = "CactusFruit"; }
            if(this.itemStacks[0].getItem() == ShopKeeper.foodCherry)                             { fillingLevel++; if(0 == content.compareTo("empty")) content = "Cherry"; }
            if(this.itemStacks[0].getItem() == ShopKeeper.foodGrapes)                             { fillingLevel++; if(0 == content.compareTo("empty")) content = "Grapes"; }
            if(this.itemStacks[0].getItem() == ShopKeeper.foodLemon)                              { fillingLevel++; if(0 == content.compareTo("empty")) content = "Lemon"; }
            if(this.itemStacks[0].getItem() == ShopKeeper.foodOrange)                             { fillingLevel++; if(0 == content.compareTo("empty")) content = "Orange"; }
            if(this.itemStacks[0].getItem() == ShopKeeper.foodPeach)                              { fillingLevel++; if(0 == content.compareTo("empty")) content = "Peach"; }
            if(this.itemStacks[0].getItem() == ShopKeeper.foodPineapple)                          { fillingLevel++; if(0 == content.compareTo("empty")) content = "Pineapple"; }
            if(this.itemStacks[0].getItem() == ShopKeeper.foodTomato)                             { fillingLevel++; if(0 == content.compareTo("empty")) content = "Tomato"; }
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
    
	private Item changeBucket(Item item, String string){
		if(0 == string.compareTo("Oil")){
    		if(item == ShopKeeper.bucketWoodEmpty)       return ShopKeeper.bucketWoodOil;
    		if(item == ShopKeeper.bucketCopperEmpty)     return ShopKeeper.bucketCopperOil;
    		if(item == ShopKeeper.bucketIronEmpty)       return ShopKeeper.bucketIronOil;
    		if(item == ShopKeeper.bucketAluminiumEmpty)  return ShopKeeper.bucketAluminiumOil;
    		if(item == ShopKeeper.bucketLeadEmpty)       return ShopKeeper.bucketLeadOil;
    		if(item == ShopKeeper.bucketBronzeEmpty)     return ShopKeeper.bucketBronzeOil;
    		if(item == ShopKeeper.bucketSteelEmpty)      return ShopKeeper.bucketSteelOil;
    		if(item == ShopKeeper.bucketMythrilEmpty)    return ShopKeeper.bucketMythrilOil;
    		if(item == ShopKeeper.bucketAdamantiumEmpty) return ShopKeeper.bucketAdamantiumOil;
    		if(item == ShopKeeper.bucketUnobtaniumEmpty) return ShopKeeper.bucketUnobtaniumOil;
    	}
		if(0 == string.compareTo("Apple")){
    		if(item == ShopKeeper.bucketWoodEmpty)       return ShopKeeper.bucketWoodApple;
    		if(item == ShopKeeper.bucketCopperEmpty)     return ShopKeeper.bucketCopperApple;
    		if(item == ShopKeeper.bucketIronEmpty)       return ShopKeeper.bucketIronApple;
    		if(item == ShopKeeper.bucketAluminiumEmpty)  return ShopKeeper.bucketAluminiumApple;
    		if(item == ShopKeeper.bucketLeadEmpty)       return ShopKeeper.bucketLeadApple;
    		if(item == ShopKeeper.bucketBronzeEmpty)     return ShopKeeper.bucketBronzeApple;
    		if(item == ShopKeeper.bucketSteelEmpty)      return ShopKeeper.bucketSteelApple;
    		if(item == ShopKeeper.bucketMythrilEmpty)    return ShopKeeper.bucketMythrilApple;
    		if(item == ShopKeeper.bucketAdamantiumEmpty) return ShopKeeper.bucketAdamantiumApple;
    		if(item == ShopKeeper.bucketUnobtaniumEmpty) return ShopKeeper.bucketUnobtaniumApple;
    	}
    	if(0 == string.compareTo("Banana")){
    		if(item == ShopKeeper.bucketWoodEmpty)       return ShopKeeper.bucketWoodBanana;
    		if(item == ShopKeeper.bucketCopperEmpty)     return ShopKeeper.bucketCopperBanana;
    		if(item == ShopKeeper.bucketIronEmpty)       return ShopKeeper.bucketIronBanana;
    		if(item == ShopKeeper.bucketAluminiumEmpty)  return ShopKeeper.bucketAluminiumBanana;
    		if(item == ShopKeeper.bucketLeadEmpty)       return ShopKeeper.bucketLeadBanana;
    		if(item == ShopKeeper.bucketBronzeEmpty)     return ShopKeeper.bucketBronzeBanana;
    		if(item == ShopKeeper.bucketSteelEmpty)      return ShopKeeper.bucketSteelBanana;
    		if(item == ShopKeeper.bucketMythrilEmpty)    return ShopKeeper.bucketMythrilBanana;
    		if(item == ShopKeeper.bucketAdamantiumEmpty) return ShopKeeper.bucketAdamantiumBanana;
    		if(item == ShopKeeper.bucketUnobtaniumEmpty) return ShopKeeper.bucketUnobtaniumBanana;
    	}
    	if(0 == string.compareTo("Cactus")){
    		if(item == ShopKeeper.bucketWoodEmpty)       return ShopKeeper.bucketWoodCactusFruit;
    		if(item == ShopKeeper.bucketCopperEmpty)     return ShopKeeper.bucketCopperCactusFruit;
    		if(item == ShopKeeper.bucketIronEmpty)       return ShopKeeper.bucketIronCactusFruit;
    		if(item == ShopKeeper.bucketAluminiumEmpty)  return ShopKeeper.bucketAluminiumCactusFruit;
    		if(item == ShopKeeper.bucketLeadEmpty)       return ShopKeeper.bucketLeadCactusFruit;
    		if(item == ShopKeeper.bucketBronzeEmpty)     return ShopKeeper.bucketBronzeCactusFruit;
    		if(item == ShopKeeper.bucketSteelEmpty)      return ShopKeeper.bucketSteelCactusFruit;
    		if(item == ShopKeeper.bucketMythrilEmpty)    return ShopKeeper.bucketMythrilCactusFruit;
    		if(item == ShopKeeper.bucketAdamantiumEmpty) return ShopKeeper.bucketAdamantiumCactusFruit;
    		if(item == ShopKeeper.bucketUnobtaniumEmpty) return ShopKeeper.bucketUnobtaniumCactusFruit;
    	}
    	if(0 == string.compareTo("Cherry")){
    		if(item == ShopKeeper.bucketWoodEmpty)       return ShopKeeper.bucketWoodCherry;
    		if(item == ShopKeeper.bucketCopperEmpty)     return ShopKeeper.bucketCopperCherry;
    		if(item == ShopKeeper.bucketIronEmpty)       return ShopKeeper.bucketIronCherry;
    		if(item == ShopKeeper.bucketAluminiumEmpty)  return ShopKeeper.bucketAluminiumCherry;
    		if(item == ShopKeeper.bucketLeadEmpty)       return ShopKeeper.bucketLeadCherry;
    		if(item == ShopKeeper.bucketBronzeEmpty)     return ShopKeeper.bucketBronzeCherry;
    		if(item == ShopKeeper.bucketSteelEmpty)      return ShopKeeper.bucketSteelCherry;
    		if(item == ShopKeeper.bucketMythrilEmpty)    return ShopKeeper.bucketMythrilCherry;
    		if(item == ShopKeeper.bucketAdamantiumEmpty) return ShopKeeper.bucketAdamantiumCherry;
    		if(item == ShopKeeper.bucketUnobtaniumEmpty) return ShopKeeper.bucketUnobtaniumCherry;
    	}
    	if(0 == string.compareTo("Grapes")){
    		if(item == ShopKeeper.bucketWoodEmpty)       return ShopKeeper.bucketWoodGrapes;
    		if(item == ShopKeeper.bucketCopperEmpty)     return ShopKeeper.bucketCopperGrapes;
    		if(item == ShopKeeper.bucketIronEmpty)       return ShopKeeper.bucketIronGrapes;
    		if(item == ShopKeeper.bucketAluminiumEmpty)  return ShopKeeper.bucketAluminiumGrapes;
    		if(item == ShopKeeper.bucketLeadEmpty)       return ShopKeeper.bucketLeadGrapes;
    		if(item == ShopKeeper.bucketBronzeEmpty)     return ShopKeeper.bucketBronzeGrapes;
    		if(item == ShopKeeper.bucketSteelEmpty)      return ShopKeeper.bucketSteelGrapes;
    		if(item == ShopKeeper.bucketMythrilEmpty)    return ShopKeeper.bucketMythrilGrapes;
    		if(item == ShopKeeper.bucketAdamantiumEmpty) return ShopKeeper.bucketAdamantiumGrapes;
    		if(item == ShopKeeper.bucketUnobtaniumEmpty) return ShopKeeper.bucketUnobtaniumGrapes;
    	}
    	if(0 == string.compareTo("Lemon")){
    		if(item == ShopKeeper.bucketWoodEmpty)       return ShopKeeper.bucketWoodLemon;
    		if(item == ShopKeeper.bucketCopperEmpty)     return ShopKeeper.bucketCopperLemon;
    		if(item == ShopKeeper.bucketIronEmpty)       return ShopKeeper.bucketIronLemon;
    		if(item == ShopKeeper.bucketAluminiumEmpty)  return ShopKeeper.bucketAluminiumLemon;
    		if(item == ShopKeeper.bucketLeadEmpty)       return ShopKeeper.bucketLeadLemon;
    		if(item == ShopKeeper.bucketBronzeEmpty)     return ShopKeeper.bucketBronzeLemon;
    		if(item == ShopKeeper.bucketSteelEmpty)      return ShopKeeper.bucketSteelLemon;
    		if(item == ShopKeeper.bucketMythrilEmpty)    return ShopKeeper.bucketMythrilLemon;
    		if(item == ShopKeeper.bucketAdamantiumEmpty) return ShopKeeper.bucketAdamantiumLemon;
    		if(item == ShopKeeper.bucketUnobtaniumEmpty) return ShopKeeper.bucketUnobtaniumLemon;
    	}
    	if(0 == string.compareTo("Orange")){
    		if(item == ShopKeeper.bucketWoodEmpty)       return ShopKeeper.bucketWoodOrange;
    		if(item == ShopKeeper.bucketCopperEmpty)     return ShopKeeper.bucketCopperOrange;
    		if(item == ShopKeeper.bucketIronEmpty)       return ShopKeeper.bucketIronOrange;
    		if(item == ShopKeeper.bucketAluminiumEmpty)  return ShopKeeper.bucketAluminiumOrange;
    		if(item == ShopKeeper.bucketLeadEmpty)       return ShopKeeper.bucketLeadOrange;
    		if(item == ShopKeeper.bucketBronzeEmpty)     return ShopKeeper.bucketBronzeOrange;
    		if(item == ShopKeeper.bucketSteelEmpty)      return ShopKeeper.bucketSteelOrange;
    		if(item == ShopKeeper.bucketMythrilEmpty)    return ShopKeeper.bucketMythrilOrange;
    		if(item == ShopKeeper.bucketAdamantiumEmpty) return ShopKeeper.bucketAdamantiumOrange;
    		if(item == ShopKeeper.bucketUnobtaniumEmpty) return ShopKeeper.bucketUnobtaniumOrange;
    	}
    	if(0 == string.compareTo("Peach")){
    		if(item == ShopKeeper.bucketWoodEmpty)       return ShopKeeper.bucketWoodPeach;
    		if(item == ShopKeeper.bucketCopperEmpty)     return ShopKeeper.bucketCopperPeach;
    		if(item == ShopKeeper.bucketIronEmpty)       return ShopKeeper.bucketIronPeach;
    		if(item == ShopKeeper.bucketAluminiumEmpty)  return ShopKeeper.bucketAluminiumPeach;
    		if(item == ShopKeeper.bucketLeadEmpty)       return ShopKeeper.bucketLeadPeach;
    		if(item == ShopKeeper.bucketBronzeEmpty)     return ShopKeeper.bucketBronzePeach;
    		if(item == ShopKeeper.bucketSteelEmpty)      return ShopKeeper.bucketSteelPeach;
    		if(item == ShopKeeper.bucketMythrilEmpty)    return ShopKeeper.bucketMythrilPeach;
    		if(item == ShopKeeper.bucketAdamantiumEmpty) return ShopKeeper.bucketAdamantiumPeach;
    		if(item == ShopKeeper.bucketUnobtaniumEmpty) return ShopKeeper.bucketUnobtaniumPeach;
    	}
    	if(0 == string.compareTo("Pineapple")){
    		if(item == ShopKeeper.bucketWoodEmpty)       return ShopKeeper.bucketWoodPineapple;
    		if(item == ShopKeeper.bucketCopperEmpty)     return ShopKeeper.bucketCopperPineapple;
    		if(item == ShopKeeper.bucketIronEmpty)       return ShopKeeper.bucketIronPineapple;
    		if(item == ShopKeeper.bucketAluminiumEmpty)  return ShopKeeper.bucketAluminiumPineapple;
    		if(item == ShopKeeper.bucketLeadEmpty)       return ShopKeeper.bucketLeadPineapple;
    		if(item == ShopKeeper.bucketBronzeEmpty)     return ShopKeeper.bucketBronzePineapple;
    		if(item == ShopKeeper.bucketSteelEmpty)      return ShopKeeper.bucketSteelPineapple;
    		if(item == ShopKeeper.bucketMythrilEmpty)    return ShopKeeper.bucketMythrilPineapple;
    		if(item == ShopKeeper.bucketAdamantiumEmpty) return ShopKeeper.bucketAdamantiumPineapple;
    		if(item == ShopKeeper.bucketUnobtaniumEmpty) return ShopKeeper.bucketUnobtaniumPineapple;
    	}
    	if(0 == string.compareTo("Tomato")){
    		if(item == ShopKeeper.bucketWoodEmpty)       return ShopKeeper.bucketWoodTomato;
    		if(item == ShopKeeper.bucketCopperEmpty)     return ShopKeeper.bucketCopperTomato;
    		if(item == ShopKeeper.bucketIronEmpty)       return ShopKeeper.bucketIronTomato;
    		if(item == ShopKeeper.bucketAluminiumEmpty)  return ShopKeeper.bucketAluminiumTomato;
    		if(item == ShopKeeper.bucketLeadEmpty)       return ShopKeeper.bucketLeadTomato;
    		if(item == ShopKeeper.bucketBronzeEmpty)     return ShopKeeper.bucketBronzeTomato;
    		if(item == ShopKeeper.bucketSteelEmpty)      return ShopKeeper.bucketSteelTomato;
    		if(item == ShopKeeper.bucketMythrilEmpty)    return ShopKeeper.bucketMythrilTomato;
    		if(item == ShopKeeper.bucketAdamantiumEmpty) return ShopKeeper.bucketAdamantiumTomato;
    		if(item == ShopKeeper.bucketUnobtaniumEmpty) return ShopKeeper.bucketUnobtaniumTomato;
    	}
    	return item;
    }
    
    private Item changeBottle(Item item, String string){
    	if(item == Items.glass_bottle && 0 == string.compareTo("Oil"))       return ShopKeeper.juiceOil;
    	if(item == Items.glass_bottle && 0 == string.compareTo("Apple"))     return ShopKeeper.juiceApple;
    	if(item == Items.glass_bottle && 0 == string.compareTo("Banana"))    return ShopKeeper.juiceBanana;
    	if(item == Items.glass_bottle && 0 == string.compareTo("Cactus"))    return ShopKeeper.juiceCactus;
    	if(item == Items.glass_bottle && 0 == string.compareTo("Cherry"))    return ShopKeeper.juiceCherry;
    	if(item == Items.glass_bottle && 0 == string.compareTo("Grapes"))    return ShopKeeper.juiceGrapes;
    	if(item == Items.glass_bottle && 0 == string.compareTo("Lemon"))     return ShopKeeper.juiceLemon;
    	if(item == Items.glass_bottle && 0 == string.compareTo("Orange"))    return ShopKeeper.juiceOrange;
    	if(item == Items.glass_bottle && 0 == string.compareTo("Peach"))     return ShopKeeper.juicePeach;
    	if(item == Items.glass_bottle && 0 == string.compareTo("Pineapple")) return ShopKeeper.juicePineapple;
    	if(item == Items.glass_bottle && 0 == string.compareTo("Tomato"))    return ShopKeeper.juiceTomato;
    	return item;
    }
    
	public void firstSetUp(int l, int e) {
		meta = l;
		energy = e;
		content = "empty";
		fillingLevel = 0;
		
	}
	
	public String getContent() {
		return content;
	}
	
	public int getFillingLevelScaled() {
		return fillingLevel * 3;
	}

}