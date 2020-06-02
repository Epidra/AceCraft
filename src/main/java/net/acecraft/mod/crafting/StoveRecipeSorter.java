package net.acecraft.mod.crafting;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class StoveRecipeSorter implements Comparator {
	
final StoveCraftingManager stove;
	
	public StoveRecipeSorter(StoveCraftingManager stoveCraftingManager){
		this.stove = stoveCraftingManager;
	}
	
	public int compareRecipes(IRecipe recipe1, IRecipe recipe2){
		return recipe1 instanceof StoveShapelessRecipes && recipe2 instanceof StoveShapedRecipes ? 1: (recipe2 instanceof StoveShapelessRecipes && recipe1 instanceof StoveShapedRecipes ? -1 : (recipe2.getRecipeSize() < recipe1.getRecipeSize() ? -1 : (recipe2.getRecipeSize() > recipe1.getRecipeSize() ? 1 : 0)));
	}
	
	public int compare(Object o1, Object o2) {
		return this.compareRecipes((IRecipe)o1, (IRecipe)o2);
	}

}