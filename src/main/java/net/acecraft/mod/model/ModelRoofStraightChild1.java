package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRoofStraightChild1 extends ModelBase
{
  //fields
    ModelRenderer Shape1600;
    ModelRenderer Shape1701;
    ModelRenderer Shape1702;
    ModelRenderer Shape1703;
  
  public ModelRoofStraightChild1()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Shape1600 = new ModelRenderer(this, 0, 17);
      Shape1600.addBox(-8F, -1F, -23F, 16, 1, 23);
      Shape1600.setRotationPoint(0F, 9F, 8F);
      Shape1600.setTextureSize(64, 32);
      Shape1600.mirror = true;
      setRotation(Shape1600, 0.7853982F, 0F, 0F);
      Shape1701 = new ModelRenderer(this, 0, 42);
      Shape1701.addBox(-8F, -1F, -9F, 16, 1, 10);
      Shape1701.setRotationPoint(0F, 9F, 8F);
      Shape1701.setTextureSize(64, 32);
      Shape1701.mirror = true;
      setRotation(Shape1701, 0.6981317F, 0F, 0F);
      Shape1702 = new ModelRenderer(this, 0, 42);
      Shape1702.addBox(-8F, -1F, -9F, 16, 1, 10);
      Shape1702.setRotationPoint(0F, 14F, 3F);
      Shape1702.setTextureSize(64, 32);
      Shape1702.mirror = true;
      setRotation(Shape1702, 0.6981317F, 0F, 0F);
      Shape1703 = new ModelRenderer(this, 0, 42);
      Shape1703.addBox(-8F, -1F, -9F, 16, 1, 10);
      Shape1703.setRotationPoint(0F, 20F, -3F);
      Shape1703.setTextureSize(64, 32);
      Shape1703.mirror = true;
      setRotation(Shape1703, 0.6981317F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape1600.render(f5);
    Shape1701.render(f5);
    Shape1702.render(f5);
    Shape1703.render(f5);
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
