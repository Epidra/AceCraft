package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCableChild3 extends ModelBase
{
  //fields
    ModelRenderer Shape301;
  
  public ModelCableChild3()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Shape301 = new ModelRenderer(this, 0, 10);
      Shape301.addBox(-1.5F, 5F, 1F, 3, 3, 7);
      Shape301.setRotationPoint(0F, 16F, 0F);
      Shape301.setTextureSize(64, 32);
      Shape301.mirror = true;
      setRotation(Shape301, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape301.render(f5);
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
