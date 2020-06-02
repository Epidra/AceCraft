package net.acecraft.mod.block.machina;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.tileentity.TileEntityAnvil;
import net.acecraft.mod.tileentity.TileEntityAxle;
import net.acecraft.mod.tileentity.TileEntityGearBox;
import net.acecraft.mod.tileentity.TileEntityPipeStraight;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class PipeStraight extends BlockContainer {
	
	public PipeStraight(){
		super(Material.iron);
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
		return new TileEntityPipeStraight();
	}
	
	public void registerBlockIcons(IIconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5));
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z){
		int meta = world.getBlockMetadata(x, y, z);
		if(meta == 0){ this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 1.0F, 0.8F); }
		if(meta == 1){ this.setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 1.0F, 0.8F); }
		if(meta == 2){ this.setBlockBounds(0.2F, 0.2F, 0.0F, 0.8F, 0.8F, 1.0F); }
		if(meta == 3){ this.setBlockBounds(0.2F, 0.2F, 0.0F, 0.8F, 0.8F, 1.0F); }
		if(meta == 4){ this.setBlockBounds(0.0F, 0.2F, 0.2F, 1.0F, 0.8F, 0.8F); }
		if(meta == 5){ this.setBlockBounds(0.0F, 0.2F, 0.2F, 1.0F, 0.8F, 0.8F); }
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
		if(player.getCurrentEquippedItem() == null){
			TileEntityPipeStraight entity = (TileEntityPipeStraight)world.getTileEntity(x, y, z);
			entity.turnPipe();
		}
		return false;
	}
	
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack){
    	boolean abort = true;
        int meta = determineOrientation(world, x, y, z, player);
        world.setBlockMetadataWithNotify(x, y, z, meta, 2);
        TileEntityPipeStraight entity = (TileEntityPipeStraight) world.getTileEntity(x, y, z);
        entity.firstSetUp(meta, 0);
    }
    
    public static int determineOrientation(World world, int x, int y, int z, EntityLivingBase player){
    	if(MathHelper.abs((float)player.posX - (float)x) < 2.0F && MathHelper.abs((float)player.posZ - (float)z) < 2.0F){
            double d0 = player.posY + 1.82D - (double)player.yOffset;
            if(d0 - (double)y > 2.0D){
                return 1;
            }
            if((double)y - d0 > 0.0D){
                return 0;
            }
        }
        int l = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        return l == 0 ? 2 : (l == 1 ? 5 : (l == 2 ? 3 : (l == 3 ? 4 : 0)));
    }
	
    private static int revertMeta(int i){
    	if(i == 0) return 1;
    	if(i == 1) return 0;
    	if(i == 2) return 3;
    	if(i == 3) return 2;
    	if(i == 4) return 5;
    	if(i == 5) return 4;
    	return i;
    }

}