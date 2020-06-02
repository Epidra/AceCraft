package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRoofInsideChild1 extends ModelBase
{
  //fields
    ModelRenderer Shape3101;
    ModelRenderer Shape3102;
    ModelRenderer Shape3201;
    ModelRenderer Shape3301;
    ModelRenderer Shape3401;
    ModelRenderer Shape3202;
    ModelRenderer Shape3302;
    ModelRenderer Shape3402;
  
  public ModelRoofInsideChild1()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Shape3101 = new ModelRenderer(this, 0, 17);
      Shape3101.addBox(-8F, -1F, -23F, 16, 1, 23);
      Shape3101.setRotationPoint(0F, 9F, 8F);
      Shape3101.setTextureSize(64, 32);
      Shape3101.mirror = true;
      setRotation(Shape3101, 0.7853982F, 0F, 0F);
      Shape3102 = new ModelRenderer(this, 0, 17);
      Shape3102.addBox(-8F, -1F, -23F, 16, 1, 23);
      Shape3102.setRotationPoint(8F, 9F, 0F);
      Shape3102.setTextureSize(64, 32);
      Shape3102.mirror = true;
      setRotation(Shape3102, 0.7853982F, 1.570796F, 0F);
      Shape3201 = new ModelRenderer(this, 0, 42);
      Shape3201.addBox(-8F, -1F, -9F, 16, 1, 10);
      Shape3201.setRotationPoint(0F, 9F, 8F);
      Shape3201.setTextureSize(64, 32);
      Shape3201.mirror = true;
      setRotation(Shape3201, 0.6981317F, 0F, 0F);
      Shape3301 = new ModelRenderer(this, 0, 42);
      Shape3301.addBox(-8F, -1F, -9F, 16, 1, 10);
      Shape3301.setRotationPoint(0F, 14F, 3F);
      Shape3301.setTextureSize(64, 32);
      Shape3301.mirror = true;
      setRotation(Shape3301, 0.6981317F, 0F, 0F);
      Shape3401 = new ModelRenderer(this, 0, 42);
      Shape3401.addBox(-8F, -1F, -9F, 16, 1, 10);
      Shape3401.setRotationPoint(0F, 20F, -3F);
      Shape3401.setTextureSize(64, 32);
      Shape3401.mirror = true;
      setRotation(Shape3401, 0.6981317F, 0F, 0F);
      Shape3202 = new ModelRenderer(this, 0, 42);
      Shape3202.addBox(-8F, -1F, -9F, 16, 1, 10);
      Shape3202.setRotationPoint(8F, 9F, 0F);
      Shape3202.setTextureSize(64, 32);
      Shape3202.mirror = true;
      setRotation(Shape3202, 0.6981317F, 1.570796F, 0F);
      Shape3302 = new ModelRenderer(this, 0, 42);
      Shape3302.addBox(-8F, -1F, -9F, 16, 1, 10);
      Shape3302.setRotationPoint(3F, 14F, 0F);
      Shape3302.setTextureSize(64, 32);
      Shape3302.mirror = true;
      setRotation(Shape3302, 0.6981317F, 1.570796F, 0F);
      Shape3402 = new ModelRenderer(this, 0, 42);
      Shape3402.addBox(-8F, -1F, -9F, 16, 1, 10);
      Shape3402.setRotationPoint(-3F, 20F, 0F);
      Shape3402.setTextureSize(64, 32);
      Shape3402.mirror = true;
      setRotation(Shape3402, 0.6981317F, 1.570796F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape3101.render(f5);
    Shape3102.render(f5);
    Shape3201.render(f5);
    Shape3301.render(f5);
    Shape3401.render(f5);
    Shape3202.render(f5);
    Shape3302.render(f5);
    Shape3402.render(f5);
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
  }

}
