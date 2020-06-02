package net.acecraft.mod.crafting;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class SewingStationRecipeSorter implements Comparator {
	
	final SewingStationCraftingManager sewingStation;
	
	public SewingStationRecipeSorter(SewingStationCraftingManager sewingStationCraftingManager){
		this.sewingStation = sewingStationCraftingManager;
	}
	
	public int compareRecipes(IRecipe recipe1, IRecipe recipe2){
		return recipe1 instanceof SewingStationShapelessRecipes && recipe2 instanceof SewingStationShapedRecipes ? 1: (recipe2 instanceof SewingStationShapelessRecipes && recipe1 instanceof SewingStationShapedRecipes ? -1 : (recipe2.getRecipeSize() < recipe1.getRecipeSize() ? -1 : (recipe2.getRecipeSize() > recipe1.getRecipeSize() ? 1 : 0)));
	}
	
	public int compare(Object o1, Object o2) {
		return this.compareRecipes((IRecipe)o1, (IRecipe)o2);
	}

}