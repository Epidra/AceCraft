package mod.acecraft.blocks;

import mod.acecraft.tileentities.TileEntityGearBox;
import mod.shared.blocks.IMachinaEnergy;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;

public class MachinaGearBox extends IMachinaEnergy {
	
	public MachinaGearBox(String name) {
		super(name, Material.WOOD);
	}
	
	public TileEntity createNewTileEntity(World worldIn, int meta){
        return new TileEntityGearBox();
    }
	
	public EnumBlockRenderType getRenderType(IBlockState state){
        return EnumBlockRenderType.MODEL;
    }
	
}
