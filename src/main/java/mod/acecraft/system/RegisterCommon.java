package mod.acecraft.system;

import mod.acecraft.Register;
import mod.acecraft.common.entity.EntityAlpaca;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static mod.acecraft.AceCraft.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegisterCommon {
	
	// ...
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SUBSCRIBER  ---------- ---------- ---------- ---------- //
	
	@SubscribeEvent
	public void onServerAboutToStartEvent(ServerAboutToStartEvent event) {
		Register.registerJigsaws(event.getServer());
	}
	
	@SubscribeEvent
	public static void entityAttributes(EntityAttributeCreationEvent event){
		event.put(Register.ENTITY_ALPACA.get( ), EntityAlpaca.createAttributes( ).build());
	}

	@SubscribeEvent
	public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event){
		event.register(Register.ENTITY_ALPACA.get( ), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, EntityAlpaca::canAlpacaSpawn,   SpawnPlacementRegisterEvent.Operation.OR);
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SUPPORT  ---------- ---------- ---------- ---------- //
	
	// ...
	
	
	
}
