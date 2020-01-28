package mod.acecraft.blocks;

import mod.acecraft.AceCraft;
import mod.acecraft.ShopKeeper;
import mod.acecraft.tileentities.TileEntityFruitPress;
import mod.shared.blocks.IMachinaEnergy;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MachinaFruitPress extends IMachinaEnergy {
	
	public MachinaFruitPress(String name) {
		super(name, Material.WOOD);
	}
	
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        if (worldIn.isRemote){
            return true;
        } else {
            TileEntity tileentity = worldIn.getTileEntity(pos);
            if (tileentity instanceof TileEntityFruitPress){
            	playerIn.openGui(AceCraft.instance, ShopKeeper.GuiID.FRUITPRESS.ordinal(), worldIn, pos.getX(), pos.getY(), pos.getZ());
                playerIn.addStat(StatList.FURNACE_INTERACTION);
            }
            return true;
        }
    }
	
	public TileEntity createNewTileEntity(World worldIn, int meta){
        return new TileEntityFruitPress();
    }
	
}
