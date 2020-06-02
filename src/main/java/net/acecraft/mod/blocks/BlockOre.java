package net.acecraft.mod.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockOre extends Block {
	
	int harvestLevel;
	Item drop;
	
	public BlockOre(String name, int _harvestLevel, Item _drop) {
		super(Material.ROCK);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setHardness(1.00F + (0.75F*_harvestLevel));
		this.setResistance(5.0F);
		this.setSoundType(SoundType.STONE);
		this.setLightOpacity(16);
		this.setLightLevel(0);
		this.setHarvestLevel("pickaxe", _harvestLevel);
		this.setTickRandomly(false);
		harvestLevel = _harvestLevel;
		drop = _drop;
	}
	
	public Item getItemDropped(IBlockState state, Random rand, int fortune){
		return drop;
	}
	
	public int quantityDropped(Random random){
		return 1;
	}
	
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune){
		return harvestLevel * harvestLevel;
    }
	
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune){
        List<ItemStack> ret = new java.util.ArrayList<ItemStack>();
        ret.add(new ItemStack(drop));
        for(int i = 0; i < fortune; i++){
        	ret.add(new ItemStack(drop));
        }
        return ret;
    }
    
    public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player){
        return true;
    }
	
}
