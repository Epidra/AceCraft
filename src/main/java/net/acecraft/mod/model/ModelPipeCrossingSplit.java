package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPipeCrossingSplit extends ModelBase
{
  //fields
    ModelRenderer Shape801;
    ModelRenderer Shape802;
    ModelRenderer Shape803;
    ModelRenderer Shape804;
    ModelRenderer Shape901;
    ModelRenderer Shape902;
    ModelRenderer Shape903;
    ModelRenderer Shape904;
    ModelRenderer Shape1101;
    ModelRenderer Shape1102;
    ModelRenderer Shape1103;
    ModelRenderer Shape1104;
  
  public ModelPipeCrossingSplit()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Shape801 = new ModelRenderer(this, 13, 17);
      Shape801.addBox(-2.5F, -9F, 5F, 5, 2, 1);
      Shape801.setRotationPoint(0F, 0F, 0F);
      Shape801.setTextureSize(64, 32);
      Shape801.mirror = true;
      setRotation(Shape801, 0F, 0.7853982F, 0F);
      Shape802 = new ModelRenderer(this, 13, 17);
      Shape802.addBox(-2.5F, -9F, 5F, 5, 2, 1);
      Shape802.setRotationPoint(0F, 0F, 0F);
      Shape802.setTextureSize(64, 32);
      Shape802.mirror = true;
      setRotation(Shape802, 0F, 2.356194F, 0F);
      Shape803 = new ModelRenderer(this, 13, 17);
      Shape803.addBox(-2.5F, -9F, 5F, 5, 2, 1);
      Shape803.setRotationPoint(0F, 0F, 0F);
      Shape803.setTextureSize(64, 32);
      Shape803.mirror = true;
      setRotation(Shape803, 0F, -2.356194F, 0F);
      Shape804 = new ModelRenderer(this, 13, 17);
      Shape804.addBox(-2.5F, -9F, 5F, 5, 2, 1);
      Shape804.setRotationPoint(0F, 0F, 0F);
      Shape804.setTextureSize(64, 32);
      Shape804.mirror = true;
      setRotation(Shape804, 0F, -0.7853982F, 0F);
      Shape901 = new ModelRenderer(this, 0, 21);
      Shape901.addBox(-9F, -2.5F, 5F, 2, 5, 1);
      Shape901.setRotationPoint(0F, 0F, 0F);
      Shape901.setTextureSize(64, 32);
      Shape901.mirror = true;
      setRotation(Shape901, 0F, 0F, 0F);
      Shape902 = new ModelRenderer(this, 0, 21);
      Shape902.addBox(-9F, -2.5F, 5F, 2, 5, 1);
      Shape902.setRotationPoint(0F, 0F, 0F);
      Shape902.setTextureSize(64, 32);
      Shape902.mirror = true;
      setRotation(Shape902, 1.570796F, 0F, 0F);
      Shape903 = new ModelRenderer(this, 0, 21);
      Shape903.addBox(-9F, -2.5F, 5F, 2, 5, 1);
      Shape903.setRotationPoint(0F, 0F, 0F);
      Shape903.setTextureSize(64, 32);
      Shape903.mirror = true;
      setRotation(Shape903, -3.141593F, 0F, 0F);
      Shape904 = new ModelRenderer(this, 0, 21);
      Shape904.addBox(-9F, -2.5F, 5F, 2, 5, 1);
      Shape904.setRotationPoint(0F, 0F, 0F);
      Shape904.setTextureSize(64, 32);
      Shape904.mirror = true;
      setRotation(Shape904, -1.570796F, 0F, 0F);
      Shape1101 = new ModelRenderer(this, 14, 21);
      Shape1101.addBox(7F, -2.5F, 5F, 2, 5, 1);
      Shape1101.setRotationPoint(0F, 0F, 0F);
      Shape1101.setTextureSize(64, 32);
      Shape1101.mirror = true;
      setRotation(Shape1101, 0F, 0F, 0F);
      Shape1102 = new ModelRenderer(this, 14, 21);
      Shape1102.addBox(7F, -2.5F, 5F, 2, 5, 1);
      Shape1102.setRotationPoint(0F, 0F, 0F);
      Shape1102.setTextureSize(64, 32);
      Shape1102.mirror = true;
      setRotation(Shape1102, 1.570796F, 0F, 0F);
      Shape1103 = new ModelRenderer(this, 14, 21);
      Shape1103.addBox(7F, -2.5F, 5F, 2, 5, 1);
      Shape1103.setRotationPoint(0F, 0F, 0F);
      Shape1103.setTextureSize(64, 32);
      Shape1103.mirror = true;
      setRotation(Shape1103, -3.141593F, 0F, 0F);
      Shape1104 = new ModelRenderer(this, 14, 21);
      Shape1104.addBox(7F, -2.5F, 5F, 2, 5, 1);
      Shape1104.setRotationPoint(0F, 0F, 0F);
      Shape1104.setTextureSize(64, 32);
      Shape1104.mirror = true;
      setRotation(Shape1104, -1.570796F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape801.render(f5);
    Shape802.render(f5);
    Shape803.render(f5);
    Shape804.render(f5);
    Shape901.render(f5);
    Shape902.render(f5);
    Shape903.render(f5);
    Shape904.render(f5);
    Shape1101.render(f5);
    Shape1102.render(f5);
    Shape1103.render(f5);
    Shape1104.render(f5);
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
