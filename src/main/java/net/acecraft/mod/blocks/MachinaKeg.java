package net.acecraft.mod.blocks;

import javax.annotation.Nullable;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.tileentity.TileEntityKeg;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;

public class MachinaKeg extends IMachinaEnergy {
	
	public static final AxisAlignedBB AABB_SN = new AxisAlignedBB(0.3D, 0.3D, 0.0D, 0.7D, 0.7D, 1.0D);
	public static final AxisAlignedBB AABB_UD = new AxisAlignedBB(0.3D, 0.0D, 0.3D, 0.7D, 1.0D, 0.7D);
	public static final AxisAlignedBB AABB_EW = new AxisAlignedBB(0.0D, 0.3D, 0.3D, 1.0D, 0.7D, 0.7D);
	
	private boolean hasCheese = false;
	
	public MachinaKeg(String name) {
		super(name, Material.WOOD);
	}
	
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
		EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
		//if(enumfacing == EnumFacing.NORTH || enumfacing == EnumFacing.SOUTH) return AABB_SN;
		//if(enumfacing == EnumFacing.EAST  || enumfacing == EnumFacing.WEST ) return AABB_EW;
		//if(enumfacing == EnumFacing.UP    || enumfacing == EnumFacing.DOWN ) return AABB_UD;
        return FULL_BLOCK_AABB;
    }
	
	public TileEntity createNewTileEntity(World worldIn, int meta){
        return new TileEntityKeg();
    }
	
	public EnumBlockRenderType getRenderType(IBlockState state){
        return EnumBlockRenderType.MODEL;
    }
	
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
		if(world.isRemote){
			return true;
		}else if(!player.isSneaking()){
				TileEntityKeg entity = (TileEntityKeg) world.getTileEntity(pos);
				if(entity != null){
					if(heldItem != null){
						Item item2 = entity.ChangeContent(heldItem.getItem());
						if(item2 != null){
							heldItem.stackSize--;
							if(heldItem.stackSize <= 0) heldItem = null;
							player.inventory.addItemStackToInventory(new ItemStack(item2));
						} else {
							player.openGui(AceCraft.instance, ShopKeeper.guiIDKeg, world, pos.getX(), pos.getY(), pos.getZ());
						}
					} else {
						player.openGui(AceCraft.instance, ShopKeeper.guiIDKeg, world, pos.getX(), pos.getY(), pos.getZ());
					}
				}
				return true;
			}
		return true;
	}
	
	/**
     * Called serverside after this block is replaced with another in Chunk, but before the Tile Entity is updated
     */
    public void breakBlock(World world, BlockPos pos, IBlockState state){
    	TileEntityKeg entity = (TileEntityKeg) world.getTileEntity(pos);
		if(entity != null){
			if(0 == entity.content.compareTo("Cheese")){
				hasCheese = true;
			}
		}
        if (hasTileEntity(state) && !(this instanceof BlockContainer)){
            world.removeTileEntity(pos);
        }
    }
	
	/**
     * Spawns this Block's drops into the World as EntityItems.
     */
    public void dropBlockAsItemWithChance(World world, BlockPos pos, IBlockState state, float chance, int fortune){
        if (!world.isRemote && !world.restoringBlockSnapshots){
            java.util.List<ItemStack> items = getDrops(world, pos, state, fortune);
            chance = net.minecraftforge.event.ForgeEventFactory.fireBlockHarvesting(items, world, pos, state, fortune, chance, false, harvesters.get());
            
            if(hasCheese){
            	spawnAsEntity(world, pos, new ItemStack(ShopKeeper.foodCheese));
				spawnAsEntity(world, pos, new ItemStack(ShopKeeper.foodCheese));
				spawnAsEntity(world, pos, new ItemStack(ShopKeeper.foodCheese));
				spawnAsEntity(world, pos, new ItemStack(ShopKeeper.foodCheese));
				spawnAsEntity(world, pos, new ItemStack(ShopKeeper.foodCheese));
				spawnAsEntity(world, pos, new ItemStack(ShopKeeper.foodCheese));
            }
            
			spawnAsEntity(world, pos, new ItemStack(this));
        }
    }

	
}
