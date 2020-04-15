package mod.acecraft.render;

import com.mojang.blaze3d.platform.GlStateManager;
import mod.acecraft.entity.EntityDynamite;
import mod.acecraft.entity.EntityNugget;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderNugget extends SpriteRenderer<EntityNugget> {

    public RenderNugget(EntityRendererManager renderManager) {
        super(renderManager, Minecraft.getInstance().getItemRenderer(), 1.0F);
    }
}
