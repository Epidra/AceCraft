package mod.acecraft.util;

import java.util.function.Supplier;

import mod.acecraft.ShopKeeper;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum MaterialArmor implements IArmorMaterial {

    GILIUM    ("acecraft:gilium",     15, new int[]{1, 4, 5, 2},  9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, () -> { return Ingredient.of(ShopKeeper.INGOT_GILIUM.get());     }),
    ADAMANTIUM("acecraft:adamantium", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, () -> { return Ingredient.of(ShopKeeper.INGOT_ADAMANTIUM.get()); }),
    MYTHRIL   ("acecraft:mythril",    15, new int[]{1, 4, 5, 2},  9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, () -> { return Ingredient.of(ShopKeeper.INGOT_MYTHRIL.get());    }),
    ORICHALCUM("acecraft:orichalcum", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, () -> { return Ingredient.of(ShopKeeper.INGOT_ORICHALCUM.get()); }),
    COPPER    ("acecraft:copper",     15, new int[]{1, 4, 5, 2},  9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, () -> { return Ingredient.of(ShopKeeper.INGOT_COPPER.get());     }),
    BRONZE    ("acecraft:bronze",     25, new int[]{3, 6, 7, 3}, 12, SoundEvents.ARMOR_EQUIP_CHAIN, 0.0F, () -> { return Ingredient.of(ShopKeeper.INGOT_BRONZE.get());     }),
    STEEL     ("acecraft:steel",      25, new int[]{3, 6, 7, 3}, 12, SoundEvents.ARMOR_EQUIP_CHAIN, 0.0F, () -> { return Ingredient.of(ShopKeeper.INGOT_STEEL.get());      }),
    AURORITE  ("acecraft:aurorite",   33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, () -> { return Ingredient.of(ShopKeeper.STUFF_AURORITE.get());   });

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    //private final LazyLoadBase<Ingredient> repairMaterial;

    private MaterialArmor(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountsIn, int enchantabilityIn, SoundEvent equipSoundIn, float p_i48533_8_, Supplier<Ingredient> repairMaterialSupplier) {
        this.name = nameIn;
        this.maxDamageFactor = maxDamageFactorIn;
        this.damageReductionAmountArray = damageReductionAmountsIn;
        this.enchantability = enchantabilityIn;
        this.soundEvent = equipSoundIn;
        this.toughness = p_i48533_8_;
       // this.repairMaterial = new LazyLoadBase<>(repairMaterialSupplier);
    }

    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlotType slot) {
        return MAX_DAMAGE_ARRAY[slot.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlotType slot) {
        return this.damageReductionAmountArray[slot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(ShopKeeper.INGOT_BRASS.get());
    }

    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}