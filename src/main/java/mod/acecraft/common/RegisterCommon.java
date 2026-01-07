package mod.acecraft.common;

import mod.acecraft.AceCraft;
import mod.acecraft.Register;
import mod.acecraft.common.entity.EntityAlpaca;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

@EventBusSubscriber(modid = AceCraft.MODID, bus = EventBusSubscriber.Bus.MOD)
public class RegisterCommon {

	
	
	@SubscribeEvent
	public static void entityAttributes(EntityAttributeCreationEvent event){
		event.put(Register.ENTITY_ALPACA.get(), EntityAlpaca.createAttributes().build());
	}
	
	@SubscribeEvent
	public static void registerSpawnPlacements(RegisterSpawnPlacementsEvent event){
		event.register(Register.ENTITY_ALPACA.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, EntityAlpaca::checkAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.AND);
	}

}
