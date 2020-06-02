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
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemStack;

public class BonfireRecipes {
	
	private static final BonfireRecipes smeltingBase = new BonfireRecipes();
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
    private static final String __OBFID = "CL_00000085";
    
    public static BonfireRecipes smelting(){
        return smeltingBase;
    }
    
    private BonfireRecipes(){
        this.func_151396_a(Items.porkchop,                new ItemStack(Items.cooked_porkchop),            0.35F);
        this.func_151396_a(Items.beef,                    new ItemStack(Items.cooked_beef),                0.35F);
        this.func_151396_a(Items.chicken,                 new ItemStack(Items.cooked_chicken),             0.35F);
        this.func_151393_a(Blocks.log,                    new ItemStack(Items.coal, 1, 1),                 0.15F);
        this.func_151393_a(Blocks.log2,                   new ItemStack(Items.coal, 1, 1),                 0.15F);
        this.func_151396_a(Items.potato,                  new ItemStack(Items.baked_potato),               0.35F);
        this.func_151393_a(ShopKeeper.aceLog,             new ItemStack(Items.coal, 1, 1),                 0.15F);
        this.func_151396_a(ShopKeeper.foodMammothMeatRaw, new ItemStack(ShopKeeper.foodMammothMeatCooked), 0.25F);
        this.func_151396_a(ShopKeeper.foodVenisonRaw,     new ItemStack(ShopKeeper.foodVenisonCooked),     0.25F);
        this.func_151396_a(ShopKeeper.foodMuttonRaw,      new ItemStack(ShopKeeper.foodMuttonCooked),      0.25F);
        this.func_151396_a(ShopKeeper.foodCrabMeatRaw,    new ItemStack(ShopKeeper.foodCrabMeatCooked),    0.25F);
        this.func_151396_a(ShopKeeper.foodCalamariRaw,    new ItemStack(ShopKeeper.foodCalamariCooked),    0.25F);
        ItemFishFood.FishType[] afishtype = ItemFishFood.FishType.values();
        int i = afishtype.length;
        for (int j = 0; j < i; ++j){
            ItemFishFood.FishType fishtype = afishtype[j];
            if (fishtype.func_150973_i()){
                this.func_151394_a(new ItemStack(Items.fish, 1, fishtype.func_150976_a()), new ItemStack(Items.cooked_fished, 1, fishtype.func_150976_a()), 0.35F);
            }
        }
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