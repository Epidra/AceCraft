package mod.acecraft.container;

import mod.acecraft.tileentities.TileDistillery;
import mod.acecraft.tileentities.TileFoundry;
import mod.lucky77.tileentities.TileBase;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.util.text.ITextComponent;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ContainerProvider implements INamedContainerProvider {

    public TileBase tile;





    //----------------------------------------CONSTRUCTOR----------------------------------------//

    public ContainerProvider(@Nonnull TileBase tile) {
        this.tile = tile;
    }





    //----------------------------------------CREATE----------------------------------------//

    @Nullable
    @Override
    public Container createMenu(int windowId, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        if(this.tile instanceof TileDistillery){ return new ContainerDistillery(windowId, playerInventory, this.tile); }
        if(this.tile instanceof TileFoundry){    return new ContainerFoundry(   windowId, playerInventory, this.tile); }
        return null;
    }





    //----------------------------------------BASIC----------------------------------------//

    @Override
    public ITextComponent getDisplayName() {
        return this.tile.getName();
    }



}
