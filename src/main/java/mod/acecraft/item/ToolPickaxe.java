package mod.acecraft.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class ToolPickaxe extends PickaxeItem {

    // ...




    //----------------------------------------CONSTRUCTOR----------------------------------------//

    /** Default Constructor */
    public ToolPickaxe(Tier tier, int attackDamageIn, float attackSpeedIn) {
        super(tier, attackDamageIn, attackSpeedIn, new Properties().tab(CreativeModeTab.TAB_TOOLS));
    }

}
