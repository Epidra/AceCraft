package net.acecraft.mod.block.blocks;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MinoBlock extends Block {
	
	IIcon iconSide;
	
	public MinoBlock(){
		super(Material.dragonEgg);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeStone);
		this.setCreativeTab(ShopKeeper.acetabCommon);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		blockIcon = iconRegister.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5) + "Top");
		iconSide  = iconRegister.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5) + "Side");
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		if(side == 0) return blockIcon;
		if(side == 1) return blockIcon;
		if(side == 2) return iconSide;
		if(side == 3) return iconSide;
		if(side == 4) return iconSide;
		if(side == 5) return iconSide;
		return blockIcon;
	}

}