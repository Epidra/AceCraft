package mod.acecraft;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import mod.acecraft.blocks.*;
import mod.acecraft.container.ContainerBlastFurnace;
import mod.acecraft.container.ContainerDestille;
import mod.acecraft.crafting.RecipeDestille;
import mod.acecraft.crafting.RecipeStove;
import mod.acecraft.gui.GuiBlastFurnace;
import mod.acecraft.gui.GuiDistille;
import mod.acecraft.items.*;
import mod.acecraft.util.MaterialArmor;
import mod.acecraft.util.MaterialTool;
import mod.shared.Register;
import mod.shared.blocks.BlockBlock;
import mod.shared.items.ItemItem;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemTier;
import net.minecraft.item.crafting.CookingRecipeSerializer;
import net.minecraft.item.crafting.FurnaceRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

import java.nio.file.Path;

import static mod.acecraft.AceCraft.MODID;

public class ShopKeeper {

    // Blocks
    public static final Block BLOCK_BRASS      = new BlockBlock(MODID, "block_brass",      Blocks.IRON_BLOCK);
    public static final Block BLOCK_QUESTORIUM = new BlockBlock(MODID, "block_questorium", Blocks.IRON_BLOCK);
    public static final Block BLOCK_GILIUM     = new BlockBlock(MODID, "block_gilium",     Blocks.IRON_BLOCK);
    public static final Block BLOCK_ADAMANTIUM = new BlockBlock(MODID, "block_adamantium", Blocks.IRON_BLOCK);
    public static final Block BLOCK_VIRIDIUM   = new BlockBlock(MODID, "block_viridium",   Blocks.IRON_BLOCK);
    public static final Block BLOCK_ZINC       = new BlockBlock(MODID, "block_zinc",       Blocks.IRON_BLOCK);
    public static final Block BLOCK_KOBALIUM   = new BlockBlock(MODID, "block_kobalium",   Blocks.IRON_BLOCK);
    public static final Block BLOCK_DENARIUM   = new BlockBlock(MODID, "block_denarium",   Blocks.IRON_BLOCK);
    public static final Block BLOCK_MYTHRIL    = new BlockBlock(MODID, "block_mythril",    Blocks.IRON_BLOCK);
    public static final Block BLOCK_CLAVIUM    = new BlockBlock(MODID, "block_clavium",    Blocks.IRON_BLOCK);
    public static final Block BLOCK_AURELIUM   = new BlockBlock(MODID, "block_aurelium",   Blocks.IRON_BLOCK);
    public static final Block BLOCK_NIVIDIUM   = new BlockBlock(MODID, "block_nividium",   Blocks.IRON_BLOCK);
    public static final Block BLOCK_TIN        = new BlockBlock(MODID, "block_tin",        Blocks.IRON_BLOCK);
    public static final Block BLOCK_ORICHALCUM = new BlockBlock(MODID, "block_orichalcum", Blocks.IRON_BLOCK);
    public static final Block BLOCK_SCARLETITE = new BlockBlock(MODID, "block_scarletite", Blocks.IRON_BLOCK);
    public static final Block BLOCK_COPPER     = new BlockBlock(MODID, "block_copper",     Blocks.IRON_BLOCK);
    public static final Block BLOCK_BRONZE     = new BlockBlock(MODID, "block_bronze",     Blocks.IRON_BLOCK);
    public static final Block BLOCK_STEEL      = new BlockBlock(MODID, "block_steel",      Blocks.IRON_BLOCK);
    public static final Block BLOCK_DARKSTEEL  = new BlockBlock(MODID, "block_darksteel",  Blocks.IRON_BLOCK);
    public static final Block BLOCK_UNOBTANIUM = new BlockBlock(MODID, "block_unobtanium", Blocks.IRON_BLOCK);

    // Ore
    public static final Block ORE_BRASS      = new BlockBlock(MODID, "ore_brass",      Blocks.IRON_BLOCK);
    public static final Block ORE_QUESTORIUM = new BlockBlock(MODID, "ore_questorium", Blocks.IRON_BLOCK);
    public static final Block ORE_GILIUM     = new BlockBlock(MODID, "ore_gilium",     Blocks.IRON_BLOCK);
    public static final Block ORE_ADAMANTIUM = new BlockBlock(MODID, "ore_adamantium", Blocks.IRON_BLOCK);
    public static final Block ORE_VIRIDIUM   = new BlockBlock(MODID, "ore_viridium",   Blocks.IRON_BLOCK);
    public static final Block ORE_ZINC       = new BlockBlock(MODID, "ore_zinc",       Blocks.IRON_BLOCK);
    public static final Block ORE_KOBALIUM   = new BlockBlock(MODID, "ore_kobalium",   Blocks.IRON_BLOCK);
    public static final Block ORE_DENARIUM   = new BlockBlock(MODID, "ore_denarium",   Blocks.IRON_BLOCK);
    public static final Block ORE_MYTHRIL    = new BlockBlock(MODID, "ore_mythril",    Blocks.IRON_BLOCK);
    public static final Block ORE_CLAVIUM    = new BlockBlock(MODID, "ore_clavium",    Blocks.IRON_BLOCK);
    public static final Block ORE_AURELIUM   = new BlockBlock(MODID, "ore_aurelium",   Blocks.IRON_BLOCK);
    public static final Block ORE_NIVIDIUM   = new BlockBlock(MODID, "ore_nividium",   Blocks.IRON_BLOCK);
    public static final Block ORE_TIN        = new BlockBlock(MODID, "ore_tin",        Blocks.IRON_BLOCK);
    public static final Block ORE_ORICHALCUM = new BlockBlock(MODID, "ore_orichalcum", Blocks.IRON_BLOCK);
    public static final Block ORE_SCARLETITE = new BlockBlock(MODID, "ore_scarletite", Blocks.IRON_BLOCK);
    public static final Block ORE_COPPER     = new BlockBlock(MODID, "ore_copper",     Blocks.IRON_BLOCK);
    public static final Block ORE_BRONZE     = new BlockBlock(MODID, "ore_bronze",     Blocks.IRON_BLOCK);
    public static final Block ORE_STEEL      = new BlockBlock(MODID, "ore_steel",      Blocks.IRON_BLOCK);
    public static final Block ORE_DARKSTEEL  = new BlockBlock(MODID, "ore_darksteel",  Blocks.IRON_BLOCK);
    public static final Block ORE_UNOBTANIUM = new BlockBlock(MODID, "ore_unobtanium", Blocks.IRON_BLOCK);

    // Nuggets
    public static final Item NUGGET_BRASS      = new ItemItem(MODID, "nugget_brass",      ItemGroup.MATERIALS);
    public static final Item NUGGET_QUESTORIUM = new ItemItem(MODID, "nugget_questorium", ItemGroup.MATERIALS);
    public static final Item NUGGET_GILIUM     = new ItemItem(MODID, "nugget_gilium",     ItemGroup.MATERIALS);
    public static final Item NUGGET_ADAMANTIUM = new ItemItem(MODID, "nugget_adamantium", ItemGroup.MATERIALS);
    public static final Item NUGGET_VIRIDIUM   = new ItemItem(MODID, "nugget_viridium",   ItemGroup.MATERIALS);
    public static final Item NUGGET_ZINC       = new ItemItem(MODID, "nugget_zinc",       ItemGroup.MATERIALS);
    public static final Item NUGGET_KOBALIUM   = new ItemItem(MODID, "nugget_kobalium",   ItemGroup.MATERIALS);
    public static final Item NUGGET_DENARIUM   = new ItemItem(MODID, "nugget_denarium",   ItemGroup.MATERIALS);
    public static final Item NUGGET_MYTHRIL    = new ItemItem(MODID, "nugget_mythril",    ItemGroup.MATERIALS);
    public static final Item NUGGET_CLAVIUM    = new ItemItem(MODID, "nugget_clavium",    ItemGroup.MATERIALS);
    public static final Item NUGGET_AURELIUM   = new ItemItem(MODID, "nugget_aurelium",   ItemGroup.MATERIALS);
    public static final Item NUGGET_NIVIDIUM   = new ItemItem(MODID, "nugget_nividium",   ItemGroup.MATERIALS);
    public static final Item NUGGET_TIN        = new ItemItem(MODID, "nugget_tin",        ItemGroup.MATERIALS);
    public static final Item NUGGET_ORICHALCUM = new ItemItem(MODID, "nugget_orichalcum", ItemGroup.MATERIALS);
    public static final Item NUGGET_SCARLETITE = new ItemItem(MODID, "nugget_scarletite", ItemGroup.MATERIALS);
    public static final Item NUGGET_COPPER     = new ItemItem(MODID, "nugget_copper",     ItemGroup.MATERIALS);
    public static final Item NUGGET_BRONZE     = new ItemItem(MODID, "nugget_bronze",     ItemGroup.MATERIALS);
    public static final Item NUGGET_STEEL      = new ItemItem(MODID, "nugget_steel",      ItemGroup.MATERIALS);
    public static final Item NUGGET_DARKSTEEL  = new ItemItem(MODID, "nugget_darksteel",  ItemGroup.MATERIALS);
    public static final Item NUGGET_UNOBTANIUM = new ItemItem(MODID, "nugget_unobtanium", ItemGroup.MATERIALS);

    // Ingots
    public static final Item INGOT_BRASS      = new ItemItem(MODID, "ingot_brass",      ItemGroup.MATERIALS);
    public static final Item INGOT_QUESTORIUM = new ItemItem(MODID, "ingot_questorium", ItemGroup.MATERIALS);
    public static final Item INGOT_GILIUM     = new ItemItem(MODID, "ingot_gilium",     ItemGroup.MATERIALS);
    public static final Item INGOT_ADAMANTIUM = new ItemItem(MODID, "ingot_adamantium", ItemGroup.MATERIALS);
    public static final Item INGOT_VIRIDIUM   = new ItemItem(MODID, "ingot_viridium",   ItemGroup.MATERIALS);
    public static final Item INGOT_ZINC       = new ItemItem(MODID, "ingot_zinc",       ItemGroup.MATERIALS);
    public static final Item INGOT_KOBALIUM   = new ItemItem(MODID, "ingot_kobalium",   ItemGroup.MATERIALS);
    public static final Item INGOT_DENARIUM   = new ItemItem(MODID, "ingot_denarium",   ItemGroup.MATERIALS);
    public static final Item INGOT_MYTHRIL    = new ItemItem(MODID, "ingot_mythril",    ItemGroup.MATERIALS);
    public static final Item INGOT_CLAVIUM    = new ItemItem(MODID, "ingot_clavium",    ItemGroup.MATERIALS);
    public static final Item INGOT_AURELIUM   = new ItemItem(MODID, "ingot_aurelium",   ItemGroup.MATERIALS);
    public static final Item INGOT_NIVIDIUM   = new ItemItem(MODID, "ingot_nividium",   ItemGroup.MATERIALS);
    public static final Item INGOT_TIN        = new ItemItem(MODID, "ingot_tin",        ItemGroup.MATERIALS);
    public static final Item INGOT_ORICHALCUM = new ItemItem(MODID, "ingot_orichalcum", ItemGroup.MATERIALS);
    public static final Item INGOT_SCARLETITE = new ItemItem(MODID, "ingot_scarletite", ItemGroup.MATERIALS);
    public static final Item INGOT_COPPER     = new ItemItem(MODID, "ingot_copper",     ItemGroup.MATERIALS);
    public static final Item INGOT_BRONZE     = new ItemItem(MODID, "ingot_bronze",     ItemGroup.MATERIALS);
    public static final Item INGOT_STEEL      = new ItemItem(MODID, "ingot_steel",      ItemGroup.MATERIALS);
    public static final Item INGOT_DARKSTEEL  = new ItemItem(MODID, "ingot_darksteel",  ItemGroup.MATERIALS);
    public static final Item INGOT_UNOBTANIUM = new ItemItem(MODID, "ingot_unobtanium", ItemGroup.MATERIALS);




    public static final Block BLOCK_AURORITE = new BlockBlock(MODID, "block_aurorite", Blocks.DIAMOND_BLOCK);
    public static final Block BLOCK_RUBY = new BlockBlock(MODID, "block_ruby", Blocks.DIAMOND_BLOCK);
    public static final Block BLOCK_TOPAZ = new BlockBlock(MODID, "block_topaz", Blocks.DIAMOND_BLOCK);
    public static final Block BLOCK_SAPPHIRE = new BlockBlock(MODID, "block_sapphire", Blocks.DIAMOND_BLOCK);
    public static final Block BLOCK_AMETHYST = new BlockBlock(MODID, "block_amethyst", Blocks.DIAMOND_BLOCK);
    public static final Block BLOCK_CITRINE = new BlockBlock(MODID, "block_citrine", Blocks.DIAMOND_BLOCK);

    // Gems
    public static final Item GEM_AURORITE = new ItemItem(MODID, "gem_aurorite", ItemGroup.MISC);
    public static final Item GEM_RUBY = new ItemItem(MODID, "gem_ruby", ItemGroup.MISC);
    public static final Item GEM_TOPAZ = new ItemItem(MODID, "gem_topaz", ItemGroup.MISC);
    public static final Item GEM_SAPPHIRE = new ItemItem(MODID, "gem_sapphire", ItemGroup.MISC);
    public static final Item GEM_AMETHYST = new ItemItem(MODID, "gem_amethyst", ItemGroup.MISC);
    public static final Item GEM_CITRINE = new ItemItem(MODID, "gem_citrine", ItemGroup.MISC);
    public static final Item GEM_JADE = new ItemItem(MODID, "gem_jade", ItemGroup.MISC);

    // Other Blocks
    public static final Block BLOCK_SALT = new BlockBlock(MODID, "block_salt", Blocks.SAND);
    public static final Block BLOCK_SULFUR = new BlockBlock(MODID, "block_sulfur", Blocks.SAND);
    public static final Block BLOCK_JADE = new BlockBlock(MODID, "block_jade", Blocks.SAND);
    public static final Block BLOCK_FLOUR = new BlockBlock(MODID, "block_flour", Blocks.SAND);
    public static final Block BLOCK_COFFEE = new BlockBlock(MODID, "block_coffee", Blocks.SAND);

    public static final Block ORE_AURORITE = new BlockOre(MODID, "ore_aurorite", Blocks.DIAMOND_ORE);
    public static final Block ORE_RUBY = new BlockOre(MODID, "ore_ruby", Blocks.DIAMOND_ORE);
    public static final Block ORE_TOPAZ = new BlockOre(MODID, "ore_topaz", Blocks.DIAMOND_ORE);
    public static final Block ORE_SAPPHIRE = new BlockOre(MODID, "ore_sapphire", Blocks.DIAMOND_ORE);
    public static final Block ORE_AMETHYST = new BlockOre(MODID, "ore_amethyst", Blocks.DIAMOND_ORE);
    public static final Block ORE_CITRINE = new BlockOre(MODID, "ore_citrine", Blocks.DIAMOND_ORE);

    public static final Block ORE_SALT = new BlockOre(MODID, "ore_salt", Blocks.LAPIS_ORE);
    public static final Block ORE_SULFUR = new BlockOre(MODID, "ore_sulfur", Blocks.LAPIS_ORE);
    public static final Block ORE_JADE = new BlockOre(MODID, "ore_jade", Blocks.LAPIS_ORE);

    public static final Block CROP_COFFEE = new BlockCrop(MODID, "crop_coffee", 7,  Blocks.GRASS);
    public static final Block CROP_TURNIP = new BlockCrop(MODID, "crop_turnip", 7, Blocks.GRASS);
    public static final Block CROP_CABBAGE = new BlockCrop(MODID, "crop_cabbage", 7, Blocks.GRASS);
    public static final Block CROP_TOMATO = new BlockCrop(MODID, "crop_tomato", 7, Blocks.GRASS);
    public static final Block CROP_CUCUMBER = new BlockCrop(MODID, "crop_cucumber", 7, Blocks.GRASS);
    public static final Block CROP_RICE = new BlockCrop(MODID, "crop_rice", 7, Blocks.GRASS);
    public static final Block CROP_CORN = new BlockCrop(MODID, "crop_corn", 7, Blocks.GRASS);
    public static final Block CROP_GRAPES = new BlockCrop(MODID, "crop_grapes", 7, Blocks.GRASS);
    public static final Block CROP_HEMP = new BlockCrop(MODID, "crop_hemp", 7, Blocks.GRASS);
    public static final Block CROP_COTTON = new BlockCrop(MODID, "crop_cotton", 7, Blocks.GRASS);
    public static final Block CROP_STRAWBERRIES = new BlockCrop(MODID, "crop_strawberries", 7, Blocks.GRASS);
    public static final Block CROP_ONION = new BlockCrop(MODID, "crop_onion", 7, Blocks.GRASS);
    public static final Block CROP_PINEAPPLE = new BlockCrop(MODID, "crop_pineapple", 7, Blocks.GRASS);
    public static final Block CROP_EGGPLANT = new BlockCrop(MODID, "crop_eggplant", 7, Blocks.GRASS);
    public static final Block CROP_SPINACH = new BlockCrop(MODID, "crop_spinach", 7, Blocks.GRASS);
    public static final Block CROP_YAMS = new BlockCrop(MODID, "crop_yams", 7, Blocks.GRASS);
    public static final Block CROP_PEPPER = new BlockCrop(MODID, "crop_pepper", 7, Blocks.GRASS);

    public static final Block FLOWER_BAMBOO = new BlockBush(MODID, "flower_bamboo", Blocks.CORNFLOWER);
    public static final Block FLOWER_MATSUTAKE = new BlockBush(MODID, "flower_matsutake", Blocks.CORNFLOWER);
    public static final Block FLOWER_MOONDROP = new BlockBush(MODID, "flower_moondrop", Blocks.CORNFLOWER);
    public static final Block FLOWER_TOYFLOWER = new BlockBush(MODID, "flower_toyflower", Blocks.CORNFLOWER);
    public static final Block FLOWER_PINKCAT = new BlockBush(MODID, "flower_pinkcat", Blocks.CORNFLOWER);
    public static final Block FLOWER_MAGICGRASS = new BlockBush(MODID, "flower_magicgrass", Blocks.CORNFLOWER);

    public static final Item FOOD_COFFEE = new ItemFood(MODID, "food_coffee", 4, 0.4f);
    public static final Item FOOD_TURNIP = new ItemFood(MODID, "food_turnip",  4, 0.4f);
    public static final Item FOOD_CABBAGE = new ItemFood(MODID, "food_cabbage",  4, 0.4f);
    public static final Item FOOD_TOMATO = new ItemFood(MODID, "food_tomato",  4, 0.4f);
    public static final Item FOOD_CUCUMBER = new ItemFood(MODID, "food_cucumber",  4, 0.4f);
    public static final Item FOOD_RICE = new ItemFood(MODID, "food_rice",  4, 0.4f);
    public static final Item FOOD_CORN = new ItemFood(MODID, "food_corn",  4, 0.4f);
    public static final Item FOOD_GRAPES = new ItemFood(MODID, "food_grapes",  4, 0.4f);
    public static final Item FOOD_STRAWBERRIES = new ItemFood(MODID, "food_strawberries",  4, 0.4f);
    public static final Item FOOD_ONION = new ItemFood(MODID, "food_onion",  4, 0.4f);
    public static final Item FOOD_PINEAPPLE = new ItemFood(MODID, "food_pineapple",  4, 0.4f);
    public static final Item FOOD_EGGPLANT = new ItemFood(MODID, "food_eggplant",  4, 0.4f);
    public static final Item FOOD_SPINACH = new ItemFood(MODID, "food_spinach",  4, 0.4f);
    public static final Item FOOD_YAMS = new ItemFood(MODID, "food_yams",  4, 0.4f);
    public static final Item FOOD_PEPPER = new ItemFood(MODID, "food_pepper",  4, 0.4f);

    public static final Item SEEDS_WILD = new ItemSeedWild(MODID, "seeds_wild", new Item.Properties().group(ItemGroup.FOOD));
    public static final Item SEEDS_COFFEE = new ItemSeed(MODID, "seeds_coffee", CROP_COFFEE, new Item.Properties().group(ItemGroup.FOOD));
    public static final Item SEEDS_TURNIP = new ItemSeed(MODID, "seeds_turnip", CROP_TURNIP, new Item.Properties().group(ItemGroup.FOOD));
    public static final Item SEEDS_CABBAGE = new ItemSeed(MODID, "seeds_cabbage", CROP_CABBAGE, new Item.Properties().group(ItemGroup.FOOD));
    public static final Item SEEDS_TOMATO = new ItemSeed(MODID, "seeds_tomato", CROP_TOMATO, new Item.Properties().group(ItemGroup.FOOD));
    public static final Item SEEDS_CUCUMBER = new ItemSeed(MODID, "seeds_cucumber", CROP_CUCUMBER, new Item.Properties().group(ItemGroup.FOOD));
    public static final Item SEEDS_RICE = new ItemSeed(MODID, "seeds_rice", CROP_RICE, new Item.Properties().group(ItemGroup.FOOD));
    public static final Item SEEDS_CORN = new ItemSeed(MODID, "seeds_corn", CROP_CORN, new Item.Properties().group(ItemGroup.FOOD));
    public static final Item SEEDS_GRAPES = new ItemSeed(MODID, "seeds_grapes", CROP_GRAPES, new Item.Properties().group(ItemGroup.FOOD));
    public static final Item SEEDS_HEMP = new ItemSeed(MODID, "seeds_hemp", CROP_HEMP, new Item.Properties().group(ItemGroup.FOOD));
    public static final Item SEEDS_COTTON = new ItemSeed(MODID, "seeds_cotton", CROP_COTTON, new Item.Properties().group(ItemGroup.FOOD));
    public static final Item SEEDS_STRAWBERRIES = new ItemSeed(MODID, "seeds_strawberries", CROP_STRAWBERRIES, new Item.Properties().group(ItemGroup.FOOD));
    public static final Item SEEDS_ONION = new ItemSeed(MODID, "seeds_onion", CROP_ONION, new Item.Properties().group(ItemGroup.FOOD));
    public static final Item SEEDS_PINEAPPLE = new ItemSeed(MODID, "seeds_pineapple", CROP_PINEAPPLE, new Item.Properties().group(ItemGroup.FOOD));
    public static final Item SEEDS_EGGPLANT = new ItemSeed(MODID, "seeds_eggplant", CROP_EGGPLANT, new Item.Properties().group(ItemGroup.FOOD));
    public static final Item SEEDS_SPINACH = new ItemSeed(MODID, "seeds_spinach", CROP_SPINACH, new Item.Properties().group(ItemGroup.FOOD));
    public static final Item SEEDS_YAMS = new ItemSeed(MODID, "seeds_yams", CROP_YAMS, new Item.Properties().group(ItemGroup.FOOD));
    public static final Item SEEDS_PEPPER = new ItemSeed(MODID, "seeds_pepper", CROP_PEPPER, new Item.Properties().group(ItemGroup.FOOD));

    public static final Item FOOD_VENISON_RAW = new ItemFood(MODID, "food_venison_raw",  4, 0.4f);
    public static final Item FOOD_VENISON_COOKED = new ItemFood(MODID, "food_venison_cooked",  4, 0.4f);
    public static final Item FOOD_VICUGNA_RAW = new ItemFood(MODID, "food_vicugna_raw",  4, 0.4f);
    public static final Item FOOD_VICUGNA_COOKED = new ItemFood(MODID, "food_vicugna_cooked",  4, 0.4f);

    public static final Item STUFF_DYNAMITE = new ItemDynamite(MODID, "stuff_dynamite", ItemGroup.TOOLS);

    public static final Item STUFF_ROPE = new ItemItem(MODID, "stuff_rope", ItemGroup.MISC);
    public static final Item STUFF_HEMP = new ItemItem(MODID, "stuff_hemp", ItemGroup.MISC);
    public static final Item STUFF_COTTON = new ItemItem(MODID, "stuff_cotton", ItemGroup.MISC);
    public static final Item STUFF_GEAR_WOODEN = new ItemItem(MODID, "stuff_gear_wooden", ItemGroup.MISC);
    public static final Item STUFF_FUR = new ItemItem(MODID, "stuff_fur", ItemGroup.MISC);

    public static final Item STUFF_FLOUR = new ItemItem(MODID, "stuff_flour", ItemGroup.FOOD);
    public static final Item STUFF_COFFEE = new ItemItem(MODID, "stuff_coffee", ItemGroup.FOOD);
    public static final Item STUFF_SALT = new ItemItem(MODID, "stuff_salt", ItemGroup.FOOD);
    public static final Item STUFF_SULFUR = new ItemItem(MODID, "stuff_sulfur", ItemGroup.FOOD);

    public static final Block MACHINA_ROPE = new BlockBlock(MODID, "machina_rope", Blocks.IRON_BLOCK);
    public static final Block MACHINA_ANCHOR = new BlockBlock(MODID, "machina_anchor", Blocks.IRON_BLOCK);
    public static final Block MACHINA_DESTILLERY = new BlockBlock(MODID, "machina_destillery", Blocks.IRON_BLOCK);
    public static final Block MACHINA_GLOBE = new MachinaGlobe(MODID, "machina_globe", Blocks.IRON_BLOCK);
    public static final Block MACHINA_BLASTFURNACE = new MachinaBlastfurnace(MODID, "machina_blastfurnace", Blocks.IRON_BLOCK);
    public static final Block MACHINA_KEG = new BlockBlock(MODID, "machina_keg", Blocks.IRON_BLOCK);

    public static final Item LIQUOR_COFFEE = new ItemFood(MODID, "liquor_coffee",  4, 0.4f);
    public static final Item LIQUOR_RUM = new ItemFood(MODID, "liquor_rum",  4, 0.4f);
    public static final Item LIQUOR_SAKE = new ItemFood(MODID, "liquor_sake",  4, 0.4f);
    public static final Item LIQUOR_SALGAM = new ItemFood(MODID, "liquor_salgam",  4, 0.4f);
    public static final Item LIQUOR_VODKA = new ItemFood(MODID, "liquor_vodka",  4, 0.4f);
    public static final Item LIQUOR_BEER = new ItemFood(MODID, "liquor_beer",  4, 0.4f);
    public static final Item LIQUOR_CIDER = new ItemFood(MODID, "liquor_cider",  4, 0.4f);
    public static final Item LIQUOR_WINE = new ItemFood(MODID, "liquor_wine",  4, 0.4f);

    // Armor Boots
    public static final Item ARMOR_BOOTS_BRASS      = new ItemArmor(MODID, "armor_boots_brass",      MaterialArmor.BRASS,      EquipmentSlotType.FEET);
    public static final Item ARMOR_BOOTS_QUESTORIUM = new ItemArmor(MODID, "armor_boots_questorium", MaterialArmor.QUESTORIUM, EquipmentSlotType.FEET);
    public static final Item ARMOR_BOOTS_GILIUM     = new ItemArmor(MODID, "armor_boots_gilium",     MaterialArmor.GILIUM,     EquipmentSlotType.FEET);
    public static final Item ARMOR_BOOTS_ADAMANTIUM = new ItemArmor(MODID, "armor_boots_adamantium", MaterialArmor.ADAMANTIUM, EquipmentSlotType.FEET);
    public static final Item ARMOR_BOOTS_VIRIDIUM   = new ItemArmor(MODID, "armor_boots_viridium",   MaterialArmor.VIRIDIUM,   EquipmentSlotType.FEET);
    public static final Item ARMOR_BOOTS_ZINC       = new ItemArmor(MODID, "armor_boots_zinc",       MaterialArmor.ZINC,       EquipmentSlotType.FEET);
    public static final Item ARMOR_BOOTS_KOBALIUM   = new ItemArmor(MODID, "armor_boots_kobalium",   MaterialArmor.KOBALIUM,   EquipmentSlotType.FEET);
    public static final Item ARMOR_BOOTS_DENARIUM   = new ItemArmor(MODID, "armor_boots_denarium",   MaterialArmor.DENARIUM,   EquipmentSlotType.FEET);
    public static final Item ARMOR_BOOTS_MYTHRIL    = new ItemArmor(MODID, "armor_boots_mythril",    MaterialArmor.MYTHRIL,    EquipmentSlotType.FEET);
    public static final Item ARMOR_BOOTS_CLAVIUM    = new ItemArmor(MODID, "armor_boots_clavium",    MaterialArmor.CLAVIUM,    EquipmentSlotType.FEET);
    public static final Item ARMOR_BOOTS_AURELIUM   = new ItemArmor(MODID, "armor_boots_aurelium",   MaterialArmor.AURELIUM,   EquipmentSlotType.FEET);
    public static final Item ARMOR_BOOTS_NIVIDIUM   = new ItemArmor(MODID, "armor_boots_nividium",   MaterialArmor.NIVIDIUM,   EquipmentSlotType.FEET);
    public static final Item ARMOR_BOOTS_TIN        = new ItemArmor(MODID, "armor_boots_tin",        MaterialArmor.TIN,        EquipmentSlotType.FEET);
    public static final Item ARMOR_BOOTS_ORICHALCUM = new ItemArmor(MODID, "armor_boots_orichalcum", MaterialArmor.ORICHALCUM, EquipmentSlotType.FEET);
    public static final Item ARMOR_BOOTS_SCARLETITE = new ItemArmor(MODID, "armor_boots_scarletite", MaterialArmor.SCARLETITE, EquipmentSlotType.FEET);
    public static final Item ARMOR_BOOTS_COPPER     = new ItemArmor(MODID, "armor_boots_copper",     MaterialArmor.COPPER,     EquipmentSlotType.FEET);
    public static final Item ARMOR_BOOTS_BRONZE     = new ItemArmor(MODID, "armor_boots_bronze",     MaterialArmor.BRONZE,     EquipmentSlotType.FEET);
    public static final Item ARMOR_BOOTS_STEEL      = new ItemArmor(MODID, "armor_boots_steel",      MaterialArmor.STEEL,      EquipmentSlotType.FEET);
    public static final Item ARMOR_BOOTS_DARKSTEEL  = new ItemArmor(MODID, "armor_boots_darksteel",  MaterialArmor.DARKSTEEL,  EquipmentSlotType.FEET);
    public static final Item ARMOR_BOOTS_UNOBTANIUM = new ItemArmor(MODID, "armor_boots_unobtanium", MaterialArmor.UNOBTANIUM, EquipmentSlotType.FEET);
    public static final Item ARMOR_BOOTS_AURORITE   = new ItemArmor(MODID, "armor_boots_aurorite",   MaterialArmor.AURORITE,   EquipmentSlotType.FEET);

    // Armor Chestplate
    public static final Item ARMOR_PLATE_BRASS      = new ItemArmor(MODID, "armor_plate_brass",      MaterialArmor.BRASS,      EquipmentSlotType.CHEST);
    public static final Item ARMOR_PLATE_QUESTORIUM = new ItemArmor(MODID, "armor_plate_questorium", MaterialArmor.QUESTORIUM, EquipmentSlotType.CHEST);
    public static final Item ARMOR_PLATE_GILIUM     = new ItemArmor(MODID, "armor_plate_gilium",     MaterialArmor.GILIUM,     EquipmentSlotType.CHEST);
    public static final Item ARMOR_PLATE_ADAMANTIUM = new ItemArmor(MODID, "armor_plate_adamantium", MaterialArmor.ADAMANTIUM, EquipmentSlotType.CHEST);
    public static final Item ARMOR_PLATE_VIRIDIUM   = new ItemArmor(MODID, "armor_plate_viridium",   MaterialArmor.VIRIDIUM,   EquipmentSlotType.CHEST);
    public static final Item ARMOR_PLATE_ZINC       = new ItemArmor(MODID, "armor_plate_zinc",       MaterialArmor.ZINC,       EquipmentSlotType.CHEST);
    public static final Item ARMOR_PLATE_KOBALIUM   = new ItemArmor(MODID, "armor_plate_kobalium",   MaterialArmor.KOBALIUM,   EquipmentSlotType.CHEST);
    public static final Item ARMOR_PLATE_DENARIUM   = new ItemArmor(MODID, "armor_plate_denarium",   MaterialArmor.DENARIUM,   EquipmentSlotType.CHEST);
    public static final Item ARMOR_PLATE_MYTHRIL    = new ItemArmor(MODID, "armor_plate_mythril",    MaterialArmor.MYTHRIL,    EquipmentSlotType.CHEST);
    public static final Item ARMOR_PLATE_CLAVIUM    = new ItemArmor(MODID, "armor_plate_clavium",    MaterialArmor.CLAVIUM,    EquipmentSlotType.CHEST);
    public static final Item ARMOR_PLATE_AURELIUM   = new ItemArmor(MODID, "armor_plate_aurelium",   MaterialArmor.AURELIUM,   EquipmentSlotType.CHEST);
    public static final Item ARMOR_PLATE_NIVIDIUM   = new ItemArmor(MODID, "armor_plate_nividium",   MaterialArmor.NIVIDIUM,   EquipmentSlotType.CHEST);
    public static final Item ARMOR_PLATE_TIN        = new ItemArmor(MODID, "armor_plate_tin",        MaterialArmor.TIN,        EquipmentSlotType.CHEST);
    public static final Item ARMOR_PLATE_ORICHALCUM = new ItemArmor(MODID, "armor_plate_orichalcum", MaterialArmor.ORICHALCUM, EquipmentSlotType.CHEST);
    public static final Item ARMOR_PLATE_SCARLETITE = new ItemArmor(MODID, "armor_plate_scarletite", MaterialArmor.SCARLETITE, EquipmentSlotType.CHEST);
    public static final Item ARMOR_PLATE_COPPER     = new ItemArmor(MODID, "armor_plate_copper",     MaterialArmor.COPPER,     EquipmentSlotType.CHEST);
    public static final Item ARMOR_PLATE_BRONZE     = new ItemArmor(MODID, "armor_plate_bronze",     MaterialArmor.BRONZE,     EquipmentSlotType.CHEST);
    public static final Item ARMOR_PLATE_STEEL      = new ItemArmor(MODID, "armor_plate_steel",      MaterialArmor.STEEL,      EquipmentSlotType.CHEST);
    public static final Item ARMOR_PLATE_DARKSTEEL  = new ItemArmor(MODID, "armor_plate_darksteel",  MaterialArmor.DARKSTEEL,  EquipmentSlotType.CHEST);
    public static final Item ARMOR_PLATE_UNOBTANIUM = new ItemArmor(MODID, "armor_plate_unobtanium", MaterialArmor.UNOBTANIUM, EquipmentSlotType.CHEST);
    public static final Item ARMOR_PLATE_AURORITE   = new ItemArmor(MODID, "armor_plate_aurorite",   MaterialArmor.AURORITE,   EquipmentSlotType.CHEST);

    // Armor Leggings
    public static final Item ARMOR_LEGGINGS_BRASS      = new ItemArmor(MODID, "armor_leggings_brass",      MaterialArmor.BRASS,      EquipmentSlotType.LEGS);
    public static final Item ARMOR_LEGGINGS_QUESTORIUM = new ItemArmor(MODID, "armor_leggings_questorium", MaterialArmor.QUESTORIUM, EquipmentSlotType.LEGS);
    public static final Item ARMOR_LEGGINGS_GILIUM     = new ItemArmor(MODID, "armor_leggings_gilium",     MaterialArmor.GILIUM,     EquipmentSlotType.LEGS);
    public static final Item ARMOR_LEGGINGS_ADAMANTIUM = new ItemArmor(MODID, "armor_leggings_adamantium", MaterialArmor.ADAMANTIUM, EquipmentSlotType.LEGS);
    public static final Item ARMOR_LEGGINGS_VIRIDIUM   = new ItemArmor(MODID, "armor_leggings_viridium",   MaterialArmor.VIRIDIUM,   EquipmentSlotType.LEGS);
    public static final Item ARMOR_LEGGINGS_ZINC       = new ItemArmor(MODID, "armor_leggings_zinc",       MaterialArmor.ZINC,       EquipmentSlotType.LEGS);
    public static final Item ARMOR_LEGGINGS_KOBALIUM   = new ItemArmor(MODID, "armor_leggings_kobalium",   MaterialArmor.KOBALIUM,   EquipmentSlotType.LEGS);
    public static final Item ARMOR_LEGGINGS_DENARIUM   = new ItemArmor(MODID, "armor_leggings_denarium",   MaterialArmor.DENARIUM,   EquipmentSlotType.LEGS);
    public static final Item ARMOR_LEGGINGS_MYTHRIL    = new ItemArmor(MODID, "armor_leggings_mythril",    MaterialArmor.MYTHRIL,    EquipmentSlotType.LEGS);
    public static final Item ARMOR_LEGGINGS_CLAVIUM    = new ItemArmor(MODID, "armor_leggings_clavium",    MaterialArmor.CLAVIUM,    EquipmentSlotType.LEGS);
    public static final Item ARMOR_LEGGINGS_AURELIUM   = new ItemArmor(MODID, "armor_leggings_aurelium",   MaterialArmor.AURELIUM,   EquipmentSlotType.LEGS);
    public static final Item ARMOR_LEGGINGS_NIVIDIUM   = new ItemArmor(MODID, "armor_leggings_nividium",   MaterialArmor.NIVIDIUM,   EquipmentSlotType.LEGS);
    public static final Item ARMOR_LEGGINGS_TIN        = new ItemArmor(MODID, "armor_leggings_tin",        MaterialArmor.TIN,        EquipmentSlotType.LEGS);
    public static final Item ARMOR_LEGGINGS_ORICHALCUM = new ItemArmor(MODID, "armor_leggings_orichalcum", MaterialArmor.ORICHALCUM, EquipmentSlotType.LEGS);
    public static final Item ARMOR_LEGGINGS_SCARLETITE = new ItemArmor(MODID, "armor_leggings_scarletite", MaterialArmor.SCARLETITE, EquipmentSlotType.LEGS);
    public static final Item ARMOR_LEGGINGS_COPPER     = new ItemArmor(MODID, "armor_leggings_copper",     MaterialArmor.COPPER,     EquipmentSlotType.LEGS);
    public static final Item ARMOR_LEGGINGS_BRONZE     = new ItemArmor(MODID, "armor_leggings_bronze",     MaterialArmor.BRONZE,     EquipmentSlotType.LEGS);
    public static final Item ARMOR_LEGGINGS_STEEL      = new ItemArmor(MODID, "armor_leggings_steel",      MaterialArmor.STEEL,      EquipmentSlotType.LEGS);
    public static final Item ARMOR_LEGGINGS_DARKSTEEL  = new ItemArmor(MODID, "armor_leggings_darksteel",  MaterialArmor.DARKSTEEL,  EquipmentSlotType.LEGS);
    public static final Item ARMOR_LEGGINGS_UNOBTANIUM = new ItemArmor(MODID, "armor_leggings_unobtanium", MaterialArmor.UNOBTANIUM, EquipmentSlotType.LEGS);
    public static final Item ARMOR_LEGGINGS_AURORITE   = new ItemArmor(MODID, "armor_leggings_aurorite",   MaterialArmor.AURORITE,   EquipmentSlotType.LEGS);

    // Armor Helmet
    public static final Item ARMOR_HELMET_BRASS      = new ItemArmor(MODID, "armor_helmet_brass",      MaterialArmor.BRASS,      EquipmentSlotType.HEAD);
    public static final Item ARMOR_HELMET_QUESTORIUM = new ItemArmor(MODID, "armor_helmet_questorium", MaterialArmor.QUESTORIUM, EquipmentSlotType.HEAD);
    public static final Item ARMOR_HELMET_GILIUM     = new ItemArmor(MODID, "armor_helmet_gilium",     MaterialArmor.GILIUM,     EquipmentSlotType.HEAD);
    public static final Item ARMOR_HELMET_ADAMANTIUM = new ItemArmor(MODID, "armor_helmet_adamantium", MaterialArmor.ADAMANTIUM, EquipmentSlotType.HEAD);
    public static final Item ARMOR_HELMET_VIRIDIUM   = new ItemArmor(MODID, "armor_helmet_viridium",   MaterialArmor.VIRIDIUM,   EquipmentSlotType.HEAD);
    public static final Item ARMOR_HELMET_ZINC       = new ItemArmor(MODID, "armor_helmet_zinc",       MaterialArmor.ZINC,       EquipmentSlotType.HEAD);
    public static final Item ARMOR_HELMET_KOBALIUM   = new ItemArmor(MODID, "armor_helmet_kobalium",   MaterialArmor.KOBALIUM,   EquipmentSlotType.HEAD);
    public static final Item ARMOR_HELMET_DENARIUM   = new ItemArmor(MODID, "armor_helmet_denarium",   MaterialArmor.DENARIUM,   EquipmentSlotType.HEAD);
    public static final Item ARMOR_HELMET_MYTHRIL    = new ItemArmor(MODID, "armor_helmet_mythril",    MaterialArmor.MYTHRIL,    EquipmentSlotType.HEAD);
    public static final Item ARMOR_HELMET_CLAVIUM    = new ItemArmor(MODID, "armor_helmet_clavium",    MaterialArmor.CLAVIUM,    EquipmentSlotType.HEAD);
    public static final Item ARMOR_HELMET_AURELIUM   = new ItemArmor(MODID, "armor_helmet_aurelium",   MaterialArmor.AURELIUM,   EquipmentSlotType.HEAD);
    public static final Item ARMOR_HELMET_NIVIDIUM   = new ItemArmor(MODID, "armor_helmet_nividium",   MaterialArmor.NIVIDIUM,   EquipmentSlotType.HEAD);
    public static final Item ARMOR_HELMET_TIN        = new ItemArmor(MODID, "armor_helmet_tin",        MaterialArmor.TIN,        EquipmentSlotType.HEAD);
    public static final Item ARMOR_HELMET_ORICHALCUM = new ItemArmor(MODID, "armor_helmet_orichalcum", MaterialArmor.ORICHALCUM, EquipmentSlotType.HEAD);
    public static final Item ARMOR_HELMET_SCARLETITE = new ItemArmor(MODID, "armor_helmet_scarletite", MaterialArmor.SCARLETITE, EquipmentSlotType.HEAD);
    public static final Item ARMOR_HELMET_COPPER     = new ItemArmor(MODID, "armor_helmet_copper",     MaterialArmor.COPPER,     EquipmentSlotType.HEAD);
    public static final Item ARMOR_HELMET_BRONZE     = new ItemArmor(MODID, "armor_helmet_bronze",     MaterialArmor.BRONZE,     EquipmentSlotType.HEAD);
    public static final Item ARMOR_HELMET_STEEL      = new ItemArmor(MODID, "armor_helmet_steel",      MaterialArmor.STEEL,      EquipmentSlotType.HEAD);
    public static final Item ARMOR_HELMET_DARKSTEEL  = new ItemArmor(MODID, "armor_helmet_darksteel",  MaterialArmor.DARKSTEEL,  EquipmentSlotType.HEAD);
    public static final Item ARMOR_HELMET_UNOBTANIUM = new ItemArmor(MODID, "armor_helmet_unobtanium", MaterialArmor.UNOBTANIUM, EquipmentSlotType.HEAD);
    public static final Item ARMOR_HELMET_AURORITE   = new ItemArmor(MODID, "armor_helmet_aurorite",   MaterialArmor.AURORITE,   EquipmentSlotType.HEAD);

    // Tool Sword
    public static final Item TOOL_SWORD_BRASS      = new ToolSword(MODID, "tool_sword_brass",      MaterialTool.BRASS,      1, -1.0f);
    public static final Item TOOL_SWORD_QUESTORIUM = new ToolSword(MODID, "tool_sword_questorium", MaterialTool.QUESTORIUM, 1, -1.0f);
    public static final Item TOOL_SWORD_GILIUM     = new ToolSword(MODID, "tool_sword_gilium",     MaterialTool.GILIUM,     1, -1.0f);
    public static final Item TOOL_SWORD_ADAMANTIUM = new ToolSword(MODID, "tool_sword_adamantium", MaterialTool.ADAMANTIUM, 1, -1.0f);
    public static final Item TOOL_SWORD_VIRIDIUM   = new ToolSword(MODID, "tool_sword_viridium",   MaterialTool.VIRIDIUM,   1, -1.0f);
    public static final Item TOOL_SWORD_ZINC       = new ToolSword(MODID, "tool_sword_zinc",       MaterialTool.ZINC,       1, -1.0f);
    public static final Item TOOL_SWORD_KOBALIUM   = new ToolSword(MODID, "tool_sword_kobalium",   MaterialTool.KOBALIUM,   1, -1.0f);
    public static final Item TOOL_SWORD_DENARIUM   = new ToolSword(MODID, "tool_sword_denarium",   MaterialTool.DENARIUM,   1, -1.0f);
    public static final Item TOOL_SWORD_MYTHRIL    = new ToolSword(MODID, "tool_sword_mythril",    MaterialTool.MYTHRIL,    1, -1.0f);
    public static final Item TOOL_SWORD_CLAVIUM    = new ToolSword(MODID, "tool_sword_clavium",    MaterialTool.CLAVIUM,    1, -1.0f);
    public static final Item TOOL_SWORD_AURELIUM   = new ToolSword(MODID, "tool_sword_aurelium",   MaterialTool.AURELIUM,   1, -1.0f);
    public static final Item TOOL_SWORD_NIVIDIUM   = new ToolSword(MODID, "tool_sword_nividium",   MaterialTool.NIVIDIUM,   1, -1.0f);
    public static final Item TOOL_SWORD_TIN        = new ToolSword(MODID, "tool_sword_tin",        MaterialTool.TIN,        1, -1.0f);
    public static final Item TOOL_SWORD_ORICHALCUM = new ToolSword(MODID, "tool_sword_orichalcum", MaterialTool.ORICHALCUM, 1, -1.0f);
    public static final Item TOOL_SWORD_SCARLETITE = new ToolSword(MODID, "tool_sword_scarletite", MaterialTool.SCARLETITE, 1, -1.0f);
    public static final Item TOOL_SWORD_COPPER     = new ToolSword(MODID, "tool_sword_copper",     MaterialTool.COPPER,     1, -1.0f);
    public static final Item TOOL_SWORD_BRONZE     = new ToolSword(MODID, "tool_sword_bronze",     MaterialTool.BRONZE,     1, -1.0f);
    public static final Item TOOL_SWORD_STEEL      = new ToolSword(MODID, "tool_sword_steel",      MaterialTool.STEEL,      1, -1.0f);
    public static final Item TOOL_SWORD_DARKSTEEL  = new ToolSword(MODID, "tool_sword_darksteel",  MaterialTool.DARKSTEEL,  1, -1.0f);
    public static final Item TOOL_SWORD_UNOBTANIUM = new ToolSword(MODID, "tool_sword_unobtanium", MaterialTool.UNOBTANIUM, 1, -1.0f);
    public static final Item TOOL_SWORD_AURORITE   = new ToolSword(MODID, "tool_sword_aurorite",   MaterialTool.AURORITE,   1, -1.0f);

    // Tool Spear
    public static final Item TOOL_SPEAR_BRASS      = new ToolSpear(MODID, "tool_spear_brass",      MaterialTool.BRASS,      1, -1.0f);
    public static final Item TOOL_SPEAR_QUESTORIUM = new ToolSpear(MODID, "tool_spear_questorium", MaterialTool.QUESTORIUM, 1, -1.0f);
    public static final Item TOOL_SPEAR_GILIUM     = new ToolSpear(MODID, "tool_spear_gilium",     MaterialTool.GILIUM,     1, -1.0f);
    public static final Item TOOL_SPEAR_ADAMANTIUM = new ToolSpear(MODID, "tool_spear_adamantium", MaterialTool.ADAMANTIUM, 1, -1.0f);
    public static final Item TOOL_SPEAR_VIRIDIUM   = new ToolSpear(MODID, "tool_spear_viridium",   MaterialTool.VIRIDIUM,   1, -1.0f);
    public static final Item TOOL_SPEAR_ZINC       = new ToolSpear(MODID, "tool_spear_zinc",       MaterialTool.ZINC,       1, -1.0f);
    public static final Item TOOL_SPEAR_KOBALIUM   = new ToolSpear(MODID, "tool_spear_kobalium",   MaterialTool.KOBALIUM,   1, -1.0f);
    public static final Item TOOL_SPEAR_DENARIUM   = new ToolSpear(MODID, "tool_spear_denarium",   MaterialTool.DENARIUM,   1, -1.0f);
    public static final Item TOOL_SPEAR_MYTHRIL    = new ToolSpear(MODID, "tool_spear_mythril",    MaterialTool.MYTHRIL,    1, -1.0f);
    public static final Item TOOL_SPEAR_CLAVIUM    = new ToolSpear(MODID, "tool_spear_clavium",    MaterialTool.CLAVIUM,    1, -1.0f);
    public static final Item TOOL_SPEAR_AURELIUM   = new ToolSpear(MODID, "tool_spear_aurelium",   MaterialTool.AURELIUM,   1, -1.0f);
    public static final Item TOOL_SPEAR_NIVIDIUM   = new ToolSpear(MODID, "tool_spear_nividium",   MaterialTool.NIVIDIUM,   1, -1.0f);
    public static final Item TOOL_SPEAR_TIN        = new ToolSpear(MODID, "tool_spear_tin",        MaterialTool.TIN,        1, -1.0f);
    public static final Item TOOL_SPEAR_ORICHALCUM = new ToolSpear(MODID, "tool_spear_orichalcum", MaterialTool.ORICHALCUM, 1, -1.0f);
    public static final Item TOOL_SPEAR_SCARLETITE = new ToolSpear(MODID, "tool_spear_scarletite", MaterialTool.SCARLETITE, 1, -1.0f);
    public static final Item TOOL_SPEAR_COPPER     = new ToolSpear(MODID, "tool_spear_copper",     MaterialTool.COPPER,     1, -1.0f);
    public static final Item TOOL_SPEAR_BRONZE     = new ToolSpear(MODID, "tool_spear_bronze",     MaterialTool.BRONZE,     1, -1.0f);
    public static final Item TOOL_SPEAR_STEEL      = new ToolSpear(MODID, "tool_spear_steel",      MaterialTool.STEEL,      1, -1.0f);
    public static final Item TOOL_SPEAR_DARKSTEEL  = new ToolSpear(MODID, "tool_spear_darksteel",  MaterialTool.DARKSTEEL,  1, -1.0f);
    public static final Item TOOL_SPEAR_UNOBTANIUM = new ToolSpear(MODID, "tool_spear_unobtanium", MaterialTool.UNOBTANIUM, 1, -1.0f);
    public static final Item TOOL_SPEAR_AURORITE   = new ToolSpear(MODID, "tool_spear_aurorite",   MaterialTool.AURORITE,   1, -1.0f);

    // Tool Hammer
    public static final Item TOOL_HAMMER_BRASS      = new ToolHammer(MODID, "tool_hammer_brass",      MaterialTool.BRASS,      1, -1.0f);
    public static final Item TOOL_HAMMER_QUESTORIUM = new ToolHammer(MODID, "tool_hammer_questorium", MaterialTool.QUESTORIUM, 1, -1.0f);
    public static final Item TOOL_HAMMER_GILIUM     = new ToolHammer(MODID, "tool_hammer_gilium",     MaterialTool.GILIUM,     1, -1.0f);
    public static final Item TOOL_HAMMER_ADAMANTIUM = new ToolHammer(MODID, "tool_hammer_adamantium", MaterialTool.ADAMANTIUM, 1, -1.0f);
    public static final Item TOOL_HAMMER_VIRIDIUM   = new ToolHammer(MODID, "tool_hammer_viridium",   MaterialTool.VIRIDIUM,   1, -1.0f);
    public static final Item TOOL_HAMMER_ZINC       = new ToolHammer(MODID, "tool_hammer_zinc",       MaterialTool.ZINC,       1, -1.0f);
    public static final Item TOOL_HAMMER_KOBALIUM   = new ToolHammer(MODID, "tool_hammer_kobalium",   MaterialTool.KOBALIUM,   1, -1.0f);
    public static final Item TOOL_HAMMER_DENARIUM   = new ToolHammer(MODID, "tool_hammer_denarium",   MaterialTool.DENARIUM,   1, -1.0f);
    public static final Item TOOL_HAMMER_MYTHRIL    = new ToolHammer(MODID, "tool_hammer_mythril",    MaterialTool.MYTHRIL,    1, -1.0f);
    public static final Item TOOL_HAMMER_CLAVIUM    = new ToolHammer(MODID, "tool_hammer_clavium",    MaterialTool.CLAVIUM,    1, -1.0f);
    public static final Item TOOL_HAMMER_AURELIUM   = new ToolHammer(MODID, "tool_hammer_aurelium",   MaterialTool.AURELIUM,   1, -1.0f);
    public static final Item TOOL_HAMMER_NIVIDIUM   = new ToolHammer(MODID, "tool_hammer_nividium",   MaterialTool.NIVIDIUM,   1, -1.0f);
    public static final Item TOOL_HAMMER_TIN        = new ToolHammer(MODID, "tool_hammer_tin",        MaterialTool.TIN,        1, -1.0f);
    public static final Item TOOL_HAMMER_ORICHALCUM = new ToolHammer(MODID, "tool_hammer_orichalcum", MaterialTool.ORICHALCUM, 1, -1.0f);
    public static final Item TOOL_HAMMER_SCARLETITE = new ToolHammer(MODID, "tool_hammer_scarletite", MaterialTool.SCARLETITE, 1, -1.0f);
    public static final Item TOOL_HAMMER_COPPER     = new ToolHammer(MODID, "tool_hammer_copper",     MaterialTool.COPPER,     1, -1.0f);
    public static final Item TOOL_HAMMER_BRONZE     = new ToolHammer(MODID, "tool_hammer_bronze",     MaterialTool.BRONZE,     1, -1.0f);
    public static final Item TOOL_HAMMER_STEEL      = new ToolHammer(MODID, "tool_hammer_steel",      MaterialTool.STEEL,      1, -1.0f);
    public static final Item TOOL_HAMMER_DARKSTEEL  = new ToolHammer(MODID, "tool_hammer_darksteel",  MaterialTool.DARKSTEEL,  1, -1.0f);
    public static final Item TOOL_HAMMER_UNOBTANIUM = new ToolHammer(MODID, "tool_hammer_unobtanium", MaterialTool.UNOBTANIUM, 1, -1.0f);
    public static final Item TOOL_HAMMER_AURORITE   = new ToolHammer(MODID, "tool_hammer_aurorite",   MaterialTool.AURORITE,   1, -1.0f);

    // Tool Axe
    public static final Item TOOL_AXE_BRASS      = new ToolAxe(MODID, "tool_axe_brass",      MaterialTool.BRASS,      1, -1.0f);
    public static final Item TOOL_AXE_QUESTORIUM = new ToolAxe(MODID, "tool_axe_questorium", MaterialTool.QUESTORIUM, 1, -1.0f);
    public static final Item TOOL_AXE_GILIUM     = new ToolAxe(MODID, "tool_axe_gilium",     MaterialTool.GILIUM,     1, -1.0f);
    public static final Item TOOL_AXE_ADAMANTIUM = new ToolAxe(MODID, "tool_axe_adamantium", MaterialTool.ADAMANTIUM, 1, -1.0f);
    public static final Item TOOL_AXE_VIRIDIUM   = new ToolAxe(MODID, "tool_axe_viridium",   MaterialTool.VIRIDIUM,   1, -1.0f);
    public static final Item TOOL_AXE_ZINC       = new ToolAxe(MODID, "tool_axe_zinc",       MaterialTool.ZINC,       1, -1.0f);
    public static final Item TOOL_AXE_KOBALIUM   = new ToolAxe(MODID, "tool_axe_kobalium",   MaterialTool.KOBALIUM,   1, -1.0f);
    public static final Item TOOL_AXE_DENARIUM   = new ToolAxe(MODID, "tool_axe_denarium",   MaterialTool.DENARIUM,   1, -1.0f);
    public static final Item TOOL_AXE_MYTHRIL    = new ToolAxe(MODID, "tool_axe_mythril",    MaterialTool.MYTHRIL,    1, -1.0f);
    public static final Item TOOL_AXE_CLAVIUM    = new ToolAxe(MODID, "tool_axe_clavium",    MaterialTool.CLAVIUM,    1, -1.0f);
    public static final Item TOOL_AXE_AURELIUM   = new ToolAxe(MODID, "tool_axe_aurelium",   MaterialTool.AURELIUM,   1, -1.0f);
    public static final Item TOOL_AXE_NIVIDIUM   = new ToolAxe(MODID, "tool_axe_nividium",   MaterialTool.NIVIDIUM,   1, -1.0f);
    public static final Item TOOL_AXE_TIN        = new ToolAxe(MODID, "tool_axe_tin",        MaterialTool.TIN,        1, -1.0f);
    public static final Item TOOL_AXE_ORICHALCUM = new ToolAxe(MODID, "tool_axe_orichalcum", MaterialTool.ORICHALCUM, 1, -1.0f);
    public static final Item TOOL_AXE_SCARLETITE = new ToolAxe(MODID, "tool_axe_scarletite", MaterialTool.SCARLETITE, 1, -1.0f);
    public static final Item TOOL_AXE_COPPER     = new ToolAxe(MODID, "tool_axe_copper",     MaterialTool.COPPER,     1, -1.0f);
    public static final Item TOOL_AXE_BRONZE     = new ToolAxe(MODID, "tool_axe_bronze",     MaterialTool.BRONZE,     1, -1.0f);
    public static final Item TOOL_AXE_STEEL      = new ToolAxe(MODID, "tool_axe_steel",      MaterialTool.STEEL,      1, -1.0f);
    public static final Item TOOL_AXE_DARKSTEEL  = new ToolAxe(MODID, "tool_axe_darksteel",  MaterialTool.DARKSTEEL,  1, -1.0f);
    public static final Item TOOL_AXE_UNOBTANIUM = new ToolAxe(MODID, "tool_axe_unobtanium", MaterialTool.UNOBTANIUM, 1, -1.0f);
    public static final Item TOOL_AXE_AURORITE   = new ToolAxe(MODID, "tool_axe_aurorite",   MaterialTool.AURORITE,   1, -1.0f);

    // Tool Pickaxe
    public static final Item TOOL_PICKAXE_BRASS      = new ToolPickaxe(MODID, "tool_pickaxe_brass",      MaterialTool.BRASS,      1, -1.0f);
    public static final Item TOOL_PICKAXE_QUESTORIUM = new ToolPickaxe(MODID, "tool_pickaxe_questorium", MaterialTool.QUESTORIUM, 1, -1.0f);
    public static final Item TOOL_PICKAXE_GILIUM     = new ToolPickaxe(MODID, "tool_pickaxe_gilium",     MaterialTool.GILIUM,     1, -1.0f);
    public static final Item TOOL_PICKAXE_ADAMANTIUM = new ToolPickaxe(MODID, "tool_pickaxe_adamantium", MaterialTool.ADAMANTIUM, 1, -1.0f);
    public static final Item TOOL_PICKAXE_VIRIDIUM   = new ToolPickaxe(MODID, "tool_pickaxe_viridium",   MaterialTool.VIRIDIUM,   1, -1.0f);
    public static final Item TOOL_PICKAXE_ZINC       = new ToolPickaxe(MODID, "tool_pickaxe_zinc",       MaterialTool.ZINC,       1, -1.0f);
    public static final Item TOOL_PICKAXE_KOBALIUM   = new ToolPickaxe(MODID, "tool_pickaxe_kobalium",   MaterialTool.KOBALIUM,   1, -1.0f);
    public static final Item TOOL_PICKAXE_DENARIUM   = new ToolPickaxe(MODID, "tool_pickaxe_denarium",   MaterialTool.DENARIUM,   1, -1.0f);
    public static final Item TOOL_PICKAXE_MYTHRIL    = new ToolPickaxe(MODID, "tool_pickaxe_mythril",    MaterialTool.MYTHRIL,    1, -1.0f);
    public static final Item TOOL_PICKAXE_CLAVIUM    = new ToolPickaxe(MODID, "tool_pickaxe_clavium",    MaterialTool.CLAVIUM,    1, -1.0f);
    public static final Item TOOL_PICKAXE_AURELIUM   = new ToolPickaxe(MODID, "tool_pickaxe_aurelium",   MaterialTool.AURELIUM,   1, -1.0f);
    public static final Item TOOL_PICKAXE_NIVIDIUM   = new ToolPickaxe(MODID, "tool_pickaxe_nividium",   MaterialTool.NIVIDIUM,   1, -1.0f);
    public static final Item TOOL_PICKAXE_TIN        = new ToolPickaxe(MODID, "tool_pickaxe_tin",        MaterialTool.TIN,        1, -1.0f);
    public static final Item TOOL_PICKAXE_ORICHALCUM = new ToolPickaxe(MODID, "tool_pickaxe_orichalcum", MaterialTool.ORICHALCUM, 1, -1.0f);
    public static final Item TOOL_PICKAXE_SCARLETITE = new ToolPickaxe(MODID, "tool_pickaxe_scarletite", MaterialTool.SCARLETITE, 1, -1.0f);
    public static final Item TOOL_PICKAXE_COPPER     = new ToolPickaxe(MODID, "tool_pickaxe_copper",     MaterialTool.COPPER,     1, -1.0f);
    public static final Item TOOL_PICKAXE_BRONZE     = new ToolPickaxe(MODID, "tool_pickaxe_bronze",     MaterialTool.BRONZE,     1, -1.0f);
    public static final Item TOOL_PICKAXE_STEEL      = new ToolPickaxe(MODID, "tool_pickaxe_steel",      MaterialTool.STEEL,      1, -1.0f);
    public static final Item TOOL_PICKAXE_DARKSTEEL  = new ToolPickaxe(MODID, "tool_pickaxe_darksteel",  MaterialTool.DARKSTEEL,  1, -1.0f);
    public static final Item TOOL_PICKAXE_UNOBTANIUM = new ToolPickaxe(MODID, "tool_pickaxe_unobtanium", MaterialTool.UNOBTANIUM, 1, -1.0f);
    public static final Item TOOL_PICKAXE_AURORITE   = new ToolPickaxe(MODID, "tool_pickaxe_aurorite",   MaterialTool.AURORITE,   1, -1.0f);

    // Tool Shovel
    public static final Item TOOL_SHOVEL_BRASS      = new ToolShovel(MODID, "tool_shovel_brass",      MaterialTool.BRASS,      1, -1.0f);
    public static final Item TOOL_SHOVEL_QUESTORIUM = new ToolShovel(MODID, "tool_shovel_questorium", MaterialTool.QUESTORIUM, 1, -1.0f);
    public static final Item TOOL_SHOVEL_GILIUM     = new ToolShovel(MODID, "tool_shovel_gilium",     MaterialTool.GILIUM,     1, -1.0f);
    public static final Item TOOL_SHOVEL_ADAMANTIUM = new ToolShovel(MODID, "tool_shovel_adamantium", MaterialTool.ADAMANTIUM, 1, -1.0f);
    public static final Item TOOL_SHOVEL_VIRIDIUM   = new ToolShovel(MODID, "tool_shovel_viridium",   MaterialTool.VIRIDIUM,   1, -1.0f);
    public static final Item TOOL_SHOVEL_ZINC       = new ToolShovel(MODID, "tool_shovel_zinc",       MaterialTool.ZINC,       1, -1.0f);
    public static final Item TOOL_SHOVEL_KOBALIUM   = new ToolShovel(MODID, "tool_shovel_kobalium",   MaterialTool.KOBALIUM,   1, -1.0f);
    public static final Item TOOL_SHOVEL_DENARIUM   = new ToolShovel(MODID, "tool_shovel_denarium",   MaterialTool.DENARIUM,   1, -1.0f);
    public static final Item TOOL_SHOVEL_MYTHRIL    = new ToolShovel(MODID, "tool_shovel_mythril",    MaterialTool.MYTHRIL,    1, -1.0f);
    public static final Item TOOL_SHOVEL_CLAVIUM    = new ToolShovel(MODID, "tool_shovel_clavium",    MaterialTool.CLAVIUM,    1, -1.0f);
    public static final Item TOOL_SHOVEL_AURELIUM   = new ToolShovel(MODID, "tool_shovel_aurelium",   MaterialTool.AURELIUM,   1, -1.0f);
    public static final Item TOOL_SHOVEL_NIVIDIUM   = new ToolShovel(MODID, "tool_shovel_nividium",   MaterialTool.NIVIDIUM,   1, -1.0f);
    public static final Item TOOL_SHOVEL_TIN        = new ToolShovel(MODID, "tool_shovel_tin",        MaterialTool.TIN,        1, -1.0f);
    public static final Item TOOL_SHOVEL_ORICHALCUM = new ToolShovel(MODID, "tool_shovel_orichalcum", MaterialTool.ORICHALCUM, 1, -1.0f);
    public static final Item TOOL_SHOVEL_SCARLETITE = new ToolShovel(MODID, "tool_shovel_scarletite", MaterialTool.SCARLETITE, 1, -1.0f);
    public static final Item TOOL_SHOVEL_COPPER     = new ToolShovel(MODID, "tool_shovel_copper",     MaterialTool.COPPER,     1, -1.0f);
    public static final Item TOOL_SHOVEL_BRONZE     = new ToolShovel(MODID, "tool_shovel_bronze",     MaterialTool.BRONZE,     1, -1.0f);
    public static final Item TOOL_SHOVEL_STEEL      = new ToolShovel(MODID, "tool_shovel_steel",      MaterialTool.STEEL,      1, -1.0f);
    public static final Item TOOL_SHOVEL_DARKSTEEL  = new ToolShovel(MODID, "tool_shovel_darksteel",  MaterialTool.DARKSTEEL,  1, -1.0f);
    public static final Item TOOL_SHOVEL_UNOBTANIUM = new ToolShovel(MODID, "tool_shovel_unobtanium", MaterialTool.UNOBTANIUM, 1, -1.0f);
    public static final Item TOOL_SHOVEL_AURORITE   = new ToolShovel(MODID, "tool_shovel_aurorite",   MaterialTool.AURORITE,   1, -1.0f);

    // Tool Hoe
    public static final Item TOOL_HOE_BRASS      = new ToolHoe(MODID, "tool_hoe_brass",      MaterialTool.BRASS,      -1.0f);
    public static final Item TOOL_HOE_QUESTORIUM = new ToolHoe(MODID, "tool_hoe_questorium", MaterialTool.QUESTORIUM, -1.0f);
    public static final Item TOOL_HOE_GILIUM     = new ToolHoe(MODID, "tool_hoe_gilium",     MaterialTool.GILIUM,     -1.0f);
    public static final Item TOOL_HOE_ADAMANTIUM = new ToolHoe(MODID, "tool_hoe_adamantium", MaterialTool.ADAMANTIUM, -1.0f);
    public static final Item TOOL_HOE_VIRIDIUM   = new ToolHoe(MODID, "tool_hoe_viridium",   MaterialTool.VIRIDIUM,   -1.0f);
    public static final Item TOOL_HOE_ZINC       = new ToolHoe(MODID, "tool_hoe_zinc",       MaterialTool.ZINC,       -1.0f);
    public static final Item TOOL_HOE_KOBALIUM   = new ToolHoe(MODID, "tool_hoe_kobalium",   MaterialTool.KOBALIUM,   -1.0f);
    public static final Item TOOL_HOE_DENARIUM   = new ToolHoe(MODID, "tool_hoe_denarium",   MaterialTool.DENARIUM,   -1.0f);
    public static final Item TOOL_HOE_MYTHRIL    = new ToolHoe(MODID, "tool_hoe_mythril",    MaterialTool.MYTHRIL,    -1.0f);
    public static final Item TOOL_HOE_CLAVIUM    = new ToolHoe(MODID, "tool_hoe_clavium",    MaterialTool.CLAVIUM,    -1.0f);
    public static final Item TOOL_HOE_AURELIUM   = new ToolHoe(MODID, "tool_hoe_aurelium",   MaterialTool.AURELIUM,   -1.0f);
    public static final Item TOOL_HOE_NIVIDIUM   = new ToolHoe(MODID, "tool_hoe_nividium",   MaterialTool.NIVIDIUM,   -1.0f);
    public static final Item TOOL_HOE_TIN        = new ToolHoe(MODID, "tool_hoe_tin",        MaterialTool.TIN,        -1.0f);
    public static final Item TOOL_HOE_ORICHALCUM = new ToolHoe(MODID, "tool_hoe_orichalcum", MaterialTool.ORICHALCUM, -1.0f);
    public static final Item TOOL_HOE_SCARLETITE = new ToolHoe(MODID, "tool_hoe_scarletite", MaterialTool.SCARLETITE, -1.0f);
    public static final Item TOOL_HOE_COPPER     = new ToolHoe(MODID, "tool_hoe_copper",     MaterialTool.COPPER,     -1.0f);
    public static final Item TOOL_HOE_BRONZE     = new ToolHoe(MODID, "tool_hoe_bronze",     MaterialTool.BRONZE,     -1.0f);
    public static final Item TOOL_HOE_STEEL      = new ToolHoe(MODID, "tool_hoe_steel",      MaterialTool.STEEL,      -1.0f);
    public static final Item TOOL_HOE_DARKSTEEL  = new ToolHoe(MODID, "tool_hoe_darksteel",  MaterialTool.DARKSTEEL,  -1.0f);
    public static final Item TOOL_HOE_UNOBTANIUM = new ToolHoe(MODID, "tool_hoe_unobtanium", MaterialTool.UNOBTANIUM, -1.0f);
    public static final Item TOOL_HOE_AURORITE   = new ToolHoe(MODID, "tool_hoe_aurorite",   MaterialTool.AURORITE,   -1.0f);

    /**Register all stuff, pre is true during preInit and false during Init**/
    public static void registerBlocks(){

        // Blocks
        Register.registerBlock(BLOCK_BRASS     , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_QUESTORIUM, ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_GILIUM    , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_ADAMANTIUM, ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_VIRIDIUM  , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_ZINC      , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_KOBALIUM  , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_DENARIUM  , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_MYTHRIL   , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_CLAVIUM   , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_AURELIUM  , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_NIVIDIUM  , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_TIN       , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_ORICHALCUM, ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_SCARLETITE, ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_COPPER    , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_BRONZE    , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_STEEL     , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_DARKSTEEL , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_UNOBTANIUM, ItemGroup.BUILDING_BLOCKS);

        // Ore
        Register.registerBlock(ORE_BRASS     , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_QUESTORIUM, ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_GILIUM    , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_ADAMANTIUM, ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_VIRIDIUM  , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_ZINC      , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_KOBALIUM  , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_DENARIUM  , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_MYTHRIL   , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_CLAVIUM   , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_AURELIUM  , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_NIVIDIUM  , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_TIN       , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_ORICHALCUM, ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_SCARLETITE, ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_COPPER    , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_BRONZE    , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_STEEL     , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_DARKSTEEL , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_UNOBTANIUM, ItemGroup.BUILDING_BLOCKS);

        Register.registerBlock(BLOCK_AURORITE, ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_RUBY    , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_TOPAZ   , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_SAPPHIRE, ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_AMETHYST, ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_CITRINE , ItemGroup.BUILDING_BLOCKS);

        // Other Blocks
        Register.registerBlock(BLOCK_SALT  , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_SULFUR, ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_JADE  , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_FLOUR , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_COFFEE, ItemGroup.BUILDING_BLOCKS);

        Register.registerBlock(ORE_AURORITE, ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_RUBY    , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_TOPAZ   , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_SAPPHIRE, ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_AMETHYST, ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_CITRINE , ItemGroup.BUILDING_BLOCKS);

        Register.registerBlock(ORE_SALT  , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_SULFUR, ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_JADE  , ItemGroup.BUILDING_BLOCKS);

        Register.registerBlock(CROP_COFFEE      , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(CROP_TURNIP      , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(CROP_CABBAGE     , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(CROP_TOMATO      , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(CROP_CUCUMBER    , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(CROP_RICE        , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(CROP_CORN        , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(CROP_GRAPES      , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(CROP_HEMP        , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(CROP_COTTON      , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(CROP_STRAWBERRIES, ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(CROP_ONION       , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(CROP_PINEAPPLE   , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(CROP_EGGPLANT    , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(CROP_SPINACH     , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(CROP_YAMS        , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(CROP_PEPPER      , ItemGroup.BUILDING_BLOCKS);

        Register.registerBlock(FLOWER_BAMBOO    , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(FLOWER_MATSUTAKE , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(FLOWER_MOONDROP  , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(FLOWER_TOYFLOWER , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(FLOWER_PINKCAT   , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(FLOWER_MAGICGRASS, ItemGroup.BUILDING_BLOCKS);

        Register.registerBlock(MACHINA_ROPE        , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(MACHINA_ANCHOR      , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(MACHINA_DESTILLERY  , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(MACHINA_GLOBE       , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(MACHINA_BLASTFURNACE, ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(MACHINA_KEG         , ItemGroup.BUILDING_BLOCKS);


    }

    public static void registerItems(){

        // Nuggets
        Register.registerItem(NUGGET_BRASS     );
        Register.registerItem(NUGGET_QUESTORIUM);
        Register.registerItem(NUGGET_GILIUM    );
        Register.registerItem(NUGGET_ADAMANTIUM);
        Register.registerItem(NUGGET_VIRIDIUM  );
        Register.registerItem(NUGGET_ZINC      );
        Register.registerItem(NUGGET_KOBALIUM  );
        Register.registerItem(NUGGET_DENARIUM  );
        Register.registerItem(NUGGET_MYTHRIL   );
        Register.registerItem(NUGGET_CLAVIUM   );
        Register.registerItem(NUGGET_AURELIUM  );
        Register.registerItem(NUGGET_NIVIDIUM  );
        Register.registerItem(NUGGET_TIN       );
        Register.registerItem(NUGGET_ORICHALCUM);
        Register.registerItem(NUGGET_SCARLETITE);
        Register.registerItem(NUGGET_COPPER    );
        Register.registerItem(NUGGET_BRONZE    );
        Register.registerItem(NUGGET_STEEL     );
        Register.registerItem(NUGGET_DARKSTEEL );
        Register.registerItem(NUGGET_UNOBTANIUM);

        // Ingots
        Register.registerItem(INGOT_BRASS     );
        Register.registerItem(INGOT_QUESTORIUM);
        Register.registerItem(INGOT_GILIUM    );
        Register.registerItem(INGOT_ADAMANTIUM);
        Register.registerItem(INGOT_VIRIDIUM  );
        Register.registerItem(INGOT_ZINC      );
        Register.registerItem(INGOT_KOBALIUM  );
        Register.registerItem(INGOT_DENARIUM  );
        Register.registerItem(INGOT_MYTHRIL   );
        Register.registerItem(INGOT_CLAVIUM   );
        Register.registerItem(INGOT_AURELIUM  );
        Register.registerItem(INGOT_NIVIDIUM  );
        Register.registerItem(INGOT_TIN       );
        Register.registerItem(INGOT_ORICHALCUM);
        Register.registerItem(INGOT_SCARLETITE);
        Register.registerItem(INGOT_COPPER    );
        Register.registerItem(INGOT_BRONZE    );
        Register.registerItem(INGOT_STEEL     );
        Register.registerItem(INGOT_DARKSTEEL );
        Register.registerItem(INGOT_UNOBTANIUM);

        // Gems
        Register.registerItem(GEM_AURORITE);
        Register.registerItem(GEM_RUBY    );
        Register.registerItem(GEM_TOPAZ   );
        Register.registerItem(GEM_SAPPHIRE);
        Register.registerItem(GEM_AMETHYST);
        Register.registerItem(GEM_CITRINE );
        Register.registerItem(GEM_JADE    );

        Register.registerItem(FOOD_COFFEE      );
        Register.registerItem(FOOD_TURNIP      );
        Register.registerItem(FOOD_CABBAGE     );
        Register.registerItem(FOOD_TOMATO      );
        Register.registerItem(FOOD_CUCUMBER    );
        Register.registerItem(FOOD_RICE        );
        Register.registerItem(FOOD_CORN        );
        Register.registerItem(FOOD_GRAPES      );
        Register.registerItem(FOOD_STRAWBERRIES);
        Register.registerItem(FOOD_ONION       );
        Register.registerItem(FOOD_PINEAPPLE   );
        Register.registerItem(FOOD_EGGPLANT    );
        Register.registerItem(FOOD_SPINACH     );
        Register.registerItem(FOOD_YAMS        );
        Register.registerItem(FOOD_PEPPER      );

        Register.registerItem(SEEDS_WILD        );
        Register.registerItem(SEEDS_COFFEE      );
        Register.registerItem(SEEDS_TURNIP      );
        Register.registerItem(SEEDS_CABBAGE     );
        Register.registerItem(SEEDS_TOMATO      );
        Register.registerItem(SEEDS_CUCUMBER    );
        Register.registerItem(SEEDS_RICE        );
        Register.registerItem(SEEDS_CORN        );
        Register.registerItem(SEEDS_GRAPES      );
        Register.registerItem(SEEDS_HEMP        );
        Register.registerItem(SEEDS_COTTON      );
        Register.registerItem(SEEDS_STRAWBERRIES);
        Register.registerItem(SEEDS_ONION       );
        Register.registerItem(SEEDS_PINEAPPLE   );
        Register.registerItem(SEEDS_EGGPLANT    );
        Register.registerItem(SEEDS_SPINACH     );
        Register.registerItem(SEEDS_YAMS        );
        Register.registerItem(SEEDS_PEPPER      );

        Register.registerItem(FOOD_VENISON_RAW   );
        Register.registerItem(FOOD_VENISON_COOKED);
        Register.registerItem(FOOD_VICUGNA_RAW   );
        Register.registerItem(FOOD_VICUGNA_COOKED);

        Register.registerItem(STUFF_DYNAMITE);

        Register.registerItem(STUFF_ROPE       );
        Register.registerItem(STUFF_HEMP       );
        Register.registerItem(STUFF_COTTON     );
        Register.registerItem(STUFF_GEAR_WOODEN);
        Register.registerItem(STUFF_FUR        );

        Register.registerItem(STUFF_FLOUR );
        Register.registerItem(STUFF_COFFEE);
        Register.registerItem(STUFF_SALT  );
        Register.registerItem(STUFF_SULFUR);

        Register.registerItem(LIQUOR_COFFEE);
        Register.registerItem(LIQUOR_RUM   );
        Register.registerItem(LIQUOR_SAKE  );
        Register.registerItem(LIQUOR_SALGAM);
        Register.registerItem(LIQUOR_VODKA );
        Register.registerItem(LIQUOR_BEER  );
        Register.registerItem(LIQUOR_CIDER );
        Register.registerItem(LIQUOR_WINE  );

        // Armor Boots
        Register.registerItem(ARMOR_BOOTS_BRASS     );
        Register.registerItem(ARMOR_BOOTS_QUESTORIUM);
        Register.registerItem(ARMOR_BOOTS_GILIUM    );
        Register.registerItem(ARMOR_BOOTS_ADAMANTIUM);
        Register.registerItem(ARMOR_BOOTS_VIRIDIUM  );
        Register.registerItem(ARMOR_BOOTS_ZINC      );
        Register.registerItem(ARMOR_BOOTS_KOBALIUM  );
        Register.registerItem(ARMOR_BOOTS_DENARIUM  );
        Register.registerItem(ARMOR_BOOTS_MYTHRIL   );
        Register.registerItem(ARMOR_BOOTS_CLAVIUM   );
        Register.registerItem(ARMOR_BOOTS_AURELIUM  );
        Register.registerItem(ARMOR_BOOTS_NIVIDIUM  );
        Register.registerItem(ARMOR_BOOTS_TIN       );
        Register.registerItem(ARMOR_BOOTS_ORICHALCUM);
        Register.registerItem(ARMOR_BOOTS_SCARLETITE);
        Register.registerItem(ARMOR_BOOTS_COPPER    );
        Register.registerItem(ARMOR_BOOTS_BRONZE    );
        Register.registerItem(ARMOR_BOOTS_STEEL     );
        Register.registerItem(ARMOR_BOOTS_DARKSTEEL );
        Register.registerItem(ARMOR_BOOTS_UNOBTANIUM);
        Register.registerItem(ARMOR_BOOTS_AURORITE  );

        // Armor Chestplate
        Register.registerItem(ARMOR_PLATE_BRASS     );
        Register.registerItem(ARMOR_PLATE_QUESTORIUM);
        Register.registerItem(ARMOR_PLATE_GILIUM    );
        Register.registerItem(ARMOR_PLATE_ADAMANTIUM);
        Register.registerItem(ARMOR_PLATE_VIRIDIUM  );
        Register.registerItem(ARMOR_PLATE_ZINC      );
        Register.registerItem(ARMOR_PLATE_KOBALIUM  );
        Register.registerItem(ARMOR_PLATE_DENARIUM  );
        Register.registerItem(ARMOR_PLATE_MYTHRIL   );
        Register.registerItem(ARMOR_PLATE_CLAVIUM   );
        Register.registerItem(ARMOR_PLATE_AURELIUM  );
        Register.registerItem(ARMOR_PLATE_NIVIDIUM  );
        Register.registerItem(ARMOR_PLATE_TIN       );
        Register.registerItem(ARMOR_PLATE_ORICHALCUM);
        Register.registerItem(ARMOR_PLATE_SCARLETITE);
        Register.registerItem(ARMOR_PLATE_COPPER    );
        Register.registerItem(ARMOR_PLATE_BRONZE    );
        Register.registerItem(ARMOR_PLATE_STEEL     );
        Register.registerItem(ARMOR_PLATE_DARKSTEEL );
        Register.registerItem(ARMOR_PLATE_UNOBTANIUM);
        Register.registerItem(ARMOR_PLATE_AURORITE  );

        // Armor Leggings
        Register.registerItem(ARMOR_LEGGINGS_BRASS     );
        Register.registerItem(ARMOR_LEGGINGS_QUESTORIUM);
        Register.registerItem(ARMOR_LEGGINGS_GILIUM    );
        Register.registerItem(ARMOR_LEGGINGS_ADAMANTIUM);
        Register.registerItem(ARMOR_LEGGINGS_VIRIDIUM  );
        Register.registerItem(ARMOR_LEGGINGS_ZINC      );
        Register.registerItem(ARMOR_LEGGINGS_KOBALIUM  );
        Register.registerItem(ARMOR_LEGGINGS_DENARIUM  );
        Register.registerItem(ARMOR_LEGGINGS_MYTHRIL   );
        Register.registerItem(ARMOR_LEGGINGS_CLAVIUM   );
        Register.registerItem(ARMOR_LEGGINGS_AURELIUM  );
        Register.registerItem(ARMOR_LEGGINGS_NIVIDIUM  );
        Register.registerItem(ARMOR_LEGGINGS_TIN       );
        Register.registerItem(ARMOR_LEGGINGS_ORICHALCUM);
        Register.registerItem(ARMOR_LEGGINGS_SCARLETITE);
        Register.registerItem(ARMOR_LEGGINGS_COPPER    );
        Register.registerItem(ARMOR_LEGGINGS_BRONZE    );
        Register.registerItem(ARMOR_LEGGINGS_STEEL     );
        Register.registerItem(ARMOR_LEGGINGS_DARKSTEEL );
        Register.registerItem(ARMOR_LEGGINGS_UNOBTANIUM);
        Register.registerItem(ARMOR_LEGGINGS_AURORITE  );

        // Armor Helmet
        Register.registerItem(ARMOR_HELMET_BRASS     );
        Register.registerItem(ARMOR_HELMET_QUESTORIUM);
        Register.registerItem(ARMOR_HELMET_GILIUM    );
        Register.registerItem(ARMOR_HELMET_ADAMANTIUM);
        Register.registerItem(ARMOR_HELMET_VIRIDIUM  );
        Register.registerItem(ARMOR_HELMET_ZINC      );
        Register.registerItem(ARMOR_HELMET_KOBALIUM  );
        Register.registerItem(ARMOR_HELMET_DENARIUM  );
        Register.registerItem(ARMOR_HELMET_MYTHRIL   );
        Register.registerItem(ARMOR_HELMET_CLAVIUM   );
        Register.registerItem(ARMOR_HELMET_AURELIUM  );
        Register.registerItem(ARMOR_HELMET_NIVIDIUM  );
        Register.registerItem(ARMOR_HELMET_TIN       );
        Register.registerItem(ARMOR_HELMET_ORICHALCUM);
        Register.registerItem(ARMOR_HELMET_SCARLETITE);
        Register.registerItem(ARMOR_HELMET_COPPER    );
        Register.registerItem(ARMOR_HELMET_BRONZE    );
        Register.registerItem(ARMOR_HELMET_STEEL     );
        Register.registerItem(ARMOR_HELMET_DARKSTEEL );
        Register.registerItem(ARMOR_HELMET_UNOBTANIUM);
        Register.registerItem(ARMOR_HELMET_AURORITE  );

        // Tool Sword
        Register.registerItem(TOOL_SWORD_BRASS     );
        Register.registerItem(TOOL_SWORD_QUESTORIUM);
        Register.registerItem(TOOL_SWORD_GILIUM    );
        Register.registerItem(TOOL_SWORD_ADAMANTIUM);
        Register.registerItem(TOOL_SWORD_VIRIDIUM  );
        Register.registerItem(TOOL_SWORD_ZINC      );
        Register.registerItem(TOOL_SWORD_KOBALIUM  );
        Register.registerItem(TOOL_SWORD_DENARIUM  );
        Register.registerItem(TOOL_SWORD_MYTHRIL   );
        Register.registerItem(TOOL_SWORD_CLAVIUM   );
        Register.registerItem(TOOL_SWORD_AURELIUM  );
        Register.registerItem(TOOL_SWORD_NIVIDIUM  );
        Register.registerItem(TOOL_SWORD_TIN       );
        Register.registerItem(TOOL_SWORD_ORICHALCUM);
        Register.registerItem(TOOL_SWORD_SCARLETITE);
        Register.registerItem(TOOL_SWORD_COPPER    );
        Register.registerItem(TOOL_SWORD_BRONZE    );
        Register.registerItem(TOOL_SWORD_STEEL     );
        Register.registerItem(TOOL_SWORD_DARKSTEEL );
        Register.registerItem(TOOL_SWORD_UNOBTANIUM);
        Register.registerItem(TOOL_SWORD_AURORITE  );

        // Tool Spear
        Register.registerItem(TOOL_SPEAR_BRASS     );
        Register.registerItem(TOOL_SPEAR_QUESTORIUM);
        Register.registerItem(TOOL_SPEAR_GILIUM    );
        Register.registerItem(TOOL_SPEAR_ADAMANTIUM);
        Register.registerItem(TOOL_SPEAR_VIRIDIUM  );
        Register.registerItem(TOOL_SPEAR_ZINC      );
        Register.registerItem(TOOL_SPEAR_KOBALIUM  );
        Register.registerItem(TOOL_SPEAR_DENARIUM  );
        Register.registerItem(TOOL_SPEAR_MYTHRIL   );
        Register.registerItem(TOOL_SPEAR_CLAVIUM   );
        Register.registerItem(TOOL_SPEAR_AURELIUM  );
        Register.registerItem(TOOL_SPEAR_NIVIDIUM  );
        Register.registerItem(TOOL_SPEAR_TIN       );
        Register.registerItem(TOOL_SPEAR_ORICHALCUM);
        Register.registerItem(TOOL_SPEAR_SCARLETITE);
        Register.registerItem(TOOL_SPEAR_COPPER    );
        Register.registerItem(TOOL_SPEAR_BRONZE    );
        Register.registerItem(TOOL_SPEAR_STEEL     );
        Register.registerItem(TOOL_SPEAR_DARKSTEEL );
        Register.registerItem(TOOL_SPEAR_UNOBTANIUM);
        Register.registerItem(TOOL_SPEAR_AURORITE  );

        // Tool Hammer
        Register.registerItem(TOOL_HAMMER_BRASS     );
        Register.registerItem(TOOL_HAMMER_QUESTORIUM);
        Register.registerItem(TOOL_HAMMER_GILIUM    );
        Register.registerItem(TOOL_HAMMER_ADAMANTIUM);
        Register.registerItem(TOOL_HAMMER_VIRIDIUM  );
        Register.registerItem(TOOL_HAMMER_ZINC      );
        Register.registerItem(TOOL_HAMMER_KOBALIUM  );
        Register.registerItem(TOOL_HAMMER_DENARIUM  );
        Register.registerItem(TOOL_HAMMER_MYTHRIL   );
        Register.registerItem(TOOL_HAMMER_CLAVIUM   );
        Register.registerItem(TOOL_HAMMER_AURELIUM  );
        Register.registerItem(TOOL_HAMMER_NIVIDIUM  );
        Register.registerItem(TOOL_HAMMER_TIN       );
        Register.registerItem(TOOL_HAMMER_ORICHALCUM);
        Register.registerItem(TOOL_HAMMER_SCARLETITE);
        Register.registerItem(TOOL_HAMMER_COPPER    );
        Register.registerItem(TOOL_HAMMER_BRONZE    );
        Register.registerItem(TOOL_HAMMER_STEEL     );
        Register.registerItem(TOOL_HAMMER_DARKSTEEL );
        Register.registerItem(TOOL_HAMMER_UNOBTANIUM);
        Register.registerItem(TOOL_HAMMER_AURORITE  );

        // Tool Axe
        Register.registerItem(TOOL_AXE_BRASS     );
        Register.registerItem(TOOL_AXE_QUESTORIUM);
        Register.registerItem(TOOL_AXE_GILIUM    );
        Register.registerItem(TOOL_AXE_ADAMANTIUM);
        Register.registerItem(TOOL_AXE_VIRIDIUM  );
        Register.registerItem(TOOL_AXE_ZINC      );
        Register.registerItem(TOOL_AXE_KOBALIUM  );
        Register.registerItem(TOOL_AXE_DENARIUM  );
        Register.registerItem(TOOL_AXE_MYTHRIL   );
        Register.registerItem(TOOL_AXE_CLAVIUM   );
        Register.registerItem(TOOL_AXE_AURELIUM  );
        Register.registerItem(TOOL_AXE_NIVIDIUM  );
        Register.registerItem(TOOL_AXE_TIN       );
        Register.registerItem(TOOL_AXE_ORICHALCUM);
        Register.registerItem(TOOL_AXE_SCARLETITE);
        Register.registerItem(TOOL_AXE_COPPER    );
        Register.registerItem(TOOL_AXE_BRONZE    );
        Register.registerItem(TOOL_AXE_STEEL     );
        Register.registerItem(TOOL_AXE_DARKSTEEL );
        Register.registerItem(TOOL_AXE_UNOBTANIUM);
        Register.registerItem(TOOL_AXE_AURORITE  );

        // Tool Pickaxe
        Register.registerItem(TOOL_PICKAXE_BRASS     );
        Register.registerItem(TOOL_PICKAXE_QUESTORIUM);
        Register.registerItem(TOOL_PICKAXE_GILIUM    );
        Register.registerItem(TOOL_PICKAXE_ADAMANTIUM);
        Register.registerItem(TOOL_PICKAXE_VIRIDIUM  );
        Register.registerItem(TOOL_PICKAXE_ZINC      );
        Register.registerItem(TOOL_PICKAXE_KOBALIUM  );
        Register.registerItem(TOOL_PICKAXE_DENARIUM  );
        Register.registerItem(TOOL_PICKAXE_MYTHRIL   );
        Register.registerItem(TOOL_PICKAXE_CLAVIUM   );
        Register.registerItem(TOOL_PICKAXE_AURELIUM  );
        Register.registerItem(TOOL_PICKAXE_NIVIDIUM  );
        Register.registerItem(TOOL_PICKAXE_TIN       );
        Register.registerItem(TOOL_PICKAXE_ORICHALCUM);
        Register.registerItem(TOOL_PICKAXE_SCARLETITE);
        Register.registerItem(TOOL_PICKAXE_COPPER    );
        Register.registerItem(TOOL_PICKAXE_BRONZE    );
        Register.registerItem(TOOL_PICKAXE_STEEL     );
        Register.registerItem(TOOL_PICKAXE_DARKSTEEL );
        Register.registerItem(TOOL_PICKAXE_UNOBTANIUM);
        Register.registerItem(TOOL_PICKAXE_AURORITE  );

        // Tool Shovel
        Register.registerItem(TOOL_SHOVEL_BRASS     );
        Register.registerItem(TOOL_SHOVEL_QUESTORIUM);
        Register.registerItem(TOOL_SHOVEL_GILIUM    );
        Register.registerItem(TOOL_SHOVEL_ADAMANTIUM);
        Register.registerItem(TOOL_SHOVEL_VIRIDIUM  );
        Register.registerItem(TOOL_SHOVEL_ZINC      );
        Register.registerItem(TOOL_SHOVEL_KOBALIUM  );
        Register.registerItem(TOOL_SHOVEL_DENARIUM  );
        Register.registerItem(TOOL_SHOVEL_MYTHRIL   );
        Register.registerItem(TOOL_SHOVEL_CLAVIUM   );
        Register.registerItem(TOOL_SHOVEL_AURELIUM  );
        Register.registerItem(TOOL_SHOVEL_NIVIDIUM  );
        Register.registerItem(TOOL_SHOVEL_TIN       );
        Register.registerItem(TOOL_SHOVEL_ORICHALCUM);
        Register.registerItem(TOOL_SHOVEL_SCARLETITE);
        Register.registerItem(TOOL_SHOVEL_COPPER    );
        Register.registerItem(TOOL_SHOVEL_BRONZE    );
        Register.registerItem(TOOL_SHOVEL_STEEL     );
        Register.registerItem(TOOL_SHOVEL_DARKSTEEL );
        Register.registerItem(TOOL_SHOVEL_UNOBTANIUM);
        Register.registerItem(TOOL_SHOVEL_AURORITE  );

        // Tool Hoe
        Register.registerItem(TOOL_HOE_BRASS     );
        Register.registerItem(TOOL_HOE_QUESTORIUM);
        Register.registerItem(TOOL_HOE_GILIUM    );
        Register.registerItem(TOOL_HOE_ADAMANTIUM);
        Register.registerItem(TOOL_HOE_VIRIDIUM  );
        Register.registerItem(TOOL_HOE_ZINC      );
        Register.registerItem(TOOL_HOE_KOBALIUM  );
        Register.registerItem(TOOL_HOE_DENARIUM  );
        Register.registerItem(TOOL_HOE_MYTHRIL   );
        Register.registerItem(TOOL_HOE_CLAVIUM   );
        Register.registerItem(TOOL_HOE_AURELIUM  );
        Register.registerItem(TOOL_HOE_NIVIDIUM  );
        Register.registerItem(TOOL_HOE_TIN       );
        Register.registerItem(TOOL_HOE_ORICHALCUM);
        Register.registerItem(TOOL_HOE_SCARLETITE);
        Register.registerItem(TOOL_HOE_COPPER    );
        Register.registerItem(TOOL_HOE_BRONZE    );
        Register.registerItem(TOOL_HOE_STEEL     );
        Register.registerItem(TOOL_HOE_DARKSTEEL );
        Register.registerItem(TOOL_HOE_UNOBTANIUM);
        Register.registerItem(TOOL_HOE_AURORITE  );
    }

    //@ObjectHolder(ContainerReference.TEMPLATE_MANAGER_CONTAINER)
    public final static ContainerType<ContainerBlastFurnace> TYPE_BLASTFURNACE = IForgeContainerType.create(ContainerBlastFurnace::new);
    public final static ContainerType<ContainerDestille> TYPE_DESTILLE         = IForgeContainerType.create(ContainerDestille::new);

    public static TileEntityType<TileEntity> TYPE_BLASTFURNACE_TILE;
    public static TileEntityType<TileEntity> TYPE_DESTILLE_TILE;

    public static void registerContainer(IForgeRegistry<ContainerType<?>> registry){
        registry.register(TYPE_BLASTFURNACE.setRegistryName(MODID, "blastfurnace"));
        registry.register(TYPE_DESTILLE.setRegistryName(MODID, "destille"));
    }

    public static void registerGUI(){
        ScreenManager.registerFactory(TYPE_BLASTFURNACE, GuiBlastFurnace::new);
        ScreenManager.registerFactory(TYPE_DESTILLE, GuiDistille::new);
        //ScreenManager.<TYPE_BLASTFURNACE, GuiBlastFurnace>registerFactory(TYPE_BLASTFURNACE, GuiBlastFurnace::new);
    }

    /**Register Living Entities**/
    public static void registerEntities(){
       // event.getRegistry().register(
//
       //         EntityType.Builder.<ConstructionBlockEntity>create(ConstructionBlockEntity::new, EntityClassification.MISC)
//
       //                 .setTrackingRange(64)
//
       //                 .setUpdateInterval(1)
//
       //                 .setShouldReceiveVelocityUpdates(false)
//
       //                 .setCustomClientFactory(((spawnEntity, world) -> new ConstructionBlockEntity(CONSTRUCTION_BLOCK, world)))
//
       //                 .build("")
//
       //                 .setRegistryName(EntityReference.CONSTRUCTION_BLOCK_ENTITY_RL)
//
       // );

        /**

         * Called from the runWhenOn(Dist.CLIENT...) method somewhere else.

         * This is a client side only render.

         */

      // public static void registerModels() {

      //     FMLJavaModLoadingContext.get().getModEventBus().addListener(event -> RenderingRegistry.registerEntityRenderingHandler(ConstructionBlockEntity.class, ConstructionBlockEntityRender::new));

      // }

    }

}
