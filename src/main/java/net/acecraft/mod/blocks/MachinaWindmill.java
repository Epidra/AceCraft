package net.acecraft.mod.blocks;

import java.util.Random;

import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.tileentity.ITileEntityEnergy;
import net.acecraft.mod.tileentity.TileEntityWindmill;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class MachinaWindmill extends IMachinaEnergy {
	
	public static final AxisAlignedBB AABB_SN = new AxisAlignedBB(-3.0D, -3.0D,  0.0D, 4.0D, 4.0D, 1.0D);
	public static final AxisAlignedBB AABB_EW = new AxisAlignedBB( 0.0D, -3.0D, -3.0D, 1.0D, 4.0D, 4.0D);
	
	public MachinaWindmill(String name) {
		super(name, Material.WOOD);
	}
	
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
		EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
		if(enumfacing == EnumFacing.NORTH || enumfacing == EnumFacing.SOUTH) return AABB_SN;
		if(enumfacing == EnumFacing.EAST  || enumfacing == EnumFacing.WEST ) return AABB_EW;
        return FULL_BLOCK_AABB;
    }
	
	public TileEntity createNewTileEntity(World worldIn, int meta){
        return new TileEntityWindmill();
    }
	
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
	         if(hasNeighbour(world, pos.south())){ if(EnumFacing.SOUTH == world.getBlockState(pos.south()).getValue(FACING)){ world.setBlockState(pos, state.withProperty(FACING, EnumFacing.SOUTH), 2); } else { world.destroyBlock(pos, true); } }
		else if(hasNeighbour(world, pos.north())){ if(EnumFacing.NORTH == world.getBlockState(pos.north()).getValue(FACING)){ world.setBlockState(pos, state.withProperty(FACING, EnumFacing.NORTH), 2); } else { world.destroyBlock(pos, true); } }
		else if(hasNeighbour(world, pos.west ())){ if(EnumFacing.WEST  == world.getBlockState(pos.west ()).getValue(FACING)){ world.setBlockState(pos, state.withProperty(FACING, EnumFacing.WEST ), 2); } else { world.destroyBlock(pos, true); } }
		else if(hasNeighbour(world, pos.east ())){ if(EnumFacing.EAST  == world.getBlockState(pos.east ()).getValue(FACING)){ world.setBlockState(pos, state.withProperty(FACING, EnumFacing.EAST ), 2); } else { world.destroyBlock(pos, true); } }
		else world.destroyBlock(pos, true);
    }
	
	private boolean hasNeighbour(World world, BlockPos pos){
		if(world.getBlockState(pos).getBlock() == ShopKeeper.machinaGearBox){
			return true;
		}
		return false;
	}
	
}
