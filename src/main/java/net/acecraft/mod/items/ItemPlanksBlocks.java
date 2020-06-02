package net.acecraft.mod.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemPlanksBlocks extends ItemBlock {
	
	final static String[] subBlocks = new String[] {"FruitTree", "Golden", "PalmTree"};

	public ItemPlanksBlocks(Block block) {
		super(block);
		this.setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack) {
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= subBlocks.length) {
			i = 0;
		}
		return super.getUnlocalizedName() + "." + subBlocks[i];
	}
	
	public int getMetadata(int meta) {
		return meta;
	}

}