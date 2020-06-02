package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBattery extends ModelBase
{
  //fields
    ModelRenderer Shape100;
    ModelRenderer Shape201;
    ModelRenderer Shape202;
    ModelRenderer Shape203;
    ModelRenderer Shape204;
    ModelRenderer Shape300;
    ModelRenderer Shape400;
    ModelRenderer Shape501;
    ModelRenderer Shape502;
    ModelRenderer Shape601;
    ModelRenderer Shape602;
    ModelRenderer Shape701;
    ModelRenderer Shape702;
    ModelRenderer Shape801;
    ModelRenderer Shape802;
  
  public ModelBattery()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Shape100 = new ModelRenderer(this, 0, 0);
      Shape100.addBox(-5F, 7F, -5F, 10, 1, 10);
      Shape100.setRotationPoint(0F, 16F, 0F);
      Shape100.setTextureSize(64, 32);
      Shape100.mirror = true;
      setRotation(Shape100, 0F, 0F, 0F);
      Shape201 = new ModelRenderer(this, 0, 0);
      Shape201.addBox(-3.5F, 2F, -3.5F, 2, 5, 2);
      Shape201.setRotationPoint(0F, 16F, 0F);
      Shape201.setTextureSize(64, 32);
      Shape201.mirror = true;
      setRotation(Shape201, 0F, 0F, 0F);
      Shape202 = new ModelRenderer(this, 0, 0);
      Shape202.addBox(1.5F, 2F, -3.5F, 2, 5, 2);
      Shape202.setRotationPoint(0F, 16F, 0F);
      Shape202.setTextureSize(64, 32);
      Shape202.mirror = true;
      setRotation(Shape202, 0F, 0F, 0F);
      Shape203 = new ModelRenderer(this, 0, 0);
      Shape203.addBox(-3.5F, 2F, 1.5F, 2, 5, 2);
      Shape203.setRotationPoint(0F, 16F, 0F);
      Shape203.setTextureSize(64, 32);
      Shape203.mirror = true;
      setRotation(Shape203, 0F, 0F, 0F);
      Shape204 = new ModelRenderer(this, 0, 0);
      Shape204.addBox(1.5F, 2F, 1.5F, 2, 5, 2);
      Shape204.setRotationPoint(0F, 16F, 0F);
      Shape204.setTextureSize(64, 32);
      Shape204.mirror = true;
      setRotation(Shape204, 0F, 0F, 0F);
      Shape300 = new ModelRenderer(this, 4, 11);
      Shape300.addBox(-4F, -11F, -4F, 8, 13, 8);
      Shape300.setRotationPoint(0F, 16F, 0F);
      Shape300.setTextureSize(64, 32);
      Shape300.mirror = true;
      setRotation(Shape300, 0F, 0F, 0F);
      Shape400 = new ModelRenderer(this, 37, 25);
      Shape400.addBox(-3F, -12F, -3F, 6, 1, 6);
      Shape400.setRotationPoint(0F, 16F, 0F);
      Shape400.setTextureSize(64, 32);
      Shape400.mirror = true;
      setRotation(Shape400, 0F, 0F, 0F);
      Shape501 = new ModelRenderer(this, 53, 1);
      Shape501.addBox(-1.5F, 5F, -8F, 3, 3, 2);
      Shape501.setRotationPoint(0F, 16F, 0F);
      Shape501.setTextureSize(64, 32);
      Shape501.mirror = true;
      setRotation(Shape501, 0F, 0F, 0F);
      Shape502 = new ModelRenderer(this, 53, 1);
      Shape502.addBox(-1.5F, 5F, 6F, 3, 3, 2);
      Shape502.setRotationPoint(0F, 16F, 0F);
      Shape502.setTextureSize(64, 32);
      Shape502.mirror = true;
      setRotation(Shape502, 0F, 0F, 0F);
      Shape601 = new ModelRenderer(this, 53, 7);
      Shape601.addBox(-2F, 6F, -6F, 4, 2, 1);
      Shape601.setRotationPoint(0F, 16F, 0F);
      Shape601.setTextureSize(64, 32);
      Shape601.mirror = true;
      setRotation(Shape601, 0F, 0F, 0F);
      Shape602 = new ModelRenderer(this, 53, 7);
      Shape602.addBox(-2F, 6F, 5F, 4, 2, 1);
      Shape602.setRotationPoint(0F, 16F, 0F);
      Shape602.setTextureSize(64, 32);
      Shape602.mirror = true;
      setRotation(Shape602, 0F, 0F, 0F);
      Shape701 = new ModelRenderer(this, 42, 1);
      Shape701.addBox(-8F, 5F, -1.5F, 2, 3, 3);
      Shape701.setRotationPoint(0F, 16F, 0F);
      Shape701.setTextureSize(64, 32);
      Shape701.mirror = true;
      setRotation(Shape701, 0F, 0F, 0F);
      Shape702 = new ModelRenderer(this, 42, 1);
      Shape702.addBox(6F, 5F, -1.5F, 2, 3, 3);
      Shape702.setRotationPoint(0F, 16F, 0F);
      Shape702.setTextureSize(64, 32);
      Shape702.mirror = true;
      setRotation(Shape702, 0F, 0F, 0F);
      Shape801 = new ModelRenderer(this, 42, 8);
      Shape801.addBox(-6F, 6F, -2F, 1, 2, 4);
      Shape801.setRotationPoint(0F, 16F, 0F);
      Shape801.setTextureSize(64, 32);
      Shape801.mirror = true;
      setRotation(Shape801, 0F, 0F, 0F);
      Shape802 = new ModelRenderer(this, 42, 8);
      Shape802.addBox(5F, 6F, -2F, 1, 2, 4);
      Shape802.setRotationPoint(0F, 16F, 0F);
      Shape802.setTextureSize(64, 32);
      Shape802.mirror = true;
      setRotation(Shape802, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape100.render(f5);
    Shape201.render(f5);
    Shape202.render(f5);
    Shape203.render(f5);
    Shape204.render(f5);
    Shape300.render(f5);
    Shape400.render(f5);
    Shape501.render(f5);
    Shape502.render(f5);
    Shape601.render(f5);
    Shape602.render(f5);
    Shape701.render(f5);
    Shape702.render(f5);
    Shape801.render(f5);
    Shape802.render(f5);
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
