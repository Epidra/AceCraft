package mod.acecraft;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.google.common.base.CaseFormat;
import com.google.common.collect.Lists;
import mod.acecraft.blocks.*;
import mod.acecraft.container.ContainerBlastFurnace;
import mod.acecraft.container.ContainerDestille;
import mod.acecraft.crafting.RecipeDestille;
import mod.acecraft.crafting.RecipeStove;
import mod.acecraft.entity.EntityCrab;
import mod.acecraft.entity.EntityDynamite;
import mod.acecraft.entity.EntityNugget;
import mod.acecraft.entity.EntitySpear;
import mod.acecraft.gui.GuiBlastFurnace;
import mod.acecraft.gui.GuiDistille;
import mod.acecraft.items.*;
import mod.acecraft.render.RenderCrab;
import mod.acecraft.util.BiomeDictionaryHelper;
import mod.acecraft.util.MaterialArmor;
import mod.acecraft.util.MaterialTool;
import mod.shared.Register;
import mod.shared.blocks.BlockBlock;
import mod.shared.items.ItemItem;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

import javax.annotation.Nullable;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static mod.acecraft.AceCraft.MODID;

public class ShopKeeper {

    // Blocks
    public static final Block BLOCK_BRASS      = new BlockBlock(MODID, "block_brass",      Blocks.IRON_BLOCK);
    public static final Block BLOCK_GILIUM     = new BlockBlock(MODID, "block_gilium",     Blocks.IRON_BLOCK);
    public static final Block BLOCK_ADAMANTIUM = new BlockBlock(MODID, "block_adamantium", Blocks.IRON_BLOCK);
    public static final Block BLOCK_ZINC       = new BlockBlock(MODID, "block_zinc",       Blocks.IRON_BLOCK);
    public static final Block BLOCK_MYTHRIL    = new BlockBlock(MODID, "block_mythril",    Blocks.IRON_BLOCK);
    public static final Block BLOCK_TIN        = new BlockBlock(MODID, "block_tin",        Blocks.IRON_BLOCK);
    public static final Block BLOCK_ORICHALCUM = new BlockBlock(MODID, "block_orichalcum", Blocks.IRON_BLOCK);
    public static final Block BLOCK_COPPER     = new BlockBlock(MODID, "block_copper",     Blocks.IRON_BLOCK);
    public static final Block BLOCK_BRONZE     = new BlockBlock(MODID, "block_bronze",     Blocks.IRON_BLOCK);
    public static final Block BLOCK_STEEL      = new BlockBlock(MODID, "block_steel",      Blocks.IRON_BLOCK);

    // Ore
    public static final Block ORE_GILIUM     = new BlockBlock(MODID, "ore_gilium",     Blocks.IRON_BLOCK);
    public static final Block ORE_ZINC       = new BlockBlock(MODID, "ore_zinc",       Blocks.IRON_BLOCK);
    public static final Block ORE_MYTHRIL    = new BlockBlock(MODID, "ore_mythril",    Blocks.IRON_BLOCK);
    public static final Block ORE_TIN        = new BlockBlock(MODID, "ore_tin",        Blocks.IRON_BLOCK);
    public static final Block ORE_COPPER     = new BlockBlock(MODID, "ore_copper",     Blocks.IRON_BLOCK);

    // Nuggets
    public static final Item NUGGET_GILIUM     = new ItemItem(MODID, "nugget_gilium",     ItemGroup.MATERIALS);
    public static final Item NUGGET_ZINC       = new ItemItem(MODID, "nugget_zinc",       ItemGroup.MATERIALS);
    public static final Item NUGGET_MYTHRIL    = new ItemItem(MODID, "nugget_mythril",    ItemGroup.MATERIALS);
    public static final Item NUGGET_TIN        = new ItemItem(MODID, "nugget_tin",        ItemGroup.MATERIALS);
    public static final Item NUGGET_COPPER     = new ItemItem(MODID, "nugget_copper",     ItemGroup.MATERIALS);

    // Ingots
    public static final Item INGOT_BRASS      = new ItemItem(MODID, "ingot_brass",      ItemGroup.MATERIALS);
    public static final Item INGOT_GILIUM     = new ItemItem(MODID, "ingot_gilium",     ItemGroup.MATERIALS);
    public static final Item INGOT_ADAMANTIUM = new ItemItem(MODID, "ingot_adamantium", ItemGroup.MATERIALS);
    public static final Item INGOT_ZINC       = new ItemItem(MODID, "ingot_zinc",       ItemGroup.MATERIALS);
    public static final Item INGOT_MYTHRIL    = new ItemItem(MODID, "ingot_mythril",    ItemGroup.MATERIALS);
    public static final Item INGOT_TIN        = new ItemItem(MODID, "ingot_tin",        ItemGroup.MATERIALS);
    public static final Item INGOT_ORICHALCUM = new ItemItem(MODID, "ingot_orichalcum", ItemGroup.MATERIALS);
    public static final Item INGOT_COPPER     = new ItemItem(MODID, "ingot_copper",     ItemGroup.MATERIALS);
    public static final Item INGOT_BRONZE     = new ItemItem(MODID, "ingot_bronze",     ItemGroup.MATERIALS);
    public static final Item INGOT_STEEL      = new ItemItem(MODID, "ingot_steel",      ItemGroup.MATERIALS);




    public static final Block BLOCK_AURORITE = new BlockBlock(MODID, "block_aurorite", Blocks.DIAMOND_BLOCK);
    public static final Block BLOCK_RUBY = new BlockBlock(MODID, "block_ruby", Blocks.DIAMOND_BLOCK);
    public static final Block BLOCK_SAPPHIRE = new BlockBlock(MODID, "block_sapphire", Blocks.DIAMOND_BLOCK);
    public static final Block BLOCK_AMETHYST = new BlockBlock(MODID, "block_amethyst", Blocks.DIAMOND_BLOCK);

    // Other Blocks
    public static final Block BLOCK_SALT = new BlockBlock(MODID, "block_salt", Blocks.SAND);
    public static final Block BLOCK_SULFUR = new BlockBlock(MODID, "block_sulfur", Blocks.SAND);
    public static final Block BLOCK_FLOUR = new BlockBlock(MODID, "block_flour", Blocks.SAND);
    public static final Block BLOCK_COFFEE = new BlockBlock(MODID, "block_coffee", Blocks.SAND);

    public static final Block ORE_AURORITE = new BlockOre(MODID, "ore_aurorite", Blocks.DIAMOND_ORE);
    public static final Block ORE_RUBY = new BlockOre(MODID, "ore_ruby", Blocks.DIAMOND_ORE);
    public static final Block ORE_SAPPHIRE = new BlockOre(MODID, "ore_sapphire", Blocks.DIAMOND_ORE);
    public static final Block ORE_AMETHYST = new BlockOre(MODID, "ore_amethyst", Blocks.DIAMOND_ORE);

    public static final Block ORE_SALT = new BlockOre(MODID, "ore_salt", Blocks.LAPIS_ORE);
    public static final Block ORE_SULFUR = new BlockOre(MODID, "ore_sulfur", Blocks.LAPIS_ORE);

    public static final Block CROP_COFFEE = new BlockCrop(MODID, "crop_coffee", 7,  Blocks.GRASS);
    public static final Block CROP_TURNIP = new BlockCrop(MODID, "crop_turnip", 7, Blocks.GRASS);
    public static final Block CROP_CABBAGE = new BlockCrop(MODID, "crop_cabbage", 7, Blocks.GRASS);
    public static final Block CROP_TOMATO = new BlockCrop(MODID, "crop_tomato", 7, Blocks.GRASS);
    public static final Block CROP_CUCUMBER = new BlockCrop(MODID, "crop_cucumber", 7, Blocks.GRASS);
    public static final Block CROP_CORN = new BlockCrop(MODID, "crop_corn", 7, Blocks.GRASS);
    public static final Block CROP_GRAPES = new BlockCrop(MODID, "crop_grapes", 7, Blocks.GRASS);
    public static final Block CROP_HEMP = new BlockCrop(MODID, "crop_hemp", 7, Blocks.GRASS);
    public static final Block CROP_STRAWBERRIES = new BlockCrop(MODID, "crop_strawberries", 7, Blocks.GRASS);
    public static final Block CROP_ONION = new BlockCrop(MODID, "crop_onion", 7, Blocks.GRASS);

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
    public static final Item FOOD_CORN = new ItemFood(MODID, "food_corn",  4, 0.4f);
    public static final Item FOOD_GRAPES = new ItemFood(MODID, "food_grapes",  4, 0.4f);
    public static final Item FOOD_STRAWBERRIES = new ItemFood(MODID, "food_strawberries",  4, 0.4f);
    public static final Item FOOD_ONION = new ItemFood(MODID, "food_onion",  4, 0.4f);

    public static final Item SEEDS_WILD = new ItemSeedWild(MODID, "seeds_wild", new Item.Properties().group(ItemGroup.FOOD));
    public static final Item SEEDS_COFFEE = new ItemSeed(MODID, "seeds_coffee", CROP_COFFEE, new Item.Properties().group(ItemGroup.FOOD));
    public static final Item SEEDS_TURNIP = new ItemSeed(MODID, "seeds_turnip", CROP_TURNIP, new Item.Properties().group(ItemGroup.FOOD));
    public static final Item SEEDS_CABBAGE = new ItemSeed(MODID, "seeds_cabbage", CROP_CABBAGE, new Item.Properties().group(ItemGroup.FOOD));
    public static final Item SEEDS_TOMATO = new ItemSeed(MODID, "seeds_tomato", CROP_TOMATO, new Item.Properties().group(ItemGroup.FOOD));
    public static final Item SEEDS_CUCUMBER = new ItemSeed(MODID, "seeds_cucumber", CROP_CUCUMBER, new Item.Properties().group(ItemGroup.FOOD));
    public static final Item SEEDS_CORN = new ItemSeed(MODID, "seeds_corn", CROP_CORN, new Item.Properties().group(ItemGroup.FOOD));
    public static final Item SEEDS_GRAPES = new ItemSeed(MODID, "seeds_grapes", CROP_GRAPES, new Item.Properties().group(ItemGroup.FOOD));
    public static final Item SEEDS_HEMP = new ItemSeed(MODID, "seeds_hemp", CROP_HEMP, new Item.Properties().group(ItemGroup.FOOD));
    public static final Item SEEDS_STRAWBERRIES = new ItemSeed(MODID, "seeds_strawberries", CROP_STRAWBERRIES, new Item.Properties().group(ItemGroup.FOOD));
    public static final Item SEEDS_ONION = new ItemSeed(MODID, "seeds_onion", CROP_ONION, new Item.Properties().group(ItemGroup.FOOD));

    public static final Item FOOD_VENISON_RAW = new ItemFood(MODID, "food_venison_raw",  4, 0.4f);
    public static final Item FOOD_VENISON_COOKED = new ItemFood(MODID, "food_venison_cooked",  4, 0.4f);
    public static final Item FOOD_VICUGNA_RAW = new ItemFood(MODID, "food_vicugna_raw",  4, 0.4f);
    public static final Item FOOD_VICUGNA_COOKED = new ItemFood(MODID, "food_vicugna_cooked",  4, 0.4f);

    public static final Item STUFF_DYNAMITE = new ItemDynamite(MODID, "stuff_dynamite", ItemGroup.TOOLS);

    public static final Item STUFF_ROPE = new ItemItem(MODID, "stuff_rope", ItemGroup.MISC);
    public static final Item STUFF_HEMP = new ItemItem(MODID, "stuff_hemp", ItemGroup.MISC);
    public static final Item STUFF_GEAR_WOODEN = new ItemItem(MODID, "stuff_gear_wooden", ItemGroup.MISC);
    public static final Item STUFF_AURORITE = new ItemItem(MODID, "stuff_aurorite", ItemGroup.MISC);
    public static final Item STUFF_RUBY = new ItemItem(MODID, "stuff_ruby", ItemGroup.MISC);
    public static final Item STUFF_SAPPHIRE = new ItemItem(MODID, "stuff_sapphire", ItemGroup.MISC);
    public static final Item STUFF_AMETHYST = new ItemItem(MODID, "stuff_amethyst", ItemGroup.MISC);
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
    public static final Item ARMOR_BOOTS_GILIUM     = new ItemArmor(MODID, "armor_boots_gilium",     MaterialArmor.GILIUM,     EquipmentSlotType.FEET);
    public static final Item ARMOR_BOOTS_ADAMANTIUM = new ItemArmor(MODID, "armor_boots_adamantium", MaterialArmor.ADAMANTIUM, EquipmentSlotType.FEET);
    public static final Item ARMOR_BOOTS_MYTHRIL    = new ItemArmor(MODID, "armor_boots_mythril",    MaterialArmor.MYTHRIL,    EquipmentSlotType.FEET);
    public static final Item ARMOR_BOOTS_ORICHALCUM = new ItemArmor(MODID, "armor_boots_orichalcum", MaterialArmor.ORICHALCUM, EquipmentSlotType.FEET);
    public static final Item ARMOR_BOOTS_COPPER     = new ItemArmor(MODID, "armor_boots_copper",     MaterialArmor.COPPER,     EquipmentSlotType.FEET);
    public static final Item ARMOR_BOOTS_BRONZE     = new ItemArmor(MODID, "armor_boots_bronze",     MaterialArmor.BRONZE,     EquipmentSlotType.FEET);
    public static final Item ARMOR_BOOTS_STEEL      = new ItemArmor(MODID, "armor_boots_steel",      MaterialArmor.STEEL,      EquipmentSlotType.FEET);
    public static final Item ARMOR_BOOTS_AURORITE   = new ItemArmor(MODID, "armor_boots_aurorite",   MaterialArmor.AURORITE,   EquipmentSlotType.FEET);

    // Armor Chestplate
    public static final Item ARMOR_PLATE_BRASS      = new ItemArmor(MODID, "armor_plate_brass",      MaterialArmor.BRASS,      EquipmentSlotType.CHEST);
    public static final Item ARMOR_PLATE_GILIUM     = new ItemArmor(MODID, "armor_plate_gilium",     MaterialArmor.GILIUM,     EquipmentSlotType.CHEST);
    public static final Item ARMOR_PLATE_ADAMANTIUM = new ItemArmor(MODID, "armor_plate_adamantium", MaterialArmor.ADAMANTIUM, EquipmentSlotType.CHEST);
    public static final Item ARMOR_PLATE_MYTHRIL    = new ItemArmor(MODID, "armor_plate_mythril",    MaterialArmor.MYTHRIL,    EquipmentSlotType.CHEST);
    public static final Item ARMOR_PLATE_ORICHALCUM = new ItemArmor(MODID, "armor_plate_orichalcum", MaterialArmor.ORICHALCUM, EquipmentSlotType.CHEST);
    public static final Item ARMOR_PLATE_COPPER     = new ItemArmor(MODID, "armor_plate_copper",     MaterialArmor.COPPER,     EquipmentSlotType.CHEST);
    public static final Item ARMOR_PLATE_BRONZE     = new ItemArmor(MODID, "armor_plate_bronze",     MaterialArmor.BRONZE,     EquipmentSlotType.CHEST);
    public static final Item ARMOR_PLATE_STEEL      = new ItemArmor(MODID, "armor_plate_steel",      MaterialArmor.STEEL,      EquipmentSlotType.CHEST);
    public static final Item ARMOR_PLATE_AURORITE   = new ItemArmor(MODID, "armor_plate_aurorite",   MaterialArmor.AURORITE,   EquipmentSlotType.CHEST);

    // Armor Leggings
    public static final Item ARMOR_LEGGINGS_BRASS      = new ItemArmor(MODID, "armor_leggings_brass",      MaterialArmor.BRASS,      EquipmentSlotType.LEGS);
    public static final Item ARMOR_LEGGINGS_GILIUM     = new ItemArmor(MODID, "armor_leggings_gilium",     MaterialArmor.GILIUM,     EquipmentSlotType.LEGS);
    public static final Item ARMOR_LEGGINGS_ADAMANTIUM = new ItemArmor(MODID, "armor_leggings_adamantium", MaterialArmor.ADAMANTIUM, EquipmentSlotType.LEGS);
    public static final Item ARMOR_LEGGINGS_MYTHRIL    = new ItemArmor(MODID, "armor_leggings_mythril",    MaterialArmor.MYTHRIL,    EquipmentSlotType.LEGS);
    public static final Item ARMOR_LEGGINGS_ORICHALCUM = new ItemArmor(MODID, "armor_leggings_orichalcum", MaterialArmor.ORICHALCUM, EquipmentSlotType.LEGS);
    public static final Item ARMOR_LEGGINGS_COPPER     = new ItemArmor(MODID, "armor_leggings_copper",     MaterialArmor.COPPER,     EquipmentSlotType.LEGS);
    public static final Item ARMOR_LEGGINGS_BRONZE     = new ItemArmor(MODID, "armor_leggings_bronze",     MaterialArmor.BRONZE,     EquipmentSlotType.LEGS);
    public static final Item ARMOR_LEGGINGS_STEEL      = new ItemArmor(MODID, "armor_leggings_steel",      MaterialArmor.STEEL,      EquipmentSlotType.LEGS);
    public static final Item ARMOR_LEGGINGS_AURORITE   = new ItemArmor(MODID, "armor_leggings_aurorite",   MaterialArmor.AURORITE,   EquipmentSlotType.LEGS);

    // Armor Helmet
    public static final Item ARMOR_HELMET_BRASS      = new ItemArmor(MODID, "armor_helmet_brass",      MaterialArmor.BRASS,      EquipmentSlotType.HEAD);
    public static final Item ARMOR_HELMET_GILIUM     = new ItemArmor(MODID, "armor_helmet_gilium",     MaterialArmor.GILIUM,     EquipmentSlotType.HEAD);
    public static final Item ARMOR_HELMET_ADAMANTIUM = new ItemArmor(MODID, "armor_helmet_adamantium", MaterialArmor.ADAMANTIUM, EquipmentSlotType.HEAD);
    public static final Item ARMOR_HELMET_MYTHRIL    = new ItemArmor(MODID, "armor_helmet_mythril",    MaterialArmor.MYTHRIL,    EquipmentSlotType.HEAD);
    public static final Item ARMOR_HELMET_ORICHALCUM = new ItemArmor(MODID, "armor_helmet_orichalcum", MaterialArmor.ORICHALCUM, EquipmentSlotType.HEAD);
    public static final Item ARMOR_HELMET_COPPER     = new ItemArmor(MODID, "armor_helmet_copper",     MaterialArmor.COPPER,     EquipmentSlotType.HEAD);
    public static final Item ARMOR_HELMET_BRONZE     = new ItemArmor(MODID, "armor_helmet_bronze",     MaterialArmor.BRONZE,     EquipmentSlotType.HEAD);
    public static final Item ARMOR_HELMET_STEEL      = new ItemArmor(MODID, "armor_helmet_steel",      MaterialArmor.STEEL,      EquipmentSlotType.HEAD);
    public static final Item ARMOR_HELMET_AURORITE   = new ItemArmor(MODID, "armor_helmet_aurorite",   MaterialArmor.AURORITE,   EquipmentSlotType.HEAD);

    // Tool Sword
    public static final Item TOOL_SWORD_BRASS      = new ToolSword(MODID, "tool_sword_brass",      MaterialTool.BRASS,      1, -1.0f);
    public static final Item TOOL_SWORD_GILIUM     = new ToolSword(MODID, "tool_sword_gilium",     MaterialTool.GILIUM,     1, -1.0f);
    public static final Item TOOL_SWORD_ADAMANTIUM = new ToolSword(MODID, "tool_sword_adamantium", MaterialTool.ADAMANTIUM, 1, -1.0f);
    public static final Item TOOL_SWORD_MYTHRIL    = new ToolSword(MODID, "tool_sword_mythril",    MaterialTool.MYTHRIL,    1, -1.0f);
    public static final Item TOOL_SWORD_ORICHALCUM = new ToolSword(MODID, "tool_sword_orichalcum", MaterialTool.ORICHALCUM, 1, -1.0f);
    public static final Item TOOL_SWORD_COPPER     = new ToolSword(MODID, "tool_sword_copper",     MaterialTool.COPPER,     1, -1.0f);
    public static final Item TOOL_SWORD_BRONZE     = new ToolSword(MODID, "tool_sword_bronze",     MaterialTool.BRONZE,     1, -1.0f);
    public static final Item TOOL_SWORD_STEEL      = new ToolSword(MODID, "tool_sword_steel",      MaterialTool.STEEL,      1, -1.0f);
    public static final Item TOOL_SWORD_AURORITE   = new ToolSword(MODID, "tool_sword_aurorite",   MaterialTool.AURORITE,   1, -1.0f);

    // Tool Spear
    public static final Item TOOL_SPEAR_BRASS      = new ToolSpear(MODID, "tool_spear_brass",      MaterialTool.BRASS,      1, -1.0f);
    public static final Item TOOL_SPEAR_GILIUM     = new ToolSpear(MODID, "tool_spear_gilium",     MaterialTool.GILIUM,     1, -1.0f);
    public static final Item TOOL_SPEAR_ADAMANTIUM = new ToolSpear(MODID, "tool_spear_adamantium", MaterialTool.ADAMANTIUM, 1, -1.0f);
    public static final Item TOOL_SPEAR_MYTHRIL    = new ToolSpear(MODID, "tool_spear_mythril",    MaterialTool.MYTHRIL,    1, -1.0f);
    public static final Item TOOL_SPEAR_ORICHALCUM = new ToolSpear(MODID, "tool_spear_orichalcum", MaterialTool.ORICHALCUM, 1, -1.0f);
    public static final Item TOOL_SPEAR_COPPER     = new ToolSpear(MODID, "tool_spear_copper",     MaterialTool.COPPER,     1, -1.0f);
    public static final Item TOOL_SPEAR_BRONZE     = new ToolSpear(MODID, "tool_spear_bronze",     MaterialTool.BRONZE,     1, -1.0f);
    public static final Item TOOL_SPEAR_STEEL      = new ToolSpear(MODID, "tool_spear_steel",      MaterialTool.STEEL,      1, -1.0f);
    public static final Item TOOL_SPEAR_AURORITE   = new ToolSpear(MODID, "tool_spear_aurorite",   MaterialTool.AURORITE,   1, -1.0f);

    // Tool Axe
    public static final Item TOOL_AXE_BRASS      = new ToolAxe(MODID, "tool_axe_brass",      MaterialTool.BRASS,      1, -1.0f);
    public static final Item TOOL_AXE_GILIUM     = new ToolAxe(MODID, "tool_axe_gilium",     MaterialTool.GILIUM,     1, -1.0f);
    public static final Item TOOL_AXE_ADAMANTIUM = new ToolAxe(MODID, "tool_axe_adamantium", MaterialTool.ADAMANTIUM, 1, -1.0f);
    public static final Item TOOL_AXE_MYTHRIL    = new ToolAxe(MODID, "tool_axe_mythril",    MaterialTool.MYTHRIL,    1, -1.0f);
    public static final Item TOOL_AXE_ORICHALCUM = new ToolAxe(MODID, "tool_axe_orichalcum", MaterialTool.ORICHALCUM, 1, -1.0f);
    public static final Item TOOL_AXE_COPPER     = new ToolAxe(MODID, "tool_axe_copper",     MaterialTool.COPPER,     1, -1.0f);
    public static final Item TOOL_AXE_BRONZE     = new ToolAxe(MODID, "tool_axe_bronze",     MaterialTool.BRONZE,     1, -1.0f);
    public static final Item TOOL_AXE_STEEL      = new ToolAxe(MODID, "tool_axe_steel",      MaterialTool.STEEL,      1, -1.0f);
    public static final Item TOOL_AXE_AURORITE   = new ToolAxe(MODID, "tool_axe_aurorite",   MaterialTool.AURORITE,   1, -1.0f);

    // Tool Pickaxe
    public static final Item TOOL_PICKAXE_BRASS      = new ToolPickaxe(MODID, "tool_pickaxe_brass",      MaterialTool.BRASS,      1, -1.0f);
    public static final Item TOOL_PICKAXE_GILIUM     = new ToolPickaxe(MODID, "tool_pickaxe_gilium",     MaterialTool.GILIUM,     1, -1.0f);
    public static final Item TOOL_PICKAXE_ADAMANTIUM = new ToolPickaxe(MODID, "tool_pickaxe_adamantium", MaterialTool.ADAMANTIUM, 1, -1.0f);
    public static final Item TOOL_PICKAXE_MYTHRIL    = new ToolPickaxe(MODID, "tool_pickaxe_mythril",    MaterialTool.MYTHRIL,    1, -1.0f);
    public static final Item TOOL_PICKAXE_ORICHALCUM = new ToolPickaxe(MODID, "tool_pickaxe_orichalcum", MaterialTool.ORICHALCUM, 1, -1.0f);
    public static final Item TOOL_PICKAXE_COPPER     = new ToolPickaxe(MODID, "tool_pickaxe_copper",     MaterialTool.COPPER,     1, -1.0f);
    public static final Item TOOL_PICKAXE_BRONZE     = new ToolPickaxe(MODID, "tool_pickaxe_bronze",     MaterialTool.BRONZE,     1, -1.0f);
    public static final Item TOOL_PICKAXE_STEEL      = new ToolPickaxe(MODID, "tool_pickaxe_steel",      MaterialTool.STEEL,      1, -1.0f);
    public static final Item TOOL_PICKAXE_AURORITE   = new ToolPickaxe(MODID, "tool_pickaxe_aurorite",   MaterialTool.AURORITE,   1, -1.0f);

    // Tool Shovel
    public static final Item TOOL_SHOVEL_BRASS      = new ToolShovel(MODID, "tool_shovel_brass",      MaterialTool.BRASS,      1, -1.0f);
    public static final Item TOOL_SHOVEL_GILIUM     = new ToolShovel(MODID, "tool_shovel_gilium",     MaterialTool.GILIUM,     1, -1.0f);
    public static final Item TOOL_SHOVEL_ADAMANTIUM = new ToolShovel(MODID, "tool_shovel_adamantium", MaterialTool.ADAMANTIUM, 1, -1.0f);
    public static final Item TOOL_SHOVEL_MYTHRIL    = new ToolShovel(MODID, "tool_shovel_mythril",    MaterialTool.MYTHRIL,    1, -1.0f);
    public static final Item TOOL_SHOVEL_ORICHALCUM = new ToolShovel(MODID, "tool_shovel_orichalcum", MaterialTool.ORICHALCUM, 1, -1.0f);
    public static final Item TOOL_SHOVEL_COPPER     = new ToolShovel(MODID, "tool_shovel_copper",     MaterialTool.COPPER,     1, -1.0f);
    public static final Item TOOL_SHOVEL_BRONZE     = new ToolShovel(MODID, "tool_shovel_bronze",     MaterialTool.BRONZE,     1, -1.0f);
    public static final Item TOOL_SHOVEL_UNOBTANIUM = new ToolShovel(MODID, "tool_shovel_unobtanium", MaterialTool.UNOBTANIUM, 1, -1.0f);
    public static final Item TOOL_SHOVEL_AURORITE   = new ToolShovel(MODID, "tool_shovel_aurorite",   MaterialTool.AURORITE,   1, -1.0f);

    // Tool Hoe
    public static final Item TOOL_HOE_BRASS      = new ToolHoe(MODID, "tool_hoe_brass",      MaterialTool.BRASS,      -1.0f);
    public static final Item TOOL_HOE_GILIUM     = new ToolHoe(MODID, "tool_hoe_gilium",     MaterialTool.GILIUM,     -1.0f);
    public static final Item TOOL_HOE_ADAMANTIUM = new ToolHoe(MODID, "tool_hoe_adamantium", MaterialTool.ADAMANTIUM, -1.0f);
    public static final Item TOOL_HOE_MYTHRIL    = new ToolHoe(MODID, "tool_hoe_mythril",    MaterialTool.MYTHRIL,    -1.0f);
    public static final Item TOOL_HOE_ORICHALCUM = new ToolHoe(MODID, "tool_hoe_orichalcum", MaterialTool.ORICHALCUM, -1.0f);
    public static final Item TOOL_HOE_COPPER     = new ToolHoe(MODID, "tool_hoe_copper",     MaterialTool.COPPER,     -1.0f);
    public static final Item TOOL_HOE_BRONZE     = new ToolHoe(MODID, "tool_hoe_bronze",     MaterialTool.BRONZE,     -1.0f);
    public static final Item TOOL_HOE_STEEL      = new ToolHoe(MODID, "tool_hoe_steel",      MaterialTool.STEEL,      -1.0f);
    public static final Item TOOL_HOE_AURORITE   = new ToolHoe(MODID, "tool_hoe_aurorite",   MaterialTool.AURORITE,   -1.0f);

    /**Register all stuff, pre is true during preInit and false during Init**/
    static void registerBlocks(){

        // Blocks
        Register.registerBlock(BLOCK_BRASS     , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_GILIUM    , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_ADAMANTIUM, ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_ZINC      , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_MYTHRIL   , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_TIN       , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_ORICHALCUM, ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_COPPER    , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_BRONZE    , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_STEEL     , ItemGroup.BUILDING_BLOCKS);

        // Ore
        Register.registerBlock(ORE_GILIUM    , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_ZINC      , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_MYTHRIL   , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_TIN       , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_COPPER    , ItemGroup.BUILDING_BLOCKS);

        Register.registerBlock(BLOCK_AURORITE, ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_RUBY    , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_SAPPHIRE, ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_AMETHYST, ItemGroup.BUILDING_BLOCKS);

        // Other Blocks
        Register.registerBlock(BLOCK_SALT  , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_SULFUR, ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_FLOUR , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(BLOCK_COFFEE, ItemGroup.BUILDING_BLOCKS);

        Register.registerBlock(ORE_AURORITE, ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_RUBY    , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_SAPPHIRE, ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_AMETHYST, ItemGroup.BUILDING_BLOCKS);

        Register.registerBlock(ORE_SALT  , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(ORE_SULFUR, ItemGroup.BUILDING_BLOCKS);

        Register.registerBlock(CROP_COFFEE      , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(CROP_TURNIP      , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(CROP_CABBAGE     , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(CROP_TOMATO      , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(CROP_CUCUMBER    , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(CROP_CORN        , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(CROP_GRAPES      , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(CROP_HEMP        , ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(CROP_STRAWBERRIES, ItemGroup.BUILDING_BLOCKS);
        Register.registerBlock(CROP_ONION       , ItemGroup.BUILDING_BLOCKS);

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

    static void registerItems(){

        // Nuggets
        Register.registerItem(NUGGET_GILIUM    );
        Register.registerItem(NUGGET_ZINC      );
        Register.registerItem(NUGGET_MYTHRIL   );
        Register.registerItem(NUGGET_TIN       );
        Register.registerItem(NUGGET_COPPER    );

        // Ingots
        Register.registerItem(INGOT_BRASS     );
        Register.registerItem(INGOT_GILIUM    );
        Register.registerItem(INGOT_ADAMANTIUM);
        Register.registerItem(INGOT_ZINC      );
        Register.registerItem(INGOT_MYTHRIL   );
        Register.registerItem(INGOT_TIN       );
        Register.registerItem(INGOT_ORICHALCUM);
        Register.registerItem(INGOT_COPPER    );
        Register.registerItem(INGOT_BRONZE    );
        Register.registerItem(INGOT_STEEL     );

        Register.registerItem(FOOD_COFFEE      );
        Register.registerItem(FOOD_TURNIP      );
        Register.registerItem(FOOD_CABBAGE     );
        Register.registerItem(FOOD_TOMATO      );
        Register.registerItem(FOOD_CUCUMBER    );
        Register.registerItem(FOOD_CORN        );
        Register.registerItem(FOOD_GRAPES      );
        Register.registerItem(FOOD_STRAWBERRIES);
        Register.registerItem(FOOD_ONION       );

        Register.registerItem(SEEDS_WILD        );
        Register.registerItem(SEEDS_COFFEE      );
        Register.registerItem(SEEDS_TURNIP      );
        Register.registerItem(SEEDS_CABBAGE     );
        Register.registerItem(SEEDS_TOMATO      );
        Register.registerItem(SEEDS_CUCUMBER    );
        Register.registerItem(SEEDS_CORN        );
        Register.registerItem(SEEDS_GRAPES      );
        Register.registerItem(SEEDS_HEMP        );
        Register.registerItem(SEEDS_STRAWBERRIES);
        Register.registerItem(SEEDS_ONION       );

        Register.registerItem(FOOD_VENISON_RAW   );
        Register.registerItem(FOOD_VENISON_COOKED);
        Register.registerItem(FOOD_VICUGNA_RAW   );
        Register.registerItem(FOOD_VICUGNA_COOKED);

        Register.registerItem(STUFF_DYNAMITE);

        Register.registerItem(STUFF_ROPE       );
        Register.registerItem(STUFF_HEMP       );
        Register.registerItem(STUFF_GEAR_WOODEN);
        Register.registerItem(STUFF_AURORITE);
        Register.registerItem(STUFF_RUBY    );
        Register.registerItem(STUFF_SAPPHIRE);
        Register.registerItem(STUFF_AMETHYST);
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
        Register.registerItem(ARMOR_BOOTS_GILIUM    );
        Register.registerItem(ARMOR_BOOTS_ADAMANTIUM);
        Register.registerItem(ARMOR_BOOTS_MYTHRIL   );
        Register.registerItem(ARMOR_BOOTS_ORICHALCUM);
        Register.registerItem(ARMOR_BOOTS_COPPER    );
        Register.registerItem(ARMOR_BOOTS_BRONZE    );
        Register.registerItem(ARMOR_BOOTS_STEEL     );
        Register.registerItem(ARMOR_BOOTS_AURORITE  );

        // Armor Chestplate
        Register.registerItem(ARMOR_PLATE_BRASS     );
        Register.registerItem(ARMOR_PLATE_GILIUM    );
        Register.registerItem(ARMOR_PLATE_ADAMANTIUM);
        Register.registerItem(ARMOR_PLATE_MYTHRIL   );
        Register.registerItem(ARMOR_PLATE_ORICHALCUM);
        Register.registerItem(ARMOR_PLATE_COPPER    );
        Register.registerItem(ARMOR_PLATE_BRONZE    );
        Register.registerItem(ARMOR_PLATE_STEEL     );
        Register.registerItem(ARMOR_PLATE_AURORITE  );

        // Armor Leggings
        Register.registerItem(ARMOR_LEGGINGS_BRASS     );
        Register.registerItem(ARMOR_LEGGINGS_GILIUM    );
        Register.registerItem(ARMOR_LEGGINGS_ADAMANTIUM);
        Register.registerItem(ARMOR_LEGGINGS_MYTHRIL   );
        Register.registerItem(ARMOR_LEGGINGS_ORICHALCUM);
        Register.registerItem(ARMOR_LEGGINGS_COPPER    );
        Register.registerItem(ARMOR_LEGGINGS_BRONZE    );
        Register.registerItem(ARMOR_LEGGINGS_STEEL     );
        Register.registerItem(ARMOR_LEGGINGS_AURORITE  );

        // Armor Helmet
        Register.registerItem(ARMOR_HELMET_BRASS     );
        Register.registerItem(ARMOR_HELMET_GILIUM    );
        Register.registerItem(ARMOR_HELMET_ADAMANTIUM);
        Register.registerItem(ARMOR_HELMET_MYTHRIL   );
        Register.registerItem(ARMOR_HELMET_ORICHALCUM);
        Register.registerItem(ARMOR_HELMET_COPPER    );
        Register.registerItem(ARMOR_HELMET_BRONZE    );
        Register.registerItem(ARMOR_HELMET_STEEL     );
        Register.registerItem(ARMOR_HELMET_AURORITE  );

        // Tool Sword
        Register.registerItem(TOOL_SWORD_BRASS     );
        Register.registerItem(TOOL_SWORD_GILIUM    );
        Register.registerItem(TOOL_SWORD_ADAMANTIUM);
        Register.registerItem(TOOL_SWORD_MYTHRIL   );
        Register.registerItem(TOOL_SWORD_ORICHALCUM);
        Register.registerItem(TOOL_SWORD_COPPER    );
        Register.registerItem(TOOL_SWORD_BRONZE    );
        Register.registerItem(TOOL_SWORD_STEEL     );
        Register.registerItem(TOOL_SWORD_AURORITE  );

        // Tool Spear
        Register.registerItem(TOOL_SPEAR_BRASS     );
        Register.registerItem(TOOL_SPEAR_GILIUM    );
        Register.registerItem(TOOL_SPEAR_ADAMANTIUM);
        Register.registerItem(TOOL_SPEAR_MYTHRIL   );
        Register.registerItem(TOOL_SPEAR_ORICHALCUM);
        Register.registerItem(TOOL_SPEAR_COPPER    );
        Register.registerItem(TOOL_SPEAR_BRONZE    );
        Register.registerItem(TOOL_SPEAR_STEEL     );
        Register.registerItem(TOOL_SPEAR_AURORITE  );

        // Tool Axe
        Register.registerItem(TOOL_AXE_BRASS     );
        Register.registerItem(TOOL_AXE_GILIUM    );
        Register.registerItem(TOOL_AXE_ADAMANTIUM);
        Register.registerItem(TOOL_AXE_MYTHRIL   );
        Register.registerItem(TOOL_AXE_ORICHALCUM);
        Register.registerItem(TOOL_AXE_COPPER    );
        Register.registerItem(TOOL_AXE_BRONZE    );
        Register.registerItem(TOOL_AXE_STEEL     );
        Register.registerItem(TOOL_AXE_AURORITE  );

        // Tool Pickaxe
        Register.registerItem(TOOL_PICKAXE_BRASS     );
        Register.registerItem(TOOL_PICKAXE_GILIUM    );
        Register.registerItem(TOOL_PICKAXE_ADAMANTIUM);
        Register.registerItem(TOOL_PICKAXE_MYTHRIL   );
        Register.registerItem(TOOL_PICKAXE_ORICHALCUM);
        Register.registerItem(TOOL_PICKAXE_COPPER    );
        Register.registerItem(TOOL_PICKAXE_BRONZE    );
        Register.registerItem(TOOL_PICKAXE_STEEL     );
        Register.registerItem(TOOL_PICKAXE_AURORITE  );

        // Tool Shovel
        Register.registerItem(TOOL_SHOVEL_BRASS     );
        Register.registerItem(TOOL_SHOVEL_GILIUM    );
        Register.registerItem(TOOL_SHOVEL_ADAMANTIUM);
        Register.registerItem(TOOL_SHOVEL_MYTHRIL   );
        Register.registerItem(TOOL_SHOVEL_ORICHALCUM);
        Register.registerItem(TOOL_SHOVEL_COPPER    );
        Register.registerItem(TOOL_SHOVEL_BRONZE    );
        Register.registerItem(TOOL_SHOVEL_UNOBTANIUM);
        Register.registerItem(TOOL_SHOVEL_AURORITE  );

        // Tool Hoe
        Register.registerItem(TOOL_HOE_BRASS     );
        Register.registerItem(TOOL_HOE_GILIUM    );
        Register.registerItem(TOOL_HOE_ADAMANTIUM);
        Register.registerItem(TOOL_HOE_MYTHRIL   );
        Register.registerItem(TOOL_HOE_ORICHALCUM);
        Register.registerItem(TOOL_HOE_COPPER    );
        Register.registerItem(TOOL_HOE_BRONZE    );
        Register.registerItem(TOOL_HOE_STEEL     );
        Register.registerItem(TOOL_HOE_AURORITE  );
    }

    //@ObjectHolder(ContainerReference.TEMPLATE_MANAGER_CONTAINER)
    public final static ContainerType<ContainerBlastFurnace> TYPE_BLASTFURNACE = IForgeContainerType.create(ContainerBlastFurnace::new);
    public final static ContainerType<ContainerDestille> TYPE_DESTILLE         = IForgeContainerType.create(ContainerDestille::new);

    public static TileEntityType<TileEntity> TYPE_BLASTFURNACE_TILE;
    public static TileEntityType<TileEntity> TYPE_DESTILLE_TILE;

    static List<EntityType> entities = Lists.newArrayList();

    static List<Item> spawnEggs = Lists.newArrayList();

    public static void registerContainer(IForgeRegistry<ContainerType<?>> registry){
        registry.register(TYPE_BLASTFURNACE.setRegistryName(MODID, "blastfurnace"));
        registry.register(TYPE_DESTILLE.setRegistryName(MODID, "destille"));
    }

    static void registerGUI(){
        ScreenManager.registerFactory(TYPE_BLASTFURNACE, GuiBlastFurnace::new);
        ScreenManager.registerFactory(TYPE_DESTILLE, GuiDistille::new);
        //ScreenManager.<TYPE_BLASTFURNACE, GuiBlastFurnace>registerFactory(TYPE_BLASTFURNACE, GuiBlastFurnace::new);
    }



    //public static final IRecipeSerializer<WoodcuttingRecipe> WOODCUTTING = new SingleItemRecipe.Serializer<WoodcuttingRecipe>(WoodcuttingRecipe::new) {};




    public static final EntityType<EntityDynamite> ENTITY_DYNAMITE = createThrowableEntity(EntityDynamite.class, EntityDynamite::new);
    public static final EntityType<EntitySpear>    ENTITY_SPEAR    = createProjectileEntity(EntitySpear.class,    EntitySpear::new);
    public static final EntityType<EntityNugget>   ENTITY_NUGGET   = createThrowableEntity(EntityNugget.class,   EntityNugget::new);

    public static final EntityType<EntityCrab>   ENTITY_CRAB   = createEntity(EntityCrab.class,   EntityCrab::new, 1, 1, 1, 1);

    public static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
        ResourceLocation location = new ResourceLocation(AceCraft.MODID, name);
        EntityType<T> entityType = builder.build(location.toString());
        entityType.setRegistryName(location);
        entities.add(entityType);
        return entityType;
    }


    private static <T extends ThrowableEntity> EntityType<T> createThrowableEntity(Class<T> entityClass, EntityType.IFactory<T> factory) {
        ResourceLocation location = new ResourceLocation(AceCraft.MODID, classToStringT(entityClass));
        EntityType<T> entity = EntityType.Builder.create(factory, EntityClassification.MISC).setTrackingRange(64).setUpdateInterval(1).build(location.toString());
        entity.setRegistryName(location);
        entities.add(entity);
        return entity;
    }

    private static <T extends AbstractArrowEntity> EntityType<T> createProjectileEntity(Class<T> entityClass, EntityType.IFactory<T> factory) {
        ResourceLocation location = new ResourceLocation(AceCraft.MODID, classToStringP(entityClass));
        EntityType<T> entity = EntityType.Builder.create(factory, EntityClassification.MISC).setTrackingRange(64).setUpdateInterval(1).build(location.toString());
        entity.setRegistryName(location);
        entities.add(entity);
        return entity;
    }

    private static String classToStringA(Class<? extends AnimalEntity> entityClass) {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, entityClass.getSimpleName()).replace("entity_", "");
    }

    private static String classToStringT(Class<? extends ThrowableEntity> entityClass) {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, entityClass.getSimpleName()).replace("entity_", "");
    }

    private static String classToStringP(Class<? extends AbstractArrowEntity> entityClass) {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, entityClass.getSimpleName()).replace("entity_", "");
    }

    private static <T extends AnimalEntity> EntityType<T> createEntity(Class<T> entityClass, EntityType.IFactory<T> factory, float width, float height, int eggPrimary, int eggSecondary) {
        ResourceLocation location = new ResourceLocation(AceCraft.MODID, classToStringA(entityClass));
        EntityType<T> entity = EntityType.Builder.create(factory, EntityClassification.CREATURE).size(width, height).setTrackingRange(64).setUpdateInterval(1).build(location.toString());
        entity.setRegistryName(location);
        entities.add(entity);
        Item spawnEgg = new SpawnEggItem(entity, eggPrimary, eggSecondary, (new Item.Properties()).group(ItemGroup.MISC));
        spawnEgg.setRegistryName(new ResourceLocation(AceCraft.MODID, classToStringA(entityClass) + "_spawn_egg"));
        spawnEggs.add(spawnEgg);
        return entity;
    }

    static void registerRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(EntityCrab.class, RenderCrab::new);
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
            biome.getSpawns(EntityClassification.CREATURE).add(new Biome.SpawnListEntry(ENTITY_CRAB, 1, 2, 5));
        }
    }

    static List<SoundEvent> sounds = Lists.newArrayList();
    public static final SoundEvent LLAMA_AMBIENT = createSound("adelie.ambient");
    public static final SoundEvent LLAMA_BABY_AMBIENT = createSound("adelie.baby.ambient");
    public static final SoundEvent LLAMA_DEATH = createSound("adelie.death");
    public static final SoundEvent LLAMA_HURT = createSound("adelie.hurt");

    private static SoundEvent createSound(String name) {
        ResourceLocation resourceLocation = new ResourceLocation(AceCraft.MODID, name);
        SoundEvent sound = new SoundEvent(resourceLocation);
        sound.setRegistryName(resourceLocation);
        sounds.add(sound);
        return sound;
    }

    public static final IRecipeType<RecipeStove> WOODCUTTING = registerRecipeType("woodcutting");

    private static <T extends IRecipe<?>> IRecipeType<T> registerRecipeType(final String key) {
        return Registry.register(Registry.RECIPE_TYPE, new ResourceLocation(MODID, key), new IRecipeType<T>() {
            public String toString() {
                return MODID + ":" + key;
            }
        });
    }




}
