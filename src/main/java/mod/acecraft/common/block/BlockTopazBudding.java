package mod.acecraft.common.block;

import mod.acecraft.Register;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;

public class BlockTopazBudding extends BlockTopaz {
	
	private static final Direction[] DIRECTIONS = Direction.values();
	
	
	
	
	
	// ---------- ---------- ---------- ----------  CONSTRUCTOR  ---------- ---------- ---------- ---------- //
	
	public BlockTopazBudding(BlockBehaviour.Properties properties) {
		super(properties);
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  PLACEMENT  ---------- ---------- ---------- ---------- //
	
	// ...
	
	
	
	
	
	// ---------- ---------- ---------- ----------  INTERACTION  ---------- ---------- ---------- ---------- //
	
	// ...
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SUPPORT  ---------- ---------- ---------- ---------- //
	
	public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
		if (random.nextInt(5) == 0) {
			Direction direction = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
			BlockPos blockpos = pos.relative(direction);
			BlockState blockstate = level.getBlockState(blockpos);
			Block block = null;
			if (canClusterGrowAtState(blockstate)) {
				block = Register.BLOCK_TOPAZ_BUD_1.get();
			} else if (blockstate.is(Register.BLOCK_TOPAZ_BUD_1.get()) && blockstate.getValue(BlockTopazCluster.FACING) == direction) {
				block = Register.BLOCK_TOPAZ_BUD_2.get();
			} else if (blockstate.is(Register.BLOCK_TOPAZ_BUD_2.get()) && blockstate.getValue(BlockTopazCluster.FACING) == direction) {
				block = Register.BLOCK_TOPAZ_BUD_3.get();
			} else if (blockstate.is(Register.BLOCK_TOPAZ_BUD_3.get()) && blockstate.getValue(BlockTopazCluster.FACING) == direction) {
				block = Blocks.AMETHYST_CLUSTER;
			}
					if (block != null) {
				BlockState blockstate1 = block.defaultBlockState().setValue(BlockTopazCluster.FACING, direction).setValue(BlockTopazCluster.WATERLOGGED, Boolean.valueOf(blockstate.getFluidState().getType() == Fluids.WATER));
				level.setBlockAndUpdate(blockpos, blockstate1);
			}
		}
	}
	
	public static boolean canClusterGrowAtState(BlockState state) {
		return state.isAir() || state.is(Blocks.WATER) && state.getFluidState().getAmount() == 8;
	}
}