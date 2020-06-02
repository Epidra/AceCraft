package net.acecraft.mod.proxy;

import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.render.RenderAxle;
import net.acecraft.mod.render.RenderFruitPress;
import net.acecraft.mod.render.RenderMillstone;
import net.acecraft.mod.render.RenderWaterwheel;
import net.acecraft.mod.render.RenderWindmill;
import net.acecraft.mod.tileentity.TileEntityAxle;
import net.acecraft.mod.tileentity.TileEntityFruitPress;
import net.acecraft.mod.tileentity.TileEntityMillstone;
import net.acecraft.mod.tileentity.TileEntityWaterwheel;
import net.acecraft.mod.tileentity.TileEntityWindmill;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void PreInit(FMLPreInitializationEvent preEvent){
		ShopKeeper.init();
		ShopKeeper.registerStuff(true);
		ShopKeeper.registerRecipes();
		ShopKeeper.registerSmelting();
		ShopKeeper.registerRender();
		ShopKeeper.registerSounds();
	}
	
	@Override
	public void Init(FMLInitializationEvent event){
		ShopKeeper.registerStuff(false);
		ShopKeeper.registerEntities();
	}
	
	//@Override
	//public void PostInit(FMLPostInitializationEvent postEvent){
		
	//}
	
	public void registerRenderThings(){
		
	}
	
	public void registerTileEntitySpecialRenderer(){
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWindmill  .class, new RenderWindmill()  ); //Windmill
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWaterwheel.class, new RenderWaterwheel()); //Waterwheel
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAxle      .class, new RenderAxle()      ); //Axle
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFruitPress.class, new RenderFruitPress()); //FruitPress
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMillstone .class, new RenderMillstone() ); //Millstone

	}
	
}
