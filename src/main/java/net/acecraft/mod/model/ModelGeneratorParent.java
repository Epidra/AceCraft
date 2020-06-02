package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelGeneratorParent extends ModelBase
{
  //fields
    ModelRenderer Shape101;
    ModelRenderer Shape102;
    ModelRenderer Shape103;
    ModelRenderer Shape104;
    ModelRenderer Shape200;
    ModelRenderer Shape300;
    ModelRenderer Shape401;
    ModelRenderer Shape402;
    ModelRenderer Shape500;
    ModelRenderer Shape900;
    ModelRenderer Shape1000;
    ModelRenderer Shape1300;
    ModelRenderer Shape1400;
    ModelRenderer Shape1501;
    ModelRenderer Shape1502;
    ModelRenderer Shape1600;
    ModelRenderer Shape1701;
    ModelRenderer Shape1702;
  
  public ModelGeneratorParent()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Shape101 = new ModelRenderer(this, 0, 0);
      Shape101.addBox(5F, -5F, -8F, 3, 13, 3);
      Shape101.setRotationPoint(0F, 16F, 0F);
      Shape101.setTextureSize(128, 64);
      Shape101.mirror = true;
      setRotation(Shape101, 0F, 0F, 0F);
      Shape102 = new ModelRenderer(this, 0, 0);
      Shape102.addBox(5F, -5F, 5F, 3, 13, 3);
      Shape102.setRotationPoint(0F, 16F, 0F);
      Shape102.setTextureSize(128, 64);
      Shape102.mirror = true;
      setRotation(Shape102, 0F, 0F, 0F);
      Shape103 = new ModelRenderer(this, 0, 0);
      Shape103.addBox(-8F, -5F, -8F, 3, 13, 3);
      Shape103.setRotationPoint(0F, 16F, 0F);
      Shape103.setTextureSize(128, 64);
      Shape103.mirror = true;
      setRotation(Shape103, 0F, 0F, 0F);
      Shape104 = new ModelRenderer(this, 0, 0);
      Shape104.addBox(-8F, -5F, 5F, 3, 13, 3);
      Shape104.setRotationPoint(0F, 16F, 0F);
      Shape104.setTextureSize(128, 64);
      Shape104.mirror = true;
      setRotation(Shape104, 0F, 0F, 0F);
      Shape200 = new ModelRenderer(this, 0, 17);
      Shape200.addBox(-5F, -3F, -7F, 10, 10, 1);
      Shape200.setRotationPoint(0F, 16F, 0F);
      Shape200.setTextureSize(128, 64);
      Shape200.mirror = true;
      setRotation(Shape200, 0F, 0F, 0F);
      Shape300 = new ModelRenderer(this, 0, 29);
      Shape300.addBox(-3F, -1F, -4F, 6, 2, 2);
      Shape300.setRotationPoint(0F, 16F, 0F);
      Shape300.setTextureSize(128, 64);
      Shape300.mirror = true;
      setRotation(Shape300, 0F, 0F, 0F);
      Shape401 = new ModelRenderer(this, 0, 33);
      Shape401.addBox(-5F, -1F, -4F, 2, 2, 6);
      Shape401.setRotationPoint(0F, 16F, 0F);
      Shape401.setTextureSize(128, 64);
      Shape401.mirror = true;
      setRotation(Shape401, 0F, 0F, 0F);
      Shape402 = new ModelRenderer(this, 0, 33);
      Shape402.addBox(3F, -1F, -4F, 2, 2, 6);
      Shape402.setRotationPoint(0F, 16F, 0F);
      Shape402.setTextureSize(128, 64);
      Shape402.mirror = true;
      setRotation(Shape402, 0F, 0F, 0F);
      Shape500 = new ModelRenderer(this, 17, 29);
      Shape500.addBox(-2F, -2F, -5F, 4, 4, 4);
      Shape500.setRotationPoint(0F, 16F, 0F);
      Shape500.setTextureSize(128, 64);
      Shape500.mirror = true;
      setRotation(Shape500, 0F, 0F, 0F);
      Shape900 = new ModelRenderer(this, 23, 17);
      Shape900.addBox(-5F, -3F, 6F, 10, 10, 1);
      Shape900.setRotationPoint(0F, 16F, 0F);
      Shape900.setTextureSize(128, 64);
      Shape900.mirror = true;
      setRotation(Shape900, 0F, 0F, 0F);
      Shape1000 = new ModelRenderer(this, 13, 0);
      Shape1000.addBox(-2F, -3F, 3F, 4, 10, 1);
      Shape1000.setRotationPoint(0F, 16F, 0F);
      Shape1000.setTextureSize(128, 64);
      Shape1000.mirror = true;
      setRotation(Shape1000, 0F, 0F, 0F);
      Shape1300 = new ModelRenderer(this, 13, 0);
      Shape1300.addBox(-7F, 7F, -7F, 14, 1, 14);
      Shape1300.setRotationPoint(0F, 16F, 0F);
      Shape1300.setTextureSize(128, 64);
      Shape1300.mirror = true;
      setRotation(Shape1300, 0F, 0F, 0F);
      Shape1400 = new ModelRenderer(this, 36, 32);
      Shape1400.addBox(-1.5F, 5F, -8F, 3, 3, 1);
      Shape1400.setRotationPoint(0F, 16F, 0F);
      Shape1400.setTextureSize(128, 64);
      Shape1400.mirror = true;
      setRotation(Shape1400, 0F, 0F, 0F);
      Shape1501 = new ModelRenderer(this, 37, 29);
      Shape1501.addBox(1F, 0F, -6F, 0, 1, 1);
      Shape1501.setRotationPoint(0F, 16F, 0F);
      Shape1501.setTextureSize(128, 64);
      Shape1501.mirror = true;
      setRotation(Shape1501, 0F, 0F, 0F);
      Shape1502 = new ModelRenderer(this, 37, 29);
      Shape1502.addBox(-1F, 0F, -6F, 0, 1, 1);
      Shape1502.setRotationPoint(0F, 16F, 0F);
      Shape1502.setTextureSize(128, 64);
      Shape1502.mirror = true;
      setRotation(Shape1502, 0F, 0F, 0F);
      Shape1600 = new ModelRenderer(this, 13, 0);
      Shape1600.addBox(-7F, -4F, -7F, 14, 1, 14);
      Shape1600.setRotationPoint(0F, 16F, 0F);
      Shape1600.setTextureSize(128, 64);
      Shape1600.mirror = true;
      setRotation(Shape1600, 0F, 0F, 0F);
      Shape1701 = new ModelRenderer(this, 46, 16);
      Shape1701.addBox(6F, -2F, -5F, 1, 8, 10);
      Shape1701.setRotationPoint(0F, 16F, 0F);
      Shape1701.setTextureSize(128, 64);
      Shape1701.mirror = true;
      setRotation(Shape1701, 0F, 0F, 0F);
      Shape1702 = new ModelRenderer(this, 46, 16);
      Shape1702.addBox(-7F, -2F, -5F, 1, 8, 10);
      Shape1702.setRotationPoint(0F, 16F, 0F);
      Shape1702.setTextureSize(128, 64);
      Shape1702.mirror = true;
      setRotation(Shape1702, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape101.render(f5);
    Shape102.render(f5);
    Shape103.render(f5);
    Shape104.render(f5);
    Shape200.render(f5);
    Shape300.render(f5);
    Shape401.render(f5);
    Shape402.render(f5);
    Shape500.render(f5);
    Shape900.render(f5);
    Shape1000.render(f5);
    Shape1300.render(f5);
    Shape1400.render(f5);
    Shape1501.render(f5);
    Shape1502.render(f5);
    Shape1600.render(f5);
    Shape1701.render(f5);
    Shape1702.render(f5);
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
