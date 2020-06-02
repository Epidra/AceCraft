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

public class WorkbenchRecipes extends AceCraftingManager {
	
	/** The static instance of this class */
    private static final WorkbenchRecipes INSTANCE = new WorkbenchRecipes();
    private final List<IRecipe> recipes = Lists.<IRecipe>newArrayList();

    /** Returns the static instance of this class */
    public static WorkbenchRecipes getInstance(){
        /** The static instance of this class */
        return INSTANCE;
    }
    
    public WorkbenchRecipes(){
    	this.addShapelessRecipe(new ItemStack(Items.BOOK, 1), new Object[] {Items.PAPER, Items.PAPER, Items.PAPER, Items.LEATHER});
        this.addShapelessRecipe(new ItemStack(Items.WRITABLE_BOOK, 1), new Object[] {Items.BOOK, new ItemStack(Items.DYE, 1, 0), Items.FEATHER});
        this.addShapelessRecipe(new ItemStack(Items.FLINT_AND_STEEL, 1), new Object[] {new ItemStack(Items.IRON_INGOT, 1), new ItemStack(Items.FLINT, 1)});
        this.addShapelessRecipe(new ItemStack(Items.ENDER_EYE, 1), new Object[] {Items.ENDER_PEARL, Items.BLAZE_POWDER});
        this.addShapelessRecipe(new ItemStack(Items.FIRE_CHARGE, 3), new Object[] {Items.GUNPOWDER, Items.BLAZE_POWDER, Items.COAL});
        this.addShapelessRecipe(new ItemStack(Items.FIRE_CHARGE, 3), new Object[] {Items.GUNPOWDER, Items.BLAZE_POWDER, new ItemStack(Items.COAL, 1, 1)});
        this.addShapelessRecipe(new ItemStack(Items.MAP, 1), new ItemStack(Items.PAPER), new ItemStack(Items.FEATHER), new ItemStack(Items.DYE,1,0), new ItemStack(Items.DYE,1,1), new ItemStack(Items.DYE,1,11));
        this.addRecipe(new ItemStack(ShopKeeper.explosiveDynamite, 3), new Object[] {" I ", "XOX", "XOX", "XOX", "XOX", 'I', Items.STRING, 'X', Items.PAPER, 'O', Items.GUNPOWDER});
        //this.addRecipe(0, new ItemStack(Blocks.COBBLESTONE_WALL, 6, 0), new Object[] {"###", "###", '#', Blocks.COBBLESTONE});
        //this.addRecipe(0, new ItemStack(Blocks.COBBLESTONE_WALL, 6, 1), new Object[] {"###", "###", '#', Blocks.MOSSY_COBBLESTONE});
        //this.addRecipe(0, new ItemStack(Blocks.nether_brick_fence, 6), new Object[] {"###", "###", '#', Blocks.NETHER_BRICK});
        //this.addRecipe(0, new ItemStack(Blocks.fence_gate, 1), new Object[] {"#W#", "#W#", '#', Items.STICK, 'W', Blocks.PLANKS});
        //this.addRecipe(0, new ItemStack(Blocks.jukebox, 1), new Object[] {"###", "#X#", "###", '#', Blocks.PLANKS, 'X', Items.DIAMOND});
        //this.addRecipe(0, new ItemStack(Blocks.noteblock, 1), new Object[] {"###", "#X#", "###", '#', Blocks.PLANKS, 'X', Items.REDSTONE});
        //this.addRecipe(0, new ItemStack(Blocks.bookshelf, 1), new Object[] {"###", "XXX", "###", '#', Blocks.PLANKS, 'X', Items.BOOK});
        //this.addRecipe(0, new ItemStack(Blocks.SNOW, 1), new Object[] {"##", "##", '#', Items.SNOWBALL});
        //this.addRecipe(0, new ItemStack(Blocks.snow_layer, 6), new Object[] {"###", '#', Blocks.SNOW});
        //this.addRecipe(0, new ItemStack(Blocks.clay, 1), new Object[] {"##", "##", '#', Items.CLAY_BALL});
        //this.addRecipe(0, new ItemStack(Blocks.BRICK_BLOCK, 1), new Object[] {"##", "##", '#', Items.BRICK});
        //this.addRecipe(0, new ItemStack(Blocks.glowstone, 1), new Object[] {"##", "##", '#', Items.GLOWSTONE_DUST});
        //this.addRecipe(0, new ItemStack(Blocks.QUARTZ_BLOCK, 1), new Object[] {"##", "##", '#', Items.QUARTZ});
        //this.addRecipe(0, new ItemStack(Blocks.tnt, 1), new Object[] {"X#X", "#X#", "X#X", 'X', Items.GUNPOWDER, '#', Blocks.SAND});
        //this.addRecipe(0, new ItemStack(Blocks.stone_slab, 6, 3), new Object[] {"###", '#', Blocks.COBBLESTONE});
        //this.addRecipe(0, new ItemStack(Blocks.stone_slab, 6, 0), new Object[] {"###", '#', Blocks.STONE});
        //this.addRecipe(0, new ItemStack(Blocks.stone_slab, 6, 1), new Object[] {"###", '#', Blocks.SANDSTONE});
        //this.addRecipe(0, new ItemStack(Blocks.stone_slab, 6, 4), new Object[] {"###", '#', Blocks.BRICK_BLOCK});
        //this.addRecipe(0, new ItemStack(Blocks.stone_slab, 6, 5), new Object[] {"###", '#', Blocks.STONEBRICK});
        //this.addRecipe(0, new ItemStack(Blocks.stone_slab, 6, 6), new Object[] {"###", '#', Blocks.NETHER_BRICK});
        //this.addRecipe(0, new ItemStack(Blocks.stone_slab, 6, 7), new Object[] {"###", '#', Blocks.QUARTZ_BLOCK});
        //this.addRecipe(0, new ItemStack(Blocks.wooden_slab, 6, 0), new Object[] {"###", '#', new ItemStack(Blocks.PLANKS, 1, 0)});
        //this.addRecipe(0, new ItemStack(Blocks.wooden_slab, 6, 2), new Object[] {"###", '#', new ItemStack(Blocks.PLANKS, 1, 2)});
        //this.addRecipe(0, new ItemStack(Blocks.wooden_slab, 6, 1), new Object[] {"###", '#', new ItemStack(Blocks.PLANKS, 1, 1)});
        //this.addRecipe(0, new ItemStack(Blocks.wooden_slab, 6, 3), new Object[] {"###", '#', new ItemStack(Blocks.PLANKS, 1, 3)});
        //this.addRecipe(0, new ItemStack(Blocks.wooden_slab, 6, 4), new Object[] {"###", '#', new ItemStack(Blocks.PLANKS, 1, 4)});
        //this.addRecipe(0, new ItemStack(Blocks.wooden_slab, 6, 5), new Object[] {"###", '#', new ItemStack(Blocks.PLANKS, 1, 5)});
        //this.addRecipe(0, new ItemStack(Blocks.ladder, 3), new Object[] {"# #", "###", "# #", '#', Items.STICK});
        //this.addRecipe(0, new ItemStack(Items.wooden_door, 1), new Object[] {"##", "##", "##", '#', Blocks.PLANKS});
        //this.addRecipe(0, new ItemStack(Blocks.trapdoor, 2), new Object[] {"###", "###", '#', Blocks.PLANKS});
        //this.addRecipe(0, new ItemStack(Items.sign, 3), new Object[] {"###", "###", " X ", '#', Blocks.PLANKS, 'X', Items.STICK});
        //this.addRecipe(0, new ItemStack(Blocks.PLANKS, 4, 0), new Object[] {"#", '#', new ItemStack(Blocks.log, 1, 0)});
        //this.addRecipe(0, new ItemStack(Blocks.PLANKS, 4, 1), new Object[] {"#", '#', new ItemStack(Blocks.log, 1, 1)});
        //this.addRecipe(0, new ItemStack(Blocks.PLANKS, 4, 2), new Object[] {"#", '#', new ItemStack(Blocks.log, 1, 2)});
        //this.addRecipe(0, new ItemStack(Blocks.PLANKS, 4, 3), new Object[] {"#", '#', new ItemStack(Blocks.log, 1, 3)});
        //this.addRecipe(0, new ItemStack(Blocks.PLANKS, 4, 4), new Object[] {"#", '#', new ItemStack(Blocks.log2, 1, 0)});
        //this.addRecipe(0, new ItemStack(Blocks.PLANKS, 4, 5), new Object[] {"#", '#', new ItemStack(Blocks.log2, 1, 1)});
        //this.addRecipe(0, new ItemStack(Items.stick, 4), new Object[] {"#", "#", '#', Blocks.PLANKS});
        //this.addRecipe(0, new ItemStack(Blocks.torch, 4), new Object[] {"X", "#", 'X', Items.coal, '#', Items.stick});
        //this.addRecipe(0, new ItemStack(Blocks.torch, 4), new Object[] {"X", "#", 'X', new ItemStack(Items.coal, 1, 1), '#', Items.stick});
        //this.addRecipe(0, new ItemStack(Items.bowl, 4), new Object[] {"# #", " # ", '#', Blocks.PLANKS});
        //this.addRecipe(0, new ItemStack(Items.glass_bottle, 3), new Object[] {"# #", " # ", '#', Blocks.glass});
        //this.addRecipe(0, new ItemStack(Items.brewing_stand, 1), new Object[] {" B ", "###", '#', Blocks.cobblestone, 'B', Items.blaze_rod});
        //this.addRecipe(0, new ItemStack(Blocks.lit_pumpkin, 1), new Object[] {"A", "B", 'A', Blocks.pumpkin, 'B', Blocks.torch});
        //this.addRecipe(0, new ItemStack(Items.chest_minecart, 1), new Object[] {"A", "B", 'A', Blocks.chest, 'B', Items.minecart});
        //this.addRecipe(0, new ItemStack(Items.furnace_minecart, 1), new Object[] {"A", "B", 'A', Blocks.furnace, 'B', Items.minecart});
        //this.addRecipe(0, new ItemStack(Items.tnt_minecart, 1), new Object[] {"A", "B", 'A', Blocks.tnt, 'B', Items.minecart});
        //this.addRecipe(0, new ItemStack(Items.hopper_minecart, 1), new Object[] {"A", "B", 'A', Blocks.hopper, 'B', Items.minecart});
        //this.addRecipe(0, new ItemStack(Items.boat, 1), new Object[] {"# #", "###", '#', Blocks.planks});
        //this.addRecipe(0, new ItemStack(Items.flower_pot, 1), new Object[] {"# #", " # ", '#', Items.BRICK});
        //this.addRecipe(0, new ItemStack(Blocks.oak_stairs, 4), new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.planks, 1, 0)});
        //this.addRecipe(0, new ItemStack(Blocks.birch_stairs, 4), new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.planks, 1, 2)});
        //this.addRecipe(0, new ItemStack(Blocks.spruce_stairs, 4), new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.planks, 1, 1)});
        //this.addRecipe(0, new ItemStack(Blocks.jungle_stairs, 4), new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.planks, 1, 3)});
        //this.addRecipe(0, new ItemStack(Blocks.acacia_stairs, 4), new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.planks, 1, 4)});
        //this.addRecipe(0, new ItemStack(Blocks.dark_oak_stairs, 4), new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.planks, 1, 5)});
        //this.addRecipe(0, new ItemStack(Items.fishing_rod, 1), new Object[] {"  #", " #X", "# X", '#', Items.stick, 'X', Items.string});
        //this.addRecipe(0, new ItemStack(Items.carrot_on_a_stick, 1), new Object[] {"# ", " X", '#', Items.fishing_rod, 'X', Items.carrot}).func_92100_c();
        //this.addRecipe(0, new ItemStack(Blocks.stone_stairs, 4), new Object[] {"#  ", "## ", "###", '#', Blocks.cobblestone});
        //this.addRecipe(0, new ItemStack(Blocks.brick_stairs, 4), new Object[] {"#  ", "## ", "###", '#', Blocks.brick_block});
        //this.addRecipe(0, new ItemStack(Blocks.stone_brick_stairs, 4), new Object[] {"#  ", "## ", "###", '#', Blocks.stonebrick});
        //this.addRecipe(0, new ItemStack(Blocks.nether_brick_stairs, 4), new Object[] {"#  ", "## ", "###", '#', Blocks.nether_brick});
        //this.addRecipe(0, new ItemStack(Blocks.sandstone_stairs, 4), new Object[] {"#  ", "## ", "###", '#', Blocks.sandstone});
        //this.addRecipe(0, new ItemStack(Blocks.quartz_stairs, 4), new Object[] {"#  ", "## ", "###", '#', Blocks.quartz_block});
        //this.addRecipe(0, new ItemStack(Items.painting, 1), new Object[] {"###", "#X#", "###", '#', Items.stick, 'X', Blocks.wool});
        //this.addRecipe(0, new ItemStack(Items.item_frame, 1), new Object[] {"###", "#X#", "###", '#', Items.stick, 'X', Items.leather});
        //this.addRecipe(0, new ItemStack(Items.golden_apple, 1, 0), new Object[] {"###", "#X#", "###", '#', Items.gold_ingot, 'X', Items.apple});
        //this.addRecipe(0, new ItemStack(Items.golden_apple, 1, 1), new Object[] {"###", "#X#", "###", '#', Blocks.gold_block, 'X', Items.apple});
        //this.addRecipe(0, new ItemStack(Items.golden_carrot, 1, 0), new Object[] {"###", "#X#", "###", '#', Items.gold_nugget, 'X', Items.carrot});
        //this.addRecipe(0, new ItemStack(Items.speckled_melon, 1), new Object[] {"###", "#X#", "###", '#', Items.gold_nugget, 'X', Items.melon});
        //this.addRecipe(0, new ItemStack(Blocks.lever, 1), new Object[] {"X", "#", '#', Blocks.cobblestone, 'X', Items.stick});
        //this.addRecipe(0, new ItemStack(Blocks.tripwire_hook, 2), new Object[] {"I", "S", "#", '#', Blocks.planks, 'S', Items.stick, 'I', Items.iron_ingot});
        //this.addRecipe(0, new ItemStack(Blocks.redstone_torch, 1), new Object[] {"X", "#", '#', Items.stick, 'X', Items.redstone});
        //this.addRecipe(0, new ItemStack(Items.repeater, 1), new Object[] {"#X#", "III", '#', Blocks.redstone_torch, 'X', Items.redstone, 'I', Blocks.stone});
        //this.addRecipe(0, new ItemStack(Items.comparator, 1), new Object[] {" # ", "#X#", "III", '#', Blocks.redstone_torch, 'X', Items.quartz, 'I', Blocks.stone});
        //this.addRecipe(0, new ItemStack(Blocks.stone_button, 1), new Object[] {"#", '#', Blocks.stone});
        //this.addRecipe(0, new ItemStack(Blocks.wooden_button, 1), new Object[] {"#", '#', Blocks.planks});
        //this.addRecipe(0, new ItemStack(Blocks.wooden_button, 1), new Object[] {"#", '#', ShopKeeper.acePlanks});
        //this.addRecipe(0, new ItemStack(Blocks.stone_pressure_plate, 1), new Object[] {"##", '#', Blocks.stone});
        //this.addRecipe(0, new ItemStack(Blocks.wooden_pressure_plate, 1), new Object[] {"##", '#', Blocks.planks});
        //this.addRecipe(0, new ItemStack(Blocks.wooden_pressure_plate, 1), new Object[] {"##", '#', ShopKeeper.acePlanks});
        //this.addRecipe(0, new ItemStack(Blocks.dispenser, 1), new Object[] {"###", "#X#", "#R#", '#', Blocks.cobblestone, 'X', Items.bow, 'R', Items.redstone});
        //this.addRecipe(0, new ItemStack(Blocks.dropper, 1), new Object[] {"###", "# #", "#R#", '#', Blocks.cobblestone, 'R', Items.redstone});
        //this.addRecipe(0, new ItemStack(Blocks.piston, 1), new Object[] {"TTT", "#X#", "#R#", '#', Blocks.cobblestone, 'X', Items.iron_ingot, 'R', Items.redstone, 'T', Blocks.planks});
        //this.addRecipe(0, new ItemStack(Blocks.sticky_piston, 1), new Object[] {"S", "P", 'S', Items.slime_ball, 'P', Blocks.piston});
		//this.addRecipe(0, new ItemStack(Blocks.enchanting_table, 1), new Object[] {" B ", "D#D", "###", '#', Blocks.obsidian, 'B', Items.book, 'D', Items.diamond});
		//this.addRecipe(0, new ItemStack(Blocks.enchanting_table, 1), new Object[]{" B ", "GOG", "OOO", 'B', Items.book, 'G', Items.emerald,    'O', Blocks.obsidian});
		//this.addRecipe(0, new ItemStack(Blocks.enchanting_table, 1), new Object[]{" B ", "GOG", "OOO", 'B', Items.book, 'G', ShopKeeper.gemstoneRuby,     'O', Blocks.obsidian});
		//this.addRecipe(0, new ItemStack(Blocks.enchanting_table, 1), new Object[]{" B ", "GOG", "OOO", 'B', Items.book, 'G', ShopKeeper.gemstonePeridot,  'O', Blocks.obsidian});
		//this.addRecipe(0, new ItemStack(Blocks.enchanting_table, 1), new Object[]{" B ", "GOG", "OOO", 'B', Items.book, 'G', ShopKeeper.gemstoneTopaz,    'O', Blocks.obsidian});
		//this.addRecipe(0, new ItemStack(Blocks.enchanting_table, 1), new Object[]{" B ", "GOG", "OOO", 'B', Items.book, 'G', ShopKeeper.gemstoneSaphire,  'O', Blocks.obsidian});
		//this.addRecipe(0, new ItemStack(Blocks.enchanting_table, 1), new Object[]{" B ", "GOG", "OOO", 'B', Items.book, 'G', ShopKeeper.gemstoneAzurit,   'O', Blocks.obsidian});
		//this.addRecipe(0, new ItemStack(Blocks.enchanting_table, 1), new Object[]{" B ", "GOG", "OOO", 'B', Items.book, 'G', ShopKeeper.gemstoneAmber,    'O', Blocks.obsidian});
		//this.addRecipe(0, new ItemStack(Blocks.enchanting_table, 1), new Object[]{" B ", "GOG", "OOO", 'B', Items.book, 'G', ShopKeeper.gemstoneAmethyst, 'O', Blocks.obsidian});
		//this.addRecipe(0, new ItemStack(Blocks.enchanting_table, 1), new Object[]{" B ", "GOG", "OOO", 'B', Items.book, 'G', ShopKeeper.gemstoneGagat,    'O', Blocks.obsidian});
		//this.addRecipe(0, new ItemStack(Blocks.enchanting_table, 1), new Object[]{" B ", "GOG", "OOO", 'B', Items.book, 'G', ShopKeeper.gemstoneOpal,     'O', Blocks.obsidian});
        //this.addRecipe(0, new ItemStack(Blocks.daylight_detector), new Object[] {"GGG", "QQQ", "WWW", 'G', Blocks.glass, 'Q', Items.quartz, 'W', Blocks.wooden_slab});
        this.addRecipe(new ItemStack(Items.LEAD),           new Object[]{"X","X",'X', ShopKeeper.stuffRope});
        //this.addRecipe(0, new ItemStack(ShopKeeper.blockCopper),     new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.ingotCopper      });
        //this.addRecipe(0, new ItemStack(ShopKeeper.blockAluminium),  new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.ingotAluminium   });
        //this.addRecipe(0, new ItemStack(ShopKeeper.blockLead),       new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.ingotLead        });
        //this.addRecipe(0, new ItemStack(ShopKeeper.blockTin),        new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.ingotTin         });
        //this.addRecipe(0, new ItemStack(ShopKeeper.blockZinc),       new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.ingotZinc        });
        //this.addRecipe(0, new ItemStack(ShopKeeper.blockSilver),     new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.ingotSilver      });
        //this.addRecipe(0, new ItemStack(ShopKeeper.blockMythril),    new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.ingotMythril     });
        //this.addRecipe(0, new ItemStack(ShopKeeper.blockIridium),    new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.ingotIridium     });
        //this.addRecipe(0, new ItemStack(ShopKeeper.blockAdamantium), new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.ingotAdamantium  });
        //this.addRecipe(0, new ItemStack(ShopKeeper.blockOrichalcum), new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.ingotOrichalcum  });
        //this.addRecipe(0, new ItemStack(ShopKeeper.blockUnobtanium), new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.ingotUnobtanium  });
        //this.addRecipe(0, new ItemStack(ShopKeeper.blockBronze),     new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.ingotBronze      });
        //this.addRecipe(0, new ItemStack(ShopKeeper.blockSteel),      new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.ingotSteel       });
        //this.addRecipe(0, new ItemStack(ShopKeeper.blockBrass),      new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.ingotBrass       });
        this.addRecipe(new ItemStack(ShopKeeper.blockSalt),       new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.powderSalt       });
        this.addRecipe(new ItemStack(ShopKeeper.blockSulfur),     new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.powderSulfur     });
        this.addRecipe(new ItemStack(ShopKeeper.blockFlour),      new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.powderFlour      });
        this.addRecipe(new ItemStack(ShopKeeper.blockCoffee),     new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.powderCoffee     });
        //this.addRecipe(0, new ItemStack(ShopKeeper.blockRuby),       new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.gemstoneRuby     });
        //this.addRecipe(0, new ItemStack(ShopKeeper.blockPeridot),    new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.gemstonePeridot  });
        //this.addRecipe(0, new ItemStack(ShopKeeper.blockTopaz),      new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.gemstoneTopaz    });
        //this.addRecipe(0, new ItemStack(ShopKeeper.blockSaphire),    new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.gemstoneSaphire  });
        //this.addRecipe(0, new ItemStack(ShopKeeper.blockAzurit),     new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.gemstoneAzurit   });
        //this.addRecipe(0, new ItemStack(ShopKeeper.blockAmber),      new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.gemstoneAmber    });
        //this.addRecipe(0, new ItemStack(ShopKeeper.blockAmethyst),   new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.gemstoneAmethyst });
        //this.addRecipe(0, new ItemStack(ShopKeeper.blockGagat),      new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.gemstoneGagat    });
        //this.addRecipe(0, new ItemStack(ShopKeeper.blockOpal),       new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.gemstoneOpal     });
        //this.addRecipe(0, new ItemStack(ShopKeeper.blockJade),       new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.gemstoneJade     });
        //this.addRecipe(0, new ItemStack(ShopKeeper.blockTurquoise),  new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.gemstoneTurquoise});
        this.addRecipe(new ItemStack(ShopKeeper.toolAxeFlint),        new Object[]{"XX","XI"," I",'X',Items.FLINT,    'I',Items.STICK});
        this.addRecipe(new ItemStack(ShopKeeper.toolHoeFlint),        new Object[]{"XX"," I"," I",'X',Items.FLINT,    'I',Items.STICK});
        this.addRecipe(new ItemStack(ShopKeeper.toolPickaxeFlint),        new Object[]{"XXX"," I "," I ",'X',Items.FLINT,    'I',Items.STICK});
        this.addRecipe(new ItemStack(ShopKeeper.toolShovelFlint),        new Object[]{"X","I","I",'X',Items.FLINT,    'I',Items.STICK});
        this.addRecipe(new ItemStack(ShopKeeper.toolSwordFlint),        new Object[]{"X","X","I",'X',Items.FLINT,    'I',Items.STICK});
        this.addRecipe(new ItemStack(ShopKeeper.toolSpearFlint),        new Object[]{"  X"," I ","I  ",'X',Items.FLINT,    'I',Items.STICK});
        this.addRecipe(new ItemStack(ShopKeeper.toolHammerFlint),        new Object[]{"XXX","XXX"," I "," I ",'X',Items.FLINT,    'I',Items.STICK});
        this.addRecipe(new ItemStack(Items.LEATHER_HELMET), new Object[]{"XXX","X X",'X',Items.LEATHER});
        this.addRecipe(new ItemStack(Items.LEATHER_CHESTPLATE), new Object[]{"X X","XXX","XXX",'X',Items.LEATHER});
        this.addRecipe(new ItemStack(Items.LEATHER_LEGGINGS), new Object[]{"XXX","X X","X X",'X',Items.LEATHER});
        this.addRecipe(new ItemStack(Items.LEATHER_BOOTS), new Object[]{"X X","X X",'X',Items.LEATHER});
        //this.addRecipe(0, new ItemStack(ShopKeeper.bucketWoodEmpty),       new Object[]{"X X","X X"," X ",'X', Blocks.planks}); // Bucket Wood
        //this.addRecipe(0, new ItemStack(ShopKeeper.bucketWoodEmpty),       new Object[]{"X X","X X"," X ",'X', ShopKeeper.acePlanks}); // Bucket Wood
        this.addRecipe(new ItemStack(ShopKeeper.bedItemWhite),     new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.WOOL, 1,  0),'P',Blocks.PLANKS});
        this.addRecipe(new ItemStack(ShopKeeper.bedItemOrange),    new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.WOOL, 1,  1),'P',Blocks.PLANKS});
        this.addRecipe(new ItemStack(ShopKeeper.bedItemMagenta),   new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.WOOL, 1,  2),'P',Blocks.PLANKS});
        this.addRecipe(new ItemStack(ShopKeeper.bedItemLightBlue), new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.WOOL, 1,  3),'P',Blocks.PLANKS});
        this.addRecipe(new ItemStack(ShopKeeper.bedItemYellow),    new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.WOOL, 1,  4),'P',Blocks.PLANKS});
        this.addRecipe(new ItemStack(ShopKeeper.bedItemLime),      new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.WOOL, 1,  5),'P',Blocks.PLANKS});
        this.addRecipe(new ItemStack(ShopKeeper.bedItemPink),      new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.WOOL, 1,  6),'P',Blocks.PLANKS});
        this.addRecipe(new ItemStack(ShopKeeper.bedItemGrey),      new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.WOOL, 1,  7),'P',Blocks.PLANKS});
        this.addRecipe(new ItemStack(ShopKeeper.bedItemSilver),    new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.WOOL, 1,  8),'P',Blocks.PLANKS});
        this.addRecipe(new ItemStack(ShopKeeper.bedItemCyan),      new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.WOOL, 1,  9),'P',Blocks.PLANKS});
        this.addRecipe(new ItemStack(ShopKeeper.bedItemPurple),    new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.WOOL, 1, 10),'P',Blocks.PLANKS});
        this.addRecipe(new ItemStack(ShopKeeper.bedItemBlue),      new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.WOOL, 1, 11),'P',Blocks.PLANKS});
        this.addRecipe(new ItemStack(ShopKeeper.bedItemBrown),     new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.WOOL, 1, 12),'P',Blocks.PLANKS});
        this.addRecipe(new ItemStack(ShopKeeper.bedItemGreen),     new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.WOOL, 1, 13),'P',Blocks.PLANKS});
        this.addRecipe(new ItemStack(ShopKeeper.bedItemRed),       new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.WOOL, 1, 14),'P',Blocks.PLANKS});
        this.addRecipe(new ItemStack(ShopKeeper.bedItemBlack),     new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.WOOL, 1, 15),'P',Blocks.PLANKS});
        this.addRecipe(new ItemStack(ShopKeeper.machinaKeg), new Object[]{"IXXI"," XX "," XX ","IXXI",'X',Blocks.PLANKS,'I',Items.IRON_INGOT});
        this.addRecipe(new ItemStack(ShopKeeper.machinaBlastFurnace), new Object[]{" X ","XXX","XXX","BOB","BBB",'X', Blocks.STONE, 'O', Blocks.COAL_BLOCK, 'B', Blocks.BRICK_BLOCK});
        this.addRecipe(new ItemStack(ShopKeeper.machinaAnvil),            new Object[]{"XXX"," X ","XXX",'X', Items.IRON_INGOT});
        //this.addRecipe(0, new ItemStack(ShopKeeper.machinaAnvilCopper),            new Object[]{"XXX"," X ","XXX",'X', ShopKeeper.ingotCopper});
        //this.addRecipe(0, new ItemStack(ShopKeeper.machinaAnvilAluminium),            new Object[]{"XXX"," X ","XXX",'X', ShopKeeper.ingotAluminium});
        //this.addRecipe(0, new ItemStack(ShopKeeper.machinaAnvilLead),            new Object[]{"XXX"," X ","XXX",'X', ShopKeeper.ingotLead});
        //this.addRecipe(0, new ItemStack(ShopKeeper.machinaAnvilBronze),            new Object[]{"XXX"," X ","XXX",'X', ShopKeeper.ingotBronze});
        //this.addRecipe(0, new ItemStack(ShopKeeper.machinaAnvilSteel),            new Object[]{"XXX"," X ","XXX",'X', ShopKeeper.ingotSteel});
        //this.addRecipe(0, new ItemStack(ShopKeeper.machinaAnvilMythril),            new Object[]{"XXX"," X ","XXX",'X', ShopKeeper.ingotMythril});
        //this.addRecipe(0, new ItemStack(ShopKeeper.machinaAnvilAdamantium),            new Object[]{"XXX"," X ","XXX",'X', ShopKeeper.ingotAdamantium});
        //this.addRecipe(0, new ItemStack(ShopKeeper.machinaAnvilUnobtanium),            new Object[]{"XXX"," X ","XXX",'X', ShopKeeper.ingotUnobtanium});
        this.addRecipe(new ItemStack(ShopKeeper.machinaWorkbench),        new Object[]{"XXX","XXX","XXX",'X', Blocks.PLANKS});
        this.addRecipe(new ItemStack(ShopKeeper.machinaSewingBench),    new Object[]{"CCC","XXX","XXX",'X', Blocks.PLANKS, 'C',Blocks.WOOL});
        this.addRecipe(new ItemStack(ShopKeeper.machinaStove),            new Object[]{"III","XXX","XXX",'X', Blocks.COBBLESTONE, 'I',Items.IRON_INGOT});
        this.addRecipe(new ItemStack(ShopKeeper.machinaCampfire), new Object[]{"LL","OO",'L', Blocks.LOG,   'O', Blocks.COBBLESTONE});
        this.addRecipe(new ItemStack(ShopKeeper.machinaCampfire), new Object[]{"LL","OO",'L', Blocks.LOG2,  'O', Blocks.COBBLESTONE});
        this.addRecipe(new ItemStack(ShopKeeper.machinaCampfire), new Object[]{"LL","OO",'L', Blocks.LOG,   'O', Blocks.GRAVEL});
        this.addRecipe(new ItemStack(ShopKeeper.machinaCampfire), new Object[]{"LL","OO",'L', Blocks.LOG2,  'O', Blocks.GRAVEL});
        this.addRecipe(new ItemStack(ShopKeeper.machinaGlobe), new Object[]{" C ","CWI"," XI",'X', Blocks.PLANKS, 'W', Blocks.CLAY, 'C', Items.DYE, 'I', ShopKeeper.stuffIvory});
        this.addRecipe(new ItemStack(ShopKeeper.machinaGearBox,4), new Object[]{"XXXXX","X G X","XGAGX","X G X","XXXXX",'X',Blocks.PLANKS, 'G', ShopKeeper.stuffGear, 'A', ShopKeeper.machinaAxle});
        this.addRecipe(new ItemStack(ShopKeeper.machinaAxle,8), new Object[]{"XX","XX","XX","XX",'X',Blocks.PLANKS});
        this.addRecipe(new ItemStack(ShopKeeper.machinaWindmill), new Object[]{" CI  "," CICC","IIAII","CCIC ","  IC ", 'A',ShopKeeper.machinaAxle, 'I', Items.STICK, 'C', ShopKeeper.stuffClothLinen});
        this.addRecipe(new ItemStack(ShopKeeper.machinaWaterwheel), new Object[]{" XXX ","XIIIX","XIAIX","XIIIX"," XXX ", 'X', Blocks.WOODEN_SLAB, 'I', Items.STICK, 'A', ShopKeeper.machinaAxle});
        this.addRecipe(new ItemStack(ShopKeeper.machinaFruitPress), new Object[]{" A ","SAS","XXX","XXX", 'X', Blocks.PLANKS, 'A', ShopKeeper.machinaAxle, 'S', Blocks.WOODEN_SLAB});
        this.addRecipe(new ItemStack(ShopKeeper.machinaMillstone), new Object[]{" A "," AS","XXX","XXX", 'X', Blocks.PLANKS, 'A', ShopKeeper.machinaAxle, 'S', Blocks.STONE});
        this.addRecipe(new ItemStack(ShopKeeper.machinaDestille), new Object[]{"BI","WF",'B', ShopKeeper.blockCopper, 'I', ShopKeeper.ingotCopper, 'W', Blocks.PLANKS, 'F', Blocks.FURNACE});
        //this.addRecipe(0, new ItemStack(ShopKeeper.machinaPodium),       new Object[]{" S ","ISI","SSS",'S', Blocks.stonebrick, 'I', Items.iron_ingot});
        //this.addRecipe(0, new ItemStack(ShopKeeper.machinaGenerator),       new Object[]{" SSS ", "ASISC", " SSS ", 'S', Blocks.wooden_slab, 'A', ShopKeeper.machinaAxle, 'I', Items.iron_ingot, 'C', ShopKeeper.machinaCable});
        //this.addRecipe(0, new ItemStack(ShopKeeper.machinaMotor),       new Object[]{" SSS ", "CSISA", " SSS ", 'S', Blocks.stone_slab, 'C', ShopKeeper.machinaCable, 'I', Items.iron_ingot, 'A', ShopKeeper.machinaAxle});
        //this.addRecipe(0, new ItemStack(ShopKeeper.scaffoldingOak,36),    new Object[]{"XXXX","X XX","XX X","XXXX", 'X', new ItemStack(Blocks.planks,1,0)});
        //this.addRecipe(0, new ItemStack(ShopKeeper.scaffoldingSpruce,36), new Object[]{"XXXX","X XX","XX X","XXXX", 'X', new ItemStack(Blocks.planks,1,1)});
        //this.addRecipe(0, new ItemStack(ShopKeeper.scaffoldingBirch,36),  new Object[]{"XXXX","X XX","XX X","XXXX", 'X', new ItemStack(Blocks.planks,1,2)});
        //this.addRecipe(0, new ItemStack(ShopKeeper.scaffoldingJungle,36), new Object[]{"XXXX","X XX","XX X","XXXX", 'X', new ItemStack(Blocks.planks,1,3)});
        //this.addRecipe(0, new ItemStack(ShopKeeper.scaffoldingAcacia,36), new Object[]{"XXXX","X XX","XX X","XXXX", 'X', new ItemStack(Blocks.planks,1,4)});
        //this.addRecipe(0, new ItemStack(ShopKeeper.scaffoldingBigOak,36), new Object[]{"XXXX","X XX","XX X","XXXX", 'X', new ItemStack(Blocks.planks,1,5)});
        //this.addRecipe(0, new ItemStack(ShopKeeper.scaffoldingFruit,36),    new Object[]{"XXXX","X XX","XX X","XXXX", 'X', new ItemStack(ShopKeeper.acePlanks,1,0)});
        //this.addRecipe(0, new ItemStack(ShopKeeper.scaffoldingGolden,36),    new Object[]{"XXXX","X XX","XX X","XXXX", 'X', new ItemStack(ShopKeeper.acePlanks,1,1)});
        //this.addRecipe(0, new ItemStack(ShopKeeper.scaffoldingPalm,36),    new Object[]{"XXXX","X XX","XX X","XXXX", 'X', new ItemStack(ShopKeeper.acePlanks,1,2)});
        this.addRecipe(new ItemStack(ShopKeeper.stuffGear), new Object[]{" X ","XOX"," X ",'X', Blocks.WOODEN_BUTTON, 'O', Blocks.PLANKS});
        this.addRecipe(new ItemStack(ShopKeeper.stuffRope, 8), new Object[]{"XX","XX","XX","XX",'X', ShopKeeper.stuffHemp});
        this.addRecipe(new ItemStack(Items.FLINT), new Object[]{"OO","OO",'O',Blocks.GRAVEL});
        this.addRecipe(new ItemStack(ShopKeeper.stuffClothLinen, 3), new Object[]{"XXX","XXX","XXX",'X', ShopKeeper.stuffHemp});
        this.addRecipe(new ItemStack(ShopKeeper.stuffClothWool,  3), new Object[]{"XXX","XXX","XXX",'X', Blocks.WOOL});
        this.addRecipe(new ItemStack(ShopKeeper.stuffClothSilk,  1), new Object[]{"XXX","XXX","XXX",'X', Items.STRING});
    }
}