package net.acecraft.mod.proxy;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	
	public void PreInit(FMLPreInitializationEvent preEvent){
		ShopKeeper.init();
		ShopKeeper.registerStuff(true);
		ShopKeeper.registerRecipes();
		ShopKeeper.registerSmelting();
		//ShopKeeper.registerSounds();
	}
	
	public void Init(FMLInitializationEvent event){
		//ShopKeeper.registerStuff(false);
		ShopKeeper.registerEntities();
	}
	
	public void PostInit(FMLPostInitializationEvent postEvent){
		
	}
	
	public void registerRenderThings(){
		
	}
	
	public void registerTileEntitySpecialRenderer(){
		
	}
	
}
