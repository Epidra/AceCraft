package net.acecraft.mod.render;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.entity.EntityMammoth;
import net.acecraft.mod.entity.EntitySpear;
import net.acecraft.mod.model.ModelMammoth;
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
public class RenderMammoth extends RenderLiving<EntityMammoth>{
	
	public static final Factory FACTORY = new Factory();
	
    private static final ResourceLocation MAMMOTH_TEXTURES = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/Mammoth.png");

    public RenderMammoth(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn){
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityMammoth entity){
        return MAMMOTH_TEXTURES;
    }
    
    public static class Factory implements IRenderFactory<EntityMammoth>{
    	public Render<? super EntityMammoth> createRenderFor(RenderManager manager){
    		return new RenderMammoth(manager, new ModelMammoth(), 1);
    	}
    }
}