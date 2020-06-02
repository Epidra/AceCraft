package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRoofOutsideParent extends ModelBase
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
  
  public ModelRoofOutsideParent()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Shape100 = new ModelRenderer(this, 1, 0);
      Shape100.addBox(-14F, 0F, -14F, 15, 1, 15);
      Shape100.setRotationPoint(7F, 23F, 7F);
      Shape100.setTextureSize(128, 64);
      Shape100.mirror = true;
      setRotation(Shape100, 0F, 0F, 0F);
      Shape200 = new ModelRenderer(this, 3, 1);
      Shape200.addBox(-13F, 0F, -13F, 14, 1, 14);
      Shape200.setRotationPoint(7F, 22F, 7F);
      Shape200.setTextureSize(128, 64);
      Shape200.mirror = true;
      setRotation(Shape200, 0F, 0F, 0F);
      Shape300 = new ModelRenderer(this, 5, 2);
      Shape300.addBox(-12F, 0F, -12F, 13, 1, 13);
      Shape300.setRotationPoint(7F, 21F, 7F);
      Shape300.setTextureSize(128, 64);
      Shape300.mirror = true;
      setRotation(Shape300, 0F, 0F, 0F);
      Shape400 = new ModelRenderer(this, 7, 3);
      Shape400.addBox(-11F, 0F, -11F, 12, 1, 12);
      Shape400.setRotationPoint(7F, 20F, 7F);
      Shape400.setTextureSize(128, 64);
      Shape400.mirror = true;
      setRotation(Shape400, 0F, 0F, 0F);
      Shape500 = new ModelRenderer(this, 9, 4);
      Shape500.addBox(-10F, 0F, -10F, 11, 1, 11);
      Shape500.setRotationPoint(7F, 19F, 7F);
      Shape500.setTextureSize(128, 64);
      Shape500.mirror = true;
      setRotation(Shape500, 0F, 0F, 0F);
      Shape600 = new ModelRenderer(this, 11, 5);
      Shape600.addBox(-9F, 0F, -9F, 10, 1, 10);
      Shape600.setRotationPoint(7F, 18F, 7F);
      Shape600.setTextureSize(128, 64);
      Shape600.mirror = true;
      setRotation(Shape600, 0F, 0F, 0F);
      Shape700 = new ModelRenderer(this, 13, 6);
      Shape700.addBox(-8F, 0F, -8F, 9, 1, 9);
      Shape700.setRotationPoint(7F, 17F, 7F);
      Shape700.setTextureSize(128, 64);
      Shape700.mirror = true;
      setRotation(Shape700, 0F, 0F, 0F);
      Shape800 = new ModelRenderer(this, 15, 7);
      Shape800.addBox(-7F, 0F, -7F, 8, 1, 8);
      Shape800.setRotationPoint(7F, 16F, 7F);
      Shape800.setTextureSize(128, 64);
      Shape800.mirror = true;
      setRotation(Shape800, 0F, 0F, 0F);
      Shape900 = new ModelRenderer(this, 17, 8);
      Shape900.addBox(-6F, 0F, -6F, 7, 1, 7);
      Shape900.setRotationPoint(7F, 15F, 7F);
      Shape900.setTextureSize(128, 64);
      Shape900.mirror = true;
      setRotation(Shape900, 0F, 0F, 0F);
      Shape1000 = new ModelRenderer(this, 19, 9);
      Shape1000.addBox(-5F, 0F, -5F, 6, 1, 6);
      Shape1000.setRotationPoint(7F, 14F, 7F);
      Shape1000.setTextureSize(128, 64);
      Shape1000.mirror = true;
      setRotation(Shape1000, 0F, 0F, 0F);
      Shape1100 = new ModelRenderer(this, 21, 10);
      Shape1100.addBox(-4F, 0F, -4F, 5, 1, 5);
      Shape1100.setRotationPoint(7F, 13F, 7F);
      Shape1100.setTextureSize(128, 64);
      Shape1100.mirror = true;
      setRotation(Shape1100, 0F, 0F, 0F);
      Shape1200 = new ModelRenderer(this, 23, 11);
      Shape1200.addBox(-3F, 0F, -3F, 4, 1, 4);
      Shape1200.setRotationPoint(7F, 12F, 7F);
      Shape1200.setTextureSize(128, 64);
      Shape1200.mirror = true;
      setRotation(Shape1200, 0F, 0F, 0F);
      Shape1300 = new ModelRenderer(this, 25, 12);
      Shape1300.addBox(-2F, 0F, -2F, 3, 1, 3);
      Shape1300.setRotationPoint(7F, 11F, 7F);
      Shape1300.setTextureSize(128, 64);
      Shape1300.mirror = true;
      setRotation(Shape1300, 0F, 0F, 0F);
      Shape1400 = new ModelRenderer(this, 27, 13);
      Shape1400.addBox(-1F, 0F, -1F, 2, 1, 2);
      Shape1400.setRotationPoint(7F, 10F, 7F);
      Shape1400.setTextureSize(128, 64);
      Shape1400.mirror = true;
      setRotation(Shape1400, 0F, 0F, 0F);
      Shape1500 = new ModelRenderer(this, 29, 14);
      Shape1500.addBox(0F, 0F, 0F, 1, 1, 1);
      Shape1500.setRotationPoint(7F, 9F, 7F);
      Shape1500.setTextureSize(128, 64);
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
