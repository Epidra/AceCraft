package mod.acecraft.entity;

import mod.acecraft.ShopKeeper;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.entity.IEntityAdditionalSpawnData;
import net.minecraftforge.network.NetworkHooks;

public class EntityNugget extends ThrowableItemProjectile implements IEntityAdditionalSpawnData {

    private ItemStack stack = null;





    //----------------------------------------CONSTRUCTOR----------------------------------------//

    public EntityNugget(EntityType<? extends EntityNugget> p_37391_, Level p_37392_) {
        super(p_37391_, p_37392_);
    }

    //public EntityNugget(FMLPlayMessages.SpawnEntity packet, Level worldIn){
    //    super(ShopKeeper.ENTITY_NUGGET.get(), worldIn);
    //    FriendlyByteBuf buf = packet.getAdditionalData();
    //    stack = buf.readItem();
    //}

    public EntityNugget(Level p_37399_, LivingEntity p_37400_, ItemStack itemIn) {
        super(ShopKeeper.ENTITY_NUGGET.get(), p_37400_, p_37399_);
        this.stack = itemIn.copy();
    }

    public EntityNugget(Level p_37394_, double p_37395_, double p_37396_, double p_37397_) {
        super(ShopKeeper.ENTITY_NUGGET.get(), p_37395_, p_37396_, p_37397_, p_37394_);
    }





    //----------------------------------------SPAWNDATA----------------------------------------//

    /** Called by the server when constructing the spawn packet. Data should be added to the provided stream.
     * @param buffer The packet data stream */
    public void writeSpawnData(FriendlyByteBuf buffer){
        buffer.writeItem(this.stack);
    }

    /** Called by the client when it receives a Entity spawn packet. Data should be read out of the stream in the same way as it was written.
     * @param additionalData The packet data stream */
    public void readSpawnData(FriendlyByteBuf additionalData){

    }

    // @Override
    // public Packet<?> getAddEntityPacket() {
    //     return NetworkHooks.getEntitySpawningPacket(this);
    // }





    //----------------------------------------SUPPORT----------------------------------------//

    public void handleEntityEvent(byte p_37402_) {
        if (p_37402_ == 3) {
            ParticleOptions particleoptions = this.getParticle();
            for(int i = 0; i < 8; ++i) {
                this.level.addParticle(particleoptions, this.getX(), this.getY(), this.getZ(), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    protected void onHitEntity(EntityHitResult p_37404_) {
        super.onHitEntity(p_37404_);
        Entity entity = p_37404_.getEntity();
        int i = entity instanceof Blaze ? 3 : 0;
        // entity.hurt(DamageSource.thrown(this, this.getOwner()), (float)i);
    }

    protected void onHit(HitResult p_37406_) {
        super.onHit(p_37406_);
        if (!this.level.isClientSide) {
            this.level.broadcastEntityEvent(this, (byte)3);
            this.discard();
        }
    }

    protected Item getDefaultItem() {
        return stack == null ? ShopKeeper.NUGGET_GILIUM.get() : stack.getItem();
    }

    private ParticleOptions getParticle() {
        ItemStack itemstack = this.getItemRaw();
        return (ParticleOptions)(itemstack.isEmpty() ? ParticleTypes.ITEM_SNOWBALL : new ItemParticleOption(ParticleTypes.ITEM, itemstack));
    }



}
