package net.acecraft.mod.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemLogBlocks extends ItemBlock {
	
	public ItemLogBlocks(Block block){
		super(block);
		this.setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack){
		return super.getUnlocalizedName();
	}
	
	public int getMetadata(int meta){
		return meta;
	}

}