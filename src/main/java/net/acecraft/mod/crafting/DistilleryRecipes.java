package net.acecraft.mod.crafting;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DistilleryRecipes {
	
	private static final DistilleryRecipes smeltingBase = new DistilleryRecipes();
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
    private static final String __OBFID = "CL_00000085";
    
    public static DistilleryRecipes smelting(){
        return smeltingBase;
    }
    
    private DistilleryRecipes(){
    	this.func_151396_a(Items.reeds, new ItemStack(ShopKeeper.liquorRum), 0.35F);
    	this.func_151396_a(Items.wheat, new ItemStack(ShopKeeper.liquorBeer), 0.35F);
    	this.func_151396_a(ShopKeeper.foodTurnip, new ItemStack(ShopKeeper.liquorSalgam), 0.35F);
    	this.func_151396_a(Items.potato, new ItemStack(ShopKeeper.liquorVodka), 0.35F);
    	this.func_151396_a(ShopKeeper.foodCactusFruit, new ItemStack(ShopKeeper.liquorCactusJack), 0.35F);
    	this.func_151396_a(ShopKeeper.foodRice, new ItemStack(ShopKeeper.liquorSake), 0.35F);
    }
    
    public void func_151393_a(Block block, ItemStack stack, float f){
        this.func_151396_a(Item.getItemFromBlock(block), stack, f);
    }
    
    public void func_151396_a(Item item, ItemStack stack, float f){
        this.func_151394_a(new ItemStack(item, 1, 32767), stack, f);
    }
    
    public void func_151394_a(ItemStack input, ItemStack output, float f){
        this.smeltingList.put(input, output);
        this.experienceList.put(output, Float.valueOf(f));
    }
    
    public ItemStack getSmeltingResult(ItemStack itemIngridient){
        Iterator iterator = this.smeltingList.entrySet().iterator();
        Entry entry;
        do{
            if (!iterator.hasNext()){
                return null;
            }
            entry = (Entry)iterator.next();
        }
        while (!this.func_151397_a(itemIngridient, (ItemStack)entry.getKey()));
        return (ItemStack)entry.getValue();
    }
    
    private boolean func_151397_a(ItemStack input, ItemStack output){
        return output.getItem() == input.getItem() && (output.getItemDamage() == 32767 || output.getItemDamage() == input.getItemDamage());
    }
    
    public Map getSmeltingList(){
        return this.smeltingList;
    }
    
    public float func_151398_b(ItemStack stack){
        float ret = stack.getItem().getSmeltingExperience(stack);
        if (ret != -1) return ret;
        Iterator iterator = this.experienceList.entrySet().iterator();
        Entry entry;
        do{
            if (!iterator.hasNext()){
                return 0.0F;
            }
            entry = (Entry)iterator.next();
        }
        while (!this.func_151397_a(stack, (ItemStack)entry.getKey()));
        return ((Float)entry.getValue()).floatValue();
    }

}