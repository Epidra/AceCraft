package mod.acecraft.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMillstoneParent extends ModelBase {
	
	//fields
    ModelRenderer Shape101;
    ModelRenderer Shape102;
    ModelRenderer Shape103;
    ModelRenderer Shape104;
    ModelRenderer Shape105;
    ModelRenderer Shape106;
    ModelRenderer Shape107;
    ModelRenderer Shape108;
    ModelRenderer Shape109;
    ModelRenderer Shape110;
    ModelRenderer Shape111;
    ModelRenderer Shape112;
    ModelRenderer Shape200;
    ModelRenderer Shape301;
    ModelRenderer Shape401;
    ModelRenderer Shape501;
    ModelRenderer Shape302;
    ModelRenderer Shape402;
    ModelRenderer Shape502;
  
  public ModelMillstoneParent()
  {
    textureWidth = 256;
    textureHeight = 128;
    
      Shape101 = new ModelRenderer(this, 0, 0);
      Shape101.addBox(-6.5F, -8F, -24F, 13, 16, 3);
      Shape101.setRotationPoint(0F, 16F, 0F);
      Shape101.setTextureSize(64, 32);
      Shape101.mirror = true;
      setRotation(Shape101, 0F, 0F, 0F);
      Shape102 = new ModelRenderer(this, 0, 0);
      Shape102.addBox(-6.5F, -8F, -24F, 13, 16, 3);
      Shape102.setRotationPoint(0F, 16F, 0F);
      Shape102.setTextureSize(64, 32);
      Shape102.mirror = true;
      setRotation(Shape102, 0F, -0.5235988F, 0F);
      Shape103 = new ModelRenderer(this, 0, 0);
      Shape103.addBox(-6.5F, -8F, -24F, 13, 16, 3);
      Shape103.setRotationPoint(0F, 16F, 0F);
      Shape103.setTextureSize(64, 32);
      Shape103.mirror = true;
      setRotation(Shape103, 0F, -1.047198F, 0F);
      Shape104 = new ModelRenderer(this, 0, 0);
      Shape104.addBox(-6.5F, -8F, -24F, 13, 16, 3);
      Shape104.setRotationPoint(0F, 16F, 0F);
      Shape104.setTextureSize(64, 32);
      Shape104.mirror = true;
      setRotation(Shape104, 0F, -1.570796F, 0F);
      Shape105 = new ModelRenderer(this, 0, 0);
      Shape105.addBox(-6.5F, -8F, -24F, 13, 16, 3);
      Shape105.setRotationPoint(0F, 16F, 0F);
      Shape105.setTextureSize(64, 32);
      Shape105.mirror = true;
      setRotation(Shape105, 0F, -2.094395F, 0F);
      Shape106 = new ModelRenderer(this, 0, 0);
      Shape106.addBox(-6.5F, -8F, -24F, 13, 16, 3);
      Shape106.setRotationPoint(0F, 16F, 0F);
      Shape106.setTextureSize(64, 32);
      Shape106.mirror = true;
      setRotation(Shape106, 0F, -2.617994F, 0F);
      Shape107 = new ModelRenderer(this, 0, 0);
      Shape107.addBox(-6.5F, -8F, -24F, 14, 16, 3);
      Shape107.setRotationPoint(0F, 16F, 0F);
      Shape107.setTextureSize(64, 32);
      Shape107.mirror = true;
      setRotation(Shape107, 0F, -3.141593F, 0F);
      Shape108 = new ModelRenderer(this, 0, 0);
      Shape108.addBox(-6.5F, -8F, -24F, 13, 16, 3);
      Shape108.setRotationPoint(0F, 16F, 0F);
      Shape108.setTextureSize(64, 32);
      Shape108.mirror = true;
      setRotation(Shape108, 0F, 2.617994F, 0F);
      Shape109 = new ModelRenderer(this, 0, 0);
      Shape109.addBox(-6.5F, -8F, -24F, 13, 16, 3);
      Shape109.setRotationPoint(0F, 16F, 0F);
      Shape109.setTextureSize(64, 32);
      Shape109.mirror = true;
      setRotation(Shape109, 0F, 2.094395F, 0F);
      Shape110 = new ModelRenderer(this, 0, 0);
      Shape110.addBox(-6.5F, -8F, -24F, 13, 16, 3);
      Shape110.setRotationPoint(0F, 16F, 0F);
      Shape110.setTextureSize(64, 32);
      Shape110.mirror = true;
      setRotation(Shape110, 0F, 1.570796F, 0F);
      Shape111 = new ModelRenderer(this, 0, 0);
      Shape111.addBox(-6.5F, -8F, -24F, 13, 16, 3);
      Shape111.setRotationPoint(0F, 16F, 0F);
      Shape111.setTextureSize(64, 32);
      Shape111.mirror = true;
      setRotation(Shape111, 0F, 1.047198F, 0F);
      Shape112 = new ModelRenderer(this, 0, 0);
      Shape112.addBox(-6.5F, -8F, -24F, 13, 16, 3);
      Shape112.setRotationPoint(0F, 16F, 0F);
      Shape112.setTextureSize(64, 32);
      Shape112.mirror = true;
      setRotation(Shape112, 0F, 0.5235988F, 0F);
      Shape200 = new ModelRenderer(this, 39, 18);
      Shape200.addBox(-21F, 0F, -11F, 42, 12, 22);
      Shape200.setRotationPoint(0F, 12F, 0F);
      Shape200.setTextureSize(64, 32);
      Shape200.mirror = true;
      setRotation(Shape200, 0F, 0F, 0F);
      Shape301 = new ModelRenderer(this, 150, 0);
      Shape301.addBox(-18F, 0F, 11F, 36, 12, 5);
      Shape301.setRotationPoint(0F, 12F, 0F);
      Shape301.setTextureSize(64, 32);
      Shape301.mirror = true;
      setRotation(Shape301, 0F, 0F, 0F);
      Shape401 = new ModelRenderer(this, 36, 0);
      Shape401.addBox(-14.5F, 0F, 16F, 29, 12, 3);
      Shape401.setRotationPoint(0F, 12F, 0F);
      Shape401.setTextureSize(64, 32);
      Shape401.mirror = true;
      setRotation(Shape401, 0F, 0F, 0F);
      Shape501 = new ModelRenderer(this, 103, 0);
      Shape501.addBox(-9.5F, 12F, 19F, 19, 12, 3);
      Shape501.setRotationPoint(0F, 0F, 0F);
      Shape501.setTextureSize(64, 32);
      Shape501.mirror = true;
      setRotation(Shape501, 0F, 0F, 0F);
      Shape302 = new ModelRenderer(this, 150, 0);
      Shape302.addBox(-18F, 0F, -16F, 36, 12, 5);
      Shape302.setRotationPoint(0F, 12F, 0F);
      Shape302.setTextureSize(64, 32);
      Shape302.mirror = true;
      setRotation(Shape302, 0F, 0F, 0F);
      Shape402 = new ModelRenderer(this, 36, 0);
      Shape402.addBox(-14.5F, 0F, -19F, 29, 12, 3);
      Shape402.setRotationPoint(0F, 12F, 0F);
      Shape402.setTextureSize(64, 32);
      Shape402.mirror = true;
      setRotation(Shape402, 0F, 0F, 0F);
      Shape502 = new ModelRenderer(this, 103, 0);
      Shape502.addBox(-9.5F, 0F, -22F, 19, 12, 3);
      Shape502.setRotationPoint(0F, 12F, 0F);
      Shape502.setTextureSize(64, 32);
      Shape502.mirror = true;
      setRotation(Shape502, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape101.render(f5);
    Shape102.render(f5);
    Shape103.render(f5);
    Shape104.render(f5);
    Shape105.render(f5);
    Shape106.render(f5);
    Shape107.render(f5);
    Shape108.render(f5);
    Shape109.render(f5);
    Shape110.render(f5);
    Shape111.render(f5);
    Shape112.render(f5);
    Shape200.render(f5);
    Shape301.render(f5);
    Shape401.render(f5);
    Shape501.render(f5);
    Shape302.render(f5);
    Shape402.render(f5);
    Shape502.render(f5);
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
