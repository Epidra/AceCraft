package mod.acecraft.client.menu;

import mod.acecraft.Register;
import mod.acecraft.util.recipe.RecipeDistillery;
import mod.lucky77.block.entity.BlockEntityBase;
import mod.lucky77.menu.MenuBase;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MenuDistillery extends MenuBase {
	
	private final RecipeType<? extends RecipeDistillery> recipeType = RecipeDistillery.Type.INSTANE;
	
	
	
	
	// ---------- ---------- ---------- ----------  CONSTRUCTOR  ---------- ---------- ---------- ---------- //
	
	/** Default Constructor **/
	public MenuDistillery(int windowID, Inventory playerInventory, BlockEntityBase tile) {
		super(Register.MENU_DISTILLERY.get(), windowID, playerInventory, tile);
		
	}
	
	/** Forge Registry Constructor **/
	public MenuDistillery(int windowID, Inventory playerInventory, FriendlyByteBuf packetBuffer) {
		super(Register.MENU_DISTILLERY.get(), windowID, playerInventory, BlockPos.of(packetBuffer.readLong()));
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SUPPORT  ---------- ---------- ---------- ---------- //
	
	@Override
	protected void createInventory(Container tile, Inventory player) {
		this.addSlot(new Slot(tile, 0,  37, 17)); // INPUT 1
		this.addSlot(new Slot(tile, 1,  56, 17)); // INPUT 2
		this.addSlot(new Slot(tile, 2,  56, 53)); // FUEL
		this.addSlot(new Slot(tile, 3, 116, 35)); // OUTPUT
		addPlayerSlots(player);
	}
	
	@OnlyIn(Dist.CLIENT)
	public int getCookingProgress() {
		int i = this.data.get(2); // Process
		int j = this.data.get(3); // Total Time
		return i / 10;
		// return j != 0 && i != 0 ? i * 24 / j : 0;
	}
	
	@OnlyIn(Dist.CLIENT)
	public int getBurnProgress() {
		int i = this.data.get(0); // Process
		int j = this.data.get(1); // Total Time
		if (j == 0) {
			j = 200;
		}
		
		return i * 13 / j;
	}
	
	public boolean isLit() {
		return this.data.get(0) > 0;
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
