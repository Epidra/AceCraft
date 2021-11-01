package mod.acecraft.render;

import mod.acecraft.AceCraft;
import mod.acecraft.entity.EntityAlpaca;
import mod.acecraft.model.ModelAlpaca;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderAlpaca extends MobRenderer<EntityAlpaca, ModelAlpaca<EntityAlpaca>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(AceCraft.MODID, "textures/entity/alpaca.png");





    //----------------------------------------CONSTRUCTOR----------------------------------------//

    public RenderAlpaca(EntityRendererManager renderManager) {
        super(renderManager, new ModelAlpaca<>(), 0.5F);
        this.addLayer(new RenderAlpacaLayer(this));
    }





    //----------------------------------------SUPPORT----------------------------------------//

    @Override
    public ResourceLocation getTextureLocation(EntityAlpaca p_110775_1_) {
        return TEXTURE;
    }



}
