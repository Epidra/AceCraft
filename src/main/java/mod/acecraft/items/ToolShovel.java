package mod.acecraft.items;

import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ShovelItem;

public class ToolShovel extends ShovelItem {

    public ToolShovel(IItemTier tier, float attackDamageIn, float attackSpeedIn) {
        super(tier, attackDamageIn, attackSpeedIn, new Properties().group(ItemGroup.TOOLS));
    }

}
