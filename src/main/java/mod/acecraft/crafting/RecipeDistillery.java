package mod.acecraft.crafting;

import mod.acecraft.ShopKeeper;
import mod.lucky77.blockentity.BlockEntityBase;
import mod.lucky77.crafting.RecipeBase;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

public class RecipeDistillery /*extends RecipeBase*/ {

//    protected final ResourceLocation id;
//    protected final ItemStack result;
//    protected final String group;
//    protected final float experience;
//    protected final Ingredient ingredient;
//
//
//
//
//
//    //----------------------------------------CONSTRUCTOR----------------------------------------//
//
//    public RecipeDistillery(ResourceLocation id, Ingredient ingredient, ItemStack item, String group, float experienceIn, int cookTimeIn) {
//        super(cookTimeIn);
//        this.id = id;
//        this.ingredient = ingredient;
//        this.result = item;
//        this.group = group;
//        this.experience = experienceIn;
//    }
//
//
//
//
//
//    //----------------------------------------SUPPORT----------------------------------------//
//
//    @Override
//    public boolean matches(BlockEntityBase tile, Level p_77569_2_) {
//        return this.ingredient.test(tile.getItem(0)) && this.ingredient.test(tile.getItem(1));
//    }
//
//    @Override
//    public ItemStack assemble(BlockEntityBase p_77572_1_) {
//        return this.result.copy();
//    }
//
//    public boolean canCraftInDimensions(int p_194133_1_, int p_194133_2_) {
//        return true;
//    }
//
//    public NonNullList<Ingredient> getIngredients() {
//        NonNullList<Ingredient> nonnulllist = NonNullList.create();
//        nonnulllist.add(this.ingredient);
//        return nonnulllist;
//    }
//
//
//
//
//
//    //----------------------------------------GETTER/SETTER----------------------------------------//
//
//    public float getExperience() {
//        return this.experience;
//    }
//
//    public ItemStack getResultItem() {
//        return this.result;
//    }
//
//    public String getGroup() {
//        return this.group;
//    }
//
//    public int getCookingTime() {
//        return this.cookTime;
//    }
//
//    public ResourceLocation getId() {
//        return this.id;
//    }
//
//    public RecipeType<?> getType() {
//        return ShopKeeper.RECIPE_DISTILLERY;
//    }
//
//    public ItemStack getToastSymbol() {
//        return new ItemStack(Blocks.FURNACE);
//    }
//
//    public RecipeSerializer<?> getSerializer() {
//        return ShopKeeper.SERIALIZER_DISTILLERY.get();
//    }



}
