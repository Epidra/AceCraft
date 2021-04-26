package mod.acecraft.render;

import mod.acecraft.AceCraft;
import mod.acecraft.entity.EntitySpear;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderSpear extends EntityRenderer<EntitySpear> {

    public static final ResourceLocation TRIDENT = new ResourceLocation(AceCraft.MODID, "textures/entity/spear_gold.png");




    //----------------------------------------CONSTRUCTOR----------------------------------------//

    public RenderSpear(EntityRendererManager renderManagerIn) {
        super(renderManagerIn);
    }




    //----------------------------------------SUPPORT----------------------------------------//

    @Override
    public ResourceLocation getTextureLocation(EntitySpear p_110775_1_) {
        return TRIDENT;
    }

}
