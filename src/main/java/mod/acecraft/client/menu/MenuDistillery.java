package mod.acecraft.client.menu;

import mod.acecraft.Register;
import mod.lucky77.client.menu.MenuBase;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class MenuDistillery extends MenuBase {
	
	// Client Menu Contructor
	public MenuDistillery(int containerID, Inventory playerInventory, FriendlyByteBuf buffer){
		this(containerID, playerInventory, buffer.readBlockPos());
	}
	
	// Server Menu Constructor
	public MenuDistillery(int containerID, Inventory playerInventory, BlockPos pos){
		super(Register.MENU_DISTILLERY.get(), containerID, playerInventory, pos);
	}
	
	@Override
	protected void createInventory(Container container, Inventory player){
		this.addSlot(new Slot(container, 0, 37, 17)); // INPUT 1
		this.addSlot(new Slot(container, 1, 56, 17)); // INPUT 2
		this.addSlot(new Slot(container, 2, 56, 53)); // FUEL
		this.addSlot(new Slot(container, 3, 116, 35)); // OUTPUT
		addPlayerSlots(player);
	}
	
	// @OnlyIn(Dist.CLIENT)
	public int getCookingProgress(){
		int i = this.data.get(2); // Current Time
		int j = this.data.get(3); // Total Time
		return i / 10;
	}
	
	// @OnlyIn(Dist.CLIENT)
	public int getBurnProgress(){
		int i = this.data.get(0); // Current Time
		int j = this.data.get(1); // Total Time
		if(j == 0){
			j = 200;
		}
		return i * 13 / j;
	}
	
	public boolean isLit(){
		return this.data.get(0) > 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	// MOVE INTO BASE
	// Crashes on shift-clicking
	
	// Assume we have a data inventory of size 5
// The inventory has 4 inputs (index 1 - 4) which outputs to a result slot (index 0)
// We also have the 27 player inventory slots and the 9 hotbar slots
// As such, the actual slots are indexed like so:
//   - Data Inventory: Result (0), Inputs (1 - 4)
//   - Player Inventory (5 - 31)
//   - Player Hotbar (32 - 40)
	@Override
	public ItemStack quickMoveStack(Player player, int quickMovedSlotIndex) {
		// The quick moved slot stack
		ItemStack quickMovedStack = ItemStack.EMPTY;
		// The quick moved slot
		Slot quickMovedSlot = this.slots.get(quickMovedSlotIndex);
		
		// If the slot is in the valid range and the slot is not empty
		if (quickMovedSlot != null && quickMovedSlot.hasItem()) {
			// Get the raw stack to move
			ItemStack rawStack = quickMovedSlot.getItem();
			// Set the slot stack to a copy of the raw stack
			quickMovedStack = rawStack.copy();

        /*
        The following quick move logic can be simplified to if in data inventory,
        try to move to player inventory/hotbar and vice versa for containers
        that cannot transform data (e.g. chests).
        */
			
			// If the quick move was performed on the data inventory result slot
			if (quickMovedSlotIndex == 0) {
				// Try to move the result slot into the player inventory/hotbar
				if (!this.moveItemStackTo(rawStack, 5, 41, true)) {
					// If cannot move, no longer quick move
					return ItemStack.EMPTY;
				}
				
				// Perform logic on result slot quick move
				quickMovedSlot.onQuickCraft(rawStack, quickMovedStack);
			}
			// Else if the quick move was performed on the player inventory or hotbar slot
			else if (quickMovedSlotIndex >= 5 && quickMovedSlotIndex < 41) {
				// Try to move the inventory/hotbar slot into the data inventory input slots
				if (!this.moveItemStackTo(rawStack, 1, 5, false)) {
					// If cannot move and in player inventory slot, try to move to hotbar
					if (quickMovedSlotIndex < 32) {
						if (!this.moveItemStackTo(rawStack, 32, 41, false)) {
							// If cannot move, no longer quick move
							return ItemStack.EMPTY;
						}
					}
					// Else try to move hotbar into player inventory slot
					else if (!this.moveItemStackTo(rawStack, 5, 32, false)) {
						// If cannot move, no longer quick move
						return ItemStack.EMPTY;
					}
				}
			}
			// Else if the quick move was performed on the data inventory input slots, try to move to player inventory/hotbar
			else if (!this.moveItemStackTo(rawStack, 5, 41, false)) {
				// If cannot move, no longer quick move
				return ItemStack.EMPTY;
			}
			
			if (rawStack.isEmpty()) {
				// If the raw stack has completely moved out of the slot, set the slot to the empty stack
				quickMovedSlot.set(ItemStack.EMPTY);
			} else {
				// Otherwise, notify the slot that that the stack count has changed
				quickMovedSlot.setChanged();
			}

        /*
        The following if statement and Slot#onTake call can be removed if the
        menu does not represent a container that can transform stacks (e.g.
        chests).
        */
			if (rawStack.getCount() == quickMovedStack.getCount()) {
				// If the raw stack was not able to be moved to another slot, no longer quick move
				return ItemStack.EMPTY;
			}
			// Execute logic on what to do post move with the remaining stack
			quickMovedSlot.onTake(player, rawStack);
		}
		
		return quickMovedStack; // Return the slot stack
	}
	
}
