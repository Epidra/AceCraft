package mod.acecraft.worldgen;

import mod.acecraft.ShopKeeper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.*;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Random;

public class WorldGen {

    public static void GenerateOre()
    {

        for (Biome biome : ForgeRegistries.BIOMES) {

            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ShopKeeper.ORE_COPPER.getDefaultState(), 7), Placement.COUNT_RANGE, new CountRangeConfig(10, 0, 0, 128)));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ShopKeeper.ORE_MYTHRIL.getDefaultState(), 7), Placement.COUNT_RANGE, new CountRangeConfig(10, 0, 0, 32)));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ShopKeeper.ORE_TIN.getDefaultState(), 5), Placement.COUNT_RANGE, new CountRangeConfig(10, 0, 0, 64)));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ShopKeeper.ORE_ZINC.getDefaultState(), 5), Placement.COUNT_RANGE, new CountRangeConfig(10, 0, 0, 64)));
            //biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ShopKeeper.ORE_SILVER.getDefaultState(), 5), Placement.COUNT_RANGE, new CountRangeConfig(10, 0, 0, 64)));

            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ShopKeeper.ORE_AURORITE.getDefaultState(), 3), Placement.COUNT_RANGE, new CountRangeConfig(4, 0, 0, 64)));
            //biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ShopKeeper.ORE_CITRINE.getDefaultState(), 4), Placement.COUNT_RANGE, new CountRangeConfig(4, 0, 0, 64)));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ShopKeeper.ORE_RUBY.getDefaultState(), 4), Placement.COUNT_RANGE, new CountRangeConfig(4, 0, 0, 64)));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ShopKeeper.ORE_SAPPHIRE.getDefaultState(), 4), Placement.COUNT_RANGE, new CountRangeConfig(4, 0, 0, 64)));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ShopKeeper.ORE_AMETHYST.getDefaultState(), 4), Placement.COUNT_RANGE, new CountRangeConfig(4, 0, 0, 64)));

            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ShopKeeper.ORE_SALT.getDefaultState(), 8), Placement.COUNT_RANGE, new CountRangeConfig(10, 0, 0, 96)));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ShopKeeper.ORE_SULFUR.getDefaultState(), 8), Placement.COUNT_RANGE, new CountRangeConfig(8, 0, 0, 64)));

            biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(ShopKeeper.FLOWER_MATSUTAKE.getDefaultState()), Placement.COUNT_CHANCE_HEIGHTMAP, new HeightWithChanceConfig(2, 0.005F)));
            biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(ShopKeeper.FLOWER_BAMBOO.getDefaultState()), Placement.COUNT_CHANCE_HEIGHTMAP, new HeightWithChanceConfig(2, 0.005F)));

            biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(ShopKeeper.FLOWER_MOONDROP.getDefaultState()), Placement.COUNT_CHANCE_HEIGHTMAP, new HeightWithChanceConfig(3, 0.005F)));
            biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(ShopKeeper.FLOWER_MAGICGRASS.getDefaultState()), Placement.COUNT_CHANCE_HEIGHTMAP, new HeightWithChanceConfig(3, 0.005F)));
            biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(ShopKeeper.FLOWER_TOYFLOWER.getDefaultState()), Placement.COUNT_CHANCE_HEIGHTMAP, new HeightWithChanceConfig(3, 0.005F)));
            biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Biome.createDecoratedFeature(Feature.BUSH, new BushConfig(ShopKeeper.FLOWER_PINKCAT.getDefaultState()), Placement.COUNT_CHANCE_HEIGHTMAP, new HeightWithChanceConfig(3, 0.005F)));
        }


    }

    public static void GenerateNetherOre()
    {
        Biomes.NETHER.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, ShopKeeper.ORE_GILIUM.getDefaultState(), 9), Placement.COUNT_RANGE, new CountRangeConfig(10, 0, 0, 128)));
        //Biomes.NETHER.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, ShopKeeper.ORE_NIVIDIUM.getDefaultState(), 7), Placement.COUNT_RANGE, new CountRangeConfig(10, 0, 0, 64)));
        //Biomes.NETHER.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, ShopKeeper.ORE_CLAVIUM.getDefaultState(), 7), Placement.COUNT_RANGE, new CountRangeConfig(10, 0, 0, 64)));
    }

}
