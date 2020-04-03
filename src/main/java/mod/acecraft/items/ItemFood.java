package mod.acecraft.items;

import javafx.util.Pair;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import java.util.List;

public class ItemFood extends Item {

    /** Default Constructor */
    public ItemFood(String modid, String name, int hunger, float saturation){
        super(new Properties().group(ItemGroup.FOOD).maxStackSize(16).food(new Food.Builder().hunger(hunger).saturation(saturation).build()));
        this.setRegistryName(modid, name);
    }

    public UseAction getUseAction(ItemStack stack) {
        //return stack.getItem().isFood() ? UseAction.EAT : UseAction.NONE;
        return UseAction.EAT;
    }

}

//public class ItemFood extends net.minecraft.item.ItemFood {
//
//    boolean isDrink;
//    boolean returnBowl;
//
//    public ItemFood(String name, int _hunger, float _saturation, boolean _wolfFood, boolean _isDrink, boolean _returnBowl) {
//        super(_hunger, _saturation, _wolfFood);
//        this.setUnlocalizedName(name);
//        this.setRegistryName(name);
//        this.setCreativeTab(CreativeTabs.FOOD);
//        isDrink = _isDrink;
//        returnBowl = _returnBowl;
//    }
//
//    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving){
//        if (entityLiving instanceof EntityPlayer){
//            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
//            entityplayer.getFoodStats().addStats(this, stack);
//            worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS, 0.5F, worldIn.rand.nextFloat() * 0.1F + 0.9F);
//            this.onFoodEaten(stack, worldIn, entityplayer);
//            entityplayer.addStat(StatList.getObjectUseStats(this));
//        }
//        stack.shrink(1);
//        return stack;
//    }
//
//    public int getMaxItemUseDuration(ItemStack stack) {
//        return 32;
//    }
//
//    public EnumAction getItemUseAction(ItemStack stack) {
//        return isDrink ? EnumAction.DRINK : EnumAction.EAT;
//    }
//
//}
