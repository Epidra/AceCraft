package mod.acecraft.blocks;

public class MachinaWaterwheel {

}

//public class MachinaWaterwheel extends IMachinaEnergy {
//
//    public static final AxisAlignedBB AABB_SN = new AxisAlignedBB(-1.0D, -1.0D,  0.0D, 2.0D, 2.0D, 1.0D);
//    public static final AxisAlignedBB AABB_EW = new AxisAlignedBB( 0.0D, -1.0D, -1.0D, 1.0D, 2.0D, 2.0D);
//
//    public MachinaWaterwheel(String name) {
//        super(name, Material.WOOD);
//    }
//
//    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
//        EnumFacing enumfacing = state.getValue(FACING);
//        if(enumfacing == EnumFacing.NORTH || enumfacing == EnumFacing.SOUTH) return AABB_SN;
//        if(enumfacing == EnumFacing.EAST  || enumfacing == EnumFacing.WEST ) return AABB_EW;
//        return FULL_BLOCK_AABB;
//    }
//
//    public TileEntity createNewTileEntity(World worldIn, int meta){
//        return new TileEntityWaterwheel();
//    }
//
//    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
//        if(hasNeighbour(world, pos.south())){ if(EnumFacing.SOUTH == world.getBlockState(pos.south()).getValue(FACING)){ world.setBlockState(pos, state.withProperty(FACING, EnumFacing.SOUTH), 2); } else { world.destroyBlock(pos, true); } }
//        else if(hasNeighbour(world, pos.north())){ if(EnumFacing.NORTH == world.getBlockState(pos.north()).getValue(FACING)){ world.setBlockState(pos, state.withProperty(FACING, EnumFacing.NORTH), 2); } else { world.destroyBlock(pos, true); } }
//        else if(hasNeighbour(world, pos.west ())){ if(EnumFacing.WEST  == world.getBlockState(pos.west ()).getValue(FACING)){ world.setBlockState(pos, state.withProperty(FACING, EnumFacing.WEST ), 2); } else { world.destroyBlock(pos, true); } }
//        else if(hasNeighbour(world, pos.east ())){ if(EnumFacing.EAST  == world.getBlockState(pos.east ()).getValue(FACING)){ world.setBlockState(pos, state.withProperty(FACING, EnumFacing.EAST ), 2); } else { world.destroyBlock(pos, true); } }
//        else world.destroyBlock(pos, true);
//    }
//
//    private boolean hasNeighbour(World world, BlockPos pos){
//        return world.getBlockState(pos).getBlock() == ShopKeeper.MACHINA_GEARBOX;
//    }
//
//}

