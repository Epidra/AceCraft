package mod.acecraft.block;

import mod.acecraft.ShopKeeper;
import mod.lucky77.block.MachinaCube;
import mod.lucky77.blockentity.BlockEntityBase;
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
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockAnchor extends MachinaCube {

    public static final VoxelShape AABB_S = Block.box(6, 0, 3, 10, 13, 16);
    public static final VoxelShape AABB_E = Block.box(3, 0, 6, 16, 13, 10);
    public static final VoxelShape AABB_N = Block.box(6, 0, 0, 10, 13, 13);
    public static final VoxelShape AABB_W = Block.box(0, 0, 6, 13, 13, 10);
    public static final VoxelShape AABB_U = Block.box(6, 0, 3, 10, 16, 13);
    public static final VoxelShape AABB_D = Block.box(6, 0, 3, 10, 13, 13);





    //----------------------------------------CONSTRUCTOR----------------------------------------//

    /** Contructor with predefined BlockProperty */
    public BlockAnchor() {
        super(Blocks.IRON_BLOCK);
    }





    //----------------------------------------PLACEMENT----------------------------------------//

    // ...





    //----------------------------------------INTERACTION----------------------------------------//

    @Override
    public void interact(Level world, BlockPos pos, Player player, BlockEntityBase tile) {
        if(player.getMainHandItem().getItem() == ShopKeeper.STUFF_ROPE.get()){
            int stacksize = player.getMainHandItem().getCount();
            int layer = 0;
            while(stacksize > 0){
                layer++;
                if(world.getBlockState(new BlockPos(pos.getX(), pos.getY() - layer, pos.getZ())).getBlock() == ShopKeeper.MACHINA_ROPE.get()){
                    // Skip this Layer
                } else if(world.getBlockState(new BlockPos(pos.getX(), pos.getY() - layer, pos.getZ())).getBlock() == Blocks.AIR){
                    // Place a Rope Block
                    world.setBlockAndUpdate(new BlockPos(pos.getX(), pos.getY() - layer, pos.getZ()), ShopKeeper.MACHINA_ROPE.get().defaultBlockState());
                    stacksize--;
                } else {
                    // Cancel further Rope Placement
                    break;
                }
            }
            if(stacksize == 0){
                player.setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
            } else {
                player.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(player.getMainHandItem().getItem(), stacksize));
            }
        }
    }





    //----------------------------------------SUPPORT----------------------------------------//

    @Override
    public boolean isLadder(BlockState state, LevelReader world, BlockPos pos, LivingEntity entity) {
        return true;
    }

    @Deprecated
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        Direction enumfacing = state.getValue(FACING);
        switch(enumfacing) {
            case NORTH: return AABB_N;
            case SOUTH: return AABB_S;
            case EAST:  return AABB_E;
            case WEST:  return AABB_W;
            case UP:    return AABB_U;
            case DOWN:  return AABB_D;
            default:
                return Shapes.block();
        }
    }



}
