package net.acecraft.mod.items;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

/**
 * This is an implementation of the ItemAxe. This class was created
 * due to a bug in ItemAxe that results in an "Array out of Bound"
 * exception in the constructor. 
 * 
 * Note: You don't need permission from me to use this code. Just use it
 * if your having the same problem I'm having. :)
 * @author derf6060
 */
public class ToolAxe extends ItemTool {
	// A holder object for the tool material
	private ToolMaterial material = null;
	// This is a list of 
	private static Set<Block> blocks = null;
	
	/**
	 * This initializes the ItemAxeCustom object.
	 * @param ToolMaterial material
	 */
	public ToolAxe(String name, ToolMaterial material) {
		super(material, getEffectedBlocks());
		this.material = material;
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
	}

	/**
	 * This create a list of vanilla blocks that the custom
	 * axe can be used on.
	 * @return Set<Block>
	 */
	private static Set<Block> getEffectedBlocks() {
		// TODO Auto-generated method stub
		
		if(blocks == null) {
			blocks = new HashSet<Block>();
			// Arcacia
			blocks.add(Blocks.acacia_door);
			blocks.add(Blocks.acacia_fence);
			blocks.add(Blocks.acacia_fence_gate);
			blocks.add(Blocks.acacia_stairs);
			// Birch
			blocks.add(Blocks.birch_door);
			blocks.add(Blocks.birch_fence);
			blocks.add(Blocks.birch_fence_gate);
			blocks.add(Blocks.birch_stairs);
			// Dark Oak
			blocks.add(Blocks.dark_oak_door);
			blocks.add(Blocks.dark_oak_fence);
			blocks.add(Blocks.dark_oak_fence_gate);
			blocks.add(Blocks.dark_oak_stairs);
			// Jungle
			blocks.add(Blocks.jungle_door);
			blocks.add(Blocks.jungle_fence);
			blocks.add(Blocks.jungle_fence_gate);
			blocks.add(Blocks.jungle_stairs);
			// Oak 
			blocks.add(Blocks.oak_door);
			blocks.add(Blocks.oak_fence);
			blocks.add(Blocks.oak_fence_gate);
			blocks.add(Blocks.oak_stairs);
			// Spruce
			blocks.add(Blocks.spruce_door);
			blocks.add(Blocks.spruce_fence);
			blocks.add(Blocks.spruce_fence_gate);
			blocks.add(Blocks.spruce_stairs);
			// Logs
			blocks.add(Blocks.log);
			blocks.add(Blocks.log2);
			// Leaves
			blocks.add(Blocks.leaves);
			blocks.add(Blocks.leaves2);
			// Planks
			blocks.add(Blocks.planks);
			// Crafting Table
			blocks.add(Blocks.crafting_table);
			// Pumkin
			blocks.add(Blocks.pumpkin);
			// Lit Pumkin
			blocks.add(Blocks.lit_pumpkin);
			// Vines
			blocks.add(Blocks.vine);
			// Melon
			blocks.add(Blocks.melon_block);
		}
		return blocks;
	}

	/**
	 * This check if the block can be mined by the custom axe
	 * @param ItemStack stack
	 * @param IBlockState state
	 * @return
	 */
	private boolean checkStrVsBlock(ItemStack stack, IBlockState state) {
		
		boolean b = false;
		
		// Check Block List that the axe can mine...
		Iterator<Block> it = blocks.iterator();
		
		while(it.hasNext()) {
			Block block = it.next();
			
			if(block == state.getBlock()) {
				b = true;
				break;
			}
		}
		
		
		// Check Materials
		Material material = state.getMaterial();
		
		// Added in harvest tool and harvest level
		return b || 
			   material == Material.wood || 
			   material == Material.plants || 
			   material == Material.vine || 
			   (((state.getBlock().getHarvestTool(state) != null && state.getBlock().getHarvestTool(state).equals("axe"))? true : false) && state.getBlock().getHarvestLevel(state) <= this.material.getHarvestLevel());
	}
	
	
	@Override
	public float getStrVsBlock(ItemStack stack, IBlockState state) {
		// TODO Auto-generated method stub
		return (!checkStrVsBlock(stack, state))? super.getStrVsBlock(stack, state) : this.material.getEfficiencyOnProperMaterial();
	}
}