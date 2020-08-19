package mod.acecraft.blocks;

import mod.acecraft.container.ContainerProvider;
import mod.acecraft.tileentities.TileEntityStove;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class MachinaStove extends MachinaBasic {

    public MachinaStove(String modid, String name, Block block) {
        super(modid, name, block);
    }

    public boolean isFullCube(BlockState state){
        return false;
    }

    //public BlockRenderLayer getRenderLayer() {
    //    return BlockRenderLayer.TRANSLUCENT;
    //}

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult blockRayTraceResult) {
        // Only execute on the server
        if (worldIn.isRemote)
            return ActionResultType.SUCCESS;
        TileEntity te = worldIn.getTileEntity(pos);
        NetworkHooks.openGui((ServerPlayerEntity) player, new ContainerProvider((TileEntityStove) te), buf -> buf.writeBlockPos(pos));
        return ActionResultType.SUCCESS;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileEntityStove();
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> drops = new ArrayList<>();
        drops.add(new ItemStack(this));
        return drops;
    }

}
