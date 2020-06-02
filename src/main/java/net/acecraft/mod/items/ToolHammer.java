package net.acecraft.mod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;

public class ToolHammer extends ItemSword {
	
	public ToolHammer(String name, ToolMaterial material){
		super(material);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.tabTools);
	}
	
}
