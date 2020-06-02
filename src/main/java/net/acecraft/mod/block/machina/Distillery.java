package net.acecraft.mod.block.machina;

import java.util.Random;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.tileentity.TileEntityDistillery;
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

public class Distillery extends BlockContainer {
	
	public static final int[][] field_a = new int[][] {{0, 1}, { -1, 0}, {0, -1}, {1, 0}};
	 @SideOnly(Side.CLIENT)
	 private IIcon[] field_b;
	 @SideOnly(Side.CLIENT)
	 private IIcon[] field_M;
	 @SideOnly(Side.CLIENT)
	 private IIcon[] field_N;
	 private static final String __OBFID = "CL_00000198";
	
	private final boolean isActive;
	
	private static boolean keepInventory = true;
	private Random rand = new Random();
	
	public Distillery(Boolean isActive){
		super(Material.rock);
		this.setHardness(5.0F);
		this.isActive = isActive;
	}
	
	public static int getDirection(int side){
		return side & 3;
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z){
		int meta = world.getBlockMetadata(x, y, z);
		if(meta == 2){ this.setBlockBounds( 0.0F, 0.0F,  0.0F, 2.0F, 1.8F, 1.0F); }
		if(meta == 3){ this.setBlockBounds(-1.0F, 0.0F,  0.0F, 1.0F, 1.8F, 1.0F); }
		if(meta == 4){ this.setBlockBounds( 0.0F, 0.0F, -1.0F, 0.0F, 1.8F, 1.0F); }
		if(meta == 5){ this.setBlockBounds( 0.0F, 0.0F,  0.0F, 0.8F, 1.8F, 2.0F); }
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5));
	}
	
	public Item getItemDropped(int i, Random random, int j){
		return Item.getItemFromBlock(ShopKeeper.machinaDistilleryIdle);
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
		if(world.isRemote){
			return true;
		}else if(!player.isSneaking()){
			ItemStack item = player.getHeldItem();
			if(item != null){
				TileEntityDistillery entity = (TileEntityDistillery) world.getTileEntity(x, y, z);
				if(entity != null){
					FMLNetworkHandler.openGui(player, AceCraft.instance, ShopKeeper.guiIDDistillery, world, x, y, z);
				}
				return true;
			}
		}else{
			return true;
		}
		return isActive;
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
		return new TileEntityDistillery();
	}
	
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random){
		if(this.isActive){
			int direction = world.getBlockMetadata(x, y, z);
			float x1 = (float)x + random.nextFloat();
			float y1 = (float)y + 0.1F;
			float z1 = (float)z + random.nextFloat();
			float f = 0;
			float f1 = random.nextFloat() * 0.6F - 0.3F;
			world.spawnParticle("smoke", (double)(x1 - f), (double)(y1), (double)(z1 + f1), 0D, 0D, 0D);
			world.spawnParticle("flame", (double)(x1 - f), (double)(y1), (double)(z1 + f1), 0D, 0D, 0D);
		}
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityplayer, ItemStack itemstack){
		int l = MathHelper.floor_double((double)(entityplayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		if(l == 0){ world.setBlockMetadataWithNotify(x, y, z, 2, 2); }
		if(l == 1){ world.setBlockMetadataWithNotify(x, y, z, 5, 2); }
		if(l == 2){ world.setBlockMetadataWithNotify(x, y, z, 3, 2); }
		if(l == 3){ world.setBlockMetadataWithNotify(x, y, z, 4, 2); }
	}
	
	public static void updateBonfireBlockState(boolean active, World worldObj, int xCoord, int yCoord, int zCoord){
		int i = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
		TileEntity tileentity = worldObj.getTileEntity(xCoord, yCoord, zCoord);
		keepInventory = true;
		if(active){
			worldObj.setBlock(xCoord, yCoord, zCoord, ShopKeeper.machinaDistilleryActive);
		}else{
			worldObj.setBlock(xCoord, yCoord, zCoord, ShopKeeper.machinaDistilleryIdle);
		}
		keepInventory = false;
		worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);
		if(tileentity != null){
			tileentity.validate();
			worldObj.setTileEntity(xCoord, yCoord, zCoord, tileentity);
		}
	}
	
	public static void func_149979_a(World p_149979_0_, int p_149979_1_, int p_149979_2_, int p_149979_3_, boolean p_149979_4_){
		int l = p_149979_0_.getBlockMetadata(p_149979_1_, p_149979_2_, p_149979_3_);
		if (p_149979_4_){
			l |= 4;
		}else{
			l &= -5;
		}
		p_149979_0_.setBlockMetadataWithNotify(p_149979_1_, p_149979_2_, p_149979_3_, l, 4);
	}
	
	public void breakBlock(World world, int x, int y, int z, Block oldblock, int oldMetadata){
		if(!keepInventory){
			TileEntityDistillery tileentity = (TileEntityDistillery) world.getTileEntity(x, y, z);
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
		return Item.getItemFromBlock(ShopKeeper.machinaDistilleryIdle);
	}

}