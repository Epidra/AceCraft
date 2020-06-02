package net.acecraft.mod.block.machina;

import java.util.Random;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.tileentity.TileEntityRope;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Rope extends BlockContainer {
	
	public Rope(){
		super(Material.cloth);
		this.setHardness(0.5F);
		this.setResistance(0.5F);
		this.setBlockBounds(0.4F, 0F, 0.4F, 0.6F, 1F, 0.6F);
	}
	
	@Override
	public boolean isLadder(IBlockAccess world, int x, int y, int z, EntityLivingBase entity){
		return true;
	}
	
	public int getRenderType(){
		return -1;
	}
	
	public boolean isOpaqueCube(){
		return false;
	}
	
	public boolean renderAsNormalBlock(){
		return false;
	}
	
	public TileEntity createNewTileEntity(World world, int i){
		return new TileEntityRope();
	}
	
	public void registerBlockIcons(IIconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5));
	}
	
    public Item getItemDropped(int i, Random random, int j){
    	return ShopKeeper.stuffRope;
    }
    
    public Item getItem(World world, int x, int y, int z){
    	return ShopKeeper.stuffRope;
    }

}