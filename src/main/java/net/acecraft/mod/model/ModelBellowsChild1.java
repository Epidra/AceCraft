package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBellowsChild1 extends ModelBase
{
  //fields
    ModelRenderer Shape100;
    ModelRenderer Shape1100;
  
  public ModelBellowsChild1()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Shape100 = new ModelRenderer(this, 0, 41);
      Shape100.addBox(-2F, -2F, -10F, 4, 4, 19);
      Shape100.setRotationPoint(0F, 0F, 0F);
      Shape100.setTextureSize(64, 32);
      Shape100.mirror = true;
      setRotation(Shape100, 0F, 0F, -1.570796F);
      Shape1100 = new ModelRenderer(this, 44, 14);
      Shape1100.addBox(-1.5F, -14F, -3F, 3, 28, 6);
      Shape1100.setRotationPoint(0F, 0F, 0F);
      Shape1100.setTextureSize(64, 32);
      Shape1100.mirror = true;
      setRotation(Shape1100, 0F, 0F, -1.570796F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape100.render(f5);
    Shape1100.render(f5);
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
