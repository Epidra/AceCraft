package mod.acecraft.tileentities;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.IIntArray;
import net.minecraft.util.text.ITextComponent;

public abstract class TileBase extends TileEntity implements ITickableTileEntity, INamedContainerProvider, IInventory {

    public TileBase(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public abstract ITextComponent getName();
    
    public abstract IIntArray getIntArray();

    public abstract boolean isItemValid(ItemStack stack);
}
