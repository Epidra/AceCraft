package mod.acecraft.blocks;

import mod.acecraft.ShopKeeper;
import mod.shared.blocks.MachinaBasic;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class MachinaRope extends MachinaBasic {

    public static final VoxelShape AABB = Block.makeCuboidShape(6, 0, 6, 9, 16, 9);

    public MachinaRope(String modid, String name, Block block) {
        super(modid, name, block);
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public boolean isLadder(BlockState state, net.minecraft.world.IWorldReader world, BlockPos pos, LivingEntity entity) {
        return true;
    }

    @Deprecated
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return AABB;
    }

    @Deprecated
    public void neighborChanged(BlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if(world.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())).getBlock() != ShopKeeper.MACHINA_ANCHOR && world.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())).getBlock() != ShopKeeper.MACHINA_ROPE){
            world.destroyBlock(pos, true);
        }
    }

}
