package mod.acecraft.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelCrab extends ModelBase {
	
	//fields
    ModelRenderer BodyLower;
    ModelRenderer BodyUpper;
    ModelRenderer LegLeft1;
    ModelRenderer LegLeft2;
    ModelRenderer LegLeft3;
    ModelRenderer LegLeft4;
    ModelRenderer LegRight1;
    ModelRenderer LegRight2;
    ModelRenderer LegRight3;
    ModelRenderer LegRight4;
    ModelRenderer StalkLeft;
    ModelRenderer StalkRight;
    ModelRenderer EyeLeft;
    ModelRenderer EyeRight;
    ModelRenderer ArmLeft;
    ModelRenderer ClawLeftUpper;
    ModelRenderer ClawLeftLower;
    ModelRenderer ArmRight;
    ModelRenderer ClawRightUpper;
    ModelRenderer ClawRightLower;
  
  public ModelCrab()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      BodyLower = new ModelRenderer(this, 0, 10);
      BodyLower.addBox(-4F, -2F, -6F, 8, 5, 12);
      BodyLower.setRotationPoint(0F, 18F, 0F);
      BodyLower.setTextureSize(128, 64);
      BodyLower.mirror = true;
      setRotation(BodyLower, 0F, 0F, 0F);
      BodyUpper = new ModelRenderer(this, 6, 0);
      BodyUpper.addBox(-3F, -4F, -4F, 6, 2, 8);
      BodyUpper.setRotationPoint(0F, 18F, 0F);
      BodyUpper.setTextureSize(128, 64);
      BodyUpper.mirror = true;
      setRotation(BodyUpper, 0F, 0F, 0F);
      LegLeft1 = new ModelRenderer(this, 0, 28);
      LegLeft1.addBox(2.5F, 1F, 1F, 1, 5, 1);
      LegLeft1.setRotationPoint(0F, 19F, 4F);
      LegLeft1.setTextureSize(128, 64);
      LegLeft1.mirror = true;
      setRotation(LegLeft1, 0.2617994F, 0F, 0F);
      LegLeft2 = new ModelRenderer(this, 4, 28);
      LegLeft2.addBox(0.5F, 1F, 1F, 1, 5, 1);
      LegLeft2.setRotationPoint(0F, 19F, 4F);
      LegLeft2.setTextureSize(128, 64);
      LegLeft2.mirror = true;
      setRotation(LegLeft2, 0.2617994F, 0F, 0F);
      LegLeft3 = new ModelRenderer(this, 8, 28);
      LegLeft3.addBox(-1.5F, 1F, 1F, 1, 5, 1);
      LegLeft3.setRotationPoint(0F, 19F, 4F);
      LegLeft3.setTextureSize(128, 64);
      LegLeft3.mirror = true;
      setRotation(LegLeft3, 0.2617994F, 0F, 0F);
      LegLeft4 = new ModelRenderer(this, 12, 28);
      LegLeft4.addBox(-3.5F, 1F, 1F, 1, 5, 1);
      LegLeft4.setRotationPoint(0F, 19F, 4F);
      LegLeft4.setTextureSize(128, 64);
      LegLeft4.mirror = true;
      setRotation(LegLeft4, 0.2617994F, 0F, 0F);
      LegRight1 = new ModelRenderer(this, 36, 28);
      LegRight1.addBox(2.5F, 1F, -2F, 1, 5, 1);
      LegRight1.setRotationPoint(0F, 19F, -4F);
      LegRight1.setTextureSize(128, 64);
      LegRight1.mirror = true;
      setRotation(LegRight1, -0.2617994F, 0F, 0F);
      LegRight2 = new ModelRenderer(this, 32, 28);
      LegRight2.addBox(0.5F, 1F, -2F, 1, 5, 1);
      LegRight2.setRotationPoint(0F, 19F, -4F);
      LegRight2.setTextureSize(128, 64);
      LegRight2.mirror = true;
      setRotation(LegRight2, -0.2617994F, 0F, 0F);
      LegRight3 = new ModelRenderer(this, 28, 28);
      LegRight3.addBox(-1.5F, 1F, -2F, 1, 5, 1);
      LegRight3.setRotationPoint(0F, 19F, -4F);
      LegRight3.setTextureSize(128, 64);
      LegRight3.mirror = true;
      setRotation(LegRight3, -0.2617994F, 0F, 0F);
      LegRight4 = new ModelRenderer(this, 24, 28);
      LegRight4.addBox(-3.5F, 1F, -2F, 1, 5, 1);
      LegRight4.setRotationPoint(0F, 19F, -4F);
      LegRight4.setTextureSize(128, 64);
      LegRight4.mirror = true;
      setRotation(LegRight4, -0.2617994F, 0F, 0F);
      StalkLeft = new ModelRenderer(this, 42, 8);
      StalkLeft.addBox(-0.5F, -3F, 2F, 1, 4, 1);
      StalkLeft.setRotationPoint(3F, 14F, 0F);
      StalkLeft.setTextureSize(128, 64);
      StalkLeft.mirror = true;
      setRotation(StalkLeft, 0F, 0F, 0.3490659F);
      StalkRight = new ModelRenderer(this, 55, 8);
      StalkRight.addBox(-0.5F, -3F, -3F, 1, 4, 1);
      StalkRight.setRotationPoint(3F, 14F, 0F);
      StalkRight.setTextureSize(128, 64);
      StalkRight.mirror = true;
      setRotation(StalkRight, 0F, 0F, 0.8726646F);
      EyeLeft = new ModelRenderer(this, 38, 1);
      EyeLeft.addBox(-1.5F, -6F, 1F, 3, 3, 3);
      EyeLeft.setRotationPoint(3F, 14F, 0F);
      EyeLeft.setTextureSize(128, 64);
      EyeLeft.mirror = true;
      setRotation(EyeLeft, 0F, 0F, 0.3490659F);
      EyeRight = new ModelRenderer(this, 51, 1);
      EyeRight.addBox(-1.5F, -6F, -4F, 3, 3, 3);
      EyeRight.setRotationPoint(3F, 14F, 0F);
      EyeRight.setTextureSize(128, 64);
      EyeRight.mirror = true;
      setRotation(EyeRight, 0F, 0F, 0.8726646F);
      ArmLeft = new ModelRenderer(this, 67, 1);
      ArmLeft.addBox(-1F, -1F, -1F, 3, 2, 2);
      ArmLeft.setRotationPoint(4F, 18F, 5F);
      ArmLeft.setTextureSize(128, 64);
      ArmLeft.mirror = true;
      setRotation(ArmLeft, 0F, -0.5235988F, 0F);
      ClawLeftUpper = new ModelRenderer(this, 65, 6);
      ClawLeftUpper.addBox(2F, -1F, -7F, 4, 2, 8);
      ClawLeftUpper.setRotationPoint(4F, 18F, 5F);
      ClawLeftUpper.setTextureSize(128, 64);
      ClawLeftUpper.mirror = true;
      setRotation(ClawLeftUpper, 0F, -0.5235988F, 0F);
      ClawLeftLower = new ModelRenderer(this, 68, 17);
      ClawLeftLower.addBox(2.5F, 1F, -5F, 3, 1, 6);
      ClawLeftLower.setRotationPoint(4F, 18F, 5F);
      ClawLeftLower.setTextureSize(128, 64);
      ClawLeftLower.mirror = true;
      setRotation(ClawLeftLower, 0F, -0.5235988F, 0F);
      ArmRight = new ModelRenderer(this, 62, 26);
      ArmRight.addBox(0F, -0.5F, -0.5F, 2, 1, 1);
      ArmRight.setRotationPoint(4F, 18F, -5F);
      ArmRight.setTextureSize(128, 64);
      ArmRight.mirror = true;
      setRotation(ArmRight, 0F, -0.0872665F, 0F);
      ClawRightUpper = new ModelRenderer(this, 55, 29);
      ClawRightUpper.addBox(1.5F, -1F, -1F, 2, 1, 5);
      ClawRightUpper.setRotationPoint(4F, 18F, -5F);
      ClawRightUpper.setTextureSize(128, 64);
      ClawRightUpper.mirror = true;
      setRotation(ClawRightUpper, 0F, 0F, 0F);
      ClawRightLower = new ModelRenderer(this, 58, 36);
      ClawRightLower.addBox(2F, 0F, -1F, 1, 1, 3);
      ClawRightLower.setRotationPoint(4F, 18F, -5F);
      ClawRightLower.setTextureSize(128, 64);
      ClawRightLower.mirror = true;
      setRotation(ClawRightLower, -0.2094395F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    if(this.isChild){
    	GlStateManager.pushMatrix();
	    	GlStateManager.translate(0, 0.75f, 0);
	    	GlStateManager.scale(0.5f, 0.5f, 0.5f);
	    	BodyLower.render(f5);
	        BodyUpper.render(f5);
	        LegLeft1.render(f5);
	        LegLeft2.render(f5);
	        LegLeft3.render(f5);
	        LegLeft4.render(f5);
	        LegRight1.render(f5);
	        LegRight2.render(f5);
	        LegRight3.render(f5);
	        LegRight4.render(f5);
	        StalkLeft.render(f5);
	        StalkRight.render(f5);
	        EyeLeft.render(f5);
	        EyeRight.render(f5);
	        ArmLeft.render(f5);
	        ClawLeftUpper.render(f5);
	        ClawLeftLower.render(f5);
	        ArmRight.render(f5);
	        ClawRightUpper.render(f5);
	        ClawRightLower.render(f5);
        GlStateManager.popMatrix();
    } else {
    	BodyLower.render(f5);
        BodyUpper.render(f5);
        LegLeft1.render(f5);
        LegLeft2.render(f5);
        LegLeft3.render(f5);
        LegLeft4.render(f5);
        LegRight1.render(f5);
        LegRight2.render(f5);
        LegRight3.render(f5);
        LegRight4.render(f5);
        StalkLeft.render(f5);
        StalkRight.render(f5);
        EyeLeft.render(f5);
        EyeRight.render(f5);
        ArmLeft.render(f5);
        ClawLeftUpper.render(f5);
        ClawLeftLower.render(f5);
        ArmRight.render(f5);
        ClawRightUpper.render(f5);
        ClawRightLower.render(f5);
    }
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
    this.EyeLeft  .rotateAngleY = f3 / (180F / (float)Math.PI);
    this.EyeLeft  .rotateAngleX = f4 / (180F / (float)Math.PI);
    this.EyeRight .rotateAngleY = f3 / (180F / (float)Math.PI);
    this.EyeRight .rotateAngleX = f4 / (180F / (float)Math.PI);
    this.LegLeft1 .rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.LegLeft1 .rotateAngleY = 0.0F;
    this.LegLeft2 .rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.LegLeft2 .rotateAngleY = 0.0F;
    this.LegLeft3 .rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.LegLeft3 .rotateAngleY = 0.0F;
    this.LegLeft4 .rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.LegLeft4 .rotateAngleY = 0.0F;
    this.LegRight1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.LegRight1.rotateAngleY = 0.0F;
    this.LegRight2.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.LegRight2.rotateAngleY = 0.0F;
    this.LegRight3.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.LegRight3.rotateAngleY = 0.0F;
    this.LegRight4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.LegRight4.rotateAngleY = 0.0F;
  }
	
}
