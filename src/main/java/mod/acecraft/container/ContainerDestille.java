package mod.acecraft.container;

import mod.acecraft.ShopKeeper;
import mod.acecraft.slots.SlotFurnaceFuelDestille;
import mod.acecraft.tileentities.TileEntityDestille;
import mod.shared.container.ContainerFlamer;
import mod.shared.util.ContainerContent;
import mod.shared.util.SlotFuel;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.IRecipeHelperPopulator;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IntArray;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ContainerDestille extends ContainerFlamer {

    // Main Constructor
    public ContainerDestille(int id, PlayerInventory player, TileEntityDestille container, IIntArray furnaceData, ContainerContent materials) {
        super(ShopKeeper.TYPE_DESTILLE, id, player, (IInventory)container, furnaceData, materials);
        //super(ShopKeeper.TYPE_DESTILLE, id);
    }

    // For Forge Registry
    public ContainerDestille(int id, PlayerInventory playerInventory, PacketBuffer packetBuffer) {
        super(ShopKeeper.TYPE_DESTILLE, id, playerInventory);
    }

    //public ContainerDestille(int windowId, PlayerInventory playerInventory, PacketBuffer extraData) {
    //    this(windowId, playerInventory, (BaseCreatureEntity)playerInventory.player.getEntityWorld().getEntityByID(extraData.readInt()));
    //}

  //  /**
  //   * Main Constructor
  //   * @param windowId The window id for the gui screen to use.
  //   * @param playerInventory The accessing player's inventory.
  //   * @param creature The creature to access.
  //   */
  //  public ContainerDestille(int windowId, PlayerInventory playerInventory, BaseCreatureEntity creature) {
  //      super(ShopKeeper.TYPE_DESTILLE, windowId);
  //      this.creature = creature;
//
  //      // Player Inventory:
  //      this.addPlayerSlots(playerInventory, 0, 0);
//
  //      // Creature Equipment:
  //      this.specialStart = this.inventorySlots.size();
  //      this.drawCreatureEquipment(creature, 8, 18);
  //      this.specialFinish = this.inventorySlots.size() - 1;
//
  //      // Creature Inventory
  //      this.inventoryStart = this.inventorySlots.size();
  //      if(creature.inventory.getItemSlotsSize() > 0)
  //          this.addSlotsByColumn(creature.inventory, 8 + (18 * 4), 18, 5, 0, creature.inventory.getActiveItemSlotsSize() - 1);
  //      this.inventoryFinish = this.inventorySlots.size() - 1;
  //  }

    //public ContainerDestille(int i, PlayerInventory playerInventory, PacketBuffer packetBuffer) {
   //     super();
   // }


    /** Adds Container Speific Blocks **/
    private void addOwnSlots(PlayerInventory playerInventory) { // for container specifig slots
        this.addSlot(new Slot(furnaceInventory, 0, 56, 17));
        this.addSlot(new SlotFuel(this, furnaceInventory, 1, 56, 53));
        this.addSlot(new FurnaceResultSlot(playerInventory.player, furnaceInventory, 2, 116, 35));
        this.addSlot(new Slot(furnaceInventory, 3, 37, 17));
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return false;
    }
}
