package mod.acecraft.common.item;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

public class ToolPickaxe extends PickaxeItem {
	
	public ToolPickaxe(Tier tier, float attackDamage, float attackSpeed){
		super(tier, new Item.Properties().attributes(PickaxeItem.createAttributes(tier, attackDamage, attackSpeed)));
	}
	
}
