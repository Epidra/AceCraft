package mod.acecraft.blocks;

import mod.acecraft.ShopKeeper;
import mod.shared.blocks.MachinaBasic;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class MachinaAnchor extends MachinaBasic {

    public MachinaAnchor(String modid, String name, Block block) {
        super(modid, name, block);
    }

    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult blockRayTraceResult) {
        if(hand == Hand.MAIN_HAND){
            if(player.inventory.mainInventory.get(player.inventory.currentItem).getItem() == ShopKeeper.STUFF_ROPE){
                int stacksize = player.getHeldItem(hand).getMaxStackSize();
                int layer = 0;
                while(stacksize > 0){
                    layer++;
                    if(world.getBlockState(new BlockPos(pos.getX(), pos.getY() - layer, pos.getZ())).getBlock() == ShopKeeper.MACHINA_ROPE){
                        // Skip this Layer
                    } else if(world.getBlockState(new BlockPos(pos.getX(), pos.getY() - layer, pos.getZ())).getBlock() == Blocks.AIR){
                        // Place a Rope Block
                        world.setBlockState(new BlockPos(pos.getX(), pos.getY() - layer, pos.getZ()), ShopKeeper.MACHINA_ROPE.getDefaultState());
                        stacksize--;
                    } else {
                        // Cancel further Rope Placement
                        break;
                    }
                }
                if(stacksize == 0){
                    player.setHeldItem(hand, null);
                } else {
                    player.setHeldItem(hand, new ItemStack(player.getHeldItem(hand).getItem(), stacksize));
                }
            }
        }
        return true;
    }

}
