package mod.acecraft.blocks;

public class MachinaFruitPress {

}

//public class MachinaFruitPress extends IMachinaEnergy {
//
//    public MachinaFruitPress(String name) {
//        super(name, Material.WOOD);
//    }
//
//    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
//        if (worldIn.isRemote){
//            return true;
//        } else {
//            TileEntity tileentity = worldIn.getTileEntity(pos);
//            if (tileentity instanceof TileEntityFruitPress){
//                playerIn.openGui(AceCraft.instance, ShopKeeper.GuiID.FRUITPRESS.ordinal(), worldIn, pos.getX(), pos.getY(), pos.getZ());
//                playerIn.addStat(StatList.FURNACE_INTERACTION);
//            }
//            return true;
//        }
//    }
//
//    public TileEntity createNewTileEntity(World worldIn, int meta){
//        return new TileEntityFruitPress();
//    }
//
//}
