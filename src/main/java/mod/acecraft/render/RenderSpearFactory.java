package mod.acecraft.render;

import mod.acecraft.entity.EntitySpear;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderSpearFactory<T extends EntitySpear>
        extends Object
        implements IRenderFactory<T>
{
    public EntityRenderer<T> createRenderFor(EntityRendererManager manager) { return (EntityRenderer<T>) new RenderSpear(manager); }
}
