package mod.acecraft.entity;

import mod.acecraft.ShopKeeper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityDynamite extends ProjectileItemEntity {

    public EntityDynamite(EntityType<? extends EntityDynamite> p_i50159_1_, World p_i50159_2_) {
        super(p_i50159_1_, p_i50159_2_);
    }

    public EntityDynamite(FMLPlayMessages.SpawnEntity packet, World worldIn)
    {
        super(ShopKeeper.ENTITY_DYNAMITE, worldIn);
    }

    public EntityDynamite(World worldIn, LivingEntity throwerIn) {
        super(ShopKeeper.ENTITY_DYNAMITE, throwerIn, worldIn);
    }

    public EntityDynamite(World worldIn, double x, double y, double z) {
        super(ShopKeeper.ENTITY_DYNAMITE, x, y, z, worldIn);
    }

    protected Item getDefaultItem() {
        return ShopKeeper.STUFF_DYNAMITE;
    }

    @OnlyIn(Dist.CLIENT)
    private IParticleData makeParticle() {
        ItemStack itemstack = this.func_213882_k();
        return (IParticleData)(itemstack.isEmpty() ? ParticleTypes.ITEM_SNOWBALL : new ItemParticleData(ParticleTypes.ITEM, itemstack));
    }

    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 3) {
            IParticleData iparticledata = this.makeParticle();

            for(int i = 0; i < 8; ++i) {
                this.world.addParticle(iparticledata, this.getPosX(), this.getPosY(), this.getPosZ(), 0.0D, 0.0D, 0.0D);
            }
        }

    }

    protected void onImpact(RayTraceResult result) {
        if (result.getType() == RayTraceResult.Type.ENTITY) {
            Entity entity = ((EntityRayTraceResult)result).getEntity();
            int i = entity instanceof BlazeEntity ? 3 : 0;
            entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.func_234616_v_()), (float)i);
        }

        if (!this.world.isRemote) {
            this.world.setEntityState(this, (byte)3);
            explode();
            this.remove();
        }

    }

    private void explode(){
        float f = 3.0F;
        this.world.createExplosion(this, this.getPosX(), this.getPosY() + (double)(this.getHeight() / 16.0F), this.getPosZ(), f, Explosion.Mode.DESTROY);
    }

    //public void shoot(float rotationPitchIn, float rotationYawIn, float pitchOffset, float velocity, float inaccuracy) {
    //    float f = -MathHelper.sin(rotationYawIn * ((float)Math.PI / 180F)) * MathHelper.cos(rotationPitchIn * ((float)Math.PI / 180F));
    //    float f1 = -MathHelper.sin((rotationPitchIn + pitchOffset) * ((float)Math.PI / 180F));
    //    float f2 = MathHelper.cos(rotationYawIn * ((float)Math.PI / 180F)) * MathHelper.cos(rotationPitchIn * ((float)Math.PI / 180F));
    //    this.shoot((double)f, (double)f1, (double)f2, velocity, inaccuracy);
    //    //Vec3d vec3d = entityThrower.getMotion();
    //    //this.setMotion(this.getMotion().add(vec3d.x, vec3d.y, vec3d.z));
    //}

    @Override
    public IPacket<?> createSpawnPacket()
    {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
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
