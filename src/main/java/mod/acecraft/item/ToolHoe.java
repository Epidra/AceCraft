package mod.acecraft.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Tier;

public class ToolHoe extends HoeItem {

    // ...





    //----------------------------------------CONSTRUCTOR----------------------------------------//

    /** Default Constructor */
    public ToolHoe(Tier tier, int attackDamageIn, float attackSpeedIn) {
        super(tier, attackDamageIn, attackSpeedIn, new Properties().tab(CreativeModeTab.TAB_TOOLS));
    }



}
