package net.acecraft.mod.handler;

import java.util.Random;

import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;
import net.acecraft.mod.ShopKeeper;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

public class TradeHandler implements IVillageTradeHandler{
	
	@Override
	public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipeList, Random random){
		switch(villager.getProfession()) {
		case 0: // FARMER
			recipeList.add(new MerchantRecipe(new ItemStack(Blocks.gravel, 10), new ItemStack(Items.potato, 2), new ItemStack(Items.flint, 5)));
			recipeList.add(new MerchantRecipe(new ItemStack(Blocks.gravel, 10), new ItemStack(Items.carrot, 2), new ItemStack(Items.flint, 5)));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.carrot, 5), new ItemStack(Items.apple, 4)));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.potato, 5), new ItemStack(Items.apple, 4)));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 1), new ItemStack(ShopKeeper.seedsWild, 30)));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 1), new ItemStack(ShopKeeper.seedsHemp, 10)));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 1), new ItemStack(ShopKeeper.seedsCotton, 10)));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 1), new ItemStack(ShopKeeper.foodTurnip, 5)));
			break;
		case 1: // LIBRARIAN
			recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 1), new ItemStack(Items.diamond,               1)));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 1), new ItemStack(ShopKeeper.gemstoneRuby,     1)));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 1), new ItemStack(ShopKeeper.gemstonePeridot,  1)));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 1), new ItemStack(ShopKeeper.gemstoneTopaz,    1)));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 1), new ItemStack(ShopKeeper.gemstoneSaphire,  1)));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 1), new ItemStack(ShopKeeper.gemstoneAzurit,   1)));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 1), new ItemStack(ShopKeeper.gemstoneAmber,    1)));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 1), new ItemStack(ShopKeeper.gemstoneAmethyst, 1)));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 1), new ItemStack(ShopKeeper.gemstoneGagat,    1)));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 1), new ItemStack(ShopKeeper.gemstoneOpal,     1)));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.diamond, 1), new ItemStack(Items.emerald,               1)));
			recipeList.add(new MerchantRecipe(new ItemStack(ShopKeeper.gemstoneRuby,     1), new ItemStack(Items.emerald, 1)));
			recipeList.add(new MerchantRecipe(new ItemStack(ShopKeeper.gemstonePeridot,  1), new ItemStack(Items.emerald, 1)));
			recipeList.add(new MerchantRecipe(new ItemStack(ShopKeeper.gemstoneTopaz,    1), new ItemStack(Items.emerald, 1)));
			recipeList.add(new MerchantRecipe(new ItemStack(ShopKeeper.gemstoneSaphire,  1), new ItemStack(Items.emerald, 1)));
			recipeList.add(new MerchantRecipe(new ItemStack(ShopKeeper.gemstoneAzurit,   1), new ItemStack(Items.emerald, 1)));
			recipeList.add(new MerchantRecipe(new ItemStack(ShopKeeper.gemstoneAmber,    1), new ItemStack(Items.emerald, 1)));
			recipeList.add(new MerchantRecipe(new ItemStack(ShopKeeper.gemstoneAmethyst, 1), new ItemStack(Items.emerald, 1)));
			recipeList.add(new MerchantRecipe(new ItemStack(ShopKeeper.gemstoneGagat,    1), new ItemStack(Items.emerald, 1)));
			recipeList.add(new MerchantRecipe(new ItemStack(ShopKeeper.gemstoneOpal,     1), new ItemStack(Items.emerald, 1)));
          //recipeList.add(new MerchantRecipe(new ItemStack(Items.diamond, 1), Items.enchanted_book.getEnchantedItemStack(new EnchantmentData(Enchantment.flame, 1))));
			break;
		case 2: // PRIEST
			//EntityPlayer player = (EntityPlayer) villager.worldObj.playerEntities.get(0);
			//if(player.getCurrentEquippedItem().getItem() == Items.flint){
			//	recipeList.add(new MerchantRecipe(new ItemStack(Items.flint), new ItemStack(Items.flint)));
			//}
			break;
		case 3: // BLACKSMITH
			recipeList.add(new MerchantRecipe(new ItemStack(ShopKeeper.ingotCopper, 6+random.nextInt(4)), new ItemStack(Items.emerald, 1)));
			recipeList.add(new MerchantRecipe(new ItemStack(ShopKeeper.ingotLead, 5+random.nextInt(4)), new ItemStack(Items.emerald, 1)));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald,  4+random.nextInt(4)), new ItemStack(ShopKeeper.toolSwordCopper, 1)));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald,  4+random.nextInt(4)), new ItemStack(ShopKeeper.toolSwordLead, 1)));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald,  4+random.nextInt(4)), new ItemStack(ShopKeeper.toolSpearCopper, 1)));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald,  4+random.nextInt(4)), new ItemStack(ShopKeeper.toolSpearLead, 1)));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald,  5+random.nextInt(3)), new ItemStack(ShopKeeper.armorHelmetCopper, 1)));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald,  5+random.nextInt(3)), new ItemStack(ShopKeeper.armorHelmetLead, 1)));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 10+random.nextInt(4)), new ItemStack(ShopKeeper.armorChestplateCopper, 1)));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 10+random.nextInt(4)), new ItemStack(ShopKeeper.armorChestplateLead, 1)));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald,  9+random.nextInt(3)), new ItemStack(ShopKeeper.armorLegginsCopper, 1)));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald,  9+random.nextInt(3)), new ItemStack(ShopKeeper.armorLegginsLead, 1)));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald,  5+random.nextInt(2)), new ItemStack(ShopKeeper.armorBootsCopper, 1)));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald,  5+random.nextInt(2)), new ItemStack(ShopKeeper.armorBootsLead, 1)));
			break;
		case 4: // BUTCHER
			recipeList.add(new MerchantRecipe(new ItemStack(ShopKeeper.foodMuttonRaw, 14+random.nextInt(4)), new ItemStack(Items.emerald, 1)));
			recipeList.add(new MerchantRecipe(new ItemStack(ShopKeeper.foodVenisonRaw, 14+random.nextInt(4)), new ItemStack(Items.emerald, 1)));
			recipeList.add(new MerchantRecipe(new ItemStack(ShopKeeper.foodCrabMeatRaw, 14+random.nextInt(4)), new ItemStack(Items.emerald, 1)));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 1), new ItemStack(ShopKeeper.foodMuttonCooked, 5+random.nextInt(3))));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 1), new ItemStack(ShopKeeper.foodVenisonCooked, 5+random.nextInt(3))));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 1), new ItemStack(ShopKeeper.foodCrabMeatCooked, 5+random.nextInt(3))));
			recipeList.add(new MerchantRecipe(new ItemStack(Items.rotten_flesh, 20+random.nextInt(10)), new ItemStack(Items.leather, 10+random.nextInt(5))));
			break;
		default:
			break;
		}
	}

}