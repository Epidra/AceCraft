package net.acecraft.mod.renderer.entity;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.entity.EntityCarrotWhite;
import net.acecraft.mod.model.ModelCarrot;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderCarrotWhite extends RenderLiving {
	
private static final ResourceLocation texture = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/CarrotWhite.png");
	
	protected ModelCarrot modelEntity;

	public RenderCarrotWhite(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		modelEntity = ((ModelCarrot) mainModel);
	}
	
	public void renderCarrot(EntityCarrotWhite entity, double x, double y, double z, float u, float v){
		super.doRender(entity, x, y, z, u, v);
	}
	
	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v){
		renderCarrot((EntityCarrotWhite)entityLiving, x, y, z, u, v);
	}
	
	public void doRender(Entity entity, double x, double y, double z, float u, float v){
		renderCarrot((EntityCarrotWhite)entity, x, y, z, u, v);
	}

	protected ResourceLocation getEntityTexture(Entity var1) {
		return texture;
	}

}