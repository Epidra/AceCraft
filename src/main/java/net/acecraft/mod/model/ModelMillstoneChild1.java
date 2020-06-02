package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMillstoneChild1 extends ModelBase
{
  //fields
    ModelRenderer Shape600;
  
  public ModelMillstoneChild1()
  {
    textureWidth = 256;
    textureHeight = 128;
    
      Shape600 = new ModelRenderer(this, 0, 21);
      Shape600.addBox(-4F, -20F, -4F, 8, 36, 8);
      Shape600.setRotationPoint(0F, -4F, 0F);
      Shape600.setTextureSize(64, 32);
      Shape600.mirror = true;
      setRotation(Shape600, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape600.render(f5);
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
