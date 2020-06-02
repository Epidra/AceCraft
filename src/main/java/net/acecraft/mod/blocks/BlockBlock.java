package net.acecraft.mod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBlock extends Block {

	public BlockBlock(String name, Material material, float hardness, float resistance) {
		super(material);                            // sets the material for the block which defines basic settings
		this.setUnlocalizedName(name);   // sets the name of the block
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.tabBlock); // sets the creative tab to display the block in
		this.setHardness(hardness);                 // sets how long it takes to break the block
		this.setResistance(resistance);             // sets the block's resistance against explosions
		this.setStepSound(SoundType.GROUND);        // sets the step sound of a block
		this.setLightOpacity(16);                   // sets how much light is subtracted when going through this block		This is only used if isOpaqueCube() returns false
		this.setLightLevel(0);                      // sets how much light is emitted from the block
		this.setHarvestLevel("pickaxe", 0);         // sets the tool and the tool level to break a block. If you don't use this, the break level is defined by the material
		//this.setBlockUnbreakable();               // makes the block unbreakable in survival
		this.setTickRandomly(false);                // if true the block receives random update ticks. Used for example for the decaying of leaves.
		
		      if(material == Material.iron) { this.setStepSound(SoundType.METAL);
		}else if(material == Material.glass){ this.setStepSound(SoundType.GLASS);
		}else if(material == Material.sand) { this.setStepSound(SoundType.SAND);
		}else if(material == Material.rock) { this.setStepSound(SoundType.STONE);
		}else if(material == Material.wood) { this.setStepSound(SoundType.WOOD);
		}
	}

}
