package mod.acecraft;

import mod.acecraft.system.PacketHandler;
import mod.acecraft.system.ClientProxy;
import mod.acecraft.system.CommonProxy;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("acecraft")
public class AceCraft {

    public static final String MODID = "acecraft";
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    // Client/Server Proxy
    public static CommonProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);

    public AceCraft() {
        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::setupCommon);
        eventBus.addListener(this::enqueueIMC);
        eventBus.addListener(this::processIMC);
        eventBus.addListener(this::setupClient);
        eventBus.addListener(this::villagerTrades);
        eventBus.addListener(this::wandererTrades);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.spec);
        MinecraftForge.EVENT_BUS.register(this);
        ShopKeeper.register();
    }

    private void setupCommon(final FMLCommonSetupEvent event) {
        PacketHandler.register();
        ShopKeeper.setup(event);
        //DeferredWorkQueue.runLater(ShopKeeper::addSpawn);
        //ShopKeeper.addTrades();
    }

    private void setupClient(final FMLClientSetupEvent event) {
        ShopKeeper.setup(event);
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {

    }

    private void processIMC(final InterModProcessEvent event) {
        // PostInit
        //registerBlockColor here
    }

    @SubscribeEvent
    public void villagerTrades(VillagerTradesEvent event){
        if(event.getType() == VillagerProfession.FARMER){
            event.getTrades().get(1).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(ShopKeeper.FOOD_RICEBALL.get(), 16), 8, 10, 0F));
            event.getTrades().get(1).add((entity, random) -> new MerchantOffer(new ItemStack(Items.EMERALD, 1), new ItemStack(ShopKeeper.ITEM_CURRY.get(),    16), 8, 10, 0F));
            //RandomTradeBuilder.forEachLevel((level, tradeBuild) -> event.getTrades().get(level.intValue()).add(tradeBuild.build()));
        }
    }

    //@SubscribeEvent
    public void wandererTrades(WandererTradesEvent event){
        //List<ITrade> genericList = event.getGenericTrades();
        //RandomTradeBuilder.forEachWanderer((tradeBuild) -> genericList.add(tradeBuild.build()));
        //List<ITrade> rareList = event.getRareTrades();
        //RandomTradeBuilder.forEachWandererRare((tradeBuild) -> rareList.add(tradeBuild.build()));
    }


    /**
     * Check out how vanilla does it in GrassColors, FoliageColors, and BiomeColors. Then use BlockColors#register in the client setup event ColorHandlerEvent﻿﻿.Block* to replace the vanilla block colors.
     */


}
