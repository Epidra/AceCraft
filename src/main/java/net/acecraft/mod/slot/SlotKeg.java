package net.acecraft.mod.slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class SlotKeg extends Slot {
	
	public SlotKeg(EntityPlayer player, IInventory inventory, int i, int j, int k) {
		super(inventory, i, j, k);
	}

}