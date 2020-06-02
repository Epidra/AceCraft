package net.acecraft.mod.renderer.entity;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.entity.EntityLlama;
import net.acecraft.mod.model.ModelLlama;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderLlama extends RenderLiving {
	
	private static final ResourceLocation textureFurBlack     = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/LlamaFurBlack.png");
	private static final ResourceLocation textureFurBlue      = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/LlamaFurBlue.png");
	private static final ResourceLocation textureFurBrown     = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/LlamaFurBrown.png");
	private static final ResourceLocation textureFurCyan      = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/LlamaFurCyan.png");
	private static final ResourceLocation textureFurGray      = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/LlamaFurGray.png");
	private static final ResourceLocation textureFurGreen     = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/LlamaFurGreen.png");
	private static final ResourceLocation textureFurLightBlue = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/LlamaFurLightBlue.png");
	private static final ResourceLocation textureFurLime      = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/LlamaFurLime.png");
	private static final ResourceLocation textureFurMagenta   = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/LlamaFurMagenta.png");
	private static final ResourceLocation textureFurOrange    = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/LlamaFurOrange.png");
	private static final ResourceLocation textureFurPink      = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/LlamaFurPink.png");
	private static final ResourceLocation textureFurPurple    = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/LlamaFurPurple.png");
	private static final ResourceLocation textureFurRed       = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/LlamaFurRed.png");
	private static final ResourceLocation textureFurSilver    = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/LlamaFurSilver.png");
	private static final ResourceLocation textureFurWhite     = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/LlamaFurWhite.png");
	private static final ResourceLocation textureFurYellow    = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/LlamaFurYellow.png");
	
	private static final ResourceLocation textureShearedBlack     = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/LlamaShearedBlack.png");
	private static final ResourceLocation textureShearedBlue      = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/LlamaShearedBlue.png");
	private static final ResourceLocation textureShearedBrown     = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/LlamaShearedBrown.png");
	private static final ResourceLocation textureShearedCyan      = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/LlamaShearedCyan.png");
	private static final ResourceLocation textureShearedGray      = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/LlamaShearedGray.png");
	private static final ResourceLocation textureShearedGreen     = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/LlamaShearedGreen.png");
	private static final ResourceLocation textureShearedLightBlue = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/LlamaShearedLightBlue.png");
	private static final ResourceLocation textureShearedLime      = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/LlamaShearedLime.png");
	private static final ResourceLocation textureShearedMagenta   = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/LlamaShearedMagenta.png");
	private static final ResourceLocation textureShearedOrange    = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/LlamaShearedOrange.png");
	private static final ResourceLocation textureShearedPink      = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/LlamaShearedPink.png");
	private static final ResourceLocation textureShearedPurple    = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/LlamaShearedPurple.png");
	private static final ResourceLocation textureShearedRed       = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/LlamaShearedRed.png");
	private static final ResourceLocation textureShearedSilver    = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/LlamaShearedSilver.png");
	private static final ResourceLocation textureShearedWhite     = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/LlamaShearedWhite.png");
	private static final ResourceLocation textureShearedYellow    = new ResourceLocation(AceCraft.modid + ":" + "textures/model/entity/LlamaShearedYellow.png");
	
	protected ModelLlama modelEntity;

	public RenderLlama(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		modelEntity = ((ModelLlama) mainModel);
	}
	
	public void renderLlama(EntityLlama entity, double x, double y, double z, float u, float v){
		super.doRender(entity, x, y, z, u, v);
	}
	
	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v){
		renderLlama((EntityLlama)entityLiving, x, y, z, u, v);
		EntityLlama entity = (EntityLlama)entityLiving;
	}
	
	public void doRender(Entity entity, double x, double y, double z, float u, float v){
		renderLlama((EntityLlama)entity, x, y, z, u, v);
	}

	protected ResourceLocation getEntityTexture(Entity var1) {
		EntityLlama entity = (EntityLlama)var1;
		if(entity.getSheared()) {
			switch(entity.getFleeceColor()){
				case  0: return textureShearedWhite;
				case  1: return textureShearedOrange;
				case  2: return textureShearedMagenta;
				case  3: return textureShearedLightBlue;
				case  4: return textureShearedYellow;
				case  5: return textureShearedLime;
				case  6: return textureShearedPink;
				case  7: return textureShearedGray;
				case  8: return textureShearedSilver;
				case  9: return textureShearedCyan;
				case 10: return textureShearedPurple;
				case 11: return textureShearedBlue;
				case 12: return textureShearedBrown;
				case 13: return textureShearedGreen;
				case 14: return textureShearedRed;
				case 15: return textureShearedBlack;
			}
		} else {
			switch(entity.getFleeceColor()){
				case  0: return textureFurWhite;
				case  1: return textureFurOrange;
				case  2: return textureFurMagenta;
				case  3: return textureFurLightBlue;
				case  4: return textureFurYellow;
				case  5: return textureFurLime;
				case  6: return textureFurPink;
				case  7: return textureFurGray;
				case  8: return textureFurSilver;
				case  9: return textureFurCyan;
				case 10: return textureFurPurple;
				case 11: return textureFurBlue;
				case 12: return textureFurBrown;
				case 13: return textureFurGreen;
				case 14: return textureFurRed;
				case 15: return textureFurBlack;
			}
		}
		return textureShearedBlack;
	}

}