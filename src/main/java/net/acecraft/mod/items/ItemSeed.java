package net.acecraft.mod.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSeeds;

public class ItemSeed extends ItemSeeds {
	
	public ItemSeed(String name, Block crops, Block soil) {
		super(crops, soil);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
	}
	
}
