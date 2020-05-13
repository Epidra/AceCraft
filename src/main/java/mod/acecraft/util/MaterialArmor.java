package mod.acecraft.util;

import mod.acecraft.ShopKeeper;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum MaterialArmor implements IArmorMaterial {

    BRASS     ("acecraft:brass",      7, new int[]{1, 3, 5, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F, () -> { return Ingredient.fromItems(ShopKeeper.ITEM_BRASS.get());      }),
    GILIUM    ("acecraft:gilium",     15, new int[]{1, 4, 5, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, () -> { return Ingredient.fromItems(ShopKeeper.ITEM_GILIUM.get());     }),
    ADAMANTIUM("acecraft:adamantium", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, () -> { return Ingredient.fromItems(ShopKeeper.ITEM_ADAMANTIUM.get()); }),
    MYTHRIL   ("acecraft:mythril",    15, new int[]{1, 4, 5, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, () -> { return Ingredient.fromItems(ShopKeeper.ITEM_MYTHRIL.get());    }),
    ORICHALCUM("acecraft:orichalcum", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, () -> { return Ingredient.fromItems(ShopKeeper.ITEM_ORICHALCUM.get()); }),
    COPPER    ("acecraft:copper",     15, new int[]{1, 4, 5, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F, () -> { return Ingredient.fromItems(ShopKeeper.ITEM_COPPER.get());     }),
    BRONZE    ("acecraft:bronze",     25, new int[]{3, 6, 7, 3}, 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0F, () -> { return Ingredient.fromItems(ShopKeeper.ITEM_BRONZE.get());     }),
    STEEL     ("acecraft:steel",      25, new int[]{3, 6, 7, 3}, 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0F, () -> { return Ingredient.fromItems(ShopKeeper.ITEM_STEEL.get());      }),
    AURORITE  ("acecraft:aurorite",   33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F, () -> { return Ingredient.fromItems(ShopKeeper.ITEM_AURORITE.get());   });

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final LazyValue<Ingredient> repairMaterial;

    private MaterialArmor(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountsIn, int enchantabilityIn, SoundEvent equipSoundIn, float p_i48533_8_, Supplier<Ingredient> repairMaterialSupplier) {
        this.name = nameIn;
        this.maxDamageFactor = maxDamageFactorIn;
        this.damageReductionAmountArray = damageReductionAmountsIn;
        this.enchantability = enchantabilityIn;
        this.soundEvent = equipSoundIn;
        this.toughness = p_i48533_8_;
        this.repairMaterial = new LazyValue<>(repairMaterialSupplier);
    }

    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }

    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }
}