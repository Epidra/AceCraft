package mod.acecraft.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;

public class ItemLiquor extends Item {

    // ...





    //----------------------------------------CONSTRUCTOR----------------------------------------//

    /** Default Constructor */
    public ItemLiquor(MobEffect effect1, float probability1, MobEffect effect2, float probability2){
        super(new Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(64).food(new FoodProperties.Builder().nutrition(1).saturationMod(1).alwaysEat().effect(new MobEffectInstance(effect1, 600, 0), probability1).effect(new MobEffectInstance(effect2, 600, 0), probability2).build()));
    }





    //----------------------------------------SUPPORT----------------------------------------//

    public UseAnim getUseAnimation(ItemStack p_41452_) {
        return UseAnim.DRINK;
    }



}

