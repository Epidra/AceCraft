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

public class AnvilCraftingManager {
	
    private static final AnvilCraftingManager instance = new AnvilCraftingManager();
    private List recipes = new ArrayList();
    private static final String __OBFID = "CL_00000090";
    
    public static final AnvilCraftingManager getInstance(){
        return instance;
    }
    
    private AnvilCraftingManager(){
    	recipes = new ArrayList();
        this.addRecipe(new ItemStack(Items.iron_door), new Object[]{"XX","XX","XX",'X',Items.iron_ingot});
        this.addRecipe(new ItemStack(Blocks.iron_bars, 16), new Object[]{"XXX","XXX",'X',Items.iron_ingot});
        this.addRecipe(new ItemStack(Blocks.rail, 16), new Object[] {"X X", "X#X", "X X", 'X', Items.iron_ingot, '#', Items.stick});
        this.addRecipe(new ItemStack(Blocks.golden_rail, 6), new Object[] {"X X", "X#X", "XRX", 'X', Items.gold_ingot, 'R', Items.redstone, '#', Items.stick});
        this.addRecipe(new ItemStack(Blocks.activator_rail, 6), new Object[] {"XSX", "X#X", "XSX", 'X', Items.iron_ingot, '#', Blocks.redstone_torch, 'S', Items.stick});
        this.addRecipe(new ItemStack(Blocks.detector_rail, 6), new Object[] {"X X", "X#X", "XRX", 'X', Items.iron_ingot, 'R', Items.redstone, '#', Blocks.stone_pressure_plate});
        this.addRecipe(new ItemStack(Items.minecart, 1), new Object[] {"# #", "###", '#', Items.iron_ingot});
        this.addRecipe(new ItemStack(Items.cauldron, 1), new Object[] {"# #", "# #", "###", '#', Items.iron_ingot});
        this.addRecipe(new ItemStack(Items.chest_minecart, 1), new Object[] {"A", "B", 'A', Blocks.chest, 'B', Items.minecart});
        this.addRecipe(new ItemStack(Items.furnace_minecart, 1), new Object[] {"A", "B", 'A', Blocks.furnace, 'B', Items.minecart});
        this.addRecipe(new ItemStack(Items.tnt_minecart, 1), new Object[] {"A", "B", 'A', Blocks.tnt, 'B', Items.minecart});
        this.addRecipe(new ItemStack(Items.hopper_minecart, 1), new Object[] {"A", "B", 'A', Blocks.hopper, 'B', Items.minecart});
        this.addRecipe(new ItemStack(Items.clock, 1), new Object[] {" # ", "#X#", " # ", '#', Items.gold_ingot, 'X', Items.redstone});
        this.addRecipe(new ItemStack(Items.compass, 1), new Object[] {" # ", "#X#", " # ", '#', Items.iron_ingot, 'X', Items.redstone});
        this.addRecipe(new ItemStack(Blocks.heavy_weighted_pressure_plate, 1), new Object[] {"##", '#', Items.iron_ingot});
        this.addRecipe(new ItemStack(Blocks.light_weighted_pressure_plate, 1), new Object[] {"##", '#', Items.gold_ingot});
        this.addRecipe(new ItemStack(Blocks.hopper), new Object[] {"I I", "ICI", " I ", 'I', Items.iron_ingot, 'C', Blocks.chest});
        this.addRecipe(new ItemStack(Blocks.iron_block),           new Object[]{"XXX","XXX","XXX",'X', Items.iron_ingot});
        this.addRecipe(new ItemStack(Blocks.gold_block),           new Object[]{"XXX","XXX","XXX",'X', Items.gold_ingot});
        this.addRecipe(new ItemStack(ShopKeeper.blockCopper),           new Object[]{"XXX","XXX","XXX",'X', ShopKeeper.ingotCopper});
        this.addRecipe(new ItemStack(ShopKeeper.blockAluminium),        new Object[]{"XXX","XXX","XXX",'X', ShopKeeper.ingotAluminium});
        this.addRecipe(new ItemStack(ShopKeeper.blockLead),           new Object[]{"XXX","XXX","XXX",'X', ShopKeeper.ingotLead});
        this.addRecipe(new ItemStack(ShopKeeper.blockTin),              new Object[]{"XXX","XXX","XXX",'X', ShopKeeper.ingotTin});
        this.addRecipe(new ItemStack(ShopKeeper.blockZinc),             new Object[]{"XXX","XXX","XXX",'X', ShopKeeper.ingotZinc});
        this.addRecipe(new ItemStack(ShopKeeper.blockSilver),           new Object[]{"XXX","XXX","XXX",'X', ShopKeeper.ingotSilver});
        this.addRecipe(new ItemStack(ShopKeeper.blockMythril),          new Object[]{"XXX","XXX","XXX",'X', ShopKeeper.ingotMythril});
        this.addRecipe(new ItemStack(ShopKeeper.blockIridium),           new Object[]{"XXX","XXX","XXX",'X', ShopKeeper.ingotIridium});
        this.addRecipe(new ItemStack(ShopKeeper.blockAdamantium),       new Object[]{"XXX","XXX","XXX",'X', ShopKeeper.ingotAdamantium});
        this.addRecipe(new ItemStack(ShopKeeper.blockOrichalcum),           new Object[]{"XXX","XXX","XXX",'X', ShopKeeper.ingotOrichalcum});
        this.addRecipe(new ItemStack(ShopKeeper.blockUnobtanium),       new Object[]{"XXX","XXX","XXX",'X', ShopKeeper.ingotUnobtanium});
        this.addRecipe(new ItemStack(ShopKeeper.blockBronze),           new Object[]{"XXX","XXX","XXX",'X', ShopKeeper.ingotBronze});
        this.addRecipe(new ItemStack(ShopKeeper.blockSteel),            new Object[]{"XXX","XXX","XXX",'X', ShopKeeper.ingotSteel});
        this.addRecipe(new ItemStack(ShopKeeper.blockBrass),            new Object[]{"XXX","XXX","XXX",'X', ShopKeeper.ingotBrass});
        this.addRecipe(new ItemStack(Items.iron_sword),        new Object[]{"X","X","I",'X',Items.iron_ingot,    'I',Items.stick});
        this.addRecipe(new ItemStack(Items.golden_sword),        new Object[]{"X","X","I",'X',Items.gold_ingot,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolSwordCopper),       new Object[]{"X","X","I",'X',ShopKeeper.ingotCopper,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolSwordLead),       new Object[]{"X","X","I",'X',ShopKeeper.ingotLead,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolSwordBronze),       new Object[]{"X","X","I",'X',ShopKeeper.ingotBronze,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolSwordSteel),        new Object[]{"X","X","I",'X',ShopKeeper.ingotSteel,     'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolSwordMythril),      new Object[]{"X","X","I",'X',ShopKeeper.ingotMythril,   'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolSwordIridium),       new Object[]{"X","X","I",'X',ShopKeeper.ingotIridium,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolSwordAdamantium),   new Object[]{"X","X","I",'X',ShopKeeper.ingotAdamantium,'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolSwordUnobtanium),   new Object[]{"X","X","I",'X',ShopKeeper.ingotUnobtanium,'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolSpearIron),       new Object[]{"  X"," I ","I  ",'X',Items.iron_ingot,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolSpearGold),       new Object[]{"  X"," I ","I  ",'X',Items.gold_ingot,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolSpearCopper),       new Object[]{"  X"," I ","I  ",'X',ShopKeeper.ingotCopper,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolSpearLead),       new Object[]{"  X"," I ","I  ",'X',ShopKeeper.ingotLead,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolSpearBronze),       new Object[]{"  X"," I ","I  ",'X',ShopKeeper.ingotBronze,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolSpearSteel),        new Object[]{"  X"," I ","I  ",'X',ShopKeeper.ingotSteel,     'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolSpearMythril),      new Object[]{"  X"," I ","I  ",'X',ShopKeeper.ingotMythril,   'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolSpearIridium),       new Object[]{"  X"," I ","I  ",'X',ShopKeeper.ingotIridium,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolSpearAdamantium),   new Object[]{"  X"," I ","I  ",'X',ShopKeeper.ingotAdamantium,'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolSpearUnobtanium),   new Object[]{"  X"," I ","I  ",'X',ShopKeeper.ingotUnobtanium,'I',Items.stick});
        
        this.addRecipe(new ItemStack(ShopKeeper.toolHammerIron),        new Object[]{"XXX","XXX"," I "," I ",'X',Items.iron_ingot,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolHammerGold),        new Object[]{"XXX","XXX"," I "," I ",'X',Items.gold_ingot,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolHammerCopper),      new Object[]{"XXX","XXX"," I "," I ",'X',ShopKeeper.ingotCopper,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolHammerLead),        new Object[]{"XXX","XXX"," I "," I ",'X',ShopKeeper.ingotLead,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolHammerBronze),      new Object[]{"XXX","XXX"," I "," I ",'X',ShopKeeper.ingotBronze,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolHammerSteel),       new Object[]{"XXX","XXX"," I "," I ",'X',ShopKeeper.ingotSteel,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolHammerMythril),     new Object[]{"XXX","XXX"," I "," I ",'X',ShopKeeper.ingotMythril,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolHammerIridium),     new Object[]{"XXX","XXX"," I "," I ",'X',ShopKeeper.ingotIridium,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolHammerAdamantium),  new Object[]{"XXX","XXX"," I "," I ",'X',ShopKeeper.ingotAdamantium,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolHammerUnobtanium),  new Object[]{"XXX","XXX"," I "," I ",'X',ShopKeeper.ingotUnobtanium,    'I',Items.stick});
        
        this.addRecipe(new ItemStack(Items.iron_axe),        new Object[]{"XX","XI"," I",'X',Items.iron_ingot,    'I',Items.stick});
        this.addRecipe(new ItemStack(Items.golden_axe),        new Object[]{"XX","XI"," I",'X',Items.gold_ingot,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolAxeCopper),       new Object[]{"XX","XI"," I",'X',ShopKeeper.ingotCopper,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolAxeLead),       new Object[]{"XX","XI"," I",'X',ShopKeeper.ingotLead,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolAxeBronze),       new Object[]{"XX","XI"," I",'X',ShopKeeper.ingotBronze,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolAxeSteel),        new Object[]{"XX","XI"," I",'X',ShopKeeper.ingotSteel,     'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolAxeMythril),      new Object[]{"XX","XI"," I",'X',ShopKeeper.ingotMythril,   'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolAxeIridium),       new Object[]{"XX","XI"," I",'X',ShopKeeper.ingotIridium,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolAxeAdamantium),   new Object[]{"XX","XI"," I",'X',ShopKeeper.ingotAdamantium,'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolAxeUnobtanium),   new Object[]{"XX","XI"," I",'X',ShopKeeper.ingotUnobtanium,'I',Items.stick});
        this.addRecipe(new ItemStack(Items.iron_shovel),        new Object[]{"X","I","I",'X',Items.iron_ingot,    'I',Items.stick});
        this.addRecipe(new ItemStack(Items.golden_shovel),        new Object[]{"X","I","I",'X',Items.gold_ingot,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolShovelCopper),       new Object[]{"X","I","I",'X',ShopKeeper.ingotCopper,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolShovelLead),       new Object[]{"X","I","I",'X',ShopKeeper.ingotLead,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolShovelBronze),       new Object[]{"X","I","I",'X',ShopKeeper.ingotBronze,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolShovelSteel),        new Object[]{"X","I","I",'X',ShopKeeper.ingotSteel,     'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolShovelMythril),      new Object[]{"X","I","I",'X',ShopKeeper.ingotMythril,   'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolShovelIridium),       new Object[]{"X","I","I",'X',ShopKeeper.ingotIridium,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolShovelAdamantium),   new Object[]{"X","I","I",'X',ShopKeeper.ingotAdamantium,'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolShovelUnobtanium),   new Object[]{"X","I","I",'X',ShopKeeper.ingotUnobtanium,'I',Items.stick});
        this.addRecipe(new ItemStack(Items.iron_hoe),        new Object[]{"XX"," I"," I",'X',Items.iron_ingot,    'I',Items.stick});
        this.addRecipe(new ItemStack(Items.golden_hoe),        new Object[]{"XX"," I"," I",'X',Items.gold_ingot,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolHoeCopper),       new Object[]{"XX"," I"," I",'X',ShopKeeper.ingotCopper,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolHoeLead),       new Object[]{"XX"," I"," I",'X',ShopKeeper.ingotLead,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolHoeBronze),       new Object[]{"XX"," I"," I",'X',ShopKeeper.ingotBronze,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolHoeSteel),        new Object[]{"XX"," I"," I",'X',ShopKeeper.ingotSteel,     'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolHoeMythril),      new Object[]{"XX"," I"," I",'X',ShopKeeper.ingotMythril,   'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolHoeIridium),       new Object[]{"XX"," I"," I",'X',ShopKeeper.ingotIridium,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolHoeAdamantium),   new Object[]{"XX"," I"," I",'X',ShopKeeper.ingotAdamantium,'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolHoeUnobtanium),   new Object[]{"XX"," I"," I",'X',ShopKeeper.ingotUnobtanium,'I',Items.stick});
        this.addRecipe(new ItemStack(Items.iron_pickaxe),        new Object[]{"XXX"," I "," I ",'X',Items.iron_ingot,    'I',Items.stick});
        this.addRecipe(new ItemStack(Items.golden_pickaxe),        new Object[]{"XXX"," I "," I ",'X',Items.gold_ingot,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolPickaxeCopper),       new Object[]{"XXX"," I "," I ",'X',ShopKeeper.ingotCopper,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolPickaxeLead),       new Object[]{"XXX"," I "," I ",'X',ShopKeeper.ingotLead,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolPickaxeBronze),       new Object[]{"XXX"," I "," I ",'X',ShopKeeper.ingotBronze,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolPickaxeSteel),        new Object[]{"XXX"," I "," I ",'X',ShopKeeper.ingotSteel,     'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolPickaxeMythril),      new Object[]{"XXX"," I "," I ",'X',ShopKeeper.ingotMythril,   'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolPickaxeIridium),       new Object[]{"XXX"," I "," I ",'X',ShopKeeper.ingotIridium,    'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolPickaxeAdamantium),   new Object[]{"XXX"," I "," I ",'X',ShopKeeper.ingotAdamantium,'I',Items.stick});
        this.addRecipe(new ItemStack(ShopKeeper.toolPickaxeUnobtanium),   new Object[]{"XXX"," I "," I ",'X',ShopKeeper.ingotUnobtanium,'I',Items.stick});
        this.addRecipe(new ItemStack(Items.iron_helmet), new Object[]{"XXX","X X",'X',Items.iron_ingot});
        this.addRecipe(new ItemStack(Items.golden_helmet), new Object[]{"XXX","X X",'X',Items.gold_ingot});
        this.addRecipe(new ItemStack(ShopKeeper.armorHelmetAluminium), new Object[]{"XXX","X X",'X',ShopKeeper.ingotAluminium});
        this.addRecipe(new ItemStack(ShopKeeper.armorHelmetCopper), new Object[]{"XXX","X X",'X',ShopKeeper.ingotCopper});
        this.addRecipe(new ItemStack(ShopKeeper.armorHelmetLead), new Object[]{"XXX","X X",'X',ShopKeeper.ingotLead});
        this.addRecipe(new ItemStack(ShopKeeper.armorHelmetBronze), new Object[]{"XXX","X X",'X',ShopKeeper.ingotBronze});
        this.addRecipe(new ItemStack(ShopKeeper.armorHelmetSteel), new Object[]{"XXX","X X",'X',ShopKeeper.ingotSteel});
        this.addRecipe(new ItemStack(ShopKeeper.armorHelmetMythril), new Object[]{"XXX","X X",'X',ShopKeeper.ingotMythril});
        this.addRecipe(new ItemStack(ShopKeeper.armorHelmetAdamantium), new Object[]{"XXX","X X",'X',ShopKeeper.ingotAdamantium});
        this.addRecipe(new ItemStack(ShopKeeper.armorHelmetUnobtanium), new Object[]{"XXX","X X",'X',ShopKeeper.ingotUnobtanium});
        this.addRecipe(new ItemStack(Items.iron_chestplate), new Object[]{"X X","XXX","XXX",'X',Items.iron_ingot});
        this.addRecipe(new ItemStack(Items.golden_chestplate), new Object[]{"XXX","X X","XXX",'X',Items.gold_ingot});
        this.addRecipe(new ItemStack(ShopKeeper.armorChestplateAluminium), new Object[]{"X X","XXX","XXX",'X',ShopKeeper.ingotAluminium});
        this.addRecipe(new ItemStack(ShopKeeper.armorChestplateCopper), new Object[]{"X X","XXX","XXX",'X',ShopKeeper.ingotCopper});
        this.addRecipe(new ItemStack(ShopKeeper.armorChestplateLead), new Object[]{"X X","XXX","XXX",'X',ShopKeeper.ingotLead});
        this.addRecipe(new ItemStack(ShopKeeper.armorChestplateBronze), new Object[]{"X X","XXX","XXX",'X',ShopKeeper.ingotBronze});
        this.addRecipe(new ItemStack(ShopKeeper.armorChestplateSteel), new Object[]{"X X","XXX","XXX",'X',ShopKeeper.ingotSteel});
        this.addRecipe(new ItemStack(ShopKeeper.armorChestplateMythril), new Object[]{"X X","XXX","XXX",'X',ShopKeeper.ingotMythril});
        this.addRecipe(new ItemStack(ShopKeeper.armorChestplateAdamantium), new Object[]{"X X","XXX","XXX",'X',ShopKeeper.ingotAdamantium});
        this.addRecipe(new ItemStack(ShopKeeper.armorChestplateUnobtanium), new Object[]{"X X","XXX","XXX",'X',ShopKeeper.ingotUnobtanium});
        this.addRecipe(new ItemStack(Items.iron_leggings), new Object[]{"XXX","X X","X X",'X',Items.iron_ingot});
        this.addRecipe(new ItemStack(Items.golden_leggings), new Object[]{"XXX","X X","X X",'X',Items.gold_ingot});
        this.addRecipe(new ItemStack(ShopKeeper.armorLegginsAluminium), new Object[]{"XXX","X X","X X",'X',ShopKeeper.ingotAluminium});
        this.addRecipe(new ItemStack(ShopKeeper.armorLegginsCopper), new Object[]{"XXX","X X","X X",'X',ShopKeeper.ingotCopper});
        this.addRecipe(new ItemStack(ShopKeeper.armorLegginsLead), new Object[]{"XXX","X X","X X",'X',ShopKeeper.ingotLead});
        this.addRecipe(new ItemStack(ShopKeeper.armorLegginsBronze), new Object[]{"XXX","X X","X X",'X',ShopKeeper.ingotBronze});
        this.addRecipe(new ItemStack(ShopKeeper.armorLegginsSteel), new Object[]{"XXX","X X","X X",'X',ShopKeeper.ingotSteel});
        this.addRecipe(new ItemStack(ShopKeeper.armorLegginsMythril), new Object[]{"XXX","X X","X X",'X',ShopKeeper.ingotMythril});
        this.addRecipe(new ItemStack(ShopKeeper.armorLegginsAdamantium), new Object[]{"XXX","X X","X X",'X',ShopKeeper.ingotAdamantium});
        this.addRecipe(new ItemStack(ShopKeeper.armorLegginsUnobtanium), new Object[]{"XXX","X X","X X",'X',ShopKeeper.ingotUnobtanium});
        this.addRecipe(new ItemStack(Items.iron_boots), new Object[]{"X X","X X",'X',Items.iron_ingot});
        this.addRecipe(new ItemStack(Items.golden_boots), new Object[]{"X X","X X",'X',Items.gold_ingot});
        this.addRecipe(new ItemStack(ShopKeeper.armorBootsAluminium), new Object[]{"X X","X X",'X',ShopKeeper.ingotAluminium});
        this.addRecipe(new ItemStack(ShopKeeper.armorBootsCopper), new Object[]{"X X","X X",'X',ShopKeeper.ingotCopper});
        this.addRecipe(new ItemStack(ShopKeeper.armorBootsLead), new Object[]{"X X","X X",'X',ShopKeeper.ingotLead});
        this.addRecipe(new ItemStack(ShopKeeper.armorBootsBronze), new Object[]{"X X","X X",'X',ShopKeeper.ingotBronze});
        this.addRecipe(new ItemStack(ShopKeeper.armorBootsSteel), new Object[]{"X X","X X",'X',ShopKeeper.ingotSteel});
        this.addRecipe(new ItemStack(ShopKeeper.armorBootsMythril), new Object[]{"X X","X X",'X',ShopKeeper.ingotMythril});
        this.addRecipe(new ItemStack(ShopKeeper.armorBootsAdamantium), new Object[]{"X X","X X",'X',ShopKeeper.ingotAdamantium});
        this.addRecipe(new ItemStack(ShopKeeper.armorBootsUnobtanium), new Object[]{"X X","X X",'X',ShopKeeper.ingotUnobtanium});
        this.addRecipe(new ItemStack(ShopKeeper.machinaAnvilIron),            new Object[]{"XXX"," X ","XXX",'X', Items.iron_ingot});
        this.addRecipe(new ItemStack(ShopKeeper.machinaAnvilCopper),            new Object[]{"XXX"," X ","XXX",'X', ShopKeeper.ingotCopper});
        this.addRecipe(new ItemStack(ShopKeeper.machinaAnvilAluminium),            new Object[]{"XXX"," X ","XXX",'X', ShopKeeper.ingotAluminium});
        this.addRecipe(new ItemStack(ShopKeeper.machinaAnvilLead),            new Object[]{"XXX"," X ","XXX",'X', ShopKeeper.ingotLead});
        this.addRecipe(new ItemStack(ShopKeeper.machinaAnvilBronze),            new Object[]{"XXX"," X ","XXX",'X', ShopKeeper.ingotBronze});
        this.addRecipe(new ItemStack(ShopKeeper.machinaAnvilSteel),            new Object[]{"XXX"," X ","XXX",'X', ShopKeeper.ingotSteel});
        this.addRecipe(new ItemStack(ShopKeeper.machinaAnvilMythril),            new Object[]{"XXX"," X ","XXX",'X', ShopKeeper.ingotMythril});
        this.addRecipe(new ItemStack(ShopKeeper.machinaAnvilAdamantium),            new Object[]{"XXX"," X ","XXX",'X', ShopKeeper.ingotAdamantium});
        this.addRecipe(new ItemStack(ShopKeeper.machinaAnvilUnobtanium),            new Object[]{"XXX"," X ","XXX",'X', ShopKeeper.ingotUnobtanium});
        this.addRecipe(new ItemStack(ShopKeeper.machinaIngotBasin),       new Object[]{"I  I","IIII",'I', Items.iron_ingot});
        this.addRecipe(new ItemStack(ShopKeeper.machinaAnchor),       new Object[]{"I  ","IIR","I  ",'I', Items.iron_ingot, 'R', ShopKeeper.stuffRope});
        this.addRecipe(new ItemStack(ShopKeeper.machinaBoilerIdle),       new Object[]{" P ", " I ", "ICI", "III", 'I', ShopKeeper.ingotBronze, 'C', Blocks.coal_block, 'P', ShopKeeper.machinaPipeStraightBronze});
        this.addRecipe(new ItemStack(ShopKeeper.machinaPipeStraightLead, 2),       new Object[]{"I I", "I I", "I I", "I I", 'I', ShopKeeper.ingotLead});
        this.addRecipe(new ItemStack(ShopKeeper.machinaPipeStraightBronze, 2),       new Object[]{"I I", "I I", "I I", "I I", 'I', ShopKeeper.ingotBronze});
        this.addRecipe(new ItemStack(ShopKeeper.machinaPipeCurveLead, 3),       new Object[]{"PP", " P", 'P', ShopKeeper.machinaPipeStraightLead});
        this.addRecipe(new ItemStack(ShopKeeper.machinaPipeCurveBronze, 3),       new Object[]{"PP", " P", 'P', ShopKeeper.machinaPipeStraightBronze});
        this.addRecipe(new ItemStack(ShopKeeper.machinaPipeCrossingLead, 2),       new Object[]{"PIP", " P ", 'P', ShopKeeper.machinaPipeStraightLead, 'I', ShopKeeper.ingotLead});
        this.addRecipe(new ItemStack(ShopKeeper.machinaPipeCrossingBronze, 2),       new Object[]{"PIP", " P ", 'P', ShopKeeper.machinaPipeStraightBronze, 'I', ShopKeeper.ingotBronze});
        this.addRecipe(new ItemStack(ShopKeeper.machinaTurbine),       new Object[]{"I  ", "IA ", "II ", "IIP", 'I', ShopKeeper.ingotBronze, 'A', ShopKeeper.machinaAxle, 'P', ShopKeeper.machinaPipeStraightBronze});
        this.addRecipe(new ItemStack(ShopKeeper.machinaSolarCollector),       new Object[]{"QQAQQ", "AAAAA", "QQAQQ", "AAAAA", "  L  ", 'L', ShopKeeper.ingotLead, 'A', ShopKeeper.ingotAluminium, 'Q', Items.quartz});
        this.addRecipe(new ItemStack(ShopKeeper.machinaCable, 2),       new Object[]{"C", "C", 'C', ShopKeeper.ingotCopper});
        this.addRecipe(new ItemStack(ShopKeeper.machinaEnergyNode),       new Object[]{" Q ", " A ", "CAC", 'A', ShopKeeper.ingotAluminium, 'C', ShopKeeper.machinaCable, 'Q', Items.quartz});
        this.addRecipe(new ItemStack(ShopKeeper.machinaBattery),       new Object[]{" Z ", " C ", " A ", "XAX", 'A', ShopKeeper.ingotAluminium, 'X', ShopKeeper.machinaCable, 'C', ShopKeeper.ingotCopper, 'Z', ShopKeeper.ingotZinc});
        this.addRecipe(new ItemStack(ShopKeeper.scaffoldingAdamantium,36),    new Object[]{"XXXX","X XX","XX X","XXXX", 'X', ShopKeeper.ingotAdamantium});
        this.addRecipe(new ItemStack(ShopKeeper.scaffoldingAluminium,36),    new Object[]{"XXXX","X XX","XX X","XXXX", 'X', ShopKeeper.ingotAluminium});
        this.addRecipe(new ItemStack(ShopKeeper.scaffoldingBronze,36),    new Object[]{"XXXX","X XX","XX X","XXXX", 'X', ShopKeeper.ingotBronze});
        this.addRecipe(new ItemStack(ShopKeeper.scaffoldingCopper,36),    new Object[]{"XXXX","X XX","XX X","XXXX", 'X', ShopKeeper.ingotCopper});
        this.addRecipe(new ItemStack(ShopKeeper.scaffoldingIron,36),    new Object[]{"XXXX","X XX","XX X","XXXX", 'X', Items.iron_ingot});
        this.addRecipe(new ItemStack(ShopKeeper.scaffoldingMythril,36),    new Object[]{"XXXX","X XX","XX X","XXXX", 'X', ShopKeeper.ingotMythril});
        this.addRecipe(new ItemStack(ShopKeeper.scaffoldingSteel,36),    new Object[]{"XXXX","X XX","XX X","XXXX", 'X', ShopKeeper.ingotSteel});
        this.addRecipe(new ItemStack(ShopKeeper.scaffoldingUnobtanium,36),    new Object[]{"XXXX","X XX","XX X","XXXX", 'X', ShopKeeper.ingotUnobtanium});
        this.addRecipe(new ItemStack(ShopKeeper.bucketCopperEmpty),     new Object[]{"X X","X X"," X ",'X', ShopKeeper.ingotCopper});
        this.addRecipe(new ItemStack(ShopKeeper.bucketIronEmpty),       new Object[]{"X X","X X"," X ",'X', Items.iron_ingot});
        this.addRecipe(new ItemStack(ShopKeeper.bucketAluminiumEmpty),  new Object[]{"X X","X X"," X ",'X', ShopKeeper.ingotAluminium});
        this.addRecipe(new ItemStack(ShopKeeper.bucketBronzeEmpty),     new Object[]{"X X","X X"," X ",'X', ShopKeeper.ingotBronze});
        this.addRecipe(new ItemStack(ShopKeeper.bucketSteelEmpty),      new Object[]{"X X","X X"," X ",'X', ShopKeeper.ingotSteel});
        this.addRecipe(new ItemStack(ShopKeeper.bucketMythrilEmpty),    new Object[]{"X X","X X"," X ",'X', ShopKeeper.ingotMythril});
        this.addRecipe(new ItemStack(ShopKeeper.bucketAdamantiumEmpty), new Object[]{"X X","X X"," X ",'X', ShopKeeper.ingotAdamantium});
        this.addRecipe(new ItemStack(ShopKeeper.bucketUnobtaniumEmpty), new Object[]{"X X","X X"," X ",'X', ShopKeeper.ingotUnobtanium});
        Collections.sort(this.recipes, new AnvilRecipeSorter(this));
    }
    
    public AnvilShapedRecipes addRecipe(ItemStack stack, Object ... object){
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
        AnvilShapedRecipes shapedrecipes = new AnvilShapedRecipes(j, k, aitemstack, stack);
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