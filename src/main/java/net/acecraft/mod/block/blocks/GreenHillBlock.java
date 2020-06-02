package net.acecraft.mod.block.blocks;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GreenHillBlock extends Block {
	
	private IIcon iconSide;
	private IIcon iconTop;
	
	public GreenHillBlock(Material material, boolean type){
		super(material);
		if(type == true){ //Dirt
			this.setHardness(2.0F);
			this.setResistance(2.0F);
			this.setCreativeTab(ShopKeeper.acetabCommon);
			this.setStepSound(soundTypeGrass);
		}else{ //Stone
			this.setHardness(5.0F);
			this.setResistance(5.0F);
			this.setCreativeTab(ShopKeeper.acetabCommon);
			this.setStepSound(soundTypeStone);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		blockIcon = iconRegister.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5) + "Bottom");
		iconSide  = iconRegister.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5) + "Side");
		iconTop   = iconRegister.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5) + "Top");
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		if(side == 0) return blockIcon;
		if(side == 1) return iconTop;
		if(side == 2) return iconSide;
		if(side == 3) return iconSide;
		if(side == 4) return iconSide;
		if(side == 5) return iconSide;
		return blockIcon;
	}

}