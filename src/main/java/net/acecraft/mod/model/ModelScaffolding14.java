package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelScaffolding14 extends ModelBase
{
  //fields
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Shape13;
    ModelRenderer Shape14;
    ModelRenderer Shape21;
    ModelRenderer Shape22;
    ModelRenderer Shape23;
    ModelRenderer Shape24;
    ModelRenderer Shape31;
    ModelRenderer Shape32;
    ModelRenderer Shape33;
    ModelRenderer Shape34;
    ModelRenderer Shape41;
    ModelRenderer Shape42;
    ModelRenderer Shape51;
    ModelRenderer Shape52;
    ModelRenderer Shape61;
    ModelRenderer Shape62;
    ModelRenderer Shape70;
  
  public ModelScaffolding14()
  {
    textureWidth = 128;
    textureHeight = 32;
    
      Shape11 = new ModelRenderer(this, 0, 0);
      Shape11.addBox(-7F, 7F, -8F, 14, 1, 1);
      Shape11.setRotationPoint(0F, 16F, 0F);
      Shape11.setTextureSize(128, 32);
      Shape11.mirror = true;
      setRotation(Shape11, 0F, 0F, 0F);
      Shape12 = new ModelRenderer(this, 30, 0);
      Shape12.addBox(-7F, 7F, -8F, 14, 1, 1);
      Shape12.setRotationPoint(0F, 16F, 0F);
      Shape12.setTextureSize(128, 32);
      Shape12.mirror = true;
      setRotation(Shape12, 0F, -1.570796F, 0F);
      Shape13 = new ModelRenderer(this, 60, 0);
      Shape13.addBox(-7F, 7F, 7F, 14, 1, 1);
      Shape13.setRotationPoint(0F, 16F, 0F);
      Shape13.setTextureSize(128, 32);
      Shape13.mirror = true;
      setRotation(Shape13, 0F, 0F, 0F);
      Shape14 = new ModelRenderer(this, 90, 0);
      Shape14.addBox(-7F, 7F, 7F, 14, 1, 1);
      Shape14.setRotationPoint(0F, 16F, 0F);
      Shape14.setTextureSize(128, 32);
      Shape14.mirror = true;
      setRotation(Shape14, 0F, -1.570796F, 0F);
      Shape21 = new ModelRenderer(this, 0, 4);
      Shape21.addBox(7F, -8F, 7F, 1, 16, 1);
      Shape21.setRotationPoint(0F, 16F, 0F);
      Shape21.setTextureSize(128, 32);
      Shape21.mirror = true;
      setRotation(Shape21, 0F, 0F, 0F);
      Shape22 = new ModelRenderer(this, 4, 4);
      Shape22.addBox(7F, -8F, -8F, 1, 16, 1);
      Shape22.setRotationPoint(0F, 16F, 0F);
      Shape22.setTextureSize(128, 32);
      Shape22.mirror = true;
      setRotation(Shape22, 0F, 0F, 0F);
      Shape23 = new ModelRenderer(this, 4, 4);
      Shape23.addBox(-8F, -8F, 7F, 1, 16, 1);
      Shape23.setRotationPoint(0F, 16F, 0F);
      Shape23.setTextureSize(128, 32);
      Shape23.mirror = true;
      setRotation(Shape23, 0F, 0F, 0F);
      Shape24 = new ModelRenderer(this, 0, 4);
      Shape24.addBox(-8F, -8F, -8F, 1, 16, 1);
      Shape24.setRotationPoint(0F, 16F, 0F);
      Shape24.setTextureSize(128, 32);
      Shape24.mirror = true;
      setRotation(Shape24, 0F, 0F, 0F);
      Shape31 = new ModelRenderer(this, 0, 2);
      Shape31.addBox(-7F, -8F, -8F, 14, 1, 1);
      Shape31.setRotationPoint(0F, 16F, 0F);
      Shape31.setTextureSize(128, 32);
      Shape31.mirror = true;
      setRotation(Shape31, 0F, 0F, 0F);
      Shape32 = new ModelRenderer(this, 30, 2);
      Shape32.addBox(-7F, -8F, -8F, 14, 1, 1);
      Shape32.setRotationPoint(0F, 16F, 0F);
      Shape32.setTextureSize(128, 32);
      Shape32.mirror = true;
      setRotation(Shape32, 0F, -1.570796F, 0F);
      Shape33 = new ModelRenderer(this, 60, 2);
      Shape33.addBox(-7F, -8F, 7F, 14, 1, 1);
      Shape33.setRotationPoint(0F, 16F, 0F);
      Shape33.setTextureSize(128, 32);
      Shape33.mirror = true;
      setRotation(Shape33, 0F, 0F, 0F);
      Shape34 = new ModelRenderer(this, 90, 2);
      Shape34.addBox(-7F, -8F, 7F, 14, 1, 1);
      Shape34.setRotationPoint(0F, 16F, 0F);
      Shape34.setTextureSize(128, 32);
      Shape34.mirror = true;
      setRotation(Shape34, 0F, -1.570796F, 0F);
      Shape41 = new ModelRenderer(this, 8, 4);
      Shape41.addBox(-10.5F, -0.5F, -7.5F, 21, 1, 1);
      Shape41.setRotationPoint(0F, 16F, 0F);
      Shape41.setTextureSize(128, 32);
      Shape41.mirror = true;
      setRotation(Shape41, 0F, 0F, -0.7853982F);
      Shape42 = new ModelRenderer(this, 8, 4);
      Shape42.addBox(-10.5F, -0.5F, 6.5F, 21, 1, 1);
      Shape42.setRotationPoint(0F, 16F, 0F);
      Shape42.setTextureSize(128, 32);
      Shape42.mirror = true;
      setRotation(Shape42, 0F, 0F, 0.7853982F);
      Shape51 = new ModelRenderer(this, 0, 6);
      Shape51.addBox(6.5F, -0.5F, -10.5F, 1, 1, 21);
      Shape51.setRotationPoint(0F, 16F, 0F);
      Shape51.setTextureSize(128, 32);
      Shape51.mirror = true;
      setRotation(Shape51, -0.7853982F, 0F, 0F);
      Shape52 = new ModelRenderer(this, 0, 6);
      Shape52.addBox(-7.5F, -0.5F, -10.5F, 1, 1, 21);
      Shape52.setRotationPoint(0F, 16F, 0F);
      Shape52.setTextureSize(128, 32);
      Shape52.mirror = true;
      setRotation(Shape52, 0.7853982F, 0F, 0F);
      Shape61 = new ModelRenderer(this, 0, 28);
      Shape61.addBox(-10.5F, 6.5F, -0.5F, 20, 1, 1);
      Shape61.setRotationPoint(0F, 16F, 0F);
      Shape61.setTextureSize(128, 32);
      Shape61.mirror = true;
      setRotation(Shape61, 0F, -0.7853982F, 0F);
      Shape62 = new ModelRenderer(this, 0, 28);
      Shape62.addBox(-9.5F, -7.5F, -0.5F, 20, 1, 1);
      Shape62.setRotationPoint(0F, 16F, 0F);
      Shape62.setTextureSize(128, 32);
      Shape62.mirror = true;
      setRotation(Shape62, 0F, 0.7853982F, 0F);
      Shape70 = new ModelRenderer(this, 38, 4);
      Shape70.addBox(-7F, -8F, -7F, 14, 1, 14);
      Shape70.setRotationPoint(0F, 16F, 0F);
      Shape70.setTextureSize(128, 32);
      Shape70.mirror = true;
      setRotation(Shape70, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape11.render(f5);
    Shape12.render(f5);
    Shape13.render(f5);
    Shape14.render(f5);
    Shape21.render(f5);
    Shape22.render(f5);
    Shape23.render(f5);
    Shape24.render(f5);
    Shape31.render(f5);
    Shape32.render(f5);
    Shape33.render(f5);
    Shape34.render(f5);
    Shape41.render(f5);
    Shape42.render(f5);
    Shape51.render(f5);
    Shape52.render(f5);
    Shape61.render(f5);
    Shape62.render(f5);
    Shape70.render(f5);
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
