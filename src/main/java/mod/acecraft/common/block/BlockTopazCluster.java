package mod.acecraft.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class BlockTopazCluster extends BlockTopaz implements SimpleWaterloggedBlock {
	
	public static final BooleanProperty   WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final DirectionProperty FACING      = BlockStateProperties.FACING;
	
	protected final VoxelShape northAabb;
	protected final VoxelShape southAabb;
	protected final VoxelShape eastAabb;
	protected final VoxelShape westAabb;
	protected final VoxelShape upAabb;
	protected final VoxelShape downAabb;
	
	
	
	
	
	// ---------- ---------- ---------- ----------  CONSTRUCTOR  ---------- ---------- ---------- ---------- //
	
	public BlockTopazCluster(int sizeMin, int sizeMax, BlockBehaviour.Properties properties) {
		super(properties);
		this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(false)).setValue(FACING, Direction.UP));
		this.upAabb    = box(     sizeMax,         0.0D,      sizeMax, 16 - sizeMax,      sizeMin, 16 - sizeMax);
		this.downAabb  = box(     sizeMax, 16 - sizeMin,      sizeMax, 16 - sizeMax,        16.0D, 16 - sizeMax);
		this.northAabb = box(     sizeMax,      sizeMax, 16 - sizeMin, 16 - sizeMax, 16 - sizeMax,        16.0D);
		this.southAabb = box(     sizeMax,      sizeMax,         0.0D, 16 - sizeMax, 16 - sizeMax,      sizeMin);
		this.eastAabb  = box(        0.0D,      sizeMax,      sizeMax,      sizeMin, 16 - sizeMax, 16 - sizeMax);
		this.westAabb  = box(16 - sizeMin,      sizeMax,      sizeMax,        16.0D, 16 - sizeMax, 16 - sizeMax);
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  PLACEMENT  ---------- ---------- ---------- ---------- //
	
	@Nullable
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		LevelAccessor levelaccessor = context.getLevel();
		BlockPos blockpos = context.getClickedPos();
		return this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(levelaccessor.getFluidState(blockpos).getType() == Fluids.WATER)).setValue(FACING, context.getClickedFace());
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  INTERACTION  ---------- ---------- ---------- ---------- //
	
	// ...
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SUPPORT  ---------- ---------- ---------- ---------- //
	
	public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos pos, CollisionContext context) {
		Direction direction = state.getValue(FACING);
		return switch(direction) {
			case NORTH -> this.northAabb;
			case SOUTH -> this.southAabb;
			case EAST  -> this.eastAabb;
			case WEST  -> this.westAabb;
			case DOWN  -> this.downAabb;
			case UP    -> this.upAabb;
		};
	}
	
	public BlockState updateShape(BlockState state, Direction direction, BlockState state2, LevelAccessor level, BlockPos pos1, BlockPos pos2) {
		if (state.getValue(WATERLOGGED)) {
			level.scheduleTick(pos1, Fluids.WATER, Fluids.WATER.getTickDelay(level));
		}
		
		return direction == state.getValue(FACING).getOpposite() && !state.canSurvive(level, pos1) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, state2, level, pos1, pos2);
	}
	
	public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
		Direction direction = state.getValue(FACING);
		BlockPos blockpos = pos.relative(direction.getOpposite());
		return level.getBlockState(blockpos).isFaceSturdy(level, blockpos, direction);
	}
	
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  BLOCKSTATE  ---------- ---------- ---------- ---------- //
	
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(WATERLOGGED, FACING);
	}
	
	public BlockState rotate(BlockState state, Rotation value) {
		return state.setValue(FACING, value.rotate(state.getValue(FACING)));
	}
	
	public BlockState mirror(BlockState state, Mirror value) {
		return state.rotate(value.getRotation(state.getValue(FACING)));
	}
	
	
	
}