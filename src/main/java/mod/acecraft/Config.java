package mod.acecraft;

import mod.lucky77.util.BiomeDictionaryHelper;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.registries.ForgeRegistries;

import static net.minecraftforge.common.BiomeDictionary.Type.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Config {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ConfigOre GILIUM   = new ConfigOre(BUILDER, "gilium",   6, 128, 16);
    public static final ConfigOre ZINC     = new ConfigOre(BUILDER, "zinc",     6,  64,  8);
    public static final ConfigOre MYTHRIL  = new ConfigOre(BUILDER, "mythril",  6,  48, 12);
    public static final ConfigOre TIN      = new ConfigOre(BUILDER, "tin",      6,  64,  8);
    public static final ConfigOre COPPER   = new ConfigOre(BUILDER, "copper",   6, 128, 16);
    public static final ConfigOre AURORITE = new ConfigOre(BUILDER, "aurorite", 2, 128,  4);
    public static final ConfigOre RUBY     = new ConfigOre(BUILDER, "ruby",     2,  64,  4);
    public static final ConfigOre SAPPHIRE = new ConfigOre(BUILDER, "sapphire", 2,  64,  4);
    public static final ConfigOre SALT     = new ConfigOre(BUILDER, "salt",     4,  96, 12);
    public static final ConfigOre SULFUR   = new ConfigOre(BUILDER, "sulfur",   4,  32, 12);
    public static final ConfigMob ALPACA = new ConfigMob(BUILDER, "alpaca", 1, 2, 6);
    public static final ConfigFoundry FOUNDRY = new ConfigFoundry(BUILDER);




    //----------------------------------------CONFIG_ORE----------------------------------------//

    public static class ConfigOre {
        public final ForgeConfigSpec.IntValue veinSize;
        public final ForgeConfigSpec.IntValue maxHeight;
        public final ForgeConfigSpec.IntValue spawnRate;

        ConfigOre(ForgeConfigSpec.Builder builder, String id, int _veinSize, int _maxHeight, int _spawnRate){
            builder.push("oregen " + id);
            builder.comment("This is a Comment for OreGen");
            veinSize  = builder.defineInRange("veinsize",  _veinSize,  0, 128);
            maxHeight = builder.defineInRange("maxheight", _maxHeight, 0, 128);
            spawnRate = builder.defineInRange("spawnrate", _spawnRate, 0, 128);
            builder.pop();
        }
    }




    //----------------------------------------CONFIG_MOB----------------------------------------//

    public static class ConfigMob {
        public final ForgeConfigSpec.IntValue min;
        public final ForgeConfigSpec.IntValue max;
        public final ForgeConfigSpec.IntValue weight;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> include;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> exclude;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> spawnBlocks;

        ConfigMob(ForgeConfigSpec.Builder builder, String id, int _min, int _max, int _weight) {
            builder.push("spawn chances " + id);
            builder.comment("Configure spawn weight & min/max group size. Set weight to 0 to disable.");
            min = builder.defineInRange("min", _min, 0, 64);
            max = builder.defineInRange("max", _max, 0, 64);
            weight = builder.defineInRange("weight", _weight, 0, 100);
            builder.pop();
            builder.push("spawnable biomes " + id);
            spawnBlocks = builder.defineList("spawn blocks", Collections.singletonList(Blocks.GRASS_BLOCK.getRegistryName().toString()), o -> o instanceof String && ForgeRegistries.BLOCKS.getKeys().contains(new ResourceLocation(o.toString())));
            include = builder.defineList("include", Arrays.asList(SAVANNA.toString(), HILLS.toString(), MESA.toString()), o -> o instanceof String && (o.equals("") || BiomeDictionary.Type.getAll().contains(BiomeDictionaryHelper.getType(o.toString()))));
            exclude = builder.defineList("exclude", Arrays.asList(FOREST.toString(), SNOWY.toString(), OCEAN.toString(), NETHER.toString()), o -> o instanceof String && (o.equals("") || BiomeDictionary.Type.getAll().contains(BiomeDictionaryHelper.getType(o.toString()))));
            builder.pop();
        }
    }




    //----------------------------------------CONFIG_MOB----------------------------------------//

    public static class ConfigFoundry {
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> entry;
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> smelt;

        ConfigFoundry(ForgeConfigSpec.Builder builder) {
            builder.push("foundry entries");
            entry = builder.defineList("entry", Arrays.asList(
                    "gold,minecraft:gold_ingot,acecraft:nugget_gold,minecraft:gold_ore",
                    "iron,minecraft:iron_ingot,acecraft:nugget_iron,minecraft:iron_ore",
                    "copper,acecraft:ingot_copper",
                    "tin,acecraft:ingot_tin",
                    "zinc,acecraft:ingot_zinc",
                    "mythril,acecraft:ingot_mythril",
                    "gilium,acecraft:ingot_gilium",
                    "brass,acecraft:ingot_brass",
                    "bronze,acecraft:ingot_bronze",
                    "steel,acecraft:ingot_steel",
                    "adamantium,acecraft:ingot_adamantium",
                    "orichalcum,acecraft:ingot_orichalcum"
            ), o -> o instanceof String);
            smelt = builder.defineList("smelt", Arrays.asList(
                    "brass,80,copper,20,zinc,10",
                    "bronze,80,copper,20,tin,10",
                    "steel,100,iron,0,copper,5",
                    "adamantium,80,gilium,20,tin,10",
                    "orichalcum,80,mythril,20,copper,10"
            ), o -> o instanceof String);
            builder.pop();
        }
    }




    //----------------------------------------BUILDER----------------------------------------//

    public static final ForgeConfigSpec spec = BUILDER.build();

}