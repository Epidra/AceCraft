package mod.acecraft.blocks;

import mod.acecraft.ShopKeeper;
import mod.acecraft.tileentities.TileEntityAxle;
import mod.shared.blocks.IMachinaEnergy;
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

public class MachinaAxle extends IMachinaEnergy {
	
	public static final AxisAlignedBB AABB_SN = new AxisAlignedBB(0.3D, 0.3D, 0.0D, 0.7D, 0.7D, 1.0D);
	public static final AxisAlignedBB AABB_UD = new AxisAlignedBB(0.3D, 0.0D, 0.3D, 0.7D, 1.0D, 0.7D);
	public static final AxisAlignedBB AABB_EW = new AxisAlignedBB(0.0D, 0.3D, 0.3D, 1.0D, 0.7D, 0.7D);
	
	public MachinaAxle(String name) {
		super(name, Material.WOOD);
	}
	
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
		EnumFacing enumfacing = state.getValue(FACING);
		if(enumfacing == EnumFacing.NORTH || enumfacing == EnumFacing.SOUTH) return AABB_SN;
		if(enumfacing == EnumFacing.EAST  || enumfacing == EnumFacing.WEST ) return AABB_EW;
		if(enumfacing == EnumFacing.UP    || enumfacing == EnumFacing.DOWN ) return AABB_UD;
        return FULL_BLOCK_AABB;
    }
	
	public TileEntity createNewTileEntity(World worldIn, int meta){
        return new TileEntityAxle();
    }
	
	public boolean hasTileEntity(IBlockState state){
		return true;
	}
	
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
		EnumFacing enumfacing = EnumFacing.DOWN;
		if(hasNeighbour(worldIn, pos.north())){
			enumfacing = getNeighbourState(worldIn.getBlockState(pos.north()), EnumFacing.NORTH);
			worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
		} else if(hasNeighbour(worldIn, pos.south())){
			enumfacing = getNeighbourState(worldIn.getBlockState(pos.south()), EnumFacing.SOUTH);
			worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
		} else if(hasNeighbour(worldIn, pos.east())){
			enumfacing = getNeighbourState(worldIn.getBlockState(pos.east()), EnumFacing.EAST);
			worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
		} else if(hasNeighbour(worldIn, pos.west())){
			enumfacing = getNeighbourState(worldIn.getBlockState(pos.west()), EnumFacing.WEST);
			worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
		} else if(hasNeighbour(worldIn, pos.up())){
			enumfacing = getNeighbourState(worldIn.getBlockState(pos.up()), EnumFacing.UP);
			worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
		} else if(hasNeighbour(worldIn, pos.down())){
			enumfacing = getNeighbourState(worldIn.getBlockState(pos.down()), EnumFacing.DOWN);
			worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
		} else {
			worldIn.destroyBlock(pos, true);
		}
    }
	
	private boolean hasNeighbour(World world, BlockPos pos){
		if(world.getBlockState(pos).getBlock() == ShopKeeper.MACHINA_GEARBOX){
			return true;
		}
        return world.getBlockState(pos).getBlock() == ShopKeeper.MACHINA_AXLE;
    }
	
	private EnumFacing getNeighbourState(IBlockState blockstate, EnumFacing direction){
		if(blockstate.getBlock().getMetaFromState(blockstate) == direction.getIndex()){
			return direction;
		} else{
			return direction.getOpposite();
		}
	}
	
}
