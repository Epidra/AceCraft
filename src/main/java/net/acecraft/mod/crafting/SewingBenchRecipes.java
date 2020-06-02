package net.acecraft.mod.crafting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;

public class SewingBenchRecipes extends AceCraftingManager {
	
	/** The static instance of this class */
    private static final SewingBenchRecipes INSTANCE = new SewingBenchRecipes();
    private final List<IRecipe> recipes = Lists.<IRecipe>newArrayList();

    /** Returns the static instance of this class */
    public static SewingBenchRecipes getInstance(){
        /** The static instance of this class */
        return INSTANCE;
    }
    
    public SewingBenchRecipes(){
    	this.addRecipe(new ItemStack(Items.PAINTING, 1), new Object[] {"###", "#X#", "###", '#', Items.STICK, 'X', Blocks.WOOL});
    }
}