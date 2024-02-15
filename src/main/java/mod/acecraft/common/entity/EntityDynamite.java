package mod.acecraft.common.entity;

import mod.acecraft.Register;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;

public class EntityDynamite extends ThrowableItemProjectile {
	
	// ...
	
	
	
	
	
	// ---------- ---------- ---------- ----------  CONSTRUCTOR  ---------- ---------- ---------- ---------- //
	
	public EntityDynamite(EntityType<? extends ThrowableItemProjectile> entityType, Level level){
		super(entityType, level);
	}
	
	public EntityDynamite(Level level){
		super(Register.ENTITY_DYNAMITE.get(), level);
	}
	
	public EntityDynamite(Level level, LivingEntity livingEntity){
		super(Register.ENTITY_DYNAMITE.get(), livingEntity, level);
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SUPPORT  ---------- ---------- ---------- ---------- //
	
	@Override
	protected Item getDefaultItem() {
		return Register.TOOL_DYNAMITE.get();
	}
	
	@Override
	protected void onHitBlock(BlockHitResult result){
		if(!this.level().isClientSide()){
			this.level().broadcastEntityEvent(this, ((byte) 3));
			this.level().explode(this, this.getX(), this.getY(), this.getZ(), 2.0F, Level.ExplosionInteraction.TNT);
			this.discard();
		}
		
		super.onHitBlock(result);
	}
	
	
}