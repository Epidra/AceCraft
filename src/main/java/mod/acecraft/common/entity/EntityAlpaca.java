package mod.acecraft.common.entity;

import com.google.common.collect.Maps;
import mod.acecraft.Register;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.inventory.TransientCraftingContainer;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.IForgeShearable;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

public class EntityAlpaca extends Animal implements Shearable, IForgeShearable, RangedAttackMob {
	
	private static final Map<DyeColor, float[]> COLORARRAY_BY_COLOR = Maps.<DyeColor, float[]>newEnumMap(Arrays.stream(DyeColor.values()).collect(Collectors.toMap((p_29868_) -> { return p_29868_; }, EntityAlpaca::createSheepColor)));
	private static final EntityDataAccessor<Byte> DATA_WOOL_ID      = SynchedEntityData.defineId(EntityAlpaca.class, EntityDataSerializers.BYTE);
	private static final Map<DyeColor, ItemLike>  ITEM_BY_DYE       = Util.make(Maps.newEnumMap(DyeColor.class), (map) -> {
		map.put(DyeColor.WHITE,      Blocks.WHITE_WOOL);
		map.put(DyeColor.ORANGE,     Blocks.ORANGE_WOOL);
		map.put(DyeColor.MAGENTA,    Blocks.MAGENTA_WOOL);
		map.put(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_WOOL);
		map.put(DyeColor.YELLOW,     Blocks.YELLOW_WOOL);
		map.put(DyeColor.LIME,       Blocks.LIME_WOOL);
		map.put(DyeColor.PINK,       Blocks.PINK_WOOL);
		map.put(DyeColor.GRAY,       Blocks.GRAY_WOOL);
		map.put(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_WOOL);
		map.put(DyeColor.CYAN,       Blocks.CYAN_WOOL);
		map.put(DyeColor.PURPLE,     Blocks.PURPLE_WOOL);
		map.put(DyeColor.BLUE,       Blocks.BLUE_WOOL);
		map.put(DyeColor.BROWN,      Blocks.BROWN_WOOL);
		map.put(DyeColor.GREEN,      Blocks.GREEN_WOOL);
		map.put(DyeColor.RED,        Blocks.RED_WOOL);
		map.put(DyeColor.BLACK,      Blocks.BLACK_WOOL);
	});
	
	private int          eatAnimationTick;
	private EatBlockGoal eatBlockGoal;
	boolean didSpit;
	
	
	
	
	
	// ---------- ---------- ---------- ----------  CONSTRUCTOR  ---------- ---------- ---------- ---------- //
	
	public EntityAlpaca(EntityType<? extends EntityAlpaca> entity, Level level) {
		super(entity, level);
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SETUP  ---------- ---------- ---------- ---------- //
	
	protected void registerGoals() {
		this.eatBlockGoal = new EatBlockGoal(this);
		this.goalSelector.addGoal(0, new FloatGoal(this));
		this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 40, 20.0F));
		this.goalSelector.addGoal(2, new PanicGoal(this, 1.25D));
		this.goalSelector.addGoal(3, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(4, new TemptGoal(this, 1.1D, Ingredient.of(Items.WHEAT), false));
		this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(6, this.eatBlockGoal);
		this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 6.0F));
		this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));
		this.targetSelector.addGoal(1, new AlpacaHurtByTargetGoal(this));
	}
	
	protected void customServerAiStep() {
		this.eatAnimationTick = this.eatBlockGoal.getEatAnimationTick();
		super.customServerAiStep();
	}
	
	public void aiStep() {
		if (this.level().isClientSide) {
			this.eatAnimationTick = Math.max(0, this.eatAnimationTick - 1);
		}
		super.aiStep();
	}
	
	public static AttributeSupplier.Builder createAttributes() {
		return Mob.createMobAttributes().add(Attributes.ATTACK_DAMAGE, 1).add(Attributes.MAX_HEALTH, 8.0D).add(Attributes.MOVEMENT_SPEED, 0.23F);
	}
	
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_WOOL_ID, (byte)0);
	}
	
	public ResourceLocation getDefaultLootTable() {
		if (this.isSheared()) {
			return this.getType().getDefaultLootTable();
		} else {
			ResourceLocation resourcelocation = switch(this.getColor()) {
				case WHITE      -> new ResourceLocation("acecraft", "entities/alpaca/white");
				case ORANGE     -> new ResourceLocation("acecraft", "entities/alpaca/orange");
				case MAGENTA    -> new ResourceLocation("acecraft", "entities/alpaca/magenta");
				case LIGHT_BLUE -> new ResourceLocation("acecraft", "entities/alpaca/light_blue");
				case YELLOW     -> new ResourceLocation("acecraft", "entities/alpaca/yellow");
				case LIME       -> new ResourceLocation("acecraft", "entities/alpaca/lime");
				case PINK       -> new ResourceLocation("acecraft", "entities/alpaca/pink");
				case GRAY       -> new ResourceLocation("acecraft", "entities/alpaca/gray");
				case LIGHT_GRAY -> new ResourceLocation("acecraft", "entities/alpaca/light_gray");
				case CYAN       -> new ResourceLocation("acecraft", "entities/alpaca/cyan");
				case PURPLE     -> new ResourceLocation("acecraft", "entities/alpaca/purple");
				case BLUE       -> new ResourceLocation("acecraft", "entities/alpaca/blue");
				case BROWN      -> new ResourceLocation("acecraft", "entities/alpaca/brown");
				case GREEN      -> new ResourceLocation("acecraft", "entities/alpaca/green");
				case RED        -> new ResourceLocation("acecraft", "entities/alpaca/red");
				case BLACK      -> new ResourceLocation("acecraft", "entities/alpaca/black");
			};
			return resourcelocation;
		}
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  INTERACTION  ---------- ---------- ---------- ---------- //
	
	public InteractionResult mobInteract(Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		if(itemstack.getItem() instanceof DyeItem){
			DyeItem dye = (DyeItem) itemstack.getItem();
			
			if (this.isAlive() && !this.isSheared() && this.getColor() != dye.getDyeColor()) {
				this.level().playSound(player, this, SoundEvents.DYE_USE, SoundSource.PLAYERS, 1.0F, 1.0F);
				if (!player.level().isClientSide) {
					this.setColor(dye.getDyeColor());
					itemstack.shrink(1);
				}
				
				return InteractionResult.sidedSuccess(player.level().isClientSide);
			}
		}
		return super.mobInteract(player, hand);
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SAVE / LOAD  ---------- ---------- ---------- ---------- //
	
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putBoolean("Sheared",     this.isSheared()       );
		compound.putByte(   "Color", (byte)this.getColor().getId());
	}
	
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound                      );
		this.setSheared(             compound.getBoolean("Sheared"));
		this.setColor(DyeColor.byId( compound.getByte(   "Color") ));
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SUPPORT - COLOR  ---------- ---------- ---------- ---------- //
	
	private static float[] createSheepColor(DyeColor color) {
		if (color == DyeColor.WHITE) {
			return new float[]{0.9019608F, 0.9019608F, 0.9019608F};
		} else {
			float[] afloat = color.getTextureDiffuseColors();
			float f = 0.75F;
			return new float[]{afloat[0] * 0.75F, afloat[1] * 0.75F, afloat[2] * 0.75F};
		}
	}
	
	public static float[] getColorArray(DyeColor color) {
		return COLORARRAY_BY_COLOR.get(color);
	}
	
	private DyeColor getOffspringColor(Animal parent1, Animal parent2) {
		DyeColor dyecolor1 = ((EntityAlpaca)parent1).getColor();
		DyeColor dyecolor2 = ((EntityAlpaca)parent2).getColor();
		CraftingContainer craftingcontainer = makeContainer(dyecolor1, dyecolor2);
		return this.level().getRecipeManager().getRecipeFor(RecipeType.CRAFTING, craftingcontainer, this.level()).map((recipe) -> recipe.assemble(craftingcontainer, this.level().registryAccess())).map(ItemStack::getItem).filter(DyeItem.class::isInstance).map(DyeItem.class::cast).map(DyeItem::getDyeColor).orElseGet(() -> this.level().random.nextBoolean() ? dyecolor1 : dyecolor2);
	}
	
	public static DyeColor getRandomSheepColor(RandomSource random) {
		int i = random.nextInt(100);
		     if (i <  5) { return DyeColor.BLACK;      }
		else if (i < 10) { return DyeColor.GRAY;       }
		else if (i < 15) { return DyeColor.LIGHT_GRAY; }
		else if (i < 18) { return DyeColor.ORANGE;     }
		else             { return random.nextInt(500) == 0 ? DyeColor.YELLOW : DyeColor.BROWN;
		}
	}
	
	public DyeColor getColor() {
		return DyeColor.byId(this.entityData.get(DATA_WOOL_ID) & 15);
	}
	
	public void setColor(DyeColor color) {
		byte b0 = this.entityData.get(DATA_WOOL_ID);
		this.entityData.set(DATA_WOOL_ID, (byte)(b0 & 240 | color.getId() & 15));
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SUPPORT - SHEARING  ---------- ---------- ---------- ---------- //
	
	public void shear(SoundSource sound) {
		this.level().playSound(null, this, SoundEvents.SHEEP_SHEAR, sound, 1.0F, 1.0F);
		this.setSheared(true);
		int i = 1 + this.random.nextInt(3);
		for(int j = 0; j < i; ++j) {
			ItemEntity itementity = this.spawnAtLocation(ITEM_BY_DYE.get(this.getColor()), 1);
			if (itementity != null) {
				itementity.setDeltaMovement(itementity.getDeltaMovement().add((this.random.nextFloat() - this.random.nextFloat()) * 0.1F, this.random.nextFloat() * 0.05F, (this.random.nextFloat() - this.random.nextFloat()) * 0.1F));
			}
		}
	}
	
	public boolean readyForShearing() {
		return this.isAlive() && !this.isSheared() && !this.isBaby();
	}
	
	public boolean isSheared() {
		return (this.entityData.get(DATA_WOOL_ID) & 16) != 0;
	}
	
	public void setSheared(boolean flag) {
		byte b0 = this.entityData.get(DATA_WOOL_ID);
		if (flag) { this.entityData.set(DATA_WOOL_ID, (byte)(b0 |  16)); }
		else      { this.entityData.set(DATA_WOOL_ID, (byte)(b0 & -17)); }
	}
	
	@Override
	public boolean isShearable(@NotNull ItemStack item, Level world, BlockPos pos) {
		return readyForShearing();
	}
	
	@NotNull
	@Override
	public List<ItemStack> onSheared(@Nullable Player player, @NotNull ItemStack item, Level world, BlockPos pos, int fortune) {
		world.playSound(null, this, SoundEvents.SHEEP_SHEAR, player == null ? SoundSource.BLOCKS : SoundSource.PLAYERS, 1.0F, 1.0F);
		this.gameEvent(GameEvent.SHEAR, player);
		if (!world.isClientSide) {
			this.setSheared(true);
			int i = 1 + this.random.nextInt(3);
			List<ItemStack> items = new ArrayList<>();
			for (int j = 0; j < i; ++j) {
				items.add(new ItemStack(ITEM_BY_DYE.get(this.getColor())));
			}
			return items;
		}
		return emptyList();
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SUPPORT  ---------- ---------- ---------- ---------- //
	
	protected float getStandingEyeHeight(Pose pose, EntityDimensions dimensions) {
		return 0.95F * dimensions.height;
	}
	
	public void handleEntityEvent(byte b) {
		if (b == 10) {
			this.eatAnimationTick = 40;
		} else {
			super.handleEntityEvent(b);
		}
		
	}
	
	public float getHeadEatPositionScale(float value) {
		if (this.eatAnimationTick <= 0) {
			return 0.0F;
		} else if (this.eatAnimationTick >= 4 && this.eatAnimationTick <= 36) {
			return 1.0F;
		} else {
			return this.eatAnimationTick < 4 ? ((float)this.eatAnimationTick - value) / 4.0F : -((float)(this.eatAnimationTick - 40) - value) / 4.0F;
		}
	}
	
	public float getHeadEatAngleScale(float value) {
		if (this.eatAnimationTick > 4 && this.eatAnimationTick <= 36) {
			float f = ((float)(this.eatAnimationTick - 4) - value) / 32.0F;
			return ((float)Math.PI / 5F) + 0.21991149F * Mth.sin(f * 28.7F);
		} else {
			return this.eatAnimationTick > 0 ? ((float)Math.PI / 5F) : this.getXRot() * ((float)Math.PI / 180F);
		}
	}
	
	@Nullable
	public EntityAlpaca getBreedOffspring(ServerLevel level, AgeableMob entity) {
		EntityAlpaca sheep = Register.ENTITY_ALPACA.get().create(level);
		if (sheep != null) {
			sheep.setColor(this.getOffspringColor(this, (EntityAlpaca)entity));
		}
		return sheep;
	}
	
	public void ate() {
		super.ate();
		this.setSheared(false);
		if (this.isBaby()) {
			this.ageUp(60);
		}
	}
	
	public static boolean canAlpacaSpawn(EntityType<? extends EntityAlpaca> animal, ServerLevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
		return level.getBlockState(pos.below()).is(Blocks.GRASS_BLOCK) && level.getRawBrightness(pos, 0) > 8 && level.canSeeSky(pos);
	}
	
	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroup, @Nullable CompoundTag compound) {
		this.setColor(getRandomSheepColor(level.getRandom()));
		return super.finalizeSpawn(level, difficulty, spawnType, spawnGroup, compound);
	}
	
	private static CraftingContainer makeContainer(DyeColor color1, DyeColor color2) {
		CraftingContainer craftingcontainer = new TransientCraftingContainer(new AbstractContainerMenu(null, -1) {
			public ItemStack quickMoveStack(Player player, int value) {
				return ItemStack.EMPTY;
			}
			public boolean stillValid(Player player) {
				return false;
			}
		}, 2, 1);
		craftingcontainer.setItem(0, new ItemStack(DyeItem.byColor(color1)));
		craftingcontainer.setItem(1, new ItemStack(DyeItem.byColor(color2)));
		return craftingcontainer;
	}
	
	public void performRangedAttack(LivingEntity entity, float range) {
		this.spit(entity);
	}
	
	private void spit(LivingEntity entity) {
		EntitySpit llamaspit = new EntitySpit(this.level(), this);
		double d0 = entity.getX() - this.getX();
		double d1 = entity.getY(0.3333333333333333D) - llamaspit.getY();
		double d2 = entity.getZ() - this.getZ();
		double d3 = Math.sqrt(d0 * d0 + d2 * d2) * (double)0.2F;
		llamaspit.shoot(d0, d1 + d3, d2, 1.5F, 10.0F);
		if (!this.isSilent()) {
			this.level().playSound((Player)null, this.getX(), this.getY(), this.getZ(), SoundEvents.LLAMA_SPIT, this.getSoundSource(), 1.0F, 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.2F);
		}
		
		this.level().addFreshEntity(llamaspit);
		this.didSpit = true;
	}
	
	void setDidSpit(boolean flag) {
		this.didSpit = flag;
	}
	
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SOUND  ---------- ---------- ---------- ---------- //
	
	protected SoundEvent getAngrySound() {
		return SoundEvents.LLAMA_ANGRY;
	}
	
	protected SoundEvent getAmbientSound() {
		return SoundEvents.LLAMA_AMBIENT;
	}
	
	protected SoundEvent getHurtSound(DamageSource source) {
		return SoundEvents.LLAMA_HURT;
	}
	
	protected SoundEvent getDeathSound() {
		return SoundEvents.LLAMA_DEATH;
	}
	
	@Nullable
	protected SoundEvent getEatingSound() {
		return SoundEvents.LLAMA_EAT;
	}
	
	protected void playStepSound(BlockPos pos, BlockState state) {
		this.playSound(SoundEvents.LLAMA_STEP, 0.15F, 1.0F);
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  GOALS  ---------- ---------- ---------- ---------- //
	
	static class AlpacaHurtByTargetGoal extends HurtByTargetGoal {
		public AlpacaHurtByTargetGoal(EntityAlpaca entity) {
			super(entity);
		}
		
		public boolean canContinueToUse() {
			if (this.mob instanceof EntityAlpaca) {
				EntityAlpaca alpaca = (EntityAlpaca)this.mob;
				if (alpaca.didSpit) {
					alpaca.setDidSpit(false);
					return false;
				}
			}
			
			return super.canContinueToUse();
		}
	}
	
	
}
