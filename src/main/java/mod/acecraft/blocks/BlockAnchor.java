package mod.acecraft.blocks;

import mod.acecraft.ShopKeeper;
import mod.lucky77.blocks.MachinaCube;
import mod.lucky77.tileentities.TileBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

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
    public void interact(World world, BlockPos pos, PlayerEntity player, TileBase tile) {
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
                player.setItemSlot(EquipmentSlotType.MAINHAND, ItemStack.EMPTY);
            } else {
                player.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(player.getMainHandItem().getItem(), stacksize));
            }
        }
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
        Direction enumfacing = state.getValue(FACING);
        switch(enumfacing) {
            case NORTH: return AABB_N;
            case SOUTH: return AABB_S;
            case EAST:  return AABB_E;
            case WEST:  return AABB_W;
            case UP:    return AABB_U;
            case DOWN:  return AABB_D;
            default:
                return VoxelShapes.block();
        }
    }

}
