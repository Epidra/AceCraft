package mod.acecraft.worldgen;

import java.util.Random;

import mod.acecraft.ShopKeeper;
import net.minecraft.block.Block;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGen implements IWorldGenerator {
	
	private WorldGenerator oregenGilium   = new WorldGenMinable(ShopKeeper.ORE_GILIUM  .getDefaultState(), 6, 1);
	private WorldGenerator oregenMythril  = new WorldGenMinable(ShopKeeper.ORE_MYTHRIL .getDefaultState(), 6, 0);
	private WorldGenerator oregenClavium  = new WorldGenMinable(ShopKeeper.ORE_CLAVIUM .getDefaultState(), 3, 1);
	private WorldGenerator oregenZinc     = new WorldGenMinable(ShopKeeper.ORE_ZINC    .getDefaultState(), 3, 0);
	private WorldGenerator oregenTin      = new WorldGenMinable(ShopKeeper.ORE_TIN     .getDefaultState(), 3, 0);
	private WorldGenerator oregenCopper   = new WorldGenMinable(ShopKeeper.ORE_COPPER  .getDefaultState(), 6, 0);
	private WorldGenerator oregenSilver   = new WorldGenMinable(ShopKeeper.ORE_SILVER  .getDefaultState(), 3, 0);
	private WorldGenerator oregenNividium = new WorldGenMinable(ShopKeeper.ORE_NIVIDIUM.getDefaultState(), 4, 1);
	private WorldGenerator oregenSalt     = new WorldGenMinable(ShopKeeper.ORE_SALT    .getDefaultState(), 5, 0);
	private WorldGenerator oregenSulfur   = new WorldGenMinable(ShopKeeper.ORE_SULFUR  .getDefaultState(), 5, 0);
	private WorldGenerator oregenAurorite = new WorldGenMinable(ShopKeeper.ORE_AURORITE.getDefaultState(), 1, 0);
	
	public WorldGen(){
		
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		Biome currentBiome = world.provider.getBiomeForCoords(new BlockPos(chunkX, 70, chunkZ));
		switch(world.provider.getDimension()){
		case 0: // Overworld
			this.runGenerator(oregenMythril,  world, random, chunkX, chunkZ, 15,  0,  30);
			this.runGenerator(oregenZinc,     world, random, chunkX, chunkZ,  5,  0,  75);
			this.runGenerator(oregenTin,      world, random, chunkX, chunkZ,  5, 75, 150);
			this.runGenerator(oregenCopper,   world, random, chunkX, chunkZ, 20, 85, 150);
			this.runGenerator(oregenSilver,   world, random, chunkX, chunkZ, 15, 50,  65);
			this.runGenerator(oregenSalt,     world, random, chunkX, chunkZ, 25, 65,  70);
			this.runGenerator(oregenSulfur,   world, random, chunkX, chunkZ, 25, 15,  25);
			this.runGenerator(oregenAurorite, world, random, chunkX, chunkZ,  5,  0, 150);
			generateOverworldStructures(world, random, chunkX * 16, chunkZ * 16);
			break;
		case -1: // Nether
			this.runGenerator(oregenGilium,   world, random, chunkX, chunkZ, 15,  0, 80);
			this.runGenerator(oregenClavium,  world, random, chunkX, chunkZ,  5, 45, 80);
			this.runGenerator(oregenNividium, world, random, chunkX, chunkZ,  5,  0, 45);
			break;
		case 1: // End
			//this.runGenerator(oregenUnobtanium, world, random, chunkX, chunkZ, 100, 0, 256);
			break;
		}
	}
	
	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunkX, int chunkZ, int chancetospawn, int minHeight, int maxHeight){
		if(minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Minimum or Maximum Height out of bounds");
		int heightDiff = maxHeight - minHeight + 1;
		for(int i = 0; i < chancetospawn; i++){
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}
	
	private void generateOverworldStructures(World world, Random rand, int blockX, int blockZ){
		 //get a random position in the chunk
		int randX = blockX + rand.nextInt(16);
		int randZ = blockZ + rand.nextInt(16);
		
		/** COOKIE BUSH GEN **/
		// make a world generator to use
		//WorldGenerator genCookieBushes = new WorldGenCookieBushes();
		// get the biome. I used 64 for Y, but you can use anything between 0 and 255
		//BiomeGenBase biome = world.getBiomeGenForCoords(new BlockPos(blockX, 64, blockZ));
		// check that it's a Plains biome
		// we could also use: if(biome instanceof BiomeGenPlains)
		//if(biome == Biomes.plains)
		//{
			// how many we want to make per chunk
			// let's make it random between MIN and MAX
			//int MIN = 4;
			//int MAX = 12;
			//int numBushes = MIN + rand.nextInt(MAX - MIN);
			// now let's generate the bushes
			//for(int i = 0; i < numBushes; i++)
			//{
				// get a random position in the chunk
				//int randX = blockX + rand.nextInt(16);
				//int randZ = blockZ + rand.nextInt(16);
				// the y-value we pass here will be used as minimum spawn height
				//genCookieBushes.generate(world, rand, new BlockPos(randX, 24, randZ));
			//}
		//}
		///** END COOKIE BUSH GEN **/

		/** METEOR GEN **/
		//StructureMeteor genCabin = new StructureMeteor();
		//int gen = SpawnBiomeMeteor(world.provider.getBiomeForCoords(new BlockPos(blockX+8, 70, blockZ+8)));
		//if(rand.nextInt(500/gen) == 0){
			 //use our custom function to get the ground height
		//	int groundY = getGroundFromAbove(world, randX, randZ);
		//	genCabin.generate(world, rand, new BlockPos(randX, groundY + 1, randZ), gen);
		//	return;
		//}
		/** END METEOR GEN **/
	}
	
	/** HELPER METHODS **/

	// find a grass or dirt block to place the bush on
	public static int getGroundFromAbove(World world, int x, int z){
		int y = 255;
		boolean foundGround = false;
		while(!foundGround && y-- >= 0){
			Block blockAt = world.getBlockState(new BlockPos(x,y,z)).getBlock();
			// "ground" for our bush is grass or dirt
			foundGround = blockAt == Blocks.DIRT || blockAt == Blocks.GRASS || blockAt == Blocks.SAND || blockAt == Blocks.GRAVEL;
		}
		return y;
	}
	
	private boolean oreAvailable(Biome biome, int id){
		if(id == 1){ // Orichalcum
			if(biome == Biomes.OCEAN) return true;
			if(biome == Biomes.DEEP_OCEAN) return true;
			if(biome == Biomes.FROZEN_OCEAN) return true;
		}
		if(id == 2){ // Tin
			if(biome.getDefaultTemperature() < 0.5) return true;
		}
		if(id == 3){ // Zinc
            return biome.getDefaultTemperature() > 0.5;
		}
		return false;
	}
	
	private int SpawnBiomeMeteor(Biome biome){
		if(biome == Biomes.OCEAN || biome == Biomes.DEEP_OCEAN || biome == Biomes.FROZEN_OCEAN) return 4; // Oceans: Maximum Size
		if(biome == Biomes.DESERT || biome == Biomes.DESERT_HILLS || biome == Biomes.SAVANNA || biome == Biomes.SAVANNA_PLATEAU || biome == Biomes.MESA || biome == Biomes.MESA_ROCK) return 3; // Deserts: Up to Greater Size
		if(biome == Biomes.COLD_TAIGA || biome == Biomes.TAIGA_HILLS || biome == Biomes.COLD_TAIGA || biome == Biomes.COLD_TAIGA_HILLS || biome == Biomes.ICE_PLAINS || biome == Biomes.ICE_MOUNTAINS) return 2; // Taigas: Up to Medium Size
		return 1; // Default: Everything else, only small Size
	}
	
}
