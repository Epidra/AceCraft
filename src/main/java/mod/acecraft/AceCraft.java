package mod.acecraft;

import mod.acecraft.system.CommonProxy;
import mod.acecraft.system.GuiHandler;
import mod.acecraft.worldgen.WorldGen;
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
	
	@SidedProxy(clientSide = "mod.acecraft.system.ClientProxy", serverSide = "mod.acecraft.system.CommonProxy")
	public static CommonProxy aceProxy;
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent preEvent){
		aceProxy.PreInit(preEvent);
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event){
		aceProxy.Init(event);
		GameRegistry.registerWorldGenerator(new WorldGen(), 0);
		MinecraftForge.EVENT_BUS.register(new ForgeHook());
		NetworkRegistry.INSTANCE.registerGuiHandler(AceCraft.instance, new GuiHandler());
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent postEvent){
		aceProxy.PostInit(postEvent);
	}
	
}
