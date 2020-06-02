package net.acecraft.mod.render;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.entity.EntityCrab;
import net.acecraft.mod.entity.EntitySpear;
import net.acecraft.mod.model.ModelCrab;
import net.acecraft.mod.model.ModelDeer;
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
public class RenderCrab extends RenderLiving<EntityCrab>{
	
	public static final Factory FACTORY = new Factory();
	
    private static final ResourceLocation CRAB_TEXTURES = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/Crab.png");

    public RenderCrab(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn){
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }
    
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityCrab entity){
        return CRAB_TEXTURES;
    }
    
    public static class Factory implements IRenderFactory<EntityCrab>{
    	public Render<? super EntityCrab> createRenderFor(RenderManager manager){
    		return new RenderCrab(manager, new ModelCrab(), 1);
    	}
    }
}