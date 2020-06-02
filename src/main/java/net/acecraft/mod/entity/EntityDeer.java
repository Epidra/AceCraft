package net.acecraft.mod.entity;

import net.acecraft.mod.ShopKeeper;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityDeer extends EntityAnimal {
	
	public EntityDeer(World world) {
		super(world);
		this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, false));
        this.setSize(1.2f, 1.5f);
	}
	
	@Override
	protected void applyEntityAttributes(){
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.0D);
	}
	
	protected boolean isAIEnabled(){
        return true;
    }
	
	protected String getLivingSound(){
        return "acecraft:deer-say";
    }
	
    protected String getHurtSound(){
        return "acecraft:deer-hurt";
    }
    
    protected String getDeathSound(){
        return "acecraft:deer-death";
    }
    
    protected Item getDropItem(){
        return ShopKeeper.foodVenisonRaw;
    }
    
	@Override
	public EntityAgeable createChild(EntityAgeable entity) {
		return null;
	}

}