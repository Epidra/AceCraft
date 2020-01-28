package mod.acecraft.system;

import mod.acecraft.ShopKeeper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	
	public void PreInit(FMLPreInitializationEvent preEvent){
		ShopKeeper.init();
		ShopKeeper.registerStuff(true);
		ShopKeeper.registerRecipes();
	}
	
	public void Init(FMLInitializationEvent event){
		ShopKeeper.registerEntities();
	}
	
	public void PostInit(FMLPostInitializationEvent postEvent){
		
	}
	
}
