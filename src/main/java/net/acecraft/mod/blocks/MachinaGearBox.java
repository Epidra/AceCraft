package net.acecraft.mod.blocks;

import java.util.Random;

import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.tileentity.TileEntityGearBox;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MachinaGearBox extends IMachinaEnergy {
	
	public MachinaGearBox(String name) {
		super(name, Material.WOOD);
	}
	
	public TileEntity createNewTileEntity(World worldIn, int meta){
        return new TileEntityGearBox();
    }
	
	public EnumBlockRenderType getRenderType(IBlockState state){
        return EnumBlockRenderType.MODEL;
    }
	
}
