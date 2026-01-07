package mod.acecraft.common.block;

import mod.acecraft.Register;
import mod.lucky77.common.block.BlockBlock;
import mod.lucky77.common.block.base.MachinaBase;
import mod.lucky77.common.block.entity.BlockEntityBase;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.RedStoneWireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockRope extends BlockBlock {
	
	protected static final VoxelShape AABB = Block.box(6, 0, 6, 10, 16, 10);
	
	public BlockRope(){
		super(Blocks.LADDER);
	}
	
	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return AABB;
	}
	
	@Override
	protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving){
		if(level.getBlockState(pos.above()).getBlock() != Register.MACHINA_ANCHOR.get() && level.getBlockState(pos.above()).getBlock() != Register.MACHINA_ROPE.get()){
			level.destroyBlock(pos, true);
		}
	}
	
	
	
}
