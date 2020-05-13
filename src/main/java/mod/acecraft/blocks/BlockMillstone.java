package mod.acecraft.blocks;

public class BlockMillstone {

}

//public class MachinaMillstone extends IMachinaEnergy {
//
//    public int energy = 0;
//
//    public static final AxisAlignedBB AABB = new AxisAlignedBB(-1.0D, 0.0D, -1.0D, 2.0D, 2.0D, 2.0D);
//
//    public MachinaMillstone(String name) {
//        super(name, Material.WOOD);
//    }
//
//    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
//        return AABB;
//    }
//
//    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
//        if (worldIn.isRemote){
//            return true;
//        } else {
//            TileEntity tileentity = worldIn.getTileEntity(pos);
//            if (tileentity instanceof TileEntityMillstone){
//                playerIn.openGui(AceCraft.instance, ShopKeeper.GuiID.MILLSTONE.ordinal(), worldIn, pos.getX(), pos.getY(), pos.getZ());
//                playerIn.addStat(StatList.FURNACE_INTERACTION);
//            }
//            return true;
//        }
//    }
//
//    public TileEntity createNewTileEntity(World worldIn, int meta){
//        return new TileEntityMillstone();
//    }
//
//}
