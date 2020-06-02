package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelIngotBasinParent extends ModelBase
{
  //fields
    ModelRenderer Shape100;
    ModelRenderer Shape201;
    ModelRenderer Shape202;
    ModelRenderer Shape301;
    ModelRenderer Shape302;
    ModelRenderer Shape400;
    ModelRenderer Shape501;
    ModelRenderer Shape502;
  
  public ModelIngotBasinParent()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Shape100 = new ModelRenderer(this, 34, 0);
      Shape100.addBox(-7F, 7F, -7F, 14, 1, 28);
      Shape100.setRotationPoint(0F, 16F, 0F);
      Shape100.setTextureSize(128, 64);
      Shape100.mirror = true;
      setRotation(Shape100, 0F, 0F, 0F);
      Shape201 = new ModelRenderer(this, 0, 0);
      Shape201.addBox(-7F, -4F, -7F, 14, 11, 1);
      Shape201.setRotationPoint(0F, 16F, 0F);
      Shape201.setTextureSize(128, 64);
      Shape201.mirror = true;
      setRotation(Shape201, 0F, 0F, 0F);
      Shape202 = new ModelRenderer(this, 0, 0);
      Shape202.addBox(-7F, -4F, 20F, 14, 11, 1);
      Shape202.setRotationPoint(0F, 16F, 0F);
      Shape202.setTextureSize(128, 64);
      Shape202.mirror = true;
      setRotation(Shape202, 0F, 0F, 0F);
      Shape301 = new ModelRenderer(this, 5, 4);
      Shape301.addBox(-7F, -4F, -6F, 1, 11, 26);
      Shape301.setRotationPoint(0F, 16F, 0F);
      Shape301.setTextureSize(128, 64);
      Shape301.mirror = true;
      setRotation(Shape301, 0F, 0F, 0F);
      Shape302 = new ModelRenderer(this, 5, 4);
      Shape302.addBox(6F, -4F, -6F, 1, 11, 26);
      Shape302.setRotationPoint(0F, 16F, 0F);
      Shape302.setTextureSize(128, 64);
      Shape302.mirror = true;
      setRotation(Shape302, 0F, 0F, 0F);
      Shape400 = new ModelRenderer(this, 1, 42);
      Shape400.addBox(-2F, -1F, 19F, 4, 1, 7);
      Shape400.setRotationPoint(0F, 16F, 0F);
      Shape400.setTextureSize(128, 64);
      Shape400.mirror = true;
      setRotation(Shape400, 0.1745329F, 0F, 0F);
      Shape501 = new ModelRenderer(this, 24, 42);
      Shape501.addBox(2F, -3F, 19F, 1, 3, 7);
      Shape501.setRotationPoint(0F, 16F, 0F);
      Shape501.setTextureSize(128, 64);
      Shape501.mirror = true;
      setRotation(Shape501, 0.1745329F, 0F, 0F);
      Shape502 = new ModelRenderer(this, 24, 42);
      Shape502.addBox(-3F, -3F, 19F, 1, 3, 7);
      Shape502.setRotationPoint(0F, 16F, 0F);
      Shape502.setTextureSize(128, 64);
      Shape502.mirror = true;
      setRotation(Shape502, 0.1745329F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape100.render(f5);
    Shape201.render(f5);
    Shape202.render(f5);
    Shape301.render(f5);
    Shape302.render(f5);
    Shape400.render(f5);
    Shape501.render(f5);
    Shape502.render(f5);
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
