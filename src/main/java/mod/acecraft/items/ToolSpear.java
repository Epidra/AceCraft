package mod.acecraft.items;

import net.minecraft.item.*;

public class ToolSpear extends SwordItem {

    // ...





    //----------------------------------------CONSTRUCTOR----------------------------------------//

    /** Default Constructor */
    public ToolSpear(IItemTier tier, int attackDamageIn, float attackSpeedIn) {
        super(tier, attackDamageIn, attackSpeedIn, new Properties().tab(ItemGroup.TAB_TOOLS));
    }



}
