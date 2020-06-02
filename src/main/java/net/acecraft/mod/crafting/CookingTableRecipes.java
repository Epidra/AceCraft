package net.acecraft.mod.crafting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;

public class CookingTableRecipes extends AceCraftingManager {
	
	/** The static instance of this class */
    private static final CookingTableRecipes INSTANCE = new CookingTableRecipes();
    private final List<IRecipe> recipes = Lists.<IRecipe>newArrayList();

    /** Returns the static instance of this class */
    public static CookingTableRecipes getInstance(){
        /** The static instance of this class */
        return INSTANCE;
    }
    
    public CookingTableRecipes(){
    	// Other
        this.addShapelessRecipe(new ItemStack(Items.BREAD), new Object[]{ShopKeeper.powderFlour, ShopKeeper.powderFlour, ShopKeeper.powderFlour});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.juiceCoffee), new Object[]{ShopKeeper.powderCoffee, Items.POTIONITEM});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.foodRiceball), new Object[]{ShopKeeper.foodRice, ShopKeeper.foodRice});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishSeaSaltIceCream), new Object[]{Items.STICK, Items.SUGAR, ShopKeeper.powderSalt, ShopKeeper.juiceMilk});
        
        // No Utensils
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishSalad           ), new Object[]{ShopKeeper.foodCucumber, ShopKeeper.foodCabbage, ShopKeeper.foodTomato, Items.CARROT});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishSandwich        ), new Object[]{ShopKeeper.foodTomato, ShopKeeper.foodCucumber, ShopKeeper.dishBoiledEgg, Items.BREAD});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishFruitSandwich   ), new Object[]{ShopKeeper.foodOrange, ShopKeeper.foodBanana, Items.APPLE, Items.BREAD});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishPickledTurnips  ), new Object[]{ShopKeeper.foodTurnip});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishPickledCucumber ), new Object[]{ShopKeeper.foodCucumber});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishBambooRice      ), new Object[]{ShopKeeper.foodBambooShoot, ShopKeeper.foodRiceball});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishMushroomRice    ), new Object[]{Blocks.BROWN_MUSHROOM, ShopKeeper.foodRiceball});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishSushi           ), new Object[]{Items.FISH, ShopKeeper.foodRiceball});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishRaisinBread     ), new Object[]{ShopKeeper.foodGrapes, Items.BREAD});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishChirashiSushi   ), new Object[]{Items.FISH, ShopKeeper.dishScrambledEggs, ShopKeeper.foodRiceball, ShopKeeper.foodCucumber});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishIceCream        ), new Object[]{ShopKeeper.juiceMilk, Items.EGG});
        
        // Frying Pan
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishStirFry         ), new Object[]{ShopKeeper.juiceOil, ShopKeeper.foodCabbage});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishFriedRice       ), new Object[]{ShopKeeper.foodRiceball, ShopKeeper.juiceOil, Items.EGG});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishSavoryPancake   ), new Object[]{ShopKeeper.foodCabbage, ShopKeeper.powderFlour, Items.EGG, ShopKeeper.juiceOil});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishFrenchFries     ), new Object[]{Items.POTATO, ShopKeeper.juiceOil});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishCroquette       ), new Object[]{Items.POTATO, ShopKeeper.foodOnion, Items.EGG, ShopKeeper.powderFlour, ShopKeeper.juiceOil});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishPopcorn         ), new Object[]{ShopKeeper.foodCorn});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishCornflakes      ), new Object[]{ShopKeeper.foodCorn, ShopKeeper.juiceMilk});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishHappyEggplant   ), new Object[]{ShopKeeper.foodEggplant});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishScrambledEggs   ), new Object[]{Items.EGG, ShopKeeper.juiceOil});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishOmelet          ), new Object[]{Items.EGG, ShopKeeper.juiceMilk, ShopKeeper.juiceOil});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishOmeletRice      ), new Object[]{Items.EGG, ShopKeeper.juiceMilk, ShopKeeper.juiceOil, ShopKeeper.foodRiceball});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishAppleSouffle    ), new Object[]{Items.APPLE});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishCurryBread      ), new Object[]{Items.BREAD, ShopKeeper.powderCurry, ShopKeeper.juiceOil});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishFrenchToast     ), new Object[]{Items.EGG, Items.BREAD, ShopKeeper.juiceOil});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishDoughnut        ), new Object[]{Items.EGG, ShopKeeper.juiceMilk, ShopKeeper.foodButter, ShopKeeper.powderFlour, ShopKeeper.juiceOil});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishFriedNoodles    ), new Object[]{ShopKeeper.dishNoodles, ShopKeeper.juiceOil});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishTempura         ), new Object[]{Items.EGG, ShopKeeper.powderFlour, ShopKeeper.juiceOil});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishPancake         ), new Object[]{Items.EGG, ShopKeeper.juiceMilk, ShopKeeper.powderFlour, ShopKeeper.juiceOil});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishPotSticker      ), new Object[]{ShopKeeper.foodCabbage, ShopKeeper.foodOnion, ShopKeeper.powderFlour, ShopKeeper.juiceOil});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishRisotto         ), new Object[]{ShopKeeper.foodTomato, ShopKeeper.foodOnion, ShopKeeper.foodRiceball, ShopKeeper.juiceOil});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishDryCurry        ), new Object[]{ShopKeeper.foodRiceball, ShopKeeper.powderCurry});
        
        // Cooking Pot
        this.addShapelessRecipe(new ItemStack(ShopKeeper.juiceHotMilk        ), new Object[]{ShopKeeper.juiceMilk});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.juiceHotChocolate   ), new Object[]{ShopKeeper.juiceMilk, Items.DYE});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishPumpkinStew     ), new Object[]{Blocks.PUMPKIN});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishFishStew        ), new Object[]{Items.FISH});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishMountainStew    ), new Object[]{Items.CARROT, ShopKeeper.foodBambooShoot, Blocks.BROWN_MUSHROOM});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishBoiledSpinach   ), new Object[]{ShopKeeper.foodSpinach});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishBoiledEgg       ), new Object[]{Items.EGG});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishCandiedPotato   ), new Object[]{ShopKeeper.foodSweetPotato});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishDumplings       ), new Object[]{ShopKeeper.foodCabbage, ShopKeeper.foodOnion, ShopKeeper.powderFlour, ShopKeeper.juiceOil});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishStrawberryJam   ), new Object[]{ShopKeeper.foodStrawberry});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishAppleJam        ), new Object[]{Items.APPLE});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishPeachJam        ), new Object[]{ShopKeeper.foodPeach});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishGrapeJam        ), new Object[]{ShopKeeper.foodGrapes});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishMarmelade       ), new Object[]{ShopKeeper.foodOrange});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishCheeseFondue    ), new Object[]{ShopKeeper.foodCheese, Items.BREAD});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishNoodles         ), new Object[]{ShopKeeper.powderFlour});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishCurryNoodles    ), new Object[]{ShopKeeper.dishNoodles, ShopKeeper.powderCurry});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishTempuraNoodles  ), new Object[]{ShopKeeper.dishTempura, ShopKeeper.dishNoodles});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishRiceSoup        ), new Object[]{ShopKeeper.foodRiceball});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishPorridge        ), new Object[]{ShopKeeper.juiceMilk, ShopKeeper.foodRiceball});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishTempuraRice     ), new Object[]{ShopKeeper.foodRiceball, ShopKeeper.dishTempura});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishEggOverRice     ), new Object[]{Items.EGG, ShopKeeper.foodRiceball});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishStew            ), new Object[]{ShopKeeper.juiceMilk, ShopKeeper.powderFlour});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishCurryRice       ), new Object[]{ShopKeeper.foodRiceball, ShopKeeper.powderCurry});
        
        // Oven
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishBakedCorn       ), new Object[]{ShopKeeper.foodCorn});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishToastedRiceball ), new Object[]{ShopKeeper.foodRiceball});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishBakedYam        ), new Object[]{ShopKeeper.foodSweetPotato});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishToast           ), new Object[]{Items.BREAD});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishJambun          ), new Object[]{ShopKeeper.juiceMilk, Items.EGG, ShopKeeper.dishAppleJam});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishDinnerRoll      ), new Object[]{Items.EGG, ShopKeeper.juiceMilk, ShopKeeper.foodButter});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishPizza           ), new Object[]{ShopKeeper.foodCheese, ShopKeeper.powderFlour, ShopKeeper.foodTomato});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishDoria           ), new Object[]{ShopKeeper.foodOnion, ShopKeeper.foodButter, ShopKeeper.juiceMilk, ShopKeeper.foodRiceball, ShopKeeper.powderFlour});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishGratin          ), new Object[]{ShopKeeper.foodOnion, ShopKeeper.foodButter, ShopKeeper.juiceMilk, ShopKeeper.foodCheese, ShopKeeper.powderFlour});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishSweetPotatoes   ), new Object[]{Items.EGG, ShopKeeper.foodButter, ShopKeeper.foodSweetPotato});
        this.addShapelessRecipe(new ItemStack(Items.COOKIE                   ), new Object[]{Items.EGG, ShopKeeper.powderFlour, ShopKeeper.foodButter});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishChocolateCookies), new Object[]{Items.EGG, ShopKeeper.powderFlour, ShopKeeper.foodButter, Items.DYE});
        this.addShapelessRecipe(new ItemStack(Items.CAKE                     ), new Object[]{Items.EGG, ShopKeeper.powderFlour, ShopKeeper.foodButter, ShopKeeper.foodStrawberry});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishChocolateCake   ), new Object[]{Items.EGG, ShopKeeper.powderFlour, ShopKeeper.foodButter, ShopKeeper.foodStrawberry, Items.DYE});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishCheesecake      ), new Object[]{Items.EGG, ShopKeeper.foodCheese, ShopKeeper.juiceMilk});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishApplePie        ), new Object[]{Items.APPLE, Items.EGG, ShopKeeper.foodButter, ShopKeeper.powderFlour});
        
        // Steamer
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishSteamedBun      ), new Object[]{ShopKeeper.powderFlour, ShopKeeper.juiceOil});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishCheeseSteamedBun), new Object[]{ShopKeeper.foodCheese, ShopKeeper.powderFlour, ShopKeeper.juiceOil});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishShaomi          ), new Object[]{ShopKeeper.foodOnion, ShopKeeper.foodCabbage, Items.EGG, ShopKeeper.powderFlour});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishSteamedEgg      ), new Object[]{Items.EGG, Blocks.BROWN_MUSHROOM, ShopKeeper.foodBambooShoot});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishChineseBun      ), new Object[]{Blocks.BROWN_MUSHROOM, ShopKeeper.powderFlour, ShopKeeper.foodBambooShoot, Items.CARROT});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishCurryBun        ), new Object[]{ShopKeeper.powderFlour, ShopKeeper.powderCurry});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishSteamedDumplings), new Object[]{ShopKeeper.foodCabbage, ShopKeeper.foodOnion, ShopKeeper.powderFlour, ShopKeeper.juiceOil});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishSpongeCake      ), new Object[]{Items.EGG, ShopKeeper.powderFlour});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishSteamedCake     ), new Object[]{Items.EGG, ShopKeeper.juiceMilk, ShopKeeper.juiceOil});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishPudding         ), new Object[]{Items.EGG, ShopKeeper.juiceMilk});
        this.addShapelessRecipe(new ItemStack(ShopKeeper.dishPumpkinPudding  ), new Object[]{Items.EGG, ShopKeeper.juiceMilk, Blocks.PUMPKIN});
    }
}