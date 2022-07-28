package mod.acecraft;

import mod.acecraft.system.AceCraftPacketHandler;
import mod.acecraft.system.ClientProxy;
import mod.acecraft.system.CommonProxy;
import mod.lucky77.system.SystemStructures;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("acecraft")
public class AceCraft {

    // The Mod ID
    public static final String MODID = "acecraft";
    // Client/Server Proxy
    public static CommonProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);





    //----------------------------------------CONSTRUCTOR----------------------------------------//

    public AceCraft() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupCommon);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.spec);
        MinecraftForge.EVENT_BUS.register(this);
        ShopKeeper.register(FMLJavaModLoadingContext.get().getModEventBus());

        // For events that happen after initialization. This is probably going to be use a lot.
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        //forgeBus.addListener(EventPriority.NORMAL, this::addDimensionalSpacing);
        //forgeBus.addListener(EventPriority.NORMAL, StructureRuinedHouse::setupStructureSpawns);
    }





    //----------------------------------------SETUP----------------------------------------//

    private void setupCommon(final FMLCommonSetupEvent event) {
        ShopKeeper.registerOreSpawn();
        ShopKeeper.registerStructureConfigs();
        AceCraftPacketHandler.register();
        ShopKeeper.setup(event);
    }

    private void setupClient(final FMLClientSetupEvent event) {
        ShopKeeper.setup(event);
    }

    public void addDimensionalSpacing(final WorldEvent.Load event){
        //SystemStructures.addDimensionalSpacing(event,
        //        ShopKeeper.STRUCTURE_RUINED_HOUSE.get(),
        //        ShopKeeper.CONFIGURED_RUN_DOWN_HOUSE
        //);
    }



}
