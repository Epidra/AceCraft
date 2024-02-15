package mod.acecraft.common.block.entity;

import mod.acecraft.Register;
import mod.acecraft.client.logic.LogicFoundry;
import mod.acecraft.common.block.BlockDistillery;
import mod.acecraft.util.recipe.RecipeDistillery;
import mod.lucky77.block.entity.BlockEntityBase;
import mod.lucky77.util.content.Dummy;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class BlockEntityDistillery extends BlockEntityBase<Dummy> {
	
	// private static final int INPUT_SLOT = 0;
	// private static final int OUTPUT_SLOT = 3;
	
	private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
	
	// private int progress = 0;
	// private int maxProgress = 78;
	
	int burnTime;
	int burnDuration;
	int cookingProgress;
	int cookingTotalTime = 240;
	
	
	
	
	
	// ---------- ---------- ---------- ----------  CONSTRUCTOR  ---------- ---------- ---------- ---------- //
	
	public BlockEntityDistillery(BlockEntityType<?> tileEntityTypeIn, BlockPos blockpos, BlockState blockstate) {
		super(tileEntityTypeIn, blockpos, blockstate, 4, new LogicFoundry());
		// public BlockEntityDistillery(BlockPos pPos, BlockState pBlockState) {
		// 	super(Register.TILE_DISTILLERY.get(), pPos, pBlockState);
		data = new ContainerData() {
			public int get(int p_58431_) {
				return switch(p_58431_) {
					case 0 -> BlockEntityDistillery.this.burnTime;
					case 1 -> BlockEntityDistillery.this.burnDuration;
					case 2 -> BlockEntityDistillery.this.cookingProgress;
					case 3 -> BlockEntityDistillery.this.cookingTotalTime;
					default -> 0;
				};
			}
				public void set(int p_58433_, int p_58434_) {
				switch(p_58433_) {
					case 0 -> BlockEntityDistillery.this.burnTime = p_58434_;
					case 1 -> BlockEntityDistillery.this.burnDuration = p_58434_;
					case 2 -> BlockEntityDistillery.this.cookingProgress = p_58434_;
					case 3 -> BlockEntityDistillery.this.cookingTotalTime = p_58434_;
				}
				}
				public int getCount() {
				return 4;
			}
		};
	}
	
	public BlockEntityDistillery(BlockPos blockpos, BlockState blockstate) {
		this(Register.TILE_DISTILLERY.get(), blockpos, blockstate);
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SERVER TICK  ---------- ---------- ---------- ---------- //
	
	public static void serverTick(Level level, BlockPos pos, BlockState state, BlockEntityDistillery BE){
		boolean flag0 = BE.isLit();
		boolean flag1 = false;
		boolean flag2 = !BE.inventory.get(0).isEmpty();
		boolean flag3 = !BE.inventory.get(1).isEmpty();
		boolean flag4 = !BE.inventory.get(2).isEmpty();
		
		// update Burn Time
		if (flag0) {
			--BE.burnTime;
		}
		
		// Check for Recipe
		if (flag0 || flag3 && flag2 && flag4) {
			if(BE.hasRecipe()){
				
				// Process Fuel
				if(!BE.isLit()){
					BE.burnTime = BE.getBurnDuration(BE.inventory.get(2));
					BE.burnDuration = BE.burnTime;
					if (BE.isLit()) {
						flag1 = true;
						if (BE.inventory.get(2).hasCraftingRemainingItem())
							BE.inventory.set(2, BE.inventory.get(2).getCraftingRemainingItem());
						else if (flag4) {
							Item item = BE.inventory.get(2).getItem();
							BE.inventory.get(2).shrink(1);
							if (BE.inventory.get(2).isEmpty()) {
								BE.inventory.set(1, BE.inventory.get(2).getCraftingRemainingItem());
							}
						}
					}
				}
				
				// Process Crafting
				if (BE.isLit()) {
					BE.increaseCraftingProgress();
					setChanged(level, pos, state);
					
					
					if(BE.hasProgressFinished()) {
						BE.craftItem();
						BE.resetProgress();
						flag1 = true;
					}
					
					level.sendBlockUpdated(pos, state, state, 2);
				} else {
					BE.cookingProgress = 0;
				}
			}
		}
		
		if(flag0 != BE.isLit()){
			level.setBlockAndUpdate(pos, state.setValue(BlockDistillery.LIT, BE.isLit()));
		}
		
		// if (flag1) {
		// 	setChanged(level, pos, state);
		// }
		
		// if(BE.hasRecipe()) {
		// 	BE.increaseCraftingProgress();
		// 	setChanged(level, pos, state);
		//
		// 	if(BE.hasProgressFinished()) {
		// 		BE.craftItem();
		// 		BE.resetProgress();
		// 	}
		// } else {
		// 	BE.resetProgress();
		// }
		
		
		
		// 	//
		// 	//
		// 	//
		// 	//
		// 	// }
		// 	//


		// 	//

		// 	//

		// 	// } else if (!p_155017_.isLit() && p_155017_.cookingProgress > 0) {
		// 	// 	p_155017_.cookingProgress = Mth.clamp(p_155017_.cookingProgress - 2, 0, p_155017_.cookingTotalTime);
		// 	// }
		// 	//
		// 	// if (flag != p_155017_.isLit()) {
		// 	// 	flag1 = true;
		// 	// 	p_155016_ = p_155016_.setValue(AbstractFurnaceBlock.LIT, Boolean.valueOf(p_155017_.isLit()));
		// 	// 	p_155014_.setBlock(p_155015_, p_155016_, 3);
		// 	// }
		// 	//
		
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SAVE / LOAD  ---------- ---------- ---------- ---------- //
	
	@Override
	protected void saveAdditional(CompoundTag compound) {
		super.saveAdditional(compound);
		compound.putInt("BurnTime", this.burnTime);
		compound.putInt("CookTime", this.cookingProgress);
		compound.putInt("CookTimeTotal", this.cookingTotalTime);
	}
	
	@Override
	public void load(CompoundTag compound) {
		super.load(compound);
		this.burnTime = compound.getInt("BurnTime");
		this.cookingProgress = compound.getInt("CookTime");
		this.cookingTotalTime = compound.getInt("CookTimeTotal");
		this.burnDuration = this.getBurnDuration(this.inventory.get(2));
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  NETWORK  ---------- ---------- ---------- ---------- //
	
	@Override
	public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
		if(cap == ForgeCapabilities.ITEM_HANDLER) {
			return lazyItemHandler.cast();
		}
		
		return super.getCapability(cap, side);
	}
	
	@Override
	public void onLoad() {
		super.onLoad();
		lazyItemHandler = LazyOptional.of(() -> (IItemHandler) inventory);
	}
	
	@Override
	public void invalidateCaps() {
		super.invalidateCaps();
		lazyItemHandler.invalidate();
	}
	
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}
	
	public CompoundTag getUpdateTag() {
		CompoundTag tag = this.saveWithoutMetadata();
		saveAdditional(tag);
		return tag;
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SUPPORT  ---------- ---------- ---------- ---------- //
	
	private boolean isLit() {
		return this.burnTime > 0;
	}
	
	// private boolean canBurn(RegistryAccess access, @javax.annotation.Nullable Recipe<?> recipe, NonNullList<ItemStack> stack, int maxStackSize) {
	// 	if(hasRecipe()){
	//
	// 	}
	// 	return false;
	// 	if (!stack.get(0).isEmpty() && recipe != null) {
	// 		ItemStack itemstack = ((Recipe<WorldlyContainer>) recipe).assemble(this, access);
	// 		if (itemstack.isEmpty()) {
	// 			return false;
	// 		} else {
	// 			ItemStack itemstack1 = stack.get(2);
	// 			if (itemstack1.isEmpty()) {
	// 				return true;
	// 			} else if (!ItemStack.isSameItem(itemstack1, itemstack)) {
	// 				return false;
	// 			} else if (itemstack1.getCount() + itemstack.getCount() <= maxStackSize && itemstack1.getCount() + itemstack.getCount() <= itemstack1.getMaxStackSize()) { // Forge fix: make furnace respect stack sizes in furnace recipes
	// 				return true;
	// 			} else {
	// 				return itemstack1.getCount() + itemstack.getCount() <= itemstack.getMaxStackSize(); // Forge fix: make furnace respect stack sizes in furnace recipes
	// 			}
	// 		}
	// 	} else {
	// 		return false;
	// 	}
	// }
	
	private boolean burn() {
		if (hasRecipe()){ // this.canBurn(p_266740_, p_266780_, p_267073_, p_267157_)) {
			// ItemStack itemstack = items.get(0);
			// ItemStack itemstack1 = ((Recipe<WorldlyContainer>) p_266780_).assemble(this, p_266740_);
			// ItemStack itemstack2 = items.get(2);
			// if (itemstack2.isEmpty()) {
			// 	items.set(2, itemstack1.copy());
			// } else if (itemstack2.is(itemstack1.getItem())) {
			// 	itemstack2.grow(itemstack1.getCount());
			// }
			// 	if (itemstack.is(Blocks.WET_SPONGE.asItem()) && !items.get(1).isEmpty() && items.get(1).is(Items.BUCKET)) {
			// 		items.set(1, new ItemStack(Items.WATER_BUCKET));
			// }
			inventory.get(2).shrink(1);
			return true;
		} else {
			return false;
		}
	}
	
	private void resetProgress() {
		cookingProgress = 0;
	}
	
	private void craftItem() {
		Optional<RecipeDistillery> recipe = getCurrentRecipe();
		ItemStack result = recipe.get().getResultItem(null);
		
		this.removeItem(0, 1);
		this.removeItem(1, 1);
		// this.inventory.extractItem(INPUT_SLOT, 1, false);
		
		this.setItem(3, new ItemStack(result.getItem(), this.inventory.get(3).getCount() + result.getCount()));
		// this.inventory.setStackInSlot(OUTPUT_SLOT, new ItemStack(result.getItem(), this.inventory.getStackInSlot(OUTPUT_SLOT).getCount() + result.getCount()));
	}
	
	private boolean hasRecipe() {
		Optional<RecipeDistillery> recipe = getCurrentRecipe();
		
		if(recipe.isEmpty()) {
			return false;
		}
		ItemStack result = recipe.get().getResultItem(getLevel().registryAccess());
		
		return canInsertAmountIntoOutputSlot(result.getCount()) && canInsertItemIntoOutputSlot(result.getItem());
	}
	
	private Optional<RecipeDistillery> getCurrentRecipe() {
		// SimpleContainer inventory = new SimpleContainer(this.itemHandler.getSlots());
		SimpleContainer inventory2 = new SimpleContainer(2);
		// for(int i = 0; i < itemHandler.getSlots(); i++) {
		// 	inventory2.setItem(i, this.itemHandler.getStackInSlot(i));
		// }
		// for(int i = 0; i < inventory.size(); i++) {
		// 	inventory2.setItem(i, this.inventory.get(i));
		// }
		inventory2.setItem(0, this.inventory.get(0));
		inventory2.setItem(1, this.inventory.get(1));
		
		return this.level.getRecipeManager().getRecipeFor(RecipeDistillery.Type.INSTANE, inventory2, level);
	}
	
	private boolean canInsertItemIntoOutputSlot(Item item) {
		// return this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() || this.itemHandler.getStackInSlot(OUTPUT_SLOT).is(item);
		return this.inventory.get(3).isEmpty() || this.inventory.get(3).is(item);
	}
	
	private boolean canInsertAmountIntoOutputSlot(int count) {
		// return this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + count <= this.itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
		return this.inventory.get(3).getCount() + count <= this.inventory.get(3).getMaxStackSize();
	}
	
	private boolean hasProgressFinished() {
		return cookingProgress >= cookingTotalTime;
	}
	
	private void increaseCraftingProgress() {
		cookingProgress++;
	}
	

	//

	//

	//
	protected int getBurnDuration(ItemStack stack) {
		if (stack.isEmpty()) {
			return 0;
		} else {
			Item item = stack.getItem();
			return net.minecraftforge.common.ForgeHooks.getBurnTime(stack, RecipeType.SMELTING);
		}
	}
	//
	// private static int getTotalCookTime(Level p_222693_, BlockEntityDistillery p_222694_) {
	// 	return p_222694_.quickCheck.getRecipeFor(p_222694_, p_222693_).map(AbstractCookingRecipe::getCookingTime).orElse(200);
	// }
	//
	// public static boolean isFuel(ItemStack p_58400_) {
	// 	return net.minecraftforge.common.ForgeHooks.getBurnTime(p_58400_, null) > 0;
	// }
	//
	@Override
	protected void setItemAdditional(int slot, ItemStack stack, boolean flag){
		if (slot == 0 && !flag) {
			this.cookingTotalTime = 200;
			this.cookingProgress = 0;
			this.setChanged();
		}
	}
	
	// private final RecipeType<? extends RecipeDistillery> recipeType = RecipeDistillery.Type.INSTANE;
	//
	
	
	
}
