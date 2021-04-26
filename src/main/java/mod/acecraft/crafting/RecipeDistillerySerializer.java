package mod.acecraft.crafting;

import com.google.gson.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class RecipeDistillerySerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<RecipeDistillery> {

    private final int defaultCookingTime = 200;




    //----------------------------------------SUPPORT----------------------------------------//

    public RecipeDistillery fromJson(ResourceLocation recipeId, JsonObject json) {
        String s = JSONUtils.getAsString(json, "group", "");
        JsonElement jsonelement = (JsonElement)(JSONUtils.isArrayNode(json, "ingredients") ? JSONUtils.getAsJsonArray(json, "ingredients") : JSONUtils.getAsJsonObject(json, "ingredients"));
        Ingredient ingredient = Ingredient.fromJson(jsonelement);
        //Forge: Check if primitive string to keep vanilla or a object which can contain a count field.
        if (!json.has("result")) throw new com.google.gson.JsonSyntaxException("Missing result, expected to find a string or object");
        ItemStack itemstack;
        if (json.get("result").isJsonObject()) itemstack = ShapedRecipe.itemFromJson(JSONUtils.getAsJsonObject(json, "result"));
        else {
            String s1 = JSONUtils.getAsString(json, "result");
            ResourceLocation resourcelocation = new ResourceLocation(s1);
            itemstack = new ItemStack(Registry.ITEM.getOptional(resourcelocation).orElseThrow(() -> {
                return new IllegalStateException("Item: " + s1 + " does not exist");
            }));
        }
        float f = JSONUtils.getAsFloat(json, "experience", 0.0F);
        int i = JSONUtils.getAsInt(json, "cookingtime", this.defaultCookingTime);
        return new RecipeDistillery(recipeId, ingredient, itemstack, s, f, i);
    }

    public RecipeDistillery fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
        String s = buffer.readUtf(32767);
        Ingredient ingredient = Ingredient.fromNetwork(buffer);
        ItemStack itemstack = buffer.readItem();
        float f = buffer.readFloat();
        int i = buffer.readVarInt();
        return new RecipeDistillery(recipeId, ingredient, itemstack, s, f, i);
    }

    public void toNetwork(PacketBuffer buffer, RecipeDistillery recipe) {
        buffer.writeUtf(recipe.group);
        recipe.ingredient.toNetwork(buffer);
        buffer.writeItem(recipe.result);
        buffer.writeFloat(recipe.experience);
        buffer.writeVarInt(recipe.getCookingTime());
    }

}
