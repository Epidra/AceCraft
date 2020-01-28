package mod.acecraft.blocks;

import mod.acecraft.ShopKeeper;
import mod.shared.blocks.IMachinaCubic;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MachinaAnchor extends IMachinaCubic {
	
	public MachinaAnchor(String name) {
		super(name, Material.IRON);
	}
	
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(world.isRemote){
			return true;
		} else if(!player.isSneaking()){
			if(player.getHeldItem(hand).getItem() != null && player.getHeldItem(hand).getItem() == ShopKeeper.STUFF_ROPE){
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
