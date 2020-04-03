package mod.acecraft.model;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelWindmill <T extends Entity> extends EntityModel<T> {

    //fields
    RendererModel Shape100;
    RendererModel Shape201;
    RendererModel Shape202;
    RendererModel Shape203;
    RendererModel Shape204;
    RendererModel Shape301;
    RendererModel Shape302;
    RendererModel Shape303;
    RendererModel Shape304;
    RendererModel Shape305;
    RendererModel Shape306;
    RendererModel Shape307;
    RendererModel Shape308;
    RendererModel Shape309;
    RendererModel Shape310;
    RendererModel Shape311;
    RendererModel Shape312;
    RendererModel Shape313;
    RendererModel Shape314;
    RendererModel Shape315;
    RendererModel Shape316;
    RendererModel Shape401;
    RendererModel Shape402;
    RendererModel Shape403;
    RendererModel Shape404;

    public ModelWindmill()
    {
        textureWidth = 256;
        textureHeight = 64;

        Shape100 = new RendererModel(this, 14, 6);
        Shape100.addBox(-3F, -3F, -8F, 6, 6, 14);
        Shape100.setRotationPoint(0F, 0F, 0F);
        Shape100.setTextureSize(256, 64);
        Shape100.mirror = true;
        setRotation(Shape100, 0F, 0F, -0.7853982F);
        Shape201 = new RendererModel(this, 14, 0);
        Shape201.addBox(3F, -1F, 1F, 58, 3, 3);
        Shape201.setRotationPoint(0F, 0F, 0F);
        Shape201.setTextureSize(256, 64);
        Shape201.mirror = true;
        setRotation(Shape201, 0.3141593F, 0F, -0.7853982F);
        Shape202 = new RendererModel(this, 14, 0);
        Shape202.addBox(3F, -1F, 1F, 58, 3, 3);
        Shape202.setRotationPoint(0F, 0F, 0F);
        Shape202.setTextureSize(256, 64);
        Shape202.mirror = true;
        setRotation(Shape202, 0.3141593F, 0F, 0.7853982F);
        Shape203 = new RendererModel(this, 14, 0);
        Shape203.addBox(3F, -1F, 1F, 58, 3, 3);
        Shape203.setRotationPoint(0F, 0F, 0F);
        Shape203.setTextureSize(256, 64);
        Shape203.mirror = true;
        setRotation(Shape203, 0.3141593F, 0F, 2.356194F);
        Shape204 = new RendererModel(this, 14, 0);
        Shape204.addBox(3F, -1F, 1F, 58, 3, 3);
        Shape204.setRotationPoint(0F, 0F, 0F);
        Shape204.setTextureSize(256, 64);
        Shape204.mirror = true;
        setRotation(Shape204, 0.3141593F, 0F, -2.356194F);
        Shape301 = new RendererModel(this, 0, 0);
        Shape301.addBox(5F, -24F, 1.5F, 2, 24, 2);
        Shape301.setRotationPoint(0F, 0F, 0F);
        Shape301.setTextureSize(256, 64);
        Shape301.mirror = true;
        setRotation(Shape301, 0.3141593F, 0F, -0.7853982F);
        Shape302 = new RendererModel(this, 6, 0);
        Shape302.addBox(22F, -24F, 1.5F, 2, 24, 2);
        Shape302.setRotationPoint(0F, 0F, 0F);
        Shape302.setTextureSize(256, 64);
        Shape302.mirror = true;
        setRotation(Shape302, 0.3141593F, 0F, -0.7853982F);
        Shape303 = new RendererModel(this, 0, 25);
        Shape303.addBox(41F, -24F, 1.5F, 2, 24, 2);
        Shape303.setRotationPoint(0F, 0F, 0F);
        Shape303.setTextureSize(256, 64);
        Shape303.mirror = true;
        setRotation(Shape303, 0.3141593F, 0F, -0.7853982F);
        Shape304 = new RendererModel(this, 6, 25);
        Shape304.addBox(59F, -24F, 1.5F, 2, 24, 2);
        Shape304.setRotationPoint(0F, 0F, 0F);
        Shape304.setTextureSize(256, 64);
        Shape304.mirror = true;
        setRotation(Shape304, 0.3141593F, 0F, -0.7853982F);
        Shape305 = new RendererModel(this, 0, 0);
        Shape305.addBox(5F, -24F, 1.5F, 2, 24, 2);
        Shape305.setRotationPoint(0F, 0F, 0F);
        Shape305.setTextureSize(256, 64);
        Shape305.mirror = true;
        setRotation(Shape305, 0.3141593F, 0F, 0.7853982F);
        Shape306 = new RendererModel(this, 6, 0);
        Shape306.addBox(22F, -24F, 1.5F, 2, 24, 2);
        Shape306.setRotationPoint(0F, 0F, 0F);
        Shape306.setTextureSize(256, 64);
        Shape306.mirror = true;
        setRotation(Shape306, 0.3141593F, 0F, 0.7853982F);
        Shape307 = new RendererModel(this, 0, 25);
        Shape307.addBox(41F, -24F, 1.5F, 2, 24, 2);
        Shape307.setRotationPoint(0F, 0F, 0F);
        Shape307.setTextureSize(256, 64);
        Shape307.mirror = true;
        setRotation(Shape307, 0.3141593F, 0F, 0.7853982F);
        Shape308 = new RendererModel(this, 6, 25);
        Shape308.addBox(59F, -24F, 1.5F, 2, 24, 2);
        Shape308.setRotationPoint(0F, 0F, 0F);
        Shape308.setTextureSize(256, 64);
        Shape308.mirror = true;
        setRotation(Shape308, 0.3141593F, 0F, 0.7853982F);
        Shape309 = new RendererModel(this, 0, 0);
        Shape309.addBox(5F, -24F, 1.5F, 2, 24, 2);
        Shape309.setRotationPoint(0F, 0F, 0F);
        Shape309.setTextureSize(256, 64);
        Shape309.mirror = true;
        setRotation(Shape309, 0.3141593F, 0F, 2.356194F);
        Shape310 = new RendererModel(this, 6, 0);
        Shape310.addBox(22F, -24F, 1.5F, 2, 24, 2);
        Shape310.setRotationPoint(0F, 0F, 0F);
        Shape310.setTextureSize(256, 64);
        Shape310.mirror = true;
        setRotation(Shape310, 0.3141593F, 0F, 2.356194F);
        Shape311 = new RendererModel(this, 0, 25);
        Shape311.addBox(41F, -24F, 1.5F, 2, 24, 2);
        Shape311.setRotationPoint(0F, 0F, 0F);
        Shape311.setTextureSize(256, 64);
        Shape311.mirror = true;
        setRotation(Shape311, 0.3141593F, 0F, 2.356194F);
        Shape312 = new RendererModel(this, 6, 25);
        Shape312.addBox(59F, -24F, 1.5F, 2, 24, 2);
        Shape312.setRotationPoint(0F, 0F, 0F);
        Shape312.setTextureSize(256, 64);
        Shape312.mirror = true;
        setRotation(Shape312, 0.3141593F, 0F, 2.356194F);
        Shape313 = new RendererModel(this, 0, 0);
        Shape313.addBox(5F, -24F, 1.5F, 2, 24, 2);
        Shape313.setRotationPoint(0F, 0F, 0F);
        Shape313.setTextureSize(256, 64);
        Shape313.mirror = true;
        setRotation(Shape313, 0.3141593F, 0F, -2.356194F);
        Shape314 = new RendererModel(this, 6, 0);
        Shape314.addBox(22F, -24F, 1.5F, 2, 24, 2);
        Shape314.setRotationPoint(0F, 0F, 0F);
        Shape314.setTextureSize(256, 64);
        Shape314.mirror = true;
        setRotation(Shape314, 0.3141593F, 0F, -2.356194F);
        Shape315 = new RendererModel(this, 0, 25);
        Shape315.addBox(41F, -24F, 1.5F, 2, 24, 2);
        Shape315.setRotationPoint(0F, 0F, 0F);
        Shape315.setTextureSize(256, 64);
        Shape315.mirror = true;
        setRotation(Shape315, 0.3141593F, 0F, -2.356194F);
        Shape316 = new RendererModel(this, 6, 25);
        Shape316.addBox(59F, -24F, 1.5F, 2, 24, 2);
        Shape316.setRotationPoint(0F, 0F, 0F);
        Shape316.setTextureSize(256, 64);
        Shape316.mirror = true;
        setRotation(Shape316, 0.3141593F, 0F, -2.356194F);
        Shape401 = new RendererModel(this, 54, 6);
        Shape401.addBox(6F, -23F, 2F, 54, 22, 1);
        Shape401.setRotationPoint(0F, 0F, 0F);
        Shape401.setTextureSize(256, 64);
        Shape401.mirror = true;
        setRotation(Shape401, 0.3141593F, 0F, -0.7853982F);
        Shape402 = new RendererModel(this, 54, 6);
        Shape402.addBox(6F, -23F, 2F, 54, 22, 1);
        Shape402.setRotationPoint(0F, 0F, 0F);
        Shape402.setTextureSize(256, 64);
        Shape402.mirror = true;
        setRotation(Shape402, 0.3141593F, 0F, 0.7853982F);
        Shape403 = new RendererModel(this, 54, 6);
        Shape403.addBox(6F, -23F, 2F, 54, 22, 1);
        Shape403.setRotationPoint(0F, 0F, 0F);
        Shape403.setTextureSize(256, 64);
        Shape403.mirror = true;
        setRotation(Shape403, 0.3141593F, 0F, 2.356194F);
        Shape404 = new RendererModel(this, 54, 6);
        Shape404.addBox(6F, -23F, 2F, 54, 22, 1);
        Shape404.setRotationPoint(0F, 0F, 0F);
        Shape404.setTextureSize(256, 64);
        Shape404.mirror = true;
        setRotation(Shape404, 0.3141593F, 0F, -2.356194F);
    }

    public void render(T entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(entity, f, f1, f2, f3, f4, f5);
        Shape100.render(f5);
        Shape201.render(f5);
        Shape202.render(f5);
        Shape203.render(f5);
        Shape204.render(f5);
        Shape301.render(f5);
        Shape302.render(f5);
        Shape303.render(f5);
        Shape304.render(f5);
        Shape305.render(f5);
        Shape306.render(f5);
        Shape307.render(f5);
        Shape308.render(f5);
        Shape309.render(f5);
        Shape310.render(f5);
        Shape311.render(f5);
        Shape312.render(f5);
        Shape313.render(f5);
        Shape314.render(f5);
        Shape315.render(f5);
        Shape316.render(f5);
        Shape401.render(f5);
        Shape402.render(f5);
        Shape403.render(f5);
        Shape404.render(f5);
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