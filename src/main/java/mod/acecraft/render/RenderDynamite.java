package mod.acecraft.render;

import mod.acecraft.entity.EntityDynamite;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderDynamite extends SpriteRenderer<EntityDynamite> {

    // ...





    //----------------------------------------CONSTRUCTOR----------------------------------------//

    public RenderDynamite(EntityRendererManager p_i226035_1_, ItemRenderer p_i226035_2_, float p_i226035_3_, boolean p_i226035_4_) {
        super(p_i226035_1_, p_i226035_2_, p_i226035_3_, p_i226035_4_);
    }



}
