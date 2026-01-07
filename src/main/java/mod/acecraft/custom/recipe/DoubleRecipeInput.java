package mod.acecraft.custom.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record DoubleRecipeInput(ItemStack item0, ItemStack item1) implements RecipeInput {
	@Override
	public ItemStack getItem(int index) {
		if (index > 1) {
			throw new IllegalArgumentException("No item for index " + index);
		} else {
			return index == 0 ? item0 : item1;
		}
	}
	
	@Override
	public int size() {
		return 2;
	}
}
