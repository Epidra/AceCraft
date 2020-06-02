package net.acecraft.mod.render;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.model.ModelFruitPressChild;
import net.acecraft.mod.model.ModelFruitPressParent;
import net.acecraft.mod.tileentity.TileEntityFruitPress;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderFruitPress extends TileEntitySpecialRenderer {
	
	private static final ResourceLocation texture = new ResourceLocation(AceCraft.modid + ":" + "textures/model/FruitPress.png");
	
	private ModelFruitPressParent modelParent;
	private ModelFruitPressChild  modelChild;
	private float energy;
	private float rotation;
	private float current;
	
	public RenderFruitPress(){
		this.modelParent = new ModelFruitPressParent();
		this.modelChild  = new ModelFruitPressChild();
		this.energy = 5;
		this.rotation = 0;
		this.current = 0;
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float partialTicks, int destroyStage) {
		int i = 0;
        if (tileentity.getWorld() != null){
        	Block block = tileentity.getBlockType();
            i = tileentity.getBlockMetadata();
        }
        TileEntityFruitPress entity = (TileEntityFruitPress) tileentity;
        if(entity != null){
        	if(this.energy != entity.energy){
        		this.energy = entity.energy;
        		this.energy = energy / 200;
        	}
        }
		int j = 180;
		if(i == 5) { j = 270; }
	    if(i == 2) { j = 180; }
	    if(i == 4) { j =  90; }
	    if(i == 3) { j = 360; }
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F); 
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(j, 0.0F, 1.0F, 0F);
		this.modelParent.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glRotatef(rotation, 0.0F, 1.0F, 0.0F);
		this.modelChild .render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		rotation = rotation + energy;
	    if(rotation == 360) rotation = 0;
	    if(current > energy) current = current - 0.001F;
	    if(current < energy) current = current + 0.001F;
	}

}