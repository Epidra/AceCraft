package mod.acecraft;

import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ForgeHook {
	
	@SubscribeEvent
	public void spawnEntity(EntityJoinWorldEvent event){
		if(event.getEntity() instanceof EntityCreeper){
			event.setCanceled(true);
		}
	}
	
	@SubscribeEvent
	public void dropEntity(LivingDropsEvent event){
		//if(event.getEntity() instanceof EntitySquid){
			//event.getDrops().add(new EntityItem(event.getEntity().worldObj, event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ, new ItemStack(ShopKeeper.foodFishSquid, 1)));
		//}
	}
	
	@SubscribeEvent
	public void dropBlock(HarvestDropsEvent event){
		if(event.getState().getBlock() == Blocks.IRON_ORE){
			event.getDrops().clear();
			event.getDrops().add(new ItemStack(ShopKeeper.NUGGET_IRON));
		}
		if(event.getState().getBlock() == Blocks.GOLD_ORE){
			event.getDrops().clear();
			event.getDrops().add(new ItemStack(ShopKeeper.NUGGET_GOLD));
		}
	}
	
}
