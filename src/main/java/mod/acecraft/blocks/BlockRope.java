package mod.acecraft.blocks;

import mod.acecraft.ShopKeeper;
import mod.lucky77.blocks.MachinaBase;
import mod.lucky77.tileentities.TileBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BlockRope extends MachinaBase {

    public static final VoxelShape AABB = Block.box(6, 0, 6, 10, 16, 10);




    //----------------------------------------CONSTRUCTOR----------------------------------------//

    /** Contructor with predefined BlockProperty */
    public BlockRope() {
        super(Blocks.BLACK_WOOL);
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
        if(world.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())).getBlock() != ShopKeeper.MACHINA_ANCHOR.get() && world.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())).getBlock() != ShopKeeper.MACHINA_ROPE.get()){
            world.destroyBlock(pos, true);
        }
    }

}
