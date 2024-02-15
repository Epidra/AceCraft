package mod.acecraft.system;

import mod.acecraft.client.menu.MenuDistillery;
import mod.acecraft.client.menu.MenuFoundry;
import mod.acecraft.common.block.entity.*;
import mod.lucky77.block.entity.BlockEntityBase;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class MenuProvider implements net.minecraft.world.MenuProvider {
	
	public BlockEntityBase tile;
	
	
	
	
	
	// ---------- ---------- ---------- ----------  CONSTRUCTOR  ---------- ---------- ---------- ---------- //
	
	public MenuProvider(@Nonnull BlockEntityBase tile) {
		this.tile = tile;
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  CREATE MENU  ---------- ---------- ---------- ---------- //
	
	@Nullable
	@Override
	public AbstractContainerMenu createMenu(int windowId, Inventory playerInventory, Player playerEntity) {
		if(this.tile instanceof BlockEntityDistillery){
			return new MenuDistillery(windowId, playerInventory, this.tile);
		} else {
			return new MenuFoundry(   windowId, playerInventory, this.tile);
		}
		
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SUPPORT  ---------- ---------- ---------- ---------- //
	
	@Override
	public Component getDisplayName() {
		return Component.empty();
	}
	
}