package net.acecraft.mod.renderer.tile;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.model.ModelBellowsChild1;
import net.acecraft.mod.model.ModelBellowsChild2;
import net.acecraft.mod.model.ModelBellowsChild3;
import net.acecraft.mod.model.ModelBellowsChild4;
import net.acecraft.mod.model.ModelBellowsChild5;
import net.acecraft.mod.model.ModelBellowsChild6;
import net.acecraft.mod.model.ModelBellowsParent;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderBellows extends TileEntitySpecialRenderer {
	
	private static final ResourceLocation texture = new ResourceLocation(AceCraft.modid + ":" + "textures/model/Bellows.png");
	
	private ModelBellowsParent modelParent;
	private ModelBellowsChild1 modelChild1;
	private ModelBellowsChild2 modelChild2;
	private ModelBellowsChild3 modelChild3;
	private ModelBellowsChild4 modelChild4;
	private ModelBellowsChild5 modelChild5;
	private ModelBellowsChild6 modelChild6;
	
	public RenderBellows(){
		this.modelParent = new ModelBellowsParent();
		this.modelChild1 = new ModelBellowsChild1();
		this.modelChild2 = new ModelBellowsChild2();
		this.modelChild3 = new ModelBellowsChild3();
		this.modelChild4 = new ModelBellowsChild4();
		this.modelChild5 = new ModelBellowsChild5();
		this.modelChild6 = new ModelBellowsChild6();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		int i = 0;
        if (tileentity.getWorldObj() != null){
        	Block block = tileentity.getBlockType();
            i = tileentity.getBlockMetadata();
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
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F); 
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);	
        GL11.glRotatef(j, 0.0F, 1.0F, 0F);
		this.modelChild1.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F); 
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);	
        GL11.glRotatef(j, 0.0F, 1.0F, 0F);
		this.modelChild2.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F); 
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);	
        GL11.glRotatef(j, 0.0F, 1.0F, 0F);
		this.modelChild3.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F); 
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);	
        GL11.glRotatef(j, 0.0F, 1.0F, 0F);
		this.modelChild4.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F); 
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);	
        GL11.glRotatef(j, 0.0F, 1.0F, 0F);
		this.modelChild5.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F); 
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);	
        GL11.glRotatef(j, 0.0F, 1.0F, 0F);
		this.modelChild6.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}