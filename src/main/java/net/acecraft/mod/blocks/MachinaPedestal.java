package net.acecraft.mod.blocks;

import net.acecraft.mod.entity.EntityZed;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MachinaPedestal extends IMachinaBasic {
	
	public MachinaPedestal(String name) {
		super(name, Material.ROCK);
	}
	
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
		worldIn.spawnEntityInWorld(new EntityZed(worldIn));
        return true;
    }
	
}
