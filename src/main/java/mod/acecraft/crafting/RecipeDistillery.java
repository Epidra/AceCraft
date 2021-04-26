package mod.acecraft.crafting;

import mod.acecraft.ShopKeeper;
import mod.lucky77.crafting.RecipeBase;
import mod.lucky77.tileentities.TileBase;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class RecipeDistillery extends RecipeBase {

    protected final ResourceLocation id;
    protected final ItemStack result;
    protected final String group;
    protected final float experience;
    protected final Ingredient ingredient;




    //----------------------------------------CONSTRUCTOR----------------------------------------//

    public RecipeDistillery(ResourceLocation id, Ingredient ingredient, ItemStack item, String group, float experienceIn, int cookTimeIn) {
        super(cookTimeIn);
        this.id = id;
        this.ingredient = ingredient;
        this.result = item;
        this.group = group;
        this.experience = experienceIn;
    }




    //----------------------------------------SUPPORT----------------------------------------//

    @Override
    public boolean matches(TileBase tile, World p_77569_2_) {
        return this.ingredient.test(tile.getItem(0)) && this.ingredient.test(tile.getItem(1));
    }

    @Override
    public ItemStack assemble(TileBase p_77572_1_) {
        return this.result.copy();
    }

    public boolean canCraftInDimensions(int p_194133_1_, int p_194133_2_) {
        return true;
    }

    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> nonnulllist = NonNullList.create();
        nonnulllist.add(this.ingredient);
        return nonnulllist;
    }

    public float getExperience() {
        return this.experience;
    }

    public ItemStack getResultItem() {
        return this.result;
    }

    public String getGroup() {
        return this.group;
    }

    public int getCookingTime() {
        return this.cookTime;
    }

    public ResourceLocation getId() {
        return this.id;
    }

    public IRecipeType<?> getType() {
        return ShopKeeper.RECIPE_DISTILLERY;
    }

    public ItemStack getToastSymbol() {
        return new ItemStack(Blocks.FURNACE);
    }

    public IRecipeSerializer<?> getSerializer() {
        return ShopKeeper.SERIALIZER_DISTILLERY.get();
    }

}
