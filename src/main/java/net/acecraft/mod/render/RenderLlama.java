package net.acecraft.mod.render;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.entity.EntityLlama;
import net.acecraft.mod.entity.EntitySpear;
import net.acecraft.mod.model.ModelLlama;
import net.acecraft.mod.render.RenderSpear.Factory;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderLlama extends RenderLiving<EntityLlama>{
	
	public static final Factory FACTORY = new Factory();
	
	private static final ResourceLocation textureFurBlack     = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/LlamaFurBlack.png");
	private static final ResourceLocation textureFurBlue      = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/LlamaFurBlue.png");
	private static final ResourceLocation textureFurBrown     = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/LlamaFurBrown.png");
	private static final ResourceLocation textureFurCyan      = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/LlamaFurCyan.png");
	private static final ResourceLocation textureFurGray      = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/LlamaFurGray.png");
	private static final ResourceLocation textureFurGreen     = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/LlamaFurGreen.png");
	private static final ResourceLocation textureFurLightBlue = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/LlamaFurLightBlue.png");
	private static final ResourceLocation textureFurLime      = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/LlamaFurLime.png");
	private static final ResourceLocation textureFurMagenta   = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/LlamaFurMagenta.png");
	private static final ResourceLocation textureFurOrange    = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/LlamaFurOrange.png");
	private static final ResourceLocation textureFurPink      = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/LlamaFurPink.png");
	private static final ResourceLocation textureFurPurple    = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/LlamaFurPurple.png");
	private static final ResourceLocation textureFurRed       = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/LlamaFurRed.png");
	private static final ResourceLocation textureFurSilver    = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/LlamaFurSilver.png");
	private static final ResourceLocation textureFurWhite     = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/LlamaFurWhite.png");
	private static final ResourceLocation textureFurYellow    = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/LlamaFurYellow.png");
	
	private static final ResourceLocation textureShearedBlack     = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/LlamaShearedBlack.png");
	private static final ResourceLocation textureShearedBlue      = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/LlamaShearedBlue.png");
	private static final ResourceLocation textureShearedBrown     = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/LlamaShearedBrown.png");
	private static final ResourceLocation textureShearedCyan      = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/LlamaShearedCyan.png");
	private static final ResourceLocation textureShearedGray      = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/LlamaShearedGray.png");
	private static final ResourceLocation textureShearedGreen     = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/LlamaShearedGreen.png");
	private static final ResourceLocation textureShearedLightBlue = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/LlamaShearedLightBlue.png");
	private static final ResourceLocation textureShearedLime      = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/LlamaShearedLime.png");
	private static final ResourceLocation textureShearedMagenta   = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/LlamaShearedMagenta.png");
	private static final ResourceLocation textureShearedOrange    = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/LlamaShearedOrange.png");
	private static final ResourceLocation textureShearedPink      = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/LlamaShearedPink.png");
	private static final ResourceLocation textureShearedPurple    = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/LlamaShearedPurple.png");
	private static final ResourceLocation textureShearedRed       = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/LlamaShearedRed.png");
	private static final ResourceLocation textureShearedSilver    = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/LlamaShearedSilver.png");
	private static final ResourceLocation textureShearedWhite     = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/LlamaShearedWhite.png");
	private static final ResourceLocation textureShearedYellow    = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/LlamaShearedYellow.png");

    public RenderLlama(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn){
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityLlama entity){
		if(entity.getSheared()) {
			switch(entity.getFleeceColor()){
				case WHITE: return textureShearedWhite;
				case ORANGE: return textureShearedOrange;
				case MAGENTA: return textureShearedMagenta;
				case LIGHT_BLUE: return textureShearedLightBlue;
				case YELLOW: return textureShearedYellow;
				case LIME: return textureShearedLime;
				case PINK: return textureShearedPink;
				case GRAY: return textureShearedGray;
				case SILVER: return textureShearedSilver;
				case CYAN: return textureShearedCyan;
				case PURPLE: return textureShearedPurple;
				case BLUE: return textureShearedBlue;
				case BROWN: return textureShearedBrown;
				case GREEN: return textureShearedGreen;
				case RED: return textureShearedRed;
				case BLACK: return textureShearedBlack;
			}
		} else {
			switch(entity.getFleeceColor()){
				case WHITE: return textureFurWhite;
				case ORANGE: return textureFurOrange;
				case MAGENTA: return textureFurMagenta;
				case LIGHT_BLUE: return textureFurLightBlue;
				case YELLOW: return textureFurYellow;
				case LIME: return textureFurLime;
				case PINK: return textureFurPink;
				case GRAY: return textureFurGray;
				case SILVER: return textureFurSilver;
				case CYAN: return textureFurCyan;
				case PURPLE: return textureFurPurple;
				case BLUE: return textureFurBlue;
				case BROWN: return textureFurBrown;
				case GREEN: return textureFurGreen;
				case RED: return textureFurRed;
				case BLACK: return textureFurBlack;
			}
		}
		return textureShearedBlack;
    }
    
    public static class Factory implements IRenderFactory<EntityLlama>{
    	public Render<? super EntityLlama> createRenderFor(RenderManager manager){
    		return new RenderLlama(manager, new ModelLlama(), 1);
    	}
    }
}