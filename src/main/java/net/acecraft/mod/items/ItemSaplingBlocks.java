package net.acecraft.mod.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemSaplingBlocks extends ItemBlockWithMetadata {
	
	public ItemSaplingBlocks(Block block){
		super(block, block);
		this.setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack){
		return super.getUnlocalizedName();
	}
	
	public int getMetadata(int meta){
		return meta;
	}

}