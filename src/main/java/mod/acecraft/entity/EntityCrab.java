package mod.acecraft.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class EntityCrab extends EntityAnimal {
	
	public EntityCrab(World world) {
		super(world);
        this.setSize(1.2f, 1.5f);
	}
	
	protected void applyEntityAttributes(){
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(8.0D);
    }
    
    protected void initEntityAI(){
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.25D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.1D, Items.FISH, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));
        this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
    }
    
    //protected Item getDropItem(){
    //    return ShopKeeper.FOOD_FISH_CRAB;
    //}
    
	@Override
    public EntityCrab createChild(EntityAgeable ageable){
		EntityCrab entitychild = new EntityCrab(this.world);
        return entitychild;
    }
	
	//protected SoundEvent getAmbientSound(){
    //	return ShopKeeper.SOUND_CRAB_IDLE;
    //}
    
    //protected SoundEvent getHurtSound(){
    //	return ShopKeeper.SOUND_CRAB_HURT;
    //}
    
    //protected SoundEvent getDeathSound(){
    //	return ShopKeeper.SOUND_CRAB_DEATH;
    //}
	
}
