package mod.acecraft.entity;

import com.google.common.collect.Maps;
import mod.acecraft.ShopKeeper;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.DyeColor;
import net.minecraft.item.DyeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.loot.LootTables;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class EntityAlpaca extends AnimalEntity implements IShearable, net.minecraftforge.common.IForgeShearable {

    private static final DataParameter<Byte> DATA_WOOL_ID = EntityDataManager.defineId(EntityAlpaca.class, DataSerializers.BYTE);
    private static final Map<DyeColor, IItemProvider> ITEM_BY_DYE = Util.make(Maps.newEnumMap(DyeColor.class), (p_203402_0_) -> {
        p_203402_0_.put(DyeColor.WHITE, Blocks.WHITE_WOOL);
        p_203402_0_.put(DyeColor.ORANGE, Blocks.ORANGE_WOOL);
        p_203402_0_.put(DyeColor.MAGENTA, Blocks.MAGENTA_WOOL);
        p_203402_0_.put(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_WOOL);
        p_203402_0_.put(DyeColor.YELLOW, Blocks.YELLOW_WOOL);
        p_203402_0_.put(DyeColor.LIME, Blocks.LIME_WOOL);
        p_203402_0_.put(DyeColor.PINK, Blocks.PINK_WOOL);
        p_203402_0_.put(DyeColor.GRAY, Blocks.GRAY_WOOL);
        p_203402_0_.put(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_WOOL);
        p_203402_0_.put(DyeColor.CYAN, Blocks.CYAN_WOOL);
        p_203402_0_.put(DyeColor.PURPLE, Blocks.PURPLE_WOOL);
        p_203402_0_.put(DyeColor.BLUE, Blocks.BLUE_WOOL);
        p_203402_0_.put(DyeColor.BROWN, Blocks.BROWN_WOOL);
        p_203402_0_.put(DyeColor.GREEN, Blocks.GREEN_WOOL);
        p_203402_0_.put(DyeColor.RED, Blocks.RED_WOOL);
        p_203402_0_.put(DyeColor.BLACK, Blocks.BLACK_WOOL);
    });
    private static final Map<DyeColor, float[]> COLORARRAY_BY_COLOR = Maps.newEnumMap(Arrays.stream(DyeColor.values()).collect(Collectors.toMap((DyeColor p_200204_0_) -> {
        return p_200204_0_;
    }, EntityAlpaca::createSheepColor)));
    private int eatAnimationTick;
    private EatGrassGoal eatBlockGoal;




    //----------------------------------------CONSTRUCTOR----------------------------------------//

    public EntityAlpaca(EntityType<? extends EntityAlpaca> p_i50245_1_, World p_i50245_2_) {
        super(p_i50245_1_, p_i50245_2_);
    }




    //----------------------------------------SUPPORT----------------------------------------//

    protected void registerGoals() {
        this.eatBlockGoal = new EatGrassGoal(this);
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.1D, Ingredient.of(Items.WHEAT), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(5, this.eatBlockGoal);
        this.goalSelector.addGoal(6, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
    }

    protected void customServerAiStep() {
        this.eatAnimationTick = this.eatBlockGoal.getEatAnimationTick();
        super.customServerAiStep();
    }

    public void aiStep() {
        if (this.level.isClientSide) {
            this.eatAnimationTick = Math.max(0, this.eatAnimationTick - 1);
        }

        super.aiStep();
    }

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MobEntity.createMobAttributes().add(Attributes.MAX_HEALTH, 8.0D).add(Attributes.MOVEMENT_SPEED, (double)0.23F);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_WOOL_ID, (byte)0);
    }

    public ResourceLocation getDefaultLootTable() {
        if (this.isSheared()) {
            return this.getType().getDefaultLootTable();
        } else {
            switch(this.getColor()) {
                default:
                case WHITE:      return ShopKeeper.ALPACA_WHITE;
                case ORANGE:     return ShopKeeper.ALPACA_ORANGE;
                case MAGENTA:    return ShopKeeper.ALPACA_MAGENTA;
                case LIGHT_BLUE: return ShopKeeper.ALPACA_LIGHT_BLUE;
                case YELLOW:     return ShopKeeper.ALPACA_YELLOW;
                case LIME:       return ShopKeeper.ALPACA_LIME;
                case PINK:       return ShopKeeper.ALPACA_PINK;
                case GRAY:       return ShopKeeper.ALPACA_GRAY;
                case LIGHT_GRAY: return ShopKeeper.ALPACA_LIGHT_GRAY;
                case CYAN:       return ShopKeeper.ALPACA_CYAN;
                case PURPLE:     return ShopKeeper.ALPACA_PURPLE;
                case BLUE:       return ShopKeeper.ALPACA_BLUE;
                case BROWN:      return ShopKeeper.ALPACA_BROWN;
                case GREEN:      return ShopKeeper.ALPACA_GREEN;
                case RED:        return ShopKeeper.ALPACA_RED;
                case BLACK:      return ShopKeeper.ALPACA_BLACK;
            }
        }
    }

    private static float[] createSheepColor(DyeColor p_192020_0_) {
        if (p_192020_0_ == DyeColor.WHITE) {
            return new float[]{0.9019608F, 0.9019608F, 0.9019608F};
        } else {
            float[] afloat = p_192020_0_.getTextureDiffuseColors();
            float f = 0.75F;
            return new float[]{afloat[0] * 0.75F, afloat[1] * 0.75F, afloat[2] * 0.75F};
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static float[] getColorArray(DyeColor p_175513_0_) {
        return COLORARRAY_BY_COLOR.get(p_175513_0_);
    }

    @OnlyIn(Dist.CLIENT)
    public void handleEntityEvent(byte p_70103_1_) {
        if (p_70103_1_ == 10) {
            this.eatAnimationTick = 40;
        } else {
            super.handleEntityEvent(p_70103_1_);
        }

    }

    @OnlyIn(Dist.CLIENT)
    public float getHeadEatPositionScale(float p_70894_1_) {
        if (this.eatAnimationTick <= 0) {
            return 0.0F;
        } else if (this.eatAnimationTick >= 4 && this.eatAnimationTick <= 36) {
            return 1.0F;
        } else {
            return this.eatAnimationTick < 4 ? ((float)this.eatAnimationTick - p_70894_1_) / 4.0F : -((float)(this.eatAnimationTick - 40) - p_70894_1_) / 4.0F;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public float getHeadEatAngleScale(float p_70890_1_) {
        if (this.eatAnimationTick > 4 && this.eatAnimationTick <= 36) {
            float f = ((float)(this.eatAnimationTick - 4) - p_70890_1_) / 32.0F;
            return ((float)Math.PI / 5F) + 0.21991149F * MathHelper.sin(f * 28.7F);
        } else {
            return this.eatAnimationTick > 0 ? ((float)Math.PI / 5F) : this.xRot * ((float)Math.PI / 180F);
        }
    }

    public ActionResultType mobInteract(PlayerEntity p_230254_1_, Hand p_230254_2_) {
        ItemStack itemstack = p_230254_1_.getItemInHand(p_230254_2_);
        if (false && itemstack.getItem() == Items.SHEARS) { //Forge: Moved to onSheared
            if (!this.level.isClientSide && this.readyForShearing()) {
                this.shear(SoundCategory.PLAYERS);
                itemstack.hurtAndBreak(1, p_230254_1_, (p_213613_1_) -> {
                    p_213613_1_.broadcastBreakEvent(p_230254_2_);
                });
                return ActionResultType.SUCCESS;
            } else {
                return ActionResultType.CONSUME;
            }
        } else {
            return super.mobInteract(p_230254_1_, p_230254_2_);
        }
    }

    public void shear(SoundCategory p_230263_1_) {
        this.level.playSound((PlayerEntity)null, this, SoundEvents.SHEEP_SHEAR, p_230263_1_, 1.0F, 1.0F);
        this.setSheared(true);
        int i = 1 + this.random.nextInt(3);

        for(int j = 0; j < i; ++j) {
            ItemEntity itementity = this.spawnAtLocation(ITEM_BY_DYE.get(this.getColor()), 1);
            if (itementity != null) {
                itementity.setDeltaMovement(itementity.getDeltaMovement().add((double)((this.random.nextFloat() - this.random.nextFloat()) * 0.1F), (double)(this.random.nextFloat() * 0.05F), (double)((this.random.nextFloat() - this.random.nextFloat()) * 0.1F)));
            }
        }

    }

    public boolean readyForShearing() {
        return this.isAlive() && !this.isSheared() && !this.isBaby();
    }

    public void addAdditionalSaveData(CompoundNBT p_213281_1_) {
        super.addAdditionalSaveData(p_213281_1_);
        p_213281_1_.putBoolean("Sheared", this.isSheared());
        p_213281_1_.putByte("Color", (byte)this.getColor().getId());
    }

    public void readAdditionalSaveData(CompoundNBT p_70037_1_) {
        super.readAdditionalSaveData(p_70037_1_);
        this.setSheared(p_70037_1_.getBoolean("Sheared"));
        this.setColor(DyeColor.byId(p_70037_1_.getByte("Color")));
    }

    protected SoundEvent getAmbientSound() {
        return ShopKeeper.SOUND_ALPACA_AMBIENT.get();
    }

    protected SoundEvent getHurtSound(DamageSource p_184601_1_) {
        return ShopKeeper.SOUND_ALPACA_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return ShopKeeper.SOUND_ALPACA_DEATH.get();
    }

    protected void playStepSound(BlockPos p_180429_1_, BlockState p_180429_2_) {
        this.playSound(SoundEvents.SHEEP_STEP, 0.15F, 1.0F);
    }

    public DyeColor getColor() {
        return DyeColor.byId(this.entityData.get(DATA_WOOL_ID) & 15);
    }

    public void setColor(DyeColor p_175512_1_) {
        byte b0 = this.entityData.get(DATA_WOOL_ID);
        this.entityData.set(DATA_WOOL_ID, (byte)(b0 & 240 | p_175512_1_.getId() & 15));
    }

    public boolean isSheared() {
        return (this.entityData.get(DATA_WOOL_ID) & 16) != 0;
    }

    public void setSheared(boolean p_70893_1_) {
        byte b0 = this.entityData.get(DATA_WOOL_ID);
        if (p_70893_1_) {
            this.entityData.set(DATA_WOOL_ID, (byte)(b0 | 16));
        } else {
            this.entityData.set(DATA_WOOL_ID, (byte)(b0 & -17));
        }

    }

    public static DyeColor getRandomSheepColor(Random p_175510_0_) {
        int i = p_175510_0_.nextInt(100);
        if (i < 5) {
            return DyeColor.BLACK;
        } else if (i < 10) {
            return DyeColor.GRAY;
        } else if (i < 15) {
            return DyeColor.LIGHT_GRAY;
        } else if (i < 18) {
            return DyeColor.BROWN;
        } else {
            return p_175510_0_.nextInt(500) == 0 ? DyeColor.PINK : DyeColor.ORANGE;
        }
    }

    public EntityAlpaca getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        EntityAlpaca sheepentity = (EntityAlpaca)p_241840_2_;
        EntityAlpaca sheepentity1 = ShopKeeper.ENTITY_ALPACA.get().create(p_241840_1_);
        sheepentity1.setColor(this.getOffspringColor(this, sheepentity));
        return sheepentity1;
    }

    public void ate() {
        this.setSheared(false);
        if (this.isBaby()) {
            this.ageUp(60);
        }

    }

    @Nullable
    public ILivingEntityData finalizeSpawn(IServerWorld p_213386_1_, DifficultyInstance p_213386_2_, SpawnReason p_213386_3_, @Nullable ILivingEntityData p_213386_4_, @Nullable CompoundNBT p_213386_5_) {
        this.setColor(getRandomSheepColor(p_213386_1_.getRandom()));
        return super.finalizeSpawn(p_213386_1_, p_213386_2_, p_213386_3_, p_213386_4_, p_213386_5_);
    }

    private DyeColor getOffspringColor(AnimalEntity p_175511_1_, AnimalEntity p_175511_2_) {
        DyeColor dyecolor = ((EntityAlpaca)p_175511_1_).getColor();
        DyeColor dyecolor1 = ((EntityAlpaca)p_175511_2_).getColor();
        CraftingInventory craftinginventory = makeContainer(dyecolor, dyecolor1);
        return this.level.getRecipeManager().getRecipeFor(IRecipeType.CRAFTING, craftinginventory, this.level).map((p_213614_1_) -> {
            return p_213614_1_.assemble(craftinginventory);
        }).map(ItemStack::getItem).filter(DyeItem.class::isInstance).map(DyeItem.class::cast).map(DyeItem::getDyeColor).orElseGet(() -> {
            return this.level.random.nextBoolean() ? dyecolor : dyecolor1;
        });
    }

    private static CraftingInventory makeContainer(DyeColor p_213611_0_, DyeColor p_213611_1_) {
        CraftingInventory craftinginventory = new CraftingInventory(new Container((ContainerType)null, -1) {
            public boolean stillValid(PlayerEntity p_75145_1_) {
                return false;
            }
        }, 2, 1);
        craftinginventory.setItem(0, new ItemStack(DyeItem.byColor(p_213611_0_)));
        craftinginventory.setItem(1, new ItemStack(DyeItem.byColor(p_213611_1_)));
        return craftinginventory;
    }

    protected float getStandingEyeHeight(Pose p_213348_1_, EntitySize p_213348_2_) {
        return 1F * p_213348_2_.height;
    }

    @Override
    public boolean isShearable(@javax.annotation.Nonnull ItemStack item, World world, BlockPos pos) {
        return readyForShearing();
    }

    @javax.annotation.Nonnull
    @Override
    public java.util.List<ItemStack> onSheared(@Nullable PlayerEntity player, @javax.annotation.Nonnull ItemStack item, World world, BlockPos pos, int fortune) {
        world.playSound(null, this, SoundEvents.SHEEP_SHEAR, player == null ? SoundCategory.BLOCKS : SoundCategory.PLAYERS, 1.0F, 1.0F);
        if (!world.isClientSide) {
            this.setSheared(true);
            int i = 1 + this.random.nextInt(3);

            java.util.List<ItemStack> items = new java.util.ArrayList<>();
            for (int j = 0; j < i; ++j) {
                items.add(new ItemStack(ITEM_BY_DYE.get(this.getColor())));
            }
            return items;
        }
        return java.util.Collections.emptyList();
    }

}
