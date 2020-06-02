package net.acecraft.mod.render;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.entity.EntityGoat;
import net.acecraft.mod.entity.EntitySpear;
import net.acecraft.mod.model.ModelGoat;
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
public class RenderGoat extends RenderLiving<EntityGoat>{
	
	public static final Factory FACTORY = new Factory();
	
    private static final ResourceLocation GOAT_TEXTURES = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/Goat.png");

    public RenderGoat(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn){
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityGoat entity){
        return GOAT_TEXTURES;
    }
    
    public static class Factory implements IRenderFactory<EntityGoat>{
    	public Render<? super EntityGoat> createRenderFor(RenderManager manager){
    		return new RenderGoat(manager, new ModelGoat(), 1);
    	}
    }
}