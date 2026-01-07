package mod.acecraft.custom.material;

import mod.acecraft.AceCraft;
import mod.acecraft.Register;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class MaterialArmor {
	
	// ERROR:
	// when using search function in creative inventory
	// java.lang.NullPointerException: Trying to access unbound value: ResourceKey[minecraft:armor_material / acecraft:mythril]
	
	
	
	public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIAL_DEFERRED = DeferredRegister.create(Registries.ARMOR_MATERIAL, AceCraft.MODID);
	
	public static Holder<ArmorMaterial> BRONZE = register("bronze", Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 3);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.CHESTPLATE, 8);
		map.put(ArmorItem.Type.HELMET, 3);
	}), 14, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.of(Register.STUFF_BRONZE_INGOT.get()));
	
	public static Holder<ArmorMaterial> GILIUM = register("gilium", Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 3);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.CHESTPLATE, 8);
		map.put(ArmorItem.Type.HELMET, 3);
	}), 14, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.of(Register.STUFF_GILIUM_INGOT.get()));
	
	public static Holder<ArmorMaterial> MYTHRIL = register("mythril", Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 3);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.CHESTPLATE, 8);
		map.put(ArmorItem.Type.HELMET, 3);
	}), 14, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.of(Register.STUFF_MYTHRIL_INGOT.get()));
	
	public static Holder<ArmorMaterial> ADAMANTIUM = register("adamantium", Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 3);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.CHESTPLATE, 8);
		map.put(ArmorItem.Type.HELMET, 3);
	}), 14, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.of(Register.STUFF_ADAMANTIUM_INGOT.get()));
	
	public static Holder<ArmorMaterial> ORICHALCUM = register("orichalcum", Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 3);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.CHESTPLATE, 8);
		map.put(ArmorItem.Type.HELMET, 3);
	}), 14, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.of(Register.STUFF_ORICHALCUM_INGOT.get()));
	
	public static Holder<ArmorMaterial> AURORITE = register("aurorite", Util.make(new EnumMap<>(ArmorItem.Type.class), (map) -> {
		map.put(ArmorItem.Type.BOOTS, 3);
		map.put(ArmorItem.Type.LEGGINGS, 6);
		map.put(ArmorItem.Type.CHESTPLATE, 8);
		map.put(ArmorItem.Type.HELMET, 3);
	}), 14, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> Ingredient.of(Register.STUFF_AURORITE.get()));
	
	private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> defense, int enchantmentValue, Holder<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient){
		EnumMap<ArmorItem.Type, Integer> armorTypeMap = new EnumMap<>(ArmorItem.Type.class);
		ResourceLocation location = ResourceLocation.fromNamespaceAndPath(AceCraft.MODID, name);
		
		for(ArmorItem.Type armoritem$type : ArmorItem.Type.values()){
			armorTypeMap.put(armoritem$type, defense.get(armoritem$type));
		}
		
		List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(location));
		
		return ARMOR_MATERIAL_DEFERRED.register(name, () -> new ArmorMaterial(armorTypeMap, enchantmentValue, equipSound, repairIngredient, list, toughness, knockbackResistance));
	}
	
}
