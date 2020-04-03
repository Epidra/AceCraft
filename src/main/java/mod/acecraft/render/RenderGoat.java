package mod.acecraft.render;

import mod.acecraft.AceCraft;
import mod.acecraft.entity.EntityGoat;
import mod.acecraft.model.ModelGoat;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderGoat extends MobRenderer<EntityGoat, ModelGoat<EntityGoat>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(AceCraft.MODID, "textures/entity/goat.png");

    public RenderGoat(EntityRendererManager renderManager) {
        super(renderManager, new ModelGoat<>(), 0.5F);
    }

    protected ResourceLocation getEntityTexture(EntityGoat entityGoat) {
        return TEXTURE;
    }
}
