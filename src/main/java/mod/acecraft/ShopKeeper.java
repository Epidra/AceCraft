package mod.acecraft;

import mod.acecraft.blocks.*;
import mod.acecraft.container.ContainerDistillery;
import mod.acecraft.container.ContainerFoundry;
import mod.acecraft.crafting.*;
import mod.acecraft.entity.*;
import mod.acecraft.render.RenderAlpaca;
import mod.acecraft.render.RenderDynamite;
import mod.acecraft.render.RenderNugget;
import mod.acecraft.render.RenderSpear;
import mod.acecraft.items.*;
import mod.acecraft.screen.ScreenDistillery;
import mod.acecraft.screen.ScreenFoundry;
import mod.acecraft.tileentities.*;
import mod.acecraft.util.*;
import mod.lucky77.blocks.BlockBlock;
import mod.lucky77.items.ItemFood;
import mod.lucky77.items.ItemItem;
import mod.lucky77.util.BiomeDictionaryHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import net.minecraft.potion.Effects;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;

import static mod.acecraft.AceCraft.MODID;

@SuppressWarnings({"unused", "deprecation"})
public class ShopKeeper {

    private static final DeferredRegister<Block>                BLOCKS     = DeferredRegister.create(ForgeRegistries.BLOCKS,             MODID);
    private static final DeferredRegister<Item>                 ITEMS      = DeferredRegister.create(ForgeRegistries.ITEMS,              MODID);
    private static final DeferredRegister<ContainerType<?>>     CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS,         MODID);
    private static final DeferredRegister<TileEntityType<?>>    TILES      = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES,      MODID);
    private static final DeferredRegister<SoundEvent>           SOUNDS     = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS,       MODID);
    private static final DeferredRegister<EntityType<?>>        ENTITIES   = DeferredRegister.create(ForgeRegistries.ENTITIES,           MODID);
    private static final DeferredRegister<IRecipeSerializer<?>> RECIPES    = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, MODID);




    // Blocks
    public static final RegistryObject<Block> BLOCK_COPPER     = register("block_copper",     new BlockBlock(Blocks.IRON_BLOCK),    ItemGroup.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_MYTHRIL    = register("block_mythril",    new BlockBlock(Blocks.IRON_BLOCK),    ItemGroup.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_GILIUM     = register("block_gilium",     new BlockBlock(Blocks.IRON_BLOCK),    ItemGroup.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_TIN        = register("block_tin",        new BlockBlock(Blocks.IRON_BLOCK),    ItemGroup.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_ZINC       = register("block_zinc",       new BlockBlock(Blocks.IRON_BLOCK),    ItemGroup.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_BRONZE     = register("block_bronze",     new BlockBlock(Blocks.IRON_BLOCK),    ItemGroup.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_BRASS      = register("block_brass",      new BlockBlock(Blocks.IRON_BLOCK),    ItemGroup.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_STEEL      = register("block_steel",      new BlockBlock(Blocks.IRON_BLOCK),    ItemGroup.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_ORICHALCUM = register("block_orichalcum", new BlockBlock(Blocks.IRON_BLOCK),    ItemGroup.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_ADAMANTIUM = register("block_adamantium", new BlockBlock(Blocks.IRON_BLOCK),    ItemGroup.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_SALT       = register("block_salt",       new BlockBlock(Blocks.SAND),          ItemGroup.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_SULFUR     = register("block_sulfur",     new BlockBlock(Blocks.SAND),          ItemGroup.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_RUBY       = register("block_ruby",       new BlockBlock(Blocks.DIAMOND_BLOCK), ItemGroup.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_SAPPHIRE   = register("block_sapphire",   new BlockBlock(Blocks.DIAMOND_BLOCK), ItemGroup.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_AURORITE   = register("block_aurorite",   new BlockBlock(Blocks.DIAMOND_BLOCK), ItemGroup.TAB_BUILDING_BLOCKS);

    // Ore
    public static final RegistryObject<Block> ORE_COPPER   = register("ore_copper",   new BlockBlock(Blocks.IRON_ORE),    ItemGroup.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_MYTHRIL  = register("ore_mythril",  new BlockBlock(Blocks.IRON_ORE),    ItemGroup.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_GILIUM   = register("ore_gilium",   new BlockBlock(Blocks.IRON_ORE),    ItemGroup.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_TIN      = register("ore_tin",      new BlockBlock(Blocks.IRON_ORE),    ItemGroup.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_ZINC     = register("ore_zinc",     new BlockBlock(Blocks.IRON_ORE),    ItemGroup.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_SALT     = register("ore_salt",     new BlockBlock(Blocks.LAPIS_ORE),   ItemGroup.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_SULFUR   = register("ore_sulfur",   new BlockBlock(Blocks.LAPIS_ORE),   ItemGroup.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_RUBY     = register("ore_ruby",     new BlockBlock(Blocks.DIAMOND_ORE), ItemGroup.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_SAPPHIRE = register("ore_sapphire", new BlockBlock(Blocks.DIAMOND_ORE), ItemGroup.TAB_BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_AURORITE = register("ore_aurorite", new BlockBlock(Blocks.DIAMOND_ORE), ItemGroup.TAB_BUILDING_BLOCKS);

    // Nuggets
    public static final RegistryObject<Item> NUGGET_IRON    = register("nugget_iron",    new ItemNugget());
    public static final RegistryObject<Item> NUGGET_GOLD    = register("nugget_gold",    new ItemNugget());
    public static final RegistryObject<Item> NUGGET_COPPER  = register("nugget_copper",  new ItemNugget());
    public static final RegistryObject<Item> NUGGET_MYTHRIL = register("nugget_mythril", new ItemNugget());
    public static final RegistryObject<Item> NUGGET_GILIUM  = register("nugget_gilium",  new ItemNugget());
    public static final RegistryObject<Item> NUGGET_TIN     = register("nugget_tin",     new ItemNugget());
    public static final RegistryObject<Item> NUGGET_ZINC    = register("nugget_zinc",    new ItemNugget());

    // Ingot
    public static final RegistryObject<Item> INGOT_COPPER     = register("ingot_copper",     new ItemItem(ItemGroup.TAB_MATERIALS));
    public static final RegistryObject<Item> INGOT_MYTHRIL    = register("ingot_mythril",    new ItemItem(ItemGroup.TAB_MATERIALS));
    public static final RegistryObject<Item> INGOT_GILIUM     = register("ingot_gilium",     new ItemItem(ItemGroup.TAB_MATERIALS));
    public static final RegistryObject<Item> INGOT_TIN        = register("ingot_tin",        new ItemItem(ItemGroup.TAB_MATERIALS));
    public static final RegistryObject<Item> INGOT_ZINC       = register("ingot_zinc",       new ItemItem(ItemGroup.TAB_MATERIALS));
    public static final RegistryObject<Item> INGOT_BRONZE     = register("ingot_bronze",     new ItemItem(ItemGroup.TAB_MATERIALS));
    public static final RegistryObject<Item> INGOT_BRASS      = register("ingot_brass",      new ItemItem(ItemGroup.TAB_MATERIALS));
    public static final RegistryObject<Item> INGOT_STEEL      = register("ingot_steel",      new ItemItem(ItemGroup.TAB_MATERIALS));
    public static final RegistryObject<Item> INGOT_ORICHALCUM = register("ingot_orichalcum", new ItemItem(ItemGroup.TAB_MATERIALS));
    public static final RegistryObject<Item> INGOT_ADAMANTIUM = register("ingot_adamantium", new ItemItem(ItemGroup.TAB_MATERIALS));

    // Stuff
    public static final RegistryObject<Item> STUFF_SALT     = register("stuff_salt",     new ItemItem(ItemGroup.TAB_MISC));
    public static final RegistryObject<Item> STUFF_SULFUR   = register("stuff_sulfur",   new ItemItem(ItemGroup.TAB_MISC));
    public static final RegistryObject<Item> STUFF_RICE     = register("stuff_rice",     new ItemItem(ItemGroup.TAB_MISC));
    public static final RegistryObject<Item> STUFF_COFFEE   = register("stuff_coffee",   new ItemItem(ItemGroup.TAB_MISC));
    public static final RegistryObject<Item> STUFF_HEMP     = register("stuff_hemp",     new ItemItem(ItemGroup.TAB_MISC));
    public static final RegistryObject<Item> STUFF_ROPE     = register("stuff_rope",     new ItemItem(ItemGroup.TAB_MISC));
    public static final RegistryObject<Item> STUFF_SLAG     = register("stuff_slag",     new ItemItem(ItemGroup.TAB_MISC));
    public static final RegistryObject<Item> STUFF_RUBY     = register("stuff_ruby",     new ItemItem(ItemGroup.TAB_MISC));
    public static final RegistryObject<Item> STUFF_SAPPHIRE = register("stuff_sapphire", new ItemItem(ItemGroup.TAB_MISC));
    public static final RegistryObject<Item> STUFF_AURORITE = register("stuff_aurorite", new ItemItem(ItemGroup.TAB_MISC));

    // Food
    public static final RegistryObject<Item> FOOD_CABBAGE        = register("food_cabbage",        new ItemFood(1, 1, false));
    public static final RegistryObject<Item> FOOD_CORN           = register("food_corn",           new ItemFood(1, 1, false));
    public static final RegistryObject<Item> FOOD_CUCUMBER       = register("food_cucumber",       new ItemFood(1, 1, false));
    public static final RegistryObject<Item> FOOD_EGGPLANT       = register("food_eggplant",       new ItemFood(1, 1, false));
    public static final RegistryObject<Item> FOOD_GRAPES         = register("food_grapes",         new ItemFood(1, 1, false));
    public static final RegistryObject<Item> FOOD_ONION          = register("food_onion",          new ItemFood(1, 1, false));
    public static final RegistryObject<Item> FOOD_PINEAPPLE      = register("food_pineapple",      new ItemFood(1, 1, false));
    public static final RegistryObject<Item> FOOD_STRAWBERRY     = register("food_strawberry",     new ItemFood(1, 1, false));
    public static final RegistryObject<Item> FOOD_TOMATO         = register("food_tomato",         new ItemFood(1, 1, false));
    public static final RegistryObject<Item> FOOD_TURNIP         = register("food_turnip",         new ItemFood(1, 1, false));
    public static final RegistryObject<Item> FOOD_VICUGNA_RAW    = register("food_vicugna_raw",    new ItemFood(1, 1, true));
    public static final RegistryObject<Item> FOOD_VICUGNA_COOKED = register("food_vicugna_cooked", new ItemFood(1, 1, true));

    // Liquor
    public static final RegistryObject<Item> LIQUOR_COFFEE    = register("liquor_coffee",    new ItemLiquor(Effects.DIG_SPEED,    1.0f, Effects.HUNGER, 0.8f));
    public static final RegistryObject<Item> LIQUOR_MOONSHINE = register("liquor_moonshine", new ItemLiquor(Effects.DAMAGE_BOOST, 0.3f, Effects.CONFUSION, 0.3f));
    public static final RegistryObject<Item> LIQUOR_RUM       = register("liquor_rum",       new ItemLiquor(Effects.DAMAGE_BOOST, 0.3f, Effects.CONFUSION, 0.3f));
    public static final RegistryObject<Item> LIQUOR_SAKE      = register("liquor_sake",      new ItemLiquor(Effects.DAMAGE_BOOST, 0.3f, Effects.CONFUSION, 0.3f));
    public static final RegistryObject<Item> LIQUOR_SALGAM    = register("liquor_salgam",    new ItemLiquor(Effects.DAMAGE_BOOST, 0.3f, Effects.CONFUSION, 0.3f));
    public static final RegistryObject<Item> LIQUOR_VODKA     = register("liquor_vodka",     new ItemLiquor(Effects.DAMAGE_BOOST, 0.3f, Effects.CONFUSION, 0.3f));
    public static final RegistryObject<Item> LIQUOR_WHISKY    = register("liquor_whisky",    new ItemLiquor(Effects.DAMAGE_BOOST, 0.3f, Effects.CONFUSION, 0.3f));
    public static final RegistryObject<Item> LIQUOR_BRANDY    = register("liquor_brandy",    new ItemLiquor(Effects.DAMAGE_BOOST, 0.3f, Effects.CONFUSION, 0.3f));
    public static final RegistryObject<Item> LIQUOR_OIL       = register("liquor_oil",       new ItemLiquor(Effects.WITHER,   1.0f, Effects.HUNGER, 1.0f));

    // Crop
    public static final RegistryObject<Block> CROP_CABBAGE    = register("crop_cabbage",    new BlockCrop("cabbage",   Blocks.WHEAT));
    public static final RegistryObject<Block> CROP_CORN       = register("crop_corn",       new BlockCrop("corn",      Blocks.WHEAT));
    public static final RegistryObject<Block> CROP_CUCUMBER   = register("crop_cucumber",   new BlockCrop("cucumber",  Blocks.WHEAT));
    public static final RegistryObject<Block> CROP_EGGPLANT   = register("crop_eggplant",   new BlockCrop("eggplant",  Blocks.WHEAT));
    public static final RegistryObject<Block> CROP_GRAPES     = register("crop_grapes",     new BlockCrop("grapes",    Blocks.WHEAT));
    public static final RegistryObject<Block> CROP_ONION      = register("crop_onion",      new BlockCrop("onion",     Blocks.WHEAT));
    public static final RegistryObject<Block> CROP_PINEAPPLE  = register("crop_pineapple",  new BlockCrop("pineapple", Blocks.WHEAT));
    public static final RegistryObject<Block> CROP_STRAWBERRY = register("crop_strawberry", new BlockCrop("strawberry",Blocks.WHEAT));
    public static final RegistryObject<Block> CROP_TOMATO     = register("crop_tomato",     new BlockCrop("tomato",    Blocks.WHEAT));
    public static final RegistryObject<Block> CROP_TURNIP     = register("crop_turnip",     new BlockCrop("turnip",    Blocks.WHEAT));
    public static final RegistryObject<Block> CROP_RICE       = register("crop_rice",       new BlockCrop("rice",      Blocks.WHEAT));
    public static final RegistryObject<Block> CROP_COFFEE     = register("crop_coffee",     new BlockCrop("coffee",    Blocks.WHEAT));
    public static final RegistryObject<Block> CROP_HEMP       = register("crop_hemp",       new BlockCrop("hemp",      Blocks.WHEAT));

    // Seeds
    public static final RegistryObject<Item> SEED_CABBAGE    = register("seeds_cabbage",    new ItemSeed("cabbage"   ));
    public static final RegistryObject<Item> SEED_CORN       = register("seeds_corn",       new ItemSeed("corn"      ));
    public static final RegistryObject<Item> SEED_CUCUMBER   = register("seeds_cucumber",   new ItemSeed("cucumber"  ));
    public static final RegistryObject<Item> SEED_EGGPLANT   = register("seeds_eggplant",   new ItemSeed("eggplant"  ));
    public static final RegistryObject<Item> SEED_GRAPES     = register("seeds_grapes",     new ItemSeed("grapes"    ));
    public static final RegistryObject<Item> SEED_ONION      = register("seeds_onion",      new ItemSeed("onion"     ));
    public static final RegistryObject<Item> SEED_PINEAPPLE  = register("seeds_pineapple",  new ItemSeed("pineapple" ));
    public static final RegistryObject<Item> SEED_STRAWBERRY = register("seeds_strawberry", new ItemSeed("strawberry"));
    public static final RegistryObject<Item> SEED_TOMATO     = register("seeds_tomato",     new ItemSeed("tomato"    ));
    public static final RegistryObject<Item> SEED_TURNIP     = register("seeds_turnip",     new ItemSeed("turnip"    ));
    public static final RegistryObject<Item> SEED_RICE       = register("seeds_rice",       new ItemSeed("rice"      ));
    public static final RegistryObject<Item> SEED_COFFEE     = register("seeds_coffee",     new ItemSeed("coffee"    ));
    public static final RegistryObject<Item> SEED_HEMP       = register("seeds_hemp",       new ItemSeed("hemp"      ));

    // Machina
    public static final RegistryObject<Block> MACHINA_GLOBE        = register("machina_globe",        new BlockGlobe(),        ItemGroup.TAB_DECORATIONS);
    public static final RegistryObject<Block> MACHINA_FOUNDRY      = register("machina_foundry",      new BlockFoundry(),      ItemGroup.TAB_DECORATIONS);
    public static final RegistryObject<Block> MACHINA_DISTILLERY   = register("machina_distillery",   new BlockDistillery(),   ItemGroup.TAB_DECORATIONS);
    public static final RegistryObject<Block> MACHINA_COOKINGBOARD = register("machina_cookingboard", new BlockCookingBoard(), ItemGroup.TAB_DECORATIONS);
    public static final RegistryObject<Block> MACHINA_KEG          = register("machina_keg",          new BlockKeg(),          ItemGroup.TAB_DECORATIONS);
    public static final RegistryObject<Block> MACHINA_ANCHOR       = register("machina_anchor",       new BlockAnchor(),       ItemGroup.TAB_DECORATIONS);
    public static final RegistryObject<Block> MACHINA_ROPE         = register("machina_rope",         new BlockRope(),         ItemGroup.TAB_DECORATIONS);

    // Armor Boots
    public static final RegistryObject<Item> ARMOR_BOOTS_GILIUM     = register("armor_boots_gilium",     new ItemArmor(     MaterialArmor.GILIUM,     EquipmentSlotType.FEET));
    public static final RegistryObject<Item> ARMOR_BOOTS_ADAMANTIUM = register("armor_boots_adamantium", new ItemArmor(     MaterialArmor.ADAMANTIUM, EquipmentSlotType.FEET));
    public static final RegistryObject<Item> ARMOR_BOOTS_MYTHRIL    = register("armor_boots_mythril",    new ItemArmor(     MaterialArmor.MYTHRIL,    EquipmentSlotType.FEET));
    public static final RegistryObject<Item> ARMOR_BOOTS_ORICHALCUM = register("armor_boots_orichalcum", new ItemArmor(     MaterialArmor.ORICHALCUM, EquipmentSlotType.FEET));
    public static final RegistryObject<Item> ARMOR_BOOTS_COPPER     = register("armor_boots_copper",     new ItemArmor(     MaterialArmor.COPPER,     EquipmentSlotType.FEET));
    public static final RegistryObject<Item> ARMOR_BOOTS_BRONZE     = register("armor_boots_bronze",     new ItemArmor(     MaterialArmor.BRONZE,     EquipmentSlotType.FEET));
    public static final RegistryObject<Item> ARMOR_BOOTS_STEEL      = register("armor_boots_steel",      new ItemArmor(     MaterialArmor.STEEL,      EquipmentSlotType.FEET));
    public static final RegistryObject<Item> ARMOR_BOOTS_AURORITE   = register("armor_boots_aurorite",   new ItemArmorColor(MaterialArmor.AURORITE,   EquipmentSlotType.FEET));

    // Armor Chestplate
    public static final RegistryObject<Item> ARMOR_PLATE_GILIUM     = register("armor_plate_gilium",     new ItemArmor(     MaterialArmor.GILIUM,     EquipmentSlotType.CHEST));
    public static final RegistryObject<Item> ARMOR_PLATE_ADAMANTIUM = register("armor_plate_adamantium", new ItemArmor(     MaterialArmor.ADAMANTIUM, EquipmentSlotType.CHEST));
    public static final RegistryObject<Item> ARMOR_PLATE_MYTHRIL    = register("armor_plate_mythril",    new ItemArmor(     MaterialArmor.MYTHRIL,    EquipmentSlotType.CHEST));
    public static final RegistryObject<Item> ARMOR_PLATE_ORICHALCUM = register("armor_plate_orichalcum", new ItemArmor(     MaterialArmor.ORICHALCUM, EquipmentSlotType.CHEST));
    public static final RegistryObject<Item> ARMOR_PLATE_COPPER     = register("armor_plate_copper",     new ItemArmor(     MaterialArmor.COPPER,     EquipmentSlotType.CHEST));
    public static final RegistryObject<Item> ARMOR_PLATE_BRONZE     = register("armor_plate_bronze",     new ItemArmor(     MaterialArmor.BRONZE,     EquipmentSlotType.CHEST));
    public static final RegistryObject<Item> ARMOR_PLATE_STEEL      = register("armor_plate_steel",      new ItemArmor(     MaterialArmor.STEEL,      EquipmentSlotType.CHEST));
    public static final RegistryObject<Item> ARMOR_PLATE_AURORITE   = register("armor_plate_aurorite",   new ItemArmorColor(MaterialArmor.AURORITE,   EquipmentSlotType.CHEST));

    // Armor Leggings
    public static final RegistryObject<Item> ARMOR_LEGGINGS_GILIUM     = register("armor_leggings_gilium",     new ItemArmor(     MaterialArmor.GILIUM,     EquipmentSlotType.LEGS));
    public static final RegistryObject<Item> ARMOR_LEGGINGS_ADAMANTIUM = register("armor_leggings_adamantium", new ItemArmor(     MaterialArmor.ADAMANTIUM, EquipmentSlotType.LEGS));
    public static final RegistryObject<Item> ARMOR_LEGGINGS_MYTHRIL    = register("armor_leggings_mythril",    new ItemArmor(     MaterialArmor.MYTHRIL,    EquipmentSlotType.LEGS));
    public static final RegistryObject<Item> ARMOR_LEGGINGS_ORICHALCUM = register("armor_leggings_orichalcum", new ItemArmor(     MaterialArmor.ORICHALCUM, EquipmentSlotType.LEGS));
    public static final RegistryObject<Item> ARMOR_LEGGINGS_COPPER     = register("armor_leggings_copper",     new ItemArmor(     MaterialArmor.COPPER,     EquipmentSlotType.LEGS));
    public static final RegistryObject<Item> ARMOR_LEGGINGS_BRONZE     = register("armor_leggings_bronze",     new ItemArmor(     MaterialArmor.BRONZE,     EquipmentSlotType.LEGS));
    public static final RegistryObject<Item> ARMOR_LEGGINGS_STEEL      = register("armor_leggings_steel",      new ItemArmor(     MaterialArmor.STEEL,      EquipmentSlotType.LEGS));
    public static final RegistryObject<Item> ARMOR_LEGGINGS_AURORITE   = register("armor_leggings_aurorite",   new ItemArmorColor(MaterialArmor.AURORITE,   EquipmentSlotType.LEGS));

    // Armor Helmet
    public static final RegistryObject<Item> ARMOR_HELMET_GILIUM     = register("armor_helmet_gilium",     new ItemArmor(     MaterialArmor.GILIUM,     EquipmentSlotType.HEAD));
    public static final RegistryObject<Item> ARMOR_HELMET_ADAMANTIUM = register("armor_helmet_adamantium", new ItemArmor(     MaterialArmor.ADAMANTIUM, EquipmentSlotType.HEAD));
    public static final RegistryObject<Item> ARMOR_HELMET_MYTHRIL    = register("armor_helmet_mythril",    new ItemArmor(     MaterialArmor.MYTHRIL,    EquipmentSlotType.HEAD));
    public static final RegistryObject<Item> ARMOR_HELMET_ORICHALCUM = register("armor_helmet_orichalcum", new ItemArmor(     MaterialArmor.ORICHALCUM, EquipmentSlotType.HEAD));
    public static final RegistryObject<Item> ARMOR_HELMET_COPPER     = register("armor_helmet_copper",     new ItemArmor(     MaterialArmor.COPPER,     EquipmentSlotType.HEAD));
    public static final RegistryObject<Item> ARMOR_HELMET_BRONZE     = register("armor_helmet_bronze",     new ItemArmor(     MaterialArmor.BRONZE,     EquipmentSlotType.HEAD));
    public static final RegistryObject<Item> ARMOR_HELMET_STEEL      = register("armor_helmet_steel",      new ItemArmor(     MaterialArmor.STEEL,      EquipmentSlotType.HEAD));
    public static final RegistryObject<Item> ARMOR_HELMET_AURORITE   = register("armor_helmet_aurorite",   new ItemArmorColor(MaterialArmor.AURORITE,   EquipmentSlotType.HEAD));

    // Tool Sword
    public static final RegistryObject<Item> TOOL_SWORD_GILIUM     = register("tool_sword_gilium",     new ToolSword(MaterialTool.GILIUM,     2, -1.0f));
    public static final RegistryObject<Item> TOOL_SWORD_ADAMANTIUM = register("tool_sword_adamantium", new ToolSword(MaterialTool.ADAMANTIUM, 3, -1.0f));
    public static final RegistryObject<Item> TOOL_SWORD_MYTHRIL    = register("tool_sword_mythril",    new ToolSword(MaterialTool.MYTHRIL,    2, -1.0f));
    public static final RegistryObject<Item> TOOL_SWORD_ORICHALCUM = register("tool_sword_orichalcum", new ToolSword(MaterialTool.ORICHALCUM, 3, -1.0f));
    public static final RegistryObject<Item> TOOL_SWORD_COPPER     = register("tool_sword_copper",     new ToolSword(MaterialTool.COPPER,     1, -1.0f));
    public static final RegistryObject<Item> TOOL_SWORD_BRONZE     = register("tool_sword_bronze",     new ToolSword(MaterialTool.BRONZE,     2, -1.0f));
    public static final RegistryObject<Item> TOOL_SWORD_STEEL      = register("tool_sword_steel",      new ToolSword(MaterialTool.STEEL,      2, -1.0f));
    public static final RegistryObject<Item> TOOL_SWORD_AURORITE   = register("tool_sword_aurorite",   new ToolSword(MaterialTool.AURORITE,   3, -1.0f));

    // Tool Spear
    public static final RegistryObject<Item> TOOL_SPEAR_GILIUM     = register("tool_spear_gilium",     new ToolSpear(MaterialTool.GILIUM,     2, -1.0f));
    public static final RegistryObject<Item> TOOL_SPEAR_ADAMANTIUM = register("tool_spear_adamantium", new ToolSpear(MaterialTool.ADAMANTIUM, 3, -1.0f));
    public static final RegistryObject<Item> TOOL_SPEAR_MYTHRIL    = register("tool_spear_mythril",    new ToolSpear(MaterialTool.MYTHRIL,    2, -1.0f));
    public static final RegistryObject<Item> TOOL_SPEAR_ORICHALCUM = register("tool_spear_orichalcum", new ToolSpear(MaterialTool.ORICHALCUM, 3, -1.0f));
    public static final RegistryObject<Item> TOOL_SPEAR_COPPER     = register("tool_spear_copper",     new ToolSpear(MaterialTool.COPPER,     1, -1.0f));
    public static final RegistryObject<Item> TOOL_SPEAR_BRONZE     = register("tool_spear_bronze",     new ToolSpear(MaterialTool.BRONZE,     2, -1.0f));
    public static final RegistryObject<Item> TOOL_SPEAR_STEEL      = register("tool_spear_steel",      new ToolSpear(MaterialTool.STEEL,      2, -1.0f));
    public static final RegistryObject<Item> TOOL_SPEAR_AURORITE   = register("tool_spear_aurorite",   new ToolSpear(MaterialTool.AURORITE,   3, -1.0f));

    // Tool Axe
    public static final RegistryObject<Item> TOOL_AXE_GILIUM     = register("tool_axe_gilium",     new ToolAxe(MaterialTool.GILIUM,     2, -1.0f));
    public static final RegistryObject<Item> TOOL_AXE_ADAMANTIUM = register("tool_axe_adamantium", new ToolAxe(MaterialTool.ADAMANTIUM, 3, -1.0f));
    public static final RegistryObject<Item> TOOL_AXE_MYTHRIL    = register("tool_axe_mythril",    new ToolAxe(MaterialTool.MYTHRIL,    2, -1.0f));
    public static final RegistryObject<Item> TOOL_AXE_ORICHALCUM = register("tool_axe_orichalcum", new ToolAxe(MaterialTool.ORICHALCUM, 3, -1.0f));
    public static final RegistryObject<Item> TOOL_AXE_COPPER     = register("tool_axe_copper",     new ToolAxe(MaterialTool.COPPER,     1, -1.0f));
    public static final RegistryObject<Item> TOOL_AXE_BRONZE     = register("tool_axe_bronze",     new ToolAxe(MaterialTool.BRONZE,     2, -1.0f));
    public static final RegistryObject<Item> TOOL_AXE_STEEL      = register("tool_axe_steel",      new ToolAxe(MaterialTool.STEEL,      2, -1.0f));
    public static final RegistryObject<Item> TOOL_AXE_AURORITE   = register("tool_axe_aurorite",   new ToolAxe(MaterialTool.AURORITE,   3, -1.0f));

    // Tool Pickaxe
    public static final RegistryObject<Item> TOOL_PICKAXE_GILIUM     = register("tool_pickaxe_gilium",     new ToolPickaxe(MaterialTool.GILIUM,     2, -1.0f));
    public static final RegistryObject<Item> TOOL_PICKAXE_ADAMANTIUM = register("tool_pickaxe_adamantium", new ToolPickaxe(MaterialTool.ADAMANTIUM, 3, -1.0f));
    public static final RegistryObject<Item> TOOL_PICKAXE_MYTHRIL    = register("tool_pickaxe_mythril",    new ToolPickaxe(MaterialTool.MYTHRIL,    2, -1.0f));
    public static final RegistryObject<Item> TOOL_PICKAXE_ORICHALCUM = register("tool_pickaxe_orichalcum", new ToolPickaxe(MaterialTool.ORICHALCUM, 3, -1.0f));
    public static final RegistryObject<Item> TOOL_PICKAXE_COPPER     = register("tool_pickaxe_copper",     new ToolPickaxe(MaterialTool.COPPER,     1, -1.0f));
    public static final RegistryObject<Item> TOOL_PICKAXE_BRONZE     = register("tool_pickaxe_bronze",     new ToolPickaxe(MaterialTool.BRONZE,     2, -1.0f));
    public static final RegistryObject<Item> TOOL_PICKAXE_STEEL      = register("tool_pickaxe_steel",      new ToolPickaxe(MaterialTool.STEEL,      2, -1.0f));
    public static final RegistryObject<Item> TOOL_PICKAXE_AURORITE   = register("tool_pickaxe_aurorite",   new ToolPickaxe(MaterialTool.AURORITE,   3, -1.0f));

    // Tool Shovel
    public static final RegistryObject<Item> TOOL_SHOVEL_GILIUM     = register("tool_shovel_gilium",     new ToolShovel(MaterialTool.GILIUM,     2, -1.0f));
    public static final RegistryObject<Item> TOOL_SHOVEL_ADAMANTIUM = register("tool_shovel_adamantium", new ToolShovel(MaterialTool.ADAMANTIUM, 3, -1.0f));
    public static final RegistryObject<Item> TOOL_SHOVEL_MYTHRIL    = register("tool_shovel_mythril",    new ToolShovel(MaterialTool.MYTHRIL,    2, -1.0f));
    public static final RegistryObject<Item> TOOL_SHOVEL_ORICHALCUM = register("tool_shovel_orichalcum", new ToolShovel(MaterialTool.ORICHALCUM, 3, -1.0f));
    public static final RegistryObject<Item> TOOL_SHOVEL_COPPER     = register("tool_shovel_copper",     new ToolShovel(MaterialTool.COPPER,     1, -1.0f));
    public static final RegistryObject<Item> TOOL_SHOVEL_BRONZE     = register("tool_shovel_bronze",     new ToolShovel(MaterialTool.BRONZE,     2, -1.0f));
    public static final RegistryObject<Item> TOOL_SHOVEL_STEEL      = register("tool_shovel_steel",      new ToolShovel(MaterialTool.STEEL,      2, -1.0f));
    public static final RegistryObject<Item> TOOL_SHOVEL_AURORITE   = register("tool_shovel_aurorite",   new ToolShovel(MaterialTool.AURORITE,   3, -1.0f));

    // // Tool Hoe
    public static final RegistryObject<Item> TOOL_HOE_GILIUM     = register("tool_hoe_gilium",     new ToolHoe(MaterialTool.GILIUM,     2, -1.0f));
    public static final RegistryObject<Item> TOOL_HOE_ADAMANTIUM = register("tool_hoe_adamantium", new ToolHoe(MaterialTool.ADAMANTIUM, 3, -1.0f));
    public static final RegistryObject<Item> TOOL_HOE_MYTHRIL    = register("tool_hoe_mythril",    new ToolHoe(MaterialTool.MYTHRIL,    2, -1.0f));
    public static final RegistryObject<Item> TOOL_HOE_ORICHALCUM = register("tool_hoe_orichalcum", new ToolHoe(MaterialTool.ORICHALCUM, 3, -1.0f));
    public static final RegistryObject<Item> TOOL_HOE_COPPER     = register("tool_hoe_copper",     new ToolHoe(MaterialTool.COPPER,     1, -1.0f));
    public static final RegistryObject<Item> TOOL_HOE_BRONZE     = register("tool_hoe_bronze",     new ToolHoe(MaterialTool.BRONZE,     2, -1.0f));
    public static final RegistryObject<Item> TOOL_HOE_STEEL      = register("tool_hoe_steel",      new ToolHoe(MaterialTool.STEEL,      2, -1.0f));
    public static final RegistryObject<Item> TOOL_HOE_AURORITE   = register("tool_hoe_aurorite",   new ToolHoe(MaterialTool.AURORITE,   3, -1.0f));

    // Tool Other
    public static final RegistryObject<Item> TOOL_DYNAMITE = register("tool_dynamite", new ToolDynamite());

    // Sounds
    public static final RegistryObject<SoundEvent> SOUND_ALPACA_AMBIENT = register("acecraft.alpaca.ambient", new SoundEvent(new ResourceLocation(MODID, "acecraft.alpaca.ambient")));
    public static final RegistryObject<SoundEvent> SOUND_ALPACA_HURT    = register("acecraft.alpaca.hurt",    new SoundEvent(new ResourceLocation(MODID, "acecraft.alpaca.hurt")));
    public static final RegistryObject<SoundEvent> SOUND_ALPACA_DEATH   = register("acecraft.alpaca.death",   new SoundEvent(new ResourceLocation(MODID, "acecraft.alpaca.death")));

    // Tile Entity
    public static final RegistryObject<TileEntityType<TileFoundry>>    TILE_FOUNDRY    = TILES.register("foundry",    () -> TileEntityType.Builder.of(TileFoundry::new,    MACHINA_FOUNDRY.get()).build(null));
    public static final RegistryObject<TileEntityType<TileDistillery>> TILE_DISTILLERY = TILES.register("distillery", () -> TileEntityType.Builder.of(TileDistillery::new, MACHINA_DISTILLERY.get()).build(null));

    // Container
    public static final RegistryObject<ContainerType<ContainerFoundry>>    CONTAINER_FOUNDRY    = CONTAINERS.register("foundry",    () -> IForgeContainerType.create(ContainerFoundry::new));
    public static final RegistryObject<ContainerType<ContainerDistillery>> CONTAINER_DISTILLERY = CONTAINERS.register("distillery", () -> IForgeContainerType.create(ContainerDistillery::new));

    // Loot Tables
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

    // Ore Spawn
    public static ConfiguredFeature<?, ?> SPAWN_GILIUM   = null;
    public static ConfiguredFeature<?, ?> SPAWN_ZINC     = null;
    public static ConfiguredFeature<?, ?> SPAWN_MYTHRIL  = null;
    public static ConfiguredFeature<?, ?> SPAWN_TIN      = null;
    public static ConfiguredFeature<?, ?> SPAWN_COPPER   = null;
    public static ConfiguredFeature<?, ?> SPAWN_AURORITE = null;
    public static ConfiguredFeature<?, ?> SPAWN_RUBY     = null;
    public static ConfiguredFeature<?, ?> SPAWN_SAPPHIRE = null;
    public static ConfiguredFeature<?, ?> SPAWN_SALT     = null;
    public static ConfiguredFeature<?, ?> SPAWN_SULFUR   = null;

    // Recipes
    public static final IRecipeType<RecipeDistillery> RECIPE_DISTILLERY = register("acecraft:distilling");
    public static final RegistryObject<RecipeDistillerySerializer> SERIALIZER_DISTILLERY = RECIPES.register("distilling", RecipeDistillerySerializer::new);

    // Entities
    public static final RegistryObject<EntityType<EntityAlpaca>>   ENTITY_ALPACA   = ENTITIES.register("alpaca",   () -> EntityType.Builder.of(EntityAlpaca::new,                    EntityClassification.CREATURE).sized(0.9F, 1.3F).setTrackingRange(10).build(new ResourceLocation(MODID, "alpaca").toString()));
    public static final RegistryObject<EntityType<EntityDynamite>> ENTITY_DYNAMITE = ENTITIES.register("dynamite", () -> EntityType.Builder.of(factoryDynamite(EntityDynamite::new), EntityClassification.MISC).noSummon().sized(0.25F, 0.25F).setTrackingRange(100).setUpdateInterval(1).setShouldReceiveVelocityUpdates(true).setCustomClientFactory(EntityDynamite::new).build(new ResourceLocation(MODID, "dynamite").toString()));
    public static final RegistryObject<EntityType<EntitySpear>>    ENTITY_SPEAR    = ENTITIES.register("spear",    () -> EntityType.Builder.of(factorySpear(EntitySpear::new),       EntityClassification.MISC).noSummon().sized(0.25F, 0.25F).setTrackingRange(100).setUpdateInterval(1).setShouldReceiveVelocityUpdates(true).setCustomClientFactory(EntitySpear::new   ).build(new ResourceLocation(MODID, "spear").toString()));
    public static final RegistryObject<EntityType<EntityNugget>>   ENTITY_NUGGET   = ENTITIES.register("nugget",   () -> EntityType.Builder.of(factoryNugget(EntityNugget::new),     EntityClassification.MISC).noSummon().sized(0.25F, 0.25F).setTrackingRange(100).setUpdateInterval(1).setShouldReceiveVelocityUpdates(true).setCustomClientFactory(EntityNugget::new  ).build(new ResourceLocation(MODID, "nugget").toString()));

    // Spawn Eggs
    public static final RegistryObject<ItemSpawnEgg> SPAWNEGG_ALPACA = ITEMS.register("spawnegg_alpaca", () -> new ItemSpawnEgg(() -> ENTITY_ALPACA.get(), 12345, 67890, new Item.Properties().tab(ItemGroup.TAB_MISC)));

    // Client Render Factory
    private static <T extends EntityDynamite> EntityType.IFactory<T> factoryDynamite(EntityType.IFactory<T> factory){ return factory; }
    private static <T extends EntitySpear>    EntityType.IFactory<T> factorySpear(   EntityType.IFactory<T> factory){ return factory; }
    private static <T extends EntityNugget>   EntityType.IFactory<T> factoryNugget(  EntityType.IFactory<T> factory){ return factory; }



    //----------------------------------------REGISTER----------------------------------------//

    static void register(){
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
        SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        RECIPES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    static <T extends IRecipe<?>> IRecipeType<T> register(final String key)
    {
        return Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(key), new IRecipeType<T>()
        {
            @Override
            public String toString()
            {
                return key;
            }
        });
    }

    public static void registerEntity(BiomeLoadingEvent event, Set<BiomeDictionary.Type> types) {
        List<BiomeDictionary.Type> includeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(Config.ALPACA.include.get()));
        List<BiomeDictionary.Type> excludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(Config.ALPACA.exclude.get()));
        if (!includeList.isEmpty()) {
            if (types.stream().noneMatch(excludeList::contains) && types.stream().anyMatch(includeList::contains)) {
                event.getSpawns().getSpawner(EntityClassification.CREATURE).add(new MobSpawnInfo.Spawners(ENTITY_ALPACA.get(), Config.ALPACA.weight.get(), Config.ALPACA.min.get(), Config.ALPACA.max.get()));
            }
        } else {
            throw new IllegalArgumentException("Do not leave the BiomeDictionary type inclusion list empty. If you wish to disable spawning of an entity, set the weight to 0 instead.");
        }
    }

    public static void registerEntities() {
        EntitySpawnPlacementRegistry.register(ENTITY_ALPACA.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::checkAnimalSpawnRules);
        GlobalEntityTypeAttributes.put(ENTITY_ALPACA.get(), EntityAlpaca.createAttributes().build());
    }
    private static RegistryObject<Block> register(String name, Block block){
        return register(name, block, null);
    }

    private static RegistryObject<Block> register(String name, Block block, ItemGroup itemGroup){
        if(itemGroup != null){ ITEMS.register(name, () -> new BlockItem(block, (new Item.Properties()).tab(itemGroup))); }
        return BLOCKS.register(name, () -> block);
    }

    private static RegistryObject<Item> register(String name, Item item){
        return ITEMS.register(name, () -> item);
    }

    private static RegistryObject<SoundEvent> register(String name, SoundEvent sound){
        return SOUNDS.register(name, () -> sound);
    }

    private static RegistryObject<EntityType<?>> register(String name, EntityType entity){
        return ENTITIES.register(name, () -> entity);
    }

    public static ConfiguredFeature<?, ?> buildOreSpawn(String name, BlockState state, int veinSize, int maxHeight, int spawnRate, boolean isNether) {
        OreFeatureConfig config = new OreFeatureConfig(isNether ? OreFeatureConfig.FillerBlockType.NETHER_ORE_REPLACEABLES : OreFeatureConfig.FillerBlockType.NATURAL_STONE, state, veinSize);
        ConfiguredFeature<?, ?> feature = Feature.ORE.configured(config)
                .range(maxHeight)
                .squared()
                .chance(spawnRate);
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(AceCraft.MODID, name), feature  );
        return feature;

    }

    public static void registerOreSpawn(){
        SPAWN_GILIUM   = buildOreSpawn("ore_gilium",   ShopKeeper.ORE_GILIUM.get().defaultBlockState(),   Config.GILIUM.veinSize.get(),   Config.GILIUM.maxHeight.get(),   Config.GILIUM.spawnRate.get(),   true);
        SPAWN_ZINC     = buildOreSpawn("ore_zinc",     ShopKeeper.ORE_ZINC.get().defaultBlockState(),     Config.ZINC.veinSize.get(),     Config.ZINC.maxHeight.get(),     Config.ZINC.spawnRate.get(),     false);
        SPAWN_MYTHRIL  = buildOreSpawn("ore_mythril",  ShopKeeper.ORE_MYTHRIL.get().defaultBlockState(),  Config.MYTHRIL.veinSize.get(),  Config.MYTHRIL.maxHeight.get(),  Config.MYTHRIL.spawnRate.get(),  false);
        SPAWN_TIN      = buildOreSpawn("ore_tin",      ShopKeeper.ORE_TIN.get().defaultBlockState(),      Config.TIN.veinSize.get(),      Config.TIN.maxHeight.get(),      Config.TIN.spawnRate.get(),      false);
        SPAWN_COPPER   = buildOreSpawn("ore_copper",   ShopKeeper.ORE_COPPER.get().defaultBlockState(),   Config.COPPER.veinSize.get(),   Config.COPPER.maxHeight.get(),   Config.COPPER.spawnRate.get(),   false);
        SPAWN_AURORITE = buildOreSpawn("ore_aurorite", ShopKeeper.ORE_AURORITE.get().defaultBlockState(), Config.AURORITE.veinSize.get(), Config.AURORITE.maxHeight.get(), Config.AURORITE.spawnRate.get(), false);
        SPAWN_RUBY     = buildOreSpawn("ore_ruby",     ShopKeeper.ORE_RUBY.get().defaultBlockState(),     Config.RUBY.veinSize.get(),     Config.RUBY.maxHeight.get(),     Config.RUBY.spawnRate.get(),     false);
        SPAWN_SAPPHIRE = buildOreSpawn("ore_sapphire", ShopKeeper.ORE_SAPPHIRE.get().defaultBlockState(), Config.SAPPHIRE.veinSize.get(), Config.SAPPHIRE.maxHeight.get(), Config.SAPPHIRE.spawnRate.get(), false);
        SPAWN_SALT     = buildOreSpawn("ore_salt",     ShopKeeper.ORE_SALT.get().defaultBlockState(),     Config.SALT.veinSize.get(),     Config.SALT.maxHeight.get(),     Config.SALT.spawnRate.get(),     false);
        SPAWN_SULFUR   = buildOreSpawn("ore_sulfur",   ShopKeeper.ORE_SULFUR.get().defaultBlockState(),   Config.SULFUR.veinSize.get(),   Config.SULFUR.maxHeight.get(),   Config.SULFUR.spawnRate.get(),   false);
    }




    //----------------------------------------SETUP----------------------------------------//

    static void setup(FMLCommonSetupEvent event){
        registerEntities();
    }

    @OnlyIn(Dist.CLIENT)
    static void setup(FMLClientSetupEvent event){
        RenderTypeLookup.setRenderLayer(CROP_CABBAGE.get(),    RenderType.cutout());
        RenderTypeLookup.setRenderLayer(CROP_CORN.get(),       RenderType.cutout());
        RenderTypeLookup.setRenderLayer(CROP_CUCUMBER.get(),   RenderType.cutout());
        RenderTypeLookup.setRenderLayer(CROP_EGGPLANT.get(),   RenderType.cutout());
        RenderTypeLookup.setRenderLayer(CROP_GRAPES.get(),     RenderType.cutout());
        RenderTypeLookup.setRenderLayer(CROP_ONION.get(),      RenderType.cutout());
        RenderTypeLookup.setRenderLayer(CROP_PINEAPPLE.get(),  RenderType.cutout());
        RenderTypeLookup.setRenderLayer(CROP_STRAWBERRY.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(CROP_TOMATO.get(),     RenderType.cutout());
        RenderTypeLookup.setRenderLayer(CROP_TURNIP.get(),     RenderType.cutout());
        RenderTypeLookup.setRenderLayer(CROP_RICE.get(),       RenderType.cutout());
        RenderTypeLookup.setRenderLayer(CROP_COFFEE.get(),     RenderType.cutout());
        RenderTypeLookup.setRenderLayer(CROP_HEMP.get(),       RenderType.cutout());

        RenderingRegistry.registerEntityRenderingHandler(ENTITY_ALPACA.get(),   RenderAlpaca::new);
        RenderingRegistry.registerEntityRenderingHandler(ENTITY_DYNAMITE.get(), new renderFactoryDynamite());
        RenderingRegistry.registerEntityRenderingHandler(ENTITY_SPEAR.get(),    RenderSpear::new);
        RenderingRegistry.registerEntityRenderingHandler(ENTITY_NUGGET.get(),   new renderFactoryNugget());
        DeferredWorkQueue.runLater(() -> {
            ScreenManager.register(CONTAINER_FOUNDRY.get(),    ScreenFoundry::new);
            ScreenManager.register(CONTAINER_DISTILLERY.get(), ScreenDistillery::new);
        });
    }

    private static class renderFactoryDynamite implements IRenderFactory<EntityDynamite> {
        @Override
        public EntityRenderer<? super EntityDynamite> createRenderFor(EntityRendererManager manager) {
            ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
            return new RenderDynamite(manager, itemRenderer, 1.0f, false);
        }
    }

    private static class renderFactoryNugget implements IRenderFactory<EntityNugget> {
        @Override
        public EntityRenderer<? super EntityNugget> createRenderFor(EntityRendererManager manager) {
            ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
            return new RenderNugget(manager, itemRenderer, 1.0f, false);
        }
    }

}
