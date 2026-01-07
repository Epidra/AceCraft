package mod.acecraft.client;

import mod.acecraft.AceCraft;
import mod.acecraft.Register;
import mod.acecraft.common.entity.model.ModelAlpaca;
import mod.acecraft.common.entity.model.ModelAlpacaWool;
import mod.acecraft.common.entity.render.RenderAlpaca;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = AceCraft.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RegisterClient {
	
	public static ModelLayerLocation ALPACA_MODEL = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(AceCraft.MODID, "alpaca"), "alpaca_model");
	public static ModelLayerLocation ALPACA_LAYER = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(AceCraft.MODID, "alpaca"), "alpaca_layer");
	
	@SubscribeEvent
	public static void registerEntityRender(EntityRenderersEvent.RegisterRenderers event){
		event.registerEntityRenderer(Register.ENTITY_ALPACA.get(), RenderAlpaca::new);
		event.registerEntityRenderer(Register.ENTITY_DYNAMITE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Register.ENTITY_SPIT.get(), ThrownItemRenderer::new);
	}
	
	@SubscribeEvent
	public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event){
		event.registerLayerDefinition(ALPACA_MODEL, ModelAlpaca::createBodyLayer);
		event.registerLayerDefinition(ALPACA_LAYER, ModelAlpacaWool::createFurLayer);
	}
	
}
