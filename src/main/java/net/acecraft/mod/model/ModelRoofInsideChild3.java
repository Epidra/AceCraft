package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRoofInsideChild3 extends ModelBase
{
  //fields
    ModelRenderer Shape3502;
  
  public ModelRoofInsideChild3()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Shape3502 = new ModelRenderer(this, 0, 54);
      Shape3502.addBox(-8F, -1F, -1F, 16, 2, 1);
      Shape3502.setRotationPoint(8F, 8F, 0F);
      Shape3502.setTextureSize(64, 32);
      Shape3502.mirror = true;
      setRotation(Shape3502, 0F, 1.570796F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape3502.render(f5);
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
