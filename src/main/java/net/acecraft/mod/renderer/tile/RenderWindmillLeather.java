package net.acecraft.mod.renderer.tile;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.model.ModelWindmillLeather;
import net.acecraft.mod.tileentity.TileEntityWindmillLeather;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderWindmillLeather extends TileEntitySpecialRenderer {
	
	private static final ResourceLocation texture = new ResourceLocation(AceCraft.modid + ":" + "textures/model/WindmillLeather.png");
	
	private ModelWindmillLeather model;
	private float energy;
	private float rotation;
	private float current;
	
	public RenderWindmillLeather(){
		this.model = new ModelWindmillLeather();
		this.energy = 5;
		this.rotation = 0;
		this.current = 0;
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		int i = 0;
        if (tileentity.getWorldObj() != null){
        	Block block = tileentity.getBlockType();
            i = tileentity.getBlockMetadata();
        }
        TileEntityWindmillLeather entity = (TileEntityWindmillLeather) tileentity;
        if(entity != null){
        	if(this.energy != entity.energy){
        		this.energy = entity.energy;
        		this.energy = energy / 200;
        	}
        }
        GL11.glPushMatrix();
	    GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F); 
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(0F-rotation, 0.0F, 1.0F, 0F);
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
        rotation = rotation + energy;
        if(rotation == 360) rotation = 0;
        if(current > energy) current = current - 0.0001F;
        if(current < energy) current = current + 0.0001F;
	}

}