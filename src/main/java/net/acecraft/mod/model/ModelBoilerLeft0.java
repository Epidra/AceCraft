package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBoilerLeft0 extends ModelBase
{
  //fields
    ModelRenderer Shape1201;
    ModelRenderer Shape1301;
    ModelRenderer Shape1401;
  
  public ModelBoilerLeft0()
  {
    textureWidth = 256;
    textureHeight = 128;
    
      Shape1201 = new ModelRenderer(this, 2, 30);
      Shape1201.addBox(-5F, -6.2F, -7.5F, 7, 4, 5);
      Shape1201.setRotationPoint(0F, 6F, -32F);
      Shape1201.setTextureSize(64, 32);
      Shape1201.mirror = true;
      setRotation(Shape1201, 0F, 0F, -0.7853982F);
      Shape1301 = new ModelRenderer(this, 0, 50);
      Shape1301.addBox(-4F, -7F, -3F, 8, 19, 6);
      Shape1301.setRotationPoint(-4F, 12F, -37F);
      Shape1301.setTextureSize(64, 32);
      Shape1301.mirror = true;
      setRotation(Shape1301, 0F, 0F, 0F);
      Shape1401 = new ModelRenderer(this, 4, 39);
      Shape1401.addBox(0F, -12F, -3F, 4, 5, 6);
      Shape1401.setRotationPoint(-4F, 12F, -37F);
      Shape1401.setTextureSize(64, 32);
      Shape1401.mirror = true;
      setRotation(Shape1401, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape1201.render(f5);
    Shape1301.render(f5);
    Shape1401.render(f5);
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
