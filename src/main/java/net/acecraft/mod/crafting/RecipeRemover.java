package net.acecraft.mod.crafting;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;

public class RecipeRemover {
	
	public static void removeCraftingRecipe(){
		List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
		Iterator<IRecipe> remover = recipes.iterator();
		while(remover.hasNext()){
			ItemStack itemstack = remover.next().getRecipeOutput();
			      if(itemstack != null && itemstack.getItem() == Items.map)              { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.wooden_axe)       { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.wooden_hoe)       { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.wooden_pickaxe)   { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.wooden_shovel)    { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.wooden_sword)     { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.iron_axe)         { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.iron_hoe)         { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.iron_pickaxe)     { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.iron_shovel)      { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.iron_sword)       { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.golden_axe)       { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.golden_hoe)       { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.golden_pickaxe)   { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.golden_shovel)    { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.golden_sword)     { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.stone_axe)        { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.stone_hoe)        { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.stone_pickaxe)    { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.stone_shovel)     { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.stone_sword)      { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.diamond_axe)      { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.diamond_hoe)      { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.diamond_pickaxe)  { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.diamond_shovel)   { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.diamond_sword)    { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.iron_helmet)      { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.iron_chestplate)  { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.iron_leggings)    { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.iron_boots)       { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.golden_helmet)    { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.golden_chestplate){ remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.golden_leggings)  { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.golden_boots)     { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.bed)              { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.bucket)           { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.sugar)            { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.bread)            { remover.remove();
			//}else if(itemstack != null && itemstack.getItem() == new ItemStack(Items.dye, 1, 15).getItem()){ remover.remove();
			//}else if(itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.wool))       { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.iron_block)) { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.iron_bars))  { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.iron_door))  { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.gold_block)) { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.golden_rail)){ remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.rail))       { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.bed))        { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.anvil))      { remover.remove();
			}
		}
	}
	
	public static void removeFurnaceRecipe(){
		Map recipes = FurnaceRecipes.smelting().getSmeltingList();
		
		Iterator entries = recipes.entrySet().iterator();
		while(entries.hasNext()){
			Entry thisEntry = (Entry)entries.next();
		}
	}

}