package mod.acecraft.util;

import java.util.function.Supplier;

import mod.acecraft.ShopKeeper;
import net.minecraft.block.Blocks;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;

public enum MaterialTool implements IItemTier {

    BRASS     (0, 32, 12.0F, 0.0F, 22, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_BRASS);      }),
    GILIUM    (2, 250, 6.0F, 2.0F, 14, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_GILIUM);     }),
    ADAMANTIUM(3, 1561, 8.0F, 3.0F, 10, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_ADAMANTIUM); }),
    MYTHRIL   (0, 32, 12.0F, 0.0F, 22, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_MYTHRIL);    }),
    ORICHALCUM(3, 1561, 8.0F, 3.0F, 10, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_ORICHALCUM); }),
    COPPER    (1, 131, 4.0F, 1.0F, 5, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_COPPER);     }),
    BRONZE    (2, 250, 6.0F, 2.0F, 14, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_BRONZE);     }),
    STEEL     (2, 250, 6.0F, 2.0F, 14, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_STEEL);      }),
    AURORITE  (3, 1561, 8.0F, 3.0F, 10, () -> { return Ingredient.fromItems(ShopKeeper.STUFF_AURORITE);   });

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

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(ShopKeeper.INGOT_BRASS);
    }

    // public Ingredient getRepairMaterial() {
     //   return this.repairMaterial.getValue();
    //}
}