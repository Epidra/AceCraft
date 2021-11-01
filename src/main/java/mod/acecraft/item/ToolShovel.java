package mod.acecraft.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;

public class ToolShovel extends ShovelItem {

    // ...





    //----------------------------------------CONSTRUCTOR----------------------------------------//

    /** Default Constructor */
    public ToolShovel(Tier tier, float attackDamageIn, float attackSpeedIn) {
        super(tier, attackDamageIn, attackSpeedIn, new Properties().tab(CreativeModeTab.TAB_TOOLS));
    }



}
