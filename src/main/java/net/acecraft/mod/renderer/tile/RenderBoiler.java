package net.acecraft.mod.renderer.tile;

import org.lwjgl.opengl.GL11;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.block.machina.Boiler;
import net.acecraft.mod.model.ModelBoilerLeft0;
import net.acecraft.mod.model.ModelBoilerLeft1;
import net.acecraft.mod.model.ModelBoilerParent;
import net.acecraft.mod.model.ModelBoilerPipe;
import net.acecraft.mod.model.ModelBoilerRight0;
import net.acecraft.mod.model.ModelBoilerRight1;
import net.acecraft.mod.tileentity.TileEntityBoiler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderBoiler extends TileEntitySpecialRenderer {
	
	private static final ResourceLocation texture = new ResourceLocation(AceCraft.modid + ":" + "textures/model/Boiler.png");
	
	private ModelBoilerParent modelParent;
	private ModelBoilerPipe   modelPipe;
	private ModelBoilerLeft0  modelLeft0;
	private ModelBoilerLeft1  modelLeft1;
	private ModelBoilerRight0 modelRight0;
	private ModelBoilerRight1 modelRight1;
	
	public RenderBoiler(){
		this.modelParent = new ModelBoilerParent();
		this.modelPipe   = new ModelBoilerPipe();
		this.modelLeft0  = new ModelBoilerLeft0();
		this.modelLeft1  = new ModelBoilerLeft1();
		this.modelRight0 = new ModelBoilerRight0();
		this.modelRight1 = new ModelBoilerRight1();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		int i = 0;
		boolean hasRightSide = false;
		boolean hasLeftSide  = false;
		boolean isCrowned    = false;
        if (tileentity.getWorldObj() != null){
        	Boiler block = (Boiler) tileentity.getBlockType();
            TileEntityBoiler entity = (TileEntityBoiler)tileentity;
            i = tileentity.getBlockMetadata();
            isCrowned = entity.isCrowned;
            hasRightSide = entity.hasRightSide;
            hasLeftSide = entity.hasLeftSide;
        }
        int j = 180;
		if(i == 4) { j = 270; }
        if(i == 3) { j = 180; }
        if(i == 5) { j =  90; }
        if(i == 2) { j = 360; }
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F); 
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);	
        GL11.glRotatef(j, 0.0F, 1.0F, 0F);
		this.modelParent.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		if(isCrowned){
			this.modelPipe.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		}
		if(hasRightSide){
			this.modelRight1.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		}else{
			this.modelRight0.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		}
		if(hasLeftSide){
			this.modelLeft1.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		}else{
			this.modelLeft0.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		}
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}