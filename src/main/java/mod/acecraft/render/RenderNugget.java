package mod.acecraft.render;

import mod.acecraft.entity.EntityNugget;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderNugget extends SpriteRenderer<EntityNugget> {

    public RenderNugget(EntityRendererManager renderManager) {
        super(renderManager, Minecraft.getInstance().getItemRenderer());
    }
}
