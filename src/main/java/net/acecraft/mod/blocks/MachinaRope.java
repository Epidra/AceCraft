package net.acecraft.mod.blocks;

import java.util.Random;

import net.acecraft.mod.ShopKeeper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class MachinaRope extends IMachinaBasic {
	
	public static final AxisAlignedBB FULL_BLOCK_AABB = new AxisAlignedBB(0.4D, 0.0D, 0.4D, 0.6D, 1.0D, 0.6D);
	
	public MachinaRope(String name) {
		super(name, Material.CLOTH);
	}
	
	public boolean isLadder(IBlockState state, IBlockAccess world, BlockPos pos, EntityLivingBase entity) {
		return true;
	}
	
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return FULL_BLOCK_AABB;
    }
	
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block block){
    	if(world.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())).getBlock() != ShopKeeper.machinaAnchor && world.getBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())).getBlock() != ShopKeeper.machinaRope){
    		world.destroyBlock(pos, true);
    	}
    }
	
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return ShopKeeper.stuffRope;
    }
	
}
