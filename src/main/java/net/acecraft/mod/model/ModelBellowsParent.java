package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBellowsParent extends ModelBase
{
  //fields
    ModelRenderer Shape201;
    ModelRenderer Shape202;
    ModelRenderer Shape203;
    ModelRenderer Shape204;
    ModelRenderer Shape300;
    ModelRenderer Shape400;
    ModelRenderer Shape500;
    ModelRenderer Shape701;
    ModelRenderer Shape800;
    ModelRenderer Shape900;
    ModelRenderer Shape1000;
    ModelRenderer Shape1201;
    ModelRenderer Shape1202;
  
  public ModelBellowsParent()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Shape201 = new ModelRenderer(this, 30, 52);
      Shape201.addBox(-7F, 4F, -7F, 3, 4, 3);
      Shape201.setRotationPoint(0F, 16F, 0F);
      Shape201.setTextureSize(64, 32);
      Shape201.mirror = true;
      setRotation(Shape201, 0F, 0F, 0F);
      Shape202 = new ModelRenderer(this, 30, 52);
      Shape202.addBox(-7F, 4F, 4F, 3, 4, 3);
      Shape202.setRotationPoint(0F, 16F, 0F);
      Shape202.setTextureSize(64, 32);
      Shape202.mirror = true;
      setRotation(Shape202, 0F, 0F, 0F);
      Shape203 = new ModelRenderer(this, 30, 52);
      Shape203.addBox(12F, 4F, -7F, 3, 4, 3);
      Shape203.setRotationPoint(0F, 16F, 0F);
      Shape203.setTextureSize(64, 32);
      Shape203.mirror = true;
      setRotation(Shape203, 0F, 0F, 0F);
      Shape204 = new ModelRenderer(this, 30, 52);
      Shape204.addBox(12F, 4F, 4F, 3, 4, 3);
      Shape204.setRotationPoint(0F, 16F, 0F);
      Shape204.setTextureSize(64, 32);
      Shape204.mirror = true;
      setRotation(Shape204, 0F, 0F, 0F);
      Shape300 = new ModelRenderer(this, 47, 47);
      Shape300.addBox(-8F, 3F, -8F, 24, 1, 16);
      Shape300.setRotationPoint(0F, 16F, 0F);
      Shape300.setTextureSize(64, 32);
      Shape300.mirror = true;
      setRotation(Shape300, 0F, 0F, 0F);
      Shape400 = new ModelRenderer(this, 0, 0);
      Shape400.addBox(-20F, 1F, -6F, 20, 1, 12);
      Shape400.setRotationPoint(15F, 17F, 0F);
      Shape400.setTextureSize(64, 32);
      Shape400.mirror = true;
      setRotation(Shape400, 0F, 0F, 0F);
      Shape500 = new ModelRenderer(this, 0, 0);
      Shape500.addBox(0F, -2F, -7F, 2, 4, 14);
      Shape500.setRotationPoint(15F, 17F, 0F);
      Shape500.setTextureSize(64, 32);
      Shape500.mirror = true;
      setRotation(Shape500, 0F, 0F, 0F);
      Shape701 = new ModelRenderer(this, 65, 0);
      Shape701.addBox(-18F, -1F, -5F, 18, 2, 10);
      Shape701.setRotationPoint(15F, 17F, 0F);
      Shape701.setTextureSize(64, 32);
      Shape701.mirror = true;
      setRotation(Shape701, 0F, 0F, 0F);
      Shape800 = new ModelRenderer(this, 0, 14);
      Shape800.addBox(2F, -2F, -2F, 1, 4, 4);
      Shape800.setRotationPoint(15F, 17F, 0F);
      Shape800.setTextureSize(64, 32);
      Shape800.mirror = true;
      setRotation(Shape800, 0F, 0F, 0F);
      Shape900 = new ModelRenderer(this, 11, 14);
      Shape900.addBox(3F, -1.5F, -1.5F, 5, 3, 3);
      Shape900.setRotationPoint(15F, 17F, 0F);
      Shape900.setTextureSize(64, 32);
      Shape900.mirror = true;
      setRotation(Shape900, 0F, 0F, 0F);
      Shape1000 = new ModelRenderer(this, 28, 14);
      Shape1000.addBox(8F, -2.5F, -2.5F, 1, 5, 5);
      Shape1000.setRotationPoint(15F, 17F, 0F);
      Shape1000.setTextureSize(64, 32);
      Shape1000.mirror = true;
      setRotation(Shape1000, 0F, 0F, 0F);
      Shape1201 = new ModelRenderer(this, 63, 14);
      Shape1201.addBox(-4F, -4F, 8F, 8, 28, 1);
      Shape1201.setRotationPoint(0F, 0F, 0F);
      Shape1201.setTextureSize(64, 32);
      Shape1201.mirror = true;
      setRotation(Shape1201, 0F, 0F, 0F);
      Shape1202 = new ModelRenderer(this, 82, 14);
      Shape1202.addBox(-4F, -4F, -9F, 8, 28, 1);
      Shape1202.setRotationPoint(0F, 0F, 0F);
      Shape1202.setTextureSize(64, 32);
      Shape1202.mirror = true;
      setRotation(Shape1202, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape201.render(f5);
    Shape202.render(f5);
    Shape203.render(f5);
    Shape204.render(f5);
    Shape300.render(f5);
    Shape400.render(f5);
    Shape500.render(f5);
    Shape701.render(f5);
    Shape800.render(f5);
    Shape900.render(f5);
    Shape1000.render(f5);
    Shape1201.render(f5);
    Shape1202.render(f5);
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
