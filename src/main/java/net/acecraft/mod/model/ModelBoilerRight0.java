package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBoilerRight0 extends ModelBase
{
  //fields
    ModelRenderer Shape1202;
    ModelRenderer Shape1302;
    ModelRenderer Shape1402;
  
  public ModelBoilerRight0()
  {
    textureWidth = 256;
    textureHeight = 128;
    
      Shape1202 = new ModelRenderer(this, 30, 30);
      Shape1202.addBox(-2F, -6.2F, -7.5F, 7, 4, 5);
      Shape1202.setRotationPoint(0F, 6F, -32F);
      Shape1202.setTextureSize(64, 32);
      Shape1202.mirror = true;
      setRotation(Shape1202, 0F, 0F, 0.7853982F);
      Shape1302 = new ModelRenderer(this, 28, 50);
      Shape1302.addBox(-4F, -7F, -3F, 8, 19, 6);
      Shape1302.setRotationPoint(4F, 12F, -37F);
      Shape1302.setTextureSize(64, 32);
      Shape1302.mirror = true;
      setRotation(Shape1302, 0F, 0F, 0F);
      Shape1402 = new ModelRenderer(this, 32, 39);
      Shape1402.addBox(0F, -12F, -3F, 4, 5, 6);
      Shape1402.setRotationPoint(0F, 12F, -37F);
      Shape1402.setTextureSize(64, 32);
      Shape1402.mirror = true;
      setRotation(Shape1402, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape1202.render(f5);
    Shape1302.render(f5);
    Shape1402.render(f5);
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
