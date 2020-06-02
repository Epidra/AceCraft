package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelCarrot extends ModelBase
{
  //fields
    ModelRenderer Body1;
    ModelRenderer Body2;
    ModelRenderer Body3;
    ModelRenderer Body4;
    ModelRenderer Body5;
    ModelRenderer Body6;
    ModelRenderer Body7;
    ModelRenderer Hair1;
    ModelRenderer Hair2;
    ModelRenderer Hair3;
    ModelRenderer Hair4;
    ModelRenderer Hair5;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Arm1;
    ModelRenderer Arm2;
  
  public ModelCarrot()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Body1 = new ModelRenderer(this, 5, 0);
      Body1.addBox(-1F, 0F, -1F, 2, 1, 2);
      Body1.setRotationPoint(0F, 21F, 0F);
      Body1.setTextureSize(64, 32);
      Body1.mirror = true;
      setRotation(Body1, 0F, 0F, 0F);
      Body2 = new ModelRenderer(this, 10, 0);
      Body2.addBox(-1.5F, 0F, -1.5F, 3, 2, 3);
      Body2.setRotationPoint(0F, 19F, 0F);
      Body2.setTextureSize(64, 32);
      Body2.mirror = true;
      setRotation(Body2, 0F, 0F, 0F);
      Body3 = new ModelRenderer(this, 19, 1);
      Body3.addBox(-2F, 0F, -2F, 4, 2, 4);
      Body3.setRotationPoint(0F, 17F, 0F);
      Body3.setTextureSize(64, 32);
      Body3.mirror = true;
      setRotation(Body3, 0F, 0F, 0F);
      Body4 = new ModelRenderer(this, 30, 2);
      Body4.addBox(-2.5F, 0F, -2.5F, 5, 3, 5);
      Body4.setRotationPoint(0F, 14F, 0F);
      Body4.setTextureSize(64, 32);
      Body4.mirror = true;
      setRotation(Body4, 0F, 0F, 0F);
      Body5 = new ModelRenderer(this, 12, 7);
      Body5.addBox(-3F, 0F, -3F, 6, 8, 6);
      Body5.setRotationPoint(0F, 6F, 0F);
      Body5.setTextureSize(64, 32);
      Body5.mirror = true;
      setRotation(Body5, 0F, 0F, 0F);
      Body6 = new ModelRenderer(this, 36, 10);
      Body6.addBox(-2.5F, 0F, -2.5F, 5, 1, 5);
      Body6.setRotationPoint(0F, 5F, 0F);
      Body6.setTextureSize(64, 32);
      Body6.mirror = true;
      setRotation(Body6, 0F, 0F, 0F);
      Body7 = new ModelRenderer(this, 36, 16);
      Body7.addBox(-2F, 0F, -2F, 4, 1, 4);
      Body7.setRotationPoint(0F, 4F, 0F);
      Body7.setTextureSize(64, 32);
      Body7.mirror = true;
      setRotation(Body7, 0F, 0F, 0F);
      Hair1 = new ModelRenderer(this, 0, 0);
      Hair1.addBox(-0.5F, -2F, -0.5F, 1, 3, 1);
      Hair1.setRotationPoint(0F, 4F, 0F);
      Hair1.setTextureSize(64, 32);
      Hair1.mirror = true;
      setRotation(Hair1, 0.7435722F, -1.041001F, 0F);
      Hair2 = new ModelRenderer(this, 0, 0);
      Hair2.addBox(-0.5F, -2F, -0.5F, 1, 3, 1);
      Hair2.setRotationPoint(0F, 4F, 0F);
      Hair2.setTextureSize(64, 32);
      Hair2.mirror = true;
      setRotation(Hair2, 1.07818F, 0.5948578F, 0F);
      Hair3 = new ModelRenderer(this, 0, 0);
      Hair3.addBox(-0.5F, -2F, -0.5F, 1, 3, 1);
      Hair3.setRotationPoint(0F, 4F, 0F);
      Hair3.setTextureSize(64, 32);
      Hair3.mirror = true;
      setRotation(Hair3, 0.2602503F, -2.862753F, 0F);
      Hair4 = new ModelRenderer(this, 0, 0);
      Hair4.addBox(-0.5F, -2F, -0.5F, 1, 3, 1);
      Hair4.setRotationPoint(0F, 4F, 0F);
      Hair4.setTextureSize(64, 32);
      Hair4.mirror = true;
      setRotation(Hair4, 1.115358F, 1.858931F, 0F);
      Hair5 = new ModelRenderer(this, 0, 0);
      Hair5.addBox(-0.5F, -2F, -0.5F, 1, 3, 1);
      Hair5.setRotationPoint(0F, 4F, 0F);
      Hair5.setTextureSize(64, 32);
      Hair5.mirror = true;
      setRotation(Hair5, -0.0371786F, -0.1115358F, 0F);
      Leg1 = new ModelRenderer(this, 0, 10);
      Leg1.addBox(0F, 0F, -1F, 1, 8, 2);
      Leg1.setRotationPoint(1.5F, 16F, 0F);
      Leg1.setTextureSize(64, 32);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0F, 0F);
      Leg2 = new ModelRenderer(this, 0, 10);
      Leg2.addBox(-1F, 0F, -1F, 1, 8, 2);
      Leg2.setRotationPoint(-1.5F, 16F, 0F);
      Leg2.setTextureSize(64, 32);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, 0F, 0F);
      Arm1 = new ModelRenderer(this, 0, 22);
      Arm1.addBox(0F, 0F, -1F, 1, 6, 2);
      Arm1.setRotationPoint(3F, 11F, 0F);
      Arm1.setTextureSize(64, 32);
      Arm1.mirror = true;
      setRotation(Arm1, 0F, 0F, 0F);
      Arm2 = new ModelRenderer(this, 0, 22);
      Arm2.addBox(-1F, 0F, -1F, 1, 6, 2);
      Arm2.setRotationPoint(-3F, 11F, 0F);
      Arm2.setTextureSize(64, 32);
      Arm2.mirror = true;
      setRotation(Arm2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Body1.render(f5);
    Body2.render(f5);
    Body3.render(f5);
    Body4.render(f5);
    Body5.render(f5);
    Body6.render(f5);
    Body7.render(f5);
    Hair1.render(f5);
    Hair2.render(f5);
    Hair3.render(f5);
    Hair4.render(f5);
    Hair5.render(f5);
    Leg1.render(f5);
    Leg2.render(f5);
    Arm1.render(f5);
    Arm2.render(f5);
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
    this.Leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.Leg1.rotateAngleY = 0.0F;
    this.Leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.Leg2.rotateAngleY = 0.0F;
    this.Arm1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.Arm1.rotateAngleY = 0.0F;
    this.Arm2.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.Arm2.rotateAngleY = 0.0F;
  }

}
