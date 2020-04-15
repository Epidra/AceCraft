package mod.acecraft.container;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.RecipeBookContainer;

import javax.annotation.Nullable;

public abstract class ContainerBaseRecipe extends RecipeBookContainer<IInventory> {

    protected ContainerBaseRecipe(@Nullable ContainerType<?> type, int id) {
        super(type, id);
    }

    public abstract String getName();
}
