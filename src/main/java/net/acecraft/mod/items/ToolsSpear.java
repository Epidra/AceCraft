package net.acecraft.mod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.entity.EntitySpear;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ToolsSpear extends ItemSword {
	
	ToolMaterial material;
	
	public ToolsSpear(ToolMaterial _material){
		super(_material);
		material = _material;
		this.maxStackSize = 1;
		this.setMaxDamage(64);
		this.setCreativeTab(ShopKeeper.acetabCommon);
	}
	
	@SideOnly(Side.CLIENT)
	public void  registerIcons(IIconRegister iconRegister){
		this.itemIcon = iconRegister.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5));
	}
	
	public void onCreated(ItemStack itemstack, World world, EntityPlayer player){
	    if(itemstack.getItem() == ShopKeeper.toolSpearIridium){
	    	itemstack.addEnchantment(Enchantment.fireAspect, 1);
	    }
	}
	
	public EnumAction getItemUseAction(ItemStack stack){
        return EnumAction.bow;
    }
	
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int value){
        int j = this.getMaxItemUseDuration(stack) - value;
        ArrowLooseEvent event = new ArrowLooseEvent(player, stack, j);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled()){
            return;
        }
        j = event.charge;
        boolean flag = player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack) > 0;
        {
            float f = (float)j / 20.0F;
            f = (f * f + f * 2.0F) / 3.0F;
            if ((double)f < 0.1D){
                return;
            }
            if (f > 1.0F){
                f = 1.0F;
            }
            EntitySpear spear = new EntitySpear(world, player, f * 2.0F, this.getUnlocalizedName().substring(5), material.getDamageVsEntity());
            if (f == 1.0F){
                spear.setIsCritical(true);
            }
            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, stack);
            if (k > 0){
                spear.setDamage(spear.getDamage() + (double)k * 0.5D + 0.5D);
            }
            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, stack);
            if (l > 0){
                spear.setKnockbackStrength(l);
            }
            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, stack) > 0){
                spear.setFire(100);
            }
            stack.damageItem(10000, player);
            world.playSoundAtEntity(player, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
            if (flag){
                spear.canBePickedUp = 2;
            }else{
            	if(!player.capabilities.isCreativeMode){
            		player.setCurrentItemOrArmor(0, null);
            	}
                //player.inventory.consumeInventoryItem(Items.arrow);
            }
            if (!world.isRemote){
                world.spawnEntityInWorld(spear);
            }
        }
    }
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
        ArrowNockEvent event = new ArrowNockEvent(player, stack);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled()){
            return event.result;
        }
        //if (player.capabilities.isCreativeMode){
            player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
        //}
        return stack;
    }
	
	/*public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player){
        if (!player.capabilities.isCreativeMode){
            --itemStack.stackSize;
        }
        world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        if (!world.isRemote){
            world.spawnEntityInWorld(new EntitySpear(world));
        }
        return itemStack;
    }*/

}