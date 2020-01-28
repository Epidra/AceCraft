package mod.acecraft.blocks;

import mod.shared.blocks.MachinaBasic;
import net.minecraft.block.Block;

public class MachinaRope extends MachinaBasic {

    public MachinaRope(String modid, String name, Block block) {
        super(modid, name, block);
    }

}

//public class MachinaRope extends IMachinaBasic {
//
//    public static final AxisAlignedBB FULL_BLOCK_AABB = new AxisAlignedBB(0.4D, 0.0D, 0.4D, 0.6D, 1.0D, 0.6D);
//
//    public MachinaRope(String name) {
//        super(name, Material.CLOTH);
//    }
//
//    public boolean isLadder(IBlockState state, IBlockAccess world, BlockPos pos, EntityLivingBase entity) {
//        return true;
//    }
//
//    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
//        return FULL_BLOCK_AABB;
//    }
//
//    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block){
//        if(world.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())).getBlock() != ShopKeeper.MACHINA_ANCHOR && world.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())).getBlock() != ShopKeeper.MACHINA_ROPE){
//            world.destroyBlock(pos, true);
//        }
//    }
//
//    public Item getItemDropped(IBlockState state, Random rand, int fortune){
//        return ShopKeeper.STUFF_ROPE;
//    }
//
//}
