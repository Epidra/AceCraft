package net.acecraft.mod.block.machina;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.tileentity.TileEntityAnvil;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Anvil extends BlockContainer {
	
	public Anvil(){
		super(Material.anvil);
		this.setHardness(2.0F);
		this.setResistance(2.0F);
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
		return new TileEntityAnvil();
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z){
		int meta = world.getBlockMetadata(x, y, z);
		if(meta == 2){ this.setBlockBounds(-0.4F, 0.0F, 0.2F, 1.4F, 1.1F, 0.8F); }
		if(meta == 3){ this.setBlockBounds(-0.4F, 0.0F, 0.2F, 1.4F, 1.1F, 0.8F); }
		if(meta == 4){ this.setBlockBounds(0.2F, 0.0F, -0.4F, 0.8F, 1.1F, 1.4F); }
		if(meta == 5){ this.setBlockBounds(0.2F, 0.0F, -0.4F, 0.8F, 1.1F, 1.4F); }
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityplayer, ItemStack itemstack){
		int l = MathHelper.floor_double((double)(entityplayer.rotationYaw * 4.0F / 360.F) + 0.5D) & 3;
		if(l == 0){ world.setBlockMetadataWithNotify(x, y, z, 2, 2); }
		if(l == 1){ world.setBlockMetadataWithNotify(x, y, z, 5, 2); }
		if(l == 2){ world.setBlockMetadataWithNotify(x, y, z, 3, 2); }
		if(l == 3){ world.setBlockMetadataWithNotify(x, y, z, 4, 2); }
		world.playSound((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), "random.anvil_land", 1.0F, 0.3F, false);
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
		if(world.isRemote){
			return true;
		}else if(!player.isSneaking()){
			TileEntityAnvil entity = (TileEntityAnvil) world.getTileEntity(x, y, z);
			if(entity != null){
				if(player.getCurrentEquippedItem() == null){
					FMLNetworkHandler.openGui(player, AceCraft.instance, ShopKeeper.guiIDAnvilCrafting, world, x, y, z);
				}else
				if(player.getCurrentEquippedItem().isItemStackDamageable()){
					FMLNetworkHandler.openGui(player, AceCraft.instance, ShopKeeper.guiIDAnvilRepair, world, x, y, z);
				}else{
					FMLNetworkHandler.openGui(player, AceCraft.instance, ShopKeeper.guiIDAnvilCrafting, world, x, y, z);
				}
			}
			return true;
		}else{
			return false;
		}
	}

}