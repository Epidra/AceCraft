package net.acecraft.mod.block.blocks;

import java.util.List;
import java.util.Random;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AceLeaf extends BlockLeaves {
	
	int[] updatefield;
	private IIcon icon;
	
	public AceLeaf(){
		
	}
	
	//Determines if Block drops an Apple
	protected void func_150124_c(World world, int x, int y, int z, int side, int meta){
		
	}
	
	public boolean isLeaves(IBlockAccess world, int x, int y, int z){
        return true;
    }
	
	public int damageDropped(int i){
		return super.damageDropped(i);
	}
	
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister){
		icon = iconRegister.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5));
    }
	
	@SideOnly(Side.CLIENT)
    public int getBlockColor(){
        return 99999999;
    }

    @SideOnly(Side.CLIENT)
    public int getRenderColor(int i){
        return ColorizerFoliage.getFoliageColorBasic();
    }

    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_){
        return 99999999;
    }
    
    public void updateTick(World world, int x, int y, int z, Random rand){
    	if(!world.isRemote && this.getUnlocalizedName() != "tile.LeavesPalmTree" && this.getUnlocalizedName() != "tile.LeavesCoconut" && this.getUnlocalizedName() != "tile.LeavesBanana"){
    		int r = rand.nextInt(10000);
    		if(r > 9000){
    			
					if(0 == this.getUnlocalizedName().compareTo("tile.LeavesCherryEmpty")) world.setBlock(x, y, z, ShopKeeper.leavesCherryBlossom);
					if(0 == this.getUnlocalizedName().compareTo("tile.LeavesLemonEmpty"))  world.setBlock(x, y, z, ShopKeeper.leavesLemonBlossom);
					if(0 == this.getUnlocalizedName().compareTo("tile.LeavesOrangeEmpty")) world.setBlock(x, y, z, ShopKeeper.leavesOrangeBlossom);
					if(0 == this.getUnlocalizedName().compareTo("tile.LeavesPeachEmpty"))  world.setBlock(x, y, z, ShopKeeper.leavesPeachBlossom);
					if(0 == this.getUnlocalizedName().compareTo("tile.LeavesAppleEmpty"))  world.setBlock(x, y, z, ShopKeeper.leavesAppleBlossom);
					if(0 == this.getUnlocalizedName().compareTo("tile.LeavesGoldenEmpty")) world.setBlock(x, y, z, ShopKeeper.leavesGoldenBlossom);
					
					if(0 == this.getUnlocalizedName().compareTo("tile.LeavesCherryBlossom")) world.setBlock(x, y, z, ShopKeeper.leavesCherryFruit);
					if(0 == this.getUnlocalizedName().compareTo("tile.LeavesLemonBlossom"))  world.setBlock(x, y, z, ShopKeeper.leavesLemonFruit);
					if(0 == this.getUnlocalizedName().compareTo("tile.LeavesOrangeBlossom")) world.setBlock(x, y, z, ShopKeeper.leavesOrangeFruit);
					if(0 == this.getUnlocalizedName().compareTo("tile.LeavesPeachBlossom"))  world.setBlock(x, y, z, ShopKeeper.leavesPeachFruit);
					if(0 == this.getUnlocalizedName().compareTo("tile.LeavesAppleBlossom"))  world.setBlock(x, y, z, ShopKeeper.leavesAppleFruit);
					if(0 == this.getUnlocalizedName().compareTo("tile.LeavesGoldenBlossom")) world.setBlock(x, y, z, ShopKeeper.leavesGoldenFruit);
    			}
    		}
        if (!world.isRemote){
        	int l = world.getBlockMetadata(x, y, z);
            if ((l & 8) != 0 && (l & 4) == 0){
                byte b0 = 4;
                int i1 = b0 + 1;
                byte b1 = 32;
                int j1 = b1 * b1;
                int k1 = b1 / 2;
                if (this.updatefield == null){
                    this.updatefield = new int[b1 * b1 * b1];
                }
                int l1;
                if (world.checkChunksExist(x - i1, y - i1, z - i1, x + i1, y + i1, z + i1)){
                    int i2;
                    int j2;
                    for (l1 = -b0; l1 <= b0; ++l1){
                        for (i2 = -b0; i2 <= b0; ++i2){
                            for (j2 = -b0; j2 <= b0; ++j2){
                                Block block = world.getBlock(x + l1, y + i2, z + j2);
                                if (!block.canSustainLeaves(world, x + l1, y + i2, z + j2)){
                                    if (block.isLeaves(world, x + l1, y + i2, z + j2)){
                                        this.updatefield[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = -2;
                                    } else {
                                        this.updatefield[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = -1;
                                    }
                                } else {
                                    this.updatefield[(l1 + k1) * j1 + (i2 + k1) * b1 + j2 + k1] = 0;
                                }
                            }
                        }
                    }
                    for (l1 = 1; l1 <= 4; ++l1){
                        for (i2 = -b0; i2 <= b0; ++i2){
                            for (j2 = -b0; j2 <= b0; ++j2){
                                for (int k2 = -b0; k2 <= b0; ++k2){
                                    if (this.updatefield[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1] == l1 - 1) {
                                        if (this.updatefield[(i2 + k1 - 1) * j1 + (j2 + k1) * b1 + k2 + k1] == -2){
                                            this.updatefield[(i2 + k1 - 1) * j1 + (j2 + k1) * b1 + k2 + k1] = l1;
                                        }
                                        if (this.updatefield[(i2 + k1 + 1) * j1 + (j2 + k1) * b1 + k2 + k1] == -2){
                                            this.updatefield[(i2 + k1 + 1) * j1 + (j2 + k1) * b1 + k2 + k1] = l1;
                                        }
                                        if (this.updatefield[(i2 + k1) * j1 + (j2 + k1 - 1) * b1 + k2 + k1] == -2){
                                            this.updatefield[(i2 + k1) * j1 + (j2 + k1 - 1) * b1 + k2 + k1] = l1;
                                        }
                                        if (this.updatefield[(i2 + k1) * j1 + (j2 + k1 + 1) * b1 + k2 + k1] == -2){
                                            this.updatefield[(i2 + k1) * j1 + (j2 + k1 + 1) * b1 + k2 + k1] = l1;
                                        }
                                        if (this.updatefield[(i2 + k1) * j1 + (j2 + k1) * b1 + (k2 + k1 - 1)] == -2){
                                            this.updatefield[(i2 + k1) * j1 + (j2 + k1) * b1 + (k2 + k1 - 1)] = l1;
                                        }
                                        if (this.updatefield[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1 + 1] == -2){
                                            this.updatefield[(i2 + k1) * j1 + (j2 + k1) * b1 + k2 + k1 + 1] = l1;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                l1 = this.updatefield[k1 * j1 + k1 * b1 + k1];
                if (l1 >= 0){
                    world.setBlockMetadataWithNotify(x, y, z, l & -9, 4);
                } else {
                    this.removeLeaves(world, x, y, z);
                }
            }
        }
    }
    
    private void removeLeaves(World world, int x, int y, int z){
        this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
        world.setBlockToAir(x, y, z);
    }
    
	@Override
	public IIcon getIcon(int side, int meta){
		return icon;
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
		if(0 == this.getUnlocalizedName().compareTo("tile.LeavesCherryFruit")) {player.inventory.addItemStackToInventory(new ItemStack(ShopKeeper.foodCherry)); world.setBlock(x, y, z, ShopKeeper.leavesCherryEmpty);}
		if(0 == this.getUnlocalizedName().compareTo("tile.LeavesLemonFruit"))  {player.inventory.addItemStackToInventory(new ItemStack(ShopKeeper.foodLemon));  world.setBlock(x, y, z, ShopKeeper.leavesLemonEmpty);}
		if(0 == this.getUnlocalizedName().compareTo("tile.LeavesOrangeFruit")) {player.inventory.addItemStackToInventory(new ItemStack(ShopKeeper.foodOrange)); world.setBlock(x, y, z, ShopKeeper.leavesOrangeEmpty);}
		if(0 == this.getUnlocalizedName().compareTo("tile.LeavesPeachFruit"))  {player.inventory.addItemStackToInventory(new ItemStack(ShopKeeper.foodPeach));  world.setBlock(x, y, z, ShopKeeper.leavesPeachEmpty);}
		if(0 == this.getUnlocalizedName().compareTo("tile.LeavesAppleFruit"))  {player.inventory.addItemStackToInventory(new ItemStack(Items.apple));           world.setBlock(x, y, z, ShopKeeper.leavesAppleEmpty);}
		if(0 == this.getUnlocalizedName().compareTo("tile.LeavesGoldenFruit")) {player.inventory.addItemStackToInventory(new ItemStack(Items.golden_apple));    world.setBlock(x, y, z, ShopKeeper.leavesGoldenEmpty);}
		return true;
		
	}
	
	@Override
	public boolean renderAsNormalBlock(){
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(){
		return false;
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess blockaccess, int x, int y, int z, int side){
		return true;
	}

	@Override
	public String[] func_150125_e() {
		// TODO Auto-generated method stub
		return null;
	}

}