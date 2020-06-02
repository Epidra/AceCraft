package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBoilerLeft1 extends ModelBase
{
  //fields
    ModelRenderer Shape100;
    ModelRenderer Shape1001;
    ModelRenderer Shape1101;
  
  public ModelBoilerLeft1()
  {
    textureWidth = 256;
    textureHeight = 128;
    
      Shape100 = new ModelRenderer(this, 0, 0);
      Shape100.addBox(-4F, -12F, -3F, 8, 24, 6);
      Shape100.setRotationPoint(-4F, 12F, -37F);
      Shape100.setTextureSize(64, 32);
      Shape100.mirror = true;
      setRotation(Shape100, 0F, 0F, 0F);
      Shape1001 = new ModelRenderer(this, 59, 72);
      Shape1001.addBox(-8F, -4F, -18F, 4, 8, 27);
      Shape1001.setRotationPoint(0F, 13F, -16F);
      Shape1001.setTextureSize(64, 32);
      Shape1001.mirror = true;
      setRotation(Shape1001, 0F, 0F, 0F);
      Shape1101 = new ModelRenderer(this, 138, 70);
      Shape1101.addBox(-8F, -12F, -7F, 1, 24, 14);
      Shape1101.setRotationPoint(0F, 12F, 0F);
      Shape1101.setTextureSize(64, 32);
      Shape1101.mirror = true;
      setRotation(Shape1101, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape100.render(f5);
    Shape1001.render(f5);
    Shape1101.render(f5);
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
