package net.acecraft.mod.crafting;

import net.acecraft.mod.ShopKeeper;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BlastFurnaceRecipes {
	
	public BlastFurnaceRecipes(){
		
	}
	
	public static ItemStack getSmeltingResult(Item item0, Item item1, Item item2, Item item3, Item item4, Item item5, Item item6, Item item7, Item item8, Item item9){
		return getOutput(item0, item1, item2, item3, item4, item5, item6, item7, item8, item9);
	}
	
	public static ItemStack getOutput(Item item0, Item item1, Item item2, Item item3, Item item4, Item item5, Item item6, Item item7, Item item8, Item item9){
		
		int countIron       = 0;
		int countGold       = 0;
		int countCopper     = 0;
		int countAluminium  = 0;
		int countLead       = 0;
		int countTin        = 0;
		int countZinc       = 0;
		int countSilver     = 0;
		int countMythril    = 0;
		int countIridium    = 0;
		int countAdamantium = 0;
		int countOrichalcum = 0;
		int countUnobtanium = 0;
		int countCoal       = 0;
		
		if(item0 == ShopKeeper.nuggetIron || item0 == Items.iron_ingot){ countIron++; }
		if(item1 == ShopKeeper.nuggetIron || item1 == Items.iron_ingot){ countIron++; }
		if(item2 == ShopKeeper.nuggetIron || item2 == Items.iron_ingot){ countIron++; }
		if(item3 == ShopKeeper.nuggetIron || item3 == Items.iron_ingot){ countIron++; }
		if(item4 == ShopKeeper.nuggetIron || item4 == Items.iron_ingot){ countIron++; }
		if(item5 == ShopKeeper.nuggetIron || item5 == Items.iron_ingot){ countIron++; }
		if(item6 == ShopKeeper.nuggetIron || item6 == Items.iron_ingot){ countIron++; }
		if(item7 == ShopKeeper.nuggetIron || item7 == Items.iron_ingot){ countIron++; }
		if(item8 == ShopKeeper.nuggetIron || item8 == Items.iron_ingot){ countIron++; }
		if(item9 == ShopKeeper.nuggetIron || item9 == Items.iron_ingot){ countIron++; }
		
		if(item0 == ShopKeeper.nuggetGold || item0 == Items.gold_ingot){ countGold++; }
		if(item1 == ShopKeeper.nuggetGold || item1 == Items.gold_ingot){ countGold++; }
		if(item2 == ShopKeeper.nuggetGold || item2 == Items.gold_ingot){ countGold++; }
		if(item3 == ShopKeeper.nuggetGold || item3 == Items.gold_ingot){ countGold++; }
		if(item4 == ShopKeeper.nuggetGold || item4 == Items.gold_ingot){ countGold++; }
		if(item5 == ShopKeeper.nuggetGold || item5 == Items.gold_ingot){ countGold++; }
		if(item6 == ShopKeeper.nuggetGold || item6 == Items.gold_ingot){ countGold++; }
		if(item7 == ShopKeeper.nuggetGold || item7 == Items.gold_ingot){ countGold++; }
		if(item8 == ShopKeeper.nuggetGold || item8 == Items.gold_ingot){ countGold++; }
		if(item9 == ShopKeeper.nuggetGold || item9 == Items.gold_ingot){ countGold++; }
		
		if(item0 == ShopKeeper.nuggetCopper || item0 == ShopKeeper.ingotCopper){ countCopper++; }
		if(item1 == ShopKeeper.nuggetCopper || item1 == ShopKeeper.ingotCopper){ countCopper++; }
		if(item2 == ShopKeeper.nuggetCopper || item2 == ShopKeeper.ingotCopper){ countCopper++; }
		if(item3 == ShopKeeper.nuggetCopper || item3 == ShopKeeper.ingotCopper){ countCopper++; }
		if(item4 == ShopKeeper.nuggetCopper || item4 == ShopKeeper.ingotCopper){ countCopper++; }
		if(item5 == ShopKeeper.nuggetCopper || item5 == ShopKeeper.ingotCopper){ countCopper++; }
		if(item6 == ShopKeeper.nuggetCopper || item6 == ShopKeeper.ingotCopper){ countCopper++; }
		if(item7 == ShopKeeper.nuggetCopper || item7 == ShopKeeper.ingotCopper){ countCopper++; }
		if(item8 == ShopKeeper.nuggetCopper || item8 == ShopKeeper.ingotCopper){ countCopper++; }
		if(item9 == ShopKeeper.nuggetCopper || item9 == ShopKeeper.ingotCopper){ countCopper++; }
		
		if(item0 == ShopKeeper.nuggetBauxite || item0 == ShopKeeper.ingotAluminium){ countAluminium++; }
		if(item1 == ShopKeeper.nuggetBauxite || item1 == ShopKeeper.ingotAluminium){ countAluminium++; }
		if(item2 == ShopKeeper.nuggetBauxite || item2 == ShopKeeper.ingotAluminium){ countAluminium++; }
		if(item3 == ShopKeeper.nuggetBauxite || item3 == ShopKeeper.ingotAluminium){ countAluminium++; }
		if(item4 == ShopKeeper.nuggetBauxite || item4 == ShopKeeper.ingotAluminium){ countAluminium++; }
		if(item5 == ShopKeeper.nuggetBauxite || item5 == ShopKeeper.ingotAluminium){ countAluminium++; }
		if(item6 == ShopKeeper.nuggetBauxite || item6 == ShopKeeper.ingotAluminium){ countAluminium++; }
		if(item7 == ShopKeeper.nuggetBauxite || item7 == ShopKeeper.ingotAluminium){ countAluminium++; }
		if(item8 == ShopKeeper.nuggetBauxite || item8 == ShopKeeper.ingotAluminium){ countAluminium++; }
		if(item9 == ShopKeeper.nuggetBauxite || item9 == ShopKeeper.ingotAluminium){ countAluminium++; }
		
		if(item0 == ShopKeeper.nuggetLead || item0 == ShopKeeper.ingotLead){ countLead++; }
		if(item1 == ShopKeeper.nuggetLead || item1 == ShopKeeper.ingotLead){ countLead++; }
		if(item2 == ShopKeeper.nuggetLead || item2 == ShopKeeper.ingotLead){ countLead++; }
		if(item3 == ShopKeeper.nuggetLead || item3 == ShopKeeper.ingotLead){ countLead++; }
		if(item4 == ShopKeeper.nuggetLead || item4 == ShopKeeper.ingotLead){ countLead++; }
		if(item5 == ShopKeeper.nuggetLead || item5 == ShopKeeper.ingotLead){ countLead++; }
		if(item6 == ShopKeeper.nuggetLead || item6 == ShopKeeper.ingotLead){ countLead++; }
		if(item7 == ShopKeeper.nuggetLead || item7 == ShopKeeper.ingotLead){ countLead++; }
		if(item8 == ShopKeeper.nuggetLead || item8 == ShopKeeper.ingotLead){ countLead++; }
		if(item9 == ShopKeeper.nuggetLead || item9 == ShopKeeper.ingotLead){ countLead++; }
		
		if(item0 == ShopKeeper.nuggetTin || item0 == ShopKeeper.ingotTin){ countTin++; }
		if(item1 == ShopKeeper.nuggetTin || item1 == ShopKeeper.ingotTin){ countTin++; }
		if(item2 == ShopKeeper.nuggetTin || item2 == ShopKeeper.ingotTin){ countTin++; }
		if(item3 == ShopKeeper.nuggetTin || item3 == ShopKeeper.ingotTin){ countTin++; }
		if(item4 == ShopKeeper.nuggetTin || item4 == ShopKeeper.ingotTin){ countTin++; }
		if(item5 == ShopKeeper.nuggetTin || item5 == ShopKeeper.ingotTin){ countTin++; }
		if(item6 == ShopKeeper.nuggetTin || item6 == ShopKeeper.ingotTin){ countTin++; }
		if(item7 == ShopKeeper.nuggetTin || item7 == ShopKeeper.ingotTin){ countTin++; }
		if(item8 == ShopKeeper.nuggetTin || item8 == ShopKeeper.ingotTin){ countTin++; }
		if(item9 == ShopKeeper.nuggetTin || item9 == ShopKeeper.ingotTin){ countTin++; }
		
		if(item0 == ShopKeeper.nuggetZinc || item0 == ShopKeeper.ingotZinc){ countZinc++; }
		if(item1 == ShopKeeper.nuggetZinc || item1 == ShopKeeper.ingotZinc){ countZinc++; }
		if(item2 == ShopKeeper.nuggetZinc || item2 == ShopKeeper.ingotZinc){ countZinc++; }
		if(item3 == ShopKeeper.nuggetZinc || item3 == ShopKeeper.ingotZinc){ countZinc++; }
		if(item4 == ShopKeeper.nuggetZinc || item4 == ShopKeeper.ingotZinc){ countZinc++; }
		if(item5 == ShopKeeper.nuggetZinc || item5 == ShopKeeper.ingotZinc){ countZinc++; }
		if(item6 == ShopKeeper.nuggetZinc || item6 == ShopKeeper.ingotZinc){ countZinc++; }
		if(item7 == ShopKeeper.nuggetZinc || item7 == ShopKeeper.ingotZinc){ countZinc++; }
		if(item8 == ShopKeeper.nuggetZinc || item8 == ShopKeeper.ingotZinc){ countZinc++; }
		if(item9 == ShopKeeper.nuggetZinc || item9 == ShopKeeper.ingotZinc){ countZinc++; }
		
		if(item0 == ShopKeeper.nuggetSilver || item0 == ShopKeeper.ingotSilver){ countSilver++; }
		if(item1 == ShopKeeper.nuggetSilver || item1 == ShopKeeper.ingotSilver){ countSilver++; }
		if(item2 == ShopKeeper.nuggetSilver || item2 == ShopKeeper.ingotSilver){ countSilver++; }
		if(item3 == ShopKeeper.nuggetSilver || item3 == ShopKeeper.ingotSilver){ countSilver++; }
		if(item4 == ShopKeeper.nuggetSilver || item4 == ShopKeeper.ingotSilver){ countSilver++; }
		if(item5 == ShopKeeper.nuggetSilver || item5 == ShopKeeper.ingotSilver){ countSilver++; }
		if(item6 == ShopKeeper.nuggetSilver || item6 == ShopKeeper.ingotSilver){ countSilver++; }
		if(item7 == ShopKeeper.nuggetSilver || item7 == ShopKeeper.ingotSilver){ countSilver++; }
		if(item8 == ShopKeeper.nuggetSilver || item8 == ShopKeeper.ingotSilver){ countSilver++; }
		if(item9 == ShopKeeper.nuggetSilver || item9 == ShopKeeper.ingotSilver){ countSilver++; }
		
		if(item0 == ShopKeeper.nuggetMythril || item0 == ShopKeeper.ingotMythril){ countMythril++; }
		if(item1 == ShopKeeper.nuggetMythril || item1 == ShopKeeper.ingotMythril){ countMythril++; }
		if(item2 == ShopKeeper.nuggetMythril || item2 == ShopKeeper.ingotMythril){ countMythril++; }
		if(item3 == ShopKeeper.nuggetMythril || item3 == ShopKeeper.ingotMythril){ countMythril++; }
		if(item4 == ShopKeeper.nuggetMythril || item4 == ShopKeeper.ingotMythril){ countMythril++; }
		if(item5 == ShopKeeper.nuggetMythril || item5 == ShopKeeper.ingotMythril){ countMythril++; }
		if(item6 == ShopKeeper.nuggetMythril || item6 == ShopKeeper.ingotMythril){ countMythril++; }
		if(item7 == ShopKeeper.nuggetMythril || item7 == ShopKeeper.ingotMythril){ countMythril++; }
		if(item8 == ShopKeeper.nuggetMythril || item8 == ShopKeeper.ingotMythril){ countMythril++; }
		if(item9 == ShopKeeper.nuggetMythril || item9 == ShopKeeper.ingotMythril){ countMythril++; }
		
		if(item0 == ShopKeeper.nuggetIridium || item0 == ShopKeeper.ingotIridium){ countIridium++; }
		if(item1 == ShopKeeper.nuggetIridium || item1 == ShopKeeper.ingotIridium){ countIridium++; }
		if(item2 == ShopKeeper.nuggetIridium || item2 == ShopKeeper.ingotIridium){ countIridium++; }
		if(item3 == ShopKeeper.nuggetIridium || item3 == ShopKeeper.ingotIridium){ countIridium++; }
		if(item4 == ShopKeeper.nuggetIridium || item4 == ShopKeeper.ingotIridium){ countIridium++; }
		if(item5 == ShopKeeper.nuggetIridium || item5 == ShopKeeper.ingotIridium){ countIridium++; }
		if(item6 == ShopKeeper.nuggetIridium || item6 == ShopKeeper.ingotIridium){ countIridium++; }
		if(item7 == ShopKeeper.nuggetIridium || item7 == ShopKeeper.ingotIridium){ countIridium++; }
		if(item8 == ShopKeeper.nuggetIridium || item8 == ShopKeeper.ingotIridium){ countIridium++; }
		if(item9 == ShopKeeper.nuggetIridium || item9 == ShopKeeper.ingotIridium){ countIridium++; }
		
		if(item0 == ShopKeeper.nuggetAdamantium || item0 == ShopKeeper.ingotAdamantium){ countAdamantium++; }
		if(item1 == ShopKeeper.nuggetAdamantium || item1 == ShopKeeper.ingotAdamantium){ countAdamantium++; }
		if(item2 == ShopKeeper.nuggetAdamantium || item2 == ShopKeeper.ingotAdamantium){ countAdamantium++; }
		if(item3 == ShopKeeper.nuggetAdamantium || item3 == ShopKeeper.ingotAdamantium){ countAdamantium++; }
		if(item4 == ShopKeeper.nuggetAdamantium || item4 == ShopKeeper.ingotAdamantium){ countAdamantium++; }
		if(item5 == ShopKeeper.nuggetAdamantium || item5 == ShopKeeper.ingotAdamantium){ countAdamantium++; }
		if(item6 == ShopKeeper.nuggetAdamantium || item6 == ShopKeeper.ingotAdamantium){ countAdamantium++; }
		if(item7 == ShopKeeper.nuggetAdamantium || item7 == ShopKeeper.ingotAdamantium){ countAdamantium++; }
		if(item8 == ShopKeeper.nuggetAdamantium || item8 == ShopKeeper.ingotAdamantium){ countAdamantium++; }
		if(item9 == ShopKeeper.nuggetAdamantium || item9 == ShopKeeper.ingotAdamantium){ countAdamantium++; }
		
		if(item0 == ShopKeeper.nuggetOrichalcum || item0 == ShopKeeper.powderOrichalcum || item0 == ShopKeeper.ingotOrichalcum){ countOrichalcum++; }
		if(item1 == ShopKeeper.nuggetOrichalcum || item1 == ShopKeeper.powderOrichalcum || item1 == ShopKeeper.ingotOrichalcum){ countOrichalcum++; }
		if(item2 == ShopKeeper.nuggetOrichalcum || item2 == ShopKeeper.powderOrichalcum || item2 == ShopKeeper.ingotOrichalcum){ countOrichalcum++; }
		if(item3 == ShopKeeper.nuggetOrichalcum || item3 == ShopKeeper.powderOrichalcum || item3 == ShopKeeper.ingotOrichalcum){ countOrichalcum++; }
		if(item4 == ShopKeeper.nuggetOrichalcum || item4 == ShopKeeper.powderOrichalcum || item4 == ShopKeeper.ingotOrichalcum){ countOrichalcum++; }
		if(item5 == ShopKeeper.nuggetOrichalcum || item5 == ShopKeeper.powderOrichalcum || item5 == ShopKeeper.ingotOrichalcum){ countOrichalcum++; }
		if(item6 == ShopKeeper.nuggetOrichalcum || item6 == ShopKeeper.powderOrichalcum || item6 == ShopKeeper.ingotOrichalcum){ countOrichalcum++; }
		if(item7 == ShopKeeper.nuggetOrichalcum || item7 == ShopKeeper.powderOrichalcum || item7 == ShopKeeper.ingotOrichalcum){ countOrichalcum++; }
		if(item8 == ShopKeeper.nuggetOrichalcum || item8 == ShopKeeper.powderOrichalcum || item8 == ShopKeeper.ingotOrichalcum){ countOrichalcum++; }
		if(item9 == ShopKeeper.nuggetOrichalcum || item9 == ShopKeeper.powderOrichalcum || item9 == ShopKeeper.ingotOrichalcum){ countOrichalcum++; }
		
		if(item0 == ShopKeeper.nuggetUnobtanium || item0 == ShopKeeper.ingotUnobtanium){ countUnobtanium++; }
		if(item1 == ShopKeeper.nuggetUnobtanium || item1 == ShopKeeper.ingotUnobtanium){ countUnobtanium++; }
		if(item2 == ShopKeeper.nuggetUnobtanium || item2 == ShopKeeper.ingotUnobtanium){ countUnobtanium++; }
		if(item3 == ShopKeeper.nuggetUnobtanium || item3 == ShopKeeper.ingotUnobtanium){ countUnobtanium++; }
		if(item4 == ShopKeeper.nuggetUnobtanium || item4 == ShopKeeper.ingotUnobtanium){ countUnobtanium++; }
		if(item5 == ShopKeeper.nuggetUnobtanium || item5 == ShopKeeper.ingotUnobtanium){ countUnobtanium++; }
		if(item6 == ShopKeeper.nuggetUnobtanium || item6 == ShopKeeper.ingotUnobtanium){ countUnobtanium++; }
		if(item7 == ShopKeeper.nuggetUnobtanium || item7 == ShopKeeper.ingotUnobtanium){ countUnobtanium++; }
		if(item8 == ShopKeeper.nuggetUnobtanium || item8 == ShopKeeper.ingotUnobtanium){ countUnobtanium++; }
		if(item9 == ShopKeeper.nuggetUnobtanium || item9 == ShopKeeper.ingotUnobtanium){ countUnobtanium++; }
		
		if(item0 == Items.coal){ countCoal++; }
		if(item1 == Items.coal){ countCoal++; }
		if(item2 == Items.coal){ countCoal++; }
		if(item3 == Items.coal){ countCoal++; }
		if(item4 == Items.coal){ countCoal++; }
		if(item5 == Items.coal){ countCoal++; }
		if(item6 == Items.coal){ countCoal++; }
		if(item7 == Items.coal){ countCoal++; }
		if(item8 == Items.coal){ countCoal++; }
		if(item9 == Items.coal){ countCoal++; }
		
		if(countIron       == 10){ return new ItemStack(     Items.iron_ingot,      10); }
		if(countGold       == 10){ return new ItemStack(     Items.gold_ingot,      10); }
		if(countCopper     == 10){ return new ItemStack(ShopKeeper.ingotCopper,     10); }
		if(countAluminium  == 10){ return new ItemStack(ShopKeeper.ingotAluminium,  10); }
		if(countLead       == 10){ return new ItemStack(ShopKeeper.ingotLead,       10); }
		if(countTin        == 10){ return new ItemStack(ShopKeeper.ingotTin,        10); }
		if(countZinc       == 10){ return new ItemStack(ShopKeeper.ingotZinc,       10); }
		if(countSilver     == 10){ return new ItemStack(ShopKeeper.ingotSilver,     10); }
		if(countMythril    == 10){ return new ItemStack(ShopKeeper.ingotMythril,    10); }
		if(countIridium    == 10){ return new ItemStack(ShopKeeper.ingotIridium,    10); }
		if(countAdamantium == 10){ return new ItemStack(ShopKeeper.ingotAdamantium, 10); }
		if(countOrichalcum == 10){ return new ItemStack(ShopKeeper.ingotOrichalcum, 10); }
		if(countUnobtanium == 10){ return new ItemStack(ShopKeeper.ingotUnobtanium, 10); }
		
		if(countCopper == 9 && countTin  == 1){ return new ItemStack(ShopKeeper.ingotBronze, 10); }
		if(countIron   == 8 && countCoal == 2){ return new ItemStack(ShopKeeper.ingotSteel,  10); }
		if(countCopper == 8 && countZinc == 2){ return new ItemStack(ShopKeeper.ingotBrass,  10); }
		
		return null;
	}

}