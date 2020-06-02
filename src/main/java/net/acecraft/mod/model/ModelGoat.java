package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelGoat extends ModelBase
{
  //fields
    ModelRenderer Body;
    ModelRenderer LegFrontLeft;
    ModelRenderer LegFrontRight;
    ModelRenderer LegBackLeft;
    ModelRenderer LegBackRight;
    ModelRenderer Neck;
    ModelRenderer Head;
    ModelRenderer EarLeft;
    ModelRenderer EarRight;
    ModelRenderer HornLeft;
    ModelRenderer HornRight;
    ModelRenderer Tail;
  
  public ModelGoat()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Body = new ModelRenderer(this, 0, 0);
      Body.addBox(-4F, -4F, -7F, 8, 7, 14);
      Body.setRotationPoint(0F, 14F, 0F);
      Body.setTextureSize(64, 32);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      LegFrontLeft = new ModelRenderer(this, 32, 0);
      LegFrontLeft.addBox(-1F, 0F, -1F, 2, 7, 2);
      LegFrontLeft.setRotationPoint(2.5F, 17F, -4.5F);
      LegFrontLeft.setTextureSize(64, 32);
      LegFrontLeft.mirror = true;
      setRotation(LegFrontLeft, 0F, 0F, 0F);
      LegFrontRight = new ModelRenderer(this, 40, 0);
      LegFrontRight.addBox(-1F, 0F, -1F, 2, 7, 2);
      LegFrontRight.setRotationPoint(-2.5F, 17F, -4.5F);
      LegFrontRight.setTextureSize(64, 32);
      LegFrontRight.mirror = true;
      setRotation(LegFrontRight, 0F, 0F, 0F);
      LegBackLeft = new ModelRenderer(this, 48, 0);
      LegBackLeft.addBox(-1F, 0F, -1F, 2, 7, 2);
      LegBackLeft.setRotationPoint(2.5F, 17F, 5.5F);
      LegBackLeft.setTextureSize(64, 32);
      LegBackLeft.mirror = true;
      setRotation(LegBackLeft, 0F, 0F, 0F);
      LegBackRight = new ModelRenderer(this, 56, 0);
      LegBackRight.addBox(-1F, 0F, -1F, 2, 7, 2);
      LegBackRight.setRotationPoint(-2.5F, 17F, 5.5F);
      LegBackRight.setTextureSize(64, 32);
      LegBackRight.mirror = true;
      setRotation(LegBackRight, 0F, 0F, 0F);
      Neck = new ModelRenderer(this, 0, 21);
      Neck.addBox(-1.5F, -5F, -1.5F, 3, 7, 3);
      Neck.setRotationPoint(0F, 10F, -7F);
      Neck.setTextureSize(64, 32);
      Neck.mirror = true;
      setRotation(Neck, 0.6108652F, 0F, 0F);
      Head = new ModelRenderer(this, 12, 21);
      Head.addBox(-2F, -7F, -7F, 4, 4, 6);
      Head.setRotationPoint(0F, 10F, -7F);
      Head.setTextureSize(64, 32);
      Head.mirror = true;
      setRotation(Head, 0.1396263F, 0F, 0F);
      EarLeft = new ModelRenderer(this, 33, 22);
      EarLeft.addBox(-2.5F, -6F, -4F, 3, 1, 2);
      EarLeft.setRotationPoint(0F, 10F, -7F);
      EarLeft.setTextureSize(64, 32);
      EarLeft.mirror = true;
      setRotation(EarLeft, 0F, 0F, 0.6981317F);
      EarRight = new ModelRenderer(this, 33, 26);
      EarRight.addBox(-0.5F, -6F, -4F, 3, 1, 2);
      EarRight.setRotationPoint(0F, 10F, -7F);
      EarRight.setTextureSize(64, 32);
      EarRight.mirror = true;
      setRotation(EarRight, 0F, 0F, -0.6981317F);
      HornLeft = new ModelRenderer(this, 49, 22);
      HornLeft.addBox(0.5F, -5F, -7F, 1, 3, 1);
      HornLeft.setRotationPoint(0F, 10F, -7F);
      HornLeft.setTextureSize(64, 32);
      HornLeft.mirror = true;
      setRotation(HornLeft, -0.7853982F, 0F, 0F);
      HornRight = new ModelRenderer(this, 44, 22);
      HornRight.addBox(-1.5F, -5F, -7F, 1, 3, 1);
      HornRight.setRotationPoint(0F, 10F, -7F);
      HornRight.setTextureSize(64, 32);
      HornRight.mirror = true;
      setRotation(HornRight, -0.7853982F, 0F, 0F);
      Tail = new ModelRenderer(this, 44, 27);
      Tail.addBox(-1F, -7F, 5F, 2, 3, 1);
      Tail.setRotationPoint(0F, 14F, 0F);
      Tail.setTextureSize(64, 32);
      Tail.mirror = true;
      setRotation(Tail, -0.2617994F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    if(this.isChild){
    	GlStateManager.pushMatrix();
	    	GlStateManager.translate(0, 0.75f, 0);
	    	GlStateManager.scale(0.5f, 0.5f, 0.5f);
	    	Body.render(f5);
	        LegFrontLeft.render(f5);
	        LegFrontRight.render(f5);
	        LegBackLeft.render(f5);
	        LegBackRight.render(f5);
	        Neck.render(f5);
	        Head.render(f5);
	        EarLeft.render(f5);
	        EarRight.render(f5);
	        HornLeft.render(f5);
	        HornRight.render(f5);
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
        HornLeft.render(f5);
        HornRight.render(f5);
        Tail.render(f5);
    }
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
    //this.Neck         .rotateAngleY = f3 / (180F / (float)Math.PI);
    //this.Neck         .rotateAngleX = f4 / (180F / (float)Math.PI);
    //this.EarLeft      .rotateAngleY = f3 / (180F / (float)Math.PI);
    //this.EarLeft      .rotateAngleX = f4 / (180F / (float)Math.PI);
    //this.EarRight     .rotateAngleY = f3 / (180F / (float)Math.PI);
    //this.EarRight     .rotateAngleX = f4 / (180F / (float)Math.PI);
    //this.HornLeft     .rotateAngleY = f3 / (180F / (float)Math.PI);
    //this.HornLeft     .rotateAngleX = f4 / (180F / (float)Math.PI);
    //this.HornRight    .rotateAngleY = f3 / (180F / (float)Math.PI);
    //this.HornRight    .rotateAngleX = f4 / (180F / (float)Math.PI);
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
