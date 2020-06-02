package net.acecraft.mod;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;

public class ForgeHook {
	
	public ForgeHook(){
		
	}
	
	@SubscribeEvent
	public void OreDrop(HarvestDropsEvent event) {
		if(event.block == Blocks.iron_ore) {
			event.drops.clear();
			event.drops.add(new ItemStack(ShopKeeper.nuggetIron, 1));
		}
		if(event.block == Blocks.gold_ore) {
			event.drops.clear();
			event.drops.add(new ItemStack(ShopKeeper.nuggetGold, 1));
		}
		if(event.block == Blocks.web) {
			event.drops.clear();
			event.drops.add(new ItemStack(Items.string, 1));
		}
		if(ShopKeeper.loadedBiomesOPlenty)
		if(new ItemStack(event.block).getItem() == new ItemStack(biomesoplenty.api.content.BOPCBlocks.plants, 1, 12).getItem()){
			event.drops.add(new ItemStack(ShopKeeper.foodCactusFruit));
		}
	}
	
	@SubscribeEvent
	public void EntityDrop(LivingDropsEvent event) {
		if(event.entity instanceof EntitySheep) {
			event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ, new ItemStack(ShopKeeper.foodMuttonRaw, 1)));
		}
		if(event.entity instanceof EntitySquid) {
			event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ, new ItemStack(ShopKeeper.foodCalamariRaw, 1)));
		}
	}
	
	@SubscribeEvent
	public void EntityDeath(LivingDeathEvent event){
		if(event.source.getEntity() instanceof EntityPlayer){
			if(((EntityPlayer) event.source.getEntity()).getCurrentArmor(0) != null){
				if(((EntityPlayer) event.source.getEntity()).getCurrentArmor(1) != null){
					if(((EntityPlayer) event.source.getEntity()).getCurrentArmor(2) != null){
						if(((EntityPlayer) event.source.getEntity()).getCurrentArmor(3) != null){
							if(((EntityPlayer) event.source.getEntity()).getHeldItem() != null){
								if(((EntityPlayer) event.source.getEntity()).getHeldItem().getItem() instanceof ItemSpade){
									((EntityPlayer) event.source.getEntity()).addStat(ShopKeeper.achievementShovelKnight, 1);
								}
							}
						}
					}
				}
			}
		}
	}
	
	@SubscribeEvent
	public void PlayerDeath(PlayerDropsEvent event){
		
	}
	
	@SubscribeEvent
    public void EntityInteractEvent(EntityInteractEvent event){
		if(event.entityPlayer.getCurrentEquippedItem() != null){
			if(validBucket(event.entityPlayer.getCurrentEquippedItem().getItem())){
				if(event.target instanceof EntityCow && !event.entity.worldObj.isRemote){
					event.entityPlayer.setCurrentItemOrArmor(0, changeBucket(event.entityPlayer.getCurrentEquippedItem().getItem()));
				}
			}
		}
    }
	
	private boolean validBucket(Item item){
		if(item == ShopKeeper.bucketWoodEmpty)       return true;
		if(item == ShopKeeper.bucketIronEmpty)       return true;
		if(item == ShopKeeper.bucketCopperEmpty)     return true;
		if(item == ShopKeeper.bucketAluminiumEmpty)  return true;
		if(item == ShopKeeper.bucketLeadEmpty)       return true;
		if(item == ShopKeeper.bucketBronzeEmpty)     return true;
		if(item == ShopKeeper.bucketSteelEmpty)      return true;
		if(item == ShopKeeper.bucketMythrilEmpty)    return true;
		if(item == ShopKeeper.bucketAdamantiumEmpty) return true;
		if(item == ShopKeeper.bucketUnobtaniumEmpty) return true;
		return false;
	}
	
	private ItemStack changeBucket(Item item){
		if(item == ShopKeeper.bucketWoodEmpty)       return new ItemStack(ShopKeeper.bucketWoodMilk);
		if(item == ShopKeeper.bucketIronEmpty)       return new ItemStack(ShopKeeper.bucketIronMilk);
		if(item == ShopKeeper.bucketCopperEmpty)     return new ItemStack(ShopKeeper.bucketCopperMilk);
		if(item == ShopKeeper.bucketAluminiumEmpty)  return new ItemStack(ShopKeeper.bucketAluminiumMilk);
		if(item == ShopKeeper.bucketLeadEmpty)       return new ItemStack(ShopKeeper.bucketLeadMilk);
		if(item == ShopKeeper.bucketBronzeEmpty)     return new ItemStack(ShopKeeper.bucketBronzeMilk);
		if(item == ShopKeeper.bucketSteelEmpty)      return new ItemStack(ShopKeeper.bucketSteelMilk);
		if(item == ShopKeeper.bucketMythrilEmpty)    return new ItemStack(ShopKeeper.bucketMythrilMilk);
		if(item == ShopKeeper.bucketAdamantiumEmpty) return new ItemStack(ShopKeeper.bucketAdamantiumMilk);
		if(item == ShopKeeper.bucketUnobtaniumEmpty) return new ItemStack(ShopKeeper.bucketUnobtaniumMilk);
		return null;
	}

}