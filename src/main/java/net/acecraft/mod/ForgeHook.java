package net.acecraft.mod;

import java.util.Random;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ForgeHook {
	
	@SubscribeEvent
	public void dropEntity(LivingDropsEvent event){
		if(event.getEntity() instanceof EntitySquid){
			event.getDrops().add(new EntityItem(event.getEntity().worldObj, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, new ItemStack(ShopKeeper.foodCalamariRaw, 1)));
		}
		if(event.getEntity() instanceof EntityWolf){
			ItemStack itemstack = new ItemStack(ShopKeeper.stuffFur, 1);
			event.getDrops().add(new EntityItem(event.getEntity().worldObj, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, itemstack));
			Random rand = new Random();
			if(rand.nextInt(3) == 0){
				switch(rand.nextInt(7)){
				case 0: ItemStack stack0 = new ItemStack(Items.chicken, 1); event.getDrops().add(new EntityItem(event.getEntity().worldObj, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, stack0)); break;
				case 1: ItemStack stack1 = new ItemStack(Items.porkchop, 1); event.getDrops().add(new EntityItem(event.getEntity().worldObj, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, stack1)); break;
				case 2: ItemStack stack2 = new ItemStack(Items.beef, 1); event.getDrops().add(new EntityItem(event.getEntity().worldObj, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, stack2)); break;
				case 3: ItemStack stack3 = new ItemStack(Items.mutton, 1); event.getDrops().add(new EntityItem(event.getEntity().worldObj, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, stack3)); break;
				case 4: ItemStack stack4 = new ItemStack(Items.rabbit, 1); event.getDrops().add(new EntityItem(event.getEntity().worldObj, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, stack4)); break;
				case 5: ItemStack stack5 = new ItemStack(ShopKeeper.foodVenisonRaw, 1); event.getDrops().add(new EntityItem(event.getEntity().worldObj, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, stack5)); break;
				case 6: ItemStack stack6 = new ItemStack(ShopKeeper.foodVicugnaRaw, 1); event.getDrops().add(new EntityItem(event.getEntity().worldObj, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, stack6)); break;
				}
			}
		}
	}
	
	@SubscribeEvent
	public void dropBlock(HarvestDropsEvent event){
		if(event.getState().getBlock() == Blocks.iron_ore){
			event.getDrops().clear();
			event.getDrops().add(new ItemStack(ShopKeeper.nuggetIron));
		}
		if(event.getState().getBlock() == Blocks.gold_ore){
			event.getDrops().clear();
			event.getDrops().add(new ItemStack(ShopKeeper.nuggetGold));
		}
	}
	
}