package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBoilerRight1 extends ModelBase
{
  //fields
    ModelRenderer Shape200;
    ModelRenderer Shape1002;
    ModelRenderer Shape1102;
  
  public ModelBoilerRight1()
  {
    textureWidth = 256;
    textureHeight = 128;
    
      Shape200 = new ModelRenderer(this, 28, 0);
      Shape200.addBox(-4F, -12F, -3F, 8, 24, 6);
      Shape200.setRotationPoint(4F, 12F, -37F);
      Shape200.setTextureSize(64, 32);
      Shape200.mirror = true;
      setRotation(Shape200, 0F, 0F, 0F);
      Shape1002 = new ModelRenderer(this, 59, 72);
      Shape1002.addBox(4F, -4F, -18F, 4, 8, 27);
      Shape1002.setRotationPoint(0F, 13F, -16F);
      Shape1002.setTextureSize(64, 32);
      Shape1002.mirror = true;
      setRotation(Shape1002, 0F, 0F, 0F);
      Shape1102 = new ModelRenderer(this, 138, 70);
      Shape1102.addBox(7F, -12F, -7F, 1, 24, 14);
      Shape1102.setRotationPoint(0F, 12F, 0F);
      Shape1102.setTextureSize(64, 32);
      Shape1102.mirror = true;
      setRotation(Shape1102, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape200.render(f5);
    Shape1002.render(f5);
    Shape1102.render(f5);
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
