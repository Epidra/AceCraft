package net.acecraft.mod.crafting;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

import net.acecraft.mod.ShopKeeper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemStack;

public class BlastFurnaceRecipes{
    
	private static final BlastFurnaceRecipes SMELTING_BASE = new BlastFurnaceRecipes();
    
    private static float tolerance = 0.1f;
    
    /**
     * Returns an instance of FurnaceRecipes.
     */
    public static BlastFurnaceRecipes instance(){
        return SMELTING_BASE;
    }
    
    private BlastFurnaceRecipes(){
    	
    }
    
    /**
     * Returns the smelting result of an item.
     */
    @Nullable
    public ItemStack getSmeltingResult(ItemStack[] slots){
    	
    	int countIron = 0;
    	int countGold = 0;
    	int countCopper = 0;
    	int countAluminium = 0;
    	int countLead = 0;
    	int countTin = 0;
    	int countZinc = 0;
    	int countSilver = 0;
    	int countMythril = 0;
    	int countAdamantium = 0;
    	int countOrichalcum = 0;
    	int countUnobtanium = 0;
    	int countCoal = 0;
    	
    	countIron += 1 * match(ShopKeeper.nuggetIron, slots);
    	countIron += 1 * match(Items.IRON_INGOT,      slots);
    	countIron += 9 * match(Blocks.IRON_BLOCK,     slots);
    	countGold += 1 * match(ShopKeeper.nuggetGold, slots);
    	countGold += 1 * match(Items.GOLD_INGOT,      slots);
    	countIron += 9 * match(Blocks.GOLD_BLOCK,     slots);
    	
    	countCopper += 1 * match(ShopKeeper.nuggetCopper, slots);
    	countCopper += 1 * match(ShopKeeper.ingotCopper,  slots);
    	countCopper += 9 * match(ShopKeeper.blockCopper,  slots);
    	
    	countAluminium += 1 * match(ShopKeeper.nuggetBauxite,  slots);
    	countAluminium += 1 * match(ShopKeeper.ingotAluminium, slots);
    	countAluminium += 9 * match(ShopKeeper.blockAluminium, slots);
    	
    	countLead += 1 * match(ShopKeeper.nuggetLead, slots);
    	countLead += 1 * match(ShopKeeper.ingotLead,  slots);
    	countLead += 9 * match(ShopKeeper.blockLead,  slots);
    	
    	countTin += 1 * match(ShopKeeper.nuggetTin, slots);
    	countTin += 1 * match(ShopKeeper.ingotTin,  slots);
    	countTin += 9 * match(ShopKeeper.blockTin,  slots);
    	
    	countZinc += 1 * match(ShopKeeper.nuggetZinc, slots);
    	countZinc += 1 * match(ShopKeeper.ingotZinc,  slots);
    	countZinc += 9 * match(ShopKeeper.blockZinc,  slots);
    	
    	countSilver += 1 * match(ShopKeeper.nuggetSilver, slots);
    	countSilver += 1 * match(ShopKeeper.ingotSilver,  slots);
    	countSilver += 9 * match(ShopKeeper.blockSilver,  slots);
    	
    	countMythril += 1 * match(ShopKeeper.nuggetMythril, slots);
    	countMythril += 1 * match(ShopKeeper.ingotMythril,  slots);
    	countMythril += 9 * match(ShopKeeper.blockMythril,  slots);
    	
    	countAdamantium += 1 * match(ShopKeeper.nuggetAdamantium, slots);
    	countAdamantium += 1 * match(ShopKeeper.ingotAdamantium,  slots);
    	countAdamantium += 9 * match(ShopKeeper.blockAdamantium,  slots);
    	
    	countOrichalcum += 1 * match(ShopKeeper.nuggetOrichalcum, slots);
    	countOrichalcum += 1 * match(ShopKeeper.ingotOrichalcum,  slots);
    	countOrichalcum += 9 * match(ShopKeeper.blockOrichalcum,  slots);
    	
    	countUnobtanium += 1 * match(ShopKeeper.nuggetUnobtanium, slots);
    	countUnobtanium += 1 * match(ShopKeeper.ingotUnobtanium,  slots);
    	countUnobtanium += 9 * match(ShopKeeper.blockUnobtanium,  slots);
    	
    	countCoal += 1 * match(Items.COAL, slots);
    	
    	float countTotal = countIron + countGold + countCopper + countAluminium + countLead + countTin + countZinc + countSilver + countMythril + countAdamantium + countOrichalcum + countUnobtanium + countCoal;
    	
    	float scaleIron       = countIron       / countTotal;
    	float scaleGold       = countGold       / countTotal;
    	float scaleCopper     = countCopper     / countTotal;
    	float scaleAluminium  = countAluminium  / countTotal;
    	float scaleLead       = countLead       / countTotal;
    	float scaleTin        = countTin        / countTotal;
    	float scaleZinc       = countZinc       / countTotal;
    	float scaleSilver     = countSilver     / countTotal;
    	float scaleMythril    = countMythril    / countTotal;
    	float scaleAdamantium = countAdamantium / countTotal;
    	float scaleOrichalcum = countOrichalcum / countTotal;
    	float scaleUnobtanium = countUnobtanium / countTotal;
    	float scaleCoal       = countCoal       / countTotal;
    	
    	if(circa(scaleCopper, 0.9f) && circa(scaleTin,  0.1f)) return new ItemStack(ShopKeeper.ingotBronze, (int)countTotal);
    	if(circa(scaleCopper, 0.9f) && circa(scaleZinc, 0.1f)) return new ItemStack(ShopKeeper.ingotBrass,  (int)countTotal);
    	if(circa(scaleIron,   0.9f) && circa(scaleCoal, 0.1f)) return new ItemStack(ShopKeeper.ingotSteel,  (int)countTotal);
    	
    	if(circa(scaleIron,       1)) return new ItemStack(Items.IRON_INGOT,           (int)countTotal);
    	if(circa(scaleGold,       1)) return new ItemStack(Items.GOLD_INGOT,           (int)countTotal);
    	if(circa(scaleCopper,     1)) return new ItemStack(ShopKeeper.ingotCopper,     (int)countTotal);
    	if(circa(scaleAluminium,  1)) return new ItemStack(ShopKeeper.ingotAluminium,  (int)countTotal);
    	if(circa(scaleLead,       1)) return new ItemStack(ShopKeeper.ingotLead,       (int)countTotal);
    	if(circa(scaleTin,        1)) return new ItemStack(ShopKeeper.ingotTin,        (int)countTotal);
    	if(circa(scaleZinc,       1)) return new ItemStack(ShopKeeper.ingotZinc,       (int)countTotal);
    	if(circa(scaleSilver,     1)) return new ItemStack(ShopKeeper.ingotSilver,     (int)countTotal);
    	if(circa(scaleMythril,    1)) return new ItemStack(ShopKeeper.ingotMythril,    (int)countTotal);
    	if(circa(scaleAdamantium, 1)) return new ItemStack(ShopKeeper.ingotAdamantium, (int)countTotal);
    	if(circa(scaleOrichalcum, 1)) return new ItemStack(ShopKeeper.ingotOrichalcum, (int)countTotal);
    	if(circa(scaleUnobtanium, 1)) return new ItemStack(ShopKeeper.ingotUnobtanium, (int)countTotal);
    	
    	
        return null;
    }
    
    private boolean circa(float scale, float value){
    	if(value - tolerance < scale && scale < value + tolerance)
    		return true;
    	return false;
    }
    
    private int match(Item item, ItemStack[] slots){
    	int counter = 0;
    	for(int i = 0; i < 10; i++){
    		if(slots[i].getItem() == item) counter++;
    	}
    	return counter;
    }
    
    private int match(Block block, ItemStack[] slots){
    	int counter = 0;
    	for(int i = 0; i < 10; i++){
    		if(slots[i].getItem() == Item.getItemFromBlock(block)) counter++;
    	}
    	return counter;
    }
}