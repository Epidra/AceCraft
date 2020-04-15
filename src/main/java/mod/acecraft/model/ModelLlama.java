package mod.acecraft.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import mod.acecraft.entity.EntityLlama;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelLlama <T extends Entity> extends EntityModel<T> {

    //fields
    ModelRenderer BodyClean;
    ModelRenderer BodyFur;
    ModelRenderer LegFrontLeftClean;
    ModelRenderer LegFrontLeftFur;
    ModelRenderer LegFrontRightClean;
    ModelRenderer LegFrontRightFur;
    ModelRenderer LegBackLeftClean;
    ModelRenderer LegBackLeftFur;
    ModelRenderer LegBackRightClean;
    ModelRenderer LegBackRightFur;
    ModelRenderer NeckClean;
    ModelRenderer NeckFur;
    ModelRenderer Head;
    ModelRenderer Nose;
    ModelRenderer EarLeft;
    ModelRenderer EarRight;
    ModelRenderer Tail;

    public ModelLlama()
    {
        textureWidth = 128;
        textureHeight = 64;

        BodyClean = new ModelRenderer(this, 1, 1);
        BodyClean.addBox(-5F, -7F, -10F, 10, 11, 20);
        BodyClean.setRotationPoint(0F, 11F, 0F);
        BodyClean.setTextureSize(128, 64);
        BodyClean.mirror = true;
        setRotation(BodyClean, 0F, 0F, 0F);
        BodyFur = new ModelRenderer(this, 62, 0);
        BodyFur.addBox(-5.5F, -7.5F, -10.5F, 11, 12, 21);
        BodyFur.setRotationPoint(0F, 11F, 0F);
        BodyFur.setTextureSize(128, 64);
        BodyFur.mirror = true;
        setRotation(BodyFur, 0F, 0F, 0F);
        LegFrontLeftClean = new ModelRenderer(this, 2, 35);
        LegFrontLeftClean.addBox(-1.5F, -1F, -1.5F, 3, 10, 3);
        LegFrontLeftClean.setRotationPoint(2.5F, 15F, -7F);
        LegFrontLeftClean.setTextureSize(128, 64);
        LegFrontLeftClean.mirror = true;
        setRotation(LegFrontLeftClean, 0F, 0F, 0F);
        LegFrontLeftFur = new ModelRenderer(this, 0, 49);
        LegFrontLeftFur.addBox(-2F, -1F, -2F, 4, 9, 4);
        LegFrontLeftFur.setRotationPoint(2.5F, 15F, -7F);
        LegFrontLeftFur.setTextureSize(128, 64);
        LegFrontLeftFur.mirror = true;
        setRotation(LegFrontLeftFur, 0F, 0F, 0F);
        LegFrontRightClean = new ModelRenderer(this, 19, 35);
        LegFrontRightClean.addBox(-1.5F, -1F, -1.5F, 3, 10, 3);
        LegFrontRightClean.setRotationPoint(-2.5F, 15F, -7F);
        LegFrontRightClean.setTextureSize(128, 64);
        LegFrontRightClean.mirror = true;
        setRotation(LegFrontRightClean, 0F, 0F, 0F);
        LegFrontRightFur = new ModelRenderer(this, 17, 49);
        LegFrontRightFur.addBox(-2F, -1F, -2F, 4, 9, 4);
        LegFrontRightFur.setRotationPoint(-2.5F, 15F, -7F);
        LegFrontRightFur.setTextureSize(128, 64);
        LegFrontRightFur.mirror = true;
        setRotation(LegFrontRightFur, 0F, 0F, 0F);
        LegBackLeftClean = new ModelRenderer(this, 36, 35);
        LegBackLeftClean.addBox(-1.5F, -1F, -1.5F, 3, 10, 3);
        LegBackLeftClean.setRotationPoint(2.5F, 15F, 7F);
        LegBackLeftClean.setTextureSize(128, 64);
        LegBackLeftClean.mirror = true;
        setRotation(LegBackLeftClean, 0F, 0F, 0F);
        LegBackLeftFur = new ModelRenderer(this, 34, 49);
        LegBackLeftFur.addBox(-2F, -1F, -2F, 4, 9, 4);
        LegBackLeftFur.setRotationPoint(2.5F, 15F, 7F);
        LegBackLeftFur.setTextureSize(128, 64);
        LegBackLeftFur.mirror = true;
        setRotation(LegBackLeftFur, 0F, 0F, 0F);
        LegBackRightClean = new ModelRenderer(this, 53, 35);
        LegBackRightClean.addBox(-1.5F, -1F, -1.5F, 3, 10, 3);
        LegBackRightClean.setRotationPoint(-2.5F, 15F, 7F);
        LegBackRightClean.setTextureSize(128, 64);
        LegBackRightClean.mirror = true;
        setRotation(LegBackRightClean, 0F, 0F, 0F);
        LegBackRightFur = new ModelRenderer(this, 51, 49);
        LegBackRightFur.addBox(-2F, -1F, -2F, 4, 9, 4);
        LegBackRightFur.setRotationPoint(-2.5F, 15F, 7F);
        LegBackRightFur.setTextureSize(128, 64);
        LegBackRightFur.mirror = true;
        setRotation(LegBackRightFur, 0F, 0F, 0F);
        NeckClean = new ModelRenderer(this, 43, 1);
        NeckClean.addBox(-1.5F, -11F, -1.5F, 3, 11, 3);
        NeckClean.setRotationPoint(0F, 4F, -7.5F);
        NeckClean.setTextureSize(128, 64);
        NeckClean.mirror = true;
        setRotation(NeckClean, 0F, 0F, 0F);
        NeckFur = new ModelRenderer(this, 56, 0);
        NeckFur.addBox(-2F, -11F, -2F, 4, 11, 4);
        NeckFur.setRotationPoint(0F, 4F, -7.5F);
        NeckFur.setTextureSize(128, 64);
        NeckFur.mirror = true;
        setRotation(NeckFur, 0F, 0F, 0F);
        Head = new ModelRenderer(this, 84, 34);
        Head.addBox(-2.5F, -16F, -2.5F, 5, 5, 5);
        Head.setRotationPoint(0F, 4F, -7.5F);
        Head.setTextureSize(128, 64);
        Head.mirror = true;
        setRotation(Head, 0F, 0F, 0F);
        Nose = new ModelRenderer(this, 86, 45);
        Nose.addBox(-2F, -13F, -6.5F, 4, 2, 4);
        Nose.setRotationPoint(0F, 4F, -7.5F);
        Nose.setTextureSize(128, 64);
        Nose.mirror = true;
        setRotation(Nose, 0F, 0F, 0F);
        EarLeft = new ModelRenderer(this, 105, 34);
        EarLeft.addBox(-1F, -19F, 1F, 2, 4, 1);
        EarLeft.setRotationPoint(0F, 4F, -7.5F);
        EarLeft.setTextureSize(128, 64);
        EarLeft.mirror = true;
        setRotation(EarLeft, 0F, 0F, 0.0872665F);
        EarRight = new ModelRenderer(this, 77, 34);
        EarRight.addBox(-1F, -19F, 1F, 2, 4, 1);
        EarRight.setRotationPoint(0F, 4F, -7.5F);
        EarRight.setTextureSize(128, 64);
        EarRight.mirror = true;
        setRotation(EarRight, 0F, 0F, -0.0872665F);
        Tail = new ModelRenderer(this, 3, 3);
        Tail.addBox(-1.5F, -11F, 7F, 3, 5, 2);
        Tail.setRotationPoint(0F, 11F, 0F);
        Tail.setTextureSize(128, 64);
        Tail.mirror = true;
        setRotation(Tail, -0.2617994F, 0F, 0F);
    }

    @Override
    public void render(T t, float v, float v1, float v2, float v3, float v4) {

    }

    //// Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale
    //public void render(T entity, float f, float f1, float f2, float f3, float f4, float f5){
    //    EntityLlama e = (EntityLlama) entity;
    //    super.render(entity, f, f1, f2, f3, f4, f5);
    //    setRotationAngles(entity, f, f1, f2, f3, f4, f5);
    //    if(this.isChild){
    //        GlStateManager.pushMatrix();
    //        GlStateManager.translatef(0, 0.75f, 0);
    //        GlStateManager.scalef(0.5f, 0.5f, 0.5f);
    //        BodyClean.render(f5);
    //        BodyFur.render(f5);
    //        LegFrontLeftClean.render(f5);
    //        LegFrontLeftFur.render(f5);
    //        LegFrontRightClean.render(f5);
    //        LegFrontRightFur.render(f5);
    //        LegBackLeftClean.render(f5);
    //        LegBackLeftFur.render(f5);
    //        LegBackRightClean.render(f5);
    //        LegBackRightFur.render(f5);
    //        NeckClean.render(f5);
    //        NeckFur.render(f5);
    //        Tail.render(f5);
    //        GlStateManager.popMatrix();
    //        GlStateManager.pushMatrix();
    //        GlStateManager.translatef(0, 0.9f,  0.10f);
    //        GlStateManager.scalef(0.75f, 0.75f, 0.75f);
    //        Head.render(f5);
    //        Nose.render(f5);
    //        EarLeft.render(f5);
    //        EarRight.render(f5);
    //        GlStateManager.popMatrix();
    //    } else {
    //        BodyClean.render(f5);
    //        BodyFur.render(f5);
    //        LegFrontLeftClean.render(f5);
    //        LegFrontLeftFur.render(f5);
    //        LegFrontRightClean.render(f5);
    //        LegFrontRightFur.render(f5);
    //        LegBackLeftClean.render(f5);
    //        LegBackLeftFur.render(f5);
    //        LegBackRightClean.render(f5);
    //        LegBackRightFur.render(f5);
    //        NeckClean.render(f5);
    //        NeckFur.render(f5);
    //        Tail.render(f5);
    //        if(e.isBeingRidden()){
    //            GlStateManager.pushMatrix();
    //            GlStateManager.translatef(0, 0.15f, 0);
    //            Head.render(f5);
    //            Nose.render(f5);
    //            EarLeft.render(f5);
    //            EarRight.render(f5);
    //            GlStateManager.popMatrix();
    //        } else {
    //            Head.render(f5);
    //            Nose.render(f5);
    //            EarLeft.render(f5);
    //            EarRight.render(f5);
    //        }
    //    }
    //}

    private void setRotation(ModelRenderer model, float x, float y, float z){
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    // float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn
    public void setRotationAngles(T entity, float f, float f1, float f2, float f3, float f4, float f5){
        //super.setRotationAngles(entity, f, f1, f2, f3, f4, f5);
        EntityLlama e = (EntityLlama) entity;
        int invert = this.isChild || e.isBeingRidden() ? 1 : -1;
        int maxrot = this.isChild ? 2 :  1;
        this.Head              .rotateAngleY =        f3 / (180F / (float)Math.PI);
        this.Head              .rotateAngleX = invert*f4/maxrot / (180F / (float)Math.PI);
        this.NeckClean         .rotateAngleY =        f3 / (180F / (float)Math.PI);
        this.NeckClean         .rotateAngleX = invert*f4/maxrot / (180F / (float)Math.PI);
        this.NeckFur           .rotateAngleY =        f3 / (180F / (float)Math.PI);
        this.NeckFur           .rotateAngleX = invert*f4/maxrot / (180F / (float)Math.PI);
        this.Nose              .rotateAngleY =        f3 / (180F / (float)Math.PI);
        this.Nose              .rotateAngleX = invert*f4/maxrot / (180F / (float)Math.PI);
        this.EarLeft           .rotateAngleY =        f3 / (180F / (float)Math.PI);
        this.EarLeft           .rotateAngleX = invert*f4/maxrot / (180F / (float)Math.PI);
        this.EarRight          .rotateAngleY =        f3 / (180F / (float)Math.PI);
        this.EarRight          .rotateAngleX = invert*f4/maxrot / (180F / (float)Math.PI);
        this.LegFrontLeftClean .rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.LegFrontLeftClean .rotateAngleY = 0.0F;
        this.LegFrontRightClean.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
        this.LegFrontRightClean.rotateAngleY = 0.0F;
        this.LegBackLeftClean  .rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
        this.LegBackLeftClean  .rotateAngleY = 0.0F;
        this.LegBackRightClean .rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.LegBackRightClean .rotateAngleY = 0.0F;
        this.LegFrontLeftFur   .rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.LegFrontLeftFur   .rotateAngleY = 0.0F;
        this.LegFrontRightFur  .rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
        this.LegFrontRightFur  .rotateAngleY = 0.0F;
        this.LegBackLeftFur    .rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
        this.LegBackLeftFur    .rotateAngleY = 0.0F;
        this.LegBackRightFur   .rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.LegBackRightFur   .rotateAngleY = 0.0F;
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder iVertexBuilder, int i, int i1, float v, float v1, float v2, float v3) {

    }
}
