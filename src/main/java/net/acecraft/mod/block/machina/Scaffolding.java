package net.acecraft.mod.block.machina;

import java.util.Iterator;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.tileentity.TileEntityBonfire;
import net.acecraft.mod.tileentity.TileEntityScaffolding;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class Scaffolding extends BlockContainer {
	
	public Scaffolding(Material material){
		super(material);
		this.setHardness(0.5F);
		this.setResistance(0.5F);
		this.setBlockBounds(1.0f/16*5, 0F, 0F, 1F, 1F, 1F);
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
		return new TileEntityScaffolding();
	}
	
	public void registerBlockIcons(IIconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5));
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityplayer, ItemStack itemstack){
		world.setBlockMetadataWithNotify(x, y, z, 0, 2);
		ScanForNeighbours(world, x, y, z);
	}
	
	@Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
    	ScanForNeighbours(world, x, y, z);
    }
	
	@Override
    public void onBlockAdded(World world, int x, int y, int z) {
    	world.setBlockMetadataWithNotify(x, y, z, 0, 2);
    	ScanForNeighbours(world, x, y, z);
    }
    
	@Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float floatX, float floatY, float floatZ){
		ScanForNeighbours(world, x, y, z);
    	if(world.isRemote){
			return true;
		}else if(!player.isSneaking()){
			if(player.getHeldItem() != null){
				ItemStack item = player.getHeldItem();
				if(item.getItem() instanceof ItemBlock){
					if(CheckForScaffolding(item.getItem())){
						return false;
					}
					ItemBlock block = (ItemBlock) item.getItem();
					world.removeTileEntity(x, y, z);
					block.placeBlockAt(item, player, world, x, y, z, DetermineOrientation(world, x, y, z, player), floatX, floatY, floatZ, item.getItemDamage());
					if(!player.capabilities.isCreativeMode){
						item.stackSize = item.stackSize - 1;
						player.setCurrentItemOrArmor(0, item);					
					}
				}
			return true;
			}
		}
		return true;
    }
	
	@Override
	public boolean isLadder(IBlockAccess world, int x, int y, int z, EntityLivingBase entity){
		return true;
	}
	
	private boolean CheckForScaffolding(Item item){
		if(item == new ItemStack(ShopKeeper.scaffoldingAcacia)    .getItem()) return true;
		if(item == new ItemStack(ShopKeeper.scaffoldingBigOak)    .getItem()) return true;
		if(item == new ItemStack(ShopKeeper.scaffoldingBirch)     .getItem()) return true;
		if(item == new ItemStack(ShopKeeper.scaffoldingJungle)    .getItem()) return true;
		if(item == new ItemStack(ShopKeeper.scaffoldingOak)       .getItem()) return true;
		if(item == new ItemStack(ShopKeeper.scaffoldingSpruce)    .getItem()) return true;
		if(item == new ItemStack(ShopKeeper.scaffoldingFruit)     .getItem()) return true;
		if(item == new ItemStack(ShopKeeper.scaffoldingGolden)    .getItem()) return true;
		if(item == new ItemStack(ShopKeeper.scaffoldingPalm)      .getItem()) return true;
		if(item == new ItemStack(ShopKeeper.scaffoldingAdamantium).getItem()) return true;
		if(item == new ItemStack(ShopKeeper.scaffoldingAluminium) .getItem()) return true;
		if(item == new ItemStack(ShopKeeper.scaffoldingBronze)    .getItem()) return true;
		if(item == new ItemStack(ShopKeeper.scaffoldingCopper)    .getItem()) return true;
		if(item == new ItemStack(ShopKeeper.scaffoldingIron)      .getItem()) return true;
		if(item == new ItemStack(ShopKeeper.scaffoldingMythril)   .getItem()) return true;
		if(item == new ItemStack(ShopKeeper.scaffoldingSteel)     .getItem()) return true;
		if(item == new ItemStack(ShopKeeper.scaffoldingUnobtanium).getItem()) return true;
		return false;
	}
	
    private static int DetermineOrientation(World world, int x, int y, int z, EntityLivingBase player){
        if (MathHelper.abs((float)player.posX - (float)x) < 2.0F && MathHelper.abs((float)player.posZ - (float)z) < 2.0F){
            double d0 = player.posY + 1.82D - (double)player.yOffset;
            if (d0 - (double)y > 2.0D){ return 1; }
            if ((double)y - d0 > 0.0D){ return 0; }
        }
        int l = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        return l == 0 ? 2 : (l == 1 ? 5 : (l == 2 ? 3 : (l == 3 ? 4 : 0)));
    }
    
    private void ScanForNeighbours(World world, int x, int y, int z){
    	int i = 0;
    	int s = 0;
    	boolean nn = false;
    	boolean ne = false;
    	boolean ee = false;
    	boolean se = false;
    	boolean ss = false;
    	boolean sw = false;
    	boolean ww = false;
    	boolean nw = false;
    	boolean tp = false;
    	if(world.getBlock(x  , y  , z-1) != Blocks.air) nn = true;
    	if(world.getBlock(x+1, y  , z-1) != Blocks.air) ne = true;
    	if(world.getBlock(x+1, y  , z  ) != Blocks.air) ee = true;
    	if(world.getBlock(x+1, y  , z+1) != Blocks.air) se = true;
    	if(world.getBlock(x  , y  , z+1) != Blocks.air) ss = true;
    	if(world.getBlock(x-1, y  , z+1) != Blocks.air) sw = true;
    	if(world.getBlock(x-1, y  , z  ) != Blocks.air) ww = true;
    	if(world.getBlock(x-1, y  , z-1) != Blocks.air) nw = true;
    	if(world.getBlock(x  , y+1, z  ) == Blocks.air) tp = true;
    	     if( nn &&  ne &&  ee &&  se &&  ss &&  sw &&  ww &&  nw){ i = 14; s = 0; }
    	else if( nn &&  ne &&  ee &&  se &&  ss && !sw &&  ww &&  nw){ i = 13; s = 0; }
    	else if( nn &&  ne &&  ee &&  se &&  ss &&  sw &&  ww && !nw){ i = 13; s = 1; }
    	else if( nn && !ne &&  ee &&  se &&  ss &&  sw &&  ww &&  nw){ i = 13; s = 2; }
    	else if( nn &&  ne &&  ee && !se &&  ss &&  sw &&  ww &&  nw){ i = 13; s = 3; }
    	else if( nn &&  ne &&  ee && !se &&  ss && !sw &&  ww &&  nw){ i = 12; s = 0; }
    	else if( nn &&  ne &&  ee &&  se &&  ss && !sw &&  ww && !nw){ i = 12; s = 1; }
    	else if( nn && !ne &&  ee &&  se &&  ss &&  sw &&  ww && !nw){ i = 12; s = 2; }
    	else if( nn && !ne &&  ee && !se &&  ss &&  sw &&  ww &&  nw){ i = 12; s = 3; }
    	else if( nn &&  ne &&  ee && !se && !ss && !sw &&  ww &&  nw){ i = 11; s = 0; }
    	else if( nn &&  ne &&  ee &&  se &&  ss && !sw && !ww && !nw){ i = 11; s = 1; }
    	else if(!nn && !ne &&  ee &&  se &&  ss &&  sw &&  ww && !nw){ i = 11; s = 2; }
    	else if( nn && !ne && !ee && !se &&  ss &&  sw &&  ww &&  nw){ i = 11; s = 3; }
    	else if( nn &&  ne &&  ee && !se &&  ss &&  sw &&  ww && !nw){ i = 10; s = 0; }
    	else if( nn && !ne &&  ee &&  se &&  ss && !sw &&  ww &&  nw){ i = 10; s = 1; }
    	else if( nn &&  ne &&  ee && !se &&  ss && !sw &&  ww && !nw){ i =  9; s = 0; }
    	else if( nn && !ne &&  ee &&  se &&  ss && !sw &&  ww && !nw){ i =  9; s = 1; }
    	else if( nn && !ne &&  ee && !se &&  ss &&  sw &&  ww && !nw){ i =  9; s = 2; }
    	else if( nn && !ne &&  ee && !se &&  ss && !sw &&  ww &&  nw){ i =  9; s = 3; }
    	else if( nn &&  ne &&  ee && !se &&  ss && !sw && !ww && !nw){ i =  8; s = 0; }
    	else if(!nn && !ne &&  ee &&  se &&  ss && !sw &&  ww && !nw){ i =  8; s = 1; }
    	else if( nn && !ne && !ee && !se &&  ss &&  sw &&  ww && !nw){ i =  8; s = 2; }
    	else if( nn && !ne &&  ee && !se && !ss && !sw &&  ww &&  nw){ i =  8; s = 3; }
    	else if( nn &&  ne &&  ee && !se && !ss && !sw &&  ww && !nw){ i =  7; s = 0; }
    	else if( nn && !ne &&  ee &&  se &&  ss && !sw && !ww && !nw){ i =  7; s = 1; }
    	else if(!nn && !ne &&  ee && !se &&  ss &&  sw &&  ww && !nw){ i =  7; s = 2; }
    	else if( nn && !ne && !ee && !se &&  ss && !sw &&  ww &&  nw){ i =  7; s = 3; }
    	else if( nn &&  ne &&  ee && !se && !ss && !sw && !ww && !nw){ i =  6; s = 0; }
    	else if(!nn && !ne &&  ee &&  se &&  ss && !sw && !ww && !nw){ i =  6; s = 1; }
    	else if(!nn && !ne && !ee && !se &&  ss &&  sw &&  ww && !nw){ i =  6; s = 2; }
    	else if( nn && !ne && !ee && !se && !ss && !sw &&  ww &&  nw){ i =  6; s = 3; }
    	else if( nn && !ne &&  ee && !se &&  ss && !sw &&  ww && !nw){ i =  5; s = 0; }
    	else if( nn && !ne &&  ee && !se && !ss && !sw &&  ww && !nw){ i =  4; s = 0; }
    	else if( nn && !ne &&  ee && !se &&  ss && !sw && !ww && !nw){ i =  4; s = 1; }
    	else if(!nn && !ne &&  ee && !se &&  ss && !sw &&  ww && !nw){ i =  4; s = 2; }
    	else if( nn && !ne && !ee && !se &&  ss && !sw &&  ww && !nw){ i =  4; s = 3; }
    	else if( nn && !ne &&  ee && !se && !ss && !sw && !ww && !nw){ i =  3; s = 0; }
    	else if(!nn && !ne &&  ee && !se &&  ss && !sw && !ww && !nw){ i =  3; s = 1; }
    	else if(!nn && !ne && !ee && !se &&  ss && !sw &&  ww && !nw){ i =  3; s = 2; }
    	else if( nn && !ne && !ee && !se && !ss && !sw &&  ww && !nw){ i =  3; s = 3; }
    	else if( nn && !ne && !ee && !se &&  ss && !sw && !ww && !nw){ i =  2; s = 0; }
    	else if(!nn && !ne &&  ee && !se && !ss && !sw &&  ww && !nw){ i =  2; s = 1; }
    	else if( nn && !ne && !ee && !se && !ss && !sw && !ww && !nw){ i =  1; s = 0; }
    	else if(!nn && !ne &&  ee && !se && !ss && !sw && !ww && !nw){ i =  1; s = 1; }
    	else if(!nn && !ne && !ee && !se &&  ss && !sw && !ww && !nw){ i =  1; s = 2; }
    	else if(!nn && !ne && !ee && !se && !ss && !sw &&  ww && !nw){ i =  1; s = 3; }
    	TileEntityScaffolding entity = (TileEntityScaffolding) world.getTileEntity(x, y, z);
    	entity.SubmitData(i, s, tp);
    }
    
}