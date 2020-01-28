package mod.acecraft.crafting;

import java.util.List;

import javax.annotation.Nullable;

import mod.acecraft.ShopKeeper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BlastFurnaceRecipes {
	
private static final BlastFurnaceRecipes SMELTING_BASE = new BlastFurnaceRecipes();
    
    private static float tolerance = 0.1f;
    
    private enum Ore { COAL, IRON, GOLD, DENARIUM, ADAMANTIUM, GILIUM, MYTHRIL, ORICHALCUM, CLAVIUM, AURELIUM, ZINC, TIN, COPPER, BRONZE, SILVER, STEEL, NIVIDIUM }

    /**
     * Returns an instance of FurnaceRecipes.
     */
    public static BlastFurnaceRecipes instance(){
        return SMELTING_BASE;
    }
    
    private BlastFurnaceRecipes(){
    	
    }
    
    /**
     * Returns the smelting result of an item.
     */
    @Nullable
    public ItemStack getSmeltingResult(List<ItemStack> slots){
    	
    	int counter[] = new int[Ore.values().length];
    	float scaler[] = new float[Ore.values().length];
    	
    	for(int i = 0; i < counter.length; i++) {
    		counter[i] = 0;
    	}
    	
    	// Coal
    	counter[Ore.COAL.ordinal()] += matches(Items.COAL,        slots, 1);
    	counter[Ore.COAL.ordinal()] += matches(Blocks.COAL_BLOCK, slots, 9);
    	
    	// Iron
    	counter[Ore.IRON.ordinal()] += matches(ShopKeeper.NUGGET_IRON,     slots, 1);
    	counter[Ore.IRON.ordinal()] += matches(Items.IRON_INGOT,           slots, 1);
    	counter[Ore.IRON.ordinal()] += matches(Items.IRON_SHOVEL,          slots, 1);
    	counter[Ore.IRON.ordinal()] += matches(Items.IRON_PICKAXE,         slots, 3);
    	counter[Ore.IRON.ordinal()] += matches(Items.IRON_AXE,             slots, 3);
    	counter[Ore.IRON.ordinal()] += matches(Items.IRON_HOE,             slots, 2);
    	counter[Ore.IRON.ordinal()] += matches(Items.IRON_SWORD,           slots, 2);
    	//counter[Ore.IRON.ordinal()] += matches(ShopKeeper.TOOL_IRON_SPEAR, slots, 1);
    	counter[Ore.IRON.ordinal()] += matches(Items.IRON_HELMET,          slots, 5);
    	counter[Ore.IRON.ordinal()] += matches(Items.IRON_CHESTPLATE,      slots, 8);
    	counter[Ore.IRON.ordinal()] += matches(Items.IRON_LEGGINGS,        slots, 7);
    	counter[Ore.IRON.ordinal()] += matches(Items.IRON_BOOTS,           slots, 4);
    	counter[Ore.IRON.ordinal()] += matches(Blocks.IRON_BLOCK,          slots, 9);
    	
    	// Gold
    	counter[Ore.GOLD.ordinal()] += matches(ShopKeeper.NUGGET_GOLD,     slots, 1);
    	counter[Ore.GOLD.ordinal()] += matches(Items.GOLD_INGOT,           slots, 1);
    	counter[Ore.GOLD.ordinal()] += matches(Items.GOLDEN_SHOVEL,        slots, 1);
    	counter[Ore.GOLD.ordinal()] += matches(Items.GOLDEN_PICKAXE,       slots, 3);
    	counter[Ore.GOLD.ordinal()] += matches(Items.GOLDEN_AXE,           slots, 3);
    	counter[Ore.GOLD.ordinal()] += matches(Items.GOLDEN_HOE,           slots, 2);
    	counter[Ore.GOLD.ordinal()] += matches(Items.GOLDEN_SWORD,         slots, 2);
    	//counter[Ore.GOLD.ordinal()] += matches(ShopKeeper.TOOL_GOLD_SPEAR, slots, 1);
    	counter[Ore.GOLD.ordinal()] += matches(Items.GOLDEN_HELMET,        slots, 5);
    	counter[Ore.GOLD.ordinal()] += matches(Items.GOLDEN_CHESTPLATE,    slots, 8);
    	counter[Ore.GOLD.ordinal()] += matches(Items.GOLDEN_LEGGINGS,      slots, 7);
    	counter[Ore.GOLD.ordinal()] += matches(Items.GOLDEN_BOOTS,         slots, 4);
    	counter[Ore.GOLD.ordinal()] += matches(Blocks.GOLD_BLOCK,          slots, 9);
    	
    	// Copper
    	counter[Ore.COPPER.ordinal()] += matches(ShopKeeper.NUGGET_COPPER,           slots, 1);
    	counter[Ore.COPPER.ordinal()] += matches(ShopKeeper.INGOT_COPPER,            slots, 1);
    	counter[Ore.COPPER.ordinal()] += matches(ShopKeeper.BLOCK_COPPER,            slots, 9);
    	
    	// Tin
    	counter[Ore.TIN.ordinal()] += matches(ShopKeeper.NUGGET_TIN,           slots, 1);
    	counter[Ore.TIN.ordinal()] += matches(ShopKeeper.INGOT_TIN,            slots, 1);
    	counter[Ore.TIN.ordinal()] += matches(ShopKeeper.BLOCK_TIN,            slots, 9);
    	
    	// Zinc
    	counter[Ore.ZINC.ordinal()] += matches(ShopKeeper.NUGGET_ZINC,           slots, 1);
    	counter[Ore.ZINC.ordinal()] += matches(ShopKeeper.INGOT_ZINC,            slots, 1);
    	counter[Ore.ZINC.ordinal()] += matches(ShopKeeper.BLOCK_ZINC,            slots, 9);
    	
    	// Mythril
    	counter[Ore.MYTHRIL.ordinal()] += matches(ShopKeeper.NUGGET_MYTHRIL,           slots, 1);
    	counter[Ore.MYTHRIL.ordinal()] += matches(ShopKeeper.INGOT_MYTHRIL,            slots, 1);
    	counter[Ore.MYTHRIL.ordinal()] += matches(ShopKeeper.BLOCK_MYTHRIL,            slots, 9);
    	
    	// Adamantium
    	counter[Ore.ADAMANTIUM.ordinal()] += matches(ShopKeeper.INGOT_ADAMANTIUM,            slots, 1);
    	counter[Ore.ADAMANTIUM.ordinal()] += matches(ShopKeeper.BLOCK_ADAMANTIUM,            slots, 9);
    	
    	// Aurelium
    	counter[Ore.AURELIUM.ordinal()] += matches(ShopKeeper.INGOT_AURELIUM,            slots, 1);
    	counter[Ore.AURELIUM.ordinal()] += matches(ShopKeeper.BLOCK_AURELIUM,            slots, 9);
    	
    	// Bronze
    	counter[Ore.BRONZE.ordinal()] += matches(ShopKeeper.INGOT_BRONZE,            slots, 1);
    	counter[Ore.BRONZE.ordinal()] += matches(ShopKeeper.BLOCK_BRONZE,            slots, 9);
    	
    	// Brass
    	counter[Ore.DENARIUM.ordinal()] += matches(ShopKeeper.INGOT_DENARIUM,            slots, 1);
    	counter[Ore.DENARIUM.ordinal()] += matches(ShopKeeper.BLOCK_DENARIUM,            slots, 9);
    	
    	// Steel
    	counter[Ore.STEEL.ordinal()] += matches(ShopKeeper.INGOT_STEEL,            slots, 1);
    	counter[Ore.STEEL.ordinal()] += matches(ShopKeeper.BLOCK_STEEL,            slots, 9);
    	
    	// Orichalcum
    	counter[Ore.ORICHALCUM.ordinal()] += matches(ShopKeeper.INGOT_ORICHALCUM,            slots, 1);
    	counter[Ore.ORICHALCUM.ordinal()] += matches(ShopKeeper.BLOCK_ORICHALCUM,            slots, 9);
    	
    	float maxCount = 0;
    	for(int i = 0; i < counter.length; i++) {
    		maxCount += counter[i];
    	}
    	
    	for(int i = 0; i < scaler.length; i++) {
    		scaler[i] = counter[i] / maxCount;
    	}
    	
    	if(circa(scaler[Ore.IRON      .ordinal()], 1.0f)) return new ItemStack(Items.IRON_INGOT           , counter[Ore.IRON      .ordinal()]);
    	if(circa(scaler[Ore.GOLD      .ordinal()], 1.0f)) return new ItemStack(Items.GOLD_INGOT           , counter[Ore.GOLD      .ordinal()]);
    	if(circa(scaler[Ore.COPPER    .ordinal()], 1.0f)) return new ItemStack(ShopKeeper.INGOT_COPPER    , counter[Ore.COPPER    .ordinal()]);
    	if(circa(scaler[Ore.TIN       .ordinal()], 1.0f)) return new ItemStack(ShopKeeper.INGOT_TIN       , counter[Ore.TIN       .ordinal()]);
    	if(circa(scaler[Ore.ZINC      .ordinal()], 1.0f)) return new ItemStack(ShopKeeper.INGOT_ZINC      , counter[Ore.ZINC      .ordinal()]);
    	if(circa(scaler[Ore.MYTHRIL   .ordinal()], 1.0f)) return new ItemStack(ShopKeeper.INGOT_MYTHRIL   , counter[Ore.MYTHRIL   .ordinal()]);
    	if(circa(scaler[Ore.ADAMANTIUM.ordinal()], 1.0f)) return new ItemStack(ShopKeeper.INGOT_ADAMANTIUM, counter[Ore.ADAMANTIUM.ordinal()]);
    	if(circa(scaler[Ore.AURELIUM  .ordinal()], 1.0f)) return new ItemStack(ShopKeeper.INGOT_AURELIUM  , counter[Ore.AURELIUM  .ordinal()]);
    	if(circa(scaler[Ore.BRONZE    .ordinal()], 1.0f)) return new ItemStack(ShopKeeper.INGOT_BRONZE    , counter[Ore.BRONZE    .ordinal()]);
    	if(circa(scaler[Ore.DENARIUM     .ordinal()], 1.0f)) return new ItemStack(ShopKeeper.INGOT_DENARIUM     , counter[Ore.DENARIUM     .ordinal()]);
    	if(circa(scaler[Ore.STEEL     .ordinal()], 1.0f)) return new ItemStack(ShopKeeper.INGOT_STEEL     , counter[Ore.STEEL     .ordinal()]);
    	if(circa(scaler[Ore.ORICHALCUM.ordinal()], 1.0f)) return new ItemStack(ShopKeeper.INGOT_ORICHALCUM, counter[Ore.ORICHALCUM.ordinal()]);
    	
    	if(circa(scaler[Ore.COPPER .ordinal()], 0.8f) && circa(scaler[Ore.TIN .ordinal()], 0.2f)) return new ItemStack(ShopKeeper.INGOT_BRONZE    , counter[Ore.BRONZE    .ordinal()]);
    	if(circa(scaler[Ore.COPPER .ordinal()], 0.8f) && circa(scaler[Ore.ZINC.ordinal()], 0.2f)) return new ItemStack(ShopKeeper.INGOT_DENARIUM     , counter[Ore.DENARIUM     .ordinal()]);
    	if(circa(scaler[Ore.IRON   .ordinal()], 0.8f) && circa(scaler[Ore.COAL.ordinal()], 0.2f)) return new ItemStack(ShopKeeper.INGOT_STEEL     , counter[Ore.STEEL     .ordinal()]);
    	if(circa(scaler[Ore.MYTHRIL.ordinal()], 0.8f) && circa(scaler[Ore.CLAVIUM.ordinal()], 0.2f)) return new ItemStack(ShopKeeper.INGOT_ORICHALCUM, counter[Ore.ORICHALCUM.ordinal()]);
    	if(circa(scaler[Ore.GOLD.ordinal()],    0.5f) && circa(scaler[Ore.SILVER.ordinal()],  0.5f)) return new ItemStack(ShopKeeper.INGOT_AURELIUM,   counter[Ore.AURELIUM  .ordinal()]);
    	if(circa(scaler[Ore.GILIUM.ordinal()],  0.8f) && circa(scaler[Ore.CLAVIUM.ordinal()], 0.2f)) return new ItemStack(ShopKeeper.INGOT_ADAMANTIUM, counter[Ore.ADAMANTIUM.ordinal()]);
    	
        return null;
    }
    
    private boolean circa(float scale, float value){
        return value - tolerance < scale && scale < value + tolerance;
    }
    
    private int matches(Item item, List<ItemStack> slots, int maxIngot){
    	int counter = 0;
    	for(int i = 0; i < 10; i++){
    		if(slots.get(i).getItem() == item) {
    			if(slots.get(i).getItem().isDamageable()) {
    				counter += ( (int)( (slots.get(i).getItem().getDamage(slots.get(i)) / (float)slots.get(i).getItem().getMaxDamage(slots.get(i))) ) * maxIngot );
    			} else {
    				counter += maxIngot;
    			}
    		}
    	}
    	return counter;
    }
    
    private int matches(Block block, List<ItemStack> slots, int maxIngot){
    	int counter = 0;
    	for(int i = 0; i < 10; i++){
    		if(slots.get(i).getItem() == Item.getItemFromBlock(block)) counter+=maxIngot;
    	}
    	return counter;
    }
	
}
