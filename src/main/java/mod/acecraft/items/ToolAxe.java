package mod.acecraft.items;

import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;

public class ToolAxe extends AxeItem {

    public ToolAxe(String modid, String name, IItemTier tier, float attackDamageIn, float attackSpeedIn) {
        super(tier, attackDamageIn, attackSpeedIn, new Properties().group(ItemGroup.TOOLS));
        this.setRegistryName(modid, name);
    }
}
