package net.acecraft.mod.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

import net.acecraft.mod.ShopKeeper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntitySpear extends Entity implements IProjectile {
	
    private int fieldX = -1;
    private int fieldY = -1;
    private int fieldZ = -1;
    private Block block;
    private int inData;
    private boolean inGround;
    public int canBePickedUp;
    public int arrowShake;
    public Entity shootingEntity;
    private int ticksInGround;
    private int ticksInAir;
    private double damage = 2.0D;
    private int knockbackStrength;
    String id;
    
    public EntitySpear(World world){
        super(world);
        this.renderDistanceWeight = 10.0D;
        this.setSize(0.5F, 0.5F);
    }
    
    public EntitySpear(World world, double x, double y, double z){
        super(world);
        this.renderDistanceWeight = 10.0D;
        this.setSize(0.5F, 0.5F);
        this.setPosition(x, y, z);
        this.yOffset = 0.0F;
    }
    
    public EntitySpear(World world, EntityLivingBase entity1, EntityLivingBase entity2, float value1, float value2){
        super(world);
        this.renderDistanceWeight = 10.0D;
        this.shootingEntity = entity1;
        if (entity1 instanceof EntityPlayer){
            this.canBePickedUp = 1;
        }
        this.posY = entity1.posY + (double)entity1.getEyeHeight() - 0.10000000149011612D;
        double d0 = entity2.posX - entity1.posX;
        double d1 = entity2.boundingBox.minY + (double)(entity2.height / 3.0F) - this.posY;
        double d2 = entity2.posZ - entity1.posZ;
        double d3 = (double)MathHelper.sqrt_double(d0 * d0 + d2 * d2);
        if (d3 >= 1.0E-7D){
            float f2 = (float)(Math.atan2(d2, d0) * 180.0D / Math.PI) - 90.0F;
            float f3 = (float)(-(Math.atan2(d1, d3) * 180.0D / Math.PI));
            double d4 = d0 / d3;
            double d5 = d2 / d3;
            this.setLocationAndAngles(entity1.posX + d4, this.posY, entity1.posZ + d5, f2, f3);
            this.yOffset = 0.0F;
            float f4 = (float)d3 * 0.2F;
            this.setThrowableHeading(d0, d1 + (double)f4, d2, value1, value2);
        }
    }
    
    public EntitySpear(World world, EntityLivingBase entity, float value, String _id, float dmg){
        super(world);
        damage = dmg*1.5;
        this.renderDistanceWeight = 10.0D;
        this.shootingEntity = entity;
        if (entity instanceof EntityPlayer){
            this.canBePickedUp = 1;
        }
        this.setSize(0.5F, 0.5F);
        this.setLocationAndAngles(entity.posX, entity.posY + (double)entity.getEyeHeight(), entity.posZ, entity.rotationYaw, entity.rotationPitch);
        this.posX -= (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
        this.posY -= 0.10000000149011612D;
        this.posZ -= (double)(MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0.0F;
        this.motionX = (double)(-MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
        this.motionZ = (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
        this.motionY = (double)(-MathHelper.sin(this.rotationPitch / 180.0F * (float)Math.PI));
        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, value * 1.5F, 1.0F);
        id = _id;
    }
    
    protected void entityInit(){
        this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
    }
    
    public void setThrowableHeading(double x, double y, double z, float value1, float value2){
        float f2 = MathHelper.sqrt_double(x * x + y * y + z * z);
        x /= (double)f2;
        y /= (double)f2;
        z /= (double)f2;
        x += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)value2;
        y += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)value2;
        z += this.rand.nextGaussian() * (double)(this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)value2;
        x *= (double)value1;
        y *= (double)value1;
        z *= (double)value1;
        this.motionX = x;
        this.motionY = y;
        this.motionZ = z;
        float f3 = MathHelper.sqrt_double(x * x + z * z);
        this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(x, z) * 180.0D / Math.PI);
        this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(y, (double)f3) * 180.0D / Math.PI);
        this.ticksInGround = 0;
    }
    
    @SideOnly(Side.CLIENT)
    public void setPositionAndRotation2(double x, double y, double z, float rotX, float rotY, int rotZ){
        this.setPosition(x, y, z);
        this.setRotation(rotX, rotY);
    }
    
    @SideOnly(Side.CLIENT)
    public void setVelocity(double x, double y, double z){
        this.motionX = x;
        this.motionY = y;
        this.motionZ = z;
        if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F){
            float f = MathHelper.sqrt_double(x * x + z * z);
            this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(x, z) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(y, (double)f) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch;
            this.prevRotationYaw = this.rotationYaw;
            this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            this.ticksInGround = 0;
        }
    }
    
    public void onUpdate(){
        super.onUpdate();
        if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F){
            float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch = (float)(Math.atan2(this.motionY, (double)f) * 180.0D / Math.PI);
        }
        Block block = this.worldObj.getBlock(this.fieldX, this.fieldY, this.fieldZ);
        if (block.getMaterial() != Material.air){
            block.setBlockBoundsBasedOnState(this.worldObj, this.fieldX, this.fieldY, this.fieldZ);
            AxisAlignedBB axisalignedbb = block.getCollisionBoundingBoxFromPool(this.worldObj, this.fieldX, this.fieldY, this.fieldZ);
            if (axisalignedbb != null && axisalignedbb.isVecInside(Vec3.createVectorHelper(this.posX, this.posY, this.posZ))){
                this.inGround = true;
            }
        }
        if (this.arrowShake > 0){
            --this.arrowShake;
        }
        if (this.inGround){
            int j = this.worldObj.getBlockMetadata(this.fieldX, this.fieldY, this.fieldZ);
            if (block == this.block && j == this.inData){
                ++this.ticksInGround;
                if (this.ticksInGround == 1200){
                    this.setDead();
                }
            }else{
                this.inGround = false;
                this.motionX *= (double)(this.rand.nextFloat() * 0.2F);
                this.motionY *= (double)(this.rand.nextFloat() * 0.2F);
                this.motionZ *= (double)(this.rand.nextFloat() * 0.2F);
                this.ticksInGround = 0;
                this.ticksInAir = 0;
            }
        }else{
            ++this.ticksInAir;
            Vec3 vec31 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
            Vec3 vec3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            MovingObjectPosition movingobjectposition = this.worldObj.func_147447_a(vec31, vec3, false, true, false);
            vec31 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
            vec3 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            if (movingobjectposition != null){
                vec3 = Vec3.createVectorHelper(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
            }
            Entity entity = null;
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
            double d0 = 0.0D;
            int i;
            float f1;
            for (i = 0; i < list.size(); ++i){
                Entity entity1 = (Entity)list.get(i);
                if (entity1.canBeCollidedWith() && (entity1 != this.shootingEntity || this.ticksInAir >= 5)){
                    f1 = 0.3F;
                    AxisAlignedBB axisalignedbb1 = entity1.boundingBox.expand((double)f1, (double)f1, (double)f1);
                    MovingObjectPosition movingobjectposition1 = axisalignedbb1.calculateIntercept(vec31, vec3);
                    if (movingobjectposition1 != null){
                        double d1 = vec31.distanceTo(movingobjectposition1.hitVec);
                        if (d1 < d0 || d0 == 0.0D){
                            entity = entity1;
                            d0 = d1;
                        }
                    }
                }
            }
            if (entity != null){
                movingobjectposition = new MovingObjectPosition(entity);
            }
            if (movingobjectposition != null && movingobjectposition.entityHit != null && movingobjectposition.entityHit instanceof EntityPlayer){
                EntityPlayer entityplayer = (EntityPlayer)movingobjectposition.entityHit;
                if (entityplayer.capabilities.disableDamage || this.shootingEntity instanceof EntityPlayer && !((EntityPlayer)this.shootingEntity).canAttackPlayer(entityplayer)){
                    movingobjectposition = null;
                }
            }
            float f2;
            float f4;
            if (movingobjectposition != null){
                if (movingobjectposition.entityHit != null){
                    f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                    int k = MathHelper.ceiling_double_int((double)f2 * this.damage);
                    if (this.getIsCritical()){
                        k += this.rand.nextInt(k / 2 + 2);
                    }
                    DamageSource damagesource = null;
                    if (this.shootingEntity == null){
                        damagesource = DamageSource.causeThrownDamage(this, this);
                    }else{
                        damagesource = DamageSource.causeThrownDamage(this, this.shootingEntity);
                    }
                    if (this.isBurning() && !(movingobjectposition.entityHit instanceof EntityEnderman)){
                        movingobjectposition.entityHit.setFire(5);
                    }
                    if (movingobjectposition.entityHit.attackEntityFrom(damagesource, (float)k)){
                        if (movingobjectposition.entityHit instanceof EntityLivingBase){
                            EntityLivingBase entitylivingbase = (EntityLivingBase)movingobjectposition.entityHit;
                            if (!this.worldObj.isRemote){
                                entitylivingbase.setArrowCountInEntity(entitylivingbase.getArrowCountInEntity() + 1);
                            }
                            if (this.knockbackStrength > 0){
                                f4 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
                                if (f4 > 0.0F){
                                    movingobjectposition.entityHit.addVelocity(this.motionX * (double)this.knockbackStrength * 0.6000000238418579D / (double)f4, 0.1D, this.motionZ * (double)this.knockbackStrength * 0.6000000238418579D / (double)f4);
                                }
                            }
                            if (this.shootingEntity != null && this.shootingEntity instanceof EntityLivingBase){
                                EnchantmentHelper.func_151384_a(entitylivingbase, this.shootingEntity);
                                EnchantmentHelper.func_151385_b((EntityLivingBase)this.shootingEntity, entitylivingbase);
                            }
                            if (this.shootingEntity != null && movingobjectposition.entityHit != this.shootingEntity && movingobjectposition.entityHit instanceof EntityPlayer && this.shootingEntity instanceof EntityPlayerMP){
                                ((EntityPlayerMP)this.shootingEntity).playerNetServerHandler.sendPacket(new S2BPacketChangeGameState(6, 0.0F));
                            }
                        }
                        this.playSound("random.bowhit", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
                        if (!(movingobjectposition.entityHit instanceof EntityEnderman)){
                            this.setDead();
                        }
                    }else{
                        this.motionX *= -0.10000000149011612D;
                        this.motionY *= -0.10000000149011612D;
                        this.motionZ *= -0.10000000149011612D;
                        this.rotationYaw += 180.0F;
                        this.prevRotationYaw += 180.0F;
                        this.ticksInAir = 0;
                    }
                }else{
                    this.fieldX = movingobjectposition.blockX;
                    this.fieldY = movingobjectposition.blockY;
                    this.fieldZ = movingobjectposition.blockZ;
                    this.block = this.worldObj.getBlock(this.fieldX, this.fieldY, this.fieldZ);
                    this.inData = this.worldObj.getBlockMetadata(this.fieldX, this.fieldY, this.fieldZ);
                    this.motionX = (double)((float)(movingobjectposition.hitVec.xCoord - this.posX));
                    this.motionY = (double)((float)(movingobjectposition.hitVec.yCoord - this.posY));
                    this.motionZ = (double)((float)(movingobjectposition.hitVec.zCoord - this.posZ));
                    f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                    this.posX -= this.motionX / (double)f2 * 0.05000000074505806D;
                    this.posY -= this.motionY / (double)f2 * 0.05000000074505806D;
                    this.posZ -= this.motionZ / (double)f2 * 0.05000000074505806D;
                    this.playSound("random.bowhit", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
                    this.inGround = true;
                    this.arrowShake = 7;
                    this.setIsCritical(false);
                    if (this.block.getMaterial() != Material.air){
                        this.block.onEntityCollidedWithBlock(this.worldObj, this.fieldX, this.fieldY, this.fieldZ, this);
                    }
                }
            }
            if (this.getIsCritical()){
                for (i = 0; i < 4; ++i){
                    this.worldObj.spawnParticle("crit", this.posX + this.motionX * (double)i / 4.0D, this.posY + this.motionY * (double)i / 4.0D, this.posZ + this.motionZ * (double)i / 4.0D, -this.motionX, -this.motionY + 0.2D, -this.motionZ);
                }
            }
            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;
            f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
            for (this.rotationPitch = (float)(Math.atan2(this.motionY, (double)f2) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F){
                ;
            }
            while (this.rotationPitch - this.prevRotationPitch >= 180.0F){
                this.prevRotationPitch += 360.0F;
            }
            while (this.rotationYaw - this.prevRotationYaw < -180.0F){
                this.prevRotationYaw -= 360.0F;
            }
            while (this.rotationYaw - this.prevRotationYaw >= 180.0F){
                this.prevRotationYaw += 360.0F;
            }
            this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
            this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
            float f3 = 0.99F;
            f1 = 0.05F;
            if (this.isInWater()){
                for (int l = 0; l < 4; ++l){
                    f4 = 0.25F;
                    this.worldObj.spawnParticle("bubble", this.posX - this.motionX * (double)f4, this.posY - this.motionY * (double)f4, this.posZ - this.motionZ * (double)f4, this.motionX, this.motionY, this.motionZ);
                }
                f3 = 0.8F;
            }
            if (this.isWet()){
                this.extinguish();
            }
            this.motionX *= (double)f3;
            this.motionY *= (double)f3;
            this.motionZ *= (double)f3;
            this.motionY -= (double)f1;
            this.setPosition(this.posX, this.posY, this.posZ);
            this.func_145775_I();
        }
    }
    
    public void writeEntityToNBT(NBTTagCompound nbt){
        nbt.setShort("xTile", (short)this.fieldX);
        nbt.setShort("yTile", (short)this.fieldY);
        nbt.setShort("zTile", (short)this.fieldZ);
        nbt.setShort("life", (short)this.ticksInGround);
        nbt.setByte("inTile", (byte)Block.getIdFromBlock(this.block));
        nbt.setByte("inData", (byte)this.inData);
        nbt.setByte("shake", (byte)this.arrowShake);
        nbt.setByte("inGround", (byte)(this.inGround ? 1 : 0));
        nbt.setByte("pickup", (byte)this.canBePickedUp);
        nbt.setDouble("damage", this.damage);
    }
    
    public void readEntityFromNBT(NBTTagCompound nbt){
        this.fieldX = nbt.getShort("xTile");
        this.fieldY = nbt.getShort("yTile");
        this.fieldZ = nbt.getShort("zTile");
        this.ticksInGround = nbt.getShort("life");
        this.block = Block.getBlockById(nbt.getByte("inTile") & 255);
        this.inData = nbt.getByte("inData") & 255;
        this.arrowShake = nbt.getByte("shake") & 255;
        this.inGround = nbt.getByte("inGround") == 1;
        if (nbt.hasKey("damage", 99)){
            this.damage = nbt.getDouble("damage");
        }
        if (nbt.hasKey("pickup", 99)){
            this.canBePickedUp = nbt.getByte("pickup");
        }else if (nbt.hasKey("player", 99)){
            this.canBePickedUp = nbt.getBoolean("player") ? 1 : 0;
        }
    }
    
    public void onCollideWithPlayer(EntityPlayer player){
        if (!this.worldObj.isRemote && this.inGround){
            boolean flag = this.canBePickedUp == 1 || this.canBePickedUp == 2 && player.capabilities.isCreativeMode;
            ItemStack stack;
                 if(id.compareTo("ToolSpearFlint")      == 0) { stack = new ItemStack(ShopKeeper.toolSpearFlint,      1); }
            else if(id.compareTo("ToolSpearIron")       == 0) { stack = new ItemStack(ShopKeeper.toolSpearIron,       1); }
            else if(id.compareTo("ToolSpearGold")       == 0) { stack = new ItemStack(ShopKeeper.toolSpearGold,       1); }
            else if(id.compareTo("ToolSpearCopper")     == 0) { stack = new ItemStack(ShopKeeper.toolSpearCopper,     1); }
            else if(id.compareTo("ToolSpearLead")       == 0) { stack = new ItemStack(ShopKeeper.toolSpearLead,       1); }
            else if(id.compareTo("ToolSpearBronze")     == 0) { stack = new ItemStack(ShopKeeper.toolSpearBronze,     1); }
            else if(id.compareTo("ToolSpearSteel")      == 0) { stack = new ItemStack(ShopKeeper.toolSpearSteel,      1); }
            else if(id.compareTo("ToolSpearMythril")    == 0) { stack = new ItemStack(ShopKeeper.toolSpearMythril,    1); }
            else if(id.compareTo("ToolSpearIridium")    == 0) { stack = new ItemStack(ShopKeeper.toolSpearIridium,    1); }
            else if(id.compareTo("ToolSpearAdamantium") == 0) { stack = new ItemStack(ShopKeeper.toolSpearAdamantium, 1); }
            else if(id.compareTo("ToolSpearUnobtanium") == 0) { stack = new ItemStack(ShopKeeper.toolSpearUnobtanium, 1); }
            else{ stack = new ItemStack(Items.flint, 1); }
            if (this.canBePickedUp == 1 && !player.inventory.addItemStackToInventory(stack)){
                flag = false;
            }
            if (flag){
                this.playSound("random.pop", 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
                //player.onItemPickup(this, 1);
                this.setDead();
            }
        }
    }
    
    /*public void onCollideWithPlayer(EntityPlayer player){
        if (!this.worldObj.isRemote && this.inGround && this.arrowShake <= 0){
            boolean flag = this.canBePickedUp == 1 || this.canBePickedUp == 2 && player.capabilities.isCreativeMode;
            if (this.canBePickedUp == 1 && !player.inventory.addItemStackToInventory(new ItemStack(Items.arrow, 1))){
                flag = false;
            }
            if (flag){
                this.playSound("random.pop", 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
                player.onItemPickup(this, 1);
                this.setDead();
            }
        }
    }*/
    
    protected boolean canTriggerWalking(){
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public float getShadowSize(){
        return 0.0F;
    }
    
    public void setDamage(double damage){
        this.damage = damage;
    }
    
    public double getDamage(){
        return this.damage;
    }
    
    public void setKnockbackStrength(int strength){
        this.knockbackStrength = strength;
    }
    
    public boolean canAttackWithItem()
    {
        return true;
    }
    
    public void setIsCritical(boolean flag){
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);
        if (flag){
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 1)));
        }else{
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & -2)));
        }
    }
    
    public boolean getIsCritical(){
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);
        return (b0 & 1) != 0;
    }

}