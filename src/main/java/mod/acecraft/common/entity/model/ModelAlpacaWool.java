package mod.acecraft.common.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mod.acecraft.common.entity.EntityAlpaca;
import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelAlpacaWool<T extends EntityAlpaca> extends AgeableListModel<T> {
	
	private final ModelPart Body;
	private final ModelPart LegBackRight;
	private final ModelPart LegBackLeft;
	private final ModelPart LegFrontRight;
	private final ModelPart LegFrontLeft;
	private final ModelPart Head;
	
	private float headXRot;
	
	
	
	
	
	// ---------- ---------- ---------- ----------  CONSTRUCTOR  ---------- ---------- ---------- ---------- //
	
	public ModelAlpacaWool(ModelPart part) {
		super(true, 12.0F, 6.0F);
		Body          = part.getChild("body");
		LegBackRight  = part.getChild("leg_back_right");
		LegBackLeft   = part.getChild("leg_back_left");
		LegFrontRight = part.getChild("leg_front_right");
		LegFrontLeft  = part.getChild("leg_front_left");
		Head          = part.getChild("head");
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  CREATE  ---------- ---------- ---------- ---------- //
	
	public static LayerDefinition createBodyLayer() {
		MeshDefinition modelDefinition = new MeshDefinition();
		PartDefinition def = modelDefinition.getRoot();
		def.addOrReplaceChild("body",            CubeListBuilder.create().texOffs( 0,  0).addBox(-6.0F, -20.0F, -9.0F, 12.0F, 10.0F, 18.0F),                                                                 PartPose.offset( 0.0F, 24.0F,  0.0F));
		def.addOrReplaceChild("leg_back_right",  CubeListBuilder.create().texOffs( 0,  0).addBox(-2.0F,   0.0F, -2.0F,  4.0F, 10.0F,  4.0F),                                                                 PartPose.offset(-2.5F, 12.0F,  5.5F));
		def.addOrReplaceChild("leg_back_left",   CubeListBuilder.create().texOffs(42,  0).addBox(-2.0F,   0.0F, -2.0F,  4.0F, 10.0F,  4.0F),                                                                 PartPose.offset( 2.5F, 12.0F,  5.5F));
		def.addOrReplaceChild("leg_front_right", CubeListBuilder.create().texOffs( 0, 44).addBox(-2.0F,   0.0F, -2.0F,  4.0F, 10.0F,  4.0F),                                                                 PartPose.offset(-2.5F, 12.0F, -5.5F));
		def.addOrReplaceChild("leg_front_left",  CubeListBuilder.create().texOffs(16, 44).addBox(-2.0F,   0.0F, -2.0F,  4.0F, 10.0F,  4.0F),                                                                 PartPose.offset( 2.5F, 12.0F, -5.5F));
		def.addOrReplaceChild("head",            CubeListBuilder.create().texOffs( 0, 28).addBox(-4.0F, -18.5F, -4.0F,  8.0F, 10.0F,  6.0F).texOffs(28, 28).addBox(-3.0F, -10.0F, -4.5F, 6.0F, 13.0F, 5.0F), PartPose.offset( 0.0F,  7.0F, -7.0F));
		return LayerDefinition.create(modelDefinition, 64, 64);
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  ANIMATION  ---------- ---------- ---------- ---------- //
	
	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.xRot = this.headXRot;
		this.Head.yRot = netHeadYaw * ((float)Math.PI / 180F);
		this.LegBackRight.xRot  = Mth.cos(limbSwing * 0.6662F                 ) * 1.4F * limbSwingAmount;
		this.LegBackLeft.xRot   = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.LegFrontRight.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		this.LegFrontLeft.xRot  = Mth.cos(limbSwing * 0.6662F                 ) * 1.4F * limbSwingAmount;
	}
	
	public void prepareMobModel(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
		super.prepareMobModel(entityIn, limbSwing, limbSwingAmount, partialTick);
		this.headXRot = entityIn.getHeadEatAngleScale(partialTick);
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  RENDER  ---------- ---------- ---------- ---------- //
	
	@Override
	public void renderToBuffer(PoseStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		matrixStack.pushPose();
		matrixStack.scale(0.75f, 0.75f, 0.75f);
		matrixStack.translate(0, 0.5f, 0);
		super.renderToBuffer(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		matrixStack.popPose();
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SUPPORT  ---------- ---------- ---------- ---------- //
	
	@Override
	protected Iterable<ModelPart> headParts() {
		return ImmutableList.of(this.Head);
	}
	
	@Override
	protected Iterable<ModelPart> bodyParts() {
		return ImmutableList.of(this.Body, this.LegBackLeft, this.LegBackRight, this.LegFrontLeft, this.LegFrontRight);
	}
	
	
	
}
