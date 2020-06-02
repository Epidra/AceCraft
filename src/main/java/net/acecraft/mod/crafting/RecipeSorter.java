package net.acecraft.mod.crafting;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class RecipeSorter implements Comparator {
	
final AceCraftingManager cm;
	
	public RecipeSorter(AceCraftingManager anvilCraftingManager){
		this.cm = anvilCraftingManager;
	}
	
	public int compareRecipes(IRecipe recipe1, IRecipe recipe2){
		return recipe1 instanceof RecipesShapeless && recipe2 instanceof RecipesShaped ? 1: (recipe2 instanceof RecipesShapeless && recipe1 instanceof RecipesShaped ? -1 : (recipe2.getRecipeSize() < recipe1.getRecipeSize() ? -1 : (recipe2.getRecipeSize() > recipe1.getRecipeSize() ? 1 : 0)));
	}
	
	public int compare(Object o1, Object o2) {
		return this.compareRecipes((IRecipe)o1, (IRecipe)o2);
	}

}