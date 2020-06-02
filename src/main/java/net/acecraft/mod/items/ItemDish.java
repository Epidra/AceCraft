package net.acecraft.mod.items;

import net.acecraft.mod.ShopKeeper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemDish extends net.minecraft.item.ItemFood {
	
	boolean isDrink;
	boolean returnBowl;
	boolean needFurnace;
	boolean needCauldron;
	
	public ItemDish(String name, int _hunger, float _saturation, boolean _wolfFood, boolean _isDrink, boolean _returnBowl, boolean _needFurnace, boolean _needCauldron) {
		super(_hunger, _saturation, _wolfFood);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.tabFood);
		isDrink = _isDrink;
		returnBowl = _returnBowl;
		needFurnace = _needFurnace;
		needCauldron = _needCauldron;
	}
	
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving){
        if (entityLiving instanceof EntityPlayer){
            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            entityplayer.getFoodStats().addStats(this, stack);
            worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.entity_player_burp, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
            this.onFoodEaten(stack, worldIn, entityplayer);
            entityplayer.addStat(StatList.func_188057_b(this));
            if(stack.getItem() == ShopKeeper.juiceMilk || stack.getItem() == ShopKeeper.juiceCoconutMilk || stack.getItem() == ShopKeeper.juiceChocolateMilk){
            	entityplayer.curePotionEffects(stack);
        	}
        	if(stack.getItem() == ShopKeeper.dishSeaSaltIceCream){
        		entityplayer.inventory.addItemStackToInventory(new ItemStack(Items.stick));
        	}
        	if(returnBowl && !isDrink){
        		entityplayer.inventory.addItemStackToInventory(new ItemStack(Items.bowl));
        	}
        	if(returnBowl &&  isDrink){
        		entityplayer.inventory.addItemStackToInventory(new ItemStack(Items.glass_bottle));
        	}
        }
        --stack.stackSize;
        return stack;
    }
	
    public int getMaxItemUseDuration(ItemStack stack) {
        return 16;
    }

    public EnumAction getItemUseAction(ItemStack stack) {
    	if(isDrink){
    		return EnumAction.DRINK;
    	}else{
    		return EnumAction.EAT;
    	}
    }
    
    public boolean getNeedFurnace(){
    	return needFurnace;
    }
    
    public boolean getNeedCauldron(){
    	return needCauldron;
    }
    
}