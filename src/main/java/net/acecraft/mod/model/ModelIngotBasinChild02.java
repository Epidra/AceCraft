package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelIngotBasinChild02 extends ModelBase
{
  //fields
    ModelRenderer Shape602;
  
  public ModelIngotBasinChild02()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Shape602 = new ModelRenderer(this, 50, 35);
      Shape602.addBox(-6F, 5F, -6F, 12, 1, 26);
      Shape602.setRotationPoint(0F, 16F, 0F);
      Shape602.setTextureSize(64, 32);
      Shape602.mirror = true;
      setRotation(Shape602, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape602.render(f5);
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
