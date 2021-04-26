package mod.acecraft.entity;

import mod.acecraft.ShopKeeper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
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
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;

public class EntityNugget extends ProjectileItemEntity implements IEntityAdditionalSpawnData {

    private ItemStack stack = null;




    //----------------------------------------CONSTRUCTOR----------------------------------------//

    public EntityNugget(EntityType<? extends EntityNugget> p_i50159_1_, World p_i50159_2_) {
        super(p_i50159_1_, p_i50159_2_);
    }

    public EntityNugget(FMLPlayMessages.SpawnEntity packet, World worldIn){
        super(ShopKeeper.ENTITY_NUGGET.get(), worldIn);
        PacketBuffer buf = packet.getAdditionalData();
        stack = buf.readItem();
    }

    public EntityNugget(World worldIn, LivingEntity throwerIn, ItemStack itemIn) {
        super(ShopKeeper.ENTITY_NUGGET.get(), throwerIn, worldIn);
        this.stack = itemIn.copy();
    }

    public EntityNugget(World worldIn, double x, double y, double z) {
        super(ShopKeeper.ENTITY_NUGGET.get(), x, y, z, worldIn);
    }




    //----------------------------------------SPAWN_DATA----------------------------------------//

    /** Called by the server when constructing the spawn packet. Data should be added to the provided stream.
     * @param buffer The packet data stream */
    public void writeSpawnData(PacketBuffer buffer){
        buffer.writeItem(this.stack);
    }

    /** Called by the client when it receives a Entity spawn packet. Data should be read out of the stream in the same way as it was written.
     * @param additionalData The packet data stream */
    public void readSpawnData(PacketBuffer additionalData){

    }




    //----------------------------------------SUPPORT----------------------------------------//

    protected Item getDefaultItem() {
        return stack == null ? ShopKeeper.NUGGET_COPPER.get() : stack.getItem();
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
        int i = 1;
        entity.hurt(DamageSource.thrown(this, this.getOwner()), (float)i);
    }

    protected void onHit(RayTraceResult p_70227_1_) {
        super.onHit(p_70227_1_);
        if (!this.level.isClientSide) {
            this.level.broadcastEntityEvent(this, (byte)3);
            this.spawnAtLocation(new ItemStack(getItem().getItem()));
            this.remove();
        }
    }

    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
