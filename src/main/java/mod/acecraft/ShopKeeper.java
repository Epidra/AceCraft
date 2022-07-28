package mod.acecraft;

import mod.acecraft.block.*;
import mod.acecraft.menu.MenuDistillery;
import mod.acecraft.menu.MenuFoundry;
import mod.acecraft.crafting.*;
import mod.acecraft.entity.*;
import mod.acecraft.item.*;
import mod.acecraft.screen.ScreenDistillery;
import mod.acecraft.screen.ScreenFoundry;
import mod.acecraft.blockentity.*;
import mod.acecraft.structure.StructureRuinedHouse;
import mod.acecraft.util.*;
import mod.lucky77.block.BlockBlock;
import mod.lucky77.item.ItemFood;
import mod.lucky77.item.ItemItem;
import mod.lucky77.system.SystemRegister;
import mod.lucky77.system.SystemStructures;
import mod.lucky77.system.SystemTrades;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.PlainVillagePools;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.*;

import static net.minecraft.world.entity.MobCategory.CREATURE;

@SuppressWarnings({"unused", "deprecation"})
public class ShopKeeper {

    private static final DeferredRegister<Block>               BLOCKS     = DeferredRegister.create(ForgeRegistries.BLOCKS,             AceCraft.MODID);
    private static final DeferredRegister<Item>                ITEMS      = DeferredRegister.create(ForgeRegistries.ITEMS,              AceCraft.MODID);
    private static final DeferredRegister<MenuType<?>>         CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS,         AceCraft.MODID);
    private static final DeferredRegister<BlockEntityType<?>>  TILES      = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES,     AceCraft.MODID);
    private static final DeferredRegister<SoundEvent>          SOUNDS     = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS,       AceCraft.MODID);
    private static final DeferredRegister<EntityType<?>>       ENTITIES   = DeferredRegister.create(ForgeRegistries.ENTITIES,           AceCraft.MODID);
    private static final DeferredRegister<RecipeSerializer<?>> RECIPES    = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, AceCraft.MODID);
    private static final DeferredRegister<StructureFeature<?>> STRUCTURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, AceCraft.MODID);





    // Blocks
    public static final RegistryObject<Block> BLOCK_MYTHRIL    = registerB("block_mythril",    () -> new BlockBlock(Blocks.IRON_BLOCK),    CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_GILIUM     = registerB("block_gilium",     () -> new BlockBlock(Blocks.IRON_BLOCK),    CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_TIN        = registerB("block_tin",        () -> new BlockBlock(Blocks.IRON_BLOCK),    CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_ZINC       = registerB("block_zinc",       () -> new BlockBlock(Blocks.IRON_BLOCK),    CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_BRONZE     = registerB("block_bronze",     () -> new BlockBlock(Blocks.IRON_BLOCK),    CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_BRASS      = registerB("block_brass",      () -> new BlockBlock(Blocks.IRON_BLOCK),    CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_STEEL      = registerB("block_steel",      () -> new BlockBlock(Blocks.IRON_BLOCK),    CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_ORICHALCUM = registerB("block_orichalcum", () -> new BlockBlock(Blocks.IRON_BLOCK),    CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_ADAMANTIUM = registerB("block_adamantium", () -> new BlockBlock(Blocks.IRON_BLOCK),    CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_SALT       = registerB("block_salt",       () -> new BlockBlock(Blocks.SAND),          CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_SULFUR     = registerB("block_sulfur",     () -> new BlockBlock(Blocks.SAND),          CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_RUBY       = registerB("block_ruby",       () -> new BlockBlock(Blocks.DIAMOND_BLOCK), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_SAPPHIRE   = registerB("block_sapphire",   () -> new BlockBlock(Blocks.DIAMOND_BLOCK), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_AURORITE   = registerB("block_aurorite",   () -> new BlockBlock(Blocks.DIAMOND_BLOCK), CreativeModeTab.TAB_BUILDING_BLOCKS);

    // Ore
    public static final RegistryObject<Block> ORE_MYTHRIL_BASE  = registerB("ore_mythril_base",  () -> new BlockOre(Blocks.IRON_ORE),              CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_MYTHRIL_DEEP  = registerB("ore_mythril_deep",  () -> new BlockOre(Blocks.DEEPSLATE_IRON_ORE),    CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_GILIUM        = registerB("ore_gilium",        () -> new BlockOre(Blocks.IRON_ORE),              CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_TIN_BASE      = registerB("ore_tin_base",      () -> new BlockOre(Blocks.IRON_ORE),              CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_TIN_DEEP      = registerB("ore_tin_deep",      () -> new BlockOre(Blocks.DEEPSLATE_IRON_ORE),    CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_ZINC_BASE     = registerB("ore_zinc_base",     () -> new BlockOre(Blocks.IRON_ORE),              CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_ZINC_DEEP     = registerB("ore_zinc_deep",     () -> new BlockOre(Blocks.DEEPSLATE_IRON_ORE),    CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_SALT_BASE     = registerB("ore_salt_base",     () -> new BlockOre(Blocks.LAPIS_ORE),             CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_SALT_DEEP     = registerB("ore_salt_deep",     () -> new BlockOre(Blocks.DEEPSLATE_LAPIS_ORE),   CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_SULFUR_BASE   = registerB("ore_sulfur_base",   () -> new BlockOre(Blocks.LAPIS_ORE),             CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_SULFUR_DEEP   = registerB("ore_sulfur_deep",   () -> new BlockOre(Blocks.DEEPSLATE_LAPIS_ORE),   CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_RUBY_BASE     = registerB("ore_ruby_base",     () -> new BlockOre(Blocks.DIAMOND_ORE),           CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_RUBY_DEEP     = registerB("ore_ruby_deep",     () -> new BlockOre(Blocks.DEEPSLATE_DIAMOND_ORE), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_SAPPHIRE_BASE = registerB("ore_sapphire_base", () -> new BlockOre(Blocks.DIAMOND_ORE),           CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_SAPPHIRE_DEEP = registerB("ore_sapphire_deep", () -> new BlockOre(Blocks.DEEPSLATE_DIAMOND_ORE), CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_AURORITE_BASE = registerB("ore_aurorite_base", () -> new BlockOre(Blocks.DIAMOND_ORE),           CreativeModeTab.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_AURORITE_DEEP = registerB("ore_aurorite_deep", () -> new BlockOre(Blocks.DEEPSLATE_DIAMOND_ORE), CreativeModeTab.TAB_BUILDING_BLOCKS);

    // Nuggets
    public static final RegistryObject<Item> NUGGET_MYTHRIL = registerI("nugget_mythril", () -> new ItemItem(CreativeModeTab.TAB_MATERIALS));
    public static final RegistryObject<Item> NUGGET_GILIUM  = registerI("nugget_gilium",  () -> new ItemItem(CreativeModeTab.TAB_MATERIALS));
    public static final RegistryObject<Item> NUGGET_TIN     = registerI("nugget_tin",     () -> new ItemItem(CreativeModeTab.TAB_MATERIALS));
    public static final RegistryObject<Item> NUGGET_ZINC    = registerI("nugget_zinc",    () -> new ItemItem(CreativeModeTab.TAB_MATERIALS));

    // Ingot
    public static final RegistryObject<Item> INGOT_MYTHRIL    = registerI("ingot_mythril",    () -> new ItemItem(CreativeModeTab.TAB_MATERIALS));
    public static final RegistryObject<Item> INGOT_GILIUM     = registerI("ingot_gilium",     () -> new ItemItem(CreativeModeTab.TAB_MATERIALS));
    public static final RegistryObject<Item> INGOT_TIN        = registerI("ingot_tin",        () -> new ItemItem(CreativeModeTab.TAB_MATERIALS));
    public static final RegistryObject<Item> INGOT_ZINC       = registerI("ingot_zinc",       () -> new ItemItem(CreativeModeTab.TAB_MATERIALS));
    public static final RegistryObject<Item> INGOT_BRONZE     = registerI("ingot_bronze",     () -> new ItemItem(CreativeModeTab.TAB_MATERIALS));
    public static final RegistryObject<Item> INGOT_BRASS      = registerI("ingot_brass",      () -> new ItemItem(CreativeModeTab.TAB_MATERIALS));
    public static final RegistryObject<Item> INGOT_STEEL      = registerI("ingot_steel",      () -> new ItemItem(CreativeModeTab.TAB_MATERIALS));
    public static final RegistryObject<Item> INGOT_ORICHALCUM = registerI("ingot_orichalcum", () -> new ItemItem(CreativeModeTab.TAB_MATERIALS));
    public static final RegistryObject<Item> INGOT_ADAMANTIUM = registerI("ingot_adamantium", () -> new ItemItem(CreativeModeTab.TAB_MATERIALS));

    // Stuff
    public static final RegistryObject<Item> STUFF_SALT     = registerI("stuff_salt",     () -> new ItemItem(CreativeModeTab.TAB_MISC));
    public static final RegistryObject<Item> STUFF_SULFUR   = registerI("stuff_sulfur",   () -> new ItemItem(CreativeModeTab.TAB_MISC));
    public static final RegistryObject<Item> STUFF_RICE     = registerI("stuff_rice",     () -> new ItemItem(CreativeModeTab.TAB_MISC));
    public static final RegistryObject<Item> STUFF_COFFEE   = registerI("stuff_coffee",   () -> new ItemItem(CreativeModeTab.TAB_MISC));
    public static final RegistryObject<Item> STUFF_HEMP     = registerI("stuff_hemp",     () -> new ItemItem(CreativeModeTab.TAB_MISC));
    public static final RegistryObject<Item> STUFF_ROPE     = registerI("stuff_rope",     () -> new ItemItem(CreativeModeTab.TAB_MISC));
    public static final RegistryObject<Item> STUFF_SLAG     = registerI("stuff_slag",     () -> new ItemItem(CreativeModeTab.TAB_MISC));
    public static final RegistryObject<Item> STUFF_RUBY     = registerI("stuff_ruby",     () -> new ItemItem(CreativeModeTab.TAB_MISC));
    public static final RegistryObject<Item> STUFF_SAPPHIRE = registerI("stuff_sapphire", () -> new ItemItem(CreativeModeTab.TAB_MISC));
    public static final RegistryObject<Item> STUFF_AURORITE = registerI("stuff_aurorite", () -> new ItemItem(CreativeModeTab.TAB_MISC));

    // Food
    public static final RegistryObject<Item> FOOD_CABBAGE        = registerI("food_cabbage",        () -> new ItemFood(1, 1, false));
    public static final RegistryObject<Item> FOOD_CORN           = registerI("food_corn",           () -> new ItemFood(1, 1, false));
    public static final RegistryObject<Item> FOOD_CUCUMBER       = registerI("food_cucumber",       () -> new ItemFood(1, 1, false));
    public static final RegistryObject<Item> FOOD_EGGPLANT       = registerI("food_eggplant",       () -> new ItemFood(1, 1, false));
    public static final RegistryObject<Item> FOOD_GRAPES         = registerI("food_grapes",         () -> new ItemFood(1, 1, false));
    public static final RegistryObject<Item> FOOD_ONION          = registerI("food_onion",          () -> new ItemFood(1, 1, false));
    public static final RegistryObject<Item> FOOD_PINEAPPLE      = registerI("food_pineapple",      () -> new ItemFood(1, 1, false));
    public static final RegistryObject<Item> FOOD_STRAWBERRY     = registerI("food_strawberry",     () -> new ItemFood(1, 1, false));
    public static final RegistryObject<Item> FOOD_TOMATO         = registerI("food_tomato",         () -> new ItemFood(1, 1, false));
    public static final RegistryObject<Item> FOOD_TURNIP         = registerI("food_turnip",         () -> new ItemFood(1, 1, false));
    public static final RegistryObject<Item> FOOD_VICUGNA_RAW    = registerI("food_vicugna_raw",    () -> new ItemFood(1, 1, true));
    public static final RegistryObject<Item> FOOD_VICUGNA_COOKED = registerI("food_vicugna_cooked", () -> new ItemFood(1, 1, true));

    // Liquor
    public static final RegistryObject<Item> LIQUOR_COFFEE    = registerI("liquor_coffee",    () -> new ItemLiquor(MobEffects.DIG_SPEED,    1.0f, MobEffects.HUNGER,    0.8f));
    public static final RegistryObject<Item> LIQUOR_MOONSHINE = registerI("liquor_moonshine", () -> new ItemLiquor(MobEffects.DAMAGE_BOOST, 0.3f, MobEffects.CONFUSION, 0.3f));
    public static final RegistryObject<Item> LIQUOR_RUM       = registerI("liquor_rum",       () -> new ItemLiquor(MobEffects.DAMAGE_BOOST, 0.3f, MobEffects.CONFUSION, 0.3f));
    public static final RegistryObject<Item> LIQUOR_SAKE      = registerI("liquor_sake",      () -> new ItemLiquor(MobEffects.DAMAGE_BOOST, 0.3f, MobEffects.CONFUSION, 0.3f));
    public static final RegistryObject<Item> LIQUOR_SALGAM    = registerI("liquor_salgam",    () -> new ItemLiquor(MobEffects.DAMAGE_BOOST, 0.3f, MobEffects.CONFUSION, 0.3f));
    public static final RegistryObject<Item> LIQUOR_VODKA     = registerI("liquor_vodka",     () -> new ItemLiquor(MobEffects.DAMAGE_BOOST, 0.3f, MobEffects.CONFUSION, 0.3f));
    public static final RegistryObject<Item> LIQUOR_WHISKY    = registerI("liquor_whisky",    () -> new ItemLiquor(MobEffects.DAMAGE_BOOST, 0.3f, MobEffects.CONFUSION, 0.3f));
    public static final RegistryObject<Item> LIQUOR_BRANDY    = registerI("liquor_brandy",    () -> new ItemLiquor(MobEffects.DAMAGE_BOOST, 0.3f, MobEffects.CONFUSION, 0.3f));
    public static final RegistryObject<Item> LIQUOR_OIL       = registerI("liquor_oil",       () -> new ItemLiquor(MobEffects.WITHER,       1.0f, MobEffects.HUNGER,    1.0f));

    // Crop
    public static final RegistryObject<Block> CROP_CABBAGE    = registerB("crop_cabbage",    () -> new BlockCrop("cabbage",   Blocks.WHEAT));
    public static final RegistryObject<Block> CROP_CORN       = registerB("crop_corn",       () -> new BlockCrop("corn",      Blocks.WHEAT));
    public static final RegistryObject<Block> CROP_CUCUMBER   = registerB("crop_cucumber",   () -> new BlockCrop("cucumber",  Blocks.WHEAT));
    public static final RegistryObject<Block> CROP_EGGPLANT   = registerB("crop_eggplant",   () -> new BlockCrop("eggplant",  Blocks.WHEAT));
    public static final RegistryObject<Block> CROP_GRAPES     = registerB("crop_grapes",     () -> new BlockCrop("grapes",    Blocks.WHEAT));
    public static final RegistryObject<Block> CROP_ONION      = registerB("crop_onion",      () -> new BlockCrop("onion",     Blocks.WHEAT));
    public static final RegistryObject<Block> CROP_PINEAPPLE  = registerB("crop_pineapple",  () -> new BlockCrop("pineapple", Blocks.WHEAT));
    public static final RegistryObject<Block> CROP_STRAWBERRY = registerB("crop_strawberry", () -> new BlockCrop("strawberry",Blocks.WHEAT));
    public static final RegistryObject<Block> CROP_TOMATO     = registerB("crop_tomato",     () -> new BlockCrop("tomato",    Blocks.WHEAT));
    public static final RegistryObject<Block> CROP_TURNIP     = registerB("crop_turnip",     () -> new BlockCrop("turnip",    Blocks.WHEAT));
    public static final RegistryObject<Block> CROP_RICE       = registerB("crop_rice",       () -> new BlockCrop("rice",      Blocks.WHEAT));
    public static final RegistryObject<Block> CROP_COFFEE     = registerB("crop_coffee",     () -> new BlockCrop("coffee",    Blocks.WHEAT));
    public static final RegistryObject<Block> CROP_HEMP       = registerB("crop_hemp",       () -> new BlockCrop("hemp",      Blocks.WHEAT));

    // Seeds
    public static final RegistryObject<Item> SEED_CABBAGE    = registerI("seeds_cabbage",    () -> new ItemSeed("cabbage"   ));
    public static final RegistryObject<Item> SEED_CORN       = registerI("seeds_corn",       () -> new ItemSeed("corn"      ));
    public static final RegistryObject<Item> SEED_CUCUMBER   = registerI("seeds_cucumber",   () -> new ItemSeed("cucumber"  ));
    public static final RegistryObject<Item> SEED_EGGPLANT   = registerI("seeds_eggplant",   () -> new ItemSeed("eggplant"  ));
    public static final RegistryObject<Item> SEED_GRAPES     = registerI("seeds_grapes",     () -> new ItemSeed("grapes"    ));
    public static final RegistryObject<Item> SEED_ONION      = registerI("seeds_onion",      () -> new ItemSeed("onion"     ));
    public static final RegistryObject<Item> SEED_PINEAPPLE  = registerI("seeds_pineapple",  () -> new ItemSeed("pineapple" ));
    public static final RegistryObject<Item> SEED_STRAWBERRY = registerI("seeds_strawberry", () -> new ItemSeed("strawberry"));
    public static final RegistryObject<Item> SEED_TOMATO     = registerI("seeds_tomato",     () -> new ItemSeed("tomato"    ));
    public static final RegistryObject<Item> SEED_TURNIP     = registerI("seeds_turnip",     () -> new ItemSeed("turnip"    ));
    public static final RegistryObject<Item> SEED_RICE       = registerI("seeds_rice",       () -> new ItemSeed("rice"      ));
    public static final RegistryObject<Item> SEED_COFFEE     = registerI("seeds_coffee",     () -> new ItemSeed("coffee"    ));
    public static final RegistryObject<Item> SEED_HEMP       = registerI("seeds_hemp",       () -> new ItemSeed("hemp"      ));

    // Machina
    public static final RegistryObject<Block> MACHINA_GLOBE        = registerB("machina_globe",        () -> new BlockGlobe(),        CreativeModeTab.TAB_DECORATIONS);     //static final RegistryObject<Item> I_MACHINA_GLOBE        = fromBlock(MACHINA_GLOBE       , CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> MACHINA_FOUNDRY      = registerB("machina_foundry",      () -> new BlockFoundry(),      CreativeModeTab.TAB_DECORATIONS);     //static final RegistryObject<Item> I_MACHINA_FOUNDRY      = fromBlock(MACHINA_FOUNDRY     , CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> MACHINA_DISTILLERY   = registerB("machina_distillery",   () -> new BlockDistillery(),   CreativeModeTab.TAB_DECORATIONS);     //static final RegistryObject<Item> I_MACHINA_DISTILLERY   = fromBlock(MACHINA_DISTILLERY  , CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> MACHINA_COOKINGBOARD = registerB("machina_cookingboard", () -> new BlockCookingBoard(), CreativeModeTab.TAB_DECORATIONS);     //static final RegistryObject<Item> I_MACHINA_COOKINGBOARD = fromBlock(MACHINA_COOKINGBOARD, CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> MACHINA_KEG          = registerB("machina_keg",          () -> new BlockKeg(),          CreativeModeTab.TAB_DECORATIONS);     //static final RegistryObject<Item> I_MACHINA_KEG          = fromBlock(MACHINA_KEG         , CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> MACHINA_ANCHOR       = registerB("machina_anchor",       () -> new BlockAnchor(),       CreativeModeTab.TAB_DECORATIONS);     //static final RegistryObject<Item> I_MACHINA_ANCHOR       = fromBlock(MACHINA_ANCHOR      , CreativeModeTab.TAB_DECORATIONS);
    public static final RegistryObject<Block> MACHINA_ROPE         = registerB("machina_rope",         () -> new BlockRope(),         CreativeModeTab.TAB_DECORATIONS);     //static final RegistryObject<Item> I_MACHINA_ROPE         = fromBlock(MACHINA_ROPE        , CreativeModeTab.TAB_DECORATIONS);

    // Armor Boots
    public static final RegistryObject<Item> ARMOR_BOOTS_GILIUM     = registerI("armor_boots_gilium",     () -> new ItemArmor(     MaterialArmor.GILIUM,     EquipmentSlot.FEET));
    public static final RegistryObject<Item> ARMOR_BOOTS_ADAMANTIUM = registerI("armor_boots_adamantium", () -> new ItemArmor(     MaterialArmor.ADAMANTIUM, EquipmentSlot.FEET));
    public static final RegistryObject<Item> ARMOR_BOOTS_MYTHRIL    = registerI("armor_boots_mythril",    () -> new ItemArmor(     MaterialArmor.MYTHRIL,    EquipmentSlot.FEET));
    public static final RegistryObject<Item> ARMOR_BOOTS_ORICHALCUM = registerI("armor_boots_orichalcum", () -> new ItemArmor(     MaterialArmor.ORICHALCUM, EquipmentSlot.FEET));
    public static final RegistryObject<Item> ARMOR_BOOTS_COPPER     = registerI("armor_boots_copper",     () -> new ItemArmor(     MaterialArmor.COPPER,     EquipmentSlot.FEET));
    public static final RegistryObject<Item> ARMOR_BOOTS_BRONZE     = registerI("armor_boots_bronze",     () -> new ItemArmor(     MaterialArmor.BRONZE,     EquipmentSlot.FEET));
    public static final RegistryObject<Item> ARMOR_BOOTS_STEEL      = registerI("armor_boots_steel",      () -> new ItemArmor(     MaterialArmor.STEEL,      EquipmentSlot.FEET));
    public static final RegistryObject<Item> ARMOR_BOOTS_AURORITE   = registerI("armor_boots_aurorite",   () -> new ItemArmorColor(MaterialArmor.AURORITE,   EquipmentSlot.FEET));

    // Armor Chestplate
    public static final RegistryObject<Item> ARMOR_PLATE_GILIUM     = registerI("armor_plate_gilium",     () -> new ItemArmor(     MaterialArmor.GILIUM,     EquipmentSlot.CHEST));
    public static final RegistryObject<Item> ARMOR_PLATE_ADAMANTIUM = registerI("armor_plate_adamantium", () -> new ItemArmor(     MaterialArmor.ADAMANTIUM, EquipmentSlot.CHEST));
    public static final RegistryObject<Item> ARMOR_PLATE_MYTHRIL    = registerI("armor_plate_mythril",    () -> new ItemArmor(     MaterialArmor.MYTHRIL,    EquipmentSlot.CHEST));
    public static final RegistryObject<Item> ARMOR_PLATE_ORICHALCUM = registerI("armor_plate_orichalcum", () -> new ItemArmor(     MaterialArmor.ORICHALCUM, EquipmentSlot.CHEST));
    public static final RegistryObject<Item> ARMOR_PLATE_COPPER     = registerI("armor_plate_copper",     () -> new ItemArmor(     MaterialArmor.COPPER,     EquipmentSlot.CHEST));
    public static final RegistryObject<Item> ARMOR_PLATE_BRONZE     = registerI("armor_plate_bronze",     () -> new ItemArmor(     MaterialArmor.BRONZE,     EquipmentSlot.CHEST));
    public static final RegistryObject<Item> ARMOR_PLATE_STEEL      = registerI("armor_plate_steel",      () -> new ItemArmor(     MaterialArmor.STEEL,      EquipmentSlot.CHEST));
    public static final RegistryObject<Item> ARMOR_PLATE_AURORITE   = registerI("armor_plate_aurorite",   () -> new ItemArmorColor(MaterialArmor.AURORITE,   EquipmentSlot.CHEST));

    // Armor Leggings
    public static final RegistryObject<Item> ARMOR_LEGGINGS_GILIUM     = registerI("armor_leggings_gilium",     () -> new ItemArmor(     MaterialArmor.GILIUM,     EquipmentSlot.LEGS));
    public static final RegistryObject<Item> ARMOR_LEGGINGS_ADAMANTIUM = registerI("armor_leggings_adamantium", () -> new ItemArmor(     MaterialArmor.ADAMANTIUM, EquipmentSlot.LEGS));
    public static final RegistryObject<Item> ARMOR_LEGGINGS_MYTHRIL    = registerI("armor_leggings_mythril",    () -> new ItemArmor(     MaterialArmor.MYTHRIL,    EquipmentSlot.LEGS));
    public static final RegistryObject<Item> ARMOR_LEGGINGS_ORICHALCUM = registerI("armor_leggings_orichalcum", () -> new ItemArmor(     MaterialArmor.ORICHALCUM, EquipmentSlot.LEGS));
    public static final RegistryObject<Item> ARMOR_LEGGINGS_COPPER     = registerI("armor_leggings_copper",     () -> new ItemArmor(     MaterialArmor.COPPER,     EquipmentSlot.LEGS));
    public static final RegistryObject<Item> ARMOR_LEGGINGS_BRONZE     = registerI("armor_leggings_bronze",     () -> new ItemArmor(     MaterialArmor.BRONZE,     EquipmentSlot.LEGS));
    public static final RegistryObject<Item> ARMOR_LEGGINGS_STEEL      = registerI("armor_leggings_steel",      () -> new ItemArmor(     MaterialArmor.STEEL,      EquipmentSlot.LEGS));
    public static final RegistryObject<Item> ARMOR_LEGGINGS_AURORITE   = registerI("armor_leggings_aurorite",   () -> new ItemArmorColor(MaterialArmor.AURORITE,   EquipmentSlot.LEGS));

    // Armor Helmet
    public static final RegistryObject<Item> ARMOR_HELMET_GILIUM     = registerI("armor_helmet_gilium",     () -> new ItemArmor(     MaterialArmor.GILIUM,     EquipmentSlot.HEAD));
    public static final RegistryObject<Item> ARMOR_HELMET_ADAMANTIUM = registerI("armor_helmet_adamantium", () -> new ItemArmor(     MaterialArmor.ADAMANTIUM, EquipmentSlot.HEAD));
    public static final RegistryObject<Item> ARMOR_HELMET_MYTHRIL    = registerI("armor_helmet_mythril",    () -> new ItemArmor(     MaterialArmor.MYTHRIL,    EquipmentSlot.HEAD));
    public static final RegistryObject<Item> ARMOR_HELMET_ORICHALCUM = registerI("armor_helmet_orichalcum", () -> new ItemArmor(     MaterialArmor.ORICHALCUM, EquipmentSlot.HEAD));
    public static final RegistryObject<Item> ARMOR_HELMET_COPPER     = registerI("armor_helmet_copper",     () -> new ItemArmor(     MaterialArmor.COPPER,     EquipmentSlot.HEAD));
    public static final RegistryObject<Item> ARMOR_HELMET_BRONZE     = registerI("armor_helmet_bronze",     () -> new ItemArmor(     MaterialArmor.BRONZE,     EquipmentSlot.HEAD));
    public static final RegistryObject<Item> ARMOR_HELMET_STEEL      = registerI("armor_helmet_steel",      () -> new ItemArmor(     MaterialArmor.STEEL,      EquipmentSlot.HEAD));
    public static final RegistryObject<Item> ARMOR_HELMET_AURORITE   = registerI("armor_helmet_aurorite",   () -> new ItemArmorColor(MaterialArmor.AURORITE,   EquipmentSlot.HEAD));

    // Tool Sword
    public static final RegistryObject<Item> TOOL_SWORD_GILIUM     = registerI("tool_sword_gilium",     () -> new ToolSword(MaterialTool.GILIUM,     2, -1.0f));
    public static final RegistryObject<Item> TOOL_SWORD_ADAMANTIUM = registerI("tool_sword_adamantium", () -> new ToolSword(MaterialTool.ADAMANTIUM, 3, -1.0f));
    public static final RegistryObject<Item> TOOL_SWORD_MYTHRIL    = registerI("tool_sword_mythril",    () -> new ToolSword(MaterialTool.MYTHRIL,    2, -1.0f));
    public static final RegistryObject<Item> TOOL_SWORD_ORICHALCUM = registerI("tool_sword_orichalcum", () -> new ToolSword(MaterialTool.ORICHALCUM, 3, -1.0f));
    public static final RegistryObject<Item> TOOL_SWORD_COPPER     = registerI("tool_sword_copper",     () -> new ToolSword(MaterialTool.COPPER,     1, -1.0f));
    public static final RegistryObject<Item> TOOL_SWORD_BRONZE     = registerI("tool_sword_bronze",     () -> new ToolSword(MaterialTool.BRONZE,     2, -1.0f));
    public static final RegistryObject<Item> TOOL_SWORD_STEEL      = registerI("tool_sword_steel",      () -> new ToolSword(MaterialTool.STEEL,      2, -1.0f));
    public static final RegistryObject<Item> TOOL_SWORD_AURORITE   = registerI("tool_sword_aurorite",   () -> new ToolSword(MaterialTool.AURORITE,   3, -1.0f));

    // Tool Spear
    public static final RegistryObject<Item> TOOL_SPEAR_GILIUM     = registerI("tool_spear_gilium",     () -> new ToolSpear(MaterialTool.GILIUM,     2, -1.0f));
    public static final RegistryObject<Item> TOOL_SPEAR_ADAMANTIUM = registerI("tool_spear_adamantium", () -> new ToolSpear(MaterialTool.ADAMANTIUM, 3, -1.0f));
    public static final RegistryObject<Item> TOOL_SPEAR_MYTHRIL    = registerI("tool_spear_mythril",    () -> new ToolSpear(MaterialTool.MYTHRIL,    2, -1.0f));
    public static final RegistryObject<Item> TOOL_SPEAR_ORICHALCUM = registerI("tool_spear_orichalcum", () -> new ToolSpear(MaterialTool.ORICHALCUM, 3, -1.0f));
    public static final RegistryObject<Item> TOOL_SPEAR_COPPER     = registerI("tool_spear_copper",     () -> new ToolSpear(MaterialTool.COPPER,     1, -1.0f));
    public static final RegistryObject<Item> TOOL_SPEAR_BRONZE     = registerI("tool_spear_bronze",     () -> new ToolSpear(MaterialTool.BRONZE,     2, -1.0f));
    public static final RegistryObject<Item> TOOL_SPEAR_STEEL      = registerI("tool_spear_steel",      () -> new ToolSpear(MaterialTool.STEEL,      2, -1.0f));
    public static final RegistryObject<Item> TOOL_SPEAR_AURORITE   = registerI("tool_spear_aurorite",   () -> new ToolSpear(MaterialTool.AURORITE,   3, -1.0f));

    // Tool Axe
    public static final RegistryObject<Item> TOOL_AXE_GILIUM     = registerI("tool_axe_gilium",     () -> new ToolAxe(MaterialTool.GILIUM,     2, -1.0f));
    public static final RegistryObject<Item> TOOL_AXE_ADAMANTIUM = registerI("tool_axe_adamantium", () -> new ToolAxe(MaterialTool.ADAMANTIUM, 3, -1.0f));
    public static final RegistryObject<Item> TOOL_AXE_MYTHRIL    = registerI("tool_axe_mythril",    () -> new ToolAxe(MaterialTool.MYTHRIL,    2, -1.0f));
    public static final RegistryObject<Item> TOOL_AXE_ORICHALCUM = registerI("tool_axe_orichalcum", () -> new ToolAxe(MaterialTool.ORICHALCUM, 3, -1.0f));
    public static final RegistryObject<Item> TOOL_AXE_COPPER     = registerI("tool_axe_copper",     () -> new ToolAxe(MaterialTool.COPPER,     1, -1.0f));
    public static final RegistryObject<Item> TOOL_AXE_BRONZE     = registerI("tool_axe_bronze",     () -> new ToolAxe(MaterialTool.BRONZE,     2, -1.0f));
    public static final RegistryObject<Item> TOOL_AXE_STEEL      = registerI("tool_axe_steel",      () -> new ToolAxe(MaterialTool.STEEL,      2, -1.0f));
    public static final RegistryObject<Item> TOOL_AXE_AURORITE   = registerI("tool_axe_aurorite",   () -> new ToolAxe(MaterialTool.AURORITE,   3, -1.0f));

    // Tool Pickaxe
    public static final RegistryObject<Item> TOOL_PICKAXE_GILIUM     = registerI("tool_pickaxe_gilium",     () -> new ToolPickaxe(MaterialTool.GILIUM,     2, -1.0f));
    public static final RegistryObject<Item> TOOL_PICKAXE_ADAMANTIUM = registerI("tool_pickaxe_adamantium", () -> new ToolPickaxe(MaterialTool.ADAMANTIUM, 3, -1.0f));
    public static final RegistryObject<Item> TOOL_PICKAXE_MYTHRIL    = registerI("tool_pickaxe_mythril",    () -> new ToolPickaxe(MaterialTool.MYTHRIL,    2, -1.0f));
    public static final RegistryObject<Item> TOOL_PICKAXE_ORICHALCUM = registerI("tool_pickaxe_orichalcum", () -> new ToolPickaxe(MaterialTool.ORICHALCUM, 3, -1.0f));
    public static final RegistryObject<Item> TOOL_PICKAXE_COPPER     = registerI("tool_pickaxe_copper",     () -> new ToolPickaxe(MaterialTool.COPPER,     1, -1.0f));
    public static final RegistryObject<Item> TOOL_PICKAXE_BRONZE     = registerI("tool_pickaxe_bronze",     () -> new ToolPickaxe(MaterialTool.BRONZE,     2, -1.0f));
    public static final RegistryObject<Item> TOOL_PICKAXE_STEEL      = registerI("tool_pickaxe_steel",      () -> new ToolPickaxe(MaterialTool.STEEL,      2, -1.0f));
    public static final RegistryObject<Item> TOOL_PICKAXE_AURORITE   = registerI("tool_pickaxe_aurorite",   () -> new ToolPickaxe(MaterialTool.AURORITE,   3, -1.0f));

    // Tool Shovel
    public static final RegistryObject<Item> TOOL_SHOVEL_GILIUM     = registerI("tool_shovel_gilium",     () -> new ToolShovel(MaterialTool.GILIUM,     2, -1.0f));
    public static final RegistryObject<Item> TOOL_SHOVEL_ADAMANTIUM = registerI("tool_shovel_adamantium", () -> new ToolShovel(MaterialTool.ADAMANTIUM, 3, -1.0f));
    public static final RegistryObject<Item> TOOL_SHOVEL_MYTHRIL    = registerI("tool_shovel_mythril",    () -> new ToolShovel(MaterialTool.MYTHRIL,    2, -1.0f));
    public static final RegistryObject<Item> TOOL_SHOVEL_ORICHALCUM = registerI("tool_shovel_orichalcum", () -> new ToolShovel(MaterialTool.ORICHALCUM, 3, -1.0f));
    public static final RegistryObject<Item> TOOL_SHOVEL_COPPER     = registerI("tool_shovel_copper",     () -> new ToolShovel(MaterialTool.COPPER,     1, -1.0f));
    public static final RegistryObject<Item> TOOL_SHOVEL_BRONZE     = registerI("tool_shovel_bronze",     () -> new ToolShovel(MaterialTool.BRONZE,     2, -1.0f));
    public static final RegistryObject<Item> TOOL_SHOVEL_STEEL      = registerI("tool_shovel_steel",      () -> new ToolShovel(MaterialTool.STEEL,      2, -1.0f));
    public static final RegistryObject<Item> TOOL_SHOVEL_AURORITE   = registerI("tool_shovel_aurorite",   () -> new ToolShovel(MaterialTool.AURORITE,   3, -1.0f));

    // Tool Hoe
    public static final RegistryObject<Item> TOOL_HOE_GILIUM     = registerI("tool_hoe_gilium",     () -> new ToolHoe(MaterialTool.GILIUM,     2, -1.0f));
    public static final RegistryObject<Item> TOOL_HOE_ADAMANTIUM = registerI("tool_hoe_adamantium", () -> new ToolHoe(MaterialTool.ADAMANTIUM, 3, -1.0f));
    public static final RegistryObject<Item> TOOL_HOE_MYTHRIL    = registerI("tool_hoe_mythril",    () -> new ToolHoe(MaterialTool.MYTHRIL,    2, -1.0f));
    public static final RegistryObject<Item> TOOL_HOE_ORICHALCUM = registerI("tool_hoe_orichalcum", () -> new ToolHoe(MaterialTool.ORICHALCUM, 3, -1.0f));
    public static final RegistryObject<Item> TOOL_HOE_COPPER     = registerI("tool_hoe_copper",     () -> new ToolHoe(MaterialTool.COPPER,     1, -1.0f));
    public static final RegistryObject<Item> TOOL_HOE_BRONZE     = registerI("tool_hoe_bronze",     () -> new ToolHoe(MaterialTool.BRONZE,     2, -1.0f));
    public static final RegistryObject<Item> TOOL_HOE_STEEL      = registerI("tool_hoe_steel",      () -> new ToolHoe(MaterialTool.STEEL,      2, -1.0f));
    public static final RegistryObject<Item> TOOL_HOE_AURORITE   = registerI("tool_hoe_aurorite",   () -> new ToolHoe(MaterialTool.AURORITE,   3, -1.0f));

    // Sounds
    public static final RegistryObject<SoundEvent> SOUND_ALPACA_AMBIENT = registerS("acecraft.alpaca.ambient", () -> new SoundEvent(new ResourceLocation(AceCraft.MODID, "acecraft.alpaca.ambient")));
    public static final RegistryObject<SoundEvent> SOUND_ALPACA_HURT    = registerS("acecraft.alpaca.hurt",    () -> new SoundEvent(new ResourceLocation(AceCraft.MODID, "acecraft.alpaca.hurt")));
    public static final RegistryObject<SoundEvent> SOUND_ALPACA_DEATH   = registerS("acecraft.alpaca.death",   () -> new SoundEvent(new ResourceLocation(AceCraft.MODID, "acecraft.alpaca.death")));

    // Tile Entity
    public static final RegistryObject<BlockEntityType<BlockEntityFoundry>>    TILE_FOUNDRY    = TILES.register("foundry",    () -> BlockEntityType.Builder.of(BlockEntityFoundry::new,    MACHINA_FOUNDRY.get()).build(null));
    public static final RegistryObject<BlockEntityType<BlockEntityDistillery>> TILE_DISTILLERY = TILES.register("distillery", () -> BlockEntityType.Builder.of(BlockEntityDistillery::new, MACHINA_DISTILLERY.get()).build(null));

    // Container
    public static final RegistryObject<MenuType<MenuFoundry>>    CONTAINER_FOUNDRY    = CONTAINERS.register("foundry",    () -> IForgeMenuType.create(MenuFoundry::new));
    public static final RegistryObject<MenuType<MenuDistillery>> CONTAINER_DISTILLERY = CONTAINERS.register("distillery", () -> IForgeMenuType.create(MenuDistillery::new));

    // Structures
    // public static final RegistryObject<StructureFeature<JigsawConfiguration>> STRUCTURE_RUINED_HOUSE = register("ruined_house", new StructureRuinedHouse(JigsawConfiguration.CODEC));

    // Loot Tables
    public static final ResourceLocation ALPACA_WHITE      = new ResourceLocation(AceCraft.MODID, "entities/alpaca/white");
    public static final ResourceLocation ALPACA_ORANGE     = new ResourceLocation(AceCraft.MODID, "entities/alpaca/orange");
    public static final ResourceLocation ALPACA_MAGENTA    = new ResourceLocation(AceCraft.MODID, "entities/alpaca/magenta");
    public static final ResourceLocation ALPACA_LIGHT_BLUE = new ResourceLocation(AceCraft.MODID, "entities/alpaca/light_blue");
    public static final ResourceLocation ALPACA_YELLOW     = new ResourceLocation(AceCraft.MODID, "entities/alpaca/yellow");
    public static final ResourceLocation ALPACA_LIME       = new ResourceLocation(AceCraft.MODID, "entities/alpaca/lime");
    public static final ResourceLocation ALPACA_PINK       = new ResourceLocation(AceCraft.MODID, "entities/alpaca/pink");
    public static final ResourceLocation ALPACA_GRAY       = new ResourceLocation(AceCraft.MODID, "entities/alpaca/gray");
    public static final ResourceLocation ALPACA_LIGHT_GRAY = new ResourceLocation(AceCraft.MODID, "entities/alpaca/light_gray");
    public static final ResourceLocation ALPACA_CYAN       = new ResourceLocation(AceCraft.MODID, "entities/alpaca/cyan");
    public static final ResourceLocation ALPACA_PURPLE     = new ResourceLocation(AceCraft.MODID, "entities/alpaca/purple");
    public static final ResourceLocation ALPACA_BLUE       = new ResourceLocation(AceCraft.MODID, "entities/alpaca/blue");
    public static final ResourceLocation ALPACA_BROWN      = new ResourceLocation(AceCraft.MODID, "entities/alpaca/brown");
    public static final ResourceLocation ALPACA_GREEN      = new ResourceLocation(AceCraft.MODID, "entities/alpaca/green");
    public static final ResourceLocation ALPACA_RED        = new ResourceLocation(AceCraft.MODID, "entities/alpaca/red");
    public static final ResourceLocation ALPACA_BLACK      = new ResourceLocation(AceCraft.MODID, "entities/alpaca/black");

    // Ore Spawn
    public static Holder<PlacedFeature> SPAWN_GILIUM        = null;
    public static Holder<PlacedFeature> SPAWN_ZINC_BASE     = null;
    public static Holder<PlacedFeature> SPAWN_ZINC_DEEP     = null;
    public static Holder<PlacedFeature> SPAWN_MYTHRIL_BASE  = null;
    public static Holder<PlacedFeature> SPAWN_MYTHRIL_DEEP  = null;
    public static Holder<PlacedFeature> SPAWN_TIN_BASE      = null;
    public static Holder<PlacedFeature> SPAWN_TIN_DEEP      = null;
    public static Holder<PlacedFeature> SPAWN_AURORITE_BASE = null;
    public static Holder<PlacedFeature> SPAWN_AURORITE_DEEP = null;
    public static Holder<PlacedFeature> SPAWN_RUBY_BASE     = null;
    public static Holder<PlacedFeature> SPAWN_RUBY_DEEP     = null;
    public static Holder<PlacedFeature> SPAWN_SAPPHIRE_BASE = null;
    public static Holder<PlacedFeature> SPAWN_SAPPHIRE_DEEP = null;
    public static Holder<PlacedFeature> SPAWN_SALT_BASE     = null;
    public static Holder<PlacedFeature> SPAWN_SALT_DEEP     = null;
    public static Holder<PlacedFeature> SPAWN_SULFUR_BASE   = null;
    public static Holder<PlacedFeature> SPAWN_SULFUR_DEEP   = null;

    // Recipes
    public static RecipeType<RecipeDistillery>               RECIPE_DISTILLERY     = null;
    //public static final Lazy<RecipeDistillery> lazy = Lazy.of(() -> Registry.register(Registry.RECIPE_TYPE, typeName, new RecipeDistillery());
    public static final RegistryObject<RecipeDistillerySerializer> SERIALIZER_DISTILLERY = RECIPES.register("distilling", RecipeDistillerySerializer::new);

    // Entities
    public static final RegistryObject<EntityType<EntityAlpaca>>   ENTITY_ALPACA   = ENTITIES.register("alpaca",   () -> EntityType.Builder.of(EntityAlpaca::new,                    CREATURE).sized(0.9F, 1.3F).setTrackingRange(10).build(new ResourceLocation(AceCraft.MODID, "alpaca").toString()));
    public static final RegistryObject<EntityType<EntityDynamite>> ENTITY_DYNAMITE = null;

    // Spawn Eggs
    public static final RegistryObject<Item> SPAWNEGG_ALPACA = ITEMS.register("spawnegg_alpaca", () -> new ForgeSpawnEggItem(ENTITY_ALPACA, 12345, 67890, new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    // Structure Configurations
    /** Static instance of our structure so we can reference it and add it to biomes easily. */
    public static ConfiguredStructureFeature<?, ?> CONFIGURED_RUN_DOWN_HOUSE = null;
    // Dummy JigsawConfiguration values for now. We will modify the pool at runtime since we cannot get json pool files here at mod init.
    // You can create and register your pools in code, pass in the code create pool here, and delete both newConfig and newContext in RunDownHouseStructure's createPiecesGenerator.
    // Note: JigsawConfiguration only takes 0 - 7 size so that's another reason why we are going to bypass that "codec" by changing size at runtime to get higher sizes.





    //----------------------------------------REGISTER----------------------------------------//

    static void register(IEventBus FMLbus){
        BLOCKS.register(    FMLbus);
        ITEMS.register(     FMLbus);
        CONTAINERS.register(FMLbus);
        TILES.register(     FMLbus);
        SOUNDS.register(    FMLbus);
        ENTITIES.register(  FMLbus);
        RECIPES.register(   FMLbus);
        STRUCTURES.register(FMLbus);
    }

    // Conveniance function: Take a RegistryObject<Block> and make a corresponding RegistryObject<Item> from it
    public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
    }

    // Conveniance function: Take a RegistryObject<Block> and make a corresponding RegistryObject<Item> from it
    public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block, Item.Properties prop) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), prop));
    }

    // Conveniance function: Take a RegistryObject<Block> and make a corresponding RegistryObject<Item> from it
    public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block, CreativeModeTab CreativeModeTab) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), (new Item.Properties()).tab(CreativeModeTab) ));
    }

    static <T extends Recipe<?>> RecipeType<T> register(final String key) {
        return Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(key), new RecipeType<T>()
        {
            @Override
            public String toString()
            {
                return key;
            }
        });
    }

    public static void registerEntity(BiomeLoadingEvent event, Set<BiomeDictionary.Type> types) {
        event.getSpawns().getSpawner(CREATURE).add(new MobSpawnSettings.SpawnerData(ENTITY_ALPACA.get(), Config.ALPACA.weight.get(), Config.ALPACA.min.get(), Config.ALPACA.max.get()));
    }

    private static RegistryObject<StructureFeature<JigsawConfiguration>> register(String name, StructureFeature<JigsawConfiguration> structure){
        return STRUCTURES.register(name, () -> (structure));
    }

    private static RegistryObject<Block> registerB(String name,  java.util.function.Supplier<? extends Block> block){
        return registerB(name, block, null);
    }

    private static RegistryObject<Block> registerB(String name,  java.util.function.Supplier<? extends Block> block, CreativeModeTab CreativeModeTab){
        RegistryObject<Block> rob = BLOCKS.register(name, block);
        if(CreativeModeTab != null){ ITEMS.register(name, () -> new BlockItem(rob.get(), (new Item.Properties()).tab(CreativeModeTab))); }
        return rob;
    }

    private static RegistryObject<Item> registerI(String name, java.util.function.Supplier<? extends Item> item){
        return ITEMS.register(name, item);
    }

    private static RegistryObject<SoundEvent> registerS(String name, java.util.function.Supplier<? extends SoundEvent> sound){
        return SOUNDS.register(name, sound);
    }

    private static RegistryObject<EntityType<?>> registerE(String name, java.util.function.Supplier<? extends EntityType<?>> entity){
        return ENTITIES.register(name, entity);
    }

    //public static PlacedFeature buildOreSpawn(String name, BlockState state, int veinSize, int maxHeight, int spawnRate, RuleTest replacables) {
//
    //    List<OreConfiguration.TargetBlockState> TARGETLIST = List.of(OreConfiguration.target(replacables, state));
    //    ConfiguredFeature<?, ?> FEATURE = FeatureUtils.register(name, Feature.ORE.configured(new OreConfiguration(TARGETLIST, veinSize)));
    //    PlacedFeature PLACED = PlacementUtils.register(name, FEATURE.placed(commonOrePlacement(spawnRate, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(maxHeight)))));
    //    return PLACED;
    //}

    public static void registerStructureConfigs(){
        //CONFIGURED_RUN_DOWN_HOUSE = ShopKeeper.STRUCTURE_RUINED_HOUSE.get().configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));
    }

    public static void registerOreSpawn(){
        SPAWN_GILIUM        = SystemRegister.buildOreSpawn("ore_gilium",        ShopKeeper.ORE_GILIUM.get().defaultBlockState(),        Config.GILIUM.veinSize.get(),        0, Config.GILIUM.maxHeight.get(),        Config.GILIUM.spawnRate.get(),        OreFeatures.NETHER_ORE_REPLACEABLES,    true);
        SPAWN_ZINC_BASE     = SystemRegister.buildOreSpawn("ore_zinc_base",     ShopKeeper.ORE_ZINC_BASE.get().defaultBlockState(),     Config.ZINC_BASE.veinSize.get(),     0, Config.ZINC_BASE.maxHeight.get(),     Config.ZINC_BASE.spawnRate.get(),     OreFeatures.STONE_ORE_REPLACEABLES,     true);
        SPAWN_ZINC_DEEP     = SystemRegister.buildOreSpawn("ore_zinc_deep",     ShopKeeper.ORE_ZINC_DEEP.get().defaultBlockState(),     Config.ZINC_DEEP.veinSize.get(),     0, Config.ZINC_DEEP.maxHeight.get(),     Config.ZINC_DEEP.spawnRate.get(),     OreFeatures.DEEPSLATE_ORE_REPLACEABLES, true);
        SPAWN_MYTHRIL_BASE  = SystemRegister.buildOreSpawn("ore_mythril_base",  ShopKeeper.ORE_MYTHRIL_BASE.get().defaultBlockState(),  Config.MYTHRIL_BASE.veinSize.get(),  0, Config.MYTHRIL_BASE.maxHeight.get(),  Config.MYTHRIL_BASE.spawnRate.get(),  OreFeatures.STONE_ORE_REPLACEABLES,     true);
        SPAWN_MYTHRIL_DEEP  = SystemRegister.buildOreSpawn("ore_mythril_deep",  ShopKeeper.ORE_MYTHRIL_DEEP.get().defaultBlockState(),  Config.MYTHRIL_DEEP.veinSize.get(),  0, Config.MYTHRIL_DEEP.maxHeight.get(),  Config.MYTHRIL_DEEP.spawnRate.get(),  OreFeatures.DEEPSLATE_ORE_REPLACEABLES, true);
        SPAWN_TIN_BASE      = SystemRegister.buildOreSpawn("ore_tin_base",      ShopKeeper.ORE_TIN_BASE.get().defaultBlockState(),      Config.TIN_BASE.veinSize.get(),      0, Config.TIN_BASE.maxHeight.get(),      Config.TIN_BASE.spawnRate.get(),      OreFeatures.STONE_ORE_REPLACEABLES,     true);
        SPAWN_TIN_DEEP      = SystemRegister.buildOreSpawn("ore_tin_deep",      ShopKeeper.ORE_TIN_DEEP.get().defaultBlockState(),      Config.TIN_DEEP.veinSize.get(),      0, Config.TIN_DEEP.maxHeight.get(),      Config.TIN_DEEP.spawnRate.get(),      OreFeatures.DEEPSLATE_ORE_REPLACEABLES, true);
        SPAWN_AURORITE_BASE = SystemRegister.buildOreSpawn("ore_aurorite_base", ShopKeeper.ORE_AURORITE_BASE.get().defaultBlockState(), Config.AURORITE_BASE.veinSize.get(), 0, Config.AURORITE_BASE.maxHeight.get(), Config.AURORITE_BASE.spawnRate.get(), OreFeatures.STONE_ORE_REPLACEABLES,     true);
        SPAWN_AURORITE_DEEP = SystemRegister.buildOreSpawn("ore_aurorite_deep", ShopKeeper.ORE_AURORITE_DEEP.get().defaultBlockState(), Config.AURORITE_DEEP.veinSize.get(), 0, Config.AURORITE_DEEP.maxHeight.get(), Config.AURORITE_DEEP.spawnRate.get(), OreFeatures.DEEPSLATE_ORE_REPLACEABLES, true);
        SPAWN_RUBY_BASE     = SystemRegister.buildOreSpawn("ore_ruby_base",     ShopKeeper.ORE_RUBY_BASE.get().defaultBlockState(),     Config.RUBY_BASE.veinSize.get(),     0, Config.RUBY_BASE.maxHeight.get(),     Config.RUBY_BASE.spawnRate.get(),     OreFeatures.STONE_ORE_REPLACEABLES,     true);
        SPAWN_RUBY_DEEP     = SystemRegister.buildOreSpawn("ore_ruby_deep",     ShopKeeper.ORE_RUBY_DEEP.get().defaultBlockState(),     Config.RUBY_DEEP.veinSize.get(),     0, Config.RUBY_DEEP.maxHeight.get(),     Config.RUBY_DEEP.spawnRate.get(),     OreFeatures.DEEPSLATE_ORE_REPLACEABLES, true);
        SPAWN_SAPPHIRE_BASE = SystemRegister.buildOreSpawn("ore_sapphire_base", ShopKeeper.ORE_SAPPHIRE_BASE.get().defaultBlockState(), Config.SAPPHIRE_BASE.veinSize.get(), 0, Config.SAPPHIRE_BASE.maxHeight.get(), Config.SAPPHIRE_BASE.spawnRate.get(), OreFeatures.STONE_ORE_REPLACEABLES,     true);
        SPAWN_SAPPHIRE_DEEP = SystemRegister.buildOreSpawn("ore_sapphire_deep", ShopKeeper.ORE_SAPPHIRE_DEEP.get().defaultBlockState(), Config.SAPPHIRE_DEEP.veinSize.get(), 0, Config.SAPPHIRE_DEEP.maxHeight.get(), Config.SAPPHIRE_DEEP.spawnRate.get(), OreFeatures.DEEPSLATE_ORE_REPLACEABLES, true);
        SPAWN_SALT_BASE     = SystemRegister.buildOreSpawn("ore_salt_base",     ShopKeeper.ORE_SALT_BASE.get().defaultBlockState(),     Config.SALT_BASE.veinSize.get(),     0, Config.SALT_BASE.maxHeight.get(),     Config.SALT_BASE.spawnRate.get(),     OreFeatures.STONE_ORE_REPLACEABLES,     false);
        SPAWN_SALT_DEEP     = SystemRegister.buildOreSpawn("ore_salt_deep",     ShopKeeper.ORE_SALT_DEEP.get().defaultBlockState(),     Config.SALT_DEEP.veinSize.get(),     0, Config.SALT_DEEP.maxHeight.get(),     Config.SALT_DEEP.spawnRate.get(),     OreFeatures.DEEPSLATE_ORE_REPLACEABLES, false);
        SPAWN_SULFUR_BASE   = SystemRegister.buildOreSpawn("ore_sulfur_base",   ShopKeeper.ORE_SULFUR_BASE.get().defaultBlockState(),   Config.SULFUR_BASE.veinSize.get(),   0, Config.SULFUR_BASE.maxHeight.get(),   Config.SULFUR_BASE.spawnRate.get(),   OreFeatures.STONE_ORE_REPLACEABLES,     false);
        SPAWN_SULFUR_DEEP   = SystemRegister.buildOreSpawn("ore_sulfur_deep",   ShopKeeper.ORE_SULFUR_DEEP.get().defaultBlockState(),   Config.SULFUR_DEEP.veinSize.get(),   0, Config.SULFUR_DEEP.maxHeight.get(),   Config.SULFUR_DEEP.spawnRate.get(),   OreFeatures.DEEPSLATE_ORE_REPLACEABLES, false);


    }

    private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    private static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }





    //----------------------------------------SETUP----------------------------------------//

    static void setup(FMLCommonSetupEvent event){

        generateTradeData();

        /**
         * Here, setupStructures will be ran after registration of all structures are finished.
         * This is important to be done here so that the Deferred Registry has already ran and
         * registered/created our structure for us.
         *
         * Once after that structure instance is made, we then can now do the rest of the setup
         * that requires a structure instance such as setting the structure spacing, creating the
         * configured structure instance, and more.
         */
        //event.enqueueWork(() -> {
        //    setupStructures();
        //    registerConfiguredStructures();
        //});
    }

    @OnlyIn(Dist.CLIENT)
    static void setup(FMLClientSetupEvent event){
        ItemBlockRenderTypes.setRenderLayer(CROP_CABBAGE.get(),    RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CROP_CORN.get(),       RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CROP_CUCUMBER.get(),   RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CROP_EGGPLANT.get(),   RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CROP_GRAPES.get(),     RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CROP_ONION.get(),      RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CROP_PINEAPPLE.get(),  RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CROP_STRAWBERRY.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CROP_TOMATO.get(),     RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CROP_TURNIP.get(),     RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CROP_RICE.get(),       RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CROP_COFFEE.get(),     RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(CROP_HEMP.get(),       RenderType.cutout());
        MenuScreens.register(CONTAINER_FOUNDRY.get(),    ScreenFoundry::new);
        MenuScreens.register(CONTAINER_DISTILLERY.get(), ScreenDistillery::new);
    }

    /**
     * This is where we set the rarity of your structures and determine if land conforms to it.
     * See the comments in below for more details.
     */
    public static void setupStructures() {
        //SystemStructures.setupMapSpacingAndLand(STRUCTURE_RUINED_HOUSE.get(), 10, 5, 1234567890, true);
        // Add more structures here and so on
    }

    /**
     * Registers the configured structure which is what gets added to the biomes.
     * Noticed we are not using a forge registry because there is none for configured structures.
     * We can register configured structures at any time before a world is clicked on and made.
     * But the best time to register configured features by code is honestly to do it in FMLCommonSetupEvent.
     */
    public static void registerConfiguredStructures() {
        Registry<ConfiguredStructureFeature<?, ?>> registry = BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE;
        Registry.register(registry, new ResourceLocation(AceCraft.MODID, "configured_run_down_house"), CONFIGURED_RUN_DOWN_HOUSE);
    }

    public static void generateTradeData(){
        SystemTrades.addTradeToProfession(VillagerProfession.ARMORER, 1, new VillagerTrades.ItemListing[]{
                new SystemTrades.ItemsForGems(ARMOR_HELMET_COPPER.get(),  5,1,12,1, 0.2f),
                new SystemTrades.ItemsForGems(ARMOR_PLATE_COPPER.get(),   9,1,12,1, 0.2f),
                new SystemTrades.ItemsForGems(ARMOR_LEGGINGS_COPPER.get(),7,1,12,1, 0.2f),
                new SystemTrades.ItemsForGems(ARMOR_BOOTS_COPPER.get(),   4,1,12,1, 0.2f)
        });
        SystemTrades.addTradeToProfession(VillagerProfession.BUTCHER, 2, new VillagerTrades.ItemListing[]{
                new SystemTrades.ItemsForGems(FOOD_VICUGNA_COOKED.get(), 1, 2, 16,5, 0.05f),
                new SystemTrades.GemsForItems(FOOD_VICUGNA_RAW.get(),    7, 16, 20, 0.05f)
        });
        SystemTrades.addTradeToProfession(VillagerProfession.FARMER, 1, new VillagerTrades.ItemListing[]{
                new SystemTrades.ItemsForGems(FOOD_TURNIP.get(),  1,15,16,2, 0.05f)
        });
        SystemTrades.addTradeToProfession(VillagerProfession.TOOLSMITH, 1, new VillagerTrades.ItemListing[]{
                new SystemTrades.ItemsForGems(TOOL_AXE_COPPER.get(),     1,1,12,1, 0.2f),
                new SystemTrades.ItemsForGems(TOOL_SHOVEL_COPPER.get(),  1,1,12,1, 0.2f),
                new SystemTrades.ItemsForGems(TOOL_PICKAXE_COPPER.get(), 1,1,12,1, 0.2f),
                new SystemTrades.ItemsForGems(TOOL_HOE_COPPER.get(),     1,1,12,1, 0.2f)
        });
        SystemTrades.addTradeToProfession(VillagerProfession.WEAPONSMITH, 1, new VillagerTrades.ItemListing[]{
                new SystemTrades.ItemsForGems(TOOL_SWORD_COPPER.get(),     3,1,12,1, 0.2f)
        });
    }



}
