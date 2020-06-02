package net.acecraft.mod;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import net.acecraft.mod.handler.CraftingHandler;
import net.acecraft.mod.handler.GuiHandler;
import net.acecraft.mod.handler.TradeHandler;
import net.acecraft.mod.proxy.CommonProxy;
import net.acecraft.mod.worldgen.AceCraftWorldGen;

@Mod(modid = AceCraft.modid, version = AceCraft.version, name = AceCraft.modName, dependencies = AceCraft.dependencies)
public class AceCraft {
	
	public static final String modid = "AceCraft";
	public static final String version = "Mark II";
	public static final String modName = "AceCraft";
	public static final String dependencies = "";
	//public static final String dependencies = "load-after:BiomesOPlenty;load-after:millenaire";
	
	@Instance(modid)
	public static AceCraft instance;
	
	@SidedProxy(clientSide = "net.acecraft.mod.proxy.ClientProxy", serverSide = "net.acecraft.mod.proxy.CommonProxy")
	public static CommonProxy aceProxy;
	
	AceCraftWorldGen eventWorldGen = new AceCraftWorldGen();
	
	public static ShopKeeper Shopkeeper = new ShopKeeper();
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent preEvent){
		Shopkeeper.PreInit();
		GameRegistry.registerWorldGenerator(eventWorldGen, 0);
		aceProxy.registerRenderThings();
		for (int i = 0; i < 5; ++i) {
			VillagerRegistry.instance().registerVillageTradeHandler(i, new TradeHandler());
		}
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event){
		FMLCommonHandler.instance().bus().register(new CraftingHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		Shopkeeper.Init();
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent postEvent){
		Shopkeeper.PostInit();
	}

}