package net.acecraft.mod.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelVent extends ModelBase
{
  //fields
    ModelRenderer Shape101;
    ModelRenderer Shape102;
    ModelRenderer Shape103;
    ModelRenderer Shape104;
    ModelRenderer Shape201;
    ModelRenderer Shape202;
    ModelRenderer Shape203;
    ModelRenderer Shape204;
    ModelRenderer Shape301;
    ModelRenderer Shape302;
    ModelRenderer Shape303;
    ModelRenderer Shape304;
    ModelRenderer Shape305;
    ModelRenderer Shape306;
    ModelRenderer Shape307;
    ModelRenderer Shape308;
    ModelRenderer Shape401;
    ModelRenderer Shape402;
    ModelRenderer Shape403;
    ModelRenderer Shape404;
    ModelRenderer Shape501;
    ModelRenderer Shape502;
    ModelRenderer Shape503;
    ModelRenderer Shape504;
  
  public ModelVent()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Shape101 = new ModelRenderer(this, 0, 0);
      Shape101.addBox(-2.5F, 2F, 4F, 5, 6, 1);
      Shape101.setRotationPoint(0F, 16F, 0F);
      Shape101.setTextureSize(64, 32);
      Shape101.mirror = true;
      setRotation(Shape101, 0F, 0F, 0F);
      Shape102 = new ModelRenderer(this, 0, 0);
      Shape102.addBox(-2.5F, 2F, 4F, 5, 6, 1);
      Shape102.setRotationPoint(0F, 16F, 0F);
      Shape102.setTextureSize(64, 32);
      Shape102.mirror = true;
      setRotation(Shape102, 0F, 1.570796F, 0F);
      Shape103 = new ModelRenderer(this, 0, 0);
      Shape103.addBox(-2.5F, 2F, 4F, 5, 6, 1);
      Shape103.setRotationPoint(0F, 16F, 0F);
      Shape103.setTextureSize(64, 32);
      Shape103.mirror = true;
      setRotation(Shape103, 0F, -3.141593F, 0F);
      Shape104 = new ModelRenderer(this, 0, 0);
      Shape104.addBox(-2.5F, 2F, 4F, 5, 6, 1);
      Shape104.setRotationPoint(0F, 16F, 0F);
      Shape104.setTextureSize(64, 32);
      Shape104.mirror = true;
      setRotation(Shape104, 0F, -1.570796F, 0F);
      Shape201 = new ModelRenderer(this, 12, 0);
      Shape201.addBox(-2F, 2F, 4F, 4, 6, 1);
      Shape201.setRotationPoint(0F, 16F, 0F);
      Shape201.setTextureSize(64, 32);
      Shape201.mirror = true;
      setRotation(Shape201, 0F, 0.7853982F, 0F);
      Shape202 = new ModelRenderer(this, 12, 0);
      Shape202.addBox(-2F, 2F, 4F, 4, 6, 1);
      Shape202.setRotationPoint(0F, 16F, 0F);
      Shape202.setTextureSize(64, 32);
      Shape202.mirror = true;
      setRotation(Shape202, 0F, 2.356194F, 0F);
      Shape203 = new ModelRenderer(this, 12, 0);
      Shape203.addBox(-2F, 2F, 4F, 4, 6, 1);
      Shape203.setRotationPoint(0F, 16F, 0F);
      Shape203.setTextureSize(64, 32);
      Shape203.mirror = true;
      setRotation(Shape203, 0F, -2.356194F, 0F);
      Shape204 = new ModelRenderer(this, 12, 0);
      Shape204.addBox(-2F, 2F, 4F, 4, 6, 1);
      Shape204.setRotationPoint(0F, 16F, 0F);
      Shape204.setTextureSize(64, 32);
      Shape204.mirror = true;
      setRotation(Shape204, 0F, -0.7853982F, 0F);
      Shape301 = new ModelRenderer(this, 23, 0);
      Shape301.addBox(-2.5F, -0.5F, 5F, 5, 4, 1);
      Shape301.setRotationPoint(0F, 16F, 0F);
      Shape301.setTextureSize(64, 32);
      Shape301.mirror = true;
      setRotation(Shape301, 0F, 0F, 0F);
      Shape302 = new ModelRenderer(this, 23, 0);
      Shape302.addBox(-2.5F, -0.5F, 5F, 5, 4, 1);
      Shape302.setRotationPoint(0F, 16F, 0F);
      Shape302.setTextureSize(64, 32);
      Shape302.mirror = true;
      setRotation(Shape302, 0F, 1.570796F, 0F);
      Shape303 = new ModelRenderer(this, 23, 0);
      Shape303.addBox(-2.5F, -0.5F, 5F, 5, 4, 1);
      Shape303.setRotationPoint(0F, 16F, 0F);
      Shape303.setTextureSize(64, 32);
      Shape303.mirror = true;
      setRotation(Shape303, 0F, -3.141593F, 0F);
      Shape304 = new ModelRenderer(this, 23, 0);
      Shape304.addBox(-2.5F, -0.5F, 5F, 5, 4, 1);
      Shape304.setRotationPoint(0F, 16F, 0F);
      Shape304.setTextureSize(64, 32);
      Shape304.mirror = true;
      setRotation(Shape304, 0F, -1.570796F, 0F);
      Shape305 = new ModelRenderer(this, 23, 6);
      Shape305.addBox(-2.5F, 0F, 5F, 5, 3, 1);
      Shape305.setRotationPoint(0F, 16F, 0F);
      Shape305.setTextureSize(64, 32);
      Shape305.mirror = true;
      setRotation(Shape305, 0F, 0.7853982F, 0F);
      Shape306 = new ModelRenderer(this, 23, 6);
      Shape306.addBox(-2.5F, 0F, 5F, 5, 3, 1);
      Shape306.setRotationPoint(0F, 16F, 0F);
      Shape306.setTextureSize(64, 32);
      Shape306.mirror = true;
      setRotation(Shape306, 0F, 2.356194F, 0F);
      Shape307 = new ModelRenderer(this, 23, 6);
      Shape307.addBox(-2.5F, 0F, 5F, 5, 3, 1);
      Shape307.setRotationPoint(0F, 16F, 0F);
      Shape307.setTextureSize(64, 32);
      Shape307.mirror = true;
      setRotation(Shape307, 0F, -2.356194F, 0F);
      Shape308 = new ModelRenderer(this, 23, 6);
      Shape308.addBox(-2.5F, 0F, 5F, 5, 3, 1);
      Shape308.setRotationPoint(0F, 16F, 0F);
      Shape308.setTextureSize(64, 32);
      Shape308.mirror = true;
      setRotation(Shape308, 0F, -0.7853982F, 0F);
      Shape401 = new ModelRenderer(this, 0, 8);
      Shape401.addBox(1.5F, 0.2F, -5F, 1, 1, 10);
      Shape401.setRotationPoint(0F, 16F, 0F);
      Shape401.setTextureSize(64, 32);
      Shape401.mirror = true;
      setRotation(Shape401, 0F, 0F, 0F);
      Shape402 = new ModelRenderer(this, 0, 8);
      Shape402.addBox(-2.5F, 0.2F, -5F, 1, 1, 10);
      Shape402.setRotationPoint(0F, 16F, 0F);
      Shape402.setTextureSize(64, 32);
      Shape402.mirror = true;
      setRotation(Shape402, 0F, 0F, 0F);
      Shape403 = new ModelRenderer(this, 0, 8);
      Shape403.addBox(1.5F, 0.3F, -5F, 1, 1, 10);
      Shape403.setRotationPoint(0F, 16F, 0F);
      Shape403.setTextureSize(64, 32);
      Shape403.mirror = true;
      setRotation(Shape403, 0F, -1.570796F, 0F);
      Shape404 = new ModelRenderer(this, 0, 8);
      Shape404.addBox(-2.5F, 0.7F, -5F, 1, 1, 10);
      Shape404.setRotationPoint(0F, 16F, 0F);
      Shape404.setTextureSize(64, 32);
      Shape404.mirror = true;
      setRotation(Shape404, 0F, -1.570796F, 0F);
      Shape501 = new ModelRenderer(this, 23, 13);
      Shape501.addBox(-2.5F, 7F, 5F, 5, 2, 1);
      Shape501.setRotationPoint(0F, 16F, 0F);
      Shape501.setTextureSize(64, 32);
      Shape501.mirror = true;
      setRotation(Shape501, 0F, 0.7853982F, 0F);
      Shape502 = new ModelRenderer(this, 23, 13);
      Shape502.addBox(-2.5F, 7F, 5F, 5, 2, 1);
      Shape502.setRotationPoint(0F, 16F, 0F);
      Shape502.setTextureSize(64, 32);
      Shape502.mirror = true;
      setRotation(Shape502, 0F, 2.356194F, 0F);
      Shape503 = new ModelRenderer(this, 23, 13);
      Shape503.addBox(-2.5F, 7F, 5F, 5, 2, 1);
      Shape503.setRotationPoint(0F, 16F, 0F);
      Shape503.setTextureSize(64, 32);
      Shape503.mirror = true;
      setRotation(Shape503, 0F, -2.356194F, 0F);
      Shape504 = new ModelRenderer(this, 0, 0);
      Shape504.addBox(-2.5F, 7F, 5F, 5, 2, 1);
      Shape504.setRotationPoint(0F, 16F, 0F);
      Shape504.setTextureSize(64, 32);
      Shape504.mirror = true;
      setRotation(Shape504, 0F, -0.7853982F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape101.render(f5);
    Shape102.render(f5);
    Shape103.render(f5);
    Shape104.render(f5);
    Shape201.render(f5);
    Shape202.render(f5);
    Shape203.render(f5);
    Shape204.render(f5);
    Shape301.render(f5);
    Shape302.render(f5);
    Shape303.render(f5);
    Shape304.render(f5);
    Shape305.render(f5);
    Shape306.render(f5);
    Shape307.render(f5);
    Shape308.render(f5);
    Shape401.render(f5);
    Shape402.render(f5);
    Shape403.render(f5);
    Shape404.render(f5);
    Shape501.render(f5);
    Shape502.render(f5);
    Shape503.render(f5);
    Shape504.render(f5);
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
