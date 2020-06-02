package net.acecraft.mod.crafting;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class WorkbenchRecipeSorter implements Comparator {
	
	final WorkbenchCraftingManager workbench;
	
	public WorkbenchRecipeSorter(WorkbenchCraftingManager workbenchCraftingManager){
		this.workbench = workbenchCraftingManager;
	}
	
	public int compareRecipes(IRecipe recipe1, IRecipe recipe2){
		return recipe1 instanceof WorkbenchShapelessRecipes && recipe2 instanceof WorkbenchShapedRecipes ? 1: (recipe2 instanceof WorkbenchShapelessRecipes && recipe1 instanceof WorkbenchShapedRecipes ? -1 : (recipe2.getRecipeSize() < recipe1.getRecipeSize() ? -1 : (recipe2.getRecipeSize() > recipe1.getRecipeSize() ? 1 : 0)));
	}
	
	public int compare(Object o1, Object o2) {
		return this.compareRecipes((IRecipe)o1, (IRecipe)o2);
	}

}