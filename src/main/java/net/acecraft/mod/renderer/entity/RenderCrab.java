package net.acecraft.mod.renderer.entity;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.entity.EntityCrab;
import net.acecraft.mod.model.ModelCrab;
import net.acecraft.mod.model.ModelDeer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderCrab extends RenderLiving {
	
private static final ResourceLocation texture = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/Crab.png");
	
	protected ModelCrab modelEntity;

	public RenderCrab(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		modelEntity = ((ModelCrab) mainModel);
	}
	
	public void renderCrab(EntityCrab entity, double x, double y, double z, float u, float v){
		super.doRender(entity, x, y, z, u, v);
	}
	
	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v){
		renderCrab((EntityCrab)entityLiving, x, y, z, u, v);
	}
	
	public void doRender(Entity entity, double x, double y, double z, float u, float v){
		renderCrab((EntityCrab)entity, x, y, z, u, v);
	}

	protected ResourceLocation getEntityTexture(Entity var1) {
		return texture;
	}

}