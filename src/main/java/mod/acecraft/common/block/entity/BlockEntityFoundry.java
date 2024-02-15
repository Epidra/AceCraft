package mod.acecraft.common.block.entity;

import mod.acecraft.Register;
import mod.acecraft.client.logic.LogicFoundry;
import mod.acecraft.common.block.BlockFoundry;
import mod.acecraft.util.FoundryContent;
import mod.lucky77.block.entity.BlockEntityBase;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Collection;

public class BlockEntityFoundry extends BlockEntityBase<LogicFoundry> {
	
	private Item lastCheckedItem = Blocks.AIR.asItem();
	public int coalAmount = 0;
	public int cookTime = 0;
	public int cookTimeMax = 600;
	public boolean readyToEject = false;
	
	
	
	
	
	// ---------- ---------- ---------- ----------  CONSTRUCTOR  ---------- ---------- ---------- ---------- //
	
	public BlockEntityFoundry(BlockEntityType<?> tileEntityTypeIn, BlockPos blockpos, BlockState blockstate) {
		super(tileEntityTypeIn, blockpos, blockstate, 6, new LogicFoundry());
		data = new ContainerData() {
			public int get(int index) {
				switch(index) {
					default: return 0;
					case 0: return coalAmount;
					case 1: return cookTime;
					case 2: return cookTimeMax;
					case 3: return readyToEject ? 1 : 0;
				}
			}
			public void set(int index, int value) {
				switch(index) {
					default:                     break;
					case 0: coalAmount  = value; break;
					case 1: cookTime    = value; break;
					case 2: cookTimeMax = value; break;
					case 3: readyToEject = value == 1; break;
				}
			}
			public int getCount() {
				return 4;
			}
		};
	}
	
	public BlockEntityFoundry(BlockPos blockpos, BlockState blockstate) {
		this(Register.TILE_FOUNDRY.get(), blockpos, blockstate);
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SERVER TICK  ---------- ---------- ---------- ---------- //
	
	public static void serverTick(Level level, BlockPos pos, BlockState state, BlockEntityFoundry BE){
		boolean isDirty = false;
		if(BE.cookTime == 0){
			if(!BE.inventory.get(0).isEmpty()){
				if(BE.lastCheckedItem != BE.inventory.get(0).getItem()){
					isDirty = BE.searchForMaterial();
					BE.lastCheckedItem = isDirty ? Blocks.AIR.asItem() : BE.inventory.get(0).getItem();
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
		if (isDirty){
			BE.setChanged();
		}
		if(BE.cookTime >  0 && !state.getValue(BlockFoundry.LIT)){ level.setBlockAndUpdate(pos, state.setValue(BlockFoundry.LIT,  true)); }
		if(BE.cookTime == 0 &&  state.getValue(BlockFoundry.LIT)){ level.setBlockAndUpdate(pos, state.setValue(BlockFoundry.LIT, false)); }
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SAVE / LOAD  ---------- ---------- ---------- ---------- //
	
	@Override
	public void load(CompoundTag nbt){
		super.load(nbt);
		this.coalAmount = nbt.getInt("Coal");
		this.cookTime = nbt.getInt("CookTime");
		this.cookTimeMax = nbt.getInt("CookTimeMax");
		logic().load(nbt.getString("Content"));
	}
	
	@Override
	public void saveAdditional(CompoundTag compound){
		super.saveAdditional(compound);
		compound.putInt("Coal", this.coalAmount);
		compound.putInt("CookTime", this.cookTime);
		compound.putInt("CookTimeMax", this.cookTimeMax);
		compound.putString("Content", logic().save());
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  NETWORK  ---------- ---------- ---------- ---------- //
	
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}
	
	public CompoundTag getUpdateTag() {
		CompoundTag tag = this.saveWithoutMetadata();
		saveAdditional(tag);
		return tag;
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SUPPORT  ---------- ---------- ---------- ---------- //
	
	private LogicFoundry logic(){
		return (LogicFoundry) logic;
	}
	
	private boolean searchForMaterial(){
		
		// Search for Coal
		if(inventory.get(0).getItem() == Items.COAL || inventory.get(0).getItem() == Items.CHARCOAL){
			coalAmount++;
			if(inventory.get(0).getCount() == 1){
				inventory.set(0, ItemStack.EMPTY);
			} else {
				inventory.get(0).shrink(1);
			}
			return true;
		}
		
		// Search for Foundry Items
		for(FoundryContent c : logic().content){
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
		Collection<Recipe<?>> stuff = level.getRecipeManager().getRecipes();
		for(Recipe r : stuff){
			if(r.getResultItem(level.registryAccess()).getItem() == inventory.get(0).getItem()){
				NonNullList<Ingredient> ingredients = r.getIngredients();
				int matches = 0;
				String name = "";
				for(Ingredient i : ingredients){
					ItemStack[] stack = i.getItems();
					for(ItemStack itemStack : stack) {
						for(FoundryContent c : logic().content) {
							if(c.result == itemStack.getItem()) {
								matches++;
								name = c.id;
							}
						}
					}
				}
				if(matches > 0){
					logic.increase(name, matches);
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
	
	public void ignite() {
		if(cookTime == 0){
			if(coalAmount > logic().count() / 8 + 1){
				coalAmount -= logic().count() / 8 + 1;
				cookTime = 1;
				cookTimeMax = logic().count() * 100;
				
			}
		}
	}
	
	public void eject(){
		if(cookTime == 0){
			int invPos = 1;
			for(int i = 1; i < 6; i++){
				if(inventory.get(i).isEmpty()){
					break;
				} else {
					invPos++;
				}
			}
			for(FoundryContent c : logic().content){
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
