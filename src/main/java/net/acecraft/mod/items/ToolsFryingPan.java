package net.acecraft.mod.items;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ToolsFryingPan extends ItemSword {
	
	public ToolsFryingPan(ToolMaterial material){
		super(material);
		this.setCreativeTab(ShopKeeper.acetabCommon);
		this.setMaxDamage(100);
		this.setNoRepair();
	}
	
	@SideOnly(Side.CLIENT)
	public void  registerIcons(IIconRegister iconRegister){
		this.itemIcon = iconRegister.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5));
	}

}