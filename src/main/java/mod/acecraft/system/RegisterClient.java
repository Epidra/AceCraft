package mod.acecraft.system;

import mod.acecraft.Register;
import mod.acecraft.common.entity.model.ModelAlpaca;
import mod.acecraft.common.entity.model.ModelAlpacaWool;
import mod.acecraft.common.entity.render.RenderAlpaca;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static mod.acecraft.AceCraft.MODID;

@Mod.EventBusSubscriber(modid = MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RegisterClient {
	
	public static ModelLayerLocation ALPACA_MODEL = new ModelLayerLocation(new ResourceLocation(MODID, "alpaca" ), "alpaca_model" );
	public static ModelLayerLocation ALPACA_LAYER = new ModelLayerLocation(new ResourceLocation(MODID, "alpaca" ), "alpaca_layer" );
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SUBSCRIBER  ---------- ---------- ---------- ---------- //
	
	@SubscribeEvent
	public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(Register.ENTITY_ALPACA.get(  ), RenderAlpaca::new);
		event.registerEntityRenderer(Register.ENTITY_DYNAMITE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(Register.ENTITY_SPIT.get(    ), ThrownItemRenderer::new);
	}
	
	@SubscribeEvent
	public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ALPACA_MODEL, ModelAlpaca::createBodyLayer);
		event.registerLayerDefinition(ALPACA_LAYER, ModelAlpacaWool::createBodyLayer);
	}
	
	
	
}