package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSolarCollectorParent extends ModelBase
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
    ModelRenderer Shape401;
    ModelRenderer Shape402;
    ModelRenderer Shape500;
  
  public ModelSolarCollectorParent()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Shape100 = new ModelRenderer(this, 0, 0);
      Shape100.addBox(-8F, 20F, -8F, 16, 4, 16);
      Shape100.setRotationPoint(0F, 0F, 0F);
      Shape100.setTextureSize(128, 64);
      Shape100.mirror = true;
      setRotation(Shape100, 0F, 0F, 0F);
      Shape201 = new ModelRenderer(this, 0, 20);
      Shape201.addBox(-3F, 10F, 6F, 6, 10, 1);
      Shape201.setRotationPoint(0F, 0F, 0F);
      Shape201.setTextureSize(128, 64);
      Shape201.mirror = true;
      setRotation(Shape201, 0F, 0F, 0F);
      Shape202 = new ModelRenderer(this, 0, 20);
      Shape202.addBox(-3F, 10F, 6F, 6, 10, 1);
      Shape202.setRotationPoint(0F, 0F, 0F);
      Shape202.setTextureSize(128, 64);
      Shape202.mirror = true;
      setRotation(Shape202, 0F, 1.570796F, 0F);
      Shape203 = new ModelRenderer(this, 0, 20);
      Shape203.addBox(-3F, 10F, 6F, 6, 10, 1);
      Shape203.setRotationPoint(0F, 0F, 0F);
      Shape203.setTextureSize(128, 64);
      Shape203.mirror = true;
      setRotation(Shape203, 0F, -3.141593F, 0F);
      Shape204 = new ModelRenderer(this, 0, 20);
      Shape204.addBox(-3F, 10F, 6F, 6, 10, 1);
      Shape204.setRotationPoint(0F, 0F, 0F);
      Shape204.setTextureSize(128, 64);
      Shape204.mirror = true;
      setRotation(Shape204, 0F, -1.570796F, 0F);
      Shape205 = new ModelRenderer(this, 15, 20);
      Shape205.addBox(-3F, 10F, 6F, 6, 10, 1);
      Shape205.setRotationPoint(0F, 0F, 0F);
      Shape205.setTextureSize(128, 64);
      Shape205.mirror = true;
      setRotation(Shape205, 0F, 0.7853982F, 0F);
      Shape206 = new ModelRenderer(this, 15, 20);
      Shape206.addBox(-3F, 10F, 6F, 6, 10, 1);
      Shape206.setRotationPoint(0F, 0F, 0F);
      Shape206.setTextureSize(128, 64);
      Shape206.mirror = true;
      setRotation(Shape206, 0F, 2.356194F, 0F);
      Shape207 = new ModelRenderer(this, 15, 20);
      Shape207.addBox(-3F, 10F, 6F, 6, 10, 1);
      Shape207.setRotationPoint(0F, 0F, 0F);
      Shape207.setTextureSize(128, 64);
      Shape207.mirror = true;
      setRotation(Shape207, 0F, -2.356194F, 0F);
      Shape208 = new ModelRenderer(this, 15, 20);
      Shape208.addBox(-3F, 10F, 6F, 6, 10, 1);
      Shape208.setRotationPoint(0F, 0F, 0F);
      Shape208.setTextureSize(128, 64);
      Shape208.mirror = true;
      setRotation(Shape208, 0F, -0.7853982F, 0F);
      Shape301 = new ModelRenderer(this, 0, 31);
      Shape301.addBox(-7F, 9F, -2F, 14, 1, 4);
      Shape301.setRotationPoint(0F, 0F, 0F);
      Shape301.setTextureSize(128, 64);
      Shape301.mirror = true;
      setRotation(Shape301, 0F, 0.7853982F, 0F);
      Shape302 = new ModelRenderer(this, 0, 31);
      Shape302.addBox(-7F, 9F, -2F, 14, 1, 4);
      Shape302.setRotationPoint(0F, 0F, 0F);
      Shape302.setTextureSize(128, 64);
      Shape302.mirror = true;
      setRotation(Shape302, 0F, -0.7853982F, 0F);
      Shape401 = new ModelRenderer(this, 0, 36);
      Shape401.addBox(-7F, 8F, -3F, 14, 2, 6);
      Shape401.setRotationPoint(0F, 0F, 0F);
      Shape401.setTextureSize(128, 64);
      Shape401.mirror = true;
      setRotation(Shape401, 0F, 0F, 0F);
      Shape402 = new ModelRenderer(this, 0, 36);
      Shape402.addBox(-7F, 8F, -3F, 14, 2, 6);
      Shape402.setRotationPoint(0F, 0F, 0F);
      Shape402.setTextureSize(128, 64);
      Shape402.mirror = true;
      setRotation(Shape402, 0F, 1.570796F, 0F);
      Shape500 = new ModelRenderer(this, 0, 44);
      Shape500.addBox(-5F, 8F, -5F, 10, 1, 10);
      Shape500.setRotationPoint(0F, 0F, 0F);
      Shape500.setTextureSize(128, 64);
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
    Shape401.render(f5);
    Shape402.render(f5);
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
