package mod.acecraft.system;

import mod.acecraft.ShopKeeper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void PreInit(FMLPreInitializationEvent preEvent){
		ShopKeeper.init();
		ShopKeeper.registerStuff(true);
		ShopKeeper.registerRecipes();
		ShopKeeper.registerRenders();
		ShopKeeper.registerSounds();
	}
	
	@Override
	public void Init(FMLInitializationEvent event){
		ShopKeeper.registerStuff(false);
		ShopKeeper.registerEntities();
	}
	
	@Override
	public void PostInit(FMLPostInitializationEvent postEvent){
		
	}
	
}
