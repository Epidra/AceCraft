package net.acecraft.mod.block.blocks;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockBlock extends Block {
	
	public BlockBlock(Material material){
		super(material);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setCreativeTab(ShopKeeper.acetabCommon);
		      if(material == Material.iron) { this.setStepSound(soundTypeMetal);
		}else if(material == Material.glass){ this.setStepSound(soundTypeGlass);
		}else if(material == Material.sand) { this.setStepSound(soundTypeSand);
		}else if(material == Material.rock) { this.setStepSound(soundTypeStone);
		}else if(material == Material.wood) { this.setStepSound(soundTypeWood);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5));
	}

}