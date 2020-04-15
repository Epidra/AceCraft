package mod.acecraft.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GLX;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import mod.acecraft.AceCraft;
import mod.acecraft.ShopKeeper;
import mod.acecraft.entity.EntitySpear;
import mod.acecraft.model.ModelSpear;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderSpear extends EntityRenderer<EntitySpear> {

    public static final ResourceLocation TRIDENT = new ResourceLocation(AceCraft.MODID, "textures/entity/spear_gold.png");
    private final ModelSpear tridentModel = new ModelSpear();

    public RenderSpear(EntityRendererManager renderManagerIn) {
        super(renderManagerIn);
    }

    public void render(EntitySpear entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        matrixStackIn.push();
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90.0F));
        matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch) + 90.0F));
        IVertexBuilder ivertexbuilder = net.minecraft.client.renderer.ItemRenderer.getBuffer(bufferIn, this.tridentModel.getRenderType(this.getEntityTexture(entityIn)), false, entityIn.func_226572_w_());
        this.tridentModel.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.DEFAULT_LIGHT, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStackIn.pop();
        super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
    }

    public ResourceLocation getEntityTexture(EntitySpear entity) {

        if(entity.getStack() == ShopKeeper.TOOL_SPEAR_BRASS     ) return new ResourceLocation(AceCraft.MODID, "textures/entity/spear_brass.png");
        if(entity.getStack() == ShopKeeper.TOOL_SPEAR_GILIUM    ) return new ResourceLocation(AceCraft.MODID, "textures/entity/spear_gilium.png");
        if(entity.getStack() == ShopKeeper.TOOL_SPEAR_ADAMANTIUM) return new ResourceLocation(AceCraft.MODID, "textures/entity/spear_adamantium.png");
        if(entity.getStack() == ShopKeeper.TOOL_SPEAR_MYTHRIL   ) return new ResourceLocation(AceCraft.MODID, "textures/entity/spear_mythril.png");
        if(entity.getStack() == ShopKeeper.TOOL_SPEAR_ORICHALCUM) return new ResourceLocation(AceCraft.MODID, "textures/entity/spear_orichalcum.png");
        if(entity.getStack() == ShopKeeper.TOOL_SPEAR_COPPER    ) return new ResourceLocation(AceCraft.MODID, "textures/entity/spear_copper.png");
        if(entity.getStack() == ShopKeeper.TOOL_SPEAR_BRONZE    ) return new ResourceLocation(AceCraft.MODID, "textures/entity/spear_bronze.png");
        if(entity.getStack() == ShopKeeper.TOOL_SPEAR_STEEL     ) return new ResourceLocation(AceCraft.MODID, "textures/entity/spear_steel.png");
        if(entity.getStack() == ShopKeeper.TOOL_SPEAR_AURORITE  ) return new ResourceLocation(AceCraft.MODID, "textures/entity/spear_aurorite/" + Math.round((float)((System.currentTimeMillis() >> 6) % 24L)) + ".png");
            return TRIDENT;
    }

    protected void func_203085_b(EntitySpear tridentEntityIn, double x, double y, double z, float entityYaw, float partialTicks) {
        Entity entity = tridentEntityIn.getShooter();
        if (entity != null && tridentEntityIn.getNoClip()) {
            Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder bufferbuilder = tessellator.getBuffer();
            double d0 = (double)(MathHelper.lerp(partialTicks * 0.5F, entity.rotationYaw, entity.prevRotationYaw) * ((float)Math.PI / 180F));
            double d1 = Math.cos(d0);
            double d2 = Math.sin(d0);
            double d3 = MathHelper.lerp((double)partialTicks, entity.prevPosX, entity.getPosX());
            double d4 = MathHelper.lerp((double)partialTicks, entity.prevPosY + (double)entity.getEyeHeight() * 0.8D, entity.getPosY() + (double)entity.getEyeHeight() * 0.8D);
            double d5 = MathHelper.lerp((double)partialTicks, entity.prevPosZ, entity.getPosZ());
            double d6 = d1 - d2;
            double d7 = d2 + d1;
            double d8 = MathHelper.lerp((double)partialTicks, tridentEntityIn.prevPosX, tridentEntityIn.getPosX());
            double d9 = MathHelper.lerp((double)partialTicks, tridentEntityIn.prevPosY, tridentEntityIn.getPosY());
            double d10 = MathHelper.lerp((double)partialTicks, tridentEntityIn.prevPosZ, tridentEntityIn.getPosZ());
            double d11 = (double)((float)(d3 - d8));
            double d12 = (double)((float)(d4 - d9));
            double d13 = (double)((float)(d5 - d10));
            double d14 = Math.sqrt(d11 * d11 + d12 * d12 + d13 * d13);
            int i = tridentEntityIn.getEntityId() + tridentEntityIn.ticksExisted;
            double d15 = (double)((float)i + partialTicks) * -0.1D;
            double d16 = Math.min(0.5D, d14 / 30.0D);
            GlStateManager.disableTexture();
            GlStateManager.disableLighting();
            GlStateManager.disableCull();
            //GLX.glMultiTexCoord2f(GLX.GL_TEXTURE1, 255.0F, 255.0F);
            bufferbuilder.begin(5, DefaultVertexFormats.POSITION_COLOR);
            int j = 37;
            int k = 7 - i % 7;
            double d17 = 0.1D;

            for(int l = 0; l <= 37; ++l) {
                double d18 = (double)l / 37.0D;
                float f = 1.0F - (float)((l + k) % 7) / 7.0F;
                double d19 = d18 * 2.0D - 1.0D;
                d19 = (1.0D - d19 * d19) * d16;
                double d20 = x + d11 * d18 + Math.sin(d18 * Math.PI * 8.0D + d15) * d6 * d19;
                double d21 = y + d12 * d18 + Math.cos(d18 * Math.PI * 8.0D + d15) * 0.02D + (0.1D + d19) * 1.0D;
                double d22 = z + d13 * d18 + Math.sin(d18 * Math.PI * 8.0D + d15) * d7 * d19;
                float f1 = 0.87F * f + 0.3F * (1.0F - f);
                float f2 = 0.91F * f + 0.6F * (1.0F - f);
                float f3 = 0.85F * f + 0.5F * (1.0F - f);
                bufferbuilder.pos(d20, d21, d22).color(f1, f2, f3, 1.0F).endVertex();
                bufferbuilder.pos(d20 + 0.1D * d19, d21 + 0.1D * d19, d22).color(f1, f2, f3, 1.0F).endVertex();
                if (l > tridentEntityIn.returningTicks * 2) {
                    break;
                }
            }

            tessellator.draw();
            bufferbuilder.begin(5, DefaultVertexFormats.POSITION_COLOR);

            for(int i1 = 0; i1 <= 37; ++i1) {
                double d23 = (double)i1 / 37.0D;
                float f4 = 1.0F - (float)((i1 + k) % 7) / 7.0F;
                double d24 = d23 * 2.0D - 1.0D;
                d24 = (1.0D - d24 * d24) * d16;
                double d25 = x + d11 * d23 + Math.sin(d23 * Math.PI * 8.0D + d15) * d6 * d24;
                double d26 = y + d12 * d23 + Math.cos(d23 * Math.PI * 8.0D + d15) * 0.01D + (0.1D + d24) * 1.0D;
                double d27 = z + d13 * d23 + Math.sin(d23 * Math.PI * 8.0D + d15) * d7 * d24;
                float f5 = 0.87F * f4 + 0.3F * (1.0F - f4);
                float f6 = 0.91F * f4 + 0.6F * (1.0F - f4);
                float f7 = 0.85F * f4 + 0.5F * (1.0F - f4);
                bufferbuilder.pos(d25, d26, d27).color(f5, f6, f7, 1.0F).endVertex();
                bufferbuilder.pos(d25 + 0.1D * d24, d26, d27 + 0.1D * d24).color(f5, f6, f7, 1.0F).endVertex();
                if (i1 > tridentEntityIn.returningTicks * 2) {
                    break;
                }
            }

            tessellator.draw();
            GlStateManager.enableLighting();
            GlStateManager.enableTexture();
            GlStateManager.enableCull();
        }
    }

}
