package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBellowsChild4 extends ModelBase
{
  //fields
    ModelRenderer Shape704;
  
  public ModelBellowsChild4()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Shape704 = new ModelRenderer(this, 65, 0);
      Shape704.addBox(-18F, -1F, -5F, 18, 2, 10);
      Shape704.setRotationPoint(15F, 17F, 0F);
      Shape704.setTextureSize(64, 32);
      Shape704.mirror = true;
      setRotation(Shape704, 0F, 0F, 0.2617994F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape704.render(f5);
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
