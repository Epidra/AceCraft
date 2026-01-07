package mod.acecraft.common.item;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class ToolSword extends SwordItem {
	
	public ToolSword(Tier tier, int attackDamage, float attackSpeed){
		super(tier, new Item.Properties().attributes(SwordItem.createAttributes(tier, attackDamage, attackSpeed)));
	}
	
}
