package mod.acecraft.render;

import mod.acecraft.entity.EntityDynamite;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderDynamite extends SpriteRenderer<EntityDynamite> {

    public RenderDynamite(EntityRendererManager renderManager) {
        super(renderManager, Minecraft.getInstance().getItemRenderer());
    }
}
