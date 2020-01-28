package mod.acecraft.crafting;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Nullable;

import mod.acecraft.ShopKeeper;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DistilleryRecipes {
	
	private static final DistilleryRecipes SMELTING_BASE = new DistilleryRecipes();
    private final Map<ItemStack, ItemStack> smeltingList = Maps.newHashMap();
    private final Map<ItemStack, Float> experienceList = Maps.newHashMap();
    
    public static DistilleryRecipes instance(){
        return SMELTING_BASE;
    }
    
    private DistilleryRecipes(){
		this.addSmelting(Items.WHEAT,            new ItemStack(ShopKeeper.LIQUOR_BEER),   0.65F);
		this.addSmelting(Items.REEDS,            new ItemStack(ShopKeeper.LIQUOR_RUM),    0.65F);
		this.addSmelting(ShopKeeper.FOOD_TURNIP, new ItemStack(ShopKeeper.LIQUOR_SALGAM), 0.65F);
		this.addSmelting(Items.POTATO,           new ItemStack(ShopKeeper.LIQUOR_VODKA),  0.65F);
		this.addSmelting(ShopKeeper.FOOD_RICE,   new ItemStack(ShopKeeper.LIQUOR_SAKE),   0.65F);
		this.addSmelting(ShopKeeper.FOOD_COFFEE, new ItemStack(ShopKeeper.LIQUOR_COFFEE), 0.65F);
    }
    
    /**
     * Adds a smelting recipe, where the input item is an instance of Block.
     */
    public void addSmeltingRecipeForBlock(Block input, ItemStack stack, float experience){
        this.addSmelting(Item.getItemFromBlock(input), stack, experience);
    }
    
    /**
     * Adds a smelting recipe using an Item as the input item.
     */
    public void addSmelting(Item input, ItemStack stack, float experience){
        this.addSmeltingRecipe(new ItemStack(input, 1, 32767), stack, experience);
    }
    
    /**
     * Adds a smelting recipe using an ItemStack as the input for the recipe.
     */
    public void addSmeltingRecipe(ItemStack input, ItemStack stack, float experience){
        if (getSmeltingResult(input) != null) { net.minecraftforge.fml.common.FMLLog.info("Ignored smelting recipe with conflicting input: " + input + " = " + stack); return; }
        this.smeltingList.put(input, stack);
        this.experienceList.put(stack, Float.valueOf(experience));
    }
    
    /**
     * Returns the smelting result of an item.
     */
    @Nullable
    public ItemStack getSmeltingResult(ItemStack stack){
        for (Entry<ItemStack, ItemStack> entry : this.smeltingList.entrySet()){
            if (this.compareItemStacks(stack, entry.getKey())){
                return entry.getValue();
            }
        }
        return null;
    }
    
    /**
     * Compares two itemstacks to ensure that they are the same. This checks both the item and the metadata of the item.
     */
    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2){
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }
    
    public Map<ItemStack, ItemStack> getSmeltingList(){
        return this.smeltingList;
    }
    
    public float getSmeltingExperience(ItemStack stack){
        float ret = stack.getItem().getSmeltingExperience(stack);
        if (ret != -1) return ret;
        for (Entry<ItemStack, Float> entry : this.experienceList.entrySet()){
            if (this.compareItemStacks(stack, entry.getKey())){
                return entry.getValue().floatValue();
            }
        }
        return 0.0F;
    }
	
}
