package mod.acecraft.common.block;

import mod.acecraft.Register;
import mod.acecraft.client.menu.MenuDistillery;
import mod.acecraft.client.menu.MenuFoundry;
import mod.acecraft.common.block.entity.BlockEntityDistillery;
import mod.acecraft.common.block.entity.BlockEntityFoundry;
import mod.lucky77.common.block.base.MachinaHigh;
import mod.lucky77.common.block.entity.BlockEntityBase;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
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
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class BlockDistillery extends MachinaHigh implements EntityBlock {
	
	protected static final VoxelShape AABB = Block.box(1, 0, 1, 15, 16, 15);
	
	public static final BooleanProperty LIT = BlockStateProperties.LIT;
	
	public BlockDistillery(){
		super(Blocks.STONE);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(OFFSET, true).setValue(LIT, false));
	}
	
	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return AABB;
	}
	
	@Override
	public void interact(Level level, BlockPos pos, Player player, BlockEntityBase blockEntity){
		// BlockEntity blockentity = level.getBlockEntity(pos);
		if (blockEntity instanceof BlockEntityBase) {
			// player.openMenu((MenuProvider)blockEntity);
			// player.awardStat(Stats.INTERACT_WITH_FURNACE);
			
			// vanilla version
			// player.openMenu((MenuProvider)blockEntity);
			
			// neoforge version 1
			// In some implementation with access to the Player on the logical server (e.g. ServerPlayer instance)
			// Assume we have ServerPlayer serverPlayer
			// player.openMenu(new SimpleMenuProvider(
			// 		(containerId, playerInventory, player2) -> new MenuFoundry(containerId, playerInventory, pos),
			// 		Component.translatable("menu.title.examplemod.mymenu")
			// ));
			
			// can be moved into base
			if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
				serverPlayer.openMenu(level.getBlockState(pos).getMenuProvider(level, pos), buf -> buf.writeBlockPos(pos));
			}
			
		}
		
		
		
	}
	
	// Vanilla methods use this to view the menu in spectator mode.
	@Override
	public MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
		return new SimpleMenuProvider(
				(containerId, playerInventory, player2) -> new MenuDistillery(containerId, playerInventory, pos),
				Component.translatable("menu.title.examplemod.mymenu")
		);
	}
	
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state){
		return state.getValue(OFFSET) ? new BlockEntityDistillery(pos, state) : null;
	}
	
	// ???
	@Nullable
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type){
		return createTicker(level, type, (BlockEntityType<? extends BlockEntityDistillery>) Register.ENTITY_DISTILLERY.get());
	}
	
	@Nullable
	protected static <T extends BlockEntity> BlockEntityTicker<T> createTicker(Level level, BlockEntityType<T> type, BlockEntityType<? extends BlockEntityDistillery> typeCustom){
		return createTickerHelper(type, typeCustom, BlockEntityDistillery::serverTick);
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder){
		builder.add(FACING, OFFSET, LIT);
	}
	
}
