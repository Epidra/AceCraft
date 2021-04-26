package mod.acecraft.util;

import java.util.function.Supplier;

import mod.acecraft.ShopKeeper;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public enum MaterialTool implements IItemTier {

    GILIUM    (2, 250, 6.0F, 2.0F, 14, () -> { return Ingredient.of(ShopKeeper.INGOT_GILIUM.get());     }),
    ADAMANTIUM(3, 1561, 8.0F, 3.0F, 10, () -> { return Ingredient.of(ShopKeeper.INGOT_ADAMANTIUM.get()); }),
    MYTHRIL   (0, 32, 12.0F, 0.0F, 22, () -> { return Ingredient.of(ShopKeeper.INGOT_MYTHRIL.get());    }),
    ORICHALCUM(3, 1561, 8.0F, 3.0F, 10, () -> { return Ingredient.of(ShopKeeper.INGOT_ORICHALCUM.get()); }),
    COPPER    (1, 131, 4.0F, 1.0F, 5, () -> { return Ingredient.of(ShopKeeper.INGOT_COPPER.get());     }),
    BRONZE    (2, 250, 6.0F, 2.0F, 14, () -> { return Ingredient.of(ShopKeeper.INGOT_BRONZE.get());     }),
    STEEL     (2, 250, 6.0F, 2.0F, 14, () -> { return Ingredient.of(ShopKeeper.INGOT_STEEL.get());      }),
    AURORITE  (3, 1561, 8.0F, 3.0F, 10, () -> { return Ingredient.of(ShopKeeper.STUFF_AURORITE.get());   });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    //private final LazyLoadBase<Ingredient> repairMaterial;

    private MaterialTool(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
        this.harvestLevel = harvestLevelIn;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantability = enchantabilityIn;
      //  this.repairMaterial = new LazyLoadBase<>(repairMaterialIn);
    }

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
        return Ingredient.of(ShopKeeper.INGOT_BRASS.get());
    }

    // public Ingredient getRepairMaterial() {
     //   return this.repairMaterial.getValue();
    //}
}