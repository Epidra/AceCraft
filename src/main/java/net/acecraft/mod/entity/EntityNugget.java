package net.acecraft.mod.entity;

import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.entity.EntitySpear.PickupStatus;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityNugget extends EntityThrowable
{
	
	public String id = "empty";
	
    public EntityNugget(World worldIn)
    {
        super(worldIn);
    }

    public EntityNugget(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
    }
    
    public EntityNugget(World worldIn, EntityLivingBase throwerIn, String name)
    {
        super(worldIn, throwerIn);
        id = name;
    }
    
    public EntityNugget(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(RayTraceResult result)
    {
        if (result.entityHit != null)
        {
            int i = 2;

            if (result.entityHit instanceof EntityBlaze)
            {
                i = 3;
            }

            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)i);
        }

        for (int j = 0; j < 8; ++j)
        {
            this.worldObj.spawnParticle(EnumParticleTypes.SNOWBALL, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
        }

        if (!this.worldObj.isRemote)
        {
            //this.setDead();
        }
    }
    
    public void onCollideWithPlayer(EntityPlayer player){
        if (!this.worldObj.isRemote && this.inGround){
        	boolean flag = !player.capabilities.isCreativeMode;
            ItemStack stack;
                 if(id.compareTo("ToolSpearFlint")      == 0) { stack = new ItemStack(ShopKeeper.toolSpearFlint,      1); }
            else if(id.compareTo("ToolSpearObsidian")   == 0) { stack = new ItemStack(ShopKeeper.toolSpearObsidian,   1); }
            else if(id.compareTo("ToolSpearIron")       == 0) { stack = new ItemStack(ShopKeeper.toolSpearIron,       1); }
            else if(id.compareTo("ToolSpearGold")       == 0) { stack = new ItemStack(ShopKeeper.toolSpearGold,       1); }
            else if(id.compareTo("ToolSpearCopper")     == 0) { stack = new ItemStack(ShopKeeper.toolSpearCopper,     1); }
            else if(id.compareTo("ToolSpearBronze")     == 0) { stack = new ItemStack(ShopKeeper.toolSpearBronze,     1); }
            else if(id.compareTo("ToolSpearSteel")      == 0) { stack = new ItemStack(ShopKeeper.toolSpearSteel,      1); }
            else if(id.compareTo("ToolSpearMythril")    == 0) { stack = new ItemStack(ShopKeeper.toolSpearMythril,    1); }
            else if(id.compareTo("ToolSpearIridium")    == 0) { stack = new ItemStack(ShopKeeper.toolSpearIridium,    1); }
            else if(id.compareTo("ToolSpearAdamantium") == 0) { stack = new ItemStack(ShopKeeper.toolSpearAdamantium, 1); }
            else if(id.compareTo("ToolSpearUnobtanium") == 0) { stack = new ItemStack(ShopKeeper.toolSpearUnobtanium, 1); }
            else{ stack = new ItemStack(Items.flint, 1); }
            if (flag){
            	player.worldObj.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.entity_arrow_shoot, SoundCategory.NEUTRAL, 1.0F, 1.0F / (rand.nextFloat() * 0.4F + 1.2F));
                //player.onItemPickup(this, 1);
                this.setDead();
            }
        }
    }
    
}