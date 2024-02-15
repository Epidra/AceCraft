package mod.acecraft.common.block;

import mod.acecraft.Register;
import mod.lucky77.block.base.MachinaCube;
import mod.lucky77.block.entity.BlockEntityBase;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockAnchor extends MachinaCube {
	
	public static final BooleanProperty ATTACHED = BlockStateProperties.ATTACHED;
	
	public static final VoxelShape AABB_S = Block.box(6, 0, 3, 10, 13, 16);
	public static final VoxelShape AABB_E = Block.box(3, 0, 6, 16, 13, 10);
	public static final VoxelShape AABB_N = Block.box(6, 0, 0, 10, 13, 13);
	public static final VoxelShape AABB_W = Block.box(0, 0, 6, 13, 13, 10);
	public static final VoxelShape AABB_U = Block.box(6, 0, 3, 10, 16, 13);
	public static final VoxelShape AABB_D = Block.box(6, 0, 3, 10, 13, 13);
	
	
	
	
	
	// ---------- ---------- ---------- ----------  CONSTRUCTOR  ---------- ---------- ---------- ---------- //
	
	/** Contructor with predefined BlockProperty */
	public BlockAnchor() {
		super(Blocks.IRON_BLOCK);
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(ATTACHED, false));
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  PLACEMENT  ---------- ---------- ---------- ---------- //
	
	// ...
	
	
	
	
	
	// ---------- ---------- ---------- ----------  INTERACTION  ---------- ---------- ---------- ---------- //
	
	@Override
	public void interact(Level world, BlockPos pos, Player player, BlockEntityBase tile) {
		int layer = 0;
		
		// ----- When the Player has a Rope in Hand ----- //
		if(player.getMainHandItem().getItem() == Register.STUFF_ROPE.get()){
			int stacksize = player.getMainHandItem().getCount();
			while(stacksize > 0){
				layer++;
				
				// - Place a new Rope Block - //
				if(world.getBlockState(new BlockPos(pos.getX(), pos.getY() - layer, pos.getZ())).getBlock() == Blocks.AIR){
					world.setBlockAndUpdate(new BlockPos(pos.getX(), pos.getY() - layer, pos.getZ()), Register.MACHINA_ROPE.get().defaultBlockState());
					stacksize--;
					
				// - Find a non-Rope Block and stop the cycle - //
				} else if(world.getBlockState(new BlockPos(pos.getX(), pos.getY() - layer, pos.getZ())).getBlock() != Register.MACHINA_ROPE.get()){
					break;
				}
			}
			
			// - Remove used rope from player hand - //
			player.setItemSlot(EquipmentSlot.MAINHAND, stacksize == 0 ? ItemStack.EMPTY : new ItemStack(player.getMainHandItem().getItem(), stacksize));
			
			
		// ----- When the Player has an empty Hand ----- //
		} else if(player.getMainHandItem().isEmpty()){
			
			// - Scan for all Rope blocks beneath the Anchor - //
			while(world.getBlockState(new BlockPos(pos.getX(), pos.getY() - layer - 1, pos.getZ())).getBlock() == Register.MACHINA_ROPE.get()){
				layer++;
			}
			
			// - Return as many rope as the player can hold in hand - //
			player.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Register.STUFF_ROPE.get(), layer > 64 ? 64 : layer));
			int endpoint = layer < 64 ? 0 : layer - 64;
			while(layer > endpoint){
				world.destroyBlock(new BlockPos(pos.getX(), pos.getY() - layer, pos.getZ()), false);
				layer--;
			}
		}
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SUPPORT  ---------- ---------- ---------- ---------- //
	
	@Deprecated
	public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
		Direction enumfacing = state.getValue(FACING);
		return switch(enumfacing) {
			case NORTH -> AABB_N;
			case SOUTH -> AABB_S;
			case EAST  -> AABB_E;
			case WEST  -> AABB_W;
			case UP    -> AABB_U;
			case DOWN  -> AABB_D;
		};
	}
	
	@Override
	public boolean isLadder(BlockState state, LevelReader world, BlockPos pos, LivingEntity entity) {
		return true;
	}
	
	@Deprecated
	public void neighborChanged(BlockState state, Level world, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
		world.setBlock(pos, world.getBlockState(pos).setValue(ATTACHED, world.getBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ())).getBlock() == Register.MACHINA_ROPE.get()), 2);
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  BLOCKSTATE  ---------- ---------- ---------- ---------- //
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, ATTACHED);
	}
	
	
	
}
