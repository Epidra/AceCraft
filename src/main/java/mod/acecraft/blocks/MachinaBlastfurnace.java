package mod.acecraft.blocks;

import mod.acecraft.ShopKeeper;
import mod.acecraft.tileentities.TileBlastFurnace;
import mod.shared.blocks.MachinaBasic;
import mod.shared.blocks.MachinaFlamer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class MachinaBlastfurnace extends MachinaFlamer {



    //----------------------------------------CONSTRUCTOR----------------------------------------//

    /** Contructor with predefined BlockProperty */
    public MachinaBlastfurnace(String modid, String name, Block block) {
        super(modid, name, block);
    }


    //----------------------------------------FUNCTION----------------------------------------//

    @Override
    protected void interactWith(World world, BlockPos pos, PlayerEntity player) {
        TileEntity tileentity = world.getTileEntity(pos);
        INamedContainerProvider provider = tileentity instanceof INamedContainerProvider ? (INamedContainerProvider) tileentity : null;
        player.openContainer(provider);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ShopKeeper.TYPE_BLASTFURNACE_TILE.create();
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> drops = new ArrayList<>();
        drops.add(new ItemStack(this));
        return drops;
    }

}
