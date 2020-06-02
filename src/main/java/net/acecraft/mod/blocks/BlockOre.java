package net.acecraft.mod.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockOre extends Block {
	
	int harvestLevel;
	Item drop;
	
	public BlockOre(String name, int _harvestLevel, Item _drop) {
		super(Material.rock);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(1.00F + (0.75F*_harvestLevel));
		this.setResistance(5.0F);
		this.setStepSound(SoundType.STONE);
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
	
	public void dropXpOnBlockBreak(World world, int x, int y, int z, int varXP){
        if (!world.isRemote){
            while (varXP > 0){
                int i1 = EntityXPOrb.getXPSplit(varXP);
                varXP -= i1;
                world.spawnEntityInWorld(new EntityXPOrb(world, (double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, i1));
            }
        }
    }
	
	public int getExpDrop(IBlockAccess world, int metadata, int fortune){
        return harvestLevel * harvestLevel;
    }
	
}
