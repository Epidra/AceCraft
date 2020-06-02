package net.acecraft.mod.renderer.tile;

import org.lwjgl.opengl.GL11;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.model.ModelCableChild1;
import net.acecraft.mod.model.ModelCableChild2;
import net.acecraft.mod.model.ModelCableChild3;
import net.acecraft.mod.model.ModelCableChild4;
import net.acecraft.mod.model.ModelCableParent;
import net.acecraft.mod.tileentity.TileEntityCable;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderCable extends TileEntitySpecialRenderer {
	
	private static final ResourceLocation texture = new ResourceLocation(AceCraft.modid + ":" + "textures/model/Cable.png");
	
	private ModelCableParent modelParent;
	private ModelCableChild1 modelChild1; //West
	private ModelCableChild2 modelChild2; //East
	private ModelCableChild3 modelChild3; //South
	private ModelCableChild4 modelChild4; //North
	
	public RenderCable(){
		this.modelParent = new ModelCableParent();
		this.modelChild1 = new ModelCableChild1();
		this.modelChild2 = new ModelCableChild2();
		this.modelChild3 = new ModelCableChild3();
		this.modelChild4 = new ModelCableChild4();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		boolean hasNorth = false;
		boolean hasEast  = false;
		boolean hasSouth = false;
		boolean hasWest  = false;
        if (tileentity.getWorldObj() != null){
        	TileEntityCable entity = (TileEntityCable)tileentity;
            hasNorth = entity.hasNorth;
            hasEast  = entity.hasEast;
            hasSouth = entity.hasSouth;
            hasWest  = entity.hasWest;
        }
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F); 
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		this.modelParent.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		if(hasWest) this.modelChild1.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		if(hasEast) this.modelChild2.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		if(hasSouth)this.modelChild3.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		if(hasNorth)this.modelChild4.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}