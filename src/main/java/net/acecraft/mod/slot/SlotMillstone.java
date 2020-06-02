package net.acecraft.mod.slot;

import net.acecraft.mod.crafting.BonfireRecipes;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.common.FMLCommonHandler;

public class SlotMillstone extends Slot {
	
    private EntityPlayer thePlayer;
    private int field;
    
    public SlotMillstone(EntityPlayer player, IInventory inventory, int x, int y, int z){
        super(inventory, x, y, z);
        this.thePlayer = player;
    }
    
    public boolean isItemValid(ItemStack stack){
        return false;
    }
    
    public ItemStack decrStackSize(int value){
        if (this.getHasStack()){
            this.field += Math.min(value, this.getStack().stackSize);
        }
        return super.decrStackSize(value);
    }
    
    public void onPickupFromSlot(EntityPlayer player, ItemStack stack){
        this.onCrafting(stack);
        super.onPickupFromSlot(player, stack);
    }
    
    protected void onCrafting(ItemStack stack, int value){
        this.field += value;
        this.onCrafting(stack);
    }
    
    protected void onCrafting(ItemStack stack){
        stack.onCrafting(this.thePlayer.worldObj, this.thePlayer, this.field);
        if (!this.thePlayer.worldObj.isRemote){
            int i = this.field;
            float f = BonfireRecipes.smelting().func_151398_b(stack);
            int j;
            if (f == 0.0F){
                i = 0;
            }else if (f < 1.0F){
                j = MathHelper.floor_float((float)i * f);
                if (j < MathHelper.ceiling_float_int((float)i * f) && (float)Math.random() < (float)i * f - (float)j){
                    ++j;
                }
                i = j;
            }
            while (i > 0){
                j = EntityXPOrb.getXPSplit(i);
                i -= j;
                this.thePlayer.worldObj.spawnEntityInWorld(new EntityXPOrb(this.thePlayer.worldObj, this.thePlayer.posX, this.thePlayer.posY + 0.5D, this.thePlayer.posZ + 0.5D, j));
            }
        }
        this.field = 0;
        FMLCommonHandler.instance().firePlayerSmeltedEvent(thePlayer, stack);
        if (stack.getItem() == Items.iron_ingot){
            this.thePlayer.addStat(AchievementList.acquireIron, 1);
        }
        if (stack.getItem() == Items.cooked_fished){
            this.thePlayer.addStat(AchievementList.cookFish, 1);
        }
    }

}