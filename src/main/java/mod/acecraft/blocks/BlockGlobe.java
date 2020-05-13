package mod.acecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class BlockGlobe extends BlockBasic {

    public static final VoxelShape AABB = Block.makeCuboidShape(4, 0, 4, 12, 14, 12);

    public BlockGlobe() {
        super(Blocks.LAPIS_BLOCK);
    }

    @Deprecated
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return AABB;
    }
}
