package mod.acecraft.items;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ItemArmorColor extends ArmorItem {

    public ItemArmorColor(String modid, String name, IArmorMaterial materialIn, EquipmentSlotType slot) {
        super(materialIn, slot, new Properties().group(ItemGroup.COMBAT));
        this.setRegistryName(modid, name);
    }

    @Nullable
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        String domain = "acecraft";
        int curFrame = getCurrentSpectriteFrame(entity.getEntityWorld());
        return String.format("%s:textures/models/armor/aurorite_layer_%d/%d.png", domain, Integer.valueOf(slot == EquipmentSlotType.LEGS ? 2 : 1), Integer.valueOf(curFrame));
    }

    public static int getCurrentSpectriteFrame(World worldIn) {
        if (worldIn == null) {
            return Math.round((float)((System.currentTimeMillis() >> 6) % 24L));
        }
        float time = MathHelper.abs((float)((worldIn.getGameTime() >> 1) % 24L) * 0.2777F * 1000.0F) / 10000.0F;
        return Math.round(time * 24.0F);
    }
}
