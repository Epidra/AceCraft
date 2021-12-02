package mod.acecraft.block;

import mod.acecraft.ShopKeeper;
import mod.acecraft.menu.MenuProvider;
import mod.acecraft.blockentity.BlockEntityDistillery;
import mod.lucky77.block.MachinaBase;
import mod.lucky77.blockentity.BlockEntityBase;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
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
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class BlockDistillery extends MachinaBase implements EntityBlock {

    public static final BooleanProperty LIT = BlockStateProperties.LIT;

    private static final VoxelShape AABB0 = Block.box(2, 0, 1, 16, 16, 15);
    private static final VoxelShape AABB1 = Block.box(1, 0, 2, 16, 16, 15);
    private static final VoxelShape AABB2 = Block.box(0, 0, 1, 14, 16, 15);
    private static final VoxelShape AABB3 = Block.box(1, 0, 0, 15, 16, 14);





    //----------------------------------------CONSTRUCTOR----------------------------------------//

    /** Contructor with predefined BlockProperty */
    public BlockDistillery() {
        super(Blocks.IRON_BLOCK);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(LIT, false));
    }





    //----------------------------------------PLACEMENT----------------------------------------//

    // ...





    //----------------------------------------INTERACTION----------------------------------------//

    @Override
    public void interact(Level world, BlockPos pos, Player player, BlockEntityBase tile) {
        NetworkHooks.openGui((ServerPlayer) player, new MenuProvider(tile), buf -> buf.writeBlockPos(pos));
    }





    //----------------------------------------BLOCKENTITY----------------------------------------//

    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BlockEntityDistillery(pos, state);
    }

    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTicker(level, type, ShopKeeper.TILE_DISTILLERY.get());
    }

    @Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createTicker(Level level, BlockEntityType<T> type, BlockEntityType<? extends BlockEntityDistillery> typeCustom) {
        return createTickerHelper(type, typeCustom, BlockEntityDistillery::serverTick);
    }





    //----------------------------------------SUPPORT----------------------------------------//

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        Direction enumfacing = state.getValue(FACING);
        switch(enumfacing) {
            case NORTH: return AABB1;
            case SOUTH: return AABB3;
            case EAST:  return AABB2;
            case WEST:  return AABB0;
            default:
                return Shapes.block();
        }
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> drops = new ArrayList<>();
        drops.add(new ItemStack(this));
        return drops;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, LIT);
    }



}
