package net.acecraft.mod.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemLeafBlocks extends ItemBlock {
	
	public ItemLeafBlocks(Block block){
		super(block);
		this.setHasSubtypes(false);
	}
	
	public String getUnlocalizedName(ItemStack itemstack){
		return super.getUnlocalizedName();
	}
	
	public int getMetadata(int meta){
		return meta;
	}

}