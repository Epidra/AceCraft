package mod.acecraft.entity;

import mod.acecraft.ShopKeeper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class EntityNugget extends ProjectileItemEntity {

    public EntityNugget(EntityType<? extends EntityNugget> type, World worldIn) {
        super(type, worldIn);
    }

    public EntityNugget(World worldIn, LivingEntity throwerIn) {
        super(ShopKeeper.ENTITY_NUGGET, throwerIn, worldIn);
    }

    public EntityNugget(EntityType<? extends EntityNugget> type, double x, double y, double z, World worldIn) {
        super(type, x, y, z, worldIn);
    }

    public EntityNugget(EntityType<? extends EntityNugget> type, LivingEntity livingEntityIn, World worldIn) {
        super(type, livingEntityIn, worldIn);
    }

    protected Item func_213885_i() {
        return ShopKeeper.NUGGET_COPPER;
    }

    @OnlyIn(Dist.CLIENT)
    private IParticleData func_213887_n() {
        ItemStack itemstack = this.func_213882_k();
        return (IParticleData)(itemstack.isEmpty() ? ParticleTypes.ITEM_SNOWBALL : new ItemParticleData(ParticleTypes.ITEM, itemstack));
    }

    /**
     * Handler for {@link World#setEntityState}
     */
    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 3) {
            IParticleData iparticledata = this.func_213887_n();

            for(int i = 0; i < 8; ++i) {
                this.world.addParticle(iparticledata, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
            }
        }

    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(RayTraceResult result) {
        if (result.getType() == RayTraceResult.Type.ENTITY) {
            Entity entity = ((EntityRayTraceResult)result).getEntity();
            //int i = entity instanceof BlazeEntity ? 3 : 0;
            int i = 1;
            entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)i);
        }

        if (!this.world.isRemote) {
            this.world.setEntityState(this, (byte)3);
            this.remove();
        }

    }

}
