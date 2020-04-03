package mod.acecraft.model;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelFruitPressChild <T extends Entity> extends EntityModel<T> {

    //fields
    RendererModel Shape1400;
    RendererModel Shape1501;
    RendererModel Shape1502;
    RendererModel Shape1503;
    RendererModel Shape1504;

    public ModelFruitPressChild()
    {
        textureWidth = 128;
        textureHeight = 64;

        Shape1400 = new RendererModel(this, 0, 22);
        Shape1400.addBox(-4F, 0F, -4F, 8, 28, 8);
        Shape1400.setRotationPoint(0F, -8F, 0F);
        Shape1400.setTextureSize(128, 64);
        Shape1400.mirror = true;
        setRotation(Shape1400, 0F, 0F, 0F);
        Shape1501 = new RendererModel(this, 33, 38);
        Shape1501.addBox(3F, 0F, -10F, 1, 14, 6);
        Shape1501.setRotationPoint(0F, 0F, 0F);
        Shape1501.setTextureSize(128, 64);
        Shape1501.mirror = true;
        setRotation(Shape1501, 0F, 0F, 0.2230717F);
        Shape1502 = new RendererModel(this, 33, 38);
        Shape1502.addBox(3F, 0F, -10F, 1, 14, 6);
        Shape1502.setRotationPoint(0F, 0F, 0F);
        Shape1502.setTextureSize(128, 64);
        Shape1502.mirror = true;
        setRotation(Shape1502, 0F, -1.570796F, 0.2230717F);
        Shape1503 = new RendererModel(this, 33, 38);
        Shape1503.addBox(3F, 0F, -10F, 1, 14, 6);
        Shape1503.setRotationPoint(0F, 0F, 0F);
        Shape1503.setTextureSize(128, 64);
        Shape1503.mirror = true;
        setRotation(Shape1503, 0F, -3.141593F, 0.2230717F);
        Shape1504 = new RendererModel(this, 33, 38);
        Shape1504.addBox(3F, 0F, -10F, 1, 14, 6);
        Shape1504.setRotationPoint(0F, 0F, 0F);
        Shape1504.setTextureSize(128, 64);
        Shape1504.mirror = true;
        setRotation(Shape1504, 0F, 1.570796F, 0.2230717F);
    }

    public void render(T entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(entity, f, f1, f2, f3, f4, f5);
        Shape1400.render(f5);
        Shape1501.render(f5);
        Shape1502.render(f5);
        Shape1503.render(f5);
        Shape1504.render(f5);
    }

    private void setRotation(RendererModel model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(T entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.setRotationAngles(entity, f, f1, f2, f3, f4, f5);
    }

}
