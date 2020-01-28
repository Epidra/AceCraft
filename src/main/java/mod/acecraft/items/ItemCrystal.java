package mod.acecraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemCrystal extends Item {
	
	public ItemCrystal(String name){
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.MATERIALS);
		
		setHasSubtypes(true); // This allows the item to be marked as a metadata item.
        setMaxDamage(0); // This makes it so your item doesn't have the damage bar at the bottom of its icon, when "damaged" similar to the Tools.
	}
	
}
