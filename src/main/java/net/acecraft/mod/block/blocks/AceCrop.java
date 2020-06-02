package net.acecraft.mod.block.blocks;

import java.util.Random;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AceCrop extends BlockCrops {
	
	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;
	
	public AceCrop(){
		
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		this.iconArray = new IIcon[8];
		for(int i = 0; i < this.iconArray.length; i++){
			this.iconArray[i] = iconRegister.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5) + "Plant" + (i + 1));
		}
	}
	
	public IIcon getIcon(int side, int metadata){
		return this.iconArray[metadata];
	}
	
	public int quantityDropped(Random random){
		if(0 == this.getUnlocalizedName().substring(9).compareTo("GoldenCarrot")){
			return random.nextInt(3)+2;
		}
		return 1;
	}
	
	protected Item func_149866_i(){
		      if(0 == this.getUnlocalizedName().substring(9).compareTo("Turnip"))      { return ShopKeeper.seedsTurnip;
		}else if(0 == this.getUnlocalizedName().substring(9).compareTo("Grapes"))      { return ShopKeeper.seedsGrapes;
		}else if(0 == this.getUnlocalizedName().substring(9).compareTo("Onion"))       { return ShopKeeper.seedsOnion;
		}else if(0 == this.getUnlocalizedName().substring(9).compareTo("Pineapple"))   { return ShopKeeper.seedsPineapple;
		}else if(0 == this.getUnlocalizedName().substring(9).compareTo("Tomato"))      { return ShopKeeper.seedsTomato;
		}else if(0 == this.getUnlocalizedName().substring(9).compareTo("Cabbage"))     { return ShopKeeper.seedsCabbage;
		}else if(0 == this.getUnlocalizedName().substring(9).compareTo("Rice"))        { return ShopKeeper.seedsRice;
		}else if(0 == this.getUnlocalizedName().substring(9).compareTo("Maise"))       { return ShopKeeper.seedsMaise;
		}else if(0 == this.getUnlocalizedName().substring(9).compareTo("Peas"))        { return ShopKeeper.seedsPeas;
		}else if(0 == this.getUnlocalizedName().substring(9).compareTo("Pickles"))     { return ShopKeeper.seedsPickles;
		}else if(0 == this.getUnlocalizedName().substring(9).compareTo("CoffeeBeans")) { return ShopKeeper.seedsCoffeeBeans;
		}else if(0 == this.getUnlocalizedName().substring(9).compareTo("GoldenCarrot")){ return Items.golden_carrot;
		}else if(0 == this.getUnlocalizedName().substring(9).compareTo("Hemp"))        { return ShopKeeper.seedsHemp;
		}else if(0 == this.getUnlocalizedName().substring(9).compareTo("Cotton"))      { return ShopKeeper.seedsCotton;
		}
		return Items.wheat_seeds;
	}
	
	protected Item func_149865_P(){
	            if(0 == this.getUnlocalizedName().substring(9).compareTo("Turnip"))      { return ShopKeeper.foodTurnip;
	      }else if(0 == this.getUnlocalizedName().substring(9).compareTo("Grapes"))      { return ShopKeeper.foodGrapes;
	      }else if(0 == this.getUnlocalizedName().substring(9).compareTo("Onion"))       { return ShopKeeper.foodOnion;
	      }else if(0 == this.getUnlocalizedName().substring(9).compareTo("Pineapple"))   { return ShopKeeper.foodPineapple;
	      }else if(0 == this.getUnlocalizedName().substring(9).compareTo("Tomato"))      { return ShopKeeper.foodTomato;
	      }else if(0 == this.getUnlocalizedName().substring(9).compareTo("Cabbage"))     { return ShopKeeper.foodCabbage;
	      }else if(0 == this.getUnlocalizedName().substring(9).compareTo("Rice"))        { return ShopKeeper.foodRice;
	      }else if(0 == this.getUnlocalizedName().substring(9).compareTo("Maise"))       { return ShopKeeper.foodMaise;
	      }else if(0 == this.getUnlocalizedName().substring(9).compareTo("Peas"))        { return ShopKeeper.foodPeas;
	      }else if(0 == this.getUnlocalizedName().substring(9).compareTo("Pickles"))     { return ShopKeeper.foodPickles;
	      }else if(0 == this.getUnlocalizedName().substring(9).compareTo("CoffeeBeans")) { return ShopKeeper.foodCoffeeBeans;
	      }else if(0 == this.getUnlocalizedName().substring(9).compareTo("GoldenCarrot")){ return Items.golden_carrot;
	      }else if(0 == this.getUnlocalizedName().substring(9).compareTo("Hemp"))        { return ShopKeeper.stuffHemp;
	      }else if(0 == this.getUnlocalizedName().substring(9).compareTo("Cotton"))      { return ShopKeeper.stuffCotton;
	      }
	      return Items.wheat;
	}

}