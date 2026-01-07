package mod.acecraft.common.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.*;

public class ToolAxe extends AxeItem {
	
	public ToolAxe(Tier tier, float attackDamage, float attackSpeed){
		super(tier, new Item.Properties().attributes(AxeItem.createAttributes(tier, attackDamage, attackSpeed)));
	}
	
}
