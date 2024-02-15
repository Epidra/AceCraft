package mod.acecraft.util;

import mod.acecraft.Register;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum MaterialTool implements Tier {
	
	GILIUM    (2,  250,  6.0F, 2.0F, 14, () -> Ingredient.of(Register.INGOT_GILIUM.get())),
	ADAMANTIUM(3, 1561,  8.0F, 3.0F, 10, () -> Ingredient.of(Register.INGOT_ADAMANTIUM.get())),
	MYTHRIL   (0,   32, 12.0F, 0.0F, 22, () -> Ingredient.of(Register.INGOT_MYTHRIL.get())),
	ORICHALCUM(3, 1561,  8.0F, 3.0F, 10, () -> Ingredient.of(Register.INGOT_ORICHALCUM.get())),
	BRONZE    (2,  250,  6.0F, 2.0F, 14, () -> Ingredient.of(Register.INGOT_BRONZE.get())),
	AURORITE  (3, 1561,  8.0F, 3.0F, 10, () -> Ingredient.of(Register.STUFF_AURORITE.get()));
	
	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int enchantability;
	private final LazyLoadedValue<Ingredient> repairIngredient;
	
	
	
	
	
	// ---------- ---------- ---------- ----------  CONSTRUCTOR  ---------- ---------- ---------- ---------- //
	
	private MaterialTool(int _harvestLevel, int _maxUses, float _efficiency, float _attackDamage, int _enchantability, Supplier<Ingredient> _repairMaterial) {
		this.harvestLevel   = _harvestLevel;
		this.maxUses        = _maxUses;
		this.efficiency     = _efficiency;
		this.attackDamage   = _attackDamage;
		this.enchantability = _enchantability;
		this.repairIngredient = new LazyLoadedValue<>(_repairMaterial);
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SUPPORT  ---------- ---------- ---------- ---------- //
	
	@Override
	public int getUses() {
		return this.maxUses;
	}
	
	@Override
	public float getSpeed() {
		return this.efficiency;
	}
	
	@Override
	public float getAttackDamageBonus() {
		return this.attackDamage;
	}
	
	@Override
	public int getLevel() {
		return this.harvestLevel;
	}
	
	@Override
	public int getEnchantmentValue() {
		return this.enchantability;
	}
	
	@Override
	public Ingredient getRepairIngredient() {
		return this.repairIngredient.get();
	}
	
	
	
}