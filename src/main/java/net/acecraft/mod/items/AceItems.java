package net.acecraft.mod.items;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AceItems extends Item {
	
	public AceItems(boolean tab){
		if(tab)
			this.setCreativeTab(ShopKeeper.acetabCommon);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister){
		this.itemIcon = iconRegister.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5));
	}

}