package net.acecraft.mod.render;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.entity.EntityChocobo;
import net.acecraft.mod.entity.EntityLlama;
import net.acecraft.mod.entity.EntitySpear;
import net.acecraft.mod.model.ModelChocobo;
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
public class RenderChocobo extends RenderLiving<EntityChocobo>{
	
	public static final Factory FACTORY = new Factory();
	
	private static final ResourceLocation textureGrey   = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/ChocoboGrey.png");
	private static final ResourceLocation textureRed    = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/ChocoboRed.png");
	private static final ResourceLocation textureGreen  = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/ChocoboGreen.png");
	private static final ResourceLocation textureBlue   = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/ChocoboBlue.png");
	private static final ResourceLocation textureOrange = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/ChocoboOrange.png");
	private static final ResourceLocation textureViolet = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/ChocoboViolet.png");
	private static final ResourceLocation textureYellow = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/ChocoboYellow.png");
	
	private static final ResourceLocation textureChildGrey   = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/ChicoboGrey.png");
	private static final ResourceLocation textureChildRed    = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/ChicoboRed.png");
	private static final ResourceLocation textureChildGreen  = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/ChicoboGreen.png");
	private static final ResourceLocation textureChildBlue   = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/ChicoboBlue.png");
	private static final ResourceLocation textureChildOrange = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/ChicoboOrange.png");
	private static final ResourceLocation textureChildViolet = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/ChicoboViolet.png");
	private static final ResourceLocation textureChildYellow = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/ChicoboYellow.png");

    public RenderChocobo(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn){
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityChocobo entity){
    	if(entity.isChild()){
    		switch(entity.getFeatherColor()){
				case GREY:   return textureChildGrey;
				case RED:    return textureChildRed;
				case GREEN:  return textureChildGreen;
				case BLUE:   return textureChildBlue;
				case ORANGE: return textureChildOrange;
				case VIOLET: return textureChildViolet;
				case YELLOW: return textureChildYellow;
    		}
    	} else {
    		switch(entity.getFeatherColor()){
				case GREY:   return textureGrey;
				case RED:    return textureRed;
				case GREEN:  return textureGreen;
				case BLUE:   return textureBlue;
				case ORANGE: return textureOrange;
				case VIOLET: return textureViolet;
				case YELLOW: return textureYellow;
    		}
    	}
		return textureGrey;
    }
    
    public static class Factory implements IRenderFactory<EntityChocobo>{
    	public Render<? super EntityChocobo> createRenderFor(RenderManager manager){
    		return new RenderChocobo(manager, new ModelChocobo(), 1);
    	}
    }
}