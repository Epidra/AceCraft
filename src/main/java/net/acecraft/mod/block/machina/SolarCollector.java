package net.acecraft.mod.block.machina;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.tileentity.TileEntitySolarCollector;
import net.acecraft.mod.tileentity.TileEntityTurbine;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class SolarCollector extends BlockContainer {
	
	public SolarCollector(){
		super(Material.iron);
		this.setHardness(2.0F);
		this.setResistance(2.0F);
		this.setBlockBounds(0F, 0F, 0F, 1F, 3F, 1F);
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
		return new TileEntitySolarCollector();
	}
	
	public void registerBlockIcons(IIconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5));
	}
	
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack){
    	boolean abort = true;
        int meta = 0;
        world.setBlockMetadataWithNotify(x, y, z, meta, 2);
        TileEntitySolarCollector entity = (TileEntitySolarCollector) world.getTileEntity(x, y, z);
        entity.firstSetUp(meta, 0);
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