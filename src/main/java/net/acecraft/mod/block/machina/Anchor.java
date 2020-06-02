package net.acecraft.mod.block.machina;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.tileentity.TileEntityAnchor;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class Anchor extends BlockContainer {
	
	public Anchor(){
		super(Material.iron);
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
		return new TileEntityAnchor();
	}
	
	public void registerBlockIcons(IIconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5));
	}
	
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float floatX, float floatY, float floatZ){
    	if(world.isRemote){
			return true;
		}else if(!player.isSneaking()){
			if(player.getHeldItem() == null){
				
			}else{
				ItemStack item = player.getHeldItem();
				if(item.getItem() == ShopKeeper.stuffRope){
					int count = item.stackSize;
					int v = 0;
					int w = 0;
					while(count > 0){
						v=v+1;
						if(world.getBlock(x, y-v, z) == ShopKeeper.machinaRope){
							// idle
						}else if(world.getBlock(x, y-v, z) == Blocks.air){
							world.setBlock(x, y-v, z, ShopKeeper.machinaRope, meta, 2);
							w=w+1;
						}else{
							count = 0;
						}
						count=count-1;
					}
					if(item.stackSize == w){
						player.setCurrentItemOrArmor(0, null);
						return true;
					}
					item.stackSize = item.stackSize - w;
					player.setCurrentItemOrArmor(0, item);
				}
			return true;
			}
		}
		return true;
    }
    
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack){
        int meta = determineOrientation(world, x, y, z, player);
        world.setBlockMetadataWithNotify(x, y, z, meta, 2);
    }
    
    public void breakBlock(World world, int x, int y, int z, Block block, int meta){
    	if(meta == 10){
    		super.breakBlock(world, x, y, z, block, meta);
    		world.removeTileEntity(x, y, z);
    	}else{
    		if(world.getBlock(x, y-1, z) == ShopKeeper.machinaRope){
    			world.getBlock(x, y-1, z).breakBlock(world, x, y-1, z, block, meta);
    		}
    		super.breakBlock(world, x, y, z, block, meta);
    		world.removeTileEntity(x, y, z);
    	}
    }
    
    public static int determineOrientation(World world, int x, int y, int z, EntityLivingBase player){
        if (MathHelper.abs((float)player.posX - (float)x) < 2.0F && MathHelper.abs((float)player.posZ - (float)z) < 2.0F){
            double d0 = player.posY + 1.82D - (double)player.yOffset;
            if(d0 - (double)y > 2.0D){ return 1; }
            if((double)y - d0 > 0.0D){ return 0; }
        }
        int l = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        return l == 0 ? 2 : (l == 1 ? 5 : (l == 2 ? 3 : (l == 3 ? 4 : 0)));
    }

}