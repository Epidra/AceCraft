package mod.acecraft.entity;

import mod.acecraft.ShopKeeper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityDynamite extends ProjectileItemEntity {

    // ...




    //----------------------------------------CONSTRUCTOR----------------------------------------//

    public EntityDynamite(EntityType<? extends EntityDynamite> p_i50159_1_, World p_i50159_2_) {
        super(p_i50159_1_, p_i50159_2_);
    }

    public EntityDynamite(FMLPlayMessages.SpawnEntity packet, World worldIn){
        super(ShopKeeper.ENTITY_DYNAMITE.get(), worldIn);
        PacketBuffer buf = packet.getAdditionalData();
    }

    public EntityDynamite(World worldIn, LivingEntity throwerIn) {
        super(ShopKeeper.ENTITY_DYNAMITE.get(), throwerIn, worldIn);
    }

    public EntityDynamite(World worldIn, double x, double y, double z) {
        super(ShopKeeper.ENTITY_DYNAMITE.get(), x, y, z, worldIn);
    }




    //----------------------------------------SUPPORT----------------------------------------//

    protected Item getDefaultItem() {
        return ShopKeeper.TOOL_DYNAMITE.get();
    }

    @OnlyIn(Dist.CLIENT)
    private IParticleData getParticle() {
        ItemStack itemstack = this.getItemRaw();
        return (IParticleData)(itemstack.isEmpty() ? ParticleTypes.ITEM_SNOWBALL : new ItemParticleData(ParticleTypes.ITEM, itemstack));
    }

    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte p_70103_1_) {
        if (p_70103_1_ == 3) {
            IParticleData iparticledata = this.getParticle();
            for(int i = 0; i < 8; ++i) {
                this.level.addParticle(iparticledata, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    protected void onHitEntity(EntityRayTraceResult p_213868_1_) {
        super.onHitEntity(p_213868_1_);
        Entity entity = p_213868_1_.getEntity();
        int i = 0;
        entity.hurt(DamageSource.thrown(this, this.getOwner()), (float)i);
    }

    protected void onHit(RayTraceResult p_70227_1_) {
        super.onHit(p_70227_1_);
        if (!this.level.isClientSide) {
            this.level.broadcastEntityEvent(this, (byte)3);
            this.explode();
            this.remove();
        }
    }

    private void explode(){
        float f = 3.0F;
        this.level.explode(this, this.getX(), this.getY() + (double)(this.getEyeHeight() / 16.0F), this.getZ(), f, Explosion.Mode.BREAK);
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}