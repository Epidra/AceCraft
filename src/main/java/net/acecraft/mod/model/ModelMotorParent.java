package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMotorParent extends ModelBase
{
  //fields
    ModelRenderer Shape200;
    ModelRenderer Shape301;
    ModelRenderer Shape302;
    ModelRenderer Shape400;
    ModelRenderer Shape500;
    ModelRenderer Shape600;
  
  public ModelMotorParent()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Shape200 = new ModelRenderer(this, 0, 0);
      Shape200.addBox(-4F, -4F, -5F, 8, 12, 12);
      Shape200.setRotationPoint(0F, 16F, 0F);
      Shape200.setTextureSize(128, 64);
      Shape200.mirror = true;
      setRotation(Shape200, 0F, 0F, 0F);
      Shape301 = new ModelRenderer(this, 41, 0);
      Shape301.addBox(-7F, 0F, -5F, 3, 8, 12);
      Shape301.setRotationPoint(0F, 16F, 0F);
      Shape301.setTextureSize(128, 64);
      Shape301.mirror = true;
      setRotation(Shape301, 0F, 0F, 0F);
      Shape302 = new ModelRenderer(this, 72, 0);
      Shape302.addBox(4F, 0F, -5F, 3, 8, 12);
      Shape302.setRotationPoint(0F, 16F, 0F);
      Shape302.setTextureSize(128, 64);
      Shape302.mirror = true;
      setRotation(Shape302, 0F, 0F, 0F);
      Shape400 = new ModelRenderer(this, 42, 21);
      Shape400.addBox(-6F, -2F, -4.5F, 3, 5, 11);
      Shape400.setRotationPoint(0F, 16F, 0F);
      Shape400.setTextureSize(128, 64);
      Shape400.mirror = true;
      setRotation(Shape400, 0F, 0F, 0.4363323F);
      Shape500 = new ModelRenderer(this, 73, 21);
      Shape500.addBox(3F, -2F, -4.5F, 3, 5, 11);
      Shape500.setRotationPoint(0F, 16F, 0F);
      Shape500.setTextureSize(128, 64);
      Shape500.mirror = true;
      setRotation(Shape500, 0F, 0F, -0.4363323F);
      Shape600 = new ModelRenderer(this, 25, 30);
      Shape600.addBox(-1.5F, 5F, 7F, 3, 3, 1);
      Shape600.setRotationPoint(0F, 16F, 0F);
      Shape600.setTextureSize(128, 64);
      Shape600.mirror = true;
      setRotation(Shape600, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape200.render(f5);
    Shape301.render(f5);
    Shape302.render(f5);
    Shape400.render(f5);
    Shape500.render(f5);
    Shape600.render(f5);
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
