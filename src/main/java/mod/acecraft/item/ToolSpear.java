package mod.acecraft.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class ToolSpear extends SwordItem {

    // ...





    //----------------------------------------CONSTRUCTOR----------------------------------------//

    /** Default Constructor */
    public ToolSpear(Tier tier, int attackDamageIn, float attackSpeedIn) {
        super(tier, attackDamageIn, attackSpeedIn, new Properties().tab(CreativeModeTab.TAB_TOOLS));
    }



}
