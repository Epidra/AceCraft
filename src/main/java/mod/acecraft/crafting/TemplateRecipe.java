package mod.acecraft.crafting;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.SingleItemRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class TemplateRecipe extends SingleItemRecipe {
    public TemplateRecipe(IRecipeType<?> p_i50023_1_, IRecipeSerializer<?> p_i50023_2_, ResourceLocation p_i50023_3_, String p_i50023_4_, Ingredient p_i50023_5_, ItemStack p_i50023_6_) {
        super(p_i50023_1_, p_i50023_2_, p_i50023_3_, p_i50023_4_, p_i50023_5_, p_i50023_6_);
    }

    @Override
    public boolean matches(IInventory inv, World worldIn) {
        return false;
    }

    //public WoodcuttingRecipe(ResourceLocation id, String group, Ingredient ingredient, ItemStack result) {
    //    super(ModRecipeTypes.WOODCUTTING, ModRecipeSerializers.WOODCUTTING, id, group, ingredient, result);
    //}

    //@Override
    //public boolean matches(IInventory inv, World worldIn) {
    //    return this.ingredient.test(inv.getStackInSlot(0));
    //}

    //@Override
    //public ItemStack getIcon() {
    //    return ModBlocks.createRandomStack();
    //}

}
