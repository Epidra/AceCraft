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
			      if(itemstack != null && itemstack.getItem() == Items.MAP)              { remover.remove();
			//}else if(itemstack != null && itemstack.getItem() == Items.WOODEN_AXE)       { remover.remove();
			//}else if(itemstack != null && itemstack.getItem() == Items.WOODEN_HOE)       { remover.remove();
			//}else if(itemstack != null && itemstack.getItem() == Items.WOODEN_PICKAXE)   { remover.remove();
			//}else if(itemstack != null && itemstack.getItem() == Items.WOODEN_SHOVEL)    { remover.remove();
			//}else if(itemstack != null && itemstack.getItem() == Items.WOODEN_SWORD)     { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.IRON_AXE)         { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.IRON_HOE)         { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.IRON_PICKAXE)     { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.IRON_SHOVEL)      { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.IRON_SWORD)       { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.GOLDEN_AXE)       { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.GOLDEN_HOE)       { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.GOLDEN_PICKAXE)   { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.GOLDEN_SHOVEL)    { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.GOLDEN_SWORD)     { remover.remove();
			//}else if(itemstack != null && itemstack.getItem() == Items.STONE_AXE)        { remover.remove();
			//}else if(itemstack != null && itemstack.getItem() == Items.STONE_HOE)        { remover.remove();
			//}else if(itemstack != null && itemstack.getItem() == Items.STONE_PICKAXE)    { remover.remove();
			//}else if(itemstack != null && itemstack.getItem() == Items.STONE_SHOVEL)     { remover.remove();
			//}else if(itemstack != null && itemstack.getItem() == Items.STONE_SWORD)      { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.DIAMOND_AXE)      { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.DIAMOND_HOE)      { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.DIAMOND_PICKAXE)  { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.DIAMOND_SHOVEL)   { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.DIAMOND_SWORD)    { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.IRON_HELMET)      { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.IRON_CHESTPLATE)  { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.IRON_LEGGINGS)    { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.IRON_BOOTS)       { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.GOLDEN_HELMET)    { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.GOLDEN_CHESTPLATE){ remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.GOLDEN_LEGGINGS)  { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.GOLDEN_BOOTS)     { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.BED)              { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.BUCKET)           { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.SUGAR)            { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Items.BREAD)            { remover.remove();
			//}else if(itemstack != null && itemstack.getItem() == new ItemStack(Items.dye, 1, 15).getItem()){ remover.remove();
			//}else if(itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.wool))       { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.IRON_BLOCK)) { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.IRON_BARS))  { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.IRON_DOOR))  { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.GOLD_BLOCK)) { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.GOLDEN_RAIL)){ remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.RAIL))       { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.BED))        { remover.remove();
			}else if(itemstack != null && itemstack.getItem() == Item.getItemFromBlock(Blocks.ANVIL))      { remover.remove();
			}
		}
	}
	
	public static void removeFurnaceRecipe(){
		Map recipes = FurnaceRecipes.instance().getSmeltingList();
		
		Iterator entries = recipes.entrySet().iterator();
		while(entries.hasNext()){
			Entry thisEntry = (Entry)entries.next();
		}
	}

}