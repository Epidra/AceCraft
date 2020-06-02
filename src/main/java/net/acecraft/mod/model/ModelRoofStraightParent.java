package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRoofStraightParent extends ModelBase
{
  //fields
    ModelRenderer Shape100;
    ModelRenderer Shape200;
    ModelRenderer Shape300;
    ModelRenderer Shape400;
    ModelRenderer Shape500;
    ModelRenderer Shape600;
    ModelRenderer Shape700;
    ModelRenderer Shape800;
    ModelRenderer Shape900;
    ModelRenderer Shape1000;
    ModelRenderer Shape1100;
    ModelRenderer Shape1200;
    ModelRenderer Shape1300;
    ModelRenderer Shape1400;
    ModelRenderer Shape1500;
  
  public ModelRoofStraightParent()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Shape100 = new ModelRenderer(this, 0, 0);
      Shape100.addBox(-8F, -0.5F, -14.5F, 16, 1, 15);
      Shape100.setRotationPoint(0F, 23.5F, 7.5F);
      Shape100.setTextureSize(64, 32);
      Shape100.mirror = true;
      setRotation(Shape100, 0F, 0F, 0F);
      Shape200 = new ModelRenderer(this, 1, 1);
      Shape200.addBox(-8F, -0.5F, -13.5F, 16, 1, 14);
      Shape200.setRotationPoint(0F, 22.5F, 7.5F);
      Shape200.setTextureSize(64, 32);
      Shape200.mirror = true;
      setRotation(Shape200, 0F, 0F, 0F);
      Shape300 = new ModelRenderer(this, 2, 2);
      Shape300.addBox(-8F, -0.5F, -12.5F, 16, 1, 13);
      Shape300.setRotationPoint(0F, 21.5F, 7.5F);
      Shape300.setTextureSize(64, 32);
      Shape300.mirror = true;
      setRotation(Shape300, 0F, 0F, 0F);
      Shape400 = new ModelRenderer(this, 3, 3);
      Shape400.addBox(-8F, -0.5F, -11.5F, 16, 1, 12);
      Shape400.setRotationPoint(0F, 20.5F, 7.5F);
      Shape400.setTextureSize(64, 32);
      Shape400.mirror = true;
      setRotation(Shape400, 0F, 0F, 0F);
      Shape500 = new ModelRenderer(this, 4, 4);
      Shape500.addBox(-8F, -0.5F, -10.5F, 16, 1, 11);
      Shape500.setRotationPoint(0F, 19.5F, 7.5F);
      Shape500.setTextureSize(64, 32);
      Shape500.mirror = true;
      setRotation(Shape500, 0F, 0F, 0F);
      Shape600 = new ModelRenderer(this, 5, 5);
      Shape600.addBox(-8F, -0.5F, -9.5F, 16, 1, 10);
      Shape600.setRotationPoint(0F, 18.5F, 7.5F);
      Shape600.setTextureSize(64, 32);
      Shape600.mirror = true;
      setRotation(Shape600, 0F, 0F, 0F);
      Shape700 = new ModelRenderer(this, 6, 6);
      Shape700.addBox(-8F, -0.5F, -8.5F, 16, 1, 9);
      Shape700.setRotationPoint(0F, 17.5F, 7.5F);
      Shape700.setTextureSize(64, 32);
      Shape700.mirror = true;
      setRotation(Shape700, 0F, 0F, 0F);
      Shape800 = new ModelRenderer(this, 7, 7);
      Shape800.addBox(-8F, -0.5F, -7.5F, 16, 1, 8);
      Shape800.setRotationPoint(0F, 16.5F, 7.5F);
      Shape800.setTextureSize(64, 32);
      Shape800.mirror = true;
      setRotation(Shape800, 0F, 0F, 0F);
      Shape900 = new ModelRenderer(this, 8, 8);
      Shape900.addBox(-8F, -0.5F, -6.5F, 16, 1, 7);
      Shape900.setRotationPoint(0F, 15.5F, 7.5F);
      Shape900.setTextureSize(64, 32);
      Shape900.mirror = true;
      setRotation(Shape900, 0F, 0F, 0F);
      Shape1000 = new ModelRenderer(this, 9, 9);
      Shape1000.addBox(-8F, -0.5F, -5.5F, 16, 1, 6);
      Shape1000.setRotationPoint(0F, 14.5F, 7.5F);
      Shape1000.setTextureSize(64, 32);
      Shape1000.mirror = true;
      setRotation(Shape1000, 0F, 0F, 0F);
      Shape1100 = new ModelRenderer(this, 10, 10);
      Shape1100.addBox(-8F, -0.5F, -4.5F, 16, 1, 5);
      Shape1100.setRotationPoint(0F, 13.5F, 7.5F);
      Shape1100.setTextureSize(64, 32);
      Shape1100.mirror = true;
      setRotation(Shape1100, 0F, 0F, 0F);
      Shape1200 = new ModelRenderer(this, 11, 11);
      Shape1200.addBox(-8F, -0.5F, -3.5F, 16, 1, 4);
      Shape1200.setRotationPoint(0F, 12.5F, 7.5F);
      Shape1200.setTextureSize(64, 32);
      Shape1200.mirror = true;
      setRotation(Shape1200, 0F, 0F, 0F);
      Shape1300 = new ModelRenderer(this, 12, 12);
      Shape1300.addBox(-8F, -0.5F, -2.5F, 16, 1, 3);
      Shape1300.setRotationPoint(0F, 11.5F, 7.5F);
      Shape1300.setTextureSize(64, 32);
      Shape1300.mirror = true;
      setRotation(Shape1300, 0F, 0F, 0F);
      Shape1400 = new ModelRenderer(this, 13, 13);
      Shape1400.addBox(-8F, -0.5F, -1.5F, 16, 1, 2);
      Shape1400.setRotationPoint(0F, 10.5F, 7.5F);
      Shape1400.setTextureSize(64, 32);
      Shape1400.mirror = true;
      setRotation(Shape1400, 0F, 0F, 0F);
      Shape1500 = new ModelRenderer(this, 14, 14);
      Shape1500.addBox(-8F, -0.5F, -0.5F, 16, 1, 1);
      Shape1500.setRotationPoint(0F, 9.5F, 7.5F);
      Shape1500.setTextureSize(64, 32);
      Shape1500.mirror = true;
      setRotation(Shape1500, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape100.render(f5);
    Shape200.render(f5);
    Shape300.render(f5);
    Shape400.render(f5);
    Shape500.render(f5);
    Shape600.render(f5);
    Shape700.render(f5);
    Shape800.render(f5);
    Shape900.render(f5);
    Shape1000.render(f5);
    Shape1100.render(f5);
    Shape1200.render(f5);
    Shape1300.render(f5);
    Shape1400.render(f5);
    Shape1500.render(f5);
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
