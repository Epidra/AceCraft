package mod.acecraft.common.entity.render;

import mod.acecraft.common.entity.EntityAlpaca;
import mod.acecraft.common.entity.model.ModelAlpaca;
import mod.acecraft.common.entity.model.ModelAlpacaWool;
import net.minecraft.client.model.SheepModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.SheepRenderer;
import net.minecraft.client.renderer.entity.layers.SheepFurLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Sheep;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderAlpaca extends MobRenderer<EntityAlpaca, ModelAlpaca<EntityAlpaca>> {
	private static final ResourceLocation SHEEP_LOCATION = ResourceLocation.withDefaultNamespace("textures/entity/sheep/sheep.png");
	
	public RenderAlpaca(EntityRendererProvider.Context p_174366_) {
		super(p_174366_, new ModelAlpaca<>(p_174366_.bakeLayer(ModelLayers.SHEEP)), 0.7F);
		this.addLayer(new RenderAlpacaWool(this, p_174366_.getModelSet()));
		
		
	}
	
	/**
	 * Returns the location of an entity's texture.
	 */
	public ResourceLocation getTextureLocation(EntityAlpaca entity) {
		return SHEEP_LOCATION;
	}
}
