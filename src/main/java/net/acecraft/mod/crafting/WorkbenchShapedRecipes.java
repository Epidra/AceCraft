package net.acecraft.mod.crafting;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class WorkbenchShapedRecipes implements IRecipe {
	
    public final int recipeWidth;
    public final int recipeHeight;
    public final ItemStack[] recipeItems;
    private ItemStack recipeOutput;
    private boolean field_92101_f;
    private static final String __OBFID = "CL_00000093";
    
    public WorkbenchShapedRecipes(int width, int height, ItemStack[] items, ItemStack output){
        this.recipeWidth  = width;
        this.recipeHeight = height;
        this.recipeItems  = items;
        this.recipeOutput = output;
    }
    
    public ItemStack getRecipeOutput(){
        return this.recipeOutput;
    }
    
    public boolean matches(InventoryCrafting icrafting, World world){
        for (int i = 0; i <= 5 - this.recipeWidth; ++i){
            for (int j = 0; j <= 5 - this.recipeHeight; ++j){
                if (this.checkMatch(icrafting, i, j, true)){
                    return true;
                }
                if (this.checkMatch(icrafting, i, j, false)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean checkMatch(InventoryCrafting icrafting, int i, int j, boolean flag){
        for (int k = 0; k < 5; ++k){
            for (int l = 0; l < 5; ++l){
                int i1 = k - i;
                int j1 = l - j;
                ItemStack itemstack = null;
                if (i1 >= 0 && j1 >= 0 && i1 < this.recipeWidth && j1 < this.recipeHeight){
                    if (flag){
                        itemstack = this.recipeItems[this.recipeWidth - i1 - 1 + j1 * this.recipeWidth];
                    }else{
                        itemstack = this.recipeItems[i1 + j1 * this.recipeWidth];
                    }
                }
                ItemStack itemstack1 = icrafting.getStackInRowAndColumn(k, l);
                if (itemstack1 != null || itemstack != null){
                    if (itemstack1 == null && itemstack != null || itemstack1 != null && itemstack == null){
                        return false;
                    }
                    if (itemstack.getItem() != itemstack1.getItem()){
                        return false;
                    }
                    if (itemstack.getItemDamage() != 32767 && itemstack.getItemDamage() != itemstack1.getItemDamage()){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public ItemStack getCraftingResult(InventoryCrafting icrafting){
        ItemStack itemstack = this.getRecipeOutput().copy();
        if (this.field_92101_f){
            for (int i = 0; i < icrafting.getSizeInventory(); ++i){
                ItemStack itemstack1 = icrafting.getStackInSlot(i);
                if (itemstack1 != null && itemstack1.hasTagCompound()){
                    itemstack.setTagCompound((NBTTagCompound)itemstack1.stackTagCompound.copy());
                }
            }
        }
        return itemstack;
    }
    
    public int getRecipeSize(){
        return this.recipeWidth * this.recipeHeight;
    }
    
    public WorkbenchShapedRecipes func_92100_c(){
        this.field_92101_f = true;
        return this;
    }

}