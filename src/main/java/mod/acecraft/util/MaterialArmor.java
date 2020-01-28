package mod.acecraft.util;

import java.util.function.Supplier;

import mod.acecraft.ShopKeeper;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyLoadBase;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum MaterialArmor implements IArmorMaterial {

    BRASS     ("acecraft:brass",      10, new int[]{5, 5, 5, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_BRASS);      }),
    QUESTORIUM("acecraft:questorium", 10, new int[]{5, 5, 5, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_QUESTORIUM); }),
    GILIUM    ("acecraft:gilium",     10, new int[]{5, 5, 5, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_GILIUM);     }),
    ADAMANTIUM("acecraft:adamantium", 10, new int[]{5, 5, 5, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_ADAMANTIUM); }),
    VIRIDIUM  ("acecraft:viridium",   10, new int[]{5, 5, 5, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_VIRIDIUM);   }),
    ZINC      ("acecraft:zinc",       10, new int[]{5, 5, 5, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_ZINC);       }),
    KOBALIUM  ("acecraft:kobalium",   10, new int[]{5, 5, 5, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_KOBALIUM);   }),
    DENARIUM  ("acecraft:denarium",   10, new int[]{5, 5, 5, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_DENARIUM);   }),
    MYTHRIL   ("acecraft:mythril",    10, new int[]{5, 5, 5, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_MYTHRIL);    }),
    CLAVIUM   ("acecraft:clavium",    10, new int[]{5, 5, 5, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_CLAVIUM);    }),
    AURELIUM  ("acecraft:aurelium",   10, new int[]{5, 5, 5, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_AURELIUM);   }),
    NIVIDIUM  ("acecraft:nividium",   10, new int[]{5, 5, 5, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_NIVIDIUM);   }),
    TIN       ("acecraft:tin",        10, new int[]{5, 5, 5, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_TIN);        }),
    ORICHALCUM("acecraft:orichalcum", 10, new int[]{5, 5, 5, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_ORICHALCUM); }),
    SCARLETITE("acecraft:scarletite", 10, new int[]{5, 5, 5, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_SCARLETITE); }),
    COPPER    ("acecraft:copper",     10, new int[]{5, 5, 5, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_COPPER);     }),
    BRONZE    ("acecraft:bronze",     10, new int[]{5, 5, 5, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_BRONZE);     }),
    STEEL     ("acecraft:steel",      10, new int[]{5, 5, 5, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_STEEL);      }),
    DARKSTEEL ("acecraft:darksteel",  10, new int[]{5, 5, 5, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_DARKSTEEL);  }),
    UNOBTANIUM("acecraft:unobtanium", 10, new int[]{5, 5, 5, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, () -> { return Ingredient.fromItems(ShopKeeper.INGOT_UNOBTANIUM); }),
    AURORITE  ("acecraft:aurorite",   10, new int[]{5, 5, 5, 5}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0f, () -> { return Ingredient.fromItems(ShopKeeper.GEM_AURORITE);     });

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final LazyLoadBase<Ingredient> repairMaterial;

    private MaterialArmor(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountsIn, int enchantabilityIn, SoundEvent equipSoundIn, float p_i48533_8_, Supplier<Ingredient> repairMaterialSupplier) {
        this.name = nameIn;
        this.maxDamageFactor = maxDamageFactorIn;
        this.damageReductionAmountArray = damageReductionAmountsIn;
        this.enchantability = enchantabilityIn;
        this.soundEvent = equipSoundIn;
        this.toughness = p_i48533_8_;
        this.repairMaterial = new LazyLoadBase<>(repairMaterialSupplier);
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