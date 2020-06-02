package net.acecraft.mod;

import net.acecraft.mod.blocks.BlockBed;
import net.acecraft.mod.blocks.BlockBlock;
import net.acecraft.mod.blocks.BlockCrop;
import net.acecraft.mod.blocks.BlockFruitLeaf;
import net.acecraft.mod.blocks.BlockFruitSapling;
import net.acecraft.mod.blocks.BlockOre;
import net.acecraft.mod.blocks.MachinaAnchor;
import net.acecraft.mod.blocks.MachinaAnvil;
import net.acecraft.mod.blocks.MachinaAxle;
import net.acecraft.mod.blocks.MachinaBlastFurnace;
import net.acecraft.mod.blocks.MachinaCampfire;
import net.acecraft.mod.blocks.MachinaDestille;
import net.acecraft.mod.blocks.MachinaFruitPress;
import net.acecraft.mod.blocks.MachinaGearBox;
import net.acecraft.mod.blocks.MachinaGlobe;
import net.acecraft.mod.blocks.MachinaKeg;
import net.acecraft.mod.blocks.MachinaMillstone;
import net.acecraft.mod.blocks.MachinaPedestal;
import net.acecraft.mod.blocks.MachinaRope;
import net.acecraft.mod.blocks.MachinaSewingBench;
import net.acecraft.mod.blocks.MachinaCookingTable;
import net.acecraft.mod.blocks.MachinaWaterwheel;
import net.acecraft.mod.blocks.MachinaWindmill;
import net.acecraft.mod.blocks.MachinaWorkbench;
import net.acecraft.mod.crafting.RecipeRemover;
import net.acecraft.mod.entity.EntityChocobo;
import net.acecraft.mod.entity.EntityCrab;
import net.acecraft.mod.entity.EntityDeer;
import net.acecraft.mod.entity.EntityDynamite;
import net.acecraft.mod.entity.EntityGoat;
import net.acecraft.mod.entity.EntityLlama;
import net.acecraft.mod.entity.EntityMammoth;
import net.acecraft.mod.entity.EntityNugget;
import net.acecraft.mod.entity.EntitySpear;
import net.acecraft.mod.entity.EntityZed;
import net.acecraft.mod.items.ItemArmor;
import net.acecraft.mod.items.ItemBed;
import net.acecraft.mod.items.ItemDynamite;
import net.acecraft.mod.items.ItemFood;
import net.acecraft.mod.items.ItemItem;
import net.acecraft.mod.items.ItemLiquor;
import net.acecraft.mod.items.ItemNugget;
import net.acecraft.mod.items.ItemSeed;
import net.acecraft.mod.items.ItemSeedWild;
import net.acecraft.mod.items.ToolsAxe;
import net.acecraft.mod.items.ToolsFryingPan;
import net.acecraft.mod.items.ToolsHammer;
import net.acecraft.mod.items.ToolsHoe;
import net.acecraft.mod.items.ToolsPickaxe;
import net.acecraft.mod.items.ToolsShovel;
import net.acecraft.mod.items.ToolsSpear;
import net.acecraft.mod.items.ToolsSword;
import net.acecraft.mod.render.RenderChocobo;
import net.acecraft.mod.render.RenderCrab;
import net.acecraft.mod.render.RenderDeer;
import net.acecraft.mod.render.RenderDynamite;
import net.acecraft.mod.render.RenderGoat;
import net.acecraft.mod.render.RenderLlama;
import net.acecraft.mod.render.RenderMammoth;
import net.acecraft.mod.render.RenderNugget;
import net.acecraft.mod.render.RenderSpear;
import net.acecraft.mod.render.RenderZed;
import net.acecraft.mod.tileentity.TileEntityAxle;
import net.acecraft.mod.tileentity.TileEntityBlastFurnace;
import net.acecraft.mod.tileentity.TileEntityCampfire;
import net.acecraft.mod.tileentity.TileEntityDistillery;
import net.acecraft.mod.tileentity.TileEntityFruitPress;
import net.acecraft.mod.tileentity.TileEntityGearBox;
import net.acecraft.mod.tileentity.TileEntityKeg;
import net.acecraft.mod.tileentity.TileEntityMillstone;
import net.acecraft.mod.tileentity.TileEntityWaterwheel;
import net.acecraft.mod.tileentity.TileEntityWindmill;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ShopKeeper {
	
	// Tool Materials
	public static ToolMaterial materialToolFlint      = EnumHelper.addToolMaterial("MaterialToolFlint",      1,  152,  4.0F, 1.5F,   0);
	public static ToolMaterial materialToolCopper     = EnumHelper.addToolMaterial("MaterialToolCopper",     2,  185,  5.5F, 2.0F,  10);
	public static ToolMaterial materialToolBronze     = EnumHelper.addToolMaterial("MaterialToolBronze",     2,  560,  7.0F, 2.5F,  19);
	public static ToolMaterial materialToolSteel      = EnumHelper.addToolMaterial("MaterialToolSteel",      2, 1244,  8.0F, 3.0F,  19);
	public static ToolMaterial materialToolMythril    = EnumHelper.addToolMaterial("MaterialToolMythril",    3, 2100, 10.0F, 3.5F,  50);
	public static ToolMaterial materialToolIridium    = EnumHelper.addToolMaterial("MaterialToolIridium",    3, 3500, 12.0F, 4.0F,   0);
	public static ToolMaterial materialToolAdamantium = EnumHelper.addToolMaterial("MaterialToolAdamantium", 3, 5600, 15.0F, 5.0F,  75);
	public static ToolMaterial materialToolUnobtanium = EnumHelper.addToolMaterial("MaterialToolUnobtanium", 4, 9999, 42.0F, 9.9F, 100);
	
	// Armor Materials
	public static ArmorMaterial materialArmorCopper     = EnumHelper.addArmorMaterial("MaterialArmorCopper",     AceCraft.modid + ":" + "copper",      7, new int[]{2, 4, 2, 2},   5, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 5);
	public static ArmorMaterial materialArmorAluminium  = EnumHelper.addArmorMaterial("MaterialArmorAluminium",  AceCraft.modid + ":" + "aluminium",  15, new int[]{2, 7, 6, 3},  12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 5);
	public static ArmorMaterial materialArmorLead       = EnumHelper.addArmorMaterial("MaterialArmorLead",       AceCraft.modid + ":" + "lead",       20, new int[]{2, 5, 3, 2},   5, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 5);
	public static ArmorMaterial materialArmorBronze     = EnumHelper.addArmorMaterial("MaterialArmorBronze",     AceCraft.modid + ":" + "bronze",     20, new int[]{2, 5, 3, 2},  12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 5);
	public static ArmorMaterial materialArmorSteel      = EnumHelper.addArmorMaterial("MaterialArmorSteel",      AceCraft.modid + ":" + "steel",      25, new int[]{3, 6, 4, 3},  12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 5);
	public static ArmorMaterial materialArmorMythril    = EnumHelper.addArmorMaterial("MaterialArmorMythril",    AceCraft.modid + ":" + "mythril",    30, new int[]{3, 7, 5, 3},  45, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 5);
	public static ArmorMaterial materialArmorAdamantium = EnumHelper.addArmorMaterial("MaterialArmorAdamantium", AceCraft.modid + ":" + "adamantium", 35, new int[]{3, 8, 6, 3},  70, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 5);
	public static ArmorMaterial materialArmorUnobtanium = EnumHelper.addArmorMaterial("MaterialArmorUnobtanium", AceCraft.modid + ":" + "unobtanium", 99, new int[]{3, 8, 6, 3}, 100, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 5);
	
	// GUI IDs
	public static int guiIDBlastFurnace  =  0;
	public static int guiIDKeg           =  1;
	public static int guiIDCampfire      =  2;
	public static int guiIDFruitPress    =  3;
	public static int guiIDMillstone     =  4;
	public static int guiIDDistillery    =  5;
	public static int guiIDBoiler        =  6;
	public static int guiIDWorkbench     =  7;
	public static int guiIDAnvilCrafting =  8;
	public static int guiIDAnvilRepair   =  9;
	public static int guiIDSewingBench   = 10;
	public static int guiIDCookingTable  = 11;
	
	// Full Blocks
	public static Block blockCopper     = new BlockBlock("BlockCopper",     Material.IRON,  3.0F, 5.0F);
	public static Block blockAluminium  = new BlockBlock("BlockAluminium",  Material.IRON,  3.0F, 5.0F);
	public static Block blockLead       = new BlockBlock("BlockLead",       Material.IRON,  3.0F, 3.0F);
	public static Block blockTin        = new BlockBlock("BlockTin",        Material.IRON,  3.0F, 3.0F);
	public static Block blockZinc       = new BlockBlock("BlockZinc",       Material.IRON,  3.0F, 3.0F);
	public static Block blockSilver     = new BlockBlock("BlockSilver",     Material.IRON,  3.0F, 3.0F);
	public static Block blockMythril    = new BlockBlock("BlockMythril",    Material.IRON,  3.0F, 5.0F);
	public static Block blockIridium    = new BlockBlock("BlockIridium",    Material.CORAL, 3.0F, 6.0F);
	public static Block blockAdamantium = new BlockBlock("BlockAdamantium", Material.IRON,  3.0F, 5.0F);
	public static Block blockOrichalcum = new BlockBlock("BlockOrichalcum", Material.IRON,  3.0F, 3.0F);
	public static Block blockUnobtanium = new BlockBlock("BlockUnobtanium", Material.IRON,  9.9F, 9.9F);
	public static Block blockBrass      = new BlockBlock("BlockBrass",      Material.IRON,  3.0F, 3.0F);
	public static Block blockBronze     = new BlockBlock("BlockBronze",     Material.IRON,  3.0F, 3.0F);
	public static Block blockSteel      = new BlockBlock("BlockSteel",      Material.IRON,  3.0F, 5.0F);
	public static Block blockRuby       = new BlockBlock("BlockRuby",       Material.GLASS, 3.0F, 4.0F);
	public static Block blockTourmaline = new BlockBlock("BlockTourmaline", Material.GLASS, 3.0F, 4.0F);
	public static Block blockTopaz      = new BlockBlock("BlockTopaz",      Material.GLASS, 3.0F, 4.0F);
	public static Block blockSaphire    = new BlockBlock("BlockSaphire",    Material.GLASS, 3.0F, 4.0F);
	public static Block blockAquamarine = new BlockBlock("BlockAquamarine", Material.GLASS, 3.0F, 4.0F);
	public static Block blockPyrite     = new BlockBlock("BlockPyrite",     Material.GLASS, 3.0F, 4.0F);
	public static Block blockAmethyst   = new BlockBlock("BlockAmethyst",   Material.GLASS, 3.0F, 4.0F);
	public static Block blockGagat      = new BlockBlock("BlockGagat",      Material.GLASS, 3.0F, 4.0F);
	public static Block blockOpal       = new BlockBlock("BlockOpal",       Material.GLASS, 3.0F, 4.0F);
	public static Block blockSalt       = new BlockBlock("BlockSalt",       Material.SAND,  3.0F, 1.0F);
	public static Block blockSulfur     = new BlockBlock("BlockSulfur",     Material.SAND,  3.0F, 1.0F);
	public static Block blockFlour      = new BlockBlock("BlockFlour",      Material.SAND,  3.0F, 1.0F);
	public static Block blockCurry      = new BlockBlock("BlockCurry",      Material.SAND,  3.0F, 1.0F);
	public static Block blockCoffee     = new BlockBlock("BlockCoffee",     Material.SAND,  3.0F, 1.0F);
	public static Block blockMeteor     = new BlockBlock("BlockMeteor",     Material.ROCK,  7.0F, 9.0F);
	
	// Nuggets
	public static Item nuggetIron       = new ItemNugget("NuggetIron");
	public static Item nuggetGold       = new ItemNugget("NuggetGold");
	public static Item nuggetCopper     = new ItemNugget("NuggetCopper");
	public static Item nuggetBauxite    = new ItemNugget("NuggetBauxite");
	public static Item nuggetLead       = new ItemNugget("NuggetLead");
	public static Item nuggetTin        = new ItemNugget("NuggetTin");
	public static Item nuggetZinc       = new ItemNugget("NuggetZinc");
	public static Item nuggetSilver     = new ItemNugget("NuggetSilver");
	public static Item nuggetMythril    = new ItemNugget("NuggetMythril");
	public static Item nuggetIridium    = new ItemNugget("NuggetIridium");
	public static Item nuggetAdamantium = new ItemNugget("NuggetAdamantium");
	public static Item nuggetOrichalcum = new ItemNugget("NuggetOrichalcum");
	public static Item nuggetUnobtanium = new ItemNugget("NuggetUnobtanium");
	
	// Gemstones
	public static Item gemRuby       = new ItemItem("GemRuby");
	public static Item gemTourmaline = new ItemItem("GemTourmaline");
	public static Item gemTopaz      = new ItemItem("GemTopaz");
	public static Item gemSaphire    = new ItemItem("GemSaphire");
	public static Item gemAquamarine = new ItemItem("GemAquamarine");
	public static Item gemPyrite     = new ItemItem("GemPyrite");
	public static Item gemAmethyst   = new ItemItem("GemAmethyst");
	public static Item gemGagat      = new ItemItem("GemGagat");
	public static Item gemOpal       = new ItemItem("GemOpal");
	
	// Powder
	public static Item powderSalt       = new ItemItem("PowderSalt");
	public static Item powderSulfur     = new ItemItem("PowderSulfur");
	public static Item powderFlour      = new ItemItem("PowderFlour");
	public static Item powderCurry      = new ItemItem("PowderCurry");
	public static Item powderCoffee     = new ItemItem("PowderCoffee");
	
	// Ore Blocks
	public static Block oreCopper     = new BlockOre("OreCopper",     1, nuggetCopper);
	public static Block oreBauxite    = new BlockOre("OreBauxite",    1, nuggetBauxite);
	public static Block oreLead       = new BlockOre("OreLead",       1, nuggetLead);
	public static Block oreTin        = new BlockOre("OreTin",        1, nuggetTin);
	public static Block oreZinc       = new BlockOre("OreZinc",       1, nuggetZinc);
	public static Block oreSilver     = new BlockOre("OreSilver",     1, nuggetSilver);
	public static Block oreMythril    = new BlockOre("OreMythril",    2, nuggetMythril);
	public static Block oreIridium    = new BlockOre("OreIridium",    3, nuggetIridium);
	public static Block oreAdamantium = new BlockOre("OreAdamantium", 3, nuggetAdamantium);
	public static Block oreOrichalcum = new BlockOre("OreOrichalcum", 2, nuggetOrichalcum);
	public static Block oreUnobtanium = new BlockOre("OreUnobtanium", 4, nuggetUnobtanium);
	public static Block oreRuby       = new BlockOre("OreRuby",       2, gemRuby);
	public static Block oreTourmaline = new BlockOre("OreTourmaline", 2, gemTourmaline);
	public static Block oreTopaz      = new BlockOre("OreTopaz",      2, gemTopaz);
	public static Block oreAquamarine = new BlockOre("OreAquamarine", 2, gemAquamarine);
	public static Block orePyrite     = new BlockOre("OrePyrite",     2, gemPyrite);
	public static Block oreSaphire    = new BlockOre("OreSaphire",    2, gemSaphire);
	public static Block oreAmethyst   = new BlockOre("OreAmethyst",   2, gemAmethyst);
	public static Block oreGagat      = new BlockOre("OreGagat",      2, gemGagat);
	public static Block oreOpal       = new BlockOre("OreOpal",       3, gemOpal);
	public static Block oreSalt       = new BlockOre("OreSalt",       1, powderSalt);
	public static Block oreSulfur     = new BlockOre("OreSulfur",     1, powderSulfur);
	
	// Ingots
	public static Item ingotCopper     = new ItemItem("IngotCopper");
	public static Item ingotAluminium  = new ItemItem("IngotAluminium");
	public static Item ingotLead       = new ItemItem("IngotLead");
	public static Item ingotTin        = new ItemItem("IngotTin");
	public static Item ingotZinc       = new ItemItem("IngotZinc");
	public static Item ingotSilver     = new ItemItem("IngotSilver");
	public static Item ingotMythril    = new ItemItem("IngotMythril");
	public static Item ingotAdamantium = new ItemItem("IngotAdamantium");
	public static Item ingotOrichalcum = new ItemItem("IngotOrichalcum");
	public static Item ingotUnobtanium = new ItemItem("IngotUnobtanium");
	public static Item ingotBrass      = new ItemItem("IngotBrass");
	public static Item ingotBronze     = new ItemItem("IngotBronze");
	public static Item ingotSteel      = new ItemItem("IngotSteel");
	
	// Tools
	public static Item toolFryingPan         = new ToolsFryingPan("ToolFryingPan",         ToolMaterial.IRON);
	public static Item toolAxeFlint          = new ToolsAxe      ("ToolAxeFlint",          materialToolFlint);
	public static Item toolAxeCopper         = new ToolsAxe      ("ToolAxeCopper",         materialToolCopper);
	public static Item toolAxeMythril        = new ToolsAxe      ("ToolAxeMythril",        materialToolMythril);
	public static Item toolAxeIridium        = new ToolsAxe      ("ToolAxeIridium",        materialToolIridium);
	public static Item toolAxeAdamantium     = new ToolsAxe      ("ToolAxeAdamantium",     materialToolAdamantium);
	public static Item toolAxeUnobtanium     = new ToolsAxe      ("ToolAxeUnobtanium",     materialToolUnobtanium);
	public static Item toolAxeBronze         = new ToolsAxe      ("ToolAxeBronze",         materialToolBronze);
	public static Item toolAxeSteel          = new ToolsAxe      ("ToolAxeSteel",          materialToolSteel);
	public static Item toolHammerIron        = new ToolsHammer   ("ToolHammerIron",        ToolMaterial.IRON);
	public static Item toolHammerGold        = new ToolsHammer   ("ToolHammerGold",        ToolMaterial.GOLD);
	public static Item toolHammerFlint       = new ToolsHammer   ("ToolHammerFlint",       materialToolFlint);
	public static Item toolHammerCopper      = new ToolsHammer   ("ToolHammerCopper",      materialToolCopper);
	public static Item toolHammerMythril     = new ToolsHammer   ("ToolHammerMythril",     materialToolMythril);
	public static Item toolHammerIridium     = new ToolsHammer   ("ToolHammerIridium",     materialToolIridium);
	public static Item toolHammerAdamantium  = new ToolsHammer   ("ToolHammerAdamantium",  materialToolAdamantium);
	public static Item toolHammerUnobtanium  = new ToolsHammer   ("ToolHammerUnobtanium",  materialToolUnobtanium);
	public static Item toolHammerBronze      = new ToolsHammer   ("ToolHammerBronze",      materialToolBronze);
	public static Item toolHammerSteel       = new ToolsHammer   ("ToolHammerSteel",       materialToolSteel);
	public static Item toolHoeFlint          = new ToolsHoe      ("ToolHoeFlint",          materialToolFlint);
	public static Item toolHoeCopper         = new ToolsHoe      ("ToolHoeCopper",         materialToolCopper);
	public static Item toolHoeMythril        = new ToolsHoe      ("ToolHoeMythril",        materialToolMythril);
	public static Item toolHoeIridium        = new ToolsHoe      ("ToolHoeIridium",        materialToolIridium);
	public static Item toolHoeAdamantium     = new ToolsHoe      ("ToolHoeAdamantium",     materialToolAdamantium);
	public static Item toolHoeUnobtanium     = new ToolsHoe      ("ToolHoeUnobtanium",     materialToolUnobtanium);
	public static Item toolHoeBronze         = new ToolsHoe      ("ToolHoeBronze",         materialToolBronze);
	public static Item toolHoeSteel          = new ToolsHoe      ("ToolHoeSteel",          materialToolSteel);
	public static Item toolPickaxeFlint      = new ToolsPickaxe  ("ToolPickaxeFlint",      materialToolFlint);
	public static Item toolPickaxeCopper     = new ToolsPickaxe  ("ToolPickaxeCopper",     materialToolCopper);
	public static Item toolPickaxeMythril    = new ToolsPickaxe  ("ToolPickaxeMythril",    materialToolMythril);
	public static Item toolPickaxeIridium    = new ToolsPickaxe  ("ToolPickaxeIridium",    materialToolIridium);
	public static Item toolPickaxeAdamantium = new ToolsPickaxe  ("ToolPickaxeAdamantium", materialToolAdamantium);
	public static Item toolPickaxeUnobtanium = new ToolsPickaxe  ("ToolPickaxeUnobtanium", materialToolUnobtanium);
	public static Item toolPickaxeBronze     = new ToolsPickaxe  ("ToolPickaxeBronze",     materialToolBronze);
	public static Item toolPickaxeSteel      = new ToolsPickaxe  ("ToolPickaxeSteel",      materialToolSteel);
	public static Item toolShovelFlint       = new ToolsShovel   ("ToolShovelFlint",       materialToolFlint);
	public static Item toolShovelCopper      = new ToolsShovel   ("ToolShovelCopper",      materialToolCopper);
	public static Item toolShovelMythril     = new ToolsShovel   ("ToolShovelMythril",     materialToolMythril);
	public static Item toolShovelIridium     = new ToolsShovel   ("ToolShovelIridium",     materialToolIridium);
	public static Item toolShovelAdamantium  = new ToolsShovel   ("ToolShovelAdamantium",  materialToolAdamantium);
	public static Item toolShovelUnobtanium  = new ToolsShovel   ("ToolShovelUnobtanium",  materialToolUnobtanium);
	public static Item toolShovelBronze      = new ToolsShovel   ("ToolShovelBronze",      materialToolBronze);
	public static Item toolShovelSteel       = new ToolsShovel   ("ToolShovelSteel",       materialToolSteel);
	public static Item toolSpearIron         = new ToolsSpear    ("ToolSpearIron",         ToolMaterial.IRON);
	public static Item toolSpearGold         = new ToolsSpear    ("ToolSpearGold",         ToolMaterial.GOLD);
	public static Item toolSpearFlint        = new ToolsSpear    ("ToolSpearFlint",        materialToolFlint);
	public static Item toolSpearCopper       = new ToolsSpear    ("ToolSpearCopper",       materialToolCopper);
	public static Item toolSpearMythril      = new ToolsSpear    ("ToolSpearMythril",      materialToolMythril);
	public static Item toolSpearIridium      = new ToolsSpear    ("ToolSpearIridium",      materialToolIridium);
	public static Item toolSpearAdamantium   = new ToolsSpear    ("ToolSpearAdamantium",   materialToolAdamantium);
	public static Item toolSpearUnobtanium   = new ToolsSpear    ("ToolSpearUnobtanium",   materialToolUnobtanium);
	public static Item toolSpearBronze       = new ToolsSpear    ("ToolSpearBronze",       materialToolBronze);
	public static Item toolSpearSteel        = new ToolsSpear    ("ToolSpearSteel",        materialToolSteel);
	public static Item toolSwordFlint        = new ToolsSword    ("ToolSwordFlint",        materialToolFlint);
	public static Item toolSwordCopper       = new ToolsSword    ("ToolSwordCopper",       materialToolCopper);
	public static Item toolSwordMythril      = new ToolsSword    ("ToolSwordMythril",      materialToolMythril);
	public static Item toolSwordIridium      = new ToolsSword    ("ToolSwordIridium",      materialToolIridium);
	public static Item toolSwordAdamantium   = new ToolsSword    ("ToolSwordAdamantium",   materialToolAdamantium);
	public static Item toolSwordUnobtanium   = new ToolsSword    ("ToolSwordUnobtanium",   materialToolUnobtanium);
	public static Item toolSwordBronze       = new ToolsSword    ("ToolSwordBronze",       materialToolBronze);
	public static Item toolSwordSteel        = new ToolsSword    ("ToolSwordSteel",        materialToolSteel);
	
	
	// Armor
	public static Item armorBootsCopper          = new ItemArmor("ArmorBootsCopper",          materialArmorCopper,     0, EntityEquipmentSlot.FEET);
	public static Item armorBootsAluminium       = new ItemArmor("ArmorBootsAluminium",       materialArmorAluminium,  0, EntityEquipmentSlot.FEET);
	public static Item armorBootsLead            = new ItemArmor("ArmorBootsLead",            materialArmorLead,       0, EntityEquipmentSlot.FEET);
	public static Item armorBootsMythril         = new ItemArmor("ArmorBootsMythril",         materialArmorMythril,    0, EntityEquipmentSlot.FEET);
	public static Item armorBootsAdamantium      = new ItemArmor("ArmorBootsAdamantium",      materialArmorAdamantium, 0, EntityEquipmentSlot.FEET);
	public static Item armorBootsUnobtanium      = new ItemArmor("ArmorBootsUnobtanium",      materialArmorUnobtanium, 0, EntityEquipmentSlot.FEET);
	public static Item armorBootsBronze          = new ItemArmor("ArmorBootsBronze",          materialArmorBronze,     0, EntityEquipmentSlot.FEET);
	public static Item armorBootsSteel           = new ItemArmor("ArmorBootsSteel",           materialArmorSteel,      0, EntityEquipmentSlot.FEET);
	public static Item armorChestplateCopper     = new ItemArmor("ArmorChestplateCopper",     materialArmorCopper,     0, EntityEquipmentSlot.CHEST);
	public static Item armorChestplateAluminium  = new ItemArmor("ArmorChestplateAluminium",  materialArmorAluminium,  0, EntityEquipmentSlot.CHEST);
	public static Item armorChestplateLead       = new ItemArmor("ArmorChestplateLead",       materialArmorLead,       0, EntityEquipmentSlot.CHEST);
	public static Item armorChestplateMythril    = new ItemArmor("ArmorChestplateMythril",    materialArmorMythril,    0, EntityEquipmentSlot.CHEST);
	public static Item armorChestplateAdamantium = new ItemArmor("ArmorChestplateAdamantium", materialArmorAdamantium, 0, EntityEquipmentSlot.CHEST);
	public static Item armorChestplateUnobtanium = new ItemArmor("ArmorChestplateUnobtanium", materialArmorUnobtanium, 0, EntityEquipmentSlot.CHEST);
	public static Item armorChestplateBronze     = new ItemArmor("ArmorChestplateBronze",     materialArmorBronze,     0, EntityEquipmentSlot.CHEST);
	public static Item armorChestplateSteel      = new ItemArmor("ArmorChestplateSteel",      materialArmorSteel,      0, EntityEquipmentSlot.CHEST);
	public static Item armorHelmetCopper         = new ItemArmor("ArmorHelmetCopper",         materialArmorCopper,     0, EntityEquipmentSlot.HEAD);
	public static Item armorHelmetAluminium      = new ItemArmor("ArmorHelmetAluminium",      materialArmorAluminium,  0, EntityEquipmentSlot.HEAD);
	public static Item armorHelmetLead           = new ItemArmor("ArmorHelmetLead",           materialArmorLead,       0, EntityEquipmentSlot.HEAD);
	public static Item armorHelmetMythril        = new ItemArmor("ArmorHelmetMythril",        materialArmorMythril,    0, EntityEquipmentSlot.HEAD);
	public static Item armorHelmetAdamantium     = new ItemArmor("ArmorHelmetAdamantium",     materialArmorAdamantium, 0, EntityEquipmentSlot.HEAD);
	public static Item armorHelmetUnobtanium     = new ItemArmor("ArmorHelmetUnobtanium",     materialArmorUnobtanium, 0, EntityEquipmentSlot.HEAD);
	public static Item armorHelmetBronze         = new ItemArmor("ArmorHelmetBronze",         materialArmorBronze,     0, EntityEquipmentSlot.HEAD);
	public static Item armorHelmetSteel          = new ItemArmor("ArmorHelmetSteel",          materialArmorSteel,      0, EntityEquipmentSlot.HEAD);
	public static Item armorLeggingsCopper       = new ItemArmor("ArmorLeggingsCopper",       materialArmorCopper,     0, EntityEquipmentSlot.LEGS);
	public static Item armorLeggingsAluminium    = new ItemArmor("ArmorLeggingsAluminium",    materialArmorAluminium,  0, EntityEquipmentSlot.LEGS);
	public static Item armorLeggingsLead         = new ItemArmor("ArmorLeggingsLead",         materialArmorLead,       0, EntityEquipmentSlot.LEGS);
	public static Item armorLeggingsMythril      = new ItemArmor("ArmorLeggingsMythril",      materialArmorMythril,    0, EntityEquipmentSlot.LEGS);
	public static Item armorLeggingsAdamantium   = new ItemArmor("ArmorLeggingsAdamantium",   materialArmorAdamantium, 0, EntityEquipmentSlot.LEGS);
	public static Item armorLeggingsUnobtanium   = new ItemArmor("ArmorLeggingsUnobtanium",   materialArmorUnobtanium, 0, EntityEquipmentSlot.LEGS);
	public static Item armorLeggingsBronze       = new ItemArmor("ArmorLeggingsBronze",       materialArmorBronze,     0, EntityEquipmentSlot.LEGS);
	public static Item armorLeggingsSteel        = new ItemArmor("ArmorLeggingsSteel",        materialArmorSteel,      0, EntityEquipmentSlot.LEGS);
	
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
	
	// Explosives
	public static Item explosiveDynamite = new ItemDynamite("ExplosiveDynamite");
	
	// Food
	public static Item foodGrandMeatRaw    = new ItemFood("FoodGrandMeatRaw",    1, 1,  true, false, false);
	public static Item foodGrandMeatCooked = new ItemFood("FoodGrandMeatCooked", 1, 1,  true, false, false);
	public static Item foodVenisonRaw      = new ItemFood("FoodVenisonRaw",      1, 1,  true, false, false);
	public static Item foodVenisonCooked   = new ItemFood("FoodVenisonCooked",   1, 1,  true, false, false);
	public static Item foodVicugnaRaw      = new ItemFood("FoodVicugnaRaw",      1, 1,  true, false, false);
	public static Item foodVicugnaCooked   = new ItemFood("FoodVicugnaCooked",   1, 1,  true, false, false);
	public static Item foodFishCrab        = new ItemFood("FoodFishCrab",        1, 1,  true, false, false);
	public static Item foodFishSquid       = new ItemFood("FoodFishSquid",       1, 1,  true, false, false);
	public static Item foodBambooShoot     = new ItemFood("FoodBambooShoot",     1, 1, false, false, false);
	public static Item foodTurnip          = new ItemFood("FoodTurnip",          1, 1, false, false, false);
	public static Item foodCabbage         = new ItemFood("FoodCabbage",         1, 1, false, false, false);
	public static Item foodCucumber        = new ItemFood("FoodCucumber",        1, 1, false, false, false);
	public static Item foodStrawberry      = new ItemFood("FoodStrawberry",      1, 1, false, false, false);
	public static Item foodRice            = new ItemFood("FoodRice",            1, 1, false, false, false);
	public static Item foodOnion           = new ItemFood("FoodOnion",           1, 1, false, false, false);
	public static Item foodCorn            = new ItemFood("FoodCorn",            1, 1, false, false, false);
	public static Item foodTomato          = new ItemFood("FoodTomato",          1, 1, false, false, false);
	public static Item foodGrapes          = new ItemFood("FoodGrapes",          1, 1, false, false, false);
	public static Item foodPineapple       = new ItemFood("FoodPineapple",       1, 1, false, false, false);
	public static Item foodCoffeeBeans     = new ItemFood("FoodCoffeeBeans",     1, 1, false, false, false);
	public static Item foodSweetPotato     = new ItemFood("FoodSweetPotato",     1, 1, false, false, false);
	public static Item foodEggplant        = new ItemFood("FoodEggplant",        1, 1, false, false, false);
	public static Item foodSpinach         = new ItemFood("FoodSpinach",         1, 1, false, false, false);
	public static Item foodGreenPepper     = new ItemFood("FoodGreenPepper",     1, 1, false, false, false);
	public static Item foodLemon           = new ItemFood("FoodLemon",           1, 1, false, false, false);
	public static Item foodPeach           = new ItemFood("FoodPeach",           1, 1, false, false, false);
	public static Item foodOrange          = new ItemFood("FoodOrange",          1, 1, false, false, false);
	public static Item foodCherries        = new ItemFood("FoodCherries",        1, 1, false, false, false);
	public static Item foodBanana          = new ItemFood("FoodBanana",          1, 1, false, false, false);
	public static Item foodRiceball        = new ItemFood("FoodRiceball",        1, 1, false, false, false);
	public static Item foodCheese          = new ItemFood("FoodRiceball",        1, 1, false, false, false);
	public static Item foodButter          = new ItemFood("FoodButter",          1, 1, false, false, false);
	
	public static Block cropTurnip      = new BlockCrop("CropTurnip",      foodTurnip,      3);
	public static Block cropCabbage     = new BlockCrop("CropCabbage",     foodCabbage,     4);
	public static Block cropCucumber    = new BlockCrop("CropCucumber",    foodCucumber,    4);
	public static Block cropStrawberry  = new BlockCrop("CropStrawberry",  foodStrawberry,  4);
	public static Block cropRice        = new BlockCrop("CropRice",        foodRice,        5);
	public static Block cropOnion       = new BlockCrop("CropOnion",       foodOnion,       3);
	public static Block cropCorn        = new BlockCrop("CropCorn",        foodCorn,        5);
	public static Block cropTomato      = new BlockCrop("CropTomato",      foodTomato,      5);
	public static Block cropGrapes      = new BlockCrop("CropGrapes",      foodGrapes,      4);
	public static Block cropPineapple   = new BlockCrop("CropPineapple",   foodPineapple,   4);
	public static Block cropCoffeeBeans = new BlockCrop("CropCoffeeBeans", foodCoffeeBeans, 4);
	public static Block cropSweetPotato = new BlockCrop("CropSweetPotato", foodSweetPotato, 3);
	public static Block cropEggplant    = new BlockCrop("CropEggplant",    foodEggplant,    4);
	public static Block cropSpinach     = new BlockCrop("CropSpinach",     foodSpinach,     3);
	public static Block cropGreenPepper = new BlockCrop("CropGreenPepper", foodGreenPepper, 4);
	public static Block cropHemp        = new BlockCrop("CropHemp",        stuffHemp,       4);
	public static Block cropCotton      = new BlockCrop("CropCotton",      stuffCotton,     4);
	
	public static Item seedWild;
	public static Item seedTurnip;
	public static Item seedCabbage;
	public static Item seedCucumber;
	public static Item seedStrawberry;
	public static Item seedRice;
	public static Item seedOnion;
	public static Item seedCorn;
	public static Item seedTomato;
	public static Item seedGrapes;
	public static Item seedPineapple;
	public static Item seedCoffeeBeans;
	public static Item seedSweetPotato;
	public static Item seedEggplant;
	public static Item seedSpinach;
	public static Item seedGreenPepper;
	public static Item seedHemp;
	public static Item seedCotton;
	
	// Fruit Saplings
	public static Block saplingApple    = new BlockFruitSapling("SaplingApple",    0);	
	public static Block saplingLemon    = new BlockFruitSapling("SaplingLemon",    1);
	public static Block saplingPeach    = new BlockFruitSapling("SaplingPeach",    2);
	public static Block saplingOrange   = new BlockFruitSapling("SaplingOrange",   3);
	public static Block saplingCherries = new BlockFruitSapling("SaplingCherries", 4);
	public static Block saplingBanana   = new BlockFruitSapling("SaplingBanana",   5);
	
	// Fruit Leaves
	public static Block fruitApple    = new BlockFruitLeaf("FruitApple",    Items.APPLE,  saplingApple);
	public static Block fruitLemon    = new BlockFruitLeaf("FruitLemon",    foodLemon,    saplingLemon);
	public static Block fruitPeach    = new BlockFruitLeaf("FruitPeach",    foodPeach,    saplingPeach);
	public static Block fruitOrange   = new BlockFruitLeaf("FruitOrange",   foodOrange,   saplingOrange);
	public static Block fruitCherries = new BlockFruitLeaf("FruitCherries", foodCherries, saplingCherries);
	public static Block fruitBanana   = new BlockFruitLeaf("FruitBanana",   foodBanana,   saplingBanana);
	
	// Juices
	public static Item juiceApple          = new ItemFood("JuiceApple",        1, 1, false, true, true);
	public static Item juiceGrapes         = new ItemFood("JuiceGrapes",       1, 1, false, true, true);
	public static Item juicePineapple      = new ItemFood("JuicePineapple",    1, 1, false, true, true);
	public static Item juiceStrawberry     = new ItemFood("JuiceStrawberry",   1, 1, false, true, true);
	public static Item juiceLemon          = new ItemFood("JuiceLemon",        1, 1, false, true, true);
	public static Item juicePeach          = new ItemFood("JuicePeach",        1, 1, false, true, true);
	public static Item juiceOrange         = new ItemFood("JuiceOrange",       1, 1, false, true, true);
	public static Item juiceCherries       = new ItemFood("JuiceCherries",     1, 1, false, true, true);
	public static Item juiceBanana         = new ItemFood("JuiceBanana",       1, 1, false, true, true);
	public static Item juiceMilk           = new ItemFood("JuiceMilk",         1, 1, false, true, true);
	public static Item juiceHotMilk        = new ItemFood("JuiceHotMilk",      1, 1, false, true, true);
	public static Item juiceHotChocolate   = new ItemFood("JuiceHotChocolate", 1, 1, false, true, true);
	public static Item juiceCoffee         = new ItemFood("JuiceCoffee",       1, 1, false, true, true);
	public static Item juiceOil            = new ItemFood("JuiceOil",          1, 1, false, true, true);
	
	// Liquor
	public static Item liquorCider      = new ItemLiquor("LiquorCider",      0);
	public static Item liquorRum        = new ItemLiquor("LiquorRum",        1);
	public static Item liquorBeer       = new ItemLiquor("LiquorBeer",       2);
	public static Item liquorSalgam     = new ItemLiquor("LiquorSalgam",     3);
	public static Item liquorVodka      = new ItemLiquor("LiquorVodka",      4);
	public static Item liquorSake       = new ItemLiquor("LiquorSake",       5);
	public static Item liquorMead       = new ItemLiquor("LiquorMead",       6);
	public static Item liquorWineGrapes = new ItemLiquor("LiquorWineGrapes", 7);
	public static Item liquorWineCherry = new ItemLiquor("LiquorWineCherry", 8);
	public static Item liquorWinePines  = new ItemLiquor("LiquorWinePines",  9);
	
	// Dishes
	public static Item dishSeaSaltIceCream  = new ItemFood("DishSeaSaltIceCream",  10, 10, false, false, false);
	public static Item dishSalad            = new ItemFood("DishSalad",            10, 10, false, false, false);
	public static Item dishSandwich         = new ItemFood("DishSandwich",         10, 10, false, false, false);
	public static Item dishFruitSandwich    = new ItemFood("DishFruitSandwich",    10, 10, false, false, false);
	public static Item dishPickledTurnips   = new ItemFood("DishPickledTurnips",   10, 10, false, false, false);
	public static Item dishPickledCucumber  = new ItemFood("DishPickledCucumber",  10, 10, false, false, false);
	public static Item dishBambooRice       = new ItemFood("DishBambooRice",       10, 10, false, false, false);
	public static Item dishMushroomRice     = new ItemFood("DishMushroomRice",     10, 10, false, false, false);
	public static Item dishSushi            = new ItemFood("DishSushi",            10, 10, false, false, false);
	public static Item dishRaisinBread      = new ItemFood("DishRaisinBread",      10, 10, false, false, false);
	public static Item dishChirashiSushi    = new ItemFood("DishChirashiSushi",    10, 10, false, false, false);
	public static Item dishIceCream         = new ItemFood("DishIceCream",         10, 10, false, false, false);
	public static Item dishStirFry          = new ItemFood("DishStirFry",          10, 10, false, false, false);
	public static Item dishFriedRice        = new ItemFood("DishFriedRice",        10, 10, false, false, false);
	public static Item dishSavoryPancake    = new ItemFood("DishSavoryPancake",    10, 10, false, false, false);
	public static Item dishFrenchFries      = new ItemFood("DishFrenchFries",      10, 10, false, false, false);
	public static Item dishCroquette        = new ItemFood("DishCroquette",        10, 10, false, false, false);
	public static Item dishPopcorn          = new ItemFood("DishPopcorn",          10, 10, false, false, false);
	public static Item dishCornflakes       = new ItemFood("DishCornflakes",       10, 10, false, false, false);
	public static Item dishHappyEggplant    = new ItemFood("DishHappyEggplant",    10, 10, false, false, false);
	public static Item dishScrambledEggs    = new ItemFood("DishScrambledEggs",    10, 10, false, false, false);
	public static Item dishOmelet           = new ItemFood("DishOmelet",           10, 10, false, false, false);
	public static Item dishOmeletRice       = new ItemFood("DishOmeletRice",       10, 10, false, false, false);
	public static Item dishAppleSouffle     = new ItemFood("DishAppleSouffle",     10, 10, false, false, false);
	public static Item dishCurryBread       = new ItemFood("DishCurryBread",       10, 10, false, false, false);
	public static Item dishFrenchToast      = new ItemFood("DishFrenchToast",      10, 10, false, false, false);
	public static Item dishDoughnut         = new ItemFood("DishDoughnut",         10, 10, false, false, false);
	public static Item dishFriedNoodles     = new ItemFood("DishFriedNoodles",     10, 10, false, false, false);
	public static Item dishTempura          = new ItemFood("DishTempura",          10, 10, false, false, false);
	public static Item dishPancake          = new ItemFood("DishPancake",          10, 10, false, false, false);
	public static Item dishPotSticker       = new ItemFood("DishPotSticker",       10, 10, false, false, false);
	public static Item dishRisotto          = new ItemFood("DishRisotto",          10, 10, false, false, false);
	public static Item dishDryCurry         = new ItemFood("DishDryCurry",         10, 10, false, false, false);
	public static Item dishStew             = new ItemFood("DishStew",             10, 10, false, false, false);
	public static Item dishPumpkinStew      = new ItemFood("DishPumpkinStew",      10, 10, false, false, false);
	public static Item dishFishStew         = new ItemFood("DishFishStew",         10, 10, false, false, false);
	public static Item dishMountainStew     = new ItemFood("DishMountainStew",     10, 10, false, false, false);
	public static Item dishBoiledSpinach    = new ItemFood("DishBoiledSpinach",    10, 10, false, false, false);
	public static Item dishBoiledEgg        = new ItemFood("DishBoiledEgg",        10, 10, false, false, false);
	public static Item dishCandiedPotato    = new ItemFood("DishCandiedPotato",    10, 10, false, false, false);
	public static Item dishDumplings        = new ItemFood("DishDumplings",        10, 10, false, false, false);
	public static Item dishStrawberryJam    = new ItemFood("DishStrawberryJam",    10, 10, false, false, false);
	public static Item dishAppleJam         = new ItemFood("DishAppleJam",         10, 10, false, false, false);
	public static Item dishPeachJam         = new ItemFood("DishPeachJam",         10, 10, false, false, false);
	public static Item dishGrapeJam         = new ItemFood("DishGrapeJam",         10, 10, false, false, false);
	public static Item dishMarmelade        = new ItemFood("DishMarmelade",        10, 10, false, false, false);
	public static Item dishCheeseFondue     = new ItemFood("DishCheeseFondue",     10, 10, false, false, false);
	public static Item dishNoodles          = new ItemFood("DishNoodles",          10, 10, false, false, false);
	public static Item dishCurryNoodles     = new ItemFood("DishCurryNoodles",     10, 10, false, false, false);
	public static Item dishTempuraNoodles   = new ItemFood("DishTempuraNoodles",   10, 10, false, false, false);
	public static Item dishRiceSoup         = new ItemFood("DishRiceSoup",         10, 10, false, false, false);
	public static Item dishPorridge         = new ItemFood("DishPorridge",         10, 10, false, false, false);
	public static Item dishTempuraRice      = new ItemFood("DishTempuraRice",      10, 10, false, false, false);
	public static Item dishEggOverRice      = new ItemFood("DishEggOverRice",      10, 10, false, false, false);
	public static Item dishCurryRice        = new ItemFood("DishCurryRice",        10, 10, false, false, false);
	public static Item dishBakedCorn        = new ItemFood("DishBakedCorn",        10, 10, false, false, false);
	public static Item dishToastedRiceball  = new ItemFood("DishToastedRiceball",  10, 10, false, false, false);
	public static Item dishBakedYam         = new ItemFood("DishBakedYam",         10, 10, false, false, false);
	public static Item dishToast            = new ItemFood("DishToast",            10, 10, false, false, false);
	public static Item dishJambun           = new ItemFood("DishJambun",           10, 10, false, false, false);
	public static Item dishDinnerRoll       = new ItemFood("DishDinnerRoll",       10, 10, false, false, false);
	public static Item dishPizza            = new ItemFood("DishPizza",            10, 10, false, false, false);
	public static Item dishDoria            = new ItemFood("DishDoria",            10, 10, false, false, false);
	public static Item dishGratin           = new ItemFood("DishGratin",           10, 10, false, false, false);
	public static Item dishSweetPotatoes    = new ItemFood("DishSweetPotatoes",    10, 10, false, false, false);
  //public static Item dishCookies          = new ItemFood("DishCookies",          10, 10, false, false, false);
	public static Item dishChocolateCookies = new ItemFood("DishChocolateCookies", 10, 10, false, false, false);
  //public static Item dishCake             = new ItemFood("DishCake",             10, 10, false, false, false);
	public static Item dishChocolateCake    = new ItemFood("DishChocolateCake",    10, 10, false, false, false);
	public static Item dishCheesecake       = new ItemFood("DishCheesecake",       10, 10, false, false, false);
	public static Item dishApplePie         = new ItemFood("DishApplePie",         10, 10, false, false, false);
	public static Item dishSteamedBun       = new ItemFood("DishSteamedBun",       10, 10, false, false, false);
	public static Item dishCheeseSteamedBun = new ItemFood("DishCheeseSteamedBun", 10, 10, false, false, false);
	public static Item dishShaomi           = new ItemFood("DishShaomi",           10, 10, false, false, false);
	public static Item dishSteamedEgg       = new ItemFood("DishSteamedEgg",       10, 10, false, false, false);
	public static Item dishChineseBun       = new ItemFood("DishChineseBun",       10, 10, false, false, false);
	public static Item dishCurryBun         = new ItemFood("DishCurryBun",         10, 10, false, false, false);
	public static Item dishSteamedDumplings = new ItemFood("DishSteamedDumplings", 10, 10, false, false, false);
	public static Item dishSpongeCake       = new ItemFood("DishSpongeCake",       10, 10, false, false, false);
	public static Item dishSteamedCake      = new ItemFood("DishSteamedCake",      10, 10, false, false, false);
	public static Item dishPudding          = new ItemFood("DishPudding",          10, 10, false, false, false);
	public static Item dishPumpkinPudding   = new ItemFood("DishPumpkinPudding",   10, 10, false, false, false);
	
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
	
	// Machina
	public static Block machinaWorkbench    = new MachinaWorkbench   ("MachinaWorkbench");
	public static Block machinaSewingBench  = new MachinaSewingBench ("MachinaSewingBench");
	public static Block machinaAnvil        = new MachinaAnvil       ("MachinaAnvil");
	public static Block machinaStove        = new MachinaCookingTable("MachinaCookingTable");
	public static Block machinaBlastFurnace = new MachinaBlastFurnace("MachinaBlastFurnace");
	public static Block machinaCampfire      = new MachinaCampfire    ("MachinaCampfire");
	public static Block machinaDestille     = new MachinaDestille    ("MachinaDestille");
	public static Block machinaGlobe        = new MachinaGlobe       ("MachinaGlobe");
	public static Block machinaPedestal     = new MachinaPedestal    ("MachinaPedestal");
	public static Block machinaAnchor       = new MachinaAnchor      ("MachinaAnchor");
	public static Block machinaRope         = new MachinaRope        ("MachinaRope");
	public static Block machinaKeg          = new MachinaKeg         ("MachinaKeg");
	public static Block machinaGearBox      = new MachinaGearBox     ("MachinaGearBox");
	public static Block machinaAxle         = new MachinaAxle        ("MachinaAxle");
	public static Block machinaWindmill     = new MachinaWindmill    ("MachinaWindmill");
	public static Block machinaWaterwheel   = new MachinaWaterwheel  ("MachinaWaterwheel");
	public static Block machinaFruitPress   = new MachinaFruitPress  ("MachinaFruitPress");
	public static Block machinaMillstone    = new MachinaMillstone   ("MachinaMillstone");
	
	//Sounds
	public static SoundEvent soundLlamaIdle;
	public static SoundEvent soundLlamaHurt;
	public static SoundEvent soundLlamaDeath;
	public static SoundEvent soundChocoboKweh;
	
	public static void init(){
		
		// Seeds
		seedWild = new ItemSeedWild("SeedWild");
		seedTurnip      = new ItemSeed("SeedTurnip",      cropTurnip,      Blocks.FARMLAND); ((BlockCrop) cropTurnip)     .setSeed(seedTurnip);
		seedCabbage     = new ItemSeed("SeedCabbage",     cropCabbage,     Blocks.FARMLAND); ((BlockCrop) cropCabbage)    .setSeed(seedCabbage);
		seedCucumber    = new ItemSeed("SeedCucumber",    cropCucumber,    Blocks.FARMLAND); ((BlockCrop) cropCucumber)   .setSeed(seedCucumber);
		seedStrawberry  = new ItemSeed("SeedStrawberry",  cropStrawberry,  Blocks.FARMLAND); ((BlockCrop) cropStrawberry) .setSeed(seedStrawberry);
		seedRice        = new ItemSeed("SeedRice",        cropRice,        Blocks.FARMLAND); ((BlockCrop) cropRice)       .setSeed(seedRice);
		seedOnion       = new ItemSeed("SeedOnion",       cropOnion,       Blocks.FARMLAND); ((BlockCrop) cropOnion)      .setSeed(seedOnion);
		seedCorn        = new ItemSeed("SeedCorn",        cropCorn,        Blocks.FARMLAND); ((BlockCrop) cropCorn)       .setSeed(seedCorn);
		seedTomato      = new ItemSeed("SeedTomato",      cropTomato,      Blocks.FARMLAND); ((BlockCrop) cropTomato)     .setSeed(seedTomato);
		seedGrapes      = new ItemSeed("SeedGrapes",      cropGrapes,      Blocks.FARMLAND); ((BlockCrop) cropGrapes)     .setSeed(seedGrapes);
		seedPineapple   = new ItemSeed("SeedPineapple",   cropPineapple,   Blocks.FARMLAND); ((BlockCrop) cropPineapple)  .setSeed(seedPineapple);
		seedCoffeeBeans = new ItemSeed("SeedCoffeeBeans", cropCoffeeBeans, Blocks.FARMLAND); ((BlockCrop) cropCoffeeBeans).setSeed(seedCoffeeBeans);
		seedSweetPotato = new ItemSeed("SeedSweetPotato", cropSweetPotato, Blocks.FARMLAND); ((BlockCrop) cropSweetPotato).setSeed(seedSweetPotato);
		seedEggplant    = new ItemSeed("SeedEggplant",    cropEggplant,    Blocks.FARMLAND); ((BlockCrop) cropEggplant)   .setSeed(seedEggplant);
		seedSpinach     = new ItemSeed("SeedSpinach",     cropSpinach,     Blocks.FARMLAND); ((BlockCrop) cropSpinach)    .setSeed(seedSpinach);
		seedGreenPepper = new ItemSeed("SeedGreenPepper", cropGreenPepper, Blocks.FARMLAND); ((BlockCrop) cropGreenPepper).setSeed(seedGreenPepper);
		seedHemp        = new ItemSeed("SeedHemp",        cropHemp,        Blocks.FARMLAND); ((BlockCrop) cropHemp)       .setSeed(seedHemp);
		seedCotton      = new ItemSeed("SeedCotton",      cropCotton,      Blocks.FARMLAND); ((BlockCrop) cropCotton)     .setSeed(seedCotton);
		MinecraftForge.addGrassSeed(new ItemStack(seedWild), 10000000);
		
		// Beds
		bedBlockBlack     = new BlockBed("BedBlockBlack");     bedItemBlack     = new ItemBed("BedItemBlack",     bedBlockBlack);     ((BlockBed) bedBlockBlack)    .setItem(bedItemBlack);
		bedBlockRed       = new BlockBed("BedBlockRed");       bedItemRed       = new ItemBed("BedItemRed",       bedBlockRed);       ((BlockBed) bedBlockRed)      .setItem(bedItemRed);
		bedBlockGreen     = new BlockBed("BedBlockGreen");     bedItemGreen     = new ItemBed("BedItemGreen",     bedBlockGreen);     ((BlockBed) bedBlockGreen)    .setItem(bedItemGreen);
		bedBlockBrown     = new BlockBed("BedBlockBrown");     bedItemBrown     = new ItemBed("BedItemBrown",     bedBlockBrown);     ((BlockBed) bedBlockBrown)    .setItem(bedItemBrown);
		bedBlockBlue      = new BlockBed("BedBlockBlue");      bedItemBlue      = new ItemBed("BedItemBlue",      bedBlockBlue);      ((BlockBed) bedBlockBlue)     .setItem(bedItemBlue);
		bedBlockPurple    = new BlockBed("BedBlockPurple");    bedItemPurple    = new ItemBed("BedItemPurple",    bedBlockPurple);    ((BlockBed) bedBlockPurple)   .setItem(bedItemPurple);
		bedBlockCyan      = new BlockBed("BedBlockCyan");      bedItemCyan      = new ItemBed("BedItemCyan",      bedBlockCyan);      ((BlockBed) bedBlockCyan)     .setItem(bedItemCyan);
		bedBlockSilver    = new BlockBed("BedBlockSilver");    bedItemSilver    = new ItemBed("BedItemSilver",    bedBlockSilver);    ((BlockBed) bedBlockSilver)   .setItem(bedItemSilver);
		bedBlockGrey      = new BlockBed("BedBlockGrey");      bedItemGrey      = new ItemBed("BedItemGrey",      bedBlockGrey);      ((BlockBed) bedBlockGrey)     .setItem(bedItemGrey);
		bedBlockPink      = new BlockBed("BedBlockPink");      bedItemPink      = new ItemBed("BedItemPink",      bedBlockPink);      ((BlockBed) bedBlockPink)     .setItem(bedItemPink);
		bedBlockLime      = new BlockBed("BedBlockLime");      bedItemLime      = new ItemBed("BedItemLime",      bedBlockLime);      ((BlockBed) bedBlockLime)     .setItem(bedItemLime);
		bedBlockYellow    = new BlockBed("BedBlockYellow");    bedItemYellow    = new ItemBed("BedItemYellow",    bedBlockYellow);    ((BlockBed) bedBlockYellow)   .setItem(bedItemYellow);
		bedBlockLightBlue = new BlockBed("BedBlockLightBlue"); bedItemLightBlue = new ItemBed("BedItemLightBlue", bedBlockLightBlue); ((BlockBed) bedBlockLightBlue).setItem(bedItemLightBlue);
		bedBlockMagenta   = new BlockBed("BedBlockMagenta");   bedItemMagenta   = new ItemBed("BedItemMagenta",   bedBlockMagenta);   ((BlockBed) bedBlockMagenta)  .setItem(bedItemMagenta);
		bedBlockOrange    = new BlockBed("BedBlockOrange");    bedItemOrange    = new ItemBed("BedItemOrange",    bedBlockOrange);    ((BlockBed) bedBlockOrange)   .setItem(bedItemOrange);
		bedBlockWhite     = new BlockBed("BedBlockWhite");     bedItemWhite     = new ItemBed("BedItemWhite",     bedBlockWhite);     ((BlockBed) bedBlockWhite)    .setItem(bedItemWhite);
	}
	
	public static void registerStuff(boolean pre){
		
		// Full Blocks
		registerBlock(blockCopper,     pre);
		registerBlock(blockAluminium,  pre);
		registerBlock(blockLead,       pre);
		registerBlock(blockTin,        pre);
		registerBlock(blockZinc,       pre);
		registerBlock(blockSilver,     pre);
		registerBlock(blockMythril,    pre);
		registerBlock(blockIridium,    pre);
		registerBlock(blockAdamantium, pre);
		registerBlock(blockOrichalcum, pre);
		registerBlock(blockUnobtanium, pre);
		registerBlock(blockBrass,      pre);
		registerBlock(blockBronze,     pre);
		registerBlock(blockSteel,      pre);
		registerBlock(blockRuby,       pre);
		registerBlock(blockTourmaline, pre);
		registerBlock(blockTopaz,      pre);
		registerBlock(blockSaphire,    pre);
		registerBlock(blockAquamarine, pre);
		registerBlock(blockPyrite,     pre);
		registerBlock(blockAmethyst,   pre);
		registerBlock(blockGagat,      pre);
		registerBlock(blockOpal,       pre);
		registerBlock(blockSalt,       pre);
		registerBlock(blockSulfur,     pre);
		registerBlock(blockFlour,      pre);
		registerBlock(blockCurry,      pre);
		registerBlock(blockCoffee,     pre);
		registerBlock(blockMeteor,     pre);
		
		// Ore Blocks
		registerBlock(oreCopper,     pre);
		registerBlock(oreBauxite,    pre);
		registerBlock(oreLead,       pre);
		registerBlock(oreTin,        pre);
		registerBlock(oreZinc,       pre);
		registerBlock(oreSilver,     pre);
		registerBlock(oreMythril,    pre);
		registerBlock(oreIridium,    pre);
		registerBlock(oreAdamantium, pre);
		registerBlock(oreOrichalcum, pre);
		registerBlock(oreUnobtanium, pre);
		registerBlock(oreRuby,       pre);
		registerBlock(oreTourmaline, pre);
		registerBlock(oreTopaz,      pre);
		registerBlock(oreSaphire,    pre);
		registerBlock(oreAquamarine, pre);
		registerBlock(orePyrite,     pre);
		registerBlock(oreAmethyst,   pre);
		registerBlock(oreGagat,      pre);
		registerBlock(oreOpal,       pre);
		registerBlock(oreSalt,       pre);
		registerBlock(oreSulfur,     pre);
		
		// Nuggets
		registerItem(nuggetIron,       pre);
		registerItem(nuggetGold,       pre);
		registerItem(nuggetCopper,     pre);
		registerItem(nuggetBauxite,    pre);
		registerItem(nuggetLead,       pre);
		registerItem(nuggetTin,        pre);
		registerItem(nuggetZinc,       pre);
		registerItem(nuggetSilver,     pre);
		registerItem(nuggetMythril,    pre);
		registerItem(nuggetIridium,    pre);
		registerItem(nuggetAdamantium, pre);
		registerItem(nuggetOrichalcum, pre);
		registerItem(nuggetUnobtanium, pre);
		
		// Gemstones
		registerItem(gemRuby,       pre);
		registerItem(gemTourmaline, pre);
		registerItem(gemTopaz,      pre);
		registerItem(gemSaphire,    pre);
		registerItem(gemAquamarine, pre);
		registerItem(gemPyrite,     pre);
		registerItem(gemAmethyst,   pre);
		registerItem(gemGagat,      pre);
		registerItem(gemOpal,       pre);
		
		// Powders
		registerItem(powderSalt,       pre);
		registerItem(powderSulfur,     pre);
		registerItem(powderFlour,      pre);
		registerItem(powderCurry,      pre);
		registerItem(powderCoffee,     pre);
		
		// Ingots
		registerItem(ingotCopper,     pre);
		registerItem(ingotAluminium,  pre);
		registerItem(ingotLead,       pre);
		registerItem(ingotTin,        pre);
		registerItem(ingotZinc,       pre);
		registerItem(ingotSilver,     pre);
		registerItem(ingotMythril,    pre);
		registerItem(ingotAdamantium, pre);
		registerItem(ingotOrichalcum, pre);
		registerItem(ingotUnobtanium, pre);
		registerItem(ingotBrass,      pre);
		registerItem(ingotBronze,     pre);
		registerItem(ingotSteel,      pre);
		
		// Tools
		registerItem(toolFryingPan,         pre);
		registerItem(toolAxeFlint,          pre);
		registerItem(toolAxeCopper,         pre);
		registerItem(toolAxeMythril,        pre);
		registerItem(toolAxeIridium,        pre);
		registerItem(toolAxeAdamantium,     pre);
		registerItem(toolAxeUnobtanium,     pre);
		registerItem(toolAxeBronze,         pre);
		registerItem(toolAxeSteel,          pre);
		registerItem(toolHammerIron,        pre);
		registerItem(toolHammerGold,        pre);
		registerItem(toolHammerFlint,       pre);
		registerItem(toolHammerCopper,      pre);
		registerItem(toolHammerMythril,     pre);
		registerItem(toolHammerIridium,     pre);
		registerItem(toolHammerAdamantium,  pre);
		registerItem(toolHammerUnobtanium,  pre);
		registerItem(toolHammerBronze,      pre);
		registerItem(toolHammerSteel,       pre);
		registerItem(toolHoeFlint,          pre);
		registerItem(toolHoeCopper,         pre);
		registerItem(toolHoeMythril,        pre);
		registerItem(toolHoeIridium,        pre);
		registerItem(toolHoeAdamantium,     pre);
		registerItem(toolHoeUnobtanium,     pre);
		registerItem(toolHoeBronze,         pre);
		registerItem(toolHoeSteel,          pre);
		registerItem(toolPickaxeFlint,      pre);
		registerItem(toolPickaxeCopper,     pre);
		registerItem(toolPickaxeMythril,    pre);
		registerItem(toolPickaxeIridium,    pre);
		registerItem(toolPickaxeAdamantium, pre);
		registerItem(toolPickaxeUnobtanium, pre);
		registerItem(toolPickaxeBronze,     pre);
		registerItem(toolPickaxeSteel,      pre);
		registerItem(toolShovelFlint,       pre);
		registerItem(toolShovelCopper,      pre);
		registerItem(toolShovelMythril,     pre);
		registerItem(toolShovelIridium,     pre);
		registerItem(toolShovelAdamantium,  pre);
		registerItem(toolShovelUnobtanium,  pre);
		registerItem(toolShovelBronze,      pre);
		registerItem(toolShovelSteel,       pre);
		registerItem(toolSpearIron,         pre);
		registerItem(toolSpearGold,         pre);
		registerItem(toolSpearFlint,        pre);
		registerItem(toolSpearCopper,       pre);
		registerItem(toolSpearMythril,      pre);
		registerItem(toolSpearIridium,      pre);
		registerItem(toolSpearAdamantium,   pre);
		registerItem(toolSpearUnobtanium,   pre);
		registerItem(toolSpearBronze,       pre);
		registerItem(toolSpearSteel,        pre);
		registerItem(toolSwordFlint,        pre);
		registerItem(toolSwordCopper,       pre);
		registerItem(toolSwordMythril,      pre);
		registerItem(toolSwordIridium,      pre);
		registerItem(toolSwordAdamantium,   pre);
		registerItem(toolSwordUnobtanium,   pre);
		registerItem(toolSwordBronze,       pre);
		registerItem(toolSwordSteel,        pre);
		
		// Armor
		registerItem(armorBootsCopper,          pre);
		registerItem(armorBootsAluminium,       pre);
		registerItem(armorBootsLead,            pre);
		registerItem(armorBootsMythril,         pre);
		registerItem(armorBootsAdamantium,      pre);
		registerItem(armorBootsUnobtanium,      pre);
		registerItem(armorBootsBronze,          pre);
		registerItem(armorBootsSteel,           pre);
		registerItem(armorChestplateCopper,     pre);
		registerItem(armorChestplateAluminium,  pre);
		registerItem(armorChestplateLead,       pre);
		registerItem(armorChestplateMythril,    pre);
		registerItem(armorChestplateAdamantium, pre);
		registerItem(armorChestplateUnobtanium, pre);
		registerItem(armorChestplateBronze,     pre);
		registerItem(armorChestplateSteel,      pre);
		registerItem(armorHelmetCopper,         pre);
		registerItem(armorHelmetAluminium,      pre);
		registerItem(armorHelmetLead,           pre);
		registerItem(armorHelmetMythril,        pre);
		registerItem(armorHelmetAdamantium,     pre);
		registerItem(armorHelmetUnobtanium,     pre);
		registerItem(armorHelmetBronze,         pre);
		registerItem(armorHelmetSteel,          pre);
		registerItem(armorLeggingsCopper,       pre);
		registerItem(armorLeggingsAluminium,    pre);
		registerItem(armorLeggingsLead,         pre);
		registerItem(armorLeggingsMythril,      pre);
		registerItem(armorLeggingsAdamantium,   pre);
		registerItem(armorLeggingsUnobtanium,   pre);
		registerItem(armorLeggingsBronze,       pre);
		registerItem(armorLeggingsSteel,        pre);
		
		// Machina
		registerBlock(machinaWorkbench,    pre);
		registerBlock(machinaSewingBench,  pre);
		registerBlock(machinaAnvil,        pre);
		registerBlock(machinaStove,        pre);
		registerBlock(machinaBlastFurnace, pre);
		registerBlock(machinaCampfire,      pre);
		registerBlock(machinaDestille,     pre);
		registerBlock(machinaGlobe,        pre);
		registerBlock(machinaPedestal,     pre);
		registerBlock(machinaAnchor,       pre);
		registerBlock(machinaRope,         pre);
		registerBlock(machinaKeg,          pre);
		registerBlock(machinaGearBox,      pre);
		registerBlock(machinaAxle,         pre);
		registerBlock(machinaWindmill,     pre);
		registerBlock(machinaWaterwheel,   pre);
		registerBlock(machinaFruitPress,   pre);
		registerBlock(machinaMillstone,    pre);
		
		// Stuff
		registerItem(stuffFur,        pre);
		registerItem(stuffIvory,      pre);
		registerItem(stuffBeastShell, pre);
		registerItem(stuffHemp,       pre);
		registerItem(stuffCotton,     pre);
		registerItem(stuffRope,       pre);
		registerItem(stuffClothLinen, pre);
		registerItem(stuffClothWool,  pre);
		registerItem(stuffClothSilk,  pre);
		registerItem(stuffGear,       pre);
				
		// Explosives
		registerItem(explosiveDynamite, pre);
		
		// Food
		registerItem(foodGrandMeatRaw,    pre);
		registerItem(foodGrandMeatCooked, pre);
		registerItem(foodVenisonRaw,      pre);
		registerItem(foodVenisonCooked,   pre);
		registerItem(foodVicugnaRaw,      pre);
		registerItem(foodVicugnaCooked,   pre);
		registerItem(foodFishCrab,        pre);
		registerItem(foodFishSquid,       pre);
		
		registerItem(foodBambooShoot, pre);
		registerItem(foodTurnip,      pre);
		registerItem(foodCabbage,     pre);
		registerItem(foodCucumber,    pre);
		registerItem(foodStrawberry,  pre);
		registerItem(foodRice,        pre);
		registerItem(foodOnion,       pre);
		registerItem(foodCorn,        pre);
		registerItem(foodTomato,      pre);
		registerItem(foodGrapes,      pre);
		registerItem(foodPineapple,   pre);
		registerItem(foodCoffeeBeans, pre);
		registerItem(foodSweetPotato, pre);
		registerItem(foodEggplant,    pre);
		registerItem(foodSpinach,     pre);
		registerItem(foodGreenPepper, pre);
		registerItem(foodLemon,       pre);
		registerItem(foodPeach,       pre);
		registerItem(foodOrange,      pre);
		registerItem(foodCherries,    pre);
		registerItem(foodBanana,      pre);
		registerItem(foodCheese,      pre);
		registerItem(foodButter,      pre);
		
		registerBlock(cropTurnip,      pre);
		registerBlock(cropCabbage,     pre);
		registerBlock(cropCucumber,    pre);
		registerBlock(cropStrawberry,  pre);
		registerBlock(cropRice,        pre);
		registerBlock(cropOnion,       pre);
		registerBlock(cropCorn,        pre);
		registerBlock(cropTomato,      pre);
		registerBlock(cropGrapes,      pre);
		registerBlock(cropPineapple,   pre);
		registerBlock(cropCoffeeBeans, pre);
		registerBlock(cropSweetPotato, pre);
		registerBlock(cropEggplant,    pre);
		registerBlock(cropSpinach,     pre);
		registerBlock(cropGreenPepper, pre);
		registerBlock(cropHemp,        pre);
		registerBlock(cropCotton,      pre);
		
		registerItem(seedWild,        pre);
		registerItem(seedTurnip,      pre);
		registerItem(seedCabbage,     pre);
		registerItem(seedCucumber,    pre);
		registerItem(seedStrawberry,  pre);
		registerItem(seedRice,        pre);
		registerItem(seedOnion,       pre);
		registerItem(seedCorn,        pre);
		registerItem(seedTomato,      pre);
		registerItem(seedGrapes,      pre);
		registerItem(seedPineapple,   pre);
		registerItem(seedCoffeeBeans, pre);
		registerItem(seedSweetPotato, pre);
		registerItem(seedEggplant,    pre);
		registerItem(seedSpinach,     pre);
		registerItem(seedGreenPepper, pre);
		registerItem(seedHemp,        pre);
		registerItem(seedCotton,      pre);
		
		registerBlock(saplingApple,    pre);
		registerBlock(saplingLemon,    pre);
		registerBlock(saplingPeach,    pre);
		registerBlock(saplingOrange,   pre);
		registerBlock(saplingCherries, pre);
		registerBlock(saplingBanana,   pre);
		
		registerBlock(fruitApple,    pre);
		registerBlock(fruitLemon,    pre);
		registerBlock(fruitPeach,    pre);
		registerBlock(fruitOrange,   pre);
		registerBlock(fruitCherries, pre);
		registerBlock(fruitBanana,   pre);
		
		// Juices
		registerItem(juiceApple          , pre);
		registerItem(juiceGrapes         , pre);
		registerItem(juicePineapple      , pre);
		registerItem(juiceStrawberry     , pre);
		registerItem(juiceLemon          , pre);
		registerItem(juicePeach          , pre);
		registerItem(juiceOrange         , pre);
		registerItem(juiceCherries       , pre);
		registerItem(juiceBanana         , pre);
		registerItem(juiceMilk           , pre);
		registerItem(juiceHotMilk        , pre);
		registerItem(juiceHotChocolate   , pre);
		registerItem(juiceCoffee         , pre);
		registerItem(juiceOil            , pre);
		
		// Liquor
		registerItem(liquorCider      , pre);
		registerItem(liquorRum        , pre);
		registerItem(liquorBeer       , pre);
		registerItem(liquorSalgam     , pre);
		registerItem(liquorVodka      , pre);
		registerItem(liquorSake       , pre);
		registerItem(liquorMead       , pre);
		registerItem(liquorWineGrapes , pre);
		registerItem(liquorWineCherry , pre);
		registerItem(liquorWinePines  , pre);
		
		// Dishes
		registerItem(dishSeaSaltIceCream  , pre);
		registerItem(dishSalad            , pre);
		registerItem(dishSandwich         , pre);
		registerItem(dishFruitSandwich    , pre);
		registerItem(dishPickledTurnips   , pre);
		registerItem(dishPickledCucumber  , pre);
		registerItem(dishBambooRice       , pre);
		registerItem(dishMushroomRice     , pre);
		registerItem(dishSushi            , pre);
		registerItem(dishRaisinBread      , pre);
		registerItem(dishChirashiSushi    , pre);
		registerItem(dishIceCream         , pre);
		registerItem(dishStirFry          , pre);
		registerItem(dishFriedRice        , pre);
		registerItem(dishSavoryPancake    , pre);
		registerItem(dishFrenchFries      , pre);
		registerItem(dishCroquette        , pre);
		registerItem(dishPopcorn          , pre);
		registerItem(dishCornflakes       , pre);
		registerItem(dishHappyEggplant    , pre);
		registerItem(dishScrambledEggs    , pre);
		registerItem(dishOmelet           , pre);
		registerItem(dishOmeletRice       , pre);
		registerItem(dishAppleSouffle     , pre);
		registerItem(dishCurryBread       , pre);
		registerItem(dishFrenchToast      , pre);
		registerItem(dishDoughnut         , pre);
		registerItem(dishFriedNoodles     , pre);
		registerItem(dishTempura          , pre);
		registerItem(dishPancake          , pre);
		registerItem(dishPotSticker       , pre);
		registerItem(dishRisotto          , pre);
		registerItem(dishDryCurry         , pre);
		registerItem(dishStew             , pre);
		registerItem(dishPumpkinStew      , pre);
		registerItem(dishFishStew         , pre);
		registerItem(dishMountainStew     , pre);
		registerItem(dishBoiledSpinach    , pre);
		registerItem(dishBoiledEgg        , pre);
		registerItem(dishCandiedPotato    , pre);
		registerItem(dishDumplings        , pre);
		registerItem(dishStrawberryJam    , pre);
		registerItem(dishAppleJam         , pre);
		registerItem(dishPeachJam         , pre);
		registerItem(dishGrapeJam         , pre);
		registerItem(dishMarmelade        , pre);
		registerItem(dishCheeseFondue     , pre);
		registerItem(dishNoodles          , pre);
		registerItem(dishCurryNoodles     , pre);
		registerItem(dishTempuraNoodles   , pre);
		registerItem(dishRiceSoup         , pre);
		registerItem(dishPorridge         , pre);
		registerItem(dishTempuraRice      , pre);
		registerItem(dishEggOverRice      , pre);
		registerItem(dishCurryRice        , pre);
		registerItem(dishBakedCorn        , pre);
		registerItem(dishToastedRiceball  , pre);
		registerItem(dishBakedYam         , pre);
		registerItem(dishToast            , pre);
		registerItem(dishJambun           , pre);
		registerItem(dishDinnerRoll       , pre);
		registerItem(dishPizza            , pre);
		registerItem(dishDoria            , pre);
		registerItem(dishGratin           , pre);
		registerItem(dishSweetPotatoes    , pre);
	  //registerItem(dishCookies          , pre);
		registerItem(dishChocolateCookies , pre);
	  //registerItem(dishCake             , pre);
		registerItem(dishChocolateCake    , pre);
		registerItem(dishCheesecake       , pre);
		registerItem(dishApplePie         , pre);
		registerItem(dishSteamedBun       , pre);
		registerItem(dishCheeseSteamedBun , pre);
		registerItem(dishShaomi           , pre);
		registerItem(dishSteamedEgg       , pre);
		registerItem(dishChineseBun       , pre);
		registerItem(dishCurryBun         , pre);
		registerItem(dishSteamedDumplings , pre);
		registerItem(dishSpongeCake       , pre);
		registerItem(dishSteamedCake      , pre);
		registerItem(dishPudding          , pre);
		registerItem(dishPumpkinPudding   , pre);
		
		// Beds
		registerBlockAndItem(bedBlockBlack,     bedItemBlack,     pre);
		registerBlockAndItem(bedBlockRed,       bedItemRed,       pre);
		registerBlockAndItem(bedBlockGreen,     bedItemGreen,     pre);
		registerBlockAndItem(bedBlockBrown,     bedItemBrown,     pre);
		registerBlockAndItem(bedBlockBlue,      bedItemBlue,      pre);
		registerBlockAndItem(bedBlockPurple,    bedItemPurple,    pre);
		registerBlockAndItem(bedBlockCyan,      bedItemCyan,      pre);
		registerBlockAndItem(bedBlockSilver,    bedItemSilver,    pre);
		registerBlockAndItem(bedBlockGrey,      bedItemGrey,      pre);
		registerBlockAndItem(bedBlockPink,      bedItemPink,      pre);
		registerBlockAndItem(bedBlockLime,      bedItemLime,      pre);
		registerBlockAndItem(bedBlockYellow,    bedItemYellow,    pre);
		registerBlockAndItem(bedBlockLightBlue, bedItemLightBlue, pre);
		registerBlockAndItem(bedBlockMagenta,   bedItemMagenta,   pre);
		registerBlockAndItem(bedBlockOrange,    bedItemOrange,    pre);
		registerBlockAndItem(bedBlockWhite,     bedItemWhite,     pre);
	}
	
	public static void registerSounds() {
		soundLlamaIdle   = registerSound("sound.llamaidle");
		soundLlamaHurt   = registerSound("sound.llamahurt");
		soundLlamaDeath  = registerSound("sound.llamadeath");
		soundChocoboKweh = registerSound("sound.chocobokweh");
		
	}
	
	public static void registerRecipes(){
		//Recipe Remover
		RecipeRemover.removeCraftingRecipe();
		RecipeRemover.removeFurnaceRecipe();
		
		//Changed Vanilla Recipes
		GameRegistry.addShapelessRecipe(new ItemStack(Items.MAP, 1), new ItemStack(Items.PAPER), new ItemStack(Items.FEATHER), new ItemStack(Items.DYE,1,0), new ItemStack(Items.DYE,1,1), new ItemStack(Items.DYE,1,11));
		
		//GameRegistry.addShapelessRecipe(new ItemStack(Items.bucket),    new ItemStack(bucketIronEmpty));
		//GameRegistry.addShapelessRecipe(new ItemStack(bucketIronEmpty), new ItemStack(Items.bucket));
		GameRegistry.addShapelessRecipe(new ItemStack(Items.GUNPOWDER), new ItemStack(Items.COAL), new ItemStack(powderSalt), new ItemStack(powderSulfur));
		
		GameRegistry.addRecipe(new ItemStack(Items.LEAD                     ), new Object[]{ "X" , "X"  ,        'X', stuffRope                                                              });
		GameRegistry.addRecipe(new ItemStack(Blocks.ENCHANTING_TABLE        ), new Object[]{" B ", "GOG", "OOO", 'B', Items.BOOK,                 'G', Items.EMERALD, 'O', Blocks.OBSIDIAN});
		GameRegistry.addRecipe(new ItemStack(Blocks.ENCHANTING_TABLE        ), new Object[]{" B ", "GOG", "OOO", 'B', Items.BOOK,                 'G', gemRuby,       'O', Blocks.OBSIDIAN});
		GameRegistry.addRecipe(new ItemStack(Blocks.ENCHANTING_TABLE        ), new Object[]{" B ", "GOG", "OOO", 'B', Items.BOOK,                 'G', gemTourmaline, 'O', Blocks.OBSIDIAN});
		GameRegistry.addRecipe(new ItemStack(Blocks.ENCHANTING_TABLE        ), new Object[]{" B ", "GOG", "OOO", 'B', Items.BOOK,                 'G', gemTopaz,      'O', Blocks.OBSIDIAN});
		GameRegistry.addRecipe(new ItemStack(Blocks.ENCHANTING_TABLE        ), new Object[]{" B ", "GOG", "OOO", 'B', Items.BOOK,                 'G', gemSaphire,    'O', Blocks.OBSIDIAN});
		GameRegistry.addRecipe(new ItemStack(Blocks.ENCHANTING_TABLE        ), new Object[]{" B ", "GOG", "OOO", 'B', Items.BOOK,                 'G', gemAquamarine, 'O', Blocks.OBSIDIAN});
		GameRegistry.addRecipe(new ItemStack(Blocks.ENCHANTING_TABLE        ), new Object[]{" B ", "GOG", "OOO", 'B', Items.BOOK,                 'G', gemPyrite,      'O', Blocks.OBSIDIAN});
		GameRegistry.addRecipe(new ItemStack(Blocks.ENCHANTING_TABLE        ), new Object[]{" B ", "GOG", "OOO", 'B', Items.BOOK,                 'G', gemAmethyst,   'O', Blocks.OBSIDIAN});
		GameRegistry.addRecipe(new ItemStack(Blocks.ENCHANTING_TABLE        ), new Object[]{" B ", "GOG", "OOO", 'B', Items.BOOK,                 'G', gemGagat,      'O', Blocks.OBSIDIAN});
		GameRegistry.addRecipe(new ItemStack(Blocks.ENCHANTING_TABLE        ), new Object[]{" B ", "GOG", "OOO", 'B', Items.BOOK,                 'G', gemOpal,       'O', Blocks.OBSIDIAN});
		
		//Custom Simple Recipes
		//GameRegistry.addRecipe(new ItemStack(Items.bucket     ), new Object[]{"X" , 'X', bucketIronEmpty});
		//GameRegistry.addRecipe(new ItemStack(bucketIronEmpty     ), new Object[]{"X" , 'X', Items.bucket});
		GameRegistry.addRecipe(new ItemStack(Items.FLINT        ), new Object[]{"OO" , "OO" ,        'O', Blocks.GRAVEL                            });
		GameRegistry.addRecipe(new ItemStack(blockSalt          ), new Object[]{"XXX", "XXX", "XXX", 'X', powderSalt                               });
		GameRegistry.addRecipe(new ItemStack(blockSulfur        ), new Object[]{"XXX", "XXX", "XXX", 'X', powderSulfur                             });
		GameRegistry.addRecipe(new ItemStack(blockFlour         ), new Object[]{"XXX", "XXX", "XXX", 'X', powderFlour                              });
		GameRegistry.addRecipe(new ItemStack(blockCurry         ), new Object[]{"XXX", "XXX", "XXX", 'X', powderCurry                              });
		GameRegistry.addRecipe(new ItemStack(blockCoffee        ), new Object[]{"XXX", "XXX", "XXX", 'X', powderCoffee                             });
		GameRegistry.addRecipe(new ItemStack(blockRuby          ), new Object[]{"XXX", "XXX", "XXX", 'X', gemRuby                                  });
		GameRegistry.addRecipe(new ItemStack(blockTourmaline    ), new Object[]{"XXX", "XXX", "XXX", 'X', gemTourmaline                            });
		GameRegistry.addRecipe(new ItemStack(blockTopaz         ), new Object[]{"XXX", "XXX", "XXX", 'X', gemTopaz                                 });
		GameRegistry.addRecipe(new ItemStack(blockSaphire       ), new Object[]{"XXX", "XXX", "XXX", 'X', gemSaphire                               });
		GameRegistry.addRecipe(new ItemStack(blockAquamarine    ), new Object[]{"XXX", "XXX", "XXX", 'X', gemAquamarine                            });
		GameRegistry.addRecipe(new ItemStack(blockPyrite        ), new Object[]{"XXX", "XXX", "XXX", 'X', gemPyrite                                });
		GameRegistry.addRecipe(new ItemStack(blockAmethyst      ), new Object[]{"XXX", "XXX", "XXX", 'X', gemAmethyst                              });
		GameRegistry.addRecipe(new ItemStack(blockGagat         ), new Object[]{"XXX", "XXX", "XXX", 'X', gemGagat                                 });
		GameRegistry.addRecipe(new ItemStack(blockOpal          ), new Object[]{"XXX", "XXX", "XXX", 'X', gemOpal                                  });
		GameRegistry.addRecipe(new ItemStack(toolAxeFlint       ), new Object[]{"XX" , "XI" , " I" , 'X', Items.FLINT,      'I', Items.STICK       });
		GameRegistry.addRecipe(new ItemStack(toolHoeFlint       ), new Object[]{"XX" , " I" , " I" , 'X', Items.FLINT,      'I', Items.STICK       });
		GameRegistry.addRecipe(new ItemStack(toolPickaxeFlint   ), new Object[]{"XXX", " I ", " I ", 'X', Items.FLINT,      'I', Items.STICK       });
		GameRegistry.addRecipe(new ItemStack(toolShovelFlint    ), new Object[]{ "X" ,  "I" ,  "I" , 'X', Items.FLINT,      'I', Items.STICK       });
		GameRegistry.addRecipe(new ItemStack(toolSwordFlint     ), new Object[]{ "X" ,  "X" ,  "I" , 'X', Items.FLINT,      'I', Items.STICK       });
		GameRegistry.addRecipe(new ItemStack(toolSpearFlint     ), new Object[]{"  X", " I ", "I  ", 'X', Items.FLINT,      'I', Items.STICK       });
		GameRegistry.addRecipe(new ItemStack(machinaWorkbench   ), new Object[]{"XXX", "XXX", "XXX", 'X', Blocks.PLANKS                            });
		GameRegistry.addRecipe(new ItemStack(machinaCampfire    ), new Object[]{"LL" , "OO" ,        'L', Blocks.LOG,       'O', Blocks.COBBLESTONE});
		GameRegistry.addRecipe(new ItemStack(machinaCampfire    ), new Object[]{"LL" , "OO" ,        'L', Blocks.LOG2,      'O', Blocks.COBBLESTONE});
		GameRegistry.addRecipe(new ItemStack(machinaCampfire    ), new Object[]{"LL" , "OO" ,        'L', Blocks.LOG,       'O', Blocks.GRAVEL     });
		GameRegistry.addRecipe(new ItemStack(machinaCampfire    ), new Object[]{"LL" , "OO" ,        'L', Blocks.LOG2,      'O', Blocks.GRAVEL     });
		GameRegistry.addRecipe(new ItemStack(bedItemWhite       ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.WOOL, 1,  0), 'P', Blocks.PLANKS});
		GameRegistry.addRecipe(new ItemStack(bedItemOrange      ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.WOOL, 1,  1), 'P', Blocks.PLANKS});
		GameRegistry.addRecipe(new ItemStack(bedItemMagenta     ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.WOOL, 1,  2), 'P', Blocks.PLANKS});
		GameRegistry.addRecipe(new ItemStack(bedItemLightBlue   ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.WOOL, 1,  3), 'P', Blocks.PLANKS});
		GameRegistry.addRecipe(new ItemStack(bedItemYellow      ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.WOOL, 1,  4), 'P', Blocks.PLANKS});
		GameRegistry.addRecipe(new ItemStack(bedItemLime        ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.WOOL, 1,  5), 'P', Blocks.PLANKS});
		GameRegistry.addRecipe(new ItemStack(bedItemPink        ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.WOOL, 1,  6), 'P', Blocks.PLANKS});
		GameRegistry.addRecipe(new ItemStack(bedItemGrey        ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.WOOL, 1,  7), 'P', Blocks.PLANKS});
		GameRegistry.addRecipe(new ItemStack(bedItemSilver      ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.WOOL, 1,  8), 'P', Blocks.PLANKS});
		GameRegistry.addRecipe(new ItemStack(bedItemCyan        ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.WOOL, 1,  9), 'P', Blocks.PLANKS});
		GameRegistry.addRecipe(new ItemStack(bedItemPurple      ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.WOOL, 1, 10), 'P', Blocks.PLANKS});
		GameRegistry.addRecipe(new ItemStack(bedItemBlue        ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.WOOL, 1, 11), 'P', Blocks.PLANKS});
		GameRegistry.addRecipe(new ItemStack(bedItemBrown       ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.WOOL, 1, 12), 'P', Blocks.PLANKS});
		GameRegistry.addRecipe(new ItemStack(bedItemGreen       ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.WOOL, 1, 13), 'P', Blocks.PLANKS});
		GameRegistry.addRecipe(new ItemStack(bedItemRed         ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.WOOL, 1, 14), 'P', Blocks.PLANKS});
		GameRegistry.addRecipe(new ItemStack(bedItemBlack       ), new Object[]{"WWW", "PPP",        'W', new ItemStack(Blocks.WOOL, 1, 15), 'P', Blocks.PLANKS});
	}
	
	public static void registerSmelting(){
		//Smelting Ore
		GameRegistry.addSmelting(oreCopper,     new ItemStack(ingotCopper,     1), 1);
		GameRegistry.addSmelting(oreBauxite,    new ItemStack(ingotAluminium,  1), 1);
		GameRegistry.addSmelting(oreLead,       new ItemStack(ingotLead,       1), 1);
		GameRegistry.addSmelting(oreTin,        new ItemStack(ingotTin,        1), 1);
		GameRegistry.addSmelting(oreZinc,       new ItemStack(ingotZinc,       1), 1);
		GameRegistry.addSmelting(oreSilver,     new ItemStack(ingotSilver,     1), 1);
		GameRegistry.addSmelting(oreMythril,    new ItemStack(ingotMythril,    1), 1);
		GameRegistry.addSmelting(oreAdamantium, new ItemStack(ingotAdamantium, 1), 1);
		GameRegistry.addSmelting(oreOrichalcum, new ItemStack(ingotOrichalcum, 1), 1);
		GameRegistry.addSmelting(oreUnobtanium, new ItemStack(ingotUnobtanium, 1), 1);
		
		//Smelting Nugget
		GameRegistry.addSmelting(nuggetIron,       new ItemStack(Items.IRON_INGOT, 1), 1);
		GameRegistry.addSmelting(nuggetGold,       new ItemStack(Items.GOLD_INGOT, 1), 1);
		GameRegistry.addSmelting(nuggetCopper,     new ItemStack(ingotCopper,      1), 1);
		GameRegistry.addSmelting(nuggetBauxite,    new ItemStack(ingotAluminium,   1), 1);
		GameRegistry.addSmelting(nuggetLead,       new ItemStack(ingotLead,        1), 1);
		GameRegistry.addSmelting(nuggetTin,        new ItemStack(ingotTin,         1), 1);
		GameRegistry.addSmelting(nuggetZinc,       new ItemStack(ingotZinc,        1), 1);
		GameRegistry.addSmelting(nuggetSilver,     new ItemStack(ingotSilver,      1), 1);
		GameRegistry.addSmelting(nuggetMythril,    new ItemStack(ingotMythril,     1), 1);
		GameRegistry.addSmelting(nuggetAdamantium, new ItemStack(ingotAdamantium,  1), 1);
		GameRegistry.addSmelting(nuggetOrichalcum, new ItemStack(ingotOrichalcum,  1), 1);
		GameRegistry.addSmelting(nuggetUnobtanium, new ItemStack(ingotUnobtanium,  1), 1);
	}
	
	public static void registerEntities(){
		EntityRegistry.registerModEntity(EntityNugget  .class, "EntityNugget",    0, AceCraft.instance, 64, 20, true);
		EntityRegistry.registerModEntity(EntitySpear   .class, "EntitySpear",     1, AceCraft.instance, 64, 20, true);
		EntityRegistry.registerModEntity(EntityDynamite.class, "EntityDynamite",  2, AceCraft.instance, 64, 20, true);
		EntityRegistry.registerModEntity(EntityMammoth .class, "EntityMammoth",  10, AceCraft.instance, 80,  3, true, 123456, 234567);
		EntityRegistry.registerModEntity(EntityLlama   .class, "EntityLlama",    11, AceCraft.instance, 80,  3, true, 345678, 456789);
		EntityRegistry.registerModEntity(EntityDeer    .class, "EntityDeer",     12, AceCraft.instance, 80,  3, true, 567890, 678901);
		EntityRegistry.registerModEntity(EntityGoat    .class, "EntityGoat",     13, AceCraft.instance, 80,  3, true, 789012, 890123);
		EntityRegistry.registerModEntity(EntityCrab    .class, "EntityCrab",     14, AceCraft.instance, 80,  3, true, 901234,  12345);
		EntityRegistry.registerModEntity(EntityZed     .class, "EntityZed",      15, AceCraft.instance, 80,  3, true, 111111, 999999);
		EntityRegistry.registerModEntity(EntityChocobo .class, "EntityChocobo",  16, AceCraft.instance, 80,  3, true, 536728, 193673);
		EntityRegistry.addSpawn(EntityMammoth .class,  5, 1, 1, EnumCreatureType.CREATURE, Biomes.COLD_TAIGA, Biomes.COLD_TAIGA_HILLS, Biomes.ICE_MOUNTAINS, Biomes.ICE_PLAINS);
		EntityRegistry.addSpawn(EntityLlama   .class, 20, 1, 3, EnumCreatureType.CREATURE, Biomes.MESA, Biomes.MESA_CLEAR_ROCK, Biomes.MESA_ROCK);
		EntityRegistry.addSpawn(EntityDeer    .class, 25, 1, 2, EnumCreatureType.CREATURE, Biomes.PLAINS, Biomes.FOREST, Biomes.FOREST_HILLS);
		EntityRegistry.addSpawn(EntityGoat    .class, 25, 2, 4, EnumCreatureType.CREATURE, Biomes.EXTREME_HILLS, Biomes.EXTREME_HILLS_EDGE, Biomes.EXTREME_HILLS_WITH_TREES);
		EntityRegistry.addSpawn(EntityCrab    .class, 15, 1, 6, EnumCreatureType.CREATURE, Biomes.BEACH, Biomes.STONE_BEACH);
		//EntityRegistry.addSpawn(EntityElephant.class,  5, 1, 4, EnumCreatureType.CREATURE,  Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU);
		
		GameRegistry.registerTileEntity(TileEntityBlastFurnace.class, "MachinaBlastFurnace");
		GameRegistry.registerTileEntity(TileEntityCampfire     .class, "MachinaBonfire");
		GameRegistry.registerTileEntity(TileEntityDistillery  .class, "MachinaDistillery");
		GameRegistry.registerTileEntity(TileEntityKeg         .class, "MachinaKeg");
		GameRegistry.registerTileEntity(TileEntityGearBox     .class, "MachinaGearBox");
		GameRegistry.registerTileEntity(TileEntityAxle        .class, "MachinaAxle");
		GameRegistry.registerTileEntity(TileEntityWindmill    .class, "MachinaWindmill");
		GameRegistry.registerTileEntity(TileEntityWaterwheel  .class, "MachinaWaterwheel");
		GameRegistry.registerTileEntity(TileEntityFruitPress  .class, "MachinaFruitPress");
		GameRegistry.registerTileEntity(TileEntityMillstone   .class, "MachinaMillstone");
	}
	
	public static void registerRender(){
		RenderingRegistry.registerEntityRenderingHandler(EntityDynamite.class, RenderDynamite.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityNugget  .class, RenderNugget  .FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntitySpear   .class, RenderSpear   .FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityMammoth .class, RenderMammoth .FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityLlama   .class, RenderLlama   .FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityDeer    .class, RenderDeer    .FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityGoat    .class, RenderGoat    .FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityCrab    .class, RenderCrab    .FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityZed     .class, RenderZed     .FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityChocobo .class, RenderChocobo .FACTORY);
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
	
	private static void registerBlockAndItem(Block block, Item item, boolean pre){
		if(pre){
			GameRegistry.register(block);
			GameRegistry.register(item);
			GameRegistry.register(new ItemBlock(block).setUnlocalizedName(block.getUnlocalizedName().substring(5)).setRegistryName(block.getRegistryName()));
		}else{
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(AceCraft.modid + ":" + block.getUnlocalizedName().substring(5), "inventory"));
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(AceCraft.modid + ":" + item.getUnlocalizedName().substring(5), "inventory"));
		}
	}
	
	private static void registerEntity(Class<? extends Entity> entity, String name, Render<? extends Entity> renderer){
		EntityRegistry.registerModEntity(entity, name, 0, AceCraft.instance, 64, 20, true);
	}
	
	private static SoundEvent registerSound(String soundName) {
		final ResourceLocation soundID = new ResourceLocation(AceCraft.modid, soundName);
		return GameRegistry.register(new SoundEvent(soundID).setRegistryName(soundID));

	}
	
}
