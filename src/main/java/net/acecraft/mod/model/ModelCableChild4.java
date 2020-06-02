package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCableChild4 extends ModelBase
{
  //fields
    ModelRenderer Shape302;
  
  public ModelCableChild4()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Shape302 = new ModelRenderer(this, 0, 10);
      Shape302.addBox(-1.5F, 5F, -8F, 3, 3, 7);
      Shape302.setRotationPoint(0F, 16F, 0F);
      Shape302.setTextureSize(64, 32);
      Shape302.mirror = true;
      setRotation(Shape302, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape302.render(f5);
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
