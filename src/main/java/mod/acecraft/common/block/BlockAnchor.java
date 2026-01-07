package mod.acecraft.common.block;

import mod.acecraft.Register;
import mod.lucky77.common.block.base.MachinaCube;
import mod.lucky77.common.block.entity.BlockEntityBase;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockAnchor extends MachinaCube {
	
	protected static final VoxelShape AABB = Block.box(1, 0, 1, 15, 16, 15);
	
	// public static final BooleanProperty LIT = BlockStateProperties.LIT;
	
	// public static final DirectionProperty FACING2 = BlockStateProperties.HORIZONTAL_FACING;
	
	public BlockAnchor(){
		super(Blocks.STONE);
		// this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(OFFSET, false));
		// this.registerDefaultState(this.stateDefinition.any().setValue(FACING2, Direction.NORTH).setValue(OFFSET, true));
	}
	
	@Override
	protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return AABB;
	}
	
	@Override
	public void interact(Level level, BlockPos pos, Player player, BlockEntityBase blockEntity){
		int layer = 0;
		
		// ----- When the Player has a Rope in Hand ----- //
		if(player.getMainHandItem().getItem() == Register.STUFF_ROPE.get()){
			int stacksize = player.getMainHandItem().getCount();
			while(stacksize > 0){
				layer++;
				
				// - Place a new Rope Block - //
				if(level.getBlockState(pos.below(layer)).getBlock() == Blocks.AIR){
					level.setBlockAndUpdate(pos.below(layer), Register.MACHINA_ROPE.get().defaultBlockState());
					stacksize--;
				
				// - Find a non-Rope Block and stop the cycle - //
				} else if(level.getBlockState(pos.below(layer)).getBlock() != Register.MACHINA_ROPE.get()){
					break;
				}
			}
			
			// - Remove used Rope from the player hand - //
			player.setItemSlot(EquipmentSlot.MAINHAND, stacksize == 0 ? ItemStack.EMPTY : new ItemStack(player.getMainHandItem().getItem(), stacksize));
			
		// ----- When the Player has an empty Hand ----- //
		} else if(player.getMainHandItem().isEmpty()){
			
			// - Scan for all Rope blocks below the the Anchor - //
			while(level.getBlockState(pos.below(layer + 1)).getBlock() == Register.MACHINA_ROPE.get()){
				layer++;
			}
			
			// - Return as many ropes as the player can hold in hand - //
			player.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Register.STUFF_ROPE.get(), layer > 64 ? 64 : layer));
			int endpoint = layer < 64 ? 0 : layer - 64;
			while(layer > endpoint){
				level.destroyBlock(pos.below(layer), false);
				layer--;
			}
		}
	}
	
	@Override
	protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving){
		level.setBlock(pos, level.getBlockState(pos).setValue(OFFSET, level.getBlockState(pos.below()).getBlock() == Register.MACHINA_ROPE.get()), 2);
	}
	
	// @Override
	// protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder){
	// 	builder.add(FACING2, OFFSET);
	// }
	
	
	
}
