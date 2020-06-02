package net.acecraft.mod.crafting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import net.acecraft.mod.ShopKeeper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class StoveCraftingManager {
	
    private static final StoveCraftingManager instance = new StoveCraftingManager();
    private List recipes = new ArrayList();
    private static final String __OBFID = "CL_00000090";
    
    public static final StoveCraftingManager getInstance(){
        return instance;
    }
    
    private Item getItemFruitSalad(int a){
    	if(a == 0) return Items.apple;
    	if(a == 1) return ShopKeeper.foodOrange;
    	if(a == 2) return ShopKeeper.foodCherry;
    	if(a == 3) return ShopKeeper.foodPeach;
    	if(a == 4) return ShopKeeper.foodBanana;
    	return Items.apple;
    }
    
    private StoveCraftingManager(){
    	recipes = new ArrayList();
    	this.addShapelessRecipe(new ItemStack(Items.bread,  1), new ItemStack(ShopKeeper.powderFlour, 1), new ItemStack(ShopKeeper.powderFlour, 1), new ItemStack(ShopKeeper.powderFlour, 1));
    	this.addShapelessRecipe(new ItemStack(Blocks.cake,  1), new ItemStack(Items.sugar, 1), new ItemStack(ShopKeeper.juiceMilk, 1), new ItemStack(Items.egg, 1, 0), new ItemStack(ShopKeeper.powderFlour, 1, 0));
    	this.addShapelessRecipe(new ItemStack(Items.cookie,  4), new ItemStack(ShopKeeper.powderFlour, 1), new ItemStack(Items.dye, 1, 3), new ItemStack(Items.egg, 1));
    	this.addShapelessRecipe(new ItemStack(Items.melon,  4), new ItemStack(Blocks.melon_block, 1));
    	this.addShapelessRecipe(new ItemStack(Items.mushroom_stew,  4), new ItemStack(Items.bowl, 1), new ItemStack(Blocks.brown_mushroom, 1), new ItemStack(Blocks.red_mushroom, 1));
    	this.addShapelessRecipe(new ItemStack(Items.pumpkin_pie,  1), new ItemStack(Blocks.pumpkin, 1), new ItemStack(Items.sugar, 1), new ItemStack(Items.egg, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodCheese,  4), new ItemStack(ShopKeeper.foodCheeseWheel, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodSeaSaltIceCream,  1), new ItemStack(Items.stick), new ItemStack(Items.sugar), new ItemStack(ShopKeeper.powderSalt), new ItemStack(ShopKeeper.juiceMilk), new ItemStack(Items.egg, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodKrabbyPatty,  1), new ItemStack(Items.bread), new ItemStack(ShopKeeper.foodCrabMeatCooked), new ItemStack(ShopKeeper.foodTomato), new ItemStack(ShopKeeper.foodCheese), new ItemStack(ShopKeeper.foodPickles), new ItemStack(ShopKeeper.powderOrichalcum));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.juiceCoffee,  1), new ItemStack(Items.potionitem, 1, 0), new ItemStack(ShopKeeper.powderCoffee));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.juiceChocolateMilk,  1), new ItemStack(ShopKeeper.juiceMilk), new ItemStack(Items.dye, 1, 3));
    	
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodRiceball,  1), new ItemStack(ShopKeeper.foodRice, 1), new ItemStack(ShopKeeper.foodRice, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodRiceBowl, 1), new ItemStack(Items.bowl, 1), new ItemStack(ShopKeeper.foodRice, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodSalad, 1), new ItemStack(Items.bowl, 1), new ItemStack(ShopKeeper.foodCabbage, 1));
    	for(int i = 0; i < 5; i++){
    		for(int j = 0; j < 5; j++){
    			Item item1 = getItemFruitSalad(i);
    			Item item2 = getItemFruitSalad(j);
    			this.addShapelessRecipe(new ItemStack(ShopKeeper.foodFruitSalad,  1), new ItemStack(item1, 1), new ItemStack(item2, 1));
    		}
    	}
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodBurger, 1), new ItemStack(Items.bread, 1), new ItemStack(Items.cooked_beef, 1), new ItemStack(ShopKeeper.foodCabbage, 1), new ItemStack(ShopKeeper.foodTomato, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodBurger, 1), new ItemStack(Items.bread, 1), new ItemStack(Items.cooked_porkchop, 1), new ItemStack(ShopKeeper.foodCabbage, 1), new ItemStack(ShopKeeper.foodTomato, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodBurger, 1), new ItemStack(Items.bread, 1), new ItemStack(ShopKeeper.foodVenisonCooked, 1), new ItemStack(ShopKeeper.foodCabbage, 1), new ItemStack(ShopKeeper.foodTomato, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodCheeseBurger, 1), new ItemStack(Items.bread, 1), new ItemStack(Items.cooked_beef, 1), new ItemStack(ShopKeeper.foodCheese, 1), new ItemStack(ShopKeeper.foodCabbage, 1), new ItemStack(ShopKeeper.foodTomato, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodCheeseBurger, 1), new ItemStack(Items.bread, 1), new ItemStack(Items.cooked_porkchop, 1), new ItemStack(ShopKeeper.foodCheese, 1), new ItemStack(ShopKeeper.foodCabbage, 1), new ItemStack(ShopKeeper.foodTomato, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodCheeseBurger, 1), new ItemStack(Items.bread, 1), new ItemStack(ShopKeeper.foodVenisonCooked, 1), new ItemStack(ShopKeeper.foodCheese, 1), new ItemStack(ShopKeeper.foodCabbage, 1), new ItemStack(ShopKeeper.foodTomato, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodKebab, 1), new ItemStack(Items.bread, 1), new ItemStack(ShopKeeper.foodMuttonCooked, 1), new ItemStack(ShopKeeper.foodCabbage, 1), new ItemStack(ShopKeeper.foodOnion, 1), new ItemStack(ShopKeeper.foodTomato, 1));
    	if(ShopKeeper.loadedBiomesOPlenty)
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodDungeonFilet, 1), new ItemStack(Items.rotten_flesh, 1), new ItemStack(ShopKeeper.powderSalt, 1), new ItemStack(ShopKeeper.powderSulfur, 1), new ItemStack(ShopKeeper.powderFlour, 1), new ItemStack(biomesoplenty.api.content.BOPCBlocks.flowers2, 1, 6), new ItemStack(Blocks.brown_mushroom, 1));
    	if(ShopKeeper.loadedBiomesOPlenty)
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodDungeonFilet, 1), new ItemStack(Items.rotten_flesh, 1), new ItemStack(ShopKeeper.powderSalt, 1), new ItemStack(ShopKeeper.powderSulfur, 1), new ItemStack(ShopKeeper.powderFlour, 1), new ItemStack(biomesoplenty.api.content.BOPCBlocks.flowers2, 1, 6), new ItemStack(Blocks.red_mushroom, 1));
    	if(ShopKeeper.loadedBiomesOPlenty)
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodDungeonFilet, 1), new ItemStack(Items.rotten_flesh, 1), new ItemStack(ShopKeeper.powderSalt, 1), new ItemStack(ShopKeeper.powderSulfur, 1), new ItemStack(ShopKeeper.powderFlour, 1), new ItemStack(biomesoplenty.api.content.BOPCBlocks.flowers2, 1, 6), new ItemStack(biomesoplenty.api.content.BOPCBlocks.mushrooms, 1, OreDictionary.WILDCARD_VALUE));
    	
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodStirFry, 1), new ItemStack(ShopKeeper.toolFryingPan, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(ShopKeeper.foodCabbage, 1), new ItemStack(ShopKeeper.juiceOil, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodFriedRice, 1), new ItemStack(ShopKeeper.toolFryingPan, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(ShopKeeper.foodRice, 1), new ItemStack(Items.egg, 1), new ItemStack(ShopKeeper.juiceOil, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodSavoryPancake, 1), new ItemStack(ShopKeeper.toolFryingPan, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(ShopKeeper.foodCabbage, 1), new ItemStack(ShopKeeper.powderFlour, 1), new ItemStack(Items.egg, 1), new ItemStack(ShopKeeper.juiceOil, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodFrenchFries, 1), new ItemStack(ShopKeeper.toolFryingPan, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.potato, 1), new ItemStack(ShopKeeper.juiceOil, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodCroquette, 1), new ItemStack(ShopKeeper.toolFryingPan, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.potato, 1), new ItemStack(ShopKeeper.foodOnion, 1), new ItemStack(Items.egg, 1), new ItemStack(ShopKeeper.powderFlour, 1), new ItemStack(ShopKeeper.juiceOil, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodPopcorn, 1), new ItemStack(ShopKeeper.toolFryingPan, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(ShopKeeper.foodMaise, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodScrambledEggs, 1), new ItemStack(ShopKeeper.toolFryingPan, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.egg, 1), new ItemStack(ShopKeeper.juiceOil, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodOmelet, 1), new ItemStack(ShopKeeper.toolFryingPan, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.egg, 1), new ItemStack(ShopKeeper.juiceMilk, 1), new ItemStack(ShopKeeper.juiceOil, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodOmeletRice, 1), new ItemStack(ShopKeeper.toolFryingPan, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.egg, 1), new ItemStack(ShopKeeper.juiceMilk, 1), new ItemStack(ShopKeeper.juiceOil, 1), new ItemStack(ShopKeeper.foodRice, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodAppleSouffle, 1), new ItemStack(ShopKeeper.toolFryingPan, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.apple, 1));
    	if(ShopKeeper.loadedMillenaire)
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodCurryBread, 1), new ItemStack(ShopKeeper.toolFryingPan, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.bread, 1), new ItemStack(org.millenaire.common.forge.Mill.turmeric, 1), new ItemStack(ShopKeeper.juiceOil, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodFrenchToast, 1), new ItemStack(ShopKeeper.toolFryingPan, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.egg, 1), new ItemStack(Items.bread, 1), new ItemStack(ShopKeeper.juiceOil, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodDoughnut, 1), new ItemStack(ShopKeeper.toolFryingPan, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.egg, 1), new ItemStack(ShopKeeper.juiceMilk, 1), new ItemStack(ShopKeeper.powderFlour, 1), new ItemStack(ShopKeeper.juiceOil, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodFriedNoodles, 1), new ItemStack(ShopKeeper.toolFryingPan, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(ShopKeeper.foodNoodles, 1), new ItemStack(ShopKeeper.juiceOil, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodTempura, 1), new ItemStack(ShopKeeper.toolFryingPan, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.egg, 1), new ItemStack(ShopKeeper.powderFlour, 1), new ItemStack(ShopKeeper.juiceOil, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodPancake, 1), new ItemStack(ShopKeeper.toolFryingPan, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(Items.egg, 1), new ItemStack(ShopKeeper.juiceMilk, 1), new ItemStack(ShopKeeper.powderFlour, 1), new ItemStack(ShopKeeper.juiceOil, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodPotSticker, 1), new ItemStack(ShopKeeper.toolFryingPan, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(ShopKeeper.foodCabbage, 1), new ItemStack(ShopKeeper.foodOnion, 1), new ItemStack(ShopKeeper.powderFlour, 1), new ItemStack(ShopKeeper.juiceOil, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodRisotto, 1), new ItemStack(ShopKeeper.toolFryingPan, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(ShopKeeper.foodTomato, 1), new ItemStack(ShopKeeper.foodOnion, 1), new ItemStack(ShopKeeper.foodRice, 1), new ItemStack(ShopKeeper.juiceOil, 1));
    	if(ShopKeeper.loadedMillenaire)
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodDryCurry, 1), new ItemStack(ShopKeeper.toolFryingPan, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(ShopKeeper.foodRice, 1), new ItemStack(org.millenaire.common.forge.Mill.turmeric, 1));
    	
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodPumpkinStew, 1), new ItemStack(Items.bowl, 1), new ItemStack(Blocks.pumpkin, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodFishStew, 1), new ItemStack(Items.bowl, 1), new ItemStack(Items.fish, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodBoiledEgg, 1), new ItemStack(Items.egg, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodDumplings, 1), new ItemStack(ShopKeeper.foodCabbage, 1), new ItemStack(ShopKeeper.foodOnion, 1), new ItemStack(ShopKeeper.powderFlour, 1), new ItemStack(ShopKeeper.juiceOil, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodCheeseFondue, 1), new ItemStack(Items.bowl, 1), new ItemStack(ShopKeeper.foodCheese, 1), new ItemStack(Items.bread, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodNoodles, 1), new ItemStack(ShopKeeper.powderFlour, 1));
    	if(ShopKeeper.loadedMillenaire)
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodCurryNoodles, 1), new ItemStack(ShopKeeper.foodNoodles, 1), new ItemStack(org.millenaire.common.forge.Mill.turmeric, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodTempuraNoodles, 1), new ItemStack(ShopKeeper.foodNoodles, 1), new ItemStack(ShopKeeper.foodTempura, 1));
    	if(ShopKeeper.loadedBiomesOPlenty)
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodMountainStew, 1), new ItemStack(Items.bowl, 1), new ItemStack(Items.carrot, 1), new ItemStack(biomesoplenty.api.content.BOPCBlocks.bamboo, 1), new ItemStack(Blocks.brown_mushroom, 1));
    	if(ShopKeeper.loadedBiomesOPlenty)
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodMountainStew, 1), new ItemStack(Items.bowl, 1), new ItemStack(Items.carrot, 1), new ItemStack(biomesoplenty.api.content.BOPCBlocks.bamboo, 1), new ItemStack(Blocks.red_mushroom, 1));
    	if(ShopKeeper.loadedBiomesOPlenty)
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodMountainStew, 1), new ItemStack(Items.bowl, 1), new ItemStack(Items.carrot, 1), new ItemStack(biomesoplenty.api.content.BOPCBlocks.bamboo, 1), new ItemStack(biomesoplenty.api.content.BOPCBlocks.mushrooms, 1, OreDictionary.WILDCARD_VALUE));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodRiceSoup, 1), new ItemStack(Items.bowl, 1), new ItemStack(ShopKeeper.foodRice, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodPorridge, 1), new ItemStack(ShopKeeper.juiceMilk, 1), new ItemStack(ShopKeeper.foodRice, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodTempuraRice, 1), new ItemStack(ShopKeeper.foodTempura, 1), new ItemStack(ShopKeeper.foodRice, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodEggOverRice, 1), new ItemStack(Items.egg, 1), new ItemStack(ShopKeeper.foodRice, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodStew, 1), new ItemStack(ShopKeeper.juiceMilk, 1), new ItemStack(ShopKeeper.powderFlour, 1));
    	if(ShopKeeper.loadedMillenaire)
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodCurryRice, 1), new ItemStack(ShopKeeper.foodRice, 1), new ItemStack(org.millenaire.common.forge.Mill.turmeric, 1));
    	
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodBakedCorn, 1), new ItemStack(ShopKeeper.foodMaise, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodToastedRiceBall, 1), new ItemStack(ShopKeeper.foodRiceball, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodToast, 1), new ItemStack(Items.bread, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodDinnerRoll, 1), new ItemStack(Items.egg, 1), new ItemStack(ShopKeeper.juiceMilk, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodPizza, 1), new ItemStack(ShopKeeper.powderFlour, 1), new ItemStack(ShopKeeper.foodCheese, 1), new ItemStack(ShopKeeper.foodTomato, 1), new ItemStack(Items.cooked_beef, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodPizza, 1), new ItemStack(ShopKeeper.powderFlour, 1), new ItemStack(ShopKeeper.foodCheese, 1), new ItemStack(ShopKeeper.foodTomato, 1), new ItemStack(Items.cooked_porkchop, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodPizza, 1), new ItemStack(ShopKeeper.powderFlour, 1), new ItemStack(ShopKeeper.foodCheese, 1), new ItemStack(ShopKeeper.foodTomato, 1), new ItemStack(ShopKeeper.foodVenisonCooked, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodDoria, 1), new ItemStack(ShopKeeper.foodOnion, 1), new ItemStack(ShopKeeper.juiceMilk, 1), new ItemStack(ShopKeeper.foodRice, 1), new ItemStack(ShopKeeper.powderFlour, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodGratin, 1), new ItemStack(ShopKeeper.foodOnion, 1), new ItemStack(ShopKeeper.juiceMilk, 1), new ItemStack(ShopKeeper.foodCheese, 1), new ItemStack(ShopKeeper.powderFlour, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodChocolateCake, 1), new ItemStack(Items.sugar, 1), new ItemStack(ShopKeeper.juiceMilk, 1), new ItemStack(Items.egg, 1), new ItemStack(ShopKeeper.powderFlour, 1), new ItemStack(Items.dye, 1, 3));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodCheesecake, 1), new ItemStack(Items.egg, 1), new ItemStack(ShopKeeper.foodCheese, 1), new ItemStack(ShopKeeper.juiceMilk, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodApplePie, 1), new ItemStack(Items.apple, 1), new ItemStack(Items.egg, 1), new ItemStack(ShopKeeper.powderFlour, 1));
    	
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodSteamedBun, 1), new ItemStack(ShopKeeper.powderFlour, 1), new ItemStack(ShopKeeper.juiceOil, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodCheeseSteamedBun, 1), new ItemStack(ShopKeeper.foodCheese, 1), new ItemStack(ShopKeeper.powderFlour, 1), new ItemStack(ShopKeeper.juiceOil, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodShaomai, 1), new ItemStack(ShopKeeper.foodOnion, 1), new ItemStack(ShopKeeper.foodCabbage, 1), new ItemStack(Items.egg, 1), new ItemStack(ShopKeeper.powderFlour, 1));
    	if(ShopKeeper.loadedBiomesOPlenty)
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodSteamedEgg, 1), new ItemStack(Items.egg, 1), new ItemStack(Blocks.brown_mushroom, 1), new ItemStack(biomesoplenty.api.content.BOPCBlocks.bamboo, 1));
    	if(ShopKeeper.loadedBiomesOPlenty)
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodSteamedEgg, 1), new ItemStack(Items.egg, 1), new ItemStack(Blocks.red_mushroom, 1), new ItemStack(biomesoplenty.api.content.BOPCBlocks.bamboo, 1));
    	if(ShopKeeper.loadedBiomesOPlenty)
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodSteamedEgg, 1), new ItemStack(Items.egg, 1), new ItemStack(biomesoplenty.api.content.BOPCBlocks.mushrooms, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(biomesoplenty.api.content.BOPCBlocks.bamboo, 1));
    	if(ShopKeeper.loadedBiomesOPlenty)
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodChineseBun, 1), new ItemStack(Items.egg, 1), new ItemStack(Blocks.brown_mushroom, 1), new ItemStack(biomesoplenty.api.content.BOPCBlocks.bamboo, 1), new ItemStack(Items.carrot, 1));
    	if(ShopKeeper.loadedBiomesOPlenty)
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodChineseBun, 1), new ItemStack(Items.egg, 1), new ItemStack(Blocks.red_mushroom, 1), new ItemStack(biomesoplenty.api.content.BOPCBlocks.bamboo, 1), new ItemStack(Items.carrot, 1));
    	if(ShopKeeper.loadedBiomesOPlenty)
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodChineseBun, 1), new ItemStack(Items.egg, 1), new ItemStack(biomesoplenty.api.content.BOPCBlocks.mushrooms, 1, OreDictionary.WILDCARD_VALUE), new ItemStack(biomesoplenty.api.content.BOPCBlocks.bamboo, 1), new ItemStack(Items.carrot, 1));
    	if(ShopKeeper.loadedMillenaire)
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodCurryBun, 1), new ItemStack(ShopKeeper.powderFlour, 1), new ItemStack(org.millenaire.common.forge.Mill.turmeric, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodSteamedDumplings, 1), new ItemStack(ShopKeeper.foodCabbage, 1), new ItemStack(ShopKeeper.foodOnion, 1), new ItemStack(ShopKeeper.powderFlour, 1), new ItemStack(ShopKeeper.juiceOil, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodSpongeCake, 1), new ItemStack(Items.egg, 1), new ItemStack(ShopKeeper.powderFlour, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodSteamedCake, 1), new ItemStack(Items.egg, 1), new ItemStack(ShopKeeper.juiceMilk, 1), new ItemStack(ShopKeeper.juiceOil, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodPudding, 1), new ItemStack(Items.egg, 1), new ItemStack(ShopKeeper.juiceMilk, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodPumpkinPudding, 1), new ItemStack(Items.egg, 1), new ItemStack(ShopKeeper.juiceMilk, 1), new ItemStack(Blocks.pumpkin, 1));
    	
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodSandwich, 1), new ItemStack(Items.bread, 1), new ItemStack(ShopKeeper.foodTomato, 1), new ItemStack(ShopKeeper.foodPickles, 1), new ItemStack(ShopKeeper.foodBoiledEgg, 1));
    	for(int i = 0; i < 5; i++){
    		for(int j = 0; j < 5; j++){
    			Item item1 = getItemFruitSalad(i);
    			Item item2 = getItemFruitSalad(j);
    			this.addShapelessRecipe(new ItemStack(ShopKeeper.foodFruitSandwich, 1), new ItemStack(item1, 1), new ItemStack(item2, 1));
    		}
    	}
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodPickledTurnip, 1), new ItemStack(ShopKeeper.foodTurnip, 1), new ItemStack(Items.sugar, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodPickledCucumber, 1), new ItemStack(ShopKeeper.foodPickles, 1));
    	if(ShopKeeper.loadedBiomesOPlenty)
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodBambooRice, 1), new ItemStack(ShopKeeper.foodRice, 1), new ItemStack(biomesoplenty.api.content.BOPCBlocks.bamboo, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodMushroomRice, 1), new ItemStack(ShopKeeper.foodRice, 1), new ItemStack(Blocks.brown_mushroom, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodMushroomRice, 1), new ItemStack(ShopKeeper.foodRice, 1), new ItemStack(Blocks.red_mushroom, 1));
    	if(ShopKeeper.loadedBiomesOPlenty)
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodMushroomRice, 1), new ItemStack(ShopKeeper.foodRice, 1), new ItemStack(biomesoplenty.api.content.BOPCBlocks.mushrooms, 1, OreDictionary.WILDCARD_VALUE));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodSushi, 1), new ItemStack(ShopKeeper.foodRice, 1), new ItemStack(Items.fish, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodRaisinBread, 1), new ItemStack(ShopKeeper.powderFlour, 1), new ItemStack(ShopKeeper.powderFlour, 1), new ItemStack(ShopKeeper.powderFlour, 1), new ItemStack(ShopKeeper.foodGrapes, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodChirashiSushi, 1), new ItemStack(ShopKeeper.foodRice, 1), new ItemStack(Items.fish, 1), new ItemStack(ShopKeeper.foodScrambledEggs, 1), new ItemStack(Items.carrot, 1), new ItemStack(ShopKeeper.foodPickles, 1));
    	this.addShapelessRecipe(new ItemStack(ShopKeeper.foodIceCream, 1), new ItemStack(ShopKeeper.juiceMilk, 1), new ItemStack(Items.egg, 1), new ItemStack(Items.sugar, 1));
    	
        Collections.sort(this.recipes, new StoveRecipeSorter(this));
    }
    
    public StoveShapedRecipes addRecipe(ItemStack stack, Object ... object){
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;
        if (object[i] instanceof String[]){
            String[] astring = (String[])((String[])object[i++]);
            for (int l = 0; l < astring.length; ++l){
                String s1 = astring[l];
                ++k;
                j = s1.length();
                s = s + s1;
            }
        }else{
            while (object[i] instanceof String){
                String s2 = (String)object[i++];
                ++k;
                j = s2.length();
                s = s + s2;
            }
        }
        HashMap hashmap;
        for (hashmap = new HashMap(); i < object.length; i += 2){
            Character character = (Character)object[i];
            ItemStack itemstack1 = null;
            if (object[i + 1] instanceof Item){
                itemstack1 = new ItemStack((Item)object[i + 1]);
            }else if (object[i + 1] instanceof Block){
                itemstack1 = new ItemStack((Block)object[i + 1], 1, 32767);
            }else if (object[i + 1] instanceof ItemStack){
                itemstack1 = (ItemStack)object[i + 1];
            }
            hashmap.put(character, itemstack1);
        }
        ItemStack[] aitemstack = new ItemStack[j * k];
        for (int i1 = 0; i1 < j * k; ++i1){
            char c0 = s.charAt(i1);
            if (hashmap.containsKey(Character.valueOf(c0))){
                aitemstack[i1] = ((ItemStack)hashmap.get(Character.valueOf(c0))).copy();
            }else{
                aitemstack[i1] = null;
            }
        }
        StoveShapedRecipes shapedrecipes = new StoveShapedRecipes(j, k, aitemstack, stack);
        this.recipes.add(shapedrecipes);
        return shapedrecipes;
    }
    
    public void addShapelessRecipe(ItemStack stack, Object ... object){
        ArrayList arraylist = new ArrayList();
        Object[] aobject = object;
        int i = object.length;
        for (int j = 0; j < i; ++j){
            Object object1 = aobject[j];
            if (object1 instanceof ItemStack){
                arraylist.add(((ItemStack)object1).copy());
            }else if (object1 instanceof Item){
                arraylist.add(new ItemStack((Item)object1));
            }else{
                if (!(object1 instanceof Block)){
                    throw new RuntimeException("Invalid shapeless recipy!");
                }
                arraylist.add(new ItemStack((Block)object1));
            }
        }
        this.recipes.add(new ShapelessRecipes(stack, arraylist));
    }
    
    public ItemStack findMatchingRecipe(InventoryCrafting icrafting, World world){
        int i = 0;
        ItemStack itemstack = null;
        ItemStack itemstack1 = null;
        int j;
        for (j = 0; j < icrafting.getSizeInventory(); ++j){
            ItemStack itemstack2 = icrafting.getStackInSlot(j);
            if (itemstack2 != null){
                if (i == 0){
                    itemstack = itemstack2;
                }
                if (i == 1){
                    itemstack1 = itemstack2;
                }
                ++i;
            }
        }
        if (i == 2 && itemstack.getItem() == itemstack1.getItem() && itemstack.stackSize == 1 && itemstack1.stackSize == 1 && itemstack.getItem().isRepairable()){
            Item item = itemstack.getItem();
            int j1 = item.getMaxDamage() - itemstack.getItemDamageForDisplay();
            int k = item.getMaxDamage() - itemstack1.getItemDamageForDisplay();
            int l = j1 + k + item.getMaxDamage() * 5 / 100;
            int i1 = item.getMaxDamage() - l;
            if (i1 < 0){
                i1 = 0;
            }
            return new ItemStack(itemstack.getItem(), 1, i1);
        }else{
            for (j = 0; j < this.recipes.size(); ++j){
                IRecipe irecipe = (IRecipe)this.recipes.get(j);
                if (irecipe.matches(icrafting, world)){
                    return irecipe.getCraftingResult(icrafting);
                }
            }
            return null;
        }
    }
    
    public List getRecipeList(){
        return this.recipes;
    }

}