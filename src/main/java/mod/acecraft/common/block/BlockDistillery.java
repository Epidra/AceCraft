package mod.acecraft.common.block;

import mod.acecraft.Register;
import mod.acecraft.common.block.entity.BlockEntityDistillery;
import mod.acecraft.system.MenuProvider;
import mod.lucky77.block.base.MachinaBase;
import mod.lucky77.block.entity.BlockEntityBase;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;

public class BlockDistillery extends MachinaBase implements EntityBlock {
	
	public static final BooleanProperty LIT = BlockStateProperties.LIT;
	
	private static final VoxelShape AABB0 = Block.box(2, 0, 1, 16, 16, 15);
	private static final VoxelShape AABB1 = Block.box(1, 0, 2, 16, 16, 15);
	private static final VoxelShape AABB2 = Block.box(0, 0, 1, 14, 16, 15);
	private static final VoxelShape AABB3 = Block.box(1, 0, 0, 15, 16, 14);
	
	
	
	
	
	// ---------- ---------- ---------- ----------  CONSTRUCTOR  ---------- ---------- ---------- ---------- //
	
	/** Contructor with predefined BlockProperty */
	public BlockDistillery() {
		super(Blocks.IRON_BLOCK);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LIT, false));
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  PLACEMENT  ---------- ---------- ---------- ---------- //
	
	// ...
	
	
	
	
	
	// ---------- ---------- ---------- ----------  INTERACTION  ---------- ---------- ---------- ---------- //
	
	@Override
	public void interact(Level world, BlockPos pos, Player player, BlockEntityBase tile) {
		NetworkHooks.openScreen((ServerPlayer) player, new MenuProvider(tile), buf -> buf.writeBlockPos(pos));
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SUPPORT  ---------- ---------- ---------- ---------- //
	
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
		Direction enumfacing = state.getValue(FACING);
		return switch(enumfacing) {
			case NORTH -> AABB1;
			case SOUTH -> AABB3;
			case EAST  -> AABB2;
			case WEST  -> AABB0;
			default    -> Shapes.block();
		};
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  BLOCK ENTITY  ---------- ---------- ---------- ---------- //
	
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new BlockEntityDistillery(pos, state);
	}
	
	@Nullable
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
		return createTicker(level, type, (BlockEntityType<? extends BlockEntityDistillery>) Register.TILE_DISTILLERY.get());
	}
	
	@Nullable
	protected static <T extends BlockEntity> BlockEntityTicker<T> createTicker(Level level, BlockEntityType<T> type, BlockEntityType<? extends BlockEntityDistillery> typeCustom) {
		return createTickerHelper(type, typeCustom, BlockEntityDistillery::serverTick);
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  BLOCKSTATE  ---------- ---------- ---------- ---------- //
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, LIT);
	}
	
	
	
}
