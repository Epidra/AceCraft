package net.acecraft.mod.block.machina;

import java.util.List;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.tileentity.TileEntityRoof;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Roof extends BlockContainer {
	
	public Roof(Material material){
		super(material);
		this.setHardness(2.0F);
		this.setResistance(2.0F);
		this.setBlockBounds(0F, 0F, 0F, 1F, 1F, 1F);
		this.setCreativeTab(ShopKeeper.acetabRoof);
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
		return new TileEntityRoof();
	}
	
    public int damageDropped(int damage){
        return damage;
    }
    
	public void registerBlockIcons(IIconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5));
	}
	
    public static int determineOrientation(World world, int x, int y, int z, EntityLivingBase player){
        if(MathHelper.abs((float)player.posX - (float)x) < 2.0F && MathHelper.abs((float)player.posZ - (float)z) < 2.0F){
            double d0 = player.posY + 1.82D - (double)player.yOffset;
        }
        int l = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        return l == 0 ? 2 : (l == 1 ? 5 : (l == 2 ? 3 : (l == 3 ? 4 : 0)));
    }
    
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityplayer, ItemStack itemstack){
		int meta = determineOrientation(world, x, y, z, entityplayer);
        world.setBlockMetadataWithNotify(x, y, z, itemstack.getItemDamage(), 2);
		TileEntityRoof entity = (TileEntityRoof) world.getTileEntity(x, y, z);
        entity.firstSetUp(meta, this.getUnlocalizedName().substring(5));
	}

}