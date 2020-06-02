package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTurbineChild extends ModelBase
{
  //fields
    ModelRenderer Shape300;
    ModelRenderer Shape401;
    ModelRenderer Shape402;
    ModelRenderer Shape403;
    ModelRenderer Shape404;
    ModelRenderer Shape405;
    ModelRenderer Shape406;
    ModelRenderer Shape407;
    ModelRenderer Shape408;
    ModelRenderer Shape3700;
  
  public ModelTurbineChild()
  {
    textureWidth = 256;
    textureHeight = 128;
    
      Shape300 = new ModelRenderer(this, 200, 0);
      Shape300.addBox(-5F, -1F, -1F, 10, 2, 2);
      Shape300.setRotationPoint(0F, 0F, 0F);
      Shape300.setTextureSize(64, 32);
      Shape300.mirror = true;
      setRotation(Shape300, 0F, 0F, 0F);
      Shape401 = new ModelRenderer(this, 205, 4);
      Shape401.addBox(-3F, 0.5F, -0.5F, 6, 8, 1);
      Shape401.setRotationPoint(0F, 0F, 0F);
      Shape401.setTextureSize(64, 32);
      Shape401.mirror = true;
      setRotation(Shape401, 0F, 0F, 0F);
      Shape402 = new ModelRenderer(this, 205, 4);
      Shape402.addBox(-3F, 0.5F, -0.5F, 6, 8, 1);
      Shape402.setRotationPoint(0F, 0F, 0F);
      Shape402.setTextureSize(64, 32);
      Shape402.mirror = true;
      setRotation(Shape402, 0.7853982F, 0F, 0F);
      Shape403 = new ModelRenderer(this, 205, 4);
      Shape403.addBox(-3F, 0.5F, -0.5F, 6, 8, 1);
      Shape403.setRotationPoint(0F, 0F, 0F);
      Shape403.setTextureSize(64, 32);
      Shape403.mirror = true;
      setRotation(Shape403, 1.570796F, 0F, 0F);
      Shape404 = new ModelRenderer(this, 205, 4);
      Shape404.addBox(-3F, 0.5F, -0.5F, 6, 8, 1);
      Shape404.setRotationPoint(0F, 0F, 0F);
      Shape404.setTextureSize(64, 32);
      Shape404.mirror = true;
      setRotation(Shape404, 2.356194F, 0F, 0F);
      Shape405 = new ModelRenderer(this, 205, 4);
      Shape405.addBox(-3F, 0.5F, -0.5F, 6, 8, 1);
      Shape405.setRotationPoint(0F, 0F, 0F);
      Shape405.setTextureSize(64, 32);
      Shape405.mirror = true;
      setRotation(Shape405, -3.141593F, 0F, 0F);
      Shape406 = new ModelRenderer(this, 205, 4);
      Shape406.addBox(-3F, 0.5F, -0.5F, 6, 8, 1);
      Shape406.setRotationPoint(0F, 0F, 0F);
      Shape406.setTextureSize(64, 32);
      Shape406.mirror = true;
      setRotation(Shape406, -2.356194F, 0F, 0F);
      Shape407 = new ModelRenderer(this, 205, 4);
      Shape407.addBox(-3F, 0.5F, -0.5F, 6, 8, 1);
      Shape407.setRotationPoint(0F, 0F, 0F);
      Shape407.setTextureSize(64, 32);
      Shape407.mirror = true;
      setRotation(Shape407, -1.570796F, 0F, 0F);
      Shape408 = new ModelRenderer(this, 205, 4);
      Shape408.addBox(-3F, 0.5F, -0.5F, 6, 8, 1);
      Shape408.setRotationPoint(0F, 0F, 0F);
      Shape408.setTextureSize(64, 32);
      Shape408.mirror = true;
      setRotation(Shape408, -0.7853982F, 0F, 0F);
      Shape3700 = new ModelRenderer(this, 36, 13);
      Shape3700.addBox(7F, -1F, -1F, 4, 2, 2);
      Shape3700.setRotationPoint(0F, 0F, 0F);
      Shape3700.setTextureSize(64, 32);
      Shape3700.mirror = true;
      setRotation(Shape3700, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape300.render(f5);
    Shape401.render(f5);
    Shape402.render(f5);
    Shape403.render(f5);
    Shape404.render(f5);
    Shape405.render(f5);
    Shape406.render(f5);
    Shape407.render(f5);
    Shape408.render(f5);
    Shape3700.render(f5);
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
