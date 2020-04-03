package mod.acecraft.render;

import mod.acecraft.AceCraft;
import mod.acecraft.entity.EntityLlama;
import mod.acecraft.model.ModelLlama;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderLlama extends MobRenderer<EntityLlama, ModelLlama<EntityLlama>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(AceCraft.MODID, "textures/entity/llama.png");

    public RenderLlama(EntityRendererManager renderManager) {
        super(renderManager, new ModelLlama<>(), 0.5F);
    }

    protected ResourceLocation getEntityTexture(EntityLlama entityLlama) {
        return TEXTURE;
    }
}
