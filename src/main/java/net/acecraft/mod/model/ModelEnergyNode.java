package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEnergyNode extends ModelBase
{
  //fields
    ModelRenderer Shape100;
    ModelRenderer Shape201;
    ModelRenderer Shape202;
    ModelRenderer Shape300;
    ModelRenderer Shape400;
    ModelRenderer Shape500;
    ModelRenderer Shape601;
    ModelRenderer Shape602;
    ModelRenderer Shape701;
    ModelRenderer Shape702;
  
  public ModelEnergyNode()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Shape100 = new ModelRenderer(this, 0, 0);
      Shape100.addBox(-7F, 4F, -7F, 14, 4, 14);
      Shape100.setRotationPoint(0F, 16F, 0F);
      Shape100.setTextureSize(128, 64);
      Shape100.mirror = true;
      setRotation(Shape100, 0F, 0F, 0F);
      Shape201 = new ModelRenderer(this, 57, 0);
      Shape201.addBox(-2F, 3F, -7.5F, 4, 1, 15);
      Shape201.setRotationPoint(0F, 16F, 0F);
      Shape201.setTextureSize(128, 64);
      Shape201.mirror = true;
      setRotation(Shape201, 0F, 0.7853982F, 0F);
      Shape202 = new ModelRenderer(this, 57, 0);
      Shape202.addBox(-2F, 3F, -7.5F, 4, 1, 15);
      Shape202.setRotationPoint(0F, 16F, 0F);
      Shape202.setTextureSize(128, 64);
      Shape202.mirror = true;
      setRotation(Shape202, 0F, -0.7853982F, 0F);
      Shape300 = new ModelRenderer(this, 0, 19);
      Shape300.addBox(-3.5F, -8F, -3.5F, 7, 12, 7);
      Shape300.setRotationPoint(0F, 16F, 0F);
      Shape300.setTextureSize(128, 64);
      Shape300.mirror = true;
      setRotation(Shape300, 0F, 0F, 0F);
      Shape400 = new ModelRenderer(this, 29, 19);
      Shape400.addBox(-3F, -9F, 0F, 6, 5, 5);
      Shape400.setRotationPoint(0F, 16F, 0F);
      Shape400.setTextureSize(128, 64);
      Shape400.mirror = true;
      setRotation(Shape400, 0.4363323F, 0F, 0F);
      Shape500 = new ModelRenderer(this, 52, 19);
      Shape500.addBox(-3.5F, -11F, 0.5F, 7, 3, 3);
      Shape500.setRotationPoint(0F, 16F, 0F);
      Shape500.setTextureSize(128, 64);
      Shape500.mirror = true;
      setRotation(Shape500, 0F, 0F, 0F);
      Shape601 = new ModelRenderer(this, 29, 30);
      Shape601.addBox(-1.5F, 5F, -8F, 3, 3, 1);
      Shape601.setRotationPoint(0F, 16F, 0F);
      Shape601.setTextureSize(128, 64);
      Shape601.mirror = true;
      setRotation(Shape601, 0F, 0F, 0F);
      Shape602 = new ModelRenderer(this, 29, 30);
      Shape602.addBox(-1.5F, 5F, 7F, 3, 3, 1);
      Shape602.setRotationPoint(0F, 16F, 0F);
      Shape602.setTextureSize(128, 64);
      Shape602.mirror = true;
      setRotation(Shape602, 0F, 0F, 0F);
      Shape701 = new ModelRenderer(this, 38, 30);
      Shape701.addBox(7F, 5F, -1.5F, 1, 3, 3);
      Shape701.setRotationPoint(0F, 16F, 0F);
      Shape701.setTextureSize(128, 64);
      Shape701.mirror = true;
      setRotation(Shape701, 0F, 0F, 0F);
      Shape702 = new ModelRenderer(this, 38, 30);
      Shape702.addBox(-8F, 5F, -1.5F, 1, 3, 3);
      Shape702.setRotationPoint(0F, 16F, 0F);
      Shape702.setTextureSize(128, 64);
      Shape702.mirror = true;
      setRotation(Shape702, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape100.render(f5);
    Shape201.render(f5);
    Shape202.render(f5);
    Shape300.render(f5);
    Shape400.render(f5);
    Shape500.render(f5);
    Shape601.render(f5);
    Shape602.render(f5);
    Shape701.render(f5);
    Shape702.render(f5);
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
