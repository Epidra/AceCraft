package mod.acecraft.crafting;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class RecipeStoveSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<RecipeStove> {

    private final RecipeStoveSerializer.IFactory<RecipeStove> factory;

    public RecipeStoveSerializer(RecipeStoveSerializer.IFactory<RecipeStove> factory) {
        this.factory = factory;
    }

    public RecipeStove read(ResourceLocation recipeId, JsonObject json) {
        String s = JSONUtils.getString(json, "group", "");
        NonNullList<Ingredient> nonnulllist = readIngredients(JSONUtils.getJsonArray(json, "ingredients"));
        if (nonnulllist.isEmpty()) {
            throw new JsonParseException("No ingredients for shapeless recipe");
        } else if (nonnulllist.size() > 5) {
            throw new JsonParseException("Too many ingredients for shapeless recipe the max is " + 5);
        } else {
            ItemStack itemstack = RecipeStove.deserializeItem(JSONUtils.getJsonObject(json, "result"));
            return new RecipeStove(recipeId, s, nonnulllist, itemstack);
        }
    }

    private static NonNullList<Ingredient> readIngredients(JsonArray p_199568_0_) {
        NonNullList<Ingredient> nonnulllist = NonNullList.create();

        for(int i = 0; i < p_199568_0_.size(); ++i) {
            Ingredient ingredient = Ingredient.deserialize(p_199568_0_.get(i));
            if (!ingredient.hasNoMatchingItems()) {
                nonnulllist.add(ingredient);
            }
        }

        return nonnulllist;
    }

    public RecipeStove read(ResourceLocation recipeId, PacketBuffer buffer) {
        String s = buffer.readString(32767);
        int i = buffer.readVarInt();
        NonNullList<Ingredient> nonnulllist = NonNullList.withSize(i, Ingredient.EMPTY);

        for(int j = 0; j < nonnulllist.size(); ++j) {
            nonnulllist.set(j, Ingredient.read(buffer));
        }

        ItemStack itemstack = buffer.readItemStack();
        return new RecipeStove(recipeId, s, nonnulllist, itemstack);
    }

    public void write(PacketBuffer buffer, RecipeStove recipe) {
        buffer.writeString(recipe.group);
        buffer.writeVarInt(recipe.recipeItems.size());

        for(Ingredient ingredient : recipe.recipeItems) {
            ingredient.write(buffer);
        }

        buffer.writeItemStack(recipe.result);
    }

    //@Override
    //@Nonnull
    //public RecipeStove read(@Nonnull ResourceLocation recipeId, @Nonnull JsonObject json) {
    //    String s = JSONUtils.getString(json, "group", "");
    //    JsonElement jsonelement = JSONUtils.isJsonArray(json, "ingredient")
    //            ? JSONUtils.getJsonArray(json, "ingredient")
    //            : JSONUtils.getJsonObject(json, "ingredient");
    //    Ingredient ingredient = Ingredient.deserialize(jsonelement);
    //    ItemStack itemstack;
    //    if (!json.has("result")) {
    //        throw new com.google.gson.JsonSyntaxException("Missing result, expected to find a string or object");
    //    }
    //    if (json.get("result").isJsonObject()) {
    //        itemstack = ShapedRecipe.deserializeItem(JSONUtils.getJsonObject(json, "result"));
    //    } else {
    //        String s1 = JSONUtils.getString(json, "result");
    //        ResourceLocation resourcelocation = new ResourceLocation(s1);
    //        //noinspection deprecation
    //        itemstack = new ItemStack(Registry.ITEM.getValue(resourcelocation).orElseThrow(() -> new IllegalStateException("Item: " + s1 + " does not exist")));
    //    }
    //    return this.factory.create(recipeId, s, ingredient, itemstack);
    //}
//
    //@Nullable
    //@Override
    //public RecipeStove read(@Nonnull ResourceLocation recipeId, PacketBuffer buffer) {
    //    String s = buffer.readString(32767);
    //    Ingredient ingredient = Ingredient.read(buffer);
    //    ItemStack itemstack = buffer.readItemStack();
    //    return this.factory.create(recipeId, s, ingredient, itemstack);
    //}
//
    //@Override
    //public void write(PacketBuffer buffer, RecipeStove recipe) {
    //    buffer.writeString(recipe.group);
    //    recipe.ingredient.write(buffer);
    //    buffer.writeItemStack(recipe.result);
    //}

    public interface IFactory<T extends RecipeStove> {
        T create(ResourceLocation resourceLocation, String group, Ingredient ingredient, ItemStack result);
    }
}
