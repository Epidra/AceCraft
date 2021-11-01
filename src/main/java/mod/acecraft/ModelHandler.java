package mod.acecraft;

import mod.acecraft.model.ModelAlpaca;
import mod.acecraft.model.ModelAlpacaWool;
import mod.acecraft.render.RenderAlpaca;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "acecraft", value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModelHandler {

    public static ModelLayerLocation ALPACA_MODEL = new ModelLayerLocation(new ResourceLocation("acecraft", "alpaca"), "alpaca_model");
    public static ModelLayerLocation ALPACA_LAYER = new ModelLayerLocation(new ResourceLocation("acecraft", "alpaca"), "alpaca_layer");





    //----------------------------------------REGISTER----------------------------------------//

    @SubscribeEvent
    public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ShopKeeper.ENTITY_ALPACA.get(), RenderAlpaca::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ALPACA_MODEL, ModelAlpaca::createBodyLayer);
        event.registerLayerDefinition(ALPACA_LAYER, ModelAlpacaWool::createBodyLayer);
    }



}
