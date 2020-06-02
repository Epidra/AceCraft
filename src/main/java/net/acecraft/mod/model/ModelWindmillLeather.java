package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelWindmillLeather extends ModelBase
{
  //fields
    ModelRenderer Shape100;
    ModelRenderer Shape201;
    ModelRenderer Shape202;
    ModelRenderer Shape203;
    ModelRenderer Shape204;
    ModelRenderer Shape205;
    ModelRenderer Shape206;
    ModelRenderer Shape207;
    ModelRenderer Shape208;
    ModelRenderer Shape301;
    ModelRenderer Shape302;
    ModelRenderer Shape303;
    ModelRenderer Shape304;
    ModelRenderer Shape400;
    ModelRenderer Shape500;
  
  public ModelWindmillLeather()
  {
    textureWidth = 256;
    textureHeight = 128;
    
      Shape100 = new ModelRenderer(this, 0, 0);
      Shape100.addBox(-5F, -44F, -5F, 10, 68, 10);
      Shape100.setRotationPoint(0F, 0F, 0F);
      Shape100.setTextureSize(256, 128);
      Shape100.mirror = true;
      setRotation(Shape100, 0F, 0F, 0F);
      Shape201 = new ModelRenderer(this, 41, 0);
      Shape201.addBox(5F, 3F, -2F, 30, 4, 4);
      Shape201.setRotationPoint(0F, 0F, 0F);
      Shape201.setTextureSize(256, 128);
      Shape201.mirror = true;
      setRotation(Shape201, -0.0872665F, 0F, 0F);
      Shape202 = new ModelRenderer(this, 41, 0);
      Shape202.addBox(5F, 3F, -2F, 30, 4, 4);
      Shape202.setRotationPoint(0F, 0F, 0F);
      Shape202.setTextureSize(256, 128);
      Shape202.mirror = true;
      setRotation(Shape202, -0.0872665F, 1.570796F, 0F);
      Shape203 = new ModelRenderer(this, 41, 0);
      Shape203.addBox(5F, 3F, -2F, 30, 4, 4);
      Shape203.setRotationPoint(0F, 0F, 0F);
      Shape203.setTextureSize(256, 128);
      Shape203.mirror = true;
      setRotation(Shape203, -0.0872665F, -3.141593F, 0F);
      Shape204 = new ModelRenderer(this, 41, 0);
      Shape204.addBox(5F, 3F, -2F, 30, 4, 4);
      Shape204.setRotationPoint(0F, 0F, 0F);
      Shape204.setTextureSize(256, 128);
      Shape204.mirror = true;
      setRotation(Shape204, -0.0872665F, -1.570796F, 0F);
      Shape205 = new ModelRenderer(this, 41, 0);
      Shape205.addBox(5F, -41F, -4F, 30, 4, 4);
      Shape205.setRotationPoint(0F, 0F, 0F);
      Shape205.setTextureSize(256, 128);
      Shape205.mirror = true;
      setRotation(Shape205, -0.0872665F, 0F, 0F);
      Shape206 = new ModelRenderer(this, 41, 0);
      Shape206.addBox(5F, -41F, -4F, 30, 4, 4);
      Shape206.setRotationPoint(0F, 0F, 0F);
      Shape206.setTextureSize(256, 128);
      Shape206.mirror = true;
      setRotation(Shape206, -0.0872665F, 1.570796F, 0F);
      Shape207 = new ModelRenderer(this, 41, 0);
      Shape207.addBox(5F, -41F, -4F, 30, 4, 4);
      Shape207.setRotationPoint(0F, 0F, 0F);
      Shape207.setTextureSize(256, 128);
      Shape207.mirror = true;
      setRotation(Shape207, -0.0872665F, -3.141593F, 0F);
      Shape208 = new ModelRenderer(this, 41, 0);
      Shape208.addBox(5F, -41F, -4F, 30, 4, 4);
      Shape208.setRotationPoint(0F, 0F, 0F);
      Shape208.setTextureSize(256, 128);
      Shape208.mirror = true;
      setRotation(Shape208, -0.0872665F, -1.570796F, 0F);
      Shape301 = new ModelRenderer(this, 41, 9);
      Shape301.addBox(7F, -37F, -1.5F, 26, 40, 1);
      Shape301.setRotationPoint(0F, 0F, 0F);
      Shape301.setTextureSize(256, 128);
      Shape301.mirror = true;
      setRotation(Shape301, -0.0872665F, 0F, 0F);
      Shape302 = new ModelRenderer(this, 41, 9);
      Shape302.addBox(7F, -37F, -1.5F, 26, 40, 1);
      Shape302.setRotationPoint(0F, 0F, 0F);
      Shape302.setTextureSize(256, 128);
      Shape302.mirror = true;
      setRotation(Shape302, -0.0872665F, 1.570796F, 0F);
      Shape303 = new ModelRenderer(this, 41, 9);
      Shape303.addBox(7F, -37F, -1.5F, 26, 40, 1);
      Shape303.setRotationPoint(0F, 0F, 0F);
      Shape303.setTextureSize(256, 128);
      Shape303.mirror = true;
      setRotation(Shape303, -0.0872665F, -3.141593F, 0F);
      Shape304 = new ModelRenderer(this, 41, 9);
      Shape304.addBox(7F, -37F, -1.5F, 26, 40, 1);
      Shape304.setRotationPoint(0F, 0F, 0F);
      Shape304.setTextureSize(256, 128);
      Shape304.mirror = true;
      setRotation(Shape304, -0.0872665F, -1.570796F, 0F);
      Shape400 = new ModelRenderer(this, 41, 51);
      Shape400.addBox(-4F, -45F, -4F, 8, 1, 8);
      Shape400.setRotationPoint(0F, 0F, 0F);
      Shape400.setTextureSize(256, 128);
      Shape400.mirror = true;
      setRotation(Shape400, 0F, 0F, 0F);
      Shape500 = new ModelRenderer(this, 41, 61);
      Shape500.addBox(-2F, -46F, -2F, 4, 1, 4);
      Shape500.setRotationPoint(0F, 0F, 0F);
      Shape500.setTextureSize(256, 128);
      Shape500.mirror = true;
      setRotation(Shape500, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape100.render(f5);
    Shape201.render(f5);
    Shape202.render(f5);
    Shape203.render(f5);
    Shape204.render(f5);
    Shape205.render(f5);
    Shape206.render(f5);
    Shape207.render(f5);
    Shape208.render(f5);
    Shape301.render(f5);
    Shape302.render(f5);
    Shape303.render(f5);
    Shape304.render(f5);
    Shape400.render(f5);
    Shape500.render(f5);
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
