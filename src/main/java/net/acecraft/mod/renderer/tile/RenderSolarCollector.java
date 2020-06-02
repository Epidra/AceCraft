package net.acecraft.mod.renderer.tile;

import org.lwjgl.opengl.GL11;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.model.ModelSolarCollectorChild;
import net.acecraft.mod.model.ModelSolarCollectorParent;
import net.acecraft.mod.tileentity.TileEntitySolarCollector;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderSolarCollector extends TileEntitySpecialRenderer {
	
	private static final ResourceLocation textureIdle   = new ResourceLocation(AceCraft.modid + ":" + "textures/model/SolarCollectorIdle.png");
	private static final ResourceLocation textureActive = new ResourceLocation(AceCraft.modid + ":" + "textures/model/SolarCollectorActive.png");
	
	private ModelSolarCollectorParent modelParent;
	private ModelSolarCollectorChild  modelChild;
	
	public RenderSolarCollector(){
		this.modelParent = new ModelSolarCollectorParent();
		this.modelChild  = new ModelSolarCollectorChild();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		ResourceLocation texture = textureIdle;
		int time = -1;
		int rotation = 0;
        if (tileentity.getWorldObj() != null) {
        	TileEntitySolarCollector entity = (TileEntitySolarCollector)tileentity;
        	time = entity.time;
        	if(entity.energy > 0){
        		texture = textureActive;
        	}
        }
        if(time == -1){
        	rotation = -90;
        }else
        if(time > 12000){
        	rotation = (int) (180 -(int) (time-12000)*1.5/100);
        }else{
        	rotation = (int) (time*1.5/100);
        }
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F); 
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		this.modelParent.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glRotatef(90-rotation, 0.0F, 1.0F, 0F);
		this.modelChild.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}