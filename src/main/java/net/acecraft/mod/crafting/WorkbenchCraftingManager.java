package net.acecraft.mod.crafting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import net.acecraft.mod.AceCraft;
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

public class WorkbenchCraftingManager {
	
    private static final WorkbenchCraftingManager instance = new WorkbenchCraftingManager();
    private List recipes = new ArrayList();
    private static final String __OBFID = "CL_00000090";
    
    public static final WorkbenchCraftingManager getInstance(){
        return instance;
    }
    
    private WorkbenchCraftingManager(){
    	recipes = new ArrayList();
        this.addShapelessRecipe(new ItemStack(Items.book, 1), new Object[] {Items.paper, Items.paper, Items.paper, Items.leather});
        this.addShapelessRecipe(new ItemStack(Items.writable_book, 1), new Object[] {Items.book, new ItemStack(Items.dye, 1, 0), Items.feather});
        this.addShapelessRecipe(new ItemStack(Items.flint_and_steel, 1), new Object[] {new ItemStack(Items.iron_ingot, 1), new ItemStack(Items.flint, 1)});
        this.addShapelessRecipe(new ItemStack(Items.ender_eye, 1), new Object[] {Items.ender_pearl, Items.blaze_powder});
        this.addShapelessRecipe(new ItemStack(Items.fire_charge, 3), new Object[] {Items.gunpowder, Items.blaze_powder, Items.coal});
        this.addShapelessRecipe(new ItemStack(Items.fire_charge, 3), new Object[] {Items.gunpowder, Items.blaze_powder, new ItemStack(Items.coal, 1, 1)});
        this.addShapelessRecipe(new ItemStack(Items.map, 1), new ItemStack(Items.paper), new ItemStack(Items.feather), new ItemStack(Items.dye,1,0), new ItemStack(Items.dye,1,1), new ItemStack(Items.dye,1,11));
        this.addRecipe(new ItemStack(ShopKeeper.stuffDynamite, 3), new Object[] {" I ", "XOX", "XOX", "XOX", "XOX", 'I', Items.string, 'X', Items.paper, 'O', Items.gunpowder});
        this.addRecipe(new ItemStack(Blocks.fence, 2), new Object[] {"###", "###", '#', Items.stick});
        this.addRecipe(new ItemStack(Blocks.cobblestone_wall, 6, 0), new Object[] {"###", "###", '#', Blocks.cobblestone});
        this.addRecipe(new ItemStack(Blocks.cobblestone_wall, 6, 1), new Object[] {"###", "###", '#', Blocks.mossy_cobblestone});
        this.addRecipe(new ItemStack(Blocks.nether_brick_fence, 6), new Object[] {"###", "###", '#', Blocks.nether_brick});
        this.addRecipe(new ItemStack(Blocks.fence_gate, 1), new Object[] {"#W#", "#W#", '#', Items.stick, 'W', Blocks.planks});
        this.addRecipe(new ItemStack(Blocks.jukebox, 1), new Object[] {"###", "#X#", "###", '#', Blocks.planks, 'X', Items.diamond});
        this.addRecipe(new ItemStack(Blocks.jukebox, 1), new Object[] {"###", "#X#", "###", '#', ShopKeeper.acePlanks, 'X', Items.diamond});
        this.addRecipe(new ItemStack(Blocks.noteblock, 1), new Object[] {"###", "#X#", "###", '#', Blocks.planks, 'X', Items.redstone});
        this.addRecipe(new ItemStack(Blocks.noteblock, 1), new Object[] {"###", "#X#", "###", '#', ShopKeeper.acePlanks, 'X', Items.redstone});
        this.addRecipe(new ItemStack(Blocks.bookshelf, 1), new Object[] {"###", "XXX", "###", '#', Blocks.planks, 'X', Items.book});
        this.addRecipe(new ItemStack(Blocks.bookshelf, 1), new Object[] {"###", "XXX", "###", '#', ShopKeeper.acePlanks, 'X', Items.book});
        this.addRecipe(new ItemStack(Blocks.snow, 1), new Object[] {"##", "##", '#', Items.snowball});
        this.addRecipe(new ItemStack(Blocks.snow_layer, 6), new Object[] {"###", '#', Blocks.snow});
        this.addRecipe(new ItemStack(Blocks.clay, 1), new Object[] {"##", "##", '#', Items.clay_ball});
        this.addRecipe(new ItemStack(Blocks.brick_block, 1), new Object[] {"##", "##", '#', Items.brick});
        this.addRecipe(new ItemStack(Blocks.glowstone, 1), new Object[] {"##", "##", '#', Items.glowstone_dust});
        this.addRecipe(new ItemStack(Blocks.quartz_block, 1), new Object[] {"##", "##", '#', Items.quartz});
        this.addRecipe(new ItemStack(Blocks.tnt, 1), new Object[] {"X#X", "#X#", "X#X", 'X', Items.gunpowder, '#', Blocks.sand});
        this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 3), new Object[] {"###", '#', Blocks.cobblestone});
        this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 0), new Object[] {"###", '#', Blocks.stone});
        this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 1), new Object[] {"###", '#', Blocks.sandstone});
        this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 4), new Object[] {"###", '#', Blocks.brick_block});
        this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 5), new Object[] {"###", '#', Blocks.stonebrick});
        this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 6), new Object[] {"###", '#', Blocks.nether_brick});
        this.addRecipe(new ItemStack(Blocks.stone_slab, 6, 7), new Object[] {"###", '#', Blocks.quartz_block});
        this.addRecipe(new ItemStack(Blocks.wooden_slab, 6, 0), new Object[] {"###", '#', new ItemStack(Blocks.planks, 1, 0)});
        this.addRecipe(new ItemStack(Blocks.wooden_slab, 6, 2), new Object[] {"###", '#', new ItemStack(Blocks.planks, 1, 2)});
        this.addRecipe(new ItemStack(Blocks.wooden_slab, 6, 1), new Object[] {"###", '#', new ItemStack(Blocks.planks, 1, 1)});
        this.addRecipe(new ItemStack(Blocks.wooden_slab, 6, 3), new Object[] {"###", '#', new ItemStack(Blocks.planks, 1, 3)});
        this.addRecipe(new ItemStack(Blocks.wooden_slab, 6, 4), new Object[] {"###", '#', new ItemStack(Blocks.planks, 1, 4)});
        this.addRecipe(new ItemStack(Blocks.wooden_slab, 6, 5), new Object[] {"###", '#', new ItemStack(Blocks.planks, 1, 5)});
        this.addRecipe(new ItemStack(Blocks.ladder, 3), new Object[] {"# #", "###", "# #", '#', Items.stick});
        this.addRecipe(new ItemStack(Items.wooden_door, 1), new Object[] {"##", "##", "##", '#', Blocks.planks});
        this.addRecipe(new ItemStack(Items.wooden_door, 1), new Object[] {"##", "##", "##", '#', ShopKeeper.acePlanks});
        this.addRecipe(new ItemStack(Blocks.trapdoor, 2), new Object[] {"###", "###", '#', Blocks.planks});
        this.addRecipe(new ItemStack(Blocks.trapdoor, 2), new Object[] {"###", "###", '#', ShopKeeper.acePlanks});
        this.addRecipe(new ItemStack(Items.sign, 3), new Object[] {"###", "###", " X ", '#', Blocks.planks, 'X', Items.stick});
        this.addRecipe(new ItemStack(Items.sign, 3), new Object[] {"###", "###", " X ", '#', ShopKeeper.acePlanks, 'X', Items.stick});
        this.addRecipe(new ItemStack(Blocks.planks, 4, 0), new Object[] {"#", '#', new ItemStack(Blocks.log, 1, 0)});
        this.addRecipe(new ItemStack(Blocks.planks, 4, 1), new Object[] {"#", '#', new ItemStack(Blocks.log, 1, 1)});
        this.addRecipe(new ItemStack(Blocks.planks, 4, 2), new Object[] {"#", '#', new ItemStack(Blocks.log, 1, 2)});
        this.addRecipe(new ItemStack(Blocks.planks, 4, 3), new Object[] {"#", '#', new ItemStack(Blocks.log, 1, 3)});
        this.addRecipe(new ItemStack(Blocks.planks, 4, 4), new Object[] {"#", '#', new ItemStack(Blocks.log2, 1, 0)});
        this.addRecipe(new ItemStack(Blocks.planks, 4, 5), new Object[] {"#", '#', new ItemStack(Blocks.log2, 1, 1)});
        this.addRecipe(new ItemStack(ShopKeeper.acePlanks, 4, 0), new Object[] {"#", '#', new ItemStack(ShopKeeper.aceLog, 1, 0)});
        this.addRecipe(new ItemStack(ShopKeeper.acePlanks, 4, 1), new Object[] {"#", '#', new ItemStack(ShopKeeper.aceLog, 1, 1)});
        this.addRecipe(new ItemStack(ShopKeeper.acePlanks, 4, 2), new Object[] {"#", '#', new ItemStack(ShopKeeper.aceLog, 1, 2)});
        this.addRecipe(new ItemStack(Items.stick, 4), new Object[] {"#", "#", '#', Blocks.planks});
        this.addRecipe(new ItemStack(Items.stick, 4), new Object[] {"#", "#", '#', ShopKeeper.acePlanks});
        this.addRecipe(new ItemStack(Blocks.torch, 4), new Object[] {"X", "#", 'X', Items.coal, '#', Items.stick});
        this.addRecipe(new ItemStack(Blocks.torch, 4), new Object[] {"X", "#", 'X', new ItemStack(Items.coal, 1, 1), '#', Items.stick});
        this.addRecipe(new ItemStack(Items.bowl, 4), new Object[] {"# #", " # ", '#', Blocks.planks});
        this.addRecipe(new ItemStack(Items.bowl, 4), new Object[] {"# #", " # ", '#', ShopKeeper.acePlanks});
        this.addRecipe(new ItemStack(Items.glass_bottle, 3), new Object[] {"# #", " # ", '#', Blocks.glass});
        this.addRecipe(new ItemStack(Items.brewing_stand, 1), new Object[] {" B ", "###", '#', Blocks.cobblestone, 'B', Items.blaze_rod});
        this.addRecipe(new ItemStack(Blocks.lit_pumpkin, 1), new Object[] {"A", "B", 'A', Blocks.pumpkin, 'B', Blocks.torch});
        this.addRecipe(new ItemStack(Items.chest_minecart, 1), new Object[] {"A", "B", 'A', Blocks.chest, 'B', Items.minecart});
        this.addRecipe(new ItemStack(Items.furnace_minecart, 1), new Object[] {"A", "B", 'A', Blocks.furnace, 'B', Items.minecart});
        this.addRecipe(new ItemStack(Items.tnt_minecart, 1), new Object[] {"A", "B", 'A', Blocks.tnt, 'B', Items.minecart});
        this.addRecipe(new ItemStack(Items.hopper_minecart, 1), new Object[] {"A", "B", 'A', Blocks.hopper, 'B', Items.minecart});
        this.addRecipe(new ItemStack(Items.boat, 1), new Object[] {"# #", "###", '#', Blocks.planks});
        this.addRecipe(new ItemStack(Items.boat, 1), new Object[] {"# #", "###", '#', ShopKeeper.acePlanks});
        this.addRecipe(new ItemStack(Items.flower_pot, 1), new Object[] {"# #", " # ", '#', Items.brick});
        this.addRecipe(new ItemStack(Blocks.oak_stairs, 4), new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.planks, 1, 0)});
        this.addRecipe(new ItemStack(Blocks.birch_stairs, 4), new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.planks, 1, 2)});
        this.addRecipe(new ItemStack(Blocks.spruce_stairs, 4), new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.planks, 1, 1)});
        this.addRecipe(new ItemStack(Blocks.jungle_stairs, 4), new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.planks, 1, 3)});
        this.addRecipe(new ItemStack(Blocks.acacia_stairs, 4), new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.planks, 1, 4)});
        this.addRecipe(new ItemStack(Blocks.dark_oak_stairs, 4), new Object[] {"#  ", "## ", "###", '#', new ItemStack(Blocks.planks, 1, 5)});
        this.addRecipe(new ItemStack(Items.fishing_rod, 1), new Object[] {"  #", " #X", "# X", '#', Items.stick, 'X', Items.string});
        this.addRecipe(new ItemStack(Items.carrot_on_a_stick, 1), new Object[] {"# ", " X", '#', Items.fishing_rod, 'X', Items.carrot}).func_92100_c();
        this.addRecipe(new ItemStack(Blocks.stone_stairs, 4), new Object[] {"#  ", "## ", "###", '#', Blocks.cobblestone});
        this.addRecipe(new ItemStack(Blocks.brick_stairs, 4), new Object[] {"#  ", "## ", "###", '#', Blocks.brick_block});
        this.addRecipe(new ItemStack(Blocks.stone_brick_stairs, 4), new Object[] {"#  ", "## ", "###", '#', Blocks.stonebrick});
        this.addRecipe(new ItemStack(Blocks.nether_brick_stairs, 4), new Object[] {"#  ", "## ", "###", '#', Blocks.nether_brick});
        this.addRecipe(new ItemStack(Blocks.sandstone_stairs, 4), new Object[] {"#  ", "## ", "###", '#', Blocks.sandstone});
        this.addRecipe(new ItemStack(Blocks.quartz_stairs, 4), new Object[] {"#  ", "## ", "###", '#', Blocks.quartz_block});
        this.addRecipe(new ItemStack(Items.painting, 1), new Object[] {"###", "#X#", "###", '#', Items.stick, 'X', Blocks.wool});
        this.addRecipe(new ItemStack(Items.item_frame, 1), new Object[] {"###", "#X#", "###", '#', Items.stick, 'X', Items.leather});
        this.addRecipe(new ItemStack(Items.golden_apple, 1, 0), new Object[] {"###", "#X#", "###", '#', Items.gold_ingot, 'X', Items.apple});
        this.addRecipe(new ItemStack(Items.golden_apple, 1, 1), new Object[] {"###", "#X#", "###", '#', Blocks.gold_block, 'X', Items.apple});
        this.addRecipe(new ItemStack(Items.golden_carrot, 1, 0), new Object[] {"###", "#X#", "###", '#', Items.gold_nugget, 'X', Items.carrot});
        this.addRecipe(new ItemStack(Items.speckled_melon, 1), new Object[] {"###", "#X#", "###", '#', Items.gold_nugget, 'X', Items.melon});
        this.addRecipe(new ItemStack(Blocks.lever, 1), new Object[] {"X", "#", '#', Blocks.cobblestone, 'X', Items.stick});
        this.addRecipe(new ItemStack(Blocks.tripwire_hook, 2), new Object[] {"I", "S", "#", '#', Blocks.planks, 'S', Items.stick, 'I', Items.iron_ingot});
        this.addRecipe(new ItemStack(Blocks.redstone_torch, 1), new Object[] {"X", "#", '#', Items.stick, 'X', Items.redstone});
        this.addRecipe(new ItemStack(Items.repeater, 1), new Object[] {"#X#", "III", '#', Blocks.redstone_torch, 'X', Items.redstone, 'I', Blocks.stone});
        this.addRecipe(new ItemStack(Items.comparator, 1), new Object[] {" # ", "#X#", "III", '#', Blocks.redstone_torch, 'X', Items.quartz, 'I', Blocks.stone});
        this.addRecipe(new ItemStack(Blocks.stone_button, 1), new Object[] {"#", '#', Blocks.stone});
        this.addRecipe(new ItemStack(Blocks.wooden_button, 1), new Object[] {"#", '#', Blocks.planks});
        this.addRecipe(new ItemStack(Blocks.wooden_button, 1), new Object[] {"#", '#', ShopKeeper.acePlanks});
        this.addRecipe(new ItemStack(Blocks.stone_pressure_plate, 1), new Object[] {"##", '#', Blocks.stone});
        this.addRecipe(new ItemStack(Blocks.wooden_pressure_plate, 1), new Object[] {"##", '#', Blocks.planks});
        this.addRecipe(new ItemStack(Blocks.wooden_pressure_plate, 1), new Object[] {"##", '#', ShopKeeper.acePlanks});
        this.addRecipe(new ItemStack(Blocks.dispenser, 1), new Object[] {"###", "#X#", "#R#", '#', Blocks.cobblestone, 'X', Items.bow, 'R', Items.redstone});
        this.addRecipe(new ItemStack(Blocks.dropper, 1), new Object[] {"###", "# #", "#R#", '#', Blocks.cobblestone, 'R', Items.redstone});
        this.addRecipe(new ItemStack(Blocks.piston, 1), new Object[] {"TTT", "#X#", "#R#", '#', Blocks.cobblestone, 'X', Items.iron_ingot, 'R', Items.redstone, 'T', Blocks.planks});
        this.addRecipe(new ItemStack(Blocks.sticky_piston, 1), new Object[] {"S", "P", 'S', Items.slime_ball, 'P', Blocks.piston});
		this.addRecipe(new ItemStack(Blocks.enchanting_table, 1), new Object[] {" B ", "D#D", "###", '#', Blocks.obsidian, 'B', Items.book, 'D', Items.diamond});
		this.addRecipe(new ItemStack(Blocks.enchanting_table, 1), new Object[]{" B ", "GOG", "OOO", 'B', Items.book, 'G', Items.emerald,    'O', Blocks.obsidian});
		this.addRecipe(new ItemStack(Blocks.enchanting_table, 1), new Object[]{" B ", "GOG", "OOO", 'B', Items.book, 'G', ShopKeeper.gemstoneRuby,     'O', Blocks.obsidian});
		this.addRecipe(new ItemStack(Blocks.enchanting_table, 1), new Object[]{" B ", "GOG", "OOO", 'B', Items.book, 'G', ShopKeeper.gemstonePeridot,  'O', Blocks.obsidian});
		this.addRecipe(new ItemStack(Blocks.enchanting_table, 1), new Object[]{" B ", "GOG", "OOO", 'B', Items.book, 'G', ShopKeeper.gemstoneTopaz,    'O', Blocks.obsidian});
		this.addRecipe(new ItemStack(Blocks.enchanting_table, 1), new Object[]{" B ", "GOG", "OOO", 'B', Items.book, 'G', ShopKeeper.gemstoneSaphire,  'O', Blocks.obsidian});
		this.addRecipe(new ItemStack(Blocks.enchanting_table, 1), new Object[]{" B ", "GOG", "OOO", 'B', Items.book, 'G', ShopKeeper.gemstoneAzurit,   'O', Blocks.obsidian});
		this.addRecipe(new ItemStack(Blocks.enchanting_table, 1), new Object[]{" B ", "GOG", "OOO", 'B', Items.book, 'G', ShopKeeper.gemstoneAmber,    'O', Blocks.obsidian});
		this.addRecipe(new ItemStack(Blocks.enchanting_table, 1), new Object[]{" B ", "GOG", "OOO", 'B', Items.book, 'G', ShopKeeper.gemstoneAmethyst, 'O', Blocks.obsidian});
		this.addRecipe(new ItemStack(Blocks.enchanting_table, 1), new Object[]{" B ", "GOG", "OOO", 'B', Items.book, 'G', ShopKeeper.gemstoneGagat,    'O', Blocks.obsidian});
		this.addRecipe(new ItemStack(Blocks.enchanting_table, 1), new Object[]{" B ", "GOG", "OOO", 'B', Items.book, 'G', ShopKeeper.gemstoneOpal,     'O', Blocks.obsidian});
        this.addRecipe(new ItemStack(Blocks.daylight_detector), new Object[] {"GGG", "QQQ", "WWW", 'G', Blocks.glass, 'Q', Items.quartz, 'W', Blocks.wooden_slab});
        this.addRecipe(new ItemStack(Items.lead),           new Object[]{"X","X",'X', ShopKeeper.stuffRope});
        this.addRecipe(new ItemStack(ShopKeeper.blockCopper),     new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.ingotCopper      });
        this.addRecipe(new ItemStack(ShopKeeper.blockAluminium),  new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.ingotAluminium   });
        this.addRecipe(new ItemStack(ShopKeeper.blockLead),       new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.ingotLead        });
        this.addRecipe(new ItemStack(ShopKeeper.blockTin),        new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.ingotTin         });
        this.addRecipe(new ItemStack(ShopKeeper.blockZinc),       new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.ingotZinc        });
        this.addRecipe(new ItemStack(ShopKeeper.blockSilver),     new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.ingotSilver      });
        this.addRecipe(new ItemStack(ShopKeeper.blockMythril),    new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.ingotMythril     });
        this.addRecipe(new ItemStack(ShopKeeper.blockIridium),    new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.ingotIridium     });
        this.addRecipe(new ItemStack(ShopKeeper.blockAdamantium), new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.ingotAdamantium  });
        this.addRecipe(new ItemStack(ShopKeeper.blockOrichalcum), new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.ingotOrichalcum  });
        this.addRecipe(new ItemStack(ShopKeeper.blockUnobtanium), new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.ingotUnobtanium  });
        this.addRecipe(new ItemStack(ShopKeeper.blockBronze),     new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.ingotBronze      });
        this.addRecipe(new ItemStack(ShopKeeper.blockSteel),      new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.ingotSteel       });
        this.addRecipe(new ItemStack(ShopKeeper.blockBrass),      new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.ingotBrass       });
        this.addRecipe(new ItemStack(ShopKeeper.blockSalt),       new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.powderSalt       });
        this.addRecipe(new ItemStack(ShopKeeper.blockSulfur),     new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.powderSulfur     });
        this.addRecipe(new ItemStack(ShopKeeper.blockFlour),      new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.powderFlour      });
        this.addRecipe(new ItemStack(ShopKeeper.blockCoffee),     new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.powderCoffee     });
        this.addRecipe(new ItemStack(ShopKeeper.blockRuby),       new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.gemstoneRuby     });
        this.addRecipe(new ItemStack(ShopKeeper.blockPeridot),    new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.gemstonePeridot  });
        this.addRecipe(new ItemStack(ShopKeeper.blockTopaz),      new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.gemstoneTopaz    });
        this.addRecipe(new ItemStack(ShopKeeper.blockSaphire),    new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.gemstoneSaphire  });
        this.addRecipe(new ItemStack(ShopKeeper.blockAzurit),     new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.gemstoneAzurit   });
        this.addRecipe(new ItemStack(ShopKeeper.blockAmber),      new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.gemstoneAmber    });
        this.addRecipe(new ItemStack(ShopKeeper.blockAmethyst),   new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.gemstoneAmethyst });
        this.addRecipe(new ItemStack(ShopKeeper.blockGagat),      new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.gemstoneGagat    });
        this.addRecipe(new ItemStack(ShopKeeper.blockOpal),       new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.gemstoneOpal     });
        this.addRecipe(new ItemStack(ShopKeeper.blockJade),       new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.gemstoneJade     });
        this.addRecipe(new ItemStack(ShopKeeper.blockTurquoise),  new Object[]{ "XXX","XXX","XXX", 'X',ShopKeeper.gemstoneTurquoise});
        this.addRecipe(new ItemStack(ShopKeeper.toolAxeFlint),        new Object[]{"XX","XI"," I",'X',Items.flint,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolHoeFlint),        new Object[]{"XX"," I"," I",'X',Items.flint,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolPickaxeFlint),        new Object[]{"XXX"," I "," I ",'X',Items.flint,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolShovelFlint),        new Object[]{"X","I","I",'X',Items.flint,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolSwordFlint),        new Object[]{"X","X","I",'X',Items.flint,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolSpearFlint),        new Object[]{"  X"," I ","I  ",'X',Items.flint,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolHammerFlint),        new Object[]{"XXX","XXX"," I "," I ",'X',Items.flint,    'I',Items.stick});
        this.addRecipe(new ItemStack(Items.leather_helmet), new Object[]{"XXX","X X",'X',Items.iron_ingot});
        this.addRecipe(new ItemStack(Items.leather_chestplate), new Object[]{"X X","XXX","XXX",'X',Items.iron_ingot});
        this.addRecipe(new ItemStack(Items.leather_leggings), new Object[]{"XXX","X X","X X",'X',Items.iron_ingot});
        this.addRecipe(new ItemStack(Items.leather_boots), new Object[]{"X X","X X",'X',Items.iron_ingot});
        this.addRecipe(new ItemStack(ShopKeeper.bucketWoodEmpty),       new Object[]{"X X","X X"," X ",'X', Blocks.planks}); // Bucket Wood
        this.addRecipe(new ItemStack(ShopKeeper.bucketWoodEmpty),       new Object[]{"X X","X X"," X ",'X', ShopKeeper.acePlanks}); // Bucket Wood
        this.addRecipe(new ItemStack(ShopKeeper.bedWhite),     new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.wool, 1,  0),'P',Blocks.planks});
        this.addRecipe(new ItemStack(ShopKeeper.bedOrange),    new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.wool, 1,  1),'P',Blocks.planks});
        this.addRecipe(new ItemStack(ShopKeeper.bedMagenta),   new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.wool, 1,  2),'P',Blocks.planks});
        this.addRecipe(new ItemStack(ShopKeeper.bedLightBlue), new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.wool, 1,  3),'P',Blocks.planks});
        this.addRecipe(new ItemStack(ShopKeeper.bedYellow),    new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.wool, 1,  4),'P',Blocks.planks});
        this.addRecipe(new ItemStack(ShopKeeper.bedLime),      new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.wool, 1,  5),'P',Blocks.planks});
        this.addRecipe(new ItemStack(ShopKeeper.bedPink),      new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.wool, 1,  6),'P',Blocks.planks});
        this.addRecipe(new ItemStack(ShopKeeper.bedGrey),      new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.wool, 1,  7),'P',Blocks.planks});
        this.addRecipe(new ItemStack(ShopKeeper.bedSilver),    new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.wool, 1,  8),'P',Blocks.planks});
        this.addRecipe(new ItemStack(ShopKeeper.bedCyan),      new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.wool, 1,  9),'P',Blocks.planks});
        this.addRecipe(new ItemStack(ShopKeeper.bedPurple),    new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.wool, 1, 10),'P',Blocks.planks});
        this.addRecipe(new ItemStack(ShopKeeper.bedBlue),      new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.wool, 1, 11),'P',Blocks.planks});
        this.addRecipe(new ItemStack(ShopKeeper.bedBrown),     new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.wool, 1, 12),'P',Blocks.planks});
        this.addRecipe(new ItemStack(ShopKeeper.bedGreen),     new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.wool, 1, 13),'P',Blocks.planks});
        this.addRecipe(new ItemStack(ShopKeeper.bedRed),       new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.wool, 1, 14),'P',Blocks.planks});
        this.addRecipe(new ItemStack(ShopKeeper.bedBlack),     new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.wool, 1, 15),'P',Blocks.planks});
        this.addRecipe(new ItemStack(ShopKeeper.bedWhite),     new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.wool, 1,  0),'P',ShopKeeper.acePlanks});
        this.addRecipe(new ItemStack(ShopKeeper.bedOrange),    new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.wool, 1,  1),'P',ShopKeeper.acePlanks});
        this.addRecipe(new ItemStack(ShopKeeper.bedMagenta),   new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.wool, 1,  2),'P',ShopKeeper.acePlanks});
        this.addRecipe(new ItemStack(ShopKeeper.bedLightBlue), new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.wool, 1,  3),'P',ShopKeeper.acePlanks});
        this.addRecipe(new ItemStack(ShopKeeper.bedYellow),    new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.wool, 1,  4),'P',ShopKeeper.acePlanks});
        this.addRecipe(new ItemStack(ShopKeeper.bedLime),      new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.wool, 1,  5),'P',ShopKeeper.acePlanks});
        this.addRecipe(new ItemStack(ShopKeeper.bedPink),      new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.wool, 1,  6),'P',ShopKeeper.acePlanks});
        this.addRecipe(new ItemStack(ShopKeeper.bedGrey),      new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.wool, 1,  7),'P',ShopKeeper.acePlanks});
        this.addRecipe(new ItemStack(ShopKeeper.bedSilver),    new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.wool, 1,  8),'P',ShopKeeper.acePlanks});
        this.addRecipe(new ItemStack(ShopKeeper.bedCyan),      new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.wool, 1,  9),'P',ShopKeeper.acePlanks});
        this.addRecipe(new ItemStack(ShopKeeper.bedPurple),    new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.wool, 1, 10),'P',ShopKeeper.acePlanks});
        this.addRecipe(new ItemStack(ShopKeeper.bedBlue),      new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.wool, 1, 11),'P',ShopKeeper.acePlanks});
        this.addRecipe(new ItemStack(ShopKeeper.bedBrown),     new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.wool, 1, 12),'P',ShopKeeper.acePlanks});
        this.addRecipe(new ItemStack(ShopKeeper.bedGreen),     new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.wool, 1, 13),'P',ShopKeeper.acePlanks});
        this.addRecipe(new ItemStack(ShopKeeper.bedRed),       new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.wool, 1, 14),'P',ShopKeeper.acePlanks});
        this.addRecipe(new ItemStack(ShopKeeper.bedBlack),     new Object[]{"WWW","PPP",'W',new ItemStack(Blocks.wool, 1, 15),'P',ShopKeeper.acePlanks});
        this.addRecipe(new ItemStack(ShopKeeper.machinaKeg), new Object[]{"IXXI"," XX "," XX ","IXXI",'X',Blocks.planks,'I',Items.iron_ingot});
        this.addRecipe(new ItemStack(ShopKeeper.machinaBlastFurnaceIdle), new Object[]{" X ","XXX","XXX","BOB","BBB",'X', Blocks.stone, 'O', Blocks.coal_block, 'B', Blocks.brick_block});
        this.addRecipe(new ItemStack(ShopKeeper.machinaAnvilIron),            new Object[]{"XXX"," X ","XXX",'X', Items.iron_ingot});
        this.addRecipe(new ItemStack(ShopKeeper.machinaAnvilCopper),            new Object[]{"XXX"," X ","XXX",'X', ShopKeeper.ingotCopper});
        this.addRecipe(new ItemStack(ShopKeeper.machinaAnvilAluminium),            new Object[]{"XXX"," X ","XXX",'X', ShopKeeper.ingotAluminium});
        this.addRecipe(new ItemStack(ShopKeeper.machinaAnvilLead),            new Object[]{"XXX"," X ","XXX",'X', ShopKeeper.ingotLead});
        this.addRecipe(new ItemStack(ShopKeeper.machinaAnvilBronze),            new Object[]{"XXX"," X ","XXX",'X', ShopKeeper.ingotBronze});
        this.addRecipe(new ItemStack(ShopKeeper.machinaAnvilSteel),            new Object[]{"XXX"," X ","XXX",'X', ShopKeeper.ingotSteel});
        this.addRecipe(new ItemStack(ShopKeeper.machinaAnvilMythril),            new Object[]{"XXX"," X ","XXX",'X', ShopKeeper.ingotMythril});
        this.addRecipe(new ItemStack(ShopKeeper.machinaAnvilAdamantium),            new Object[]{"XXX"," X ","XXX",'X', ShopKeeper.ingotAdamantium});
        this.addRecipe(new ItemStack(ShopKeeper.machinaAnvilUnobtanium),            new Object[]{"XXX"," X ","XXX",'X', ShopKeeper.ingotUnobtanium});
        this.addRecipe(new ItemStack(ShopKeeper.machinaWorkbench),        new Object[]{"XXX","XXX","XXX",'X', Blocks.planks});
        this.addRecipe(new ItemStack(ShopKeeper.machinaWorkbench),        new Object[]{"XXX","XXX","XXX",'X', ShopKeeper.acePlanks});
        this.addRecipe(new ItemStack(ShopKeeper.machinaSewingStation),    new Object[]{"CCC","XXX","XXX",'X', Blocks.planks, 'C',Blocks.wool});
        this.addRecipe(new ItemStack(ShopKeeper.machinaSewingStation),    new Object[]{"CCC","XXX","XXX",'X', ShopKeeper.acePlanks, 'C',Blocks.wool});
        this.addRecipe(new ItemStack(ShopKeeper.machinaStove),            new Object[]{"III","XXX","XXX",'X', Blocks.cobblestone, 'I',Items.iron_ingot});
        this.addRecipe(new ItemStack(ShopKeeper.machinaBonfireIdle), new Object[]{"LL","OO",'L', Blocks.log,   'O', Blocks.cobblestone});
        this.addRecipe(new ItemStack(ShopKeeper.machinaBonfireIdle), new Object[]{"LL","OO",'L', Blocks.log2,  'O', Blocks.cobblestone});
        this.addRecipe(new ItemStack(ShopKeeper.machinaBonfireIdle), new Object[]{"LL","OO",'L', ShopKeeper.aceLog, 'O', Blocks.cobblestone});
        this.addRecipe(new ItemStack(ShopKeeper.machinaBonfireIdle), new Object[]{"LL","OO",'L', Blocks.log,   'O', Blocks.gravel});
        this.addRecipe(new ItemStack(ShopKeeper.machinaBonfireIdle), new Object[]{"LL","OO",'L', Blocks.log2,  'O', Blocks.gravel});
        this.addRecipe(new ItemStack(ShopKeeper.machinaBonfireIdle), new Object[]{"LL","OO",'L', ShopKeeper.aceLog, 'O', Blocks.gravel});
        this.addRecipe(new ItemStack(ShopKeeper.machinaGlobe), new Object[]{" C ","CWI"," XI",'X', Blocks.planks, 'W', Blocks.clay, 'C', Items.dye, 'I', ShopKeeper.stuffIvory});
        this.addRecipe(new ItemStack(ShopKeeper.machinaGlobe), new Object[]{" C ","CWI"," XI",'X', ShopKeeper.acePlanks, 'W', Blocks.clay, 'C', Items.dye, 'I', ShopKeeper.stuffIvory});
        this.addRecipe(new ItemStack(ShopKeeper.machinaGearBox,4), new Object[]{"XXXXX","X G X","XGAGX","X G X","XXXXX",'X',Blocks.planks, 'G', ShopKeeper.stuffGear, 'A', ShopKeeper.machinaAxle});
        this.addRecipe(new ItemStack(ShopKeeper.machinaGearBox,4), new Object[]{"XXXXX","X G X","XGAGX","X G X","XXXXX",'X',ShopKeeper.acePlanks, 'G', ShopKeeper.stuffGear, 'A', ShopKeeper.machinaAxle});
        this.addRecipe(new ItemStack(ShopKeeper.machinaAxle,8), new Object[]{"XX","XX","XX","XX",'X',Blocks.planks});
        this.addRecipe(new ItemStack(ShopKeeper.machinaAxle,8), new Object[]{"XX","XX","XX","XX",'X',ShopKeeper.acePlanks});
        this.addRecipe(new ItemStack(ShopKeeper.machinaWindmillWool), new Object[]{" CI  "," CICC","IIAII","CCIC ","  IC ", 'A',ShopKeeper.machinaAxle, 'I', Items.stick, 'C', ShopKeeper.stuffClothLinen});
        this.addRecipe(new ItemStack(ShopKeeper.machinaWindmillLeather),       new Object[]{"SSASS","LLALL","LLALL","SSASS","  X  ", 'X', Blocks.wooden_slab, 'A', ShopKeeper.machinaAxle, 'S', Items.stick, 'L', Items.leather});
        this.addRecipe(new ItemStack(ShopKeeper.machinaWaterwheel), new Object[]{" XXX ","XIIIX","XIAIX","XIIIX"," XXX ", 'X', Blocks.wooden_slab, 'I', Items.stick, 'A', ShopKeeper.machinaAxle});
        this.addRecipe(new ItemStack(ShopKeeper.machinaFruitPress), new Object[]{" A ","SAS","XXX","XXX", 'X', Blocks.planks, 'A', ShopKeeper.machinaAxle, 'S', Blocks.wooden_slab});
        this.addRecipe(new ItemStack(ShopKeeper.machinaFruitPress), new Object[]{" A ","SAS","XXX","XXX", 'X', ShopKeeper.acePlanks, 'A', ShopKeeper.machinaAxle, 'S', Blocks.wooden_slab});
        this.addRecipe(new ItemStack(ShopKeeper.machinaMillstone), new Object[]{" A "," AS","XXX","XXX", 'X', Blocks.planks, 'A', ShopKeeper.machinaAxle, 'S', Blocks.stone});
        this.addRecipe(new ItemStack(ShopKeeper.machinaMillstone), new Object[]{" A "," AS","XXX","XXX", 'X', ShopKeeper.acePlanks, 'A', ShopKeeper.machinaAxle, 'S', Blocks.stone});
        this.addRecipe(new ItemStack(ShopKeeper.machinaDistilleryIdle), new Object[]{"BI","WF",'B', ShopKeeper.blockCopper, 'I', ShopKeeper.ingotCopper, 'W', Blocks.planks, 'F', Blocks.furnace});
        this.addRecipe(new ItemStack(ShopKeeper.machinaDistilleryIdle), new Object[]{"BI","WF",'B', ShopKeeper.blockCopper, 'I', ShopKeeper.ingotCopper, 'W', ShopKeeper.acePlanks, 'F', Blocks.furnace});
        this.addRecipe(new ItemStack(ShopKeeper.machinaPodium),       new Object[]{" S ","ISI","SSS",'S', Blocks.stonebrick, 'I', Items.iron_ingot});
        this.addRecipe(new ItemStack(ShopKeeper.machinaGenerator),       new Object[]{" SSS ", "ASISC", " SSS ", 'S', Blocks.wooden_slab, 'A', ShopKeeper.machinaAxle, 'I', Items.iron_ingot, 'C', ShopKeeper.machinaCable});
        this.addRecipe(new ItemStack(ShopKeeper.machinaMotor),       new Object[]{" SSS ", "CSISA", " SSS ", 'S', Blocks.stone_slab, 'C', ShopKeeper.machinaCable, 'I', Items.iron_ingot, 'A', ShopKeeper.machinaAxle});
        this.addRecipe(new ItemStack(ShopKeeper.scaffoldingOak,36),    new Object[]{"XXXX","X XX","XX X","XXXX", 'X', new ItemStack(Blocks.planks,1,0)});
        this.addRecipe(new ItemStack(ShopKeeper.scaffoldingSpruce,36), new Object[]{"XXXX","X XX","XX X","XXXX", 'X', new ItemStack(Blocks.planks,1,1)});
        this.addRecipe(new ItemStack(ShopKeeper.scaffoldingBirch,36),  new Object[]{"XXXX","X XX","XX X","XXXX", 'X', new ItemStack(Blocks.planks,1,2)});
        this.addRecipe(new ItemStack(ShopKeeper.scaffoldingJungle,36), new Object[]{"XXXX","X XX","XX X","XXXX", 'X', new ItemStack(Blocks.planks,1,3)});
        this.addRecipe(new ItemStack(ShopKeeper.scaffoldingAcacia,36), new Object[]{"XXXX","X XX","XX X","XXXX", 'X', new ItemStack(Blocks.planks,1,4)});
        this.addRecipe(new ItemStack(ShopKeeper.scaffoldingBigOak,36), new Object[]{"XXXX","X XX","XX X","XXXX", 'X', new ItemStack(Blocks.planks,1,5)});
        this.addRecipe(new ItemStack(ShopKeeper.scaffoldingFruit,36),    new Object[]{"XXXX","X XX","XX X","XXXX", 'X', new ItemStack(ShopKeeper.acePlanks,1,0)});
        this.addRecipe(new ItemStack(ShopKeeper.scaffoldingGolden,36),    new Object[]{"XXXX","X XX","XX X","XXXX", 'X', new ItemStack(ShopKeeper.acePlanks,1,1)});
        this.addRecipe(new ItemStack(ShopKeeper.scaffoldingPalm,36),    new Object[]{"XXXX","X XX","XX X","XXXX", 'X', new ItemStack(ShopKeeper.acePlanks,1,2)});
        this.addRecipe(new ItemStack(ShopKeeper.minoBlank), new Object[]{"XQX", "Q Q", "XQX", 'X', ShopKeeper.scaffoldingAdamantium, 'Q', Items.quartz});
        this.addRecipe(new ItemStack(ShopKeeper.minoBlank), new Object[]{"XQX", "Q Q", "XQX", 'X', ShopKeeper.scaffoldingAluminium,  'Q', Items.quartz});
        this.addRecipe(new ItemStack(ShopKeeper.minoBlank), new Object[]{"XQX", "Q Q", "XQX", 'X', ShopKeeper.scaffoldingBronze,     'Q', Items.quartz});
        this.addRecipe(new ItemStack(ShopKeeper.minoBlank), new Object[]{"XQX", "Q Q", "XQX", 'X', ShopKeeper.scaffoldingCopper,     'Q', Items.quartz});
        this.addRecipe(new ItemStack(ShopKeeper.minoBlank), new Object[]{"XQX", "Q Q", "XQX", 'X', ShopKeeper.scaffoldingIron,       'Q', Items.quartz});
        this.addRecipe(new ItemStack(ShopKeeper.minoBlank), new Object[]{"XQX", "Q Q", "XQX", 'X', ShopKeeper.scaffoldingMythril,    'Q', Items.quartz});
        this.addRecipe(new ItemStack(ShopKeeper.minoBlank), new Object[]{"XQX", "Q Q", "XQX", 'X', ShopKeeper.scaffoldingSteel,      'Q', Items.quartz});
        this.addRecipe(new ItemStack(ShopKeeper.minoBlank), new Object[]{"XQX", "Q Q", "XQX", 'X', ShopKeeper.scaffoldingUnobtanium, 'Q', Items.quartz});
        this.addRecipe(new ItemStack(ShopKeeper.minoFire), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingAdamantium, 'Q', Items.quartz, 'G', ShopKeeper.gemstoneRuby});
        this.addRecipe(new ItemStack(ShopKeeper.minoFire), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingAluminium,  'Q', Items.quartz, 'G', ShopKeeper.gemstoneRuby});
        this.addRecipe(new ItemStack(ShopKeeper.minoFire), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingBronze,     'Q', Items.quartz, 'G', ShopKeeper.gemstoneRuby});
        this.addRecipe(new ItemStack(ShopKeeper.minoFire), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingCopper,     'Q', Items.quartz, 'G', ShopKeeper.gemstoneRuby});
        this.addRecipe(new ItemStack(ShopKeeper.minoFire), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingIron,       'Q', Items.quartz, 'G', ShopKeeper.gemstoneRuby});
        this.addRecipe(new ItemStack(ShopKeeper.minoFire), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingMythril,    'Q', Items.quartz, 'G', ShopKeeper.gemstoneRuby});
        this.addRecipe(new ItemStack(ShopKeeper.minoFire), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingSteel,      'Q', Items.quartz, 'G', ShopKeeper.gemstoneRuby});
        this.addRecipe(new ItemStack(ShopKeeper.minoFire), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingUnobtanium, 'Q', Items.quartz, 'G', ShopKeeper.gemstoneRuby});
        this.addRecipe(new ItemStack(ShopKeeper.minoAir), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingAdamantium, 'Q', Items.quartz, 'G', ShopKeeper.gemstonePeridot});
        this.addRecipe(new ItemStack(ShopKeeper.minoAir), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingAluminium,  'Q', Items.quartz, 'G', ShopKeeper.gemstonePeridot});
        this.addRecipe(new ItemStack(ShopKeeper.minoAir), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingBronze,     'Q', Items.quartz, 'G', ShopKeeper.gemstonePeridot});
        this.addRecipe(new ItemStack(ShopKeeper.minoAir), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingCopper,     'Q', Items.quartz, 'G', ShopKeeper.gemstonePeridot});
        this.addRecipe(new ItemStack(ShopKeeper.minoAir), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingIron,       'Q', Items.quartz, 'G', ShopKeeper.gemstonePeridot});
        this.addRecipe(new ItemStack(ShopKeeper.minoAir), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingMythril,    'Q', Items.quartz, 'G', ShopKeeper.gemstonePeridot});
        this.addRecipe(new ItemStack(ShopKeeper.minoAir), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingSteel,      'Q', Items.quartz, 'G', ShopKeeper.gemstonePeridot});
        this.addRecipe(new ItemStack(ShopKeeper.minoAir), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingUnobtanium, 'Q', Items.quartz, 'G', ShopKeeper.gemstonePeridot});
        this.addRecipe(new ItemStack(ShopKeeper.minoThunder), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingAdamantium, 'Q', Items.quartz, 'G', ShopKeeper.gemstoneTopaz});
        this.addRecipe(new ItemStack(ShopKeeper.minoThunder), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingAluminium,  'Q', Items.quartz, 'G', ShopKeeper.gemstoneTopaz});
        this.addRecipe(new ItemStack(ShopKeeper.minoThunder), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingBronze,     'Q', Items.quartz, 'G', ShopKeeper.gemstoneTopaz});
        this.addRecipe(new ItemStack(ShopKeeper.minoThunder), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingCopper,     'Q', Items.quartz, 'G', ShopKeeper.gemstoneTopaz});
        this.addRecipe(new ItemStack(ShopKeeper.minoThunder), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingIron,       'Q', Items.quartz, 'G', ShopKeeper.gemstoneTopaz});
        this.addRecipe(new ItemStack(ShopKeeper.minoThunder), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingMythril,    'Q', Items.quartz, 'G', ShopKeeper.gemstoneTopaz});
        this.addRecipe(new ItemStack(ShopKeeper.minoThunder), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingSteel,      'Q', Items.quartz, 'G', ShopKeeper.gemstoneTopaz});
        this.addRecipe(new ItemStack(ShopKeeper.minoThunder), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingUnobtanium, 'Q', Items.quartz, 'G', ShopKeeper.gemstoneTopaz});
        this.addRecipe(new ItemStack(ShopKeeper.minoWater), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingAdamantium, 'Q', Items.quartz, 'G', ShopKeeper.gemstoneSaphire});
        this.addRecipe(new ItemStack(ShopKeeper.minoWater), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingAluminium,  'Q', Items.quartz, 'G', ShopKeeper.gemstoneSaphire});
        this.addRecipe(new ItemStack(ShopKeeper.minoWater), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingBronze,     'Q', Items.quartz, 'G', ShopKeeper.gemstoneSaphire});
        this.addRecipe(new ItemStack(ShopKeeper.minoWater), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingCopper,     'Q', Items.quartz, 'G', ShopKeeper.gemstoneSaphire});
        this.addRecipe(new ItemStack(ShopKeeper.minoWater), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingIron,       'Q', Items.quartz, 'G', ShopKeeper.gemstoneSaphire});
        this.addRecipe(new ItemStack(ShopKeeper.minoWater), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingMythril,    'Q', Items.quartz, 'G', ShopKeeper.gemstoneSaphire});
        this.addRecipe(new ItemStack(ShopKeeper.minoWater), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingSteel,      'Q', Items.quartz, 'G', ShopKeeper.gemstoneSaphire});
        this.addRecipe(new ItemStack(ShopKeeper.minoWater), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingUnobtanium, 'Q', Items.quartz, 'G', ShopKeeper.gemstoneSaphire});
        this.addRecipe(new ItemStack(ShopKeeper.minoIce), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingAdamantium, 'Q', Items.quartz, 'G', ShopKeeper.gemstoneAzurit});
        this.addRecipe(new ItemStack(ShopKeeper.minoIce), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingAluminium,  'Q', Items.quartz, 'G', ShopKeeper.gemstoneAzurit});
        this.addRecipe(new ItemStack(ShopKeeper.minoIce), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingBronze,     'Q', Items.quartz, 'G', ShopKeeper.gemstoneAzurit});
        this.addRecipe(new ItemStack(ShopKeeper.minoIce), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingCopper,     'Q', Items.quartz, 'G', ShopKeeper.gemstoneAzurit});
        this.addRecipe(new ItemStack(ShopKeeper.minoIce), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingIron,       'Q', Items.quartz, 'G', ShopKeeper.gemstoneAzurit});
        this.addRecipe(new ItemStack(ShopKeeper.minoIce), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingMythril,    'Q', Items.quartz, 'G', ShopKeeper.gemstoneAzurit});
        this.addRecipe(new ItemStack(ShopKeeper.minoIce), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingSteel,      'Q', Items.quartz, 'G', ShopKeeper.gemstoneAzurit});
        this.addRecipe(new ItemStack(ShopKeeper.minoIce), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingUnobtanium, 'Q', Items.quartz, 'G', ShopKeeper.gemstoneAzurit});
        this.addRecipe(new ItemStack(ShopKeeper.minoEarth), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingAdamantium, 'Q', Items.quartz, 'G', ShopKeeper.gemstoneAmber});
        this.addRecipe(new ItemStack(ShopKeeper.minoEarth), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingAluminium,  'Q', Items.quartz, 'G', ShopKeeper.gemstoneAmber});
        this.addRecipe(new ItemStack(ShopKeeper.minoEarth), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingBronze,     'Q', Items.quartz, 'G', ShopKeeper.gemstoneAmber});
        this.addRecipe(new ItemStack(ShopKeeper.minoEarth), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingCopper,     'Q', Items.quartz, 'G', ShopKeeper.gemstoneAmber});
        this.addRecipe(new ItemStack(ShopKeeper.minoEarth), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingIron,       'Q', Items.quartz, 'G', ShopKeeper.gemstoneAmber});
        this.addRecipe(new ItemStack(ShopKeeper.minoEarth), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingMythril,    'Q', Items.quartz, 'G', ShopKeeper.gemstoneAmber});
        this.addRecipe(new ItemStack(ShopKeeper.minoEarth), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingSteel,      'Q', Items.quartz, 'G', ShopKeeper.gemstoneAmber});
        this.addRecipe(new ItemStack(ShopKeeper.minoEarth), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingUnobtanium, 'Q', Items.quartz, 'G', ShopKeeper.gemstoneAmber});
        this.addRecipe(new ItemStack(ShopKeeper.minoMetal), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingAdamantium, 'Q', Items.quartz, 'G', ShopKeeper.gemstoneAmethyst});
        this.addRecipe(new ItemStack(ShopKeeper.minoMetal), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingAluminium,  'Q', Items.quartz, 'G', ShopKeeper.gemstoneAmethyst});
        this.addRecipe(new ItemStack(ShopKeeper.minoMetal), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingBronze,     'Q', Items.quartz, 'G', ShopKeeper.gemstoneAmethyst});
        this.addRecipe(new ItemStack(ShopKeeper.minoMetal), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingCopper,     'Q', Items.quartz, 'G', ShopKeeper.gemstoneAmethyst});
        this.addRecipe(new ItemStack(ShopKeeper.minoMetal), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingIron,       'Q', Items.quartz, 'G', ShopKeeper.gemstoneAmethyst});
        this.addRecipe(new ItemStack(ShopKeeper.minoMetal), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingMythril,    'Q', Items.quartz, 'G', ShopKeeper.gemstoneAmethyst});
        this.addRecipe(new ItemStack(ShopKeeper.minoMetal), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingSteel,      'Q', Items.quartz, 'G', ShopKeeper.gemstoneAmethyst});
        this.addRecipe(new ItemStack(ShopKeeper.minoMetal), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingUnobtanium, 'Q', Items.quartz, 'G', ShopKeeper.gemstoneAmethyst});
        this.addRecipe(new ItemStack(ShopKeeper.minoNature), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingAdamantium, 'Q', Items.quartz, 'G', Items.emerald});
        this.addRecipe(new ItemStack(ShopKeeper.minoNature), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingAluminium,  'Q', Items.quartz, 'G', Items.emerald});
        this.addRecipe(new ItemStack(ShopKeeper.minoNature), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingBronze,     'Q', Items.quartz, 'G', Items.emerald});
        this.addRecipe(new ItemStack(ShopKeeper.minoNature), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingCopper,     'Q', Items.quartz, 'G', Items.emerald});
        this.addRecipe(new ItemStack(ShopKeeper.minoNature), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingIron,       'Q', Items.quartz, 'G', Items.emerald});
        this.addRecipe(new ItemStack(ShopKeeper.minoNature), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingMythril,    'Q', Items.quartz, 'G', Items.emerald});
        this.addRecipe(new ItemStack(ShopKeeper.minoNature), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingSteel,      'Q', Items.quartz, 'G', Items.emerald});
        this.addRecipe(new ItemStack(ShopKeeper.minoNature), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingUnobtanium, 'Q', Items.quartz, 'G', Items.emerald});
        this.addRecipe(new ItemStack(ShopKeeper.minoLight), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingAdamantium, 'Q', Items.quartz, 'G', Items.diamond});
        this.addRecipe(new ItemStack(ShopKeeper.minoLight), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingAluminium,  'Q', Items.quartz, 'G', Items.diamond});
        this.addRecipe(new ItemStack(ShopKeeper.minoLight), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingBronze,     'Q', Items.quartz, 'G', Items.diamond});
        this.addRecipe(new ItemStack(ShopKeeper.minoLight), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingCopper,     'Q', Items.quartz, 'G', Items.diamond});
        this.addRecipe(new ItemStack(ShopKeeper.minoLight), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingIron,       'Q', Items.quartz, 'G', Items.diamond});
        this.addRecipe(new ItemStack(ShopKeeper.minoLight), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingMythril,    'Q', Items.quartz, 'G', Items.diamond});
        this.addRecipe(new ItemStack(ShopKeeper.minoLight), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingSteel,      'Q', Items.quartz, 'G', Items.diamond});
        this.addRecipe(new ItemStack(ShopKeeper.minoLight), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingUnobtanium, 'Q', Items.quartz, 'G', Items.diamond});
        this.addRecipe(new ItemStack(ShopKeeper.minoDark), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingAdamantium, 'Q', Items.quartz, 'G', ShopKeeper.gemstoneGagat});
        this.addRecipe(new ItemStack(ShopKeeper.minoDark), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingAluminium,  'Q', Items.quartz, 'G', ShopKeeper.gemstoneGagat});
        this.addRecipe(new ItemStack(ShopKeeper.minoDark), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingBronze,     'Q', Items.quartz, 'G', ShopKeeper.gemstoneGagat});
        this.addRecipe(new ItemStack(ShopKeeper.minoDark), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingCopper,     'Q', Items.quartz, 'G', ShopKeeper.gemstoneGagat});
        this.addRecipe(new ItemStack(ShopKeeper.minoDark), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingIron,       'Q', Items.quartz, 'G', ShopKeeper.gemstoneGagat});
        this.addRecipe(new ItemStack(ShopKeeper.minoDark), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingMythril,    'Q', Items.quartz, 'G', ShopKeeper.gemstoneGagat});
        this.addRecipe(new ItemStack(ShopKeeper.minoDark), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingSteel,      'Q', Items.quartz, 'G', ShopKeeper.gemstoneGagat});
        this.addRecipe(new ItemStack(ShopKeeper.minoDark), new Object[]{"XQX", "QGQ", "XQX", 'X', ShopKeeper.scaffoldingUnobtanium, 'Q', Items.quartz, 'G', ShopKeeper.gemstoneGagat});
        this.addRecipe(new ItemStack(ShopKeeper.stuffGear), new Object[]{" X ","XOX"," X ",'X', Blocks.wooden_button, 'O', Blocks.planks});
        this.addRecipe(new ItemStack(ShopKeeper.stuffGear), new Object[]{" X ","XOX"," X ",'X', Blocks.wooden_button, 'O', ShopKeeper.acePlanks});
        this.addRecipe(new ItemStack(ShopKeeper.stuffRope, 8), new Object[]{"XX","XX","XX","XX",'X', ShopKeeper.stuffHemp});
        this.addRecipe(new ItemStack(Items.flint), new Object[]{"OO","OO",'O',Blocks.gravel});
        this.addRecipe(new ItemStack(ShopKeeper.stuffClothLinen, 3), new Object[]{"XXX","XXX","XXX",'X', ShopKeeper.stuffHemp});
        this.addRecipe(new ItemStack(ShopKeeper.stuffClothWool,  3), new Object[]{"XXX","XXX","XXX",'X', Blocks.wool});
        this.addRecipe(new ItemStack(ShopKeeper.stuffClothSilk,  1), new Object[]{"XXX","XXX","XXX",'X', Items.string});
        this.addRecipe(new ItemStack(ShopKeeper.roofAcaciaStraw,                3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,4),        'I', Items.wheat               });
        this.addRecipe(new ItemStack(ShopKeeper.roofAcaciaReeds,                3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,4),        'I', Items.reeds               });
        this.addRecipe(new ItemStack(ShopKeeper.roofAcaciaClay,                 3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,4),        'I', Items.brick               });
        this.addRecipe(new ItemStack(ShopKeeper.roofAcaciaCopper,               3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,4),        'I', ShopKeeper.ingotCopper    });
        this.addRecipe(new ItemStack(ShopKeeper.roofAcaciaTin,                  3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,4),        'I', ShopKeeper.ingotTin       });
        this.addRecipe(new ItemStack(ShopKeeper.roofAcaciaBrass,                3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,4),        'I', ShopKeeper.ingotBrass     });
        this.addRecipe(new ItemStack(ShopKeeper.roofAcaciaGold,                 3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,4),        'I', Items.gold_ingot          });
        this.addRecipe(new ItemStack(ShopKeeper.roofAcaciaMythril,              3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,4),        'I', ShopKeeper.ingotMythril   });
        this.addRecipe(new ItemStack(ShopKeeper.roofAcaciaOrichalcum,           3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,4),        'I', ShopKeeper.ingotOrichalcum});
        this.addRecipe(new ItemStack(ShopKeeper.roofAcaciaNether,               3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,4),        'I', Items.netherbrick         });
        this.addRecipe(new ItemStack(ShopKeeper.roofBigOakStraw,                3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,5),        'I', Items.wheat               });
        this.addRecipe(new ItemStack(ShopKeeper.roofBigOakReeds,                3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,5),        'I', Items.reeds               });
        this.addRecipe(new ItemStack(ShopKeeper.roofBigOakClay,                 3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,5),        'I', Items.brick               });
        this.addRecipe(new ItemStack(ShopKeeper.roofBigOakCopper,               3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,5),        'I', ShopKeeper.ingotCopper    });
        this.addRecipe(new ItemStack(ShopKeeper.roofBigOakTin,                  3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,5),        'I', ShopKeeper.ingotTin       });
        this.addRecipe(new ItemStack(ShopKeeper.roofBigOakBrass,                3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,5),        'I', ShopKeeper.ingotBrass     });
        this.addRecipe(new ItemStack(ShopKeeper.roofBigOakGold,                 3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,5),        'I', Items.gold_ingot          });
        this.addRecipe(new ItemStack(ShopKeeper.roofBigOakMythril,              3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,5),        'I', ShopKeeper.ingotMythril   });
        this.addRecipe(new ItemStack(ShopKeeper.roofBigOakOrichalcum,           3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,5),        'I', ShopKeeper.ingotOrichalcum});
        this.addRecipe(new ItemStack(ShopKeeper.roofBigOakNether,               3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,5),        'I', Items.netherbrick         });
        this.addRecipe(new ItemStack(ShopKeeper.roofBirchStraw,                 3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,2),        'I', Items.wheat               });
        this.addRecipe(new ItemStack(ShopKeeper.roofBirchReeds,                 3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,2),        'I', Items.reeds               });
        this.addRecipe(new ItemStack(ShopKeeper.roofBirchClay,                  3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,2),        'I', Items.brick               });
        this.addRecipe(new ItemStack(ShopKeeper.roofBirchCopper,                3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,2),        'I', ShopKeeper.ingotCopper    });
        this.addRecipe(new ItemStack(ShopKeeper.roofBirchTin,                   3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,2),        'I', ShopKeeper.ingotTin       });
        this.addRecipe(new ItemStack(ShopKeeper.roofBirchBrass,                 3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,2),        'I', ShopKeeper.ingotBrass     });
        this.addRecipe(new ItemStack(ShopKeeper.roofBirchGold,                  3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,2),        'I', Items.gold_ingot          });
        this.addRecipe(new ItemStack(ShopKeeper.roofBirchMythril,               3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,2),        'I', ShopKeeper.ingotMythril   });
        this.addRecipe(new ItemStack(ShopKeeper.roofBirchOrichalcum,            3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,2),        'I', ShopKeeper.ingotOrichalcum});
        this.addRecipe(new ItemStack(ShopKeeper.roofBirchNether,                3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,2),        'I', Items.netherbrick         });
        this.addRecipe(new ItemStack(ShopKeeper.roofJungleStraw,                3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,3),        'I', Items.wheat               });
        this.addRecipe(new ItemStack(ShopKeeper.roofJungleReeds,                3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,3),        'I', Items.reeds               });
        this.addRecipe(new ItemStack(ShopKeeper.roofJungleClay,                 3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,3),        'I', Items.brick               });
        this.addRecipe(new ItemStack(ShopKeeper.roofJungleCopper,               3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,3),        'I', ShopKeeper.ingotCopper    });
        this.addRecipe(new ItemStack(ShopKeeper.roofJungleTin,                  3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,3),        'I', ShopKeeper.ingotTin       });
        this.addRecipe(new ItemStack(ShopKeeper.roofJungleBrass,                3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,3),        'I', ShopKeeper.ingotBrass     });
        this.addRecipe(new ItemStack(ShopKeeper.roofJungleGold,                 3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,3),        'I', Items.gold_ingot          });
        this.addRecipe(new ItemStack(ShopKeeper.roofJungleMythril,              3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,3),        'I', ShopKeeper.ingotMythril   });
        this.addRecipe(new ItemStack(ShopKeeper.roofJungleOrichalcum,           3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,3),        'I', ShopKeeper.ingotOrichalcum});
        this.addRecipe(new ItemStack(ShopKeeper.roofJungleNether,               3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,3),        'I', Items.netherbrick         });
        this.addRecipe(new ItemStack(ShopKeeper.roofOakStraw,                   3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,0),        'I', Items.wheat               });
        this.addRecipe(new ItemStack(ShopKeeper.roofOakReeds,                   3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,0),        'I', Items.reeds               });
        this.addRecipe(new ItemStack(ShopKeeper.roofOakClay,                    3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,0),        'I', Items.brick               });
        this.addRecipe(new ItemStack(ShopKeeper.roofOakCopper,                  3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,0),        'I', ShopKeeper.ingotCopper    });
        this.addRecipe(new ItemStack(ShopKeeper.roofOakTin,                     3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,0),        'I', ShopKeeper.ingotTin       });
        this.addRecipe(new ItemStack(ShopKeeper.roofOakBrass,                   3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,0),        'I', ShopKeeper.ingotBrass     });
        this.addRecipe(new ItemStack(ShopKeeper.roofOakGold,                    3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,0),        'I', Items.gold_ingot          });
        this.addRecipe(new ItemStack(ShopKeeper.roofOakMythril,                 3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,0),        'I', ShopKeeper.ingotMythril   });
        this.addRecipe(new ItemStack(ShopKeeper.roofOakOrichalcum,              3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,0),        'I', ShopKeeper.ingotOrichalcum});
        this.addRecipe(new ItemStack(ShopKeeper.roofOakNether,                  3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,0),        'I', Items.netherbrick         });
        this.addRecipe(new ItemStack(ShopKeeper.roofSpruceStraw,                3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,1),        'I', Items.wheat               });
        this.addRecipe(new ItemStack(ShopKeeper.roofSpruceReeds,                3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,1),        'I', Items.reeds               });
        this.addRecipe(new ItemStack(ShopKeeper.roofSpruceClay,                 3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,1),        'I', Items.brick               });
        this.addRecipe(new ItemStack(ShopKeeper.roofSpruceCopper,               3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,1),        'I', ShopKeeper.ingotCopper    });
        this.addRecipe(new ItemStack(ShopKeeper.roofSpruceTin,                  3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,1),        'I', ShopKeeper.ingotTin       });
        this.addRecipe(new ItemStack(ShopKeeper.roofSpruceBrass,                3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,1),        'I', ShopKeeper.ingotBrass     });
        this.addRecipe(new ItemStack(ShopKeeper.roofSpruceGold,                 3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,1),        'I', Items.gold_ingot          });
        this.addRecipe(new ItemStack(ShopKeeper.roofSpruceMythril,              3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,1),        'I', ShopKeeper.ingotMythril   });
        this.addRecipe(new ItemStack(ShopKeeper.roofSpruceOrichalcum,           3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,1),        'I', ShopKeeper.ingotOrichalcum});
        this.addRecipe(new ItemStack(ShopKeeper.roofSpruceNether,               3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.planks,1,1),        'I', Items.netherbrick         });
        this.addRecipe(new ItemStack(ShopKeeper.roofFruitStraw,                 3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(ShopKeeper.acePlanks,1,0), 'I', Items.wheat               });
        this.addRecipe(new ItemStack(ShopKeeper.roofFruitReeds,                 3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(ShopKeeper.acePlanks,1,0), 'I', Items.reeds               });
        this.addRecipe(new ItemStack(ShopKeeper.roofFruitClay,                  3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(ShopKeeper.acePlanks,1,0), 'I', Items.brick               });
        this.addRecipe(new ItemStack(ShopKeeper.roofFruitCopper,                3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(ShopKeeper.acePlanks,1,0), 'I', ShopKeeper.ingotCopper    });
        this.addRecipe(new ItemStack(ShopKeeper.roofFruitTin,                   3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(ShopKeeper.acePlanks,1,0), 'I', ShopKeeper.ingotTin       });
        this.addRecipe(new ItemStack(ShopKeeper.roofFruitBrass,                 3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(ShopKeeper.acePlanks,1,0), 'I', ShopKeeper.ingotBrass     });
        this.addRecipe(new ItemStack(ShopKeeper.roofFruitGold,                  3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(ShopKeeper.acePlanks,1,0), 'I', Items.gold_ingot          });
        this.addRecipe(new ItemStack(ShopKeeper.roofFruitMythril,               3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(ShopKeeper.acePlanks,1,0), 'I', ShopKeeper.ingotMythril   });
        this.addRecipe(new ItemStack(ShopKeeper.roofFruitOrichalcum,            3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(ShopKeeper.acePlanks,1,0), 'I', ShopKeeper.ingotOrichalcum});
        this.addRecipe(new ItemStack(ShopKeeper.roofFruitNether,                3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(ShopKeeper.acePlanks,1,0), 'I', Items.netherbrick         });
        this.addRecipe(new ItemStack(ShopKeeper.roofGoldenStraw,                3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(ShopKeeper.acePlanks,1,1), 'I', Items.wheat               });
        this.addRecipe(new ItemStack(ShopKeeper.roofGoldenReeds,                3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(ShopKeeper.acePlanks,1,1), 'I', Items.reeds               });
        this.addRecipe(new ItemStack(ShopKeeper.roofGoldenClay,                 3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(ShopKeeper.acePlanks,1,1), 'I', Items.brick               });
        this.addRecipe(new ItemStack(ShopKeeper.roofGoldenCopper,               3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(ShopKeeper.acePlanks,1,1), 'I', ShopKeeper.ingotCopper    });
        this.addRecipe(new ItemStack(ShopKeeper.roofGoldenTin,                  3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(ShopKeeper.acePlanks,1,1), 'I', ShopKeeper.ingotTin       });
        this.addRecipe(new ItemStack(ShopKeeper.roofGoldenBrass,                3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(ShopKeeper.acePlanks,1,1), 'I', ShopKeeper.ingotBrass     });
        this.addRecipe(new ItemStack(ShopKeeper.roofGoldenGold,                 3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(ShopKeeper.acePlanks,1,1), 'I', Items.gold_ingot          });
        this.addRecipe(new ItemStack(ShopKeeper.roofGoldenMythril,              3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(ShopKeeper.acePlanks,1,1), 'I', ShopKeeper.ingotMythril   });
        this.addRecipe(new ItemStack(ShopKeeper.roofGoldenOrichalcum,           3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(ShopKeeper.acePlanks,1,1), 'I', ShopKeeper.ingotOrichalcum});
        this.addRecipe(new ItemStack(ShopKeeper.roofGoldenNether,               3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(ShopKeeper.acePlanks,1,1), 'I', Items.netherbrick         });
        this.addRecipe(new ItemStack(ShopKeeper.roofPalmStraw,                  3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(ShopKeeper.acePlanks,1,2), 'I', Items.wheat               });
        this.addRecipe(new ItemStack(ShopKeeper.roofPalmReeds,                  3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(ShopKeeper.acePlanks,1,2), 'I', Items.reeds               });
        this.addRecipe(new ItemStack(ShopKeeper.roofPalmClay,                   3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(ShopKeeper.acePlanks,1,2), 'I', Items.brick               });
        this.addRecipe(new ItemStack(ShopKeeper.roofPalmCopper,                 3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(ShopKeeper.acePlanks,1,2), 'I', ShopKeeper.ingotCopper    });
        this.addRecipe(new ItemStack(ShopKeeper.roofPalmTin,                    3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(ShopKeeper.acePlanks,1,2), 'I', ShopKeeper.ingotTin       });
        this.addRecipe(new ItemStack(ShopKeeper.roofPalmBrass,                  3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(ShopKeeper.acePlanks,1,2), 'I', ShopKeeper.ingotBrass     });
        this.addRecipe(new ItemStack(ShopKeeper.roofPalmGold,                   3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(ShopKeeper.acePlanks,1,2), 'I', Items.gold_ingot          });
        this.addRecipe(new ItemStack(ShopKeeper.roofPalmMythril,                3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(ShopKeeper.acePlanks,1,2), 'I', ShopKeeper.ingotMythril   });
        this.addRecipe(new ItemStack(ShopKeeper.roofPalmOrichalcum,             3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(ShopKeeper.acePlanks,1,2), 'I', ShopKeeper.ingotOrichalcum});
        this.addRecipe(new ItemStack(ShopKeeper.roofPalmNether,                 3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(ShopKeeper.acePlanks,1,2), 'I', Items.netherbrick         });
        this.addRecipe(new ItemStack(ShopKeeper.roofBrickStraw,                 3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.brick_block,                      'I', Items.wheat               });
        this.addRecipe(new ItemStack(ShopKeeper.roofBrickReeds,                 3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.brick_block,                      'I', Items.reeds               });
        this.addRecipe(new ItemStack(ShopKeeper.roofBrickClay,                  3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.brick_block,                      'I', Items.brick               });
        this.addRecipe(new ItemStack(ShopKeeper.roofBrickCopper,                3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.brick_block,                      'I', ShopKeeper.ingotCopper    });
        this.addRecipe(new ItemStack(ShopKeeper.roofBrickTin,                   3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.brick_block,                      'I', ShopKeeper.ingotTin       });
        this.addRecipe(new ItemStack(ShopKeeper.roofBrickBrass,                 3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.brick_block,                      'I', ShopKeeper.ingotBrass     });
        this.addRecipe(new ItemStack(ShopKeeper.roofBrickGold,                  3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.brick_block,                      'I', Items.gold_ingot          });
        this.addRecipe(new ItemStack(ShopKeeper.roofBrickMythril,               3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.brick_block,                      'I', ShopKeeper.ingotMythril   });
        this.addRecipe(new ItemStack(ShopKeeper.roofBrickOrichalcum,            3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.brick_block,                      'I', ShopKeeper.ingotOrichalcum});
        this.addRecipe(new ItemStack(ShopKeeper.roofBrickNether,                3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.brick_block,                      'I', Items.netherbrick         });
        this.addRecipe(new ItemStack(ShopKeeper.roofCobblestoneStraw,           3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.cobblestone,                      'I', Items.wheat               });
        this.addRecipe(new ItemStack(ShopKeeper.roofCobblestoneReeds,           3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.cobblestone,                      'I', Items.reeds               });
        this.addRecipe(new ItemStack(ShopKeeper.roofCobblestoneClay,            3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.cobblestone,                      'I', Items.brick               });
        this.addRecipe(new ItemStack(ShopKeeper.roofCobblestoneCopper,          3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.cobblestone,                      'I', ShopKeeper.ingotCopper    });
        this.addRecipe(new ItemStack(ShopKeeper.roofCobblestoneTin,             3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.cobblestone,                      'I', ShopKeeper.ingotTin       });
        this.addRecipe(new ItemStack(ShopKeeper.roofCobblestoneBrass,           3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.cobblestone,                      'I', ShopKeeper.ingotBrass     });
        this.addRecipe(new ItemStack(ShopKeeper.roofCobblestoneGold,            3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.cobblestone,                      'I', Items.gold_ingot          });
        this.addRecipe(new ItemStack(ShopKeeper.roofCobblestoneMythril,         3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.cobblestone,                      'I', ShopKeeper.ingotMythril   });
        this.addRecipe(new ItemStack(ShopKeeper.roofCobblestoneOrichalcum,      3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.cobblestone,                      'I', ShopKeeper.ingotOrichalcum});
        this.addRecipe(new ItemStack(ShopKeeper.roofCobblestoneNether,          3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.cobblestone,                      'I', Items.netherbrick         });
        this.addRecipe(new ItemStack(ShopKeeper.roofCobblestoneMossyStraw,      3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.mossy_cobblestone,                'I', Items.wheat               });
        this.addRecipe(new ItemStack(ShopKeeper.roofCobblestoneMossyReeds,      3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.mossy_cobblestone,                'I', Items.reeds               });
        this.addRecipe(new ItemStack(ShopKeeper.roofCobblestoneMossyClay,       3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.mossy_cobblestone,                'I', Items.brick               });
        this.addRecipe(new ItemStack(ShopKeeper.roofCobblestoneMossyCopper,     3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.mossy_cobblestone,                'I', ShopKeeper.ingotCopper    });
        this.addRecipe(new ItemStack(ShopKeeper.roofCobblestoneMossyTin,        3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.mossy_cobblestone,                'I', ShopKeeper.ingotTin       });
        this.addRecipe(new ItemStack(ShopKeeper.roofCobblestoneMossyBrass,      3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.mossy_cobblestone,                'I', ShopKeeper.ingotBrass     });
        this.addRecipe(new ItemStack(ShopKeeper.roofCobblestoneMossyGold,       3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.mossy_cobblestone,                'I', Items.gold_ingot          });
        this.addRecipe(new ItemStack(ShopKeeper.roofCobblestoneMossyMythril,    3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.mossy_cobblestone,                'I', ShopKeeper.ingotMythril   });
        this.addRecipe(new ItemStack(ShopKeeper.roofCobblestoneMossyOrichalcum, 3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.mossy_cobblestone,                'I', ShopKeeper.ingotOrichalcum});
        this.addRecipe(new ItemStack(ShopKeeper.roofCobblestoneMossyNether,     3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.mossy_cobblestone,                'I', Items.netherbrick         });
        this.addRecipe(new ItemStack(ShopKeeper.roofStonebrickStraw,            3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.stonebrick,1,0),    'I', Items.wheat               });
        this.addRecipe(new ItemStack(ShopKeeper.roofStonebrickReeds,            3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.stonebrick,1,0),    'I', Items.reeds               });
        this.addRecipe(new ItemStack(ShopKeeper.roofStonebrickClay,             3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.stonebrick,1,0),    'I', Items.brick               });
        this.addRecipe(new ItemStack(ShopKeeper.roofStonebrickCopper,           3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.stonebrick,1,0),    'I', ShopKeeper.ingotCopper    });
        this.addRecipe(new ItemStack(ShopKeeper.roofStonebrickTin,              3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.stonebrick,1,0),    'I', ShopKeeper.ingotTin       });
        this.addRecipe(new ItemStack(ShopKeeper.roofStonebrickBrass,            3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.stonebrick,1,0),    'I', ShopKeeper.ingotBrass     });
        this.addRecipe(new ItemStack(ShopKeeper.roofStonebrickGold,             3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.stonebrick,1,0),    'I', Items.gold_ingot          });
        this.addRecipe(new ItemStack(ShopKeeper.roofStonebrickMythril,          3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.stonebrick,1,0),    'I', ShopKeeper.ingotMythril   });
        this.addRecipe(new ItemStack(ShopKeeper.roofStonebrickOrichalcum,       3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.stonebrick,1,0),    'I', ShopKeeper.ingotOrichalcum});
        this.addRecipe(new ItemStack(ShopKeeper.roofStonebrickNether,           3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.stonebrick,1,0),    'I', Items.netherbrick         });
        this.addRecipe(new ItemStack(ShopKeeper.roofStonebrickMossyStraw,       3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.stonebrick,1,1),    'I', Items.wheat               });
        this.addRecipe(new ItemStack(ShopKeeper.roofStonebrickMossyReeds,       3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.stonebrick,1,1),    'I', Items.reeds               });
        this.addRecipe(new ItemStack(ShopKeeper.roofStonebrickMossyClay,        3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.stonebrick,1,1),    'I', Items.brick               });
        this.addRecipe(new ItemStack(ShopKeeper.roofStonebrickMossyCopper,      3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.stonebrick,1,1),    'I', ShopKeeper.ingotCopper    });
        this.addRecipe(new ItemStack(ShopKeeper.roofStonebrickMossyTin,         3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.stonebrick,1,1),    'I', ShopKeeper.ingotTin       });
        this.addRecipe(new ItemStack(ShopKeeper.roofStonebrickMossyBrass,       3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.stonebrick,1,1),    'I', ShopKeeper.ingotBrass     });
        this.addRecipe(new ItemStack(ShopKeeper.roofStonebrickMossyGold,        3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.stonebrick,1,1),    'I', Items.gold_ingot          });
        this.addRecipe(new ItemStack(ShopKeeper.roofStonebrickMossyMythril,     3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.stonebrick,1,1),    'I', ShopKeeper.ingotMythril   });
        this.addRecipe(new ItemStack(ShopKeeper.roofStonebrickMossyOrichalcum,  3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.stonebrick,1,1),    'I', ShopKeeper.ingotOrichalcum});
        this.addRecipe(new ItemStack(ShopKeeper.roofStonebrickMossyNether,      3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', new ItemStack(Blocks.stonebrick,1,1),    'I', Items.netherbrick         });
        this.addRecipe(new ItemStack(ShopKeeper.roofSandstoneStraw,             3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.sandstone,                        'I', Items.wheat               });
        this.addRecipe(new ItemStack(ShopKeeper.roofSandstoneReeds,             3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.sandstone,                        'I', Items.reeds               });
        this.addRecipe(new ItemStack(ShopKeeper.roofSandstoneClay,              3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.sandstone,                        'I', Items.brick               });
        this.addRecipe(new ItemStack(ShopKeeper.roofSandstoneCopper,            3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.sandstone,                        'I', ShopKeeper.ingotCopper    });
        this.addRecipe(new ItemStack(ShopKeeper.roofSandstoneTin,               3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.sandstone,                        'I', ShopKeeper.ingotTin       });
        this.addRecipe(new ItemStack(ShopKeeper.roofSandstoneBrass,             3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.sandstone,                        'I', ShopKeeper.ingotBrass     });
        this.addRecipe(new ItemStack(ShopKeeper.roofSandstoneGold,              3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.sandstone,                        'I', Items.gold_ingot          });
        this.addRecipe(new ItemStack(ShopKeeper.roofSandstoneMythril,           3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.sandstone,                        'I', ShopKeeper.ingotMythril   });
        this.addRecipe(new ItemStack(ShopKeeper.roofSandstoneOrichalcum,        3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.sandstone,                        'I', ShopKeeper.ingotOrichalcum});
        this.addRecipe(new ItemStack(ShopKeeper.roofSandstoneNether,            3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.sandstone,                        'I', Items.netherbrick         });
        this.addRecipe(new ItemStack(ShopKeeper.roofNetherStraw,                3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.nether_brick,                     'I', Items.wheat               });
        this.addRecipe(new ItemStack(ShopKeeper.roofNetherReeds,                3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.nether_brick,                     'I', Items.reeds               });
        this.addRecipe(new ItemStack(ShopKeeper.roofNetherClay,                 3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.nether_brick,                     'I', Items.brick               });
        this.addRecipe(new ItemStack(ShopKeeper.roofNetherCopper,               3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.nether_brick,                     'I', ShopKeeper.ingotCopper    });
        this.addRecipe(new ItemStack(ShopKeeper.roofNetherTin,                  3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.nether_brick,                     'I', ShopKeeper.ingotTin       });
        this.addRecipe(new ItemStack(ShopKeeper.roofNetherBrass,                3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.nether_brick,                     'I', ShopKeeper.ingotBrass     });
        this.addRecipe(new ItemStack(ShopKeeper.roofNetherGold,                 3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.nether_brick,                     'I', Items.gold_ingot          });
        this.addRecipe(new ItemStack(ShopKeeper.roofNetherMythril,              3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.nether_brick,                     'I', ShopKeeper.ingotMythril   });
        this.addRecipe(new ItemStack(ShopKeeper.roofNetherOrichalcum,           3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.nether_brick,                     'I', ShopKeeper.ingotOrichalcum});
        this.addRecipe(new ItemStack(ShopKeeper.roofNetherNether,               3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.nether_brick,                     'I', Items.netherbrick         });
        this.addRecipe(new ItemStack(ShopKeeper.roofQuartzStraw,                3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.quartz_block,                     'I', Items.wheat               });
        this.addRecipe(new ItemStack(ShopKeeper.roofQuartzReeds,                3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.quartz_block,                     'I', Items.reeds               });
        this.addRecipe(new ItemStack(ShopKeeper.roofQuartzClay,                 3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.quartz_block,                     'I', Items.brick               });
        this.addRecipe(new ItemStack(ShopKeeper.roofQuartzCopper,               3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.quartz_block,                     'I', ShopKeeper.ingotCopper    });
        this.addRecipe(new ItemStack(ShopKeeper.roofQuartzTin,                  3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.quartz_block,                     'I', ShopKeeper.ingotTin       });
        this.addRecipe(new ItemStack(ShopKeeper.roofQuartzBrass,                3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.quartz_block,                     'I', ShopKeeper.ingotBrass     });
        this.addRecipe(new ItemStack(ShopKeeper.roofQuartzGold,                 3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.quartz_block,                     'I', Items.gold_ingot          });
        this.addRecipe(new ItemStack(ShopKeeper.roofQuartzMythril,              3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.quartz_block,                     'I', ShopKeeper.ingotMythril   });
        this.addRecipe(new ItemStack(ShopKeeper.roofQuartzOrichalcum,           3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.quartz_block,                     'I', ShopKeeper.ingotOrichalcum});
        this.addRecipe(new ItemStack(ShopKeeper.roofQuartzNether,               3), new Object[]{"I    ", "BI   ", "BBI  ", "BBBI ", "BBBBI", 'B', Blocks.quartz_block,                     'I', Items.netherbrick         });
        Collections.sort(this.recipes, new WorkbenchRecipeSorter(this));
    }

    public WorkbenchShapedRecipes addRecipe(ItemStack stack, Object ... object){
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
        WorkbenchShapedRecipes shapedrecipes = new WorkbenchShapedRecipes(j, k, aitemstack, stack);
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