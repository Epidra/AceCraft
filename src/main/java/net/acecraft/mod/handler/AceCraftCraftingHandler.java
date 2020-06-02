package net.acecraft.mod.handler;

import net.acecraft.mod.ShopKeeper;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;

public class AceCraftCraftingHandler {
	
	@SubscribeEvent
	public void onCrafting(ItemCraftedEvent event){
		final IInventory craftMatrix = null;
		for(int i = 0; i < event.craftMatrix.getSizeInventory(); i++){
			if(event.craftMatrix.getStackInSlot(i) != null){
				ItemStack item0 = event.craftMatrix.getStackInSlot(i);
				if(item0 != null){
					if(item0.getItem() == ShopKeeper.toolFryingPan){
						ItemStack k = new ItemStack(ShopKeeper.toolFryingPan, 1, (item0.getItemDamage() + 1));
						if(k.getItemDamage() >= k.getMaxDamage()){
							k.stackSize--;
						}
						event.craftMatrix.setInventorySlotContents(i, k);
					}
				}
			}
		}
	}
	
}
