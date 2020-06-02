package net.acecraft.mod;

import net.acecraft.mod.handler.AceGUIHandler;
import net.acecraft.mod.proxy.CommonProxy;
import net.acecraft.mod.worldgen.AceCraftWorldGen;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = AceCraft.modid, version = AceCraft.version, name = AceCraft.modName, dependencies = AceCraft.dependencies)
public class AceCraft {
	
	public static final String modid        = "acecraft";
	public static final String version      = "v01";
	public static final String modName      = "AceCraft";
	public static final String dependencies = "";
	
	@Instance(modid)
	public static AceCraft instance;
	
	@SidedProxy(clientSide = "net.acecraft.mod.proxy.ClientProxy", serverSide = "net.acecraft.mod.proxy.CommonProxy")
	public static CommonProxy aceProxy;
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent preEvent){
		aceProxy.PreInit(preEvent);
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event){
		aceProxy.Init(event);
		GameRegistry.registerWorldGenerator(new AceCraftWorldGen(), 0);
		MinecraftForge.EVENT_BUS.register(new ForgeHook());
		NetworkRegistry.INSTANCE.registerGuiHandler(AceCraft.instance, new AceGUIHandler());
		aceProxy.registerRenderThings();
		aceProxy.registerTileEntitySpecialRenderer();
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent postEvent){
		aceProxy.PostInit(postEvent);
	}
	
}
