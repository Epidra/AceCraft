package net.acecraft.mod.block.machina;

import java.util.Iterator;
import java.util.Random;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.tileentity.TileEntityBonfire;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Bonfire extends BlockContainer {
	
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
	
	public Bonfire(Boolean isActive){
		super(Material.rock);
		this.setHardness(5.0F);
		this.isActive = isActive;
	}

   public static int getDirection(int side){
       return side & 3;
   }
	
   @Override
   public boolean isBed(IBlockAccess world, int x, int y, int z, EntityLivingBase player){
       return true;
   }
   
   public ChunkCoordinates getBedSpawnPosition(IBlockAccess world, int x, int y, int z, EntityPlayer player){
       if(world instanceof World)
           return BlockBed.func_149977_a((World)world, x, y, z, 0);
       return null;
   }
   
   public void setBedOccupied(IBlockAccess world, int x, int y, int z, EntityPlayer player, boolean occupied){
       if (world instanceof World)
           BlockBed.func_149979_a((World)world,  x, y, z, occupied);
   }
   
   public int getBedDirection(IBlockAccess world, int x, int y, int z){
       return BlockBed.getDirection(world.getBlockMetadata(x,  y, z));
   }
   
   public boolean isBedFoot(IBlockAccess world, int x, int y, int z){
       return BlockBed.isBlockHeadOfBed(world.getBlockMetadata(x,  y, z));
   }
   
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5));
	}
	
	public Item getItemDropped(int i, Random random, int j){
		return Item.getItemFromBlock(ShopKeeper.machinaBonfireIdle);
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
		if(world.isRemote){
			return true;
		}else if(!player.isSneaking()){
			ItemStack item = player.getHeldItem();
			if(item != null){
				TileEntityBonfire entity = (TileEntityBonfire) world.getTileEntity(x, y, z);
				if(entity != null){
					FMLNetworkHandler.openGui(player, AceCraft.instance, ShopKeeper.guiIDBonfire, world, x, y, z);
				}
				return true;
			}else if(isActive){
				int i1 = world.getBlockMetadata(x, y, z);
	            if (isActive){
	                if(world.getBlock(x, y, z) != this){
	                    return true;
	                }
	                i1 = world.getBlockMetadata(x, y, z);
	            }
	            if(world.provider.canRespawnHere() && world.getBiomeGenForCoords(x, z) != BiomeGenBase.hell){
	                if (func_149976_c(i1)){
	                    EntityPlayer entityplayer1 = null;
	                    Iterator iterator = world.playerEntities.iterator();
	                    while (iterator.hasNext()){
	                        EntityPlayer entityplayer2 = (EntityPlayer)iterator.next();
	                        if (entityplayer2.isPlayerSleeping()){
	                            ChunkCoordinates chunkcoordinates = entityplayer2.playerLocation;
	                            if (chunkcoordinates.posX == x && chunkcoordinates.posY == y && chunkcoordinates.posZ == z){
	                                entityplayer1 = entityplayer2;
	                            }
	                        }
	                    }
	                    if(entityplayer1 != null){
	                        player.addChatComponentMessage(new ChatComponentTranslation("tile.bed.occupied", new Object[0]));
	                        return true;
	                    }
	                    func_149979_a(world, x, y, z, false);
	                }
	                EntityPlayer.EnumStatus enumstatus = player.sleepInBedAt(x, y, z);
	                if(enumstatus == EntityPlayer.EnumStatus.OK){
	                    func_149979_a(world, x, y, z, true);
	                    return true;
	                }else{
	                    if(enumstatus == EntityPlayer.EnumStatus.NOT_POSSIBLE_NOW){
	                        player.addChatComponentMessage(new ChatComponentTranslation("tile.bed.noSleep", new Object[0]));
	                    }else if(enumstatus == EntityPlayer.EnumStatus.NOT_SAFE){
	                        player.addChatComponentMessage(new ChatComponentTranslation("tile.bed.notSafe", new Object[0]));
	                    }
	                    return true;
	                }
	            }
			}
		}else{
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
		return new TileEntityBonfire();
	}
	
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random){
		if(this.isActive && world.isRaining() && world.canLightningStrikeAt(x, y+1, z)){
			updateBonfireBlockState(false,world,x,y,z);
		}else if(this.isActive){
			world.playSound((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), "fire.fire", 1.0F + random.nextFloat(), random.nextFloat() * 0.7F + 0.3F, false);
			int direction = world.getBlockMetadata(x, y, z);
			float x1 = (float)x + random.nextFloat();
			float y1 = (float)y + 0.1F;
			float z1 = (float)z + random.nextFloat();
			float f = 0;
			float f1 = random.nextFloat() * 0.6F - 0.3F;
			world.spawnParticle("smoke", (double)(x1), (double)(y1), (double)(z1), 0D, 0D, 0D);
			world.spawnParticle("flame", (double)(x1), (double)(y1), (double)(z1), 0D, 0D, 0D);
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
			worldObj.setBlock(xCoord, yCoord, zCoord, ShopKeeper.machinaBonfireActive);
		}else{
			worldObj.setBlock(xCoord, yCoord, zCoord, ShopKeeper.machinaBonfireIdle);
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
			TileEntityBonfire tileentity = (TileEntityBonfire) world.getTileEntity(x, y, z);
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
		return Item.getItemFromBlock(ShopKeeper.machinaBonfireIdle);
	}

}