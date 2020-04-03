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
    public ContainerDestille(int id, PlayerInventory player, TileEntityDestille container, IIntArray furnaceData) {
        super(ShopKeeper.TYPE_DESTILLE, id, player, (IInventory)container, furnaceData);
        addPlayerSlots(player);
        addOwnSlots(player);
    }

    // For Forge Registry
    public ContainerDestille(int id, PlayerInventory playerInventory, PacketBuffer packetBuffer) {
        super(ShopKeeper.TYPE_DESTILLE, id, playerInventory);
        addPlayerSlots(playerInventory);
        addOwnSlots(playerInventory);
    }

    /** Adds Container Speific Blocks **/
    private void addOwnSlots(PlayerInventory playerInventory) { // for container specifig slots
        this.addSlot(new Slot(furnaceInventory, 0, 56, 17));
        this.addSlot(new SlotFuel(this, furnaceInventory, 1, 56, 53));
        this.addSlot(new FurnaceResultSlot(playerInventory.player, furnaceInventory, 2, 116, 35));
        this.addSlot(new Slot(furnaceInventory, 3, 37, 17));
    }

}
