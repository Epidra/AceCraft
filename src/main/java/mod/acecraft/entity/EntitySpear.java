package mod.acecraft.entity;

import mod.acecraft.ShopKeeper;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class EntitySpear extends AbstractArrowEntity implements IEntityAdditionalSpawnData {

    private static final DataParameter<Byte> LOYALTY_LEVEL = EntityDataManager.createKey(EntitySpear.class, DataSerializers.BYTE);
    private static final DataParameter<Boolean> field_226571_aq_ = EntityDataManager.createKey(EntitySpear.class, DataSerializers.BOOLEAN);
    private ItemStack thrownStack = new ItemStack(Items.TRIDENT);
    private boolean dealtDamage;
    public int returningTicks;

    public EntitySpear(EntityType<? extends AbstractArrowEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public EntitySpear(FMLPlayMessages.SpawnEntity packet, World worldIn)
    {
        super(ShopKeeper.ENTITY_SPEAR.get(), worldIn);
        PacketBuffer buf = packet.getAdditionalData();
        thrownStack = buf.readItemStack();
    }

    @Nonnull
    public EntityType<?> getType() { return ShopKeeper.ENTITY_SPEAR.get(); }


    public EntitySpear(World worldIn, LivingEntity thrower, ItemStack thrownStackIn) {
        super(ShopKeeper.ENTITY_SPEAR.get(), thrower, worldIn);
        this.thrownStack = thrownStackIn.copy();
        this.dataManager.set(LOYALTY_LEVEL, (byte) EnchantmentHelper.getLoyaltyModifier(thrownStackIn));
        this.dataManager.set(field_226571_aq_, thrownStackIn.hasEffect());
    }

    @OnlyIn(Dist.CLIENT)
    public EntitySpear(World worldIn, double x, double y, double z) {
        super(ShopKeeper.ENTITY_SPEAR.get(), x, y, z, worldIn);
    }

    @Override

    public void writeSpawnData(PacketBuffer buffer) {

        buffer.writeItemStack(this.thrownStack);

    }

    @OnlyIn(Dist.CLIENT)
    public boolean func_226572_w_() {
        return this.dataManager.get(field_226571_aq_);
    }



    @Override

    public void readSpawnData(PacketBuffer additionalData) {

    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(LOYALTY_LEVEL, (byte)0);
        this.dataManager.register(field_226571_aq_, false);
    }

    public Item getStack(){
        return thrownStack.getItem();
    }

    @Override
    public IPacket<?> createSpawnPacket()
    {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    public void tick() {
        if (this.timeInGround > 4) {
            this.dealtDamage = true;
        }

        Entity entity = this.getShooter();
        if ((this.dealtDamage || this.getNoClip()) && entity != null) {
            int i = this.dataManager.get(LOYALTY_LEVEL);
            if (i > 0 && !this.shouldReturnToThrower()) {
                if (!this.world.isRemote && this.pickupStatus == AbstractArrowEntity.PickupStatus.ALLOWED) {
                    this.entityDropItem(this.getArrowStack(), 0.1F);
                }

                this.remove();
            } else if (i > 0) {
                this.setNoClip(true);
                Vec3d vec3d = new Vec3d(entity.getPosX() - this.getPosX(), entity.getPosY() + (double)entity.getEyeHeight() - this.getPosY(), entity.getPosZ() - this.getPosZ());
                //this.setPosY() += vec3d.y * 0.015D * (double)i;
                if (this.world.isRemote) {
                    this.lastTickPosY = this.getPosY();
                }

                double d0 = 0.05D * (double)i;
                this.setMotion(this.getMotion().scale(0.95D).add(vec3d.normalize().scale(d0)));
                if (this.returningTicks == 0) {
                    this.playSound(SoundEvents.ITEM_TRIDENT_RETURN, 10.0F, 1.0F);
                }

                ++this.returningTicks;
            }
        }

        super.tick();
    }

    private boolean shouldReturnToThrower() {
        Entity entity = this.getShooter();
        if (entity != null && entity.isAlive()) {
            return !(entity instanceof ServerPlayerEntity) || !entity.isSpectator();
        } else {
            return false;
        }
    }

    protected ItemStack getArrowStack() {
        return this.thrownStack.copy();
    }

    @Nullable
    protected EntityRayTraceResult rayTraceEntities(Vec3d startVec, Vec3d endVec) {
        return this.dealtDamage ? null : super.rayTraceEntities(startVec, endVec);
    }

    protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
        Entity entity = p_213868_1_.getEntity();
        float f = 8.0F;
        if (entity instanceof LivingEntity) {
            LivingEntity livingentity = (LivingEntity)entity;
            f += EnchantmentHelper.getModifierForCreature(this.thrownStack, livingentity.getCreatureAttribute());
        }

        Entity entity1 = this.getShooter();
        DamageSource damagesource = DamageSource.causeTridentDamage(this, (Entity)(entity1 == null ? this : entity1));
        this.dealtDamage = true;
        SoundEvent soundevent = SoundEvents.ITEM_TRIDENT_HIT;
        if (entity.attackEntityFrom(damagesource, f) && entity instanceof LivingEntity) {
            LivingEntity livingentity1 = (LivingEntity)entity;
            if (entity1 instanceof LivingEntity) {
                EnchantmentHelper.applyThornEnchantments(livingentity1, entity1);
                EnchantmentHelper.applyArthropodEnchantments((LivingEntity)entity1, livingentity1);
            }

            this.arrowHit(livingentity1);
        }

        this.setMotion(this.getMotion().mul(-0.01D, -0.1D, -0.01D));
        float f1 = 1.0F;
        if (this.world instanceof ServerWorld && this.world.isThundering() && EnchantmentHelper.hasChanneling(this.thrownStack)) {
            BlockPos blockpos = entity.getPosition();
            if (this.world.canBlockSeeSky(blockpos)) {
                LightningBoltEntity lightningboltentity = new LightningBoltEntity(this.world, (double)blockpos.getX() + 0.5D, (double)blockpos.getY(), (double)blockpos.getZ() + 0.5D, false);
                lightningboltentity.setCaster(entity1 instanceof ServerPlayerEntity ? (ServerPlayerEntity)entity1 : null);
                ((ServerWorld)this.world).addLightningBolt(lightningboltentity);
                soundevent = SoundEvents.ITEM_TRIDENT_THUNDER;
                f1 = 5.0F;
            }
        }

        this.playSound(soundevent, f1, 1.0F);
    }

    protected SoundEvent getHitEntitySound() {
        return SoundEvents.ITEM_TRIDENT_HIT_GROUND;
    }

    public void onCollideWithPlayer(PlayerEntity entityIn) {
        Entity entity = this.getShooter();
        if (entity == null || entity.getUniqueID() == entityIn.getUniqueID()) {
            super.onCollideWithPlayer(entityIn);
        }
    }

    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        if (compound.contains("Trident", 10)) {
            this.thrownStack = ItemStack.read(compound.getCompound("Trident"));
        }

        this.dealtDamage = compound.getBoolean("DealtDamage");
        this.dataManager.set(LOYALTY_LEVEL, (byte) EnchantmentHelper.getLoyaltyModifier(this.thrownStack));
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.put("Trident", this.thrownStack.write(new CompoundNBT()));
        compound.putBoolean("DealtDamage", this.dealtDamage);
    }

    protected void tryDespawn() {
        int i = this.dataManager.get(LOYALTY_LEVEL);
        if (this.pickupStatus != AbstractArrowEntity.PickupStatus.ALLOWED || i <= 0) {
            super.checkDespawn();
        }

    }

    protected float getWaterDrag() {
        return 0.99F;
    }

    @OnlyIn(Dist.CLIENT)
    public boolean isInRangeToRender3d(double x, double y, double z) {
        return true;
    }

}
