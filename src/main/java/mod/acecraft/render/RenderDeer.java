package mod.acecraft.render;

import mod.acecraft.AceCraft;
import mod.acecraft.entity.EntityDeer;
import mod.acecraft.model.ModelDeer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderDeer extends MobRenderer<EntityDeer, ModelDeer<EntityDeer>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(AceCraft.MODID, "textures/entity/deer.png");

    public RenderDeer(EntityRendererManager renderManager) {
        super(renderManager, new ModelDeer<>(), 0.5F);
    }

    protected ResourceLocation getEntityTexture(EntityDeer entity) {
        return TEXTURE;
    }
}
