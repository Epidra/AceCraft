package mod.acecraft.common.item;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;

public class ItemArmor extends ArmorItem {
	
	public ItemArmor(Holder<ArmorMaterial> material, Type slot){
		super(material, slot, new Properties());
	}
	
}
