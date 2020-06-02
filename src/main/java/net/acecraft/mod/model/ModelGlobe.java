package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelGlobe extends ModelBase
{
  //fields
    ModelRenderer Base1;
    ModelRenderer Base2;
    ModelRenderer Base3;
    ModelRenderer CurveDown;
    ModelRenderer CurveMiddle;
    ModelRenderer CurveUp;
    ModelRenderer HoldDown;
    ModelRenderer HoldUp;
    ModelRenderer Cube;
  
  public ModelGlobe()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Base1 = new ModelRenderer(this, 28, 0);
      Base1.addBox(-4F, 0F, -4F, 8, 1, 8);
      Base1.setRotationPoint(0F, 23F, 0F);
      Base1.setTextureSize(64, 32);
      Base1.mirror = true;
      setRotation(Base1, 0F, 0F, 0F);
      Base2 = new ModelRenderer(this, 28, 9);
      Base2.addBox(-2F, 0F, -2F, 4, 1, 4);
      Base2.setRotationPoint(0F, 22F, 0F);
      Base2.setTextureSize(64, 32);
      Base2.mirror = true;
      setRotation(Base2, 0F, 0F, 0F);
      Base3 = new ModelRenderer(this, 44, 9);
      Base3.addBox(-1F, 0F, -1F, 2, 2, 2);
      Base3.setRotationPoint(0F, 20F, 0F);
      Base3.setTextureSize(64, 32);
      Base3.mirror = true;
      setRotation(Base3, 0F, 0F, 0F);
      CurveDown = new ModelRenderer(this, 0, 14);
      CurveDown.addBox(-0.5F, -1F, -6F, 1, 1, 6);
      CurveDown.setRotationPoint(0F, 21F, 0F);
      CurveDown.setTextureSize(64, 32);
      CurveDown.mirror = true;
      setRotation(CurveDown, -0.5235988F, 0F, 0F);
      CurveMiddle = new ModelRenderer(this, 14, 14);
      CurveMiddle.addBox(-0.4666667F, -10F, -1F, 1, 10, 1);
      CurveMiddle.setRotationPoint(0F, 21F, 1F);
      CurveMiddle.setTextureSize(64, 32);
      CurveMiddle.mirror = true;
      setRotation(CurveMiddle, -0.5235988F, 0F, 0F);
      CurveUp = new ModelRenderer(this, 18, 14);
      CurveUp.addBox(-0.5F, -1F, -5F, 1, 1, 7);
      CurveUp.setRotationPoint(0F, 12F, 4F);
      CurveUp.setTextureSize(64, 32);
      CurveUp.mirror = true;
      setRotation(CurveUp, -0.5235988F, 0F, 0F);
      HoldDown = new ModelRenderer(this, 34, 14);
      HoldDown.addBox(-1F, -1.5F, -1.5F, 2, 3, 2);
      HoldDown.setRotationPoint(0F, 18F, -3F);
      HoldDown.setTextureSize(64, 32);
      HoldDown.mirror = true;
      setRotation(HoldDown, -0.5235988F, 0F, 0F);
      HoldUp = new ModelRenderer(this, 34, 19);
      HoldUp.addBox(-1F, -1.5F, -2.5F, 2, 3, 2);
      HoldUp.setRotationPoint(0F, 11F, 2F);
      HoldUp.setTextureSize(64, 32);
      HoldUp.mirror = true;
      setRotation(HoldUp, -0.5235988F, 0F, 0F);
      Cube = new ModelRenderer(this, 0, 0);
      Cube.addBox(-3.5F, -3.5F, -3.5F, 7, 7, 7);
      Cube.setRotationPoint(0F, 14F, -1F);
      Cube.setTextureSize(64, 32);
      Cube.mirror = true;
      setRotation(Cube, -0.5235988F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Base1.render(f5);
    Base2.render(f5);
    Base3.render(f5);
    CurveDown.render(f5);
    CurveMiddle.render(f5);
    CurveUp.render(f5);
    HoldDown.render(f5);
    HoldUp.render(f5);
    Cube.render(f5);
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
