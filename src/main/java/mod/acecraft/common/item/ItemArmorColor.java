package mod.acecraft.common.item;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class ItemArmorColor extends ArmorItem {

    // ...
    
    
    
    
    
    // ---------- ---------- ---------- ----------  CONSTRUCTOR  ---------- ---------- ---------- ---------- //

    /** Default Constructor */
    public ItemArmorColor(ArmorMaterial material, Type slot) {
        super(material, slot, new Properties());
    }
    
    
    
    
    
    // ---------- ---------- ---------- ----------  SUPPORT  ---------- ---------- ---------- ---------- //

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        String domain = "acecraft";
        int curFrame = getCurrentFrame(entity.getCommandSenderWorld());
        return String.format("%s:textures/models/armor/aurorite_layer_%d/%d.png", domain, slot == EquipmentSlot.LEGS ? 2 : 1, curFrame);
    }
    
    public static int getCurrentFrame(Level level) {
        return Math.round((float)((System.currentTimeMillis() >> 6) % 24L));
    }



}
