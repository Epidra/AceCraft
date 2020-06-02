package net.acecraft.mod.block.blocks;

import java.util.List;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AceLog extends BlockLog {
	
	public static final String[] logs = new String[]{"FruitTree", "Golden", "PalmTree"};
	
	
	public AceLog(){
		this.setCreativeTab(ShopKeeper.acetabCommon);
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks (Item item, CreativeTabs tabs, List list){
		for (int i = 0; i < logs.length; i++){
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	public boolean isWood(IBlockAccess world, int x, int y, int z){
         return true;
    }
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons (IIconRegister iconRegister){
		this.field_150167_a = new IIcon[logs.length];
		this.field_150166_b = new IIcon[logs.length];
		for(int i = 0; i < logs.length; i++){
			this.field_150167_a[i] = iconRegister.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5) + logs[i] + "Side");
			this.field_150166_b[i] = iconRegister.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5) + logs[i] + "Top");
		}
	}

}
