package net.acecraft.mod;

import net.acecraft.mod.blocks.BlockBed;
import net.acecraft.mod.blocks.BlockBlock;
import net.acecraft.mod.blocks.BlockCake;
import net.acecraft.mod.blocks.BlockCrop;
import net.acecraft.mod.blocks.BlockMino;
import net.acecraft.mod.blocks.BlockOre;
import net.acecraft.mod.blocks.BlockPizza;
import net.acecraft.mod.entity.EntityDynamite;
import net.acecraft.mod.entity.EntityNugget;
import net.acecraft.mod.entity.EntitySpear;
import net.acecraft.mod.items.ItemArmor;
import net.acecraft.mod.items.ItemBed;
import net.acecraft.mod.items.ItemDish;
import net.acecraft.mod.items.ItemDrink;
import net.acecraft.mod.items.ItemDynamite;
import net.acecraft.mod.items.ItemFood;
import net.acecraft.mod.items.ItemItem;
import net.acecraft.mod.items.ItemNugget;
import net.acecraft.mod.items.ItemSeed;
import net.acecraft.mod.items.ItemSeedWild;
import net.acecraft.mod.items.ToolAxe;
import net.acecraft.mod.items.ToolFryingPan;
import net.acecraft.mod.items.ToolHammer;
import net.acecraft.mod.items.ToolHoe;
import net.acecraft.mod.items.ToolPickaxe;
import net.acecraft.mod.items.ToolShovel;
import net.acecraft.mod.items.ToolSpear;
import net.acecraft.mod.items.ToolSword;
import net.acecraft.mod.render.RenderNugget;
import net.acecraft.mod.render.RenderSpear;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ShopKeeper {
	
	public static ToolMaterial materialToolFlint      = EnumHelper.addToolMaterial("MaterialToolFlint",      1,  152,  4.0F,  1.5F,   0);
	public static ToolMaterial materialToolObsidian   = EnumHelper.addToolMaterial("MaterialToolObsidian",   1,  148,  8.0F,  7.5F,  65);
	public static ToolMaterial materialToolCopper     = EnumHelper.addToolMaterial("MaterialToolCopper",     2,  185,  5.5F,  2.0F,  15);
	public static ToolMaterial materialToolBronze     = EnumHelper.addToolMaterial("MaterialToolBronze",     2,  560,  7.0F,  3.0F,  20);
	public static ToolMaterial materialToolSteel      = EnumHelper.addToolMaterial("MaterialToolSteel",      2, 1244,  8.0F,  3.5F,  20);
	public static ToolMaterial materialToolMythril    = EnumHelper.addToolMaterial("MaterialToolMythril",    3, 2100, 10.0F,  5.0F,  50);
	public static ToolMaterial materialToolIridium    = EnumHelper.addToolMaterial("MaterialToolIridium",    3, 6500,  9.0F, 10.0F, 100);
	public static ToolMaterial materialToolAdamantium = EnumHelper.addToolMaterial("MaterialToolAdamantium", 3, 5600, 15.0F,  8.0F,  75);
	public static ToolMaterial materialToolUnobtanium = EnumHelper.addToolMaterial("MaterialToolUnobtanium", 4, 9999, 42.0F, 42.0F, 100);
	
	public static ArmorMaterial materialArmorCopper     = EnumHelper.addArmorMaterial("MaterialArmorCopper",     AceCraft.modid + ":" + "copper",      7, new int[]{2, 4, 2, 2},   5, SoundEvents.item_armor_equip_iron);
	public static ArmorMaterial materialArmorAluminium  = EnumHelper.addArmorMaterial("MaterialArmorAluminium",  AceCraft.modid + ":" + "aluminium",  15, new int[]{2, 7, 6, 3},  12, SoundEvents.item_armor_equip_iron);
	public static ArmorMaterial materialArmorLead       = EnumHelper.addArmorMaterial("MaterialArmorLead",       AceCraft.modid + ":" + "lead",       20, new int[]{2, 5, 3, 2},   5, SoundEvents.item_armor_equip_iron);
	public static ArmorMaterial materialArmorBronze     = EnumHelper.addArmorMaterial("MaterialArmorBronze",     AceCraft.modid + ":" + "bronze",     20, new int[]{2, 5, 3, 2},  12, SoundEvents.item_armor_equip_gold);
	public static ArmorMaterial materialArmorSteel      = EnumHelper.addArmorMaterial("MaterialArmorSteel",      AceCraft.modid + ":" + "steel",      25, new int[]{3, 6, 4, 3},  12, SoundEvents.item_armor_equip_gold);
	public static ArmorMaterial materialArmorMythril    = EnumHelper.addArmorMaterial("MaterialArmorMythril",    AceCraft.modid + ":" + "mythril",    30, new int[]{3, 7, 5, 3},  45, SoundEvents.item_armor_equip_diamond);
	public static ArmorMaterial materialArmorAdamantium = EnumHelper.addArmorMaterial("MaterialArmorAdamantium", AceCraft.modid + ":" + "adamantium", 35, new int[]{3, 8, 6, 3},  70, SoundEvents.item_armor_equip_diamond);
	public static ArmorMaterial materialArmorUnobtanium = EnumHelper.addArmorMaterial("MaterialArmorUnobtanium", AceCraft.modid + ":" + "unobtanium", 99, new int[]{3, 8, 6, 3}, 100, SoundEvents.item_armor_equip_diamond);
	
	// Full Blocks
	public static Block blockAdamantium = new BlockBlock("BlockAdamantium", Material.iron,  3.0F, 5.0F);
	public static Block blockAluminium  = new BlockBlock("BlockAluminium",  Material.iron,  3.0F, 5.0F);
	public static Block blockAmethyst   = new BlockBlock("BlockAmethyst",   Material.glass, 3.0F, 4.0F);
	public static Block blockAquamarine = new BlockBlock("BlockAquamarine", Material.glass, 3.0F, 4.0F);
	public static Block blockBeryl      = new BlockBlock("BlockBeryl",      Material.glass, 3.0F, 4.0F);
	public static Block blockBrass      = new BlockBlock("BlockBrass",      Material.iron,  3.0F, 3.0F);
	public static Block blockCoffee     = new BlockBlock("BlockCoffee",     Material.sand,  3.0F, 1.0F);
	public static Block blockCopper     = new BlockBlock("BlockCopper",     Material.iron,  3.0F, 5.0F);
	public static Block blockFlour      = new BlockBlock("BlockFlour",      Material.sand,  3.0F, 1.0F);
	public static Block blockGagat      = new BlockBlock("BlockGagat",      Material.glass, 3.0F, 4.0F);
	public static Block blockIridium    = new BlockBlock("BlockIridium",    Material.coral, 3.0F, 6.0F);
	public static Block blockLead       = new BlockBlock("BlockLead",       Material.iron,  3.0F, 3.0F);
	public static Block blockMeteor     = new BlockBlock("BlockMeteor",     Material.rock,  7.0F, 9.0F);
	public static Block blockMythril    = new BlockBlock("BlockMythril",    Material.iron,  3.0F, 5.0F);
	public static Block blockOpal       = new BlockBlock("BlockOpal",       Material.glass, 3.0F, 4.0F);
	public static Block blockOrichalcum = new BlockBlock("BlockOrichalcum", Material.iron,  3.0F, 3.0F);
	public static Block blockRuby       = new BlockBlock("BlockRuby",       Material.glass, 3.0F, 4.0F);
	public static Block blockSalt       = new BlockBlock("BlockSalt",       Material.sand,  3.0F, 1.0F);
	public static Block blockSaphire    = new BlockBlock("BlockSaphire",    Material.glass, 3.0F, 4.0F);
	public static Block blockSilver     = new BlockBlock("BlockSilver",     Material.iron,  3.0F, 3.0F);
	public static Block blockSteel      = new BlockBlock("BlockSteel",      Material.iron,  3.0F, 5.0F);
	public static Block blockSulfur     = new BlockBlock("BlockSulfur",     Material.rock,  3.0F, 1.0F);
	public static Block blockTin        = new BlockBlock("BlockTin",        Material.iron,  3.0F, 3.0F);
	public static Block blockTopaz      = new BlockBlock("BlockTopaz",      Material.glass, 3.0F, 4.0F);
	public static Block blockTourmaline = new BlockBlock("BlockTourmaline", Material.glass, 3.0F, 4.0F);
	public static Block blockUnobtanium = new BlockBlock("BlockUnobtanium", Material.iron,  9.9F, 9.9F);
	public static Block blockZinc       = new BlockBlock("BlockZinc",       Material.iron,  3.0F, 3.0F);
	
	// Nuggets
	public static Item nuggetAdamantium = new ItemNugget("NuggetAdamantium");
	public static Item nuggetBauxite    = new ItemNugget("NuggetBauxite");
	public static Item nuggetCopper     = new ItemNugget("NuggetCopper");
	public static Item nuggetGold       = new ItemNugget("NuggetGold");
	public static Item nuggetIridium    = new ItemNugget("NuggetIridium");
	public static Item nuggetIron       = new ItemNugget("NuggetIron");
	public static Item nuggetLead       = new ItemNugget("NuggetLead");
	public static Item nuggetMythril    = new ItemNugget("NuggetMythril");
	public static Item nuggetOrichalcum = new ItemNugget("NuggetOrichalcum");
	public static Item nuggetSilver     = new ItemNugget("NuggetSilver");
	public static Item nuggetTin        = new ItemNugget("NuggetTin");
	public static Item nuggetUnobtanium = new ItemNugget("NuggetUnobtanium");
	public static Item nuggetZinc       = new ItemNugget("NuggetZinc");
	
	// Gemstones
	public static Item gemAmethyst   = new ItemItem("GemAmethyst");
	public static Item gemAquamarine = new ItemItem("GemAquamarine");
	public static Item gemBeryl      = new ItemItem("GemBeryl");
	public static Item gemGagat      = new ItemItem("GemGagat");
	public static Item gemOpal       = new ItemItem("GemOpal");
	public static Item gemRuby       = new ItemItem("GemRuby");
	public static Item gemSaphire    = new ItemItem("GemSaphire");
	public static Item gemTopaz      = new ItemItem("GemTopaz");
	public static Item gemTourmaline = new ItemItem("GemTourmaline");
	
	// Powder
	public static Item powderCoffee     = new ItemNugget("PowderCoffee");
	public static Item powderFlour      = new ItemNugget("PowderFlour");
	public static Item powderOrichalcum = new ItemNugget("PowderOrichalcum");
	public static Item powderSalt       = new ItemNugget("PowderSalt");
	public static Item powderSulfur     = new ItemNugget("PowderSulfur");
	
	// Ore Blocks
	public static Block oreAdamantium = new BlockOre("OreAdamantium", 3, nuggetAdamantium);
	public static Block oreAmethyst   = new BlockOre("OreAmethyst",   2, gemAmethyst);
	public static Block oreAquamarine = new BlockOre("OreAquamarine", 2, gemAquamarine);
	public static Block oreBauxite    = new BlockOre("OreBauxite",    1, nuggetBauxite);
	public static Block oreBeryl      = new BlockOre("OreBeryl",      2, gemBeryl);
	public static Block oreCopper     = new BlockOre("OreCopper",     1, nuggetCopper);
	public static Block oreIridium    = new BlockOre("OreIridium",    3, nuggetIridium);
	public static Block oreLead       = new BlockOre("OreLead",       1, nuggetLead);
	public static Block oreMythril    = new BlockOre("OreMythril",    2, nuggetMythril);
	public static Block oreOpal       = new BlockOre("OreOpal",       3, gemOpal);
	public static Block oreOrichalcum = new BlockOre("OreOrichalcum", 2, nuggetOrichalcum);
	public static Block oreRuby       = new BlockOre("OreRuby",       2, gemRuby);
	public static Block oreSalt       = new BlockOre("OreSalt",       1, powderSalt);
	public static Block oreSaphire    = new BlockOre("OreSaphire",    2, gemSaphire);
	public static Block oreSilver     = new BlockOre("OreSilver",     1, nuggetSilver);
	public static Block oreSulfur     = new BlockOre("OreSulfur",     1, powderSulfur);
	public static Block oreTin        = new BlockOre("OreTin",        1, nuggetTin);
	public static Block oreTopaz      = new BlockOre("OreTopaz",      2, gemTopaz);
	public static Block oreTourmaline = new BlockOre("OreTourmaline", 2, gemTourmaline);
	public static Block oreUnobtanium = new BlockOre("OreUnobtanium", 4, nuggetUnobtanium);
	public static Block oreZinc       = new BlockOre("OreZinc",       1, nuggetZinc);
	public static Block oreGagat      = new BlockOre("OreGagat",      2, gemGagat);
	
	// Minos
	public static Block minoBlank   = new BlockMino("MinoBlank",   Items.flint);
	public static Block minoFire    = new BlockMino("MinoFire",    gemRuby);
	public static Block minoAir     = new BlockMino("MinoAir",     gemTourmaline);
	public static Block minoThunder = new BlockMino("MinoThunder", gemTopaz);
	public static Block minoWater   = new BlockMino("MinoWater",   gemSaphire);
	public static Block minoIce     = new BlockMino("MinoIce",     gemAquamarine);
	public static Block minoEarth   = new BlockMino("MinoEarth",   gemBeryl);
	public static Block minoMetal   = new BlockMino("MinoMetal",   gemAmethyst);
	public static Block minoNature  = new BlockMino("MinoNature",  Items.emerald);
	public static Block minoLight   = new BlockMino("MinoLight",   Items.diamond);
	public static Block minoDark    = new BlockMino("MinoDark",    gemGagat);
	
	// Ingots
	public static Item ingotAdamantium = new ItemItem("IngotAdamantium");
	public static Item ingotAluminium  = new ItemItem("IngotAluminium");
	public static Item ingotBrass      = new ItemItem("IngotBrass");
	public static Item ingotBronze     = new ItemItem("IngotBronze");
	public static Item ingotCopper     = new ItemItem("IngotCopper");
	public static Item ingotLead       = new ItemItem("IngotLead");
	public static Item ingotMythril    = new ItemItem("IngotMythril");
	public static Item ingotOrichalcum = new ItemItem("IngotOrichalcum");
	public static Item ingotSilver     = new ItemItem("IngotSilver");
	public static Item ingotSteel      = new ItemItem("IngotSteel");
	public static Item ingotTin        = new ItemItem("IngotTin");
	public static Item ingotUnobtanium = new ItemItem("IngotUnobtanium");
	public static Item ingotZinc       = new ItemItem("IngotZinc");
	
	// Tools
	public static Item toolFryingPan         = new ToolFryingPan("ToolFryingPan",         ToolMaterial.IRON);
	public static Item toolAxeAdamantium     = new ToolAxe      ("ToolAxeAdamantium",     materialToolAdamantium);
	public static Item toolAxeBronze         = new ToolAxe      ("ToolAxeBronze",         materialToolBronze);
	public static Item toolAxeCopper         = new ToolAxe      ("ToolAxeCopper",         materialToolCopper);
	public static Item toolAxeFlint          = new ToolAxe      ("ToolAxeFlint",          materialToolFlint);
	public static Item toolAxeIridium        = new ToolAxe      ("ToolAxeIridium",        materialToolIridium);
	public static Item toolAxeMythril        = new ToolAxe      ("ToolAxeMythril",        materialToolMythril);
	public static Item toolAxeObsidian       = new ToolAxe      ("ToolAxeObsidian",       materialToolObsidian);
	public static Item toolAxeSteel          = new ToolAxe      ("ToolAxeSteel",          materialToolSteel);
	public static Item toolAxeUnobtanium     = new ToolAxe      ("ToolAxeUnobtanium",     materialToolUnobtanium);
	public static Item toolHammerAdamantium  = new ToolHammer   ("ToolHammerAdamantium",  materialToolAdamantium);
	public static Item toolHammerBronze      = new ToolHammer   ("ToolHammerBronze",      materialToolBronze);
	public static Item toolHammerCopper      = new ToolHammer   ("ToolHammerCopper",      materialToolCopper);
	public static Item toolHammerFlint       = new ToolHammer   ("ToolHammerFlint",       materialToolFlint);
	public static Item toolHammerGold        = new ToolHammer   ("ToolHammerGold",        ToolMaterial.GOLD);
	public static Item toolHammerIridium     = new ToolHammer   ("ToolHammerIridium",     materialToolIridium);
	public static Item toolHammerIron        = new ToolHammer   ("ToolHammerIron",        ToolMaterial.IRON);
	public static Item toolHammerMythril     = new ToolHammer   ("ToolHammerMythril",     materialToolMythril);
	public static Item toolHammerObsidian    = new ToolHammer   ("ToolHammerObsidian",    materialToolObsidian);
	public static Item toolHammerSteel       = new ToolHammer   ("ToolHammerSteel",       materialToolSteel);
	public static Item toolHammerUnobtanium  = new ToolHammer   ("ToolHammerUnobtanium",  materialToolUnobtanium);
	public static Item toolHoeAdamantium     = new ToolHoe      ("ToolHoeAdamantium",     materialToolAdamantium);
	public static Item toolHoeBronze         = new ToolHoe      ("ToolHoeBronze",         materialToolBronze);
	public static Item toolHoeCopper         = new ToolHoe      ("ToolHoeCopper",         materialToolCopper);
	public static Item toolHoeFlint          = new ToolHoe      ("ToolHoeFlint",          materialToolFlint);
	public static Item toolHoeIridium        = new ToolHoe      ("ToolHoeIridium",        materialToolIridium);
	public static Item toolHoeMythril        = new ToolHoe      ("ToolHoeMythril",        materialToolMythril);
	public static Item toolHoeObsidian       = new ToolHoe      ("ToolHoeObsidian",       materialToolObsidian);
	public static Item toolHoeSteel          = new ToolHoe      ("ToolHoeSteel",          materialToolSteel);
	public static Item toolHoeUnobtanium     = new ToolHoe      ("ToolHoeUnobtanium",     materialToolUnobtanium);
	public static Item toolPickaxeAdamantium = new ToolPickaxe  ("ToolPickaxeAdamantium", materialToolAdamantium);
	public static Item toolPickaxeBronze     = new ToolPickaxe  ("ToolPickaxeBronze",     materialToolBronze);
	public static Item toolPickaxeCopper     = new ToolPickaxe  ("ToolPickaxeCopper",     materialToolCopper);
	public static Item toolPickaxeFlint      = new ToolPickaxe  ("ToolPickaxeFlint",      materialToolFlint);
	public static Item toolPickaxeIridium    = new ToolPickaxe  ("ToolPickaxeIridium",    materialToolIridium);
	public static Item toolPickaxeMythril    = new ToolPickaxe  ("ToolPickaxeMythril",    materialToolMythril);
	public static Item toolPickaxeObsidian   = new ToolPickaxe  ("ToolPickaxeObsidian",   materialToolObsidian);
	public static Item toolPickaxeSteel      = new ToolPickaxe  ("ToolPickaxeSteel",      materialToolSteel);
	public static Item toolPickaxeUnobtanium = new ToolPickaxe  ("ToolPickaxeUnobtanium", materialToolUnobtanium);
	public static Item toolShovelAdamantium  = new ToolShovel   ("ToolShovelAdamantium",  materialToolAdamantium);
	public static Item toolShovelBronze      = new ToolShovel   ("ToolShovelBronze",      materialToolBronze);
	public static Item toolShovelCopper      = new ToolShovel   ("ToolShovelCopper",      materialToolCopper);
	public static Item toolShovelFlint       = new ToolShovel   ("ToolShovelFlint",       materialToolFlint);
	public static Item toolShovelIridium     = new ToolShovel   ("ToolShovelIridium",     materialToolIridium);
	public static Item toolShovelMythril     = new ToolShovel   ("ToolShovelMythril",     materialToolMythril);
	public static Item toolShovelObsidian    = new ToolShovel   ("ToolShovelObsidian",    materialToolObsidian);
	public static Item toolShovelSteel       = new ToolShovel   ("ToolShovelSteel",       materialToolSteel);
	public static Item toolShovelUnobtanium  = new ToolShovel   ("ToolShovelUnobtanium",  materialToolUnobtanium);
	public static Item toolSpearAdamantium   = new ToolSpear    ("ToolSpearAdamantium",   materialToolAdamantium);
	public static Item toolSpearBronze       = new ToolSpear    ("ToolSpearBronze",       materialToolBronze);
	public static Item toolSpearCopper       = new ToolSpear    ("ToolSpearCopper",       materialToolCopper);
	public static Item toolSpearFlint        = new ToolSpear    ("ToolSpearFlint",        materialToolFlint);
	public static Item toolSpearGold         = new ToolSpear    ("ToolSpearGold",         ToolMaterial.GOLD);
	public static Item toolSpearIridium      = new ToolSpear    ("ToolSpearIridium",      materialToolIridium);
	public static Item toolSpearIron         = new ToolSpear    ("ToolSpearIron",         ToolMaterial.IRON);
	public static Item toolSpearMythril      = new ToolSpear    ("ToolSpearMythril",      materialToolMythril);
	public static Item toolSpearObsidian     = new ToolSpear    ("ToolSpearObsidian",     materialToolObsidian);
	public static Item toolSpearSteel        = new ToolSpear    ("ToolSpearSteel",        materialToolSteel);
	public static Item toolSpearUnobtanium   = new ToolSpear    ("ToolSpearUnobtanium",   materialToolUnobtanium);
	public static Item toolSwordAdamantium   = new ToolSword    ("ToolSwordAdamantium",   materialToolAdamantium);
	public static Item toolSwordBronze       = new ToolSword    ("ToolSwordBronze",       materialToolBronze);
	public static Item toolSwordCopper       = new ToolSword    ("ToolSwordCopper",       materialToolCopper);
	public static Item toolSwordFlint        = new ToolSword    ("ToolSwordFlint",        materialToolFlint);
	public static Item toolSwordIridium      = new ToolSword    ("ToolSwordIridium",      materialToolIridium);
	public static Item toolSwordMythril      = new ToolSword    ("ToolSwordMythril",      materialToolMythril);
	public static Item toolSwordObsidian     = new ToolSword    ("ToolSwordObsidian",     materialToolObsidian);
	public static Item toolSwordSteel        = new ToolSword    ("ToolSwordSteel",        materialToolSteel);
	public static Item toolSwordUnobtanium   = new ToolSword    ("ToolSwordUnobtanium",   materialToolUnobtanium);
	
	// Armor
	public static Item armorBootsAdamantium      = new ItemArmor("ArmorBootsAdamantium",      materialArmorAdamantium, 0, EntityEquipmentSlot.FEET);
	public static Item armorBootsAluminium       = new ItemArmor("ArmorBootsAluminium",       materialArmorAluminium,  0, EntityEquipmentSlot.FEET);
	public static Item armorBootsBronze          = new ItemArmor("ArmorBootsBronze",          materialArmorBronze,     0, EntityEquipmentSlot.FEET);
	public static Item armorBootsCopper          = new ItemArmor("ArmorBootsCopper",          materialArmorCopper,     0, EntityEquipmentSlot.FEET);
	public static Item armorBootsLead            = new ItemArmor("ArmorBootsLead",            materialArmorLead,       0, EntityEquipmentSlot.FEET);
	public static Item armorBootsMythril         = new ItemArmor("ArmorBootsMythril",         materialArmorMythril,    0, EntityEquipmentSlot.FEET);
	public static Item armorBootsSteel           = new ItemArmor("ArmorBootsSteel",           materialArmorSteel,      0, EntityEquipmentSlot.FEET);
	public static Item armorBootsUnobtanium      = new ItemArmor("ArmorBootsUnobtanium",      materialArmorUnobtanium, 0, EntityEquipmentSlot.FEET);
	public static Item armorChestplateAdamantium = new ItemArmor("ArmorChestplateAdamantium", materialArmorAdamantium, 0, EntityEquipmentSlot.CHEST);
	public static Item armorChestplateAluminium  = new ItemArmor("ArmorChestplateAluminium",  materialArmorAluminium,  0, EntityEquipmentSlot.CHEST);
	public static Item armorChestplateBronze     = new ItemArmor("ArmorChestplateBronze",     materialArmorBronze,     0, EntityEquipmentSlot.CHEST);
	public static Item armorChestplateCopper     = new ItemArmor("ArmorChestplateCopper",     materialArmorCopper,     0, EntityEquipmentSlot.CHEST);
	public static Item armorChestplateLead       = new ItemArmor("ArmorChestplateLead",       materialArmorLead,       0, EntityEquipmentSlot.CHEST);
	public static Item armorChestplateMythril    = new ItemArmor("ArmorChestplateMythril",    materialArmorMythril,    0, EntityEquipmentSlot.CHEST);
	public static Item armorChestplateSteel      = new ItemArmor("ArmorChestplateSteel",      materialArmorSteel,      0, EntityEquipmentSlot.CHEST);
	public static Item armorChestplateUnobtanium = new ItemArmor("ArmorChestplateUnobtanium", materialArmorUnobtanium, 0, EntityEquipmentSlot.CHEST);
	public static Item armorHelmetAdamantium     = new ItemArmor("ArmorHelmetAdamantium",     materialArmorAdamantium, 0, EntityEquipmentSlot.HEAD);
	public static Item armorHelmetAluminium      = new ItemArmor("ArmorHelmetAluminium",      materialArmorAluminium,  0, EntityEquipmentSlot.HEAD);
	public static Item armorHelmetBronze         = new ItemArmor("ArmorHelmetBronze",         materialArmorBronze,     0, EntityEquipmentSlot.HEAD);
	public static Item armorHelmetCopper         = new ItemArmor("ArmorHelmetCopper",         materialArmorCopper,     0, EntityEquipmentSlot.HEAD);
	public static Item armorHelmetLead           = new ItemArmor("ArmorHelmetLead",           materialArmorLead,       0, EntityEquipmentSlot.HEAD);
	public static Item armorHelmetMythril        = new ItemArmor("ArmorHelmetMythril",        materialArmorMythril,    0, EntityEquipmentSlot.HEAD);
	public static Item armorHelmetSteel          = new ItemArmor("ArmorHelmetSteel",          materialArmorSteel,      0, EntityEquipmentSlot.HEAD);
	public static Item armorHelmetUnobtanium     = new ItemArmor("ArmorHelmetUnobtanium",     materialArmorUnobtanium, 0, EntityEquipmentSlot.HEAD);
	public static Item armorLeggingsAdamantium   = new ItemArmor("ArmorLeggingsAdamantium",   materialArmorAdamantium, 0, EntityEquipmentSlot.LEGS);
	public static Item armorLeggingsAluminium    = new ItemArmor("ArmorLeggingsAluminium",    materialArmorAluminium,  0, EntityEquipmentSlot.LEGS);
	public static Item armorLeggingsBronze       = new ItemArmor("ArmorLeggingsBronze",       materialArmorBronze,     0, EntityEquipmentSlot.LEGS);
	public static Item armorLeggingsCopper       = new ItemArmor("ArmorLeggingsCopper",       materialArmorCopper,     0, EntityEquipmentSlot.LEGS);
	public static Item armorLeggingsLead         = new ItemArmor("ArmorLeggingsLead",         materialArmorLead,       0, EntityEquipmentSlot.LEGS);
	public static Item armorLeggingsMythril      = new ItemArmor("ArmorLeggingsMythril",      materialArmorMythril,    0, EntityEquipmentSlot.LEGS);
	public static Item armorLeggingsSteel        = new ItemArmor("ArmorLeggingsSteel",        materialArmorSteel,      0, EntityEquipmentSlot.LEGS);
	public static Item armorLeggingsUnobtanium   = new ItemArmor("ArmorLeggingsUnobtanium",   materialArmorUnobtanium, 0, EntityEquipmentSlot.LEGS);
	
	// Stuff
	public static Item stuffFur          = new ItemItem("StuffFur");
	public static Item stuffIvory        = new ItemItem("StuffIvory");
	public static Item stuffBeastShell   = new ItemItem("StuffBeastShell");
	public static Item stuffHemp         = new ItemItem("StuffHemp");
	public static Item stuffCotton       = new ItemItem("StuffCotton");
	public static Item stuffRope         = new ItemItem("StuffRope");
	public static Item stuffClothLinen   = new ItemItem("StuffClothLinen");
	public static Item stuffClothWool    = new ItemItem("StuffClothWool");
	public static Item stuffClothSilk    = new ItemItem("StuffClothSilk");
	public static Item stuffGear         = new ItemItem("StuffGear");
	public static Item stuffCoconutFull  = new ItemItem("StuffCoconutFull");
	public static Item stuffCoconutEmpty = new ItemItem("StuffCoconutEmpty");
	
	// Explosives
	public static Item explosiveDynamite = new ItemDynamite("ExplosiveDynamite");
	
	// Food
	public static Item foodCoconutFlesh   = new ItemFood("FoodCoconutFlesh",   2, 0.2F, false, false, false);
	public static Item foodGrandBeef      = new ItemFood("FoodGrandBeef",      4, 0.5F, false, false, false);
	public static Item foodGrandSteak     = new ItemFood("FoodGrandSteak",     8, 1.0F, false, false, false);
	public static Item foodVenisonRaw     = new ItemFood("FoodVenisonRaw",     2, 0.4F, false, false, false);
	public static Item foodVenisonCooked  = new ItemFood("FoodVenisonCooked",  6, 0.8F, false, false, false);
	public static Item foodVicugnaRaw     = new ItemFood("FoodVicugnaRaw",     3, 0.4F, false, false, false);
	public static Item foodVicugnaCooked  = new ItemFood("FoodVicugnaCooked",  6, 0.8F, false, false, false);
	public static Item foodCrabClawRaw    = new ItemFood("FoodCrabClawRaw",    2, 0.3F, false, false, false);
	public static Item foodCrabClawCooked = new ItemFood("FoodCrabClawCooked", 4, 0.6F, false, false, false);
	public static Item foodCalamariRaw    = new ItemFood("FoodCalamariRaw",    2, 0.3F, false, false, false);
	public static Item foodCalamariCooked = new ItemFood("FoodCalamariCooked", 4, 0.6F, false, false, false);
	public static Item foodBanana         = new ItemFood("FoodBanana",         2, 0.2F, false, false, false);
	public static Item foodLemon          = new ItemFood("FoodLemon",          1, 0.3F, false, false, false);
	public static Item foodCherry         = new ItemFood("FoodCherry",         1, 0.2F, false, false, false);
	public static Item foodOrange         = new ItemFood("FoodOrange",         2, 0.2F, false, false, false);
	public static Item foodPeach          = new ItemFood("FoodPeach",          2, 0.2F, false, false, false);
	public static Item foodCactusFruit    = new ItemFood("FoodCactusFruit",    1, 0.1F, false, false, false);
	public static Item foodTurnip         = new ItemFood("FoodTurnip",         2, 0.4F, false, false, false);
	public static Item foodGrapes         = new ItemFood("FoodGrapes",         1, 0.1F, false, false, false);
	public static Item foodOnion          = new ItemFood("FoodOnion",          2, 0.1F, false, false, false);
	public static Item foodPineapple      = new ItemFood("FoodPineapple",      3, 0.3F, false, false, false);
	public static Item foodTomato         = new ItemFood("FoodTomato",         2, 0.3F, false, false, false);
	public static Item foodCabbage        = new ItemFood("FoodCabbage",        2, 0.3F, false, false, false);
	public static Item foodRice           = new ItemFood("FoodRice",           3, 0.1F, false, false, false);
	public static Item foodMaise          = new ItemFood("FoodMaise",          2, 0.2F, false, false, false);
	public static Item foodCoffeeBeans    = new ItemFood("FoodCoffeeBeans",    1, 0.1F, false, false, false);
	public static Item foodCucumber       = new ItemFood("FoodCucumber",       1, 0.2F, false, false, false);
	public static Item foodCheeseWheel    = new ItemFood("FoodCheeseWheel",    8, 0.8F, false, false, false);
	public static Item foodCheese         = new ItemFood("FoodCheese",         2, 0.2F, false, false, false);
	
	// Dishes
	public static Item  dishRiceball         = new ItemDish("DishRiceball",         2, 0.2F, false, false, false, false, false);
	public static Item  dishRiceBowl         = new ItemDish("DishRiceBowl",         3, 0.2F, false, false, false, false, false);
	public static Item  dishSalad            = new ItemDish("DishSalad",           10, 1.5F, false, false, false, false, false);
	public static Item  dishFruitSalad       = new ItemDish("DishFruitSalad",       7, 0.7F, false, false, false, false, false);
	public static Item  dishBurger           = new ItemDish("DishBurger",          16, 1.8F, false, false, false, false, false);
	public static Item  dishCheeseBurger     = new ItemDish("DishCheeseBurger",    18, 2.0F, false, false, false, false, false);
	public static Item  dishKebab            = new ItemDish("DishKebab",           18, 1.9F, false, false, false, false, false);
	public static Item  dishDungeonFilet     = new ItemDish("DishDungeonFilet",     1, 0.1F, false, false, false, false, false);
	public static Item  dishStirFry          = new ItemDish("DishStirFry",          5, 0.6F, false, false, false, false, false);
	public static Item  dishFriedRice        = new ItemDish("DishFriedRice",        6, 0.6F, false, false, false, false, false);
	public static Item  dishSavoryPancake    = new ItemDish("DishSavoryPancake",    7, 0.8F, false, false, false, false, false);
	public static Item  dishFrenchFries      = new ItemDish("DishFrenchFries",      4, 0.6F, false, false, false, false, false);
	public static Item  dishCroquette        = new ItemDish("DishCroquette",        8, 0.9F, false, false, false, false, false);
	public static Item  dishPopcorn          = new ItemDish("DishPopcorn",          4, 0.4F, false, false, false, false, false);
	public static Item  dishCornflakes       = new ItemDish("DishCornflakes",       8, 0.8F, false, false, false, false, false);
	public static Item  dishScrambledEggs    = new ItemDish("DishScrambledEggs",    4, 0.4F, false, false, false, false, false);
	public static Item  dishOmelet           = new ItemDish("DishOmelet",           7, 0.7F, false, false, false, false, false);
	public static Item  dishOmeletRice       = new ItemDish("DishOmeletRice",      11, 0.9F, false, false, false, false, false);
	public static Item  dishAppleSouffle     = new ItemDish("DishAppleSouffle",     6, 0.5F, false, false, false, false, false);
	public static Item  dishCurryBread       = new ItemDish("DishCurryBread",       9, 0.9F, false, false, false, false, false);
	public static Item  dishFrenchToast      = new ItemDish("DishFrenchToast",      9, 0.9F, false, false, false, false, false);
	public static Item  dishDoughnut         = new ItemDish("DishDoughnut",         8, 0.8F, false, false, false, false, false);
	public static Item  dishGrilledFish      = new ItemDish("DishGrilledFish",      4, 0.4F, false, false, false, false, false);
	public static Item  dishFriedNoodles     = new ItemDish("DishFriedNoodles",     6, 0.6F, false, false, false, false, false);
	public static Item  dishTempura          = new ItemDish("DishTempura",          5, 0.5F, false, false, false, false, false);
	public static Item  dishPancake          = new ItemDish("DishPancake",          8, 0.8F, false, false, false, false, false);
	public static Item  dishPotSticker       = new ItemDish("DishPotSticker",       8, 0.8F, false, false, false, false, false);
	public static Item  dishRisotto          = new ItemDish("DishRisotto",         11, 0.9F, false, false, false, false, false);
	public static Item  dishDryCurry         = new ItemDish("DishDryCurry",         9, 0.7F, false, false, false, false, false);
	public static Item  dishPumpkinStew      = new ItemDish("DishPumpkinStew",      6, 0.6F, false, false, false, false, false);
	public static Item  dishFishStew         = new ItemDish("DishFishStew",         4, 0.4F, false, false, false, false, false);
	public static Item  dishBoiledEgg        = new ItemDish("DishBoiledEgg",        2, 0.2F, false, false, false, false, false);
	public static Item  dishDumplings        = new ItemDish("DishDumplings",        8, 0.8F, false, false, false, false, false);
	public static Item  dishCheeseFondue     = new ItemDish("DishCheeseFondue",     9, 0.9F, false, false, false, false, false);
	public static Item  dishNoodles          = new ItemDish("DishNoodles",          3, 0.3F, false, false, false, false, false);
	public static Item  dishCurryNoodles     = new ItemDish("DishCurryNoodles",     5, 0.5F, false, false, false, false, false);
	public static Item  dishTempuraNoodles   = new ItemDish("DishTempuraNoodles",   9, 0.9F, false, false, false, false, false);
	public static Item  dishMountainStew     = new ItemDish("DishMountainStew",     8, 1.0F, false, false, false, false, false);
	public static Item  dishRiceSoup         = new ItemDish("DishRiceSoup",         8, 0.4F, false, false, false, false, false);
	public static Item  dishPorridge         = new ItemDish("DishPorridge",        11, 0.7F, false, false, false, false, false);
	public static Item  dishTempuraRice      = new ItemDish("DishTempuraRice",     13, 0.9F, false, false, false, false, false);
	public static Item  dishEggOverRice      = new ItemDish("DishEggOverRice",      9, 0.5F, false, false, false, false, false);
	public static Item  dishStew             = new ItemDish("DishStew",             6, 0.6F, false, false, false, false, false);
	public static Item  dishCurryRice        = new ItemDish("DishCurryRice",        9, 0.5F, false, false, false, false, false);
	public static Item  dishBakedCorn        = new ItemDish("DishBakedCorn",        3, 0.3F, false, false, false, false, false);
	public static Item  dishToastedRiceBall  = new ItemDish("DishToastedRiceBall",  7, 0.3F, false, false, false, false, false);
	public static Item  dishToast            = new ItemDish("DishToast",            6, 0.6F, false, false, false, false, false);
	public static Item  dishDinnerRoll       = new ItemDish("DishDinnerRoll",       5, 0.5F, false, false, false, false, false);
	public static Block dishPizza            = new BlockPizza("DishPizza");
	public static Item  dishDoria            = new ItemDish("DishDoria",           13, 0.8F, false, false, false, false, false);
	public static Item  dishGratin           = new ItemDish("DishGratin",           9, 0.8F, false, false, false, false, false);
	public static Block dishChocolateCake    = new BlockCake("DishChocolateCake");
	public static Block dishCheesecake       = new BlockCake("DishCheesecake");
	public static Block dishApplePie         = new BlockCake("DishApplePie");
	public static Item  dishSteamedBun       = new ItemDish("DishSteamedBun",       4, 0.4F, false, false, false, false, false);
	public static Item  dishCheeseSteamedBun = new ItemDish("DishCheeseSteamedBun", 6, 0.6F, false, false, false, false, false);
	public static Item  dishShaomi           = new ItemDish("DishShaomi",           8, 0.8F, false, false, false, false, false);
	public static Item  dishSteamedEgg       = new ItemDish("DishSteamedEgg",       5, 0.5F, false, false, false, false, false);
	public static Item  dishChineseBun       = new ItemDish("DishChineseBun",       9, 1.1F, false, false, false, false, false);
	public static Item  dishCurryBun         = new ItemDish("DishCurryBun",         4, 0.4F, false, false, false, false, false);
	public static Item  dishSteamedDumplings = new ItemDish("DishSteamedDumplings", 8, 0.8F, false, false, false, false, false);
	public static Item  dishSpongeCake       = new ItemDish("DishSpongeCake",       4, 0.4F, false, false, false, false, false);
	public static Item  dishSteamedCake      = new ItemDish("DishSteamedCake",      7, 0.7F, false, false, false, false, false);
	public static Item  dishPudding          = new ItemDish("DishPudding",          6, 0.6F, false, false, false, false, false);
	public static Item  dishPumpkinPudding   = new ItemDish("DishPumpkinPudding",   9, 0.9F, false, false, false, false, false);
	public static Item  dishSandwich         = new ItemDish("DishSandwich",        11, 1.3F, false, false, false, false, false);
	public static Item  dishFruitSandwich    = new ItemDish("DishFruitSandwich",   11, 1.1F, false, false, false, false, false);
	public static Item  dishPickledTurnip    = new ItemDish("DishPickledTurnip",    3, 0.6F, false, false, false, false, false);
	public static Item  dishPickledCucumber  = new ItemDish("DishPickledCucumber",  2, 0.3F, false, false, false, false, false);
	public static Item  dishBambooRice       = new ItemDish("DishBambooRice",       7, 0.3F, false, false, false, false, false);
	public static Item  dishMushroomRice     = new ItemDish("DishMushroomRice",     9, 0.4F, false, false, false, false, false);
	public static Item  dishSushi            = new ItemDish("DishSushi",            9, 0.5F, false, false, false, false, false);
	public static Item  dishRaisinBread      = new ItemDish("DishRaisinBread",      6, 0.6F, false, false, false, false, false);
	public static Item  dishSashimi          = new ItemDish("DishSashimi",          3, 0.3F, false, false, false, false, false);
	public static Item  dishChirashiSushi    = new ItemDish("DishChirashiSushi",    3, 0.3F, false, false, false, false, false);
	public static Item  dishIceCream         = new ItemDish("DishIceCream",        18, 1.7F, false, false, false, false, false);
	public static Item  dishSeaSaltIceCream  = new ItemDish("DishSeaSaltIceCream",  7, 0.7F, false, false, false, false, false);
	public static Item  dishKrabbyPatty      = new ItemDish("DishKrabbyPatty",     20, 2.0F, false, false, false, false, false);
	
	// Juice
	public static Item juiceOil           = new ItemDrink("JuiceOil",           1, 0.1F, false);
	public static Item juiceApple         = new ItemDrink("JuiceApple",         3, 0.2F, false);
	public static Item juiceBanana        = new ItemDrink("JuiceBanana",        3, 0.2F, false);
	public static Item juiceCactus        = new ItemDrink("JuiceCactus",        3, 0.2F, false);
	public static Item juiceCherry        = new ItemDrink("JuiceCherry",        3, 0.2F, false);
	public static Item juiceChocolateMilk = new ItemDrink("JuiceChocolateMilk", 3, 0.3F, false);
	public static Item juiceCoconutMilk   = new ItemDrink("JuiceCoconutMilk",   3, 0.3F, false);
	public static Item juiceCoffee        = new ItemDrink("JuiceCoffee",        2, 0.2F, false);
	public static Item juiceGrapes        = new ItemDrink("JuiceGrapes",        3, 0.2F, false);
	public static Item juiceLemon         = new ItemDrink("JuiceLemon",         3, 0.2F, false);
	public static Item juiceMilk          = new ItemDrink("JuiceMilk",          3, 0.3F, false);
	public static Item juiceOrange        = new ItemDrink("JuiceOrange",        3, 0.2F, false);
	public static Item juicePeach         = new ItemDrink("JuicePeach",         3, 0.2F, false);
	public static Item juicePineapple     = new ItemDrink("JuicePineapple",     3, 0.2F, false);
	public static Item juiceTomato        = new ItemDrink("JuiceTomato",        3, 0.2F, false);
	
	// Liquor
	public static Item liquorCoconutRum    = new ItemDrink("LiquorCoconutRum",    1, 0.1F, false);
	public static Item liquorCider         = new ItemDrink("LiquorCider",         1, 0.1F, false);
	public static Item liquorRum           = new ItemDrink("LiquorRum",           1, 0.1F, false);
	public static Item liquorBeer          = new ItemDrink("LiquorBeer",          1, 0.1F, false);
	public static Item liquorSalgam        = new ItemDrink("LiquorSalgam",        1, 0.1F, false);
	public static Item liquorVodka         = new ItemDrink("LiquorVodka",         1, 0.1F, false);
	public static Item liquorCactusJack    = new ItemDrink("LiquorCactusJack",    1, 0.1F, false);
	public static Item liquorSake          = new ItemDrink("LiquorSake",          1, 0.1F, false);
	public static Item liquorMead          = new ItemDrink("LiquorMead",          1, 0.1F, false);
	public static Item liquorWineGrapes    = new ItemDrink("LiquorWineGrapes",    2, 0.1F, false);
	public static Item liquorWineCherry    = new ItemDrink("LiquorWineCherry",    2, 0.1F, false);
	public static Item liquorWinePineapple = new ItemDrink("LiquorWinePineapple", 2, 0.1F, false);
	
	// Crops
	public static Block cropTurnip;
	public static Block cropGrapes;
	public static Block cropOnion;
	public static Block cropPineapple;
	public static Block cropTomato;
	public static Block cropCabbage;
	public static Block cropRice;
	public static Block cropMaise;
	public static Block cropCoffeeBeans;
	public static Block cropCucumber;
	public static Block cropGoldenCarrot;
	public static Block cropHemp;
	public static Block cropCotton;
	public static Block cropCoconut;
	public static Block cropBanana;
	
	// Seeds
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
	public static Item seedsCucumber;
	public static Item seedsHemp;
	public static Item seedsCotton;
	
	// Beds
	public static Block bedBlockBlack;
	public static Block bedBlockRed;
	public static Block bedBlockGreen;
	public static Block bedBlockBrown;
	public static Block bedBlockBlue;
	public static Block bedBlockPurple;
	public static Block bedBlockCyan;
	public static Block bedBlockSilver;
	public static Block bedBlockGrey;
	public static Block bedBlockPink;
	public static Block bedBlockLime;
	public static Block bedBlockYellow;
	public static Block bedBlockLightBlue;
	public static Block bedBlockMagenta;
	public static Block bedBlockOrange;
	public static Block bedBlockWhite;
	public static Item  bedItemBlack;
	public static Item  bedItemRed;
	public static Item  bedItemGreen;
	public static Item  bedItemBrown;
	public static Item  bedItemBlue;
	public static Item  bedItemPurple;
	public static Item  bedItemCyan;
	public static Item  bedItemSilver;
	public static Item  bedItemGrey;
	public static Item  bedItemPink;
	public static Item  bedItemLime;
	public static Item  bedItemYellow;
	public static Item  bedItemLightBlue;
	public static Item  bedItemMagenta;
	public static Item  bedItemOrange;
	public static Item  bedItemWhite;
	
	// Buckets
	
	// Machina
	
	// Scaffolding
	
	// Roof
	
	public static void init(){
		// Crops
		cropTurnip       = new BlockCrop("CropTurnip",       foodTurnip);
		cropGrapes       = new BlockCrop("CropGrapes",       foodGrapes);
		cropOnion        = new BlockCrop("CropOnion",        foodOnion);
		cropPineapple    = new BlockCrop("CropPineapple",    foodPineapple);
		cropTomato       = new BlockCrop("CropTomato",       foodTomato);
		cropCabbage      = new BlockCrop("CropCabbage",      foodCabbage);
		cropRice         = new BlockCrop("CropRice",         foodRice);
		cropMaise        = new BlockCrop("CropMaise",        foodMaise);
		cropCoffeeBeans  = new BlockCrop("CropCoffeeBeans",  foodCoffeeBeans);
		cropCucumber     = new BlockCrop("CropCucumber",     foodCucumber);
		cropGoldenCarrot = new BlockCrop("CropGoldenCarrot", Items.golden_carrot);
		cropHemp         = new BlockCrop("CropHemp",         stuffHemp);
		cropCotton       = new BlockCrop("CropCotton",       stuffCotton);
		cropCoconut      = new BlockCrop("CropCoconut",      stuffCoconutFull);
		cropBanana       = new BlockCrop("CropBanana",       foodBanana);
		
		// Seeds
		seedsWild        = new ItemSeedWild("SeedsWild");
		seedsTurnip      = new ItemSeed("SeedsTurnip",      cropTurnip,      Blocks.farmland); ((BlockCrop) cropTurnip).setSeed(seedsTurnip);
		seedsGrapes      = new ItemSeed("SeedsGrapes",      cropGrapes,      Blocks.farmland); ((BlockCrop) cropGrapes).setSeed(seedsGrapes);
		seedsOnion       = new ItemSeed("SeedsOnion",       cropOnion,       Blocks.farmland); ((BlockCrop) cropOnion).setSeed(seedsOnion);
		seedsPineapple   = new ItemSeed("SeedsPineapple",   cropPineapple,   Blocks.farmland); ((BlockCrop) cropPineapple).setSeed(seedsPineapple);
		seedsTomato      = new ItemSeed("SeedsTomato",      cropTomato,      Blocks.farmland); ((BlockCrop) cropTomato).setSeed(seedsTomato);
		seedsCabbage     = new ItemSeed("SeedsCabbage",     cropCabbage,     Blocks.farmland); ((BlockCrop) cropCabbage).setSeed(seedsCabbage);
		seedsRice        = new ItemSeed("SeedsRice",        cropRice,        Blocks.farmland); ((BlockCrop) cropRice).setSeed(seedsRice);
		seedsMaise       = new ItemSeed("SeedsMaise",       cropMaise,       Blocks.farmland); ((BlockCrop) cropMaise).setSeed(seedsMaise);
		seedsCoffeeBeans = new ItemSeed("SeedsCoffeeBeans", cropCoffeeBeans, Blocks.farmland); ((BlockCrop) cropCoffeeBeans).setSeed(seedsCoffeeBeans);
		seedsCucumber    = new ItemSeed("SeedsCucumber",    cropCucumber,    Blocks.farmland); ((BlockCrop) cropCucumber).setSeed(seedsCucumber);
		seedsHemp        = new ItemSeed("SeedsHemp",        cropHemp,        Blocks.farmland); ((BlockCrop) cropHemp).setSeed(seedsHemp);
		seedsCotton      = new ItemSeed("SeedsCotton",      cropCotton,      Blocks.farmland); ((BlockCrop) cropCotton).setSeed(seedsCotton);
		((BlockCrop) cropGoldenCarrot).setSeed(Items.golden_carrot);
		((BlockCrop) cropCoconut).setSeed(stuffCoconutFull);
		((BlockCrop) cropBanana).setSeed(foodBanana);
		
		MinecraftForge.addGrassSeed(new ItemStack(seedsWild), 10000000);
		
		bedBlockBlack     = new BlockBed("BedBlockBlack");
		bedBlockRed       = new BlockBed("BedBlockRed");
		bedBlockGreen     = new BlockBed("BedBlockGreen");
		bedBlockBrown     = new BlockBed("BedBlockBrown");
		bedBlockBlue      = new BlockBed("BedBlockBlue");
		bedBlockPurple    = new BlockBed("BedBlockPurple");
		bedBlockCyan      = new BlockBed("BedBlockCyan");
		bedBlockSilver    = new BlockBed("BedBlockSilver");
		bedBlockGrey      = new BlockBed("BedBlockGrey");
		bedBlockPink      = new BlockBed("BedBlockPink");
		bedBlockLime      = new BlockBed("BedBlockLime");
		bedBlockYellow    = new BlockBed("BedBlockYellow");
		bedBlockLightBlue = new BlockBed("BedBlockLightBlue");
		bedBlockMagenta   = new BlockBed("BedBlockMagenta");
		bedBlockOrange    = new BlockBed("BedBlockOrange");
		bedBlockWhite     = new BlockBed("BedBlockWhite");
		bedItemBlack      = new ItemBed("BedItemBlack",       bedBlockBlack);     ((BlockBed) bedBlockBlack).setItem(bedItemBlack);
		bedItemRed        = new ItemBed("BedItemRed",         bedBlockRed);       ((BlockBed) bedBlockRed).setItem(bedItemRed);
		bedItemGreen      = new ItemBed("BedItemGreen",       bedBlockGreen);     ((BlockBed) bedBlockGreen).setItem(bedItemGreen);
		bedItemBrown      = new ItemBed("BedItemBrown",       bedBlockBrown);     ((BlockBed) bedBlockBrown).setItem(bedItemBrown);
		bedItemBlue       = new ItemBed("BedItemBlue",        bedBlockBlue);      ((BlockBed) bedBlockBlue).setItem(bedItemBlue);
		bedItemPurple     = new ItemBed("BedItemPurple",      bedBlockPurple);    ((BlockBed) bedBlockPurple).setItem(bedItemPurple);
		bedItemCyan       = new ItemBed("BedItemCyan",        bedBlockCyan);      ((BlockBed) bedBlockCyan).setItem(bedItemCyan);
		bedItemSilver     = new ItemBed("BedItemSilver",      bedBlockSilver);    ((BlockBed) bedBlockSilver).setItem(bedItemSilver);
		bedItemGrey       = new ItemBed("BedItemGrey",        bedBlockGrey);      ((BlockBed) bedBlockGrey).setItem(bedItemGrey);
		bedItemPink       = new ItemBed("BedItemPink",        bedBlockPink);      ((BlockBed) bedBlockPink).setItem(bedItemPink);
		bedItemLime       = new ItemBed("BedItemLime",        bedBlockLime);      ((BlockBed) bedBlockLime).setItem(bedItemLime);
		bedItemYellow     = new ItemBed("BedItemYellow",      bedBlockYellow);    ((BlockBed) bedBlockYellow).setItem(bedItemYellow);
		bedItemLightBlue  = new ItemBed("BedItemLightBlue",   bedBlockLightBlue); ((BlockBed) bedBlockLightBlue).setItem(bedItemLightBlue);
		bedItemMagenta    = new ItemBed("BedItemMagenta",     bedBlockMagenta);   ((BlockBed) bedBlockMagenta).setItem(bedItemMagenta);
		bedItemOrange     = new ItemBed("BedItemOrange",      bedBlockOrange);    ((BlockBed) bedBlockOrange).setItem(bedItemOrange);
		bedItemWhite      = new ItemBed("BedItemWhite",       bedBlockWhite);     ((BlockBed) bedBlockWhite).setItem(bedItemWhite);
	}
	
	public static void registerStuff(boolean pre){
		
		// Full Blocks
		registerBlock(blockAdamantium, pre);
		registerBlock(blockAluminium, pre);
		registerBlock(blockAmethyst, pre);
		registerBlock(blockAquamarine, pre);
		registerBlock(blockBeryl, pre);
		registerBlock(blockBrass, pre);
		registerBlock(blockCoffee, pre);
		registerBlock(blockCopper, pre);
		registerBlock(blockFlour, pre);
		registerBlock(blockGagat, pre);
		registerBlock(blockIridium, pre);
		registerBlock(blockLead, pre);
		registerBlock(blockMeteor, pre);
		registerBlock(blockMythril, pre);
		registerBlock(blockOpal, pre);
		registerBlock(blockOrichalcum, pre);
		registerBlock(blockRuby, pre);
		registerBlock(blockSalt, pre);
		registerBlock(blockSaphire, pre);
		registerBlock(blockSilver, pre);
		registerBlock(blockSteel, pre);
		registerBlock(blockSulfur, pre);
		registerBlock(blockTin, pre);
		registerBlock(blockTopaz, pre);
		registerBlock(blockTourmaline, pre);
		registerBlock(blockUnobtanium, pre);
		registerBlock(blockZinc, pre);
		
		// Ore Blocks
		registerBlock(oreAdamantium, pre);
		registerBlock(oreAmethyst, pre);
		registerBlock(oreAquamarine, pre);
		registerBlock(oreBauxite, pre);
		registerBlock(oreBeryl, pre);
		registerBlock(oreCopper, pre);
		registerBlock(oreIridium, pre);
		registerBlock(oreLead, pre);
		registerBlock(oreMythril, pre);
		registerBlock(oreOpal, pre);
		registerBlock(oreOrichalcum, pre);
		registerBlock(oreRuby, pre);
		registerBlock(oreSalt, pre);
		registerBlock(oreSaphire, pre);
		registerBlock(oreSilver, pre);
		registerBlock(oreSulfur, pre);
		registerBlock(oreTin, pre);
		registerBlock(oreTopaz, pre);
		registerBlock(oreTourmaline, pre);
		registerBlock(oreUnobtanium, pre);
		registerBlock(oreZinc, pre);
		registerBlock(oreGagat, pre);
		
		// Armor
		registerItem(armorBootsAdamantium, pre);
		registerItem(armorBootsAluminium, pre);
		registerItem(armorBootsBronze, pre);
		registerItem(armorBootsCopper, pre);
		registerItem(armorBootsLead, pre);
		registerItem(armorBootsMythril, pre);
		registerItem(armorBootsSteel, pre);
		registerItem(armorBootsUnobtanium, pre);
		registerItem(armorChestplateAdamantium, pre);
		registerItem(armorChestplateAluminium, pre);
		registerItem(armorChestplateBronze, pre);
		registerItem(armorChestplateCopper, pre);
		registerItem(armorChestplateLead, pre);
		registerItem(armorChestplateMythril, pre);
		registerItem(armorChestplateSteel, pre);
		registerItem(armorChestplateUnobtanium, pre);
		registerItem(armorHelmetAdamantium, pre);
		registerItem(armorHelmetAluminium, pre);
		registerItem(armorHelmetBronze, pre);
		registerItem(armorHelmetCopper, pre);
		registerItem(armorHelmetLead, pre);
		registerItem(armorHelmetMythril, pre);
		registerItem(armorHelmetSteel, pre);
		registerItem(armorHelmetUnobtanium, pre);
		registerItem(armorLeggingsAdamantium, pre);
		registerItem(armorLeggingsAluminium, pre);
		registerItem(armorLeggingsBronze, pre);
		registerItem(armorLeggingsCopper, pre);
		registerItem(armorLeggingsLead, pre);
		registerItem(armorLeggingsMythril, pre);
		registerItem(armorLeggingsSteel, pre);
		registerItem(armorLeggingsUnobtanium, pre);
		
		// Gemstones
		registerItem(gemAmethyst, pre);
		registerItem(gemAquamarine, pre);
		registerItem(gemBeryl, pre);
		registerItem(gemGagat, pre);
		registerItem(gemOpal, pre);
		registerItem(gemRuby, pre);
		registerItem(gemSaphire, pre);
		registerItem(gemTopaz, pre);
		registerItem(gemTourmaline, pre);
		
		// Ingots
		registerItem(ingotAdamantium, pre);
		registerItem(ingotAluminium, pre);
		registerItem(ingotBrass, pre);
		registerItem(ingotBronze, pre);
		registerItem(ingotCopper, pre);
		registerItem(ingotLead, pre);
		registerItem(ingotMythril, pre);
		registerItem(ingotOrichalcum, pre);
		registerItem(ingotSilver, pre);
		registerItem(ingotSteel, pre);
		registerItem(ingotTin, pre);
		registerItem(ingotUnobtanium, pre);
		registerItem(ingotZinc, pre);
		
		// Nuggets
		registerItem(nuggetAdamantium, pre);
		registerItem(nuggetBauxite, pre);
		registerItem(nuggetCopper, pre);
		registerItem(nuggetGold, pre);
		registerItem(nuggetIridium, pre);
		registerItem(nuggetIron, pre);
		registerItem(nuggetLead, pre);
		registerItem(nuggetMythril, pre);
		registerItem(nuggetOrichalcum, pre);
		registerItem(nuggetSilver, pre);
		registerItem(nuggetTin, pre);
		registerItem(nuggetUnobtanium, pre);
		registerItem(nuggetZinc, pre);
		
		// Powders
		registerItem(powderCoffee, pre);
		registerItem(powderFlour, pre);
		registerItem(powderOrichalcum, pre);
		registerItem(powderSalt, pre);
		registerItem(powderSulfur, pre);
		
		// Tools
		registerItem(toolAxeAdamantium, pre);
		registerItem(toolAxeBronze, pre);
		registerItem(toolAxeCopper, pre);
		registerItem(toolAxeFlint, pre);
		registerItem(toolAxeIridium, pre);
		registerItem(toolAxeMythril, pre);
		registerItem(toolAxeObsidian, pre);
		registerItem(toolAxeSteel, pre);
		registerItem(toolAxeUnobtanium, pre);
		registerItem(toolFryingPan, pre);
		registerItem(toolHammerAdamantium, pre);
		registerItem(toolHammerBronze, pre);
		registerItem(toolHammerCopper, pre);
		registerItem(toolHammerFlint, pre);
		registerItem(toolHammerGold, pre);
		registerItem(toolHammerIridium, pre);
		registerItem(toolHammerIron, pre);
		registerItem(toolHammerMythril, pre);
		registerItem(toolHammerObsidian, pre);
		registerItem(toolHammerSteel, pre);
		registerItem(toolHammerUnobtanium, pre);
		registerItem(toolHoeAdamantium, pre);
		registerItem(toolHoeBronze, pre);
		registerItem(toolHoeCopper, pre);
		registerItem(toolHoeFlint, pre);
		registerItem(toolHoeIridium, pre);
		registerItem(toolHoeMythril, pre);
		registerItem(toolHoeObsidian, pre);
		registerItem(toolHoeSteel, pre);
		registerItem(toolHoeUnobtanium, pre);
		registerItem(toolPickaxeAdamantium, pre);
		registerItem(toolPickaxeBronze, pre);
		registerItem(toolPickaxeCopper, pre);
		registerItem(toolPickaxeFlint, pre);
		registerItem(toolPickaxeIridium, pre);
		registerItem(toolPickaxeMythril, pre);
		registerItem(toolPickaxeObsidian, pre);
		registerItem(toolPickaxeSteel, pre);
		registerItem(toolPickaxeUnobtanium, pre);
		registerItem(toolShovelAdamantium, pre);
		registerItem(toolShovelBronze, pre);
		registerItem(toolShovelCopper, pre);
		registerItem(toolShovelFlint, pre);
		registerItem(toolShovelIridium, pre);
		registerItem(toolShovelMythril, pre);
		registerItem(toolShovelObsidian, pre);
		registerItem(toolShovelSteel, pre);
		registerItem(toolShovelUnobtanium, pre);
		registerItem(toolSpearAdamantium, pre);
		registerItem(toolSpearBronze, pre);
		registerItem(toolSpearCopper, pre);
		registerItem(toolSpearFlint, pre);
		registerItem(toolSpearGold, pre);
		registerItem(toolSpearIridium, pre);
		registerItem(toolSpearIron, pre);
		registerItem(toolSpearMythril, pre);
		registerItem(toolSpearObsidian, pre);
		registerItem(toolSpearSteel, pre);
		registerItem(toolSpearUnobtanium, pre);
		registerItem(toolSwordAdamantium, pre);
		registerItem(toolSwordBronze, pre);
		registerItem(toolSwordCopper, pre);
		registerItem(toolSwordFlint, pre);
		registerItem(toolSwordIridium, pre);
		registerItem(toolSwordMythril, pre);
		registerItem(toolSwordObsidian, pre);
		registerItem(toolSwordSteel, pre);
		registerItem(toolSwordUnobtanium, pre);
		
		// Minos
		registerBlock(minoBlank, pre);
		registerBlock(minoFire, pre);
		registerBlock(minoAir, pre);
		registerBlock(minoThunder, pre);
		registerBlock(minoWater, pre);
		registerBlock(minoIce, pre);
		registerBlock(minoEarth, pre);
		registerBlock(minoMetal, pre);
		registerBlock(minoNature, pre);
		registerBlock(minoLight, pre);
		registerBlock(minoDark, pre);
		
		// Stuff
		registerItem(stuffFur, pre);
		registerItem(stuffIvory, pre);
		registerItem(stuffBeastShell, pre);
		registerItem(stuffHemp, pre);
		registerItem(stuffCotton, pre);
		registerItem(stuffRope, pre);
		registerItem(stuffClothLinen, pre);
		registerItem(stuffClothWool, pre);
		registerItem(stuffClothSilk, pre);
		registerItem(stuffGear, pre);
		registerItem(stuffCoconutFull, pre);
		registerItem(stuffCoconutEmpty, pre);
		
		// Explosives
		registerItem(explosiveDynamite, pre);
		
		// Food
		registerItem(foodCoconutFlesh, pre);
		registerItem(foodGrandBeef, pre);
		registerItem(foodGrandSteak, pre);
		registerItem(foodVenisonRaw, pre);
		registerItem(foodVenisonCooked, pre);
		registerItem(foodVicugnaRaw, pre);
		registerItem(foodVicugnaCooked, pre);
		registerItem(foodCrabClawRaw, pre);
		registerItem(foodCrabClawCooked, pre);
		registerItem(foodCalamariRaw, pre);
		registerItem(foodCalamariCooked, pre);
		registerItem(foodBanana, pre);
		registerItem(foodLemon, pre);
		registerItem(foodCherry, pre);
		registerItem(foodOrange, pre);
		registerItem(foodPeach, pre);
		registerItem(foodCactusFruit, pre);
		registerItem(foodTurnip, pre);
		registerItem(foodGrapes, pre);
		registerItem(foodOnion, pre);
		registerItem(foodPineapple, pre);
		registerItem(foodTomato, pre);
		registerItem(foodCabbage, pre);
		registerItem(foodRice, pre);
		registerItem(foodMaise, pre);
		registerItem(foodCoffeeBeans, pre);
		registerItem(foodCucumber, pre);
		registerItem(foodCheeseWheel, pre);
		registerItem(foodCheese, pre);
		
		// Dishes
		registerItem(dishRiceball, pre);
		registerItem(dishRiceBowl, pre);
		registerItem(dishSalad, pre);
		registerItem(dishFruitSalad, pre);
		registerItem(dishBurger, pre);
		registerItem(dishCheeseBurger, pre);
		registerItem(dishKebab, pre);
		registerItem(dishDungeonFilet, pre);
		registerItem(dishStirFry, pre);
		registerItem(dishFriedRice, pre);
		registerItem(dishSavoryPancake, pre);
		registerItem(dishFrenchFries, pre);
		registerItem(dishCroquette, pre);
		registerItem(dishPopcorn, pre);
		registerItem(dishCornflakes, pre);
		registerItem(dishScrambledEggs, pre);
		registerItem(dishOmelet, pre);
		registerItem(dishOmeletRice, pre);
		registerItem(dishAppleSouffle, pre);
		registerItem(dishCurryBread, pre);
		registerItem(dishFrenchToast, pre);
		registerItem(dishDoughnut, pre);
		registerItem(dishFriedNoodles, pre);
		registerItem(dishTempura, pre);
		registerItem(dishPancake, pre);
		registerItem(dishPotSticker, pre);
		registerItem(dishRisotto, pre);
		registerItem(dishDryCurry, pre);
		registerItem(dishPumpkinStew, pre);
		registerItem(dishFishStew, pre);
		registerItem(dishBoiledEgg, pre);
		registerItem(dishDumplings, pre);
		registerItem(dishCheeseFondue, pre);
		registerItem(dishNoodles, pre);
		registerItem(dishCurryNoodles, pre);
		registerItem(dishTempuraNoodles, pre);
		registerItem(dishMountainStew, pre);
		registerItem(dishRiceSoup, pre);
		registerItem(dishPorridge, pre);
		registerItem(dishTempuraRice, pre);
		registerItem(dishEggOverRice, pre);
		registerItem(dishStew, pre);
		registerItem(dishCurryRice, pre);
		registerItem(dishBakedCorn, pre);
		registerItem(dishToastedRiceBall, pre);
		registerItem(dishToast, pre);
		registerItem(dishDinnerRoll, pre);
		registerBlock(dishPizza, pre);
		registerItem(dishDoria, pre);
		registerItem(dishGratin, pre);
		registerBlock(dishChocolateCake, pre);
		registerBlock(dishCheesecake, pre);
		registerBlock(dishApplePie, pre);
		registerItem(dishSteamedBun, pre);
		registerItem(dishCheeseSteamedBun, pre);
		registerItem(dishShaomi, pre);
		registerItem(dishSteamedEgg, pre);
		registerItem(dishChineseBun, pre);
		registerItem(dishCurryBun, pre);
		registerItem(dishSteamedDumplings, pre);
		registerItem(dishSpongeCake, pre);
		registerItem(dishSteamedCake, pre);
		registerItem(dishPudding, pre);
		registerItem(dishPumpkinPudding, pre);
		registerItem(dishSandwich, pre);
		registerItem(dishFruitSandwich, pre);
		registerItem(dishPickledTurnip, pre);
		registerItem(dishPickledCucumber, pre);
		registerItem(dishBambooRice, pre);
		registerItem(dishMushroomRice, pre);
		registerItem(dishSushi, pre);
		registerItem(dishRaisinBread, pre);
		registerItem(dishSashimi, pre);
		registerItem(dishChirashiSushi, pre);
		registerItem(dishIceCream, pre);
		registerItem(dishSeaSaltIceCream, pre);
		registerItem(dishKrabbyPatty, pre);
		
		// Juice
		registerItem(juiceOil, pre);
		registerItem(juiceApple, pre);
		registerItem(juiceBanana, pre);
		registerItem(juiceCactus, pre);
		registerItem(juiceCherry, pre);
		registerItem(juiceChocolateMilk, pre);
		registerItem(juiceCoconutMilk, pre);
		registerItem(juiceCoffee, pre);
		registerItem(juiceGrapes, pre);
		registerItem(juiceLemon, pre);
		registerItem(juiceMilk, pre);
		registerItem(juiceOrange, pre);
		registerItem(juicePeach, pre);
		registerItem(juicePineapple, pre);
		registerItem(juiceTomato, pre);
		
		// Liquor
		registerItem(liquorCoconutRum, pre);
		registerItem(liquorCider, pre);
		registerItem(liquorRum, pre);
		registerItem(liquorBeer, pre);
		registerItem(liquorSalgam, pre);
		registerItem(liquorVodka, pre);
		registerItem(liquorCactusJack, pre);
		registerItem(liquorSake, pre);
		registerItem(liquorMead, pre);
		registerItem(liquorWineGrapes, pre);
		registerItem(liquorWineCherry, pre);
		registerItem(liquorWinePineapple, pre);
		
		// Crops
		registerBlock(cropTurnip, pre);
		registerBlock(cropGrapes, pre);
		registerBlock(cropOnion, pre);
		registerBlock(cropPineapple, pre);
		registerBlock(cropTomato, pre);
		registerBlock(cropCabbage, pre);
		registerBlock(cropRice, pre);
		registerBlock(cropMaise, pre);
		registerBlock(cropCoffeeBeans, pre);
		registerBlock(cropCucumber, pre);
		registerBlock(cropGoldenCarrot, pre);
		registerBlock(cropHemp, pre);
		registerBlock(cropCotton, pre);
		registerBlock(cropCoconut, pre);
		registerBlock(cropBanana, pre);
		
		// Seeds
		registerItem(seedsWild, pre);
		registerItem(seedsTurnip, pre);
		registerItem(seedsGrapes, pre);
		registerItem(seedsOnion, pre);
		registerItem(seedsPineapple, pre);
		registerItem(seedsTomato, pre);
		registerItem(seedsCabbage, pre);
		registerItem(seedsRice, pre);
		registerItem(seedsMaise, pre);
		registerItem(seedsCoffeeBeans, pre);
		registerItem(seedsCucumber, pre);
		registerItem(seedsHemp, pre);
		registerItem(seedsCotton, pre);
		
		// Beds
		registerBlock(bedBlockBlack, pre);
		registerBlock(bedBlockRed, pre);
		registerBlock(bedBlockGreen, pre);
		registerBlock(bedBlockBrown, pre);
		registerBlock(bedBlockBlue, pre);
		registerBlock(bedBlockPurple, pre);
		registerBlock(bedBlockCyan, pre);
		registerBlock(bedBlockSilver, pre);
		registerBlock(bedBlockGrey, pre);
		registerBlock(bedBlockPink, pre);
		registerBlock(bedBlockLime, pre);
		registerBlock(bedBlockYellow, pre);
		registerBlock(bedBlockLightBlue, pre);
		registerBlock(bedBlockMagenta, pre);
		registerBlock(bedBlockOrange, pre);
		registerBlock(bedBlockWhite, pre);
		registerItem(bedItemBlack, pre);
		registerItem(bedItemRed, pre);
		registerItem(bedItemGreen, pre);
		registerItem(bedItemBrown, pre);
		registerItem(bedItemBlue, pre);
		registerItem(bedItemPurple, pre);
		registerItem(bedItemCyan, pre);
		registerItem(bedItemSilver, pre);
		registerItem(bedItemGrey, pre);
		registerItem(bedItemPink, pre);
		registerItem(bedItemLime, pre);
		registerItem(bedItemYellow, pre);
		registerItem(bedItemLightBlue, pre);
		registerItem(bedItemMagenta, pre);
		registerItem(bedItemOrange, pre);
		registerItem(bedItemWhite, pre);
	}
	
	public static void registerEntities(){
		EntityRegistry.registerModEntity(EntityNugget.class, "EntityNugget", 0, AceCraft.instance, 64, 20, true);
		EntityRegistry.registerModEntity(EntityDynamite.class, "EntityDynamite", 0, AceCraft.instance, 64, 20, true);
		EntityRegistry.registerModEntity(EntitySpear.class, "EntitySpear", 0, AceCraft.instance, 64, 20, true);
	}
	
	public static void registerRenderers(){
		
	}
	
	public static void registerRecipes(){
		GameRegistry.addRecipe(new ItemStack(blockCopper), new Object[]{"###","###","###",'#',ingotCopper});
		GameRegistry.addShapelessRecipe(new ItemStack(ingotCopper, 9), new Object[]{blockCopper});
	}
	
	public static void registerSmelting(){
		GameRegistry.addSmelting(oreCopper, new ItemStack(ingotCopper), 0);
		GameRegistry.addSmelting(nuggetCopper, new ItemStack(ingotCopper), 0);
	}
	
	private static void registerBlock(Block block, boolean pre){
		if(pre){
			GameRegistry.register(block);
			GameRegistry.register(new ItemBlock(block).setUnlocalizedName(block.getUnlocalizedName().substring(5)).setRegistryName(block.getRegistryName()));
		}else{
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(AceCraft.modid + ":" + block.getUnlocalizedName().substring(5), "inventory"));
		}
	}
	
	private static void registerItem(Item item, boolean pre){
		if(pre){
			GameRegistry.register(item);
		}else{
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(AceCraft.modid + ":" + item.getUnlocalizedName().substring(5), "inventory"));
		}
	}
	
	private static void registerEntity(Class<? extends Entity> entity, String name, Render<? extends Entity> renderer){
		EntityRegistry.registerModEntity(entity, name, 0, AceCraft.instance, 64, 20, true);
	}
	
}
