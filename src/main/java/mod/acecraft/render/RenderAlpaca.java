package mod.acecraft.render;

import mod.acecraft.ModelHandler;
import mod.acecraft.entity.EntityAlpaca;
import mod.acecraft.model.ModelAlpaca;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.SheepRenderer;
import net.minecraft.client.renderer.entity.layers.SheepFurLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderAlpaca extends MobRenderer<EntityAlpaca, ModelAlpaca<EntityAlpaca>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation("acecraft", "textures/entity/alpaca.png");




    //----------------------------------------CONSTRUCTOR----------------------------------------//

    public RenderAlpaca(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelAlpaca<>(renderManager.bakeLayer(ModelHandler.ALPACA_MODEL)), 0.5F);
        this.addLayer(new RenderAlpacaLayer(this, renderManager.getModelSet()));
    }




    //----------------------------------------SUPPORT----------------------------------------//

    @Override
    public ResourceLocation getTextureLocation(EntityAlpaca p_110775_1_) {
        return TEXTURE;
    }

}
