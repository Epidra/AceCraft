package net.acecraft.mod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSpade;

public class ToolShovel extends ItemSpade {
	
	public ToolShovel(String name, ToolMaterial material){
		super(material);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.tabTools);
	}

}
