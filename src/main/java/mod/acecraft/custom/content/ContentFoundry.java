package mod.acecraft.custom.content;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ContentFoundry { // Change to METALLURGE
	
	public final String id;
	public final Item result;
	public final Alloy alloy;
	
	public int amount;
	
	public ContentFoundry(String id, Item result, Alloy alloy){
		this.id = id;
		this.result = result;
		this.alloy = alloy;
	}
	
	public boolean isAlloy(){
		return alloy != null;
	}
	
	public ItemStack generateStack(){
		return new ItemStack(result, amount);
	}
	
	public void clear(){
		amount = 0;
	}
	
	
	
}
