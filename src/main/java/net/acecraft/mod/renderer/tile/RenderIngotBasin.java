package net.acecraft.mod.renderer.tile;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.model.ModelIngotBasinChild01;
import net.acecraft.mod.model.ModelIngotBasinChild02;
import net.acecraft.mod.model.ModelIngotBasinChild03;
import net.acecraft.mod.model.ModelIngotBasinChild04;
import net.acecraft.mod.model.ModelIngotBasinChild05;
import net.acecraft.mod.model.ModelIngotBasinChild06;
import net.acecraft.mod.model.ModelIngotBasinChild07;
import net.acecraft.mod.model.ModelIngotBasinChild08;
import net.acecraft.mod.model.ModelIngotBasinChild09;
import net.acecraft.mod.model.ModelIngotBasinChild10;
import net.acecraft.mod.model.ModelIngotBasinParent;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderIngotBasin extends TileEntitySpecialRenderer {
	
	private static final ResourceLocation texture = new ResourceLocation(AceCraft.modid + ":" + "textures/model/IngotBasin.png");
	
	private ModelIngotBasinParent  modelParent;
	private ModelIngotBasinChild01 modelChild01;
	private ModelIngotBasinChild02 modelChild02;
	private ModelIngotBasinChild03 modelChild03;
	private ModelIngotBasinChild04 modelChild04;
	private ModelIngotBasinChild05 modelChild05;
	private ModelIngotBasinChild06 modelChild06;
	private ModelIngotBasinChild07 modelChild07;
	private ModelIngotBasinChild08 modelChild08;
	private ModelIngotBasinChild09 modelChild09;
	private ModelIngotBasinChild10 modelChild10;
	
	public RenderIngotBasin(){
		this.modelParent  = new ModelIngotBasinParent();
		this.modelChild01 = new ModelIngotBasinChild01();
		this.modelChild02 = new ModelIngotBasinChild02();
		this.modelChild03 = new ModelIngotBasinChild03();
		this.modelChild04 = new ModelIngotBasinChild04();
		this.modelChild05 = new ModelIngotBasinChild05();
		this.modelChild06 = new ModelIngotBasinChild06();
		this.modelChild07 = new ModelIngotBasinChild07();
		this.modelChild08 = new ModelIngotBasinChild08();
		this.modelChild09 = new ModelIngotBasinChild09();
		this.modelChild10 = new ModelIngotBasinChild10();
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
		this.modelChild01.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}