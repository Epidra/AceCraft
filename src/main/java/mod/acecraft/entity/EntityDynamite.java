package mod.acecraft.entity;

public class EntityDynamite {

}

//public class EntityDynamite extends EntityThrowable {
//
//    public EntityDynamite(World worldIn){
//        super(worldIn);
//    }
//
//    public EntityDynamite(World worldIn, EntityLivingBase throwerIn){
//        super(worldIn, throwerIn);
//    }
//
//    public EntityDynamite(World worldIn, EntityLivingBase throwerIn, String name){
//        super(worldIn, throwerIn);
//    }
//
//    public EntityDynamite(World worldIn, double x, double y, double z){
//        super(worldIn, x, y, z);
//    }
//
//    protected void onImpact(RayTraceResult result){
//        if (result.entityHit != null){
//            int i = 2;
//            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)i);
//        }
//        for (int j = 0; j < 8; ++j){
//            this.world.spawnParticle(EnumParticleTypes.CRIT, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
//        }
//        if(!this.world.isRemote)
//            this.explode();
//        this.setDead();
//    }
//
//    private void explode(){
//        float f = 3.0F;
//        this.world.createExplosion(this, this.posX, this.posY + (double)(this.height / 16.0F), this.posZ, f, true);
//    }
//
//}
