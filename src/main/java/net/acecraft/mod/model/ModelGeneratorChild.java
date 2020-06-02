package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelGeneratorChild extends ModelBase
{
  //fields
    ModelRenderer Shape600;
    ModelRenderer Shape700;
    ModelRenderer Shape800;
    ModelRenderer Shape1100;
    ModelRenderer Shape1200;
  
  public ModelGeneratorChild()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Shape600 = new ModelRenderer(this, 0, 42);
      Shape600.addBox(-2F, -1F, 1.5F, 4, 2, 1);
      Shape600.setRotationPoint(0F, 0F, 0F);
      Shape600.setTextureSize(64, 32);
      Shape600.mirror = true;
      setRotation(Shape600, 0F, 0F, -0.0197253F);
      Shape700 = new ModelRenderer(this, 0, 46);
      Shape700.addBox(-2F, -1F, -0.5F, 1, 2, 2);
      Shape700.setRotationPoint(0F, 0F, 0F);
      Shape700.setTextureSize(64, 32);
      Shape700.mirror = true;
      setRotation(Shape700, 0F, 0F, 0F);
      Shape800 = new ModelRenderer(this, 6, 46);
      Shape800.addBox(1F, -1F, -0.5F, 1, 2, 2);
      Shape800.setRotationPoint(0F, 0F, 0F);
      Shape800.setTextureSize(64, 32);
      Shape800.mirror = true;
      setRotation(Shape800, 0F, 0F, 0F);
      Shape1100 = new ModelRenderer(this, 19, 38);
      Shape1100.addBox(-1F, -1F, 2.5F, 2, 2, 4);
      Shape1100.setRotationPoint(0F, 0F, 0F);
      Shape1100.setTextureSize(64, 32);
      Shape1100.mirror = true;
      setRotation(Shape1100, 0F, 0F, 0F);
      Shape1200 = new ModelRenderer(this, 32, 38);
      Shape1200.addBox(-2F, -2F, 7F, 4, 4, 1);
      Shape1200.setRotationPoint(0F, 0F, 0F);
      Shape1200.setTextureSize(64, 32);
      Shape1200.mirror = true;
      setRotation(Shape1200, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape600.render(f5);
    Shape700.render(f5);
    Shape800.render(f5);
    Shape1100.render(f5);
    Shape1200.render(f5);
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
