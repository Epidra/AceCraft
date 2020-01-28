package mod.acecraft.tileentities;

public class TileEntityFruitPress {

}

//public class TileEntityFruitPress extends ITileEntityEnergy implements ISidedInventory {
//
//    public static final int[] SLOTS_TOP    = new int[] {0};
//    public static final int[] SLOTS_BOTTOM = new int[] {2};
//    public static final int[] SLOTS_SIDES  = new int[] {1};
//    protected NonNullList<ItemStack> itemStacks = NonNullList.withSize(3, ItemStack.EMPTY);
//    public int burnTime;
//    public int currentItemBurnTime;
//    public int cookTime;
//    public String field;
//    public int energy = 0;
//    public String content = "empty";
//    public int fillingLevel = 0;
//
//    public TileEntityFruitPress(){
//
//    }
//
//    /** Returns the number of slots in the inventory. */
//    public int getSizeInventory(){
//        return this.itemStacks.size();
//    }
//
//    /** Returns the stack in the given slot. */
//    @Nullable
//    public ItemStack getStackInSlot(int index){
//        return this.itemStacks.get(index);
//    }
//
//    /** Removes up to a specified number of items from an inventory slot and returns them in a new stack. */
//    @Nullable
//    public ItemStack decrStackSize(int index, int count){
//        return ItemStackHelper.getAndSplit(this.itemStacks, index, count);
//    }
//
//    /** Removes a stack from the given slot and returns it. */
//    @Nullable
//    public ItemStack removeStackFromSlot(int index){
//        return ItemStackHelper.getAndRemove(this.itemStacks, index);
//    }
//
//    /** Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections). */
//    public void setInventorySlotContents(int index, @Nullable ItemStack stack){
//        boolean flag = stack != null && stack.isItemEqual(this.itemStacks.get(index)) && ItemStack.areItemStackTagsEqual(stack, this.itemStacks.get(index));
//        this.itemStacks.set(index, stack);
//        if (stack != null && stack.getCount() > this.getInventoryStackLimit()){
//            stack.setCount(this.getInventoryStackLimit());
//        }
//        if (index == 0 && !flag){
//            //this.totalCookTime = this.getCookTime(stack);
//            this.cookTime = 0;
//            this.markDirty();
//        }
//    }
//
//    /** Get the name of this object. For players this returns their username */
//    public String getName(){
//        return "container.furnace";
//    }
//
//    /** Returns true if this thing is named */
//    public boolean hasCustomName(){
//        return false;
//    }
//
//    /*public void readFromNBT(NBTTagCompound compound){
//    	super.readFromNBT(compound);
//        NBTTagList nbttaglist = compound.getTagList("Items", 10);
//        this.itemStacks = new ItemStack[this.getSizeInventory()];
//        for (int i = 0; i < nbttaglist.tagCount(); ++i){
//            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
//            byte b0 = nbttagcompound1.getByte("Slot");
//            if (b0 >= 0 && b0 < this.itemStacks.length){
//                this.itemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
//            }
//        }
//        this.energy       = compound.getShort("energy");
//        this.burnTime     = compound.getShort("BurnTime");
//        this.cookTime     = compound.getShort("CookTime");
//        this.content      = compound.getString("Content");
//        this.fillingLevel = compound.getShort("FillingLevel");
//    }
//
//    public NBTTagCompound writeToNBT(NBTTagCompound compound){
//    	super.writeToNBT(compound);
//    	NBTTagList nbttaglist = new NBTTagList();
//        for (int i = 0; i < this.itemStacks.length; ++i){
//            if (this.itemStacks[i] != null){
//                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
//                nbttagcompound1.setByte("Slot", (byte)i);
//                this.itemStacks[i].writeToNBT(nbttagcompound1);
//                nbttaglist.appendTag(nbttagcompound1);
//            }
//        }
//        compound.setTag("Items", nbttaglist);
//    	compound.setShort("energy",       (short)this.energy);
//    	compound.setShort("BurnTime",     (short)this.burnTime);
//    	compound.setShort("CookTime",     (short)this.cookTime);
//    	compound.setString("Content",    (String)this.content);
//    	compound.setShort("FillingLevel", (short)this.fillingLevel);
//        return compound;
//    }*/
//
//    /** Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. */
//    public int getInventoryStackLimit(){
//        return 64;
//    }
//
//    /** Furnace isBurning */
//    public boolean isBurning(){
//        return this.burnTime > 0;
//    }
//
//    @SideOnly(Side.CLIENT)
//    public static boolean isBurning(IInventory inventory){
//        return inventory.getField(0) > 0;
//    }
//
//    @SideOnly(Side.CLIENT)
//    public int getCookProgressScaled(){
//        return (this.cookTime - energy) / 3;
//    }
//
//    @SideOnly(Side.CLIENT)
//    public int getEnergyScaled(){
//        return energy / 4;
//    }
//
//    public boolean hasEnergy(){
//        return this.energy > 0;
//    }
//
//    public void update(){
//        boolean flag1 = false;
//        if(world.getBlockState(pos.up(2)).getBlock() == ShopKeeper.MACHINA_AXLE){
//            TileEntityAxle entityA = (TileEntityAxle) world.getTileEntity(pos.up(2));
//            energy = entityA.energy;
//        }else
//        if(world.getBlockState(pos.up(2)).getBlock() == ShopKeeper.MACHINA_GEARBOX){
//            TileEntityGearBox entityG = (TileEntityGearBox) world.getTileEntity(pos.up(2));
//            energy = entityG.energy;
//        }else{
//            energy = 0;
//        }
//        if(!this.world.isRemote){
//            if (this.hasEnergy() && this.canSmelt()){
//                ++this.cookTime;
//                if (this.cookTime == 300-energy){
//                    this.cookTime = 0;
//                    this.smeltItem();
//                    flag1 = true;
//                }
//            }else{
//                this.cookTime = 0;
//            }
//            if(fillingLevel > 4 && itemStacks.get(1) != null){
//                Item temp = changeBucket(itemStacks.get(1).getItem(), content);
//                if(itemStacks.get(1).getItem() != temp){
//                    if(itemStacks.get(2) == null){
//                        itemStacks.set(2, new ItemStack(temp));
//                        this.itemStacks.get(1).shrink(1);
//                        if (this.itemStacks.get(1).getCount() <= 0) this.itemStacks.set(1, null);
//                        fillingLevel = fillingLevel - 5;
//                        if(fillingLevel == 0) content = "empty";
//                        flag1 = true;
//                    }else
//                    if(itemStacks.get(2).getItem() == temp && itemStacks.get(2).isStackable() && itemStacks.get(2).getCount() < 64){
//                        this.itemStacks.get(2).grow(1);
//                        this.itemStacks.get(1).shrink(1);
//                        if (this.itemStacks.get(1).getCount() <= 0) this.itemStacks.set(1, null);
//                        fillingLevel = fillingLevel - 5;
//                        if(fillingLevel == 0) content = "empty";
//                        flag1 = true;
//                    }
//                }
//            }
//            if(fillingLevel > 0 && itemStacks.get(1) != null){
//                Item temp = changeBottle(itemStacks.get(1).getItem(), content);
//                if(itemStacks.get(1).getItem() != temp){
//                    if(itemStacks.get(2) == null){
//                        itemStacks.set(2, new ItemStack(temp));
//                        this.itemStacks.get(1).shrink(1);
//                        if (this.itemStacks.get(1).getCount() <= 0) this.itemStacks.set(1, null);
//                        fillingLevel = fillingLevel - 1;
//                        if(fillingLevel == 0) content = "empty";
//                        flag1 = true;
//                    }else
//                    if(itemStacks.get(2).getItem() == temp && itemStacks.get(2).isStackable() && itemStacks.get(2).getCount() < 64){
//                        this.itemStacks.get(2).grow(1);
//                        this.itemStacks.get(1).shrink(1);
//                        if (this.itemStacks.get(1).getCount() <= 0) this.itemStacks.set(1, null);
//                        fillingLevel = fillingLevel - 1;
//                        if(fillingLevel == 0) content = "empty";
//                        flag1 = true;
//                    }
//                }
//            }
//        }
//        if (flag1){
//            this.markDirty();
//        }
//    }
//
//    private boolean canSmelt(){
//        if (this.itemStacks.get(0) == null){
//            return false;
//        }else{
//            if((0 == content.compareTo("Oil")       || 0 == content.compareTo("empty")) && fillingLevel < 25 && this.itemStacks.get(0).getItem() == new ItemStack(Blocks.DOUBLE_PLANT, 1, 0).getItem()) return true;
//            return (0 == content.compareTo("Apple") || 0 == content.compareTo("empty")) && fillingLevel < 25 && this.itemStacks.get(0).getItem() == Items.APPLE;
//            //if((0 == content.compareTo("Banana")    || 0 == content.compareTo("empty")) && fillingLevel < 25 && this.itemStacks.get(0).getItem() == ShopKeeper.foodBanana)                              return true;
//            //if((0 == content.compareTo("Cherry")    || 0 == content.compareTo("empty")) && fillingLevel < 25 && this.itemStacks.get(0).getItem() == ShopKeeper.foodCherries)                            return true;
//            //if((0 == content.compareTo("Grapes")    || 0 == content.compareTo("empty")) && fillingLevel < 25 && this.itemStacks.get(0).getItem() == ShopKeeper.FOOD_GRAPES)                              return true;
//            //if((0 == content.compareTo("Lemon")     || 0 == content.compareTo("empty")) && fillingLevel < 25 && this.itemStacks.get(0).getItem() == ShopKeeper.foodLemon)                               return true;
//            //if((0 == content.compareTo("Orange")    || 0 == content.compareTo("empty")) && fillingLevel < 25 && this.itemStacks.get(0).getItem() == ShopKeeper.foodOrange)                              return true;
//            //if((0 == content.compareTo("Peach")     || 0 == content.compareTo("empty")) && fillingLevel < 25 && this.itemStacks.get(0).getItem() == ShopKeeper.foodPeach)                               return true;
//            //if((0 == content.compareTo("Pineapple") || 0 == content.compareTo("empty")) && fillingLevel < 25 && this.itemStacks.get(0).getItem() == ShopKeeper.FOOD_PINEAPPLE)                           return true;
//            //if((0 == content.compareTo("Tomato")    || 0 == content.compareTo("empty")) && fillingLevel < 25 && this.itemStacks.get(0).getItem() == ShopKeeper.FOOD_TOMATO)                              return true;
//        }
//    }
//
//    public void smeltItem(){
//        if (this.canSmelt()){
//            if(this.itemStacks.get(0).getItem() == new ItemStack(Blocks.DOUBLE_PLANT, 1, 0).getItem()){ fillingLevel++; if(0 == content.compareTo("empty")) content = "Oil"; }
//            if(this.itemStacks.get(0).getItem() == Items.APPLE)                                       { fillingLevel++; if(0 == content.compareTo("empty")) content = "Apple"; }
//            //if(this.itemStacks.get(0).getItem() == ShopKeeper.foodBanana)                             { fillingLevel++; if(0 == content.compareTo("empty")) content = "Banana"; }
//            //if(this.itemStacks.get(0).getItem() == ShopKeeper.foodCherries)                           { fillingLevel++; if(0 == content.compareTo("empty")) content = "Cherry"; }
//            //if(this.itemStacks.get(0).getItem() == ShopKeeper.FOOD_GRAPES)                             { fillingLevel++; if(0 == content.compareTo("empty")) content = "Grapes"; }
//            //if(this.itemStacks.get(0).getItem() == ShopKeeper.foodLemon)                              { fillingLevel++; if(0 == content.compareTo("empty")) content = "Lemon"; }
//            //if(this.itemStacks.get(0).getItem() == ShopKeeper.foodOrange)                             { fillingLevel++; if(0 == content.compareTo("empty")) content = "Orange"; }
//            //if(this.itemStacks.get(0).getItem() == ShopKeeper.foodPeach)                              { fillingLevel++; if(0 == content.compareTo("empty")) content = "Peach"; }
//            //if(this.itemStacks.get(0).getItem() == ShopKeeper.FOOD_PINEAPPLE)                          { fillingLevel++; if(0 == content.compareTo("empty")) content = "Pineapple"; }
//            //if(this.itemStacks.get(0).getItem() == ShopKeeper.FOOD_TOMATO)                             { fillingLevel++; if(0 == content.compareTo("empty")) content = "Tomato"; }
//            this.itemStacks.get(0).shrink(1);
//            if (this.itemStacks.get(0).getCount() <= 0){
//                this.itemStacks.set(0, null);
//            }
//        }
//    }
//
//    private Item changeBucket(Item item, String string){
//		/*if(0 == string.compareTo("Oil")){
//    		if(item == ShopKeeper.bucketWoodEmpty)       return ShopKeeper.bucketWoodOil;
//    		if(item == ShopKeeper.bucketCopperEmpty)     return ShopKeeper.bucketCopperOil;
//    		if(item == ShopKeeper.bucketIronEmpty)       return ShopKeeper.bucketIronOil;
//    		if(item == ShopKeeper.bucketAluminiumEmpty)  return ShopKeeper.bucketAluminiumOil;
//    		if(item == ShopKeeper.bucketLeadEmpty)       return ShopKeeper.bucketLeadOil;
//    		if(item == ShopKeeper.bucketBronzeEmpty)     return ShopKeeper.bucketBronzeOil;
//    		if(item == ShopKeeper.bucketSteelEmpty)      return ShopKeeper.bucketSteelOil;
//    		if(item == ShopKeeper.bucketMythrilEmpty)    return ShopKeeper.bucketMythrilOil;
//    		if(item == ShopKeeper.bucketAdamantiumEmpty) return ShopKeeper.bucketAdamantiumOil;
//    		if(item == ShopKeeper.bucketUnobtaniumEmpty) return ShopKeeper.bucketUnobtaniumOil;
//    	}
//		if(0 == string.compareTo("Apple")){
//    		if(item == ShopKeeper.bucketWoodEmpty)       return ShopKeeper.bucketWoodApple;
//    		if(item == ShopKeeper.bucketCopperEmpty)     return ShopKeeper.bucketCopperApple;
//    		if(item == ShopKeeper.bucketIronEmpty)       return ShopKeeper.bucketIronApple;
//    		if(item == ShopKeeper.bucketAluminiumEmpty)  return ShopKeeper.bucketAluminiumApple;
//    		if(item == ShopKeeper.bucketLeadEmpty)       return ShopKeeper.bucketLeadApple;
//    		if(item == ShopKeeper.bucketBronzeEmpty)     return ShopKeeper.bucketBronzeApple;
//    		if(item == ShopKeeper.bucketSteelEmpty)      return ShopKeeper.bucketSteelApple;
//    		if(item == ShopKeeper.bucketMythrilEmpty)    return ShopKeeper.bucketMythrilApple;
//    		if(item == ShopKeeper.bucketAdamantiumEmpty) return ShopKeeper.bucketAdamantiumApple;
//    		if(item == ShopKeeper.bucketUnobtaniumEmpty) return ShopKeeper.bucketUnobtaniumApple;
//    	}
//    	if(0 == string.compareTo("Banana")){
//    		if(item == ShopKeeper.bucketWoodEmpty)       return ShopKeeper.bucketWoodBanana;
//    		if(item == ShopKeeper.bucketCopperEmpty)     return ShopKeeper.bucketCopperBanana;
//    		if(item == ShopKeeper.bucketIronEmpty)       return ShopKeeper.bucketIronBanana;
//    		if(item == ShopKeeper.bucketAluminiumEmpty)  return ShopKeeper.bucketAluminiumBanana;
//    		if(item == ShopKeeper.bucketLeadEmpty)       return ShopKeeper.bucketLeadBanana;
//    		if(item == ShopKeeper.bucketBronzeEmpty)     return ShopKeeper.bucketBronzeBanana;
//    		if(item == ShopKeeper.bucketSteelEmpty)      return ShopKeeper.bucketSteelBanana;
//    		if(item == ShopKeeper.bucketMythrilEmpty)    return ShopKeeper.bucketMythrilBanana;
//    		if(item == ShopKeeper.bucketAdamantiumEmpty) return ShopKeeper.bucketAdamantiumBanana;
//    		if(item == ShopKeeper.bucketUnobtaniumEmpty) return ShopKeeper.bucketUnobtaniumBanana;
//    	}
//    	if(0 == string.compareTo("Cactus")){
//    		if(item == ShopKeeper.bucketWoodEmpty)       return ShopKeeper.bucketWoodCactusFruit;
//    		if(item == ShopKeeper.bucketCopperEmpty)     return ShopKeeper.bucketCopperCactusFruit;
//    		if(item == ShopKeeper.bucketIronEmpty)       return ShopKeeper.bucketIronCactusFruit;
//    		if(item == ShopKeeper.bucketAluminiumEmpty)  return ShopKeeper.bucketAluminiumCactusFruit;
//    		if(item == ShopKeeper.bucketLeadEmpty)       return ShopKeeper.bucketLeadCactusFruit;
//    		if(item == ShopKeeper.bucketBronzeEmpty)     return ShopKeeper.bucketBronzeCactusFruit;
//    		if(item == ShopKeeper.bucketSteelEmpty)      return ShopKeeper.bucketSteelCactusFruit;
//    		if(item == ShopKeeper.bucketMythrilEmpty)    return ShopKeeper.bucketMythrilCactusFruit;
//    		if(item == ShopKeeper.bucketAdamantiumEmpty) return ShopKeeper.bucketAdamantiumCactusFruit;
//    		if(item == ShopKeeper.bucketUnobtaniumEmpty) return ShopKeeper.bucketUnobtaniumCactusFruit;
//    	}
//    	if(0 == string.compareTo("Cherry")){
//    		if(item == ShopKeeper.bucketWoodEmpty)       return ShopKeeper.bucketWoodCherry;
//    		if(item == ShopKeeper.bucketCopperEmpty)     return ShopKeeper.bucketCopperCherry;
//    		if(item == ShopKeeper.bucketIronEmpty)       return ShopKeeper.bucketIronCherry;
//    		if(item == ShopKeeper.bucketAluminiumEmpty)  return ShopKeeper.bucketAluminiumCherry;
//    		if(item == ShopKeeper.bucketLeadEmpty)       return ShopKeeper.bucketLeadCherry;
//    		if(item == ShopKeeper.bucketBronzeEmpty)     return ShopKeeper.bucketBronzeCherry;
//    		if(item == ShopKeeper.bucketSteelEmpty)      return ShopKeeper.bucketSteelCherry;
//    		if(item == ShopKeeper.bucketMythrilEmpty)    return ShopKeeper.bucketMythrilCherry;
//    		if(item == ShopKeeper.bucketAdamantiumEmpty) return ShopKeeper.bucketAdamantiumCherry;
//    		if(item == ShopKeeper.bucketUnobtaniumEmpty) return ShopKeeper.bucketUnobtaniumCherry;
//    	}
//    	if(0 == string.compareTo("Grapes")){
//    		if(item == ShopKeeper.bucketWoodEmpty)       return ShopKeeper.bucketWoodGrapes;
//    		if(item == ShopKeeper.bucketCopperEmpty)     return ShopKeeper.bucketCopperGrapes;
//    		if(item == ShopKeeper.bucketIronEmpty)       return ShopKeeper.bucketIronGrapes;
//    		if(item == ShopKeeper.bucketAluminiumEmpty)  return ShopKeeper.bucketAluminiumGrapes;
//    		if(item == ShopKeeper.bucketLeadEmpty)       return ShopKeeper.bucketLeadGrapes;
//    		if(item == ShopKeeper.bucketBronzeEmpty)     return ShopKeeper.bucketBronzeGrapes;
//    		if(item == ShopKeeper.bucketSteelEmpty)      return ShopKeeper.bucketSteelGrapes;
//    		if(item == ShopKeeper.bucketMythrilEmpty)    return ShopKeeper.bucketMythrilGrapes;
//    		if(item == ShopKeeper.bucketAdamantiumEmpty) return ShopKeeper.bucketAdamantiumGrapes;
//    		if(item == ShopKeeper.bucketUnobtaniumEmpty) return ShopKeeper.bucketUnobtaniumGrapes;
//    	}
//    	if(0 == string.compareTo("Lemon")){
//    		if(item == ShopKeeper.bucketWoodEmpty)       return ShopKeeper.bucketWoodLemon;
//    		if(item == ShopKeeper.bucketCopperEmpty)     return ShopKeeper.bucketCopperLemon;
//    		if(item == ShopKeeper.bucketIronEmpty)       return ShopKeeper.bucketIronLemon;
//    		if(item == ShopKeeper.bucketAluminiumEmpty)  return ShopKeeper.bucketAluminiumLemon;
//    		if(item == ShopKeeper.bucketLeadEmpty)       return ShopKeeper.bucketLeadLemon;
//    		if(item == ShopKeeper.bucketBronzeEmpty)     return ShopKeeper.bucketBronzeLemon;
//    		if(item == ShopKeeper.bucketSteelEmpty)      return ShopKeeper.bucketSteelLemon;
//    		if(item == ShopKeeper.bucketMythrilEmpty)    return ShopKeeper.bucketMythrilLemon;
//    		if(item == ShopKeeper.bucketAdamantiumEmpty) return ShopKeeper.bucketAdamantiumLemon;
//    		if(item == ShopKeeper.bucketUnobtaniumEmpty) return ShopKeeper.bucketUnobtaniumLemon;
//    	}
//    	if(0 == string.compareTo("Orange")){
//    		if(item == ShopKeeper.bucketWoodEmpty)       return ShopKeeper.bucketWoodOrange;
//    		if(item == ShopKeeper.bucketCopperEmpty)     return ShopKeeper.bucketCopperOrange;
//    		if(item == ShopKeeper.bucketIronEmpty)       return ShopKeeper.bucketIronOrange;
//    		if(item == ShopKeeper.bucketAluminiumEmpty)  return ShopKeeper.bucketAluminiumOrange;
//    		if(item == ShopKeeper.bucketLeadEmpty)       return ShopKeeper.bucketLeadOrange;
//    		if(item == ShopKeeper.bucketBronzeEmpty)     return ShopKeeper.bucketBronzeOrange;
//    		if(item == ShopKeeper.bucketSteelEmpty)      return ShopKeeper.bucketSteelOrange;
//    		if(item == ShopKeeper.bucketMythrilEmpty)    return ShopKeeper.bucketMythrilOrange;
//    		if(item == ShopKeeper.bucketAdamantiumEmpty) return ShopKeeper.bucketAdamantiumOrange;
//    		if(item == ShopKeeper.bucketUnobtaniumEmpty) return ShopKeeper.bucketUnobtaniumOrange;
//    	}
//    	if(0 == string.compareTo("Peach")){
//    		if(item == ShopKeeper.bucketWoodEmpty)       return ShopKeeper.bucketWoodPeach;
//    		if(item == ShopKeeper.bucketCopperEmpty)     return ShopKeeper.bucketCopperPeach;
//    		if(item == ShopKeeper.bucketIronEmpty)       return ShopKeeper.bucketIronPeach;
//    		if(item == ShopKeeper.bucketAluminiumEmpty)  return ShopKeeper.bucketAluminiumPeach;
//    		if(item == ShopKeeper.bucketLeadEmpty)       return ShopKeeper.bucketLeadPeach;
//    		if(item == ShopKeeper.bucketBronzeEmpty)     return ShopKeeper.bucketBronzePeach;
//    		if(item == ShopKeeper.bucketSteelEmpty)      return ShopKeeper.bucketSteelPeach;
//    		if(item == ShopKeeper.bucketMythrilEmpty)    return ShopKeeper.bucketMythrilPeach;
//    		if(item == ShopKeeper.bucketAdamantiumEmpty) return ShopKeeper.bucketAdamantiumPeach;
//    		if(item == ShopKeeper.bucketUnobtaniumEmpty) return ShopKeeper.bucketUnobtaniumPeach;
//    	}
//    	if(0 == string.compareTo("Pineapple")){
//    		if(item == ShopKeeper.bucketWoodEmpty)       return ShopKeeper.bucketWoodPineapple;
//    		if(item == ShopKeeper.bucketCopperEmpty)     return ShopKeeper.bucketCopperPineapple;
//    		if(item == ShopKeeper.bucketIronEmpty)       return ShopKeeper.bucketIronPineapple;
//    		if(item == ShopKeeper.bucketAluminiumEmpty)  return ShopKeeper.bucketAluminiumPineapple;
//    		if(item == ShopKeeper.bucketLeadEmpty)       return ShopKeeper.bucketLeadPineapple;
//    		if(item == ShopKeeper.bucketBronzeEmpty)     return ShopKeeper.bucketBronzePineapple;
//    		if(item == ShopKeeper.bucketSteelEmpty)      return ShopKeeper.bucketSteelPineapple;
//    		if(item == ShopKeeper.bucketMythrilEmpty)    return ShopKeeper.bucketMythrilPineapple;
//    		if(item == ShopKeeper.bucketAdamantiumEmpty) return ShopKeeper.bucketAdamantiumPineapple;
//    		if(item == ShopKeeper.bucketUnobtaniumEmpty) return ShopKeeper.bucketUnobtaniumPineapple;
//    	}
//    	if(0 == string.compareTo("Tomato")){
//    		if(item == ShopKeeper.bucketWoodEmpty)       return ShopKeeper.bucketWoodTomato;
//    		if(item == ShopKeeper.bucketCopperEmpty)     return ShopKeeper.bucketCopperTomato;
//    		if(item == ShopKeeper.bucketIronEmpty)       return ShopKeeper.bucketIronTomato;
//    		if(item == ShopKeeper.bucketAluminiumEmpty)  return ShopKeeper.bucketAluminiumTomato;
//    		if(item == ShopKeeper.bucketLeadEmpty)       return ShopKeeper.bucketLeadTomato;
//    		if(item == ShopKeeper.bucketBronzeEmpty)     return ShopKeeper.bucketBronzeTomato;
//    		if(item == ShopKeeper.bucketSteelEmpty)      return ShopKeeper.bucketSteelTomato;
//    		if(item == ShopKeeper.bucketMythrilEmpty)    return ShopKeeper.bucketMythrilTomato;
//    		if(item == ShopKeeper.bucketAdamantiumEmpty) return ShopKeeper.bucketAdamantiumTomato;
//    		if(item == ShopKeeper.bucketUnobtaniumEmpty) return ShopKeeper.bucketUnobtaniumTomato;
//    	}*/
//        return item;
//    }
//
//    private Item changeBottle(Item item, String string){
//        //if(item == Items.GLASS_BOTTLE && 0 == string.compareTo("Oil"))       return ShopKeeper.juiceOil;
//        //if(item == Items.GLASS_BOTTLE && 0 == string.compareTo("Apple"))     return ShopKeeper.juiceApple;
//        //if(item == Items.GLASS_BOTTLE && 0 == string.compareTo("Banana"))    return ShopKeeper.juiceBanana;
//        //if(item == Items.GLASS_BOTTLE && 0 == string.compareTo("Cherry"))    return ShopKeeper.juiceCherries;
//        //if(item == Items.GLASS_BOTTLE && 0 == string.compareTo("Grapes"))    return ShopKeeper.juiceGrapes;
//        //if(item == Items.GLASS_BOTTLE && 0 == string.compareTo("Lemon"))     return ShopKeeper.juiceLemon;
//        //if(item == Items.GLASS_BOTTLE && 0 == string.compareTo("Orange"))    return ShopKeeper.juiceOrange;
//        //if(item == Items.GLASS_BOTTLE && 0 == string.compareTo("Peach"))     return ShopKeeper.juicePeach;
//        //if(item == Items.GLASS_BOTTLE && 0 == string.compareTo("Pineapple")) return ShopKeeper.juicePineapple;
//        return item;
//    }
//
//    /** Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't fuel */
//    public static int getItemBurnTime(ItemStack stack){
//        if (stack == null){
//            return 0;
//        } else {
//            Item item = stack.getItem();
//            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR){
//                Block block = Block.getBlockFromItem(item);
//                if (block == Blocks.WOODEN_SLAB){
//                    return 150;
//                }
//                if (block.getDefaultState().getMaterial() == Material.WOOD){
//                    return 300;
//                }
//                if (block == Blocks.COAL_BLOCK){
//                    return 16000;
//                }
//            }
//            if (item instanceof ItemTool  && "WOOD".equals(((ItemTool)item) .getToolMaterialName())) return 200;
//            if (item instanceof ItemSword && "WOOD".equals(((ItemSword)item).getToolMaterialName())) return 200;
//            if (item instanceof ItemHoe   && "WOOD".equals(((ItemHoe)item)  .getMaterialName()))     return 200;
//            if (item == Items.STICK) return 100;
//            if (item == Items.COAL) return 1600;
//            if (item == Items.LAVA_BUCKET) return 20000;
//            if (item == Item.getItemFromBlock(Blocks.SAPLING)) return 100;
//            if (item == Items.BLAZE_ROD) return 2400;
//            return net.minecraftforge.fml.common.registry.GameRegistry.getFuelValue(stack);
//        }
//    }
//
//    public static boolean isItemFuel(ItemStack stack){
//        return getItemBurnTime(stack) > 0;
//    }
//
//    /** Do not make give this method the name canInteractWith because it clashes with Container */
//    public boolean isUseableByPlayer(EntityPlayer player){
//        return this.world.getTileEntity(this.pos) == this && player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
//    }
//
//    public void openInventory(EntityPlayer player){
//
//    }
//
//    public void closeInventory(EntityPlayer player){
//
//    }
//
//    /**
//     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
//     */
//    public boolean isItemValidForSlot(int index, ItemStack stack){
//        if (index == 2){
//            return false;
//        } else if (index != 1){
//            return true;
//        } else {
//            ItemStack itemstack = this.itemStacks.get(1);
//            return isItemFuel(stack) || SlotFurnaceFuel.isBucket(stack) && (itemstack == null || itemstack.getItem() != Items.BUCKET);
//        }
//    }
//
//    public int[] getSlotsForFace(EnumFacing side){
//        return side == EnumFacing.DOWN ? SLOTS_BOTTOM : (side == EnumFacing.UP ? SLOTS_TOP : SLOTS_SIDES);
//    }
//
//    /** Returns true if automation can insert the given item in the given slot from the given side. */
//    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction){
//        return this.isItemValidForSlot(index, itemStackIn);
//    }
//
//    /** Returns true if automation can extract the given item in the given slot from the given side. */
//    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction){
//        if (direction == EnumFacing.DOWN && index == 1){
//            Item item = stack.getItem();
//            return item == Items.WATER_BUCKET || item == Items.BUCKET;
//        }
//        return true;
//    }
//
//    public String getGuiID(){
//        return "acecraft:furnace";
//    }
//
//    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn){
//        return new ContainerFruitPress(playerInventory, this);
//    }
//
//    public int getField(int id){
//        switch (id){
//            case 0: return this.burnTime;
//            case 1: return this.currentItemBurnTime;
//            case 2: return this.cookTime;
//            //case 3: return this.totalCookTime;
//            default:
//                return 0;
//        }
//    }
//
//    public void setField(int id, int value){
//        switch (id){
//            case 0: this.burnTime = value; break;
//            case 1: this.currentItemBurnTime = value; break;
//            case 2: this.cookTime = value; break;
//            //case 3: this.totalCookTime = value; break;
//        }
//    }
//
//    public int getFieldCount(){
//        return 4;
//    }
//
//    public void clear(){
//        for (int i = 0; i < this.itemStacks.size(); ++i){
//            this.itemStacks.set(i, null);
//        }
//    }
//
//    net.minecraftforge.items.IItemHandler handlerTop    = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.UP);
//    net.minecraftforge.items.IItemHandler handlerBottom = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.DOWN);
//    net.minecraftforge.items.IItemHandler handlerSide   = new net.minecraftforge.items.wrapper.SidedInvWrapper(this, net.minecraft.util.EnumFacing.WEST);
//
//    @SuppressWarnings("unchecked")
//    @Override
//    public <T> T getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, net.minecraft.util.EnumFacing facing){
//        if (facing != null && capability == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
//            if (facing == EnumFacing.DOWN)
//                return (T) handlerBottom;
//            else if (facing == EnumFacing.UP)
//                return (T) handlerTop;
//            else
//                return (T) handlerSide;
//        return super.getCapability(capability, facing);
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public int getFillingLevelScaled() {
//        return fillingLevel * 3;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        // TODO Auto-generated method stub
//        return false;
//    }
//
//    @Override
//    public boolean isUsableByPlayer(EntityPlayer player) {
//        // TODO Auto-generated method stub
//        return false;
//    }
//
//}
