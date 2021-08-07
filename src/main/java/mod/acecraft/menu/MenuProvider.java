package mod.acecraft.menu;

import mod.acecraft.blockentity.BlockEntityDistillery;
import mod.acecraft.blockentity.BlockEntityFoundry;
import mod.lucky77.blockentity.BlockEntityBase;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class MenuProvider implements net.minecraft.world.MenuProvider {

    public BlockEntityBase tile;




    //----------------------------------------CONSTRUCTOR----------------------------------------//

    public MenuProvider(@Nonnull BlockEntityBase tile) {
        this.tile = tile;
    }




    //----------------------------------------FUNCTION----------------------------------------//

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int windowId, Inventory playerInventory, Player playerEntity) {
        if(this.tile instanceof BlockEntityDistillery){ return new MenuDistillery(windowId, playerInventory, this.tile); }
        if(this.tile instanceof BlockEntityFoundry){    return new MenuFoundry(   windowId, playerInventory, this.tile); }
        return null;
    }




    //----------------------------------------SUPPORT----------------------------------------//

    @Override
    public TextComponent getDisplayName() {
        return this.tile.getName();
    }

}
