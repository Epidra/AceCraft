package net.acecraft.mod.block.machina;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.tileentity.TileEntityAxle;
import net.acecraft.mod.tileentity.TileEntityGearBox;
import net.acecraft.mod.tileentity.TileEntityMotor;
import net.acecraft.mod.tileentity.TileEntityTurbine;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Axle extends BlockContainer {
	
	public Axle(){
		super(Material.wood);
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
		return new TileEntityAxle();
	}
	
	public void registerBlockIcons(IIconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5));
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z){
		int meta = world.getBlockMetadata(x, y, z);
		if(meta == 0){ this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 1.0F, 0.7F); }
		if(meta == 1){ this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 1.0F, 0.7F); }
		if(meta == 2){ this.setBlockBounds(0.3F, 0.3F, 0.0F, 0.7F, 0.7F, 1.0F); }
		if(meta == 3){ this.setBlockBounds(0.3F, 0.3F, 0.0F, 0.7F, 0.7F, 1.0F); }
		if(meta == 4){ this.setBlockBounds(0.0F, 0.3F, 0.3F, 1.0F, 0.7F, 0.7F); }
		if(meta == 5){ this.setBlockBounds(0.0F, 0.3F, 0.3F, 1.0F, 0.7F, 0.7F); }
	}
	
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack){
    	boolean abort = true;
        int meta = determineOrientation(world, x, y, z, player);
        if(meta == 0){ checkForNeighbour(world, x, y, z,  0, +1,  0, meta); }
        if(meta == 1){ checkForNeighbour(world, x, y, z,  0, -1,  0, meta); }
        if(meta == 2){ checkForNeighbour(world, x, y, z,  0,  0, +1, meta); }
        if(meta == 3){ checkForNeighbour(world, x, y, z,  0,  0, -1, meta); }
        if(meta == 4){ checkForNeighbour(world, x, y, z, +1,  0,  0, meta); }
        if(meta == 5){ checkForNeighbour(world, x, y, z, -1,  0,  0, meta); }
        if(meta == 99){
        	world.setBlockToAir(x, y, z);
			this.dropBlockAsItem(world, x, y, z, new ItemStack(this, 1, 0));
        }else{
        	world.setBlockMetadataWithNotify(x, y, z, meta, 2);
            TileEntityAxle entity = (TileEntityAxle) world.getTileEntity(x, y, z);
            entity.firstSetUp(meta, 0);
        }
    }
    
	private int checkForNeighbour(World world, int wX, int wY, int wZ, int dirX, int dirY, int dirZ, int meta){
		if(world.getBlock(wX+dirX, wY+dirY, wZ+dirZ).equals(ShopKeeper.machinaGearBox)){
    		TileEntityGearBox entityG = (TileEntityGearBox) world.getTileEntity(wX+dirX, wY+dirY, wZ+dirZ);
    		if(entityG.meta != meta) return revertMeta(meta);
    		return meta;
    	}
    	if(world.getBlock(wX+dirX, wY+dirY, wZ+dirZ).equals(ShopKeeper.machinaTurbine)){
    		TileEntityTurbine entityT = (TileEntityTurbine) world.getTileEntity(wX+dirX, wY+dirY, wZ+dirZ);
    		if(entityT.metaOut == meta) return revertMeta(meta);
    		return meta;
    	}
    	if(world.getBlock(wX+dirX, wY+dirY, wZ+dirZ).equals(ShopKeeper.machinaMotor)){
    		TileEntityMotor entityM = (TileEntityMotor) world.getTileEntity(wX+dirX, wY+dirY, wZ+dirZ);
    		if(entityM.meta == meta) return revertMeta(meta);
    		return meta;
    	}
    	if(world.getBlock(wX+dirX, wY+dirY, wZ+dirZ).equals(ShopKeeper.machinaAxle)){
    		TileEntityAxle entityA = (TileEntityAxle) world.getTileEntity(wX+dirX, wY+dirY, wZ+dirZ);
    		if(entityA.meta == revertMeta(meta)) return revertMeta(meta);
    		return meta;
    	}
		return 99;
	}
    
    public static int determineOrientation(World world, int x, int y, int z, EntityLivingBase player) {
        if (MathHelper.abs((float)player.posX - (float)x) < 2.0F && MathHelper.abs((float)player.posZ - (float)z) < 2.0F) {
            double d0 = player.posY + 1.82D - (double)player.yOffset;
            if (d0 - (double)y > 2.0D){ return 1; }
            if ((double)y - d0 > 0.0D){ return 0; }
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