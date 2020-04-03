package mod.acecraft.items;

import mod.acecraft.entity.EntityNugget;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class ItemNugget extends Item {

    /** Default Constructor */
    public ItemNugget(String modid, String name, ItemGroup group){
        super(new Properties().group(group));
        this.setRegistryName(modid, name);
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        //if (this.isFood()) {
        //    ItemStack itemstack = playerIn.getHeldItem(handIn);
        //    if (playerIn.canEat(this.getFood().canEatWhenFull())) {
        //        playerIn.setActiveHand(handIn);
        //        return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
        //    } else {
        //        return new ActionResult<>(ActionResultType.FAIL, itemstack);
        //    }
        //} else {
        //    return new ActionResult<>(ActionResultType.PASS, playerIn.getHeldItem(handIn));
        //}
        if (!playerIn.abilities.isCreativeMode){
            playerIn.getHeldItem(handIn).shrink(1);
        }
        worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
        if (!worldIn.isRemote){
            EntityNugget nugget = new EntityNugget(worldIn, playerIn);
            //EntityDynamite nugget = new EntityDynamite(ShopKeeper.ENTITY_DYNAMITE, worldIn);
            nugget.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
            //worldIn.spawnEntity(nugget);
            worldIn.addEntity(nugget);
        }
        //playerIn.addStat(StatList.getObjectUseStats(this));
        //return new ActionResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
        return new ActionResult<>(ActionResultType.PASS, playerIn.getHeldItem(handIn));
    }

}

//public class ItemNugget extends Item {
//
//    public ItemNugget(String name){
//        this.setUnlocalizedName(name);
//        this.setRegistryName(name);
//        this.setCreativeTab(CreativeTabs.MATERIALS);
//    }
//
//    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn){
//        if (!playerIn.capabilities.isCreativeMode){
//            playerIn.getHeldItem(handIn).shrink(1);
//        }
//        worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
//        if (!worldIn.isRemote){
//            EntityNugget nugget = new EntityNugget(worldIn, playerIn, new ItemStack(this));
//            nugget.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
//            worldIn.spawnEntity(nugget);
//        }
//        playerIn.addStat(StatList.getObjectUseStats(this));
//        return new ActionResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
//    }
//
//}
