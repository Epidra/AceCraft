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

public class ItemDrink extends net.minecraft.item.ItemFood {
	
	public ItemDrink(String name, int _hunger, float _saturation, boolean _alwaysEdible) {
		super(_hunger, _saturation, false);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.tabFood);
		if(_alwaysEdible){
			this.setAlwaysEdible();
		}
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
            entityplayer.inventory.addItemStackToInventory(new ItemStack(Items.glass_bottle));
        }
        --stack.stackSize;
        return stack;
    }
	
    public int getMaxItemUseDuration(ItemStack stack) {
        return 32;
    }

    public EnumAction getItemUseAction(ItemStack stack) {
    	return EnumAction.DRINK;
    }

}