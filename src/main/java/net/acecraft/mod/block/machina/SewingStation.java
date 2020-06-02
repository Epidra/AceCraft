package net.acecraft.mod.block.machina;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.tileentity.TileEntitySewingStation;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;

public class SewingStation extends BlockContainer {
	
	public SewingStation(){
		super(Material.wood);
		this.setHardness(2.0F);
		this.setResistance(2.0F);
		this.setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
		this.setCreativeTab(ShopKeeper.acetabMachina);
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
		return new TileEntitySewingStation();
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z){
		int meta = world.getBlockMetadata(x, y, z);
		if(meta == 2){ this.setBlockBounds(-1.0F, 0.0F,  0.0F, 1.0F, 2.0F, 1.0F); }
		if(meta == 3){ this.setBlockBounds( 0.0F, 0.0F,  0.0F, 2.0F, 2.0F, 1.0F); }
		if(meta == 4){ this.setBlockBounds( 0.0F, 0.0F,  0.0F, 1.0F, 2.0F, 2.0F); }
		if(meta == 5){ this.setBlockBounds( 0.0F, 0.0F, -1.0F, 1.0F, 2.0F, 1.0F); }
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityplayer, ItemStack itemstack){
		int l = MathHelper.floor_double((double)(entityplayer.rotationYaw * 4.0F / 360.F) + 0.5D) & 3;
		if(l == 0){ world.setBlockMetadataWithNotify(x, y, z, 2, 2); }
		if(l == 1){ world.setBlockMetadataWithNotify(x, y, z, 5, 2); }
		if(l == 2){ world.setBlockMetadataWithNotify(x, y, z, 3, 2); }
		if(l == 3){ world.setBlockMetadataWithNotify(x, y, z, 4, 2); }
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
		if(world.isRemote){
			return true;
		}else if(!player.isSneaking()){
			TileEntitySewingStation entity = (TileEntitySewingStation) world.getTileEntity(x, y, z);
			if(entity != null){
				FMLNetworkHandler.openGui(player, AceCraft.instance, ShopKeeper.guiIDSewingStation, world, x, y, z);
			}
			return true;
		}else{
			return false;
		}
	}

}