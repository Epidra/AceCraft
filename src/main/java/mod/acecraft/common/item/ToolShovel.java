package mod.acecraft.common.item;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;

public class ToolShovel extends ShovelItem {
	
	public ToolShovel(Tier tier, float attackDamage, float attackSpeed){
		super(tier, new Item.Properties().attributes(ShovelItem.createAttributes(tier, attackDamage, attackSpeed)));
	}
	
}
