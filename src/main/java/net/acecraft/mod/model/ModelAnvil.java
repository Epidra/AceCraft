package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAnvil extends ModelBase
{
  //fields
    ModelRenderer Shape100;
    ModelRenderer Shape200;
    ModelRenderer Shape300;
    ModelRenderer Shape400;
    ModelRenderer Shape500;
    ModelRenderer Shape600;
    ModelRenderer Shape700;
  
  public ModelAnvil()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Shape100 = new ModelRenderer(this, 0, 39);
      Shape100.addBox(-8F, -1F, -5F, 16, 2, 10);
      Shape100.setRotationPoint(0F, 23F, 0F);
      Shape100.setTextureSize(128, 64);
      Shape100.mirror = true;
      setRotation(Shape100, 0F, 0F, 0F);
      Shape200 = new ModelRenderer(this, 0, 30);
      Shape200.addBox(-7F, -0.5F, -4F, 14, 1, 8);
      Shape200.setRotationPoint(0F, 21.5F, 0F);
      Shape200.setTextureSize(128, 64);
      Shape200.mirror = true;
      setRotation(Shape200, 0F, 0F, 0F);
      Shape300 = new ModelRenderer(this, 0, 18);
      Shape300.addBox(-6F, -4F, -3F, 12, 6, 6);
      Shape300.setRotationPoint(0F, 19F, 0F);
      Shape300.setTextureSize(128, 64);
      Shape300.mirror = true;
      setRotation(Shape300, 0F, 0F, 0F);
      Shape400 = new ModelRenderer(this, 0, 0);
      Shape400.addBox(-7F, -3F, -5F, 19, 8, 10);
      Shape400.setRotationPoint(-3F, 10F, 0F);
      Shape400.setTextureSize(128, 64);
      Shape400.mirror = true;
      setRotation(Shape400, 0F, 0F, 0F);
      Shape500 = new ModelRenderer(this, 58, 0);
      Shape500.addBox(-3.5F, 0F, -3.5F, 7, 6, 7);
      Shape500.setRotationPoint(-10F, 8F, 0F);
      Shape500.setTextureSize(128, 64);
      Shape500.mirror = true;
      setRotation(Shape500, 0F, -0.7853982F, 0F);
      Shape600 = new ModelRenderer(this, 57, 4);
      Shape600.addBox(-1F, -1F, -1F, 2, 1, 2);
      Shape600.setRotationPoint(-13F, 8F, 0F);
      Shape600.setTextureSize(128, 64);
      Shape600.mirror = true;
      setRotation(Shape600, 0F, -0.7853982F, 0F);
      Shape700 = new ModelRenderer(this, 58, 13);
      Shape700.addBox(0F, -3F, -4F, 5, 6, 8);
      Shape700.setRotationPoint(9F, 11F, 0F);
      Shape700.setTextureSize(128, 64);
      Shape700.mirror = true;
      setRotation(Shape700, 0F, 0F, 0F);
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
