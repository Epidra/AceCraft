package mod.acecraft.client.menu;

import mod.acecraft.Register;
import mod.acecraft.client.logic.LogicFoundry;
import mod.lucky77.block.entity.BlockEntityBase;
import mod.lucky77.menu.MenuBase;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class MenuFoundry extends MenuBase {
	
	// ...
	
	
	
	
	
	// ---------- ---------- ---------- ----------  CONSTRUCTOR  ---------- ---------- ---------- ---------- //
	
	/** Default Constructor **/
	public MenuFoundry(int windowID, Inventory playerInventory, BlockEntityBase tile) {
		super(Register.MENU_FOUNDRY.get(), windowID, playerInventory, tile);
	}
	
	/** Forge Registry Constructor **/
	public MenuFoundry(int windowID, Inventory playerInventory, FriendlyByteBuf packetBuffer) {
		super(Register.MENU_FOUNDRY.get(), windowID, playerInventory, BlockPos.of(packetBuffer.readLong()));
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  LOGIC  ---------- ---------- ---------- ---------- //
	
	public LogicFoundry logic(){
		return (LogicFoundry) this.logic;
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SUPPORT  ---------- ---------- ---------- ---------- //
	
	@Override
	protected void createInventory(Container tile, Inventory player) {
		this.addSlot(new Slot(tile, 0,  62, 11)); // INPUT
		this.addSlot(new Slot(tile, 1,  75, 57)); // OUTPUT 1
		this.addSlot(new Slot(tile, 2,  91, 57)); // OUTPUT 2
		this.addSlot(new Slot(tile, 3, 107, 57)); // OUTPUT 3
		this.addSlot(new Slot(tile, 4, 123, 57)); // OUTPUT 4
		this.addSlot(new Slot(tile, 5, 139, 57)); // OUTPUT 5
		addPlayerSlots(player);
	}
	
	public int getCoal(){
		return data.get(0);
	}
	
	public boolean getEject(){
		return data.get(3) == 1;
	}
	
	public int getCookTime(){
		return data.get(1);
	}
	
	public int getCookTimeMax(){
		return data.get(2);
	}
	
	public BlockPos pos() {
		return pos;
	}
	
	public ItemStack quickMoveStack(Player player, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(index);
		if (slot != null && slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (index == 2) {
				if (!this.moveItemStackTo(itemstack1, 3, 39, true)) {
					return ItemStack.EMPTY;
				}
				slot.onQuickCraft(itemstack1, itemstack);
			} else if (index != 1 && index != 0) {
				if (!this.moveItemStackTo(itemstack1, 0, 3, false)) {
					return ItemStack.EMPTY;
				}
				if (index >= 3 && index < 30) {
					if (!this.moveItemStackTo(itemstack1, 30, 39, false)) {
						return ItemStack.EMPTY;
					}
				} else if (index >= 30 && index < 39 && !this.moveItemStackTo(itemstack1, 3, 30, false)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.moveItemStackTo(itemstack1, 3, 39, false)) {
				return ItemStack.EMPTY;
			}
			if (itemstack1.isEmpty()) {
				slot.set(ItemStack.EMPTY);
			} else {
				slot.setChanged();
			}
			if (itemstack1.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}
			slot.onTake(player, itemstack1);
		}
		return itemstack;
	}
	
	
	
}
