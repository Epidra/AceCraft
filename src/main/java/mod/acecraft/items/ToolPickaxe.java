package mod.acecraft.items;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;

public class ToolPickaxe extends PickaxeItem {

    public ToolPickaxe(String modid, String name, IItemTier tier, int attackDamageIn, float attackSpeedIn) {
        super(tier, attackDamageIn, attackSpeedIn, new Properties().group(ItemGroup.TOOLS));
        this.setRegistryName(modid, name);
    }

}
