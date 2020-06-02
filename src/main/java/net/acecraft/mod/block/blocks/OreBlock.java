package net.acecraft.mod.block.blocks;

import java.util.Random;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class OreBlock extends Block {
	
	int harvestLevel;
	
	public OreBlock(int _harvestLevel) {
		super(Material.rock);
		this.setHardness(3.0F);
		this.setResistance(5.0F);
		this.setStepSound(soundTypeStone);
		this.setCreativeTab(ShopKeeper.acetabCommon);
		this.setHarvestLevel("pickaxe", _harvestLevel);
		harvestLevel = _harvestLevel;
	}
	
	public Item getItemDropped(int i, Random random, int j) {
		if(this.getUnlocalizedName().substring(5).compareTo("OreSalt")       == 0) { return ShopKeeper.powderSalt;        }
		if(this.getUnlocalizedName().substring(5).compareTo("OreSulfur")     == 0) { return ShopKeeper.powderSulfur;      }
		if(this.getUnlocalizedName().substring(5).compareTo("OreCopper")     == 0) { return ShopKeeper.nuggetCopper;      }
		if(this.getUnlocalizedName().substring(5).compareTo("OreBauxite")    == 0) { return ShopKeeper.nuggetBauxite;     }
		if(this.getUnlocalizedName().substring(5).compareTo("OreLead")       == 0) { return ShopKeeper.nuggetLead;        }
		if(this.getUnlocalizedName().substring(5).compareTo("OreTin")        == 0) { return ShopKeeper.nuggetTin;         }
		if(this.getUnlocalizedName().substring(5).compareTo("OreZinc")       == 0) { return ShopKeeper.nuggetZinc;        }
		if(this.getUnlocalizedName().substring(5).compareTo("OreSilver")     == 0) { return ShopKeeper.nuggetSilver;      }
		if(this.getUnlocalizedName().substring(5).compareTo("OreMythril")    == 0) { return ShopKeeper.nuggetMythril;     }
		if(this.getUnlocalizedName().substring(5).compareTo("OreIridium")    == 0) { return ShopKeeper.nuggetIridium;     }
		if(this.getUnlocalizedName().substring(5).compareTo("OreAdamantium") == 0) { return ShopKeeper.nuggetAdamantium;  }
		if(this.getUnlocalizedName().substring(5).compareTo("OreOrichalcum") == 0) { return ShopKeeper.nuggetOrichalcum;  }
		if(this.getUnlocalizedName().substring(5).compareTo("OreUnobtanium") == 0) { return ShopKeeper.nuggetUnobtanium;  }
		if(this.getUnlocalizedName().substring(5).compareTo("OreRuby")       == 0) { return ShopKeeper.gemstoneRuby;      }
		if(this.getUnlocalizedName().substring(5).compareTo("OrePeridot")    == 0) { return ShopKeeper.gemstonePeridot;   }
		if(this.getUnlocalizedName().substring(5).compareTo("OreTopaz")      == 0) { return ShopKeeper.gemstoneTopaz;     }
		if(this.getUnlocalizedName().substring(5).compareTo("OreSaphire")    == 0) { return ShopKeeper.gemstoneSaphire;   }
		if(this.getUnlocalizedName().substring(5).compareTo("OreAzurit")     == 0) { return ShopKeeper.gemstoneAzurit;    }
		if(this.getUnlocalizedName().substring(5).compareTo("OreAmber")      == 0) { return ShopKeeper.gemstoneAmber;     }
		if(this.getUnlocalizedName().substring(5).compareTo("OreAmethyst")   == 0) { return ShopKeeper.gemstoneAmethyst;  }
		if(this.getUnlocalizedName().substring(5).compareTo("OreGagat")      == 0) { return ShopKeeper.gemstoneGagat;     }
		if(this.getUnlocalizedName().substring(5).compareTo("OreOpal")       == 0) { return ShopKeeper.gemstoneOpal;      }
		if(this.getUnlocalizedName().substring(5).compareTo("OreJade")       == 0) { return ShopKeeper.gemstoneJade;      }
		if(this.getUnlocalizedName().substring(5).compareTo("OreTurquoise")  == 0) { return ShopKeeper.gemstoneTurquoise; }
		return Items.flint;
	}
	
	public int quantityDropped(Random random) {
		return 1;
	}
	
	public void dropXpOnBlockBreak(World world, int x, int y, int z, int varXP){
        if (!world.isRemote){
            while (varXP > 0){
                int i1 = EntityXPOrb.getXPSplit(varXP);
                varXP -= i1;
                world.spawnEntityInWorld(new EntityXPOrb(world, (double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, i1));
            }
        }
    }
	
	public int getExpDrop(IBlockAccess world, int metadata, int fortune){
        return harvestLevel * harvestLevel;
    }
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5));
	}

}