package mod.acecraft.items;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ItemArmorColor extends ArmorItem {

    // ...




    //----------------------------------------CONSTRUCTOR----------------------------------------//

    /** Default Constructor */
    public ItemArmorColor(IArmorMaterial materialIn, EquipmentSlotType slot) {
        super(materialIn, slot, new Properties().tab(ItemGroup.TAB_COMBAT));
    }




    //----------------------------------------SUPPORT----------------------------------------//

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        String domain = "acecraft";
        int curFrame = getCurrentFrame(entity.getCommandSenderWorld());
        return String.format("%s:textures/models/armor/aurorite_layer_%d/%d.png", domain, slot == EquipmentSlotType.LEGS ? 2 : 1, curFrame);
    }

    public static int getCurrentFrame(World worldIn) {
        return Math.round((float)((System.currentTimeMillis() >> 6) % 24L));
    }

}
