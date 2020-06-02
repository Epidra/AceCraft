package net.acecraft.mod.slot;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.MathHelper;

public class SlotBoiler extends Slot {
	
    private EntityPlayer thePlayer;
    private int field;

    public SlotBoiler(EntityPlayer player, IInventory inventory, int x, int y, int z){
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

}