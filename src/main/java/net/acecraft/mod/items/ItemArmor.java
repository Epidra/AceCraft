package net.acecraft.mod.items;

import net.acecraft.mod.ShopKeeper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.PotionTypes;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.world.World;

public class ItemArmor extends net.minecraft.item.ItemArmor {

	public ItemArmor(String name, ArmorMaterial material, int renderIndex, EntityEquipmentSlot equipmentSlot) {
		super(material, renderIndex, equipmentSlot);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.tabCombat);
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack){
		if(itemStack.getItem() == ShopKeeper.armorBootsCopper){
			this.effectPlayer(player, Potion.getPotionById(0), 0);
		}
	}
	
	private boolean isWearingFullSet(EntityPlayer player, Item helmet, Item chestplate, Item leggings, Item boots){
		return player.inventory.armorItemInSlot(0)!= null && player.inventory.armorItemInSlot(1)!= null &&  player.inventory.armorItemInSlot(2)!= null &&  player.inventory.armorItemInSlot(3)!= null; 
	}
	
	private void effectPlayer(EntityPlayer player, Potion fireResistance, int amplifier){
		if(player.getActivePotionEffect(fireResistance) == null || player.getActivePotionEffect(fireResistance).getDuration() <= 1){
			player.addPotionEffect(new PotionEffect(fireResistance, 159, amplifier, true, true));
		}
	}
	
}
