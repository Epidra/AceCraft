package mod.acecraft.custom.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import mod.acecraft.AceCraft;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class RecipeDistillery implements Recipe<DoubleRecipeInput> {
	
	// protected final RecipeType<?> type;
	protected final CookingBookCategory category;
	protected final String group;
	protected final Ingredient ingredient;
	protected final ItemStack result;
	protected final float experience;
	protected final int cookingTime;
	
	// RecipeSerializer<SmeltingRecipe> SERIALIZER = register("smelting", new SimpleCookingSerializer<>(RecipeDistillery::new, 200));
	
	// public CampfireCookingRecipe(String group, CookingBookCategory category, Ingredient ingredient, ItemStack result, float experience, int cookingTime) {
	// 	super(RecipeType.CAMPFIRE_COOKING, group, category, ingredient, result, experience, cookingTime);
	// }
	
	public RecipeDistillery(
			String group, CookingBookCategory category, Ingredient ingredient, ItemStack result, float experience, int cookingTime
	) {
		// this.type = Type.INSTANCE;
		this.category = category;
		this.group = group;
		this.ingredient = ingredient;
		this.result = result;
		this.experience = experience;
		this.cookingTime = cookingTime;
	}
	
	public boolean matches(DoubleRecipeInput input, Level level) {
		return this.ingredient.test(input.item0()) && this.ingredient.test(input.item1());
	}
	
	public ItemStack assemble(DoubleRecipeInput input, HolderLookup.Provider registries) {
		return this.result.copy();
	}
	
	// @Override
	// public boolean matches(DoubleRecipeInput input, Level level) {
	// 	return false;
	// }
	//
	// @Override
	// public ItemStack assemble(DoubleRecipeInput input, HolderLookup.Provider registries) {
	// 	return null;
	// }
	
	/**
	 * Used to determine if this recipe can fit in a grid of the given width/height
	 */
	@Override
	public boolean canCraftInDimensions(int width, int height) {
		return true;
	}
	
	@Override
	public NonNullList<Ingredient> getIngredients() {
		NonNullList<Ingredient> nonnulllist = NonNullList.create();
		nonnulllist.add(this.ingredient);
		return nonnulllist;
	}
	
	public float getExperience() {
		return this.experience;
	}
	
	@Override
	public ItemStack getResultItem(HolderLookup.Provider registries) {
		return this.result;
	}
	
	@Override
	public String getGroup() {
		return this.group;
	}
	
	// @Override
	// public RecipeSerializer<?> getSerializer() {
	// 	return null;
	// }
	
	
	@Override
	public ItemStack getToastSymbol() {
		return new ItemStack(Blocks.CAMPFIRE);
	}
	
	@Override
	public RecipeSerializer<?> getSerializer() {
		return Serializer.INSTANCE;
	}
	
	public int getCookingTime() {
		return this.cookingTime;
	}
	
	@Override
	public RecipeType<?> getType() {
		return Type.INSTANCE;
	}
	
	public static class Type implements RecipeType<RecipeDistillery>{
		public static final Type INSTANCE = new Type();
		public static final String ID = "distilling";
	}
	
	public CookingBookCategory category() {
		return this.category;
	}
	
	public interface Factory<T extends RecipeDistillery> {
		T create(String group, CookingBookCategory category, Ingredient ingredient, ItemStack result, float experience, int cookingTime);
	}
	
	static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(String key, S recipeSerializer) {
		return Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, key, recipeSerializer);
	}
	
	
	
	
	
	
	public static class Serializer implements RecipeSerializer<RecipeDistillery> {
		
		public static final Serializer INSTANCE = new Serializer(RecipeDistillery::new, 100);
		public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(AceCraft.MODID, "distilling");
		
		private final Factory<RecipeDistillery> factory;
		private final MapCodec<RecipeDistillery> codec;
		private final StreamCodec<RegistryFriendlyByteBuf, RecipeDistillery> streamCodec;
		
		public Serializer(Factory<RecipeDistillery> factory, int cookingTime) {
			this.factory = factory;
			this.codec = RecordCodecBuilder.mapCodec(
					p_300831_ -> p_300831_.group(
									Codec.STRING.optionalFieldOf("group", "").forGetter(p_300832_ -> p_300832_.group),
									CookingBookCategory.CODEC.fieldOf("category").orElse(CookingBookCategory.MISC).forGetter(p_300828_ -> p_300828_.category),
									Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(p_300833_ -> p_300833_.ingredient),
									ItemStack.CODEC.fieldOf("result").forGetter(p_300827_ -> p_300827_.result),
									Codec.FLOAT.fieldOf("experience").orElse(0.0F).forGetter(p_300826_ -> p_300826_.experience),
									Codec.INT.fieldOf("cookingtime").orElse(cookingTime).forGetter(p_300834_ -> p_300834_.cookingTime)
							)
							.apply(p_300831_, factory::create)
			);
			this.streamCodec = StreamCodec.of(this::toNetwork, this::fromNetwork);
		}
		
		@Override
		public MapCodec<RecipeDistillery> codec() {
			return this.codec;
		}
		
		@Override
		public StreamCodec<RegistryFriendlyByteBuf, RecipeDistillery> streamCodec() {
			return this.streamCodec;
		}
		
		private RecipeDistillery fromNetwork(RegistryFriendlyByteBuf buffer) {
			String s = buffer.readUtf();
			CookingBookCategory cookingbookcategory = buffer.readEnum(CookingBookCategory.class);
			Ingredient ingredient = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
			ItemStack itemstack = ItemStack.STREAM_CODEC.decode(buffer);
			float f = buffer.readFloat();
			int i = buffer.readVarInt();
			return this.factory.create(s, cookingbookcategory, ingredient, itemstack, f, i);
		}
		
		private void toNetwork(RegistryFriendlyByteBuf buffer, RecipeDistillery recipe) {
			buffer.writeUtf(recipe.group);
			buffer.writeEnum(recipe.category());
			Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.ingredient);
			ItemStack.STREAM_CODEC.encode(buffer, recipe.result);
			buffer.writeFloat(recipe.experience);
			buffer.writeVarInt(recipe.cookingTime);
		}
		
		public RecipeDistillery create(
				String group, CookingBookCategory category, Ingredient ingredient, ItemStack result, float experience, int cookingTime
		) {
			return this.factory.create(group, category, ingredient, result, experience, cookingTime);
		}
	}
	
}
