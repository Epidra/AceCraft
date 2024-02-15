package mod.acecraft.common.entity.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mod.acecraft.common.entity.EntityAlpaca;
import mod.acecraft.common.entity.model.ModelAlpaca;
import mod.acecraft.common.entity.model.ModelAlpacaWool;
import mod.acecraft.system.RegisterClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderAlpacaLayer extends RenderLayer<EntityAlpaca, ModelAlpaca<EntityAlpaca>> {
	
	private static final ResourceLocation TEXTURE = new ResourceLocation("acecraft", "textures/entity/alpaca_fur.png");
	private final ModelAlpacaWool<EntityAlpaca> modelWool;
	
	
	
	
	
	// ---------- ---------- ---------- ----------  CONSTRUCTOR  ---------- ---------- ---------- ---------- //
	
	public RenderAlpacaLayer(RenderLayerParent<EntityAlpaca, ModelAlpaca<EntityAlpaca>> model, EntityModelSet ems) {
		super(model);
		this.modelWool = new ModelAlpacaWool<>(ems.bakeLayer(RegisterClient.ALPACA_LAYER));
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  RENDER  ---------- ---------- ---------- ---------- //
	
	public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packetLight, EntityAlpaca entity, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!entity.isSheared()) {
			if (entity.isInvisible()) {
				Minecraft minecraft = Minecraft.getInstance();
				boolean flag = minecraft.shouldEntityAppearGlowing(entity);
				if (flag) {
					this.getParentModel().copyPropertiesTo(this.modelWool);
					this.modelWool.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTick);
					this.modelWool.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
					VertexConsumer vertexconsumer = bufferSource.getBuffer(RenderType.outline(TEXTURE));
					this.modelWool.renderToBuffer(poseStack, vertexconsumer, packetLight, LivingEntityRenderer.getOverlayCoords(entity, 0.0F), 0.0F, 0.0F, 0.0F, 1.0F);
				}
			} else {
				float f;
				float f1;
				float f2;
				if (entity.hasCustomName() && "jeb_".equals(entity.getName().getContents())) {
					int i1 = 25;
					int i = entity.tickCount / 25 + entity.getId();
					int j = DyeColor.values().length;
					int k = i % j;
					int l = (i + 1) % j;
					float f3 = ((float)(entity.tickCount % 25) + partialTick) / 25.0F;
					float[] afloat1 = EntityAlpaca.getColorArray(DyeColor.byId(k));
					float[] afloat2 = EntityAlpaca.getColorArray(DyeColor.byId(l));
					f = afloat1[0] * (1.0F - f3) + afloat2[0] * f3;
					f1 = afloat1[1] * (1.0F - f3) + afloat2[1] * f3;
					f2 = afloat1[2] * (1.0F - f3) + afloat2[2] * f3;
				} else {
					float[] afloat = EntityAlpaca.getColorArray(entity.getColor());
					f = afloat[0];
					f1 = afloat[1];
					f2 = afloat[2];
				}
				coloredCutoutModelCopyLayerRender(this.getParentModel(), this.modelWool, TEXTURE, poseStack, bufferSource, packetLight, entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, partialTick, f, f1, f2);
			}
		}
	}
	
	
	
}
