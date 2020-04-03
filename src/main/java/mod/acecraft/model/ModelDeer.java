package mod.acecraft.model;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelDeer <T extends Entity> extends EntityModel<T> {

    //fields
    RendererModel Body;
    RendererModel LegFrontLeft;
    RendererModel LegFrontRight;
    RendererModel LegBackLeft;
    RendererModel LegBackRight;
    RendererModel Neck;
    RendererModel Head;
    RendererModel EarLeft;
    RendererModel EarRight;
    RendererModel Vielender;
    RendererModel Tail;

    public ModelDeer()
    {
        textureWidth = 128;
        textureHeight = 64;

        Body = new RendererModel(this, 0, 0);
        Body.addBox(-6F, -7F, -11F, 12, 14, 26);
        Body.setRotationPoint(0F, 4F, 0F);
        Body.setTextureSize(128, 64);
        Body.mirror = true;
        setRotation(Body, 0F, 0F, 0F);
        LegFrontLeft = new RendererModel(this, 0, 41);
        LegFrontLeft.addBox(-2F, 0F, -2F, 4, 14, 4);
        LegFrontLeft.setRotationPoint(3F, 10F, -7F);
        LegFrontLeft.setTextureSize(128, 64);
        LegFrontLeft.mirror = true;
        setRotation(LegFrontLeft, 0F, 0F, 0F);
        LegFrontRight = new RendererModel(this, 17, 41);
        LegFrontRight.addBox(-2F, 0F, -2F, 4, 14, 4);
        LegFrontRight.setRotationPoint(-3F, 10F, -7F);
        LegFrontRight.setTextureSize(128, 64);
        LegFrontRight.mirror = true;
        setRotation(LegFrontRight, 0F, 0F, 0F);
        LegBackLeft = new RendererModel(this, 34, 41);
        LegBackLeft.addBox(-2F, 0F, -2F, 4, 14, 4);
        LegBackLeft.setRotationPoint(3F, 10F, 11F);
        LegBackLeft.setTextureSize(128, 64);
        LegBackLeft.mirror = true;
        setRotation(LegBackLeft, 0F, 0F, 0F);
        LegBackRight = new RendererModel(this, 51, 41);
        LegBackRight.addBox(-2F, 0F, -2F, 4, 14, 4);
        LegBackRight.setRotationPoint(-3F, 10F, 11F);
        LegBackRight.setTextureSize(128, 64);
        LegBackRight.mirror = true;
        setRotation(LegBackRight, 0F, 0F, 0F);
        Neck = new RendererModel(this, 51, 0);
        Neck.addBox(-3.5F, -9F, -4F, 7, 14, 7);
        Neck.setRotationPoint(0F, -3F, -11F);
        Neck.setTextureSize(128, 64);
        Neck.mirror = true;
        setRotation(Neck, 0.6981317F, 0F, 0F);
        Head = new RendererModel(this, 80, 0);
        Head.addBox(-4F, -11F, -15F, 8, 7, 12);
        Head.setRotationPoint(0F, -3F, -11F);
        Head.setTextureSize(128, 64);
        Head.mirror = true;
        setRotation(Head, 0F, 0F, 0F);
        EarLeft = new RendererModel(this, 109, 0);
        EarLeft.addBox(-3F, -15F, -5F, 3, 6, 1);
        EarLeft.setRotationPoint(0F, -3F, -11F);
        EarLeft.setTextureSize(128, 64);
        EarLeft.mirror = true;
        setRotation(EarLeft, 0F, 0F, 0.4363323F);
        EarRight = new RendererModel(this, 83, 0);
        EarRight.addBox(0F, -15F, -5F, 3, 6, 1);
        EarRight.setRotationPoint(0F, -3F, -11F);
        EarRight.setTextureSize(128, 64);
        EarRight.mirror = true;
        setRotation(EarRight, 0F, 0F, -0.4363323F);
        Vielender = new RendererModel(this, 88, 20);
        Vielender.addBox(-6F, -26F, -3.5F, 12, 15, 0);
        Vielender.setRotationPoint(0F, -3F, -11F);
        Vielender.setTextureSize(128, 64);
        Vielender.mirror = true;
        setRotation(Vielender, 0F, 0F, 0F);
        Tail = new RendererModel(this, 77, 37);
        Tail.addBox(-2.5F, -16F, 10F, 5, 8, 3);
        Tail.setRotationPoint(0F, 4F, 0F);
        Tail.setTextureSize(128, 64);
        Tail.mirror = true;
        setRotation(Tail, -0.3490659F, 0F, 0F);
    }

    public void render(T entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(entity, f, f1, f2, f3, f4, f5);
        if(this.isChild){
            GlStateManager.pushMatrix();
            GlStateManager.translatef(0, 0.75f, 0);
            GlStateManager.scalef(0.5f, 0.5f, 0.5f);
            Body.render(f5);
            LegFrontLeft.render(f5);
            LegFrontRight.render(f5);
            LegBackLeft.render(f5);
            LegBackRight.render(f5);
            Neck.render(f5);
            Head.render(f5);
            EarLeft.render(f5);
            EarRight.render(f5);
            Vielender.render(f5);
            Tail.render(f5);
            GlStateManager.popMatrix();
        } else {
            Body.render(f5);
            LegFrontLeft.render(f5);
            LegFrontRight.render(f5);
            LegBackLeft.render(f5);
            LegBackRight.render(f5);
            Neck.render(f5);
            Head.render(f5);
            EarLeft.render(f5);
            EarRight.render(f5);
            Vielender.render(f5);
            Tail.render(f5);
        }
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
        //this.Head         .rotateAngleY = f3 / (180F / (float)Math.PI);
        //this.Head         .rotateAngleX = f4 / (180F / (float)Math.PI);
        //this.Neck         .rotateAngleY = f3 / (180F / (float)Math.PI);
        //this.Neck         .rotateAngleX = f4 / (180F / (float)Math.PI);
        //this.EarLeft      .rotateAngleY = f3 / (180F / (float)Math.PI);
        //this.EarLeft      .rotateAngleX = f4 / (180F / (float)Math.PI);
        //this.EarRight     .rotateAngleY = f3 / (180F / (float)Math.PI);
        //this.EarRight     .rotateAngleX = f4 / (180F / (float)Math.PI);
        //this.Vielender    .rotateAngleY = f3 / (180F / (float)Math.PI);
        //this.Vielender    .rotateAngleX = f4 / (180F / (float)Math.PI);
        this.LegFrontLeft .rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.LegFrontLeft .rotateAngleY = 0.0F;
        this.LegFrontRight.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
        this.LegFrontRight.rotateAngleY = 0.0F;
        this.LegBackLeft  .rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
        this.LegBackLeft  .rotateAngleY = 0.0F;
        this.LegBackRight .rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.LegBackRight .rotateAngleY = 0.0F;
    }

}
