package net.acecraft.mod.crafting;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FruitPressRecipes {
	
	private static final FruitPressRecipes smeltingBase = new FruitPressRecipes();
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
    private static final String __OBFID = "CL_00000085";
    
    public static FruitPressRecipes smelting(){
        return smeltingBase;
    }
    
    private FruitPressRecipes(){
    	this.func_151396_a(new ItemStack(Blocks.double_plant, 1, 0).getItem(), new ItemStack(ShopKeeper.juiceApple),     0.35F);
    	this.func_151396_a(Items.apple,                                        new ItemStack(ShopKeeper.juiceApple),     0.35F);
    	this.func_151396_a(ShopKeeper.foodBanana,                              new ItemStack(ShopKeeper.juiceBanana),    0.35F);
    	this.func_151396_a(ShopKeeper.foodCactusFruit,                         new ItemStack(ShopKeeper.juiceCactus),    0.35F);
    	this.func_151396_a(ShopKeeper.foodCherry,                              new ItemStack(ShopKeeper.juiceCherry),    0.35F);
    	this.func_151396_a(ShopKeeper.foodGrapes,                              new ItemStack(ShopKeeper.juiceGrapes),    0.35F);
    	this.func_151396_a(ShopKeeper.foodLemon,                               new ItemStack(ShopKeeper.juiceLemon),     0.35F);
    	this.func_151396_a(ShopKeeper.foodOrange,                              new ItemStack(ShopKeeper.juiceOrange),    0.35F);
    	this.func_151396_a(ShopKeeper.foodPeach,                               new ItemStack(ShopKeeper.juicePeach),     0.35F);
    	this.func_151396_a(ShopKeeper.foodPineapple,                           new ItemStack(ShopKeeper.juicePineapple), 0.35F);
    	this.func_151396_a(ShopKeeper.foodTomato,                              new ItemStack(ShopKeeper.juiceTomato),    0.35F);
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
    
    public ItemStack getSmeltingResult(ItemStack stack){
        Iterator iterator = this.smeltingList.entrySet().iterator();
        Entry entry;
        do{
            if (!iterator.hasNext()){
                return null;
            }
            entry = (Entry)iterator.next();
        }
        while (!this.func_151397_a(stack, (ItemStack)entry.getKey()));
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