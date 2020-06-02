package net.acecraft.mod.tileentity;

import net.acecraft.mod.ShopKeeper;
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
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityKeg extends TileEntity implements ISidedInventory {
	
	private static final int[] slotsTop    = new int[] {0};
    private static final int[] slotsBottom = new int[] {2, 1};
    private static final int[] slotsSides  = new int[] {1};
    private ItemStack[] itemStacks = new ItemStack[3];
    public int burnTime;
    public int currentItemBurnTime;
    public int cookTime;
    private String field;
    public String content = "empty";
    public int fillingLevel;
    public int fermentCurrent;
    public int fermentMax = 1000;
    
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
        return this.hasCustomInventoryName() ? this.field : "container.keg";
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
        this.content        = nbt.getString("content");
        this.fillingLevel   = nbt.getShort("fillingLevel");
        this.fermentCurrent = nbt.getShort("fermentCurrent");
        this.burnTime       = nbt.getShort("BurnTime");
        this.cookTime       = nbt.getShort("CookTime");
        this.currentItemBurnTime = getItemBurnTime(this.itemStacks[1]);
        if (nbt.hasKey("CustomName", 8)){
            this.field = nbt.getString("CustomName");
        }
    }
    
    public void writeToNBT(NBTTagCompound nbt){
        super.writeToNBT(nbt);
        nbt.setString("content",      (String)this.content);
        nbt.setShort("fillingLevel",   (short)this.fillingLevel);
        nbt.setShort("fermentCurrent", (short)this.fermentCurrent);
        nbt.setShort("BurnTime",       (short)this.burnTime);
        nbt.setShort("CookTime",       (short)this.cookTime);
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
    public String getContent(){
        return content;
    }
    
    @SideOnly(Side.CLIENT)
    public int getFillingLevel(int i){
        return fillingLevel * 3;
    }
    
    @SideOnly(Side.CLIENT)
    public int getFermentCurrent(int i){
        return fermentCurrent;
    }
    
    public void updateEntity(){
        boolean flag1 = false;
        if(!this.worldObj.isRemote){
            flag1 = this.smeltItem();
            if(fillingLevel == 25){
            	if(0 == content.compareTo("Milk") || 0 == content.compareTo("CoconutMilk") || 0 == content.compareTo("Apple") || 0 == content.compareTo("Grapes") || 0 == content.compareTo("Cherry") || 0 == content.compareTo("Pineapple")){
            		fermentCurrent = fermentCurrent + 1;
            	}
            }else{
            	fermentCurrent = 0;
            }
            if(fermentCurrent == fermentMax){
            	if(0 == content.compareTo("Milk"))        content = "Cheese";
            	if(0 == content.compareTo("CoconutMilk")) content = "Cheese";
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
    
    private boolean validateBucket(Item item, String string){
		if(0 == string.compareTo("empty")){
			if(item == ShopKeeper.bucketWoodEmpty)       return true;
			if(item == ShopKeeper.bucketCopperEmpty)     return true;
			if(item == ShopKeeper.bucketIronEmpty)       return true;
			if(item == ShopKeeper.bucketAluminiumEmpty)  return true;
			if(item == ShopKeeper.bucketLeadEmpty)       return true;
			if(item == ShopKeeper.bucketBronzeEmpty)     return true;
			if(item == ShopKeeper.bucketSteelEmpty)      return true;
			if(item == ShopKeeper.bucketMythrilEmpty)    return true;
			if(item == ShopKeeper.bucketAdamantiumEmpty) return true;
			if(item == ShopKeeper.bucketUnobtaniumEmpty) return true;
		}
		if(0 == string.compareTo("Water")){
			if(item == ShopKeeper.bucketWoodWater)       return true;
			if(item == ShopKeeper.bucketCopperWater)     return true;
			if(item == ShopKeeper.bucketIronWater)       return true;
			if(item == ShopKeeper.bucketAluminiumWater)  return true;
			if(item == ShopKeeper.bucketLeadWater)       return true;
			if(item == ShopKeeper.bucketBronzeWater)     return true;
			if(item == ShopKeeper.bucketSteelWater)      return true;
			if(item == ShopKeeper.bucketMythrilWater)    return true;
			if(item == ShopKeeper.bucketAdamantiumWater) return true;
			if(item == ShopKeeper.bucketUnobtaniumWater) return true;
		}
		if(0 == string.compareTo("Oil")){
			if(item == ShopKeeper.bucketWoodOil)       return true;
			if(item == ShopKeeper.bucketCopperOil)     return true;
			if(item == ShopKeeper.bucketIronOil)       return true;
			if(item == ShopKeeper.bucketAluminiumOil)  return true;
			if(item == ShopKeeper.bucketLeadOil)       return true;
			if(item == ShopKeeper.bucketBronzeOil)     return true;
			if(item == ShopKeeper.bucketSteelOil)      return true;
			if(item == ShopKeeper.bucketMythrilOil)    return true;
			if(item == ShopKeeper.bucketAdamantiumOil) return true;
			if(item == ShopKeeper.bucketUnobtaniumOil) return true;
		}
		if(0 == string.compareTo("Milk")){
			if(item == ShopKeeper.bucketWoodMilk)       return true;
			if(item == ShopKeeper.bucketCopperMilk)     return true;
			if(item == ShopKeeper.bucketIronMilk)       return true;
			if(item == ShopKeeper.bucketAluminiumMilk)  return true;
			if(item == ShopKeeper.bucketLeadMilk)       return true;
			if(item == ShopKeeper.bucketBronzeMilk)     return true;
			if(item == ShopKeeper.bucketSteelMilk)      return true;
			if(item == ShopKeeper.bucketMythrilMilk)    return true;
			if(item == ShopKeeper.bucketAdamantiumMilk) return true;
			if(item == ShopKeeper.bucketUnobtaniumMilk) return true;
		}
		if(0 == string.compareTo("CoconutMilk")){
			if(item == ShopKeeper.bucketWoodCoconutMilk)       return true;
			if(item == ShopKeeper.bucketCopperCoconutMilk)     return true;
			if(item == ShopKeeper.bucketIronCoconutMilk)       return true;
			if(item == ShopKeeper.bucketAluminiumCoconutMilk)  return true;
			if(item == ShopKeeper.bucketLeadCoconutMilk)       return true;
			if(item == ShopKeeper.bucketBronzeCoconutMilk)     return true;
			if(item == ShopKeeper.bucketSteelCoconutMilk)      return true;
			if(item == ShopKeeper.bucketMythrilCoconutMilk)    return true;
			if(item == ShopKeeper.bucketAdamantiumCoconutMilk) return true;
			if(item == ShopKeeper.bucketUnobtaniumCoconutMilk) return true;
		}
		if(0 == string.compareTo("Apple")){
			if(item == ShopKeeper.bucketWoodApple)       return true;
			if(item == ShopKeeper.bucketCopperApple)     return true;
			if(item == ShopKeeper.bucketIronApple)       return true;
			if(item == ShopKeeper.bucketAluminiumApple)  return true;
			if(item == ShopKeeper.bucketLeadApple)       return true;
			if(item == ShopKeeper.bucketBronzeApple)     return true;
			if(item == ShopKeeper.bucketSteelApple)      return true;
			if(item == ShopKeeper.bucketMythrilApple)    return true;
			if(item == ShopKeeper.bucketAdamantiumApple) return true;
			if(item == ShopKeeper.bucketUnobtaniumApple) return true;
		}
		if(0 == string.compareTo("Banana")){
			if(item == ShopKeeper.bucketWoodBanana)       return true;
			if(item == ShopKeeper.bucketCopperBanana)     return true;
			if(item == ShopKeeper.bucketIronBanana)       return true;
			if(item == ShopKeeper.bucketAluminiumBanana)  return true;
			if(item == ShopKeeper.bucketLeadBanana)       return true;
			if(item == ShopKeeper.bucketBronzeBanana)     return true;
			if(item == ShopKeeper.bucketSteelBanana)      return true;
			if(item == ShopKeeper.bucketMythrilBanana)    return true;
			if(item == ShopKeeper.bucketAdamantiumBanana) return true;
			if(item == ShopKeeper.bucketUnobtaniumBanana) return true;
		}
		if(0 == string.compareTo("Cactus")){
			if(item == ShopKeeper.bucketWoodCactusFruit)       return true;
			if(item == ShopKeeper.bucketCopperCactusFruit)     return true;
			if(item == ShopKeeper.bucketIronCactusFruit)       return true;
			if(item == ShopKeeper.bucketAluminiumCactusFruit)  return true;
			if(item == ShopKeeper.bucketLeadCactusFruit)       return true;
			if(item == ShopKeeper.bucketBronzeCactusFruit)     return true;
			if(item == ShopKeeper.bucketSteelCactusFruit)      return true;
			if(item == ShopKeeper.bucketMythrilCactusFruit)    return true;
			if(item == ShopKeeper.bucketAdamantiumCactusFruit) return true;
			if(item == ShopKeeper.bucketUnobtaniumCactusFruit) return true;
		}
		if(0 == string.compareTo("Cherry")){
			if(item == ShopKeeper.bucketWoodCherry)       return true;
			if(item == ShopKeeper.bucketCopperCherry)     return true;
			if(item == ShopKeeper.bucketIronCherry)       return true;
			if(item == ShopKeeper.bucketAluminiumCherry)  return true;
			if(item == ShopKeeper.bucketLeadCherry)       return true;
			if(item == ShopKeeper.bucketBronzeCherry)     return true;
			if(item == ShopKeeper.bucketSteelCherry)      return true;
			if(item == ShopKeeper.bucketMythrilCherry)    return true;
			if(item == ShopKeeper.bucketAdamantiumCherry) return true;
			if(item == ShopKeeper.bucketUnobtaniumCherry) return true;
		}
		if(0 == string.compareTo("Grapes")){
			if(item == ShopKeeper.bucketWoodGrapes)       return true;
			if(item == ShopKeeper.bucketCopperGrapes)     return true;
			if(item == ShopKeeper.bucketIronGrapes)       return true;
			if(item == ShopKeeper.bucketAluminiumGrapes)  return true;
			if(item == ShopKeeper.bucketLeadGrapes)       return true;
			if(item == ShopKeeper.bucketBronzeGrapes)     return true;
			if(item == ShopKeeper.bucketSteelGrapes)      return true;
			if(item == ShopKeeper.bucketMythrilGrapes)    return true;
			if(item == ShopKeeper.bucketAdamantiumGrapes) return true;
			if(item == ShopKeeper.bucketUnobtaniumGrapes) return true;
		}
		if(0 == string.compareTo("Lemon")){
			if(item == ShopKeeper.bucketWoodLemon)       return true;
			if(item == ShopKeeper.bucketCopperLemon)     return true;
			if(item == ShopKeeper.bucketIronLemon)       return true;
			if(item == ShopKeeper.bucketAluminiumLemon)  return true;
			if(item == ShopKeeper.bucketLeadLemon)       return true;
			if(item == ShopKeeper.bucketBronzeLemon)     return true;
			if(item == ShopKeeper.bucketSteelLemon)      return true;
			if(item == ShopKeeper.bucketMythrilLemon)    return true;
			if(item == ShopKeeper.bucketAdamantiumLemon) return true;
			if(item == ShopKeeper.bucketUnobtaniumLemon) return true;
		}
		if(0 == string.compareTo("Orange")){
			if(item == ShopKeeper.bucketWoodOrange)       return true;
			if(item == ShopKeeper.bucketCopperOrange)     return true;
			if(item == ShopKeeper.bucketIronOrange)       return true;
			if(item == ShopKeeper.bucketAluminiumOrange)  return true;
			if(item == ShopKeeper.bucketLeadOrange)       return true;
			if(item == ShopKeeper.bucketBronzeOrange)     return true;
			if(item == ShopKeeper.bucketSteelOrange)      return true;
			if(item == ShopKeeper.bucketMythrilOrange)    return true;
			if(item == ShopKeeper.bucketAdamantiumOrange) return true;
			if(item == ShopKeeper.bucketUnobtaniumOrange) return true;
		}
		if(0 == string.compareTo("Peach")){
			if(item == ShopKeeper.bucketWoodPeach)       return true;
			if(item == ShopKeeper.bucketCopperPeach)     return true;
			if(item == ShopKeeper.bucketIronPeach)       return true;
			if(item == ShopKeeper.bucketAluminiumPeach)  return true;
			if(item == ShopKeeper.bucketLeadPeach)       return true;
			if(item == ShopKeeper.bucketBronzePeach)     return true;
			if(item == ShopKeeper.bucketSteelPeach)      return true;
			if(item == ShopKeeper.bucketMythrilPeach)    return true;
			if(item == ShopKeeper.bucketAdamantiumPeach) return true;
			if(item == ShopKeeper.bucketUnobtaniumPeach) return true;
		}
		if(0 == string.compareTo("Pineapple")){
			if(item == ShopKeeper.bucketWoodPineapple)       return true;
			if(item == ShopKeeper.bucketCopperPineapple)     return true;
			if(item == ShopKeeper.bucketIronPineapple)       return true;
			if(item == ShopKeeper.bucketAluminiumPineapple)  return true;
			if(item == ShopKeeper.bucketLeadPineapple)       return true;
			if(item == ShopKeeper.bucketBronzePineapple)     return true;
			if(item == ShopKeeper.bucketSteelPineapple)      return true;
			if(item == ShopKeeper.bucketMythrilPineapple)    return true;
			if(item == ShopKeeper.bucketAdamantiumPineapple) return true;
			if(item == ShopKeeper.bucketUnobtaniumPineapple) return true;
		}
		if(0 == string.compareTo("Tomato")){
			if(item == ShopKeeper.bucketWoodTomato)       return true;
			if(item == ShopKeeper.bucketCopperTomato)     return true;
			if(item == ShopKeeper.bucketIronTomato)       return true;
			if(item == ShopKeeper.bucketAluminiumTomato)  return true;
			if(item == ShopKeeper.bucketLeadTomato)       return true;
			if(item == ShopKeeper.bucketBronzeTomato)     return true;
			if(item == ShopKeeper.bucketSteelTomato)      return true;
			if(item == ShopKeeper.bucketMythrilTomato)    return true;
			if(item == ShopKeeper.bucketAdamantiumTomato) return true;
			if(item == ShopKeeper.bucketUnobtaniumTomato) return true;
		}
    	return false;
    }
    
    private boolean validateBottle(Item item, String string){
    	if(item == Items.glass_bottle && 0 == string.compareTo("empty")) return true;
    	if(item == new ItemStack(Items.potionitem, 1, 0).getItem()&& 0 == string.compareTo("Water")) return true;
    	if(item == ShopKeeper.juiceOil            && 0 == string.compareTo("Oil"))           return true;
    	if(item == ShopKeeper.juiceApple          && 0 == string.compareTo("Apple"))         return true;
    	if(item == ShopKeeper.juiceBanana         && 0 == string.compareTo("Banana"))        return true;
    	if(item == ShopKeeper.juiceCactus         && 0 == string.compareTo("Cactus"))        return true;
    	if(item == ShopKeeper.juiceCherry         && 0 == string.compareTo("Cherry"))        return true;
    	if(item == ShopKeeper.juiceGrapes         && 0 == string.compareTo("Grapes"))        return true;
    	if(item == ShopKeeper.juiceLemon          && 0 == string.compareTo("Lemon"))         return true;
    	if(item == ShopKeeper.juiceOrange         && 0 == string.compareTo("Orange"))        return true;
    	if(item == ShopKeeper.juicePeach          && 0 == string.compareTo("Peach"))         return true;
    	if(item == ShopKeeper.juicePineapple      && 0 == string.compareTo("Pineapple"))     return true;
    	if(item == ShopKeeper.juiceTomato         && 0 == string.compareTo("Tomato"))        return true;
    	if(item == ShopKeeper.juiceMilk           && 0 == string.compareTo("Milk"))          return true;
    	if(item == ShopKeeper.juiceCoconutMilk    && 0 == string.compareTo("CoconutMilk"))   return true;
    	if(item == ShopKeeper.liquorCoconutRum    && 0 == string.compareTo("CoconutRum"))    return true;
    	if(item == ShopKeeper.liquorCider         && 0 == string.compareTo("Cider"))         return true;
    	if(item == ShopKeeper.liquorRum           && 0 == string.compareTo("Rum"))           return true;
    	if(item == ShopKeeper.liquorBeer          && 0 == string.compareTo("Beer"))          return true;
    	if(item == ShopKeeper.liquorSalgam        && 0 == string.compareTo("Salgam"))        return true;
    	if(item == ShopKeeper.liquorVodka         && 0 == string.compareTo("Vodka"))         return true;
    	if(item == ShopKeeper.liquorCactusJack    && 0 == string.compareTo("CactusJack"))    return true;
    	if(item == ShopKeeper.liquorSake          && 0 == string.compareTo("Sake"))          return true;
    	if(item == ShopKeeper.liquorMead          && 0 == string.compareTo("Mead"))          return true;
    	if(item == ShopKeeper.liquorWineGrapes    && 0 == string.compareTo("WineGrapes"))    return true;
    	if(item == ShopKeeper.liquorWineCherry    && 0 == string.compareTo("WineCherry"))    return true;
    	if(item == ShopKeeper.liquorWinePineapple && 0 == string.compareTo("WinePineapple")) return true;
    	return false;
    }
    
    private Item changeBucket(Item item, String string){
    	if(0 == string.compareTo("empty")){
    		if(item == ShopKeeper.bucketWoodWater ||
    				item == ShopKeeper.bucketWoodOil ||
    				item == ShopKeeper.bucketWoodApple ||
    				item == ShopKeeper.bucketWoodBanana ||
    				item == ShopKeeper.bucketWoodCactusFruit ||
    				item == ShopKeeper.bucketWoodCherry ||
    				item == ShopKeeper.bucketWoodGrapes ||
    				item == ShopKeeper.bucketWoodLemon ||
    				item == ShopKeeper.bucketWoodOrange ||
    				item == ShopKeeper.bucketWoodPeach ||
    				item == ShopKeeper.bucketWoodPineapple ||
    				item == ShopKeeper.bucketWoodTomato ||
    				item == ShopKeeper.bucketWoodMilk ||
    				item == ShopKeeper.bucketWoodCoconutMilk){
    			return ShopKeeper.bucketWoodEmpty;
    		}
    		if(item == ShopKeeper.bucketCopperWater ||
    				item == ShopKeeper.bucketCopperOil ||
    				item == ShopKeeper.bucketCopperApple ||
    				item == ShopKeeper.bucketCopperBanana ||
    				item == ShopKeeper.bucketCopperCactusFruit ||
    				item == ShopKeeper.bucketCopperCherry ||
    				item == ShopKeeper.bucketCopperGrapes ||
    				item == ShopKeeper.bucketCopperLemon ||
    				item == ShopKeeper.bucketCopperOrange ||
    				item == ShopKeeper.bucketCopperPeach ||
    				item == ShopKeeper.bucketCopperPineapple ||
    				item == ShopKeeper.bucketCopperTomato ||
    				item == ShopKeeper.bucketCopperMilk ||
    				item == ShopKeeper.bucketCopperCoconutMilk){
    			return ShopKeeper.bucketCopperEmpty;
    		}
    		if(item == ShopKeeper.bucketIronWater ||
    				item == ShopKeeper.bucketIronOil ||
    				item == ShopKeeper.bucketIronApple ||
    				item == ShopKeeper.bucketIronBanana ||
    				item == ShopKeeper.bucketIronCactusFruit ||
    				item == ShopKeeper.bucketIronCherry ||
    				item == ShopKeeper.bucketIronGrapes ||
    				item == ShopKeeper.bucketIronLemon ||
    				item == ShopKeeper.bucketIronOrange ||
    				item == ShopKeeper.bucketIronPeach ||
    				item == ShopKeeper.bucketIronPineapple ||
    				item == ShopKeeper.bucketIronTomato ||
    				item == ShopKeeper.bucketIronMilk ||
    				item == ShopKeeper.bucketIronCoconutMilk){
    			return ShopKeeper.bucketIronEmpty;
    		}
    		if(item == ShopKeeper.bucketAluminiumWater ||
    				item == ShopKeeper.bucketAluminiumOil ||
    				item == ShopKeeper.bucketAluminiumApple ||
    				item == ShopKeeper.bucketAluminiumBanana ||
    				item == ShopKeeper.bucketAluminiumCactusFruit ||
    				item == ShopKeeper.bucketAluminiumCherry ||
    				item == ShopKeeper.bucketAluminiumGrapes ||
    				item == ShopKeeper.bucketAluminiumLemon ||
    				item == ShopKeeper.bucketAluminiumOrange ||
    				item == ShopKeeper.bucketAluminiumPeach ||
    				item == ShopKeeper.bucketAluminiumPineapple ||
    				item == ShopKeeper.bucketAluminiumTomato ||
    				item == ShopKeeper.bucketAluminiumMilk ||
    				item == ShopKeeper.bucketAluminiumCoconutMilk){
    			return ShopKeeper.bucketAluminiumEmpty;
    		}
    		if(item == ShopKeeper.bucketLeadWater ||
    				item == ShopKeeper.bucketLeadOil ||
    				item == ShopKeeper.bucketLeadApple ||
    				item == ShopKeeper.bucketLeadBanana ||
    				item == ShopKeeper.bucketLeadCactusFruit ||
    				item == ShopKeeper.bucketLeadCherry ||
    				item == ShopKeeper.bucketLeadGrapes ||
    				item == ShopKeeper.bucketLeadLemon ||
    				item == ShopKeeper.bucketLeadOrange ||
    				item == ShopKeeper.bucketLeadPeach ||
    				item == ShopKeeper.bucketLeadPineapple ||
    				item == ShopKeeper.bucketLeadTomato ||
    				item == ShopKeeper.bucketLeadMilk ||
    				item == ShopKeeper.bucketLeadCoconutMilk){
    			return ShopKeeper.bucketLeadEmpty;
    		}
    		if(item == ShopKeeper.bucketBronzeWater ||
    				item == ShopKeeper.bucketBronzeOil ||
    				item == ShopKeeper.bucketBronzeApple ||
    				item == ShopKeeper.bucketBronzeBanana ||
    				item == ShopKeeper.bucketBronzeCactusFruit ||
    				item == ShopKeeper.bucketBronzeCherry ||
    				item == ShopKeeper.bucketBronzeGrapes ||
    				item == ShopKeeper.bucketBronzeLemon ||
    				item == ShopKeeper.bucketBronzeOrange ||
    				item == ShopKeeper.bucketBronzePeach ||
    				item == ShopKeeper.bucketBronzePineapple ||
    				item == ShopKeeper.bucketBronzeTomato ||
    				item == ShopKeeper.bucketBronzeMilk ||
    				item == ShopKeeper.bucketBronzeCoconutMilk){
    			return ShopKeeper.bucketBronzeEmpty;
    		}
    		if(item == ShopKeeper.bucketSteelWater ||
    				item == ShopKeeper.bucketSteelOil ||
    				item == ShopKeeper.bucketSteelApple ||
    				item == ShopKeeper.bucketSteelBanana ||
    				item == ShopKeeper.bucketSteelCactusFruit ||
    				item == ShopKeeper.bucketSteelCherry ||
    				item == ShopKeeper.bucketSteelGrapes ||
    				item == ShopKeeper.bucketSteelLemon ||
    				item == ShopKeeper.bucketSteelOrange ||
    				item == ShopKeeper.bucketSteelPeach ||
    				item == ShopKeeper.bucketSteelPineapple ||
    				item == ShopKeeper.bucketSteelTomato ||
    				item == ShopKeeper.bucketSteelMilk ||
    				item == ShopKeeper.bucketSteelCoconutMilk){
    			return ShopKeeper.bucketSteelEmpty;
    		}
    		if(item == ShopKeeper.bucketMythrilWater ||
    				item == ShopKeeper.bucketMythrilOil ||
    				item == ShopKeeper.bucketMythrilApple ||
    				item == ShopKeeper.bucketMythrilBanana ||
    				item == ShopKeeper.bucketMythrilCactusFruit ||
    				item == ShopKeeper.bucketMythrilCherry ||
    				item == ShopKeeper.bucketMythrilGrapes ||
    				item == ShopKeeper.bucketMythrilLemon ||
    				item == ShopKeeper.bucketMythrilOrange ||
    				item == ShopKeeper.bucketMythrilPeach ||
    				item == ShopKeeper.bucketMythrilPineapple ||
    				item == ShopKeeper.bucketMythrilTomato ||
    				item == ShopKeeper.bucketMythrilMilk ||
    				item == ShopKeeper.bucketMythrilCoconutMilk){
    			return ShopKeeper.bucketMythrilEmpty;
    		}
    		if(item == ShopKeeper.bucketAdamantiumWater ||
    				item == ShopKeeper.bucketAdamantiumOil ||
    				item == ShopKeeper.bucketAdamantiumApple ||
    				item == ShopKeeper.bucketAdamantiumBanana ||
    				item == ShopKeeper.bucketAdamantiumCactusFruit ||
    				item == ShopKeeper.bucketAdamantiumCherry ||
    				item == ShopKeeper.bucketAdamantiumGrapes ||
    				item == ShopKeeper.bucketAdamantiumLemon ||
    				item == ShopKeeper.bucketAdamantiumOrange ||
    				item == ShopKeeper.bucketAdamantiumPeach ||
    				item == ShopKeeper.bucketAdamantiumPineapple ||
    				item == ShopKeeper.bucketAdamantiumTomato ||
    				item == ShopKeeper.bucketAdamantiumMilk ||
    				item == ShopKeeper.bucketAdamantiumCoconutMilk){
    			return ShopKeeper.bucketAdamantiumEmpty;
    		}
    		if(item == ShopKeeper.bucketUnobtaniumWater ||
    				item == ShopKeeper.bucketUnobtaniumOil ||
    				item == ShopKeeper.bucketUnobtaniumApple ||
    				item == ShopKeeper.bucketUnobtaniumBanana ||
    				item == ShopKeeper.bucketUnobtaniumCactusFruit ||
    				item == ShopKeeper.bucketUnobtaniumCherry ||
    				item == ShopKeeper.bucketUnobtaniumGrapes ||
    				item == ShopKeeper.bucketUnobtaniumLemon ||
    				item == ShopKeeper.bucketUnobtaniumOrange ||
    				item == ShopKeeper.bucketUnobtaniumPeach ||
    				item == ShopKeeper.bucketUnobtaniumPineapple ||
    				item == ShopKeeper.bucketUnobtaniumTomato ||
    				item == ShopKeeper.bucketUnobtaniumMilk ||
    				item == ShopKeeper.bucketUnobtaniumCoconutMilk){
    			return ShopKeeper.bucketUnobtaniumEmpty;
    		}
    	}
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
    	if(0 == string.compareTo("Water")){
    		if(item == ShopKeeper.bucketWoodEmpty)       return ShopKeeper.bucketWoodWater;
    		if(item == ShopKeeper.bucketCopperEmpty)     return ShopKeeper.bucketCopperWater;
    		if(item == ShopKeeper.bucketIronEmpty)       return ShopKeeper.bucketIronWater;
    		if(item == ShopKeeper.bucketAluminiumEmpty)  return ShopKeeper.bucketAluminiumWater;
    		if(item == ShopKeeper.bucketLeadEmpty)       return ShopKeeper.bucketLeadWater;
    		if(item == ShopKeeper.bucketBronzeEmpty)     return ShopKeeper.bucketBronzeWater;
    		if(item == ShopKeeper.bucketSteelEmpty)      return ShopKeeper.bucketSteelWater;
    		if(item == ShopKeeper.bucketMythrilEmpty)    return ShopKeeper.bucketMythrilWater;
    		if(item == ShopKeeper.bucketAdamantiumEmpty) return ShopKeeper.bucketAdamantiumWater;
    		if(item == ShopKeeper.bucketUnobtaniumEmpty) return ShopKeeper.bucketUnobtaniumWater;
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
    		if(item == ShopKeeper.bucketLeadEmpty)       return ShopKeeper.bucketLeadCherry;
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
    	if(0 == string.compareTo("Milk")){
    		if(item == ShopKeeper.bucketWoodEmpty)       return ShopKeeper.bucketWoodMilk;
    		if(item == ShopKeeper.bucketCopperEmpty)     return ShopKeeper.bucketCopperMilk;
    		if(item == ShopKeeper.bucketIronEmpty)       return ShopKeeper.bucketIronMilk;
    		if(item == ShopKeeper.bucketAluminiumEmpty)  return ShopKeeper.bucketAluminiumMilk;
    		if(item == ShopKeeper.bucketLeadEmpty)       return ShopKeeper.bucketLeadMilk;
    		if(item == ShopKeeper.bucketBronzeEmpty)     return ShopKeeper.bucketBronzeMilk;
    		if(item == ShopKeeper.bucketSteelEmpty)      return ShopKeeper.bucketSteelMilk;
    		if(item == ShopKeeper.bucketMythrilEmpty)    return ShopKeeper.bucketMythrilMilk;
    		if(item == ShopKeeper.bucketAdamantiumEmpty) return ShopKeeper.bucketAdamantiumMilk;
    		if(item == ShopKeeper.bucketUnobtaniumEmpty) return ShopKeeper.bucketUnobtaniumMilk;
    	}
    	if(0 == string.compareTo("CoconutMilk")){
    		if(item == ShopKeeper.bucketWoodEmpty)       return ShopKeeper.bucketWoodCoconutMilk;
    		if(item == ShopKeeper.bucketCopperEmpty)     return ShopKeeper.bucketCopperCoconutMilk;
    		if(item == ShopKeeper.bucketIronEmpty)       return ShopKeeper.bucketIronCoconutMilk;
    		if(item == ShopKeeper.bucketAluminiumEmpty)  return ShopKeeper.bucketAluminiumCoconutMilk;
    		if(item == ShopKeeper.bucketLeadEmpty)       return ShopKeeper.bucketLeadCoconutMilk;
    		if(item == ShopKeeper.bucketBronzeEmpty)     return ShopKeeper.bucketBronzeCoconutMilk;
    		if(item == ShopKeeper.bucketSteelEmpty)      return ShopKeeper.bucketSteelCoconutMilk;
    		if(item == ShopKeeper.bucketMythrilEmpty)    return ShopKeeper.bucketMythrilCoconutMilk;
    		if(item == ShopKeeper.bucketAdamantiumEmpty) return ShopKeeper.bucketAdamantiumCoconutMilk;
    		if(item == ShopKeeper.bucketUnobtaniumEmpty) return ShopKeeper.bucketUnobtaniumCoconutMilk;
    	}
    	return item;
    }
    
    private Item changeBottle(Item item, String string){
    	if(0 == string.compareTo("empty")){
    		if(item == new ItemStack(Items.potionitem,1,0).getItem()) return Items.glass_bottle;
    		if(item == ShopKeeper.juiceOil)            return Items.glass_bottle;
    		if(item == ShopKeeper.juiceApple)          return Items.glass_bottle;
    		if(item == ShopKeeper.juiceBanana)         return Items.glass_bottle;
    		if(item == ShopKeeper.juiceCactus)         return Items.glass_bottle;
    		if(item == ShopKeeper.juiceCherry)         return Items.glass_bottle;
    		if(item == ShopKeeper.juiceCoconutMilk)    return Items.glass_bottle;
    		if(item == ShopKeeper.juiceGrapes)         return Items.glass_bottle;
    		if(item == ShopKeeper.juiceLemon)          return Items.glass_bottle;
    		if(item == ShopKeeper.juiceMilk)           return Items.glass_bottle;
    		if(item == ShopKeeper.juiceOrange)         return Items.glass_bottle;
    		if(item == ShopKeeper.juicePeach)          return Items.glass_bottle;
    		if(item == ShopKeeper.juicePineapple)      return Items.glass_bottle;
    		if(item == ShopKeeper.juiceTomato)         return Items.glass_bottle;
    		if(item == ShopKeeper.liquorCoconutRum)    return Items.glass_bottle;
    		if(item == ShopKeeper.liquorCider)         return Items.glass_bottle;
    		if(item == ShopKeeper.liquorRum)           return Items.glass_bottle;
    		if(item == ShopKeeper.liquorBeer)          return Items.glass_bottle;
    		if(item == ShopKeeper.liquorSalgam)        return Items.glass_bottle;
    		if(item == ShopKeeper.liquorVodka)         return Items.glass_bottle;
    		if(item == ShopKeeper.liquorCactusJack)    return Items.glass_bottle;
    		if(item == ShopKeeper.liquorSake)          return Items.glass_bottle;
    		if(item == ShopKeeper.liquorMead)          return Items.glass_bottle;
    		if(item == ShopKeeper.liquorWineGrapes)    return Items.glass_bottle;
    		if(item == ShopKeeper.liquorWineCherry)    return Items.glass_bottle;
    		if(item == ShopKeeper.liquorWinePineapple) return Items.glass_bottle;
    	}
    	if(item == Items.glass_bottle && 0 == string.compareTo("Water"))         return new ItemStack(Items.potionitem,1,0).getItem();
    	if(item == Items.glass_bottle && 0 == string.compareTo("Oil"))           return ShopKeeper.juiceOil;
    	if(item == Items.glass_bottle && 0 == string.compareTo("Apple"))         return ShopKeeper.juiceApple;
    	if(item == Items.glass_bottle && 0 == string.compareTo("Banana"))        return ShopKeeper.juiceBanana;
    	if(item == Items.glass_bottle && 0 == string.compareTo("Cactus"))        return ShopKeeper.juiceCactus;
    	if(item == Items.glass_bottle && 0 == string.compareTo("Cherry"))        return ShopKeeper.juiceCherry;
    	if(item == Items.glass_bottle && 0 == string.compareTo("CoconutMilk"))   return ShopKeeper.juiceCoconutMilk;
    	if(item == Items.glass_bottle && 0 == string.compareTo("Grapes"))        return ShopKeeper.juiceGrapes;
    	if(item == Items.glass_bottle && 0 == string.compareTo("Lemon"))         return ShopKeeper.juiceLemon;
    	if(item == Items.glass_bottle && 0 == string.compareTo("Milk"))          return ShopKeeper.juiceMilk;
    	if(item == Items.glass_bottle && 0 == string.compareTo("Orange"))        return ShopKeeper.juiceOrange;
    	if(item == Items.glass_bottle && 0 == string.compareTo("Peach"))         return ShopKeeper.juicePeach;
    	if(item == Items.glass_bottle && 0 == string.compareTo("Pineapple"))     return ShopKeeper.juicePineapple;
    	if(item == Items.glass_bottle && 0 == string.compareTo("Tomato"))        return ShopKeeper.juiceTomato;
    	if(item == Items.glass_bottle && 0 == string.compareTo("CoconutRum"))    return ShopKeeper.liquorCoconutRum;
    	if(item == Items.glass_bottle && 0 == string.compareTo("Cider"))         return ShopKeeper.liquorCider;
    	if(item == Items.glass_bottle && 0 == string.compareTo("Rum"))           return ShopKeeper.liquorRum;
    	if(item == Items.glass_bottle && 0 == string.compareTo("Beer"))          return ShopKeeper.liquorBeer;
    	if(item == Items.glass_bottle && 0 == string.compareTo("Salgam"))        return ShopKeeper.liquorSalgam;
    	if(item == Items.glass_bottle && 0 == string.compareTo("Vodka"))         return ShopKeeper.liquorVodka;
    	if(item == Items.glass_bottle && 0 == string.compareTo("CactusJack"))    return ShopKeeper.liquorCactusJack;
    	if(item == Items.glass_bottle && 0 == string.compareTo("Sake"))          return ShopKeeper.liquorSake;
    	if(item == Items.glass_bottle && 0 == string.compareTo("Mead"))          return ShopKeeper.liquorMead;
    	if(item == Items.glass_bottle && 0 == string.compareTo("WineGrapes"))    return ShopKeeper.liquorWineGrapes;
    	if(item == Items.glass_bottle && 0 == string.compareTo("WineCherry"))    return ShopKeeper.liquorWineCherry;
    	if(item == Items.glass_bottle && 0 == string.compareTo("WinePineapple")) return ShopKeeper.liquorWinePineapple;
    	return item;
    }
    
    public boolean smeltItem(){
    	if(this.itemStacks[0] != null){
    	if(0 == content.compareTo("empty")){
    		if(this.itemStacks[2] == null){
    			if(validateBucket(this.itemStacks[0].getItem(),"Water")){
    				this.itemStacks[2] = new ItemStack(changeBucket(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Water"; fillingLevel = 5; return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Water")){
    				this.itemStacks[2] = new ItemStack(changeBottle(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Water"; fillingLevel = 1; return true; }
    			
    			if(validateBucket(this.itemStacks[0].getItem(),"Oil")){
    				this.itemStacks[2] = new ItemStack(changeBucket(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Oil"; fillingLevel = 5; return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Oil")){
    				this.itemStacks[2] = new ItemStack(changeBottle(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Oil"; fillingLevel = 1; return true; }
    			
    			if(validateBucket(this.itemStacks[0].getItem(),"Apple")){
    				this.itemStacks[2] = new ItemStack(changeBucket(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Apple"; fillingLevel = 5; return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Apple")){
    				this.itemStacks[2] = new ItemStack(changeBottle(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Apple"; fillingLevel = 1; return true; }
    			
    			if(validateBucket(this.itemStacks[0].getItem(),"Banana")){
    				this.itemStacks[2] = new ItemStack(changeBucket(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Banana"; fillingLevel = 5; return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Banana")){
    				this.itemStacks[2] = new ItemStack(changeBottle(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Banana"; fillingLevel = 1; return true; }
    			
    			if(validateBucket(this.itemStacks[0].getItem(),"Cactus")){
    				this.itemStacks[2] = new ItemStack(changeBucket(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Cactus"; fillingLevel = 5; return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Cactus")){
    				this.itemStacks[2] = new ItemStack(changeBottle(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Cactus"; fillingLevel = 1; return true; }
    			
    			if(validateBucket(this.itemStacks[0].getItem(),"Cherry")){
    				this.itemStacks[2] = new ItemStack(changeBucket(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Cherry"; fillingLevel = 5; return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Cherry")){
    				this.itemStacks[2] = new ItemStack(changeBottle(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Cherry"; fillingLevel = 1; return true; }
    			
    			if(validateBucket(this.itemStacks[0].getItem(),"CoconutMilk")){
    				this.itemStacks[2] = new ItemStack(changeBucket(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "CoconutMilk"; fillingLevel = 5; return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"CoconutMilk")){
    				this.itemStacks[2] = new ItemStack(changeBottle(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "CoconutMilk"; fillingLevel = 1; return true; }
    			
    			if(validateBucket(this.itemStacks[0].getItem(),"Grapes")){
    				this.itemStacks[2] = new ItemStack(changeBucket(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Grapes"; fillingLevel = 5; return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Grapes")){
    				this.itemStacks[2] = new ItemStack(changeBottle(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Grapes"; fillingLevel = 1; return true; }
    			
    			if(validateBucket(this.itemStacks[0].getItem(),"Lemon")){
    				this.itemStacks[2] = new ItemStack(changeBucket(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Lemon"; fillingLevel = 5; return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Lemon")){
    				this.itemStacks[2] = new ItemStack(changeBottle(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Lemon"; fillingLevel = 1; return true; }
    			
    			if(validateBucket(this.itemStacks[0].getItem(),"Milk")){
    				this.itemStacks[2] = new ItemStack(changeBucket(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Milk"; fillingLevel = 5; return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Milk")){
    				this.itemStacks[2] = new ItemStack(changeBottle(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Milk"; fillingLevel = 1; return true; }
    			
    			if(validateBucket(this.itemStacks[0].getItem(),"Orange")){
    				this.itemStacks[2] = new ItemStack(changeBucket(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Orange"; fillingLevel = 5; return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Orange")){
    				this.itemStacks[2] = new ItemStack(changeBottle(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Orange"; fillingLevel = 1; return true; }
    			
    			if(validateBucket(this.itemStacks[0].getItem(),"Peach")){
    				this.itemStacks[2] = new ItemStack(changeBucket(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Peach"; fillingLevel = 5; return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Peach")){
    				this.itemStacks[2] = new ItemStack(changeBottle(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Peach"; fillingLevel = 1; return true; }
    			
    			if(validateBucket(this.itemStacks[0].getItem(),"Pineapple")){
    				this.itemStacks[2] = new ItemStack(changeBucket(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Pineapple"; fillingLevel = 5; return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Pineapple")){
    				this.itemStacks[2] = new ItemStack(changeBottle(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Pineapple"; fillingLevel = 1; return true; }
    			
    			if(validateBucket(this.itemStacks[0].getItem(),"Tomato")){
    				this.itemStacks[2] = new ItemStack(changeBucket(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Tomato"; fillingLevel = 5; return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Tomato")){
    				this.itemStacks[2] = new ItemStack(changeBottle(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Tomato"; fillingLevel = 1; return true; }
    			
    			if(validateBucket(this.itemStacks[0].getItem(),"CoconutRum")){
    				this.itemStacks[2] = new ItemStack(changeBucket(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "CoconutRum"; fillingLevel = 5; return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"CoconutRum")){
    				this.itemStacks[2] = new ItemStack(changeBottle(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "CoconutRum"; fillingLevel = 1; return true; }
    			
    			if(validateBucket(this.itemStacks[0].getItem(),"Cider")){
    				this.itemStacks[2] = new ItemStack(changeBucket(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Cider"; fillingLevel = 5; return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Cider")){
    				this.itemStacks[2] = new ItemStack(changeBottle(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Cider"; fillingLevel = 1; return true; }
    			
    			if(validateBucket(this.itemStacks[0].getItem(),"Rum")){
    				this.itemStacks[2] = new ItemStack(changeBucket(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Rum"; fillingLevel = 5; return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Rum")){
    				this.itemStacks[2] = new ItemStack(changeBottle(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Rum"; fillingLevel = 1; return true; }
    			
    			if(validateBucket(this.itemStacks[0].getItem(),"Beer")){
    				this.itemStacks[2] = new ItemStack(changeBucket(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Beer"; fillingLevel = 5; return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Beer")){
    				this.itemStacks[2] = new ItemStack(changeBottle(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Beer"; fillingLevel = 1; return true; }
    			
    			if(validateBucket(this.itemStacks[0].getItem(),"Salgam")){
    				this.itemStacks[2] = new ItemStack(changeBucket(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Salgam"; fillingLevel = 5; return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Salgam")){
    				this.itemStacks[2] = new ItemStack(changeBottle(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Salgam"; fillingLevel = 1; return true; }
    			
    			if(validateBucket(this.itemStacks[0].getItem(),"Vodka")){
    				this.itemStacks[2] = new ItemStack(changeBucket(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Vodka"; fillingLevel = 5; return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Vodka")){
    				this.itemStacks[2] = new ItemStack(changeBottle(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Vodka"; fillingLevel = 1; return true; }
    			
    			if(validateBucket(this.itemStacks[0].getItem(),"CactusJack")){
    				this.itemStacks[2] = new ItemStack(changeBucket(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "CactusJack"; fillingLevel = 5; return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"CactusJack")){
    				this.itemStacks[2] = new ItemStack(changeBottle(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "CactusJack"; fillingLevel = 1; return true; }

    			if(validateBucket(this.itemStacks[0].getItem(),"Sake")){
    				this.itemStacks[2] = new ItemStack(changeBucket(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Sake"; fillingLevel = 5; return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Sake")){
    				this.itemStacks[2] = new ItemStack(changeBottle(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Sake"; fillingLevel = 1; return true; }
    			
    			if(validateBucket(this.itemStacks[0].getItem(),"Mead")){
    				this.itemStacks[2] = new ItemStack(changeBucket(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Mead"; fillingLevel = 5; return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Mead")){
    				this.itemStacks[2] = new ItemStack(changeBottle(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "Mead"; fillingLevel = 1; return true; }
    			
    			if(validateBucket(this.itemStacks[0].getItem(),"WineGrapes")){
    				this.itemStacks[2] = new ItemStack(changeBucket(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "WineGrapes"; fillingLevel = 5; return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"WineGrapes")){
    				this.itemStacks[2] = new ItemStack(changeBottle(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "WineGrapes"; fillingLevel = 1; return true; }
    			
    			if(validateBucket(this.itemStacks[0].getItem(),"WineCherry")){
    				this.itemStacks[2] = new ItemStack(changeBucket(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "WineCherry"; fillingLevel = 5; return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"WineCherry")){
    				this.itemStacks[2] = new ItemStack(changeBottle(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "WineCherry"; fillingLevel = 1; return true; }
    			
    			if(validateBucket(this.itemStacks[0].getItem(),"WinePineapple")){
    				this.itemStacks[2] = new ItemStack(changeBucket(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "WinePineapple"; fillingLevel = 5; return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"WinePineapple")){
    				this.itemStacks[2] = new ItemStack(changeBottle(this.itemStacks[0].getItem(), "empty")); this.itemStacks[0] = null; content = "WinePineapple"; fillingLevel = 1; return true; }
    		}
    	}
    	if(0 == content.compareTo("Water")){
    		if(this.itemStacks[2] == null){
    			if(validateBucket(this.itemStacks[0].getItem(),"empty") && fillingLevel > 4){
    				this.itemStacks[2] = new ItemStack(changeBucket(itemStacks[0].getItem(),"Water")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 5; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBucket(this.itemStacks[0].getItem(),"Water") && fillingLevel < 23){
        				this.itemStacks[2] = new ItemStack(changeBucket(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 5; return true; }
    		}
    		if(this.itemStacks[2] == null){
    			if(validateBottle(this.itemStacks[0].getItem(),"empty") && fillingLevel > 1){
    				this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"Water")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Water") && fillingLevel < 25){
        			this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 1; return true;
        			}
    		}
    	}
    	if(0 == content.compareTo("Oil")){
    		if(this.itemStacks[2] == null){
    			if(validateBucket(this.itemStacks[0].getItem(),"empty") && fillingLevel > 4){
    				this.itemStacks[2] = new ItemStack(changeBucket(itemStacks[0].getItem(),"Oil")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 5; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBucket(this.itemStacks[0].getItem(),"Oil") && fillingLevel < 23){
        				this.itemStacks[2] = new ItemStack(changeBucket(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 5; return true; }
    		}
    		if(this.itemStacks[2] == null){
    			if(validateBottle(this.itemStacks[0].getItem(),"empty") && fillingLevel > 1){
    				this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"Oil")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Oil") && fillingLevel < 25){
        			this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 1; return true;
        			}
    		}
    	}
    	if(0 == content.compareTo("Apple")){
    		if(this.itemStacks[2] == null){
    			if(validateBucket(this.itemStacks[0].getItem(),"empty") && fillingLevel > 4){
    				this.itemStacks[2] = new ItemStack(changeBucket(itemStacks[0].getItem(),"Apple")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 5; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBucket(this.itemStacks[0].getItem(),"Apple") && fillingLevel < 23){
        				this.itemStacks[2] = new ItemStack(changeBucket(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 5; return true; }
    		}
    		if(this.itemStacks[2] == null){
    			if(validateBottle(this.itemStacks[0].getItem(),"empty") && fillingLevel > 1){
    				this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"Apple")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Apple") && fillingLevel < 25){
        			this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 1; return true;
        			}
    		}
    	}
    	if(0 == content.compareTo("Banana")){
    		if(this.itemStacks[2] == null){
    			if(validateBucket(this.itemStacks[0].getItem(),"empty") && fillingLevel > 4){
    				this.itemStacks[2] = new ItemStack(changeBucket(itemStacks[0].getItem(),"Banana")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 5; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBucket(this.itemStacks[0].getItem(),"Banana") && fillingLevel < 23){
        				this.itemStacks[2] = new ItemStack(changeBucket(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 5; return true; }
    		}
    		if(this.itemStacks[2] == null){
    			if(validateBottle(this.itemStacks[0].getItem(),"empty") && fillingLevel > 1){
    				this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"Banana")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Banana") && fillingLevel < 25){
        			this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 1; return true;
        			}
    		}
    	}
    	if(0 == content.compareTo("Cactus")){
    		if(this.itemStacks[2] == null){
    			if(validateBucket(this.itemStacks[0].getItem(),"empty") && fillingLevel > 4){
    				this.itemStacks[2] = new ItemStack(changeBucket(itemStacks[0].getItem(),"Cactus")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 5; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBucket(this.itemStacks[0].getItem(),"Cactus") && fillingLevel < 23){
        				this.itemStacks[2] = new ItemStack(changeBucket(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 5; return true; }
    		}
    		if(this.itemStacks[2] == null){
    			if(validateBottle(this.itemStacks[0].getItem(),"empty") && fillingLevel > 1){
    				this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"Cactus")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Cactus") && fillingLevel < 25){
        			this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 1; return true;
        			}
    		}
    	}
    	if(0 == content.compareTo("Cherry")){
    		if(this.itemStacks[2] == null){
    			if(validateBucket(this.itemStacks[0].getItem(),"empty") && fillingLevel > 4){
    				this.itemStacks[2] = new ItemStack(changeBucket(itemStacks[0].getItem(),"Cherry")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 5; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBucket(this.itemStacks[0].getItem(),"Cherry") && fillingLevel < 23){
        				this.itemStacks[2] = new ItemStack(changeBucket(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 5; return true; }
    		}
    		if(this.itemStacks[2] == null){
    			if(validateBottle(this.itemStacks[0].getItem(),"empty") && fillingLevel > 1){
    				this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"Cherry")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Cherry") && fillingLevel < 25){
        			this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 1; return true;
        			}
    		}
    	}
    	if(0 == content.compareTo("Milk")){
    		if(this.itemStacks[2] == null){
    			if(validateBucket(this.itemStacks[0].getItem(),"empty") && fillingLevel > 4){
    				this.itemStacks[2] = new ItemStack(changeBucket(itemStacks[0].getItem(),"Milk")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 5; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBucket(this.itemStacks[0].getItem(),"Milk") && fillingLevel < 23){
        				this.itemStacks[2] = new ItemStack(changeBucket(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 5; return true; }
    		}
    		if(this.itemStacks[2] == null){
    			if(validateBottle(this.itemStacks[0].getItem(),"empty") && fillingLevel > 1){
    				this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"Milk")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Milk") && fillingLevel < 25){
        			this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 1; return true;
        			}
    		}
    	}
    	if(0 == content.compareTo("CoconutMilk")){
    		if(this.itemStacks[2] == null){
    			if(validateBucket(this.itemStacks[0].getItem(),"empty") && fillingLevel > 4){
    				this.itemStacks[2] = new ItemStack(changeBucket(itemStacks[0].getItem(),"CoconutMilk")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 5; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBucket(this.itemStacks[0].getItem(),"CoconutMilk") && fillingLevel < 23){
        				this.itemStacks[2] = new ItemStack(changeBucket(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 5; return true; }
    		}
    		if(this.itemStacks[2] == null){
    			if(validateBottle(this.itemStacks[0].getItem(),"empty") && fillingLevel > 1){
    				this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"CoconutMilk")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"CoconutMilk") && fillingLevel < 25){
        			this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 1; return true;
        			}
    		}
    	}
    	if(0 == content.compareTo("Grapes")){
    		if(this.itemStacks[2] == null){
    			if(validateBucket(this.itemStacks[0].getItem(),"empty") && fillingLevel > 4){
    				this.itemStacks[2] = new ItemStack(changeBucket(itemStacks[0].getItem(),"Grapes")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 5; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBucket(this.itemStacks[0].getItem(),"Grapes") && fillingLevel < 23){
        				this.itemStacks[2] = new ItemStack(changeBucket(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 5; return true; }
    		}
    		if(this.itemStacks[2] == null){
    			if(validateBottle(this.itemStacks[0].getItem(),"empty") && fillingLevel > 1){
    				this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"Grapes")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Grapes") && fillingLevel < 25){
        			this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 1; return true;
        			}
    		}
    	}
    	if(0 == content.compareTo("Lemon")){
    		if(this.itemStacks[2] == null){
    			if(validateBucket(this.itemStacks[0].getItem(),"empty") && fillingLevel > 4){
    				this.itemStacks[2] = new ItemStack(changeBucket(itemStacks[0].getItem(),"Lemon")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 5; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBucket(this.itemStacks[0].getItem(),"Lemon") && fillingLevel < 23){
        				this.itemStacks[2] = new ItemStack(changeBucket(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 5; return true; }
    		}
    		if(this.itemStacks[2] == null){
    			if(validateBottle(this.itemStacks[0].getItem(),"empty") && fillingLevel > 1){
    				this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"Lemon")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Lemon") && fillingLevel < 25){
        			this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 1; return true;
        			}
    		}
    	}
    	if(0 == content.compareTo("Orange")){
    		if(this.itemStacks[2] == null){
    			if(validateBucket(this.itemStacks[0].getItem(),"empty") && fillingLevel > 4){
    				this.itemStacks[2] = new ItemStack(changeBucket(itemStacks[0].getItem(),"Orange")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 5; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBucket(this.itemStacks[0].getItem(),"Orange") && fillingLevel < 23){
        				this.itemStacks[2] = new ItemStack(changeBucket(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 5; return true; }
    		}
    		if(this.itemStacks[2] == null){
    			if(validateBottle(this.itemStacks[0].getItem(),"empty") && fillingLevel > 1){
    				this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"Orange")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Orange") && fillingLevel < 25){
        			this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 1; return true;
        			}
    		}
    	}
    	if(0 == content.compareTo("Peach")){
    		if(this.itemStacks[2] == null){
    			if(validateBucket(this.itemStacks[0].getItem(),"empty") && fillingLevel > 4){
    				this.itemStacks[2] = new ItemStack(changeBucket(itemStacks[0].getItem(),"Peach")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 5; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBucket(this.itemStacks[0].getItem(),"Peach") && fillingLevel < 23){
        				this.itemStacks[2] = new ItemStack(changeBucket(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 5; return true; }
    		}
    		if(this.itemStacks[2] == null){
    			if(validateBottle(this.itemStacks[0].getItem(),"empty") && fillingLevel > 1){
    				this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"Peach")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Peach") && fillingLevel < 25){
        			this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 1; return true;
        			}
    		}
    	}
    	if(0 == content.compareTo("Pineapple")){
    		if(this.itemStacks[2] == null){
    			if(validateBucket(this.itemStacks[0].getItem(),"empty") && fillingLevel > 4){
    				this.itemStacks[2] = new ItemStack(changeBucket(itemStacks[0].getItem(),"Pineapple")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 5; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBucket(this.itemStacks[0].getItem(),"Pineapple") && fillingLevel < 23){
        				this.itemStacks[2] = new ItemStack(changeBucket(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 5; return true; }
    		}
    		if(this.itemStacks[2] == null){
    			if(validateBottle(this.itemStacks[0].getItem(),"empty") && fillingLevel > 1){
    				this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"Pineapple")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Pineapple") && fillingLevel < 25){
        			this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 1; return true;
        			}
    		}
    	}
    	if(0 == content.compareTo("Tomato")){
    		if(this.itemStacks[2] == null){
    			if(validateBucket(this.itemStacks[0].getItem(),"empty") && fillingLevel > 4){
    				this.itemStacks[2] = new ItemStack(changeBucket(itemStacks[0].getItem(),"Tomato")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 5; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBucket(this.itemStacks[0].getItem(),"Tomato") && fillingLevel < 23){
        				this.itemStacks[2] = new ItemStack(changeBucket(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 5; return true; }
    		}
    		if(this.itemStacks[2] == null){
    			if(validateBottle(this.itemStacks[0].getItem(),"empty") && fillingLevel > 1){
    				this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"Tomato")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Tomato") && fillingLevel < 25){
        			this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 1; return true;
        			}
    		}
    	}
    	if(0 == content.compareTo("CoconutRum")){
    		if(this.itemStacks[2] == null){
    			if(validateBottle(this.itemStacks[0].getItem(),"empty") && fillingLevel > 1){
    				this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"CoconutRum")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty"; return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"CoconutRum") && fillingLevel < 25){
        			this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 1; return true;
        			}
    		}
    	}
    	if(0 == content.compareTo("Cider")){
    		if(this.itemStacks[2] == null){
    			if(validateBottle(this.itemStacks[0].getItem(),"empty") && fillingLevel > 1){
    				this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"Cider")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Cider") && fillingLevel < 25){
        			this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 1; return true;
        			}
    		}
    	}
    	if(0 == content.compareTo("Rum")){
    		if(this.itemStacks[2] == null){
    			if(validateBottle(this.itemStacks[0].getItem(),"empty") && fillingLevel > 1){
    				this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"Rum")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Rum") && fillingLevel < 25){
        			this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 1; return true;
        			}
    		}
    	}
    	if(0 == content.compareTo("Beer")){
    		if(this.itemStacks[2] == null){
    			if(validateBottle(this.itemStacks[0].getItem(),"empty") && fillingLevel > 1){
    				this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"Beer")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Beer") && fillingLevel < 25){
        			this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 1; return true;
        			}
    		}
    	}
    	if(0 == content.compareTo("Salgam")){
    		if(this.itemStacks[2] == null){
    			if(validateBottle(this.itemStacks[0].getItem(),"empty") && fillingLevel > 1){
    				this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"Salgam")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Salgam") && fillingLevel < 25){
        			this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 1; return true;
        			}
    		}
    	}
    	if(0 == content.compareTo("Vodka")){
    		if(this.itemStacks[2] == null){
    			if(validateBottle(this.itemStacks[0].getItem(),"empty") && fillingLevel > 1){
    				this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"Vodka")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Vodka") && fillingLevel < 25){
        			this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 1; return true;
        			}
    		}
    	}
    	if(0 == content.compareTo("CactusJack")){
    		if(this.itemStacks[2] == null){
    			if(validateBottle(this.itemStacks[0].getItem(),"empty") && fillingLevel > 1){
    				this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"CactusJack")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"CactusJack") && fillingLevel < 25){
        			this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 1; return true;
        			}
    		}
    	}
    	if(0 == content.compareTo("Sake")){
    		if(this.itemStacks[2] == null){
    			if(validateBottle(this.itemStacks[0].getItem(),"empty") && fillingLevel > 1){
    				this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"Sake")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Sake") && fillingLevel < 25){
        			this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 1; return true;
        			}
    		}
    	}
    	if(0 == content.compareTo("Mead")){
    		if(this.itemStacks[2] == null){
    			if(validateBottle(this.itemStacks[0].getItem(),"empty") && fillingLevel > 1){
    				this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"Mead")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"Mead") && fillingLevel < 25){
        			this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 1; return true;
        			}
    		}
    	}
    	if(0 == content.compareTo("WineGrapes")){
    		if(this.itemStacks[2] == null){
    			if(validateBottle(this.itemStacks[0].getItem(),"empty") && fillingLevel > 1){
    				this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"WineGrapes")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"WineGrapes") && fillingLevel < 25){
        			this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 1; return true;
        			}
    		}
    	}
    	if(0 == content.compareTo("WineCherry")){
    		if(this.itemStacks[2] == null){
    			if(validateBottle(this.itemStacks[0].getItem(),"empty") && fillingLevel > 1){
    				this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"WineCherry")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"WineCherry") && fillingLevel < 25){
        			this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 1; return true;
        			}
    		}
    	}
    	if(0 == content.compareTo("WinePineapple")){
    		if(this.itemStacks[2] == null){
    			if(validateBottle(this.itemStacks[0].getItem(),"empty") && fillingLevel > 1){
    				this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"WinePineapple")); this.itemStacks[0] = null; fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty";	return true; }
    			if(validateBottle(this.itemStacks[0].getItem(),"WinePineapple") && fillingLevel < 25){
        			this.itemStacks[2] = new ItemStack(changeBottle(itemStacks[0].getItem(),"empty")); this.itemStacks[0] = null; fillingLevel = fillingLevel + 1; return true;
        			}
    		}
    	}
    	} 
        return false;
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
    
    public static int getItemBurnTime(ItemStack stack){
        if (stack == null){
            return 0;
        }else{
            Item item = stack.getItem();
            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air){
                Block block = Block.getBlockFromItem(item);
                if (block == Blocks.wooden_slab) return 150;
                if (block.getMaterial() == Material.wood) return 300;
                if (block == Blocks.coal_block) return 16000;
            }
            if (item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemSword && ((ItemSword)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemHoe && ((ItemHoe)item).getToolMaterialName().equals("WOOD")) return 200;
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
    
    public boolean isItemValidForSlot(int slot, ItemStack stack){
        return slot == 2 ? false : (slot == 1 ? isItemFuel(stack) : true);
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
    
	public Item updateFillState(Item i){
		if(i != null){
			Item item = i;
	    	if(0 == content.compareTo("empty")){
	    			if(validateBucket(item,"Water")){ content = "Water"; fillingLevel = 5; return changeBucket(item, "empty"); }
	    			if(validateBottle(item,"Water")){ content = "Water"; fillingLevel = 1; return changeBottle(item, "empty"); }
	    			if(validateBucket(item,"Oil")){ content = "Oil"; fillingLevel = 5; return changeBucket(item, "empty"); }
	    			if(validateBottle(item,"Oil")){ content = "Oil"; fillingLevel = 1; return changeBottle(item, "empty"); }
	    			if(validateBucket(item,"Apple")){ content = "Apple"; fillingLevel = 5; return changeBucket(item, "empty"); }
	    			if(validateBottle(item,"Apple")){ content = "Apple"; fillingLevel = 1; return changeBottle(item, "empty"); }
	    			if(validateBucket(item,"Banana")){ content = "Banana"; fillingLevel = 5; return changeBucket(item, "empty"); }
	    			if(validateBottle(item,"Banana")){ content = "Banana"; fillingLevel = 1; return changeBottle(item, "empty"); }
	    			if(validateBucket(item,"Cactus")){ content = "Cactus"; fillingLevel = 5; return changeBucket(item, "empty"); }
	    			if(validateBottle(item,"Cactus")){ content = "Cactus"; fillingLevel = 1; return changeBottle(item, "empty"); }
	    			if(validateBucket(item,"Cherry")){ content = "Cherry"; fillingLevel = 5; return changeBucket(item, "empty"); }
	    			if(validateBottle(item,"Cherry")){ content = "Cherry"; fillingLevel = 1; return changeBottle(item, "empty"); }
	    			if(validateBucket(item,"CoconutMilk")){ content = "CoconutMilk"; fillingLevel = 5; return changeBucket(item, "empty"); }
	    			if(validateBottle(item,"CoconutMilk")){ content = "CoconutMilk"; fillingLevel = 1; return changeBottle(item, "empty"); }
	    			if(validateBucket(item,"Grapes")){ content = "Grapes"; fillingLevel = 5; return changeBucket(item, "empty"); }
	    			if(validateBottle(item,"Grapes")){ content = "Grapes"; fillingLevel = 1; return changeBottle(item, "empty"); }
	    			if(validateBucket(item,"Lemon")){ content = "Lemon"; fillingLevel = 5; return changeBucket(item, "empty"); }
	    			if(validateBottle(item,"Lemon")){ content = "Lemon"; fillingLevel = 1; return changeBottle(item, "empty"); }
	    			if(validateBucket(item,"Milk")){ content = "Milk"; fillingLevel = 5; return changeBucket(item, "empty"); }
	    			if(validateBottle(item,"Milk")){ content = "Milk"; fillingLevel = 1; return changeBottle(item, "empty"); }
	    			if(validateBucket(item,"Orange")){ content = "Orange"; fillingLevel = 5; return changeBucket(item, "empty"); }
	    			if(validateBottle(item,"Orange")){ content = "Orange"; fillingLevel = 1; return changeBottle(item, "empty"); }
	    			if(validateBucket(item,"Peach")){ content = "Peach"; fillingLevel = 5; return changeBucket(item, "empty"); }
	    			if(validateBottle(item,"Peach")){ content = "Peach"; fillingLevel = 1; return changeBottle(item, "empty"); }
	    			if(validateBucket(item,"Pineapple")){ content = "Pineapple"; fillingLevel = 5; return changeBucket(item, "empty"); }
	    			if(validateBottle(item,"Pineapple")){ content = "Pineapple"; fillingLevel = 1; return changeBottle(item, "empty"); }
	    			if(validateBucket(item,"Tomato")){ content = "Tomato"; fillingLevel = 5; return changeBucket(item, "empty"); }
	    			if(validateBottle(item,"Tomato")){ content = "Tomato"; fillingLevel = 1; return changeBottle(item, "empty"); }
	    			if(validateBottle(item,"CoconutRum")){ content = "CoconutRum"; fillingLevel = 1; return changeBottle(item, "empty"); }
	    			if(validateBottle(item,"Cider")){ content = "Cider"; fillingLevel = 1; return changeBottle(item, "empty"); }
	    			if(validateBottle(item,"Rum")){ content = "Rum"; fillingLevel = 1; return changeBottle(item, "empty"); }
	    			if(validateBottle(item,"Beer")){ content = "Beer"; fillingLevel = 1; return changeBottle(item, "empty"); }
	    			if(validateBottle(item,"Salgam")){ content = "Salgam"; fillingLevel = 1; return changeBottle(item, "empty"); }
	    			if(validateBottle(item,"Vodka")){ content = "Vodka"; fillingLevel = 1; return changeBottle(item, "empty"); }
	    			if(validateBottle(item,"CactusJack")){ content = "CactusJack"; fillingLevel = 1; return changeBottle(item, "empty"); }
	    			if(validateBottle(item,"Sake")){ content = "Sake"; fillingLevel = 1; return changeBottle(item, "empty"); }
	    			if(validateBottle(item,"Mead")){ content = "Mead"; fillingLevel = 1; return changeBottle(item, "empty"); }
	    			if(validateBottle(item,"WineGrapes")){ content = "WineGrapes"; fillingLevel = 1; return changeBottle(item, "empty"); }
	    			if(validateBottle(item,"WineCherry")){ content = "WineCherry"; fillingLevel = 1; return changeBottle(item, "empty"); }
	    			if(validateBottle(item,"WinePineapple")){ content = "WinePineapple"; fillingLevel = 1; return changeBottle(item, "empty"); }
	    	}
	    	if(0 == content.compareTo("Water")){
	    		if(validateBucket(item,"empty") && fillingLevel > 4){
	    			fillingLevel = fillingLevel - 5; if(fillingLevel == 0) content = "empty"; return changeBucket(item,"Water"); }
	    		if(validateBucket(item,"Water") && fillingLevel < 23){
	    			fillingLevel = fillingLevel + 5;                                          return changeBucket(item,"empty"); }
	    		if(validateBottle(item,"empty") && fillingLevel > 1){
	    			fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty"; return changeBottle(item,"Water"); }
	    		if(validateBottle(item,"Water") && fillingLevel < 25){
	    			fillingLevel = fillingLevel + 1;                                          return changeBottle(item,"empty"); }
	    	}
	    	
	    	if(0 == content.compareTo("Oil")){
	    		if(validateBucket(item,"empty") && fillingLevel > 4){
	    			fillingLevel = fillingLevel - 5; if(fillingLevel == 0) content = "empty"; return changeBucket(item,"Oil"); }
	    		if(validateBucket(item,"Oil") && fillingLevel < 23){
	    			fillingLevel = fillingLevel + 5;                                          return changeBucket(item,"empty"); }
	    		if(validateBottle(item,"empty") && fillingLevel > 1){
	    			fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty"; return changeBottle(item,"Oil"); }
	    		if(validateBottle(item,"Oil") && fillingLevel < 25){
	    			fillingLevel = fillingLevel + 1;                                          return changeBottle(item,"empty"); }
	    	}
	    	
	    	if(0 == content.compareTo("Apple")){
	    		if(validateBucket(item,"empty") && fillingLevel > 4){
	    			fillingLevel = fillingLevel - 5; if(fillingLevel == 0) content = "empty"; return changeBucket(item,"Apple"); }
	    		if(validateBucket(item,"Apple") && fillingLevel < 23){
	    			fillingLevel = fillingLevel + 5;                                          return changeBucket(item,"empty"); }
	    		if(validateBottle(item,"empty") && fillingLevel > 1){
	    			fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty"; return changeBottle(item,"Apple"); }
	    		if(validateBottle(item,"Apple") && fillingLevel < 25){
	    			fillingLevel = fillingLevel + 1;                                          return changeBottle(item,"empty"); }
	    	}
	    	
	    	if(0 == content.compareTo("Banana")){
	    		if(validateBucket(item,"empty") && fillingLevel > 4){
	    			fillingLevel = fillingLevel - 5; if(fillingLevel == 0) content = "empty"; return changeBucket(item,"Banana"); }
	    		if(validateBucket(item,"Banana") && fillingLevel < 23){
	    			fillingLevel = fillingLevel + 5;                                          return changeBucket(item,"empty"); }
	    		if(validateBottle(item,"empty") && fillingLevel > 1){
	    			fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty"; return changeBottle(item,"Banana"); }
	    		if(validateBottle(item,"Banana") && fillingLevel < 25){
	    			fillingLevel = fillingLevel + 1;                                          return changeBottle(item,"empty"); }
	    	}
	    	
	    	if(0 == content.compareTo("Cactus")){
	    		if(validateBucket(item,"empty") && fillingLevel > 4){
	    			fillingLevel = fillingLevel - 5; if(fillingLevel == 0) content = "empty"; return changeBucket(item,"Cactus"); }
	    		if(validateBucket(item,"Cactus") && fillingLevel < 23){
	    			fillingLevel = fillingLevel + 5;                                          return changeBucket(item,"empty"); }
	    		if(validateBottle(item,"empty") && fillingLevel > 1){
	    			fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty"; return changeBottle(item,"Cactus"); }
	    		if(validateBottle(item,"Cactus") && fillingLevel < 25){
	    			fillingLevel = fillingLevel + 1;                                          return changeBottle(item,"empty"); }
	    	}
	    	
	    	if(0 == content.compareTo("Cherry")){
	    		if(validateBucket(item,"empty") && fillingLevel > 4){
	    			fillingLevel = fillingLevel - 5; if(fillingLevel == 0) content = "empty"; return changeBucket(item,"Cherry"); }
	    		if(validateBucket(item,"Cherry") && fillingLevel < 23){
	    			fillingLevel = fillingLevel + 5;                                          return changeBucket(item,"empty"); }
	    		if(validateBottle(item,"empty") && fillingLevel > 1){
	    			fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty"; return changeBottle(item,"Cherry"); }
	    		if(validateBottle(item,"Cherry") && fillingLevel < 25){
	    			fillingLevel = fillingLevel + 1;                                          return changeBottle(item,"empty"); }
	    	}
	    	
	    	if(0 == content.compareTo("Milk")){
	    		if(validateBucket(item,"empty") && fillingLevel > 4){
	    			fillingLevel = fillingLevel - 5; if(fillingLevel == 0) content = "empty"; return changeBucket(item,"Milk"); }
	    		if(validateBucket(item,"Milk") && fillingLevel < 23){
	    			fillingLevel = fillingLevel + 5;                                          return changeBucket(item,"empty"); }
	    		if(validateBottle(item,"empty") && fillingLevel > 1){
	    			fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty"; return changeBottle(item,"Milk"); }
	    		if(validateBottle(item,"Milk") && fillingLevel < 25){
	    			fillingLevel = fillingLevel + 1;                                          return changeBottle(item,"empty"); }
	    	}
	    	
	    	if(0 == content.compareTo("CoconutMilk")){
	    		if(validateBucket(item,"empty") && fillingLevel > 4){
	    			fillingLevel = fillingLevel - 5; if(fillingLevel == 0) content = "empty"; return changeBucket(item,"CoconutMilk"); }
	    		if(validateBucket(item,"CoconutMilk") && fillingLevel < 23){
	    			fillingLevel = fillingLevel + 5;                                          return changeBucket(item,"empty"); }
	    		if(validateBottle(item,"empty") && fillingLevel > 1){
	    			fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty"; return changeBottle(item,"CoconutMilk"); }
	    		if(validateBottle(item,"CoconutMilk") && fillingLevel < 25){
	    			fillingLevel = fillingLevel + 1;                                          return changeBottle(item,"empty"); }
	    	}
	    	
	    	if(0 == content.compareTo("Grapes")){
	    		if(validateBucket(item,"empty") && fillingLevel > 4){
	    			fillingLevel = fillingLevel - 5; if(fillingLevel == 0) content = "empty"; return changeBucket(item,"Grapes"); }
	    		if(validateBucket(item,"Grapes") && fillingLevel < 23){
	    			fillingLevel = fillingLevel + 5;                                          return changeBucket(item,"empty"); }
	    		if(validateBottle(item,"empty") && fillingLevel > 1){
	    			fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty"; return changeBottle(item,"Grapes"); }
	    		if(validateBottle(item,"Grapes") && fillingLevel < 25){
	    			fillingLevel = fillingLevel + 1;                                          return changeBottle(item,"empty"); }
	    	}
	    	
	    	if(0 == content.compareTo("Lemon")){
	    		if(validateBucket(item,"empty") && fillingLevel > 4){
	    			fillingLevel = fillingLevel - 5; if(fillingLevel == 0) content = "empty"; return changeBucket(item,"Lemon"); }
	    		if(validateBucket(item,"Lemon") && fillingLevel < 23){
	    			fillingLevel = fillingLevel + 5;                                          return changeBucket(item,"empty"); }
	    		if(validateBottle(item,"empty") && fillingLevel > 1){
	    			fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty"; return changeBottle(item,"Lemon"); }
	    		if(validateBottle(item,"Lemon") && fillingLevel < 25){
	    			fillingLevel = fillingLevel + 1;                                          return changeBottle(item,"empty"); }
	    	}
	    	
	    	if(0 == content.compareTo("Orange")){
	    		if(validateBucket(item,"empty") && fillingLevel > 4){
	    			fillingLevel = fillingLevel - 5; if(fillingLevel == 0) content = "empty"; return changeBucket(item,"Orange"); }
	    		if(validateBucket(item,"Orange") && fillingLevel < 23){
	    			fillingLevel = fillingLevel + 5;                                          return changeBucket(item,"empty"); }
	    		if(validateBottle(item,"empty") && fillingLevel > 1){
	    			fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty"; return changeBottle(item,"Orange"); }
	    		if(validateBottle(item,"Orange") && fillingLevel < 25){
	    			fillingLevel = fillingLevel + 1;                                          return changeBottle(item,"empty"); }
	    	}
	    	
	    	if(0 == content.compareTo("Peach")){
	    		if(validateBucket(item,"empty") && fillingLevel > 4){
	    			fillingLevel = fillingLevel - 5; if(fillingLevel == 0) content = "empty"; return changeBucket(item,"Peach"); }
	    		if(validateBucket(item,"Peach") && fillingLevel < 23){
	    			fillingLevel = fillingLevel + 5;                                          return changeBucket(item,"empty"); }
	    		if(validateBottle(item,"empty") && fillingLevel > 1){
	    			fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty"; return changeBottle(item,"Peach"); }
	    		if(validateBottle(item,"Peach") && fillingLevel < 25){
	    			fillingLevel = fillingLevel + 1;                                          return changeBottle(item,"empty"); }
	    	}
	    	
	    	if(0 == content.compareTo("Pineapple")){
	    		if(validateBucket(item,"empty") && fillingLevel > 4){
	    			fillingLevel = fillingLevel - 5; if(fillingLevel == 0) content = "empty"; return changeBucket(item,"Pineapple"); }
	    		if(validateBucket(item,"Pineapple") && fillingLevel < 23){
	    			fillingLevel = fillingLevel + 5;                                          return changeBucket(item,"empty"); }
	    		if(validateBottle(item,"empty") && fillingLevel > 1){
	    			fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty"; return changeBottle(item,"Pineapple"); }
	    		if(validateBottle(item,"Pineapple") && fillingLevel < 25){
	    			fillingLevel = fillingLevel + 1;                                          return changeBottle(item,"empty"); }
	    	}
	    	
	    	if(0 == content.compareTo("Tomato")){
	    		if(validateBucket(item,"empty") && fillingLevel > 4){
	    			fillingLevel = fillingLevel - 5; if(fillingLevel == 0) content = "empty"; return changeBucket(item,"Tomato"); }
	    		if(validateBucket(item,"Tomato") && fillingLevel < 23){
	    			fillingLevel = fillingLevel + 5;                                          return changeBucket(item,"empty"); }
	    		if(validateBottle(item,"empty") && fillingLevel > 1){
	    			fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty"; return changeBottle(item,"Tomato"); }
	    		if(validateBottle(item,"Tomato") && fillingLevel < 25){
	    			fillingLevel = fillingLevel + 1;                                          return changeBottle(item,"empty"); }
	    	}
	    	
	    	if(0 == content.compareTo("CoconutRum")){
	    		if(validateBottle(item,"empty") && fillingLevel > 1){
	    			fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty"; return changeBottle(item,"CoconutRum"); }
	    		if(validateBottle(item,"CoconutRum") && fillingLevel < 25){
	    			fillingLevel = fillingLevel + 1;                                          return changeBottle(item,"empty"); }
	    	}
	    	
	    	if(0 == content.compareTo("Cider")){
	    		if(validateBottle(item,"empty") && fillingLevel > 1){
	    			fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty"; return changeBottle(item,"Cider"); }
	    		if(validateBottle(item,"Cider") && fillingLevel < 25){
	    			fillingLevel = fillingLevel + 1;                                          return changeBottle(item,"empty"); }
	    	}
	    	
	    	if(0 == content.compareTo("Rum")){
	    		if(validateBottle(item,"empty") && fillingLevel > 1){
	    			fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty"; return changeBottle(item,"Rum"); }
	    		if(validateBottle(item,"Rum") && fillingLevel < 25){
	    			fillingLevel = fillingLevel + 1;                                          return changeBottle(item,"empty"); }
	    	}
	    	
	    	if(0 == content.compareTo("Beer")){
	    		if(validateBottle(item,"empty") && fillingLevel > 1){
	    			fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty"; return changeBottle(item,"Beer"); }
	    		if(validateBottle(item,"Beer") && fillingLevel < 25){
	    			fillingLevel = fillingLevel + 1;                                          return changeBottle(item,"empty"); }
	    	}
	    	
	    	if(0 == content.compareTo("Salgam")){
	    		if(validateBottle(item,"empty") && fillingLevel > 1){
	    			fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty"; return changeBottle(item,"Salgam"); }
	    		if(validateBottle(item,"Salgam") && fillingLevel < 25){
	    			fillingLevel = fillingLevel + 1;                                          return changeBottle(item,"empty"); }
	    	}
	    	
	    	if(0 == content.compareTo("Vodka")){
	    		if(validateBottle(item,"empty") && fillingLevel > 1){
	    			fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty"; return changeBottle(item,"Vodka"); }
	    		if(validateBottle(item,"Vodka") && fillingLevel < 25){
	    			fillingLevel = fillingLevel + 1;                                          return changeBottle(item,"empty"); }
	    	}
	    	
	    	if(0 == content.compareTo("CactusJack")){
	    		if(validateBottle(item,"empty") && fillingLevel > 1){
	    			fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty"; return changeBottle(item,"CactusJack"); }
	    		if(validateBottle(item,"CactusJack") && fillingLevel < 25){
	    			fillingLevel = fillingLevel + 1;                                          return changeBottle(item,"empty"); }
	    	}
	    	
	    	if(0 == content.compareTo("Sake")){
	    		if(validateBottle(item,"empty") && fillingLevel > 1){
	    			fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty"; return changeBottle(item,"Sake"); }
	    		if(validateBottle(item,"Sake") && fillingLevel < 25){
	    			fillingLevel = fillingLevel + 1;                                          return changeBottle(item,"empty"); }
	    	}
	    	
	    	if(0 == content.compareTo("Mead")){
	    		if(validateBottle(item,"empty") && fillingLevel > 1){
	    			fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty"; return changeBottle(item,"Mead"); }
	    		if(validateBottle(item,"Mead") && fillingLevel < 25){
	    			fillingLevel = fillingLevel + 1;                                          return changeBottle(item,"empty"); }
	    	}
	    	
	    	if(0 == content.compareTo("WineGrapes")){
	    		if(validateBottle(item,"empty") && fillingLevel > 1){
	    			fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty"; return changeBottle(item,"WineGrapes"); }
	    		if(validateBottle(item,"WineGrapes") && fillingLevel < 25){
	    			fillingLevel = fillingLevel + 1;                                          return changeBottle(item,"empty"); }
	    	}
	    	
	    	if(0 == content.compareTo("WineCherry")){
	    		if(validateBottle(item,"empty") && fillingLevel > 1){
	    			fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty"; return changeBottle(item,"WineCherry"); }
	    		if(validateBottle(item,"WineCherry") && fillingLevel < 25){
	    			fillingLevel = fillingLevel + 1;                                          return changeBottle(item,"empty"); }
	    	}
	    	
	    	if(0 == content.compareTo("WinePineapple")){
	    		if(validateBottle(item,"empty") && fillingLevel > 1){
	    			fillingLevel = fillingLevel - 1; if(fillingLevel == 0) content = "empty"; return changeBottle(item,"WinePineapple"); }
	    		if(validateBottle(item,"WinePineapple") && fillingLevel < 25){
	    			fillingLevel = fillingLevel + 1;                                          return changeBottle(item,"empty"); }
	    	}
		}
		return i;
	}

}