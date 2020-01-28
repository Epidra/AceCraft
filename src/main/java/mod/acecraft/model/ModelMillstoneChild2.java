package mod.acecraft.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMillstoneChild2 extends ModelBase {
	
	//fields
    ModelRenderer Shape700;
    ModelRenderer Shape801;
    ModelRenderer Shape802;
    ModelRenderer Shape803;
    ModelRenderer Shape804;
    ModelRenderer Shape805;
    ModelRenderer Shape806;
    ModelRenderer Shape807;
    ModelRenderer Shape808;
    ModelRenderer Shape809;
    ModelRenderer Shape810;
    ModelRenderer Shape811;
    ModelRenderer Shape812;
  
  public ModelMillstoneChild2()
  {
    textureWidth = 256;
    textureHeight = 128;
    
      Shape700 = new ModelRenderer(this, 0, 66);
      Shape700.addBox(-2F, -2F, -22F, 4, 4, 28);
      Shape700.setRotationPoint(0F, 0F, 0F);
      Shape700.setTextureSize(64, 32);
      Shape700.mirror = true;
      setRotation(Shape700, 0F, 0F, -3.141593F);
      Shape801 = new ModelRenderer(this, 70, 55);
      Shape801.addBox(-3F, 0F, -18.5F, 6, 12, 8);
      Shape801.setRotationPoint(0F, 0F, 0F);
      Shape801.setTextureSize(64, 32);
      Shape801.mirror = true;
      setRotation(Shape801, 0F, 0F, 0F);
      Shape802 = new ModelRenderer(this, 100, 55);
      Shape802.addBox(-3.5F, 8F, -18.5F, 7, 4, 8);
      Shape802.setRotationPoint(0F, 0F, 0F);
      Shape802.setTextureSize(64, 32);
      Shape802.mirror = true;
      setRotation(Shape802, 0F, 0F, -0.5235988F);
      Shape803 = new ModelRenderer(this, 70, 55);
      Shape803.addBox(-3F, 0F, -18.5F, 6, 12, 8);
      Shape803.setRotationPoint(0F, 0F, 0F);
      Shape803.setTextureSize(64, 32);
      Shape803.mirror = true;
      setRotation(Shape803, 0F, 0F, -1.047198F);
      Shape804 = new ModelRenderer(this, 100, 55);
      Shape804.addBox(-3.5F, 8F, -18.5F, 7, 4, 8);
      Shape804.setRotationPoint(0F, 0F, 0F);
      Shape804.setTextureSize(64, 32);
      Shape804.mirror = true;
      setRotation(Shape804, 0F, 0F, -1.570796F);
      Shape805 = new ModelRenderer(this, 70, 55);
      Shape805.addBox(-3F, 0F, -18.5F, 6, 12, 8);
      Shape805.setRotationPoint(0F, 0F, 0F);
      Shape805.setTextureSize(64, 32);
      Shape805.mirror = true;
      setRotation(Shape805, 0F, 0F, -2.094395F);
      Shape806 = new ModelRenderer(this, 100, 55);
      Shape806.addBox(-3.5F, 8F, -18.5F, 7, 4, 8);
      Shape806.setRotationPoint(0F, 0F, 0F);
      Shape806.setTextureSize(64, 32);
      Shape806.mirror = true;
      setRotation(Shape806, 0F, 0F, -2.617994F);
      Shape807 = new ModelRenderer(this, 70, 55);
      Shape807.addBox(-3F, 0F, -18.5F, 6, 12, 8);
      Shape807.setRotationPoint(0F, 0F, 0F);
      Shape807.setTextureSize(64, 32);
      Shape807.mirror = true;
      setRotation(Shape807, 0F, 0F, -3.141593F);
      Shape808 = new ModelRenderer(this, 100, 55);
      Shape808.addBox(-3.5F, 8F, -18.5F, 7, 4, 8);
      Shape808.setRotationPoint(0F, 0F, 0F);
      Shape808.setTextureSize(64, 32);
      Shape808.mirror = true;
      setRotation(Shape808, 0F, 0F, 2.617994F);
      Shape809 = new ModelRenderer(this, 70, 55);
      Shape809.addBox(-3F, 0F, -18.5F, 6, 12, 8);
      Shape809.setRotationPoint(0F, 0F, 0F);
      Shape809.setTextureSize(64, 32);
      Shape809.mirror = true;
      setRotation(Shape809, 0F, 0F, 2.094395F);
      Shape810 = new ModelRenderer(this, 100, 55);
      Shape810.addBox(-3.5F, 8F, -18.5F, 7, 4, 8);
      Shape810.setRotationPoint(0F, 0F, 0F);
      Shape810.setTextureSize(64, 32);
      Shape810.mirror = true;
      setRotation(Shape810, 0F, 0F, 1.570796F);
      Shape811 = new ModelRenderer(this, 70, 55);
      Shape811.addBox(-3F, 0F, -18.5F, 6, 12, 8);
      Shape811.setRotationPoint(0F, 0F, 0F);
      Shape811.setTextureSize(64, 32);
      Shape811.mirror = true;
      setRotation(Shape811, 0F, 0F, 1.047198F);
      Shape812 = new ModelRenderer(this, 100, 55);
      Shape812.addBox(-3.5F, 8F, -18.5F, 7, 4, 8);
      Shape812.setRotationPoint(0F, 0F, 0F);
      Shape812.setTextureSize(64, 32);
      Shape812.mirror = true;
      setRotation(Shape812, 0F, 0F, 0.5235988F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape700.render(f5);
    Shape801.render(f5);
    Shape802.render(f5);
    Shape803.render(f5);
    Shape804.render(f5);
    Shape805.render(f5);
    Shape806.render(f5);
    Shape807.render(f5);
    Shape808.render(f5);
    Shape809.render(f5);
    Shape810.render(f5);
    Shape811.render(f5);
    Shape812.render(f5);
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
