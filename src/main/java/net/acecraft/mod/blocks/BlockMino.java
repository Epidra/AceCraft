package net.acecraft.mod.blocks;

import java.util.Random;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockMino extends BlockHorizontal {
	
	Item drop;
	
	public BlockMino(String name, Item _drop) {
		super(Material.dragonEgg);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(6.0F);
		this.setResistance(7.5F);
		this.setStepSound(SoundType.METAL);
		this.setLightOpacity(16);
		this.setLightLevel(0);
		this.setHarvestLevel("pickaxe", 0);
		this.setTickRandomly(false);
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		return state.getValue(FACING).getIndex();
	}
	
	protected BlockStateContainer createBlockState() {
        return new BlockStateContainer( this, new IProperty[] {FACING} );
    }

    public IBlockState onBlockPlaced( World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer )
    {
        return this.getDefaultState().withProperty( FACING, placer.getHorizontalFacing().getOpposite() );
    }
	
    public Item getItemDropped(IBlockState state, Random rand, int fortune){
		return drop;
	}
	
	public int quantityDropped(Random random){
		return 1;
	}
    
}
