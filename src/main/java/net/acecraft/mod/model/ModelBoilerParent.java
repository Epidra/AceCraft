package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBoilerParent extends ModelBase
{
  //fields
    ModelRenderer Shape301;
    ModelRenderer Shape302;
    ModelRenderer Shape401;
    ModelRenderer Shape402;
    ModelRenderer Shape403;
    ModelRenderer Shape404;
    ModelRenderer Shape500;
    ModelRenderer Shape601;
    ModelRenderer Shape602;
    ModelRenderer Shape700;
    ModelRenderer Shape1500;
  
  public ModelBoilerParent()
  {
    textureWidth = 256;
    textureHeight = 128;
    
      Shape301 = new ModelRenderer(this, 58, 0);
      Shape301.addBox(-2.5F, -6F, -18F, 5, 12, 27);
      Shape301.setRotationPoint(0F, 13F, -16F);
      Shape301.setTextureSize(64, 32);
      Shape301.mirror = true;
      setRotation(Shape301, 0F, 0F, 0F);
      Shape302 = new ModelRenderer(this, 58, 0);
      Shape302.addBox(-2.5F, -6F, -18F, 5, 12, 27);
      Shape302.setRotationPoint(0F, 13F, -16F);
      Shape302.setTextureSize(64, 32);
      Shape302.mirror = true;
      setRotation(Shape302, 0F, 0F, 1.570796F);
      Shape401 = new ModelRenderer(this, 60, 39);
      Shape401.addBox(3F, -3F, -18F, 3, 6, 27);
      Shape401.setRotationPoint(0F, 13F, -16F);
      Shape401.setTextureSize(64, 32);
      Shape401.mirror = true;
      setRotation(Shape401, 0F, 0F, -0.7853982F);
      Shape402 = new ModelRenderer(this, 60, 39);
      Shape402.addBox(3F, -3F, -18F, 3, 6, 27);
      Shape402.setRotationPoint(0F, 13F, -16F);
      Shape402.setTextureSize(64, 32);
      Shape402.mirror = true;
      setRotation(Shape402, 0F, 0F, -2.356194F);
      Shape403 = new ModelRenderer(this, 60, 39);
      Shape403.addBox(3F, -3F, -18F, 3, 6, 27);
      Shape403.setRotationPoint(0F, 13F, -16F);
      Shape403.setTextureSize(64, 32);
      Shape403.mirror = true;
      setRotation(Shape403, 0F, 0F, 0.7853982F);
      Shape404 = new ModelRenderer(this, 60, 39);
      Shape404.addBox(3F, -3F, -18F, 3, 6, 27);
      Shape404.setRotationPoint(0F, 13F, -16F);
      Shape404.setTextureSize(64, 32);
      Shape404.mirror = true;
      setRotation(Shape404, 0F, 0F, 2.356194F);
      Shape500 = new ModelRenderer(this, 125, 0);
      Shape500.addBox(-7F, -12F, -7F, 14, 24, 14);
      Shape500.setRotationPoint(0F, 12F, 0F);
      Shape500.setTextureSize(64, 32);
      Shape500.mirror = true;
      setRotation(Shape500, 0F, 0F, 0F);
      Shape601 = new ModelRenderer(this, 138, 54);
      Shape601.addBox(-9F, -2.3F, -6.5F, 2, 3, 13);
      Shape601.setRotationPoint(0F, 6F, 0F);
      Shape601.setTextureSize(64, 32);
      Shape601.mirror = true;
      setRotation(Shape601, 0F, 0F, 0.7853982F);
      Shape602 = new ModelRenderer(this, 138, 54);
      Shape602.addBox(-9F, -1F, -6.5F, 2, 3, 13);
      Shape602.setRotationPoint(0F, 6F, 0F);
      Shape602.setTextureSize(64, 32);
      Shape602.mirror = true;
      setRotation(Shape602, 0F, 0F, 2.356194F);
      Shape700 = new ModelRenderer(this, 129, 38);
      Shape700.addBox(-5F, -2F, -7F, 10, 2, 14);
      Shape700.setRotationPoint(0F, 0F, 0F);
      Shape700.setTextureSize(64, 32);
      Shape700.mirror = true;
      setRotation(Shape700, 0F, 0F, 0F);
      Shape1500 = new ModelRenderer(this, 200, 25);
      Shape1500.addBox(-5F, -10F, -1F, 10, 12, 1);
      Shape1500.setRotationPoint(0F, 16F, -40F);
      Shape1500.setTextureSize(64, 32);
      Shape1500.mirror = true;
      setRotation(Shape1500, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape301.render(f5);
    Shape302.render(f5);
    Shape401.render(f5);
    Shape402.render(f5);
    Shape403.render(f5);
    Shape404.render(f5);
    Shape500.render(f5);
    Shape601.render(f5);
    Shape602.render(f5);
    Shape700.render(f5);
    Shape1500.render(f5);
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
