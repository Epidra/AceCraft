package mod.acecraft.blocks;

import mod.lucky77.blocks.MachinaBase;
import mod.lucky77.tileentities.TileBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BlockGlobe extends MachinaBase {

    public static final VoxelShape AABB = Block.box(4, 0, 4, 12, 14, 12);




    //----------------------------------------CONSTRUCTOR----------------------------------------//

    /** Contructor with predefined BlockProperty */
    public BlockGlobe() {
        super(Blocks.LAPIS_BLOCK);
    }




    //----------------------------------------PLACEMENT----------------------------------------//

    // ...




    //----------------------------------------INTERACTION----------------------------------------//

    @Override
    public void interact(World world, BlockPos blockPos, PlayerEntity playerEntity, TileBase tileBase) {

    }




    //----------------------------------------SUPPORT----------------------------------------//

    @Override
    public boolean hasTileEntity(BlockState state) {
        return false;
    }

    @Deprecated
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return AABB;
    }

}
