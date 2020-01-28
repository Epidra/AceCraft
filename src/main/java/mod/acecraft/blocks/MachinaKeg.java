package mod.acecraft.blocks;

import mod.acecraft.AceCraft;
import mod.acecraft.ShopKeeper;
import mod.acecraft.tileentities.TileEntityKeg;
import mod.shared.blocks.IMachinaEnergy;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MachinaKeg extends IMachinaEnergy {
	
	private boolean hasCheese = false;
	
	public MachinaKeg(String name) {
		super(name, Material.WOOD);
	}
	
	public TileEntity createNewTileEntity(World worldIn, int meta){
        return new TileEntityKeg();
    }
	
	public EnumBlockRenderType getRenderType(IBlockState state){
        return EnumBlockRenderType.MODEL;
    }
	
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(world.isRemote){
			return true;
		}else if(!player.isSneaking()){
				TileEntityKeg entity = (TileEntityKeg) world.getTileEntity(pos);
				if(entity != null){
					if(player.getHeldItem(hand) != null){
						Item item2 = entity.ChangeContent(player.getHeldItem(hand).getItem());
						if(item2 != null){
							player.getHeldItem(hand).shrink(1);
							if(player.getHeldItem(hand).getCount() <= 0) player.getHeldItem(hand).setCount(0);
							player.inventory.addItemStackToInventory(new ItemStack(item2));
						} else {
							player.openGui(AceCraft.instance, ShopKeeper.GuiID.KEG.ordinal(), world, pos.getX(), pos.getY(), pos.getZ());
						}
					} else {
						player.openGui(AceCraft.instance, ShopKeeper.GuiID.KEG.ordinal(), world, pos.getX(), pos.getY(), pos.getZ());
					}
				}
				return true;
			}
		return true;
	}
	
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
    
    public void dropBlockAsItemWithChance(World world, BlockPos pos, IBlockState state, float chance, int fortune){
        if (!world.isRemote && !world.restoringBlockSnapshots){
            java.util.List<ItemStack> items = getDrops(world, pos, state, fortune);
            chance = net.minecraftforge.event.ForgeEventFactory.fireBlockHarvesting(items, world, pos, state, fortune, chance, false, harvesters.get());
			spawnAsEntity(world, pos, new ItemStack(this));
        }
    }
	
}
