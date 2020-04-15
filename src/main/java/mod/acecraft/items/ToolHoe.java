package mod.acecraft.items;

import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;

public class ToolHoe extends HoeItem {

    public ToolHoe(String modid, String name, IItemTier tier, float attackSpeedIn) {
        super(tier, attackSpeedIn, new Properties().group(ItemGroup.TOOLS));
        this.setRegistryName(modid, name);
    }

}
