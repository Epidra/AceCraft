package net.acecraft.mod.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.block.machina.Boiler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBoiler extends TileEntity implements ISidedInventory {
	
    private ItemStack[] itemStacks = new ItemStack[1];
    public int burnTime;
    public int currentItemBurnTime;
    public int cookTime;
    private String field;
    public int energy;
    public int energyCollected;
    public boolean isCrowned;
    public boolean hasRightSide;
    public boolean hasLeftSide;
    
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
        return this.hasCustomInventoryName() ? this.field : "container.furnace";
    }
    
    public boolean hasCustomInventoryName(){
        return this.field != null && this.field.length() > 0;
    }
    
    public void func_145951_a(String p_145951_1_){
        this.field = p_145951_1_;
    }
    
    @Override
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
        this.isCrowned     = nbt.getBoolean("IsCrowned");
        this.hasRightSide  = nbt.getBoolean("HasRightSide");
        this.hasLeftSide   = nbt.getBoolean("HasLeftSide");
        this.energy          = nbt.getShort("Energy");
        this.energyCollected = nbt.getShort("EnergyCollected");
        this.burnTime        = nbt.getShort("BurnTime");
        this.cookTime        = nbt.getShort("CookTime");
        this.currentItemBurnTime = getItemBurnTime(this.itemStacks[0]);
        if (nbt.hasKey("CustomName", 8)){
            this.field = nbt.getString("CustomName");
        }
    }
    
    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tagCompound = new NBTTagCompound();
        writeToNBT(tagCompound);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tagCompound);
    }
    
    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        NBTTagCompound tag = pkt.func_148857_g();
        readFromNBT(tag);
    }
    
    @Override
    public void writeToNBT(NBTTagCompound nbt){
        super.writeToNBT(nbt);
        nbt.setBoolean("IsCrowned",    this.isCrowned);
        nbt.setBoolean("HasRightSide", this.hasRightSide);
        nbt.setBoolean("HasLeftSide",  this.hasLeftSide);
        nbt.setShort("Energy",          (short)this.energy);
        nbt.setShort("EnergyCollected", (short)this.energyCollected);
        nbt.setShort("BurnTime",        (short)this.burnTime);
        nbt.setShort("CookTime",        (short)this.cookTime);
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
    public int getEnergyScaled(){
        return this.energy / 2;
    }
    
    public int getEnergy(){
        return this.energy;
    }
    
    public boolean getIsCrowned(){
    	return this.isCrowned;
    }
    
    @SideOnly(Side.CLIENT)
    public int getCookProgressScaled(int value){
        return this.cookTime * value / 200;
    }
    
    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int value){
        if (this.currentItemBurnTime == 0){
            this.currentItemBurnTime = 200;
        }
        return this.burnTime * value / this.currentItemBurnTime;
    }
    
    public boolean isBurning(){
        return this.burnTime > 0;
    }
    
    public void updateEntity(){
        boolean flag = this.burnTime > 0;
        boolean flag1 = false;
        if (this.burnTime > 0){
            --this.burnTime;
            if(energy < 100){
            	energy++;
            }
        }else{
        	if(energy > 0){
        		energy--;
        	}
        }
        if(!this.worldObj.isRemote){
        	if(this.burnTime == 0){
        		if(this.itemStacks[0] != null){
        			--this.itemStacks[0].stackSize;
        			this.currentItemBurnTime = this.burnTime = getItemBurnTime(this.itemStacks[0]);
        			Boiler.updateBoilerBlockState(true, this.worldObj, this.xCoord, this.yCoord, this.zCoord, isCrowned);
        			flag1 = true;
        		}else{
        			Boiler.updateBoilerBlockState(false, this.worldObj, this.xCoord, this.yCoord, this.zCoord, isCrowned);
        		}
        	}
        	if (this.isBurning() && this.canSmelt()){
                ++this.cookTime;
                if (this.cookTime == 200){
                    this.cookTime = 0;
                    flag1 = true;
                }
            }else{
                this.cookTime = 0;
            }
        }
        if(isCrowned){
        	energyCollected = energy;
        	int x = 0;
        	int z = 0;
        	int i = 0;
        	int x2 = 0;
        	int z2 = 0;
        	int m = this.blockMetadata;
        	if(this.blockMetadata == 2){ x =  1; i =  1; }
            if(this.blockMetadata == 3){ x = -1; i = -1; }
    		if(this.blockMetadata == 4){ z =  1; i =  1; }
    		if(this.blockMetadata == 5){ z = -1; i = -1; }
    		boolean temp = true;
    		x2 = x;
    		z2 = z;
    		while(temp){
    			if(this.worldObj.getBlock(xCoord+x2, yCoord, zCoord+z2) == ShopKeeper.machinaBoilerActive && this.worldObj.getBlockMetadata(xCoord+x2, yCoord, zCoord+z2) == m){
    				TileEntityBoiler entity = (TileEntityBoiler)this.worldObj.getTileEntity(xCoord+x2, yCoord, zCoord+z2);
    				energyCollected = energyCollected + entity.energy;
    			}else if(this.worldObj.getBlock(xCoord+x2, yCoord, zCoord+z2) == ShopKeeper.machinaBoilerIdle && this.worldObj.getBlockMetadata(xCoord+x2, yCoord, zCoord+z2) == m){
    				
    			}else{
    				temp = false;
    			}
    			if(x2 != 0) x2 = x2 + i;
    			if(z2 != 0) z2 = z2 + i;
    		}
    		temp = true;
    		x2 = x * -1;
    		z2 = z * -1;
    		i  = i * -1;
    		while(temp){
    			if(this.worldObj.getBlock(xCoord+x2, yCoord, zCoord+z2) == ShopKeeper.machinaBoilerActive && this.worldObj.getBlockMetadata(xCoord+x2, yCoord, zCoord+z2) == m){
    				TileEntityBoiler entity = (TileEntityBoiler)this.worldObj.getTileEntity(xCoord+x2, yCoord, zCoord+z2);
    				energyCollected = energyCollected + entity.energy;
    			}else if(this.worldObj.getBlock(xCoord+x2, yCoord, zCoord+z2) == ShopKeeper.machinaBoilerIdle && this.worldObj.getBlockMetadata(xCoord+x2, yCoord, zCoord+z2) == m){
    				
    			}else{
    				temp = false;
    			}
    			if(x2 != 0) x2 = x2 + i;
    			if(z2 != 0) z2 = z2 + i;
    		}
        }
        if (flag1){
            this.markDirty();
        }
    }
    
    public void CheckSorrounding(boolean first){
    	if(first){
    		isCrowned = true;
    	}
		hasRightSide = false;
		hasLeftSide  = false;
		int meta = this.getBlockMetadata();
		if(meta == 3){
			if((worldObj.getBlock(xCoord+1, yCoord, zCoord) == ShopKeeper.machinaBoilerIdle || worldObj.getBlock(xCoord+1, yCoord, zCoord) == ShopKeeper.machinaBoilerActive) && worldObj.getBlockMetadata(xCoord+1, yCoord, zCoord) == meta){
				if(first) isCrowned = false;
				hasRightSide = true;
			}
			if((worldObj.getBlock(xCoord-1, yCoord, zCoord) == ShopKeeper.machinaBoilerIdle || worldObj.getBlock(xCoord-1, yCoord, zCoord) == ShopKeeper.machinaBoilerActive) && worldObj.getBlockMetadata(xCoord-1, yCoord, zCoord) == meta){
				if(first) isCrowned = false;
				hasLeftSide  = true;
			}
		}
		if(meta == 2){
			if((worldObj.getBlock(xCoord-1, yCoord, zCoord) == ShopKeeper.machinaBoilerIdle || worldObj.getBlock(xCoord-1, yCoord, zCoord) == ShopKeeper.machinaBoilerActive) && worldObj.getBlockMetadata(xCoord-1, yCoord, zCoord) == meta){
				if(first) isCrowned = false;
				hasRightSide = true;
			}
			if((worldObj.getBlock(xCoord+1, yCoord, zCoord) == ShopKeeper.machinaBoilerIdle || worldObj.getBlock(xCoord+1, yCoord, zCoord) == ShopKeeper.machinaBoilerActive) && worldObj.getBlockMetadata(xCoord+1, yCoord, zCoord) == meta){
				if(first) isCrowned = false;
				hasLeftSide  = true;
			}
		}
		if(meta == 4){
			if((worldObj.getBlock(xCoord, yCoord, zCoord+1) == ShopKeeper.machinaBoilerIdle || worldObj.getBlock(xCoord, yCoord, zCoord+1) == ShopKeeper.machinaBoilerActive) && worldObj.getBlockMetadata(xCoord, yCoord, zCoord+1) == meta){
				if(first) isCrowned = false;
				hasRightSide = true;
			}
			if((worldObj.getBlock(xCoord, yCoord, zCoord-1) == ShopKeeper.machinaBoilerIdle || worldObj.getBlock(xCoord, yCoord, zCoord-1) == ShopKeeper.machinaBoilerActive) && worldObj.getBlockMetadata(xCoord, yCoord, zCoord-1) == meta){
				if(first) isCrowned = false;
				hasLeftSide  = true;
			}
		}
		if(meta == 5){
			if((worldObj.getBlock(xCoord, yCoord, zCoord-1) == ShopKeeper.machinaBoilerIdle || worldObj.getBlock(xCoord, yCoord, zCoord-1) == ShopKeeper.machinaBoilerActive) && worldObj.getBlockMetadata(xCoord, yCoord, zCoord-1) == meta){
				if(first) isCrowned = false;
				hasRightSide = true;
			}
			if((worldObj.getBlock(xCoord, yCoord, zCoord+1) == ShopKeeper.machinaBoilerIdle || worldObj.getBlock(xCoord, yCoord, zCoord+1) == ShopKeeper.machinaBoilerActive) && worldObj.getBlockMetadata(xCoord, yCoord, zCoord+1) == meta){
				if(first) isCrowned = false;
				hasLeftSide  = true;
			}
		}
    }
    
    private boolean canSmelt() {
        if (this.itemStacks[0] == null) {
            return false;
        } else {
        	if(this.itemStacks[0].getItem() == Items.coal){
        		return true;
        	}
        }
        return false;
    }
    
    public static int getItemBurnTime(ItemStack stack){
        if (stack == null){
            return 0;
        }else{
            Item item = stack.getItem();
            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air){
                Block block = Block.getBlockFromItem(item);
                if (block == Blocks.wooden_slab)          return   150;
                if (block.getMaterial() == Material.wood) return   300;
                if (block == Blocks.coal_block)           return 16000;
            }
            if (item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().equals("WOOD"))   return 200;
            if (item instanceof ItemSword && ((ItemSword)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemHoe && ((ItemHoe)item).getToolMaterialName().equals("WOOD"))     return 200;
            if (item == Items.stick) return 100;
            if (item == Items.coal) return 1600;
            if (item == Items.lava_bucket) return 20000;
            if (item == Item.getItemFromBlock(Blocks.sapling)) return 100;
            if (item == Items.blaze_rod) return 2400;
            return GameRegistry.getFuelValue(stack);
        }
    }
    
    public static boolean isItemFuel(ItemStack stack){
        return getItemBurnTime(stack) > 0;
    }
    
    public boolean isUseableByPlayer(EntityPlayer player){
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }
    
    public void openInventory() {}
    public void closeInventory() {}
    
    public boolean isItemValidForSlot(int id, ItemStack stack){
        return id == 2 ? false : (id == 1 ? isItemFuel(stack) : true);
    }
    
    public int[] getAccessibleSlotsFromSide(int value){
        return new int[] {0};
    }
    
    public boolean canInsertItem(int slot, ItemStack stack, int side){
        return this.isItemValidForSlot(slot, stack);
    }
    
    public boolean canExtractItem(int slot, ItemStack stack, int side){
        return side != 0 || slot != 1 || stack.getItem() == Items.bucket;
    }

}