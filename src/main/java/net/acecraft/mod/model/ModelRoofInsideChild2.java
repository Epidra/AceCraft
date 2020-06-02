package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRoofInsideChild2 extends ModelBase
{
  //fields
    ModelRenderer Shape3501;
  
  public ModelRoofInsideChild2()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Shape3501 = new ModelRenderer(this, 0, 54);
      Shape3501.addBox(-8F, -1F, -1F, 16, 2, 1);
      Shape3501.setRotationPoint(0F, 8F, 8F);
      Shape3501.setTextureSize(64, 32);
      Shape3501.mirror = true;
      setRotation(Shape3501, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape3501.render(f5);
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
