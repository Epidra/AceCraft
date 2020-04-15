package mod.acecraft.crafting;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import it.unimi.dsi.fastutil.ints.IntList;
import mod.acecraft.ShopKeeper;
import mod.acecraft.Subscriber;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class RecipeDestille implements IRecipe<IInventory> {

    public static final IRecipeType<RecipeDestille> destille = IRecipeType.register("destille");
    private final IRecipeType<?> type;
    private final ResourceLocation id;
    final String group;
    public final NonNullList<Ingredient> recipeItems;
    final ItemStack result;
    private final boolean isSimple;
    protected final float experience;
    protected final int cookTime;

    public RecipeDestille(ResourceLocation resourceLocation, String group, NonNullList<Ingredient> ingredients, ItemStack result, float experienceIn, int cookTimeIn) {
        type = destille;
        id = resourceLocation;
        this.group = group;
        this.recipeItems = ingredients;
        //this.recipeItems = NonNullList.withSize(2, Ingredient.EMPTY);
        //this.recipeItems.set(0, ingredients.get(0));
        //this.recipeItems.set(1, ingredients.get(1));
        this.result = result;
        this.isSimple = false;//ingredients.stream().allMatch(Ingredient::isSimple);
        this.experience = experienceIn;
        this.cookTime = cookTimeIn;
    }

    public RecipeDestille(ResourceLocation resourceLocation, String group, Ingredient ingredient, ItemStack itemStack) {
        type = destille;
        id = resourceLocation;
        this.group = group;
        this.recipeItems = NonNullList.withSize(2, Ingredient.EMPTY);
        this.result = itemStack;
        this.isSimple = false;//recipeItems.stream().allMatch(Ingredient::isSimple);
        this.experience = 1;
        this.cookTime = 1;
    }

    public float getExperience() {
        return this.experience;
    }

    public int getCookTime() {
        return this.cookTime;
    }

    public boolean matches(IInventory inv, World worldIn) {
        RecipeItemHelper recipeitemhelper = new RecipeItemHelper();
        java.util.List<ItemStack> inputs = new java.util.ArrayList<>();
        int i = 0;

        //for(int j = 0; j < inv.getSizeInventory(); ++j) {
        for(int j = 0; j < 2; ++j) {
            ItemStack itemstack = inv.getStackInSlot(j);
            if (!itemstack.isEmpty()) {
                ++i;
                if (isSimple)
                    recipeitemhelper.func_221264_a(itemstack, 1);
                else inputs.add(itemstack);
            }
        }

        return i == this.recipeItems.size() && (isSimple ? recipeitemhelper.canCraft(this, (IntList)null) : net.minecraftforge.common.util.RecipeMatcher.findMatches(inputs,  this.recipeItems) != null);
    }

    //@Override
    //public boolean matches(IInventory inv, @Nonnull World worldIn) {
    //    return this.recipeItems.test(inv.getStackInSlot(0));
    //}

    @Override
    @Nonnull
    public ItemStack getCraftingResult(@Nullable IInventory inv) {
        return this.result.copy();
    }

    @Override
    public boolean canFit(int width, int height) {
        return true;
    }

    @Override
    @Nonnull
    public ItemStack getRecipeOutput() {
        return result;
    }

    @Override
    @Nonnull
    public ResourceLocation getId() {
        return id;
    }

    @Override
    @Nonnull
    public IRecipeSerializer<?> getSerializer() {
        //noinspection ConstantConditions
        return Subscriber.serializerDestille;
    }

    @Override
    @Nonnull
    public IRecipeType<?> getType() {
        return type;
    }

    @Override
    @Nonnull
    public NonNullList<Ingredient> getIngredients() {
        //NonNullList<Ingredient> nonnulllist = NonNullList.create();
        //nonnulllist.add(this.recipeItems);
        return recipeItems;
    }

    @Override
    @Nonnull
    public ItemStack getIcon() {
        return new ItemStack(ShopKeeper.MACHINA_DESTILLERY);
    }

    public static ItemStack deserializeItem(JsonObject p_199798_0_) {
        String s = JSONUtils.getString(p_199798_0_, "item");
        Item item = Registry.ITEM.getValue(new ResourceLocation(s)).orElseThrow(() -> {
            return new JsonSyntaxException("Unknown item '" + s + "'");
        });
        if (p_199798_0_.has("data")) {
            throw new JsonParseException("Disallowed data tag found");
        } else {
            int i = JSONUtils.getInt(p_199798_0_, "count", 1);
            return net.minecraftforge.common.crafting.CraftingHelper.getItemStack(p_199798_0_, true);
        }
    }
}
