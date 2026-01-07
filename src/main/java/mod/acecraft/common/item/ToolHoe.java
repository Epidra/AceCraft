package mod.acecraft.common.item;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;

public class ToolHoe extends HoeItem {
	
	public ToolHoe(Tier tier, float attackDamage, float attackSpeed){
		super(tier, new Item.Properties().attributes(HoeItem.createAttributes(tier, attackDamage, attackSpeed)));
	}
	
}
