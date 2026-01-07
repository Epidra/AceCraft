package mod.acecraft.common.entity;

import mod.acecraft.Register;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
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

public class EntityDynamite extends ThrowableItemProjectile {
	public EntityDynamite(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
		super(entityType, level);
	}
	
	public EntityDynamite(Level level, LivingEntity shooter) {
		super(Register.ENTITY_DYNAMITE.get(), shooter, level);
	}
	
	public EntityDynamite(Level level, double x, double y, double z) {
		super(Register.ENTITY_DYNAMITE.get(), x, y, z, level);
	}
	
	
	// public EntityDynamite(EntityType<Entity> entityType, Level level) {
	// 	super((EntityType<? extends ThrowableItemProjectile>) entityType, level);
	// }
	
	@Override
	protected Item getDefaultItem() {
		return Register.TOOL_DYNAMITE.get();
	}
	
	private ParticleOptions getParticle() {
		ItemStack itemstack = this.getItem();
		return (ParticleOptions)(!itemstack.isEmpty() && !itemstack.is(this.getDefaultItem())
				? new ItemParticleOption(ParticleTypes.ITEM, itemstack)
				: ParticleTypes.ITEM_SNOWBALL);
	}
	
	/**
	 * Handles an entity event received from a {@link net.minecraft.network.protocol.game.ClientboundEntityEventPacket}.
	 */
	@Override
	public void handleEntityEvent(byte id) {
		if (id == 3) {
			ParticleOptions particleoptions = this.getParticle();
			
			for (int i = 0; i < 8; i++) {
				this.level().addParticle(particleoptions, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
			}
		}
	}
	
	/**
	 * Called when the arrow hits an entity
	 */
	@Override
	protected void onHitEntity(EntityHitResult result) {
		super.onHitEntity(result);
		Entity entity = result.getEntity();
		int i = entity instanceof Blaze ? 3 : 0;
		entity.hurt(this.damageSources().thrown(this, this.getOwner()), (float)i);
	}
	
	/**
	 * Called when this EntityFireball hits a block or entity.
	 */
	@Override
	protected void onHit(HitResult result) {
		super.onHit(result);
		if (!this.level().isClientSide) {
			this.level().broadcastEntityEvent(this, (byte)3);
			this.level().explode(this, this.getX(), this.getY(), this.getZ(), 2.0f, Level.ExplosionInteraction.TNT);
			this.discard();
		}
	}
}
