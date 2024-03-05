package mod.acecraft;

import mod.acecraft.client.menu.MenuDistillery;
import mod.acecraft.client.menu.MenuFoundry;
import mod.acecraft.client.screen.ScreenDistillery;
import mod.acecraft.client.screen.ScreenFoundry;
import mod.acecraft.common.block.*;
import mod.acecraft.common.block.entity.*;
import mod.acecraft.common.entity.*;
import mod.acecraft.common.item.*;
import mod.acecraft.util.MaterialArmor;
import mod.acecraft.util.MaterialTool;
import mod.acecraft.util.recipe.RecipeDistillery;
import mod.lucky77.block.BlockBlock;
import mod.lucky77.block.BlockCropDouble;
import mod.lucky77.block.BlockCropSingle;
import mod.lucky77.block.BlockOre;
import mod.lucky77.item.ItemFood;
import mod.lucky77.item.ItemItem;
import mod.lucky77.item.ItemSeed;
import mod.lucky77.register.RegisterMod;
import mod.lucky77.register.RegisterSeed;
import mod.lucky77.util.system.SystemStructurePoolAdditions;
import mod.lucky77.util.system.SystemTrades;
import net.minecraft.client.gui.screens.MenuScreens;
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
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static mod.acecraft.AceCraft.MODID;
import static net.minecraft.world.entity.MobCategory.CREATURE;
import static net.minecraft.world.level.block.Blocks.AMETHYST_CLUSTER;

@SuppressWarnings("unused")
public class Register {
	
	// Create Deferred Registers to hold whatever is written in <...> which will all be registered under the MODID namespace
	private static final DeferredRegister<Block>               BLOCKS         = DeferredRegister.create(ForgeRegistries.BLOCKS,             MODID);
	private static final DeferredRegister<Item>                ITEMS          = DeferredRegister.create(ForgeRegistries.ITEMS,              MODID);
	private static final DeferredRegister<CreativeModeTab>     CREATIVE_TABS  = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,       MODID);
	private static final DeferredRegister<MenuType<?>>         MENUS          = DeferredRegister.create(ForgeRegistries.MENU_TYPES,         MODID);
	private static final DeferredRegister<BlockEntityType<?>>  BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MODID);
	private static final DeferredRegister<SoundEvent>          SOUNDS         = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS,       MODID);
	private static final DeferredRegister<EntityType<?>>       ENTITIES       = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES,       MODID);
	private static final DeferredRegister<RecipeSerializer<?>> RECIPIES       = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, MODID);
	
	
	
	
	
	// ---------- ---------- ---------- ----------  BLOCKS / ITEMS  ---------- ---------- ---------- ---------- //
	
	// ----- Basic Blocks ----- //
	public static final RegistryObject<Block> BLOCK_MYTHRIL       = registerBlock("block_mythril",       () -> new BlockBlock(Blocks.IRON_BLOCK   ));
	public static final RegistryObject<Block> BLOCK_GILIUM        = registerBlock("block_gilium",        () -> new BlockBlock(Blocks.IRON_BLOCK   ));
	public static final RegistryObject<Block> BLOCK_TIN           = registerBlock("block_tin",           () -> new BlockBlock(Blocks.IRON_BLOCK   ));
	public static final RegistryObject<Block> BLOCK_BRONZE        = registerBlock("block_bronze",        () -> new BlockBlock(Blocks.IRON_BLOCK   ));
	public static final RegistryObject<Block> BLOCK_ORICHALCUM    = registerBlock("block_orichalcum",    () -> new BlockBlock(Blocks.IRON_BLOCK   ));
	public static final RegistryObject<Block> BLOCK_ADAMANTIUM    = registerBlock("block_adamantium",    () -> new BlockBlock(Blocks.IRON_BLOCK   ));
	public static final RegistryObject<Block> BLOCK_RUBY          = registerBlock("block_ruby",          () -> new BlockBlock(Blocks.DIAMOND_BLOCK));
	public static final RegistryObject<Block> BLOCK_AURORITE      = registerBlock("block_aurorite",      () -> new BlockBlock(Blocks.DIAMOND_BLOCK));
	public static final RegistryObject<Block> BLOCK_TOPAZ         = registerBlock("block_topaz",         () -> new BlockTopaz(                BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).strength(1.5F                            ).sound(SoundType.AMETHYST        ).requiresCorrectToolForDrops()));
	public static final RegistryObject<Block> BLOCK_TOPAZ_BUDDING = registerBlock("block_topaz_budding", () -> new BlockTopazBudding(         BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).randomTicks().strength(1.5F              ).sound(SoundType.AMETHYST        ).requiresCorrectToolForDrops().pushReaction(PushReaction.DESTROY)));
	public static final RegistryObject<Block> BLOCK_TOPAZ_CLUSTER = registerBlock("block_topaz_cluster", () -> new BlockTopazCluster(   7, 3, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).randomTicks().forceSolidOn().noOcclusion().sound(SoundType.AMETHYST_CLUSTER).strength(1.5F).lightLevel((p_152632_) -> {		return 5;	}).pushReaction(PushReaction.DESTROY)));
	public static final RegistryObject<Block> BLOCK_TOPAZ_BUD_3   = registerBlock("block_topaz_bud_3",   () -> new AmethystClusterBlock(5, 3, BlockBehaviour.Properties.copy(AMETHYST_CLUSTER).sound(SoundType.MEDIUM_AMETHYST_BUD).forceSolidOn().lightLevel((state) -> {		return 4;	}).pushReaction(PushReaction.DESTROY)));
	public static final RegistryObject<Block> BLOCK_TOPAZ_BUD_2   = registerBlock("block_topaz_bud_2",   () -> new AmethystClusterBlock(4, 3, BlockBehaviour.Properties.copy(AMETHYST_CLUSTER).sound(SoundType.LARGE_AMETHYST_BUD ).forceSolidOn().lightLevel((state) -> {		return 2;	}).pushReaction(PushReaction.DESTROY)));
	public static final RegistryObject<Block> BLOCK_TOPAZ_BUD_1   = registerBlock("block_topaz_bud_1",   () -> new AmethystClusterBlock(3, 4, BlockBehaviour.Properties.copy(AMETHYST_CLUSTER).sound(SoundType.SMALL_AMETHYST_BUD ).forceSolidOn().lightLevel((state) -> {		return 1;	}).pushReaction(PushReaction.DESTROY)));
	
	// ----- Ore ----- //
	public static final RegistryObject<Block> ORE_MYTHRIL_BASE  = registerBlock("ore_mythril_base",  () -> new BlockOre(MapColor.STONE,     3.0f, 3f, SoundType.STONE,      0, 2));
	public static final RegistryObject<Block> ORE_MYTHRIL_DEEP  = registerBlock("ore_mythril_deep",  () -> new BlockOre(MapColor.DEEPSLATE, 4.5f, 3f, SoundType.DEEPSLATE,  0, 2));
	public static final RegistryObject<Block> ORE_TIN_BASE      = registerBlock("ore_tin_base",      () -> new BlockOre(MapColor.STONE,     3.0f, 3f, SoundType.STONE,      0, 2));
	public static final RegistryObject<Block> ORE_TIN_DEEP      = registerBlock("ore_tin_deep",      () -> new BlockOre(MapColor.DEEPSLATE, 4.5f, 3f, SoundType.DEEPSLATE,  0, 2));
	public static final RegistryObject<Block> ORE_RUBY_BASE     = registerBlock("ore_ruby_base",     () -> new BlockOre(MapColor.STONE,     3.0f, 3f, SoundType.STONE,      3, 7));
	public static final RegistryObject<Block> ORE_RUBY_DEEP     = registerBlock("ore_ruby_deep",     () -> new BlockOre(MapColor.DEEPSLATE, 4.5f, 3f, SoundType.DEEPSLATE,  3, 7));
	public static final RegistryObject<Block> ORE_AURORITE_BASE = registerBlock("ore_aurorite_base", () -> new BlockOre(MapColor.STONE,     3.0f, 3f, SoundType.STONE,      3, 7));
	public static final RegistryObject<Block> ORE_AURORITE_DEEP = registerBlock("ore_aurorite_deep", () -> new BlockOre(MapColor.DEEPSLATE, 4.5f, 3f, SoundType.DEEPSLATE,  3, 7));
	public static final RegistryObject<Block> ORE_GILIUM        = registerBlock("ore_gilium",        () -> new BlockOre(MapColor.NETHER,    3.0f, 3f, SoundType.NETHER_ORE, 2, 5));
	
	// ----- Basic Items ----- //
	public static final RegistryObject<Item> STUFF_COFFEE     = registerItem("stuff_coffee",     ItemItem::new);
	public static final RegistryObject<Item> STUFF_RICE       = registerItem("stuff_rice",       ItemItem::new);
	public static final RegistryObject<Item> STUFF_HEMP       = registerItem("stuff_hemp",       ItemItem::new);
	public static final RegistryObject<Item> STUFF_ROPE       = registerItem("stuff_rope",       ItemItem::new);
	public static final RegistryObject<Item> STUFF_SLAG       = registerItem("stuff_slag",       ItemItem::new);
	public static final RegistryObject<Item> STUFF_RUBY       = registerItem("stuff_ruby",       ItemItem::new);
	public static final RegistryObject<Item> STUFF_AURORITE   = registerItem("stuff_aurorite",   ItemItem::new);
	public static final RegistryObject<Item> STUFF_TOPAZ      = registerItem("stuff_topaz",      ItemItem::new);
	public static final RegistryObject<Item> STUFF_MYTHRIL    = registerItem("stuff_mythril",    ItemItem::new);
	public static final RegistryObject<Item> STUFF_GILIUM     = registerItem("stuff_gilium",     ItemItem::new);
	public static final RegistryObject<Item> STUFF_TIN        = registerItem("stuff_tin",        ItemItem::new);
	public static final RegistryObject<Item> INGOT_MYTHRIL    = registerItem("ingot_mythril",    ItemItem::new);
	public static final RegistryObject<Item> INGOT_GILIUM     = registerItem("ingot_gilium",     ItemItem::new);
	public static final RegistryObject<Item> INGOT_TIN        = registerItem("ingot_tin",        ItemItem::new);
	public static final RegistryObject<Item> INGOT_BRONZE     = registerItem("ingot_bronze",     ItemItem::new);
	public static final RegistryObject<Item> INGOT_ORICHALCUM = registerItem("ingot_orichalcum", ItemItem::new);
	public static final RegistryObject<Item> INGOT_ADAMANTIUM = registerItem("ingot_adamantium", ItemItem::new);
	
	// ----- Food ----- //
	public static final RegistryObject<Item> FOOD_ONIGIRI        = registerItem("food_onigiri",        () -> new ItemFood(2, 2f, false));
	public static final RegistryObject<Item> FOOD_NIGIRI         = registerItem("food_nigiri",         () -> new ItemFood(3, 3f, false));
	public static final RegistryObject<Item> FOOD_SUSHI          = registerItem("food_sushi",          () -> new ItemFood(4, 4f, false));
	public static final RegistryObject<Item> FOOD_VICUGNA_RAW    = registerItem("food_vicugna_raw",    () -> new ItemFood(1, 1f,  true));
	public static final RegistryObject<Item> FOOD_VICUGNA_COOKED = registerItem("food_vicugna_cooked", () -> new ItemFood(1, 1f,  true));
	
	// ----- Liquor ----- //
	public static final RegistryObject<Item> LIQUOR_COFFEE = registerItem("liquor_coffee", () -> new ItemLiquor(MobEffects.DIG_SPEED, 1.0f, MobEffects.HUNGER, 0.8f)); // Coffee Beans
	public static final RegistryObject<Item> LIQUOR_SALGAM = registerItem("liquor_salgam", () -> new ItemLiquor(MobEffects.DIG_SPEED, 1.0f, MobEffects.HUNGER, 0.8f)); // Beet Roots
	public static final RegistryObject<Item> LIQUOR_WHISKY = registerItem("liquor_whisky", () -> new ItemLiquor(MobEffects.DIG_SPEED, 1.0f, MobEffects.HUNGER, 0.8f)); // Wheat
	public static final RegistryObject<Item> LIQUOR_VODKA  = registerItem("liquor_vodka",  () -> new ItemLiquor(MobEffects.DIG_SPEED, 1.0f, MobEffects.HUNGER, 0.8f)); // Potatoes
	public static final RegistryObject<Item> LIQUOR_SAKE   = registerItem("liquor_sake",   () -> new ItemLiquor(MobEffects.DIG_SPEED, 1.0f, MobEffects.HUNGER, 0.8f)); // Rice
	public static final RegistryObject<Item> LIQUOR_RUM    = registerItem("liquor_rum",    () -> new ItemLiquor(MobEffects.DIG_SPEED, 1.0f, MobEffects.HUNGER, 0.8f)); // Sugar Canes
	
	// ----- Crop ----- //
	public static final RegistryObject<Block> CROP_COFFEE = registerBlock("crop_coffee", () -> new BlockCropSingle(Blocks.WHEAT, "coffee", 5), false);
	public static final RegistryObject<Block> CROP_RICE   = registerBlock("crop_rice",   () -> new BlockCropSingle(Blocks.WHEAT, "rice"     ), false);
	public static final RegistryObject<Block> CROP_HEMP   = registerBlock("crop_hemp",   () -> new BlockCropDouble(Blocks.WHEAT, "hemp"     ), false);
	
	// ----- Seeds ----- //
	public static final RegistryObject<Item> SEED_COFFEE = registerItem("seed_coffee", () -> new ItemSeed("coffee"));
	public static final RegistryObject<Item> SEED_RICE   = registerItem("seed_rice",   () -> new ItemSeed("rice"  ));
	public static final RegistryObject<Item> SEED_HEMP   = registerItem("seed_hemp",   () -> new ItemSeed("hemp"  ));
	
	// ----- Machina ----- //
	public static final RegistryObject<Block> MACHINA_FOUNDRY      = registerBlock("machina_foundry",      BlockFoundry::new     );
	public static final RegistryObject<Block> MACHINA_DISTILLERY   = registerBlock("machina_distillery",   BlockDistillery::new  );
	public static final RegistryObject<Block> MACHINA_ANCHOR       = registerBlock("machina_anchor",       BlockAnchor::new      );
	public static final RegistryObject<Block> MACHINA_ROPE         = registerBlock("machina_rope",         BlockRope::new,  false);
	
	// ----- Armor - Boots ----- //
	public static final RegistryObject<Item> ARMOR_BOOTS_GILIUM     = registerItem("armor_boots_gilium",     () -> new ItemArmor(     MaterialArmor.GILIUM,     ArmorItem.Type.BOOTS));
	public static final RegistryObject<Item> ARMOR_BOOTS_ADAMANTIUM = registerItem("armor_boots_adamantium", () -> new ItemArmor(     MaterialArmor.ADAMANTIUM, ArmorItem.Type.BOOTS));
	public static final RegistryObject<Item> ARMOR_BOOTS_MYTHRIL    = registerItem("armor_boots_mythril",    () -> new ItemArmor(     MaterialArmor.MYTHRIL,    ArmorItem.Type.BOOTS));
	public static final RegistryObject<Item> ARMOR_BOOTS_ORICHALCUM = registerItem("armor_boots_orichalcum", () -> new ItemArmor(     MaterialArmor.ORICHALCUM, ArmorItem.Type.BOOTS));
	public static final RegistryObject<Item> ARMOR_BOOTS_BRONZE     = registerItem("armor_boots_bronze",     () -> new ItemArmor(     MaterialArmor.BRONZE,     ArmorItem.Type.BOOTS));
	public static final RegistryObject<Item> ARMOR_BOOTS_AURORITE   = registerItem("armor_boots_aurorite",   () -> new ItemArmorColor(MaterialArmor.AURORITE,   ArmorItem.Type.BOOTS));
	
	// ----- Armor - Chestplate ----- //
	public static final RegistryObject<Item> ARMOR_PLATE_GILIUM     = registerItem("armor_plate_gilium",     () -> new ItemArmor(     MaterialArmor.GILIUM,     ArmorItem.Type.CHESTPLATE));
	public static final RegistryObject<Item> ARMOR_PLATE_ADAMANTIUM = registerItem("armor_plate_adamantium", () -> new ItemArmor(     MaterialArmor.ADAMANTIUM, ArmorItem.Type.CHESTPLATE));
	public static final RegistryObject<Item> ARMOR_PLATE_MYTHRIL    = registerItem("armor_plate_mythril",    () -> new ItemArmor(     MaterialArmor.MYTHRIL,    ArmorItem.Type.CHESTPLATE));
	public static final RegistryObject<Item> ARMOR_PLATE_ORICHALCUM = registerItem("armor_plate_orichalcum", () -> new ItemArmor(     MaterialArmor.ORICHALCUM, ArmorItem.Type.CHESTPLATE));
	public static final RegistryObject<Item> ARMOR_PLATE_BRONZE     = registerItem("armor_plate_bronze",     () -> new ItemArmor(     MaterialArmor.BRONZE,     ArmorItem.Type.CHESTPLATE));
	public static final RegistryObject<Item> ARMOR_PLATE_AURORITE   = registerItem("armor_plate_aurorite",   () -> new ItemArmorColor(MaterialArmor.AURORITE,   ArmorItem.Type.CHESTPLATE));
	
	// ----- Armor - Leggings ----- //
	public static final RegistryObject<Item> ARMOR_LEGGINGS_GILIUM     = registerItem("armor_leggings_gilium",     () -> new ItemArmor(     MaterialArmor.GILIUM,     ArmorItem.Type.LEGGINGS));
	public static final RegistryObject<Item> ARMOR_LEGGINGS_ADAMANTIUM = registerItem("armor_leggings_adamantium", () -> new ItemArmor(     MaterialArmor.ADAMANTIUM, ArmorItem.Type.LEGGINGS));
	public static final RegistryObject<Item> ARMOR_LEGGINGS_MYTHRIL    = registerItem("armor_leggings_mythril",    () -> new ItemArmor(     MaterialArmor.MYTHRIL,    ArmorItem.Type.LEGGINGS));
	public static final RegistryObject<Item> ARMOR_LEGGINGS_ORICHALCUM = registerItem("armor_leggings_orichalcum", () -> new ItemArmor(     MaterialArmor.ORICHALCUM, ArmorItem.Type.LEGGINGS));
	public static final RegistryObject<Item> ARMOR_LEGGINGS_BRONZE     = registerItem("armor_leggings_bronze",     () -> new ItemArmor(     MaterialArmor.BRONZE,     ArmorItem.Type.LEGGINGS));
	public static final RegistryObject<Item> ARMOR_LEGGINGS_AURORITE   = registerItem("armor_leggings_aurorite",   () -> new ItemArmorColor(MaterialArmor.AURORITE,   ArmorItem.Type.LEGGINGS));
	
	// ----- Armor - Helmet ----- //
	public static final RegistryObject<Item> ARMOR_HELMET_GILIUM     = registerItem("armor_helmet_gilium",     () -> new ItemArmor(     MaterialArmor.GILIUM,     ArmorItem.Type.HELMET));
	public static final RegistryObject<Item> ARMOR_HELMET_ADAMANTIUM = registerItem("armor_helmet_adamantium", () -> new ItemArmor(     MaterialArmor.ADAMANTIUM, ArmorItem.Type.HELMET));
	public static final RegistryObject<Item> ARMOR_HELMET_MYTHRIL    = registerItem("armor_helmet_mythril",    () -> new ItemArmor(     MaterialArmor.MYTHRIL,    ArmorItem.Type.HELMET));
	public static final RegistryObject<Item> ARMOR_HELMET_ORICHALCUM = registerItem("armor_helmet_orichalcum", () -> new ItemArmor(     MaterialArmor.ORICHALCUM, ArmorItem.Type.HELMET));
	public static final RegistryObject<Item> ARMOR_HELMET_BRONZE     = registerItem("armor_helmet_bronze",     () -> new ItemArmor(     MaterialArmor.BRONZE,     ArmorItem.Type.HELMET));
	public static final RegistryObject<Item> ARMOR_HELMET_AURORITE   = registerItem("armor_helmet_aurorite",   () -> new ItemArmorColor(MaterialArmor.AURORITE,   ArmorItem.Type.HELMET));
	
	// ----- Tools - Sword ----- //
	public static final RegistryObject<Item> TOOL_SWORD_GILIUM     = registerItem("tool_sword_gilium",     () -> new ToolSword(MaterialTool.GILIUM,     2, -1.0f));
	public static final RegistryObject<Item> TOOL_SWORD_ADAMANTIUM = registerItem("tool_sword_adamantium", () -> new ToolSword(MaterialTool.ADAMANTIUM, 3, -1.0f));
	public static final RegistryObject<Item> TOOL_SWORD_MYTHRIL    = registerItem("tool_sword_mythril",    () -> new ToolSword(MaterialTool.MYTHRIL,    2, -1.0f));
	public static final RegistryObject<Item> TOOL_SWORD_ORICHALCUM = registerItem("tool_sword_orichalcum", () -> new ToolSword(MaterialTool.ORICHALCUM, 3, -1.0f));
	public static final RegistryObject<Item> TOOL_SWORD_BRONZE     = registerItem("tool_sword_bronze",     () -> new ToolSword(MaterialTool.BRONZE,     2, -1.0f));
	public static final RegistryObject<Item> TOOL_SWORD_AURORITE   = registerItem("tool_sword_aurorite",   () -> new ToolSword(MaterialTool.AURORITE,   3, -1.0f));
	
	// ----- Tools - Axe ----- //
	public static final RegistryObject<Item> TOOL_AXE_GILIUM     = registerItem("tool_axe_gilium",     () -> new ToolAxe(MaterialTool.GILIUM,     2, -1.0f));
	public static final RegistryObject<Item> TOOL_AXE_ADAMANTIUM = registerItem("tool_axe_adamantium", () -> new ToolAxe(MaterialTool.ADAMANTIUM, 3, -1.0f));
	public static final RegistryObject<Item> TOOL_AXE_MYTHRIL    = registerItem("tool_axe_mythril",    () -> new ToolAxe(MaterialTool.MYTHRIL,    2, -1.0f));
	public static final RegistryObject<Item> TOOL_AXE_ORICHALCUM = registerItem("tool_axe_orichalcum", () -> new ToolAxe(MaterialTool.ORICHALCUM, 3, -1.0f));
	public static final RegistryObject<Item> TOOL_AXE_BRONZE     = registerItem("tool_axe_bronze",     () -> new ToolAxe(MaterialTool.BRONZE,     2, -1.0f));
	public static final RegistryObject<Item> TOOL_AXE_AURORITE   = registerItem("tool_axe_aurorite",   () -> new ToolAxe(MaterialTool.AURORITE,   3, -1.0f));
	
	// ----- Tools - Pickaxe ----- //
	public static final RegistryObject<Item> TOOL_PICKAXE_GILIUM     = registerItem("tool_pickaxe_gilium",     () -> new ToolPickaxe(MaterialTool.GILIUM,     2, -1.0f));
	public static final RegistryObject<Item> TOOL_PICKAXE_ADAMANTIUM = registerItem("tool_pickaxe_adamantium", () -> new ToolPickaxe(MaterialTool.ADAMANTIUM, 3, -1.0f));
	public static final RegistryObject<Item> TOOL_PICKAXE_MYTHRIL    = registerItem("tool_pickaxe_mythril",    () -> new ToolPickaxe(MaterialTool.MYTHRIL,    2, -1.0f));
	public static final RegistryObject<Item> TOOL_PICKAXE_ORICHALCUM = registerItem("tool_pickaxe_orichalcum", () -> new ToolPickaxe(MaterialTool.ORICHALCUM, 3, -1.0f));
	public static final RegistryObject<Item> TOOL_PICKAXE_BRONZE     = registerItem("tool_pickaxe_bronze",     () -> new ToolPickaxe(MaterialTool.BRONZE,     2, -1.0f));
	public static final RegistryObject<Item> TOOL_PICKAXE_AURORITE   = registerItem("tool_pickaxe_aurorite",   () -> new ToolPickaxe(MaterialTool.AURORITE,   3, -1.0f));
	
	// ----- Tools - Shovel ----- //
	public static final RegistryObject<Item> TOOL_SHOVEL_GILIUM     = registerItem("tool_shovel_gilium",     () -> new ToolShovel(MaterialTool.GILIUM,     2, -1.0f));
	public static final RegistryObject<Item> TOOL_SHOVEL_ADAMANTIUM = registerItem("tool_shovel_adamantium", () -> new ToolShovel(MaterialTool.ADAMANTIUM, 3, -1.0f));
	public static final RegistryObject<Item> TOOL_SHOVEL_MYTHRIL    = registerItem("tool_shovel_mythril",    () -> new ToolShovel(MaterialTool.MYTHRIL,    2, -1.0f));
	public static final RegistryObject<Item> TOOL_SHOVEL_ORICHALCUM = registerItem("tool_shovel_orichalcum", () -> new ToolShovel(MaterialTool.ORICHALCUM, 3, -1.0f));
	public static final RegistryObject<Item> TOOL_SHOVEL_BRONZE     = registerItem("tool_shovel_bronze",     () -> new ToolShovel(MaterialTool.BRONZE,     2, -1.0f));
	public static final RegistryObject<Item> TOOL_SHOVEL_AURORITE   = registerItem("tool_shovel_aurorite",   () -> new ToolShovel(MaterialTool.AURORITE,   3, -1.0f));
	
	// ----- Tools - Hoe ----- //
	public static final RegistryObject<Item> TOOL_HOE_GILIUM     = registerItem("tool_hoe_gilium",     () -> new ToolHoe(MaterialTool.GILIUM,     2, -1.0f));
	public static final RegistryObject<Item> TOOL_HOE_ADAMANTIUM = registerItem("tool_hoe_adamantium", () -> new ToolHoe(MaterialTool.ADAMANTIUM, 3, -1.0f));
	public static final RegistryObject<Item> TOOL_HOE_MYTHRIL    = registerItem("tool_hoe_mythril",    () -> new ToolHoe(MaterialTool.MYTHRIL,    2, -1.0f));
	public static final RegistryObject<Item> TOOL_HOE_ORICHALCUM = registerItem("tool_hoe_orichalcum", () -> new ToolHoe(MaterialTool.ORICHALCUM, 3, -1.0f));
	public static final RegistryObject<Item> TOOL_HOE_BRONZE     = registerItem("tool_hoe_bronze",     () -> new ToolHoe(MaterialTool.BRONZE,     2, -1.0f));
	public static final RegistryObject<Item> TOOL_HOE_AURORITE   = registerItem("tool_hoe_aurorite",   () -> new ToolHoe(MaterialTool.AURORITE,   3, -1.0f));
	
	// ----- Tools - Other ----- //
	public static final RegistryObject<Item> TOOL_DYNAMITE   = registerItem("tool_dynamite",   ToolDynamite::new);
	
	// ----- Books ----- //
	public static final RegistryObject<Item> BOOK_ALLOY     = registerItem("book_alloy", () -> new ItemBookAlloy(0, 1));
	public static final RegistryObject<Item> BOOK_PLANT     = registerItem("book_plant", () -> new ItemBookAlloy(0, 2));
	public static final RegistryObject<Item> BOOK_DRINK     = registerItem("book_drink", () -> new ItemBookAlloy(0, 3));
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SOUNDS  ---------- ---------- ---------- ---------- //
	
	// public static final RegistryObject<SoundEvent> SOUND_ALPACA_AMBIENT      = SOUNDS.register("acecraft.alpaca.ambient",    () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(MODID, "acecraft.alpaca.ambient"   )));
	// public static final RegistryObject<SoundEvent> SOUND_ALPACA_HURT         = SOUNDS.register("acecraft.alpaca.hurt",       () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(MODID, "acecraft.alpaca.hurt"      )));
	// public static final RegistryObject<SoundEvent> SOUND_ALPACA_DEATH        = SOUNDS.register("acecraft.alpaca.death",      () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(MODID, "acecraft.alpaca.death"     )));
	
	
	
	
	
	// ---------- ---------- ---------- ----------  BLOCK ENTITES  ---------- ---------- ---------- ---------- //
	
	public static final RegistryObject<BlockEntityType<?>> TILE_FOUNDRY        = BLOCK_ENTITIES.register("foundry",        () -> BlockEntityType.Builder.of(BlockEntityFoundry::new,       MACHINA_FOUNDRY.get(     )).build(null));
	public static final RegistryObject<BlockEntityType<?>> TILE_DISTILLERY     = BLOCK_ENTITIES.register("distillery",     () -> BlockEntityType.Builder.of(BlockEntityDistillery::new,    MACHINA_DISTILLERY.get(  )).build(null));
	
	
	
	
	
	// ---------- ---------- ---------- ----------  MENUS  ---------- ---------- ---------- ---------- //
	
	public static final RegistryObject<MenuType<MenuFoundry>>       MENU_FOUNDRY         = MENUS.register("foundry",         () -> IForgeMenuType.create(MenuFoundry::new));
	public static final RegistryObject<MenuType<MenuDistillery>>    MENU_DISTILLERY      = MENUS.register("distillery",      () -> IForgeMenuType.create(MenuDistillery::new));
	
	
	
	
	
	
	// ---------- ---------- ---------- ----------  LOOT TABLES  ---------- ---------- ---------- ---------- //
	
	public static final ResourceLocation ALPACA_WHITE      = new ResourceLocation(MODID, "entities/alpaca/white");
	public static final ResourceLocation ALPACA_ORANGE     = new ResourceLocation(MODID, "entities/alpaca/orange");
	public static final ResourceLocation ALPACA_MAGENTA    = new ResourceLocation(MODID, "entities/alpaca/magenta");
	public static final ResourceLocation ALPACA_LIGHT_BLUE = new ResourceLocation(MODID, "entities/alpaca/light_blue");
	public static final ResourceLocation ALPACA_YELLOW     = new ResourceLocation(MODID, "entities/alpaca/yellow");
	public static final ResourceLocation ALPACA_LIME       = new ResourceLocation(MODID, "entities/alpaca/lime");
	public static final ResourceLocation ALPACA_PINK       = new ResourceLocation(MODID, "entities/alpaca/pink");
	public static final ResourceLocation ALPACA_GRAY       = new ResourceLocation(MODID, "entities/alpaca/gray");
	public static final ResourceLocation ALPACA_LIGHT_GRAY = new ResourceLocation(MODID, "entities/alpaca/light_gray");
	public static final ResourceLocation ALPACA_CYAN       = new ResourceLocation(MODID, "entities/alpaca/cyan");
	public static final ResourceLocation ALPACA_PURPLE     = new ResourceLocation(MODID, "entities/alpaca/purple");
	public static final ResourceLocation ALPACA_BLUE       = new ResourceLocation(MODID, "entities/alpaca/blue");
	public static final ResourceLocation ALPACA_BROWN      = new ResourceLocation(MODID, "entities/alpaca/brown");
	public static final ResourceLocation ALPACA_GREEN      = new ResourceLocation(MODID, "entities/alpaca/green");
	public static final ResourceLocation ALPACA_RED        = new ResourceLocation(MODID, "entities/alpaca/red");
	public static final ResourceLocation ALPACA_BLACK      = new ResourceLocation(MODID, "entities/alpaca/black");
	
	
	
	
	
	// ---------- ---------- ---------- ----------  ENTITES  ---------- ---------- ---------- ---------- //
	
	public static final RegistryObject<EntityType<EntityAlpaca>>   ENTITY_ALPACA   = ENTITIES.register("alpaca",  () -> EntityType.Builder.of(EntityAlpaca::new,  CREATURE).sized(0.9F, 1.3F).setTrackingRange(10).build("alpaca" ));
	public static final RegistryObject<EntityType<EntityDynamite>> ENTITY_DYNAMITE = ENTITIES.register("dynamite", () -> EntityType.Builder.<EntityDynamite>of(EntityDynamite::new, MobCategory.MISC).sized(2.5f, 2.5f).build("dynamite"));
	public static final RegistryObject<EntityType<EntitySpit>> ENTITY_SPIT     = ENTITIES.register("alpaca_spit", () -> EntityType.Builder.<EntitySpit>of(EntitySpit::new, MobCategory.MISC).sized(2.5f, 2.5f).build("alpaca_spit"));;
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SPAWN EGGS  ---------- ---------- ---------- ---------- //
	
	public static final RegistryObject<Item> SPAWNEGG_ALPACA  = registerItem("spawnegg_alpaca",  () -> new ForgeSpawnEggItem(ENTITY_ALPACA,     8214796,   9638517, new Item.Properties()));
	
	
	
	
	
	// ---------- ---------- ---------- ----------  TEXTURES  ---------- ---------- ---------- ---------- //
	
	// ...
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SETUP  ---------- ---------- ---------- ---------- //
	
	public static final RegistryObject<RecipeSerializer<RecipeDistillery  >> RECIPE_DISTILLING = RECIPIES.register("distilling", () -> RecipeDistillery.Serializer.INSTANCE);
	
	
	
	
	// ---------- ---------- ---------- ----------  SETUP  ---------- ---------- ---------- ---------- //
	
	static void setup(FMLCommonSetupEvent event){
		generateTradeData();
		
		RegisterMod.register("acecraft");
		
		RegisterSeed.AddToMap("coffee", CROP_COFFEE.get(), SEED_COFFEE.get(), STUFF_COFFEE.get());
		RegisterSeed.AddToMap("rice",   CROP_RICE.get(  ), SEED_RICE.get(  ), STUFF_RICE.get(  ));
		RegisterSeed.AddToMap("hemp",   CROP_HEMP.get(  ), SEED_HEMP.get(  ), STUFF_HEMP.get(  ));
	}
	
	@OnlyIn(Dist.CLIENT)
	static void setup(FMLClientSetupEvent event){
		event.enqueueWork(() -> {
			MenuScreens.register(MENU_FOUNDRY.get(        ), ScreenFoundry::new);
			MenuScreens.register(MENU_DISTILLERY.get(     ), ScreenDistillery::new);
		});
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  REGISTER  ---------- ---------- ---------- ---------- //
	
	// registers all deferred registries to the game
	public static void register(IEventBus bus){
		BLOCKS.register(        bus);
		ITEMS.register(         bus);
		MENUS.register(         bus);
		BLOCK_ENTITIES.register(bus);
		SOUNDS.register(        bus);
		ENTITIES.register(      bus);
		RECIPIES.register(      bus);
		CREATIVE_TABS.register( bus);
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  REGISTER CREATIVE TABS  ---------- ---------- ---------- ---------- //
	
	public static void registerCreativeTabs(BuildCreativeModeTabContentsEvent event){
		if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS){
			event.accept(Register.BLOCK_MYTHRIL);
			event.accept(Register.BLOCK_GILIUM);
			event.accept(Register.BLOCK_TIN);
			event.accept(Register.BLOCK_BRONZE);
			event.accept(Register.BLOCK_ORICHALCUM);
			event.accept(Register.BLOCK_ADAMANTIUM);
			event.accept(Register.BLOCK_RUBY);
			event.accept(Register.BLOCK_AURORITE);
			event.accept(Register.ORE_MYTHRIL_BASE);
			event.accept(Register.ORE_MYTHRIL_DEEP);
			event.accept(Register.ORE_GILIUM);
			event.accept(Register.ORE_TIN_BASE);
			event.accept(Register.ORE_TIN_DEEP);
			event.accept(Register.ORE_RUBY_BASE);
			event.accept(Register.ORE_RUBY_DEEP);
			event.accept(Register.ORE_AURORITE_BASE);
			event.accept(Register.ORE_AURORITE_DEEP);
			event.accept(Register.BLOCK_TOPAZ);
			event.accept(Register.BLOCK_TOPAZ_BUDDING);
			event.accept(Register.BLOCK_TOPAZ_CLUSTER);
			event.accept(Register.BLOCK_TOPAZ_BUD_3);
			event.accept(Register.BLOCK_TOPAZ_BUD_2);
			event.accept(Register.BLOCK_TOPAZ_BUD_1);
		}
		// if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){ }
		if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS){
			event.accept(Register.MACHINA_FOUNDRY);
			event.accept(Register.MACHINA_DISTILLERY);
			event.accept(Register.MACHINA_ANCHOR);
		}
		// if (event.getTabKey() == CreativeModeTabs.COLORED_BLOCKS){ }
		// if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS){ }
		if (event.getTabKey() == CreativeModeTabs.COMBAT){
			event.accept(Register.ARMOR_BOOTS_GILIUM);
			event.accept(Register.ARMOR_BOOTS_ADAMANTIUM);
			event.accept(Register.ARMOR_BOOTS_MYTHRIL);
			event.accept(Register.ARMOR_BOOTS_ORICHALCUM);
			event.accept(Register.ARMOR_BOOTS_BRONZE);
			event.accept(Register.ARMOR_BOOTS_AURORITE);
			event.accept(Register.ARMOR_PLATE_GILIUM);
			event.accept(Register.ARMOR_PLATE_ADAMANTIUM);
			event.accept(Register.ARMOR_PLATE_MYTHRIL);
			event.accept(Register.ARMOR_PLATE_ORICHALCUM);
			event.accept(Register.ARMOR_PLATE_BRONZE);
			event.accept(Register.ARMOR_PLATE_AURORITE);
			event.accept(Register.ARMOR_LEGGINGS_GILIUM);
			event.accept(Register.ARMOR_LEGGINGS_ADAMANTIUM);
			event.accept(Register.ARMOR_LEGGINGS_MYTHRIL);
			event.accept(Register.ARMOR_LEGGINGS_ORICHALCUM);
			event.accept(Register.ARMOR_LEGGINGS_BRONZE);
			event.accept(Register.ARMOR_LEGGINGS_AURORITE);
			event.accept(Register.ARMOR_HELMET_GILIUM);
			event.accept(Register.ARMOR_HELMET_ADAMANTIUM);
			event.accept(Register.ARMOR_HELMET_MYTHRIL);
			event.accept(Register.ARMOR_HELMET_ORICHALCUM);
			event.accept(Register.ARMOR_HELMET_BRONZE);
			event.accept(Register.ARMOR_HELMET_AURORITE);
			event.accept(Register.TOOL_SWORD_GILIUM);
			event.accept(Register.TOOL_SWORD_ADAMANTIUM);
			event.accept(Register.TOOL_SWORD_MYTHRIL);
			event.accept(Register.TOOL_SWORD_ORICHALCUM);
			event.accept(Register.TOOL_SWORD_BRONZE);
			event.accept(Register.TOOL_SWORD_AURORITE);
		}
		if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES){
			event.accept(Register.TOOL_AXE_GILIUM);
			event.accept(Register.TOOL_AXE_ADAMANTIUM);
			event.accept(Register.TOOL_AXE_MYTHRIL);
			event.accept(Register.TOOL_AXE_ORICHALCUM);
			event.accept(Register.TOOL_AXE_BRONZE);
			event.accept(Register.TOOL_AXE_AURORITE);
			event.accept(Register.TOOL_PICKAXE_GILIUM);
			event.accept(Register.TOOL_PICKAXE_ADAMANTIUM);
			event.accept(Register.TOOL_PICKAXE_MYTHRIL);
			event.accept(Register.TOOL_PICKAXE_ORICHALCUM);
			event.accept(Register.TOOL_PICKAXE_BRONZE);
			event.accept(Register.TOOL_PICKAXE_AURORITE);
			event.accept(Register.TOOL_SHOVEL_GILIUM);
			event.accept(Register.TOOL_SHOVEL_ADAMANTIUM);
			event.accept(Register.TOOL_SHOVEL_MYTHRIL);
			event.accept(Register.TOOL_SHOVEL_ORICHALCUM);
			event.accept(Register.TOOL_SHOVEL_BRONZE);
			event.accept(Register.TOOL_SHOVEL_AURORITE);
			event.accept(Register.TOOL_HOE_GILIUM);
			event.accept(Register.TOOL_HOE_ADAMANTIUM);
			event.accept(Register.TOOL_HOE_MYTHRIL);
			event.accept(Register.TOOL_HOE_ORICHALCUM);
			event.accept(Register.TOOL_HOE_BRONZE);
			event.accept(Register.TOOL_HOE_AURORITE);
			event.accept(Register.TOOL_DYNAMITE);
		}
		if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS){
			event.accept(Register.FOOD_ONIGIRI);
			event.accept(Register.FOOD_NIGIRI);
			event.accept(Register.FOOD_SUSHI);
			event.accept(Register.FOOD_VICUGNA_RAW);
			event.accept(Register.FOOD_VICUGNA_COOKED);
			event.accept(Register.LIQUOR_COFFEE);
			event.accept(Register.LIQUOR_SALGAM);
			event.accept(Register.LIQUOR_WHISKY);
			event.accept(Register.LIQUOR_VODKA);
			event.accept(Register.LIQUOR_SAKE);
			event.accept(Register.LIQUOR_RUM);
		}
		if (event.getTabKey() == CreativeModeTabs.INGREDIENTS){
			event.accept(Register.STUFF_MYTHRIL);
			event.accept(Register.STUFF_GILIUM);
			event.accept(Register.STUFF_TIN);
			event.accept(Register.INGOT_MYTHRIL);
			event.accept(Register.INGOT_GILIUM);
			event.accept(Register.INGOT_TIN);
			event.accept(Register.INGOT_BRONZE);
			event.accept(Register.INGOT_ORICHALCUM);
			event.accept(Register.INGOT_ADAMANTIUM);
			event.accept(Register.STUFF_COFFEE);
			event.accept(Register.STUFF_RICE);
			event.accept(Register.STUFF_HEMP);
			event.accept(Register.STUFF_ROPE);
			event.accept(Register.STUFF_SLAG);
			event.accept(Register.STUFF_RUBY);
			event.accept(Register.STUFF_AURORITE);
			event.accept(Register.STUFF_TOPAZ);
			event.accept(Register.SEED_COFFEE);
			event.accept(Register.SEED_RICE);
			event.accept(Register.SEED_HEMP);
			event.accept(Register.BOOK_ALLOY);
			event.accept(Register.BOOK_PLANT);
			event.accept(Register.BOOK_DRINK);
		}
		if (event.getTabKey().equals(CreativeModeTabs.SPAWN_EGGS)) {
			event.accept(Register.SPAWNEGG_ALPACA);
		}
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  EXTRA REGISTER  ---------- ---------- ---------- ---------- //
	
	public static void generateTradeData(){
		SystemTrades.addTradeToProfession(VillagerProfession.ARMORER, 1, new VillagerTrades.ItemListing[]{
				// ...
		});
		SystemTrades.addTradeToProfession(VillagerProfession.BUTCHER, 2, new VillagerTrades.ItemListing[]{
				new SystemTrades.ItemsForGems(FOOD_VICUGNA_COOKED.get(), 1, 2, 16,5, 0.05f),
				new SystemTrades.GemsForItems(FOOD_VICUGNA_RAW.get(),    7, 16, 20, 0.05f)
		});
		SystemTrades.addTradeToProfession(VillagerProfession.FARMER, 1, new VillagerTrades.ItemListing[]{
				new SystemTrades.ItemsForGems(SEED_HEMP.get(), 1, 4, 16, 2, 0.05f)
		});
		SystemTrades.addTradeToProfession(VillagerProfession.TOOLSMITH, 1, new VillagerTrades.ItemListing[]{
				// ...
		});
		SystemTrades.addTradeToProfession(VillagerProfession.WEAPONSMITH, 1, new VillagerTrades.ItemListing[]{
				// ...
		});
	}
	
	public static void registerJigsaws(MinecraftServer server) {
		Registry<StructureTemplatePool>  templatePoolRegistry  = server.registryAccess().registry(Registries.TEMPLATE_POOL ).orElseThrow();
		Registry<StructureProcessorList> processorListRegistry = server.registryAccess().registry(Registries.PROCESSOR_LIST).orElseThrow();
		
		SystemStructurePoolAdditions.addBuildingToPool(templatePoolRegistry, processorListRegistry, new ResourceLocation("minecraft:village/plains/houses"),  "acecraft:village/plains_farm_coffee",  1);
		SystemStructurePoolAdditions.addBuildingToPool(templatePoolRegistry, processorListRegistry, new ResourceLocation("minecraft:village/snowy/houses"),   "acecraft:village/snowy_farm_coffee",   1);
		SystemStructurePoolAdditions.addBuildingToPool(templatePoolRegistry, processorListRegistry, new ResourceLocation("minecraft:village/savanna/houses"), "acecraft:village/savanna_farm_coffee", 1);
		SystemStructurePoolAdditions.addBuildingToPool(templatePoolRegistry, processorListRegistry, new ResourceLocation("minecraft:village/desert/houses"),  "acecraft:village/desert_farm_coffee",  1);
		SystemStructurePoolAdditions.addBuildingToPool(templatePoolRegistry, processorListRegistry, new ResourceLocation("minecraft:village/taiga/houses"),   "acecraft:village/taiga_farm_coffee",   1);
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SUPPORT  ---------- ---------- ---------- ---------- //
	
	// creates a block for the registry
	// sets up a creative tab for an additional registry later
	// if no creative tab, it does not create an fitting itemblock
	protected static RegistryObject<Block> registerBlock(String name, Supplier<? extends Block> block, boolean registerItemBlock){
		RegistryObject<Block> supply = BLOCKS.register(name, block);
		if(registerItemBlock){
			ITEMS.register(name, () -> new BlockItem(supply.get(), new Item.Properties()));
		}
		return supply;
	}
	
	protected static RegistryObject<Block> registerBlock(String name, Supplier<? extends Block> block){
		return registerBlock(name, block, true);
	}
	
	// creates an item fo the registry
	protected static RegistryObject<Item> registerItem(String name, Supplier<? extends Item> item){
		return ITEMS.register(name, item);
	}
	
	
	
}