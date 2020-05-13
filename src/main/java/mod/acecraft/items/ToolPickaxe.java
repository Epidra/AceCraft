package mod.acecraft.items;

import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;

public class ToolPickaxe extends PickaxeItem {

    public ToolPickaxe(IItemTier tier, int attackDamageIn, float attackSpeedIn) {
        super(tier, attackDamageIn, attackSpeedIn, new Properties().group(ItemGroup.TOOLS));
    }

}
