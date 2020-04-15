package mod.acecraft.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class EntityCrab extends AnimalEntity {

    private static final Ingredient TEMPTATION_ITEMS = Ingredient.fromItems(Items.COD, Items.SALMON);
    public short rotationFlipper;
    private boolean moveFlipper = false;

    public EntityCrab(EntityType<? extends AnimalEntity> type, World world) {
        super(type, world);
        this.stepHeight = 1.0F;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new EntityAIExtinguishFire());
        this.goalSelector.addGoal(2, new PanicGoal(this, 1.5D));
        this.goalSelector.addGoal(3, new BreedGoal(this, 0.8D));
        this.goalSelector.addGoal(4, new AvoidEntityGoal<>(this, PolarBearEntity.class, 6.0F, 1.0D, 1.2D));
        this.goalSelector.addGoal(5, new TemptGoal(this, 1.0D, false, TEMPTATION_ITEMS));
        this.goalSelector.addGoal(6, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(7, new RandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(8, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(9, new LookAtGoal(this, EntityCrab.class, 6.0F));
        this.goalSelector.addGoal(10, new LookRandomlyGoal(this));
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.16D);
    }

    //@Override
    //protected SoundEvent getAmbientSound() {
    //    return this.isChild() ? WaddlesSounds.ADELIE_BABY_AMBIENT : WaddlesSounds.ADELIE_AMBIENT;
    //}

   // @Override
   // protected SoundEvent getHurtSound(DamageSource source) {
   //     return WaddlesSounds.ADELIE_HURT;
   // }

    //@Override
    //protected SoundEvent getDeathSound() {
    //    return WaddlesSounds.ADELIE_DEATH;
    //}

    @Nullable
    @Override
    public AgeableEntity createChild(AgeableEntity ageableEntity) {
        return null;
    }

    @Override
    public void livingTick() {
        super.livingTick();
        if (this.world.isRemote) {
            if (this.getPosition().getX() != this.prevPosZ) {
                if (this.moveFlipper) {
                    this.rotationFlipper++;
                }
            }
        }
    }

    //@Override
    //protected int getExperiencePoints(PlayerEntity player) {
    //    if (ConfigurationHandler.GENERAL.dropExp.get()) {
    //        return super.getExperiencePoints(player);
    //    }
    //    return 0;
    //}

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public boolean isBreedingItem(@Nonnull ItemStack stack) {
        return !stack.isEmpty() && TEMPTATION_ITEMS.test(stack);
    }

    //@Override
    //@Nonnull
    //public ResourceLocation getLootTable() {
    //    return ConfigurationHandler.GENERAL.dropFish.get() ? super.getLootTable() : LootTables.EMPTY;
    //}

   // @Override
   // public EntityCrab createChild(@Nonnull AgeableEntity ageable) {
   //     return PenguinRegistry.ADELIE_PENGUIN.create(this.world);
   // }

    @Override
    protected float getStandingEyeHeight(Pose pose, EntitySize size) {
        return this.isChild() ? 0.5F : 0.9F;
    }

    private class EntityAIExtinguishFire extends PanicGoal {
        EntityAIExtinguishFire() {
            super(EntityCrab.this, 2.0D);
        }

        @Override
        public boolean shouldExecute() {
            return (EntityCrab.this.isChild() || EntityCrab.this.isBurning()) && super.shouldExecute();
        }
    }
}
