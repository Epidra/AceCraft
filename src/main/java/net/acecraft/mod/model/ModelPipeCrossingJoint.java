package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPipeCrossingJoint extends ModelBase
{
  //fields
    ModelRenderer Shape701;
    ModelRenderer Shape702;
    ModelRenderer Shape703;
    ModelRenderer Shape704;
    ModelRenderer Shape1001;
    ModelRenderer Shape1002;
    ModelRenderer Shape1003;
    ModelRenderer Shape1004;
    ModelRenderer Shape1201;
    ModelRenderer Shape1202;
    ModelRenderer Shape1203;
    ModelRenderer Shape1204;
  
  public ModelPipeCrossingJoint()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Shape701 = new ModelRenderer(this, 0, 17);
      Shape701.addBox(-2.5F, -9F, 5F, 5, 2, 1);
      Shape701.setRotationPoint(0F, 0F, 0F);
      Shape701.setTextureSize(64, 32);
      Shape701.mirror = true;
      setRotation(Shape701, 0F, 0F, 0F);
      Shape702 = new ModelRenderer(this, 0, 17);
      Shape702.addBox(-2.5F, -9F, 5F, 5, 2, 1);
      Shape702.setRotationPoint(0F, 0F, 0F);
      Shape702.setTextureSize(64, 32);
      Shape702.mirror = true;
      setRotation(Shape702, 0F, 1.570796F, 0F);
      Shape703 = new ModelRenderer(this, 0, 17);
      Shape703.addBox(-2.5F, -9F, 5F, 5, 2, 1);
      Shape703.setRotationPoint(0F, 0F, 0F);
      Shape703.setTextureSize(64, 32);
      Shape703.mirror = true;
      setRotation(Shape703, 0F, -3.141593F, 0F);
      Shape704 = new ModelRenderer(this, 0, 17);
      Shape704.addBox(-2.5F, -9F, 5F, 5, 2, 1);
      Shape704.setRotationPoint(0F, 0F, 0F);
      Shape704.setTextureSize(64, 32);
      Shape704.mirror = true;
      setRotation(Shape704, 0F, -1.570796F, 0F);
      Shape1001 = new ModelRenderer(this, 7, 21);
      Shape1001.addBox(-9F, -2.5F, 5F, 2, 5, 1);
      Shape1001.setRotationPoint(0F, 0F, 0F);
      Shape1001.setTextureSize(64, 32);
      Shape1001.mirror = true;
      setRotation(Shape1001, 0.7853982F, 0F, 0F);
      Shape1002 = new ModelRenderer(this, 7, 21);
      Shape1002.addBox(-9F, -2.5F, 5F, 2, 5, 1);
      Shape1002.setRotationPoint(0F, 0F, 0F);
      Shape1002.setTextureSize(64, 32);
      Shape1002.mirror = true;
      setRotation(Shape1002, 2.356194F, 0F, 0F);
      Shape1003 = new ModelRenderer(this, 7, 21);
      Shape1003.addBox(-9F, -2.5F, 5F, 2, 5, 1);
      Shape1003.setRotationPoint(0F, 0F, 0F);
      Shape1003.setTextureSize(64, 32);
      Shape1003.mirror = true;
      setRotation(Shape1003, -2.356194F, 0F, 0F);
      Shape1004 = new ModelRenderer(this, 7, 21);
      Shape1004.addBox(-9F, -2.5F, 5F, 2, 5, 1);
      Shape1004.setRotationPoint(0F, 0F, 0F);
      Shape1004.setTextureSize(64, 32);
      Shape1004.mirror = true;
      setRotation(Shape1004, -0.7853982F, 0F, 0F);
      Shape1201 = new ModelRenderer(this, 21, 21);
      Shape1201.addBox(7F, -2.5F, 5F, 2, 5, 1);
      Shape1201.setRotationPoint(0F, 0F, 0F);
      Shape1201.setTextureSize(64, 32);
      Shape1201.mirror = true;
      setRotation(Shape1201, 0.7853982F, 0F, 0F);
      Shape1202 = new ModelRenderer(this, 21, 21);
      Shape1202.addBox(7F, -2.5F, 5F, 2, 5, 1);
      Shape1202.setRotationPoint(0F, 0F, 0F);
      Shape1202.setTextureSize(64, 32);
      Shape1202.mirror = true;
      setRotation(Shape1202, 2.356194F, 0F, 0F);
      Shape1203 = new ModelRenderer(this, 21, 21);
      Shape1203.addBox(7F, -2.5F, 5F, 2, 5, 1);
      Shape1203.setRotationPoint(0F, 0F, 0F);
      Shape1203.setTextureSize(64, 32);
      Shape1203.mirror = true;
      setRotation(Shape1203, -2.356194F, 0F, 0F);
      Shape1204 = new ModelRenderer(this, 21, 21);
      Shape1204.addBox(7F, -2.5F, 5F, 2, 5, 1);
      Shape1204.setRotationPoint(0F, 0F, 0F);
      Shape1204.setTextureSize(64, 32);
      Shape1204.mirror = true;
      setRotation(Shape1204, -0.7853982F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape701.render(f5);
    Shape702.render(f5);
    Shape703.render(f5);
    Shape704.render(f5);
    Shape1001.render(f5);
    Shape1002.render(f5);
    Shape1003.render(f5);
    Shape1004.render(f5);
    Shape1201.render(f5);
    Shape1202.render(f5);
    Shape1203.render(f5);
    Shape1204.render(f5);
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
