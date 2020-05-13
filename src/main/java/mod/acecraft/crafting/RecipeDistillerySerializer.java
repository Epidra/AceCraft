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

public class RecipeDistillerySerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<RecipeDistillery> {

    private final int cookingTime;

    private final RecipeDistillerySerializer.IFactory<RecipeDistillery> factory;

    public RecipeDistillerySerializer(RecipeDistillerySerializer.IFactory<RecipeDistillery> factory) {
        this.factory = factory;
        this.cookingTime = 200;
    }

    public RecipeDistillery read(ResourceLocation recipeId, JsonObject json) {
        String s = JSONUtils.getString(json, "group", "");
        NonNullList<Ingredient> nonnulllist = readIngredients(JSONUtils.getJsonArray(json, "ingredients"));
        if (nonnulllist.isEmpty()) {
            throw new JsonParseException("No ingredients for shapeless recipe");
        } else if (nonnulllist.size() > 2) {
            throw new JsonParseException("Too many ingredients for shapeless recipe the max is " + 5);
        } else {
            ItemStack itemstack = RecipeDistillery.deserializeItem(JSONUtils.getJsonObject(json, "result"));
            float f = JSONUtils.getFloat(json, "experience", 0.0F);
            int i = JSONUtils.getInt(json, "cookingtime", this.cookingTime);
            return new RecipeDistillery(recipeId, s, nonnulllist, itemstack, f, i);
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

    public RecipeDistillery read(ResourceLocation recipeId, PacketBuffer buffer) {
        String s = buffer.readString(32767);
        int i = buffer.readVarInt();
        NonNullList<Ingredient> nonnulllist = NonNullList.withSize(i, Ingredient.EMPTY);

        for(int j = 0; j < nonnulllist.size(); ++j) {
            nonnulllist.set(j, Ingredient.read(buffer));
        }

        ItemStack itemstack = buffer.readItemStack();
        float f = buffer.readFloat();
        int c = buffer.readVarInt();
        return new RecipeDistillery(recipeId, s, nonnulllist, itemstack, f, c);
    }

    public void write(PacketBuffer buffer, RecipeDistillery recipe) {
        buffer.writeString(recipe.group);
        buffer.writeVarInt(recipe.recipeItems.size());

        for(Ingredient ingredient : recipe.recipeItems) {
            ingredient.write(buffer);
        }

        buffer.writeItemStack(recipe.result);
        buffer.writeFloat(recipe.experience);
        buffer.writeVarInt(recipe.cookTime);
    }

    //@Override
    //@Nonnull
    //public RecipeDestille read(@Nonnull ResourceLocation recipeId, @Nonnull JsonObject json) {
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
    //public RecipeDestille read(@Nonnull ResourceLocation recipeId, PacketBuffer buffer) {
    //    String s = buffer.readString(32767);
    //    Ingredient ingredient = Ingredient.read(buffer);
    //    ItemStack itemstack = buffer.readItemStack();
    //    return this.factory.create(recipeId, s, ingredient, itemstack);
    //}
//
    //@Override
    //public void write(PacketBuffer buffer, RecipeDestille recipe) {
    //    buffer.writeString(recipe.group);
    //    recipe.ingredient.write(buffer);
    //    buffer.writeItemStack(recipe.result);
    //}

    public interface IFactory<T extends RecipeDistillery> {
        T create(ResourceLocation resourceLocation, String group, Ingredient ingredient, ItemStack result);
    }
}
