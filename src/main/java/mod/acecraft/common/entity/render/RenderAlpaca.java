package mod.acecraft.common.entity.render;

import mod.acecraft.common.entity.EntityAlpaca;
import mod.acecraft.common.entity.model.ModelAlpaca;
import mod.acecraft.system.RegisterClient;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderAlpaca extends MobRenderer<EntityAlpaca, ModelAlpaca<EntityAlpaca>> {
	
	private static final ResourceLocation TEXTURE = new ResourceLocation("acecraft", "textures/entity/alpaca.png");
	
	
	
	
	
	// ---------- ---------- ---------- ----------  CONSTRUCTOR  ---------- ---------- ---------- ---------- //
	
	public RenderAlpaca(EntityRendererProvider.Context renderManager) {
		super(renderManager, new ModelAlpaca<>(renderManager.bakeLayer(RegisterClient.ALPACA_MODEL)), 0.5F);
		this.addLayer(new RenderAlpacaLayer(this, renderManager.getModelSet()));
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SUPPORT  ---------- ---------- ---------- ---------- //
	
	@Override
	public ResourceLocation getTextureLocation(EntityAlpaca p_110775_1_) {
		return TEXTURE;
	}
	
	
	
}
