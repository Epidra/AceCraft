package mod.acecraft.items;

import javax.annotation.Nullable;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ItemArmorColor extends net.minecraft.item.ItemArmor {
	
	public ItemArmorColor(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.COMBAT);
	}
	
	@Nullable
	  public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
	  {
	    String domain = "acecraft";
	    int curFrame = getCurrentSpectriteFrame(entity.getEntityWorld());
	    
	    return String.format("%s:textures/models/armor/aurorite_layer_%d/%d.png", domain, Integer.valueOf(slot == EntityEquipmentSlot.LEGS ? 2 : 1), Integer.valueOf(curFrame));
	  }
	
	
	public static int getCurrentSpectriteFrame(World worldIn)
	  {
	    if (worldIn == null) {
	      return Math.round((float)((System.currentTimeMillis() >> 6) % 24L));
	    }
	    float time = MathHelper.abs((float)((worldIn.getTotalWorldTime() >> 1) % 24L) * 0.2777F * 1000.0F) / 10000.0F;
	    
	    return Math.round(time * 24.0F);
	  }
	
}
