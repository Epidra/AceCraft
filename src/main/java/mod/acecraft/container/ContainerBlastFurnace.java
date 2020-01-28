package mod.acecraft.container;

import com.google.common.collect.Lists;
import mod.acecraft.ShopKeeper;
import mod.acecraft.slots.SlotFurnaceFuel;
import mod.acecraft.tileentities.TileBlastFurnace;
import mod.acecraft.util.FoundryContent;
import mod.shared.container.ContainerFlamer;
import mod.shared.util.ContainerContent;
import mod.shared.util.SlotFuel;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.FurnaceResultSlot;
import net.minecraft.inventory.container.IContainerListener;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IntReferenceHolder;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class ContainerBlastFurnace extends ContainerFlamer {

    public ContainerBlastFurnace(int id, PlayerInventory player, TileBlastFurnace container, IIntArray furnaceData, ContainerContent materials) {
        super(ShopKeeper.TYPE_BLASTFURNACE, id, player, (IInventory)container, furnaceData, materials);
    }

    // For Forge Registry
    public ContainerBlastFurnace(int id, PlayerInventory playerInventory, PacketBuffer packetBuffer) {
        super(ShopKeeper.TYPE_BLASTFURNACE, id, playerInventory);
    }

    /** Adds Container Speific Blocks **/
    private void addOwnSlots(PlayerInventory playerInventory) { // for container specifig slots
        this.addSlot(new Slot(furnaceInventory, 0, 94, 5));
        this.addSlot(new SlotFuel(this, furnaceInventory, 1, 94, 60));
        this.addSlot(new FurnaceResultSlot(playerInventory.player, furnaceInventory, 2, 116, 35));
    }



}
