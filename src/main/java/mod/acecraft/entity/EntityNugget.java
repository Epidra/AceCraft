package mod.acecraft.entity;

public class EntityNugget {

}

//public class EntityNugget extends EntityThrowable {
//
//    private static final DataParameter<ItemStack> ITEM = EntityDataManager.createKey(EntityPotion.class, DataSerializers.ITEM_STACK);
//    private static final Logger LOGGER = LogManager.getLogger();
//
//    public EntityNugget(World worldIn){
//        super(worldIn);
//    }
//
//    public EntityNugget(World worldIn, EntityLivingBase throwerIn, ItemStack nugget){
//        super(worldIn, throwerIn);
//        this.setItem(nugget);
//    }
//
//    public EntityNugget(World worldIn, double x, double y, double z, ItemStack nugget){
//        super(worldIn, x, y, z);
//        if (!nugget.isEmpty()){
//            this.setItem(nugget);
//        }
//    }
//
//    protected void entityInit(){
//        this.getDataManager().register(ITEM, ItemStack.EMPTY);
//    }
//
//    public ItemStack getNugget(){
//        ItemStack itemstack = this.getDataManager().get(ITEM);
//        if (itemstack.isEmpty()){
//            if (this.world != null){
//                LOGGER.error("ThrownPotion entity {} has no item?!", this.getEntityId());
//            }
//            return new ItemStack(Items.FLINT);
//        } else {
//            return itemstack;
//        }
//    }
//
//    public void setItem(ItemStack stack){
//        this.getDataManager().set(ITEM, stack);
//        this.getDataManager().setDirty(ITEM);
//    }
//
//    /** Gets the amount of gravity to apply to the thrown entity with each tick. */
//    protected float getGravityVelocity(){
//        return 0.05F;
//    }
//
//    /** Called when this EntityThrowable hits a block or entity. */
//    protected void onImpact(RayTraceResult result){
//        if (!this.world.isRemote){
//            if (result.entityHit != null){
//                int i = 2;
//                result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)i);
//            }
//            for (int j = 0; j < 8; ++j){
//                this.world.spawnParticle(EnumParticleTypes.CRIT, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
//            }
//            if(!this.world.isRemote)
//                this.dropItem(getNugget().getItem(), 1);
//            this.setDead();
//        }
//    }
//
//    /** (abstract) Protected helper method to read subclass entity data from NBT. */
//    public void readEntityFromNBT(NBTTagCompound compound){
//        super.readEntityFromNBT(compound);
//        ItemStack itemstack = new ItemStack(compound.getCompoundTag("Nugget"));
//        if (itemstack.isEmpty()){
//            this.setDead();
//        } else {
//            this.setItem(itemstack);
//        }
//    }
//
//    /** (abstract) Protected helper method to write subclass entity data to NBT. */
//    public void writeEntityToNBT(NBTTagCompound compound){
//        super.writeEntityToNBT(compound);
//        ItemStack itemstack = this.getNugget();
//        if (!itemstack.isEmpty()){
//            compound.setTag("Potion", itemstack.writeToNBT(new NBTTagCompound()));
//        }
//    }
//}
