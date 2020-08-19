package mod.acecraft.render;

import mod.acecraft.AceCraft;
import mod.acecraft.entity.EntityCrab;
import mod.acecraft.model.ModelCrab;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderCrab extends MobRenderer<EntityCrab, ModelCrab<EntityCrab>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(AceCraft.MODID, "textures/entity/crab.png");

    public RenderCrab(EntityRendererManager renderManager) {
        super(renderManager, new ModelCrab<>(), 0.5F);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityCrab entity) {
        return null;
    }

    // protected ResourceLocation getEntityTexture(EntityCrab entity) {
   //     return TEXTURE;
   // }
}
