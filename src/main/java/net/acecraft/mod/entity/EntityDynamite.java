package net.acecraft.mod.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityDynamite extends EntityThrowable {
	
	public EntityDynamite(World worldIn){
        super(worldIn);
    }

    public EntityDynamite(World worldIn, EntityLivingBase throwerIn){
        super(worldIn, throwerIn);
    }
    
    public EntityDynamite(World worldIn, EntityLivingBase throwerIn, String name){
        super(worldIn, throwerIn);
    }
    
    public EntityDynamite(World worldIn, double x, double y, double z){
        super(worldIn, x, y, z);
    }
    
    protected void onImpact(RayTraceResult result){
        if (result.entityHit != null){
            int i = 2;
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)i);
        }
        for (int j = 0; j < 8; ++j){
            this.worldObj.spawnParticle(EnumParticleTypes.CRIT, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
        }
        if(!this.worldObj.isRemote)
        	this.explode();
        this.setDead();
    }
    
    private void explode(){
        float f = 2.0F;
        this.worldObj.createExplosion(this, this.posX, this.posY + (double)(this.height / 16.0F), this.posZ, f, true);
    }
    
    protected SoundEvent getAmbientSound(){
        return SoundEvents.ENTITY_SHEEP_AMBIENT;
    }
    
    protected SoundEvent getHurtSound(){
        return SoundEvents.ENTITY_SHEEP_HURT;
    }
    
    protected SoundEvent getDeathSound(){
        return SoundEvents.ENTITY_SHEEP_DEATH;
    }
    
}
