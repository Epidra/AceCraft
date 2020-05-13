package mod.acecraft.items;

import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;

public class ToolHoe extends HoeItem {

    public ToolHoe(IItemTier tier, float attackSpeedIn) {
        super(tier, attackSpeedIn, new Properties().group(ItemGroup.TOOLS));
    }

}
