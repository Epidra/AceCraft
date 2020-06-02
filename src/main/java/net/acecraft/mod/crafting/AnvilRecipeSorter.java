package net.acecraft.mod.crafting;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class AnvilRecipeSorter implements Comparator {
	
final AnvilCraftingManager anvil;
	
	public AnvilRecipeSorter(AnvilCraftingManager anvilCraftingManager){
		this.anvil = anvilCraftingManager;
	}
	
	public int compareRecipes(IRecipe recipe1, IRecipe recipe2){
		return recipe1 instanceof AnvilShapelessRecipes && recipe2 instanceof AnvilShapedRecipes ? 1: (recipe2 instanceof AnvilShapelessRecipes && recipe1 instanceof AnvilShapedRecipes ? -1 : (recipe2.getRecipeSize() < recipe1.getRecipeSize() ? -1 : (recipe2.getRecipeSize() > recipe1.getRecipeSize() ? 1 : 0)));
	}
	
	public int compare(Object o1, Object o2) {
		return this.compareRecipes((IRecipe)o1, (IRecipe)o2);
	}

}