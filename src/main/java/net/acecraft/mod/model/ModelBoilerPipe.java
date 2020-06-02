package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBoilerPipe extends ModelBase
{
  //fields
    ModelRenderer Shape801;
    ModelRenderer Shape802;
    ModelRenderer Shape803;
    ModelRenderer Shape804;
    ModelRenderer Shape805;
    ModelRenderer Shape806;
    ModelRenderer Shape807;
    ModelRenderer Shape808;
    ModelRenderer Shape901;
    ModelRenderer Shape902;
    ModelRenderer Shape903;
    ModelRenderer Shape904;
    ModelRenderer Shape1600;
  
  public ModelBoilerPipe()
  {
    textureWidth = 256;
    textureHeight = 128;
    
      Shape801 = new ModelRenderer(this, 200, 0);
      Shape801.addBox(-2.5F, -5F, 4F, 5, 6, 1);
      Shape801.setRotationPoint(0F, -3F, 0F);
      Shape801.setTextureSize(64, 32);
      Shape801.mirror = true;
      setRotation(Shape801, 0F, 0F, 0F);
      Shape802 = new ModelRenderer(this, 212, 0);
      Shape802.addBox(-2F, -5F, 4F, 4, 6, 1);
      Shape802.setRotationPoint(0F, -3F, 0F);
      Shape802.setTextureSize(64, 32);
      Shape802.mirror = true;
      setRotation(Shape802, 0F, 0.7853982F, 0F);
      Shape803 = new ModelRenderer(this, 200, 0);
      Shape803.addBox(-2.5F, -5F, 4F, 5, 6, 1);
      Shape803.setRotationPoint(0F, -3F, 0F);
      Shape803.setTextureSize(64, 32);
      Shape803.mirror = true;
      setRotation(Shape803, 0F, 1.570796F, 0F);
      Shape804 = new ModelRenderer(this, 212, 0);
      Shape804.addBox(-2F, -5F, 4F, 4, 6, 1);
      Shape804.setRotationPoint(0F, -3F, 0F);
      Shape804.setTextureSize(64, 32);
      Shape804.mirror = true;
      setRotation(Shape804, 0F, 2.356194F, 0F);
      Shape805 = new ModelRenderer(this, 200, 0);
      Shape805.addBox(-2.5F, -5F, 4F, 5, 6, 1);
      Shape805.setRotationPoint(0F, -3F, 0F);
      Shape805.setTextureSize(64, 32);
      Shape805.mirror = true;
      setRotation(Shape805, 0F, 3.141593F, 0F);
      Shape806 = new ModelRenderer(this, 212, 0);
      Shape806.addBox(-2F, -5F, 4F, 4, 6, 1);
      Shape806.setRotationPoint(0F, -3F, 0F);
      Shape806.setTextureSize(64, 32);
      Shape806.mirror = true;
      setRotation(Shape806, 0F, -2.356194F, 0F);
      Shape807 = new ModelRenderer(this, 200, 0);
      Shape807.addBox(-2.5F, -5F, 4F, 5, 6, 1);
      Shape807.setRotationPoint(0F, -3F, 0F);
      Shape807.setTextureSize(64, 32);
      Shape807.mirror = true;
      setRotation(Shape807, 0F, -1.570796F, 0F);
      Shape808 = new ModelRenderer(this, 212, 0);
      Shape808.addBox(-2F, -5F, 4F, 4, 6, 1);
      Shape808.setRotationPoint(0F, -3F, 0F);
      Shape808.setTextureSize(64, 32);
      Shape808.mirror = true;
      setRotation(Shape808, 0F, -0.7853982F, 0F);
      Shape901 = new ModelRenderer(this, 200, 7);
      Shape901.addBox(-2.5F, -6F, 5F, 5, 2, 1);
      Shape901.setRotationPoint(0F, -3F, 0F);
      Shape901.setTextureSize(64, 32);
      Shape901.mirror = true;
      setRotation(Shape901, 0F, 0F, 0F);
      Shape902 = new ModelRenderer(this, 200, 7);
      Shape902.addBox(-2.5F, -6F, 5F, 5, 2, 1);
      Shape902.setRotationPoint(0F, -3F, 0F);
      Shape902.setTextureSize(64, 32);
      Shape902.mirror = true;
      setRotation(Shape902, 0F, 1.570796F, 0F);
      Shape903 = new ModelRenderer(this, 200, 7);
      Shape903.addBox(-2.5F, -6F, 5F, 5, 2, 1);
      Shape903.setRotationPoint(0F, -3F, 0F);
      Shape903.setTextureSize(64, 32);
      Shape903.mirror = true;
      setRotation(Shape903, 0F, -3.141593F, 0F);
      Shape904 = new ModelRenderer(this, 200, 7);
      Shape904.addBox(-2.5F, -6F, 5F, 5, 2, 1);
      Shape904.setRotationPoint(0F, -3F, 0F);
      Shape904.setTextureSize(64, 32);
      Shape904.mirror = true;
      setRotation(Shape904, 0F, -1.570796F, 0F);
      Shape1600 = new ModelRenderer(this, 200, 10);
      Shape1600.addBox(-4.5F, -1F, -4.5F, 9, 1, 9);
      Shape1600.setRotationPoint(0F, -2F, 0F);
      Shape1600.setTextureSize(64, 32);
      Shape1600.mirror = true;
      setRotation(Shape1600, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape801.render(f5);
    Shape802.render(f5);
    Shape803.render(f5);
    Shape804.render(f5);
    Shape805.render(f5);
    Shape806.render(f5);
    Shape807.render(f5);
    Shape808.render(f5);
    Shape901.render(f5);
    Shape902.render(f5);
    Shape903.render(f5);
    Shape904.render(f5);
    Shape1600.render(f5);
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
