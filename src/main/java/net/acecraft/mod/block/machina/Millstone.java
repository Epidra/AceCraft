package net.acecraft.mod.block.machina;

import java.util.Random;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.tileentity.TileEntityAxle;
import net.acecraft.mod.tileentity.TileEntityGearBox;
import net.acecraft.mod.tileentity.TileEntityMillstone;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Millstone extends BlockContainer {
	
	public static final int[][] field_a = new int[][] {{0, 1}, { -1, 0}, {0, -1}, {1, 0}};
	 @SideOnly(Side.CLIENT)
	 private IIcon[] field_b;
	 @SideOnly(Side.CLIENT)
	 private IIcon[] field_M;
	 @SideOnly(Side.CLIENT)
	 private IIcon[] field_N;
	 private static final String __OBFID = "CL_00000198";
	
	private static boolean keepInventory = true;
	private Random rand = new Random();
	
	public Millstone(){
		super(Material.rock);
		this.setHardness(5.0F);
		this.setCreativeTab(ShopKeeper.acetabMachina);
		this.setBlockBounds(-1F, 0F, -1F, 2F, 3F, 2F);
	}
	
   public static int getDirection(int side){
       return side & 3;
   }
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5));
	}
	
	public Item getItemDropped(int i, Random random, int j){
		return Item.getItemFromBlock(ShopKeeper.machinaMillstone);
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
		if(world.isRemote){
			return true;
		}else if(!player.isSneaking()){
			FMLNetworkHandler.openGui(player, AceCraft.instance, ShopKeeper.guiIDMillstone, world, x, y, z);
			return true;
		}
		return false;
	}
	
	public static boolean func_149976_c(int p_149976_0_){
       return (p_149976_0_ & 4) != 0;
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
		return new TileEntityMillstone();
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityplayer, ItemStack itemstack){
		int l = MathHelper.floor_double((double)(entityplayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		if(l == 0){ world.setBlockMetadataWithNotify(x, y, z, 2, 2); }
		if(l == 1){ world.setBlockMetadataWithNotify(x, y, z, 5, 2); }
		if(l == 2){ world.setBlockMetadataWithNotify(x, y, z, 3, 2); }
		if(l == 3){ world.setBlockMetadataWithNotify(x, y, z, 4, 2); }
		int e = 0;
		if(world.getBlock(x, y+3, z) == ShopKeeper.machinaAxle){
			TileEntityAxle entityA = (TileEntityAxle) world.getTileEntity(x, y+3, z);
			e = entityA.energy;
		}
		if(world.getBlock(x, y+3, z) == ShopKeeper.machinaGearBox){
			TileEntityGearBox entityG = (TileEntityGearBox) world.getTileEntity(x, y+3, z);
			e = entityG.energy;
		}
		((TileEntityMillstone)world.getTileEntity(x, y, z)).firstSetUp(l, e);
	}
	
	public static void func_149979_a(World p_149979_0_, int p_149979_1_, int p_149979_2_, int p_149979_3_, boolean p_149979_4_){
		int l = p_149979_0_.getBlockMetadata(p_149979_1_, p_149979_2_, p_149979_3_);
		if(p_149979_4_){
			l |= 4;
		}else{
			l &= -5;
		}
		p_149979_0_.setBlockMetadataWithNotify(p_149979_1_, p_149979_2_, p_149979_3_, l, 4);
	}
	
	public void breakBlock(World world, int x, int y, int z, Block oldblock, int oldMetadata){
		if(!keepInventory){
			TileEntityMillstone tileentity = (TileEntityMillstone) world.getTileEntity(x, y, z);
			if(tileentity != null){
				for(int i = 0; i < tileentity.getSizeInventory(); i++){
					ItemStack itemstack = tileentity.getStackInSlot(i);
					if(itemstack != null){
						float f  = this.rand.nextFloat() * 0.8F + 0.1F;
						float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
						float f2 = this.rand.nextFloat() * 0.8F + 0.1F;
						while(itemstack.stackSize > 0){
							int j = this.rand.nextInt(21) + 10;
							if(j > itemstack.stackSize){
								j = itemstack.stackSize;
							}
							itemstack.stackSize -= j;
							EntityItem item = new EntityItem(world, (double)((float)x + f), (double)((float)x + f1), (double)((float)x + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));
							if(itemstack.hasTagCompound()){
								item.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
							}
							world.spawnEntityInWorld(item);
						}
					}
				}
				world.func_147453_f(x, y, z, oldblock);
			}
		}
		super.breakBlock(world, x, y, z, oldblock, oldMetadata);
	}
	
	public Item getItem(World world, int x, int y, int z){
		return Item.getItemFromBlock(ShopKeeper.machinaMillstone);
	}

}