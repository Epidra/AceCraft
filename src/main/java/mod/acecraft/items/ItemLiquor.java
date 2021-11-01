package mod.acecraft.items;

import net.minecraft.item.*;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;

public class ItemLiquor extends Item {

    // ...





    //----------------------------------------CONSTRUCTOR----------------------------------------//

    /** Default Constructor */
    public ItemLiquor(Effect effect1, float probability1, Effect effect2, float probability2){
        super(new Properties().tab(ItemGroup.TAB_FOOD).stacksTo(64).food(new Food.Builder().nutrition(1).alwaysEat().saturationMod(1).effect(new EffectInstance(effect1, 600, 0), probability1).effect(new EffectInstance(effect2, 600, 0), probability2).build()));
    }





    //----------------------------------------SUPPORT----------------------------------------//

    public UseAction getUseAnimation(ItemStack stack) {
        return UseAction.DRINK;
    }



}

