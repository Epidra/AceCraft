package net.acecraft.mod.blocks;

import javax.annotation.Nullable;

import net.acecraft.mod.ShopKeeper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
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
	
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
		if(world.isRemote){
			return true;
		} else if(!player.isSneaking()){
			if(heldItem != null && heldItem.getItem() == ShopKeeper.stuffRope){
				int stacksize = heldItem.stackSize;
				int layer = 0;
				while(stacksize > 0){
					layer++;
					if(world.getBlockState(new BlockPos(pos.getX(), pos.getY() - layer, pos.getZ())).getBlock() == ShopKeeper.machinaRope){
						// Skip this Layer
					} else if(world.getBlockState(new BlockPos(pos.getX(), pos.getY() - layer, pos.getZ())).getBlock() == Blocks.AIR){
						// Place a Rope Block
						world.setBlockState(new BlockPos(pos.getX(), pos.getY() - layer, pos.getZ()), ShopKeeper.machinaRope.getDefaultState());
						stacksize--;
					} else {
						// Cancel further Rope Placement
						break;
					}
				}
				if(stacksize == 0){
					player.setHeldItem(hand, null);
				} else {
					player.setHeldItem(hand, new ItemStack(heldItem.getItem(), stacksize));
				}
			}
		}
		return true;
    }
	
}
