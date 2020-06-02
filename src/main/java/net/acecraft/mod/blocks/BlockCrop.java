package net.acecraft.mod.blocks;

import java.util.Random;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class BlockCrop extends BlockCrops {
	
	Item seed;
	Item crop;
	int maxAge;
	
	public BlockCrop(String name, Item _crop, int _maxAge) {
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		crop = _crop;
		maxAge = _maxAge-1;
	}
	
	public int getMaxAge(){
        return maxAge;
    }
	
	public Item getSeed(){
		return seed;
	}
	
	public Item getCrop(){
		return crop;
	}
	
	public void setSeed(Item _seed){
		seed = _seed;
	}
	
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand){
        super.updateTick(worldIn, pos, state, rand);
        if (worldIn.getLightFromNeighbors(pos.up()) >= 9){
            int i = this.getAge(state);
            if (i < this.getMaxAge()){
                float f = getGrowthChance(this, worldIn, pos);
                if (rand.nextInt((int)(50.0F / f) + 1) == 0){
                    worldIn.setBlockState(pos, this.withAge(i + 1), 2);
                }
            }
        }
    }
	
}
