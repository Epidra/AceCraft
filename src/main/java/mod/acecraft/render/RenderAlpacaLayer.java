package mod.acecraft.render;

import com.mojang.blaze3d.matrix.MatrixStack;
import mod.acecraft.AceCraft;
import mod.acecraft.entity.EntityAlpaca;
import mod.acecraft.model.ModelAlpaca;
import mod.acecraft.model.ModelAlpacaWool;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderAlpacaLayer extends LayerRenderer<EntityAlpaca, ModelAlpaca<EntityAlpaca>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(AceCraft.MODID, "textures/entity/alpaca_fur.png");
    private final ModelAlpacaWool<EntityAlpaca> model = new ModelAlpacaWool<>();





    //----------------------------------------CONSTRUCTOR----------------------------------------//

    public RenderAlpacaLayer(IEntityRenderer<EntityAlpaca, ModelAlpaca<EntityAlpaca>> rendererIn) {
        super(rendererIn);
    }





    //----------------------------------------RENDER----------------------------------------//

    public void render(MatrixStack p_225628_1_, IRenderTypeBuffer p_225628_2_, int p_225628_3_, EntityAlpaca p_225628_4_, float p_225628_5_, float p_225628_6_, float p_225628_7_, float p_225628_8_, float p_225628_9_, float p_225628_10_) {
        if (!p_225628_4_.isSheared() && !p_225628_4_.isInvisible()) {
            float f;
            float f1;
            float f2;
            if (p_225628_4_.hasCustomName() && "jeb_".equals(p_225628_4_.getName().getContents())) {
                int i1 = 25;
                int i = p_225628_4_.tickCount / 25 + p_225628_4_.getId();
                int j = DyeColor.values().length;
                int k = i % j;
                int l = (i + 1) % j;
                float f3 = ((float)(p_225628_4_.tickCount % 25) + p_225628_7_) / 25.0F;
                float[] afloat1 = SheepEntity.getColorArray(DyeColor.byId(k));
                float[] afloat2 = SheepEntity.getColorArray(DyeColor.byId(l));
                f = afloat1[0] * (1.0F - f3) + afloat2[0] * f3;
                f1 = afloat1[1] * (1.0F - f3) + afloat2[1] * f3;
                f2 = afloat1[2] * (1.0F - f3) + afloat2[2] * f3;
            } else {
                float[] afloat = SheepEntity.getColorArray(p_225628_4_.getColor());
                f = afloat[0];
                f1 = afloat[1];
                f2 = afloat[2];
            }
            coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, TEXTURE, p_225628_1_, p_225628_2_, p_225628_3_, p_225628_4_, p_225628_5_, p_225628_6_, p_225628_8_, p_225628_9_, p_225628_10_, p_225628_7_, f, f1, f2);
        }
    }



}
