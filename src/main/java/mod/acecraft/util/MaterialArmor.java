package mod.acecraft.util;

import mod.acecraft.Register;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum MaterialArmor implements ArmorMaterial {
	GILIUM    ("acecraft:gilium",     15, new int[]{1, 4, 5, 2},  9, SoundEvents.ARMOR_EQUIP_IRON,      0.0F, 0.0f, () -> Ingredient.of(Register.INGOT_GILIUM.get())),
	ADAMANTIUM("acecraft:adamantium", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ARMOR_EQUIP_NETHERITE, 2.0F, 0.0f, () -> Ingredient.of(Register.INGOT_ADAMANTIUM.get())),
	MYTHRIL   ("acecraft:mythril",    15, new int[]{1, 4, 5, 2},  9, SoundEvents.ARMOR_EQUIP_GOLD,      0.0F, 0.0f, () -> Ingredient.of(Register.INGOT_MYTHRIL.get())),
	ORICHALCUM("acecraft:orichalcum", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ARMOR_EQUIP_CHAIN,     2.0F, 0.0f, () -> Ingredient.of(Register.INGOT_ORICHALCUM.get())),
	BRONZE    ("acecraft:bronze",     25, new int[]{3, 6, 7, 3}, 12, SoundEvents.ARMOR_EQUIP_CHAIN,     0.0F, 0.0f, () -> Ingredient.of(Register.INGOT_BRONZE.get())),
	AURORITE  ("acecraft:aurorite",   33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ARMOR_EQUIP_DIAMOND,   2.0F, 0.0f, () -> Ingredient.of(Register.STUFF_AURORITE.get()));
	
	private final String name;
	private final int durabilityMultiplier;
	private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
	private final int enchantmentValue;
	private final SoundEvent sound;
	private final float toughness;
	private final float knockbackResistance;
	private final LazyLoadedValue<Ingredient> repairIngredient;
	
	
	
	
	
	// ---------- ---------- ---------- ----------  CONSTRUCTOR  ---------- ---------- ---------- ---------- //
	
	private MaterialArmor(String _name, int _durabilityModifier, int[] _protection, int _enchantmentValue, SoundEvent _sound, float _toughness, float _knockbackResistance, Supplier<Ingredient> _repairIngredient) {
		this.name = _name;
		this.durabilityMultiplier = _durabilityModifier;
		this.protectionFunctionForType = Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266655_) -> {
			p_266655_.put(ArmorItem.Type.BOOTS,      _protection[0]);
			p_266655_.put(ArmorItem.Type.LEGGINGS,   _protection[1]);
			p_266655_.put(ArmorItem.Type.CHESTPLATE, _protection[2]);
			p_266655_.put(ArmorItem.Type.HELMET,     _protection[3]);
		});
		this.enchantmentValue    = _enchantmentValue;
		this.sound               = _sound;
		this.toughness           = _toughness;
		this.knockbackResistance = _knockbackResistance;
		this.repairIngredient = new LazyLoadedValue<>(_repairIngredient);
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SUPPORT  ---------- ---------- ---------- ---------- //
	
	public int getDurabilityForType(ArmorItem.Type type) {
		return HEALTH_FUNCTION_FOR_TYPE.get(type) * this.durabilityMultiplier;
	}
	
	public int getDefenseForType(ArmorItem.Type type) {
		return this.protectionFunctionForType.get(type);
	}
	
	public int getEnchantmentValue() {
		return this.enchantmentValue;
	}
	
	public SoundEvent getEquipSound() {
		return this.sound;
	}
	
	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}
	
	public String getName() {
		return this.name;
	}
	
	public float getToughness() {
		return this.toughness;
	}
	
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}
	
	public String getSerializedName() {
		return this.name;
	}
	
	private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266653_) -> {
		p_266653_.put(ArmorItem.Type.BOOTS,      13);
		p_266653_.put(ArmorItem.Type.LEGGINGS,   15);
		p_266653_.put(ArmorItem.Type.CHESTPLATE, 16);
		p_266653_.put(ArmorItem.Type.HELMET,     11);
	});
	
	
	
}