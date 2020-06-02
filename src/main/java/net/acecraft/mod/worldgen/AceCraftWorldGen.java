package net.acecraft.mod.worldgen;

import java.util.Random;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.worldgen.ore.WorldGenEndMinable;
import net.acecraft.mod.worldgen.ore.WorldGenNetherMinable;
import net.acecraft.mod.worldgen.tree.WorldGenBananaTree;
import net.acecraft.mod.worldgen.tree.WorldGenCherryTree;
import net.acecraft.mod.worldgen.tree.WorldGenCoconutTree;
import net.acecraft.mod.worldgen.tree.WorldGenLemonTree;
import net.acecraft.mod.worldgen.tree.WorldGenOrangeTree;
import net.acecraft.mod.worldgen.tree.WorldGenPeachTree;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class AceCraftWorldGen implements IWorldGenerator {
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider){
		switch(world.provider.dimensionId){
		case  0: generateSurface(world, random, chunkX*16, chunkZ*16); break;
		case -1: generateNether (world, random, chunkX*16, chunkZ*16); break;
		case  1: generateEnd    (world, random, chunkX*16, chunkZ*16); break;
		}
	}
	
	private void generateSurface(World world, Random random, int chunkX, int chunkZ){
		BiomeGenBase biome = world.getBiomeGenForCoords(chunkX+8, chunkZ+8); 
		if(biome == BiomeGenBase.extremeHills || biome == BiomeGenBase.extremeHillsEdge || biome == BiomeGenBase.extremeHillsEdge || biome == BiomeGenBase.river){
			int X = chunkX + random.nextInt(16);
			int Z = chunkZ + random.nextInt(10);
			int Y = random.nextInt(20);
			(new WorldGenCherryTree(ShopKeeper.aceLog, ShopKeeper.leavesCherryEmpty, false, 5, 3, false)).generate(world, random, X+(chunkX), Y+100, Z+(chunkZ));
		}
		if(biome == BiomeGenBase.plains || biome == BiomeGenBase.birchForestHills || biome == BiomeGenBase.river || biome == BiomeGenBase.stoneBeach){
			int X = chunkX + random.nextInt(16);
			int Z = chunkZ + random.nextInt(10);
			int Y = random.nextInt(40);
			(new WorldGenLemonTree(ShopKeeper.aceLog, ShopKeeper.leavesLemonEmpty, false, 5, 3, false)).generate(world, random, X+(chunkX), Y+70, Z+(chunkZ));
		}
		if(biome == BiomeGenBase.plains || biome == BiomeGenBase.forest || biome == BiomeGenBase.forestHills || biome == BiomeGenBase.birchForest || biome == BiomeGenBase.roofedForest){
			int X = chunkX + random.nextInt(16);
			int Z = chunkZ + random.nextInt(10);
			int Y = random.nextInt(30);				   
			(new WorldGenOrangeTree(ShopKeeper.aceLog, ShopKeeper.leavesOrangeEmpty, false, 5, 3, false)).generate(world, random, X+(chunkX), Y+80, Z+(chunkZ));
		}
		if(biome == BiomeGenBase.taiga || biome == BiomeGenBase.taigaHills || biome == BiomeGenBase.birchForest || biome == BiomeGenBase.coldBeach || biome == BiomeGenBase.coldTaiga || biome == BiomeGenBase.coldTaigaHills){
			int X = chunkX + random.nextInt(16);
			int Z = chunkZ + random.nextInt(10);
			int Y = random.nextInt(20);   
			(new WorldGenPeachTree(ShopKeeper.aceLog, ShopKeeper.leavesPeachEmpty, false, 5, 3, false)).generate(world, random, X+(chunkX), Y+90, Z+(chunkZ));
		}
		if(biome == BiomeGenBase.beach){
			int X = chunkX + random.nextInt(16);
			int Z = chunkZ + random.nextInt(10);
			int Y = random.nextInt(10);   
			(new WorldGenCoconutTree(ShopKeeper.aceLog, ShopKeeper.leavesPalmTree, false, 5, 3, false)).generate(world, random, X+(chunkX), Y+60, Z+(chunkZ));
		}
		if(biome == BiomeGenBase.beach){
			int X = chunkX + random.nextInt(16);
			int Z = chunkZ + random.nextInt(10);
			int Y = random.nextInt(10);   
			(new WorldGenCoconutTree(ShopKeeper.aceLog, ShopKeeper.leavesPalmTree, false, 5, 3, false)).generate(world, random, X+(chunkX), Y+60, Z+(chunkZ));
		}
		if(biome == BiomeGenBase.jungle || biome == BiomeGenBase.jungleEdge || biome == BiomeGenBase.jungleHills){
			int X = chunkX + random.nextInt(16);
			int Z = chunkZ + random.nextInt(10);
			int Y = random.nextInt(10);   
			(new WorldGenBananaTree(ShopKeeper.aceLog, ShopKeeper.leavesPalmTree, false, 5, 3, false)).generate(world, random, X+(chunkX), Y+60, Z+(chunkZ));
		}
		this.addOreSpawn(ShopKeeper.oreSalt,      world, random, chunkX, chunkZ, 16, 16, 4+random.nextInt(4), 15, 50, 120);
		this.addOreSpawn(ShopKeeper.oreSulfur,    world, random, chunkX, chunkZ, 16, 16, 2+random.nextInt(3), 10, 38,  60);
		this.addOreSpawn(ShopKeeper.oreCopper,    world, random, chunkX, chunkZ, 16, 16, 2+random.nextInt(4), 20, 58,  95);
		this.addOreSpawn(ShopKeeper.oreBauxite,   world, random, chunkX, chunkZ, 16, 16, 3+random.nextInt(3), 15, 28,  80);
		this.addOreSpawn(ShopKeeper.oreLead,      world, random, chunkX, chunkZ, 16, 16, 3+random.nextInt(4), 20, 40,  80);
		this.addOreSpawn(ShopKeeper.oreTin,       world, random, chunkX, chunkZ, 16, 16, 3+random.nextInt(2),  5, 68, 120);
		this.addOreSpawn(ShopKeeper.oreZinc,      world, random, chunkX, chunkZ, 16, 16, 3+random.nextInt(1),  5,  5,  70);
		this.addOreSpawn(ShopKeeper.oreSilver,    world, random, chunkX, chunkZ, 16, 16, 3+random.nextInt(2), 20, 25,  50);
		this.addOreSpawn(ShopKeeper.oreMythril,   world, random, chunkX, chunkZ, 16, 16, 2+random.nextInt(4), 30,  5,  35);
		this.addOreSpawn(ShopKeeper.oreRuby,      world, random, chunkX, chunkZ,  4,  4, 1+random.nextInt(2),  5,  5, 100);
		this.addOreSpawn(ShopKeeper.orePeridot,   world, random, chunkX, chunkZ,  4,  4, 1+random.nextInt(2),  5,  5, 100);
		this.addOreSpawn(ShopKeeper.oreTopaz,     world, random, chunkX, chunkZ,  4,  4, 1+random.nextInt(2),  5,  5, 100);
		this.addOreSpawn(ShopKeeper.oreSaphire,   world, random, chunkX, chunkZ,  4,  4, 1+random.nextInt(2),  5,  5, 100);
		this.addOreSpawn(ShopKeeper.oreAzurit,    world, random, chunkX, chunkZ,  4,  4, 1+random.nextInt(2),  5,  5, 100);
		this.addOreSpawn(ShopKeeper.oreAmber,     world, random, chunkX, chunkZ,  4,  4, 1+random.nextInt(2),  5,  5, 100);
		this.addOreSpawn(ShopKeeper.oreAmethyst,  world, random, chunkX, chunkZ,  4,  4, 1+random.nextInt(2),  5,  5, 100);
		this.addOreSpawn(Blocks.emerald_ore,      world, random, chunkX, chunkZ,  4,  4, 1+random.nextInt(2),  5,  5, 100);
		this.addOreSpawn(Blocks.diamond_ore,      world, random, chunkX, chunkZ,  4,  4, 1+random.nextInt(2),  5,  5, 100);
		this.addOreSpawn(ShopKeeper.oreGagat,     world, random, chunkX, chunkZ,  4,  4, 1+random.nextInt(2),  5,  5, 100);
		this.addOreSpawn(ShopKeeper.oreOpal,      world, random, chunkX, chunkZ,  4,  4, 1+random.nextInt(2),  5,  5, 100);
		this.addOreSpawn(ShopKeeper.oreJade,      world, random, chunkX, chunkZ,  4,  4, 1+random.nextInt(2),  5,  5, 100);
		this.addOreSpawn(ShopKeeper.oreTurquoise, world, random, chunkX, chunkZ,  4,  4, 1+random.nextInt(2),  5,  5, 100);
		
		if(biome == BiomeGenBase.ocean || biome == BiomeGenBase.frozenOcean){
			this.addOreSpawn(ShopKeeper.oreOrichalcum, world, random, chunkX, chunkZ, 16, 16, 4+random.nextInt(6), 5, 0, 100);
		}
	}
	
	private void generateNether(World world, Random random, int i, int j){
		this.addNetherOreSpawn(ShopKeeper.oreAdamantium, world, random, i, j, 16, 16, 3+random.nextInt(3), 20, 36, 98);
	}
	
	private void generateEnd(World world, Random random, int i, int j){
		this.addEndOreSpawn(ShopKeeper.oreUnobtanium, world, random, i, j, 16, 16, 1+random.nextInt(1), 50, 5, 100);
	}
	
	private void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY){
		for(int i = 0; i < chanceToSpawn; i++){
			int posX = blockXPos + random.nextInt(maxX);
			int posZ = blockZPos + random.nextInt(maxZ);
			int posY = minY + random.nextInt(maxY - minY);
			(new WorldGenMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
		}
	}
	
	private void addNetherOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY){
		for(int i = 0; i < chanceToSpawn; i++){
			int posX = blockXPos + random.nextInt(maxX);
			int posZ = blockZPos + random.nextInt(maxZ);
			int posY = minY + random.nextInt(maxY - minY);
			(new WorldGenNetherMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
		}
	}
	
	private void addEndOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY){
		for(int i = 0; i < chanceToSpawn; i++){
			int posX = blockXPos + random.nextInt(maxX);
			int posZ = blockZPos + random.nextInt(maxZ);
			int posY = minY + random.nextInt(maxY - minY);
			(new WorldGenEndMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
		}
	}
	
}
