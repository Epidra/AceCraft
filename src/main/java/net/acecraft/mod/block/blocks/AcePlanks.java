package net.acecraft.mod.block.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class AcePlanks extends Block {
	
	public static final String[] planks = new String[]{"FruitTree", "Golden", "PalmTree"};
	
	@SideOnly(Side.CLIENT)
	private IIcon[] texture;
	
	public AcePlanks() {
		super(Material.wood);
		this.setHardness(2.0F);
		this.setResistance(3.0F);
		this.setCreativeTab(ShopKeeper.acetabCommon);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		texture = new IIcon[planks.length];
		for(int i = 0; i < planks.length; i++) {
			texture[i] = iconRegister.registerIcon(AceCraft.modid + ":" + "Planks" + planks[i]);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list) {
		for (int i = 0; i < planks.length; i++) {
			list.add(new ItemStack(block, 1, i));
		}
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return texture[meta];
	}
	
	public int damageDropped(int meta) {
		return meta;
	}

}