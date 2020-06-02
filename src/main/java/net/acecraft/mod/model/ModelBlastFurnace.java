package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBlastFurnace extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Shape13;
    ModelRenderer Shape14;
    ModelRenderer Shape15;
    ModelRenderer Shape16;
    ModelRenderer Shape17;
    ModelRenderer Shape18;
    ModelRenderer Shape19;
    ModelRenderer Shape20;
    ModelRenderer Shape21;
  
  public ModelBlastFurnace()
  {
    textureWidth = 512;
    textureHeight = 256;
    
      Shape1 = new ModelRenderer(this, 12, 128);
      Shape1.addBox(-21F, 0F, -21F, 42, 12, 42);
      Shape1.setRotationPoint(0F, 12F, 0F);
      Shape1.setTextureSize(512, 256);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 24, 68);
      Shape2.addBox(-18F, 0F, -18F, 36, 24, 36);
      Shape2.setRotationPoint(0F, -12F, 0F);
      Shape2.setTextureSize(512, 256);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 0);
      Shape3.addBox(-24F, 0F, -24F, 48, 20, 48);
      Shape3.setRotationPoint(0F, -32F, 0F);
      Shape3.setTextureSize(512, 256);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 200, 0);
      Shape4.addBox(-4F, 0F, -4F, 8, 36, 8);
      Shape4.setRotationPoint(-20F, -12F, -20F);
      Shape4.setTextureSize(512, 256);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 200, 0);
      Shape5.addBox(-4F, 0F, -4F, 8, 36, 8);
      Shape5.setRotationPoint(20F, -12F, -20F);
      Shape5.setTextureSize(512, 256);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 200, 0);
      Shape6.addBox(-4F, 0F, -4F, 8, 36, 8);
      Shape6.setRotationPoint(-20F, -12F, 20F);
      Shape6.setTextureSize(512, 256);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 200, 0);
      Shape7.addBox(-4F, 0F, -4F, 8, 36, 8);
      Shape7.setRotationPoint(20F, -12F, 20F);
      Shape7.setTextureSize(512, 256);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 234, 0);
      Shape8.addBox(-23F, 0F, -23F, 46, 2, 46);
      Shape8.setRotationPoint(0F, -34F, 0F);
      Shape8.setTextureSize(512, 256);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 238, 2);
      Shape9.addBox(-22F, 0F, -22F, 44, 2, 44);
      Shape9.setRotationPoint(0F, -36F, 0F);
      Shape9.setTextureSize(512, 256);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0F);
      Shape10 = new ModelRenderer(this, 242, 4);
      Shape10.addBox(-21F, 0F, -21F, 42, 2, 42);
      Shape10.setRotationPoint(0F, -38F, 0F);
      Shape10.setTextureSize(512, 256);
      Shape10.mirror = true;
      setRotation(Shape10, 0F, 0F, 0F);
      Shape11 = new ModelRenderer(this, 246, 6);
      Shape11.addBox(-20F, 0F, -20F, 40, 2, 40);
      Shape11.setRotationPoint(0F, -40F, 0F);
      Shape11.setTextureSize(512, 256);
      Shape11.mirror = true;
      setRotation(Shape11, 0F, 0F, 0F);
      Shape12 = new ModelRenderer(this, 250, 8);
      Shape12.addBox(-19F, 0F, -19F, 38, 2, 38);
      Shape12.setRotationPoint(0F, -42F, 0F);
      Shape12.setTextureSize(512, 256);
      Shape12.mirror = true;
      setRotation(Shape12, 0F, 0F, 0F);
      Shape13 = new ModelRenderer(this, 254, 10);
      Shape13.addBox(-18F, 0F, -18F, 36, 1, 36);
      Shape13.setRotationPoint(0F, -43F, 0F);
      Shape13.setTextureSize(512, 256);
      Shape13.mirror = true;
      setRotation(Shape13, 0F, 0F, 0F);
      Shape14 = new ModelRenderer(this, 258, 12);
      Shape14.addBox(-17F, 0F, -17F, 34, 1, 34);
      Shape14.setRotationPoint(0F, -44F, 0F);
      Shape14.setTextureSize(512, 256);
      Shape14.mirror = true;
      setRotation(Shape14, 0F, 0F, 0F);
      Shape15 = new ModelRenderer(this, 262, 14);
      Shape15.addBox(-16F, 0F, -16F, 32, 1, 32);
      Shape15.setRotationPoint(0F, -45F, 0F);
      Shape15.setTextureSize(512, 256);
      Shape15.mirror = true;
      setRotation(Shape15, 0F, 0F, 0F);
      Shape16 = new ModelRenderer(this, 266, 16);
      Shape16.addBox(-15F, 0F, -15F, 30, 1, 30);
      Shape16.setRotationPoint(0F, -46F, 0F);
      Shape16.setTextureSize(512, 256);
      Shape16.mirror = true;
      setRotation(Shape16, 0F, 0F, 0F);
      Shape17 = new ModelRenderer(this, 274, 20);
      Shape17.addBox(-13F, 0F, -13F, 26, 1, 26);
      Shape17.setRotationPoint(0F, -47F, 0F);
      Shape17.setTextureSize(512, 256);
      Shape17.mirror = true;
      setRotation(Shape17, 0F, 0F, 0F);
      Shape18 = new ModelRenderer(this, 282, 24);
      Shape18.addBox(-11F, 0F, -11F, 22, 1, 22);
      Shape18.setRotationPoint(0F, -48F, 0F);
      Shape18.setTextureSize(512, 256);
      Shape18.mirror = true;
      setRotation(Shape18, 0F, 0F, 0F);
      Shape19 = new ModelRenderer(this, 290, 28);
      Shape19.addBox(-9F, 0F, -9F, 18, 1, 18);
      Shape19.setRotationPoint(0F, -49F, 0F);
      Shape19.setTextureSize(512, 256);
      Shape19.mirror = true;
      setRotation(Shape19, 0F, 0F, 0F);
      Shape20 = new ModelRenderer(this, 208, 76);
      Shape20.addBox(-7F, 0F, -7F, 14, 10, 14);
      Shape20.setRotationPoint(0F, -59F, 0F);
      Shape20.setTextureSize(512, 256);
      Shape20.mirror = true;
      setRotation(Shape20, 0F, 0F, 0F);
      Shape21 = new ModelRenderer(this, 200, 52);
      Shape21.addBox(-9F, 0F, -9F, 18, 4, 18);
      Shape21.setRotationPoint(0F, -63F, 0F);
      Shape21.setTextureSize(512, 256);
      Shape21.mirror = true;
      setRotation(Shape21, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
    Shape8.render(f5);
    Shape9.render(f5);
    Shape10.render(f5);
    Shape11.render(f5);
    Shape12.render(f5);
    Shape13.render(f5);
    Shape14.render(f5);
    Shape15.render(f5);
    Shape16.render(f5);
    Shape17.render(f5);
    Shape18.render(f5);
    Shape19.render(f5);
    Shape20.render(f5);
    Shape21.render(f5);
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
