package net.acecraft.mod.blocks;

import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;

public class BlockCrop extends BlockCrops {
	
	Item seed;
	Item crop;
	
	public BlockCrop(String name, Item _crop) {
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		//this.setCreativeTab(CreativeTabs.tabDecorations);
		crop = _crop;
	}
	
	public Item getSeed(){
		return seed;
	}
	
	public Item getCrop(){
		return crop;
	}
	
	public void setSeed(Item _seed){
		seed = _seed;
	}
	
}
