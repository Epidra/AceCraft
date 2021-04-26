package mod.acecraft.container;

import mod.acecraft.ShopKeeper;
import mod.acecraft.util.LogicFoundry;
import mod.lucky77.container.ContainerBase;
import mod.lucky77.tileentities.TileBase;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;

public class ContainerFoundry extends ContainerBase {

    // ...




    //----------------------------------------CONSTRUCTOR----------------------------------------//

    /** Default Constructor **/
    public ContainerFoundry(int windowID, PlayerInventory playerInventory, TileBase tile) {
        super(ShopKeeper.CONTAINER_FOUNDRY.get(), windowID, playerInventory, tile);
    }

    /** Forge Registry Constructor **/
    public ContainerFoundry(int windowID, PlayerInventory playerInventory, PacketBuffer packetBuffer) {
        super(ShopKeeper.CONTAINER_FOUNDRY.get(), windowID, playerInventory, packetBuffer);
    }




    //----------------------------------------SUPPORT----------------------------------------//

    @Override
    protected void createInventory(TileBase tile, PlayerInventory player) {
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

    public int getCookTime(){
        return data.get(1);
    }

    public int getCookTimeMax(){
        return data.get(2);
    }

    public BlockPos pos() {
        return pos;
    }

    public LogicFoundry logic(){
        return (LogicFoundry) this.logic;
    }

}
