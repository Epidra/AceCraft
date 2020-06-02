package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelElephant extends ModelBase
{
  //fields
    ModelRenderer Body;
    ModelRenderer LegFrontLeft;
    ModelRenderer LegFrontRight;
    ModelRenderer LegBackLeft;
    ModelRenderer LegBackRight;
    ModelRenderer Head;
    ModelRenderer EarLeft;
    ModelRenderer EarRight;
    ModelRenderer Nose;
    ModelRenderer IvoryRight3;
    ModelRenderer IvoryRight2;
    ModelRenderer IvoryRight1;
    ModelRenderer IvoryLeft3;
    ModelRenderer IvoryLeft2;
    ModelRenderer IvoryLeft1;
  
  public ModelElephant()
  {
    textureWidth = 256;
    textureHeight = 128;
    
      Body = new ModelRenderer(this, 0, 0);
      Body.addBox(-12F, -22F, -24F, 24, 28, 48);
      Body.setRotationPoint(0F, 0F, 0F);
      Body.setTextureSize(64, 32);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      LegFrontLeft = new ModelRenderer(this, 0, 0);
      LegFrontLeft.addBox(-4F, -3F, -4F, 8, 21, 8);
      LegFrontLeft.setRotationPoint(6F, 6F, -18F);
      LegFrontLeft.setTextureSize(64, 32);
      LegFrontLeft.mirror = true;
      setRotation(LegFrontLeft, 0F, 0F, 0F);
      LegFrontRight = new ModelRenderer(this, 0, 0);
      LegFrontRight.addBox(-4F, -3F, -4F, 8, 21, 8);
      LegFrontRight.setRotationPoint(-6F, 6F, -18F);
      LegFrontRight.setTextureSize(64, 32);
      LegFrontRight.mirror = true;
      setRotation(LegFrontRight, 0F, 0F, 0F);
      LegBackLeft = new ModelRenderer(this, 0, 0);
      LegBackLeft.addBox(-4F, -3F, -4F, 8, 21, 8);
      LegBackLeft.setRotationPoint(6F, 6F, 16F);
      LegBackLeft.setTextureSize(64, 32);
      LegBackLeft.mirror = true;
      setRotation(LegBackLeft, 0F, 0F, 0F);
      LegBackRight = new ModelRenderer(this, 0, 0);
      LegBackRight.addBox(-4F, -3F, -4F, 8, 21, 8);
      LegBackRight.setRotationPoint(-6F, 6F, 16F);
      LegBackRight.setTextureSize(64, 32);
      LegBackRight.mirror = true;
      setRotation(LegBackRight, 0F, 0F, 0F);
      Head = new ModelRenderer(this, 100, 0);
      Head.addBox(-8F, -10F, -16F, 16, 17, 16);
      Head.setRotationPoint(0F, -19F, -22F);
      Head.setTextureSize(64, 32);
      Head.mirror = true;
      setRotation(Head, 0.0872665F, 0F, 0F);
      EarLeft = new ModelRenderer(this, 150, 0);
      EarLeft.addBox(1F, -8F, -10F, 5, 9, 1);
      EarLeft.setRotationPoint(0F, -19F, -22F);
      EarLeft.setTextureSize(64, 32);
      EarLeft.mirror = true;
      setRotation(EarLeft, 0F, -0.7853982F, 0F);
      EarRight = new ModelRenderer(this, 150, 0);
      EarRight.addBox(-6F, -8F, -10F, 5, 9, 1);
      EarRight.setRotationPoint(0F, -19F, -22F);
      EarRight.setTextureSize(64, 32);
      EarRight.mirror = true;
      setRotation(EarRight, 0F, 0.7853982F, 0F);
      Nose = new ModelRenderer(this, 165, 0);
      Nose.addBox(-2.5F, 0F, -17F, 5, 28, 5);
      Nose.setRotationPoint(0F, -19F, -22F);
      Nose.setTextureSize(64, 32);
      Nose.mirror = true;
      setRotation(Nose, 0F, 0F, 0F);
      IvoryRight3 = new ModelRenderer(this, 33, 0);
      IvoryRight3.addBox(-7.5F, 11F, -12F, 3, 13, 3);
      IvoryRight3.setRotationPoint(0F, -19F, -22F);
      IvoryRight3.setTextureSize(64, 32);
      IvoryRight3.mirror = true;
      setRotation(IvoryRight3, -0.4363323F, 0F, 0F);
      IvoryRight2 = new ModelRenderer(this, 35, 17);
      IvoryRight2.addBox(-7F, 25F, 1.5F, 2, 12, 2);
      IvoryRight2.setRotationPoint(0F, -19F, -22F);
      IvoryRight2.setTextureSize(64, 32);
      IvoryRight2.mirror = true;
      setRotation(IvoryRight2, -0.9599311F, 0F, 0F);
      IvoryRight1 = new ModelRenderer(this, 37, 32);
      IvoryRight1.addBox(-6.5F, 32F, 17F, 1, 12, 1);
      IvoryRight1.setRotationPoint(0F, -19F, -22F);
      IvoryRight1.setTextureSize(64, 32);
      IvoryRight1.mirror = true;
      setRotation(IvoryRight1, -1.396263F, 0F, 0F);
      IvoryLeft3 = new ModelRenderer(this, 33, 0);
      IvoryLeft3.addBox(4.5F, 11F, -12F, 3, 13, 3);
      IvoryLeft3.setRotationPoint(0F, -19F, -22F);
      IvoryLeft3.setTextureSize(64, 32);
      IvoryLeft3.mirror = true;
      setRotation(IvoryLeft3, -0.4363323F, 0F, 0F);
      IvoryLeft2 = new ModelRenderer(this, 35, 17);
      IvoryLeft2.addBox(5F, 25F, 1.5F, 2, 12, 2);
      IvoryLeft2.setRotationPoint(0F, -19F, -22F);
      IvoryLeft2.setTextureSize(64, 32);
      IvoryLeft2.mirror = true;
      setRotation(IvoryLeft2, -0.9599311F, 0F, 0F);
      IvoryLeft1 = new ModelRenderer(this, 37, 32);
      IvoryLeft1.addBox(5.5F, 32F, 17F, 1, 12, 1);
      IvoryLeft1.setRotationPoint(0F, -19F, -22F);
      IvoryLeft1.setTextureSize(64, 32);
      IvoryLeft1.mirror = true;
      setRotation(IvoryLeft1, -1.396263F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Body.render(f5);
    LegFrontLeft.render(f5);
    LegFrontRight.render(f5);
    LegBackLeft.render(f5);
    LegBackRight.render(f5);
    Head.render(f5);
    EarLeft.render(f5);
    EarRight.render(f5);
    Nose.render(f5);
    IvoryRight3.render(f5);
    IvoryRight2.render(f5);
    IvoryRight1.render(f5);
    IvoryLeft3.render(f5);
    IvoryLeft2.render(f5);
    IvoryLeft1.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    //this.Head         .rotateAngleY = f3 / (180F / (float)Math.PI);
    //this.Head         .rotateAngleX = f4 / (180F / (float)Math.PI);
    //this.EarLeft      .rotateAngleY = f3 / (180F / (float)Math.PI);
    //this.EarLeft      .rotateAngleX = f4 / (180F / (float)Math.PI);
    //this.EarRight     .rotateAngleY = f3 / (180F / (float)Math.PI);
    //this.EarRight     .rotateAngleX = f4 / (180F / (float)Math.PI);
    //this.Nose         .rotateAngleY = f3 / (180F / (float)Math.PI);
    //this.Nose         .rotateAngleX = f4 / (180F / (float)Math.PI);
    //this.IvoryRight3  .rotateAngleY = f3 / (180F / (float)Math.PI);
    //this.IvoryRight3  .rotateAngleX = f4 / (180F / (float)Math.PI);
    //this.IvoryRight2  .rotateAngleY = f3 / (180F / (float)Math.PI);
    //this.IvoryRight2  .rotateAngleX = f4 / (180F / (float)Math.PI);
    //this.IvoryRight1  .rotateAngleY = f3 / (180F / (float)Math.PI);
    //this.IvoryRight1  .rotateAngleX = f4 / (180F / (float)Math.PI);
    //this.IvoryLeft3   .rotateAngleY = f3 / (180F / (float)Math.PI);
    //this.IvoryLeft3   .rotateAngleX = f4 / (180F / (float)Math.PI);
    //this.IvoryLeft2   .rotateAngleY = f3 / (180F / (float)Math.PI);
    //this.IvoryLeft2   .rotateAngleX = f4 / (180F / (float)Math.PI);
    //this.IvoryLeft1   .rotateAngleY = f3 / (180F / (float)Math.PI);
    //this.IvoryLeft1   .rotateAngleX = f4 / (180F / (float)Math.PI);
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
