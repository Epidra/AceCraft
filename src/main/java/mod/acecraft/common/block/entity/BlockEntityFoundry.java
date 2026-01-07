package mod.acecraft.common.block.entity;

import mod.acecraft.Register;
import mod.acecraft.common.block.BlockFoundry;
import mod.acecraft.custom.content.ContentFoundry;
import mod.acecraft.custom.logic.LogicFoundry;
import mod.lucky77.common.block.entity.BlockEntityBase;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.FurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Collection;

public class BlockEntityFoundry extends BlockEntityBase<LogicFoundry> {
	
	public       int coalAmount   =     0;
	public       int cookTime     =     0;
	public final int cookTimeMax  =   600;
	public   boolean readyToEject = false;
	
	private Item lastCheckedItem = Blocks.AIR.asItem();
	
	// default constructor
	public BlockEntityFoundry(BlockEntityType<?> type, BlockPos pos, BlockState state){
		super(type, pos, state, 6, new LogicFoundry());
		data = new ContainerData() {
			
			@Override
			public int get(int index) {
				switch(index){
					default: return 0;
					case 0: return coalAmount;
					case 1: return cookTime;
					case 2: return cookTimeMax;
					case 3: return readyToEject ? 1 : 0;
				}
			}
			
			@Override
			public void set(int index, int value) {
				switch(index){
					default: break;
					case 0: coalAmount = value; break;
					case 1: cookTime = value; break;
					case 2: break;
					case 3: readyToEject = value == 1; break;
				}
			}
			
			@Override
			public int getCount() {
				return 4;
			}
		};
	}
	
	// actual entry point
	public BlockEntityFoundry(BlockPos pos, BlockState state){
		this(Register.ENTITY_FOUNDRY.get(), pos, state);
	}
	
	public static void serverTick(Level level, BlockPos pos, BlockState state, BlockEntityFoundry BE){
		boolean isDirty = false;
		if(BE.cookTime == 0){
			if(!BE.inventory.getFirst().isEmpty()){
				if(BE.lastCheckedItem != BE.inventory.getFirst().getItem()){
					isDirty = BE.searchForMaterial();
					BE.lastCheckedItem = isDirty ? Blocks.AIR.asItem() : BE.inventory.getFirst().getItem();
					if(isDirty){
						BE.readyToEject = false;
					}
				}
			}
		} else {
			BE.cookTime++;
			if(BE.cookTime >= BE.cookTimeMax){
				BE.cookTime = 0;
				BE.logic().findBestMix();
				BE.readyToEject = true;
			}
		}
		if(isDirty){
			BE.setChanged();
		}
		
		// MISSING LOWER BLOCK PART
		// if(BE.cookTime > 0 && !state.getValue(BlockFoundry.LIT)){
		// 	level.setBlockAndUpdate(pos, state.setValue(BlockFoundry.LIT, true));
		// }
		// if(BE.cookTime == 0 && state.getValue(BlockFoundry.LIT)){
		// 	level.setBlockAndUpdate(pos, state.setValue(BlockFoundry.LIT, false));
		// }
	}
	
	@Override
	protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries){
		super.loadAdditional(tag, registries);
		// this.inventory = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		// ContainerHelper.loadAllItems(tag, this.inventory, registries);
		this.coalAmount = tag.getInt("CoalAmount");
		this.cookTime = tag.getInt("CookTime");
		// logic().load(tag.getString("Content"));
	}
	
	@Override
	protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries){
		super.saveAdditional(tag, registries);
		// ContainerHelper.saveAllItems(tag, this.inventory, registries);
		tag.putInt("CoalAmount", this.coalAmount);
		tag.putInt("CookTime", this.cookTime);
		// tag.putString("Content", logic().save());
	}
	
	// needed?
	private LogicFoundry logic(){
		return (LogicFoundry) logic;
	}
	
	private boolean searchForMaterial(){
		// ...
		
		// Search for Coal
		if(inventory.get(0).getItem() == Items.COAL || inventory.get(0).getItem() == Items.CHARCOAL){
			// ADD -- Coal Block (+9)
			coalAmount++;
			if(inventory.get(0).getCount() == 1){
				inventory.set(0, ItemStack.EMPTY); // needed ???
			} else {
				inventory.get(0).shrink(1);
			}
		}
		
		// Search for Foundry Items
		for(ContentFoundry c : logic.content){
			if(c.result == inventory.get(0).getItem()){
				c.amount++;
				if(inventory.get(0).getCount() == 1){
					inventory.set(0, ItemStack.EMPTY);
				} else {
					inventory.get(0).shrink(1);
				}
				return true;
			}
		}
		
		// Search for Recipes
		Collection<RecipeHolder<?>> stuff = level.getRecipeManager().getRecipes();
		for(RecipeHolder<?> r : stuff){
			Recipe r2 = ((RecipeHolder<? extends Recipe>) r).value();
			if(r2.getResultItem(level.registryAccess()).getItem() == inventory.get(0).getItem()){
				NonNullList<Ingredient> ingredients = r2.getIngredients();
				int matches = 0;
				String name = "";
				for(Ingredient i : ingredients){
					ItemStack[] recipeStack = i.getItems();
					for(ItemStack singleStack : recipeStack){
						for(ContentFoundry c : logic.content){
							if(c.result == singleStack.getItem()){
								matches++;
								name = c.id;
							}
						}
					}
				}
				if(matches > 0){
					logic.increase(name, matches);
					// move into static base class INVENTORY HELPER
					if(inventory.get(0).getCount() == 1){
						inventory.set(0, ItemStack.EMPTY);
					} else {
						inventory.get(0).shrink(1);
					}
					return true;
				}
			}
		}
		
		return false;
	}
	
	// is command?
	public void ignite(){
		if(cookTime == 0){
			if(coalAmount > logic.countALL() / 8 + 1){
				coalAmount -= logic.countALL() / 8 + 1;
				cookTime = 1;
				// cookTimeMax = logic.count() * 100;
			}
		}
	}
	
	// is command?
	public void eject(){
		if(cookTime == 0){
			int invPos = 1;
			
			// missing stacking on same item
			for(int i = 1; i < 6; i++){
				if(inventory.get(i).isEmpty()){
					break;
				} else {
					invPos++;
				}
			}
			
			for(ContentFoundry c : logic.content){
				if(c.amount > 0){
					inventory.set(invPos, c.generateStack());
					c.clear();
					invPos++;
					if(invPos == 6){
						break;
					}
				}
			}
		}
	}
	
}
