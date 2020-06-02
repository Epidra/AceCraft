package net.acecraft.mod.entity;

import java.util.Random;

import net.acecraft.mod.ShopKeeper;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityLlama extends EntitySheep {
	
	public EntityLlama(World world) {
		super(world);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, false));
        this.setSize(1f, 1.5f);
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
        return "acecraft:llama-say";
    }
	
    protected String getHurtSound(){
        return "acecraft:llama-hurt";
    }
    
    protected String getDeathSound(){
        return "acecraft:llama-death";
    }
    
    protected Item getDropItem(){
        return ShopKeeper.foodMuttonRaw;
    }
    
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData idata){
        idata = super.onSpawnWithEgg(idata);
        this.setFleeceColor(getRandomColor(this.worldObj.rand));
        return idata;
    }
    
    public static int getRandomColor(Random random){
        int i = random.nextInt(100);
        if(i ==   0) return  6;
        if(i  <  10) return  1;
        if(i  <  35) return 12;
        if(i  <  60) return  4;
        if(i  <  90) return  8;
        if(i  < 100) return  7;
        return 0;
    }
    
    @Override
	public EntitySheep createChild(EntityAgeable entity) {
		return null;
	}
    
}