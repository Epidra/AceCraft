package mod.acecraft.items;

import mod.acecraft.ShopKeeper;
import mod.acecraft.entity.EntityDynamite;
import mod.acecraft.entity.EntityNugget;
import mod.acecraft.network.MessageDynamiteServer;
import mod.acecraft.system.AceCraftPacketHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class ItemNugget extends Item {

    /** Default Constructor */
    public ItemNugget(String modid, String name, ItemGroup group){
        super(new Properties().group(group));
        this.setRegistryName(modid, name);
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        if (!playerIn.abilities.isCreativeMode) {
            itemstack.shrink(1);
        }

     //   worldIn.playSound((PlayerEntity)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
        if (!worldIn.isRemote) {
            EntityNugget snowballentity = new EntityNugget(worldIn, playerIn, itemstack);
            snowballentity.setItem(itemstack);
       //     snowballentity.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
            worldIn.addEntity(snowballentity);
            //AceCraftPacketHandler.sendToServer(new MessageDynamiteServer(playerIn.posX, playerIn.posY, playerIn.posZ, playerIn.rotationPitch, playerIn.rotationYaw));
        }

        playerIn.addStat(Stats.ITEM_USED.get(this));
        return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
    }

    //public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
    //    //if (this.isFood()) {
    //    //    ItemStack itemstack = playerIn.getHeldItem(handIn);
    //    //    if (playerIn.canEat(this.getFood().canEatWhenFull())) {
    //    //        playerIn.setActiveHand(handIn);
    //    //        return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
    //    //    } else {
    //    //        return new ActionResult<>(ActionResultType.FAIL, itemstack);
    //    //    }
    //    //} else {
    //    //    return new ActionResult<>(ActionResultType.PASS, playerIn.getHeldItem(handIn));
    //    //}
    //    if (!playerIn.abilities.isCreativeMode){
    //        playerIn.getHeldItem(handIn).shrink(1);
    //    }
    //    worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
    //    if (!worldIn.isRemote){
    //        EntityDynamite nugget = new EntityDynamite(worldIn, playerIn);
    //        //EntityDynamite nugget = new EntityDynamite(ShopKeeper.ENTITY_DYNAMITE, worldIn);
    //        nugget.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
    //        //worldIn.spawnEntity(nugget);
    //        worldIn.addEntity(nugget);
    //    }
    //    //playerIn.addStat(StatList.getObjectUseStats(this));
    //    //return new ActionResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    //    return new ActionResult<>(ActionResultType.SUCCESS, playerIn.getHeldItem(handIn));
    //}

}

//public class ItemDynamite extends Item {
//
//    public ItemDynamite(String name){
//        this.setUnlocalizedName(name);
//        this.setRegistryName(name);
//        this.setCreativeTab(CreativeTabs.TOOLS);
//    }
//
//    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn){
//        if (!playerIn.capabilities.isCreativeMode){
//            playerIn.getHeldItem(handIn).shrink(1);
//        }
//        worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
//        if (!worldIn.isRemote){
//            EntityDynamite nugget = new EntityDynamite(worldIn, playerIn);
//            nugget.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 1.0F);
//            worldIn.spawnEntity(nugget);
//        }
//        playerIn.addStat(StatList.getObjectUseStats(this));
//        return new ActionResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
//    }
//
//}