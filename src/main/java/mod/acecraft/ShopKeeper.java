package mod.acecraft;

import mod.acecraft.blocks.BlockCrop;
import mod.acecraft.blocks.BlockOre;
import mod.acecraft.blocks.MachinaAnchor;
import mod.acecraft.blocks.MachinaAxle;
import mod.acecraft.blocks.MachinaBlastFurnace;
import mod.acecraft.blocks.MachinaCampfire;
import mod.acecraft.blocks.MachinaDistillery;
import mod.acecraft.blocks.MachinaFruitPress;
import mod.acecraft.blocks.MachinaGearBox;
import mod.acecraft.blocks.MachinaGlobe;
import mod.acecraft.blocks.MachinaKeg;
import mod.acecraft.blocks.MachinaMillstone;
import mod.acecraft.blocks.MachinaRope;
import mod.acecraft.blocks.MachinaWaterwheel;
import mod.acecraft.blocks.MachinaWindmill;
import mod.acecraft.entity.EntityCrab;
import mod.acecraft.entity.EntityDeer;
import mod.acecraft.entity.EntityGoat;
import mod.acecraft.entity.EntityLlama;
import mod.acecraft.entity.EntityNugget;
import mod.acecraft.entity.EntitySpear;
import mod.acecraft.items.ItemArmor;
import mod.acecraft.items.ItemArmorColor;
import mod.acecraft.items.ItemDynamite;
import mod.acecraft.items.ItemFood;
import mod.acecraft.items.ItemLiquor;
import mod.acecraft.items.ItemNugget;
import mod.acecraft.items.ItemSeed;
import mod.acecraft.items.ItemSeedWild;
import mod.acecraft.items.ToolsAxe;
import mod.acecraft.items.ToolsHoe;
import mod.acecraft.items.ToolsPickaxe;
import mod.acecraft.items.ToolsShovel;
import mod.acecraft.items.ToolsSpear;
import mod.acecraft.items.ToolsSword;
import mod.acecraft.tileentities.TileEntityAxle;
import mod.acecraft.tileentities.TileEntityBlastFurnace;
import mod.acecraft.tileentities.TileEntityCampfire;
import mod.acecraft.tileentities.TileEntityDistillery;
import mod.acecraft.tileentities.TileEntityFruitPress;
import mod.acecraft.tileentities.TileEntityGearBox;
import mod.acecraft.tileentities.TileEntityKeg;
import mod.acecraft.tileentities.TileEntityMillstone;
import mod.acecraft.tileentities.TileEntityWaterwheel;
import mod.acecraft.tileentities.TileEntityWindmill;
import mod.shared.Register;
import mod.shared.blocks.BlockBlock;
import mod.shared.items.ItemItem;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ShopKeeper {
	
	// Tool Materials																	name, harvestLevel, maxUses, efficiency, damage, enchantability
	public static final ToolMaterial MATERIAL_TOOL_WOOD       = EnumHelper.addToolMaterial("material_tool_wood",       0,   59,  2.0F, 0.0F, 15);
	public static final ToolMaterial MATERIAL_TOOL_SILVER     = EnumHelper.addToolMaterial("material_tool_silver",     0,   64,  6.0F, 0.0F, 44);
	public static final ToolMaterial MATERIAL_TOOL_STONE      = EnumHelper.addToolMaterial("material_tool_stone",      1,  131,  4.0F, 1.0F,  5);
	public static final ToolMaterial MATERIAL_TOOL_GOLD       = EnumHelper.addToolMaterial("material_tool_gold",       0,   32, 12.0F, 0.0F, 22);
	
	public static final ToolMaterial MATERIAL_TOOL_COPPER     = EnumHelper.addToolMaterial("material_tool_copper",     1,  192,  4.0F, 2.0F, 12);
	public static final ToolMaterial MATERIAL_TOOL_ORICHALCUM = EnumHelper.addToolMaterial("material_tool_orichalcum", 1,  192, 16.0F, 1.0F, 44);
	public static final ToolMaterial MATERIAL_TOOL_IRON       = EnumHelper.addToolMaterial("material_tool_iron",       2,  250,  6.0F, 2.0F, 14);
	public static final ToolMaterial MATERIAL_TOOL_DENARIUM   = EnumHelper.addToolMaterial("material_tool_denarium",   1,  128, 12.0F, 1.0F, 36);
	
	public static final ToolMaterial MATERIAL_TOOL_MYTHRIL    = EnumHelper.addToolMaterial("material_tool_mythril",    2,  450,  7.0F, 2.0F, 21);
	public static final ToolMaterial MATERIAL_TOOL_STEEL      = EnumHelper.addToolMaterial("material_tool_steel",      2,  786,  7.5F, 3.0F, 25);
	public static final ToolMaterial MATERIAL_TOOL_GILIUM     = EnumHelper.addToolMaterial("material_tool_gilium",     3,  850,  8.0F, 2.5F, 28);
	public static final ToolMaterial MATERIAL_TOOL_BRONZE     = EnumHelper.addToolMaterial("material_tool_bronze",     2, 1175,  7.5F, 3.3F, 28);
	
	public static final ToolMaterial MATERIAL_TOOL_DIAMOND    = EnumHelper.addToolMaterial("material_tool_diamond",    3, 1561,  8.0F, 3.0F, 10);
	public static final ToolMaterial MATERIAL_TOOL_AURELIUM   = EnumHelper.addToolMaterial("material_tool_aurelium",   3, 1325,  9.0F, 3.5F, 38);
	public static final ToolMaterial MATERIAL_TOOL_AURORITE   = EnumHelper.addToolMaterial("material_tool_aurorite",   4, 1750, 10.0F, 5.0F, 10);
	public static final ToolMaterial MATERIAL_TOOL_ADAMANTIUM = EnumHelper.addToolMaterial("material_tool_adamantium", 3, 1675, 10.0F, 4.0F, 46);
	
	
	
	
	
	
	
	
	
	
	
	// Armor Material																	name, textureName, durability, reductionAmounts[], enchantability, soundOnEquip, toughness
	public static final ArmorMaterial MATERIAL_ARMOR_LEATHER     = EnumHelper.addArmorMaterial("material_armor_leather",   AceCraft.modid + ":" + "leather",     5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	public static final ArmorMaterial MATERIAL_ARMOR_CHAINMAIL   = EnumHelper.addArmorMaterial("material_armor_chainmail", AceCraft.modid + ":" + "chainmail",  15, new int[]{1, 4, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN,   0.0F);
	
	public static final ArmorMaterial MATERIAL_ARMOR_COPPER     = EnumHelper.addArmorMaterial("material_armor_copper",     AceCraft.modid + ":" + "copper",     12, new int[]{1, 4, 6, 2},  8, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ArmorMaterial MATERIAL_ARMOR_IRON       = EnumHelper.addArmorMaterial("material_armor_iron",       AceCraft.modid + ":" + "iron",       15, new int[]{2, 5, 6, 2},  9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ArmorMaterial MATERIAL_ARMOR_MYTHRIL    = EnumHelper.addArmorMaterial("material_armor_mythril",    AceCraft.modid + ":" + "mythril",    18, new int[]{2, 6, 7, 2}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static final ArmorMaterial MATERIAL_ARMOR_GILIUM     = EnumHelper.addArmorMaterial("material_armor_gilium",     AceCraft.modid + ":" + "gilium",     21, new int[]{3, 6, 7, 3}, 18, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	
	public static final ArmorMaterial MATERIAL_ARMOR_SILVER     = EnumHelper.addArmorMaterial("material_armor_silver",     AceCraft.modid + ":" + "silver",      5, new int[]{1, 2, 4, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F);
	public static final ArmorMaterial MATERIAL_ARMOR_GOLD       = EnumHelper.addArmorMaterial("material_armor_gold",       AceCraft.modid + ":" + "gold",        7, new int[]{1, 3, 5, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F);
	public static final ArmorMaterial MATERIAL_ARMOR_ORICHALCUM = EnumHelper.addArmorMaterial("material_armor_orichalcum", AceCraft.modid + ":" + "orichalcum",  8, new int[]{2, 3, 5, 3}, 30, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0f);
	public static final ArmorMaterial MATERIAL_ARMOR_DENARIUM   = EnumHelper.addArmorMaterial("material_armor_denarium",   AceCraft.modid + ":" + "denarium",    9, new int[]{2, 4, 6, 3}, 35, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F);
	
	public static final ArmorMaterial MATERIAL_ARMOR_STEEL      = EnumHelper.addArmorMaterial("material_armor_steel",      AceCraft.modid + ":" + "steel",      22, new int[]{2, 4, 6, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0f);
	public static final ArmorMaterial MATERIAL_ARMOR_BRONZE     = EnumHelper.addArmorMaterial("material_armor_bronze",     AceCraft.modid + ":" + "bronze",     25, new int[]{2, 4, 7, 3}, 13, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0f);
	public static final ArmorMaterial MATERIAL_ARMOR_AURELIUM   = EnumHelper.addArmorMaterial("material_armor_aurelium",   AceCraft.modid + ":" + "aurelium",   27, new int[]{3, 5, 7, 3}, 16, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0f);
	public static final ArmorMaterial MATERIAL_ARMOR_ADAMANTIUM = EnumHelper.addArmorMaterial("material_armor_adamantium", AceCraft.modid + ":" + "adamantium", 29, new int[]{3, 6, 8, 3}, 19, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0f);
	
	public static final ArmorMaterial MATERIAL_ARMOR_DIAMOND    = EnumHelper.addArmorMaterial("material_armor_diamond",    AceCraft.modid + ":" + "diamond",    33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
	public static final ArmorMaterial MATERIAL_ARMOR_AURORITE   = EnumHelper.addArmorMaterial("material_armor_aurorite",   AceCraft.modid + ":" + "aurorite",   35, new int[]{3, 6, 8, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
	
	// Gui IDs
	public enum GuiID { BLASTFURNACE, KEG, CAMPFIRE, FRUITPRESS, MILLSTONE, DISTILLERY }
	
	// Full Blocks
	public static final Block BLOCK_CLAVIUM    = new BlockBlock("block_clavium",    Material.IRON, 2, 2);
	public static final Block BLOCK_GILIUM     = new BlockBlock("block_gilium",     Material.IRON, 2, 2);
	public static final Block BLOCK_ADAMANTIUM = new BlockBlock("block_adamantium", Material.IRON, 2, 2);
	public static final Block BLOCK_DENARIUM   = new BlockBlock("block_denarium",   Material.IRON, 2, 2);
	public static final Block BLOCK_ZINC       = new BlockBlock("block_zinc",       Material.IRON, 2, 2);
	public static final Block BLOCK_MYTHRIL    = new BlockBlock("block_mythril",    Material.IRON, 2, 2);
	public static final Block BLOCK_AURELIUM   = new BlockBlock("block_aurelium",   Material.IRON, 2, 2);
	public static final Block BLOCK_ORICHALCUM = new BlockBlock("block_orichalcum", Material.IRON, 2, 2);
	public static final Block BLOCK_TIN        = new BlockBlock("block_tin",        Material.IRON, 2, 2);
	public static final Block BLOCK_COPPER     = new BlockBlock("block_copper",     Material.IRON, 2, 2);
	public static final Block BLOCK_BRONZE     = new BlockBlock("block_bronze",     Material.IRON, 2, 2);
	public static final Block BLOCK_SILVER     = new BlockBlock("block_silver",     Material.IRON, 2, 2);
	public static final Block BLOCK_STEEL      = new BlockBlock("block_steel",      Material.IRON, 2, 2);
	public static final Block BLOCK_NIVIDIUM   = new BlockBlock("block_nividium",   Material.IRON, 2, 2);
	
	public static final Block BLOCK_SALT       = new BlockBlock("block_salt",       Material.SAND, 2, 2);
	public static final Block BLOCK_SULFUR     = new BlockBlock("block_sulfur",     Material.SAND, 2, 2);
	public static final Block BLOCK_FLOUR      = new BlockBlock("block_flour",      Material.SAND, 2, 2);
	public static final Block BLOCK_COFFEE     = new BlockBlock("block_coffee",     Material.SAND, 2, 2);
	
	public static final Block BLOCK_AURORITE   = new BlockBlock("block_aurorite",   Material.GLASS, 2, 2);
	
	// Nuggets
	public static final Item NUGGET_IRON       = new ItemNugget("nugget_iron");
	public static final Item NUGGET_GOLD       = new ItemNugget("nugget_gold");
	public static final Item NUGGET_GILIUM     = new ItemNugget("nugget_gilium");
	public static final Item NUGGET_MYTHRIL    = new ItemNugget("nugget_mythril");
	public static final Item NUGGET_CLAVIUM    = new ItemNugget("nugget_clavium");
	public static final Item NUGGET_ZINC       = new ItemNugget("nugget_zinc");
	public static final Item NUGGET_TIN        = new ItemNugget("nugget_tin");
	public static final Item NUGGET_COPPER     = new ItemNugget("nugget_copper");
	public static final Item NUGGET_SILVER     = new ItemNugget("nugget_silver");
	public static final Item NUGGET_NIVIDIUM   = new ItemNugget("nugget_nividium");
	
	// Powder/Gems
	public static final Item POWDER_SALT   = new ItemItem("powder_salt");
	public static final Item POWDER_SULFUR = new ItemItem("powder_sulfur");
	public static final Item POWDER_FLOUR  = new ItemItem("powder_flour");
	public static final Item POWDER_COFFEE = new ItemItem("powder_coffee");
	public static final Item GEM_AURORITE  = new ItemItem("gem_aurorite");
	
	// Ore Blocks
	public static final Block ORE_CLAVIUM     = new BlockOre("ore_clavium",  2, NUGGET_CLAVIUM);
	public static final Block ORE_GILIUM      = new BlockOre("ore_gilium",   3, NUGGET_GILIUM);
	public static final Block ORE_ZINC        = new BlockOre("ore_zinc",     1, NUGGET_ZINC);
	public static final Block ORE_MYTHRIL     = new BlockOre("ore_mythril",  2, NUGGET_MYTHRIL);
	public static final Block ORE_TIN         = new BlockOre("ore_tin",      1, NUGGET_TIN);
	public static final Block ORE_COPPER      = new BlockOre("ore_copper",   1, NUGGET_COPPER);
	public static final Block ORE_SILVER      = new BlockOre("ore_silver",   2, NUGGET_SILVER);
	public static final Block ORE_NIVIDIUM    = new BlockOre("ore_nividium", 2, NUGGET_NIVIDIUM);
	public static final Block ORE_SALT        = new BlockOre("ore_salt",     0, POWDER_SALT);
	public static final Block ORE_SULFUR      = new BlockOre("ore_sulfur",   0, POWDER_SULFUR);
	public static final Block ORE_AURORITE    = new BlockOre("ore_aurorite", 3, GEM_AURORITE);
	
	// Ingots
	public static final Item INGOT_CLAVIUM     = new ItemItem("ingot_clavium");
	public static final Item INGOT_GILIUM      = new ItemItem("ingot_gilium");
	public static final Item INGOT_ADAMANTIUM  = new ItemItem("ingot_adamantium");
	public static final Item INGOT_DENARIUM    = new ItemItem("ingot_denarium");
	public static final Item INGOT_ZINC        = new ItemItem("ingot_zinc");
	public static final Item INGOT_MYTHRIL     = new ItemItem("ingot_mythril");
	public static final Item INGOT_AURELIUM    = new ItemItem("ingot_aurelium");
	public static final Item INGOT_ORICHALCUM  = new ItemItem("ingot_orichalcum");
	public static final Item INGOT_TIN         = new ItemItem("ingot_tin");
	public static final Item INGOT_COPPER      = new ItemItem("ingot_copper");
	public static final Item INGOT_BRONZE      = new ItemItem("ingot_bronze");
	public static final Item INGOT_SILVER      = new ItemItem("ingot_silver");
	public static final Item INGOT_STEEL       = new ItemItem("ingot_steel");
	public static final Item INGOT_NIVIDIUM    = new ItemItem("ingot_nividium");
	
	// Tools
	public static final Item TOOL_SPEAR_WOOD         = new ToolsSpear  ("tool_spear_wood",    ToolMaterial.WOOD);
	public static final Item TOOL_SPEAR_STONE        = new ToolsSpear  ("tool_spear_stone",   ToolMaterial.STONE);
	public static final Item TOOL_SPEAR_IRON         = new ToolsSpear  ("tool_spear_iron",    ToolMaterial.IRON);
	public static final Item TOOL_SPEAR_GOLD         = new ToolsSpear  ("tool_spear_gold",    ToolMaterial.GOLD);
	public static final Item TOOL_SPEAR_DIAMOND      = new ToolsSpear  ("tool_spear_diamond", ToolMaterial.DIAMOND);
	public static final Item TOOL_SHOVEL_GILIUM      = new ToolsShovel ("tool_shovel_gilium",  MATERIAL_TOOL_GILIUM);
	public static final Item TOOL_PICKAXE_GILIUM     = new ToolsPickaxe("tool_pickaxe_gilium", MATERIAL_TOOL_GILIUM);
	public static final Item TOOL_AXE_GILIUM         = new ToolsAxe    ("tool_axe_gilium",     MATERIAL_TOOL_GILIUM);
	public static final Item TOOL_HOE_GILIUM         = new ToolsHoe    ("tool_hoe_gilium",     MATERIAL_TOOL_GILIUM);
	public static final Item TOOL_SWORD_GILIUM       = new ToolsSword  ("tool_sword_gilium",   MATERIAL_TOOL_GILIUM);
	public static final Item TOOL_SPEAR_GILIUM       = new ToolsSpear  ("tool_spear_gilium",   MATERIAL_TOOL_GILIUM);
	public static final Item TOOL_SHOVEL_ADAMANTIUM  = new ToolsShovel ("tool_shovel_adamantium",  MATERIAL_TOOL_ADAMANTIUM);
	public static final Item TOOL_PICKAXE_ADAMANTIUM = new ToolsPickaxe("tool_pickaxe_adamantium", MATERIAL_TOOL_ADAMANTIUM);
	public static final Item TOOL_AXE_ADAMANTIUM     = new ToolsAxe    ("tool_axe_adamantium",     MATERIAL_TOOL_ADAMANTIUM);
	public static final Item TOOL_HOE_ADAMANTIUM     = new ToolsHoe    ("tool_hoe_adamantium",     MATERIAL_TOOL_ADAMANTIUM);
	public static final Item TOOL_SWORD_ADAMANTIUM   = new ToolsSword  ("tool_sword_adamantium",   MATERIAL_TOOL_ADAMANTIUM);
	public static final Item TOOL_SPEAR_ADAMANTIUM   = new ToolsSpear  ("tool_spear_adamantium",   MATERIAL_TOOL_ADAMANTIUM);
	public static final Item TOOL_SHOVEL_DENARIUM    = new ToolsShovel ("tool_shovel_denarium",  MATERIAL_TOOL_DENARIUM);
	public static final Item TOOL_PICKAXE_DENARIUM   = new ToolsPickaxe("tool_pickaxe_denarium", MATERIAL_TOOL_DENARIUM);
	public static final Item TOOL_AXE_DENARIUM       = new ToolsAxe    ("tool_axe_denarium",     MATERIAL_TOOL_DENARIUM);
	public static final Item TOOL_HOE_DENARIUM       = new ToolsHoe    ("tool_hoe_denarium",     MATERIAL_TOOL_DENARIUM);
	public static final Item TOOL_SWORD_DENARIUM     = new ToolsSword  ("tool_sword_denarium",   MATERIAL_TOOL_DENARIUM);
	public static final Item TOOL_SPEAR_DENARIUM     = new ToolsSpear  ("tool_spear_denarium",   MATERIAL_TOOL_DENARIUM);
	public static final Item TOOL_SHOVEL_MYTHRIL     = new ToolsShovel ("tool_shovel_mythril",  MATERIAL_TOOL_MYTHRIL);
	public static final Item TOOL_PICKAXE_MYTHRIL    = new ToolsPickaxe("tool_pickaxe_mythril", MATERIAL_TOOL_MYTHRIL);
	public static final Item TOOL_AXE_MYTHRIL        = new ToolsAxe    ("tool_axe_mythril",     MATERIAL_TOOL_MYTHRIL);
	public static final Item TOOL_HOE_MYTHRIL        = new ToolsHoe    ("tool_hoe_mythril",     MATERIAL_TOOL_MYTHRIL);
	public static final Item TOOL_SWORD_MYTHRIL      = new ToolsSword  ("tool_sword_mythril",   MATERIAL_TOOL_MYTHRIL);
	public static final Item TOOL_SPEAR_MYTHRIL      = new ToolsSpear  ("tool_spear_mythril",   MATERIAL_TOOL_MYTHRIL);
	public static final Item TOOL_SHOVEL_AURELIUM    = new ToolsShovel ("tool_shovel_aurelium",  MATERIAL_TOOL_AURELIUM);
	public static final Item TOOL_PICKAXE_AURELIUM   = new ToolsPickaxe("tool_pickaxe_aurelium", MATERIAL_TOOL_AURELIUM);
	public static final Item TOOL_AXE_AURELIUM       = new ToolsAxe    ("tool_axe_aurelium",     MATERIAL_TOOL_AURELIUM);
	public static final Item TOOL_HOE_AURELIUM       = new ToolsHoe    ("tool_hoe_aurelium",     MATERIAL_TOOL_AURELIUM);
	public static final Item TOOL_SWORD_AURELIUM     = new ToolsSword  ("tool_sword_aurelium",   MATERIAL_TOOL_AURELIUM);
	public static final Item TOOL_SPEAR_AURELIUM     = new ToolsSpear  ("tool_spear_aurelium",   MATERIAL_TOOL_AURELIUM);
	public static final Item TOOL_SHOVEL_ORICHALCUM  = new ToolsShovel ("tool_shovel_orichalcum",  MATERIAL_TOOL_ORICHALCUM);
	public static final Item TOOL_PICKAXE_ORICHALCUM = new ToolsPickaxe("tool_pickaxe_orichalcum", MATERIAL_TOOL_ORICHALCUM);
	public static final Item TOOL_AXE_ORICHALCUM     = new ToolsAxe    ("tool_axe_orichalcum",     MATERIAL_TOOL_ORICHALCUM);
	public static final Item TOOL_HOE_ORICHALCUM     = new ToolsHoe    ("tool_hoe_orichalcum",     MATERIAL_TOOL_ORICHALCUM);
	public static final Item TOOL_SWORD_ORICHALCUM   = new ToolsSword  ("tool_sword_orichalcum",   MATERIAL_TOOL_ORICHALCUM);
	public static final Item TOOL_SPEAR_ORICHALCUM   = new ToolsSpear  ("tool_spear_orichalcum",   MATERIAL_TOOL_ORICHALCUM);
	public static final Item TOOL_SHOVEL_COPPER      = new ToolsShovel ("tool_shovel_copper",  MATERIAL_TOOL_COPPER);
	public static final Item TOOL_PICKAXE_COPPER     = new ToolsPickaxe("tool_pickaxe_copper", MATERIAL_TOOL_COPPER);
	public static final Item TOOL_AXE_COPPER         = new ToolsAxe    ("tool_axe_copper",     MATERIAL_TOOL_COPPER);
	public static final Item TOOL_HOE_COPPER         = new ToolsHoe    ("tool_hoe_copper",     MATERIAL_TOOL_COPPER);
	public static final Item TOOL_SWORD_COPPER       = new ToolsSword  ("tool_sword_copper",   MATERIAL_TOOL_COPPER);
	public static final Item TOOL_SPEAR_COPPER       = new ToolsSpear  ("tool_spear_copper",   MATERIAL_TOOL_COPPER);
	public static final Item TOOL_SHOVEL_BRONZE      = new ToolsShovel ("tool_shovel_bronze",  MATERIAL_TOOL_BRONZE);
	public static final Item TOOL_PICKAXE_BRONZE     = new ToolsPickaxe("tool_pickaxe_bronze", MATERIAL_TOOL_BRONZE);
	public static final Item TOOL_AXE_BRONZE         = new ToolsAxe    ("tool_axe_bronze",     MATERIAL_TOOL_BRONZE);
	public static final Item TOOL_HOE_BRONZE         = new ToolsHoe    ("tool_hoe_bronze",     MATERIAL_TOOL_BRONZE);
	public static final Item TOOL_SWORD_BRONZE       = new ToolsSword  ("tool_sword_bronze",   MATERIAL_TOOL_BRONZE);
	public static final Item TOOL_SPEAR_BRONZE       = new ToolsSpear  ("tool_spear_bronze",   MATERIAL_TOOL_BRONZE);
	public static final Item TOOL_SHOVEL_SILVER      = new ToolsShovel ("tool_shovel_silver",  MATERIAL_TOOL_SILVER);
	public static final Item TOOL_PICKAXE_SILVER     = new ToolsPickaxe("tool_pickaxe_silver", MATERIAL_TOOL_SILVER);
	public static final Item TOOL_AXE_SILVER         = new ToolsAxe    ("tool_axe_silver",     MATERIAL_TOOL_SILVER);
	public static final Item TOOL_HOE_SILVER         = new ToolsHoe    ("tool_hoe_silver",     MATERIAL_TOOL_SILVER);
	public static final Item TOOL_SWORD_SILVER       = new ToolsSword  ("tool_sword_silver",   MATERIAL_TOOL_SILVER);
	public static final Item TOOL_SPEAR_SILVER       = new ToolsSpear  ("tool_spear_silver",   MATERIAL_TOOL_SILVER);
	public static final Item TOOL_SHOVEL_STEEL       = new ToolsShovel ("tool_shovel_steel",  MATERIAL_TOOL_STEEL);
	public static final Item TOOL_PICKAXE_STEEL      = new ToolsPickaxe("tool_pickaxe_steel", MATERIAL_TOOL_STEEL);
	public static final Item TOOL_AXE_STEEL          = new ToolsAxe    ("tool_axe_steel",     MATERIAL_TOOL_STEEL);
	public static final Item TOOL_HOE_STEEL          = new ToolsHoe    ("tool_hoe_steel",     MATERIAL_TOOL_STEEL);
	public static final Item TOOL_SWORD_STEEL        = new ToolsSword  ("tool_sword_steel",   MATERIAL_TOOL_STEEL);
	public static final Item TOOL_SPEAR_STEEL        = new ToolsSpear  ("tool_spear_steel",   MATERIAL_TOOL_STEEL);
	public static final Item TOOL_SHOVEL_AURORITE    = new ToolsShovel ("tool_shovel_aurorite",  MATERIAL_TOOL_AURORITE);
	public static final Item TOOL_PICKAXE_AURORITE   = new ToolsPickaxe("tool_pickaxe_aurorite", MATERIAL_TOOL_AURORITE);
	public static final Item TOOL_AXE_AURORITE       = new ToolsAxe    ("tool_axe_aurorite",     MATERIAL_TOOL_AURORITE);
	public static final Item TOOL_HOE_AURORITE       = new ToolsHoe    ("tool_hoe_aurorite",     MATERIAL_TOOL_AURORITE);
	public static final Item TOOL_SWORD_AURORITE     = new ToolsSword  ("tool_sword_aurorite",   MATERIAL_TOOL_AURORITE);
	public static final Item TOOL_SPEAR_AURORITE     = new ToolsSpear  ("tool_spear_aurorite",   MATERIAL_TOOL_AURORITE);
	
	// Armor
	public static final Item ARMOR_HELMET_GILIUM         = new ItemArmor("armor_helmet_gilium",     MATERIAL_ARMOR_GILIUM, 0, EntityEquipmentSlot.HEAD);
	public static final Item ARMOR_CHESTPLATE_GILIUM     = new ItemArmor("armor_chestplate_gilium", MATERIAL_ARMOR_GILIUM, 0, EntityEquipmentSlot.CHEST);
	public static final Item ARMOR_LEGGINGS_GILIUM       = new ItemArmor("armor_leggings_gilium",   MATERIAL_ARMOR_GILIUM, 0, EntityEquipmentSlot.LEGS);
	public static final Item ARMOR_BOOTS_GILIUM          = new ItemArmor("armor_boots_gilium",      MATERIAL_ARMOR_GILIUM, 0, EntityEquipmentSlot.FEET);
	public static final Item ARMOR_HELMET_ADAMANTIUM     = new ItemArmor("armor_helmet_adamantium",     MATERIAL_ARMOR_ADAMANTIUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item ARMOR_CHESTPLATE_ADAMANTIUM = new ItemArmor("armor_chestplate_adamantium", MATERIAL_ARMOR_ADAMANTIUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item ARMOR_LEGGINGS_ADAMANTIUM   = new ItemArmor("armor_leggings_adamantium",   MATERIAL_ARMOR_ADAMANTIUM, 1, EntityEquipmentSlot.LEGS);
	public static final Item ARMOR_BOOTS_ADAMANTIUM      = new ItemArmor("armor_boots_adamantium",      MATERIAL_ARMOR_ADAMANTIUM, 1, EntityEquipmentSlot.FEET);
	public static final Item ARMOR_HELMET_DENARIUM       = new ItemArmor("armor_helmet_denarium",     MATERIAL_ARMOR_DENARIUM, 2, EntityEquipmentSlot.HEAD);
	public static final Item ARMOR_CHESTPLATE_DENARIUM   = new ItemArmor("armor_chestplate_denarium", MATERIAL_ARMOR_DENARIUM, 2, EntityEquipmentSlot.CHEST);
	public static final Item ARMOR_LEGGINGS_DENARIUM     = new ItemArmor("armor_leggings_denarium",   MATERIAL_ARMOR_DENARIUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item ARMOR_BOOTS_DENARIUM        = new ItemArmor("armor_boots_denarium",      MATERIAL_ARMOR_DENARIUM, 2, EntityEquipmentSlot.FEET);
	public static final Item ARMOR_HELMET_MYTHRIL        = new ItemArmor("armor_helmet_mythril",     MATERIAL_ARMOR_MYTHRIL, 3, EntityEquipmentSlot.HEAD);
	public static final Item ARMOR_CHESTPLATE_MYTHRIL    = new ItemArmor("armor_chestplate_mythril", MATERIAL_ARMOR_MYTHRIL, 3, EntityEquipmentSlot.CHEST);
	public static final Item ARMOR_LEGGINGS_MYTHRIL      = new ItemArmor("armor_leggings_mythril",   MATERIAL_ARMOR_MYTHRIL, 3, EntityEquipmentSlot.LEGS);
	public static final Item ARMOR_BOOTS_MYTHRIL         = new ItemArmor("armor_boots_mythril",      MATERIAL_ARMOR_MYTHRIL, 3, EntityEquipmentSlot.FEET);
	public static final Item ARMOR_HELMET_AURELIUM       = new ItemArmor("armor_helmet_aurelium",     MATERIAL_ARMOR_AURELIUM, 4, EntityEquipmentSlot.HEAD);
	public static final Item ARMOR_CHESTPLATE_AURELIUM   = new ItemArmor("armor_chestplate_aurelium", MATERIAL_ARMOR_AURELIUM, 4, EntityEquipmentSlot.CHEST);
	public static final Item ARMOR_LEGGINGS_AURELIUM     = new ItemArmor("armor_leggings_aurelium",   MATERIAL_ARMOR_AURELIUM, 4, EntityEquipmentSlot.LEGS);
	public static final Item ARMOR_BOOTS_AURELIUM        = new ItemArmor("armor_boots_aurelium",      MATERIAL_ARMOR_AURELIUM, 4, EntityEquipmentSlot.FEET);
	public static final Item ARMOR_HELMET_ORICHALCUM     = new ItemArmor("armor_helmet_orichalcum",     MATERIAL_ARMOR_ORICHALCUM, 5, EntityEquipmentSlot.HEAD);
	public static final Item ARMOR_CHESTPLATE_ORICHALCUM = new ItemArmor("armor_chestplate_orichalcum", MATERIAL_ARMOR_ORICHALCUM, 5, EntityEquipmentSlot.CHEST);
	public static final Item ARMOR_LEGGINGS_ORICHALCUM   = new ItemArmor("armor_leggings_orichalcum",   MATERIAL_ARMOR_ORICHALCUM, 5, EntityEquipmentSlot.LEGS);
	public static final Item ARMOR_BOOTS_ORICHALCUM      = new ItemArmor("armor_boots_orichalcum",      MATERIAL_ARMOR_ORICHALCUM, 5, EntityEquipmentSlot.FEET);
	public static final Item ARMOR_HELMET_COPPER         = new ItemArmor("armor_helmet_copper",     MATERIAL_ARMOR_COPPER, 6, EntityEquipmentSlot.HEAD);
	public static final Item ARMOR_CHESTPLATE_COPPER     = new ItemArmor("armor_chestplate_copper", MATERIAL_ARMOR_COPPER, 6, EntityEquipmentSlot.CHEST);
	public static final Item ARMOR_LEGGINGS_COPPER       = new ItemArmor("armor_leggings_copper",   MATERIAL_ARMOR_COPPER, 6, EntityEquipmentSlot.LEGS);
	public static final Item ARMOR_BOOTS_COPPER          = new ItemArmor("armor_boots_copper",      MATERIAL_ARMOR_COPPER, 6, EntityEquipmentSlot.FEET);
	public static final Item ARMOR_HELMET_BRONZE         = new ItemArmor("armor_helmet_bronze",     MATERIAL_ARMOR_BRONZE, 7, EntityEquipmentSlot.HEAD);
	public static final Item ARMOR_CHESTPLATE_BRONZE     = new ItemArmor("armor_chestplate_bronze", MATERIAL_ARMOR_BRONZE, 7, EntityEquipmentSlot.CHEST);
	public static final Item ARMOR_LEGGINGS_BRONZE       = new ItemArmor("armor_leggings_bronze",   MATERIAL_ARMOR_BRONZE, 7, EntityEquipmentSlot.LEGS);
	public static final Item ARMOR_BOOTS_BRONZE          = new ItemArmor("armor_boots_bronze",      MATERIAL_ARMOR_BRONZE, 7, EntityEquipmentSlot.FEET);
	public static final Item ARMOR_HELMET_SILVER         = new ItemArmor("armor_helmet_silver",     MATERIAL_ARMOR_SILVER, 8, EntityEquipmentSlot.HEAD);
	public static final Item ARMOR_CHESTPLATE_SILVER     = new ItemArmor("armor_chestplate_silver", MATERIAL_ARMOR_SILVER, 8, EntityEquipmentSlot.CHEST);
	public static final Item ARMOR_LEGGINGS_SILVER       = new ItemArmor("armor_leggings_silver",   MATERIAL_ARMOR_SILVER, 8, EntityEquipmentSlot.LEGS);
	public static final Item ARMOR_BOOTS_SILVER          = new ItemArmor("armor_boots_silver",      MATERIAL_ARMOR_SILVER, 8, EntityEquipmentSlot.FEET);
	public static final Item ARMOR_HELMET_STEEL          = new ItemArmor("armor_helmet_steel",     MATERIAL_ARMOR_STEEL, 9, EntityEquipmentSlot.HEAD);
	public static final Item ARMOR_CHESTPLATE_STEEL      = new ItemArmor("armor_chestplate_steel", MATERIAL_ARMOR_STEEL, 9, EntityEquipmentSlot.CHEST);
	public static final Item ARMOR_LEGGINGS_STEEL        = new ItemArmor("armor_leggings_steel",   MATERIAL_ARMOR_STEEL, 9, EntityEquipmentSlot.LEGS);
	public static final Item ARMOR_BOOTS_STEEL           = new ItemArmor("armor_boots_steel",      MATERIAL_ARMOR_STEEL, 9, EntityEquipmentSlot.FEET);
	public static final Item ARMOR_HELMET_AURORITE       = new ItemArmorColor("armor_helmet_aurorite",     MATERIAL_ARMOR_AURORITE, 10, EntityEquipmentSlot.HEAD);
	public static final Item ARMOR_CHESTPLATE_AURORITE   = new ItemArmorColor("armor_chestplate_aurorite", MATERIAL_ARMOR_AURORITE, 10, EntityEquipmentSlot.CHEST);
	public static final Item ARMOR_LEGGINGS_AURORITE     = new ItemArmorColor("armor_leggings_aurorite",   MATERIAL_ARMOR_AURORITE, 10, EntityEquipmentSlot.LEGS);
	public static final Item ARMOR_BOOTS_AURORITE        = new ItemArmorColor("armor_boots_aurorite",      MATERIAL_ARMOR_AURORITE, 10, EntityEquipmentSlot.FEET);
	
	// Stuff
	public static final Item STUFF_ROPE      = new ItemItem("stuff_rope");
	public static final Item STUFF_HEMP      = new ItemItem("stuff_hemp");
	public static final Item STUFF_GEAR_WOOD = new ItemItem("stuff_gear_wood");
	public static final Item STUFF_FUR       = new ItemItem("stuff_fur");
	public static final Item STUFF_TUSK      = new ItemItem("stuff_tusk");
	public static final Item STUFF_ANTLER    = new ItemItem("stuff_antler");
	public static final Item STUFF_DYNAMITE  = new ItemDynamite("stuff_dynamite");
	
	// Machina
	public static final Block MACHINA_ANCHOR       = new MachinaAnchor      ("machina_anchor");
	public static final Block MACHINA_AXLE         = new MachinaAxle        ("machina_axle");
	public static final Block MACHINA_BLASTFURNACE = new MachinaBlastFurnace("machina_blastfurnace");
	public static final Block MACHINA_CAMPFIRE     = new MachinaCampfire    ("machina_campfire");
	public static final Block MACHINA_DISTILLERY   = new MachinaDistillery  ("machina_distillery");
	public static final Block MACHINA_FRUITPRESS   = new MachinaFruitPress  ("machina_fruitpress");
	public static final Block MACHINA_GEARBOX      = new MachinaGearBox     ("machina_gearbox");
	public static final Block MACHINA_GLOBE        = new MachinaGlobe       ("machina_globe");
	public static final Block MACHINA_KEG          = new MachinaKeg         ("machina_keg");
	public static final Block MACHINA_MILLSTONE    = new MachinaMillstone   ("machina_millstone");
	public static final Block MACHINA_ROPE         = new MachinaRope        ("machina_rope");
	public static final Block MACHINA_WATERWHEEL   = new MachinaWaterwheel  ("machina_waterwheel");
	public static final Block MACHINA_WINDMILL     = new MachinaWindmill    ("machina_windmill");
	
	// Food
	public static final Item FOOD_TURNIP         = new ItemFood("food_turnip",         2, 2, false, false, false);
	public static final Item FOOD_CABBAGE        = new ItemFood("food_cabbage",        2, 2, false, false, false);
	//public static final Item FOOD_TOMATO         = new ItemFood("food_tomato",         2, 2, false, false, false);
	//public static final Item FOOD_CUCUMBER       = new ItemFood("food_cucumber",       2, 2, false, false, false);
	public static final Item FOOD_RICE           = new ItemFood("food_rice",           2, 2, false, false, false);
	//public static final Item FOOD_CORN           = new ItemFood("food_corn",           2, 2, false, false, false);
	//public static final Item FOOD_GRAPES         = new ItemFood("food_grapes",         2, 2, false, false, false);
	public static final Item FOOD_COFFEE         = new ItemFood("food_coffee",         2, 2, false, false, false);
	public static final Item FOOD_VENISON_RAW    = new ItemFood("food_venison_raw",    2, 2, true,  false, false);
	public static final Item FOOD_VENISON_COOKED = new ItemFood("food_venison_cooked", 2, 2, true,  false, false);
	public static final Item FOOD_VICUGNA_RAW    = new ItemFood("food_vicugna_raw",    2, 2, true,  false, false);
	public static final Item FOOD_VICUGNA_COOKED = new ItemFood("food_vicugna_cooked", 2, 2, true,  false, false);
	
	// Crops
	public static final Block CROP_TURNIP   = new BlockCrop("crop_turnip",   FOOD_TURNIP,   3);
	public static final Block CROP_CABBAGE  = new BlockCrop("crop_cabbage",  FOOD_CABBAGE,  4);
	//public static final Block CROP_TOMATO   = new BlockCrop("crop_tomato",   FOOD_TOMATO,   1);
	//public static final Block CROP_CUCUMBER = new BlockCrop("crop_cucumber", FOOD_CUCUMBER, 1);
	public static final Block CROP_RICE     = new BlockCrop("crop_rice",     FOOD_RICE,     5);
	//public static final Block CROP_CORN     = new BlockCrop("crop_corn",     FOOD_CORN,     1);
	//public static final Block CROP_GRAPES   = new BlockCrop("crop_grapes",   FOOD_GRAPES,   1);
	public static final Block CROP_COFFEE   = new BlockCrop("crop_coffee",   FOOD_COFFEE,   4);
	public static final Block CROP_HEMP     = new BlockCrop("crop_hemp",     STUFF_HEMP,    4);
	
	// Seeds
	public static final Item SEED_TURNIP   = new ItemSeed("seed_turnip",   CROP_TURNIP,   Blocks.FARMLAND);
	public static final Item SEED_CABBAGE  = new ItemSeed("seed_cabbage",  CROP_CABBAGE,  Blocks.FARMLAND);
	//public static final Item SEED_TOMATO   = new ItemSeed("seed_tomato",   CROP_TOMATO,   Blocks.FARMLAND);
	//public static final Item SEED_CUCUMBER = new ItemSeed("seed_cucumber", CROP_CUCUMBER, Blocks.FARMLAND);
	public static final Item SEED_RICE     = new ItemSeed("seed_rice",     CROP_RICE,     Blocks.FARMLAND);
	//public static final Item SEED_CORN     = new ItemSeed("seed_corn",     CROP_CORN,     Blocks.FARMLAND);
	//public static final Item SEED_GRAPES   = new ItemSeed("seed_grapes",   CROP_GRAPES,   Blocks.FARMLAND);
	public static final Item SEED_COFFEE   = new ItemSeed("seed_coffee",   CROP_COFFEE,   Blocks.FARMLAND);
	public static final Item SEED_HEMP     = new ItemSeed("seed_hemp",     CROP_HEMP,     Blocks.FARMLAND);
	public static final Item SEED_WILD     = new ItemSeedWild("seed_wild");
	
	// Liquor
	public static final Item LIQUOR_COFFEE = new ItemLiquor("liquor_coffee", 0);
	public static final Item LIQUOR_RUM    = new ItemLiquor("liquor_rum",    0);
	public static final Item LIQUOR_SAKE   = new ItemLiquor("liquor_sake",   0);
	public static final Item LIQUOR_SALGAM = new ItemLiquor("liquor_salgam", 0);
	public static final Item LIQUOR_VODKA  = new ItemLiquor("liquor_vodka",  0);
	public static final Item LIQUOR_BEER   = new ItemLiquor("liquor_beer",   0);
	public static final Item LIQUOR_CIDER  = new ItemLiquor("liquor_cider",  0);
	public static final Item LIQUOR_WINE   = new ItemLiquor("liquor_wine",   0);
	
	
	
	
	
	
	/**Initialize Items/Blocks that need Reference to other Items/Blocks**/
	public static void init(){
		{ // Set Seeds
			((BlockCrop) CROP_TURNIP)  .setSeed(SEED_TURNIP);
			((BlockCrop) CROP_CABBAGE) .setSeed(SEED_CABBAGE);
			//((BlockCrop) CROP_TOMATO)  .setSeed(SEED_TOMATO);
			//((BlockCrop) CROP_CUCUMBER).setSeed(SEED_CUCUMBER);
			((BlockCrop) CROP_RICE)    .setSeed(SEED_RICE);
			//((BlockCrop) CROP_CORN)    .setSeed(SEED_CORN);
			//((BlockCrop) CROP_GRAPES)  .setSeed(SEED_GRAPES);
			((BlockCrop) CROP_COFFEE)  .setSeed(SEED_COFFEE);
		}
	}
	
	/**Register all stuff, pre is true during preInit and false during Init**/
	public static void registerStuff(boolean pre){
		
		// Full Blocks
		Register.registerBlock(BLOCK_CLAVIUM    , pre, AceCraft.modid);
		Register.registerBlock(BLOCK_GILIUM     , pre, AceCraft.modid);
		Register.registerBlock(BLOCK_ADAMANTIUM , pre, AceCraft.modid);
		Register.registerBlock(BLOCK_DENARIUM   , pre, AceCraft.modid);
		Register.registerBlock(BLOCK_ZINC       , pre, AceCraft.modid);
		Register.registerBlock(BLOCK_MYTHRIL    , pre, AceCraft.modid);
		Register.registerBlock(BLOCK_AURELIUM   , pre, AceCraft.modid);
		Register.registerBlock(BLOCK_ORICHALCUM , pre, AceCraft.modid);
		Register.registerBlock(BLOCK_TIN        , pre, AceCraft.modid);
		Register.registerBlock(BLOCK_COPPER     , pre, AceCraft.modid);
		Register.registerBlock(BLOCK_BRONZE     , pre, AceCraft.modid);
		Register.registerBlock(BLOCK_SILVER     , pre, AceCraft.modid);
		Register.registerBlock(BLOCK_STEEL      , pre, AceCraft.modid);
		Register.registerBlock(BLOCK_NIVIDIUM   , pre, AceCraft.modid);
		Register.registerBlock(BLOCK_SALT       , pre, AceCraft.modid);
		Register.registerBlock(BLOCK_SULFUR     , pre, AceCraft.modid);
		Register.registerBlock(BLOCK_FLOUR      , pre, AceCraft.modid);
		Register.registerBlock(BLOCK_COFFEE     , pre, AceCraft.modid);
		Register.registerBlock(BLOCK_AURORITE   , pre, AceCraft.modid);
		
		// Nuggets
		Register.registerItem(NUGGET_IRON       , pre, AceCraft.modid);
		Register.registerItem(NUGGET_GOLD       , pre, AceCraft.modid);
		Register.registerItem(NUGGET_CLAVIUM    , pre, AceCraft.modid);
		Register.registerItem(NUGGET_GILIUM     , pre, AceCraft.modid);
		Register.registerItem(NUGGET_ZINC       , pre, AceCraft.modid);
		Register.registerItem(NUGGET_MYTHRIL    , pre, AceCraft.modid);
		Register.registerItem(NUGGET_TIN        , pre, AceCraft.modid);
		Register.registerItem(NUGGET_COPPER     , pre, AceCraft.modid);
		Register.registerItem(NUGGET_SILVER     , pre, AceCraft.modid);
		Register.registerItem(NUGGET_NIVIDIUM   , pre, AceCraft.modid);
		
		// Powder/Gems
		Register.registerItem(POWDER_SALT   , pre, AceCraft.modid);
		Register.registerItem(POWDER_SULFUR , pre, AceCraft.modid);
		Register.registerItem(POWDER_FLOUR  , pre, AceCraft.modid);
		Register.registerItem(POWDER_COFFEE , pre, AceCraft.modid);
		Register.registerItem(GEM_AURORITE  , pre, AceCraft.modid);
		
		// Ore Blocks
		Register.registerBlock(ORE_CLAVIUM     , pre, AceCraft.modid);
		Register.registerBlock(ORE_GILIUM      , pre, AceCraft.modid);
		Register.registerBlock(ORE_ZINC        , pre, AceCraft.modid);
		Register.registerBlock(ORE_MYTHRIL     , pre, AceCraft.modid);
		Register.registerBlock(ORE_TIN         , pre, AceCraft.modid);
		Register.registerBlock(ORE_COPPER      , pre, AceCraft.modid);
		Register.registerBlock(ORE_SILVER      , pre, AceCraft.modid);
		Register.registerBlock(ORE_NIVIDIUM    , pre, AceCraft.modid);
		Register.registerBlock(ORE_SALT        , pre, AceCraft.modid);
		Register.registerBlock(ORE_SULFUR      , pre, AceCraft.modid);
		Register.registerBlock(ORE_AURORITE    , pre, AceCraft.modid);
		
		// Ingots
		Register.registerItem(INGOT_CLAVIUM     , pre, AceCraft.modid);
		Register.registerItem(INGOT_GILIUM      , pre, AceCraft.modid);
		Register.registerItem(INGOT_ADAMANTIUM  , pre, AceCraft.modid);
		Register.registerItem(INGOT_DENARIUM    , pre, AceCraft.modid);
		Register.registerItem(INGOT_ZINC        , pre, AceCraft.modid);
		Register.registerItem(INGOT_MYTHRIL     , pre, AceCraft.modid);
		Register.registerItem(INGOT_AURELIUM    , pre, AceCraft.modid);
		Register.registerItem(INGOT_ORICHALCUM  , pre, AceCraft.modid);
		Register.registerItem(INGOT_TIN         , pre, AceCraft.modid);
		Register.registerItem(INGOT_COPPER      , pre, AceCraft.modid);
		Register.registerItem(INGOT_BRONZE      , pre, AceCraft.modid);
		Register.registerItem(INGOT_SILVER      , pre, AceCraft.modid);
		Register.registerItem(INGOT_STEEL       , pre, AceCraft.modid);
		Register.registerItem(INGOT_NIVIDIUM    , pre, AceCraft.modid);
		
		// Tools
		Register.registerItem(TOOL_SPEAR_WOOD         , pre, AceCraft.modid);
		Register.registerItem(TOOL_SPEAR_STONE        , pre, AceCraft.modid);
		Register.registerItem(TOOL_SPEAR_IRON         , pre, AceCraft.modid);
		Register.registerItem(TOOL_SPEAR_GOLD         , pre, AceCraft.modid);
		Register.registerItem(TOOL_SPEAR_DIAMOND      , pre, AceCraft.modid);
		Register.registerItem(TOOL_SHOVEL_GILIUM      , pre, AceCraft.modid);
		Register.registerItem(TOOL_PICKAXE_GILIUM     , pre, AceCraft.modid);
		Register.registerItem(TOOL_AXE_GILIUM         , pre, AceCraft.modid);
		Register.registerItem(TOOL_HOE_GILIUM         , pre, AceCraft.modid);
		Register.registerItem(TOOL_SWORD_GILIUM       , pre, AceCraft.modid);
		Register.registerItem(TOOL_SPEAR_GILIUM       , pre, AceCraft.modid);
		Register.registerItem(TOOL_SHOVEL_ADAMANTIUM  , pre, AceCraft.modid);
		Register.registerItem(TOOL_PICKAXE_ADAMANTIUM , pre, AceCraft.modid);
		Register.registerItem(TOOL_AXE_ADAMANTIUM     , pre, AceCraft.modid);
		Register.registerItem(TOOL_HOE_ADAMANTIUM     , pre, AceCraft.modid);
		Register.registerItem(TOOL_SWORD_ADAMANTIUM   , pre, AceCraft.modid);
		Register.registerItem(TOOL_SPEAR_ADAMANTIUM   , pre, AceCraft.modid);
		Register.registerItem(TOOL_SHOVEL_DENARIUM    , pre, AceCraft.modid);
		Register.registerItem(TOOL_PICKAXE_DENARIUM   , pre, AceCraft.modid);
		Register.registerItem(TOOL_AXE_DENARIUM       , pre, AceCraft.modid);
		Register.registerItem(TOOL_HOE_DENARIUM       , pre, AceCraft.modid);
		Register.registerItem(TOOL_SWORD_DENARIUM     , pre, AceCraft.modid);
		Register.registerItem(TOOL_SPEAR_DENARIUM     , pre, AceCraft.modid);
		Register.registerItem(TOOL_SHOVEL_MYTHRIL     , pre, AceCraft.modid);
		Register.registerItem(TOOL_PICKAXE_MYTHRIL    , pre, AceCraft.modid);
		Register.registerItem(TOOL_AXE_MYTHRIL        , pre, AceCraft.modid);
		Register.registerItem(TOOL_HOE_MYTHRIL        , pre, AceCraft.modid);
		Register.registerItem(TOOL_SWORD_MYTHRIL      , pre, AceCraft.modid);
		Register.registerItem(TOOL_SPEAR_MYTHRIL      , pre, AceCraft.modid);
		Register.registerItem(TOOL_SHOVEL_AURELIUM    , pre, AceCraft.modid);
		Register.registerItem(TOOL_PICKAXE_AURELIUM   , pre, AceCraft.modid);
		Register.registerItem(TOOL_AXE_AURELIUM       , pre, AceCraft.modid);
		Register.registerItem(TOOL_HOE_AURELIUM       , pre, AceCraft.modid);
		Register.registerItem(TOOL_SWORD_AURELIUM     , pre, AceCraft.modid);
		Register.registerItem(TOOL_SPEAR_AURELIUM     , pre, AceCraft.modid);
		Register.registerItem(TOOL_SHOVEL_ORICHALCUM  , pre, AceCraft.modid);
		Register.registerItem(TOOL_PICKAXE_ORICHALCUM , pre, AceCraft.modid);
		Register.registerItem(TOOL_AXE_ORICHALCUM     , pre, AceCraft.modid);
		Register.registerItem(TOOL_HOE_ORICHALCUM     , pre, AceCraft.modid);
		Register.registerItem(TOOL_SWORD_ORICHALCUM   , pre, AceCraft.modid);
		Register.registerItem(TOOL_SPEAR_ORICHALCUM   , pre, AceCraft.modid);
		Register.registerItem(TOOL_SHOVEL_COPPER      , pre, AceCraft.modid);
		Register.registerItem(TOOL_PICKAXE_COPPER     , pre, AceCraft.modid);
		Register.registerItem(TOOL_AXE_COPPER         , pre, AceCraft.modid);
		Register.registerItem(TOOL_HOE_COPPER         , pre, AceCraft.modid);
		Register.registerItem(TOOL_SWORD_COPPER       , pre, AceCraft.modid);
		Register.registerItem(TOOL_SPEAR_COPPER       , pre, AceCraft.modid);
		Register.registerItem(TOOL_SHOVEL_BRONZE      , pre, AceCraft.modid);
		Register.registerItem(TOOL_PICKAXE_BRONZE     , pre, AceCraft.modid);
		Register.registerItem(TOOL_AXE_BRONZE         , pre, AceCraft.modid);
		Register.registerItem(TOOL_HOE_BRONZE         , pre, AceCraft.modid);
		Register.registerItem(TOOL_SWORD_BRONZE       , pre, AceCraft.modid);
		Register.registerItem(TOOL_SPEAR_BRONZE       , pre, AceCraft.modid);
		Register.registerItem(TOOL_SHOVEL_SILVER      , pre, AceCraft.modid);
		Register.registerItem(TOOL_PICKAXE_SILVER     , pre, AceCraft.modid);
		Register.registerItem(TOOL_AXE_SILVER         , pre, AceCraft.modid);
		Register.registerItem(TOOL_HOE_SILVER         , pre, AceCraft.modid);
		Register.registerItem(TOOL_SWORD_SILVER       , pre, AceCraft.modid);
		Register.registerItem(TOOL_SPEAR_SILVER       , pre, AceCraft.modid);
		Register.registerItem(TOOL_SHOVEL_STEEL       , pre, AceCraft.modid);
		Register.registerItem(TOOL_PICKAXE_STEEL      , pre, AceCraft.modid);
		Register.registerItem(TOOL_AXE_STEEL          , pre, AceCraft.modid);
		Register.registerItem(TOOL_HOE_STEEL          , pre, AceCraft.modid);
		Register.registerItem(TOOL_SWORD_STEEL        , pre, AceCraft.modid);
		Register.registerItem(TOOL_SPEAR_STEEL        , pre, AceCraft.modid);
		Register.registerItem(TOOL_SHOVEL_AURORITE    , pre, AceCraft.modid);
		Register.registerItem(TOOL_PICKAXE_AURORITE   , pre, AceCraft.modid);
		Register.registerItem(TOOL_AXE_AURORITE       , pre, AceCraft.modid);
		Register.registerItem(TOOL_HOE_AURORITE       , pre, AceCraft.modid);
		Register.registerItem(TOOL_SWORD_AURORITE     , pre, AceCraft.modid);
		Register.registerItem(TOOL_SPEAR_AURORITE     , pre, AceCraft.modid);
		
		// Armor
		Register.registerItem(ARMOR_HELMET_GILIUM         , pre, AceCraft.modid);
		Register.registerItem(ARMOR_CHESTPLATE_GILIUM     , pre, AceCraft.modid);
		Register.registerItem(ARMOR_LEGGINGS_GILIUM       , pre, AceCraft.modid);
		Register.registerItem(ARMOR_BOOTS_GILIUM          , pre, AceCraft.modid);
		Register.registerItem(ARMOR_HELMET_ADAMANTIUM     , pre, AceCraft.modid);
		Register.registerItem(ARMOR_CHESTPLATE_ADAMANTIUM , pre, AceCraft.modid);
		Register.registerItem(ARMOR_LEGGINGS_ADAMANTIUM   , pre, AceCraft.modid);
		Register.registerItem(ARMOR_BOOTS_ADAMANTIUM      , pre, AceCraft.modid);
		Register.registerItem(ARMOR_HELMET_DENARIUM       , pre, AceCraft.modid);
		Register.registerItem(ARMOR_CHESTPLATE_DENARIUM   , pre, AceCraft.modid);
		Register.registerItem(ARMOR_LEGGINGS_DENARIUM     , pre, AceCraft.modid);
		Register.registerItem(ARMOR_BOOTS_DENARIUM        , pre, AceCraft.modid);
		Register.registerItem(ARMOR_HELMET_MYTHRIL        , pre, AceCraft.modid);
		Register.registerItem(ARMOR_CHESTPLATE_MYTHRIL    , pre, AceCraft.modid);
		Register.registerItem(ARMOR_LEGGINGS_MYTHRIL      , pre, AceCraft.modid);
		Register.registerItem(ARMOR_BOOTS_MYTHRIL         , pre, AceCraft.modid);
		Register.registerItem(ARMOR_HELMET_AURELIUM       , pre, AceCraft.modid);
		Register.registerItem(ARMOR_CHESTPLATE_AURELIUM   , pre, AceCraft.modid);
		Register.registerItem(ARMOR_LEGGINGS_AURELIUM     , pre, AceCraft.modid);
		Register.registerItem(ARMOR_BOOTS_AURELIUM        , pre, AceCraft.modid);
		Register.registerItem(ARMOR_HELMET_ORICHALCUM     , pre, AceCraft.modid);
		Register.registerItem(ARMOR_CHESTPLATE_ORICHALCUM , pre, AceCraft.modid);
		Register.registerItem(ARMOR_LEGGINGS_ORICHALCUM   , pre, AceCraft.modid);
		Register.registerItem(ARMOR_BOOTS_ORICHALCUM      , pre, AceCraft.modid);
		Register.registerItem(ARMOR_HELMET_COPPER         , pre, AceCraft.modid);
		Register.registerItem(ARMOR_CHESTPLATE_COPPER     , pre, AceCraft.modid);
		Register.registerItem(ARMOR_LEGGINGS_COPPER       , pre, AceCraft.modid);
		Register.registerItem(ARMOR_BOOTS_COPPER          , pre, AceCraft.modid);
		Register.registerItem(ARMOR_HELMET_BRONZE         , pre, AceCraft.modid);
		Register.registerItem(ARMOR_CHESTPLATE_BRONZE     , pre, AceCraft.modid);
		Register.registerItem(ARMOR_LEGGINGS_BRONZE       , pre, AceCraft.modid);
		Register.registerItem(ARMOR_BOOTS_BRONZE          , pre, AceCraft.modid);
		Register.registerItem(ARMOR_HELMET_SILVER         , pre, AceCraft.modid);
		Register.registerItem(ARMOR_CHESTPLATE_SILVER     , pre, AceCraft.modid);
		Register.registerItem(ARMOR_LEGGINGS_SILVER       , pre, AceCraft.modid);
		Register.registerItem(ARMOR_BOOTS_SILVER          , pre, AceCraft.modid);
		Register.registerItem(ARMOR_HELMET_STEEL          , pre, AceCraft.modid);
		Register.registerItem(ARMOR_CHESTPLATE_STEEL      , pre, AceCraft.modid);
		Register.registerItem(ARMOR_LEGGINGS_STEEL        , pre, AceCraft.modid);
		Register.registerItem(ARMOR_BOOTS_STEEL           , pre, AceCraft.modid);
		Register.registerItem(ARMOR_HELMET_AURORITE       , pre, AceCraft.modid);
		Register.registerItem(ARMOR_CHESTPLATE_AURORITE   , pre, AceCraft.modid);
		Register.registerItem(ARMOR_LEGGINGS_AURORITE     , pre, AceCraft.modid);
		Register.registerItem(ARMOR_BOOTS_AURORITE        , pre, AceCraft.modid);
		
		// Stuff
		Register.registerItem(STUFF_ROPE      , pre, AceCraft.modid);
		Register.registerItem(STUFF_HEMP      , pre, AceCraft.modid);
		Register.registerItem(STUFF_GEAR_WOOD , pre, AceCraft.modid);
		Register.registerItem(STUFF_FUR       , pre, AceCraft.modid);
		Register.registerItem(STUFF_TUSK      , pre, AceCraft.modid);
		Register.registerItem(STUFF_ANTLER    , pre, AceCraft.modid);
		Register.registerItem(STUFF_DYNAMITE  , pre, AceCraft.modid);
		
		// Machina
		Register.registerBlock(MACHINA_ANCHOR       , pre, AceCraft.modid);
		Register.registerBlock(MACHINA_AXLE         , pre, AceCraft.modid);
		Register.registerBlock(MACHINA_BLASTFURNACE , pre, AceCraft.modid);
		Register.registerBlock(MACHINA_CAMPFIRE     , pre, AceCraft.modid);
		Register.registerBlock(MACHINA_DISTILLERY   , pre, AceCraft.modid);
		Register.registerBlock(MACHINA_FRUITPRESS   , pre, AceCraft.modid);
		Register.registerBlock(MACHINA_GEARBOX      , pre, AceCraft.modid);
		Register.registerBlock(MACHINA_GLOBE        , pre, AceCraft.modid);
		Register.registerBlock(MACHINA_KEG          , pre, AceCraft.modid);
		Register.registerBlock(MACHINA_MILLSTONE    , pre, AceCraft.modid);
		Register.registerBlock(MACHINA_ROPE         , pre, AceCraft.modid);
		Register.registerBlock(MACHINA_WATERWHEEL   , pre, AceCraft.modid);
		Register.registerBlock(MACHINA_WINDMILL     , pre, AceCraft.modid);
		
		// Food
		Register.registerItem(FOOD_TURNIP         , pre, AceCraft.modid);
		Register.registerItem(FOOD_CABBAGE        , pre, AceCraft.modid);
		//Register.registerItem(FOOD_TOMATO         , pre, AceCraft.modid);
		//Register.registerItem(FOOD_CUCUMBER       , pre, AceCraft.modid);
		Register.registerItem(FOOD_RICE           , pre, AceCraft.modid);
		//Register.registerItem(FOOD_CORN           , pre, AceCraft.modid);
		//Register.registerItem(FOOD_GRAPES         , pre, AceCraft.modid);
		Register.registerItem(FOOD_COFFEE         , pre, AceCraft.modid);
		Register.registerItem(FOOD_VENISON_RAW    , pre, AceCraft.modid);
		Register.registerItem(FOOD_VENISON_COOKED , pre, AceCraft.modid);
		Register.registerItem(FOOD_VICUGNA_RAW    , pre, AceCraft.modid);
		Register.registerItem(FOOD_VICUGNA_COOKED , pre, AceCraft.modid);
		
		// Crops
		Register.registerBlock(CROP_TURNIP   , pre, AceCraft.modid);
		Register.registerBlock(CROP_CABBAGE  , pre, AceCraft.modid);
		//Register.registerBlock(CROP_TOMATO   , pre, AceCraft.modid);
		//Register.registerBlock(CROP_CUCUMBER , pre, AceCraft.modid);
		Register.registerBlock(CROP_RICE     , pre, AceCraft.modid);
		//Register.registerBlock(CROP_CORN     , pre, AceCraft.modid);
		//Register.registerBlock(CROP_GRAPES   , pre, AceCraft.modid);
		Register.registerBlock(CROP_COFFEE   , pre, AceCraft.modid);
		Register.registerBlock(CROP_HEMP     , pre, AceCraft.modid);
		
		// Seeds
		Register.registerItem(SEED_TURNIP   , pre, AceCraft.modid);
		Register.registerItem(SEED_CABBAGE  , pre, AceCraft.modid);
		//Register.registerItem(SEED_TOMATO   , pre, AceCraft.modid);
		//Register.registerItem(SEED_CUCUMBER , pre, AceCraft.modid);
		Register.registerItem(SEED_RICE     , pre, AceCraft.modid);
		//Register.registerItem(SEED_CORN     , pre, AceCraft.modid);
		//Register.registerItem(SEED_GRAPES   , pre, AceCraft.modid);
		Register.registerItem(SEED_COFFEE   , pre, AceCraft.modid);
		Register.registerItem(SEED_HEMP     , pre, AceCraft.modid);
		Register.registerItem(SEED_WILD     , pre, AceCraft.modid);
		
		// Liquor
		Register.registerItem(LIQUOR_COFFEE , pre, AceCraft.modid);
		Register.registerItem(LIQUOR_RUM    , pre, AceCraft.modid);
		Register.registerItem(LIQUOR_SAKE   , pre, AceCraft.modid);
		Register.registerItem(LIQUOR_SALGAM , pre, AceCraft.modid);
		Register.registerItem(LIQUOR_VODKA  , pre, AceCraft.modid);
		Register.registerItem(LIQUOR_BEER   , pre, AceCraft.modid);
		Register.registerItem(LIQUOR_CIDER  , pre, AceCraft.modid);
		Register.registerItem(LIQUOR_WINE   , pre, AceCraft.modid);
	}
	
	/**Register Sounds**/
	public static void registerSounds(){
		
	}
	
	/**Register Crafting and Furnace Recipes**/
	public static void registerRecipes(){
		GameRegistry.addSmelting(new ItemStack(NUGGET_IRON, 1), new ItemStack(Items.IRON_INGOT, 1), 5);
		GameRegistry.addSmelting(new ItemStack(NUGGET_GOLD, 1), new ItemStack(Items.GOLD_INGOT, 1), 5);
		
		GameRegistry.addSmelting(new ItemStack(   ORE_CLAVIUM, 1), new ItemStack(INGOT_CLAVIUM, 1), 5);
		GameRegistry.addSmelting(new ItemStack(NUGGET_CLAVIUM, 1), new ItemStack(INGOT_CLAVIUM, 1), 5);
		GameRegistry.addSmelting(new ItemStack(   ORE_GILIUM, 1), new ItemStack(INGOT_GILIUM, 1), 5);
		GameRegistry.addSmelting(new ItemStack(NUGGET_GILIUM, 1), new ItemStack(INGOT_GILIUM, 1), 5);
		GameRegistry.addSmelting(new ItemStack(   ORE_ZINC, 1), new ItemStack(INGOT_ZINC, 1), 5);
		GameRegistry.addSmelting(new ItemStack(NUGGET_ZINC, 1), new ItemStack(INGOT_ZINC, 1), 5);
		GameRegistry.addSmelting(new ItemStack(   ORE_MYTHRIL, 1), new ItemStack(INGOT_MYTHRIL, 1), 5);
		GameRegistry.addSmelting(new ItemStack(NUGGET_MYTHRIL, 1), new ItemStack(INGOT_MYTHRIL, 1), 5);
		GameRegistry.addSmelting(new ItemStack(   ORE_TIN, 1), new ItemStack(INGOT_TIN, 1), 5);
		GameRegistry.addSmelting(new ItemStack(NUGGET_TIN, 1), new ItemStack(INGOT_TIN, 1), 5);
		GameRegistry.addSmelting(new ItemStack(   ORE_COPPER, 1), new ItemStack(INGOT_COPPER, 1), 5);
		GameRegistry.addSmelting(new ItemStack(NUGGET_COPPER, 1), new ItemStack(INGOT_COPPER, 1), 5);
		GameRegistry.addSmelting(new ItemStack(   ORE_SILVER, 1), new ItemStack(INGOT_SILVER, 1), 5);
		GameRegistry.addSmelting(new ItemStack(NUGGET_SILVER, 1), new ItemStack(INGOT_SILVER, 1), 5);
		GameRegistry.addSmelting(new ItemStack(   ORE_NIVIDIUM, 1), new ItemStack(INGOT_NIVIDIUM, 1), 5);
		GameRegistry.addSmelting(new ItemStack(NUGGET_NIVIDIUM, 1), new ItemStack(INGOT_NIVIDIUM, 1), 5);
	}
	
	/**Register Living and Tile Entities**/
	public static void registerEntities(){
		
		// public static void registerEntity(Class<? extends Entity> entity, String name, Render<? extends Entity> renderer, Object instance, String modid)
		
		Register.registerEntity(EntityDeer.class,   "acecraft_deer",   AceCraft.instance, AceCraft.modid);
		Register.registerEntity(EntityCrab.class,   "acecraft_crab",   AceCraft.instance, AceCraft.modid);
		Register.registerEntity(EntityGoat.class,   "acecraft_goat",   AceCraft.instance, AceCraft.modid);
		Register.registerEntity(EntityLlama.class,  "acecraft_llama",  AceCraft.instance, AceCraft.modid);
		Register.registerEntity(EntityNugget.class, "acecraft_nugget", AceCraft.instance, AceCraft.modid);
		Register.registerEntity(EntitySpear.class,  "acecraft_spear",  AceCraft.instance, AceCraft.modid);
		
		GameRegistry.registerTileEntity(TileEntityAxle        .class, new ResourceLocation(AceCraft.modid, "acecraft_axle"));
		GameRegistry.registerTileEntity(TileEntityBlastFurnace.class, new ResourceLocation(AceCraft.modid, "acecraft_blastfurnace"));
		GameRegistry.registerTileEntity(TileEntityCampfire    .class, new ResourceLocation(AceCraft.modid, "acecraft_campfire"));
		GameRegistry.registerTileEntity(TileEntityDistillery  .class, new ResourceLocation(AceCraft.modid, "acecraft_distillery"));
		GameRegistry.registerTileEntity(TileEntityFruitPress  .class, new ResourceLocation(AceCraft.modid, "acecraft_fruitpress"));
		GameRegistry.registerTileEntity(TileEntityGearBox     .class, new ResourceLocation(AceCraft.modid, "acecraft_gearbox"));
		GameRegistry.registerTileEntity(TileEntityKeg         .class, new ResourceLocation(AceCraft.modid, "acecraft_keg"));
		GameRegistry.registerTileEntity(TileEntityMillstone   .class, new ResourceLocation(AceCraft.modid, "acecraft_millstone"));
		GameRegistry.registerTileEntity(TileEntityWaterwheel  .class, new ResourceLocation(AceCraft.modid, "acecraft_waterwheel"));
		GameRegistry.registerTileEntity(TileEntityWindmill    .class, new ResourceLocation(AceCraft.modid, "acecraft_windmill"));
	}
	
	/**Registers all Renderer to their Living Entities**/
	public static void registerRenders(){
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWindmill  .class, new RenderWindmill()  ); //Windmill
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWaterwheel.class, new RenderWaterwheel()); //Waterwheel
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAxle      .class, new RenderAxle()      ); //Axle
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFruitPress.class, new RenderFruitPress()); //FruitPress
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMillstone .class, new RenderMillstone() ); //Millstone
	}
	
}
