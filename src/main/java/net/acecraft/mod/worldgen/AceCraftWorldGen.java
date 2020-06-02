package net.acecraft.mod.worldgen;

import java.util.Random;

import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.structures.StructureCabin;
import net.minecraft.block.Block;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class AceCraftWorldGen implements IWorldGenerator {
	
	private WorldGenerator oregenAdamantium = new AceCraftWorldGenMinable(ShopKeeper.oreAdamantium.getDefaultState(), 6, 1);
	private WorldGenerator oregenAmethyst   = new AceCraftWorldGenMinable(ShopKeeper.oreAmethyst  .getDefaultState(), 1, 0);
	private WorldGenerator oregenAquamarine = new AceCraftWorldGenMinable(ShopKeeper.oreAquamarine.getDefaultState(), 1, 0);
	private WorldGenerator oregenBauxite    = new AceCraftWorldGenMinable(ShopKeeper.oreBauxite   .getDefaultState(), 5, 0);
	private WorldGenerator oregenBeryl      = new AceCraftWorldGenMinable(ShopKeeper.oreBeryl     .getDefaultState(), 1, 0);
	private WorldGenerator oregenCopper     = new AceCraftWorldGenMinable(ShopKeeper.oreCopper    .getDefaultState(), 6, 0);
	private WorldGenerator oregenGagat      = new AceCraftWorldGenMinable(ShopKeeper.oreGagat     .getDefaultState(), 1, 0);
	private WorldGenerator oregenLead       = new AceCraftWorldGenMinable(ShopKeeper.oreLead      .getDefaultState(), 4, 0);
	private WorldGenerator oregenMythril    = new AceCraftWorldGenMinable(ShopKeeper.oreMythril   .getDefaultState(), 3, 0);
	private WorldGenerator oregenOpal       = new AceCraftWorldGenMinable(ShopKeeper.oreOpal      .getDefaultState(), 1, 0);
	private WorldGenerator oregenOrichalcum = new AceCraftWorldGenMinable(ShopKeeper.oreOrichalcum.getDefaultState(), 7, 0);
	private WorldGenerator oregenRuby       = new AceCraftWorldGenMinable(ShopKeeper.oreRuby      .getDefaultState(), 1, 0);
	private WorldGenerator oregenSalt       = new AceCraftWorldGenMinable(ShopKeeper.oreSalt      .getDefaultState(), 8, 0);
	private WorldGenerator oregenSaphire    = new AceCraftWorldGenMinable(ShopKeeper.oreSaphire   .getDefaultState(), 1, 0);
	private WorldGenerator oregenSilver     = new AceCraftWorldGenMinable(ShopKeeper.oreSilver    .getDefaultState(), 5, 0);
	private WorldGenerator oregenSulfur     = new AceCraftWorldGenMinable(ShopKeeper.oreSulfur    .getDefaultState(), 7, 0);
	private WorldGenerator oregenTin        = new AceCraftWorldGenMinable(ShopKeeper.oreTin       .getDefaultState(), 4, 0);
	private WorldGenerator oregenTopaz      = new AceCraftWorldGenMinable(ShopKeeper.oreTopaz     .getDefaultState(), 1, 0);
	private WorldGenerator oregenTourmaline = new AceCraftWorldGenMinable(ShopKeeper.oreTourmaline.getDefaultState(), 1, 0);
	private WorldGenerator oregenUnobtanium = new AceCraftWorldGenMinable(ShopKeeper.oreUnobtanium.getDefaultState(), 3, 2);
	private WorldGenerator oregenZinc       = new AceCraftWorldGenMinable(ShopKeeper.oreZinc      .getDefaultState(), 4, 0);
	
	public AceCraftWorldGen(){
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.getDimension()){
		case 0: // Overworld
			this.runGenerator(oregenCopper,     world, random, chunkX, chunkZ, 20, 58,  95);
			this.runGenerator(oregenBauxite,    world, random, chunkX, chunkZ, 15, 28,  80);
			this.runGenerator(oregenLead,       world, random, chunkX, chunkZ, 20, 40,  80);
			this.runGenerator(oregenTin,        world, random, chunkX, chunkZ,  5, 68, 120);
			this.runGenerator(oregenZinc,       world, random, chunkX, chunkZ,  5,  5,  70);
			this.runGenerator(oregenSilver,     world, random, chunkX, chunkZ, 20, 25,  50);
			this.runGenerator(oregenMythril,    world, random, chunkX, chunkZ, 35,  5,  35);
			if(oreAvailable(world.provider.getBiomeGenForCoords(new BlockPos(chunkX+8, 70, chunkZ+8)), 1))
			this.runGenerator(oregenOrichalcum, world, random, chunkX, chunkZ, 15,  0,  75);
			this.runGenerator(oregenRuby,       world, random, chunkX, chunkZ,  5,  5, 100);
			this.runGenerator(oregenTourmaline, world, random, chunkX, chunkZ,  5,  5, 100);
			this.runGenerator(oregenTopaz,      world, random, chunkX, chunkZ,  5,  5, 100);
			this.runGenerator(oregenSaphire,    world, random, chunkX, chunkZ,  5,  5, 100);
			this.runGenerator(oregenAquamarine, world, random, chunkX, chunkZ,  5,  5, 100);
			this.runGenerator(oregenBeryl,      world, random, chunkX, chunkZ,  5,  5, 100);
			this.runGenerator(oregenAmethyst,   world, random, chunkX, chunkZ,  5,  5, 100);
			this.runGenerator(oregenGagat,      world, random, chunkX, chunkZ,  5,  5, 100);
			this.runGenerator(oregenOpal,       world, random, chunkX, chunkZ,  5,  5, 100);
			this.runGenerator(oregenSalt,       world, random, chunkX, chunkZ, 15, 65, 120);
			this.runGenerator(oregenSulfur,     world, random, chunkX, chunkZ, 10, 38,  60);
			generateOverworld(world, random, chunkX * 16, chunkZ * 16);
			break;
		case -1: // Nether
			this.runGenerator(oregenAdamantium, world, random, chunkX, chunkZ, 100, 0,  35);
			break;
		case 1: // End
			this.runGenerator(oregenUnobtanium, world, random, chunkX, chunkZ, 100, 0, 256);
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
	
	private void generateOverworld(World world, Random rand, int blockX, int blockZ) 
	{
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

		/** CABIN GEN **/
		WorldGenerator genCabin = new StructureCabin();
		// 25% of chunks can have a cabin
		final int CABIN_CHANCE = 0;
		if(rand.nextInt(100) < CABIN_CHANCE)
		{
			// get a random position in the chunk
			int randX = blockX + rand.nextInt(16);
			int randZ = blockZ + rand.nextInt(16);
			// use our custom function to get the ground height
			int groundY = getGroundFromAbove(world, randX, randZ);
			genCabin.generate(world, rand, new BlockPos(randX, groundY + 1, randZ));
		}
		/** END CABIN GEN **/
	}
	
	/** HELPER METHODS **/

	// find a grass or dirt block to place the bush on
	public static int getGroundFromAbove(World world, int x, int z)
	{
		int y = 255;
		boolean foundGround = false;
		while(!foundGround && y-- >= 0)
		{
			Block blockAt = world.getBlockState(new BlockPos(x,y,z)).getBlock();
			// "ground" for our bush is grass or dirt
			foundGround = blockAt == Blocks.dirt || blockAt == Blocks.grass;
		}

		return y;
	}
	
	private boolean oreAvailable(BiomeGenBase biome, int i){
		if(i == 1){ // Orichalcum
			if(biome == Biomes.ocean) return true;
			if(biome == Biomes.deepOcean) return true;
			if(biome == Biomes.frozenOcean) return true;
		}
		return false;
	}
	
}

