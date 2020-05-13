package mod.acecraft.util;

import mod.acecraft.ShopKeeper;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;

import java.util.function.Supplier;

public enum MaterialTool implements IItemTier {

    BRASS     (0, 32, 12.0F, 0.0F, 22, () -> { return Ingredient.fromItems(ShopKeeper.ITEM_BRASS.get());      }),
    GILIUM    (2, 250, 6.0F, 2.0F, 14, () -> { return Ingredient.fromItems(ShopKeeper.ITEM_GILIUM.get());     }),
    ADAMANTIUM(3, 1561, 8.0F, 3.0F, 10, () -> { return Ingredient.fromItems(ShopKeeper.ITEM_ADAMANTIUM.get()); }),
    MYTHRIL   (0, 32, 12.0F, 0.0F, 22, () -> { return Ingredient.fromItems(ShopKeeper.ITEM_MYTHRIL.get());    }),
    ORICHALCUM(3, 1561, 8.0F, 3.0F, 10, () -> { return Ingredient.fromItems(ShopKeeper.ITEM_ORICHALCUM.get()); }),
    COPPER    (1, 131, 4.0F, 1.0F, 5, () -> { return Ingredient.fromItems(ShopKeeper.ITEM_COPPER.get());     }),
    BRONZE    (2, 250, 6.0F, 2.0F, 14, () -> { return Ingredient.fromItems(ShopKeeper.ITEM_BRONZE.get());     }),
    STEEL     (2, 250, 6.0F, 2.0F, 14, () -> { return Ingredient.fromItems(ShopKeeper.ITEM_STEEL.get());      }),
    AURORITE  (3, 1561, 8.0F, 3.0F, 10, () -> { return Ingredient.fromItems(ShopKeeper.ITEM_AURORITE.get());   });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;

    private MaterialTool(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
        this.harvestLevel = harvestLevelIn;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantability = enchantabilityIn;
        this.repairMaterial = new LazyValue<>(repairMaterialIn);
    }

    public int getMaxUses() {
        return this.maxUses;
    }

    public float getEfficiency() {
        return this.efficiency;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }
}