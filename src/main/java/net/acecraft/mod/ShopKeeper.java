package net.acecraft.mod;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.acecraft.mod.block.blocks.AceBed;
import net.acecraft.mod.block.blocks.AceCake;
import net.acecraft.mod.block.blocks.AceCrop;
import net.acecraft.mod.block.blocks.AceLeaf;
import net.acecraft.mod.block.blocks.AceLog;
import net.acecraft.mod.block.blocks.AcePlanks;
import net.acecraft.mod.block.blocks.AceSapling;
import net.acecraft.mod.block.blocks.AceSeeds;
import net.acecraft.mod.block.blocks.BlockBlock;
import net.acecraft.mod.block.blocks.GreenHillBlock;
import net.acecraft.mod.block.blocks.MinoBlock;
import net.acecraft.mod.block.blocks.OreBlock;
import net.acecraft.mod.block.machina.Anchor;
import net.acecraft.mod.block.machina.Anvil;
import net.acecraft.mod.block.machina.Axle;
import net.acecraft.mod.block.machina.Battery;
import net.acecraft.mod.block.machina.BlastFurnace;
import net.acecraft.mod.block.machina.Boiler;
import net.acecraft.mod.block.machina.Bonfire;
import net.acecraft.mod.block.machina.Cable;
import net.acecraft.mod.block.machina.Distillery;
import net.acecraft.mod.block.machina.EnergyNode;
import net.acecraft.mod.block.machina.FruitPress;
import net.acecraft.mod.block.machina.GearBox;
import net.acecraft.mod.block.machina.Generator;
import net.acecraft.mod.block.machina.Globe;
import net.acecraft.mod.block.machina.Keg;
import net.acecraft.mod.block.machina.Millstone;
import net.acecraft.mod.block.machina.Motor;
import net.acecraft.mod.block.machina.PipeCrossing;
import net.acecraft.mod.block.machina.PipeCurve;
import net.acecraft.mod.block.machina.PipeStraight;
import net.acecraft.mod.block.machina.Podium;
import net.acecraft.mod.block.machina.Roof;
import net.acecraft.mod.block.machina.Rope;
import net.acecraft.mod.block.machina.Scaffolding;
import net.acecraft.mod.block.machina.SewingStation;
import net.acecraft.mod.block.machina.SolarCollector;
import net.acecraft.mod.block.machina.SteamVent;
import net.acecraft.mod.block.machina.Stove;
import net.acecraft.mod.block.machina.Turbine;
import net.acecraft.mod.block.machina.Waterwheel;
import net.acecraft.mod.block.machina.WindmillLeather;
import net.acecraft.mod.block.machina.WindmillWool;
import net.acecraft.mod.block.machina.Workbench;
import net.acecraft.mod.crafting.RecipeRemover;
import net.acecraft.mod.entity.EntityCarrotRed;
import net.acecraft.mod.entity.EntityCarrotWhite;
import net.acecraft.mod.entity.EntityCrab;
import net.acecraft.mod.entity.EntityDeer;
import net.acecraft.mod.entity.EntityDynamite;
import net.acecraft.mod.entity.EntityElephant;
import net.acecraft.mod.entity.EntityGoat;
import net.acecraft.mod.entity.EntityLlama;
import net.acecraft.mod.entity.EntityMammoth;
import net.acecraft.mod.entity.EntityNugget;
import net.acecraft.mod.entity.EntitySpear;
import net.acecraft.mod.handler.EntityHandler;
import net.acecraft.mod.items.AceArmor;
import net.acecraft.mod.items.AceBucket;
import net.acecraft.mod.items.AceDynamite;
import net.acecraft.mod.items.AceFood;
import net.acecraft.mod.items.AceItems;
import net.acecraft.mod.items.AceNugget;
import net.acecraft.mod.items.ItemAceBed;
import net.acecraft.mod.items.ItemCakeBlock;
import net.acecraft.mod.items.ItemLeafBlocks;
import net.acecraft.mod.items.ItemLogBlocks;
import net.acecraft.mod.items.ItemPlanksBlocks;
import net.acecraft.mod.items.ItemSaplingBlocks;
import net.acecraft.mod.items.ToolsAxe;
import net.acecraft.mod.items.ToolsHammer;
import net.acecraft.mod.items.ToolsHoe;
import net.acecraft.mod.items.ToolsPickaxe;
import net.acecraft.mod.items.ToolsShovel;
import net.acecraft.mod.items.ToolsSpear;
import net.acecraft.mod.items.ToolsSword;
import net.acecraft.mod.tileentity.TileEntityAnchor;
import net.acecraft.mod.tileentity.TileEntityAnvil;
import net.acecraft.mod.tileentity.TileEntityAxle;
import net.acecraft.mod.tileentity.TileEntityBattery;
import net.acecraft.mod.tileentity.TileEntityBellows;
import net.acecraft.mod.tileentity.TileEntityBlastFurnace;
import net.acecraft.mod.tileentity.TileEntityBoiler;
import net.acecraft.mod.tileentity.TileEntityBonfire;
import net.acecraft.mod.tileentity.TileEntityCable;
import net.acecraft.mod.tileentity.TileEntityDistillery;
import net.acecraft.mod.tileentity.TileEntityEnergyNode;
import net.acecraft.mod.tileentity.TileEntityFruitPress;
import net.acecraft.mod.tileentity.TileEntityGearBox;
import net.acecraft.mod.tileentity.TileEntityGenerator;
import net.acecraft.mod.tileentity.TileEntityGlobe;
import net.acecraft.mod.tileentity.TileEntityIngotBasin;
import net.acecraft.mod.tileentity.TileEntityKeg;
import net.acecraft.mod.tileentity.TileEntityMillstone;
import net.acecraft.mod.tileentity.TileEntityMotor;
import net.acecraft.mod.tileentity.TileEntityPipeCrossing;
import net.acecraft.mod.tileentity.TileEntityPipeCurve;
import net.acecraft.mod.tileentity.TileEntityPipeStraight;
import net.acecraft.mod.tileentity.TileEntityPodium;
import net.acecraft.mod.tileentity.TileEntityRoof;
import net.acecraft.mod.tileentity.TileEntityRope;
import net.acecraft.mod.tileentity.TileEntityScaffolding;
import net.acecraft.mod.tileentity.TileEntitySewingStation;
import net.acecraft.mod.tileentity.TileEntitySolarCollector;
import net.acecraft.mod.tileentity.TileEntitySteamVent;
import net.acecraft.mod.tileentity.TileEntityStove;
import net.acecraft.mod.tileentity.TileEntityTurbine;
import net.acecraft.mod.tileentity.TileEntityWaterwheel;
import net.acecraft.mod.tileentity.TileEntityWindmillLeather;
import net.acecraft.mod.tileentity.TileEntityWindmillWool;
import net.acecraft.mod.tileentity.TileEntityWorkbench;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;

public class ShopKeeper {
	
	//Loaded Mods
	public static boolean loadedBiomesOPlenty;
	public static boolean loadedMillenaire;
	
	//Creative Tabs
	public static CreativeTabs acetabCommon;
	public static CreativeTabs acetabMachina;
	public static CreativeTabs acetabRoof;
	
	//Achievements
	public static Achievement achievementShovelKnight;
	public static Achievement achievementRainbowCollection;
	
	//Tool Material
	public static ToolMaterial materialToolFlint      = EnumHelper.addToolMaterial("MaterialToolFlint",      1,  152,  4.0F, 1.5F,   0);
	public static ToolMaterial materialToolReed       = EnumHelper.addToolMaterial("MaterialToolReed",       0,  103,  2.0F, 0.5F,   0);
	public static ToolMaterial materialToolCopper     = EnumHelper.addToolMaterial("MaterialToolCopper",     2,  185,  5.5F, 2.0F,  10);
	public static ToolMaterial materialToolLead       = EnumHelper.addToolMaterial("MaterialToolLead",       2,  523,  4.5F, 2.5F,   5);
	public static ToolMaterial materialToolBronze     = EnumHelper.addToolMaterial("MaterialToolBronze",     2,  560,  7.0F, 2.5F,  19);
	public static ToolMaterial materialToolSteel      = EnumHelper.addToolMaterial("MaterialToolSteel",      2, 1244,  8.0F, 3.0F,  19);
	public static ToolMaterial materialToolMythril    = EnumHelper.addToolMaterial("MaterialToolMythril",    3, 2100, 10.0F, 3.5F,  50);
	public static ToolMaterial materialToolIridium    = EnumHelper.addToolMaterial("MaterialToolIridium",    3, 3500, 12.0F, 4.0F,   0);
	public static ToolMaterial materialToolAdamantium = EnumHelper.addToolMaterial("MaterialToolAdamantium", 3, 5600, 15.0F, 5.0F,  75);
	public static ToolMaterial materialToolUnobtanium = EnumHelper.addToolMaterial("MaterialToolUnobtanium", 4, 9999, 42.0F, 9.9F, 100);
	
	//Armor Material
	public static ArmorMaterial materialArmorCopper     = EnumHelper.addArmorMaterial("MaterialArmorCopper",      7, new int[]{2, 4, 2, 2},   5);
	public static ArmorMaterial materialArmorAluminium  = EnumHelper.addArmorMaterial("MaterialArmorAluminium",  15, new int[]{2, 7, 6, 3},  12);
	public static ArmorMaterial materialArmorLead       = EnumHelper.addArmorMaterial("MaterialArmorLead",       20, new int[]{2, 5, 3, 2},   5);
	public static ArmorMaterial materialArmorBronze     = EnumHelper.addArmorMaterial("MaterialArmorBronze",     20, new int[]{2, 5, 3, 2},  12);
	public static ArmorMaterial materialArmorSteel      = EnumHelper.addArmorMaterial("MaterialArmorSteel",      25, new int[]{3, 6, 4, 3},  12);
	public static ArmorMaterial materialArmorMythril    = EnumHelper.addArmorMaterial("MaterialArmorMythril",    30, new int[]{3, 7, 5, 3},  45);
	public static ArmorMaterial materialArmorAdamantium = EnumHelper.addArmorMaterial("MaterialArmorAdamantium", 35, new int[]{3, 8, 6, 3},  70);
	public static ArmorMaterial materialArmorUnobtanium = EnumHelper.addArmorMaterial("MaterialArmorUnobtanium", 99, new int[]{3, 8, 6, 3}, 100);
	
	//Mineral Blocks
	public static Block greenhillEarth;
	public static Block greenhillGrass;
	public static Block greenhillStone;
	public static Block greenhillMoss;
	
	//OreBlocks
	public static Block oreSalt;
	public static Block oreSulfur;
	public static Block oreCopper;
	public static Block oreBauxite;
	public static Block oreLead;
	public static Block oreTin;
	public static Block oreZinc;
	public static Block oreSilver;
	public static Block oreMythril;
	public static Block oreIridium;
	public static Block oreAdamantium;
	public static Block oreOrichalcum;
	public static Block oreUnobtanium;
	public static Block oreRuby;
	public static Block orePeridot;
	public static Block oreTopaz;
	public static Block oreSaphire;
	public static Block oreAzurit;
	public static Block oreAmber;
	public static Block oreAmethyst;
	public static Block oreGagat;
	public static Block oreOpal;
	public static Block oreJade;
	public static Block oreTurquoise;
	
	//Full Blocks
	public static Block blockMeteor;
	public static Block blockCopper;
	public static Block blockAluminium;
	public static Block blockLead;
	public static Block blockTin;
	public static Block blockZinc;
	public static Block blockSilver;
	public static Block blockMythril;
	public static Block blockIridium;
	public static Block blockAdamantium;
	public static Block blockOrichalcum;
	public static Block blockUnobtanium;
	public static Block blockBronze;
	public static Block blockSteel;
	public static Block blockBrass;
	public static Block blockSalt;
	public static Block blockSulfur;
	public static Block blockFlour;
	public static Block blockCoffee;
	public static Block blockRuby;
	public static Block blockPeridot;
	public static Block blockTopaz;
	public static Block blockSaphire;
	public static Block blockAzurit;
	public static Block blockAmber;
	public static Block blockAmethyst;
	public static Block blockGagat;
	public static Block blockOpal;
	public static Block blockJade;
	public static Block blockTurquoise;
	
	//Mino Blocks
	public static Block minoBlank;
	public static Block minoFire;
	public static Block minoAir;
	public static Block minoThunder;
	public static Block minoWater;
	public static Block minoIce;
	public static Block minoEarth;
	public static Block minoMetal;
	public static Block minoNature;
	public static Block minoLight;
	public static Block minoDark;
	
	//Nuggets
	public static Item nuggetIron;
	public static Item nuggetGold;
	public static Item nuggetCopper;
	public static Item nuggetBauxite;
	public static Item nuggetLead;
	public static Item nuggetTin;
	public static Item nuggetZinc;
	public static Item nuggetSilver;
	public static Item nuggetMythril;
	public static Item nuggetIridium;
	public static Item nuggetAdamantium;
	public static Item nuggetOrichalcum;
	public static Item nuggetUnobtanium;
	
	//Ingots
	public static Item ingotCopper;
	public static Item ingotAluminium;
	public static Item ingotLead;
	public static Item ingotTin;
	public static Item ingotZinc;
	public static Item ingotSilver;
	public static Item ingotMythril;
	public static Item ingotIridium;
	public static Item ingotAdamantium;
	public static Item ingotOrichalcum;
	public static Item ingotUnobtanium;
	public static Item ingotBronze;
	public static Item ingotSteel;
	public static Item ingotBrass;
	
	//Gemstones
	public static Item gemstoneRuby;
	public static Item gemstonePeridot;
	public static Item gemstoneTopaz;
	public static Item gemstoneSaphire;
	public static Item gemstoneAzurit;
	public static Item gemstoneAmber;
	public static Item gemstoneAmethyst;
	public static Item gemstoneGagat;
	public static Item gemstoneOpal;
	public static Item gemstoneJade;
	public static Item gemstoneTurquoise;
	
	//Powder
	public static Item powderSalt;
	public static Item powderSulfur;
	public static Item powderOrichalcum;
	public static Item powderFlour;
	public static Item powderCoffee;
	
	//Tools
	public static Item toolFryingPan;
	
	public static Item toolSwordFlint;
	public static Item toolSwordCopper;
	public static Item toolSwordLead;
	public static Item toolSwordBronze;
	public static Item toolSwordSteel;
	public static Item toolSwordMythril;
	public static Item toolSwordIridium;
	public static Item toolSwordAdamantium;
	public static Item toolSwordUnobtanium;

	public static Item toolSpearFlint;
	public static Item toolSpearIron;
	public static Item toolSpearGold;
	public static Item toolSpearCopper;
	public static Item toolSpearLead;
	public static Item toolSpearBronze;
	public static Item toolSpearSteel;
	public static Item toolSpearMythril;
	public static Item toolSpearIridium;
	public static Item toolSpearAdamantium;
	public static Item toolSpearUnobtanium;
	
	public static Item toolHammerFlint;
	public static Item toolHammerIron;
	public static Item toolHammerGold;
	public static Item toolHammerCopper;
	public static Item toolHammerLead;
	public static Item toolHammerBronze;
	public static Item toolHammerSteel;
	public static Item toolHammerMythril;
	public static Item toolHammerIridium;
	public static Item toolHammerAdamantium;
	public static Item toolHammerUnobtanium;
	
	public static Item toolAxeFlint;
	public static Item toolAxeCopper;
	public static Item toolAxeLead;
	public static Item toolAxeBronze;
	public static Item toolAxeSteel;
	public static Item toolAxeMythril;
	public static Item toolAxeIridium;
	public static Item toolAxeAdamantium;
	public static Item toolAxeUnobtanium;

	public static Item toolShovelFlint;
	public static Item toolShovelCopper;
	public static Item toolShovelLead;
	public static Item toolShovelBronze;
	public static Item toolShovelSteel;
	public static Item toolShovelMythril;
	public static Item toolShovelIridium;
	public static Item toolShovelAdamantium;
	public static Item toolShovelUnobtanium;

	public static Item toolHoeFlint;
	public static Item toolHoeCopper;
	public static Item toolHoeLead;
	public static Item toolHoeBronze;
	public static Item toolHoeSteel;
	public static Item toolHoeMythril;
	public static Item toolHoeIridium;
	public static Item toolHoeAdamantium;
	public static Item toolHoeUnobtanium;

	public static Item toolPickaxeFlint;
	public static Item toolPickaxeCopper;
	public static Item toolPickaxeLead;
	public static Item toolPickaxeBronze;
	public static Item toolPickaxeSteel;
	public static Item toolPickaxeMythril;
	public static Item toolPickaxeIridium;
	public static Item toolPickaxeAdamantium;
	public static Item toolPickaxeUnobtanium;
	
	//Armor
	public static Item armorHelmetCopper;
	public static Item armorHelmetAluminium;
	public static Item armorHelmetLead;
	public static Item armorHelmetBronze;
	public static Item armorHelmetSteel;
	public static Item armorHelmetMythril;
	public static Item armorHelmetAdamantium;
	public static Item armorHelmetUnobtanium;

	public static Item armorChestplateCopper;
	public static Item armorChestplateAluminium;
	public static Item armorChestplateLead;
	public static Item armorChestplateBronze;
	public static Item armorChestplateSteel;
	public static Item armorChestplateMythril;
	public static Item armorChestplateAdamantium;
	public static Item armorChestplateUnobtanium;

	public static Item armorLegginsCopper;
	public static Item armorLegginsAluminium;
	public static Item armorLegginsLead;
	public static Item armorLegginsBronze;
	public static Item armorLegginsSteel;
	public static Item armorLegginsMythril;
	public static Item armorLegginsAdamantium;
	public static Item armorLegginsUnobtanium;

	public static Item armorBootsCopper;
	public static Item armorBootsAluminium;
	public static Item armorBootsLead;
	public static Item armorBootsBronze;
	public static Item armorBootsSteel;
	public static Item armorBootsMythril;
	public static Item armorBootsAdamantium;
	public static Item armorBootsUnobtanium;
	
	//Buckets
	public static Item bucketWoodEmpty;
	public static Item bucketWoodWater;
	public static Item bucketWoodLava;
	public static Item bucketWoodOil;
	public static Item bucketWoodMilk;
	public static Item bucketWoodCoconutMilk;
	public static Item bucketWoodApple;
	public static Item bucketWoodBanana;
	public static Item bucketWoodCactusFruit;
	public static Item bucketWoodCherry;
	public static Item bucketWoodGrapes;
	public static Item bucketWoodLemon;
	public static Item bucketWoodOrange;
	public static Item bucketWoodPeach;
	public static Item bucketWoodPineapple;
	public static Item bucketWoodTomato;

	public static Item bucketIronEmpty;
	public static Item bucketIronWater;
	public static Item bucketIronLava;
	public static Item bucketIronOil;
	public static Item bucketIronMilk;
	public static Item bucketIronCoconutMilk;
	public static Item bucketIronApple;
	public static Item bucketIronBanana;
	public static Item bucketIronCactusFruit;
	public static Item bucketIronCherry;
	public static Item bucketIronGrapes;
	public static Item bucketIronLemon;
	public static Item bucketIronOrange;
	public static Item bucketIronPeach;
	public static Item bucketIronPineapple;
	public static Item bucketIronTomato;

	public static Item bucketCopperEmpty;
	public static Item bucketCopperWater;
	public static Item bucketCopperLava;
	public static Item bucketCopperOil;
	public static Item bucketCopperMilk;
	public static Item bucketCopperCoconutMilk;
	public static Item bucketCopperApple;
	public static Item bucketCopperBanana;
	public static Item bucketCopperCactusFruit;
	public static Item bucketCopperCherry;
	public static Item bucketCopperGrapes;
	public static Item bucketCopperLemon;
	public static Item bucketCopperOrange;
	public static Item bucketCopperPeach;
	public static Item bucketCopperPineapple;
	public static Item bucketCopperTomato;

	public static Item bucketAluminiumEmpty;
	public static Item bucketAluminiumWater;
	public static Item bucketAluminiumLava;
	public static Item bucketAluminiumOil;
	public static Item bucketAluminiumMilk;
	public static Item bucketAluminiumCoconutMilk;
	public static Item bucketAluminiumApple;
	public static Item bucketAluminiumBanana;
	public static Item bucketAluminiumCactusFruit;
	public static Item bucketAluminiumCherry;
	public static Item bucketAluminiumGrapes;
	public static Item bucketAluminiumLemon;
	public static Item bucketAluminiumOrange;
	public static Item bucketAluminiumPeach;
	public static Item bucketAluminiumPineapple;
	public static Item bucketAluminiumTomato;

	public static Item bucketLeadEmpty;
	public static Item bucketLeadWater;
	public static Item bucketLeadLava;
	public static Item bucketLeadOil;
	public static Item bucketLeadMilk;
	public static Item bucketLeadCoconutMilk;
	public static Item bucketLeadApple;
	public static Item bucketLeadBanana;
	public static Item bucketLeadCactusFruit;
	public static Item bucketLeadCherry;
	public static Item bucketLeadGrapes;
	public static Item bucketLeadLemon;
	public static Item bucketLeadOrange;
	public static Item bucketLeadPeach;
	public static Item bucketLeadPineapple;
	public static Item bucketLeadTomato;

	public static Item bucketBronzeEmpty;
	public static Item bucketBronzeWater;
	public static Item bucketBronzeLava;
	public static Item bucketBronzeOil;
	public static Item bucketBronzeMilk;
	public static Item bucketBronzeCoconutMilk;
	public static Item bucketBronzeApple;
	public static Item bucketBronzeBanana;
	public static Item bucketBronzeCactusFruit;
	public static Item bucketBronzeCherry;
	public static Item bucketBronzeGrapes;
	public static Item bucketBronzeLemon;
	public static Item bucketBronzeOrange;
	public static Item bucketBronzePeach;
	public static Item bucketBronzePineapple;
	public static Item bucketBronzeTomato;

	public static Item bucketSteelEmpty;
	public static Item bucketSteelWater;
	public static Item bucketSteelLava;
	public static Item bucketSteelOil;
	public static Item bucketSteelMilk;
	public static Item bucketSteelCoconutMilk;
	public static Item bucketSteelApple;
	public static Item bucketSteelBanana;
	public static Item bucketSteelCactusFruit;
	public static Item bucketSteelCherry;
	public static Item bucketSteelGrapes;
	public static Item bucketSteelLemon;
	public static Item bucketSteelOrange;
	public static Item bucketSteelPeach;
	public static Item bucketSteelPineapple;
	public static Item bucketSteelTomato;

	public static Item bucketMythrilEmpty;
	public static Item bucketMythrilWater;
	public static Item bucketMythrilLava;
	public static Item bucketMythrilOil;
	public static Item bucketMythrilMilk;
	public static Item bucketMythrilCoconutMilk;
	public static Item bucketMythrilApple;
	public static Item bucketMythrilBanana;
	public static Item bucketMythrilCactusFruit;
	public static Item bucketMythrilCherry;
	public static Item bucketMythrilGrapes;
	public static Item bucketMythrilLemon;
	public static Item bucketMythrilOrange;
	public static Item bucketMythrilPeach;
	public static Item bucketMythrilPineapple;
	public static Item bucketMythrilTomato;

	public static Item bucketAdamantiumEmpty;
	public static Item bucketAdamantiumWater;
	public static Item bucketAdamantiumLava;
	public static Item bucketAdamantiumOil;
	public static Item bucketAdamantiumMilk;
	public static Item bucketAdamantiumCoconutMilk;
	public static Item bucketAdamantiumApple;
	public static Item bucketAdamantiumBanana;
	public static Item bucketAdamantiumCactusFruit;
	public static Item bucketAdamantiumCherry;
	public static Item bucketAdamantiumGrapes;
	public static Item bucketAdamantiumLemon;
	public static Item bucketAdamantiumOrange;
	public static Item bucketAdamantiumPeach;
	public static Item bucketAdamantiumPineapple;
	public static Item bucketAdamantiumTomato;

	public static Item bucketUnobtaniumEmpty;
	public static Item bucketUnobtaniumWater;
	public static Item bucketUnobtaniumLava;
	public static Item bucketUnobtaniumOil;
	public static Item bucketUnobtaniumMilk;
	public static Item bucketUnobtaniumCoconutMilk;
	public static Item bucketUnobtaniumApple;
	public static Item bucketUnobtaniumBanana;
	public static Item bucketUnobtaniumCactusFruit;
	public static Item bucketUnobtaniumCherry;
	public static Item bucketUnobtaniumGrapes;
	public static Item bucketUnobtaniumLemon;
	public static Item bucketUnobtaniumOrange;
	public static Item bucketUnobtaniumPeach;
	public static Item bucketUnobtaniumPineapple;
	public static Item bucketUnobtaniumTomato;
	
	//Stuff
	public static Item stuffFur;
	public static Item stuffIvory;
	public static Item stuffHemp;
	public static Item stuffCotton;
	public static Item stuffRope;
	public static Item stuffDynamite;
	public static Item stuffClothLinen;
	public static Item stuffClothWool;
	public static Item stuffClothSilk;
	public static Item stuffGear;
	public static Item stuffCoconutFull;
	public static Item stuffCoconutEmpty;
	
	//Food
	public static Item foodCoconutFlesh;
	public static Item foodMammothMeatRaw;
	public static Item foodMammothMeatCooked;
	public static Item foodVenisonRaw;
	public static Item foodVenisonCooked;
	public static Item foodMuttonRaw;
	public static Item foodMuttonCooked;
	public static Item foodCrabMeatRaw;
	public static Item foodCrabMeatCooked;
	public static Item foodCalamariRaw;
	public static Item foodCalamariCooked;
	public static Item foodBanana;
	public static Item foodLemon;
	public static Item foodCherry;
	public static Item foodOrange;
	public static Item foodPeach;
	public static Item foodCactusFruit;
	public static Item foodTurnip;
	public static Item foodGrapes;
	public static Item foodOnion;
	public static Item foodPineapple;
	public static Item foodTomato;
	public static Item foodCabbage;
	public static Item foodRice;
	public static Item foodMaise;
	public static Item foodCoffeeBeans;
	public static Item foodPeas;
	public static Item foodPickles;
	public static Item foodCheeseWheel;
	public static Item foodCheese;
	public static Item foodRiceball;
	public static Item foodRiceBowl;
	public static Item foodSalad;
	public static Item foodFruitSalad;
	public static Item foodBurger;
	public static Item foodCheeseBurger;
	public static Item foodKebab;
	public static Item foodDungeonFilet;
	public static Item foodStirFry;
	public static Item foodFriedRice;
	public static Item foodSavoryPancake;
	public static Item foodFrenchFries;
	public static Item foodCroquette;
	public static Item foodPopcorn;
	public static Item foodScrambledEggs;
	public static Item foodOmelet;
	public static Item foodOmeletRice;
	public static Item foodAppleSouffle;
	public static Item foodCurryBread;
	public static Item foodFrenchToast;
	public static Item foodDoughnut;
	public static Item foodFriedNoodles;
	public static Item foodTempura;
	public static Item foodPancake;
	public static Item foodPotSticker;
	public static Item foodRisotto;
	public static Item foodDryCurry;
	public static Item foodPumpkinStew;
	public static Item foodFishStew;
	public static Item foodBoiledEgg;
	public static Item foodDumplings;
	public static Item foodCheeseFondue;
	public static Item foodNoodles;
	public static Item foodCurryNoodles;
	public static Item foodTempuraNoodles;
	public static Item foodMountainStew;
	public static Item foodRiceSoup;
	public static Item foodPorridge;
	public static Item foodTempuraRice;
	public static Item foodEggOverRice;
	public static Item foodStew;
	public static Item foodCurryRice;
	public static Item foodBakedCorn;
	public static Item foodToastedRiceBall;
	public static Item foodToast;
	public static Item foodDinnerRoll;
	public static Block foodPizza;
	public static Item foodDoria;
	public static Item foodGratin;
	public static Block foodChocolateCake;
	public static Block foodCheesecake;
	public static Block foodApplePie;
	public static Item foodSteamedBun;
	public static Item foodCheeseSteamedBun;
	public static Item foodShaomai;
	public static Item foodSteamedEgg;
	public static Item foodChineseBun;
	public static Item foodCurryBun;
	public static Item foodSteamedDumplings;
	public static Item foodSpongeCake;
	public static Item foodSteamedCake;
	public static Item foodPudding;
	public static Item foodPumpkinPudding;
	public static Item foodSandwich;
	public static Item foodFruitSandwich;
	public static Item foodPickledTurnip;
	public static Item foodPickledCucumber;
	public static Item foodBambooRice;
	public static Item foodMushroomRice;
	public static Item foodSushi;
	public static Item foodRaisinBread;
	public static Item foodChirashiSushi;
	public static Item foodIceCream;
	public static Item foodSeaSaltIceCream;
	public static Item foodKrabbyPatty;
	
	//Juice
	public static Item juiceOil;
	public static Item juiceApple;
	public static Item juiceBanana;
	public static Item juiceCactus;
	public static Item juiceCherry;
	public static Item juiceChocolateMilk;
	public static Item juiceCoconutMilk;
	public static Item juiceCoffee;
	public static Item juiceGrapes;
	public static Item juiceLemon;
	public static Item juiceMilk;
	public static Item juiceOrange;
	public static Item juicePeach;
	public static Item juicePineapple;
	public static Item juiceTomato;
	
	//Liquor
	public static Item liquorCoconutRum;
	public static Item liquorCider;
	public static Item liquorRum;
	public static Item liquorBeer;
	public static Item liquorSalgam;
	public static Item liquorVodka;
	public static Item liquorCactusJack;
	public static Item liquorSake;
	public static Item liquorMead;
	public static Item liquorWineGrapes;
	public static Item liquorWineCherry;
	public static Item liquorWinePineapple;
	
	//Crops
	public static Block cropTurnip;
	public static Block cropGrapes;
	public static Block cropOnion;
	public static Block cropPineapple;
	public static Block cropTomato;
	public static Block cropCabbage;
	public static Block cropRice;
	public static Block cropMaise;
	public static Block cropCoffeeBeans;
	public static Block cropPeas;
	public static Block cropPickles;
	public static Block cropGoldenCarrot;
	public static Block cropHemp;
	public static Block cropCotton;
	public static Block cropCoconut;
	public static Block cropBanana;
	
	//Seeds
	public static Item seedsWild;
	public static Item seedsTurnip;
	public static Item seedsGrapes;
	public static Item seedsOnion;
	public static Item seedsPineapple;
	public static Item seedsTomato;
	public static Item seedsCabbage;
	public static Item seedsRice;
	public static Item seedsMaise;
	public static Item seedsCoffeeBeans;
	public static Item seedsPeas;
	public static Item seedsPickles;
	public static Item seedsHemp;
	public static Item seedsCotton;
	
	//Tree
	public static Block aceLog;
	public static Block acePlanks;
	public static Block leavesCherryEmpty;
	public static Block leavesCherryBlossom;
	public static Block leavesCherryFruit;
	public static Block leavesLemonEmpty;
	public static Block leavesLemonBlossom;
	public static Block leavesLemonFruit;
	public static Block leavesOrangeEmpty;
	public static Block leavesOrangeBlossom;
	public static Block leavesOrangeFruit;
	public static Block leavesPeachEmpty;
	public static Block leavesPeachBlossom;
	public static Block leavesPeachFruit;
	public static Block leavesAppleEmpty;
	public static Block leavesAppleBlossom;
	public static Block leavesAppleFruit;
	public static Block leavesGoldenEmpty;
	public static Block leavesGoldenBlossom;
	public static Block leavesGoldenFruit;
	public static Block leavesPalmTree;
	public static Block aceSapling;
	
	//Beds
	public static Block bedBlack;
	public static Block bedBlue;
	public static Block bedBrown;
	public static Block bedCyan;
	public static Block bedGreen;
	public static Block bedGrey;
	public static Block bedLightBlue;
	public static Block bedLime;
	public static Block bedMagenta;
	public static Block bedOrange;
	public static Block bedPink;
	public static Block bedPurple;
	public static Block bedRed;
	public static Block bedSilver;
	public static Block bedWhite;
	public static Block bedYellow;
	
	//Advanced Constructions
	public static Block machinaBlastFurnaceIdle;
	public static Block machinaBlastFurnaceActive;
	public static Block machinaWorkbench;
	public static Block machinaSewingStation;
	public static Block machinaAnvilIron;
	public static Block machinaAnvilCopper;
	public static Block machinaAnvilAluminium;
	public static Block machinaAnvilLead;
	public static Block machinaAnvilBronze;
	public static Block machinaAnvilSteel;
	public static Block machinaAnvilMythril;
	public static Block machinaAnvilAdamantium;
	public static Block machinaAnvilUnobtanium;
	public static Block machinaStove;
	public static Block machinaBonfireIdle;
	public static Block machinaBonfireActive;
	public static Block machinaKeg;
	public static Block machinaDistilleryIdle;
	public static Block machinaDistilleryActive;
	public static Block machinaAnchor;
	public static Block machinaRope;
	public static Block machinaGlobe;
	public static Block machinaPodium;
	public static Block machinaIngotBasin;
	public static Block machinaGearBox;
	public static Block machinaWindmillWool;
	public static Block machinaWindmillLeather;
	public static Block machinaWaterwheel;
	public static Block machinaAxle;
	public static Block machinaFruitPress;
	public static Block machinaMillstone;
	public static Block machinaBoilerIdle;
	public static Block machinaBoilerActive;
	public static Block machinaPipeStraightLead;
	public static Block machinaPipeCurveLead;
	public static Block machinaPipeCrossingLead;
	public static Block machinaPipeStraightBronze;
	public static Block machinaPipeCurveBronze;
	public static Block machinaPipeCrossingBronze;
	public static Block machinaSteamVentLead;
	public static Block machinaSteamVentBronze;
	public static Block machinaTurbine;
	public static Block machinaGenerator;
	public static Block machinaBellows;
	public static Block machinaSolarCollector;
	public static Block machinaCable;
	public static Block machinaEnergyNode;
	public static Block machinaBattery;
	public static Block machinaMotor;
	
	//Scaffolding
	public static Block scaffoldingAcacia;
	public static Block scaffoldingBigOak;
	public static Block scaffoldingBirch;
	public static Block scaffoldingJungle;
	public static Block scaffoldingOak;
	public static Block scaffoldingSpruce;
	public static Block scaffoldingFruit;
	public static Block scaffoldingGolden;
	public static Block scaffoldingPalm;
	public static Block scaffoldingAdamantium;
	public static Block scaffoldingAluminium;
	public static Block scaffoldingBronze;
	public static Block scaffoldingCopper;
	public static Block scaffoldingIron;
	public static Block scaffoldingMythril;
	public static Block scaffoldingSteel;
	public static Block scaffoldingUnobtanium;
	
	//Roof
	public static Block roofAcaciaStraw;
	public static Block roofAcaciaReeds;
	public static Block roofAcaciaClay;
	public static Block roofAcaciaCopper;
	public static Block roofAcaciaTin;
	public static Block roofAcaciaBrass;
	public static Block roofAcaciaGold;
	public static Block roofAcaciaMythril;
	public static Block roofAcaciaOrichalcum;
	public static Block roofAcaciaNether;

	public static Block roofBigOakStraw;
	public static Block roofBigOakReeds;
	public static Block roofBigOakClay;
	public static Block roofBigOakCopper;
	public static Block roofBigOakTin;
	public static Block roofBigOakBrass;
	public static Block roofBigOakGold;
	public static Block roofBigOakMythril;
	public static Block roofBigOakOrichalcum;
	public static Block roofBigOakNether;

	public static Block roofBirchStraw;
	public static Block roofBirchReeds;
	public static Block roofBirchClay;
	public static Block roofBirchCopper;
	public static Block roofBirchTin;
	public static Block roofBirchBrass;
	public static Block roofBirchGold;
	public static Block roofBirchMythril;
	public static Block roofBirchOrichalcum;
	public static Block roofBirchNether;

	public static Block roofJungleStraw;
	public static Block roofJungleReeds;
	public static Block roofJungleClay;
	public static Block roofJungleCopper;
	public static Block roofJungleTin;
	public static Block roofJungleBrass;
	public static Block roofJungleGold;
	public static Block roofJungleMythril;
	public static Block roofJungleOrichalcum;
	public static Block roofJungleNether;

	public static Block roofOakStraw;
	public static Block roofOakReeds;
	public static Block roofOakClay;
	public static Block roofOakCopper;
	public static Block roofOakTin;
	public static Block roofOakBrass;
	public static Block roofOakGold;
	public static Block roofOakMythril;
	public static Block roofOakOrichalcum;
	public static Block roofOakNether;

	public static Block roofSpruceStraw;
	public static Block roofSpruceReeds;
	public static Block roofSpruceClay;
	public static Block roofSpruceCopper;
	public static Block roofSpruceTin;
	public static Block roofSpruceBrass;
	public static Block roofSpruceGold;
	public static Block roofSpruceMythril;
	public static Block roofSpruceOrichalcum;
	public static Block roofSpruceNether;

	public static Block roofFruitStraw;
	public static Block roofFruitReeds;
	public static Block roofFruitClay;
	public static Block roofFruitCopper;
	public static Block roofFruitTin;
	public static Block roofFruitBrass;
	public static Block roofFruitGold;
	public static Block roofFruitMythril;
	public static Block roofFruitOrichalcum;
	public static Block roofFruitNether;

	public static Block roofGoldenStraw;
	public static Block roofGoldenReeds;
	public static Block roofGoldenClay;
	public static Block roofGoldenCopper;
	public static Block roofGoldenTin;
	public static Block roofGoldenBrass;
	public static Block roofGoldenGold;
	public static Block roofGoldenMythril;
	public static Block roofGoldenOrichalcum;
	public static Block roofGoldenNether;

	public static Block roofPalmStraw;
	public static Block roofPalmReeds;
	public static Block roofPalmClay;
	public static Block roofPalmCopper;
	public static Block roofPalmTin;
	public static Block roofPalmBrass;
	public static Block roofPalmGold;
	public static Block roofPalmMythril;
	public static Block roofPalmOrichalcum;
	public static Block roofPalmNether;

	public static Block roofBrickStraw;
	public static Block roofBrickReeds;
	public static Block roofBrickClay;
	public static Block roofBrickCopper;
	public static Block roofBrickTin;
	public static Block roofBrickBrass;
	public static Block roofBrickGold;
	public static Block roofBrickMythril;
	public static Block roofBrickOrichalcum;
	public static Block roofBrickNether;

	public static Block roofCobblestoneStraw;
	public static Block roofCobblestoneReeds;
	public static Block roofCobblestoneClay;
	public static Block roofCobblestoneCopper;
	public static Block roofCobblestoneTin;
	public static Block roofCobblestoneBrass;
	public static Block roofCobblestoneGold;
	public static Block roofCobblestoneMythril;
	public static Block roofCobblestoneOrichalcum;
	public static Block roofCobblestoneNether;

	public static Block roofCobblestoneMossyStraw;
	public static Block roofCobblestoneMossyReeds;
	public static Block roofCobblestoneMossyClay;
	public static Block roofCobblestoneMossyCopper;
	public static Block roofCobblestoneMossyTin;
	public static Block roofCobblestoneMossyBrass;
	public static Block roofCobblestoneMossyGold;
	public static Block roofCobblestoneMossyMythril;
	public static Block roofCobblestoneMossyOrichalcum;
	public static Block roofCobblestoneMossyNether;

	public static Block roofStonebrickStraw;
	public static Block roofStonebrickReeds;
	public static Block roofStonebrickClay;
	public static Block roofStonebrickCopper;
	public static Block roofStonebrickTin;
	public static Block roofStonebrickBrass;
	public static Block roofStonebrickGold;
	public static Block roofStonebrickMythril;
	public static Block roofStonebrickOrichalcum;
	public static Block roofStonebrickNether;

	public static Block roofStonebrickMossyStraw;
	public static Block roofStonebrickMossyReeds;
	public static Block roofStonebrickMossyClay;
	public static Block roofStonebrickMossyCopper;
	public static Block roofStonebrickMossyTin;
	public static Block roofStonebrickMossyBrass;
	public static Block roofStonebrickMossyGold;
	public static Block roofStonebrickMossyMythril;
	public static Block roofStonebrickMossyOrichalcum;
	public static Block roofStonebrickMossyNether;

	public static Block roofSandstoneStraw;
	public static Block roofSandstoneReeds;
	public static Block roofSandstoneClay;
	public static Block roofSandstoneCopper;
	public static Block roofSandstoneTin;
	public static Block roofSandstoneBrass;
	public static Block roofSandstoneGold;
	public static Block roofSandstoneMythril;
	public static Block roofSandstoneOrichalcum;
	public static Block roofSandstoneNether;

	public static Block roofNetherStraw;
	public static Block roofNetherReeds;
	public static Block roofNetherClay;
	public static Block roofNetherCopper;
	public static Block roofNetherTin;
	public static Block roofNetherBrass;
	public static Block roofNetherGold;
	public static Block roofNetherMythril;
	public static Block roofNetherOrichalcum;
	public static Block roofNetherNether;

	public static Block roofQuartzStraw;
	public static Block roofQuartzReeds;
	public static Block roofQuartzClay;
	public static Block roofQuartzCopper;
	public static Block roofQuartzTin;
	public static Block roofQuartzBrass;
	public static Block roofQuartzGold;
	public static Block roofQuartzMythril;
	public static Block roofQuartzOrichalcum;
	public static Block roofQuartzNether;
	
	//GUIs
	public static final int guiIDBlastFurnace  =  0;
	public static final int guiIDWorkbench     =  1;
	public static final int guiIDSewingStation =  2;
	public static final int guiIDAnvilCrafting =  3;
	public static final int guiIDAnvilRepair   =  4;
	public static final int guiIDStove         =  5;
	public static final int guiIDBonfire       =  6;
	public static final int guiIDKeg           =  7;
	public static final int guiIDFruitPress    =  8;
	public static final int guiIDMillstone     =  9;
	public static final int guiIDDistillery    = 10;
	public static final int guiIDBoiler        = 11;
	
	public void PreInit(){
		
		//Loaded Mods
		loadedBiomesOPlenty = Loader.isModLoaded("BiomesOPlenty");
		loadedMillenaire    = Loader.isModLoaded("millenaire");
		
		//Creative Tabs
		acetabCommon = new CreativeTabs("AceCraft"){
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem(){
				return nuggetCopper;
			}
		};
		acetabMachina = new CreativeTabs("Machina"){
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem(){
				return machinaGlobe.getItem(null, 0, 0, 0);
			}
		};
		acetabRoof = new CreativeTabs("Roof"){
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem(){
				return roofAcaciaStraw.getItem(null, 0, 0, 0);
			}
		};
		
		//Mineral Blocks
		greenhillEarth = new GreenHillBlock(Material.ground, false).setBlockName("GreenHillEarth"); GameRegistry.registerBlock(greenhillEarth, "GreenHillEarth");
		greenhillGrass = new GreenHillBlock(Material.grass,  true) .setBlockName("GreenHillGrass"); GameRegistry.registerBlock(greenhillGrass, "GreenHillGrass");
		greenhillStone = new GreenHillBlock(Material.rock,   false).setBlockName("GreenHillStone"); GameRegistry.registerBlock(greenhillStone, "GreenHillStone");
		greenhillMoss  = new GreenHillBlock(Material.leaves, true) .setBlockName("GreenHillMoss" ); GameRegistry.registerBlock(greenhillMoss,  "GreenHillMoss" );
		
		//Ore Blocks
		oreSalt       = new OreBlock(1).setBlockName("OreSalt");       GameRegistry.registerBlock(oreSalt,       "OreSalt"      );
		oreSulfur     = new OreBlock(1).setBlockName("OreSulfur");     GameRegistry.registerBlock(oreSulfur,     "OreSulfur"    );
		oreCopper     = new OreBlock(1).setBlockName("OreCopper");     GameRegistry.registerBlock(oreCopper,     "OreCopper"    );
		oreBauxite    = new OreBlock(1).setBlockName("OreBauxite");    GameRegistry.registerBlock(oreBauxite,    "OreBauxite"   );
		oreLead       = new OreBlock(1).setBlockName("OreLead");       GameRegistry.registerBlock(oreLead,       "OreLead"      );
		oreTin        = new OreBlock(1).setBlockName("OreTin");        GameRegistry.registerBlock(oreTin,        "OreTin"       );
		oreZinc       = new OreBlock(1).setBlockName("OreZinc");       GameRegistry.registerBlock(oreZinc,       "OreZinc"      );
		oreSilver     = new OreBlock(1).setBlockName("OreSilver");     GameRegistry.registerBlock(oreSilver,     "OreSilver"    );
		oreMythril    = new OreBlock(2).setBlockName("OreMythril");    GameRegistry.registerBlock(oreMythril,    "OreMythril"   );
		oreIridium    = new OreBlock(3).setBlockName("OreIridium");    GameRegistry.registerBlock(oreIridium,    "OreIridium"   );
		oreAdamantium = new OreBlock(3).setBlockName("OreAdamantium"); GameRegistry.registerBlock(oreAdamantium, "OreAdamantium");
		oreOrichalcum = new OreBlock(3).setBlockName("OreOrichalcum"); GameRegistry.registerBlock(oreOrichalcum, "OreOrichalcum");
		oreUnobtanium = new OreBlock(4).setBlockName("OreUnobtanium"); GameRegistry.registerBlock(oreUnobtanium, "OreUnobtanium");
		oreRuby       = new OreBlock(2).setBlockName("OreRuby");       GameRegistry.registerBlock(oreRuby,       "OreRuby"      );
		orePeridot    = new OreBlock(2).setBlockName("OrePeridot");    GameRegistry.registerBlock(orePeridot,    "OrePeridot"   );
		oreTopaz      = new OreBlock(2).setBlockName("OreTopaz");      GameRegistry.registerBlock(oreTopaz,      "OreTopaz"     );
		oreSaphire    = new OreBlock(2).setBlockName("OreSaphire");    GameRegistry.registerBlock(oreSaphire,    "OreSaphire"   );
		oreAzurit     = new OreBlock(2).setBlockName("OreAzurit");     GameRegistry.registerBlock(oreAzurit,     "OreAzurit"    );
		oreAmber      = new OreBlock(2).setBlockName("OreAmber");      GameRegistry.registerBlock(oreAmber,      "OreAmber"     );
		oreAmethyst   = new OreBlock(2).setBlockName("OreAmethyst");   GameRegistry.registerBlock(oreAmethyst,   "OreAmethyst"  );
		oreGagat      = new OreBlock(2).setBlockName("OreGagat");      GameRegistry.registerBlock(oreGagat,      "OreGagat"     );
		oreOpal       = new OreBlock(2).setBlockName("OreOpal");       GameRegistry.registerBlock(oreOpal,       "OreOpal"      );
		oreJade       = new OreBlock(2).setBlockName("OreJade");       GameRegistry.registerBlock(oreJade,       "OreJade"      );
		oreTurquoise  = new OreBlock(2).setBlockName("OreTurquoise");  GameRegistry.registerBlock(oreTurquoise,  "OreTurquoise" );
		
		oreIridium.setLightLevel(0.5F);
		
		//Full Blocks
		blockMeteor     = new BlockBlock(Material.rock).setBlockName("BlockMeteor");     GameRegistry.registerBlock(blockMeteor,     "BlockMeteor"    );
		blockCopper     = new BlockBlock(Material.rock).setBlockName("BlockCopper");     GameRegistry.registerBlock(blockCopper,     "BlockCopper"    );
		blockAluminium  = new BlockBlock(Material.rock).setBlockName("BlockAluminium");  GameRegistry.registerBlock(blockAluminium,  "BlockAluminium" );
		blockLead       = new BlockBlock(Material.rock).setBlockName("BlockLead");       GameRegistry.registerBlock(blockLead,       "BlockLead"      );
		blockTin        = new BlockBlock(Material.rock).setBlockName("BlockTin");        GameRegistry.registerBlock(blockTin,        "BlockTin"       );
		blockZinc       = new BlockBlock(Material.rock).setBlockName("BlockZinc");       GameRegistry.registerBlock(blockZinc,       "BlockZinc"      );
		blockSilver     = new BlockBlock(Material.rock).setBlockName("BlockSilver");     GameRegistry.registerBlock(blockSilver,     "BlockSilver"    );
		blockMythril    = new BlockBlock(Material.rock).setBlockName("BlockMythril");    GameRegistry.registerBlock(blockMythril,    "BlockMythril"   );
		blockIridium    = new BlockBlock(Material.rock).setBlockName("BlockIridium");    GameRegistry.registerBlock(blockIridium,    "BlockIridium"   );
		blockAdamantium = new BlockBlock(Material.rock).setBlockName("BlockAdamantium"); GameRegistry.registerBlock(blockAdamantium, "BlockAdamantium");
		blockOrichalcum = new BlockBlock(Material.rock).setBlockName("BlockOrichalcum"); GameRegistry.registerBlock(blockOrichalcum, "BlockOrichalcum");
		blockUnobtanium = new BlockBlock(Material.rock).setBlockName("BlockUnobtanium"); GameRegistry.registerBlock(blockUnobtanium, "BlockUnobtanium");
		blockBronze     = new BlockBlock(Material.rock).setBlockName("BlockBronze");     GameRegistry.registerBlock(blockBronze,     "BlockBronze"    );
		blockSteel      = new BlockBlock(Material.rock).setBlockName("BlockSteel");      GameRegistry.registerBlock(blockSteel,      "BlockSteel"     );
		blockBrass      = new BlockBlock(Material.rock).setBlockName("BlockBrass");      GameRegistry.registerBlock(blockBrass,      "BlockBrass"     );
		blockSalt       = new BlockBlock(Material.rock).setBlockName("BlockSalt");       GameRegistry.registerBlock(blockSalt,       "BlockSalt"      );
		blockSulfur     = new BlockBlock(Material.rock).setBlockName("BlockSulfur");     GameRegistry.registerBlock(blockSulfur,     "BlockSulfur"    );
		blockFlour      = new BlockBlock(Material.rock).setBlockName("BlockFlour");      GameRegistry.registerBlock(blockFlour,      "BlockFlour"     );
		blockCoffee     = new BlockBlock(Material.rock).setBlockName("BlockCoffee");     GameRegistry.registerBlock(blockCoffee,     "BlockCoffee"    );
		blockRuby       = new BlockBlock(Material.rock).setBlockName("BlockRuby");       GameRegistry.registerBlock(blockRuby,       "BlockRuby"      );
		blockPeridot    = new BlockBlock(Material.rock).setBlockName("BlockPeridot");    GameRegistry.registerBlock(blockPeridot,    "BlockPeridot"   );
		blockTopaz      = new BlockBlock(Material.rock).setBlockName("BlockTopaz");      GameRegistry.registerBlock(blockTopaz,      "BlockTopaz"     );
		blockSaphire    = new BlockBlock(Material.rock).setBlockName("BlockSaphire");    GameRegistry.registerBlock(blockSaphire,    "BlockSaphire"   );
		blockAzurit     = new BlockBlock(Material.rock).setBlockName("BlockAzurit");     GameRegistry.registerBlock(blockAzurit,     "BlockAzurit"    );
		blockAmber      = new BlockBlock(Material.rock).setBlockName("BlockAmber");      GameRegistry.registerBlock(blockAmber,      "BlockAmber"     );
		blockAmethyst   = new BlockBlock(Material.rock).setBlockName("BlockAmethyst");   GameRegistry.registerBlock(blockAmethyst,   "BlockAmethyst"  );
		blockGagat      = new BlockBlock(Material.rock).setBlockName("BlockGagat");      GameRegistry.registerBlock(blockGagat,      "BlockGagat"     );
		blockOpal       = new BlockBlock(Material.rock).setBlockName("BlockOpal");       GameRegistry.registerBlock(blockOpal,       "BlockOpal"      );
		blockJade       = new BlockBlock(Material.rock).setBlockName("BlockJade");       GameRegistry.registerBlock(blockJade,       "BlockJade"      );
		blockTurquoise  = new BlockBlock(Material.rock).setBlockName("BlockTurquoise");  GameRegistry.registerBlock(blockTurquoise,  "BlockTurquoise" );
		
		//Mino Blocks
		minoBlank   = new MinoBlock().setBlockName("MinoBlank");   GameRegistry.registerBlock(minoBlank,   "MinoBlank"  );
		minoFire    = new MinoBlock().setBlockName("MinoFire");    GameRegistry.registerBlock(minoFire,    "MinoFire"   );
		minoAir     = new MinoBlock().setBlockName("MinoAir");     GameRegistry.registerBlock(minoAir,     "MinoAir"    );
		minoThunder = new MinoBlock().setBlockName("MinoThunder"); GameRegistry.registerBlock(minoThunder, "MinoThunder");
		minoWater   = new MinoBlock().setBlockName("MinoWater");   GameRegistry.registerBlock(minoWater,   "MinoWater"  );
		minoIce     = new MinoBlock().setBlockName("MinoIce");     GameRegistry.registerBlock(minoIce,     "MinoIce"    );
		minoEarth   = new MinoBlock().setBlockName("MinoEarth");   GameRegistry.registerBlock(minoEarth,   "MinoEarth"  );
		minoMetal   = new MinoBlock().setBlockName("MinoMetal");   GameRegistry.registerBlock(minoMetal,   "MinoMetal"  );
		minoNature  = new MinoBlock().setBlockName("MinoNature");  GameRegistry.registerBlock(minoNature,  "MinoNature" );
		minoLight   = new MinoBlock().setBlockName("MinoLight");   GameRegistry.registerBlock(minoLight,   "MinoLight"  );
		minoDark    = new MinoBlock().setBlockName("MinoDark");    GameRegistry.registerBlock(minoDark,    "MinoDark"   );
		
		//Nuggets
		nuggetIron       = new AceNugget().setUnlocalizedName("NuggetIron");       GameRegistry.registerItem(nuggetIron,       "NuggetIron"      );
		nuggetGold       = new AceNugget().setUnlocalizedName("NuggetGold");       GameRegistry.registerItem(nuggetGold,       "NuggetGold"      );
		nuggetCopper     = new AceNugget().setUnlocalizedName("NuggetCopper");     GameRegistry.registerItem(nuggetCopper,     "NuggetCopper"    );
		nuggetBauxite    = new AceNugget().setUnlocalizedName("NuggetBauxite");    GameRegistry.registerItem(nuggetBauxite,    "NuggetBauxite"   );
		nuggetLead       = new AceNugget().setUnlocalizedName("NuggetLead");       GameRegistry.registerItem(nuggetLead,       "NuggetLead"      );
		nuggetTin        = new AceNugget().setUnlocalizedName("NuggetTin");        GameRegistry.registerItem(nuggetTin,        "NuggetTin"       );
		nuggetZinc       = new AceNugget().setUnlocalizedName("NuggetZinc");       GameRegistry.registerItem(nuggetZinc,       "NuggetZinc"      );
		nuggetSilver     = new AceNugget().setUnlocalizedName("NuggetSilver");     GameRegistry.registerItem(nuggetSilver,     "NuggetSilver"    );
		nuggetMythril    = new AceNugget().setUnlocalizedName("NuggetMythril");    GameRegistry.registerItem(nuggetMythril,    "NuggetMythril"   );
		nuggetIridium    = new AceNugget().setUnlocalizedName("NuggetIridium");    GameRegistry.registerItem(nuggetIridium,    "NuggetIridium"   );
		nuggetAdamantium = new AceNugget().setUnlocalizedName("NuggetAdamantium"); GameRegistry.registerItem(nuggetAdamantium, "NuggetAdamantium");
		nuggetOrichalcum = new AceNugget().setUnlocalizedName("NuggetOrichalcum"); GameRegistry.registerItem(nuggetOrichalcum, "NuggetOrichalcum");
		nuggetUnobtanium = new AceNugget().setUnlocalizedName("NuggetUnobtanium"); GameRegistry.registerItem(nuggetUnobtanium, "NuggetUnobtanium");
		
		//Ingots
		ingotCopper     = new AceItems(true).setUnlocalizedName("IngotCopper");     GameRegistry.registerItem(ingotCopper,     "IngotCopper"    );
		ingotAluminium  = new AceItems(true).setUnlocalizedName("IngotAluminium");  GameRegistry.registerItem(ingotAluminium,  "IngotAluminium" );
		ingotLead       = new AceItems(true).setUnlocalizedName("IngotLead");       GameRegistry.registerItem(ingotLead,       "IngotLead"      );
		ingotTin        = new AceItems(true).setUnlocalizedName("IngotTin");        GameRegistry.registerItem(ingotTin,        "IngotTin"       );
		ingotZinc       = new AceItems(true).setUnlocalizedName("IngotZinc");       GameRegistry.registerItem(ingotZinc,       "IngotZinc"      );
		ingotSilver     = new AceItems(true).setUnlocalizedName("IngotSilver");     GameRegistry.registerItem(ingotSilver,     "IngotSilver"    );
		ingotMythril    = new AceItems(true).setUnlocalizedName("IngotMythril");    GameRegistry.registerItem(ingotMythril,    "IngotMythril"   );
		ingotIridium    = new AceItems(true).setUnlocalizedName("IngotIridium");    GameRegistry.registerItem(ingotIridium,    "IngotIridium"   );
		ingotAdamantium = new AceItems(true).setUnlocalizedName("IngotAdamantium"); GameRegistry.registerItem(ingotAdamantium, "IngotAdamantium");
		ingotOrichalcum = new AceItems(true).setUnlocalizedName("IngotOrichalcum"); GameRegistry.registerItem(ingotOrichalcum, "IngotOrichalcum");
		ingotUnobtanium = new AceItems(true).setUnlocalizedName("IngotUnobtanium"); GameRegistry.registerItem(ingotUnobtanium, "IngotUnobtanium");
		ingotBronze     = new AceItems(true).setUnlocalizedName("IngotBronze");     GameRegistry.registerItem(ingotBronze,     "IngotBronze"    );
		ingotSteel      = new AceItems(true).setUnlocalizedName("IngotSteel");      GameRegistry.registerItem(ingotSteel,      "IngotSteel"     );
		ingotBrass      = new AceItems(true).setUnlocalizedName("IngotBrass");      GameRegistry.registerItem(ingotBrass,      "IngotBrass"     );
		
		//Gemstones
		gemstoneRuby      = new AceItems(true).setUnlocalizedName("GemstoneRuby");      GameRegistry.registerItem(gemstoneRuby,      "GemstoneRuby"     );
		gemstonePeridot   = new AceItems(true).setUnlocalizedName("GemstonePeridot");   GameRegistry.registerItem(gemstonePeridot,   "GemstonePeridot"  );
		gemstoneTopaz     = new AceItems(true).setUnlocalizedName("GemstoneTopaz");     GameRegistry.registerItem(gemstoneTopaz,     "GemstoneTopaz"    );
		gemstoneSaphire   = new AceItems(true).setUnlocalizedName("GemstoneSaphire");   GameRegistry.registerItem(gemstoneSaphire,   "GemstoneSaphire"  );
		gemstoneAzurit    = new AceItems(true).setUnlocalizedName("GemstoneAzurit");    GameRegistry.registerItem(gemstoneAzurit,    "GemstoneAzurit"   );
		gemstoneAmber     = new AceItems(true).setUnlocalizedName("GemstoneAmber");     GameRegistry.registerItem(gemstoneAmber,     "GemstoneAmber"    );
		gemstoneAmethyst  = new AceItems(true).setUnlocalizedName("GemstoneAmethyst");  GameRegistry.registerItem(gemstoneAmethyst,  "GemstoneAmethyst" );
		gemstoneGagat     = new AceItems(true).setUnlocalizedName("GemstoneGagat");     GameRegistry.registerItem(gemstoneGagat,     "GemstoneGagat"    );
		gemstoneOpal      = new AceItems(true).setUnlocalizedName("GemstoneOpal");      GameRegistry.registerItem(gemstoneOpal,      "GemstoneOpal"     );
		gemstoneJade      = new AceItems(true).setUnlocalizedName("GemstoneJade");      GameRegistry.registerItem(gemstoneJade,      "GemstoneJade"     );
		gemstoneTurquoise = new AceItems(true).setUnlocalizedName("GemstoneTurquoise"); GameRegistry.registerItem(gemstoneTurquoise, "GemstoneTurquoise");
		
		//Powders
		powderSalt       = new AceItems(true).setUnlocalizedName("PowderSalt");       GameRegistry.registerItem(powderSalt,       "PowderSalt"      );
		powderSulfur     = new AceItems(true).setUnlocalizedName("PowderSulfur");     GameRegistry.registerItem(powderSulfur,     "PowderSulfur"    );
		powderOrichalcum = new AceItems(true).setUnlocalizedName("PowderOrichalcum"); GameRegistry.registerItem(powderOrichalcum, "PowderOrichalcum");
		powderFlour      = new AceItems(true).setUnlocalizedName("PowderFlour");      GameRegistry.registerItem(powderFlour,      "PowderFlour"     );
		powderCoffee     = new AceItems(true).setUnlocalizedName("PowderCoffee");     GameRegistry.registerItem(powderCoffee,     "PowderCoffee"    );
		
		//Tools
		toolFryingPan = new ToolsSword(ToolMaterial.IRON).setUnlocalizedName("ToolFryingPan"); GameRegistry.registerItem(toolFryingPan, "ToolFryingPan");
		
		toolSwordFlint      = new ToolsSword(materialToolFlint)     .setUnlocalizedName("ToolSwordFlint");      GameRegistry.registerItem(toolSwordFlint,      "ToolSwordFlint"     );
		toolSwordCopper     = new ToolsSword(materialToolCopper)    .setUnlocalizedName("ToolSwordCopper");     GameRegistry.registerItem(toolSwordCopper,     "ToolSwordCopper"    );
		toolSwordLead       = new ToolsSword(materialToolLead)      .setUnlocalizedName("ToolSwordLead");       GameRegistry.registerItem(toolSwordLead,       "ToolSwordLead"      );
		toolSwordBronze     = new ToolsSword(materialToolBronze)    .setUnlocalizedName("ToolSwordBronze");     GameRegistry.registerItem(toolSwordBronze,     "ToolSwordBronze"    );
		toolSwordSteel      = new ToolsSword(materialToolSteel)     .setUnlocalizedName("ToolSwordSteel");      GameRegistry.registerItem(toolSwordSteel,      "ToolSwordSteel"     );
		toolSwordMythril    = new ToolsSword(materialToolMythril)   .setUnlocalizedName("ToolSwordMythril");    GameRegistry.registerItem(toolSwordMythril,    "ToolSwordMythril"   );
		toolSwordIridium    = new ToolsSword(materialToolIridium)   .setUnlocalizedName("ToolSwordIridium");    GameRegistry.registerItem(toolSwordIridium,    "ToolSwordIridium"   );
		toolSwordAdamantium = new ToolsSword(materialToolAdamantium).setUnlocalizedName("ToolSwordAdamantium"); GameRegistry.registerItem(toolSwordAdamantium, "ToolSwordAdamantium");
		toolSwordUnobtanium = new ToolsSword(materialToolUnobtanium).setUnlocalizedName("ToolSwordUnobtanium"); GameRegistry.registerItem(toolSwordUnobtanium, "ToolSwordUnobtanium");
		
		toolSpearFlint      = new ToolsSpear(materialToolFlint)     .setUnlocalizedName("ToolSpearFlint");      GameRegistry.registerItem(toolSpearFlint,      "ToolSpearFlint"     );
		toolSpearIron       = new ToolsSpear(ToolMaterial.IRON)     .setUnlocalizedName("ToolSpearIron");       GameRegistry.registerItem(toolSpearIron,       "ToolSpearIron"      );
		toolSpearGold       = new ToolsSpear(ToolMaterial.GOLD)     .setUnlocalizedName("ToolSpearGold");       GameRegistry.registerItem(toolSpearGold,       "ToolSpearGold"      );
		toolSpearCopper     = new ToolsSpear(materialToolCopper)    .setUnlocalizedName("ToolSpearCopper");     GameRegistry.registerItem(toolSpearCopper,     "ToolSpearCopper"    );
		toolSpearLead       = new ToolsSpear(materialToolLead)      .setUnlocalizedName("ToolSpearLead");       GameRegistry.registerItem(toolSpearLead,       "ToolSpearLead"      );
		toolSpearBronze     = new ToolsSpear(materialToolBronze)    .setUnlocalizedName("ToolSpearBronze");     GameRegistry.registerItem(toolSpearBronze,     "ToolSpearBronze"    );
		toolSpearSteel      = new ToolsSpear(materialToolSteel)     .setUnlocalizedName("ToolSpearSteel");      GameRegistry.registerItem(toolSpearSteel,      "ToolSpearSteel"     );
		toolSpearMythril    = new ToolsSpear(materialToolMythril)   .setUnlocalizedName("ToolSpearMythril");    GameRegistry.registerItem(toolSpearMythril,    "ToolSpearMythril"   );
		toolSpearIridium    = new ToolsSpear(materialToolIridium)   .setUnlocalizedName("ToolSpearIridium");    GameRegistry.registerItem(toolSpearIridium,    "ToolSpearIridium"   );
		toolSpearAdamantium = new ToolsSpear(materialToolAdamantium).setUnlocalizedName("ToolSpearAdamantium"); GameRegistry.registerItem(toolSpearAdamantium, "ToolSpearAdamantium");
		toolSpearUnobtanium = new ToolsSpear(materialToolUnobtanium).setUnlocalizedName("ToolSpearUnobtanium"); GameRegistry.registerItem(toolSpearUnobtanium, "ToolSpearUnobtanium");
		
		toolHammerFlint      = new ToolsHammer(materialToolFlint)     .setUnlocalizedName("ToolHammerFlint");      GameRegistry.registerItem(toolHammerFlint,      "ToolHammerFlint"     );
		toolHammerIron       = new ToolsHammer(ToolMaterial.IRON)     .setUnlocalizedName("ToolHammerIron");       GameRegistry.registerItem(toolHammerIron,       "ToolHammerIron"      );
		toolHammerGold       = new ToolsHammer(ToolMaterial.GOLD)     .setUnlocalizedName("ToolHammerGold");       GameRegistry.registerItem(toolHammerGold,       "ToolHammerGold"      );
		toolHammerCopper     = new ToolsHammer(materialToolCopper)    .setUnlocalizedName("ToolHammerCopper");     GameRegistry.registerItem(toolHammerCopper,     "ToolHammerCopper"    );
		toolHammerLead       = new ToolsHammer(materialToolLead)      .setUnlocalizedName("ToolHammerLead");       GameRegistry.registerItem(toolHammerLead,       "ToolHammerLead"      );
		toolHammerBronze     = new ToolsHammer(materialToolBronze)    .setUnlocalizedName("ToolHammerBronze");     GameRegistry.registerItem(toolHammerBronze,     "ToolHammerBronze"    );
		toolHammerSteel      = new ToolsHammer(materialToolSteel)     .setUnlocalizedName("ToolHammerSteel");      GameRegistry.registerItem(toolHammerSteel,      "ToolHammerSteel"     );
		toolHammerMythril    = new ToolsHammer(materialToolMythril)   .setUnlocalizedName("ToolHammerMythril");    GameRegistry.registerItem(toolHammerMythril,    "ToolHammerMythril"   );
		toolHammerIridium    = new ToolsHammer(materialToolIridium)   .setUnlocalizedName("ToolHammerIridium");    GameRegistry.registerItem(toolHammerIridium,    "ToolHammerIridium"   );
		toolHammerAdamantium = new ToolsHammer(materialToolAdamantium).setUnlocalizedName("ToolHammerAdamantium"); GameRegistry.registerItem(toolHammerAdamantium, "ToolHammerAdamantium");
		toolHammerUnobtanium = new ToolsHammer(materialToolUnobtanium).setUnlocalizedName("ToolHammerUnobtanium"); GameRegistry.registerItem(toolHammerUnobtanium, "ToolHammerUnobtanium");
		
		toolAxeFlint      = new ToolsAxe(materialToolFlint)     .setUnlocalizedName("ToolAxeFlint");      GameRegistry.registerItem(toolAxeFlint,      "ToolAxeFlint"     );
		toolAxeCopper     = new ToolsAxe(materialToolCopper)    .setUnlocalizedName("ToolAxeCopper");     GameRegistry.registerItem(toolAxeCopper,     "ToolAxeCopper"    );
		toolAxeLead       = new ToolsAxe(materialToolLead)      .setUnlocalizedName("ToolAxeLead");       GameRegistry.registerItem(toolAxeLead,       "ToolAxeLead"      );
		toolAxeBronze     = new ToolsAxe(materialToolBronze)    .setUnlocalizedName("ToolAxeBronze");     GameRegistry.registerItem(toolAxeBronze,     "ToolAxeBronze"    );
		toolAxeSteel      = new ToolsAxe(materialToolSteel)     .setUnlocalizedName("ToolAxeSteel");      GameRegistry.registerItem(toolAxeSteel,      "ToolAxeSteel"     );
		toolAxeMythril    = new ToolsAxe(materialToolMythril)   .setUnlocalizedName("ToolAxeMythril");    GameRegistry.registerItem(toolAxeMythril,    "ToolAxeMythril"   );
		toolAxeIridium    = new ToolsAxe(materialToolIridium)   .setUnlocalizedName("ToolAxeIridium");    GameRegistry.registerItem(toolAxeIridium,    "ToolAxeIridium"   );
		toolAxeAdamantium = new ToolsAxe(materialToolAdamantium).setUnlocalizedName("ToolAxeAdamantium"); GameRegistry.registerItem(toolAxeAdamantium, "ToolAxeAdamantium");
		toolAxeUnobtanium = new ToolsAxe(materialToolUnobtanium).setUnlocalizedName("ToolAxeUnobtanium"); GameRegistry.registerItem(toolAxeUnobtanium, "ToolAxeUnobtanium");

		toolShovelFlint      = new ToolsShovel(materialToolFlint)     .setUnlocalizedName("ToolShovelFlint");      GameRegistry.registerItem(toolShovelFlint,      "ToolShovelFlint"     );
		toolShovelCopper     = new ToolsShovel(materialToolCopper)    .setUnlocalizedName("ToolShovelCopper");     GameRegistry.registerItem(toolShovelCopper,     "ToolShovelCopper"    );
		toolShovelLead       = new ToolsShovel(materialToolLead)      .setUnlocalizedName("ToolShovelLead");       GameRegistry.registerItem(toolShovelLead,       "ToolShovelLead"      );
		toolShovelBronze     = new ToolsShovel(materialToolBronze)    .setUnlocalizedName("ToolShovelBronze");     GameRegistry.registerItem(toolShovelBronze,     "ToolShovelBronze"    );
		toolShovelSteel      = new ToolsShovel(materialToolSteel)     .setUnlocalizedName("ToolShovelSteel");      GameRegistry.registerItem(toolShovelSteel,      "ToolShovelSteel"     );
		toolShovelMythril    = new ToolsShovel(materialToolMythril)   .setUnlocalizedName("ToolShovelMythril");    GameRegistry.registerItem(toolShovelMythril,    "ToolShovelMythril"   );
		toolShovelIridium    = new ToolsShovel(materialToolIridium)   .setUnlocalizedName("ToolShovelIridium");    GameRegistry.registerItem(toolShovelIridium,    "ToolShovelIridium"   );
		toolShovelAdamantium = new ToolsShovel(materialToolAdamantium).setUnlocalizedName("ToolShovelAdamantium"); GameRegistry.registerItem(toolShovelAdamantium, "ToolShovelAdamantium");
		toolShovelUnobtanium = new ToolsShovel(materialToolUnobtanium).setUnlocalizedName("ToolShovelUnobtanium"); GameRegistry.registerItem(toolShovelUnobtanium, "ToolShovelUnobtanium");

		toolHoeFlint      = new ToolsHoe(materialToolFlint)     .setUnlocalizedName("ToolHoeFlint");      GameRegistry.registerItem(toolHoeFlint,      "ToolHoeFlint"     );
		toolHoeCopper     = new ToolsHoe(materialToolCopper)    .setUnlocalizedName("ToolHoeCopper");     GameRegistry.registerItem(toolHoeCopper,     "ToolHoeCopper"    );
		toolHoeLead       = new ToolsHoe(materialToolLead)      .setUnlocalizedName("ToolHoeLead");       GameRegistry.registerItem(toolHoeLead,       "ToolHoeLead"      );
		toolHoeBronze     = new ToolsHoe(materialToolBronze)    .setUnlocalizedName("ToolHoeBronze");     GameRegistry.registerItem(toolHoeBronze,     "ToolHoeBronze"    );
		toolHoeSteel      = new ToolsHoe(materialToolSteel)     .setUnlocalizedName("ToolHoeSteel");      GameRegistry.registerItem(toolHoeSteel,      "ToolHoeSteel"     );
		toolHoeMythril    = new ToolsHoe(materialToolMythril)   .setUnlocalizedName("ToolHoeMythril");    GameRegistry.registerItem(toolHoeMythril,    "ToolHoeMythril"   );
		toolHoeIridium    = new ToolsHoe(materialToolIridium)   .setUnlocalizedName("ToolHoeIridium");    GameRegistry.registerItem(toolHoeIridium,    "ToolHoeIridium"   );
		toolHoeAdamantium = new ToolsHoe(materialToolAdamantium).setUnlocalizedName("ToolHoeAdamantium"); GameRegistry.registerItem(toolHoeAdamantium, "ToolHoeAdamantium");
		toolHoeUnobtanium = new ToolsHoe(materialToolUnobtanium).setUnlocalizedName("ToolHoeUnobtanium"); GameRegistry.registerItem(toolHoeUnobtanium, "ToolHoeUnobtanium");

		toolPickaxeFlint      = new ToolsPickaxe(materialToolFlint)     .setUnlocalizedName("ToolPickaxeFlint");      GameRegistry.registerItem(toolPickaxeFlint,      "ToolPickaxeFlint"     );
		toolPickaxeCopper     = new ToolsPickaxe(materialToolCopper)    .setUnlocalizedName("ToolPickaxeCopper");     GameRegistry.registerItem(toolPickaxeCopper,     "ToolPickaxeCopper"    );
		toolPickaxeLead       = new ToolsPickaxe(materialToolLead)      .setUnlocalizedName("ToolPickaxeLead");       GameRegistry.registerItem(toolPickaxeLead,       "ToolPickaxeLead"      );
		toolPickaxeBronze     = new ToolsPickaxe(materialToolBronze)    .setUnlocalizedName("ToolPickaxeBronze");     GameRegistry.registerItem(toolPickaxeBronze,     "ToolPickaxeBronze"    );
		toolPickaxeSteel      = new ToolsPickaxe(materialToolSteel)     .setUnlocalizedName("ToolPickaxeSteel");      GameRegistry.registerItem(toolPickaxeSteel,      "ToolPickaxeSteel"     );
		toolPickaxeMythril    = new ToolsPickaxe(materialToolMythril)   .setUnlocalizedName("ToolPickaxeMythril");    GameRegistry.registerItem(toolPickaxeMythril,    "ToolPickaxeMythril"   );
		toolPickaxeIridium    = new ToolsPickaxe(materialToolIridium)   .setUnlocalizedName("ToolPickaxeIridium");    GameRegistry.registerItem(toolPickaxeIridium,    "ToolPickaxeIridium"   );
		toolPickaxeAdamantium = new ToolsPickaxe(materialToolAdamantium).setUnlocalizedName("ToolPickaxeAdamantium"); GameRegistry.registerItem(toolPickaxeAdamantium, "ToolPickaxeAdamantium");
		toolPickaxeUnobtanium = new ToolsPickaxe(materialToolUnobtanium).setUnlocalizedName("ToolPickaxeUnobtanium"); GameRegistry.registerItem(toolPickaxeUnobtanium, "ToolPickaxeUnobtanium");
		
		//Armor
		armorHelmetCopper     = new AceArmor(materialArmorCopper,     0, 0, 0).setUnlocalizedName("ArmorHelmetCopper");     GameRegistry.registerItem(armorHelmetCopper, "ArmorHelmetCopper"        );
		armorHelmetAluminium  = new AceArmor(materialArmorAluminium,  1, 0, 0).setUnlocalizedName("ArmorHelmetAluminium");  GameRegistry.registerItem(armorHelmetAluminium, "ArmorHelmetAluminium"  );
		armorHelmetLead       = new AceArmor(materialArmorLead,       2, 0, 0).setUnlocalizedName("ArmorHelmetLead");       GameRegistry.registerItem(armorHelmetLead, "ArmorHelmetLead"            );
		armorHelmetBronze     = new AceArmor(materialArmorBronze,     3, 0, 0).setUnlocalizedName("ArmorHelmetBronze");     GameRegistry.registerItem(armorHelmetBronze, "ArmorHelmetBronze"        );
		armorHelmetSteel      = new AceArmor(materialArmorSteel,      4, 0, 0).setUnlocalizedName("ArmorHelmetSteel");      GameRegistry.registerItem(armorHelmetSteel, "ArmorHelmetSteel"          );
		armorHelmetMythril    = new AceArmor(materialArmorMythril,    5, 0, 0).setUnlocalizedName("ArmorHelmetMythril");    GameRegistry.registerItem(armorHelmetMythril, "ArmorHelmetMythril"      );
		armorHelmetAdamantium = new AceArmor(materialArmorAdamantium, 6, 0, 0).setUnlocalizedName("ArmorHelmetAdamantium"); GameRegistry.registerItem(armorHelmetAdamantium, "ArmorHelmetAdamantium");
		armorHelmetUnobtanium = new AceArmor(materialArmorUnobtanium, 7, 0, 0).setUnlocalizedName("ArmorHelmetUnobtanium"); GameRegistry.registerItem(armorHelmetUnobtanium, "ArmorHelmetUnobtanium");
		
		armorChestplateCopper     = new AceArmor(materialArmorCopper,     0, 1, 1).setUnlocalizedName("ArmorChestplateCopper");     GameRegistry.registerItem(armorChestplateCopper, "ArmorChestplateCopper"        );
		armorChestplateAluminium  = new AceArmor(materialArmorAluminium,  1, 1, 1).setUnlocalizedName("ArmorChestplateAluminium");  GameRegistry.registerItem(armorChestplateAluminium, "ArmorChestplateAluminium"  );
		armorChestplateLead       = new AceArmor(materialArmorLead,       2, 1, 1).setUnlocalizedName("ArmorChestplateLead");       GameRegistry.registerItem(armorChestplateLead, "ArmorChestplateLead"            );
		armorChestplateBronze     = new AceArmor(materialArmorBronze,     3, 1, 1).setUnlocalizedName("ArmorChestplateBronze");     GameRegistry.registerItem(armorChestplateBronze, "ArmorChestplateBronze"        );
		armorChestplateSteel      = new AceArmor(materialArmorSteel,      4, 1, 1).setUnlocalizedName("ArmorChestplateSteel");      GameRegistry.registerItem(armorChestplateSteel, "ArmorChestplateSteel"          );
		armorChestplateMythril    = new AceArmor(materialArmorMythril,    5, 1, 1).setUnlocalizedName("ArmorChestplateMythril");    GameRegistry.registerItem(armorChestplateMythril, "ArmorChestplateMythril"      );
		armorChestplateAdamantium = new AceArmor(materialArmorAdamantium, 6, 1, 1).setUnlocalizedName("ArmorChestplateAdamantium"); GameRegistry.registerItem(armorChestplateAdamantium, "ArmorChestplateAdamantium");
		armorChestplateUnobtanium = new AceArmor(materialArmorUnobtanium, 7, 1, 1).setUnlocalizedName("ArmorChestplateUnobtanium"); GameRegistry.registerItem(armorChestplateUnobtanium, "ArmorChestplateUnobtanium");

		armorLegginsCopper     = new AceArmor(materialArmorCopper,     0, 2, 2).setUnlocalizedName("ArmorLegginsCopper");     GameRegistry.registerItem(armorLegginsCopper, "ArmorLegginsCopper"        );
		armorLegginsAluminium  = new AceArmor(materialArmorAluminium,  1, 2, 2).setUnlocalizedName("ArmorLegginsAluminium");  GameRegistry.registerItem(armorLegginsAluminium, "ArmorLegginsAluminium"  );
		armorLegginsLead       = new AceArmor(materialArmorLead,       2, 2, 2).setUnlocalizedName("ArmorLegginsLead");       GameRegistry.registerItem(armorLegginsLead, "ArmorLegginsLead"            );
		armorLegginsBronze     = new AceArmor(materialArmorBronze,     3, 2, 2).setUnlocalizedName("ArmorLegginsBronze");     GameRegistry.registerItem(armorLegginsBronze, "ArmorLegginsBronze"        );
		armorLegginsSteel      = new AceArmor(materialArmorSteel,      4, 2, 2).setUnlocalizedName("ArmorLegginsSteel");      GameRegistry.registerItem(armorLegginsSteel, "ArmorLegginsSteel"          );
		armorLegginsMythril    = new AceArmor(materialArmorMythril,    5, 2, 2).setUnlocalizedName("ArmorLegginsMythril");    GameRegistry.registerItem(armorLegginsMythril, "ArmorLegginsMythril"      );
		armorLegginsAdamantium = new AceArmor(materialArmorAdamantium, 6, 2, 2).setUnlocalizedName("ArmorLegginsAdamantium"); GameRegistry.registerItem(armorLegginsAdamantium, "ArmorLegginsAdamantium");
		armorLegginsUnobtanium = new AceArmor(materialArmorUnobtanium, 7, 2, 2).setUnlocalizedName("ArmorLegginsUnobtanium"); GameRegistry.registerItem(armorLegginsUnobtanium, "ArmorLegginsUnobtanium");

		armorBootsCopper     = new AceArmor(materialArmorCopper,     0, 3, 3).setUnlocalizedName("ArmorBootsCopper");     GameRegistry.registerItem(armorBootsCopper, "ArmorBootsCopper"        );
		armorBootsAluminium  = new AceArmor(materialArmorAluminium,  1, 3, 3).setUnlocalizedName("ArmorBootsAluminium");  GameRegistry.registerItem(armorBootsAluminium, "ArmorBootsAluminium"  );
		armorBootsLead       = new AceArmor(materialArmorLead,       2, 3, 3).setUnlocalizedName("ArmorBootsLead");       GameRegistry.registerItem(armorBootsLead, "ArmorBootsLead"            );
		armorBootsBronze     = new AceArmor(materialArmorBronze,     3, 3, 3).setUnlocalizedName("ArmorBootsBronze");     GameRegistry.registerItem(armorBootsBronze, "ArmorBootsBronze"        );
		armorBootsSteel      = new AceArmor(materialArmorSteel,      4, 3, 3).setUnlocalizedName("ArmorBootsSteel");      GameRegistry.registerItem(armorBootsSteel, "ArmorBootsSteel"          );
		armorBootsMythril    = new AceArmor(materialArmorMythril,    5, 3, 3).setUnlocalizedName("ArmorBootsMythril");    GameRegistry.registerItem(armorBootsMythril, "ArmorBootsMythril"      );
		armorBootsAdamantium = new AceArmor(materialArmorAdamantium, 6, 3, 3).setUnlocalizedName("ArmorBootsAdamantium"); GameRegistry.registerItem(armorBootsAdamantium, "ArmorBootsAdamantium");
		armorBootsUnobtanium = new AceArmor(materialArmorUnobtanium, 7, 3, 3).setUnlocalizedName("ArmorBootsUnobtanium"); GameRegistry.registerItem(armorBootsUnobtanium, "ArmorBootsUnobtanium");
		
		//Buckets
		bucketWoodEmpty       = new AceBucket(Blocks.air,           "Wood").setUnlocalizedName("BucketWoodEmpty").setCreativeTab(acetabCommon); GameRegistry.registerItem(bucketWoodEmpty,       "BucketWoodEmpty"      );
		bucketWoodWater       = new AceBucket(Blocks.flowing_water, "Wood").setUnlocalizedName("BucketWoodWater").setCreativeTab(acetabCommon); GameRegistry.registerItem(bucketWoodWater,       "BucketWoodWater"      );
		bucketWoodLava        = new AceBucket(Blocks.flowing_lava,  "Wood").setUnlocalizedName("BucketWoodLava") .setCreativeTab(acetabCommon); GameRegistry.registerItem(bucketWoodLava,        "BucketWoodLava"       );
		bucketWoodOil         = new AceItems(false)                        .setUnlocalizedName("BucketWoodOil");                                GameRegistry.registerItem(bucketWoodOil,         "BucketWoodOil"        );
		bucketWoodMilk        = new AceItems(false)                        .setUnlocalizedName("BucketWoodMilk");                               GameRegistry.registerItem(bucketWoodMilk,        "BucketWoodMilk"       );
		bucketWoodCoconutMilk = new AceItems(false)                        .setUnlocalizedName("BucketWoodCoconutMilk");                        GameRegistry.registerItem(bucketWoodCoconutMilk, "BucketWoodCoconutMilk");
		bucketWoodApple       = new AceItems(false)                        .setUnlocalizedName("BucketWoodApple");                              GameRegistry.registerItem(bucketWoodApple,       "BucketWoodApple"      );
		bucketWoodBanana      = new AceItems(false)                        .setUnlocalizedName("BucketWoodBanana");                             GameRegistry.registerItem(bucketWoodBanana,      "BucketWoodBanana"     );
		bucketWoodCactusFruit = new AceItems(false)                        .setUnlocalizedName("BucketWoodCactusFruit");                        GameRegistry.registerItem(bucketWoodCactusFruit, "BucketWoodCactusFruit");
		bucketWoodCherry      = new AceItems(false)                        .setUnlocalizedName("BucketWoodCherry");                             GameRegistry.registerItem(bucketWoodCherry,      "BucketWoodCherry"     );
		bucketWoodGrapes      = new AceItems(false)                        .setUnlocalizedName("BucketWoodGrapes");                             GameRegistry.registerItem(bucketWoodGrapes,      "BucketWoodGrapes"     );
		bucketWoodLemon       = new AceItems(false)                        .setUnlocalizedName("BucketWoodLemon");                              GameRegistry.registerItem(bucketWoodLemon,       "BucketWoodLemon"      );
		bucketWoodOrange      = new AceItems(false)                        .setUnlocalizedName("BucketWoodOrange");                             GameRegistry.registerItem(bucketWoodOrange,      "BucketWoodOrange"     );
		bucketWoodPeach       = new AceItems(false)                        .setUnlocalizedName("BucketWoodPeach");                              GameRegistry.registerItem(bucketWoodPeach,       "BucketWoodPeach"      );
		bucketWoodPineapple   = new AceItems(false)                        .setUnlocalizedName("BucketWoodPineapple");                          GameRegistry.registerItem(bucketWoodPineapple,   "BucketWoodPineapple"  );
		bucketWoodTomato      = new AceItems(false)                        .setUnlocalizedName("BucketWoodTomato");                             GameRegistry.registerItem(bucketWoodTomato,      "BucketWoodTomato"     );
		
		bucketIronEmpty       = new AceBucket(Blocks.air,           "Iron").setUnlocalizedName("BucketIronEmpty").setCreativeTab(acetabCommon); GameRegistry.registerItem(bucketIronEmpty,       "BucketIronEmpty"      );
		bucketIronWater       = new AceBucket(Blocks.flowing_water, "Iron").setUnlocalizedName("BucketIronWater").setCreativeTab(acetabCommon); GameRegistry.registerItem(bucketIronWater,       "BucketIronWater"      );
		bucketIronLava        = new AceBucket(Blocks.flowing_lava,  "Iron").setUnlocalizedName("BucketIronLava") .setCreativeTab(acetabCommon); GameRegistry.registerItem(bucketIronLava,        "BucketIronLava"       );
		bucketIronOil         = new AceItems(false)                        .setUnlocalizedName("BucketIronOil");                                GameRegistry.registerItem(bucketIronOil,         "BucketIronOil"        );
		bucketIronMilk        = new AceItems(false)                        .setUnlocalizedName("BucketIronMilk");                               GameRegistry.registerItem(bucketIronMilk,        "BucketIronMilk"       );
		bucketIronCoconutMilk = new AceItems(false)                        .setUnlocalizedName("BucketIronCoconutMilk");                        GameRegistry.registerItem(bucketIronCoconutMilk, "BucketIronCoconutMilk");
		bucketIronApple       = new AceItems(false)                        .setUnlocalizedName("BucketIronApple");                              GameRegistry.registerItem(bucketIronApple,       "BucketIronApple"      );
		bucketIronBanana      = new AceItems(false)                        .setUnlocalizedName("BucketIronBanana");                             GameRegistry.registerItem(bucketIronBanana,      "BucketIronBanana"     );
		bucketIronCactusFruit = new AceItems(false)                        .setUnlocalizedName("BucketIronCactusFruit");                        GameRegistry.registerItem(bucketIronCactusFruit, "BucketIronCactusFruit");
		bucketIronCherry      = new AceItems(false)                        .setUnlocalizedName("BucketIronCherry");                             GameRegistry.registerItem(bucketIronCherry,      "BucketIronCherry"     );
		bucketIronGrapes      = new AceItems(false)                        .setUnlocalizedName("BucketIronGrapes");                             GameRegistry.registerItem(bucketIronGrapes,      "BucketIronGrapes"     );
		bucketIronLemon       = new AceItems(false)                        .setUnlocalizedName("BucketIronLemon");                              GameRegistry.registerItem(bucketIronLemon,       "BucketIronLemon"      );
		bucketIronOrange      = new AceItems(false)                        .setUnlocalizedName("BucketIronOrange");                             GameRegistry.registerItem(bucketIronOrange,      "BucketIronOrange"     );
		bucketIronPeach       = new AceItems(false)                        .setUnlocalizedName("BucketIronPeach");                              GameRegistry.registerItem(bucketIronPeach,       "BucketIronPeach"      );
		bucketIronPineapple   = new AceItems(false)                        .setUnlocalizedName("BucketIronPineapple");                          GameRegistry.registerItem(bucketIronPineapple,   "BucketIronPineapple"  );
		bucketIronTomato      = new AceItems(false)                        .setUnlocalizedName("BucketIronTomato");                             GameRegistry.registerItem(bucketIronTomato,      "BucketIronTomato"     );

		bucketCopperEmpty       = new AceBucket(Blocks.air,           "Copper").setUnlocalizedName("BucketCopperEmpty").setCreativeTab(acetabCommon); GameRegistry.registerItem(bucketCopperEmpty,       "BucketCopperEmpty"      );
		bucketCopperWater       = new AceBucket(Blocks.flowing_water, "Copper").setUnlocalizedName("BucketCopperWater").setCreativeTab(acetabCommon); GameRegistry.registerItem(bucketCopperWater,       "BucketCopperWater"      );
		bucketCopperLava        = new AceBucket(Blocks.flowing_lava,  "Copper").setUnlocalizedName("BucketCopperLava") .setCreativeTab(acetabCommon); GameRegistry.registerItem(bucketCopperLava,        "BucketCopperLava"       );
		bucketCopperOil         = new AceItems(false)                          .setUnlocalizedName("BucketCopperOil");                                GameRegistry.registerItem(bucketCopperOil,         "BucketCopperOil"        );
		bucketCopperMilk        = new AceItems(false)                          .setUnlocalizedName("BucketCopperMilk");                               GameRegistry.registerItem(bucketCopperMilk,        "BucketCopperMilk"       );
		bucketCopperCoconutMilk = new AceItems(false)                          .setUnlocalizedName("BucketCopperCoconutMilk");                        GameRegistry.registerItem(bucketCopperCoconutMilk, "BucketCopperCoconutMilk");
		bucketCopperApple       = new AceItems(false)                          .setUnlocalizedName("BucketCopperApple");                              GameRegistry.registerItem(bucketCopperApple,       "BucketCopperApple"      );
		bucketCopperBanana      = new AceItems(false)                          .setUnlocalizedName("BucketCopperBanana");                             GameRegistry.registerItem(bucketCopperBanana,      "BucketCopperBanana"     );
		bucketCopperCactusFruit = new AceItems(false)                          .setUnlocalizedName("BucketCopperCactusFruit");                        GameRegistry.registerItem(bucketCopperCactusFruit, "BucketCopperCactusFruit");
		bucketCopperCherry      = new AceItems(false)                          .setUnlocalizedName("BucketCopperCherry");                             GameRegistry.registerItem(bucketCopperCherry,      "BucketCopperCherry"     );
		bucketCopperGrapes      = new AceItems(false)                          .setUnlocalizedName("BucketCopperGrapes");                             GameRegistry.registerItem(bucketCopperGrapes,      "BucketCopperGrapes"     );
		bucketCopperLemon       = new AceItems(false)                          .setUnlocalizedName("BucketCopperLemon");                              GameRegistry.registerItem(bucketCopperLemon,       "BucketCopperLemon"      );
		bucketCopperOrange      = new AceItems(false)                          .setUnlocalizedName("BucketCopperOrange");                             GameRegistry.registerItem(bucketCopperOrange,      "BucketCopperOrange"     );
		bucketCopperPeach       = new AceItems(false)                          .setUnlocalizedName("BucketCopperPeach");                              GameRegistry.registerItem(bucketCopperPeach,       "BucketCopperPeach"      );
		bucketCopperPineapple   = new AceItems(false)                          .setUnlocalizedName("BucketCopperPineapple");                          GameRegistry.registerItem(bucketCopperPineapple,   "BucketCopperPineapple"  );
		bucketCopperTomato      = new AceItems(false)                          .setUnlocalizedName("BucketCopperTomato");                             GameRegistry.registerItem(bucketCopperTomato,      "BucketCopperTomato"     );

		bucketAluminiumEmpty       = new AceBucket(Blocks.air,           "Aluminium").setUnlocalizedName("BucketAluminiumEmpty").setCreativeTab(acetabCommon); GameRegistry.registerItem(bucketAluminiumEmpty,       "BucketAluminiumEmpty"      );
		bucketAluminiumWater       = new AceBucket(Blocks.flowing_water, "Aluminium").setUnlocalizedName("BucketAluminiumWater").setCreativeTab(acetabCommon); GameRegistry.registerItem(bucketAluminiumWater,       "BucketAluminiumWater"      );
		bucketAluminiumLava        = new AceBucket(Blocks.flowing_lava,  "Aluminium").setUnlocalizedName("BucketAluminiumLava") .setCreativeTab(acetabCommon); GameRegistry.registerItem(bucketAluminiumLava,        "BucketAluminiumLava"       );
		bucketAluminiumOil         = new AceItems(false)                             .setUnlocalizedName("BucketAluminiumOil");                                GameRegistry.registerItem(bucketAluminiumOil,         "BucketAluminiumOil"        );
		bucketAluminiumMilk        = new AceItems(false)                             .setUnlocalizedName("BucketAluminiumMilk");                               GameRegistry.registerItem(bucketAluminiumMilk,        "BucketAluminiumMilk"       );
		bucketAluminiumCoconutMilk = new AceItems(false)                             .setUnlocalizedName("BucketAluminiumCoconutMilk");                        GameRegistry.registerItem(bucketAluminiumCoconutMilk, "BucketAluminiumCoconutMilk");
		bucketAluminiumApple       = new AceItems(false)                             .setUnlocalizedName("BucketAluminiumApple");                              GameRegistry.registerItem(bucketAluminiumApple,       "BucketAluminiumApple"      );
		bucketAluminiumBanana      = new AceItems(false)                             .setUnlocalizedName("BucketAluminiumBanana");                             GameRegistry.registerItem(bucketAluminiumBanana,      "BucketAluminiumBanana"     );
		bucketAluminiumCactusFruit = new AceItems(false)                             .setUnlocalizedName("BucketAluminiumCactusFruit");                        GameRegistry.registerItem(bucketAluminiumCactusFruit, "BucketAluminiumCactusFruit");
		bucketAluminiumCherry      = new AceItems(false)                             .setUnlocalizedName("BucketAluminiumCherry");                             GameRegistry.registerItem(bucketAluminiumCherry,      "BucketAluminiumCherry"     );
		bucketAluminiumGrapes      = new AceItems(false)                             .setUnlocalizedName("BucketAluminiumGrapes");                             GameRegistry.registerItem(bucketAluminiumGrapes,      "BucketAluminiumGrapes"     );
		bucketAluminiumLemon       = new AceItems(false)                             .setUnlocalizedName("BucketAluminiumLemon");                              GameRegistry.registerItem(bucketAluminiumLemon,       "BucketAluminiumLemon"      );
		bucketAluminiumOrange      = new AceItems(false)                             .setUnlocalizedName("BucketAluminiumOrange");                             GameRegistry.registerItem(bucketAluminiumOrange,      "BucketAluminiumOrange"     );
		bucketAluminiumPeach       = new AceItems(false)                             .setUnlocalizedName("BucketAluminiumPeach");                              GameRegistry.registerItem(bucketAluminiumPeach,       "BucketAluminiumPeach"      );
		bucketAluminiumPineapple   = new AceItems(false)                             .setUnlocalizedName("BucketAluminiumPineapple");                          GameRegistry.registerItem(bucketAluminiumPineapple,   "BucketAluminiumPineapple"  );
		bucketAluminiumTomato      = new AceItems(false)                             .setUnlocalizedName("BucketAluminiumTomato");                             GameRegistry.registerItem(bucketAluminiumTomato,      "BucketAluminiumTomato"     );

		bucketLeadEmpty       = new AceBucket(Blocks.air,           "Lead").setUnlocalizedName("BucketLeadEmpty").setCreativeTab(acetabCommon); GameRegistry.registerItem(bucketLeadEmpty,       "BucketLeadEmpty"      );
		bucketLeadWater       = new AceBucket(Blocks.flowing_water, "Lead").setUnlocalizedName("BucketLeadWater").setCreativeTab(acetabCommon); GameRegistry.registerItem(bucketLeadWater,       "BucketLeadWater"      );
		bucketLeadLava        = new AceBucket(Blocks.flowing_lava,  "Lead").setUnlocalizedName("BucketLeadLava") .setCreativeTab(acetabCommon); GameRegistry.registerItem(bucketLeadLava,        "BucketLeadLava"       );
		bucketLeadOil         = new AceItems(false)                        .setUnlocalizedName("BucketLeadOil");                                GameRegistry.registerItem(bucketLeadOil,         "BucketLeadOil"        );
		bucketLeadMilk        = new AceItems(false)                        .setUnlocalizedName("BucketLeadMilk");                               GameRegistry.registerItem(bucketLeadMilk,        "BucketLeadMilk"       );
		bucketLeadCoconutMilk = new AceItems(false)                        .setUnlocalizedName("BucketLeadCoconutMilk");                        GameRegistry.registerItem(bucketLeadCoconutMilk, "BucketLeadCoconutMilk");
		bucketLeadApple       = new AceItems(false)                        .setUnlocalizedName("BucketLeadApple");                              GameRegistry.registerItem(bucketLeadApple,       "BucketLeadApple"      );
		bucketLeadBanana      = new AceItems(false)                        .setUnlocalizedName("BucketLeadBanana");                             GameRegistry.registerItem(bucketLeadBanana,      "BucketLeadBanana"     );
		bucketLeadCactusFruit = new AceItems(false)                        .setUnlocalizedName("BucketLeadCactusFruit");                        GameRegistry.registerItem(bucketLeadCactusFruit, "BucketLeadCactusFruit");
		bucketLeadCherry      = new AceItems(false)                        .setUnlocalizedName("BucketLeadCherry");                             GameRegistry.registerItem(bucketLeadCherry,      "BucketLeadCherry"     );
		bucketLeadGrapes      = new AceItems(false)                        .setUnlocalizedName("BucketLeadGrapes");                             GameRegistry.registerItem(bucketLeadGrapes,      "BucketLeadGrapes"     );
		bucketLeadLemon       = new AceItems(false)                        .setUnlocalizedName("BucketLeadLemon");                              GameRegistry.registerItem(bucketLeadLemon,       "BucketLeadLemon"      );
		bucketLeadOrange      = new AceItems(false)                        .setUnlocalizedName("BucketLeadOrange");                             GameRegistry.registerItem(bucketLeadOrange,      "BucketLeadOrange"     );
		bucketLeadPeach       = new AceItems(false)                        .setUnlocalizedName("BucketLeadPeach");                              GameRegistry.registerItem(bucketLeadPeach,       "BucketLeadPeach"      );
		bucketLeadPineapple   = new AceItems(false)                        .setUnlocalizedName("BucketLeadPineapple");                          GameRegistry.registerItem(bucketLeadPineapple,   "BucketLeadPineapple"  );
		bucketLeadTomato      = new AceItems(false)                        .setUnlocalizedName("BucketLeadTomato");                             GameRegistry.registerItem(bucketLeadTomato,      "BucketLeadTomato"     );

		bucketBronzeEmpty       = new AceBucket(Blocks.air,           "Bronze").setUnlocalizedName("BucketBronzeEmpty").setCreativeTab(acetabCommon); GameRegistry.registerItem(bucketBronzeEmpty,       "BucketBronzeEmpty"      );
		bucketBronzeWater       = new AceBucket(Blocks.flowing_water, "Bronze").setUnlocalizedName("BucketBronzeWater").setCreativeTab(acetabCommon); GameRegistry.registerItem(bucketBronzeWater,       "BucketBronzeWater"      );
		bucketBronzeLava        = new AceBucket(Blocks.flowing_lava,  "Bronze").setUnlocalizedName("BucketBronzeLava") .setCreativeTab(acetabCommon); GameRegistry.registerItem(bucketBronzeLava,        "BucketBronzeLava"       );
		bucketBronzeOil         = new AceItems(false)                          .setUnlocalizedName("BucketBronzeOil");                                GameRegistry.registerItem(bucketBronzeOil,         "BucketBronzeOil"        );
		bucketBronzeMilk        = new AceItems(false)                          .setUnlocalizedName("BucketBronzeMilk");                               GameRegistry.registerItem(bucketBronzeMilk,        "BucketBronzeMilk"       );
		bucketBronzeCoconutMilk = new AceItems(false)                          .setUnlocalizedName("BucketBronzeCoconutMilk");                        GameRegistry.registerItem(bucketBronzeCoconutMilk, "BucketBronzeCoconutMilk");
		bucketBronzeApple       = new AceItems(false)                          .setUnlocalizedName("BucketBronzeApple");                              GameRegistry.registerItem(bucketBronzeApple,       "BucketBronzeApple"      );
		bucketBronzeBanana      = new AceItems(false)                          .setUnlocalizedName("BucketBronzeBanana");                             GameRegistry.registerItem(bucketBronzeBanana,      "BucketBronzeBanana"     );
		bucketBronzeCactusFruit = new AceItems(false)                          .setUnlocalizedName("BucketBronzeCactusFruit");                        GameRegistry.registerItem(bucketBronzeCactusFruit, "BucketBronzeCactusFruit");
		bucketBronzeCherry      = new AceItems(false)                          .setUnlocalizedName("BucketBronzeCherry");                             GameRegistry.registerItem(bucketBronzeCherry,      "BucketBronzeCherry"     );
		bucketBronzeGrapes      = new AceItems(false)                          .setUnlocalizedName("BucketBronzeGrapes");                             GameRegistry.registerItem(bucketBronzeGrapes,      "BucketBronzeGrapes"     );
		bucketBronzeLemon       = new AceItems(false)                          .setUnlocalizedName("BucketBronzeLemon");                              GameRegistry.registerItem(bucketBronzeLemon,       "BucketBronzeLemon"      );
		bucketBronzeOrange      = new AceItems(false)                          .setUnlocalizedName("BucketBronzeOrange");                             GameRegistry.registerItem(bucketBronzeOrange,      "BucketBronzeOrange"     );
		bucketBronzePeach       = new AceItems(false)                          .setUnlocalizedName("BucketBronzePeach");                              GameRegistry.registerItem(bucketBronzePeach,       "BucketBronzePeach"      );
		bucketBronzePineapple   = new AceItems(false)                          .setUnlocalizedName("BucketBronzePineapple");                          GameRegistry.registerItem(bucketBronzePineapple,   "BucketBronzePineapple"  );
		bucketBronzeTomato      = new AceItems(false)                          .setUnlocalizedName("BucketBronzeTomato");                             GameRegistry.registerItem(bucketBronzeTomato,      "BucketBronzeTomato"     );

		bucketSteelEmpty       = new AceBucket(Blocks.air,           "Steel").setUnlocalizedName("BucketSteelEmpty").setCreativeTab(acetabCommon); GameRegistry.registerItem(bucketSteelEmpty,       "BucketSteelEmpty"      );
		bucketSteelWater       = new AceBucket(Blocks.flowing_water, "Steel").setUnlocalizedName("BucketSteelWater").setCreativeTab(acetabCommon); GameRegistry.registerItem(bucketSteelWater,       "BucketSteelWater"      );
		bucketSteelLava        = new AceBucket(Blocks.flowing_lava,  "Steel").setUnlocalizedName("BucketSteelLava") .setCreativeTab(acetabCommon); GameRegistry.registerItem(bucketSteelLava,        "BucketSteelLava"       );
		bucketSteelOil         = new AceItems(false)                         .setUnlocalizedName("BucketSteelOil");                                GameRegistry.registerItem(bucketSteelOil,         "BucketSteelOil"        );
		bucketSteelMilk        = new AceItems(false)                         .setUnlocalizedName("BucketSteelMilk");                               GameRegistry.registerItem(bucketSteelMilk,        "BucketSteelMilk"       );
		bucketSteelCoconutMilk = new AceItems(false)                         .setUnlocalizedName("BucketSteelCoconutMilk");                        GameRegistry.registerItem(bucketSteelCoconutMilk, "BucketSteelCoconutMilk");
		bucketSteelApple       = new AceItems(false)                         .setUnlocalizedName("BucketSteelApple");                              GameRegistry.registerItem(bucketSteelApple,       "BucketSteelApple"      );
		bucketSteelBanana      = new AceItems(false)                         .setUnlocalizedName("BucketSteelBanana");                             GameRegistry.registerItem(bucketSteelBanana,      "BucketSteelBanana"     );
		bucketSteelCactusFruit = new AceItems(false)                         .setUnlocalizedName("BucketSteelCactusFruit");                        GameRegistry.registerItem(bucketSteelCactusFruit, "BucketSteelCactusFruit");
		bucketSteelCherry      = new AceItems(false)                         .setUnlocalizedName("BucketSteelCherry");                             GameRegistry.registerItem(bucketSteelCherry,      "BucketSteelCherry"     );
		bucketSteelGrapes      = new AceItems(false)                         .setUnlocalizedName("BucketSteelGrapes");                             GameRegistry.registerItem(bucketSteelGrapes,      "BucketSteelGrapes"     );
		bucketSteelLemon       = new AceItems(false)                         .setUnlocalizedName("BucketSteelLemon");                              GameRegistry.registerItem(bucketSteelLemon,       "BucketSteelLemon"      );
		bucketSteelOrange      = new AceItems(false)                         .setUnlocalizedName("BucketSteelOrange");                             GameRegistry.registerItem(bucketSteelOrange,      "BucketSteelOrange"     );
		bucketSteelPeach       = new AceItems(false)                         .setUnlocalizedName("BucketSteelPeach");                              GameRegistry.registerItem(bucketSteelPeach,       "BucketSteelPeach"      );
		bucketSteelPineapple   = new AceItems(false)                         .setUnlocalizedName("BucketSteelPineapple");                          GameRegistry.registerItem(bucketSteelPineapple,   "BucketSteelPineapple"  );
		bucketSteelTomato      = new AceItems(false)                         .setUnlocalizedName("BucketSteelTomato");                             GameRegistry.registerItem(bucketSteelTomato,      "BucketSteelTomato"     );

		bucketMythrilEmpty       = new AceBucket(Blocks.air,           "Mythril").setUnlocalizedName("BucketMythrilEmpty").setCreativeTab(acetabCommon); GameRegistry.registerItem(bucketMythrilEmpty,       "BucketMythrilEmpty"      );
		bucketMythrilWater       = new AceBucket(Blocks.flowing_water, "Mythril").setUnlocalizedName("BucketMythrilWater").setCreativeTab(acetabCommon); GameRegistry.registerItem(bucketMythrilWater,       "BucketMythrilWater"      );
		bucketMythrilLava        = new AceBucket(Blocks.flowing_lava,  "Mythril").setUnlocalizedName("BucketMythrilLava") .setCreativeTab(acetabCommon); GameRegistry.registerItem(bucketMythrilLava,        "BucketMythrilLava"       );
		bucketMythrilOil         = new AceItems(false)                           .setUnlocalizedName("BucketMythrilOil");                                GameRegistry.registerItem(bucketMythrilOil,         "BucketMythrilOil"        );
		bucketMythrilMilk        = new AceItems(false)                           .setUnlocalizedName("BucketMythrilMilk");                               GameRegistry.registerItem(bucketMythrilMilk,        "BucketMythrilMilk"       );
		bucketMythrilCoconutMilk = new AceItems(false)                           .setUnlocalizedName("BucketMythrilCoconutMilk");                        GameRegistry.registerItem(bucketMythrilCoconutMilk, "BucketMythrilCoconutMilk");
		bucketMythrilApple       = new AceItems(false)                           .setUnlocalizedName("BucketMythrilApple");                              GameRegistry.registerItem(bucketMythrilApple,       "BucketMythrilApple"      );
		bucketMythrilBanana      = new AceItems(false)                           .setUnlocalizedName("BucketMythrilBanana");                             GameRegistry.registerItem(bucketMythrilBanana,      "BucketMythrilBanana"     );
		bucketMythrilCactusFruit = new AceItems(false)                           .setUnlocalizedName("BucketMythrilCactusFruit");                        GameRegistry.registerItem(bucketMythrilCactusFruit, "BucketMythrilCactusFruit");
		bucketMythrilCherry      = new AceItems(false)                           .setUnlocalizedName("BucketMythrilCherry");                             GameRegistry.registerItem(bucketMythrilCherry,      "BucketMythrilCherry"     );
		bucketMythrilGrapes      = new AceItems(false)                           .setUnlocalizedName("BucketMythrilGrapes");                             GameRegistry.registerItem(bucketMythrilGrapes,      "BucketMythrilGrapes"     );
		bucketMythrilLemon       = new AceItems(false)                           .setUnlocalizedName("BucketMythrilLemon");                              GameRegistry.registerItem(bucketMythrilLemon,       "BucketMythrilLemon"      );
		bucketMythrilOrange      = new AceItems(false)                           .setUnlocalizedName("BucketMythrilOrange");                             GameRegistry.registerItem(bucketMythrilOrange,      "BucketMythrilOrange"     );
		bucketMythrilPeach       = new AceItems(false)                           .setUnlocalizedName("BucketMythrilPeach");                              GameRegistry.registerItem(bucketMythrilPeach,       "BucketMythrilPeach"      );
		bucketMythrilPineapple   = new AceItems(false)                           .setUnlocalizedName("BucketMythrilPineapple");                          GameRegistry.registerItem(bucketMythrilPineapple,   "BucketMythrilPineapple"  );
		bucketMythrilTomato      = new AceItems(false)                           .setUnlocalizedName("BucketMythrilTomato");                             GameRegistry.registerItem(bucketMythrilTomato,      "BucketMythrilTomato"     );

		bucketAdamantiumEmpty       = new AceBucket(Blocks.air,           "Adamantium").setUnlocalizedName("BucketAdamantiumEmpty").setCreativeTab(acetabCommon); GameRegistry.registerItem(bucketAdamantiumEmpty,       "BucketAdamantiumEmpty"      );
		bucketAdamantiumWater       = new AceBucket(Blocks.flowing_water, "Adamantium").setUnlocalizedName("BucketAdamantiumWater").setCreativeTab(acetabCommon); GameRegistry.registerItem(bucketAdamantiumWater,       "BucketAdamantiumWater"      );
		bucketAdamantiumLava        = new AceBucket(Blocks.flowing_lava,  "Adamantium").setUnlocalizedName("BucketAdamantiumLava") .setCreativeTab(acetabCommon); GameRegistry.registerItem(bucketAdamantiumLava,        "BucketAdamantiumLava"       );
		bucketAdamantiumOil         = new AceItems(false)                              .setUnlocalizedName("BucketAdamantiumOil");                                GameRegistry.registerItem(bucketAdamantiumOil,         "BucketAdamantiumOil"        );
		bucketAdamantiumMilk        = new AceItems(false)                              .setUnlocalizedName("BucketAdamantiumMilk");                               GameRegistry.registerItem(bucketAdamantiumMilk,        "BucketAdamantiumMilk"       );
		bucketAdamantiumCoconutMilk = new AceItems(false)                              .setUnlocalizedName("BucketAdamantiumCoconutMilk");                        GameRegistry.registerItem(bucketAdamantiumCoconutMilk, "BucketAdamantiumCoconutMilk");
		bucketAdamantiumApple       = new AceItems(false)                              .setUnlocalizedName("BucketAdamantiumApple");                              GameRegistry.registerItem(bucketAdamantiumApple,       "BucketAdamantiumApple"      );
		bucketAdamantiumBanana      = new AceItems(false)                              .setUnlocalizedName("BucketAdamantiumBanana");                             GameRegistry.registerItem(bucketAdamantiumBanana,      "BucketAdamantiumBanana"     );
		bucketAdamantiumCactusFruit = new AceItems(false)                              .setUnlocalizedName("BucketAdamantiumCactusFruit");                        GameRegistry.registerItem(bucketAdamantiumCactusFruit, "BucketAdamantiumCactusFruit");
		bucketAdamantiumCherry      = new AceItems(false)                              .setUnlocalizedName("BucketAdamantiumCherry");                             GameRegistry.registerItem(bucketAdamantiumCherry,      "BucketAdamantiumCherry"     );
		bucketAdamantiumGrapes      = new AceItems(false)                              .setUnlocalizedName("BucketAdamantiumGrapes");                             GameRegistry.registerItem(bucketAdamantiumGrapes,      "BucketAdamantiumGrapes"     );
		bucketAdamantiumLemon       = new AceItems(false)                              .setUnlocalizedName("BucketAdamantiumLemon");                              GameRegistry.registerItem(bucketAdamantiumLemon,       "BucketAdamantiumLemon"      );
		bucketAdamantiumOrange      = new AceItems(false)                              .setUnlocalizedName("BucketAdamantiumOrange");                             GameRegistry.registerItem(bucketAdamantiumOrange,      "BucketAdamantiumOrange"     );
		bucketAdamantiumPeach       = new AceItems(false)                              .setUnlocalizedName("BucketAdamantiumPeach");                              GameRegistry.registerItem(bucketAdamantiumPeach,       "BucketAdamantiumPeach"      );
		bucketAdamantiumPineapple   = new AceItems(false)                              .setUnlocalizedName("BucketAdamantiumPineapple");                          GameRegistry.registerItem(bucketAdamantiumPineapple,   "BucketAdamantiumPineapple"  );
		bucketAdamantiumTomato      = new AceItems(false)                              .setUnlocalizedName("BucketAdamantiumTomato");                             GameRegistry.registerItem(bucketAdamantiumTomato,      "BucketAdamantiumTomato"     );

		bucketUnobtaniumEmpty       = new AceBucket(Blocks.air,           "Unobtanium").setUnlocalizedName("BucketUnobtaniumEmpty").setCreativeTab(acetabCommon); GameRegistry.registerItem(bucketUnobtaniumEmpty,       "BucketUnobtaniumEmpty"      );
		bucketUnobtaniumWater       = new AceBucket(Blocks.flowing_water, "Unobtanium").setUnlocalizedName("BucketUnobtaniumWater").setCreativeTab(acetabCommon); GameRegistry.registerItem(bucketUnobtaniumWater,       "BucketUnobtaniumWater"      );
		bucketUnobtaniumLava        = new AceBucket(Blocks.flowing_lava,  "Unobtanium").setUnlocalizedName("BucketUnobtaniumLava") .setCreativeTab(acetabCommon); GameRegistry.registerItem(bucketUnobtaniumLava,        "BucketUnobtaniumLava"       );
		bucketUnobtaniumOil         = new AceItems(false)                              .setUnlocalizedName("BucketUnobtaniumOil");                                GameRegistry.registerItem(bucketUnobtaniumOil,         "BucketUnobtaniumOil"        );
		bucketUnobtaniumMilk        = new AceItems(false)                              .setUnlocalizedName("BucketUnobtaniumMilk");                               GameRegistry.registerItem(bucketUnobtaniumMilk,        "BucketUnobtaniumMilk"       );
		bucketUnobtaniumCoconutMilk = new AceItems(false)                              .setUnlocalizedName("BucketUnobtaniumCoconutMilk");                        GameRegistry.registerItem(bucketUnobtaniumCoconutMilk, "BucketUnobtaniumCoconutMilk");
		bucketUnobtaniumApple       = new AceItems(false)                              .setUnlocalizedName("BucketUnobtaniumApple");                              GameRegistry.registerItem(bucketUnobtaniumApple,       "BucketUnobtaniumApple"      );
		bucketUnobtaniumBanana      = new AceItems(false)                              .setUnlocalizedName("BucketUnobtaniumBanana");                             GameRegistry.registerItem(bucketUnobtaniumBanana,      "BucketUnobtaniumBanana"     );
		bucketUnobtaniumCactusFruit = new AceItems(false)                              .setUnlocalizedName("BucketUnobtaniumCactusFruit");                        GameRegistry.registerItem(bucketUnobtaniumCactusFruit, "BucketUnobtaniumCactusFruit");
		bucketUnobtaniumCherry      = new AceItems(false)                              .setUnlocalizedName("BucketUnobtaniumCherry");                             GameRegistry.registerItem(bucketUnobtaniumCherry,      "BucketUnobtaniumCherry"     );
		bucketUnobtaniumGrapes      = new AceItems(false)                              .setUnlocalizedName("BucketUnobtaniumGrapes");                             GameRegistry.registerItem(bucketUnobtaniumGrapes,      "BucketUnobtaniumGrapes"     );
		bucketUnobtaniumLemon       = new AceItems(false)                              .setUnlocalizedName("BucketUnobtaniumLemon");                              GameRegistry.registerItem(bucketUnobtaniumLemon,       "BucketUnobtaniumLemon"      );
		bucketUnobtaniumOrange      = new AceItems(false)                              .setUnlocalizedName("BucketUnobtaniumOrange");                             GameRegistry.registerItem(bucketUnobtaniumOrange,      "BucketUnobtaniumOrange"     );
		bucketUnobtaniumPeach       = new AceItems(false)                              .setUnlocalizedName("BucketUnobtaniumPeach");                              GameRegistry.registerItem(bucketUnobtaniumPeach,       "BucketUnobtaniumPeach"      );
		bucketUnobtaniumPineapple   = new AceItems(false)                              .setUnlocalizedName("BucketUnobtaniumPineapple");                          GameRegistry.registerItem(bucketUnobtaniumPineapple,   "BucketUnobtaniumPineapple"  );
		bucketUnobtaniumTomato      = new AceItems(false)                              .setUnlocalizedName("BucketUnobtaniumTomato");                             GameRegistry.registerItem(bucketUnobtaniumTomato,      "BucketUnobtaniumTomato"     );
		
		//Stuff
		stuffFur          = new AceItems(true).setUnlocalizedName("StuffFur");          GameRegistry.registerItem(stuffFur,          "StuffFur");
		stuffIvory        = new AceItems(true).setUnlocalizedName("StuffIvory");        GameRegistry.registerItem(stuffIvory,        "StuffIvory");
		stuffHemp         = new AceItems(true).setUnlocalizedName("StuffHemp");         GameRegistry.registerItem(stuffHemp,         "StuffHemp");
		stuffCotton       = new AceItems(true).setUnlocalizedName("StuffCotton");       GameRegistry.registerItem(stuffCotton,       "StuffCotton");
		stuffRope         = new AceItems(true).setUnlocalizedName("StuffRope");         GameRegistry.registerItem(stuffRope,         "StuffRope");
		stuffDynamite     = new AceDynamite().setUnlocalizedName("StuffDynamite");      GameRegistry.registerItem(stuffDynamite,     "StuffDynamite");
		stuffClothLinen   = new AceItems(true).setUnlocalizedName("StuffClothLinen");   GameRegistry.registerItem(stuffClothLinen,   "StuffClothLinen");
		stuffClothWool    = new AceItems(true).setUnlocalizedName("StuffClothWool");    GameRegistry.registerItem(stuffClothWool,    "StuffClothWool");
		stuffClothSilk    = new AceItems(true).setUnlocalizedName("StuffClothSilk");    GameRegistry.registerItem(stuffClothSilk,    "StuffClothSilk");
		stuffGear         = new AceItems(true).setUnlocalizedName("StuffGear");         GameRegistry.registerItem(stuffGear,         "StuffGear");
		stuffCoconutFull  = new AceItems(true).setUnlocalizedName("StuffCoconutFull");  GameRegistry.registerItem(stuffCoconutFull,  "StuffCoconutFull");
		stuffCoconutEmpty = new AceItems(true).setUnlocalizedName("StuffCoconutEmpty"); GameRegistry.registerItem(stuffCoconutEmpty, "StuffCoconutEmpty");
		
		//Food
		foodCoconutFlesh      = new AceFood( 2, 0.2F,  true, false, false).setUnlocalizedName("FoodCoconutFlesh");      GameRegistry.registerItem(foodCoconutFlesh,      "FoodCoconutFlesh");
		foodMammothMeatRaw    = new AceFood( 4, 0.5F,  true, false, false).setUnlocalizedName("FoodMammothMeatRaw");    GameRegistry.registerItem(foodMammothMeatRaw,    "FoodMammothMeatRaw");
		foodMammothMeatCooked = new AceFood( 8, 1.0F,  true, false, false).setUnlocalizedName("FoodMammothMeatCooked"); GameRegistry.registerItem(foodMammothMeatCooked, "FoodMammothMeatCooked");
		foodVenisonRaw        = new AceFood( 2, 0.4F,  true, false, false).setUnlocalizedName("FoodVenisonRaw");        GameRegistry.registerItem(foodVenisonRaw,        "FoodVenisonRaw");
		foodVenisonCooked     = new AceFood( 6, 0.8F,  true, false, false).setUnlocalizedName("FoodVenisonCooked");     GameRegistry.registerItem(foodVenisonCooked,     "FoodVenisonCooked");
		foodMuttonRaw         = new AceFood( 3, 0.4F,  true, false, false).setUnlocalizedName("FoodMuttonRaw");         GameRegistry.registerItem(foodMuttonRaw,         "FoodMuttonRaw");
		foodMuttonCooked      = new AceFood( 7, 0.8F,  true, false, false).setUnlocalizedName("FoodMuttonCooked");      GameRegistry.registerItem(foodMuttonCooked,      "FoodMuttonCooked");
		foodCrabMeatRaw       = new AceFood( 2, 0.3F,  true, false, false).setUnlocalizedName("FoodCrabMeatRaw");       GameRegistry.registerItem(foodCrabMeatRaw,       "FoodCrabMeatRaw");
		foodCrabMeatCooked    = new AceFood( 6, 0.8F,  true, false, false).setUnlocalizedName("FoodCrabMeatCooked");    GameRegistry.registerItem(foodCrabMeatCooked,    "FoodCrabMeatCooked");
		foodCalamariRaw       = new AceFood( 2, 0.2F,  true, false, false).setUnlocalizedName("FoodCalamariRaw");       GameRegistry.registerItem(foodCalamariRaw,       "FoodCalamariRaw");
		foodCalamariCooked    = new AceFood( 6, 0.7F,  true, false, false).setUnlocalizedName("FoodCalamariCooked");    GameRegistry.registerItem(foodCalamariCooked,    "FoodCalamariCooked");
		foodBanana            = new AceFood( 2, 0.2F, false, false, false).setUnlocalizedName("FoodBanana");            GameRegistry.registerItem(foodBanana,            "FoodBanana");
		foodLemon             = new AceFood( 1, 0.3F, false, false, false).setUnlocalizedName("FoodLemon");             GameRegistry.registerItem(foodLemon,             "FoodLemon");
		foodCherry            = new AceFood( 1, 0.2F, false, false, false).setUnlocalizedName("FoodCherry");            GameRegistry.registerItem(foodCherry,            "FoodCherry");
		foodOrange            = new AceFood( 2, 0.2F, false, false, false).setUnlocalizedName("FoodOrange");            GameRegistry.registerItem(foodOrange,            "FoodOrange");
		foodPeach             = new AceFood( 2, 0.2F, false, false, false).setUnlocalizedName("FoodPeach");             GameRegistry.registerItem(foodPeach,             "FoodPeach");
		if(loadedBiomesOPlenty){
		foodCactusFruit       = new AceFood( 1, 0.1F, false, false, false).setUnlocalizedName("FoodCactusFruit");       GameRegistry.registerItem(foodCactusFruit,       "FoodCactusFruit");}
		foodTurnip            = new AceFood( 2, 0.4F, false, false, false).setUnlocalizedName("FoodTurnip");            GameRegistry.registerItem(foodTurnip,            "FoodTurnip");
		foodGrapes            = new AceFood( 1, 0.1F, false, false, false).setUnlocalizedName("FoodGrapes");            GameRegistry.registerItem(foodGrapes,            "FoodGrapes");
		foodOnion             = new AceFood( 2, 0.1F, false, false, false).setUnlocalizedName("FoodOnion");             GameRegistry.registerItem(foodOnion,             "FoodOnion");
		foodPineapple         = new AceFood( 3, 0.3F, false, false, false).setUnlocalizedName("FoodPineapple");         GameRegistry.registerItem(foodPineapple,         "FoodPineapple");
		foodTomato            = new AceFood( 2, 0.3F, false, false, false).setUnlocalizedName("FoodTomato");            GameRegistry.registerItem(foodTomato,            "FoodTomato");
		foodCabbage           = new AceFood( 2, 0.3F, false, false, false).setUnlocalizedName("FoodCabbage");           GameRegistry.registerItem(foodCabbage,           "FoodCabbage");
		foodRice              = new AceFood( 3, 0.1F, false, false, false).setUnlocalizedName("FoodRice");              GameRegistry.registerItem(foodRice,              "FoodRice");
		foodMaise             = new AceFood( 2, 0.2F, false, false, false).setUnlocalizedName("FoodMaise");             GameRegistry.registerItem(foodMaise,             "FoodMaise");
		foodCoffeeBeans       = new AceFood( 1, 0.1F, false, false, false).setUnlocalizedName("FoodCoffeeBeans");       GameRegistry.registerItem(foodCoffeeBeans,       "FoodCoffeeBeans");
		foodPeas              = new AceFood( 1, 0.1F, false, false, false).setUnlocalizedName("FoodPeas");              GameRegistry.registerItem(foodPeas,              "FoodPeas");
		foodPickles           = new AceFood( 1, 0.2F, false, false, false).setUnlocalizedName("FoodPickles");           GameRegistry.registerItem(foodPickles,           "FoodPickles");
		foodCheeseWheel       = new AceFood( 8, 0.8F, false, false, false).setUnlocalizedName("FoodCheeseWheel");       GameRegistry.registerItem(foodCheeseWheel,       "FoodCheeseWheel");
		foodCheese            = new AceFood( 2, 0.2F, false, false, false).setUnlocalizedName("FoodCheese");            GameRegistry.registerItem(foodCheese,            "FoodCheese");
		
		foodRiceball          = new AceFood( 3, 1.4F, false, false, false).setUnlocalizedName("FoodRiceball");          GameRegistry.registerItem(foodRiceball,          "FoodRiceball");
		foodRiceBowl          = new AceFood( 5, 1.4F, false, false,  true).setUnlocalizedName("FoodRiceBowl");          GameRegistry.registerItem(foodRiceBowl,          "FoodRiceBowl");
		foodSalad             = new AceFood( 5, 1.4F, false, false,  true).setUnlocalizedName("FoodSalad");             GameRegistry.registerItem(foodSalad,             "FoodSalad");
		foodFruitSalad        = new AceFood( 5, 1.4F, false, false,  true).setUnlocalizedName("FoodFruitSalad");        GameRegistry.registerItem(foodFruitSalad,        "FoodFruitSalad");
		foodBurger            = new AceFood( 8, 1.4F,  true, false, false).setUnlocalizedName("FoodBurger");            GameRegistry.registerItem(foodBurger,            "FoodBurger");
		foodCheeseBurger      = new AceFood( 9, 1.4F,  true, false, false).setUnlocalizedName("FoodCheeseBurger");      GameRegistry.registerItem(foodCheeseBurger,      "FoodCheeseBurger");
		foodKebab             = new AceFood( 8, 1.4F,  true, false, false).setUnlocalizedName("FoodKebab");             GameRegistry.registerItem(foodKebab,             "FoodKebab");
		if(loadedBiomesOPlenty){
		foodDungeonFilet      = new AceFood(10, 1.6F,  true, false, false).setUnlocalizedName("FoodDungeonFilet");      GameRegistry.registerItem(foodDungeonFilet,      "FoodDungeonFilet");}
		foodStirFry           = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodStirFry");           GameRegistry.registerItem(foodStirFry,           "FoodStirFry");
		foodFriedRice         = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodFriedRice");         GameRegistry.registerItem(foodFriedRice,         "FoodFriedRice");
		foodSavoryPancake     = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodSavoryPancake");     GameRegistry.registerItem(foodSavoryPancake,     "FoodSavoryPancake");
		foodFrenchFries       = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodFrenchFries");       GameRegistry.registerItem(foodFrenchFries,       "FoodFrenchFries");
		foodCroquette         = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodCroquette");         GameRegistry.registerItem(foodCroquette,         "FoodCroquette");
		foodPopcorn           = new AceFood( 3, 1.4F, false, false, false).setUnlocalizedName("FoodPopcorn");           GameRegistry.registerItem(foodPopcorn,           "FoodPopcorn");
		foodScrambledEggs     = new AceFood( 4, 1.4F, false, false, false).setUnlocalizedName("FoodScrambledEggs");     GameRegistry.registerItem(foodScrambledEggs,     "FoodScrambledEggs");
		foodOmelet            = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodOmelet");            GameRegistry.registerItem(foodOmelet,            "FoodOmelet");
		foodOmeletRice        = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodOmeletRice");        GameRegistry.registerItem(foodOmeletRice,        "FoodOmeletRice");
		foodAppleSouffle      = new AceFood( 6, 1.4F, false, false, false).setUnlocalizedName("FoodAppleSouffle");      GameRegistry.registerItem(foodAppleSouffle,      "FoodAppleSouffle");
		if(loadedMillenaire){
		foodCurryBread        = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodCurryBread");        GameRegistry.registerItem(foodCurryBread,        "FoodCurryBread");}
		foodFrenchToast       = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodFrenchToast");       GameRegistry.registerItem(foodFrenchToast,       "FoodFrenchToast");
		foodDoughnut          = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodDoughnut");          GameRegistry.registerItem(foodDoughnut,          "FoodDoughnut");
		foodFriedNoodles      = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodFriedNoodles");      GameRegistry.registerItem(foodFriedNoodles,      "FoodFriedNoodles");
		foodTempura           = new AceFood( 6, 1.4F, false, false, false).setUnlocalizedName("FoodTempura");           GameRegistry.registerItem(foodTempura,           "FoodTempura");
		foodPancake           = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodPancake");           GameRegistry.registerItem(foodPancake,           "FoodPancake");
		foodPotSticker        = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodPotSticker");        GameRegistry.registerItem(foodPotSticker,        "FoodPotSticker");
		foodRisotto           = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodRisotto");           GameRegistry.registerItem(foodRisotto,           "FoodRisotto");
		if(loadedMillenaire){
		foodDryCurry          = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodDryCurry");          GameRegistry.registerItem(foodDryCurry,          "FoodDryCurry");}
		foodPumpkinStew       = new AceFood( 6, 1.4F, false, false,  true).setUnlocalizedName("FoodPumpkinStew");       GameRegistry.registerItem(foodPumpkinStew,       "FoodPumpkinStew");
		foodFishStew          = new AceFood( 6, 1.4F, false, false,  true).setUnlocalizedName("FoodFishStew");          GameRegistry.registerItem(foodFishStew,          "FoodFishStew");
		foodBoiledEgg         = new AceFood( 2, 1.4F, false, false, false).setUnlocalizedName("FoodBoiledEgg");         GameRegistry.registerItem(foodBoiledEgg,         "FoodBoiledEgg");
		foodDumplings         = new AceFood( 4, 1.4F, false, false, false).setUnlocalizedName("FoodDumplings");         GameRegistry.registerItem(foodDumplings,         "FoodDumplings");
		foodCheeseFondue      = new AceFood( 6, 1.4F, false, false,  true).setUnlocalizedName("FoodCheeseFondue");      GameRegistry.registerItem(foodCheeseFondue,      "FoodCheeseFondue");
		foodNoodles           = new AceFood( 5, 1.4F, false, false, false).setUnlocalizedName("FoodNoodles");           GameRegistry.registerItem(foodNoodles,           "FoodNoodles");
		if(loadedMillenaire){
		foodCurryNoodles      = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodCurryNoodles");      GameRegistry.registerItem(foodCurryNoodles,      "FoodCurryNoodles");}
		foodTempuraNoodles    = new AceFood(10, 1.4F, false, false, false).setUnlocalizedName("FoodTempuraNoodles");    GameRegistry.registerItem(foodTempuraNoodles,    "FoodTempuraNoodles");
		if(loadedBiomesOPlenty){
		foodMountainStew      = new AceFood( 6, 1.4F, false, false,  true).setUnlocalizedName("FoodMountainStew");      GameRegistry.registerItem(foodMountainStew,      "FoodMountainStew");}
		foodRiceSoup          = new AceFood( 6, 1.4F, false, false,  true).setUnlocalizedName("FoodRiceSoup");          GameRegistry.registerItem(foodRiceSoup,          "FoodRiceSoup");
		foodPorridge          = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodPorridge");          GameRegistry.registerItem(foodPorridge,          "FoodPorridge");
		foodTempuraRice       = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodTempuraRice");       GameRegistry.registerItem(foodTempuraRice,       "FoodTempuraRice");
		foodEggOverRice       = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodEggOverRice");       GameRegistry.registerItem(foodEggOverRice,       "FoodEggOverRice");
		foodStew              = new AceFood( 6, 1.4F, false, false,  true).setUnlocalizedName("FoodStew");              GameRegistry.registerItem(foodStew,              "FoodStew");
		if(loadedMillenaire){
		foodCurryRice         = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodCurryRice");         GameRegistry.registerItem(foodCurryRice,         "FoodCurryRice");}
		foodBakedCorn         = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodBakedCorn");         GameRegistry.registerItem(foodBakedCorn,         "FoodBakedCorn");
		foodToastedRiceBall   = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodToastedRiceBall");   GameRegistry.registerItem(foodToastedRiceBall,   "FoodToastedRiceBall");
		foodToast             = new AceFood( 6, 1.4F, false, false, false).setUnlocalizedName("FoodToast");             GameRegistry.registerItem(foodToast,             "FoodToast");
		foodDinnerRoll        = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodDinnerRoll");        GameRegistry.registerItem(foodDinnerRoll,        "FoodDinnerRoll");
		foodPizza             = new AceCake().setBlockTextureName("FoodPizza")                             .setBlockName      ("FoodPizza");             GameRegistry.registerBlock(foodPizza, ItemCakeBlock.class, foodPizza.getUnlocalizedName().substring(5));
		foodDoria             = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodDoria");             GameRegistry.registerItem(foodDoria,             "FoodDoria");
		foodGratin            = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodGratin");            GameRegistry.registerItem(foodGratin,            "FoodGratin");
		foodChocolateCake     = new AceCake().setBlockTextureName("FoodChocolateCake")                             .setBlockName      ("FoodChocolateCake");     GameRegistry.registerBlock(foodChocolateCake, ItemCakeBlock.class, foodChocolateCake.getUnlocalizedName().substring(5));
		foodCheesecake        = new AceCake().setBlockTextureName("FoodCheesecake")                             .setBlockName      ("FoodCheesecake");        GameRegistry.registerBlock(foodCheesecake,    ItemCakeBlock.class, foodCheesecake   .getUnlocalizedName().substring(5));
		foodApplePie          = new AceCake().setBlockTextureName("FoodApplePie")                             .setBlockName      ("FoodApplePie");          GameRegistry.registerBlock(foodApplePie,      ItemCakeBlock.class, foodApplePie     .getUnlocalizedName().substring(5));
		foodSteamedBun        = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodSteamedBun");        GameRegistry.registerItem(foodSteamedBun,        "FoodSteamedBun");
		foodCheeseSteamedBun  = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodCheeseSteamedBun");  GameRegistry.registerItem(foodCheeseSteamedBun,  "FoodCheeseSteamedBun");
		foodShaomai           = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodShaomai");           GameRegistry.registerItem(foodShaomai,           "FoodShaomai");
		if(loadedBiomesOPlenty){
		foodSteamedEgg        = new AceFood( 4, 1.4F, false, false, false).setUnlocalizedName("FoodSteamedEgg");        GameRegistry.registerItem(foodSteamedEgg,        "FoodSteamedEgg");}
		foodChineseBun        = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodChineseBun");        GameRegistry.registerItem(foodChineseBun,        "FoodChineseBun");
		foodCurryBun          = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodCurryBun");          GameRegistry.registerItem(foodCurryBun,          "FoodCurryBun");
		foodSteamedDumplings  = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodSteamedDumplings");  GameRegistry.registerItem(foodSteamedDumplings,  "FoodSteamedDumplings");
		foodSpongeCake        = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodSpongeCake");        GameRegistry.registerItem(foodSpongeCake,        "FoodSpongeCake");
		foodSteamedCake       = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodSteamedCake");       GameRegistry.registerItem(foodSteamedCake,       "FoodSteamedCake");
		foodPudding           = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodPudding");           GameRegistry.registerItem(foodPudding,           "FoodPudding");
		foodPumpkinPudding    = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodPumpkinPudding");    GameRegistry.registerItem(foodPumpkinPudding,    "FoodPumpkinPudding");
		foodSandwich          = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodSandwich");          GameRegistry.registerItem(foodSandwich,          "FoodSandwich");
		foodFruitSandwich     = new AceFood( 8, 1.4F, false, false, false).setUnlocalizedName("FoodFruitSandwich");     GameRegistry.registerItem(foodFruitSandwich,     "FoodFruitSandwich");
		foodPickledTurnip     = new AceFood( 5, 1.4F, false, false, false).setUnlocalizedName("FoodPickledTurnip");     GameRegistry.registerItem(foodPickledTurnip,     "FoodPickledTurnip");
		foodPickledCucumber   = new AceFood( 5, 1.4F, false, false, false).setUnlocalizedName("FoodPickledCucumber");   GameRegistry.registerItem(foodPickledCucumber,   "FoodPickledCucumber");
		if(loadedBiomesOPlenty){
		foodBambooRice        = new AceFood( 6, 1.4F, false, false, false).setUnlocalizedName("FoodBambooRice");        GameRegistry.registerItem(foodBambooRice,        "FoodBambooRice");}
		foodMushroomRice      = new AceFood( 6, 1.4F, false, false, false).setUnlocalizedName("FoodMushroomRice");      GameRegistry.registerItem(foodMushroomRice,      "FoodMushroomRice");
		foodSushi             = new AceFood( 6, 1.4F, false, false, false).setUnlocalizedName("FoodSushi");             GameRegistry.registerItem(foodSushi,             "FoodSushi");
		foodRaisinBread       = new AceFood( 7, 1.4F, false, false, false).setUnlocalizedName("FoodRaisinBread");       GameRegistry.registerItem(foodRaisinBread,       "FoodRaisinBread");
		foodChirashiSushi     = new AceFood( 6, 1.4F, false, false, false).setUnlocalizedName("FoodChirashiSushi");     GameRegistry.registerItem(foodChirashiSushi,     "FoodChirashiSushi");
		foodIceCream          = new AceFood( 4, 1.4F, false, false, false).setUnlocalizedName("FoodIceCream");          GameRegistry.registerItem(foodIceCream,          "FoodIceCream");
		foodSeaSaltIceCream   = new AceFood( 4, 1.4F, false, false, false).setUnlocalizedName("FoodSeaSaltIceCream");   GameRegistry.registerItem(foodSeaSaltIceCream,   "FoodSeaSaltIceCream");
		foodKrabbyPatty       = new AceFood(10, 1.7F,  true, false, false).setUnlocalizedName("FoodKrabbyPatty");       GameRegistry.registerItem(foodKrabbyPatty,       "FoodKrabbyPatty");
		
		//Juice
		juiceOil           = new AceFood(1, 0.1F, false,  true,  true).setUnlocalizedName("JuiceOil");           GameRegistry.registerItem(juiceOil,           "JuiceOil");
		juiceApple         = new AceFood(3, 0.2F, false,  true,  true).setUnlocalizedName("JuiceApple");         GameRegistry.registerItem(juiceApple,         "JuiceApple");
		juiceBanana        = new AceFood(3, 0.2F, false,  true,  true).setUnlocalizedName("JuiceBanana");        GameRegistry.registerItem(juiceBanana,        "JuiceBanana");
		juiceCactus        = new AceFood(3, 0.2F, false,  true,  true).setUnlocalizedName("JuiceCactus");        GameRegistry.registerItem(juiceCactus,        "JuiceCactus");
		juiceCherry        = new AceFood(3, 0.2F, false,  true,  true).setUnlocalizedName("JuiceCherry");        GameRegistry.registerItem(juiceCherry,        "JuiceCherry");
		juiceChocolateMilk = new AceFood(3, 0.3F, false,  true,  true).setUnlocalizedName("JuiceChocolateMilk"); GameRegistry.registerItem(juiceChocolateMilk, "JuiceChocolateMilk");
		juiceCoconutMilk   = new AceFood(3, 0.3F, false,  true,  true).setUnlocalizedName("JuiceCoconutMilk");   GameRegistry.registerItem(juiceCoconutMilk,   "JuiceCoconutMilk");
		juiceCoffee        = new AceFood(2, 0.1F, false,  true,  true).setUnlocalizedName("JuiceCoffee");        GameRegistry.registerItem(juiceCoffee,        "JuiceCoffee");
		juiceGrapes        = new AceFood(3, 0.2F, false,  true,  true).setUnlocalizedName("JuiceGrapes");        GameRegistry.registerItem(juiceGrapes,        "JuiceGrapes");
		juiceLemon         = new AceFood(3, 0.2F, false,  true,  true).setUnlocalizedName("JuiceLemon");         GameRegistry.registerItem(juiceLemon,         "JuiceLemon");
		juiceMilk          = new AceFood(3, 0.3F, false,  true,  true).setUnlocalizedName("JuiceMilk");          GameRegistry.registerItem(juiceMilk,          "JuiceMilk");
		juiceOrange        = new AceFood(3, 0.2F, false,  true,  true).setUnlocalizedName("JuiceOrange");        GameRegistry.registerItem(juiceOrange,        "JuiceOrange");
		juicePeach         = new AceFood(3, 0.2F, false,  true,  true).setUnlocalizedName("JuicePeach");         GameRegistry.registerItem(juicePeach,         "JuicePeach");
		juicePineapple     = new AceFood(3, 0.2F, false,  true,  true).setUnlocalizedName("JuicePineapple");     GameRegistry.registerItem(juicePineapple,     "JuicePineapple");
		juiceTomato        = new AceFood(3, 0.2F, false,  true,  true).setUnlocalizedName("JuiceTomato");        GameRegistry.registerItem(juiceTomato,        "JuiceTomato");
		
		//Liquor
		liquorCoconutRum    = new AceFood(1, 0.1F, false,  true,  true).setUnlocalizedName("LiquorCoconutRum");    GameRegistry.registerItem(liquorCoconutRum,    "LiquorCoconutRum");
		liquorCider         = new AceFood(1, 0.1F, false,  true,  true).setUnlocalizedName("LiquorCider");         GameRegistry.registerItem(liquorCider,         "LiquorCider");
		liquorRum           = new AceFood(1, 0.1F, false,  true,  true).setUnlocalizedName("LiquorRum");           GameRegistry.registerItem(liquorRum,           "LiquorRum");
		liquorBeer          = new AceFood(1, 0.1F, false,  true,  true).setUnlocalizedName("LiquorBeer");          GameRegistry.registerItem(liquorBeer,          "LiquorBeer");
		liquorSalgam        = new AceFood(1, 0.1F, false,  true,  true).setUnlocalizedName("LiquorSalgam");        GameRegistry.registerItem(liquorSalgam,        "LiquorSalgam");
		liquorVodka         = new AceFood(1, 0.1F, false,  true,  true).setUnlocalizedName("LiquorVodka");         GameRegistry.registerItem(liquorVodka,         "LiquorVodka");
		liquorCactusJack    = new AceFood(1, 0.1F, false,  true,  true).setUnlocalizedName("LiquorCactusJack");    GameRegistry.registerItem(liquorCactusJack,    "LiquorCactusJack");
		liquorSake          = new AceFood(1, 0.1F, false,  true,  true).setUnlocalizedName("LiquorSake");          GameRegistry.registerItem(liquorSake,          "LiquorSake");
		liquorMead          = new AceFood(1, 0.1F, false,  true,  true).setUnlocalizedName("LiquorMead");          GameRegistry.registerItem(liquorMead,          "LiquorMead");
		liquorWineGrapes    = new AceFood(2, 0.1F, false,  true,  true).setUnlocalizedName("LiquorWineGrapes");    GameRegistry.registerItem(liquorWineGrapes,    "LiquorWineGrapes");
		liquorWineCherry    = new AceFood(2, 0.1F, false,  true,  true).setUnlocalizedName("LiquorWineCherry");    GameRegistry.registerItem(liquorWineCherry,    "LiquorWineCherry");
		liquorWinePineapple = new AceFood(2, 0.1F, false,  true,  true).setUnlocalizedName("LiquorWinePineapple"); GameRegistry.registerItem(liquorWinePineapple, "LiquorWinePineapple");
		
		//Crops
		cropTurnip       = new AceCrop().setBlockName("CropTurnip");       GameRegistry.registerBlock(cropTurnip,       "CropTurnip");
		cropGrapes       = new AceCrop().setBlockName("CropGrapes");       GameRegistry.registerBlock(cropGrapes,       "CropGrapes");
		cropOnion        = new AceCrop().setBlockName("CropOnion");        GameRegistry.registerBlock(cropOnion,        "CropOnion");
		cropPineapple    = new AceCrop().setBlockName("CropPineapple");    GameRegistry.registerBlock(cropPineapple,    "CropPineapple");
		cropTomato       = new AceCrop().setBlockName("CropTomato");       GameRegistry.registerBlock(cropTomato,       "CropTomato");
		cropCabbage      = new AceCrop().setBlockName("CropCabbage");      GameRegistry.registerBlock(cropCabbage,      "CropCabbage");
		cropRice         = new AceCrop().setBlockName("CropRice");         GameRegistry.registerBlock(cropRice,         "CropRice");
		cropMaise        = new AceCrop().setBlockName("CropMaise");        GameRegistry.registerBlock(cropMaise,        "CropMaise");
		cropCoffeeBeans  = new AceCrop().setBlockName("CropCoffeeBeans");  GameRegistry.registerBlock(cropCoffeeBeans,  "CropCoffeeBeans");
		cropPeas         = new AceCrop().setBlockName("CropPeas");         GameRegistry.registerBlock(cropPeas,         "CropPeas");
		cropPickles      = new AceCrop().setBlockName("CropPickles");      GameRegistry.registerBlock(cropPickles,      "CropPickles");
		cropGoldenCarrot = new AceCrop().setBlockName("CropGoldenCarrot"); GameRegistry.registerBlock(cropGoldenCarrot, "CropGoldenCarrot");
		cropHemp         = new AceCrop().setBlockName("CropHemp");         GameRegistry.registerBlock(cropHemp,         "CropHemp");
		cropCotton       = new AceCrop().setBlockName("CropCotton");       GameRegistry.registerBlock(cropCotton,       "CropCotton");
		cropCoconut      = new AceCrop().setBlockName("CropCoconut");      GameRegistry.registerBlock(cropCoconut,      "CropCoconut");
		cropBanana       = new AceCrop().setBlockName("CropBanana");       GameRegistry.registerBlock(cropBanana,       "CropBanana");
		
		//Seeds
		seedsWild        = new AceSeeds(Blocks.dirt,     Blocks.farmland).setUnlocalizedName("SeedsWild");        GameRegistry.registerItem(seedsWild,        "SeedsWild");
		seedsTurnip      = new AceSeeds(cropTurnip,      Blocks.farmland).setUnlocalizedName("SeedsTurnip");      GameRegistry.registerItem(seedsTurnip,      "SeedsTurnip");
		seedsGrapes      = new AceSeeds(cropGrapes,      Blocks.farmland).setUnlocalizedName("SeedsGrapes");      GameRegistry.registerItem(seedsGrapes,      "SeedsGrapes");
		seedsOnion       = new AceSeeds(cropOnion,       Blocks.farmland).setUnlocalizedName("SeedsOnion");       GameRegistry.registerItem(seedsOnion,       "SeedsOnion");
		seedsPineapple   = new AceSeeds(cropPineapple,   Blocks.farmland).setUnlocalizedName("SeedsPineapple");   GameRegistry.registerItem(seedsPineapple,   "SeedsPineapple");
		seedsTomato      = new AceSeeds(cropTomato,      Blocks.farmland).setUnlocalizedName("SeedsTomato");      GameRegistry.registerItem(seedsTomato,      "SeedsTomato");
		seedsCabbage     = new AceSeeds(cropCabbage,     Blocks.farmland).setUnlocalizedName("SeedsCabbage");     GameRegistry.registerItem(seedsCabbage,     "SeedsCabbage");
		seedsRice        = new AceSeeds(cropRice,        Blocks.farmland).setUnlocalizedName("SeedsRice");        GameRegistry.registerItem(seedsRice,        "SeedsRice");
		seedsMaise       = new AceSeeds(cropMaise,       Blocks.farmland).setUnlocalizedName("SeedsMaise");       GameRegistry.registerItem(seedsMaise,       "SeedsMaise");
		seedsCoffeeBeans = new AceSeeds(cropCoffeeBeans, Blocks.farmland).setUnlocalizedName("SeedsCoffeeBeans"); GameRegistry.registerItem(seedsCoffeeBeans, "SeedsCoffeeBeans");
		seedsPeas        = new AceSeeds(cropPeas,        Blocks.farmland).setUnlocalizedName("SeedsPeas");        GameRegistry.registerItem(seedsPeas,        "SeedsPeas");
		seedsPickles     = new AceSeeds(cropPickles,     Blocks.farmland).setUnlocalizedName("SeedsPickles");     GameRegistry.registerItem(seedsPickles,     "SeedsPickles");
		seedsHemp        = new AceSeeds(cropHemp,        Blocks.farmland).setUnlocalizedName("SeedsHemp");        GameRegistry.registerItem(seedsHemp,        "SeedsHemp");
		seedsCotton      = new AceSeeds(cropCotton,      Blocks.farmland).setUnlocalizedName("SeedsCotton");      GameRegistry.registerItem(seedsCotton,      "SeedsCotton");
		
		//Tree
		aceLog    = new AceLog()   .setBlockName("Log");    GameRegistry.registerBlock(aceLog,    ItemLogBlocks   .class, aceLog   .getUnlocalizedName().substring(5));
		acePlanks = new AcePlanks().setBlockName("Planks"); GameRegistry.registerBlock(acePlanks, ItemPlanksBlocks.class, acePlanks.getUnlocalizedName().substring(5));
		
		leavesCherryEmpty   = new AceLeaf().setBlockName("LeavesCherryEmpty")  .setCreativeTab(acetabCommon); GameRegistry.registerBlock(leavesCherryEmpty,   ItemLeafBlocks.class, leavesCherryEmpty  .getUnlocalizedName().substring(5));
		leavesCherryBlossom = new AceLeaf().setBlockName("LeavesCherryBlossom")                             ; GameRegistry.registerBlock(leavesCherryBlossom, ItemLeafBlocks.class, leavesCherryBlossom.getUnlocalizedName().substring(5));
		leavesCherryFruit   = new AceLeaf().setBlockName("LeavesCherryFruit")                               ; GameRegistry.registerBlock(leavesCherryFruit,   ItemLeafBlocks.class, leavesCherryFruit  .getUnlocalizedName().substring(5));
		leavesLemonEmpty    = new AceLeaf().setBlockName("LeavesLemonEmpty")   .setCreativeTab(acetabCommon); GameRegistry.registerBlock(leavesLemonEmpty,    ItemLeafBlocks.class, leavesLemonEmpty   .getUnlocalizedName().substring(5));
		leavesLemonBlossom  = new AceLeaf().setBlockName("LeavesLemonBlossom")                              ; GameRegistry.registerBlock(leavesLemonBlossom,  ItemLeafBlocks.class, leavesLemonBlossom .getUnlocalizedName().substring(5));
		leavesLemonFruit    = new AceLeaf().setBlockName("LeavesLemonFruit")                                ; GameRegistry.registerBlock(leavesLemonFruit,    ItemLeafBlocks.class, leavesLemonFruit   .getUnlocalizedName().substring(5));
		leavesOrangeEmpty   = new AceLeaf().setBlockName("LeavesOrangeEmpty")  .setCreativeTab(acetabCommon); GameRegistry.registerBlock(leavesOrangeEmpty,   ItemLeafBlocks.class, leavesOrangeEmpty  .getUnlocalizedName().substring(5));
		leavesOrangeBlossom = new AceLeaf().setBlockName("LeavesOrangeBlossom")                             ; GameRegistry.registerBlock(leavesOrangeBlossom, ItemLeafBlocks.class, leavesOrangeBlossom.getUnlocalizedName().substring(5));
		leavesOrangeFruit   = new AceLeaf().setBlockName("LeavesOrangeFruit")                               ; GameRegistry.registerBlock(leavesOrangeFruit,   ItemLeafBlocks.class, leavesOrangeFruit  .getUnlocalizedName().substring(5));
		leavesPeachEmpty    = new AceLeaf().setBlockName("LeavesPeachEmpty")   .setCreativeTab(acetabCommon); GameRegistry.registerBlock(leavesPeachEmpty,    ItemLeafBlocks.class, leavesPeachEmpty   .getUnlocalizedName().substring(5));
		leavesPeachBlossom  = new AceLeaf().setBlockName("LeavesPeachBlossom")                              ; GameRegistry.registerBlock(leavesPeachBlossom,  ItemLeafBlocks.class, leavesPeachBlossom .getUnlocalizedName().substring(5));
		leavesPeachFruit    = new AceLeaf().setBlockName("LeavesPeachFruit")                                ; GameRegistry.registerBlock(leavesPeachFruit,    ItemLeafBlocks.class, leavesPeachFruit   .getUnlocalizedName().substring(5));
		leavesAppleEmpty    = new AceLeaf().setBlockName("LeavesAppleEmpty")   .setCreativeTab(acetabCommon); GameRegistry.registerBlock(leavesAppleEmpty,    ItemLeafBlocks.class, leavesAppleEmpty   .getUnlocalizedName().substring(5));
		leavesAppleBlossom  = new AceLeaf().setBlockName("LeavesAppleBlossom")                              ; GameRegistry.registerBlock(leavesAppleBlossom,  ItemLeafBlocks.class, leavesAppleBlossom .getUnlocalizedName().substring(5));
		leavesAppleFruit    = new AceLeaf().setBlockName("LeavesAppleFruit")                                ; GameRegistry.registerBlock(leavesAppleFruit,    ItemLeafBlocks.class, leavesAppleFruit   .getUnlocalizedName().substring(5));
		leavesGoldenEmpty   = new AceLeaf().setBlockName("LeavesGoldenEmpty")  .setCreativeTab(acetabCommon); GameRegistry.registerBlock(leavesGoldenEmpty,   ItemLeafBlocks.class, leavesGoldenEmpty  .getUnlocalizedName().substring(5));
		leavesGoldenBlossom = new AceLeaf().setBlockName("LeavesGoldenBlossom")                             ; GameRegistry.registerBlock(leavesGoldenBlossom, ItemLeafBlocks.class, leavesGoldenBlossom.getUnlocalizedName().substring(5));
		leavesGoldenFruit   = new AceLeaf().setBlockName("LeavesGoldenFruit")                               ; GameRegistry.registerBlock(leavesGoldenFruit,   ItemLeafBlocks.class, leavesGoldenFruit  .getUnlocalizedName().substring(5));
		leavesPalmTree      = new AceLeaf().setBlockName("LeavesPalmTree")     .setCreativeTab(acetabCommon); GameRegistry.registerBlock(leavesPalmTree,      ItemLeafBlocks.class, leavesPalmTree     .getUnlocalizedName().substring(5));
		
		aceSapling = new AceSapling().setBlockName("Sapling"); GameRegistry.registerBlock(aceSapling, ItemSaplingBlocks.class, aceSapling.getUnlocalizedName().substring(5));
		
		//Beds
		bedBlack     = new AceBed().setBlockName("BedBlack");     GameRegistry.registerBlock(bedBlack,     ItemAceBed.class, bedBlack    .getUnlocalizedName().substring(5));
		bedBlue      = new AceBed().setBlockName("BedBlue");      GameRegistry.registerBlock(bedBlue,      ItemAceBed.class, bedBlue     .getUnlocalizedName().substring(5));
		bedBrown     = new AceBed().setBlockName("BedBrown");     GameRegistry.registerBlock(bedBrown,     ItemAceBed.class, bedBrown    .getUnlocalizedName().substring(5));
		bedCyan      = new AceBed().setBlockName("BedCyan");      GameRegistry.registerBlock(bedCyan,      ItemAceBed.class, bedCyan     .getUnlocalizedName().substring(5));
		bedGreen     = new AceBed().setBlockName("BedGreen");     GameRegistry.registerBlock(bedGreen,     ItemAceBed.class, bedGreen    .getUnlocalizedName().substring(5));
		bedGrey      = new AceBed().setBlockName("BedGrey");      GameRegistry.registerBlock(bedGrey,      ItemAceBed.class, bedGrey     .getUnlocalizedName().substring(5));
		bedLightBlue = new AceBed().setBlockName("BedLightBlue"); GameRegistry.registerBlock(bedLightBlue, ItemAceBed.class, bedLightBlue.getUnlocalizedName().substring(5));
		bedLime      = new AceBed().setBlockName("BedLime");      GameRegistry.registerBlock(bedLime,      ItemAceBed.class, bedLime     .getUnlocalizedName().substring(5));
		bedMagenta   = new AceBed().setBlockName("BedMagenta");   GameRegistry.registerBlock(bedMagenta,   ItemAceBed.class, bedMagenta  .getUnlocalizedName().substring(5));
		bedOrange    = new AceBed().setBlockName("BedOrange");    GameRegistry.registerBlock(bedOrange,    ItemAceBed.class, bedOrange   .getUnlocalizedName().substring(5));
		bedPink      = new AceBed().setBlockName("BedPink");      GameRegistry.registerBlock(bedPink,      ItemAceBed.class, bedPink     .getUnlocalizedName().substring(5));
		bedPurple    = new AceBed().setBlockName("BedPurple");    GameRegistry.registerBlock(bedPurple,    ItemAceBed.class, bedPurple   .getUnlocalizedName().substring(5));
		bedRed       = new AceBed().setBlockName("BedRed");       GameRegistry.registerBlock(bedRed,       ItemAceBed.class, bedRed      .getUnlocalizedName().substring(5));
		bedSilver    = new AceBed().setBlockName("BedSilver");    GameRegistry.registerBlock(bedSilver,    ItemAceBed.class, bedSilver   .getUnlocalizedName().substring(5));
		bedWhite     = new AceBed().setBlockName("BedWhite");     GameRegistry.registerBlock(bedWhite,     ItemAceBed.class, bedWhite    .getUnlocalizedName().substring(5));
		bedYellow    = new AceBed().setBlockName("BedYellow");    GameRegistry.registerBlock(bedYellow,    ItemAceBed.class, bedYellow   .getUnlocalizedName().substring(5));
		
		//Advanced Constructions
		machinaBlastFurnaceIdle   = new BlastFurnace(false).setBlockName("BlastFurnaceIdle")  .setCreativeTab(acetabMachina); GameRegistry.registerBlock(machinaBlastFurnaceIdle,   "BlastFurnaceIdle");
		machinaBlastFurnaceActive = new BlastFurnace(true) .setBlockName("BlastFurnaceActive").setLightLevel(0.825F);         GameRegistry.registerBlock(machinaBlastFurnaceActive, "BlastFurnaceActive");
		machinaWorkbench          = new Workbench()        .setBlockName("AceWorkbench");                                     GameRegistry.registerBlock(machinaWorkbench,          "AceWorkench");
		machinaSewingStation      = new SewingStation()    .setBlockName("SewingStation");                                    GameRegistry.registerBlock(machinaSewingStation,      "SewingStation");
		machinaAnvilIron          = new Anvil()            .setBlockName("AnvilIron");                                        GameRegistry.registerBlock(machinaAnvilIron,          "AnvilIron");
		machinaAnvilCopper        = new Anvil()            .setBlockName("AnvilCopper");                                      GameRegistry.registerBlock(machinaAnvilCopper,        "AnvilCopper");
		machinaAnvilAluminium     = new Anvil()            .setBlockName("AnvilAluminium");                                   GameRegistry.registerBlock(machinaAnvilAluminium,     "AnvilAluminium");
		machinaAnvilLead          = new Anvil()            .setBlockName("AnvilLead");                                        GameRegistry.registerBlock(machinaAnvilLead,          "AnvilLead");
		machinaAnvilBronze        = new Anvil()            .setBlockName("AnvilBronze");                                      GameRegistry.registerBlock(machinaAnvilBronze,        "AnvilBronze");
		machinaAnvilSteel         = new Anvil()            .setBlockName("AnvilSteel");                                       GameRegistry.registerBlock(machinaAnvilSteel,         "AnvilSteel");
		machinaAnvilMythril       = new Anvil()            .setBlockName("AnvilMythril");                                     GameRegistry.registerBlock(machinaAnvilMythril,       "AnvilMythril");
		machinaAnvilAdamantium    = new Anvil()            .setBlockName("AnvilAdamantium");                                  GameRegistry.registerBlock(machinaAnvilAdamantium,    "AnvilAdamantium");
		machinaAnvilUnobtanium    = new Anvil()            .setBlockName("AnvilUnobtanium");                                  GameRegistry.registerBlock(machinaAnvilUnobtanium,    "AnvilUnobtanium");
		machinaStove              = new Stove()            .setBlockName("AceStove");                                         GameRegistry.registerBlock(machinaStove,              "AceStove");
		machinaBonfireIdle        = new Bonfire(false)     .setBlockName("BonfireIdle")       .setCreativeTab(acetabMachina); GameRegistry.registerBlock(machinaBonfireIdle,        "BonfireIdle");
		machinaBonfireActive      = new Bonfire(true)      .setBlockName("BonfireActive")     .setLightLevel(1.0F);           GameRegistry.registerBlock(machinaBonfireActive,      "BonfireActive");
		machinaKeg                = new Keg()              .setBlockName("Keg");                                              GameRegistry.registerBlock(machinaKeg,                "Keg");
		machinaDistilleryIdle     = new Distillery(false)  .setBlockName("DistilleryIdle")    .setCreativeTab(acetabMachina); GameRegistry.registerBlock(machinaDistilleryIdle,     "DistilleryIdle");
		machinaDistilleryActive   = new Distillery(true)   .setBlockName("DistilleryActive")  .setLightLevel(0.5F);           GameRegistry.registerBlock(machinaDistilleryActive,   "DistilleryActive");
		machinaAnchor             = new Anchor()           .setBlockName("Anchor");                                           GameRegistry.registerBlock(machinaAnchor,             "Anchor");
		machinaRope               = new Rope()             .setBlockName("Rope");                                             GameRegistry.registerBlock(machinaRope,               "Rope");
		machinaGlobe              = new Globe()            .setBlockName("Globe");                                            GameRegistry.registerBlock(machinaGlobe,              "Globe");
		machinaPodium             = new Podium()           .setBlockName("Podium");                                           GameRegistry.registerBlock(machinaPodium,             "Podium");
		//machinaIngotBasin         = new IngotBasin()       .setBlockName("IngotBasin");                                       GameRegistry.registerBlock(machinaIngotBasin,         "IngotBasin");
		machinaGearBox            = new GearBox()          .setBlockName("GearBox");                                          GameRegistry.registerBlock(machinaGearBox,            "GearBox");
		machinaWindmillWool       = new WindmillWool()     .setBlockName("WindmillWool");                                     GameRegistry.registerBlock(machinaWindmillWool,       "WindmillWool");
		machinaWindmillLeather    = new WindmillLeather()  .setBlockName("WindmillLeather");                                  GameRegistry.registerBlock(machinaWindmillLeather,    "WindmillLeather");
		machinaWaterwheel         = new Waterwheel()       .setBlockName("Waterwheel");                                       GameRegistry.registerBlock(machinaWaterwheel,         "Waterwheel");
		machinaAxle               = new Axle()             .setBlockName("Axle");                                             GameRegistry.registerBlock(machinaAxle,               "Axle");
		machinaFruitPress         = new FruitPress()       .setBlockName("FruitPress");                                       GameRegistry.registerBlock(machinaFruitPress,         "FruitPress");
		machinaMillstone          = new Millstone()        .setBlockName("Millstone");                                        GameRegistry.registerBlock(machinaMillstone,          "Millstone");
		machinaBoilerIdle         = new Boiler(false)      .setBlockName("BoilerIdle")        .setCreativeTab(acetabMachina); GameRegistry.registerBlock(machinaBoilerIdle,         "BoilerIdle");
		machinaBoilerActive       = new Boiler(true)       .setBlockName("BoilerActive")      .setLightLevel(0.825F);         GameRegistry.registerBlock(machinaBoilerActive,       "BoilerActive");
		machinaPipeStraightLead   = new PipeStraight()     .setBlockName("PipeStraightLead");                                 GameRegistry.registerBlock(machinaPipeStraightLead,   "PipeStraightLead");
		machinaPipeCurveLead      = new PipeCurve()        .setBlockName("PipeCurveLead");                                    GameRegistry.registerBlock(machinaPipeCurveLead,      "PipeCurveLead");
		machinaPipeCrossingLead   = new PipeCrossing()     .setBlockName("PipeCrossingLead");                                 GameRegistry.registerBlock(machinaPipeCrossingLead,   "PipeCrossingLead");
		machinaPipeStraightBronze = new PipeStraight()     .setBlockName("PipeStraightBronze");                               GameRegistry.registerBlock(machinaPipeStraightBronze, "PipeStraightBronze");
		machinaPipeCurveBronze    = new PipeCurve()        .setBlockName("PipeCurveBronze");                                  GameRegistry.registerBlock(machinaPipeCurveBronze,    "PipeCurveBronze");
		machinaPipeCrossingBronze = new PipeCrossing()     .setBlockName("PipeCrossingBronze");                               GameRegistry.registerBlock(machinaPipeCrossingBronze, "PipeCrossingBronze");
		machinaSteamVentLead      = new SteamVent()        .setBlockName("SteamVentLead");                                    GameRegistry.registerBlock(machinaSteamVentLead,      "SteamVentLead");
		machinaSteamVentBronze    = new SteamVent()        .setBlockName("SteamVentBronze");                                  GameRegistry.registerBlock(machinaSteamVentBronze,    "SteamVentBronze");
		machinaTurbine            = new Turbine()          .setBlockName("Turbine");                                          GameRegistry.registerBlock(machinaTurbine,            "Turbine");
		machinaGenerator          = new Generator()        .setBlockName("Generator");                                        GameRegistry.registerBlock(machinaGenerator,          "Generator");
		//machinaBellows            = new Bellows()          .setBlockName("Bellows");                                          GameRegistry.registerBlock(machinaBellows,            "Bellows");
		machinaSolarCollector     = new SolarCollector()   .setBlockName("SolarCollector");                                   GameRegistry.registerBlock(machinaSolarCollector,     "SolarCollector");
		machinaCable              = new Cable()            .setBlockName("Cable");                                            GameRegistry.registerBlock(machinaCable,              "Cable");
		machinaEnergyNode         = new EnergyNode()       .setBlockName("EnergyNode");                                       GameRegistry.registerBlock(machinaEnergyNode,         "EnergyNode");
		machinaBattery            = new Battery()          .setBlockName("Battery");                                          GameRegistry.registerBlock(machinaBattery,            "Battery");
		machinaMotor              = new Motor()            .setBlockName("Motor");                                            GameRegistry.registerBlock(machinaMotor,              "Motor");
		
		//Scaffolding
		scaffoldingAcacia     = new Scaffolding(Material.wood).setBlockName("ScaffoldingAcacia");     GameRegistry.registerBlock(scaffoldingAcacia,     "ScaffoldingAcacia");
		scaffoldingBigOak     = new Scaffolding(Material.wood).setBlockName("ScaffoldingBigOak");     GameRegistry.registerBlock(scaffoldingBigOak,     "ScaffoldingBigOak");
		scaffoldingBirch      = new Scaffolding(Material.wood).setBlockName("ScaffoldingBirch");      GameRegistry.registerBlock(scaffoldingBirch,      "ScaffoldingBirch");
		scaffoldingJungle     = new Scaffolding(Material.wood).setBlockName("ScaffoldingJungle");     GameRegistry.registerBlock(scaffoldingJungle,     "ScaffoldingJungle");
		scaffoldingOak        = new Scaffolding(Material.wood).setBlockName("ScaffoldingOak");        GameRegistry.registerBlock(scaffoldingOak,        "ScaffoldingOak");
		scaffoldingSpruce     = new Scaffolding(Material.wood).setBlockName("ScaffoldingSpruce");     GameRegistry.registerBlock(scaffoldingSpruce,     "ScaffoldingSpruce");
		scaffoldingFruit      = new Scaffolding(Material.wood).setBlockName("ScaffoldingFruit");      GameRegistry.registerBlock(scaffoldingFruit,      "ScaffoldingFruit");
		scaffoldingGolden     = new Scaffolding(Material.wood).setBlockName("ScaffoldingGolden");     GameRegistry.registerBlock(scaffoldingGolden,     "ScaffoldingGolden");
		scaffoldingPalm       = new Scaffolding(Material.wood).setBlockName("ScaffoldingPalm");       GameRegistry.registerBlock(scaffoldingPalm,       "ScaffoldingPalm");
		scaffoldingAdamantium = new Scaffolding(Material.iron).setBlockName("ScaffoldingAdamantium"); GameRegistry.registerBlock(scaffoldingAdamantium, "ScaffoldingAdamantium");
		scaffoldingAluminium  = new Scaffolding(Material.iron).setBlockName("ScaffoldingAluminium");  GameRegistry.registerBlock(scaffoldingAluminium,  "ScaffoldingAluminium");
		scaffoldingBronze     = new Scaffolding(Material.iron).setBlockName("ScaffoldingBronze");     GameRegistry.registerBlock(scaffoldingBronze,     "ScaffoldingBronze");
		scaffoldingCopper     = new Scaffolding(Material.iron).setBlockName("ScaffoldingCopper");     GameRegistry.registerBlock(scaffoldingCopper,     "ScaffoldingCopper");
		scaffoldingIron       = new Scaffolding(Material.iron).setBlockName("ScaffoldingIron");       GameRegistry.registerBlock(scaffoldingIron,       "ScaffoldingIron");
		scaffoldingMythril    = new Scaffolding(Material.iron).setBlockName("ScaffoldingMythril");    GameRegistry.registerBlock(scaffoldingMythril,    "ScaffoldingMythril");
		scaffoldingSteel      = new Scaffolding(Material.iron).setBlockName("ScaffoldingSteel");      GameRegistry.registerBlock(scaffoldingSteel,      "ScaffoldingSteel");
		scaffoldingUnobtanium = new Scaffolding(Material.iron).setBlockName("ScaffoldingUnobtanium"); GameRegistry.registerBlock(scaffoldingUnobtanium, "ScaffoldingUnobtanium");
		
		//Roof
		roofAcaciaStraw      = new Roof(Material.wood).setBlockName("RoofAcaciaStraw");      GameRegistry.registerBlock(roofAcaciaStraw,      "RoofAcaciaStraw");
		roofAcaciaReeds      = new Roof(Material.wood).setBlockName("RoofAcaciaReeds");      GameRegistry.registerBlock(roofAcaciaReeds,      "RoofAcaciaReeds");
		roofAcaciaClay       = new Roof(Material.wood).setBlockName("RoofAcaciaClay");       GameRegistry.registerBlock(roofAcaciaClay,       "RoofAcaciaClay");
		roofAcaciaCopper     = new Roof(Material.wood).setBlockName("RoofAcaciaCopper");     GameRegistry.registerBlock(roofAcaciaCopper,     "RoofAcaciaCopper");
		roofAcaciaTin        = new Roof(Material.wood).setBlockName("RoofAcaciaTin");        GameRegistry.registerBlock(roofAcaciaTin,        "RoofAcaciaTin");
		roofAcaciaBrass      = new Roof(Material.wood).setBlockName("RoofAcaciaBrass");      GameRegistry.registerBlock(roofAcaciaBrass,      "RoofAcaciaBrass");
		roofAcaciaGold       = new Roof(Material.wood).setBlockName("RoofAcaciaGold");       GameRegistry.registerBlock(roofAcaciaGold,       "RoofAcaciaGold");
		roofAcaciaMythril    = new Roof(Material.wood).setBlockName("RoofAcaciaMythril");    GameRegistry.registerBlock(roofAcaciaMythril,    "RoofAcaciaMythril");
		roofAcaciaOrichalcum = new Roof(Material.wood).setBlockName("RoofAcaciaOrichalcum"); GameRegistry.registerBlock(roofAcaciaOrichalcum, "RoofAcaciaOrichalcum");
		roofAcaciaNether     = new Roof(Material.wood).setBlockName("RoofAcaciaNether");     GameRegistry.registerBlock(roofAcaciaNether,     "RoofAcaciaNether");
		
		roofBigOakStraw      = new Roof(Material.wood).setBlockName("RoofBigOakStraw");      GameRegistry.registerBlock(roofBigOakStraw,      "RoofBigOakStraw");
		roofBigOakReeds      = new Roof(Material.wood).setBlockName("RoofBigOakReeds");      GameRegistry.registerBlock(roofBigOakReeds,      "RoofBigOakReeds");
		roofBigOakClay       = new Roof(Material.wood).setBlockName("RoofBigOakClay");       GameRegistry.registerBlock(roofBigOakClay,       "RoofBigOakClay");
		roofBigOakCopper     = new Roof(Material.wood).setBlockName("RoofBigOakCopper");     GameRegistry.registerBlock(roofBigOakCopper,     "RoofBigOakCopper");
		roofBigOakTin        = new Roof(Material.wood).setBlockName("RoofBigOakTin");        GameRegistry.registerBlock(roofBigOakTin,        "RoofBigOakTin");
		roofBigOakBrass      = new Roof(Material.wood).setBlockName("RoofBigOakBrass");      GameRegistry.registerBlock(roofBigOakBrass,      "RoofBigOakBrass");
		roofBigOakGold       = new Roof(Material.wood).setBlockName("RoofBigOakGold");       GameRegistry.registerBlock(roofBigOakGold,       "RoofBigOakGold");
		roofBigOakMythril    = new Roof(Material.wood).setBlockName("RoofBigOakMythril");    GameRegistry.registerBlock(roofBigOakMythril,    "RoofBigOakMythril");
		roofBigOakOrichalcum = new Roof(Material.wood).setBlockName("RoofBigOakOrichalcum"); GameRegistry.registerBlock(roofBigOakOrichalcum, "RoofBigOakOrichalcum");
		roofBigOakNether     = new Roof(Material.wood).setBlockName("RoofBigOakNether");     GameRegistry.registerBlock(roofBigOakNether,     "RoofBigOakNether");
		
		roofBirchStraw      = new Roof(Material.wood).setBlockName("RoofBirchStraw");      GameRegistry.registerBlock(roofBirchStraw,      "RoofBirchStraw");
		roofBirchReeds      = new Roof(Material.wood).setBlockName("RoofBirchReeds");      GameRegistry.registerBlock(roofBirchReeds,      "RoofBirchReeds");
		roofBirchClay       = new Roof(Material.wood).setBlockName("RoofBirchClay");       GameRegistry.registerBlock(roofBirchClay,       "RoofBirchClay");
		roofBirchCopper     = new Roof(Material.wood).setBlockName("RoofBirchCopper");     GameRegistry.registerBlock(roofBirchCopper,     "RoofBirchCopper");
		roofBirchTin        = new Roof(Material.wood).setBlockName("RoofBirchTin");        GameRegistry.registerBlock(roofBirchTin,        "RoofBirchTin");
		roofBirchBrass      = new Roof(Material.wood).setBlockName("RoofBirchBrass");      GameRegistry.registerBlock(roofBirchBrass,      "RoofBirchBrass");
		roofBirchGold       = new Roof(Material.wood).setBlockName("RoofBirchGold");       GameRegistry.registerBlock(roofBirchGold,       "RoofBirchGold");
		roofBirchMythril    = new Roof(Material.wood).setBlockName("RoofBirchMythril");    GameRegistry.registerBlock(roofBirchMythril,    "RoofBirchMythril");
		roofBirchOrichalcum = new Roof(Material.wood).setBlockName("RoofBirchOrichalcum"); GameRegistry.registerBlock(roofBirchOrichalcum, "RoofBirchOrichalcum");
		roofBirchNether     = new Roof(Material.wood).setBlockName("RoofBirchNether");     GameRegistry.registerBlock(roofBirchNether,     "RoofBirchNether");
		
		roofJungleStraw      = new Roof(Material.wood).setBlockName("RoofJungleStraw");      GameRegistry.registerBlock(roofJungleStraw,      "RoofJungleStraw");
		roofJungleReeds      = new Roof(Material.wood).setBlockName("RoofJungleReeds");      GameRegistry.registerBlock(roofJungleReeds,      "RoofJungleReeds");
		roofJungleClay       = new Roof(Material.wood).setBlockName("RoofJungleClay");       GameRegistry.registerBlock(roofJungleClay,       "RoofJungleClay");
		roofJungleCopper     = new Roof(Material.wood).setBlockName("RoofJungleCopper");     GameRegistry.registerBlock(roofJungleCopper,     "RoofJungleCopper");
		roofJungleTin        = new Roof(Material.wood).setBlockName("RoofJungleTin");        GameRegistry.registerBlock(roofJungleTin,        "RoofJungleTin");
		roofJungleBrass      = new Roof(Material.wood).setBlockName("RoofJungleBrass");      GameRegistry.registerBlock(roofJungleBrass,      "RoofJungleBrass");
		roofJungleGold       = new Roof(Material.wood).setBlockName("RoofJungleGold");       GameRegistry.registerBlock(roofJungleGold,       "RoofJungleGold");
		roofJungleMythril    = new Roof(Material.wood).setBlockName("RoofJungleMythril");    GameRegistry.registerBlock(roofJungleMythril,    "RoofJungleMythril");
		roofJungleOrichalcum = new Roof(Material.wood).setBlockName("RoofJungleOrichalcum"); GameRegistry.registerBlock(roofJungleOrichalcum, "RoofJungleOrichalcum");
		roofJungleNether     = new Roof(Material.wood).setBlockName("RoofJungleNether");     GameRegistry.registerBlock(roofJungleNether,     "RoofJungleNether");
		
		roofOakStraw      = new Roof(Material.wood).setBlockName("RoofOakStraw");      GameRegistry.registerBlock(roofOakStraw,      "RoofOakStraw");
		roofOakReeds      = new Roof(Material.wood).setBlockName("RoofOakReeds");      GameRegistry.registerBlock(roofOakReeds,      "RoofOakReeds");
		roofOakClay       = new Roof(Material.wood).setBlockName("RoofOakClay");       GameRegistry.registerBlock(roofOakClay,       "RoofOakClay");
		roofOakCopper     = new Roof(Material.wood).setBlockName("RoofOakCopper");     GameRegistry.registerBlock(roofOakCopper,     "RoofOakCopper");
		roofOakTin        = new Roof(Material.wood).setBlockName("RoofOakTin");        GameRegistry.registerBlock(roofOakTin,        "RoofOakTin");
		roofOakBrass      = new Roof(Material.wood).setBlockName("RoofOakBrass");      GameRegistry.registerBlock(roofOakBrass,      "RoofOakBrass");
		roofOakGold       = new Roof(Material.wood).setBlockName("RoofOakGold");       GameRegistry.registerBlock(roofOakGold,       "RoofOakGold");
		roofOakMythril    = new Roof(Material.wood).setBlockName("RoofOakMythril");    GameRegistry.registerBlock(roofOakMythril,    "RoofOakMythril");
		roofOakOrichalcum = new Roof(Material.wood).setBlockName("RoofOakOrichalcum"); GameRegistry.registerBlock(roofOakOrichalcum, "RoofOakOrichalcum");
		roofOakNether     = new Roof(Material.wood).setBlockName("RoofOakNether");     GameRegistry.registerBlock(roofOakNether,     "RoofOakNether");
		
		roofSpruceStraw      = new Roof(Material.wood).setBlockName("RoofSpruceStraw");      GameRegistry.registerBlock(roofSpruceStraw,      "RoofSpruceStraw");
		roofSpruceReeds      = new Roof(Material.wood).setBlockName("RoofSpruceReeds");      GameRegistry.registerBlock(roofSpruceReeds,      "RoofSpruceReeds");
		roofSpruceClay       = new Roof(Material.wood).setBlockName("RoofSpruceClay");       GameRegistry.registerBlock(roofSpruceClay,       "RoofSpruceClay");
		roofSpruceCopper     = new Roof(Material.wood).setBlockName("RoofSpruceCopper");     GameRegistry.registerBlock(roofSpruceCopper,     "RoofSpruceCopper");
		roofSpruceTin        = new Roof(Material.wood).setBlockName("RoofSpruceTin");        GameRegistry.registerBlock(roofSpruceTin,        "RoofSpruceTin");
		roofSpruceBrass      = new Roof(Material.wood).setBlockName("RoofSpruceBrass");      GameRegistry.registerBlock(roofSpruceBrass,      "RoofSpruceBrass");
		roofSpruceGold       = new Roof(Material.wood).setBlockName("RoofSpruceGold");       GameRegistry.registerBlock(roofSpruceGold,       "RoofSpruceGold");
		roofSpruceMythril    = new Roof(Material.wood).setBlockName("RoofSpruceMythril");    GameRegistry.registerBlock(roofSpruceMythril,    "RoofSpruceMythril");
		roofSpruceOrichalcum = new Roof(Material.wood).setBlockName("RoofSpruceOrichalcum"); GameRegistry.registerBlock(roofSpruceOrichalcum, "RoofSpruceOrichalcum");
		roofSpruceNether     = new Roof(Material.wood).setBlockName("RoofSpruceNether");     GameRegistry.registerBlock(roofSpruceNether,     "RoofSpruceNether");
		
		roofFruitStraw      = new Roof(Material.wood).setBlockName("RoofFruitStraw");      GameRegistry.registerBlock(roofFruitStraw,      "RoofFruitStraw");
		roofFruitReeds      = new Roof(Material.wood).setBlockName("RoofFruitReeds");      GameRegistry.registerBlock(roofFruitReeds,      "RoofFruitReeds");
		roofFruitClay       = new Roof(Material.wood).setBlockName("RoofFruitClay");       GameRegistry.registerBlock(roofFruitClay,       "RoofFruitClay");
		roofFruitCopper     = new Roof(Material.wood).setBlockName("RoofFruitCopper");     GameRegistry.registerBlock(roofFruitCopper,     "RoofFruitCopper");
		roofFruitTin        = new Roof(Material.wood).setBlockName("RoofFruitTin");        GameRegistry.registerBlock(roofFruitTin,        "RoofFruitTin");
		roofFruitBrass      = new Roof(Material.wood).setBlockName("RoofFruitBrass");      GameRegistry.registerBlock(roofFruitBrass,      "RoofFruitBrass");
		roofFruitGold       = new Roof(Material.wood).setBlockName("RoofFruitGold");       GameRegistry.registerBlock(roofFruitGold,       "RoofFruitGold");
		roofFruitMythril    = new Roof(Material.wood).setBlockName("RoofFruitMythril");    GameRegistry.registerBlock(roofFruitMythril,    "RoofFruitMythril");
		roofFruitOrichalcum = new Roof(Material.wood).setBlockName("RoofFruitOrichalcum"); GameRegistry.registerBlock(roofFruitOrichalcum, "RoofFruitOrichalcum");
		roofFruitNether     = new Roof(Material.wood).setBlockName("RoofFruitNether");     GameRegistry.registerBlock(roofFruitNether,     "RoofFruitNether");
		
		roofGoldenStraw      = new Roof(Material.wood).setBlockName("RoofGoldenStraw");      GameRegistry.registerBlock(roofGoldenStraw,      "RoofGoldenStraw");
		roofGoldenReeds      = new Roof(Material.wood).setBlockName("RoofGoldenReeds");      GameRegistry.registerBlock(roofGoldenReeds,      "RoofGoldenReeds");
		roofGoldenClay       = new Roof(Material.wood).setBlockName("RoofGoldenClay");       GameRegistry.registerBlock(roofGoldenClay,       "RoofGoldenClay");
		roofGoldenCopper     = new Roof(Material.wood).setBlockName("RoofGoldenCopper");     GameRegistry.registerBlock(roofGoldenCopper,     "RoofGoldenCopper");
		roofGoldenTin        = new Roof(Material.wood).setBlockName("RoofGoldenTin");        GameRegistry.registerBlock(roofGoldenTin,        "RoofGoldenTin");
		roofGoldenBrass      = new Roof(Material.wood).setBlockName("RoofGoldenBrass");      GameRegistry.registerBlock(roofGoldenBrass,      "RoofGoldenBrass");
		roofGoldenGold       = new Roof(Material.wood).setBlockName("RoofGoldenGold");       GameRegistry.registerBlock(roofGoldenGold,       "RoofGoldenGold");
		roofGoldenMythril    = new Roof(Material.wood).setBlockName("RoofGoldenMythril");    GameRegistry.registerBlock(roofGoldenMythril,    "RoofGoldenMythril");
		roofGoldenOrichalcum = new Roof(Material.wood).setBlockName("RoofGoldenOrichalcum"); GameRegistry.registerBlock(roofGoldenOrichalcum, "RoofGoldenOrichalcum");
		roofGoldenNether     = new Roof(Material.wood).setBlockName("RoofGoldenNether");     GameRegistry.registerBlock(roofGoldenNether,     "RoofGoldenNether");
		
		roofPalmStraw      = new Roof(Material.wood).setBlockName("RoofPalmStraw");      GameRegistry.registerBlock(roofPalmStraw,      "RoofPalmStraw");
		roofPalmReeds      = new Roof(Material.wood).setBlockName("RoofPalmReeds");      GameRegistry.registerBlock(roofPalmReeds,      "RoofPalmReeds");
		roofPalmClay       = new Roof(Material.wood).setBlockName("RoofPalmClay");       GameRegistry.registerBlock(roofPalmClay,       "RoofPalmClay");
		roofPalmCopper     = new Roof(Material.wood).setBlockName("RoofPalmCopper");     GameRegistry.registerBlock(roofPalmCopper,     "RoofPalmCopper");
		roofPalmTin        = new Roof(Material.wood).setBlockName("RoofPalmTin");        GameRegistry.registerBlock(roofPalmTin,        "RoofPalmTin");
		roofPalmBrass      = new Roof(Material.wood).setBlockName("RoofPalmBrass");      GameRegistry.registerBlock(roofPalmBrass,      "RoofPalmBrass");
		roofPalmGold       = new Roof(Material.wood).setBlockName("RoofPalmGold");       GameRegistry.registerBlock(roofPalmGold,       "RoofPalmGold");
		roofPalmMythril    = new Roof(Material.wood).setBlockName("RoofPalmMythril");    GameRegistry.registerBlock(roofPalmMythril,    "RoofPalmMythril");
		roofPalmOrichalcum = new Roof(Material.wood).setBlockName("RoofPalmOrichalcum"); GameRegistry.registerBlock(roofPalmOrichalcum, "RoofPalmOrichalcum");
		roofPalmNether     = new Roof(Material.wood).setBlockName("RoofPalmNether");     GameRegistry.registerBlock(roofPalmNether,     "RoofPalmNether");
		
		roofBrickStraw      = new Roof(Material.rock).setBlockName("RoofBrickStraw");      GameRegistry.registerBlock(roofBrickStraw,      "RoofBrickStraw");
		roofBrickReeds      = new Roof(Material.rock).setBlockName("RoofBrickReeds");      GameRegistry.registerBlock(roofBrickReeds,      "RoofBrickReeds");
		roofBrickClay       = new Roof(Material.rock).setBlockName("RoofBrickClay");       GameRegistry.registerBlock(roofBrickClay,       "RoofBrickClay");
		roofBrickCopper     = new Roof(Material.rock).setBlockName("RoofBrickCopper");     GameRegistry.registerBlock(roofBrickCopper,     "RoofBrickCopper");
		roofBrickTin        = new Roof(Material.rock).setBlockName("RoofBrickTin");        GameRegistry.registerBlock(roofBrickTin,        "RoofBrickTin");
		roofBrickBrass      = new Roof(Material.rock).setBlockName("RoofBrickBrass");      GameRegistry.registerBlock(roofBrickBrass,      "RoofBrickBrass");
		roofBrickGold       = new Roof(Material.rock).setBlockName("RoofBrickGold");       GameRegistry.registerBlock(roofBrickGold,       "RoofBrickGold");
		roofBrickMythril    = new Roof(Material.rock).setBlockName("RoofBrickMythril");    GameRegistry.registerBlock(roofBrickMythril,    "RoofBrickMythril");
		roofBrickOrichalcum = new Roof(Material.rock).setBlockName("RoofBrickOrichalcum"); GameRegistry.registerBlock(roofBrickOrichalcum, "RoofBrickOrichalcum");
		roofBrickNether     = new Roof(Material.rock).setBlockName("RoofBrickNether");     GameRegistry.registerBlock(roofBrickNether,     "RoofBrickNether");
		
		roofCobblestoneStraw      = new Roof(Material.rock).setBlockName("RoofCobblestoneStraw");      GameRegistry.registerBlock(roofCobblestoneStraw,      "RoofCobblestoneStraw");
		roofCobblestoneReeds      = new Roof(Material.rock).setBlockName("RoofCobblestoneReeds");      GameRegistry.registerBlock(roofCobblestoneReeds,      "RoofCobblestoneReeds");
		roofCobblestoneClay       = new Roof(Material.rock).setBlockName("RoofCobblestoneClay");       GameRegistry.registerBlock(roofCobblestoneClay,       "RoofCobblestoneClay");
		roofCobblestoneCopper     = new Roof(Material.rock).setBlockName("RoofCobblestoneCopper");     GameRegistry.registerBlock(roofCobblestoneCopper,     "RoofCobblestoneCopper");
		roofCobblestoneTin        = new Roof(Material.rock).setBlockName("RoofCobblestoneTin");        GameRegistry.registerBlock(roofCobblestoneTin,        "RoofCobblestoneTin");
		roofCobblestoneBrass      = new Roof(Material.rock).setBlockName("RoofCobblestoneBrass");      GameRegistry.registerBlock(roofCobblestoneBrass,      "RoofCobblestoneBrass");
		roofCobblestoneGold       = new Roof(Material.rock).setBlockName("RoofCobblestoneGold");       GameRegistry.registerBlock(roofCobblestoneGold,       "RoofCobblestoneGold");
		roofCobblestoneMythril    = new Roof(Material.rock).setBlockName("RoofCobblestoneMythril");    GameRegistry.registerBlock(roofCobblestoneMythril,    "RoofCobblestoneMythril");
		roofCobblestoneOrichalcum = new Roof(Material.rock).setBlockName("RoofCobblestoneOrichalcum"); GameRegistry.registerBlock(roofCobblestoneOrichalcum, "RoofCobblestoneOrichalcum");
		roofCobblestoneNether     = new Roof(Material.rock).setBlockName("RoofCobblestoneNether");     GameRegistry.registerBlock(roofCobblestoneNether,     "RoofCobblestoneNether");
		
		roofCobblestoneMossyStraw      = new Roof(Material.rock).setBlockName("RoofCobblestoneMossyStraw");      GameRegistry.registerBlock(roofCobblestoneMossyStraw,      "RoofCobblestoneMossyStraw");
		roofCobblestoneMossyReeds      = new Roof(Material.rock).setBlockName("RoofCobblestoneMossyReeds");      GameRegistry.registerBlock(roofCobblestoneMossyReeds,      "RoofCobblestoneMossyReeds");
		roofCobblestoneMossyClay       = new Roof(Material.rock).setBlockName("RoofCobblestoneMossyClay");       GameRegistry.registerBlock(roofCobblestoneMossyClay,       "RoofCobblestoneMossyClay");
		roofCobblestoneMossyCopper     = new Roof(Material.rock).setBlockName("RoofCobblestoneMossyCopper");     GameRegistry.registerBlock(roofCobblestoneMossyCopper,     "RoofCobblestoneMossyCopper");
		roofCobblestoneMossyTin        = new Roof(Material.rock).setBlockName("RoofCobblestoneMossyTin");        GameRegistry.registerBlock(roofCobblestoneMossyTin,        "RoofCobblestoneMossyTin");
		roofCobblestoneMossyBrass      = new Roof(Material.rock).setBlockName("RoofCobblestoneMossyBrass");      GameRegistry.registerBlock(roofCobblestoneMossyBrass,      "RoofCobblestoneMossyBrass");
		roofCobblestoneMossyGold       = new Roof(Material.rock).setBlockName("RoofCobblestoneMossyGold");       GameRegistry.registerBlock(roofCobblestoneMossyGold,       "RoofCobblestoneMossyGold");
		roofCobblestoneMossyMythril    = new Roof(Material.rock).setBlockName("RoofCobblestoneMossyMythril");    GameRegistry.registerBlock(roofCobblestoneMossyMythril,    "RoofCobblestoneMossyMythril");
		roofCobblestoneMossyOrichalcum = new Roof(Material.rock).setBlockName("RoofCobblestoneMossyOrichalcum"); GameRegistry.registerBlock(roofCobblestoneMossyOrichalcum, "RoofCobblestoneMossyOrichalcum");
		roofCobblestoneMossyNether     = new Roof(Material.rock).setBlockName("RoofCobblestoneMossyNether");     GameRegistry.registerBlock(roofCobblestoneMossyNether,     "RoofCobblestoneMossyNether");
		
		roofStonebrickStraw      = new Roof(Material.rock).setBlockName("RoofStonebrickStraw");      GameRegistry.registerBlock(roofStonebrickStraw,      "RoofStonebrickStraw");
		roofStonebrickReeds      = new Roof(Material.rock).setBlockName("RoofStonebrickReeds");      GameRegistry.registerBlock(roofStonebrickReeds,      "RoofStonebrickReeds");
		roofStonebrickClay       = new Roof(Material.rock).setBlockName("RoofStonebrickClay");       GameRegistry.registerBlock(roofStonebrickClay,       "RoofStonebrickClay");
		roofStonebrickCopper     = new Roof(Material.rock).setBlockName("RoofStonebrickCopper");     GameRegistry.registerBlock(roofStonebrickCopper,     "RoofStonebrickCopper");
		roofStonebrickTin        = new Roof(Material.rock).setBlockName("RoofStonebrickTin");        GameRegistry.registerBlock(roofStonebrickTin,        "RoofStonebrickTin");
		roofStonebrickBrass      = new Roof(Material.rock).setBlockName("RoofStonebrickBrass");      GameRegistry.registerBlock(roofStonebrickBrass,      "RoofStonebrickBrass");
		roofStonebrickGold       = new Roof(Material.rock).setBlockName("RoofStonebrickGold");       GameRegistry.registerBlock(roofStonebrickGold,       "RoofStonebrickGold");
		roofStonebrickMythril    = new Roof(Material.rock).setBlockName("RoofStonebrickMythril");    GameRegistry.registerBlock(roofStonebrickMythril,    "RoofStonebrickMythril");
		roofStonebrickOrichalcum = new Roof(Material.rock).setBlockName("RoofStonebrickOrichalcum"); GameRegistry.registerBlock(roofStonebrickOrichalcum, "RoofStonebrickOrichalcum");
		roofStonebrickNether     = new Roof(Material.rock).setBlockName("RoofStonebrickNether");     GameRegistry.registerBlock(roofStonebrickNether,     "RoofStonebrickNether");
		
		roofStonebrickMossyStraw      = new Roof(Material.rock).setBlockName("RoofStonebrickMossyStraw");      GameRegistry.registerBlock(roofStonebrickMossyStraw,      "RoofStonebrickMossyStraw");
		roofStonebrickMossyReeds      = new Roof(Material.rock).setBlockName("RoofStonebrickMossyReeds");      GameRegistry.registerBlock(roofStonebrickMossyReeds,      "RoofStonebrickMossyReeds");
		roofStonebrickMossyClay       = new Roof(Material.rock).setBlockName("RoofStonebrickMossyClay");       GameRegistry.registerBlock(roofStonebrickMossyClay,       "RoofStonebrickMossyClay");
		roofStonebrickMossyCopper     = new Roof(Material.rock).setBlockName("RoofStonebrickMossyCopper");     GameRegistry.registerBlock(roofStonebrickMossyCopper,     "RoofStonebrickMossyCopper");
		roofStonebrickMossyTin        = new Roof(Material.rock).setBlockName("RoofStonebrickMossyTin");        GameRegistry.registerBlock(roofStonebrickMossyTin,        "RoofStonebrickMossyTin");
		roofStonebrickMossyBrass      = new Roof(Material.rock).setBlockName("RoofStonebrickMossyBrass");      GameRegistry.registerBlock(roofStonebrickMossyBrass,      "RoofStonebrickMossyBrass");
		roofStonebrickMossyGold       = new Roof(Material.rock).setBlockName("RoofStonebrickMossyGold");       GameRegistry.registerBlock(roofStonebrickMossyGold,       "RoofStonebrickMossyGold");
		roofStonebrickMossyMythril    = new Roof(Material.rock).setBlockName("RoofStonebrickMossyMythril");    GameRegistry.registerBlock(roofStonebrickMossyMythril,    "RoofStonebrickMossyMythril");
		roofStonebrickMossyOrichalcum = new Roof(Material.rock).setBlockName("RoofStonebrickMossyOrichalcum"); GameRegistry.registerBlock(roofStonebrickMossyOrichalcum, "RoofStonebrickMossyOrichalcum");
		roofStonebrickMossyNether     = new Roof(Material.rock).setBlockName("RoofStonebrickMossyNether");     GameRegistry.registerBlock(roofStonebrickMossyNether,     "RoofStonebrickMossyNether");
		
		roofSandstoneStraw      = new Roof(Material.rock).setBlockName("RoofSandstoneStraw");      GameRegistry.registerBlock(roofSandstoneStraw,      "RoofSandstoneStraw");
		roofSandstoneReeds      = new Roof(Material.rock).setBlockName("RoofSandstoneReeds");      GameRegistry.registerBlock(roofSandstoneReeds,      "RoofSandstoneReeds");
		roofSandstoneClay       = new Roof(Material.rock).setBlockName("RoofSandstoneClay");       GameRegistry.registerBlock(roofSandstoneClay,       "RoofSandstoneClay");
		roofSandstoneCopper     = new Roof(Material.rock).setBlockName("RoofSandstoneCopper");     GameRegistry.registerBlock(roofSandstoneCopper,     "RoofSandstoneCopper");
		roofSandstoneTin        = new Roof(Material.rock).setBlockName("RoofSandstoneTin");        GameRegistry.registerBlock(roofSandstoneTin,        "RoofSandstoneTin");
		roofSandstoneBrass      = new Roof(Material.rock).setBlockName("RoofSandstoneBrass");      GameRegistry.registerBlock(roofSandstoneBrass,      "RoofSandstoneBrass");
		roofSandstoneGold       = new Roof(Material.rock).setBlockName("RoofSandstoneGold");       GameRegistry.registerBlock(roofSandstoneGold,       "RoofSandstoneGold");
		roofSandstoneMythril    = new Roof(Material.rock).setBlockName("RoofSandstoneMythril");    GameRegistry.registerBlock(roofSandstoneMythril,    "RoofSandstoneMythril");
		roofSandstoneOrichalcum = new Roof(Material.rock).setBlockName("RoofSandstoneOrichalcum"); GameRegistry.registerBlock(roofSandstoneOrichalcum, "RoofSandstoneOrichalcum");
		roofSandstoneNether     = new Roof(Material.rock).setBlockName("RoofSandstoneNether");     GameRegistry.registerBlock(roofSandstoneNether,     "RoofSandstoneNether");
		
		roofNetherStraw      = new Roof(Material.rock).setBlockName("RoofNetherStraw");      GameRegistry.registerBlock(roofNetherStraw,      "RoofNetherStraw");
		roofNetherReeds      = new Roof(Material.rock).setBlockName("RoofNetherReeds");      GameRegistry.registerBlock(roofNetherReeds,      "RoofNetherReeds");
		roofNetherClay       = new Roof(Material.rock).setBlockName("RoofNetherClay");       GameRegistry.registerBlock(roofNetherClay,       "RoofNetherClay");
		roofNetherCopper     = new Roof(Material.rock).setBlockName("RoofNetherCopper");     GameRegistry.registerBlock(roofNetherCopper,     "RoofNetherCopper");
		roofNetherTin        = new Roof(Material.rock).setBlockName("RoofNetherTin");        GameRegistry.registerBlock(roofNetherTin,        "RoofNetherTin");
		roofNetherBrass      = new Roof(Material.rock).setBlockName("RoofNetherBrass");      GameRegistry.registerBlock(roofNetherBrass,      "RoofNetherBrass");
		roofNetherGold       = new Roof(Material.rock).setBlockName("RoofNetherGold");       GameRegistry.registerBlock(roofNetherGold,       "RoofNetherGold");
		roofNetherMythril    = new Roof(Material.rock).setBlockName("RoofNetherMythril");    GameRegistry.registerBlock(roofNetherMythril,    "RoofNetherMythril");
		roofNetherOrichalcum = new Roof(Material.rock).setBlockName("RoofNetherOrichalcum"); GameRegistry.registerBlock(roofNetherOrichalcum, "RoofNetherOrichalcum");
		roofNetherNether     = new Roof(Material.rock).setBlockName("RoofNetherNether");     GameRegistry.registerBlock(roofNetherNether,     "RoofNetherNether");
		
		roofQuartzStraw      = new Roof(Material.rock).setBlockName("RoofQuartzStraw");      GameRegistry.registerBlock(roofQuartzStraw,      "RoofQuartzStraw");
		roofQuartzReeds      = new Roof(Material.rock).setBlockName("RoofQuartzReeds");      GameRegistry.registerBlock(roofQuartzReeds,      "RoofQuartzReeds");
		roofQuartzClay       = new Roof(Material.rock).setBlockName("RoofQuartzClay");       GameRegistry.registerBlock(roofQuartzClay,       "RoofQuartzClay");
		roofQuartzCopper     = new Roof(Material.rock).setBlockName("RoofQuartzCopper");     GameRegistry.registerBlock(roofQuartzCopper,     "RoofQuartzCopper");
		roofQuartzTin        = new Roof(Material.rock).setBlockName("RoofQuartzTin");        GameRegistry.registerBlock(roofQuartzTin,        "RoofQuartzTin");
		roofQuartzBrass      = new Roof(Material.rock).setBlockName("RoofQuartzBrass");      GameRegistry.registerBlock(roofQuartzBrass,      "RoofQuartzBrass");
		roofQuartzGold       = new Roof(Material.rock).setBlockName("RoofQuartzGold");       GameRegistry.registerBlock(roofQuartzGold,       "RoofQuartzGold");
		roofQuartzMythril    = new Roof(Material.rock).setBlockName("RoofQuartzMythril");    GameRegistry.registerBlock(roofQuartzMythril,    "RoofQuartzMythril");
		roofQuartzOrichalcum = new Roof(Material.rock).setBlockName("RoofQuartzOrichalcum"); GameRegistry.registerBlock(roofQuartzOrichalcum, "RoofQuartzOrichalcum");
		roofQuartzNether     = new Roof(Material.rock).setBlockName("RoofQuartzNether");     GameRegistry.registerBlock(roofQuartzNether,     "RoofQuartzNether");
		
	}
	
	public void Init(){
		
		achievementShovelKnight      = new Achievement("achievement.shovelKnight", "shovelKnight", 0, 0, new ItemStack(Items.diamond_shovel), (Achievement)null).initIndependentStat().registerStat();
		achievementRainbowCollection = new Achievement("achievement.rainbowCol", "rainbowCol", 0, 2, new ItemStack(Blocks.wool), achievementShovelKnight).initIndependentStat().setSpecial().registerStat();
		
		AchievementPage.registerAchievementPage(new AchievementPage("Ace Achievements", new Achievement[]{achievementShovelKnight, achievementRainbowCollection}));
		
		//Register Tile Entities
		GameRegistry.registerTileEntity(TileEntityBlastFurnace   .class, "BlastFurnace");
		GameRegistry.registerTileEntity(TileEntityWorkbench      .class, "AceWorkbench");
		GameRegistry.registerTileEntity(TileEntitySewingStation  .class, "SewingStation");
		GameRegistry.registerTileEntity(TileEntityAnvil          .class, "AceAnvil");
		GameRegistry.registerTileEntity(TileEntityStove          .class, "AceStove");
		GameRegistry.registerTileEntity(TileEntityBonfire        .class, "Bonfire");
		GameRegistry.registerTileEntity(TileEntityKeg            .class, "Keg");
		GameRegistry.registerTileEntity(TileEntityDistillery     .class, "Distillery");
		GameRegistry.registerTileEntity(TileEntityAnchor         .class, "Anchor");
		GameRegistry.registerTileEntity(TileEntityRope           .class, "Rope");
		GameRegistry.registerTileEntity(TileEntityGlobe          .class, "Globe");
		GameRegistry.registerTileEntity(TileEntityPodium         .class, "Podium");
		GameRegistry.registerTileEntity(TileEntityIngotBasin     .class, "IngotBasin");
		GameRegistry.registerTileEntity(TileEntityGearBox        .class, "GaerBox");
		GameRegistry.registerTileEntity(TileEntityWindmillWool   .class, "WindmillWool");
		GameRegistry.registerTileEntity(TileEntityWindmillLeather.class, "WindmillLeather");
		GameRegistry.registerTileEntity(TileEntityWaterwheel     .class, "Waterwheel");
		GameRegistry.registerTileEntity(TileEntityAxle           .class, "Axle");
		GameRegistry.registerTileEntity(TileEntityFruitPress     .class, "FruitPress");
		GameRegistry.registerTileEntity(TileEntityMillstone      .class, "Millstone");
		GameRegistry.registerTileEntity(TileEntityBoiler         .class, "Boiler");
		GameRegistry.registerTileEntity(TileEntityPipeStraight   .class, "PipeStraight");
		GameRegistry.registerTileEntity(TileEntityPipeCurve      .class, "PipeCurve");
		GameRegistry.registerTileEntity(TileEntityPipeCrossing   .class, "PipeCrossing");
		GameRegistry.registerTileEntity(TileEntitySteamVent      .class, "SteamVent");
		GameRegistry.registerTileEntity(TileEntityTurbine        .class, "Turbine");
		GameRegistry.registerTileEntity(TileEntityGenerator      .class, "Generator");
		GameRegistry.registerTileEntity(TileEntityBellows        .class, "Bellows");
		GameRegistry.registerTileEntity(TileEntitySolarCollector .class, "SolarCollector");
		GameRegistry.registerTileEntity(TileEntityCable          .class, "Cable");
		GameRegistry.registerTileEntity(TileEntityEnergyNode     .class, "EnergyNode");
		GameRegistry.registerTileEntity(TileEntityBattery        .class, "Battery");
		GameRegistry.registerTileEntity(TileEntityMotor          .class, "Motor");
		GameRegistry.registerTileEntity(TileEntityScaffolding    .class, "Scaffolding");
		GameRegistry.registerTileEntity(TileEntityRoof           .class, "Roof");
		
		//Register Living Entities
		EntityHandler.registerThrowingEntity(EntityNugget  .class, "Nugget");
		EntityHandler.registerThrowingEntity(EntitySpear   .class, "Spear");
		EntityHandler.registerThrowingEntity(EntityDynamite.class, "Dynamite");
		EntityHandler.registerMonsters(EntityMammoth     .class, "Mammoth");
		EntityHandler.registerMonsters(EntityLlama       .class, "Llama");
		EntityHandler.registerMonsters(EntityDeer        .class, "Deer");
		EntityHandler.registerMonsters(EntityGoat        .class, "Goat");
		EntityHandler.registerMonsters(EntityCrab        .class, "Crab");
		EntityHandler.registerMonsters(EntityCarrotRed   .class, "CarrotRed");
		EntityHandler.registerMonsters(EntityCarrotWhite .class, "CarrotWhite");
		EntityHandler.registerMonsters(EntityElephant    .class, "Elephant");
		
		//EntityRegistry.addSpawn(mods.fossil.entity.mob.EntityTRex.class, 10, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.jungle);
		//EntityRegistry.addSpawn(mods.fossil.entity.mob.EntityAllosaurus.class, 10, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.jungle);
		//EntityRegistry.addSpawn(mods.fossil.entity.mob.EntityAnkylosaurus.class, 10, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.jungle);
		//EntityRegistry.addSpawn(mods.fossil.entity.mob.EntityBrachiosaurus.class, 10, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.jungle);
		//EntityRegistry.addSpawn(mods.fossil.entity.mob.EntityCeratosaurus.class, 10, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.jungle);
		//EntityRegistry.addSpawn(mods.fossil.entity.mob.EntityCoelacanth.class, 10, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.jungle);
		//EntityRegistry.addSpawn(mods.fossil.entity.mob.EntityCompsognathus.class, 10, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.jungle);
		//EntityRegistry.addSpawn(mods.fossil.entity.mob.EntityConfuciusornis.class, 10, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.jungle);
		//EntityRegistry.addSpawn(mods.fossil.entity.mob.EntityDeinonychus.class, 10, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.jungle);
		//EntityRegistry.addSpawn(mods.fossil.entity.mob.EntityDilophosaurus.class, 10, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.jungle);
		//EntityRegistry.addSpawn(mods.fossil.entity.mob.EntityDodo.class, 10, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.jungle);
		//EntityRegistry.addSpawn(mods.fossil.entity.mob.EntityElasmotherium.class, 10, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.jungle);
		//EntityRegistry.addSpawn(mods.fossil.entity.mob.EntityGallimimus.class, 10, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.jungle);
		//EntityRegistry.addSpawn(mods.fossil.entity.mob.EntityLiopleurodon.class, 10, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.jungle);
		//EntityRegistry.addSpawn(mods.fossil.entity.mob.EntityMammoth.class, 10, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.jungle);
		//EntityRegistry.addSpawn(mods.fossil.entity.mob.EntityMosasaurus.class, 10, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.jungle);
		//EntityRegistry.addSpawn(mods.fossil.entity.mob.EntityPachycephalosaurus.class, 10, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.jungle);
		//EntityRegistry.addSpawn(mods.fossil.entity.mob.EntityPlesiosaur.class, 10, 1, 1, EnumCreatureType.waterCreature, BiomeGenBase.ocean, BiomeGenBase.deepOcean, BiomeGenBase.frozenOcean);
		//EntityRegistry.addSpawn(mods.fossil.entity.mob.EntityPterosaur.class, 10, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.jungle);
		//EntityRegistry.addSpawn(mods.fossil.entity.mob.EntityQuagga.class, 10, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.jungle);
		//EntityRegistry.addSpawn(mods.fossil.entity.mob.EntitySarcosuchus.class, 10, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.jungle);
		//EntityRegistry.addSpawn(mods.fossil.entity.mob.EntitySmilodon.class, 10, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.jungle);
		//EntityRegistry.addSpawn(mods.fossil.entity.mob.EntitySpinosaurus.class, 10, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.jungle);
		//EntityRegistry.addSpawn(mods.fossil.entity.mob.EntityStegosaurus.class, 10, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.jungle);
		//EntityRegistry.addSpawn(mods.fossil.entity.mob.EntityTerrorBird.class, 10, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.jungle);
		//EntityRegistry.addSpawn(mods.fossil.entity.mob.EntityTriceratops.class, 10, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.jungle);
		//EntityRegistry.addSpawn(mods.fossil.entity.mob.EntityVelociraptor.class, 10, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.jungle);
		
		//Spawn Seeds
		MinecraftForge.addGrassSeed(new ItemStack(seedsWild), 1000000);
		
		//ForgeHook
		MinecraftForge.EVENT_BUS.register(new ForgeHook());
		
		ChestGenHooks.addItem(ChestGenHooks.BONUS_CHEST, new WeightedRandomChestContent(new ItemStack(toolSwordFlint),   1, 1,  60));
		ChestGenHooks.addItem(ChestGenHooks.BONUS_CHEST, new WeightedRandomChestContent(new ItemStack(toolAxeFlint),     1, 1,  40));
		ChestGenHooks.addItem(ChestGenHooks.BONUS_CHEST, new WeightedRandomChestContent(new ItemStack(toolHoeFlint),     1, 1,  30));
		ChestGenHooks.addItem(ChestGenHooks.BONUS_CHEST, new WeightedRandomChestContent(new ItemStack(toolShovelFlint),  1, 1,  40));
		ChestGenHooks.addItem(ChestGenHooks.BONUS_CHEST, new WeightedRandomChestContent(new ItemStack(toolPickaxeFlint), 1, 1,  40));
		ChestGenHooks.addItem(ChestGenHooks.BONUS_CHEST, new WeightedRandomChestContent(new ItemStack(toolSpearFlint),   1, 1,  50));
		ChestGenHooks.addItem(ChestGenHooks.BONUS_CHEST, new WeightedRandomChestContent(new ItemStack(liquorRum),        1, 1, 100));
		
		ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(ingotCopper),      1, 5, 80));
		ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(ingotAluminium),   1, 3, 70));
		ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(ingotTin),         1, 2, 60));
		ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(ingotLead),        1, 3, 50));
		ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(nuggetZinc),       1, 3, 40));
		ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(nuggetOrichalcum), 1, 1, 10));
		
		ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(nuggetCopper),      1, 5,  70));
		ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(nuggetBauxite),     1, 5,  70));
		ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(nuggetLead),        1, 5,  70));
		ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(nuggetTin),         1, 3,  40));
		ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(nuggetZinc),        1, 2,  40));
		ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(nuggetSilver),      1, 3,  30));
		ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(nuggetIron),        1, 5,  70));
		ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(nuggetGold),        1, 2,  20));
		ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(nuggetOrichalcum),  1, 1,   5));
		ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(gemstoneRuby),      1, 2,  10));
		ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(gemstonePeridot),   1, 2,  10));
		ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(gemstoneTopaz),     1, 2,  10));
		ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(gemstoneSaphire),   1, 2,  10));
		ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(gemstoneAzurit),    1, 2,  10));
		ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(gemstoneAmber),     1, 2,  10));
		ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(gemstoneAmethyst),  1, 2,  10));
		ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(gemstoneGagat),     1, 2,  10));
		ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(gemstoneOpal),      1, 1,  10));
		ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(gemstoneJade),      1, 2,  10));
		ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(gemstoneTurquoise), 1, 2,  10));
		ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(stuffRope),         1, 5,  90));
		ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(stuffGear),         1, 3,  75));
		ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(new ItemStack(foodRiceball),      1, 3, 100));
		
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(ingotCopper),       1, 5, 70));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(ingotAluminium),    1, 5, 70));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(ingotLead),         1, 5, 70));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(ingotTin),          1, 3, 40));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(ingotZinc),         1, 2, 40));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(ingotSilver),       1, 3, 30));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(nuggetOrichalcum),  1, 1,  5));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(gemstoneRuby),      1, 2, 10));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(gemstonePeridot),   1, 2, 10));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(gemstoneTopaz),     1, 2, 10));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(gemstoneSaphire),   1, 2, 10));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(gemstoneAzurit),    1, 2, 10));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(gemstoneAmber),     1, 2, 10));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(gemstoneAmethyst),  1, 2, 10));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(gemstoneGagat),     1, 2, 10));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(gemstoneOpal),      1, 1, 10));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(gemstoneJade),      1, 2, 10));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(new ItemStack(gemstoneTurquoise), 1, 2, 10));
		
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(ingotCopper),       1, 5, 70));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(ingotAluminium),    1, 5, 70));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(ingotLead),         1, 5, 70));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(ingotTin),          1, 3, 40));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(ingotZinc),         1, 2, 40));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(ingotSilver),       1, 3, 30));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(nuggetOrichalcum),  1, 1,  5));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(gemstoneRuby),      1, 2, 10));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(gemstonePeridot),   1, 2, 10));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(gemstoneTopaz),     1, 2, 10));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(gemstoneSaphire),   1, 2, 10));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(gemstoneAzurit),    1, 2, 10));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(gemstoneAmber),     1, 2, 10));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(gemstoneAmethyst),  1, 2, 10));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(gemstoneGagat),     1, 2, 10));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(gemstoneOpal),      1, 1, 10));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(gemstoneJade),      1, 2, 10));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(new ItemStack(gemstoneTurquoise), 1, 2, 10));
		
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(new ItemStack(toolSwordFlint),           1, 1, 30));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(new ItemStack(toolShovelFlint),          1, 1, 30));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(new ItemStack(toolPickaxeFlint),         1, 1, 30));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(new ItemStack(toolPickaxeCopper),        1, 1, 30));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(new ItemStack(toolSpearFlint),           1, 1, 30));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(new ItemStack(armorHelmetCopper),        1, 1, 20));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(new ItemStack(armorHelmetAluminium),     1, 1, 20));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(new ItemStack(armorChestplateCopper),    1, 1, 20));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(new ItemStack(armorChestplateAluminium), 1, 1, 20));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(new ItemStack(armorLegginsCopper),       1, 1, 20));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(new ItemStack(armorLegginsAluminium),    1, 1, 20));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(new ItemStack(armorBootsCopper),         1, 1, 20));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(new ItemStack(armorBootsAluminium),      1, 1, 20));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(new ItemStack(toolSwordCopper),          1, 1, 20));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(new ItemStack(toolSpearCopper),          1, 1, 20));
		
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(ingotCopper),           1, 5, 70));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(ingotAluminium),        1, 5, 70));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(ingotLead),             1, 5, 70));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(ingotTin),              1, 3, 40));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(ingotZinc),             1, 2, 40));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(ingotSilver),           1, 3, 30));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(nuggetOrichalcum),      1, 1,  5));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(gemstoneRuby),          1, 2, 10));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(gemstonePeridot),       1, 2, 10));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(gemstoneTopaz),         1, 2, 10));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(gemstoneSaphire),       1, 2, 10));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(gemstoneAzurit),        1, 2, 10));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(gemstoneAmber),         1, 2, 10));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(gemstoneAmethyst),      1, 2, 10));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(gemstoneGagat),         1, 2, 10));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(gemstoneOpal),          1, 1, 10));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(gemstoneJade),          1, 2, 10));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(gemstoneTurquoise),     1, 2, 10));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(toolSwordFlint),        1, 1, 60));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(toolAxeFlint),          1, 1, 40));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(toolHoeFlint),          1, 1, 30));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(toolShovelFlint),       1, 1, 40));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(toolPickaxeFlint),      1, 1, 40));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(toolSpearFlint),        1, 1, 50));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(armorHelmetCopper),     1, 1, 50));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(armorHelmetLead),       1, 1, 40));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(armorChestplateCopper), 1, 1, 50));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(armorChestplateLead),   1, 1, 40));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(armorLegginsCopper),    1, 1, 50));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(armorLegginsLead),      1, 1, 40));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(armorBootsCopper),      1, 1, 50));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(armorBootsLead),        1, 1, 40));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(toolSwordCopper),       1, 1, 50));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(toolSwordLead),         1, 1, 40));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(toolSpearCopper),       1, 1, 50));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(new ItemStack(toolSpearLead),         1, 1, 40));
		
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_LIBRARY, new WeightedRandomChestContent(new ItemStack(machinaGlobe), 1, 1, 25));
		
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(ingotCopper),           1, 5, 100));
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(ingotLead),             2, 4, 100));
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(nuggetTin),             1, 1,  60));
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(armorHelmetCopper),     1, 1,  50));
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(armorHelmetLead),       1, 1,  40));
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(armorChestplateCopper), 1, 1,  50));
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(armorChestplateLead),   1, 1,  40));
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(armorLegginsCopper),    1, 1,  50));
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(armorLegginsLead),      1, 1,  40));
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(armorBootsCopper),      1, 1,  50));
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(armorBootsLead),        1, 1,  40));
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(toolSwordCopper),       1, 1,  50));
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(toolSwordLead),         1, 1,  40));
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(toolSpearCopper),       1, 1,  50));
		ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(toolSpearLead),         1, 1,  40));
		
		//Recipe Remover
		RecipeRemover.removeCraftingRecipe();
		RecipeRemover.removeFurnaceRecipe();
		
		//Changed Vanilla Recipes
		GameRegistry.addShapelessRecipe(new ItemStack(Items.map, 1), new ItemStack(Items.paper), new ItemStack(Items.feather), new ItemStack(Items.dye,1,0), new ItemStack(Items.dye,1,1), new ItemStack(Items.dye,1,11));
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.bucket),    new ItemStack(bucketIronEmpty));
		GameRegistry.addShapelessRecipe(new ItemStack(bucketIronEmpty), new ItemStack(Items.bucket));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.gunpowder), new ItemStack(Items.coal), new ItemStack(powderSalt), new ItemStack(powderSulfur));
		
		GameRegistry.addRecipe(new ItemStack(Items.lead                     ), new Object[]{ "X" , "X"  ,        'X', stuffRope                                                              });
		GameRegistry.addRecipe(new ItemStack(Blocks.enchanting_table        ), new Object[]{" B ", "GOG", "OOO", 'B', Items.book,                 'G', Items.emerald,    'O', Blocks.obsidian});
		GameRegistry.addRecipe(new ItemStack(Blocks.enchanting_table        ), new Object[]{" B ", "GOG", "OOO", 'B', Items.book,                 'G', gemstoneRuby,     'O', Blocks.obsidian});
		GameRegistry.addRecipe(new ItemStack(Blocks.enchanting_table        ), new Object[]{" B ", "GOG", "OOO", 'B', Items.book,                 'G', gemstonePeridot,  'O', Blocks.obsidian});
		GameRegistry.addRecipe(new ItemStack(Blocks.enchanting_table        ), new Object[]{" B ", "GOG", "OOO", 'B', Items.book,                 'G', gemstoneTopaz,    'O', Blocks.obsidian});
		GameRegistry.addRecipe(new ItemStack(Blocks.enchanting_table        ), new Object[]{" B ", "GOG", "OOO", 'B', Items.book,                 'G', gemstoneSaphire,  'O', Blocks.obsidian});
		GameRegistry.addRecipe(new ItemStack(Blocks.enchanting_table        ), new Object[]{" B ", "GOG", "OOO", 'B', Items.book,                 'G', gemstoneAzurit,   'O', Blocks.obsidian});
		GameRegistry.addRecipe(new ItemStack(Blocks.enchanting_table        ), new Object[]{" B ", "GOG", "OOO", 'B', Items.book,                 'G', gemstoneAmber,    'O', Blocks.obsidian});
		GameRegistry.addRecipe(new ItemStack(Blocks.enchanting_table        ), new Object[]{" B ", "GOG", "OOO", 'B', Items.book,                 'G', gemstoneAmethyst, 'O', Blocks.obsidian});
		GameRegistry.addRecipe(new ItemStack(Blocks.enchanting_table        ), new Object[]{" B ", "GOG", "OOO", 'B', Items.book,                 'G', gemstoneGagat,    'O', Blocks.obsidian});
		GameRegistry.addRecipe(new ItemStack(Blocks.enchanting_table        ), new Object[]{" B ", "GOG", "OOO", 'B', Items.book,                 'G', gemstoneOpal,     'O', Blocks.obsidian});
		GameRegistry.addRecipe(new ItemStack(Blocks.jukebox                 ), new Object[]{"###", "#X#", "###", '#', acePlanks,                  'X', Items.diamond                         });
		GameRegistry.addRecipe(new ItemStack(Blocks.noteblock               ), new Object[]{"###", "#X#", "###", '#', acePlanks,                  'X', Items.redstone                        });
		GameRegistry.addRecipe(new ItemStack(Blocks.bookshelf               ), new Object[]{"###", "XXX", "###", '#', acePlanks,                  'X', Items.book                            });
		GameRegistry.addRecipe(new ItemStack(Items.wooden_door              ), new Object[]{"##" , "##" , "##" , '#', acePlanks                                                              });
		GameRegistry.addRecipe(new ItemStack(Blocks.trapdoor,              2), new Object[]{"###", "###",        '#', acePlanks                                                              });
		GameRegistry.addRecipe(new ItemStack(Items.sign,                   3), new Object[]{"###", "###", " X ", '#', acePlanks,                  'X', Items.stick                           });
		GameRegistry.addRecipe(new ItemStack(acePlanks,                 4, 0), new Object[]{ "#" ,               '#', new ItemStack(aceLog, 1, 0)                                            });
		GameRegistry.addRecipe(new ItemStack(acePlanks,                 4, 1), new Object[]{ "#" ,               '#', new ItemStack(aceLog, 1, 1)                                            });
		GameRegistry.addRecipe(new ItemStack(acePlanks,                 4, 2), new Object[]{ "#" ,               '#', new ItemStack(aceLog, 1, 2)                                            });
		GameRegistry.addRecipe(new ItemStack(Items.stick,                  4), new Object[]{ "#" ,  "#" ,        '#', acePlanks                                                              });
		GameRegistry.addRecipe(new ItemStack(Items.bowl,                   4), new Object[]{"# #", " # ",        '#', acePlanks                                                              });
		GameRegistry.addRecipe(new ItemStack(Items.boat                     ), new Object[]{"# #", "###",        '#', acePlanks                                                              });
		GameRegistry.addRecipe(new ItemStack(Blocks.wooden_button           ), new Object[]{ "#" ,               '#', acePlanks                                                              });
		GameRegistry.addRecipe(new ItemStack(Blocks.wooden_pressure_plate   ), new Object[]{"##" ,               '#', acePlanks                                                              });
		GameRegistry.addRecipe(new ItemStack(bucketWoodEmpty                ), new Object[]{"X X", "X X", " X ", 'X', Blocks.planks                                                          });
		GameRegistry.addRecipe(new ItemStack(bucketWoodEmpty                ), new Object[]{"X X", "X X", " X ", 'X', acePlanks                                                              });
        
		
		//Custom Simple Recipes
		GameRegistry.addRecipe(new ItemStack(Items.bucket     ), new Object[]{"X" , 'X', bucketIronEmpty});
		GameRegistry.addRecipe(new ItemStack(bucketIronEmpty     ), new Object[]{"X" , 'X', Items.bucket});
		GameRegistry.addRecipe(new ItemStack(greenhillEarth     ), new Object[]{"OX" , "XO" ,        'O', Blocks.dirt,   'X', Blocks.gravel        });
		GameRegistry.addRecipe(new ItemStack(greenhillGrass     ), new Object[]{"OO" , "OO" ,        'O', greenhillEarth                           });
		GameRegistry.addRecipe(new ItemStack(greenhillStone     ), new Object[]{"OX" , "XO" ,        'O', Blocks.stone, 'X', Blocks.cobblestone    });
		GameRegistry.addRecipe(new ItemStack(greenhillMoss      ), new Object[]{"OO" , "OO" ,        'O', greenhillStone                           });
		GameRegistry.addRecipe(new ItemStack(Items.flint        ), new Object[]{"OO" , "OO" ,        'O', Blocks.gravel                            });
		GameRegistry.addRecipe(new ItemStack(blockSalt          ), new Object[]{"XXX", "XXX", "XXX", 'X', powderSalt                               });
		GameRegistry.addRecipe(new ItemStack(blockSulfur        ), new Object[]{"XXX", "XXX", "XXX", 'X', powderSulfur                             });
		GameRegistry.addRecipe(new ItemStack(blockFlour         ), new Object[]{"XXX", "XXX", "XXX", 'X', powderFlour                              });
		GameRegistry.addRecipe(new ItemStack(blockCoffee        ), new Object[]{"XXX", "XXX", "XXX", 'X', powderCoffee                             });
		GameRegistry.addRecipe(new ItemStack(blockRuby          ), new Object[]{"XXX", "XXX", "XXX", 'X', gemstoneRuby                             });
		GameRegistry.addRecipe(new ItemStack(blockPeridot       ), new Object[]{"XXX", "XXX", "XXX", 'X', gemstonePeridot                          });
		GameRegistry.addRecipe(new ItemStack(blockTopaz         ), new Object[]{"XXX", "XXX", "XXX", 'X', gemstoneTopaz                            });
		GameRegistry.addRecipe(new ItemStack(blockSaphire       ), new Object[]{"XXX", "XXX", "XXX", 'X', gemstoneSaphire                          });
		GameRegistry.addRecipe(new ItemStack(blockAzurit        ), new Object[]{"XXX", "XXX", "XXX", 'X', gemstoneAzurit                           });
		GameRegistry.addRecipe(new ItemStack(blockAmber         ), new Object[]{"XXX", "XXX", "XXX", 'X', gemstoneAmber                            });
		GameRegistry.addRecipe(new ItemStack(blockAmethyst      ), new Object[]{"XXX", "XXX", "XXX", 'X', gemstoneAmethyst                         });
		GameRegistry.addRecipe(new ItemStack(blockGagat         ), new Object[]{"XXX", "XXX", "XXX", 'X', gemstoneGagat                            });
		GameRegistry.addRecipe(new ItemStack(blockOpal          ), new Object[]{"XXX", "XXX", "XXX", 'X', gemstoneOpal                             });
		GameRegistry.addRecipe(new ItemStack(blockJade          ), new Object[]{"XXX", "XXX", "XXX", 'X', gemstoneJade                             });
		GameRegistry.addRecipe(new ItemStack(blockTurquoise     ), new Object[]{"XXX", "XXX", "XXX", 'X', gemstoneTurquoise                        });
		GameRegistry.addRecipe(new ItemStack(toolAxeFlint       ), new Object[]{"XX" , "XI" , " I" , 'X', Items.flint,      'I', Items.stick       });
		GameRegistry.addRecipe(new ItemStack(toolHoeFlint       ), new Object[]{"XX" , " I" , " I" , 'X', Items.flint,      'I', Items.stick       });
		GameRegistry.addRecipe(new ItemStack(toolPickaxeFlint   ), new Object[]{"XXX", " I ", " I ", 'X', Items.flint,      'I', Items.stick       });
		GameRegistry.addRecipe(new ItemStack(toolShovelFlint    ), new Object[]{ "X" ,  "I" ,  "I" , 'X', Items.flint,      'I', Items.stick       });
		GameRegistry.addRecipe(new ItemStack(toolSwordFlint     ), new Object[]{ "X" ,  "X" ,  "I" , 'X', Items.flint,      'I', Items.stick       });
		GameRegistry.addRecipe(new ItemStack(toolSpearFlint     ), new Object[]{"  X", " I ", "I  ", 'X', Items.flint,      'I', Items.stick       });
		GameRegistry.addRecipe(new ItemStack(machinaWorkbench   ), new Object[]{"XXX", "XXX", "XXX", 'X', Blocks.planks                            });
		GameRegistry.addRecipe(new ItemStack(machinaWorkbench   ), new Object[]{"XXX", "XXX", "XXX", 'X', acePlanks                                });
		GameRegistry.addRecipe(new ItemStack(machinaBonfireIdle ), new Object[]{"LL" , "OO" ,        'L', Blocks.log,       'O', Blocks.cobblestone});
		GameRegistry.addRecipe(new ItemStack(machinaBonfireIdle ), new Object[]{"LL" , "OO" ,        'L', Blocks.log2,      'O', Blocks.cobblestone});
		GameRegistry.addRecipe(new ItemStack(machinaBonfireIdle ), new Object[]{"LL" , "OO" ,        'L', aceLog,           'O', Blocks.cobblestone});
		GameRegistry.addRecipe(new ItemStack(machinaBonfireIdle ), new Object[]{"LL" , "OO" ,        'L', Blocks.log,       'O', Blocks.gravel     });
		GameRegistry.addRecipe(new ItemStack(machinaBonfireIdle ), new Object[]{"LL" , "OO" ,        'L', Blocks.log2,      'O', Blocks.gravel     });
		GameRegistry.addRecipe(new ItemStack(machinaBonfireIdle ), new Object[]{"LL" , "OO" ,        'L', aceLog,           'O', Blocks.gravel     });
		GameRegistry.addRecipe(new ItemStack(bedWhite           ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.wool, 1,  0), 'P', Blocks.planks});
		GameRegistry.addRecipe(new ItemStack(bedOrange          ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.wool, 1,  1), 'P', Blocks.planks});
		GameRegistry.addRecipe(new ItemStack(bedMagenta         ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.wool, 1,  2), 'P', Blocks.planks});
		GameRegistry.addRecipe(new ItemStack(bedLightBlue       ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.wool, 1,  3), 'P', Blocks.planks});
		GameRegistry.addRecipe(new ItemStack(bedYellow          ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.wool, 1,  4), 'P', Blocks.planks});
		GameRegistry.addRecipe(new ItemStack(bedLime            ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.wool, 1,  5), 'P', Blocks.planks});
		GameRegistry.addRecipe(new ItemStack(bedPink            ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.wool, 1,  6), 'P', Blocks.planks});
		GameRegistry.addRecipe(new ItemStack(bedGrey            ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.wool, 1,  7), 'P', Blocks.planks});
		GameRegistry.addRecipe(new ItemStack(bedSilver          ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.wool, 1,  8), 'P', Blocks.planks});
		GameRegistry.addRecipe(new ItemStack(bedCyan            ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.wool, 1,  9), 'P', Blocks.planks});
		GameRegistry.addRecipe(new ItemStack(bedPurple          ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.wool, 1, 10), 'P', Blocks.planks});
		GameRegistry.addRecipe(new ItemStack(bedBlue            ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.wool, 1, 11), 'P', Blocks.planks});
		GameRegistry.addRecipe(new ItemStack(bedBrown           ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.wool, 1, 12), 'P', Blocks.planks});
		GameRegistry.addRecipe(new ItemStack(bedGreen           ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.wool, 1, 13), 'P', Blocks.planks});
		GameRegistry.addRecipe(new ItemStack(bedRed             ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.wool, 1, 14), 'P', Blocks.planks});
		GameRegistry.addRecipe(new ItemStack(bedBlack           ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.wool, 1, 15), 'P', Blocks.planks});
		GameRegistry.addRecipe(new ItemStack(bedWhite           ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.wool, 1,  0), 'P', acePlanks});
		GameRegistry.addRecipe(new ItemStack(bedOrange          ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.wool, 1,  1), 'P', acePlanks});
		GameRegistry.addRecipe(new ItemStack(bedMagenta         ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.wool, 1,  2), 'P', acePlanks});
		GameRegistry.addRecipe(new ItemStack(bedLightBlue       ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.wool, 1,  3), 'P', acePlanks});
		GameRegistry.addRecipe(new ItemStack(bedYellow          ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.wool, 1,  4), 'P', acePlanks});
		GameRegistry.addRecipe(new ItemStack(bedLime            ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.wool, 1,  5), 'P', acePlanks});
		GameRegistry.addRecipe(new ItemStack(bedPink            ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.wool, 1,  6), 'P', acePlanks});
		GameRegistry.addRecipe(new ItemStack(bedGrey            ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.wool, 1,  7), 'P', acePlanks});
		GameRegistry.addRecipe(new ItemStack(bedSilver          ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.wool, 1,  8), 'P', acePlanks});
		GameRegistry.addRecipe(new ItemStack(bedCyan            ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.wool, 1,  9), 'P', acePlanks});
		GameRegistry.addRecipe(new ItemStack(bedPurple          ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.wool, 1, 10), 'P', acePlanks});
		GameRegistry.addRecipe(new ItemStack(bedBlue            ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.wool, 1, 11), 'P', acePlanks});
		GameRegistry.addRecipe(new ItemStack(bedBrown           ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.wool, 1, 12), 'P', acePlanks});
		GameRegistry.addRecipe(new ItemStack(bedGreen           ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.wool, 1, 13), 'P', acePlanks});
		GameRegistry.addRecipe(new ItemStack(bedRed             ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.wool, 1, 14), 'P', acePlanks});
		GameRegistry.addRecipe(new ItemStack(bedBlack           ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.wool, 1, 15), 'P', acePlanks});
		
		
		//Smelting Ore
		GameRegistry.addSmelting(oreCopper,     new ItemStack(ingotCopper,     1), 1);
		GameRegistry.addSmelting(oreBauxite,    new ItemStack(ingotAluminium,  1), 1);
		GameRegistry.addSmelting(oreLead,       new ItemStack(ingotLead,       1), 1);
		GameRegistry.addSmelting(oreTin,        new ItemStack(ingotTin,        1), 1);
		GameRegistry.addSmelting(oreZinc,       new ItemStack(ingotZinc,       1), 1);
		GameRegistry.addSmelting(oreSilver,     new ItemStack(ingotSilver,     1), 1);
		GameRegistry.addSmelting(oreMythril,    new ItemStack(ingotMythril,    1), 1);
		GameRegistry.addSmelting(oreIridium,    new ItemStack(ingotIridium,    1), 1);
		GameRegistry.addSmelting(oreAdamantium, new ItemStack(ingotAdamantium, 1), 1);
		GameRegistry.addSmelting(oreOrichalcum, new ItemStack(ingotOrichalcum, 1), 1);
		GameRegistry.addSmelting(oreUnobtanium, new ItemStack(ingotUnobtanium, 1), 1);
		
		//Smelting Nugget
		GameRegistry.addSmelting(nuggetIron,       new ItemStack(Items.iron_ingot, 1), 1);
		GameRegistry.addSmelting(nuggetGold,       new ItemStack(Items.gold_ingot, 1), 1);
		GameRegistry.addSmelting(nuggetCopper,     new ItemStack(ingotCopper,      1), 1);
		GameRegistry.addSmelting(nuggetBauxite,    new ItemStack(ingotAluminium,   1), 1);
		GameRegistry.addSmelting(nuggetLead,       new ItemStack(ingotLead,        1), 1);
		GameRegistry.addSmelting(nuggetTin,        new ItemStack(ingotTin,         1), 1);
		GameRegistry.addSmelting(nuggetZinc,       new ItemStack(ingotZinc,        1), 1);
		GameRegistry.addSmelting(nuggetSilver,     new ItemStack(ingotSilver,      1), 1);
		GameRegistry.addSmelting(nuggetMythril,    new ItemStack(ingotMythril,     1), 1);
		GameRegistry.addSmelting(nuggetIridium,    new ItemStack(ingotIridium,     1), 1);
		GameRegistry.addSmelting(nuggetAdamantium, new ItemStack(ingotAdamantium,  1), 1);
		GameRegistry.addSmelting(nuggetOrichalcum, new ItemStack(ingotOrichalcum,  1), 1);
		GameRegistry.addSmelting(nuggetUnobtanium, new ItemStack(ingotUnobtanium,  1), 1);
		
		//Smelting Powder
		GameRegistry.addSmelting(powderOrichalcum, new ItemStack(ingotOrichalcum, 1), 1);
		
		//Smelting Food
		GameRegistry.addSmelting(foodMammothMeatRaw, new ItemStack(foodMammothMeatCooked, 1), 1);
		GameRegistry.addSmelting(foodVenisonRaw,     new ItemStack(foodVenisonCooked,     1), 1);
		GameRegistry.addSmelting(foodMuttonRaw,      new ItemStack(foodMuttonCooked,      1), 1);
		GameRegistry.addSmelting(foodCrabMeatRaw,    new ItemStack(foodCrabMeatCooked,    1), 1);
		GameRegistry.addSmelting(foodCalamariRaw,    new ItemStack(foodCalamariCooked,    1), 1);
	}
	
	public void PostInit(){
		//MinecraftForge.EVENT_BUS.register(new GuiBuffBar   (Minecraft.getMinecraft()));
	}

}