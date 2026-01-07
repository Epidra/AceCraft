package mod.acecraft.common.entity;

import mod.acecraft.Register;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.horse.Llama;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class EntitySpit extends ThrowableItemProjectile {
	
	public EntitySpit(EntityType<? extends EntitySpit> entityType, Level level) {
		super(entityType, level);
	}
	
	public EntitySpit(Level level, LivingEntity shooter) {
		super(Register.ENTITY_SPIT.get(), shooter, level);
	}
	
	public EntitySpit(Level level, double x, double y, double z) {
		super(Register.ENTITY_SPIT.get(), x, y, z, level);
	}
	
	@Override
	protected Item getDefaultItem() {
		return Items.SNOWBALL;
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
			this.discard();
		}
	}
	
	
	// public EntitySpit(EntityType<? extends Projectile> entityType, Level level) {
	// 	super(entityType, level);
	// }
	//
	// public EntitySpit(Level level, Llama spitter) {
	// 	this(Register.ENTITY_SPIT.get(), level);
	// 	this.setOwner(spitter);
	// 	this.setPos(
	// 			spitter.getX() - (double)(spitter.getBbWidth() + 1.0F) * 0.5 * (double) Mth.sin(spitter.yBodyRot * (float) (Math.PI / 180.0)),
	// 			spitter.getEyeY() - 0.1F,
	// 			spitter.getZ() + (double)(spitter.getBbWidth() + 1.0F) * 0.5 * (double)Mth.cos(spitter.yBodyRot * (float) (Math.PI / 180.0))
	// 	);
	// }
	//
	// // public EntitySpit(EntityType<Entity> entityType, Level level) {
	// // 	super(entityType, level);
	// // }
	//
	// // public EntitySpit(EntityType<EntitySpit> entitySpitEntityType, Level level) {
	// // 	super(entityType, level);
	// // }
	// //
	// // public EntitySpit(EntityType<Entity> entityEntityType, Level level) {
	// // }
	//
	// // public EntitySpit(EntityType<Entity> entityEntityType, Level level) {
	// // 	super();
	// // }
	//
	// @Override
	// protected double getDefaultGravity() {
	// 	return 0.06;
	// }
	//
	// @Override
	// public void tick() {
	// 	super.tick();
	// 	Vec3 vec3 = this.getDeltaMovement();
	// 	HitResult hitresult = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);
	// 	if (hitresult.getType() != HitResult.Type.MISS && !net.neoforged.neoforge.event.EventHooks.onProjectileImpact(this, hitresult))
	// 		this.hitTargetOrDeflectSelf(hitresult);
	// 	double d0 = this.getX() + vec3.x;
	// 	double d1 = this.getY() + vec3.y;
	// 	double d2 = this.getZ() + vec3.z;
	// 	this.updateRotation();
	// 	float f = 0.99F;
	// 	if (this.level().getBlockStates(this.getBoundingBox()).noneMatch(BlockBehaviour.BlockStateBase::isAir)) {
	// 		this.discard();
	// 	} else if (this.isInWaterOrBubble()) {
	// 		this.discard();
	// 	} else {
	// 		this.setDeltaMovement(vec3.scale(0.99F));
	// 		this.applyGravity();
	// 		this.setPos(d0, d1, d2);
	// 	}
	// }
	//
	// /**
	//  * Called when the arrow hits an entity
	//  */
	// @Override
	// protected void onHitEntity(EntityHitResult result) {
	// 	super.onHitEntity(result);
	// 	if (this.getOwner() instanceof LivingEntity livingentity) {
	// 		Entity entity = result.getEntity();
	// 		DamageSource damagesource = this.damageSources().spit(this, livingentity);
	// 		if (entity.hurt(damagesource, 1.0F) && this.level() instanceof ServerLevel serverlevel) {
	// 			EnchantmentHelper.doPostAttackEffects(serverlevel, entity, damagesource);
	// 		}
	// 	}
	// }
	//
	// @Override
	// protected void onHitBlock(BlockHitResult result) {
	// 	super.onHitBlock(result);
	// 	if (!this.level().isClientSide) {
	// 		this.discard();
	// 	}
	// }
	//
	// @Override
	// protected void defineSynchedData(SynchedEntityData.Builder builder) {
	// }
	//
	// @Override
	// public void recreateFromPacket(ClientboundAddEntityPacket packet) {
	// 	super.recreateFromPacket(packet);
	// 	double d0 = packet.getXa();
	// 	double d1 = packet.getYa();
	// 	double d2 = packet.getZa();
	//
	// 	for (int i = 0; i < 7; i++) {
	// 		double d3 = 0.4 + 0.1 * (double)i;
	// 		this.level().addParticle(ParticleTypes.SPIT, this.getX(), this.getY(), this.getZ(), d0 * d3, d1, d2 * d3);
	// 	}
	//
	// 	this.setDeltaMovement(d0, d1, d2);
	// }
}
