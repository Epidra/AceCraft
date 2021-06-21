package mod.acecraft.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import mod.acecraft.entity.EntityAlpaca;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// Made with Blockbench 3.8.3
// Exported for Minecraft version 1.15 - 1.16
// Paste this class into your mod and generate all required imports

@OnlyIn(Dist.CLIENT)
public class ModelAlpacaWool<T extends EntityAlpaca> extends AgeableModel<T> {

    private final ModelRenderer Body;
    private final ModelRenderer LegBackRight;
    private final ModelRenderer LegBackLeft;
    private final ModelRenderer LegFrontRight;
    private final ModelRenderer LegFrontLeft;
    private final ModelRenderer Head;

    private float headXRot;




    //----------------------------------------CONSTRUCTOR----------------------------------------//

    public ModelAlpacaWool() {
        super(true, 30.0f, 2.0f, 3.0f, 2.5f, 35.0f);

        texWidth = 64;
        texHeight = 64;

        Body = new ModelRenderer(this);
        Body.setPos(0.0F, 24.0F, 0.0F);
        Body.texOffs(0, 0).addBox(-6.0F, -20.0F, -9.0F, 12.0F, 10.0F, 18.0F, 0.0F, false);

        LegBackRight = new ModelRenderer(this);
        LegBackRight.setPos(-2.5F, 12.0F, 5.5F);
        LegBackRight.texOffs(0, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, 0.0F, false);

        LegBackLeft = new ModelRenderer(this);
        LegBackLeft.setPos(2.5F, 12.0F, 5.5F);
        LegBackLeft.texOffs(42, 0).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, 0.0F, false);

        LegFrontRight = new ModelRenderer(this);
        LegFrontRight.setPos(-2.5F, 12.0F, -5.5F);
        LegFrontRight.texOffs(0, 44).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, 0.0F, false);

        LegFrontLeft = new ModelRenderer(this);
        LegFrontLeft.setPos(2.5F, 12.0F, -5.5F);
        LegFrontLeft.texOffs(16, 44).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, 0.0F, false);

        Head = new ModelRenderer(this);
        Head.setPos(0.0F, 7.0F, -7.0F);
        Head.texOffs(0, 28).addBox(-4.0F, -18.5F, -4.0F, 8.0F, 10.0F, 6.0F, 0.0F, false);
        Head.texOffs(28, 28).addBox(-3.0F, -10.0F, -4.5F, 6.0F, 13.0F, 5.0F, 0.0F, false);
    }




    //----------------------------------------ANIMATION----------------------------------------//

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.Head.xRot = this.headXRot;
        this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
        this.LegBackRight.xRot  = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.LegBackLeft.xRot   = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.LegFrontRight.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.LegFrontLeft.xRot  = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    public void prepareMobModel(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
        super.prepareMobModel(entityIn, limbSwing, limbSwingAmount, partialTick);
        this.headXRot = entityIn.getHeadEatAngleScale(partialTick);
    }




    //----------------------------------------RENDER----------------------------------------//

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        matrixStack.pushPose();
        matrixStack.scale(0.8f, 0.8f, 0.8f);
        matrixStack.translate(0, 0.35, 0);
        super.renderToBuffer(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        matrixStack.popPose();
        //Body.render(matrixStack, buffer, packedLight, packedOverlay);
        //LegBackRight.render(matrixStack, buffer, packedLight, packedOverlay);
        //LegBackLeft.render(matrixStack, buffer, packedLight, packedOverlay);
        //LegFrontRight.render(matrixStack, buffer, packedLight, packedOverlay);
        //LegFrontLeft.render(matrixStack, buffer, packedLight, packedOverlay);
        //Head.render(matrixStack, buffer, packedLight, packedOverlay);
    }




    //----------------------------------------SUPPORT----------------------------------------//

    @Override
    protected Iterable<ModelRenderer> headParts() {
        return ImmutableList.of(this.Head);
    }

    @Override
    protected Iterable<ModelRenderer> bodyParts() {
        return ImmutableList.of(this.Body, this.LegBackLeft, this.LegBackRight, this.LegFrontLeft, this.LegFrontRight);
    }

}
