package net.acecraft.mod.entity;

import net.acecraft.mod.ShopKeeper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityNugget extends EntityThrowable {
	
	public String id = "empty";
	
    public EntityNugget(World worldIn){
        super(worldIn);
    }

    public EntityNugget(World worldIn, EntityLivingBase throwerIn){
        super(worldIn, throwerIn);
    }
    
    public EntityNugget(World worldIn, EntityLivingBase throwerIn, String name){
        super(worldIn, throwerIn);
        id = name;
    }
    
    public EntityNugget(World worldIn, double x, double y, double z){
        super(worldIn, x, y, z);
    }
    
    protected void onImpact(RayTraceResult result){
        if (result.entityHit != null){
            int i = 2;
            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)i);
        }
        for (int j = 0; j < 8; ++j){
            this.worldObj.spawnParticle(EnumParticleTypes.CRIT, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
        }
        if(!this.worldObj.isRemote)
        	this.dropItem(GetItem(), 1);
        this.setDead();
    }
    
    private Item GetItem(){
    	     if(id.compareTo("NuggetIron")       == 0) { return ShopKeeper.nuggetIron; }
        else if(id.compareTo("NuggetGold")       == 0) { return ShopKeeper.nuggetGold; }
        else if(id.compareTo("NuggetCopper")     == 0) { return ShopKeeper.nuggetCopper; }
        else if(id.compareTo("NuggetBauxite")    == 0) { return ShopKeeper.nuggetBauxite; }
        else if(id.compareTo("NuggetLead")       == 0) { return ShopKeeper.nuggetLead; }
        else if(id.compareTo("NuggetTin")        == 0) { return ShopKeeper.nuggetTin; }
        else if(id.compareTo("NuggetZinc")       == 0) { return ShopKeeper.nuggetZinc; }
        else if(id.compareTo("NuggetSilver")     == 0) { return ShopKeeper.nuggetSilver; }
        else if(id.compareTo("NuggetMythril")    == 0) { return ShopKeeper.nuggetMythril; }
        else if(id.compareTo("NuggetIridium")    == 0) { return ShopKeeper.nuggetIridium; }
        else if(id.compareTo("NuggetAdamantium") == 0) { return ShopKeeper.nuggetAdamantium; }
        else if(id.compareTo("NuggetUnobtanium") == 0) { return ShopKeeper.nuggetUnobtanium; }
    	return Items.FLINT;
    }
	
}
