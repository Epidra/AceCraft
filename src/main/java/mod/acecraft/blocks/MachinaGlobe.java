package mod.acecraft.blocks;

import mod.shared.blocks.MachinaBasic;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class MachinaGlobe extends MachinaBasic {

    public static final VoxelShape AABB = Block.makeCuboidShape(4, 0, 4, 12, 14, 12);

    public MachinaGlobe(String modid, String name, Block block) {
        super(modid, name, block);
    }

    @Deprecated
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return AABB;
    }
}
