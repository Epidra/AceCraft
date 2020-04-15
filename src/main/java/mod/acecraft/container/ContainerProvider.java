package mod.acecraft.container;

import mod.acecraft.tileentities.TileBlastFurnace;
import mod.acecraft.tileentities.TileEntityBase;
import mod.acecraft.tileentities.TileEntityDestille;
import mod.acecraft.tileentities.TileEntityStove;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.util.text.ITextComponent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ContainerProvider implements INamedContainerProvider {

    public TileEntityBase te;

    public ContainerProvider(@Nonnull TileEntityBase tile) {
        this.te = tile;
    }

    @Nullable
    @Override
    public Container createMenu(int windowId, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        if(this.te instanceof TileBlastFurnace) return new ContainerBlastFurnace(windowId, playerInventory, this.te);
        if(this.te instanceof TileEntityDestille) return new ContainerDestille(windowId, playerInventory, this.te);
        if(this.te instanceof TileEntityStove) return new ContainerStove(windowId, playerInventory, this.te);
        return null;
    }

    @Override
    public ITextComponent getDisplayName() {
        return this.te.getName();
    }

}
