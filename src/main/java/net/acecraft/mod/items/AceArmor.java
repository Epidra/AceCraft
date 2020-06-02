package net.acecraft.mod.items;

import java.util.Random;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class AceArmor extends ItemArmor{
	
	public AceArmor(ArmorMaterial material, int id, int slot, int superID){
		super(material, superID, slot);
		this.setCreativeTab(ShopKeeper.acetabCommon);
		
		if(id == 6 && slot == 0) this.setTextureName(AceCraft.modid + ":ArmorHelmetAdamantium");
		if(id == 1 && slot == 0) this.setTextureName(AceCraft.modid + ":ArmorHelmetAluminium");
		if(id == 3 && slot == 0) this.setTextureName(AceCraft.modid + ":ArmorHelmetBronze");
		if(id == 0 && slot == 0) this.setTextureName(AceCraft.modid + ":ArmorHelmetCopper");
		if(id == 2 && slot == 0) this.setTextureName(AceCraft.modid + ":ArmorHelmetLead");
		if(id == 5 && slot == 0) this.setTextureName(AceCraft.modid + ":ArmorHelmetMythril");
		if(id == 4 && slot == 0) this.setTextureName(AceCraft.modid + ":ArmorHelmetSteel");
		if(id == 7 && slot == 0) this.setTextureName(AceCraft.modid + ":ArmorHelmetUnobtanium");
		
		if(id == 6 && slot == 1) this.setTextureName(AceCraft.modid + ":ArmorChestplateAdamantium");
		if(id == 1 && slot == 1) this.setTextureName(AceCraft.modid + ":ArmorChestplateAluminium");
		if(id == 3 && slot == 1) this.setTextureName(AceCraft.modid + ":ArmorChestplateBronze");
		if(id == 0 && slot == 1) this.setTextureName(AceCraft.modid + ":ArmorChestplateCopper");
		if(id == 2 && slot == 1) this.setTextureName(AceCraft.modid + ":ArmorChestplateLead");
		if(id == 5 && slot == 1) this.setTextureName(AceCraft.modid + ":ArmorChestplateMythril");
		if(id == 4 && slot == 1) this.setTextureName(AceCraft.modid + ":ArmorChestplateSteel");
		if(id == 7 && slot == 1) this.setTextureName(AceCraft.modid + ":ArmorChestplateUnobtanium");
		
		if(id == 6 && slot == 2) this.setTextureName(AceCraft.modid + ":ArmorLegginsAdamantium");
		if(id == 1 && slot == 2) this.setTextureName(AceCraft.modid + ":ArmorLegginsAluminium");
		if(id == 3 && slot == 2) this.setTextureName(AceCraft.modid + ":ArmorLegginsBronze");
		if(id == 0 && slot == 2) this.setTextureName(AceCraft.modid + ":ArmorLegginsCopper");
		if(id == 2 && slot == 2) this.setTextureName(AceCraft.modid + ":ArmorLegginsLead");
		if(id == 5 && slot == 2) this.setTextureName(AceCraft.modid + ":ArmorLegginsMythril");
		if(id == 4 && slot == 2) this.setTextureName(AceCraft.modid + ":ArmorLegginsSteel");
		if(id == 7 && slot == 2) this.setTextureName(AceCraft.modid + ":ArmorLegginsUnobtanium");
		
		if(id == 6 && slot == 3) this.setTextureName(AceCraft.modid + ":ArmorBootsAdamantium");
		if(id == 1 && slot == 3) this.setTextureName(AceCraft.modid + ":ArmorBootsAluminium");
		if(id == 3 && slot == 3) this.setTextureName(AceCraft.modid + ":ArmorBootsBronze");
		if(id == 0 && slot == 3) this.setTextureName(AceCraft.modid + ":ArmorBootsCopper");
		if(id == 2 && slot == 3) this.setTextureName(AceCraft.modid + ":ArmorBootsLead");
		if(id == 5 && slot == 3) this.setTextureName(AceCraft.modid + ":ArmorBootsMythril");
		if(id == 4 && slot == 3) this.setTextureName(AceCraft.modid + ":ArmorBootsSteel");
		if(id == 7 && slot == 3) this.setTextureName(AceCraft.modid + ":ArmorBootsUnobtanium");
	}
	
	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type){
		if(itemstack.getItem() == ShopKeeper.armorHelmetAdamantium)    return AceCraft.modid + ":textures/model/armor/adamantium_layer_1.png";
		if(itemstack.getItem() == ShopKeeper.armorChestplateAdamantium)return AceCraft.modid + ":textures/model/armor/adamantium_layer_1.png";
		if(itemstack.getItem() == ShopKeeper.armorLegginsAdamantium)   return AceCraft.modid + ":textures/model/armor/adamantium_layer_2.png";
		if(itemstack.getItem() == ShopKeeper.armorBootsAdamantium)     return AceCraft.modid + ":textures/model/armor/adamantium_layer_1.png";
		if(itemstack.getItem() == ShopKeeper.armorHelmetAluminium)    return AceCraft.modid + ":textures/model/armor/aluminium_layer_1.png";
		if(itemstack.getItem() == ShopKeeper.armorChestplateAluminium)return AceCraft.modid + ":textures/model/armor/aluminium_layer_1.png";
		if(itemstack.getItem() == ShopKeeper.armorLegginsAluminium)   return AceCraft.modid + ":textures/model/armor/aluminium_layer_2.png";
		if(itemstack.getItem() == ShopKeeper.armorBootsAluminium)     return AceCraft.modid + ":textures/model/armor/aluminium_layer_1.png";
		if(itemstack.getItem() == ShopKeeper.armorHelmetBronze)    return AceCraft.modid + ":textures/model/armor/bronze_layer_1.png";
		if(itemstack.getItem() == ShopKeeper.armorChestplateBronze)return AceCraft.modid + ":textures/model/armor/bronze_layer_1.png";
		if(itemstack.getItem() == ShopKeeper.armorLegginsBronze)   return AceCraft.modid + ":textures/model/armor/bronze_layer_2.png";
		if(itemstack.getItem() == ShopKeeper.armorBootsBronze)     return AceCraft.modid + ":textures/model/armor/bronze_layer_1.png";
		if(itemstack.getItem() == ShopKeeper.armorHelmetCopper)    return AceCraft.modid + ":textures/model/armor/copper_layer_1.png";
		if(itemstack.getItem() == ShopKeeper.armorChestplateCopper)return AceCraft.modid + ":textures/model/armor/copper_layer_1.png";
		if(itemstack.getItem() == ShopKeeper.armorLegginsCopper)   return AceCraft.modid + ":textures/model/armor/copper_layer_2.png";
		if(itemstack.getItem() == ShopKeeper.armorBootsCopper)     return AceCraft.modid + ":textures/model/armor/copper_layer_1.png";
		if(itemstack.getItem() == ShopKeeper.armorHelmetLead)    return AceCraft.modid + ":textures/model/armor/lead_layer_1.png";
		if(itemstack.getItem() == ShopKeeper.armorChestplateLead)return AceCraft.modid + ":textures/model/armor/lead_layer_1.png";
		if(itemstack.getItem() == ShopKeeper.armorLegginsLead)   return AceCraft.modid + ":textures/model/armor/lead_layer_2.png";
		if(itemstack.getItem() == ShopKeeper.armorBootsLead)     return AceCraft.modid + ":textures/model/armor/lead_layer_1.png";
		if(itemstack.getItem() == ShopKeeper.armorHelmetMythril)    return AceCraft.modid + ":textures/model/armor/mythril_layer_1.png";
		if(itemstack.getItem() == ShopKeeper.armorChestplateMythril)return AceCraft.modid + ":textures/model/armor/mythril_layer_1.png";
		if(itemstack.getItem() == ShopKeeper.armorLegginsMythril)   return AceCraft.modid + ":textures/model/armor/mythril_layer_2.png";
		if(itemstack.getItem() == ShopKeeper.armorBootsMythril)     return AceCraft.modid + ":textures/model/armor/mythril_layer_1.png";
		if(itemstack.getItem() == ShopKeeper.armorHelmetSteel)    return AceCraft.modid + ":textures/model/armor/steel_layer_1.png";
		if(itemstack.getItem() == ShopKeeper.armorChestplateSteel)return AceCraft.modid + ":textures/model/armor/steel_layer_1.png";
		if(itemstack.getItem() == ShopKeeper.armorLegginsSteel)   return AceCraft.modid + ":textures/model/armor/steel_layer_2.png";
		if(itemstack.getItem() == ShopKeeper.armorBootsSteel)     return AceCraft.modid + ":textures/model/armor/steel_layer_1.png";
		if(itemstack.getItem() == ShopKeeper.armorHelmetUnobtanium)    return AceCraft.modid + ":textures/model/armor/unobtanium_layer_1.png";
		if(itemstack.getItem() == ShopKeeper.armorChestplateUnobtanium)return AceCraft.modid + ":textures/model/armor/unobtanium_layer_1.png";
		if(itemstack.getItem() == ShopKeeper.armorLegginsUnobtanium)   return AceCraft.modid + ":textures/model/armor/unobtanium_layer_2.png";
		if(itemstack.getItem() == ShopKeeper.armorBootsUnobtanium)     return AceCraft.modid + ":textures/model/armor/unobtanium_layer_1.png";
		return null;
	}
	
	/*
	public void onCreated(ItemStack itemstack, World world, EntityPlayer player){
		Random rand = new Random();
	    if(itemstack.getItem() == ShopKeeper.armorHelmetCopper || itemstack.getItem() == ShopKeeper.armorChestplateCopper || itemstack.getItem() == ShopKeeper.armorLegginsCopper || itemstack.getItem() == ShopKeeper.armorBootsCopper){
	    	if(0 == rand.nextInt(100))
	    		itemstack.addEnchantment(Enchantment.thorns, 1);
	    }
	    if(itemstack.getItem() == ShopKeeper.armorHelmetLead || itemstack.getItem() == ShopKeeper.armorChestplateLead || itemstack.getItem() == ShopKeeper.armorLegginsLead || itemstack.getItem() == ShopKeeper.armorBootsLead){
	    	    	if(30 < rand.nextInt(100))
	    	    		itemstack.addEnchantment(Enchantment.blastProtection, 1);
	    	    }
	    if(itemstack.getItem() == ShopKeeper.armorHelmetMythril){
	    	    	if(35 < rand.nextInt(100))
	    	    		itemstack.addEnchantment(Enchantment.respiration, 1);
	    	    }
	    if(itemstack.getItem() == ShopKeeper.armorHelmetMythril){
	    	    	if(35 < rand.nextInt(100))
	    	    		itemstack.addEnchantment(Enchantment.featherFalling, 1);
	    	    }
	    if(itemstack.getItem() == ShopKeeper.armorHelmetAdamantium || itemstack.getItem() == ShopKeeper.armorChestplateAdamantium || itemstack.getItem() == ShopKeeper.armorLegginsAdamantium || itemstack.getItem() == ShopKeeper.armorBootsAdamantium){
	    	    	if(65 < rand.nextInt(100))
	    	    		itemstack.addEnchantment(Enchantment.fireProtection, 1);
	    	    }
	}
	*/

}