package mod.acecraft.items;

import mod.acecraft.entity.EntityNugget;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemNugget extends Item {
	
	public ItemNugget(String name){
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.MATERIALS);
	}

	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn){
        if (!playerIn.capabilities.isCreativeMode){
        	playerIn.getHeldItem(handIn).shrink(1);
        }
        worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        if (!worldIn.isRemote){
            EntityNugget nugget = new EntityNugget(worldIn, playerIn, new ItemStack(this));
            nugget.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
            worldIn.spawnEntity(nugget);
        }
        playerIn.addStat(StatList.getObjectUseStats(this));
        return new ActionResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    }
	
}
