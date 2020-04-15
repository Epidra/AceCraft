package mod.acecraft.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelAxle <T extends Entity> extends EntityModel<T> {

    //fields
    ModelRenderer Shape1;

    public ModelAxle()
    {
        textureWidth = 64;
        textureHeight = 32;

        Shape1 = new ModelRenderer(this, 0, 0);
        Shape1.addBox(-3F, -3F, -8F, 6, 6, 16);
        Shape1.setRotationPoint(0F, 0F, 0F);
        Shape1.setTextureSize(64, 32);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
    }

    @Override
    public void render(T t, float v, float v1, float v2, float v3, float v4) {

    }

   // public void render(T entity, float f, float f1, float f2, float f3, float f4, float f5)
   // {
   //     super.render(entity, f, f1, f2, f3, f4, f5);
   //     setRotationAngles(entity, f, f1, f2, f3, f4, f5);
   //     Shape1.render(f5);
   // }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(T entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
       // super.setRotationAngles(entity, f, f1, f2, f3, f4, f5);
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder iVertexBuilder, int i, int i1, float v, float v1, float v2, float v3) {

    }
}

