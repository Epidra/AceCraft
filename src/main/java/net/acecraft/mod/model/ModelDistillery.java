package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDistillery extends ModelBase
{
  //fields
    ModelRenderer Shape100;
    ModelRenderer Shape200;
    ModelRenderer Shape301;
    ModelRenderer Shape302;
    ModelRenderer Shape303;
    ModelRenderer Shape304;
    ModelRenderer Shape401;
    ModelRenderer Shape402;
    ModelRenderer Shape403;
    ModelRenderer Shape404;
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
  
  public ModelDistillery()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Shape100 = new ModelRenderer(this, 0, 0);
      Shape100.addBox(-8F, -16F, -7F, 16, 16, 15);
      Shape100.setRotationPoint(0F, 24F, 0F);
      Shape100.setTextureSize(64, 32);
      Shape100.mirror = true;
      setRotation(Shape100, 0F, 0F, 0F);
      Shape200 = new ModelRenderer(this, 0, 47);
      Shape200.addBox(-2.5F, 0F, -2.5F, 5, 1, 5);
      Shape200.setRotationPoint(-16F, 23F, 0F);
      Shape200.setTextureSize(64, 32);
      Shape200.mirror = true;
      setRotation(Shape200, 0F, 0F, 0F);
      Shape301 = new ModelRenderer(this, 0, 54);
      Shape301.addBox(0F, -3F, -1F, 6, 4, 1);
      Shape301.setRotationPoint(-18.5F, 23F, -2.5F);
      Shape301.setTextureSize(64, 32);
      Shape301.mirror = true;
      setRotation(Shape301, 0F, 0F, 0F);
      Shape302 = new ModelRenderer(this, 0, 54);
      Shape302.addBox(0F, -3F, -1F, 6, 4, 1);
      Shape302.setRotationPoint(-13.5F, 23F, -2.5F);
      Shape302.setTextureSize(64, 32);
      Shape302.mirror = true;
      setRotation(Shape302, 0F, -1.570796F, 0F);
      Shape303 = new ModelRenderer(this, 0, 54);
      Shape303.addBox(0F, -3F, -1F, 6, 4, 1);
      Shape303.setRotationPoint(-13.5F, 23F, 2.5F);
      Shape303.setTextureSize(64, 32);
      Shape303.mirror = true;
      setRotation(Shape303, 0F, -3.141593F, 0F);
      Shape304 = new ModelRenderer(this, 0, 54);
      Shape304.addBox(0F, -3F, -1F, 6, 4, 1);
      Shape304.setRotationPoint(-18.5F, 23F, 2.5F);
      Shape304.setTextureSize(64, 32);
      Shape304.mirror = true;
      setRotation(Shape304, 0F, 1.570796F, 0F);
      Shape401 = new ModelRenderer(this, 0, 32);
      Shape401.addBox(-1F, 0F, -1F, 2, 6, 2);
      Shape401.setRotationPoint(-21F, 18F, -5F);
      Shape401.setTextureSize(64, 32);
      Shape401.mirror = true;
      setRotation(Shape401, 0F, 0F, 0F);
      Shape402 = new ModelRenderer(this, 0, 32);
      Shape402.addBox(-1F, 0F, -1F, 2, 6, 2);
      Shape402.setRotationPoint(-11F, 18F, -5F);
      Shape402.setTextureSize(64, 32);
      Shape402.mirror = true;
      setRotation(Shape402, 0F, 0F, 0F);
      Shape403 = new ModelRenderer(this, 0, 32);
      Shape403.addBox(-1F, 0F, -1F, 2, 6, 2);
      Shape403.setRotationPoint(-21F, 18F, 5F);
      Shape403.setTextureSize(64, 32);
      Shape403.mirror = true;
      setRotation(Shape403, 0F, 0F, 0F);
      Shape404 = new ModelRenderer(this, 0, 32);
      Shape404.addBox(-1F, 0F, -1F, 2, 6, 2);
      Shape404.setRotationPoint(-11F, 18F, 5F);
      Shape404.setTextureSize(64, 32);
      Shape404.mirror = true;
      setRotation(Shape404, 0F, 0F, 0F);
      Shape500 = new ModelRenderer(this, 0, 32);
      Shape500.addBox(-6F, -2F, -6F, 12, 2, 12);
      Shape500.setRotationPoint(-16F, 18F, 0F);
      Shape500.setTextureSize(64, 32);
      Shape500.mirror = true;
      setRotation(Shape500, 0F, 0F, 0F);
      Shape600 = new ModelRenderer(this, 63, 0);
      Shape600.addBox(-4F, -8F, -4F, 8, 13, 8);
      Shape600.setRotationPoint(-16F, 11F, 0F);
      Shape600.setTextureSize(64, 32);
      Shape600.mirror = true;
      setRotation(Shape600, 0F, 0F, 0F);
      Shape700 = new ModelRenderer(this, 96, 24);
      Shape700.addBox(-4F, 0F, -4F, 8, 4, 8);
      Shape700.setRotationPoint(0F, 4F, 0F);
      Shape700.setTextureSize(64, 32);
      Shape700.mirror = true;
      setRotation(Shape700, 0F, 0F, 0F);
      Shape800 = new ModelRenderer(this, 100, 17);
      Shape800.addBox(-3F, 0F, -3F, 6, 1, 6);
      Shape800.setRotationPoint(0F, 3F, 0F);
      Shape800.setTextureSize(64, 32);
      Shape800.mirror = true;
      setRotation(Shape800, 0F, 0F, 0F);
      Shape900 = new ModelRenderer(this, 104, 12);
      Shape900.addBox(-2F, 0F, -2F, 4, 1, 4);
      Shape900.setRotationPoint(0F, 2F, 0F);
      Shape900.setTextureSize(64, 32);
      Shape900.mirror = true;
      setRotation(Shape900, 0F, 0F, 0F);
      Shape1000 = new ModelRenderer(this, 102, 5);
      Shape1000.addBox(-2.5F, 0F, -2.5F, 5, 2, 5);
      Shape1000.setRotationPoint(0F, 0F, 0F);
      Shape1000.setTextureSize(64, 32);
      Shape1000.mirror = true;
      setRotation(Shape1000, 0F, 0F, 0F);
      Shape1100 = new ModelRenderer(this, 104, 0);
      Shape1100.addBox(-2F, 0F, -2F, 4, 1, 4);
      Shape1100.setRotationPoint(0F, -1F, 0F);
      Shape1100.setTextureSize(64, 32);
      Shape1100.mirror = true;
      setRotation(Shape1100, 0F, 0F, 0F);
      Shape1200 = new ModelRenderer(this, 68, 22);
      Shape1200.addBox(-0.5F, -5F, -0.5F, 1, 6, 1);
      Shape1200.setRotationPoint(0F, -1F, 0F);
      Shape1200.setTextureSize(64, 32);
      Shape1200.mirror = true;
      setRotation(Shape1200, 0F, 0F, -0.5235988F);
      Shape1300 = new ModelRenderer(this, 63, 22);
      Shape1300.addBox(-5F, 0F, -0.5F, 1, 17, 1);
      Shape1300.setRotationPoint(0F, -1F, 0F);
      Shape1300.setTextureSize(64, 32);
      Shape1300.mirror = true;
      setRotation(Shape1300, 0F, 0F, 1.047198F);
      Shape1400 = new ModelRenderer(this, 73, 22);
      Shape1400.addBox(-0.5F, 0F, -0.5F, 1, 4, 1);
      Shape1400.setRotationPoint(-16F, 16F, 0F);
      Shape1400.setTextureSize(64, 32);
      Shape1400.mirror = true;
      setRotation(Shape1400, 0.1487144F, -0.1115358F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape100.render(f5);
    Shape200.render(f5);
    Shape301.render(f5);
    Shape302.render(f5);
    Shape303.render(f5);
    Shape304.render(f5);
    Shape401.render(f5);
    Shape402.render(f5);
    Shape403.render(f5);
    Shape404.render(f5);
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
