package net.acecraft.mod.proxy;

import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.entity.EntityDynamite;
import net.acecraft.mod.entity.EntityNugget;
import net.acecraft.mod.entity.EntitySpear;
import net.acecraft.mod.render.RenderDynamite;
import net.acecraft.mod.render.RenderNugget;
import net.acecraft.mod.render.RenderSpear;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends  CommonProxy {
	
	public static void register(){
		
	}
	
	
	public void PreInit(FMLPreInitializationEvent preEvent){
		//RenderingRegistry.registerEntityRenderingHandler(EntitySpear.class, new IRenderFactory<Entity>(){@Override public Render<? super Entity> createRenderFor(RenderManager manager){ return new RenderSpear(manager); }});
		//RenderingRegistry.registerEntityRenderingHandler(EntityNugget.class, new IRenderFactory<Entity>(){@Override public Render<? super Entity> createRenderFor(RenderManager manager){ return new RenderNugget(manager, ShopKeeper.nuggetAdamantium, manager); }});
	}
	
	public void registerRenderThings(){
		RenderingRegistry.registerEntityRenderingHandler(EntityDynamite.class, new RenderDynamite(Minecraft.getMinecraft().getRenderManager(), ShopKeeper.explosiveDynamite, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntityNugget.class, new RenderNugget(Minecraft.getMinecraft().getRenderManager(), ShopKeeper.nuggetAdamantium, Minecraft.getMinecraft().getRenderItem()));
		
	}
	
	public void registerTileEntitySpecialRenderer(){
		
	}
}
