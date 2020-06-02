package net.acecraft.mod.structures;

import java.util.Random;

import net.acecraft.mod.ShopKeeper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class StructureMeteor extends WorldGenerator {
	
	IBlockState blockMeteor  = ShopKeeper.blockMeteor.getDefaultState();
	IBlockState blockIridium = ShopKeeper.oreIridium .getDefaultState();
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos corner){
		generate(worldIn, rand, corner, 0);
		return false;
	}
	
	public boolean generate(World world, Random rand, BlockPos corner, int gen){
		//if(canSpawnHere(world, corner)){
			
			int id = rand.nextInt(gen);
			if(id == 0){ // Small
				int r = rand.nextInt(3);
				buildLayer(world, corner, 1, -1-r, 1, rand);
				buildLayer(world, corner, 3,  0-r, 1, rand);
				buildLayer(world, corner, 1,  1-r, 1, rand);
			}
			if(id == 1){ // Medium
				int r = rand.nextInt(3);
				buildLayer(world, corner, 3, -2-r, 3, rand);
				buildLayer(world, corner, 5, -1-r, 3, rand);
				buildLayer(world, corner, 5,  0-r, 3, rand);
				buildLayer(world, corner, 5,  1-r, 3, rand);
				buildLayer(world, corner, 3,  2-r, 3, rand);
			}
			if(id == 2){ // Big
				int r = rand.nextInt(7);
				buildLayer(world, corner, 3, -3-r, 3, rand);
				buildLayer(world, corner, 5, -2-r, 3, rand);
				buildLayer(world, corner, 7, -1-r, 3, rand);
				buildLayer(world, corner, 7,  0-r, 3, rand);
				buildLayer(world, corner, 7,  1-r, 3, rand);
				buildLayer(world, corner, 5,  2-r, 3, rand);
				buildLayer(world, corner, 3,  3-r, 3, rand);
			}
			if(id == 3){ // Maximum
				int r = rand.nextInt(4);
				buildLayer(world, corner, 5, -4-r, 5, rand);
				buildLayer(world, corner, 5, -3-r, 5, rand);
				buildLayer(world, corner, 7, -2-r, 5, rand);
				buildLayer(world, corner, 9, -1-r, 5, rand);
				buildLayer(world, corner, 9,  0-r, 5, rand);
				buildLayer(world, corner, 9,  1-r, 5, rand);
				buildLayer(world, corner, 7,  2-r, 5, rand);
				buildLayer(world, corner, 5,  3-r, 5, rand);
				buildLayer(world, corner, 5,  4-r, 5, rand);
			}
			
			// debug:
			System.out.println("A Meteor crashed at " + corner + "!");
			return true;
		//} else System.out.println("Meteor couldn't land at " + corner);
		//return false;
	}
	
	private void buildLayer(World world, BlockPos frontLeftCorner, int size, int y, int minsize, Random rand){
		for(int x = 0; x < size; x++){
			for(int z = 0; z < size; z++){
				if(!IsEdge(x, z, size-1))
					world.setBlockState(frontLeftCorner.add(x + (minsize-size)/2, y, z + (minsize-size)/2), GetBlock(rand), 2);
			}
		}
	}

	private boolean canSpawnHere(World world, BlockPos posAboveGround){
		// check all the corners to see which ones are replaceable
		boolean corner1Air = canReplace(world, posAboveGround             );
		boolean corner2Air = canReplace(world, posAboveGround.add(4, 0, 0));
		boolean corner4Air = canReplace(world, posAboveGround.add(0, 0, 4));
		boolean corner3Air = canReplace(world, posAboveGround.add(4, 0, 4));
		// if Y > 20 and all corners pass the test, it's okay to spawn the structure
		return posAboveGround.getY() > 20 && corner1Air && corner2Air && corner3Air && corner4Air;
	}
	
	private boolean canReplace(World world, BlockPos pos){
		Block at = world.getBlockState(pos).getBlock();
		Material material = at.getMaterial(at.getDefaultState());
		// we think it's replaceable if it's air / liquid / snow, plants, or leaves 
		return material.isReplaceable() || material == Material.PLANTS || material == Material.LEAVES;
	}
	
	private IBlockState GetBlock(Random rand){
		if(rand.nextInt(25) == 0)
			return blockIridium;
		return blockMeteor;
	}
	
	private boolean IsEdge(int x, int z, int edge){
		if(edge == 0) return false;
		if(x ==    0 && z ==    0) return true;
		if(x ==    0 && z == edge) return true;
		if(x == edge && z ==    0) return true;
		if(x == edge && z == edge) return true;
		return false;
	}
	
}
