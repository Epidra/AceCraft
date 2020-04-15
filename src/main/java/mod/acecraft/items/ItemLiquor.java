package mod.acecraft.items;

import net.minecraft.item.*;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class ItemLiquor extends Item {

    /** Default Constructor */
    public ItemLiquor(String modid, String name, int hunger, float saturation){
        super(new Properties().group(ItemGroup.FOOD).maxStackSize(64).food(new Food.Builder().hunger(hunger).setAlwaysEdible().saturation(saturation).build()));
        this.setRegistryName(modid, name);
    }

    public UseAction getUseAction(ItemStack stack) {
        //return stack.getItem().isFood() ? UseAction.EAT : UseAction.NONE;
        return UseAction.DRINK;
    }

}

//public class ItemLiquor extends net.minecraft.item.ItemFood {
//
//    int id;
//
//    public ItemLiquor(String name, int _id) {
//        super(2, 2, false);
//        this.setUnlocalizedName(name);
//        this.setRegistryName(name);
//        this.setCreativeTab(CreativeTabs.FOOD);
//        this.setAlwaysEdible();
//        id = _id;
//    }
//
//    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving){
//        if (entityLiving instanceof EntityPlayer){
//            int r = worldIn.rand.nextInt(100);
//            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
//            entityplayer.getFoodStats().addStats(this, stack);
//            if(r > 80) entityplayer.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, 45*(r-80+worldIn.rand.nextInt(10))));
//            if(r > 50) entityplayer.addPotionEffect(new PotionEffect(MobEffects.NAUSEA,    60*(r-50+worldIn.rand.nextInt(10))));
//            switch(id){
//                case 0: if(r > 20)entityplayer.addPotionEffect(new PotionEffect(MobEffects.HASTE,           60*(r-20+worldIn.rand.nextInt(10)))); break; // Cider
//                case 1: if(r > 20)entityplayer.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 60*(r-20+worldIn.rand.nextInt(10)))); break; // Rum
//                case 2: if(r > 20)entityplayer.addPotionEffect(new PotionEffect(MobEffects.LUCK,            60*(r-20+worldIn.rand.nextInt(10)))); break; // Beer
//                case 3: if(r > 20)entityplayer.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST,      60*(r-20+worldIn.rand.nextInt(10)))); break; // Salgam
//                case 4: if(r > 20)entityplayer.addPotionEffect(new PotionEffect(MobEffects.STRENGTH,        60*(r-20+worldIn.rand.nextInt(10)))); break; // Vodka
//                case 5: if(r > 20)entityplayer.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION,    60*(r-20+worldIn.rand.nextInt(10)))); break; // Sake
//                case 6: if(r > 20)entityplayer.addPotionEffect(new PotionEffect(MobEffects.SPEED,           60*(r-20+worldIn.rand.nextInt(10)))); break; // Mead
//                case 7: if(r > 20)entityplayer.addPotionEffect(new PotionEffect(MobEffects.GLOWING,         60*(r-20+worldIn.rand.nextInt(10)))); break; // WineGrapes
//                case 8: if(r > 20)entityplayer.addPotionEffect(new PotionEffect(MobEffects.GLOWING,         60*(r-20+worldIn.rand.nextInt(10)))); break; // WineCherries
//                case 9: if(r > 20)entityplayer.addPotionEffect(new PotionEffect(MobEffects.GLOWING,         60*(r-20+worldIn.rand.nextInt(10)))); break; // WinePineapple
//            }
//            worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
//            this.onFoodEaten(stack, worldIn, entityplayer);
//            entityplayer.addStat(StatList.getObjectUseStats(this));
//        }
//        stack.shrink(1);
//        return stack;
//    }
//
//    public int getMaxItemUseDuration(ItemStack stack) {
//        return 24;
//    }
//
//    public EnumAction getItemUseAction(ItemStack stack) {
//        return EnumAction.DRINK;
//    }
//
//}

