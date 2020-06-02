package net.acecraft.mod.entity;

import net.acecraft.mod.ShopKeeper;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityNugget extends EntityThrowable {
	
	private int field_145791_d = -1;
    private int field_145792_e = -1;
    private int field_145789_f = -1;
    private Block field_145790_g;
    private int inData;
    private boolean inGround;
    public int canBePickedUp;
    public int arrowShake;
    public Entity shootingEntity;
    private int ticksInGround;
    private int ticksInAir;
    private double damage = 2.0D;
    private int knockbackStrength;
	public String id = "empty";
    
	private static final String __OBFID = "CL_00001722";
	
    public EntityNugget(World world){
        super(world);
    }
    
    public EntityNugget(World world, EntityLivingBase entity, String unlocalizedName){
        super(world, entity);
        if (entity instanceof EntityPlayer){
            this.canBePickedUp = 1;
        }
        id = unlocalizedName;
    }
    
    public EntityNugget(World world, double dX, double dY, double dZ){
        super(world, dX, dY, dZ);
    }
    
    public EntityNugget(World world, EntityPlayer player, String substring) {
    	super(world, player);
    	this.canBePickedUp = 1;
    	id = substring;
	}
    
    protected void onImpact(MovingObjectPosition position){
        if (position.entityHit != null){
            byte b0 = 1;
            if (position.entityHit instanceof EntityGhast){
                b0 = 3;
            }
            position.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)b0);
        }
        for (int i = 0; i < 8; ++i){
            this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }
        if (!this.worldObj.isRemote){
            this.motionX = 0;
            this.motionY = 0;
            this.motionZ = 0;
            this.inGround = true;
        }
    }
    
    public void onCollideWithPlayer(EntityPlayer player){
        if (!this.worldObj.isRemote && this.inGround){
            boolean flag = this.canBePickedUp == 1 || this.canBePickedUp == 2 && player.capabilities.isCreativeMode;
            ItemStack stack;
                 if(id.compareTo("NuggetIron")       == 0) { stack = new ItemStack(ShopKeeper.nuggetIron,       1); }
            else if(id.compareTo("NuggetGold")       == 0) { stack = new ItemStack(ShopKeeper.nuggetGold,       1); }
            else if(id.compareTo("NuggetCopper")     == 0) { stack = new ItemStack(ShopKeeper.nuggetCopper,     1); }
            else if(id.compareTo("NuggetBauxite")    == 0) { stack = new ItemStack(ShopKeeper.nuggetBauxite,    1); }
            else if(id.compareTo("NuggetLead")       == 0) { stack = new ItemStack(ShopKeeper.nuggetLead,       1); }
            else if(id.compareTo("NuggetTin")        == 0) { stack = new ItemStack(ShopKeeper.nuggetTin,        1); }
            else if(id.compareTo("NuggetZinc")       == 0) { stack = new ItemStack(ShopKeeper.nuggetZinc,       1); }
            else if(id.compareTo("NuggetSilver")     == 0) { stack = new ItemStack(ShopKeeper.nuggetSilver,     1); }
            else if(id.compareTo("NuggetMythril")    == 0) { stack = new ItemStack(ShopKeeper.nuggetMythril,    1); }
            else if(id.compareTo("NuggetIridium")    == 0) { stack = new ItemStack(ShopKeeper.nuggetIridium,    1); }
            else if(id.compareTo("NuggetAdamantium") == 0) { stack = new ItemStack(ShopKeeper.nuggetAdamantium, 1); }
            else if(id.compareTo("NuggetOrichalcum") == 0) { stack = new ItemStack(ShopKeeper.nuggetOrichalcum, 1); }
            else if(id.compareTo("NuggetUnobtanium") == 0) { stack = new ItemStack(ShopKeeper.nuggetUnobtanium, 1); }
            else{ stack = new ItemStack(Items.flint, 1); }
            if (this.canBePickedUp == 1 && !player.inventory.addItemStackToInventory(stack)){
                flag = false;
            }
            if (flag){
                this.playSound("random.pop", 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
                player.onItemPickup(this, 1);
                this.setDead();
            }
        }
    }
    
    protected boolean canTriggerWalking(){
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public float getShadowSize(){
        return 0.0F;
    }
    
    public boolean canAttackWithItem(){
        return true;
    }

}