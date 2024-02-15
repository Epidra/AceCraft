package mod.acecraft.common.entity;

import mod.acecraft.Register;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class EntitySpit extends ThrowableItemProjectile {
	
	// ...
	
	
	
	
	
	// ---------- ---------- ---------- ----------  CONSTRUCTOR  ---------- ---------- ---------- ---------- //
	
	public EntitySpit(EntityType<? extends ThrowableItemProjectile> entityType, Level level){
		super(entityType, level);
	}
	
	public EntitySpit(Level level){
		super(Register.ENTITY_SPIT.get(), level);
	}
	
	public EntitySpit(Level level, LivingEntity livingEntity){
		super(Register.ENTITY_SPIT.get(), livingEntity, level);
		this.setOwner(livingEntity);
		this.setPos(livingEntity.getX() - (double)(livingEntity.getBbWidth() + 1.0F) * 0.5D * (double)Mth.sin(livingEntity.yBodyRot * ((float)Math.PI / 180F)), livingEntity.getEyeY() - (double)0.1F, livingEntity.getZ() + (double)(livingEntity.getBbWidth() + 1.0F) * 0.5D * (double)Mth.cos(livingEntity.yBodyRot * ((float)Math.PI / 180F)));
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  TICK  ---------- ---------- ---------- ---------- //
	
	public void tick() {
		super.tick();
		Vec3 vec3 = this.getDeltaMovement();
		HitResult hitresult = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);
		if (hitresult.getType() != HitResult.Type.MISS && !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, hitresult))
			this.onHit(hitresult);
		double d0 = this.getX() + vec3.x;
		double d1 = this.getY() + vec3.y;
		double d2 = this.getZ() + vec3.z;
		this.updateRotation();
		float f = 0.99F;
		float f1 = 0.06F;
		if (this.level().getBlockStates(this.getBoundingBox()).noneMatch(BlockBehaviour.BlockStateBase::isAir)) {
			this.discard();
		} else if (this.isInWaterOrBubble()) {
			this.discard();
		} else {
			this.setDeltaMovement(vec3.scale((double)0.99F));
			if (!this.isNoGravity()) {
				this.setDeltaMovement(this.getDeltaMovement().add(0.0D, (double)-0.06F, 0.0D));
			}
			
			this.setPos(d0, d1, d2);
		}
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  NETWORK  ---------- ---------- ---------- ---------- //
	
	protected void defineSynchedData() {
	
	}
	
	public void recreateFromPacket(ClientboundAddEntityPacket packet) {
		super.recreateFromPacket(packet);
		double d0 = packet.getXa();
		double d1 = packet.getYa();
		double d2 = packet.getZa();
		
		for(int i = 0; i < 7; ++i) {
			double d3 = 0.4D + 0.1D * (double)i;
			this.level().addParticle(ParticleTypes.SPIT, this.getX(), this.getY(), this.getZ(), d0 * d3, d1, d2 * d3);
		}
		
		this.setDeltaMovement(d0, d1, d2);
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SUPPORT  ---------- ---------- ---------- ---------- //
	
	@Override
	protected Item getDefaultItem() {
		return Items.SNOWBALL;
	}
	
	
	
	protected void onHitEntity(EntityHitResult result) {
		super.onHitEntity(result);
		Entity entity = this.getOwner();
		if (entity instanceof LivingEntity livingentity) {
			result.getEntity().hurt(this.damageSources().mobProjectile(this, livingentity), 1.0F);
		}
		
	}
	
	protected void onHitBlock(BlockHitResult result) {
		super.onHitBlock(result);
		if (!this.level().isClientSide) {
			this.discard();
		}
		
	}
	
	
	
}
