package mod.acecraft.util.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import mod.acecraft.AceCraft;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class RecipeDistillery implements Recipe<SimpleContainer> {
	
	private final NonNullList<Ingredient> inputItems;
	private final ItemStack output;
	private final ResourceLocation id;
	
	
	
	
	
	// ---------- ---------- ---------- ----------  CONSTRUCTOR  ---------- ---------- ---------- ---------- //
	
	public RecipeDistillery(NonNullList<Ingredient> inputItems, ItemStack output, ResourceLocation id) {
		this.inputItems = inputItems;
		this.output     = output;
		this.id         = id;
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SUPPORT  ---------- ---------- ---------- ---------- //
	
	@Override
	public boolean matches(SimpleContainer container, Level level) {
		if(level.isClientSide) return false;
		return (inputItems.get(0).test(container.getItem(0)) && inputItems.get(1).test(container.getItem(1))) ||
						(inputItems.get(0).test(container.getItem(1)) && inputItems.get(1).test(container.getItem(0)));
	}
	
	@Override
	public ItemStack assemble(SimpleContainer p_44001_, RegistryAccess p_267165_) {
		return output.copy();
	}
	
	@Override
	public boolean canCraftInDimensions(int p_43999_, int p_44000_) {
		return true;
	}
	
	@Override
	public ItemStack getResultItem(RegistryAccess p_267052_) {
		return output.copy();
	}
	
	@Override
	public ResourceLocation getId() {
		return id;
	}
	
	@Override
	public RecipeSerializer<?> getSerializer() {
		return Serializer.INSTANCE;
	}
	
	@Override
	public RecipeType<?> getType() {
		return Type.INSTANE;
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  TYPE  ---------- ---------- ---------- ---------- //
	
	public static class Type implements RecipeType<RecipeDistillery> {
		public static final Type INSTANE = new Type();
		public static final String ID = "distilling";
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SERIALIZER  ---------- ---------- ---------- ---------- //
	
	public static class Serializer implements RecipeSerializer<RecipeDistillery> {
		
		public static final Serializer INSTANCE = new Serializer();
		public static final ResourceLocation ID = new ResourceLocation(AceCraft.MODID, "distilling");
		
		@Override
		public RecipeDistillery fromJson(ResourceLocation location, JsonObject json) {
			ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"));
			JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
			NonNullList<Ingredient> inputs = NonNullList.withSize(2, Ingredient.EMPTY);
			for(int i = 0; i < inputs.size(); i++){
				inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
			}
			
			return new RecipeDistillery(inputs, output, location);
		}
		
		@Override
		public @Nullable RecipeDistillery fromNetwork(ResourceLocation location, FriendlyByteBuf buffer) {
			NonNullList<Ingredient> inputs = NonNullList.withSize(buffer.readInt(), Ingredient.EMPTY);
			for(int i = 0; i < inputs.size(); i++){
				inputs.set(i, Ingredient.fromNetwork(buffer));
			}
			ItemStack output = buffer.readItem();
			return new RecipeDistillery(inputs, output, location);
		}
		
		@Override
		public void toNetwork(FriendlyByteBuf buffer, RecipeDistillery recipe) {
			buffer.writeInt(recipe.inputItems.size());
			for(Ingredient ingredient : recipe.getIngredients()){
				ingredient.toNetwork(buffer);
			}
			buffer.writeItemStack(recipe.getResultItem(null), false);
		}
	}
	
}
