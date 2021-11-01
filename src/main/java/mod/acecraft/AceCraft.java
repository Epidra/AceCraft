package mod.acecraft;

import mod.acecraft.system.AceCraftPacketHandler;
import mod.acecraft.system.ClientProxy;
import mod.acecraft.system.CommonProxy;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.village.VillagerTradesEvent;
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
        ShopKeeper.register();
        MinecraftForge.EVENT_BUS.addListener(this::villagerTrades);
    }





    //----------------------------------------SETUP----------------------------------------//

    private void setupCommon(final FMLCommonSetupEvent event) {
        ShopKeeper.registerOreSpawn();
        AceCraftPacketHandler.register();
        ShopKeeper.setup(event);
    }

    private void setupClient(final FMLClientSetupEvent event) {
        ShopKeeper.setup(event);
    }





    //----------------------------------------LISTENER----------------------------------------//

    private void villagerTrades(VillagerTradesEvent event) {
        if(event.getType() == VillagerProfession.BUTCHER) {
            event.getTrades().get(4).add(AceCraft.buildTrade(new ItemStack(Items.EMERALD, 99), new ItemStack(Items.COOKED_MUTTON, 5), 16, 25, 0.05F));
            event.getTrades().get(4).add(AceCraft.buildTrade(new ItemStack(Items.EMERALD, 99), new ItemStack(Items.COOKED_BEEF,   6), 16, 25, 0.05F));
        } else if(event.getType() == VillagerProfession.CARTOGRAPHER) {
            event.getTrades().get(5).add(AceCraft.buildTrade(new ItemStack(Items.EMERALD, 99), new ItemStack(Items.CREEPER_BANNER_PATTERN, 1), 12, 30, 0.05F));
            event.getTrades().get(5).add(AceCraft.buildTrade(new ItemStack(Items.EMERALD, 99), new ItemStack(Items.FLOWER_BANNER_PATTERN,  1), 12, 30, 0.05F));
            event.getTrades().get(5).add(AceCraft.buildTrade(new ItemStack(Items.EMERALD, 99), new ItemStack(Items.SKULL_BANNER_PATTERN,   1), 12, 30, 0.05F));
        } else if(event.getType() == VillagerProfession.CLERIC) {
            event.getTrades().get(3).add(AceCraft.buildTrade(new ItemStack(Items.EMERALD, 1), new ItemStack(Items.RABBIT_FOOT, 1), 5, 5, 0.05F));
        } else if(event.getType() == VillagerProfession.FARMER) {
            event.getTrades().get(1).add(AceCraft.buildTrade(new ItemStack(Items.EMERALD,    99), new ItemStack(Items.WHEAT,      5), 16, 1, 0.05F));
            event.getTrades().get(1).add(AceCraft.buildTrade(new ItemStack(Items.EMERALD,    99), new ItemStack(Items.POTATO,     6), 16, 1, 0.05F));
            event.getTrades().get(1).add(AceCraft.buildTrade(new ItemStack(Items.EMERALD,    99), new ItemStack(Items.CARROT,     5), 16, 1, 0.05F));
            event.getTrades().get(1).add(AceCraft.buildTrade(new ItemStack(Items.EMERALD,    99), new ItemStack(Items.SUGAR_CANE, 6), 16, 1, 0.05F));
            event.getTrades().get(1).add(AceCraft.buildTrade(new ItemStack(Items.SUGAR_CANE, 28), new ItemStack(Items.EMERALD,    1), 16, 2, 0.05F));
            event.getTrades().get(2).add(AceCraft.buildTrade(new ItemStack(Items.EMERALD,     1), new ItemStack(Items.EGG,        4), 16, 5, 0.05F));
            event.getTrades().get(2).add(AceCraft.buildTrade(new ItemStack(Items.EGG,        16), new ItemStack(Items.EMERALD,    1), 16, 10, 0.05F));
        } else if(event.getType() == VillagerProfession.FISHERMAN) {
            event.getTrades().get(5).add(AceCraft.buildTrade(new ItemStack(Items.EMERALD, 99), new ItemStack(Items.PUFFERFISH, 1), 5, 0, 0.05F));
        } else if(event.getType() == VillagerProfession.LEATHERWORKER) {
            event.getTrades().get(3).add(AceCraft.buildTrade(new ItemStack(Items.EMERALD, 99), new ItemStack(Items.LEATHER, 3), 16, 10, 0.05F));
        } else if(event.getType() == VillagerProfession.MASON) {
            event.getTrades().get(3).add(AceCraft.buildTrade(new ItemStack(Items.EMERALD,     99), new ItemStack(Items.COBBLESTONE, 8), 16, 10, 0.05F));
            event.getTrades().get(3).add(AceCraft.buildTrade(new ItemStack(Items.COBBLESTONE, 32), new ItemStack(Items.EMERALD,     1), 16, 20, 0.05F));
        } else if(event.getType() == VillagerProfession.SHEPHERD) {
            event.getTrades().get(1).add(AceCraft.buildTrade(new ItemStack(Items.EMERALD, 99), new ItemStack(Items.STRING, 3), 5, 1, 0.05F));
        }
    }

    public static VillagerTrades.ITrade buildTrade(ItemStack wanted1, ItemStack given, int tradesUntilDisabled, int xpToVillagr, float priceMultiplier) {
        return AceCraft.buildTrade(wanted1, ItemStack.EMPTY, given, tradesUntilDisabled, xpToVillagr, priceMultiplier);
    }

    public static VillagerTrades.ITrade buildTrade(ItemStack wanted1, ItemStack wanted2, ItemStack given, int tradesUntilDisabled, int xpToVillagr, float priceMultiplier) {
        return (entity, random) -> new MerchantOffer(wanted1, wanted2, given, tradesUntilDisabled, xpToVillagr, priceMultiplier);
    }



}
