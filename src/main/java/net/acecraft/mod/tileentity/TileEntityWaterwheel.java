package net.acecraft.mod.tileentity;

import net.acecraft.mod.blocks.IMachinaEnergy;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;

public class TileEntityWaterwheel extends ITileEntityEnergy {
	
	public void update(){
    	if(facing == null){
    		facing = worldObj.getBlockState(pos).getValue(IMachinaEnergy.FACING);
    	} else {
    		int e = searchWater();
    		if(e != energy){
    			energy = e;
    			this.markDirty();
    		}
    	}
    	rotation = rotation + energy;
        if(rotation >= 360) rotation -= 360;
    }
	
	private int searchWater(){
		int e = 0;
		if(facing == EnumFacing.NORTH){
			//if(worldObj.getBlockState(pos.add(-2, -2,  0)).getBlock() == Blocks.WATER) e += 0;
			  if(worldObj.getBlockState(pos.add(-1, -2,  0)).getBlock() == Blocks.WATER) e += 15;
			  if(worldObj.getBlockState(pos.add( 0, -2,  0)).getBlock() == Blocks.WATER) e += 35;
			  if(worldObj.getBlockState(pos.add( 1, -2,  0)).getBlock() == Blocks.WATER) e += 15;
			//if(worldObj.getBlockState(pos.add( 2, -2,  0)).getBlock() == Blocks.WATER) e += 0;
			
			  if(worldObj.getBlockState(pos.add( 2, -1,  0)).getBlock() == Blocks.WATER) e += 15;
			  if(worldObj.getBlockState(pos.add( 2,  0,  0)).getBlock() == Blocks.WATER) e += 35;
			  if(worldObj.getBlockState(pos.add( 2,  1,  0)).getBlock() == Blocks.WATER) e += 15;
			//if(worldObj.getBlockState(pos.add( 2,  2,  0)).getBlock() == Blocks.WATER) e += 0;
		}
		if(facing == EnumFacing.SOUTH){
			//if(worldObj.getBlockState(pos.add(-2, -2,  0)).getBlock() == Blocks.WATER) e += 0;
			  if(worldObj.getBlockState(pos.add(-1, -2,  0)).getBlock() == Blocks.WATER) e += 15;
			  if(worldObj.getBlockState(pos.add( 0, -2,  0)).getBlock() == Blocks.WATER) e += 35;
			  if(worldObj.getBlockState(pos.add( 1, -2,  0)).getBlock() == Blocks.WATER) e += 15;
			//if(worldObj.getBlockState(pos.add( 2, -2,  0)).getBlock() == Blocks.WATER) e += 0;
			
			  if(worldObj.getBlockState(pos.add(-2, -1,  0)).getBlock() == Blocks.WATER) e += 15;
			  if(worldObj.getBlockState(pos.add(-2,  0,  0)).getBlock() == Blocks.WATER) e += 35;
			  if(worldObj.getBlockState(pos.add(-2,  1,  0)).getBlock() == Blocks.WATER) e += 15;
			//if(worldObj.getBlockState(pos.add(-2,  2,  0)).getBlock() == Blocks.WATER) e += 0;		
		}
		if(facing == EnumFacing.EAST){
			//if(worldObj.getBlockState(pos.add( 0, -2, -2)).getBlock() == Blocks.WATER) e += 0;
			  if(worldObj.getBlockState(pos.add( 0, -2, -1)).getBlock() == Blocks.WATER) e += 15;
			  if(worldObj.getBlockState(pos.add( 0, -2,  0)).getBlock() == Blocks.WATER) e += 35;
			  if(worldObj.getBlockState(pos.add( 0, -2,  1)).getBlock() == Blocks.WATER) e += 15;
			//if(worldObj.getBlockState(pos.add( 0, -2,  2)).getBlock() == Blocks.WATER) e += 0;
			
			  if(worldObj.getBlockState(pos.add( 0, -1,  2)).getBlock() == Blocks.WATER) e += 15;
			  if(worldObj.getBlockState(pos.add( 0,  0,  2)).getBlock() == Blocks.WATER) e += 35;
			  if(worldObj.getBlockState(pos.add( 0,  1,  2)).getBlock() == Blocks.WATER) e += 15;
			//if(worldObj.getBlockState(pos.add( 0,  2,  2)).getBlock() == Blocks.WATER) e += 0;
		}
		if(facing == EnumFacing.WEST){
			//if(worldObj.getBlockState(pos.add( 0, -2, -2)).getBlock() == Blocks.WATER) e += 0;
			  if(worldObj.getBlockState(pos.add( 0, -2, -1)).getBlock() == Blocks.WATER) e += 15;
			  if(worldObj.getBlockState(pos.add( 0, -2,  0)).getBlock() == Blocks.WATER) e += 35;
			  if(worldObj.getBlockState(pos.add( 0, -2,  1)).getBlock() == Blocks.WATER) e += 15;
			//if(worldObj.getBlockState(pos.add( 0, -2,  2)).getBlock() == Blocks.WATER) e += 0;
			
			  if(worldObj.getBlockState(pos.add( 0, -1, -2)).getBlock() == Blocks.WATER) e += 15;
			  if(worldObj.getBlockState(pos.add( 0,  0, -2)).getBlock() == Blocks.WATER) e += 35;
			  if(worldObj.getBlockState(pos.add( 0,  1, -2)).getBlock() == Blocks.WATER) e += 15;
			//if(worldObj.getBlockState(pos.add( 0,  2, -2)).getBlock() == Blocks.WATER) e += 0;
		}
		return e;
	}
	
}
