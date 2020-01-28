package mod.acecraft.items;

import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class ItemDynamite extends Item {

    /** Default Constructor */
    public ItemDynamite(String modid, String name, ItemGroup group){
        super(new Properties().group(group));
        this.setRegistryName(modid, name);
    }

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