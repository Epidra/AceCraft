package mod.acecraft.block;

import mod.lucky77.block.MachinaBase;
import mod.lucky77.blockentity.BlockEntityBase;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

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
    public void interact(Level world, BlockPos pos, Player player, BlockEntityBase tile) {

    }




    //----------------------------------------SUPPORT----------------------------------------//

    //@Override
    //public boolean hasTileEntity(BlockState state) {
    //    return false;
    //}

    @Deprecated
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return AABB;
    }

}
