package mod.acecraft.items;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemGroup;

public class ItemArmor extends ArmorItem {

    public ItemArmor(IArmorMaterial materialIn, EquipmentSlotType slot) {
        super(materialIn, slot, new Properties().group(ItemGroup.COMBAT));
    }

}
