package mod.acecraft.entity;

public class EntityLlama {

}

//public class EntityLlama extends EntityHorse implements IShearable, IRangedAttackMob {
//
//    private static final DataParameter<Byte> DYE_COLOR = EntityDataManager.createKey(EntityLlama.class, DataSerializers.BYTE);
//    private static final Map<EnumDyeColor, float[]> DYE_TO_RGB = Maps.newEnumMap(EnumDyeColor.class);
//    /** Used to control movement as well as wool regrowth. Set to 40 on handleHealthUpdate and counts down with each tick. */
//    private int sheepTimer;
//    private EntityAIEatGrass entityAIEatGrass;
//    /** Internal crafting inventory used to check the result of mixing dyes corresponding to the fleece color when breeding sheep. */
//    private final InventoryCrafting inventoryCrafting = new InventoryCrafting(new Container(){
//        public boolean canInteractWith(EntityPlayer playerIn){
//            return false;
//        }
//    }, 2, 1);
//
//    public static float[] getDyeRgb(EnumDyeColor dyeColor){
//        return DYE_TO_RGB.get(dyeColor);
//    }
//
//    public EntityLlama(World worldIn){
//        super(worldIn);
//        this.setSize(0.9F, 2.2F);
//        this.inventoryCrafting.setInventorySlotContents(0, new ItemStack(Items.DYE));
//        this.inventoryCrafting.setInventorySlotContents(1, new ItemStack(Items.DYE));
//    }
//
//    protected void entityInit(){
//        super.entityInit();
//        this.dataManager.register(DYE_COLOR, Byte.valueOf((byte)0));
//    }
//
//    protected void initEntityAI(){
//        this.entityAIEatGrass = new EntityAIEatGrass(this);
//        this.tasks.addTask(0, new EntityAISwimming(this));
//        this.tasks.addTask(1, new EntityAIAttackRanged(this, 1.0D, 60, 10.0F));
//        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
//        this.tasks.addTask(3, new EntityAITempt(this, 1.1D, Items.WHEAT, false));
//        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));
//        this.tasks.addTask(5, this.entityAIEatGrass);
//        this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
//        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
//        this.tasks.addTask(8, new EntityAILookIdle(this));
//        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
//    }
//
//    protected void applyEntityAttributes(){
//        super.applyEntityAttributes();
//        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.24D);
//        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(16.0D);
//        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
//    }
//
//    protected void updateAITasks(){
//        this.sheepTimer = this.entityAIEatGrass.getEatingGrassTimer();
//        super.updateAITasks();
//    }
//
//    /**
//     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
//     * use this to react to sunlight and start to burn.
//     */
//    public void onLivingUpdate(){
//        if (this.world.isRemote){
//            this.sheepTimer = Math.max(0, this.sheepTimer - 1);
//        }
//        super.onLivingUpdate();
//    }
//
//    /**
//     * Returns the Y offset from the entity's position for any entity riding this one.
//     */
//    public double getMountedYOffset(){
//        return super.getMountedYOffset() + 0.5D;
//    }
//
//    @Nullable
//    protected ResourceLocation getLootTable(){
//        if (this.getSheared()){
//            return LootTableList.ENTITIES_SHEEP;
//        } else {
//            switch (this.getFleeceColor()){
//                case WHITE:      return LootTableList.ENTITIES_SHEEP_WHITE;
//                case ORANGE:     return LootTableList.ENTITIES_SHEEP_ORANGE;
//                case MAGENTA:    return LootTableList.ENTITIES_SHEEP_MAGENTA;
//                case LIGHT_BLUE: return LootTableList.ENTITIES_SHEEP_LIGHT_BLUE;
//                case YELLOW:     return LootTableList.ENTITIES_SHEEP_YELLOW;
//                case LIME:       return LootTableList.ENTITIES_SHEEP_LIME;
//                case PINK:       return LootTableList.ENTITIES_SHEEP_PINK;
//                case GRAY:       return LootTableList.ENTITIES_SHEEP_GRAY;
//                case SILVER:     return LootTableList.ENTITIES_SHEEP_SILVER;
//                case CYAN:       return LootTableList.ENTITIES_SHEEP_CYAN;
//                case PURPLE:     return LootTableList.ENTITIES_SHEEP_PURPLE;
//                case BLUE:       return LootTableList.ENTITIES_SHEEP_BLUE;
//                case BROWN:      return LootTableList.ENTITIES_SHEEP_BROWN;
//                case GREEN:      return LootTableList.ENTITIES_SHEEP_GREEN;
//                case RED:        return LootTableList.ENTITIES_SHEEP_RED;
//                case BLACK:      return LootTableList.ENTITIES_SHEEP_BLACK;
//                default:         return LootTableList.ENTITIES_SHEEP_WHITE;
//            }
//        }
//    }
//
//    @SideOnly(Side.CLIENT)
//    public void handleStatusUpdate(byte id){
//        if (id == 10){
//            this.sheepTimer = 40;
//        } else {
//            super.handleStatusUpdate(id);
//        }
//    }
//
//    @SuppressWarnings("unused")
//    public boolean processInteract(EntityPlayer player, EnumHand hand, @Nullable ItemStack stack){
//        if (false)  //Forge: Moved to onSheared
//            if (stack != null && stack.getItem() == Items.SHEARS && !this.getSheared() && !this.isChild()){
//                if (!this.world.isRemote){
//                    this.setSheared(true);
//                    int i = 1 + this.rand.nextInt(3);
//                    for (int j = 0; j < i; ++j){
//                        EntityItem entityitem = this.entityDropItem(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, this.getFleeceColor().getMetadata()), 1.0F);
//                        entityitem.motionY += (double)(this.rand.nextFloat() * 0.05F);
//                        entityitem.motionX += (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F);
//                        entityitem.motionZ += (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1F);
//                    }
//                }
//                stack.damageItem(1, player);
//                this.playSound(SoundEvents.ENTITY_SHEEP_SHEAR, 1.0F, 1.0F);
//            }
//        if(stack != null && stack.getItem() == Items.DYE && !this.getSheared()){
//            EnumDyeColor enumdyecolor = EnumDyeColor.byDyeDamage(stack.getMetadata());
//            this.setFleeceColor(enumdyecolor);
//            if(!player.isCreative()){
//                stack.shrink(1);
//                if(stack.getCount() <= 0) stack = null;
//            }
//        }
//        return super.processInteract(player, hand);
//    }
//
//    /**
//     * Called when the entity is attacked.
//     */
//    public boolean attackEntityFrom(DamageSource source, float amount){
//        if (this.isEntityInvulnerable(source)){
//            return false;
//        } else {
//            Entity entity = source.getImmediateSource();
//            //if (this.aiSit != null){
//            //    this.aiSit.setSitting(false);
//            //}
//            if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow)){
//                amount = (amount + 1.0F) / 2.0F;
//            }
//            return super.attackEntityFrom(source, amount);
//        }
//    }
//
//    public boolean attackEntityAsMob(Entity entityIn){
//        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue()));
//        if (flag){
//            this.applyEnchantments(this, entityIn);
//        }
//        return flag;
//    }
//
//    @SideOnly(Side.CLIENT)
//    public float getHeadRotationPointY(float p_70894_1_){
//        return this.sheepTimer <= 0 ? 0.0F : (this.sheepTimer >= 4 && this.sheepTimer <= 36 ? 1.0F : (this.sheepTimer < 4 ? ((float)this.sheepTimer - p_70894_1_) / 4.0F : -((float)(this.sheepTimer - 40) - p_70894_1_) / 4.0F));
//    }
//
//    @SideOnly(Side.CLIENT)
//    public float getHeadRotationAngleX(float p_70890_1_){
//        if (this.sheepTimer > 4 && this.sheepTimer <= 36){
//            float f = ((float)(this.sheepTimer - 4) - p_70890_1_) / 32.0F;
//            return ((float)Math.PI / 5F) + ((float)Math.PI * 7F / 100F) * MathHelper.sin(f * 28.7F);
//        } else {
//            return this.sheepTimer > 0 ? ((float)Math.PI / 5F) : this.rotationPitch * 0.017453292F;
//        }
//    }
//
//    /**
//     * (abstract) Protected helper method to write subclass entity data to NBT.
//     */
//    public void writeEntityToNBT(NBTTagCompound compound){
//        super.writeEntityToNBT(compound);
//        compound.setBoolean("Sheared", this.getSheared());
//        compound.setByte("Color", (byte)this.getFleeceColor().getMetadata());
//    }
//
//    /**
//     * (abstract) Protected helper method to read subclass entity data from NBT.
//     */
//    public void readEntityFromNBT(NBTTagCompound compound){
//        super.readEntityFromNBT(compound);
//        this.setSheared(compound.getBoolean("Sheared"));
//        this.setFleeceColor(EnumDyeColor.byMetadata(compound.getByte("Color")));
//    }
//
//    //protected SoundEvent getAmbientSound(){
//    //	return ShopKeeper.SOUND_LLAMA_IDLE;
//    //}
//
//    //protected SoundEvent getHurtSound(){
//    //	return ShopKeeper.SOUND_LLAMA_HURT;
//    //}
//
//    //protected SoundEvent getDeathSound(){
//    //	return ShopKeeper.SOUND_LLAMA_DEATH;
//    //}
//
//    protected void playStepSound(BlockPos pos, Block blockIn){
//        this.playSound(SoundEvents.ENTITY_SHEEP_STEP, 0.15F, 1.0F);
//    }
//
//    protected Item getDropItem(){
//        return ShopKeeper.FOOD_VICUGNA_RAW;
//    }
//
//    /**
//     * Gets the wool color of this sheep.
//     */
//    public EnumDyeColor getFleeceColor(){
//        return EnumDyeColor.byMetadata(this.dataManager.get(DYE_COLOR).byteValue() & 15);
//    }
//
//    /**
//     * Sets the wool color of this sheep
//     */
//    public void setFleeceColor(EnumDyeColor color){
//        byte b0 = this.dataManager.get(DYE_COLOR).byteValue();
//        this.dataManager.set(DYE_COLOR, Byte.valueOf((byte)(b0 & 240 | color.getMetadata() & 15)));
//    }
//
//    /**
//     * returns true if a sheeps wool has been sheared
//     */
//    public boolean getSheared(){
//        return (this.dataManager.get(DYE_COLOR).byteValue() & 16) != 0;
//    }
//
//    /**
//     * make a sheep sheared if set to true
//     */
//    public void setSheared(boolean sheared){
//        byte b0 = this.dataManager.get(DYE_COLOR).byteValue();
//        if (sheared){
//            this.dataManager.set(DYE_COLOR, Byte.valueOf((byte)(b0 | 16)));
//        } else {
//            this.dataManager.set(DYE_COLOR, Byte.valueOf((byte)(b0 & -17)));
//        }
//    }
//
//    /**
//     * Chooses a "vanilla" sheep color based on the provided random.
//     */
//    public static EnumDyeColor getRandomSheepColor(Random random){
//        int i = random.nextInt(100);
//        return i < 5 ? EnumDyeColor.CYAN : (i < 10 ? EnumDyeColor.GRAY : (i < 15 ? EnumDyeColor.BLACK : (i < 18 ? EnumDyeColor.YELLOW : (random.nextInt(500) == 0 ? EnumDyeColor.PINK : EnumDyeColor.BROWN))));
//    }
//
//    public EntityLlama createChild(EntityAgeable ageable){
//        EntityLlama entitycolor = (EntityLlama)ageable;
//        EntityLlama entitychild = new EntityLlama(this.world);
//        entitychild.setFleeceColor(this.getDyeColorMixFromParents(this, entitycolor));
//        return entitychild;
//    }
//
//    /**
//     * This function applies the benefits of growing back wool and faster growing up to the acting entity. (This
//     * function is used in the AIEatGrass)
//     */
//    public void eatGrassBonus(){
//        this.setSheared(false);
//        if (this.isChild()){
//            this.addGrowth(60);
//        }
//    }
//
//    /**
//     * Called only once on an entity when first time spawned, via egg, mob spawner, natural spawning etc, but not called
//     * when entity is reloaded from nbt. Mainly used for initializing attributes and inventory
//     */
//    @Nullable
//    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata){
//        livingdata = super.onInitialSpawn(difficulty, livingdata);
//        this.setFleeceColor(getRandomSheepColor(this.world.rand));
//        return livingdata;
//    }
//
//    /**
//     * Attempts to mix both parent sheep to come up with a mixed dye color.
//     */
//    private EnumDyeColor getDyeColorMixFromParents(EntityAnimal father, EntityAnimal mother){
//        int i = ((EntityLlama)father).getFleeceColor().getDyeDamage();
//        int j = ((EntityLlama)mother).getFleeceColor().getDyeDamage();
//        this.inventoryCrafting.getStackInSlot(0).setItemDamage(i);
//        this.inventoryCrafting.getStackInSlot(1).setItemDamage(j);
//        ItemStack itemstack = CraftingManager.findMatchingResult(this.inventoryCrafting, ((EntityLlama)father).world);
//        int k;
//        if (itemstack != null && itemstack.getItem() == Items.DYE){
//            k = itemstack.getMetadata();
//        } else {
//            k = this.world.rand.nextBoolean() ? i : j;
//        }
//        return EnumDyeColor.byDyeDamage(k);
//    }
//
//    public float getEyeHeight(){
//        return 0.95F * this.height;
//    }
//
//    static {
//        DYE_TO_RGB.put(EnumDyeColor.WHITE,      new float[] {1.0F,  1.0F,  1.0F});
//        DYE_TO_RGB.put(EnumDyeColor.ORANGE,     new float[] {0.85F, 0.5F,  0.2F});
//        DYE_TO_RGB.put(EnumDyeColor.MAGENTA,    new float[] {0.7F,  0.3F,  0.85F});
//        DYE_TO_RGB.put(EnumDyeColor.LIGHT_BLUE, new float[] {0.4F,  0.6F,  0.85F});
//        DYE_TO_RGB.put(EnumDyeColor.YELLOW,     new float[] {0.9F,  0.9F,  0.2F});
//        DYE_TO_RGB.put(EnumDyeColor.LIME,       new float[] {0.5F,  0.8F,  0.1F});
//        DYE_TO_RGB.put(EnumDyeColor.PINK,       new float[] {0.95F, 0.5F,  0.65F});
//        DYE_TO_RGB.put(EnumDyeColor.GRAY,       new float[] {0.3F,  0.3F,  0.3F});
//        DYE_TO_RGB.put(EnumDyeColor.SILVER,     new float[] {0.6F,  0.6F,  0.6F});
//        DYE_TO_RGB.put(EnumDyeColor.CYAN,       new float[] {0.3F,  0.5F,  0.6F});
//        DYE_TO_RGB.put(EnumDyeColor.PURPLE,     new float[] {0.5F,  0.25F, 0.7F});
//        DYE_TO_RGB.put(EnumDyeColor.BLUE,       new float[] {0.2F,  0.3F,  0.7F});
//        DYE_TO_RGB.put(EnumDyeColor.BROWN,      new float[] {0.4F,  0.3F,  0.2F});
//        DYE_TO_RGB.put(EnumDyeColor.GREEN,      new float[] {0.4F,  0.5F,  0.2F});
//        DYE_TO_RGB.put(EnumDyeColor.RED,        new float[] {0.6F,  0.2F,  0.2F});
//        DYE_TO_RGB.put(EnumDyeColor.BLACK,      new float[] {0.1F,  0.1F,  0.1F});
//    }
//
//    public boolean isHorseSaddled(){
//        return true;
//    }
//
//    @Override public boolean isShearable(ItemStack item, net.minecraft.world.IBlockAccess world, BlockPos pos){ return !this.getSheared() && !this.isChild(); }
//    @Override
//    public java.util.List<ItemStack> onSheared(ItemStack item, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune){
//        this.setSheared(true);
//        int i = 1 + this.rand.nextInt(3);
//        java.util.List<ItemStack> ret = new java.util.ArrayList<ItemStack>();
//        for (int j = 0; j < i; ++j)
//            ret.add(new ItemStack(Item.getItemFromBlock(Blocks.WOOL), 1, this.getFleeceColor().getMetadata()));
//        this.playSound(SoundEvents.ENTITY_SHEEP_SHEAR, 1.0F, 1.0F);
//        return ret;
//    }
//
//    @Override
//    public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
//        double d0 = target.posY + (double)target.getEyeHeight() - 1.100000023841858D;
//        double d1 = target.posX + target.motionX - this.posX;
//        double d2 = d0 - this.posY;
//        double d3 = target.posZ + target.motionZ - this.posZ;
//        float f = MathHelper.sqrt(d1 * d1 + d3 * d3);
//        world.playSound(null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (0.8F));
//        EntitySpitBall nugget = new EntitySpitBall(world, this);
//        nugget.rotationPitch -= -20.0F;
//        nugget.shoot(d1, d2 + (double)(f * 0.1F), d3, 1.75F, 1.0F);
//        this.world.spawnEntity(nugget);
//    }
//
//    @Override
//    public void setSwingingArms(boolean swingingArms) {
//        // TODO Auto-generated method stub
//
//    }
//
//}
