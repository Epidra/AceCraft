package net.acecraft.mod.entity;

import javax.annotation.Nullable;

import net.acecraft.mod.ShopKeeper;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class EntityZed extends EntityAgeable {
	
	public EntityZed(World world) {
		super(world);
        this.setSize(1, 2);
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
        this.setItemStackToSlot(EntityEquipmentSlot.FEET,     new ItemStack(Items.CHAINMAIL_BOOTS));
        this.setItemStackToSlot(EntityEquipmentSlot.LEGS,     new ItemStack(Items.CHAINMAIL_LEGGINGS));
        this.setItemStackToSlot(EntityEquipmentSlot.CHEST,    new ItemStack(Items.CHAINMAIL_CHESTPLATE));
        this.setItemStackToSlot(EntityEquipmentSlot.HEAD,     new ItemStack(Items.CHAINMAIL_HELMET));
	}
	
	protected void applyEntityAttributes(){
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(8.0D);
        //this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.0D);
        //this.getEntityAttribute(SharedMonsterAttributes.ATTACK_SPEED).setBaseValue(4.0D);
    }
    
    protected void initEntityAI(){
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.25D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.1D, Items.WHEAT, false));
        this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
    }

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		// TODO Auto-generated method stub
		return null;
	}
    
	public boolean processInteract(EntityPlayer player, EnumHand hand, @Nullable ItemStack stack){
		if(stack != null && stack.getItem() instanceof ItemSword){
			if(this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND) != null){
				ItemStack temp = this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND);
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, stack);
				player.setHeldItem(hand, temp);
			} else {
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, stack);
				player.setHeldItem(hand, null);
			}
		}
		if(stack != null && stack.getItem() == Items.GOLDEN_CHESTPLATE){
			if(this.getItemStackFromSlot(EntityEquipmentSlot.CHEST) != null){
				ItemStack temp = this.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
				this.setItemStackToSlot(EntityEquipmentSlot.CHEST, stack);
				player.setHeldItem(hand, temp);
			} else {
				this.setItemStackToSlot(EntityEquipmentSlot.CHEST, stack);
				player.setHeldItem(hand, null);
			}
		}
        if (stack != null && stack.getItem() == Items.BUCKET){// && !player.capabilities.isCreativeMode && !this.isChild()){
            player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);

            if (--stack.stackSize == 0){
                player.setHeldItem(hand, new ItemStack(Items.MILK_BUCKET));
            } else if (!player.inventory.addItemStackToInventory(new ItemStack(Items.MILK_BUCKET))){
                player.dropItem(new ItemStack(Items.MILK_BUCKET), false);
            }
            return true;
        } else {
            return super.processInteract(player, hand, stack);
        }
    }
	
    protected Item getDropItem(){
        return Items.ROTTEN_FLESH;
    }

}