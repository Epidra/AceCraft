package mod.acecraft.container;

import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;

import javax.annotation.Nullable;

public abstract class ContainerBase extends Container {

    protected ContainerBase(@Nullable ContainerType<?> type, int id) {
        super(type, id);
    }

    public abstract String getName();
}
