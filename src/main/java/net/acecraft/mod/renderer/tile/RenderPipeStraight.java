package net.acecraft.mod.renderer.tile;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.model.ModelPipeStraight;
import net.acecraft.mod.tileentity.TileEntityPipeStraight;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderPipeStraight extends TileEntitySpecialRenderer {
	
	private static final ResourceLocation textureB = new ResourceLocation(AceCraft.modid + ":" + "textures/model/PipeStraightBronze.png");
	private static final ResourceLocation textureL = new ResourceLocation(AceCraft.modid + ":" + "textures/model/PipeStraightLead.png");
	
	private ModelPipeStraight model;
	
	private int rotation;
	private String texture;
	
	public RenderPipeStraight(String t){
		this.model = new ModelPipeStraight();
		texture = t;
		rotation = 0;
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		int i = 0;
        if (tileentity.getWorldObj() != null){
        	Block block = tileentity.getBlockType();
            i = tileentity.getBlockMetadata();
            texture = readBlockType(block);
            TileEntityPipeStraight entity = (TileEntityPipeStraight)tileentity;
            rotation = entity.rotation * 90;
        }
        int j = 0;
        if(i == 5) { j = 270; }
        if(i == 2) { j = 180; }
        if(i == 4) { j =  90; }
        if(i == 3) { j = 360; }
        if(i == 0){
        	GL11.glPushMatrix();
		    GL11.glTranslatef((float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F); 
			Minecraft.getMinecraft().renderEngine.bindTexture(getTexture(texture));
			GL11.glPushMatrix();
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(     0+rotation, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(   180F, 1.0F, 0.0F, 0.0F);
			this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
        }else if(i == 1){
        	GL11.glPushMatrix();
		    GL11.glTranslatef((float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F); 
			Minecraft.getMinecraft().renderEngine.bindTexture(getTexture(texture));
			GL11.glPushMatrix();
			GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(     0-rotation, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(  0, 1.0F, 0.0F, 0.0F);
			this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
        }else if(i == 2){
        	GL11.glPushMatrix();
        	GL11.glTranslatef((float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F); 
			Minecraft.getMinecraft().renderEngine.bindTexture(getTexture(texture));
			GL11.glPushMatrix();
			GL11.glRotatef(+rotation, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(     j, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(    270, 1.0F, 0.0F, 0.0F);
			this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
        }else if(i == 3){
        	GL11.glPushMatrix();
        	GL11.glTranslatef((float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F); 
			Minecraft.getMinecraft().renderEngine.bindTexture(getTexture(texture));
			GL11.glPushMatrix();
			GL11.glRotatef(-rotation, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(     j, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(    270, 1.0F, 0.0F, 0.0F);
			this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
        }else if(i == 4){
        	GL11.glPushMatrix();
        	GL11.glTranslatef((float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F); 
			Minecraft.getMinecraft().renderEngine.bindTexture(getTexture(texture));
			GL11.glPushMatrix();
			GL11.glRotatef(0.0F-rotation, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(     j+90, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(    90, 0.0F, 0.0F, 1.0F);
			this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
        }else if(i == 5){
        	GL11.glPushMatrix();
        	GL11.glTranslatef((float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F); 
			Minecraft.getMinecraft().renderEngine.bindTexture(getTexture(texture));
			GL11.glPushMatrix();
			GL11.glRotatef(0.0F+rotation, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(     j+90, 0.0F, 1.0F, 0.0F);
            GL11.glRotatef(    90, 0.0F, 0.0F, 1.0F);
			this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
        }
	}
	
	private ResourceLocation getTexture(String t){
		if(0 == t.compareTo("Lead"))   return textureL;
		if(0 == t.compareTo("Bronze")) return textureB;
		return textureL;
	}
	
	private String readBlockType(Block block){
		if(block == ShopKeeper.machinaPipeStraightLead)   return "Lead";
		if(block == ShopKeeper.machinaPipeStraightBronze) return "Bronze";
		return "void";
	}

}