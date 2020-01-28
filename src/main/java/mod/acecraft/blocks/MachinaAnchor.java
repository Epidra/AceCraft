package mod.acecraft.blocks;

import mod.shared.blocks.MachinaBasic;
import net.minecraft.block.Block;

public class MachinaAnchor extends MachinaBasic {

    public MachinaAnchor(String modid, String name, Block block) {
        super(modid, name, block);
    }

    //public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
    //    if(world.isRemote){
    //        return true;
    //    } else if(!player.isSneaking()){
    //        if(player.getHeldItem(hand).getItem() != null && player.getHeldItem(hand).getItem() == ShopKeeper.STUFF_ROPE){
    //            int stacksize = player.getHeldItem(hand).getMaxStackSize();
    //            int layer = 0;
    //            while(stacksize > 0){
    //                layer++;
    //                if(world.getBlockState(new BlockPos(pos.getX(), pos.getY() - layer, pos.getZ())).getBlock() == ShopKeeper.MACHINA_ROPE){
    //                    // Skip this Layer
    //                } else if(world.getBlockState(new BlockPos(pos.getX(), pos.getY() - layer, pos.getZ())).getBlock() == Blocks.AIR){
    //                    // Place a Rope Block
    //                    world.setBlockState(new BlockPos(pos.getX(), pos.getY() - layer, pos.getZ()), ShopKeeper.MACHINA_ROPE.getDefaultState());
    //                    stacksize--;
    //                } else {
    //                    // Cancel further Rope Placement
    //                    break;
    //                }
    //            }
    //            if(stacksize == 0){
    //                player.setHeldItem(hand, null);
    //            } else {
    //                player.setHeldItem(hand, new ItemStack(player.getHeldItem(hand).getItem(), stacksize));
    //            }
    //        }
    //    }
    //    return true;
    //}

}
