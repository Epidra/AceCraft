package mod.acecraft.crafting;

import mod.acecraft.ShopKeeper;
import net.minecraft.block.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class RecipeStove extends SingleItemRecipe implements IRecipe<IInventory> /* extends AbstractCookingRecipe*/ {
    public RecipeStove(IRecipeType<?> p_i50023_1_, IRecipeSerializer<?> p_i50023_2_, ResourceLocation p_i50023_3_, String p_i50023_4_, Ingredient p_i50023_5_, ItemStack p_i50023_6_) {
        super(p_i50023_1_, p_i50023_2_, p_i50023_3_, p_i50023_4_, p_i50023_5_, p_i50023_6_);
    }

    @Override
    public boolean matches(IInventory inv, World worldIn) {
        return false;
    }

    // public RecipeStove(ResourceLocation p_i50031_1_, String p_i50031_2_, Ingredient p_i50031_3_, ItemStack p_i50031_4_, float p_i50031_5_, int p_i50031_6_) {
   //     super(ShopKeeper.STOVING, p_i50031_1_, p_i50031_2_, p_i50031_3_, p_i50031_4_, p_i50031_5_, p_i50031_6_);
   // }
//
   // public ItemStack getIcon() {
   //     return new ItemStack(ShopKeeper.MACHINA_DESTILLERY);
   // }
//
   // public IRecipeSerializer<?> getSerializer() {
   //     return IRecipeSerializer.BLASTING;
   // }
}
