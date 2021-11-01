package mod.acecraft.crafting;

import com.google.gson.*;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class RecipeDistillerySerializer extends ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<RecipeDistillery> {

    private final int defaultCookingTime = 200;





    //----------------------------------------SUPPORT----------------------------------------//

    public RecipeDistillery fromJson(ResourceLocation recipeId, JsonObject json) {
        String s = GsonHelper.getAsString(json, "group", "");
        JsonElement jsonelement = (JsonElement)(GsonHelper.isArrayNode(json, "ingredients") ? GsonHelper.getAsJsonArray(json, "ingredients") : GsonHelper.getAsJsonObject(json, "ingredients"));
        Ingredient ingredient = Ingredient.fromJson(jsonelement);
        //Forge: Check if primitive string to keep vanilla or a object which can contain a count field.
        if (!json.has("result")) throw new com.google.gson.JsonSyntaxException("Missing result, expected to find a string or object");
        ItemStack itemstack;
        if (json.get("result").isJsonObject()) itemstack = new ItemStack(ShapedRecipe.itemFromJson(GsonHelper.getAsJsonObject(json, "result")));
        else {
            String s1 = GsonHelper.getAsString(json, "result");
            ResourceLocation resourcelocation = new ResourceLocation(s1);
            itemstack = new ItemStack(Registry.ITEM.getOptional(resourcelocation).orElseThrow(() -> {
                return new IllegalStateException("Item: " + s1 + " does not exist");
            }));
        }
        float f = GsonHelper.getAsFloat(json, "experience", 0.0F);
        int i = GsonHelper.getAsInt(json, "cookingtime", this.defaultCookingTime);
        return new RecipeDistillery(recipeId, ingredient, itemstack, s, f, i);
    }

    public RecipeDistillery fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
        String s = buffer.readUtf(32767);
        Ingredient ingredient = Ingredient.fromNetwork(buffer);
        ItemStack itemstack = buffer.readItem();
        float f = buffer.readFloat();
        int i = buffer.readVarInt();
        return new RecipeDistillery(recipeId, ingredient, itemstack, s, f, i);
    }

    public void toNetwork(FriendlyByteBuf buffer, RecipeDistillery recipe) {
        buffer.writeUtf(recipe.group);
        recipe.ingredient.toNetwork(buffer);
        buffer.writeItem(recipe.result);
        buffer.writeFloat(recipe.experience);
        buffer.writeVarInt(recipe.getCookingTime());
    }



}
