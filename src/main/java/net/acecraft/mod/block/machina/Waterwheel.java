package net.acecraft.mod.block.machina;

import java.util.Random;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.tileentity.TileEntityGearBox;
import net.acecraft.mod.tileentity.TileEntityWaterwheel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Waterwheel extends BlockContainer {
	
	public Waterwheel(){
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
		return new TileEntityWaterwheel();
	}
	
	public void registerBlockIcons(IIconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5));
	}
	
	public Item getItemDropped(int i, Random random, int j){
		return Item.getItemFromBlock(ShopKeeper.machinaWaterwheel);
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z){
		int meta = world.getBlockMetadata(x, y, z);
		if(meta == 2){ this.setBlockBounds(-1.5F, -1.5F,  0.0F, 2.5F, 2.5F, 1.0F); }
		if(meta == 3){ this.setBlockBounds(-1.5F, -1.5F,  0.0F, 2.5F, 2.5F, 1.0F); }
		if(meta == 4){ this.setBlockBounds( 0.0F, -1.5F, -1.5F, 1.0F, 2.5F, 2.5F); }
		if(meta == 5){ this.setBlockBounds( 0.0F, -1.5F, -1.5F, 1.0F, 2.5F, 2.5F); }
	}
	
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack){
        int meta = determineOrientation(world, x, y, z, player);
        world.setBlockMetadataWithNotify(x, y, z, meta, 2);
        TileEntityWaterwheel entity = (TileEntityWaterwheel) world.getTileEntity(x, y, z);
        entity.firstSetUp(meta, searchWater(world, x, y, z, meta));
        TileEntityGearBox entityG = null;
        if(2 == meta){ if(world.getBlock(x, y, z+1).equals(ShopKeeper.machinaGearBox)){ entityG = (TileEntityGearBox) world.getTileEntity(x, y, z+1); } }
        if(3 == meta){ if(world.getBlock(x, y, z-1).equals(ShopKeeper.machinaGearBox)){ entityG = (TileEntityGearBox) world.getTileEntity(x, y, z-1); } }
        if(4 == meta){ if(world.getBlock(x+1, y, z).equals(ShopKeeper.machinaGearBox)){ entityG = (TileEntityGearBox) world.getTileEntity(x+1, y, z); } }
        if(5 == meta){ if(world.getBlock(x-1, y, z).equals(ShopKeeper.machinaGearBox)){ entityG = (TileEntityGearBox) world.getTileEntity(x-1, y, z); } }
        if(entityG != null){
        	if(entityG.meta != meta){
            	world.setBlockToAir(x, y, z);
    			this.dropBlockAsItem(world, x, y, z, new ItemStack(this, 1, 0));
            }
        }else{
        	world.setBlockToAir(x, y, z);
			this.dropBlockAsItem(world, x, y, z, new ItemStack(this, 1, 0));
        }
    }
    
    public static int determineOrientation(World world, int x, int y, int z, EntityLivingBase player){
        if(MathHelper.abs((float)player.posX - (float)x) < 2.0F && MathHelper.abs((float)player.posZ - (float)z) < 2.0F){
            double d0 = player.posY + 1.82D - (double)player.yOffset;
            if(d0 - (double)y > 2.0D){ return 1; }
            if((double)y - d0 > 0.0D){ return 0; }
        }
        int l = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        return l == 0 ? 2 : (l == 1 ? 5 : (l == 2 ? 3 : (l == 3 ? 4 : 0)));
    }
	
	private int searchWater(World world, int x, int y, int z, int meta){
		int energy = 0;
		if(meta == 2){
			if(world.getBlock(x-1, y-2, z).equals(Blocks.water) || world.getBlock(x-1, y-2, z).equals(Blocks.flowing_water)) energy = energy + 17;
			if(world.getBlock(x  , y-2, z).equals(Blocks.water) || world.getBlock(x  , y-2, z).equals(Blocks.flowing_water)) energy = energy + 27;
			if(world.getBlock(x+1, y-2, z).equals(Blocks.water) || world.getBlock(x+1, y-2, z).equals(Blocks.flowing_water)) energy = energy + 17;
			if(world.getBlock(x+2, y-1, z).equals(Blocks.water) || world.getBlock(x+2, y-1, z).equals(Blocks.flowing_water)) energy = energy + 17;
			if(world.getBlock(x+2, y  , z).equals(Blocks.water) || world.getBlock(x+2, y  , z).equals(Blocks.flowing_water)) energy = energy + 27;
			if(world.getBlock(x+2, y+1, z).equals(Blocks.water) || world.getBlock(x+2, y+1, z).equals(Blocks.flowing_water)) energy = energy + 17;
		}
		if(meta == 3){
			if(world.getBlock(x+1, y-2, z).equals(Blocks.water) || world.getBlock(x+1, y-2, z).equals(Blocks.flowing_water)) energy = energy + 17;
			if(world.getBlock(x  , y-2, z).equals(Blocks.water) || world.getBlock(x  , y-2, z).equals(Blocks.flowing_water)) energy = energy + 27;
			if(world.getBlock(x-1, y-2, z).equals(Blocks.water) || world.getBlock(x-1, y-2, z).equals(Blocks.flowing_water)) energy = energy + 17;
			if(world.getBlock(x-2, y-1, z).equals(Blocks.water) || world.getBlock(x-2, y-1, z).equals(Blocks.flowing_water)) energy = energy + 17;
			if(world.getBlock(x-2, y  , z).equals(Blocks.water) || world.getBlock(x-2, y  , z).equals(Blocks.flowing_water)) energy = energy + 27;
			if(world.getBlock(x-2, y+1, z).equals(Blocks.water) || world.getBlock(x-2, y+1, z).equals(Blocks.flowing_water)) energy = energy + 17;
		}
		if(meta == 4){
			if(world.getBlock(x, y-2, z+1).equals(Blocks.water) || world.getBlock(x, y-2, z+1).equals(Blocks.flowing_water)) energy = energy + 17;
			if(world.getBlock(x, y-2, z  ).equals(Blocks.water) || world.getBlock(x, y-2, z  ).equals(Blocks.flowing_water)) energy = energy + 27;
			if(world.getBlock(x, y-2, z-1).equals(Blocks.water) || world.getBlock(x, y-2, z-1).equals(Blocks.flowing_water)) energy = energy + 17;
			if(world.getBlock(x, y-1, z-2).equals(Blocks.water) || world.getBlock(x, y-1, z-2).equals(Blocks.flowing_water)) energy = energy + 17;
			if(world.getBlock(x, y  , z-2).equals(Blocks.water) || world.getBlock(x, y  , z-2).equals(Blocks.flowing_water)) energy = energy + 27;
			if(world.getBlock(x, y+1, z-2).equals(Blocks.water) || world.getBlock(x, y+2, z-2).equals(Blocks.flowing_water)) energy = energy + 17;
		}
		if(meta == 5){
			if(world.getBlock(x, y-2, z-1).equals(Blocks.water) || world.getBlock(x, y-2, z-1).equals(Blocks.flowing_water)) energy = energy + 17;
			if(world.getBlock(x, y-2, z  ).equals(Blocks.water) || world.getBlock(x, y-2, z  ).equals(Blocks.flowing_water)) energy = energy + 27;
			if(world.getBlock(x, y-2, z+1).equals(Blocks.water) || world.getBlock(x, y-2, z+1).equals(Blocks.flowing_water)) energy = energy + 17;
			if(world.getBlock(x, y-1, z+2).equals(Blocks.water) || world.getBlock(x, y-1, z+2).equals(Blocks.flowing_water)) energy = energy + 17;
			if(world.getBlock(x, y  , z+2).equals(Blocks.water) || world.getBlock(x, y  , z+2).equals(Blocks.flowing_water)) energy = energy + 27;
			if(world.getBlock(x, y+1, z+2).equals(Blocks.water) || world.getBlock(x, y+2, z+2).equals(Blocks.flowing_water)) energy = energy + 17;
		}
		return energy;
	}

}