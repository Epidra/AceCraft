package mod.acecraft.items;

import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;

public class ToolSword extends SwordItem {

    public ToolSword(String modid, String name, IItemTier tier, int attackDamageIn, float attackSpeedIn) {
        super(tier, attackDamageIn, attackSpeedIn, new Properties().group(ItemGroup.COMBAT));
        this.setRegistryName(modid, name);
    }

}
