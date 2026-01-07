package mod.acecraft.common.item;

import mod.lucky77.common.item.ItemFood;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;

public class ItemLiquor extends Item {
	
	public ItemLiquor(Holder<MobEffect> effect1, float probability1, Holder<MobEffect> effect2, float probability2){
		super(new Properties().stacksTo(64).food(new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).usingConvertsTo(Items.GLASS_BOTTLE)
				.effect(new MobEffectInstance(effect1, 600, 0), probability1)
				.effect(new MobEffectInstance(effect2, 600, 0), probability2)
				.build()));
	}
	
	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.DRINK;
	}
	
}
