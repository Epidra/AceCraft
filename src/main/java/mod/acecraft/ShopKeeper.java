package mod.acecraft;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import mod.acecraft.blocks.*;
import mod.acecraft.container.ContainerCookingBoard;
import mod.acecraft.container.ContainerDistillery;
import mod.acecraft.container.ContainerFoundry;
import mod.acecraft.crafting.RecipeCookingBoard;
import mod.acecraft.crafting.RecipeCookingBoardSerializer;
import mod.acecraft.crafting.RecipeDistillery;
import mod.acecraft.crafting.RecipeDistillerySerializer;
import mod.acecraft.entity.EntityCrab;
import mod.acecraft.entity.EntityDynamite;
import mod.acecraft.entity.EntityNugget;
import mod.acecraft.entity.EntitySpear;
import mod.acecraft.items.*;
import mod.acecraft.render.RenderCrab;
import mod.acecraft.render.RenderDynamite;
import mod.acecraft.render.RenderNugget;
import mod.acecraft.render.RenderSpear;
import mod.acecraft.screen.ScreenCookingBoard;
import mod.acecraft.screen.ScreenDistillery;
import mod.acecraft.screen.ScreenFoundry;
import mod.acecraft.tileentities.TileCookingBoard;
import mod.acecraft.tileentities.TileDistillery;
import mod.acecraft.tileentities.TileFoundry;
import mod.acecraft.util.BiomeDictionaryHelper;
import mod.acecraft.util.MaterialArmor;
import mod.acecraft.util.MaterialTool;
import mod.acecraft.util.VillagerUtil;
import mod.acecraft.blocks.BlockBlock;
import mod.acecraft.items.ItemItem;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

import java.util.*;

import static mod.acecraft.AceCraft.MODID;

public class ShopKeeper {

    private static final DeferredRegister<Block>                BLOCKS     = new DeferredRegister<>(ForgeRegistries.BLOCKS,             MODID);
    private static final DeferredRegister<Item>                 ITEMS      = new DeferredRegister<>(ForgeRegistries.ITEMS,              MODID);
    private static final DeferredRegister<EntityType<?>>        ENTITIES   = new DeferredRegister<>(ForgeRegistries.ENTITIES,           MODID);
    private static final DeferredRegister<ContainerType<?>>     CONTAINERS = new DeferredRegister<>(ForgeRegistries.CONTAINERS,         MODID);
    private static final DeferredRegister<TileEntityType<?>>    TILES      = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES,      MODID);
    private static final DeferredRegister<SoundEvent>           SOUNDS     = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS,       MODID);
    private static final DeferredRegister<IRecipeSerializer<?>> RECIPES    = new DeferredRegister<>(ForgeRegistries.RECIPE_SERIALIZERS, MODID);




    // Blocks
    public static final RegistryObject<Block> BLOCK_BRASS      = register("block_brass",      new BlockBlock(Blocks.IRON_BLOCK),    ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_GILIUM     = register("block_gilium",     new BlockBlock(Blocks.IRON_BLOCK),    ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_ADAMANTIUM = register("block_adamantium", new BlockBlock(Blocks.IRON_BLOCK),    ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_ZINC       = register("block_zinc",       new BlockBlock(Blocks.IRON_BLOCK),    ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_MYTHRIL    = register("block_mythril",    new BlockBlock(Blocks.IRON_BLOCK),    ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_TIN        = register("block_tin",        new BlockBlock(Blocks.IRON_BLOCK),    ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_ORICHALCUM = register("block_orichalcum", new BlockBlock(Blocks.IRON_BLOCK),    ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_COPPER     = register("block_copper",     new BlockBlock(Blocks.IRON_BLOCK),    ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_BRONZE     = register("block_bronze",     new BlockBlock(Blocks.IRON_BLOCK),    ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_STEEL      = register("block_steel",      new BlockBlock(Blocks.IRON_BLOCK),    ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_AURORITE   = register("block_aurorite",   new BlockBlock(Blocks.DIAMOND_BLOCK), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_RUBY       = register("block_ruby",       new BlockBlock(Blocks.DIAMOND_BLOCK), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_SAPPHIRE   = register("block_sapphire",   new BlockBlock(Blocks.DIAMOND_BLOCK), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_AMETHYST   = register("block_amethyst",   new BlockBlock(Blocks.DIAMOND_BLOCK), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_SALT       = register("block_salt",       new BlockBlock(Blocks.SAND),          ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BLOCK_SULFUR     = register("block_sulfur",     new BlockBlock(Blocks.SAND),          ItemGroup.BUILDING_BLOCKS);

    // Ore
    public static final RegistryObject<Block> ORE_GILIUM     = register("ore_gilium",   new BlockOre(Blocks.IRON_ORE),    ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_ZINC       = register("ore_zinc",     new BlockOre(Blocks.IRON_ORE),    ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_MYTHRIL    = register("ore_mythril",  new BlockOre(Blocks.IRON_ORE),    ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_TIN        = register("ore_tin",      new BlockOre(Blocks.IRON_ORE),    ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_COPPER     = register("ore_copper",   new BlockOre(Blocks.IRON_ORE),    ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_AURORITE   = register("ore_aurorite", new BlockOre(Blocks.DIAMOND_ORE), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_RUBY       = register("ore_ruby",     new BlockOre(Blocks.DIAMOND_ORE), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_SAPPHIRE   = register("ore_sapphire", new BlockOre(Blocks.DIAMOND_ORE), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_AMETHYST   = register("ore_amethyst", new BlockOre(Blocks.DIAMOND_ORE), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_SALT       = register("ore_salt",     new BlockOre(Blocks.LAPIS_ORE),   ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> ORE_SULFUR     = register("ore_sulfur",   new BlockOre(Blocks.LAPIS_ORE),   ItemGroup.BUILDING_BLOCKS);

    // Machinas
    public static final RegistryObject<Block> MACHINA_ROPE         = register("machina_rope",         new BlockRope()                               );
    public static final RegistryObject<Block> MACHINA_ANCHOR       = register("machina_anchor",       new BlockAnchor(),       ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> MACHINA_DISTILLERY   = register("machina_distillery",   new BlockDistillery(),   ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> MACHINA_GLOBE        = register("machina_globe",        new BlockGlobe(),        ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> MACHINA_FOUNDRY      = register("machina_foundry",      new BlockFoundry(),      ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> MACHINA_KEG          = register("machina_keg",          new BlockKeg(),          ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> MACHINA_COOKINGBOARD = register("machina_cookingboard", new BlockCookingBoard(), ItemGroup.DECORATIONS);

    // Nuggets
    public static final RegistryObject<Item> NUGGET_IRON       = register("nugget_iron",    new ItemNugget());
    public static final RegistryObject<Item> NUGGET_GOLD       = register("nugget_gold",    new ItemNugget());
    public static final RegistryObject<Item> NUGGET_GILIUM     = register("nugget_gilium",  new ItemNugget());
    public static final RegistryObject<Item> NUGGET_ZINC       = register("nugget_zinc",    new ItemNugget());
    public static final RegistryObject<Item> NUGGET_MYTHRIL    = register("nugget_mythril", new ItemNugget());
    public static final RegistryObject<Item> NUGGET_TIN        = register("nugget_tin",     new ItemNugget());
    public static final RegistryObject<Item> NUGGET_COPPER     = register("nugget_copper",  new ItemNugget());

    // Crops
    public static final RegistryObject<Block> CROP_COFFEE       = register("crop_coffee",       new BlockCrop(Blocks.GRASS), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> CROP_TURNIP       = register("crop_turnip",       new BlockCrop(Blocks.GRASS), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> CROP_CABBAGE      = register("crop_cabbage",      new BlockCrop(Blocks.GRASS), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> CROP_TOMATO       = register("crop_tomato",       new BlockCrop(Blocks.GRASS), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> CROP_CUCUMBER     = register("crop_cucumber",     new BlockCrop(Blocks.GRASS), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> CROP_CORN         = register("crop_corn",         new BlockCrop(Blocks.GRASS), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> CROP_GRAPES       = register("crop_grapes",       new BlockCrop(Blocks.GRASS), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> CROP_HEMP         = register("crop_hemp",         new BlockCrop(Blocks.GRASS), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> CROP_STRAWBERRIES = register("crop_strawberries", new BlockCrop(Blocks.GRASS), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> CROP_ONION        = register("crop_onion",        new BlockCrop(Blocks.GRASS), ItemGroup.DECORATIONS);

    // Flowers
    public static final RegistryObject<Block> FLOWER_BAMBOO     = register("flower_bamboo",     new BlockBush(Blocks.CORNFLOWER), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> FLOWER_MATSUTAKE  = register("flower_matsutake",  new BlockBush(Blocks.CORNFLOWER), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> FLOWER_MOONDROP   = register("flower_moondrop",   new BlockBush(Blocks.CORNFLOWER), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> FLOWER_TOYFLOWER  = register("flower_toyflower",  new BlockBush(Blocks.CORNFLOWER), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> FLOWER_PINKCAT    = register("flower_pinkcat",    new BlockBush(Blocks.CORNFLOWER), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> FLOWER_MAGICGRASS = register("flower_magicgrass", new BlockBush(Blocks.CORNFLOWER), ItemGroup.DECORATIONS);

    // Basic Food
    public static final RegistryObject<Item> FOOD_COFFEE         = register("food_coffee",         new ItemFood(4, 0.4f));
    public static final RegistryObject<Item> FOOD_TURNIP         = register("food_turnip",         new ItemFood(4, 0.4f));
    public static final RegistryObject<Item> FOOD_CABBAGE        = register("food_cabbage",        new ItemFood(4, 0.4f));
    public static final RegistryObject<Item> FOOD_TOMATO         = register("food_tomato",         new ItemFood(4, 0.4f));
    public static final RegistryObject<Item> FOOD_CUCUMBER       = register("food_cucumber",       new ItemFood(4, 0.4f));
    public static final RegistryObject<Item> FOOD_CORN           = register("food_corn",           new ItemFood(4, 0.4f));
    public static final RegistryObject<Item> FOOD_GRAPES         = register("food_grapes",         new ItemFood(4, 0.4f));
    public static final RegistryObject<Item> FOOD_STRAWBERRIES   = register("food_strawberries",   new ItemFood(4, 0.4f));
    public static final RegistryObject<Item> FOOD_ONION          = register("food_onion",          new ItemFood(4, 0.4f));
    public static final RegistryObject<Item> FOOD_RICEBALL       = register("food_riceball",       new ItemFood(4, 0.4f));
    public static final RegistryObject<Item> FOOD_BUTTER         = register("food_butter",         new ItemFood(4, 0.4f));
    public static final RegistryObject<Item> FOOD_VENISON_RAW    = register("food_venison_raw",    new ItemFood(4, 0.4f));
    public static final RegistryObject<Item> FOOD_VENISON_COOKED = register("food_venison_cooked", new ItemFood(4, 0.4f));
    public static final RegistryObject<Item> FOOD_VICUGNA_RAW    = register("food_vicugna_raw",    new ItemFood(4, 0.4f));
    public static final RegistryObject<Item> FOOD_VICUGNA_COOKED = register("food_vicugna_cooked", new ItemFood(4, 0.4f));

    // Dishes
    public static final RegistryObject<Item> DISH_STIRFRY          = register("dish_stirfry",          new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_FRIEDRICE        = register("dish_friedrice",        new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_SAVORYPANCAKE    = register("dish_savorypancake",    new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_FRENCHFRIES      = register("dish_frenchfries",      new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_CROQUETTE        = register("dish_croquette",        new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_POPCORN          = register("dish_popcorn",          new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_CORNFLAKES       = register("dish_cornflakes",       new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_SCRAMBLEDEGGS    = register("dish_scrambledeggs",    new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_OMELET           = register("dish_omelet",           new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_OMELETRICE       = register("dish_omeletrice",       new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_APPLESOUFFLE     = register("dish_applesouffle",     new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_CURRYBREAD       = register("dish_currybread",       new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_FRENCHTOAST      = register("dish_frenchtoast",      new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_FRIEDNODDLES     = register("dish_friednoodles",     new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_TEMPURA          = register("dish_tempura",          new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_PANCAKE          = register("dish_pancake",          new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_POTSTICKER       = register("dish_potsticker",       new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_RISOTTO          = register("dish_risotto",          new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_PUMPKINSTEW      = register("dish_pumpkinstew",      new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_BOILEDEGG        = register("dish_boiledegg",        new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_DUMPLINGS        = register("dish_dumplings",        new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_NOODLES          = register("dish_noodles",          new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_CURRYNOODLES     = register("dish_currynoodles",     new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_TEMPURANOODLES   = register("dish_tempuranoodles",   new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_RICESOUP         = register("dish_ricesoup",         new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_PORRIDGE         = register("dish_porridge",         new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_TEMPURARICE      = register("dish_tempurarice",      new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_EGGOVERRICE      = register("dish_eggoverrice",      new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_CURRYRICE        = register("dish_curryrice",        new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_TOAST            = register("dish_toast",            new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_STEAMEDBUN       = register("dish_steamedbun",       new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_SHAOMI           = register("dish_shaomi",           new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_CURRYBUN         = register("dish_currybun",         new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_STEAMEDDUMPLINGS = register("dish_steameddumplings", new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_SPONGECAKE       = register("dish_spongecake",       new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_STEAMEDCAKE      = register("dish_steamedcake",      new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_PUDDING          = register("dish_pudding",          new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_PUMPKINPUDDING   = register("dish_pumpkinpudding",   new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_SALAD            = register("dish_salad",            new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_SANDWICH         = register("dish_sandwich",         new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_FRUITSANDWICH    = register("dish_fruitsandwich",    new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_PICKLEDTURNIPS   = register("dish_pickledturnips",   new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_PICKLEDCUCUMBER  = register("dish_pickledcucumber",  new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_BAMBOORICE       = register("dish_bamboorice",       new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_MATSUTAKERICE    = register("dish_matsutakerice",    new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_SUSHI            = register("dish_sushi",            new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_RAISINBREAD      = register("dish_raisinbread",      new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_SASHIMI          = register("dish_sashimi",          new ItemDish(4, 0.4f));
    public static final RegistryObject<Item> DISH_CHIRASHISUSHI    = register("dish_chirashisushi",    new ItemDish(4, 0.4f));

    // Seeds
    //public static final RegistryObject<Item> SEEDS_WILD         = register("seeds_wild",         new ItemSeedWild());
    //public static final RegistryObject<Item> SEEDS_COFFEE       = register("seeds_coffee",       new ItemSeed(CROP_COFFEE));
    //public static final RegistryObject<Item> SEEDS_TURNIP       = register("seeds_turnip",       new ItemSeed(CROP_TURNIP));
    //public static final RegistryObject<Item> SEEDS_CABBAGE      = register("seeds_cabbage",      new ItemSeed(CROP_CABBAGE));
    //public static final RegistryObject<Item> SEEDS_TOMATO       = register("seeds_tomato",       new ItemSeed(CROP_TOMATO));
    //public static final RegistryObject<Item> SEEDS_CUCUMBER     = register("seeds_cucumber",     new ItemSeed(CROP_CUCUMBER));
    //public static final RegistryObject<Item> SEEDS_CORN         = register("seeds_corn",         new ItemSeed(CROP_CORN));
    //public static final RegistryObject<Item> SEEDS_GRAPES       = register("seeds_grapes",       new ItemSeed(CROP_GRAPES));
    //public static final RegistryObject<Item> SEEDS_HEMP         = register("seeds_hemp",         new ItemSeed(CROP_HEMP));
    //public static final RegistryObject<Item> SEEDS_STRAWBERRIES = register("seeds_strawberries", new ItemSeed(CROP_STRAWBERRIES));
    //public static final RegistryObject<Item> SEEDS_ONION        = register("seeds_onion",        new ItemSeed(CROP_ONION));

    // Simple Items
    public static final RegistryObject<Item> ITEM_ROPE       = register("item_rope",       new ItemItem(ItemGroup.MISC));
    public static final RegistryObject<Item> ITEM_HEMP       = register("item_hemp",       new ItemItem(ItemGroup.MISC));
    public static final RegistryObject<Item> ITEM_AURORITE   = register("item_aurorite",   new ItemItem(ItemGroup.MISC));
    public static final RegistryObject<Item> ITEM_RUBY       = register("item_ruby",       new ItemItem(ItemGroup.MISC));
    public static final RegistryObject<Item> ITEM_SAPPHIRE   = register("item_sapphire",   new ItemItem(ItemGroup.MISC));
    public static final RegistryObject<Item> ITEM_AMETHYST   = register("item_amethyst",   new ItemItem(ItemGroup.MISC));
    public static final RegistryObject<Item> ITEM_SALT       = register("item_salt",       new ItemItem(ItemGroup.MISC));
    public static final RegistryObject<Item> ITEM_SULFUR     = register("item_sulfur",     new ItemItem(ItemGroup.MISC));
    public static final RegistryObject<Item> ITEM_FLOUR      = register("item_flour",      new ItemItem(ItemGroup.MISC));
    public static final RegistryObject<Item> ITEM_CURRY      = register("item_curry",      new ItemItem(ItemGroup.MISC));
    public static final RegistryObject<Item> ITEM_BRASS      = register("item_brass",      new ItemItem(ItemGroup.MATERIALS));
    public static final RegistryObject<Item> ITEM_GILIUM     = register("item_gilium",     new ItemItem(ItemGroup.MATERIALS));
    public static final RegistryObject<Item> ITEM_ADAMANTIUM = register("item_adamantium", new ItemItem(ItemGroup.MATERIALS));
    public static final RegistryObject<Item> ITEM_ZINC       = register("item_zinc",       new ItemItem(ItemGroup.MATERIALS));
    public static final RegistryObject<Item> ITEM_MYTHRIL    = register("item_mythril",    new ItemItem(ItemGroup.MATERIALS));
    public static final RegistryObject<Item> ITEM_TIN        = register("item_tin",        new ItemItem(ItemGroup.MATERIALS));
    public static final RegistryObject<Item> ITEM_ORICHALCUM = register("item_orichalcum", new ItemItem(ItemGroup.MATERIALS));
    public static final RegistryObject<Item> ITEM_COPPER     = register("item_copper",     new ItemItem(ItemGroup.MATERIALS));
    public static final RegistryObject<Item> ITEM_BRONZE     = register("item_bronze",     new ItemItem(ItemGroup.MATERIALS));
    public static final RegistryObject<Item> ITEM_STEEL      = register("item_steel",      new ItemItem(ItemGroup.MATERIALS));

    // Liquor
    public static final RegistryObject<Item> LIQUOR_COFFEE       = register("liquor_coffee",        new ItemLiquor(4, 0.4f));
    public static final RegistryObject<Item> LIQUOR_RUM          = register("liquor_rum",           new ItemLiquor(4, 0.4f));
    public static final RegistryObject<Item> LIQUOR_SAKE         = register("liquor_sake",          new ItemLiquor(4, 0.4f));
    public static final RegistryObject<Item> LIQUOR_MEAD         = register("liquor_mead",          new ItemLiquor(4, 0.4f));
    public static final RegistryObject<Item> LIQUOR_SALGAM       = register("liquor_salgam",        new ItemLiquor(4, 0.4f));
    public static final RegistryObject<Item> LIQUOR_VODKA        = register("liquor_vodka",         new ItemLiquor(4, 0.4f));
    public static final RegistryObject<Item> LIQUOR_BEER         = register("liquor_beer",          new ItemLiquor(4, 0.4f));
    public static final RegistryObject<Item> LIQUOR_CIDER        = register("liquor_cider",         new ItemLiquor(4, 0.4f));
    public static final RegistryObject<Item> LIQUOR_WINE         = register("liquor_wine",          new ItemLiquor(4, 0.4f));
    public static final RegistryObject<Item> LIQUOR_OIL          = register("liquor_oil",           new ItemLiquor(4, 0.4f));
    public static final RegistryObject<Item> LIQUOR_HOTMILK      = register("liquor_hotmilk",       new ItemLiquor(4, 0.4f));
    public static final RegistryObject<Item> LIQUOR_HOTCHOCOLATE = register("liquor_hotchocolate",  new ItemLiquor(4, 0.4f));

    // Other Tools
    public static final RegistryObject<Item> TOOL_DYNAMITE = register("stuff_dynamite", new ToolDynamite());

    // Armor Boots
    public static final RegistryObject<Item> ARMOR_BOOTS_BRASS      = register("armor_boots_brass",      new ItemArmor(     MaterialArmor.BRASS,      EquipmentSlotType.FEET));
    public static final RegistryObject<Item> ARMOR_BOOTS_GILIUM     = register("armor_boots_gilium",     new ItemArmor(     MaterialArmor.GILIUM,     EquipmentSlotType.FEET));
    public static final RegistryObject<Item> ARMOR_BOOTS_ADAMANTIUM = register("armor_boots_adamantium", new ItemArmor(     MaterialArmor.ADAMANTIUM, EquipmentSlotType.FEET));
    public static final RegistryObject<Item> ARMOR_BOOTS_MYTHRIL    = register("armor_boots_mythril",    new ItemArmor(     MaterialArmor.MYTHRIL,    EquipmentSlotType.FEET));
    public static final RegistryObject<Item> ARMOR_BOOTS_ORICHALCUM = register("armor_boots_orichalcum", new ItemArmor(     MaterialArmor.ORICHALCUM, EquipmentSlotType.FEET));
    public static final RegistryObject<Item> ARMOR_BOOTS_COPPER     = register("armor_boots_copper",     new ItemArmor(     MaterialArmor.COPPER,     EquipmentSlotType.FEET));
    public static final RegistryObject<Item> ARMOR_BOOTS_BRONZE     = register("armor_boots_bronze",     new ItemArmor(     MaterialArmor.BRONZE,     EquipmentSlotType.FEET));
    public static final RegistryObject<Item> ARMOR_BOOTS_STEEL      = register("armor_boots_steel",      new ItemArmor(     MaterialArmor.STEEL,      EquipmentSlotType.FEET));
    public static final RegistryObject<Item> ARMOR_BOOTS_AURORITE   = register("armor_boots_aurorite",   new ItemArmorColor(MaterialArmor.AURORITE,   EquipmentSlotType.FEET));

    // Armor Chestplate
    public static final RegistryObject<Item> ARMOR_PLATE_BRASS      = register("armor_plate_brass",      new ItemArmor(     MaterialArmor.BRASS,      EquipmentSlotType.CHEST));
    public static final RegistryObject<Item> ARMOR_PLATE_GILIUM     = register("armor_plate_gilium",     new ItemArmor(     MaterialArmor.GILIUM,     EquipmentSlotType.CHEST));
    public static final RegistryObject<Item> ARMOR_PLATE_ADAMANTIUM = register("armor_plate_adamantium", new ItemArmor(     MaterialArmor.ADAMANTIUM, EquipmentSlotType.CHEST));
    public static final RegistryObject<Item> ARMOR_PLATE_MYTHRIL    = register("armor_plate_mythril",    new ItemArmor(     MaterialArmor.MYTHRIL,    EquipmentSlotType.CHEST));
    public static final RegistryObject<Item> ARMOR_PLATE_ORICHALCUM = register("armor_plate_orichalcum", new ItemArmor(     MaterialArmor.ORICHALCUM, EquipmentSlotType.CHEST));
    public static final RegistryObject<Item> ARMOR_PLATE_COPPER     = register("armor_plate_copper",     new ItemArmor(     MaterialArmor.COPPER,     EquipmentSlotType.CHEST));
    public static final RegistryObject<Item> ARMOR_PLATE_BRONZE     = register("armor_plate_bronze",     new ItemArmor(     MaterialArmor.BRONZE,     EquipmentSlotType.CHEST));
    public static final RegistryObject<Item> ARMOR_PLATE_STEEL      = register("armor_plate_steel",      new ItemArmor(     MaterialArmor.STEEL,      EquipmentSlotType.CHEST));
    public static final RegistryObject<Item> ARMOR_PLATE_AURORITE   = register("armor_plate_aurorite",   new ItemArmorColor(MaterialArmor.AURORITE,   EquipmentSlotType.CHEST));

    // Armor Leggings
    public static final RegistryObject<Item> ARMOR_LEGGINGS_BRASS      = register("armor_leggings_brass",      new ItemArmor(     MaterialArmor.BRASS,      EquipmentSlotType.LEGS));
    public static final RegistryObject<Item> ARMOR_LEGGINGS_GILIUM     = register("armor_leggings_gilium",     new ItemArmor(     MaterialArmor.GILIUM,     EquipmentSlotType.LEGS));
    public static final RegistryObject<Item> ARMOR_LEGGINGS_ADAMANTIUM = register("armor_leggings_adamantium", new ItemArmor(     MaterialArmor.ADAMANTIUM, EquipmentSlotType.LEGS));
    public static final RegistryObject<Item> ARMOR_LEGGINGS_MYTHRIL    = register("armor_leggings_mythril",    new ItemArmor(     MaterialArmor.MYTHRIL,    EquipmentSlotType.LEGS));
    public static final RegistryObject<Item> ARMOR_LEGGINGS_ORICHALCUM = register("armor_leggings_orichalcum", new ItemArmor(     MaterialArmor.ORICHALCUM, EquipmentSlotType.LEGS));
    public static final RegistryObject<Item> ARMOR_LEGGINGS_COPPER     = register("armor_leggings_copper",     new ItemArmor(     MaterialArmor.COPPER,     EquipmentSlotType.LEGS));
    public static final RegistryObject<Item> ARMOR_LEGGINGS_BRONZE     = register("armor_leggings_bronze",     new ItemArmor(     MaterialArmor.BRONZE,     EquipmentSlotType.LEGS));
    public static final RegistryObject<Item> ARMOR_LEGGINGS_STEEL      = register("armor_leggings_steel",      new ItemArmor(     MaterialArmor.STEEL,      EquipmentSlotType.LEGS));
    public static final RegistryObject<Item> ARMOR_LEGGINGS_AURORITE   = register("armor_leggings_aurorite",   new ItemArmorColor(MaterialArmor.AURORITE,   EquipmentSlotType.LEGS));

    // Armor Helmet
    public static final RegistryObject<Item> ARMOR_HELMET_BRASS      = register("armor_helmet_brass",      new ItemArmor(     MaterialArmor.BRASS,      EquipmentSlotType.HEAD));
    public static final RegistryObject<Item> ARMOR_HELMET_GILIUM     = register("armor_helmet_gilium",     new ItemArmor(     MaterialArmor.GILIUM,     EquipmentSlotType.HEAD));
    public static final RegistryObject<Item> ARMOR_HELMET_ADAMANTIUM = register("armor_helmet_adamantium", new ItemArmor(     MaterialArmor.ADAMANTIUM, EquipmentSlotType.HEAD));
    public static final RegistryObject<Item> ARMOR_HELMET_MYTHRIL    = register("armor_helmet_mythril",    new ItemArmor(     MaterialArmor.MYTHRIL,    EquipmentSlotType.HEAD));
    public static final RegistryObject<Item> ARMOR_HELMET_ORICHALCUM = register("armor_helmet_orichalcum", new ItemArmor(     MaterialArmor.ORICHALCUM, EquipmentSlotType.HEAD));
    public static final RegistryObject<Item> ARMOR_HELMET_COPPER     = register("armor_helmet_copper",     new ItemArmor(     MaterialArmor.COPPER,     EquipmentSlotType.HEAD));
    public static final RegistryObject<Item> ARMOR_HELMET_BRONZE     = register("armor_helmet_bronze",     new ItemArmor(     MaterialArmor.BRONZE,     EquipmentSlotType.HEAD));
    public static final RegistryObject<Item> ARMOR_HELMET_STEEL      = register("armor_helmet_steel",      new ItemArmor(     MaterialArmor.STEEL,      EquipmentSlotType.HEAD));
    public static final RegistryObject<Item> ARMOR_HELMET_AURORITE   = register("armor_helmet_aurorite",   new ItemArmorColor(MaterialArmor.AURORITE,   EquipmentSlotType.HEAD));

    // Tool Sword
    public static final RegistryObject<Item> TOOL_SWORD_BRASS      = register("tool_sword_brass",      new ToolSword(MaterialTool.BRASS,      1, -1.0f));
    public static final RegistryObject<Item> TOOL_SWORD_GILIUM     = register("tool_sword_gilium",     new ToolSword(MaterialTool.GILIUM,     1, -1.0f));
    public static final RegistryObject<Item> TOOL_SWORD_ADAMANTIUM = register("tool_sword_adamantium", new ToolSword(MaterialTool.ADAMANTIUM, 1, -1.0f));
    public static final RegistryObject<Item> TOOL_SWORD_MYTHRIL    = register("tool_sword_mythril",    new ToolSword(MaterialTool.MYTHRIL,    1, -1.0f));
    public static final RegistryObject<Item> TOOL_SWORD_ORICHALCUM = register("tool_sword_orichalcum", new ToolSword(MaterialTool.ORICHALCUM, 1, -1.0f));
    public static final RegistryObject<Item> TOOL_SWORD_COPPER     = register("tool_sword_copper",     new ToolSword(MaterialTool.COPPER,     1, -1.0f));
    public static final RegistryObject<Item> TOOL_SWORD_BRONZE     = register("tool_sword_bronze",     new ToolSword(MaterialTool.BRONZE,     1, -1.0f));
    public static final RegistryObject<Item> TOOL_SWORD_STEEL      = register("tool_sword_steel",      new ToolSword(MaterialTool.STEEL,      1, -1.0f));
    public static final RegistryObject<Item> TOOL_SWORD_AURORITE   = register("tool_sword_aurorite",   new ToolSword(MaterialTool.AURORITE,   1, -1.0f));

    // Tool Spear
    public static final RegistryObject<Item> TOOL_SPEAR_BRASS      = register("tool_spear_brass",      new ToolSpear(MaterialTool.BRASS,      1, -1.0f));
    public static final RegistryObject<Item> TOOL_SPEAR_GILIUM     = register("tool_spear_gilium",     new ToolSpear(MaterialTool.GILIUM,     1, -1.0f));
    public static final RegistryObject<Item> TOOL_SPEAR_ADAMANTIUM = register("tool_spear_adamantium", new ToolSpear(MaterialTool.ADAMANTIUM, 1, -1.0f));
    public static final RegistryObject<Item> TOOL_SPEAR_MYTHRIL    = register("tool_spear_mythril",    new ToolSpear(MaterialTool.MYTHRIL,    1, -1.0f));
    public static final RegistryObject<Item> TOOL_SPEAR_ORICHALCUM = register("tool_spear_orichalcum", new ToolSpear(MaterialTool.ORICHALCUM, 1, -1.0f));
    public static final RegistryObject<Item> TOOL_SPEAR_COPPER     = register("tool_spear_copper",     new ToolSpear(MaterialTool.COPPER,     1, -1.0f));
    public static final RegistryObject<Item> TOOL_SPEAR_BRONZE     = register("tool_spear_bronze",     new ToolSpear(MaterialTool.BRONZE,     1, -1.0f));
    public static final RegistryObject<Item> TOOL_SPEAR_STEEL      = register("tool_spear_steel",      new ToolSpear(MaterialTool.STEEL,      1, -1.0f));
    public static final RegistryObject<Item> TOOL_SPEAR_AURORITE   = register("tool_spear_aurorite",   new ToolSpear(MaterialTool.AURORITE,   1, -1.0f));

    // Tool Axe
    public static final RegistryObject<Item> TOOL_AXE_BRASS      = register("tool_axe_brass",      new ToolAxe(MaterialTool.BRASS,      1, -1.0f));
    public static final RegistryObject<Item> TOOL_AXE_GILIUM     = register("tool_axe_gilium",     new ToolAxe(MaterialTool.GILIUM,     1, -1.0f));
    public static final RegistryObject<Item> TOOL_AXE_ADAMANTIUM = register("tool_axe_adamantium", new ToolAxe(MaterialTool.ADAMANTIUM, 1, -1.0f));
    public static final RegistryObject<Item> TOOL_AXE_MYTHRIL    = register("tool_axe_mythril",    new ToolAxe(MaterialTool.MYTHRIL,    1, -1.0f));
    public static final RegistryObject<Item> TOOL_AXE_ORICHALCUM = register("tool_axe_orichalcum", new ToolAxe(MaterialTool.ORICHALCUM, 1, -1.0f));
    public static final RegistryObject<Item> TOOL_AXE_COPPER     = register("tool_axe_copper",     new ToolAxe(MaterialTool.COPPER,     1, -1.0f));
    public static final RegistryObject<Item> TOOL_AXE_BRONZE     = register("tool_axe_bronze",     new ToolAxe(MaterialTool.BRONZE,     1, -1.0f));
    public static final RegistryObject<Item> TOOL_AXE_STEEL      = register("tool_axe_steel",      new ToolAxe(MaterialTool.STEEL,      1, -1.0f));
    public static final RegistryObject<Item> TOOL_AXE_AURORITE   = register("tool_axe_aurorite",   new ToolAxe(MaterialTool.AURORITE,   1, -1.0f));

    // Tool Pickaxe
    public static final RegistryObject<Item> TOOL_PICKAXE_BRASS      = register("tool_pickaxe_brass",      new ToolPickaxe(MaterialTool.BRASS,      1, -1.0f));
    public static final RegistryObject<Item> TOOL_PICKAXE_GILIUM     = register("tool_pickaxe_gilium",     new ToolPickaxe(MaterialTool.GILIUM,     1, -1.0f));
    public static final RegistryObject<Item> TOOL_PICKAXE_ADAMANTIUM = register("tool_pickaxe_adamantium", new ToolPickaxe(MaterialTool.ADAMANTIUM, 1, -1.0f));
    public static final RegistryObject<Item> TOOL_PICKAXE_MYTHRIL    = register("tool_pickaxe_mythril",    new ToolPickaxe(MaterialTool.MYTHRIL,    1, -1.0f));
    public static final RegistryObject<Item> TOOL_PICKAXE_ORICHALCUM = register("tool_pickaxe_orichalcum", new ToolPickaxe(MaterialTool.ORICHALCUM, 1, -1.0f));
    public static final RegistryObject<Item> TOOL_PICKAXE_COPPER     = register("tool_pickaxe_copper",     new ToolPickaxe(MaterialTool.COPPER,     1, -1.0f));
    public static final RegistryObject<Item> TOOL_PICKAXE_BRONZE     = register("tool_pickaxe_bronze",     new ToolPickaxe(MaterialTool.BRONZE,     1, -1.0f));
    public static final RegistryObject<Item> TOOL_PICKAXE_STEEL      = register("tool_pickaxe_steel",      new ToolPickaxe(MaterialTool.STEEL,      1, -1.0f));
    public static final RegistryObject<Item> TOOL_PICKAXE_AURORITE   = register("tool_pickaxe_aurorite",   new ToolPickaxe(MaterialTool.AURORITE,   1, -1.0f));

    // Tool Shovel
    public static final RegistryObject<Item> TOOL_SHOVEL_BRASS      = register("tool_shovel_brass",      new ToolShovel(MaterialTool.BRASS,      1, -1.0f));
    public static final RegistryObject<Item> TOOL_SHOVEL_GILIUM     = register("tool_shovel_gilium",     new ToolShovel(MaterialTool.GILIUM,     1, -1.0f));
    public static final RegistryObject<Item> TOOL_SHOVEL_ADAMANTIUM = register("tool_shovel_adamantium", new ToolShovel(MaterialTool.ADAMANTIUM, 1, -1.0f));
    public static final RegistryObject<Item> TOOL_SHOVEL_MYTHRIL    = register("tool_shovel_mythril",    new ToolShovel(MaterialTool.MYTHRIL,    1, -1.0f));
    public static final RegistryObject<Item> TOOL_SHOVEL_ORICHALCUM = register("tool_shovel_orichalcum", new ToolShovel(MaterialTool.ORICHALCUM, 1, -1.0f));
    public static final RegistryObject<Item> TOOL_SHOVEL_COPPER     = register("tool_shovel_copper",     new ToolShovel(MaterialTool.COPPER,     1, -1.0f));
    public static final RegistryObject<Item> TOOL_SHOVEL_BRONZE     = register("tool_shovel_bronze",     new ToolShovel(MaterialTool.BRONZE,     1, -1.0f));
    public static final RegistryObject<Item> TOOL_SHOVEL_STEEL      = register("tool_shovel_steel",      new ToolShovel(MaterialTool.STEEL,      1, -1.0f));
    public static final RegistryObject<Item> TOOL_SHOVEL_AURORITE   = register("tool_shovel_aurorite",   new ToolShovel(MaterialTool.AURORITE,   1, -1.0f));

    // Tool Hoe
    public static final RegistryObject<Item> TOOL_HOE_BRASS      = register("tool_hoe_brass",      new ToolHoe(MaterialTool.BRASS,      -1.0f));
    public static final RegistryObject<Item> TOOL_HOE_GILIUM     = register("tool_hoe_gilium",     new ToolHoe(MaterialTool.GILIUM,     -1.0f));
    public static final RegistryObject<Item> TOOL_HOE_ADAMANTIUM = register("tool_hoe_adamantium", new ToolHoe(MaterialTool.ADAMANTIUM, -1.0f));
    public static final RegistryObject<Item> TOOL_HOE_MYTHRIL    = register("tool_hoe_mythril",    new ToolHoe(MaterialTool.MYTHRIL,    -1.0f));
    public static final RegistryObject<Item> TOOL_HOE_ORICHALCUM = register("tool_hoe_orichalcum", new ToolHoe(MaterialTool.ORICHALCUM, -1.0f));
    public static final RegistryObject<Item> TOOL_HOE_COPPER     = register("tool_hoe_copper",     new ToolHoe(MaterialTool.COPPER,     -1.0f));
    public static final RegistryObject<Item> TOOL_HOE_BRONZE     = register("tool_hoe_bronze",     new ToolHoe(MaterialTool.BRONZE,     -1.0f));
    public static final RegistryObject<Item> TOOL_HOE_STEEL      = register("tool_hoe_steel",      new ToolHoe(MaterialTool.STEEL,      -1.0f));
    public static final RegistryObject<Item> TOOL_HOE_AURORITE   = register("tool_hoe_aurorite",   new ToolHoe(MaterialTool.AURORITE,   -1.0f));

    // Entites
    //public static final EntityType<EntityDynamite> ENTITY_DYNAMITE = register("dynamite", EntityType.Builder.<EntityDynamite>create(EntityClassification.MISC).disableSerialization().disableSummoning().size(0.25F, 0.25F).setTrackingRange(4).setUpdateInterval(5).setCustomClientFactory(EntityDynamite::new));
    //public static final EntityType<EntityNugget>   ENTITY_NUGGET   = register("nugget",   EntityType.Builder.<EntityNugget>create(EntityClassification.MISC).disableSerialization().disableSummoning().size(0.25F, 0.25F).setTrackingRange(4).setUpdateInterval(5).setCustomClientFactory(EntityNugget::new));
    //public static final EntityType<EntitySpear>    ENTITY_SPEAR    = register("spear",    EntityType.Builder.<EntitySpear>create(EntityClassification.MISC).disableSerialization().disableSummoning().size(0.25F, 0.25F).setTrackingRange(4).setUpdateInterval(5).setCustomClientFactory(EntitySpear::new));
    //public static final EntityType<EntityCrab>     ENTITY_CRAB     = register("crab",     EntityCrab.class,   EntityCrab::new, 1, 1, 1, 1);
    public static final RegistryObject<EntityType<EntityDynamite>> ENTITY_DYNAMITE = ENTITIES.register("dynamite", () -> EntityType.Builder.<EntityDynamite>create(EntityDynamite::new, EntityClassification.MISC).size(0.5f, 0.5f).setTrackingRange(4).setUpdateInterval(5).setCustomClientFactory(EntityDynamite::new).build(new ResourceLocation(MODID, "dynamite").toString()));
    public static final RegistryObject<EntityType<EntityNugget>>   ENTITY_NUGGET   = ENTITIES.register("nugget",   () -> EntityType.Builder.<EntityNugget>create(EntityNugget::new, EntityClassification.MISC).size(0.5f, 0.5f).setTrackingRange(4).setUpdateInterval(5).setCustomClientFactory(EntityNugget::new).build(new ResourceLocation(MODID, "nugget").toString()));
    public static final RegistryObject<EntityType<EntitySpear>>    ENTITY_SPEAR    = ENTITIES.register("spear",    () -> EntityType.Builder.<EntitySpear>create(EntitySpear::new, EntityClassification.MISC).size(0.5f, 0.5f).setTrackingRange(4).setUpdateInterval(5).setCustomClientFactory(EntitySpear::new).build(new ResourceLocation(MODID, "spear").toString()));
    public static final RegistryObject<EntityType<EntityCrab>>     ENTITY_CRAB     = ENTITIES.register("crab",     () -> EntityType.Builder.<EntityCrab>create(EntityCrab::new, EntityClassification.CREATURE).size(1.0f, 1.0f).setTrackingRange(64).setUpdateInterval(1).build(new ResourceLocation(MODID, "crab").toString()));

    // Container
    public static final RegistryObject<ContainerType<ContainerFoundry>>      CONTAINER_FOUNDRY      = CONTAINERS.register("foundry",      () -> IForgeContainerType.create(ContainerFoundry::new));
    public static final RegistryObject<ContainerType<ContainerDistillery>>   CONTAINER_DISTILLERY   = CONTAINERS.register("distillery",   () -> IForgeContainerType.create(ContainerDistillery::new));
    public static final RegistryObject<ContainerType<ContainerCookingBoard>> CONTAINER_COOKINGBOARD = CONTAINERS.register("cookingboard", () -> IForgeContainerType.create(ContainerCookingBoard::new));

    // TileEntites   (We don't have a datafixer for our TileEntities, so we pass null into build.)
    public static final RegistryObject<TileEntityType<TileFoundry>>      TILE_FOUNDRY      = TILES.register("foundry",      () -> TileEntityType.Builder.create(TileFoundry::new,      MACHINA_FOUNDRY.get()).build(null));
    public static final RegistryObject<TileEntityType<TileDistillery>>   TILE_DISTILLERY   = TILES.register("distillery",   () -> TileEntityType.Builder.create(TileDistillery::new,   MACHINA_DISTILLERY.get()).build(null));
    public static final RegistryObject<TileEntityType<TileCookingBoard>> TILE_COOKINGBOARD = TILES.register("cookingboard", () -> TileEntityType.Builder.create(TileCookingBoard::new, MACHINA_COOKINGBOARD.get()).build(null));

    // Spawn Eggs
    public static final RegistryObject<Item> SPAWNEGG_CRAB   = register("spawnegg_crab",   new ItemSpawnEgg(ENTITY_CRAB, 0xF0A5A2, 0xA9672B, new Item.Properties().group(ItemGroup.MATERIALS)));

    // Recipe Serializers
    public static final RecipeDistillerySerializer   serializerDistillery   = null;
    public static final RecipeCookingBoardSerializer serializerCookingBoard = null;
    //public static final RegistryObject<IRecipeSerializer<RecipeDistillerySerializer>> RECIPE_DISTILLERY = RECIPES.register("distillery", () -> new RecipeDistillerySerializer(RecipeDistillery::new));

    // Sounds
    public static final RegistryObject<SoundEvent> ALPACA_IDLE  = SOUNDS.register("alpaca.idle",  () -> new SoundEvent(new ResourceLocation(MODID, "alpaca.idle" )));
    public static final RegistryObject<SoundEvent> ALPACA_BABY  = SOUNDS.register("alpaca.baby",  () -> new SoundEvent(new ResourceLocation(MODID, "alpaca.baby" )));
    public static final RegistryObject<SoundEvent> ALPACA_DEATH = SOUNDS.register("alpaca.death", () -> new SoundEvent(new ResourceLocation(MODID, "alpaca.death")));
    public static final RegistryObject<SoundEvent> ALPACA_HURT  = SOUNDS.register("alpaca.hurt",  () -> new SoundEvent(new ResourceLocation(MODID, "alpaca.hurt" )));




    //----------------------------------------Register Functions----------------------------------------//

    static void register(){
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private static RegistryObject<Block> register(String name, Block block){
        return register(name, block, null);
    }

    private static RegistryObject<Block> register(String name, Block block, ItemGroup itemGroup){
        if(itemGroup != null){ ITEMS.register(name, () -> new BlockItem(block, (new Item.Properties()).group(itemGroup))); }
        return BLOCKS.register(name, () -> block);
    }

    private static RegistryObject<Item> register(String name, Item item){
        return ITEMS.register(name, () -> item);
    }




    //----------------------------------------Setup Functions----------------------------------------//

    static void setup(FMLCommonSetupEvent event){
        for (Biome biome : ForgeRegistries.BIOMES) {
//
//
//
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ShopKeeper.ORE_COPPER.get().getDefaultState(), 7)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 128))));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ShopKeeper.ORE_MYTHRIL.get().getDefaultState(), 7)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 32))));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ShopKeeper.ORE_TIN.get().getDefaultState(), 5)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 64))));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ShopKeeper.ORE_ZINC.get().getDefaultState(), 5)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 64))));
            //biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ShopKeeper.ORE_SILVER.getDefaultState(), 5), Placement.COUNT_RANGE, new CountRangeConfig(10, 0, 0, 64)));
//
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ShopKeeper.ORE_AURORITE.get().getDefaultState(), 3)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 0, 0, 64))));
            //biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ShopKeeper.ORE_CITRINE.getDefaultState(), 4), Placement.COUNT_RANGE, new CountRangeConfig(4, 0, 0, 64)));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ShopKeeper.ORE_RUBY.get().getDefaultState(), 4)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 0, 0, 64))));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ShopKeeper.ORE_SAPPHIRE.get().getDefaultState(), 4)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 0, 0, 64))));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ShopKeeper.ORE_AMETHYST.get().getDefaultState(), 4)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 0, 0, 64))));
//
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ShopKeeper.ORE_SALT.get().getDefaultState(), 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 96))));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ShopKeeper.ORE_SULFUR.get().getDefaultState(), 8)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(8, 0, 0, 64))));
//
//
            //     //biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature..withConfiguration(new DecoratedFeatureConfig(ConfiguredFeature.deserialize(), ShopKeeper.FLOWER_MATSUTAKE.getDefaultState()), Placement.COUNT_CHANCE_HEIGHTMAP, new HeightWithChanceConfig(2, 0.005F)));
            //     //biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.DECORATED_FLOWER.withConfiguration(new DecoratedFeatureConfig(ShopKeeper.FLOWER_BAMBOO.getDefaultState()), Placement.COUNT_CHANCE_HEIGHTMAP, new HeightWithChanceConfig(2, 0.005F)));
////
            //     //biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.DECORATED_FLOWER.withConfiguration(new DecoratedFeatureConfig(ShopKeeper.FLOWER_MOONDROP.getDefaultState()), Placement.COUNT_CHANCE_HEIGHTMAP, new HeightWithChanceConfig(3, 0.005F)));
            //     //biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.DECORATED_FLOWER.withConfiguration(new DecoratedFeatureConfig(ShopKeeper.FLOWER_MAGICGRASS.getDefaultState()), Placement.COUNT_CHANCE_HEIGHTMAP, new HeightWithChanceConfig(3, 0.005F)));
            //     //biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.DECORATED_FLOWER.withConfiguration(new DecoratedFeatureConfig(ShopKeeper.FLOWER_TOYFLOWER.getDefaultState()), Placement.COUNT_CHANCE_HEIGHTMAP, new HeightWithChanceConfig(3, 0.005F)));
            //     //biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.DECORATED_FLOWER.withConfiguration(new DecoratedFeatureConfig(ShopKeeper.FLOWER_PINKCAT.getDefaultState()), Placement.COUNT_CHANCE_HEIGHTMAP, new HeightWithChanceConfig(3, 0.005F)));
        }

        //Biomes.NETHER.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, ShopKeeper.ORE_GILIUM.get().getDefaultState(), 9)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(10, 0, 0, 128))));
        //Biomes.NETHER.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, ShopKeeper.ORE_NIVIDIUM.getDefaultState(), 7), Placement.COUNT_RANGE, new CountRangeConfig(10, 0, 0, 64)));
        //Biomes.NETHER.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, ShopKeeper.ORE_CLAVIUM.getDefaultState(), 7), Placement.COUNT_RANGE, new CountRangeConfig(10, 0, 0, 64)));
    }

    @OnlyIn(Dist.CLIENT)
    static void setup(FMLClientSetupEvent event){
        DeferredWorkQueue.runLater(() -> {
            ScreenManager.registerFactory(CONTAINER_FOUNDRY.get(), ScreenFoundry::new);
            ScreenManager.registerFactory(CONTAINER_DISTILLERY.get(), ScreenDistillery::new);
            ScreenManager.registerFactory(CONTAINER_COOKINGBOARD.get(), ScreenCookingBoard::new);
            //ScreenManager.<TYPE_BLASTFURNACE, GuiBlastFurnace>registerFactory(TYPE_BLASTFURNACE, GuiBlastFurnace::new);
        });

        RenderingRegistry.registerEntityRenderingHandler(ENTITY_CRAB.get(), RenderCrab::new);
        RenderingRegistry.registerEntityRenderingHandler(ENTITY_DYNAMITE.get(), RenderDynamite::new);
        RenderingRegistry.registerEntityRenderingHandler(ENTITY_SPEAR.get(), RenderSpear::new);
        RenderingRegistry.registerEntityRenderingHandler(ENTITY_NUGGET.get(), RenderNugget::new);
    }




    //----------------------------------------Custom Functions----------------------------------------//

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @ObjectHolder(MODID)
    @Mod.EventBusSubscriber(bus= Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void registerSerializer(RegistryEvent.Register<IRecipeSerializer<?>> event) {
            IForgeRegistry<IRecipeSerializer<?>> registry = event.getRegistry();
            registry.register(new RecipeDistillerySerializer(RecipeDistillery::new).setRegistryName(MODID, "distillery"));
            registry.register(new RecipeCookingBoardSerializer(RecipeCookingBoard::new).setRegistryName(MODID, "cookingboard"));
        }

        @SubscribeEvent
        public void villagerTrades(VillagerTradesEvent event){
            if(event.getType() == VillagerProfession.FARMER){
                event.getTrades().get(1).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(ShopKeeper.FOOD_RICEBALL.get(), 16), 8, 10, 0F));
                event.getTrades().get(1).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(ShopKeeper.ITEM_CURRY.get(),    16), 8, 10, 0F));
                //RandomTradeBuilder.forEachLevel((level, tradeBuild) -> event.getTrades().get(level.intValue()).add(tradeBuild.build()));
            }
        }

        @SubscribeEvent
        public void wandererTrades(WandererTradesEvent event){
            //List<ITrade> genericList = event.getGenericTrades();
            //RandomTradeBuilder.forEachWanderer((tradeBuild) -> genericList.add(tradeBuild.build()));
            //List<ITrade> rareList = event.getRareTrades();
            //RandomTradeBuilder.forEachWandererRare((tradeBuild) -> rareList.add(tradeBuild.build()));
        }
    }

    static void addSpawn() {
        List<Biome> spawnableBiomes = Lists.newArrayList();
        List<BiomeDictionary.Type> includeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(Config.SPAWN.include.get()));
        List<BiomeDictionary.Type> excludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(Config.SPAWN.exclude.get()));
        if (!includeList.isEmpty()) {
            for (BiomeDictionary.Type type : includeList) {
                for (Biome biome : BiomeDictionary.getBiomes(type)) {
                    if (!biome.getSpawns(EntityClassification.CREATURE).isEmpty()) {
                        spawnableBiomes.add(biome);
                    }
                }
            }
            if (!excludeList.isEmpty()) {
                for (BiomeDictionary.Type type : excludeList) {
                    Set<Biome> excludeBiomes = BiomeDictionary.getBiomes(type);
                    for (Biome biome : excludeBiomes) {
                        spawnableBiomes.remove(biome);
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Do not leave the BiomeDictionary type inclusion list empty. If you wish to disable spawning of an entity, set the weight to 0 instead.");
        }
        for (Biome biome : spawnableBiomes) {
            //biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(ENTITY_CRAB, 1, 2, 5));
        }
    }

    private static final Map<VillagerProfession, Int2ObjectMap<VillagerTrades.ITrade[]>> VANILLA_TRADES = new HashMap<>();



    static void addTrades() {
        addVillagerTrades(VillagerProfession.FARMER,  VillagerUtil.newTradeMap(ImmutableMap.of(1, new VillagerTrades.ITrade[] {
                new VillagerUtil.ItemsForEmeraldsTrade(FOOD_RICEBALL.get(), 16, 16, 1),
                new VillagerUtil.ItemsForEmeraldsTrade(ITEM_CURRY.get(), 16, 16, 1),
        })));
    }


    public static void addVillagerTrades(VillagerProfession prof, Int2ObjectMap<VillagerTrades.ITrade[]> newTrades) {
        Int2ObjectMap<VillagerTrades.ITrade[]> profTrades = VANILLA_TRADES.getOrDefault(prof, new Int2ObjectOpenHashMap<>());
        Int2ObjectMap<List<VillagerTrades.ITrade>> mutableTrades = new Int2ObjectOpenHashMap<>();
        Int2ObjectMap<VillagerTrades.ITrade[]> newProfList = newTrades;
        for(int i = 1; i < 6; i++){ mutableTrades.put(i, NonNullList.create()); }
        newProfList.int2ObjectEntrySet().forEach(e -> { Arrays.stream(e.getValue()).forEach(mutableTrades.get(e.getIntKey())::add); });
        profTrades.int2ObjectEntrySet().forEach(e -> { Arrays.stream(e.getValue()).forEach(mutableTrades.get(e.getIntKey())::add); });
        MinecraftForge.EVENT_BUS.post(new VillagerTradesEvent(mutableTrades, prof));
        mutableTrades.int2ObjectEntrySet().forEach(e -> newProfList.put(e.getIntKey(), e.getValue().toArray(new VillagerTrades.ITrade[0])));
        VillagerTrades.VILLAGER_DEFAULT_TRADES.put(prof, newProfList);
    }

}
