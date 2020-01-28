package mod.acecraft.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntitySpitBall extends EntityThrowable {
	
	public EntitySpitBall(World worldIn){
        super(worldIn);
    }

    public EntitySpitBall(World worldIn, EntityLivingBase throwerIn){
        super(worldIn, throwerIn);
    }
    
    public EntitySpitBall(World worldIn, EntityLivingBase throwerIn, String name){
        super(worldIn, throwerIn);
    }
    
    public EntitySpitBall(World worldIn, double x, double y, double z){
        super(worldIn, x, y, z);
    }
    
    protected void onImpact(RayTraceResult result){
        if (result.entityHit != null){
            int i = 2;
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)i);
        }
        for (int j = 0; j < 8; ++j){
            this.world.spawnParticle(EnumParticleTypes.CRIT, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }
        this.setDead();
    }
	
}
