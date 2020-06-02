package net.acecraft.mod;

import net.acecraft.mod.crafting.AceCraftRecipeRemover;
import net.acecraft.mod.handler.AceCraftCraftingHandler;
import net.acecraft.mod.proxy.ClientProxy;
import net.acecraft.mod.proxy.CommonProxy;
import net.acecraft.mod.worldgen.AceCraftWorldGen;
import net.minecraft.init.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = AceCraft.modid, version = AceCraft.version, name = AceCraft.modName, dependencies = AceCraft.dependencies)
public class AceCraft {
	
	public static final String modid = "acecraft";
	public static final String version = "v01";
	public static final String modName = "AceCraft";
	public static final String dependencies = "";
	
	@Instance(modid)
	public static AceCraft instance;
	
	@SidedProxy(clientSide = "net.acecraft.mod.proxy.ClientProxy", serverSide = "net.acecraft.mod.proxy.CommonProxy")
	public static CommonProxy aceProxy;
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent preEvent){
		ShopKeeper.init();
		
		AceCraftRecipeRemover.removeCrafting(Items.book);
		ShopKeeper.registerStuff(true);
		ShopKeeper.registerRecipes();
		ShopKeeper.registerSmelting();
		
		aceProxy.PreInit(preEvent);
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event){
		ShopKeeper.registerStuff(false);
		GameRegistry.registerWorldGenerator(new AceCraftWorldGen(), 0);
		MinecraftForge.EVENT_BUS.register(new ForgeHook());
		MinecraftForge.EVENT_BUS.register(new AceCraftCraftingHandler());
		ShopKeeper.registerEntities();
		
		aceProxy.Init(event);
		aceProxy.registerRenderThings();
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent postEvent){
		aceProxy.PostInit(postEvent);
	}
	
}
