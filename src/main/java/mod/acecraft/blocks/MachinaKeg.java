package mod.acecraft.blocks;

import mod.acecraft.ShopKeeper;
import mod.acecraft.tileentities.TileEntityKeg;
import mod.shared.blocks.MachinaBasic;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public class MachinaKeg extends MachinaBasic {

    public MachinaKeg(String modid, String name, Block block) {
        super(modid, name, block);
    }

    public boolean isFullCube(BlockState state){
        return false;
    }

    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult blockRayTraceResult) {
        // Only execute on the server
        if (worldIn.isRemote)
            return true;
        TileEntity te = worldIn.getTileEntity(pos);
        if (! (te instanceof TileEntityKeg))
            return false;
        NetworkHooks.openGui((ServerPlayerEntity) player, (INamedContainerProvider) te, pos);
        return true;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileEntityKeg();
    }

}
