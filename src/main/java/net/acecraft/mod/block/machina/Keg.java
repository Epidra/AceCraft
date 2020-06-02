package net.acecraft.mod.block.machina;

import java.util.Random;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.tileentity.TileEntityBonfire;
import net.acecraft.mod.tileentity.TileEntityKeg;
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

public class Keg extends BlockContainer {
	
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
	
	public Keg(){
		super(Material.wood);
		this.setHardness(5.0F);
		this.isActive = true;
		this.setCreativeTab(ShopKeeper.acetabMachina);
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z){
		int meta = world.getBlockMetadata(x, y, z);
		if(meta == 2){ this.setBlockBounds(-0.2F, 0.0F,  0.0F, 1.2F, 1.5F, 2.0F); }
		if(meta == 3){ this.setBlockBounds(-0.2F, 0.0F, -1.0F, 1.2F, 1.5F, 1.0F); }
		if(meta == 4){ this.setBlockBounds( 0.0F, 0.0F, -0.2F, 2.0F, 1.5F, 1.2F); }
		if(meta == 5){ this.setBlockBounds(-1.0F, 0.0F, -0.2F, 1.0F, 1.5F, 1.2F); }
	}
	
	public static int getDirection(int side){
		return side & 3;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5));
	}
	
	public Item getItemDropped(int i, Random random, int j){
		return Item.getItemFromBlock(ShopKeeper.machinaKeg);
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
		if(world.isRemote){
			return true;
		}else if(!player.isSneaking()){
			ItemStack item1 = player.getHeldItem();
				TileEntityKeg entity = (TileEntityKeg) world.getTileEntity(x, y, z);
				if(entity != null){
					if(item1 != null){
						Item item2 = entity.updateFillState(item1.getItem());
						if(item1.stackSize > 1){
							player.setCurrentItemOrArmor(0, new ItemStack(item1.getItem(), item1.stackSize-1));
							player.inventory.addItemStackToInventory(new ItemStack(item2));
						}
						if(item2 != null){
							player.setCurrentItemOrArmor(0, new ItemStack(item2, 1));
						}
					}else{
						FMLNetworkHandler.openGui(player, AceCraft.instance, ShopKeeper.guiIDKeg, world, x, y, z);
					}
				}
				return true;
			}
		return true;
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
		return new TileEntityKeg();
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityplayer, ItemStack itemstack){
		int l = MathHelper.floor_double((double)(entityplayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		if(l == 0){ world.setBlockMetadataWithNotify(x, y, z, 2, 2); }
		if(l == 1){ world.setBlockMetadataWithNotify(x, y, z, 5, 2); }
		if(l == 2){ world.setBlockMetadataWithNotify(x, y, z, 3, 2); }
		if(l == 3){ world.setBlockMetadataWithNotify(x, y, z, 4, 2); }
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
			TileEntityKeg tileentity = (TileEntityKeg) world.getTileEntity(x, y, z);
			if(tileentity != null){
				if(0 == tileentity.getContent().compareTo("Cheese")){
					float f  = this.rand.nextFloat() * 0.8F + 0.1F;
					float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
					float f2 = this.rand.nextFloat() * 0.8F + 0.1F;
					ItemStack itemstack = new ItemStack(ShopKeeper.foodCheeseWheel, 2);
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
		return Item.getItemFromBlock(ShopKeeper.machinaKeg);
	}

}