package mod.acecraft.container;

import mod.acecraft.tileentities.TileFoundry;
import mod.acecraft.tileentities.TileBase;
import mod.acecraft.tileentities.TileDistillery;
import mod.acecraft.tileentities.TileCookingBoard;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.util.text.ITextComponent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ContainerProvider implements INamedContainerProvider {

    public TileBase te;

    public ContainerProvider(@Nonnull TileBase tile) {
        this.te = tile;
    }

    @Nullable
    @Override
    public Container createMenu(int windowId, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        if(this.te instanceof TileFoundry) return new ContainerFoundry(windowId, playerInventory, this.te);
        if(this.te instanceof TileDistillery) return new ContainerDistillery(windowId, playerInventory, this.te);
        if(this.te instanceof TileCookingBoard) return new ContainerCookingBoard(windowId, playerInventory, this.te);
        return null;
    }

    @Override
    public ITextComponent getDisplayName() {
        return this.te.getName();
    }

}
