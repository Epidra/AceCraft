package mod.acecraft.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelAxle <T extends Entity> extends EntityModel<T> {

    //fields
    //RendererModel Shape1;

    public ModelAxle()
    {
        textureWidth = 64;
        textureHeight = 32;

       // Shape1 = new RendererModel(this, 0, 0);
       // Shape1.addBox(-3F, -3F, -8F, 6, 6, 16);
       // Shape1.setRotationPoint(0F, 0F, 0F);
       // Shape1.setTextureSize(64, 32);
       // Shape1.mirror = true;
       // setRotation(Shape1, 0F, 0F, 0F);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

   //public void render(T entity, float f, float f1, float f2, float f3, float f4, float f5)
   //{
   //   //super.render(entity, f, f1, f2, f3, f4, f5);
   //   //setRotationAngles(entity, f, f1, f2, f3, f4, f5);
   //   //Shape1.render(f5);
   //}

   //private void setRotation(RendererModel model, float x, float y, float z)
   //{
   //  // model.rotateAngleX = x;
   //  // model.rotateAngleY = y;
   //  // model.rotateAngleZ = z;
   //}

   //public void setRotationAngles(T entity, float f, float f1, float f2, float f3, float f4, float f5)
   //{
   //    super.setRotationAngles(entity, f, f1, f2, f3, f4, f5);
   //}

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {

    }
}

