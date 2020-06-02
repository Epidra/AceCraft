package net.acecraft.mod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;

public class ToolFryingPan extends ItemSword {
	
	public ToolFryingPan(String name, ToolMaterial material){
		super(material);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.tabTools);
		this.setMaxDamage(250);
		this.setNoRepair();
	}
	
}