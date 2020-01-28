package mod.acecraft;

import mod.acecraft.tileentities.TileBlastFurnace;
import mod.acecraft.worldgen.WorldGen;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Paths;
import java.util.function.Supplier;
import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("acecraft")
public class AceCraft {

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    // The Mod ID
    public static final String MODID = "acecraft";
    // Client/Server Proxy
    //public static ServerProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);

    public AceCraft() {
       // Register the setup method for modloading
       FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
       // Register the enqueueIMC method for modloading
       FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
       // Register the processIMC method for modloading
       FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
       // Register the doClientStuff method for modloading
       FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

       // Register ourselves for server and other game events we are interested in
       MinecraftForge.EVENT_BUS.register(this);

    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());

        WorldGen.GenerateOre();
        WorldGen.GenerateNetherOre();

        //ShopKeeper.loadConfig(Paths.get("config", MODID + ".toml"));

        //DistExecutor.runWhenOn(Dist.CLIENT, () -> ChestContainerType::registerScreenFactories);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
        ShopKeeper.registerGUI();
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo(MODID, "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event) {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            ShopKeeper.registerBlocks();
        }
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
            ShopKeeper.registerItems();
        }

       // @SubscribeEvent
//
       // public static void registerContainers(RegistryEvent.Register<ContainerType<?>> event) {
//
       //     IForgeRegistry<ContainerType<?>> registry = event.getRegistry();
//
       //     ShopKeeper.registerContainer(registry);
//
       // }

        //@SubscribeEvent

       // public static void registerTiles(RegistryEvent.Register<TileEntityType<?>> event) {
//
       //     IForgeRegistry<TileEntityType<?>> registry = event.getRegistry();
//
       //     ShopKeeper.TYPE_BLASTFURNACE_TILE = TileEntityType.Builder.create((Supplier<TileEntity>) TileBlastFurnace::new,
       //             ShopKeeper.MACHINA_BLASTFURNACE
       //     ).build(null);
       //     ShopKeeper.TYPE_BLASTFURNACE_TILE.setRegistryName(MODID, "summoningpedestal");
       //     event.getRegistry().register(ShopKeeper.TYPE_BLASTFURNACE_TILE);
//
//
       //     //registry.register(TileEntityType.Builder.create(TileBlastFurnace::new, ShopKeeper.MACHINA_BLASTFURNACE).build(null).setRegistryName(MODID, "blastfurnace"));
//
       // }
    }
}
