package mod.acecraft;

import mod.acecraft.client.menu.MenuDistillery;
import mod.acecraft.client.menu.MenuFoundry;
import mod.acecraft.common.block.BlockAnchor;
import mod.acecraft.common.block.BlockDistillery;
import mod.acecraft.common.block.BlockFoundry;
import mod.acecraft.common.block.BlockRope;
import mod.acecraft.common.block.entity.BlockEntityDistillery;
import mod.acecraft.common.block.entity.BlockEntityFoundry;
import mod.acecraft.common.entity.EntityAlpaca;
import mod.acecraft.common.entity.EntityDynamite;
import mod.acecraft.common.entity.EntitySpit;
import mod.acecraft.common.item.*;
import mod.acecraft.custom.material.MaterialArmor;
import mod.acecraft.custom.material.MaterialTool;
import mod.acecraft.custom.recipe.RecipeDistillery;
import mod.lucky77.common.block.BlockBlock;
import mod.lucky77.common.block.BlockCrop;
import mod.lucky77.common.block.BlockXP;
import mod.lucky77.common.item.ItemFood;
import mod.lucky77.common.item.ItemItem;
import mod.lucky77.common.item.ItemSeed;
import mod.lucky77.custom.other.SupportStructure;
import mod.lucky77.custom.other.SupportTrades;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static mod.acecraft.AceCraft.MODID;

public class Register {
	
	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
	public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
	
	public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(Registries.MENU, MODID);
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MODID);
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(Registries.SOUND_EVENT, MODID);
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(Registries.ENTITY_TYPE, MODID);
	public static final DeferredRegister<RecipeSerializer<?>> RECIPES = DeferredRegister.create(Registries.RECIPE_SERIALIZER, MODID);
	
	// private static final Map<DeferredBlock<Block>, CreativeModeTab> CREATIVE_TABS = new HashMap<>();
	
	// --- Blocks / Items
	
	// Block Blocks
	public static final DeferredBlock<Block> BLOCK_TIN = registerBlock("block_tin", () -> new BlockBlock(Blocks.IRON_BLOCK.properties()));
	public static final DeferredBlock<Block> BLOCK_MYTHRIL = registerBlock("block_mythril", () -> new BlockBlock(Blocks.IRON_BLOCK.properties()));
	public static final DeferredBlock<Block> BLOCK_GILIUM = registerBlock("block_gilium", () -> new BlockBlock(Blocks.IRON_BLOCK.properties()));
	public static final DeferredBlock<Block> BLOCK_BRONZE = registerBlock("block_bronze", () -> new BlockBlock(Blocks.IRON_BLOCK.properties()));
	public static final DeferredBlock<Block> BLOCK_ORICHALCUM = registerBlock("block_orichalcum", () -> new BlockBlock(Blocks.IRON_BLOCK.properties()));
	public static final DeferredBlock<Block> BLOCK_ADAMANTIUM = registerBlock("block_adamantium", () -> new BlockBlock(Blocks.IRON_BLOCK.properties()));
	public static final DeferredBlock<Block> BLOCK_AURORITE = registerBlock("block_aurorite", () -> new BlockBlock(Blocks.IRON_BLOCK.properties()));
	
	// Ore Blocks
	public static final DeferredBlock<Block> ORE_TIN_BASE = registerBlock("ore_tin_base", () -> new BlockXP(Blocks.IRON_ORE.properties(), 1,10));
	public static final DeferredBlock<Block> ORE_TIN_DEEP = registerBlock("ore_tin_deep", () -> new BlockXP(Blocks.IRON_ORE.properties(), 5, 10));
	public static final DeferredBlock<Block> ORE_TIN_RAW = registerBlock("ore_tin_raw", () -> new BlockXP(Blocks.RAW_IRON_BLOCK.properties(), 0, 0));
	public static final DeferredBlock<Block> ORE_MYTHRIL_BASE = registerBlock("ore_mythril_base", () -> new BlockXP(Blocks.IRON_ORE.properties(), 1, 10));
	public static final DeferredBlock<Block> ORE_MYTHRIL_DEEP = registerBlock("ore_mythril_deep", () -> new BlockXP(Blocks.IRON_ORE.properties(), 5, 10));
	public static final DeferredBlock<Block> ORE_MYTHRIL_RAW = registerBlock("ore_mythril_raw", () -> new BlockXP(Blocks.RAW_IRON_BLOCK.properties(), 0, 0));
	public static final DeferredBlock<Block> ORE_GILIUM_HELL = registerBlock("ore_gilium_hell", () -> new BlockXP(Blocks.IRON_ORE.properties(), 3, 10));
	public static final DeferredBlock<Block> ORE_GILIUM_RAW = registerBlock("ore_gilium_raw", () -> new BlockXP(Blocks.RAW_IRON_BLOCK.properties(), 0, 0));
	public static final DeferredBlock<Block> ORE_AURORITE_BASE = registerBlock("ore_aurorite_base", () -> new BlockXP(Blocks.IRON_ORE.properties(), 1, 10));
	public static final DeferredBlock<Block> ORE_AURORITE_DEEP = registerBlock("ore_aurorite_deep", () -> new BlockXP(Blocks.IRON_ORE.properties(), 5, 10));
	
	// Raw Ore Nugget Blocks
	
	
	
	
	// Item Items
	
	public static final DeferredItem<Item> STUFF_HEMP = registerItem("stuff_hemp", () -> new ItemItem());
	public static final DeferredItem<Item> STUFF_ROPE = registerItem("stuff_rope", () -> new ItemItem());
	public static final DeferredItem<Item> STUFF_TIN_NUGGET = registerItem("stuff_tin_nugget", () -> new ItemItem());
	public static final DeferredItem<Item> STUFF_TIN_INGOT = registerItem("stuff_tin_ingot", () -> new ItemItem());
	public static final DeferredItem<Item> STUFF_MYTHRIL_NUGGET = registerItem("stuff_mythril_nugget", () -> new ItemItem());
	public static final DeferredItem<Item> STUFF_MYTHRIL_INGOT = registerItem("stuff_mythril_ingot", () -> new ItemItem());
	public static final DeferredItem<Item> STUFF_GILIUM_NUGGET = registerItem("stuff_gilium_nugget", () -> new ItemItem());
	public static final DeferredItem<Item> STUFF_GILIUM_INGOT = registerItem("stuff_gilium_ingot", () -> new ItemItem());
	public static final DeferredItem<Item> STUFF_BRONZE_INGOT = registerItem("stuff_bronze_ingot", () -> new ItemItem());
	public static final DeferredItem<Item> STUFF_ORICHALCUM_INGOT = registerItem("stuff_orichalcum_ingot", () -> new ItemItem());
	public static final DeferredItem<Item> STUFF_ADAMANTIUM_INGOT = registerItem("stuff_adamantium_ingot", () -> new ItemItem());
	public static final DeferredItem<Item> STUFF_AURORITE = registerItem("stuff_aurorite", () -> new ItemItem());
	public static final DeferredItem<Item> STUFF_SLAG = registerItem("stuff_slag", () -> new ItemItem());
	
	
	
	// Food Items
	public static final DeferredItem<Item> FOOD_COFFEE = registerItem("food_coffee", () -> new ItemFood(1, 1));
	public static final DeferredItem<Item> FOOD_VICUGNA_RAW = registerItem("food_vicugna_raw", () -> new ItemFood(3, 0.3f));
	public static final DeferredItem<Item> FOOD_VICUGNA_COOKED = registerItem("food_vicugna_cooked", () -> new ItemFood(8, 0.8f));
	
	// Drink Items
	public static final DeferredItem<Item> LIQUOR_COFFEE = registerItem("liquor_coffee", () -> new ItemLiquor(MobEffects.ABSORPTION, 1, MobEffects.ABSORPTION, 1));
	public static final DeferredItem<Item> LIQUOR_SALGAM = registerItem("liquor_salgam", () -> new ItemLiquor(MobEffects.ABSORPTION, 1, MobEffects.ABSORPTION, 1));
	public static final DeferredItem<Item> LIQUOR_WHISKY = registerItem("liquor_whisky", () -> new ItemLiquor(MobEffects.ABSORPTION, 1, MobEffects.ABSORPTION, 1));
	public static final DeferredItem<Item> LIQUOR_VODKA = registerItem("liquor_vodka", () -> new ItemLiquor(MobEffects.ABSORPTION, 1, MobEffects.ABSORPTION, 1));
	public static final DeferredItem<Item> LIQUOR_RUM = registerItem("liquor_rum", () -> new ItemLiquor(MobEffects.ABSORPTION, 1, MobEffects.ABSORPTION, 1));
	
	// Crop Blocks
	public static final DeferredBlock<Block> CROP_COFFEE = registerBlockNoItem("crop_coffee", () -> new BlockCrop(Blocks.WHEAT, "coffee"));
	public static final DeferredBlock<Block> CROP_HEMP = registerBlockNoItem("crop_hemp", () -> new BlockCrop(Blocks.WHEAT, "hemp", 2, 2));
	
	// Seed Items
	public static final DeferredItem<Item> SEED_COFFEE = registerItem("seed_coffee", () -> new ItemSeed(Blocks.WHEAT, "coffee"));
	public static final DeferredItem<Item> SEED_HEMP = registerItem("seed_hemp", () -> new ItemSeed(Blocks.WHEAT, "hemp"));
	
	// Machines
	public static final DeferredBlock<Block> MACHINA_ANCHOR = registerBlock("machina_anchor", () -> new BlockAnchor());
	public static final DeferredBlock<Block> MACHINA_FOUNDRY = registerBlock("machina_foundry", () -> new BlockFoundry());
	public static final DeferredBlock<Block> MACHINA_DISTILLERY = registerBlock("machina_distillery", () -> new BlockDistillery());
	
	public static final DeferredBlock<Block> MACHINA_ROPE = registerBlockNoItem("machina_rope", () -> new BlockRope());
	
	// Armor - Boots
	public static final DeferredItem<Item> ARMOR_BOOTS_MYTHRIL = registerItem("armor_boots_mythril", () -> new ItemArmor(MaterialArmor.MYTHRIL, ArmorItem.Type.BOOTS));
	public static final DeferredItem<Item> ARMOR_BOOTS_GILIUM = registerItem("armor_boots_gilium", () -> new ItemArmor(MaterialArmor.GILIUM, ArmorItem.Type.BOOTS));
	public static final DeferredItem<Item> ARMOR_BOOTS_BRONZE = registerItem("armor_boots_bronze", () -> new ItemArmor(MaterialArmor.BRONZE, ArmorItem.Type.BOOTS));
	public static final DeferredItem<Item> ARMOR_BOOTS_ORICHALCUM = registerItem("armor_boots_orichalcum", () -> new ItemArmor(MaterialArmor.ORICHALCUM, ArmorItem.Type.BOOTS));
	public static final DeferredItem<Item> ARMOR_BOOTS_ADAMANTIUM = registerItem("armor_boots_adamantium", () -> new ItemArmor(MaterialArmor.ADAMANTIUM, ArmorItem.Type.BOOTS));
	public static final DeferredItem<Item> ARMOR_BOOTS_AURORITE = registerItem("armor_boots_aurorite", () -> new ItemArmor(MaterialArmor.AURORITE, ArmorItem.Type.BOOTS));
	
	// Armor - Chestplates
	public static final DeferredItem<Item> ARMOR_CHESTPLATE_MYTHRIL = registerItem("armor_chestplate_mythril", () -> new ItemArmor(MaterialArmor.MYTHRIL, ArmorItem.Type.CHESTPLATE));
	public static final DeferredItem<Item> ARMOR_CHESTPLATE_GILIUM = registerItem("armor_chestplate_gilium", () -> new ItemArmor(MaterialArmor.GILIUM, ArmorItem.Type.CHESTPLATE));
	public static final DeferredItem<Item> ARMOR_CHESTPLATE_BRONZE = registerItem("armor_chestplate_bronze", () -> new ItemArmor(MaterialArmor.BRONZE, ArmorItem.Type.CHESTPLATE));
	public static final DeferredItem<Item> ARMOR_CHESTPLATE_ORICHALCUM = registerItem("armor_chestplate_orichalcum", () -> new ItemArmor(MaterialArmor.ORICHALCUM, ArmorItem.Type.CHESTPLATE));
	public static final DeferredItem<Item> ARMOR_CHESTPLATE_ADAMANTIUM = registerItem("armor_chestplate_adamantium", () -> new ItemArmor(MaterialArmor.ADAMANTIUM, ArmorItem.Type.CHESTPLATE));
	public static final DeferredItem<Item> ARMOR_CHESTPLATE_AURORITE = registerItem("armor_chestplate_aurorite", () -> new ItemArmor(MaterialArmor.AURORITE, ArmorItem.Type.CHESTPLATE));
	
	// Armor - Leggings
	public static final DeferredItem<Item> ARMOR_LEGGINGS_MYTHRIL = registerItem("armor_leggings_mythril", () -> new ItemArmor(MaterialArmor.MYTHRIL, ArmorItem.Type.LEGGINGS));
	public static final DeferredItem<Item> ARMOR_LEGGINGS_GILIUM = registerItem("armor_leggings_gilium", () -> new ItemArmor(MaterialArmor.GILIUM, ArmorItem.Type.LEGGINGS));
	public static final DeferredItem<Item> ARMOR_LEGGINGS_BRONZE = registerItem("armor_leggings_bronze", () -> new ItemArmor(MaterialArmor.BRONZE, ArmorItem.Type.LEGGINGS));
	public static final DeferredItem<Item> ARMOR_LEGGINGS_ORICHALCUM = registerItem("armor_leggings_orichalcum", () -> new ItemArmor(MaterialArmor.ORICHALCUM, ArmorItem.Type.LEGGINGS));
	public static final DeferredItem<Item> ARMOR_LEGGINGS_ADAMANTIUM = registerItem("armor_leggings_adamantium", () -> new ItemArmor(MaterialArmor.ADAMANTIUM, ArmorItem.Type.LEGGINGS));
	public static final DeferredItem<Item> ARMOR_LEGGINGS_AURORITE = registerItem("armor_leggings_aurorite", () -> new ItemArmor(MaterialArmor.AURORITE, ArmorItem.Type.LEGGINGS));
	
	// Armor - Helmets
	public static final DeferredItem<Item> ARMOR_HELMET_MYTHRIL = registerItem("armor_helmet_mythril", () -> new ItemArmor(MaterialArmor.MYTHRIL, ArmorItem.Type.HELMET));
	public static final DeferredItem<Item> ARMOR_HELMET_GILIUM = registerItem("armor_helmet_gilium", () -> new ItemArmor(MaterialArmor.GILIUM, ArmorItem.Type.HELMET));
	public static final DeferredItem<Item> ARMOR_HELMET_BRONZE = registerItem("armor_helmet_bronze", () -> new ItemArmor(MaterialArmor.BRONZE, ArmorItem.Type.HELMET));
	public static final DeferredItem<Item> ARMOR_HELMET_ORICHALCUM = registerItem("armor_helmet_orichalcum", () -> new ItemArmor(MaterialArmor.ORICHALCUM, ArmorItem.Type.HELMET));
	public static final DeferredItem<Item> ARMOR_HELMET_ADAMANTIUM = registerItem("armor_helmet_adamantium", () -> new ItemArmor(MaterialArmor.ADAMANTIUM, ArmorItem.Type.HELMET));
	public static final DeferredItem<Item> ARMOR_HELMET_AURORITE = registerItem("armor_helmet_aurorite", () -> new ItemArmor(MaterialArmor.AURORITE, ArmorItem.Type.HELMET));
	
	// Tools - Swords
	public static final DeferredItem<Item> TOOL_SWORD_MYTHRIL = registerItem("tool_sword_mythril", () -> new ToolSword(MaterialTool.MYTHRIL, 1, 1));
	public static final DeferredItem<Item> TOOL_SWORD_GILIUM = registerItem("tool_sword_gilium", () -> new ToolSword(MaterialTool.GILIUM, 1, 1));
	public static final DeferredItem<Item> TOOL_SWORD_BRONZE = registerItem("tool_sword_bronze", () -> new ToolSword(MaterialTool.BRONZE, 1, 1));
	public static final DeferredItem<Item> TOOL_SWORD_ORICHALCUM = registerItem("tool_sword_orichalcum", () -> new ToolSword(MaterialTool.ORICHALCUM, 1, 1));
	public static final DeferredItem<Item> TOOL_SWORD_ADAMANTIUM = registerItem("tool_sword_adamantium", () -> new ToolSword(MaterialTool.ADAMANTIUM, 1, 1));
	public static final DeferredItem<Item> TOOL_SWORD_AURORITE = registerItem("tool_sword_aurorite", () -> new ToolSword(MaterialTool.AURORITE, 1, 1));
	
	// Tools - Axes
	public static final DeferredItem<Item> TOOL_AXE_MYTHRIL = registerItem("tool_axe_mythril", () -> new ToolAxe(MaterialTool.MYTHRIL, 1, 1));
	public static final DeferredItem<Item> TOOL_AXE_GILIUM = registerItem("tool_axe_gilium", () -> new ToolAxe(MaterialTool.GILIUM, 1, 1));
	public static final DeferredItem<Item> TOOL_AXE_BRONZE = registerItem("tool_axe_bronze", () -> new ToolAxe(MaterialTool.BRONZE, 1, 1));
	public static final DeferredItem<Item> TOOL_AXE_ORICHALCUM = registerItem("tool_axe_orichalcum", () -> new ToolAxe(MaterialTool.ORICHALCUM, 1, 1));
	public static final DeferredItem<Item> TOOL_AXE_ADAMANTIUM = registerItem("tool_axe_adamantium", () -> new ToolAxe(MaterialTool.ADAMANTIUM, 1, 1));
	public static final DeferredItem<Item> TOOL_AXE_AURORITE = registerItem("tool_axe_aurorite", () -> new ToolAxe(MaterialTool.AURORITE, 1, 1));
	
	// Tools - Pickaxes
	public static final DeferredItem<Item> TOOL_PICKAXE_MYTHRIL = registerItem("tool_pickaxe_mythril", () -> new ToolPickaxe(MaterialTool.MYTHRIL, 1, 1));
	public static final DeferredItem<Item> TOOL_PICKAXE_GILIUM = registerItem("tool_pickaxe_gilium", () -> new ToolPickaxe(MaterialTool.GILIUM, 1, 1));
	public static final DeferredItem<Item> TOOL_PICKAXE_BRONZE = registerItem("tool_pickaxe_bronze", () -> new ToolPickaxe(MaterialTool.BRONZE, 1, 1));
	public static final DeferredItem<Item> TOOL_PICKAXE_ORICHALCUM = registerItem("tool_pickaxe_orichalcum", () -> new ToolPickaxe(MaterialTool.ORICHALCUM, 1, 1));
	public static final DeferredItem<Item> TOOL_PICKAXE_ADAMANTIUM = registerItem("tool_pickaxe_adamantium", () -> new ToolPickaxe(MaterialTool.ADAMANTIUM, 1, 1));
	public static final DeferredItem<Item> TOOL_PICKAXE_AURORITE = registerItem("tool_pickaxe_aurorite", () -> new ToolPickaxe(MaterialTool.AURORITE, 1, 1));
	
	// Tools - Shovels
	public static final DeferredItem<Item> TOOL_SHOVEL_MYTHRIL = registerItem("tool_shovel_mythril", () -> new ToolShovel(MaterialTool.MYTHRIL, 1, 1));
	public static final DeferredItem<Item> TOOL_SHOVEL_GILIUM = registerItem("tool_shovel_gilium", () -> new ToolShovel(MaterialTool.GILIUM, 1, 1));
	public static final DeferredItem<Item> TOOL_SHOVEL_BRONZE = registerItem("tool_shovel_bronze", () -> new ToolShovel(MaterialTool.BRONZE, 1, 1));
	public static final DeferredItem<Item> TOOL_SHOVEL_ORICHALCUM = registerItem("tool_shovel_orichalcum", () -> new ToolShovel(MaterialTool.ORICHALCUM, 1, 1));
	public static final DeferredItem<Item> TOOL_SHOVEL_ADAMANTIUM = registerItem("tool_shovel_adamantium", () -> new ToolShovel(MaterialTool.ADAMANTIUM, 1, 1));
	public static final DeferredItem<Item> TOOL_SHOVEL_AURORITE = registerItem("tool_shovel_aurorite", () -> new ToolShovel(MaterialTool.AURORITE, 1, 1));
	
	// Tools - Hoes
	public static final DeferredItem<Item> TOOL_HOE_MYTHRIL = registerItem("tool_hoe_mythril", () -> new ToolHoe(MaterialTool.MYTHRIL, 1, 1));
	public static final DeferredItem<Item> TOOL_HOE_GILIUM = registerItem("tool_hoe_gilium", () -> new ToolHoe(MaterialTool.GILIUM, 1, 1));
	public static final DeferredItem<Item> TOOL_HOE_BRONZE = registerItem("tool_hoe_bronze", () -> new ToolHoe(MaterialTool.BRONZE, 1, 1));
	public static final DeferredItem<Item> TOOL_HOE_ORICHALCUM = registerItem("tool_hoe_orichalcum", () -> new ToolHoe(MaterialTool.ORICHALCUM, 1, 1));
	public static final DeferredItem<Item> TOOL_HOE_ADAMANTIUM = registerItem("tool_hoe_adamantium", () -> new ToolHoe(MaterialTool.ADAMANTIUM, 1, 1));
	public static final DeferredItem<Item> TOOL_HOE_AURORITE = registerItem("tool_hoe_aurorite", () -> new ToolHoe(MaterialTool.AURORITE, 1, 1));
	
	// Tools - Other
	public static final DeferredItem<Item> TOOL_DYNAMITE = registerItem("tool_dynamite", () -> new ToolDynamite());
	
	// Books
	public static final DeferredItem<Item> BOOK_ALLOY = registerItem("book_alloy", () -> new ItemBookAlloy(0, 0));
	public static final DeferredItem<Item> BOOK_PLANT = registerItem("book_plant", () -> new ItemBookPlant(1, 1));
	public static final DeferredItem<Item> BOOK_DRINK = registerItem("book_drink", () -> new ItemBookDrink(2, 2));
	
	// --- Sounds
	
	// --- Block Entities
	public static final Supplier<BlockEntityType<BlockEntityFoundry>> ENTITY_FOUNDRY = BLOCK_ENTITIES.register("foundry", () -> BlockEntityType.Builder.of(BlockEntityFoundry::new, MACHINA_FOUNDRY.get()).build(null));
	public static final Supplier<BlockEntityType<BlockEntityDistillery>> ENTITY_DISTILLERY = BLOCK_ENTITIES.register("distillery", () -> BlockEntityType.Builder.of(BlockEntityDistillery::new, MACHINA_DISTILLERY.get()).build(null));
	
	// --- Menus
	public static final Supplier<MenuType<MenuFoundry>> MENU_FOUNDRY = MENUS.register("foundry", () -> IMenuTypeExtension.create(MenuFoundry::new));
	public static final Supplier<MenuType<MenuDistillery>> MENU_DISTILLERY = MENUS.register("distillery", () -> IMenuTypeExtension.create(MenuDistillery::new));
	
	// --- Loot Tables
	public static final ResourceLocation ALPACA_WHITE = ResourceLocation.fromNamespaceAndPath(MODID, "entities/alpaca/white");
	public static final ResourceLocation ALPACA_ORANGE = ResourceLocation.fromNamespaceAndPath(MODID, "entities/alpaca/orange");
	public static final ResourceLocation ALPACA_MAGENTA = ResourceLocation.fromNamespaceAndPath(MODID, "entities/alpaca/magenta");
	public static final ResourceLocation ALPACA_LIGHT_BLUE = ResourceLocation.fromNamespaceAndPath(MODID, "entities/alpaca/light_blue");
	public static final ResourceLocation ALPACA_YELLOW = ResourceLocation.fromNamespaceAndPath(MODID, "entities/alpaca/yellow");
	public static final ResourceLocation ALPACA_LIME = ResourceLocation.fromNamespaceAndPath(MODID, "entities/alpaca/lime");
	public static final ResourceLocation ALPACA_PINK = ResourceLocation.fromNamespaceAndPath(MODID, "entities/alpaca/pink");
	public static final ResourceLocation ALPACA_GRAY = ResourceLocation.fromNamespaceAndPath(MODID, "entities/alpaca/gray");
	public static final ResourceLocation ALPACA_LIGHT_GRAY = ResourceLocation.fromNamespaceAndPath(MODID, "entities/alpaca/light_gray");
	public static final ResourceLocation ALPACA_CYAN = ResourceLocation.fromNamespaceAndPath(MODID, "entities/alpaca/cyan");
	public static final ResourceLocation ALPACA_PURPLE = ResourceLocation.fromNamespaceAndPath(MODID, "entities/alpaca/purple");
	public static final ResourceLocation ALPACA_BLUE = ResourceLocation.fromNamespaceAndPath(MODID, "entities/alpaca/blue");
	public static final ResourceLocation ALPACA_BROWN = ResourceLocation.fromNamespaceAndPath(MODID, "entities/alpaca/brown");
	public static final ResourceLocation ALPACA_GREEN = ResourceLocation.fromNamespaceAndPath(MODID, "entities/alpaca/green");
	public static final ResourceLocation ALPACA_RED = ResourceLocation.fromNamespaceAndPath(MODID, "entities/alpaca/red");
	public static final ResourceLocation ALPACA_BLACK = ResourceLocation.fromNamespaceAndPath(MODID, "entities/alpaca/black");
	
	// --- Entites
	public static final Supplier<EntityType<EntityAlpaca>> ENTITY_ALPACA = ENTITIES.register("alpaca", () -> EntityType.Builder.of(EntityAlpaca::new, MobCategory.CREATURE).sized(1f, 1f).setTrackingRange(10).build("alpaca"));
	public static final Supplier<EntityType<EntityDynamite>> ENTITY_DYNAMITE = ENTITIES.register("dynamite", () -> EntityType.Builder.<EntityDynamite>of(EntityDynamite::new, MobCategory.MISC).sized(1f, 1f).build("dynamite"));
	public static final Supplier<EntityType<EntitySpit>> ENTITY_SPIT = ENTITIES.register("spit", () -> EntityType.Builder.<EntitySpit>of(EntitySpit::new, MobCategory.MISC).sized(1f, 1f).build("alpaca_spit"));
	
	// --- Spawn Eggs
	public static final DeferredItem<Item> SPAWNEGG_ALPACA = registerItem("spawnegg_alpaca", () -> new DeferredSpawnEggItem(ENTITY_ALPACA, 87654, 6543, new Item.Properties()));
	
	// --- Textures
	
	// --- Recipies
	public static final Supplier<RecipeSerializer<RecipeDistillery>> RECIPE_DISTILLING = RECIPES.register("distilling", () -> RecipeDistillery.Serializer.INSTANCE);
	
	// --- SUPPORT
	
	static void setup(FMLCommonSetupEvent event){
	
	}
	
	@OnlyIn(Dist.CLIENT)
	static void setup(FMLClientSetupEvent event){
	
	}
	
	public static void registerDeferredRegisters(IEventBus modEventBus){
		Register.BLOCKS.register(modEventBus);
		Register.ITEMS.register(modEventBus);
		
		Register.MENUS.register(modEventBus);
		Register.BLOCK_ENTITIES.register(modEventBus);
		Register.ENTITIES.register(modEventBus);
		Register.RECIPES.register(modEventBus);
		Register.SOUNDS.register(modEventBus);
	}
	
	public static void registerCreativeTabs(BuildCreativeModeTabContentsEvent event){
		if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
			event.accept(BLOCK_TIN);
			event.accept(BLOCK_MYTHRIL);
			event.accept(BLOCK_GILIUM);
			event.accept(BLOCK_BRONZE);
			event.accept(BLOCK_ORICHALCUM);
			event.accept(BLOCK_ADAMANTIUM);
			event.accept(BLOCK_AURORITE);
		}
		if(event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS){
		
		}
		if(event.getTabKey() == CreativeModeTabs.COMBAT){
			event.accept(ARMOR_BOOTS_MYTHRIL);
			event.accept(ARMOR_BOOTS_GILIUM);
			event.accept(ARMOR_BOOTS_BRONZE);
			event.accept(ARMOR_BOOTS_ORICHALCUM);
			event.accept(ARMOR_BOOTS_ADAMANTIUM);
			event.accept(ARMOR_BOOTS_AURORITE);
			event.accept(ARMOR_CHESTPLATE_MYTHRIL);
			event.accept(ARMOR_CHESTPLATE_GILIUM);
			event.accept(ARMOR_CHESTPLATE_BRONZE);
			event.accept(ARMOR_CHESTPLATE_ORICHALCUM);
			event.accept(ARMOR_CHESTPLATE_ADAMANTIUM);
			event.accept(ARMOR_CHESTPLATE_AURORITE);
			event.accept(ARMOR_LEGGINGS_MYTHRIL);
			event.accept(ARMOR_LEGGINGS_GILIUM);
			event.accept(ARMOR_LEGGINGS_BRONZE);
			event.accept(ARMOR_LEGGINGS_ORICHALCUM);
			event.accept(ARMOR_LEGGINGS_ADAMANTIUM);
			event.accept(ARMOR_LEGGINGS_AURORITE);
			event.accept(ARMOR_HELMET_MYTHRIL);
			event.accept(ARMOR_HELMET_GILIUM);
			event.accept(ARMOR_HELMET_BRONZE);
			event.accept(ARMOR_HELMET_ORICHALCUM);
			event.accept(ARMOR_HELMET_ADAMANTIUM);
			event.accept(ARMOR_HELMET_AURORITE);
			event.accept(TOOL_SWORD_MYTHRIL);
			event.accept(TOOL_SWORD_GILIUM);
			event.accept(TOOL_SWORD_BRONZE);
			event.accept(TOOL_SWORD_ORICHALCUM);
			event.accept(TOOL_SWORD_ADAMANTIUM);
			event.accept(TOOL_SWORD_AURORITE);
		}
		if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS){
			event.accept(FOOD_COFFEE);
			event.accept(FOOD_VICUGNA_RAW);
			event.accept(FOOD_VICUGNA_COOKED);
			event.accept(LIQUOR_COFFEE);
			event.accept(LIQUOR_SALGAM);
			event.accept(LIQUOR_WHISKY);
			event.accept(LIQUOR_VODKA);
			event.accept(LIQUOR_RUM);
		}
		if(event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS){
			event.accept(MACHINA_FOUNDRY);
			event.accept(MACHINA_DISTILLERY);
			event.accept(MACHINA_ANCHOR);
			// event.accept(MACHINA_ROPE);
		}
		if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
			event.accept(STUFF_HEMP);
			event.accept(STUFF_ROPE);
			event.accept(STUFF_TIN_NUGGET);
			event.accept(STUFF_TIN_INGOT);
			event.accept(STUFF_MYTHRIL_NUGGET);
			event.accept(STUFF_MYTHRIL_INGOT);
			event.accept(STUFF_GILIUM_NUGGET);
			event.accept(STUFF_GILIUM_INGOT);
			event.accept(STUFF_BRONZE_INGOT);
			event.accept(STUFF_ORICHALCUM_INGOT);
			event.accept(STUFF_ADAMANTIUM_INGOT);
			event.accept(STUFF_AURORITE);
			event.accept(STUFF_SLAG);
			event.accept(SEED_COFFEE);
			event.accept(SEED_HEMP);
		}
		if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS){
			event.accept(ORE_TIN_BASE);
			event.accept(ORE_TIN_DEEP);
			event.accept(ORE_TIN_RAW);
			event.accept(ORE_MYTHRIL_BASE);
			event.accept(ORE_MYTHRIL_DEEP);
			event.accept(ORE_MYTHRIL_RAW);
			event.accept(ORE_GILIUM_HELL);
			event.accept(ORE_GILIUM_RAW);
			event.accept(ORE_AURORITE_BASE);
			event.accept(ORE_AURORITE_DEEP);
			// event.accept(CROP_COFFEE);
			// event.accept(CROP_HEMP);
		}
		if(event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS){
		
		}
		if(event.getTabKey() == CreativeModeTabs.SPAWN_EGGS){
			event.accept(SPAWNEGG_ALPACA);
		}
		if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES){
			event.accept(TOOL_AXE_MYTHRIL);
			event.accept(TOOL_AXE_GILIUM);
			event.accept(TOOL_AXE_BRONZE);
			event.accept(TOOL_AXE_ORICHALCUM);
			event.accept(TOOL_AXE_ADAMANTIUM);
			event.accept(TOOL_AXE_AURORITE);
			event.accept(TOOL_PICKAXE_MYTHRIL);
			event.accept(TOOL_PICKAXE_GILIUM);
			event.accept(TOOL_PICKAXE_BRONZE);
			event.accept(TOOL_PICKAXE_ORICHALCUM);
			event.accept(TOOL_PICKAXE_ADAMANTIUM);
			event.accept(TOOL_PICKAXE_AURORITE);
			event.accept(TOOL_SHOVEL_MYTHRIL);
			event.accept(TOOL_SHOVEL_GILIUM);
			event.accept(TOOL_SHOVEL_BRONZE);
			event.accept(TOOL_SHOVEL_ORICHALCUM);
			event.accept(TOOL_SHOVEL_ADAMANTIUM);
			event.accept(TOOL_SHOVEL_AURORITE);
			event.accept(TOOL_HOE_MYTHRIL);
			event.accept(TOOL_HOE_GILIUM);
			event.accept(TOOL_HOE_BRONZE);
			event.accept(TOOL_HOE_ORICHALCUM);
			event.accept(TOOL_HOE_ADAMANTIUM);
			event.accept(TOOL_HOE_AURORITE);
			event.accept(TOOL_DYNAMITE);
			event.accept(BOOK_ALLOY);
			event.accept(BOOK_PLANT);
			event.accept(BOOK_DRINK);
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public static void generateTradeData(){
		SupportTrades.addTradeToProfession(VillagerProfession.ARMORER, 1, new VillagerTrades.ItemListing[]{
				// EMPTY
		});
		
		SupportTrades.addTradeToProfession(VillagerProfession.BUTCHER, 1, new VillagerTrades.ItemListing[]{
				new SupportTrades.ItemsForGems(FOOD_VICUGNA_COOKED.get(), 1, 2, 16, 5, 0.05f),
				new SupportTrades.GemsForItems(FOOD_VICUGNA_RAW.get(), 7, 16, 20, 0.05f)
		});
		
		SupportTrades.addTradeToProfession(VillagerProfession.FARMER, 1, new VillagerTrades.ItemListing[]{
				new SupportTrades.ItemsForGems(SEED_HEMP.get(), 1, 4, 16, 2, 0.05f)
		});
		
		SupportTrades.addTradeToProfession(VillagerProfession.TOOLSMITH, 1, new VillagerTrades.ItemListing[]{
				// EMPTY
		});
		
		SupportTrades.addTradeToProfession(VillagerProfession.WEAPONSMITH, 1, new VillagerTrades.ItemListing[]{
				// EMPTY
		});
	}
	
	public static void registerJigsaws(MinecraftServer server){
		Registry<StructureTemplatePool> templatePoolRegistry = server.registryAccess().registry(Registries.TEMPLATE_POOL).orElseThrow();
		Registry<StructureProcessorList> processorListRegistry = server.registryAccess().registry(Registries.PROCESSOR_LIST).orElseThrow();
		
		SupportStructure.addBuildingToPool(templatePoolRegistry, processorListRegistry, ResourceLocation.fromNamespaceAndPath("minecraft", "village/plains/houses"), "acecraft:village/plains_farm_coffee", 1);
		SupportStructure.addBuildingToPool(templatePoolRegistry, processorListRegistry, ResourceLocation.fromNamespaceAndPath("minecraft", "village/snowy/houses"), "acecraft:village/snowy_farm_coffee", 1);
		SupportStructure.addBuildingToPool(templatePoolRegistry, processorListRegistry, ResourceLocation.fromNamespaceAndPath("minecraft", "village/savanna/houses"), "acecraft:village/savanna_farm_coffee", 1);
		SupportStructure.addBuildingToPool(templatePoolRegistry, processorListRegistry, ResourceLocation.fromNamespaceAndPath("minecraft", "village/desert/houses"), "acecraft:village/desert_farm_coffee", 1);
		SupportStructure.addBuildingToPool(templatePoolRegistry, processorListRegistry, ResourceLocation.fromNamespaceAndPath("minecraft", "village/taiga/houses"), "acecraft:village/taiga_farm_coffee", 1);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static DeferredBlock<Block> registerBlock(String name, Supplier<? extends Block> block){
		DeferredBlock<Block> supply = BLOCKS.register(name, block);
		ITEMS.register(name, () -> new BlockItem(supply.get(), new Item.Properties()));
		return supply;
	}
	
	private static DeferredBlock<Block> registerBlockNoItem(String name, Supplier<? extends Block> block){
		DeferredBlock<Block> supply = BLOCKS.register(name, block);
		// ITEMS.register(name, () -> new BlockItem(supply.get(), new Item.Properties()));
		return supply;
	}
	
	// private static DeferredBlock<Block> registerBlock(String name, Supplier<? extends Block> block){
	// 	return registerBlock(name, block, null);
	// }
	
	private static DeferredItem<Item> registerItem(String name, Supplier<? extends Item> item){
		return ITEMS.register(name, item);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
