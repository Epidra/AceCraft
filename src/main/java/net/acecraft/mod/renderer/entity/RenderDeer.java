package net.acecraft.mod.renderer.entity;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.entity.EntityDeer;
import net.acecraft.mod.model.ModelDeer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderDeer extends RenderLiving {
	
private static final ResourceLocation texture = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/Deer.png");
	
	protected ModelDeer modelEntity;

	public RenderDeer(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		modelEntity = ((ModelDeer) mainModel);
	}
	
	public void renderDeer(EntityDeer entity, double x, double y, double z, float u, float v){
		super.doRender(entity, x, y, z, u, v);
	}
	
	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v){
		renderDeer((EntityDeer)entityLiving, x, y, z, u, v);
	}
	
	public void doRender(Entity entity, double x, double y, double z, float u, float v){
		renderDeer((EntityDeer)entity, x, y, z, u, v);
	}

	protected ResourceLocation getEntityTexture(Entity var1) {
		return texture;
	}

}