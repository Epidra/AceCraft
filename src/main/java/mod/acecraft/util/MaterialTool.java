package mod.acecraft.util;

import java.util.function.Supplier;

import mod.acecraft.ShopKeeper;
import net.minecraft.block.Blocks;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.LazyLoadBase;

public enum MaterialTool implements IItemTier {

    BRASS     (4, 2000, 10.0F, 4.0F, 15, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_BRASS);      }),
    QUESTORIUM(4, 2000, 10.0F, 4.0F, 15, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_QUESTORIUM); }),
    GILIUM    (4, 2000, 10.0F, 4.0F, 15, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_GILIUM);     }),
    ADAMANTIUM(4, 2000, 10.0F, 4.0F, 15, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_ADAMANTIUM); }),
    VIRIDIUM  (4, 2000, 10.0F, 4.0F, 15, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_VIRIDIUM);   }),
    ZINC      (4, 2000, 10.0F, 4.0F, 15, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_ZINC);       }),
    KOBALIUM  (4, 2000, 10.0F, 4.0F, 15, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_KOBALIUM);   }),
    DENARIUM  (4, 2000, 10.0F, 4.0F, 15, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_DENARIUM);   }),
    MYTHRIL   (4, 2000, 10.0F, 4.0F, 15, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_MYTHRIL);    }),
    CLAVIUM   (4, 2000, 10.0F, 4.0F, 15, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_CLAVIUM);    }),
    AURELIUM  (4, 2000, 10.0F, 4.0F, 15, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_AURELIUM);   }),
    NIVIDIUM  (4, 2000, 10.0F, 4.0F, 15, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_NIVIDIUM);   }),
    TIN       (4, 2000, 10.0F, 4.0F, 15, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_TIN);        }),
    ORICHALCUM(4, 2000, 10.0F, 4.0F, 15, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_ORICHALCUM); }),
    SCARLETITE(4, 2000, 10.0F, 4.0F, 15, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_SCARLETITE); }),
    COPPER    (4, 2000, 10.0F, 4.0F, 15, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_COPPER);     }),
    BRONZE    (4, 2000, 10.0F, 4.0F, 15, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_BRONZE);     }),
    STEEL     (4, 2000, 10.0F, 4.0F, 15, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_STEEL);      }),
    DARKSTEEL (4, 2000, 10.0F, 4.0F, 15, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_DARKSTEEL);  }),
    UNOBTANIUM(4, 2000, 10.0F, 4.0F, 15, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_UNOBTANIUM); }),
    AURORITE  (4, 2000, 10.0F, 4.0F, 15, () -> { return Ingredient.fromItems(ShopKeeper.GEM_AURORITE);     });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyLoadBase<Ingredient> repairMaterial;

    private MaterialTool(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn) {
        this.harvestLevel = harvestLevelIn;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantability = enchantabilityIn;
        this.repairMaterial = new LazyLoadBase<>(repairMaterialIn);
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