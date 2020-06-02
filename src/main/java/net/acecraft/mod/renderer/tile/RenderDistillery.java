package net.acecraft.mod.renderer.tile;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.model.ModelDistillery;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderDistillery extends TileEntitySpecialRenderer {
	
	private static final ResourceLocation textureA = new ResourceLocation(AceCraft.modid + ":" + "textures/model/DistilleryActive.png");
	private static final ResourceLocation textureI = new ResourceLocation(AceCraft.modid + ":" + "textures/model/DistilleryIdle.png");
	
	private ModelDistillery model;
	
	public RenderDistillery(){
		this.model = new ModelDistillery();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		int i = 0;
		boolean t = false;
        if (tileentity.getWorldObj() != null){
        	Block block = tileentity.getBlockType();
            if(block == ShopKeeper.machinaDistilleryActive) t=true;
            i = tileentity.getBlockMetadata();
        }
        int j = 180;
		if(i == 4) { j = 270; }
        if(i == 3) { j = 180; }
        if(i == 5) { j =  90; }
        if(i == 2) { j = 360; }
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F); 
		if(t){
			Minecraft.getMinecraft().renderEngine.bindTexture(textureA);
		}else{
			Minecraft.getMinecraft().renderEngine.bindTexture(textureI);
		}
		GL11.glPushMatrix();
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(j, 0.0F, 1.0F, 0F);
		this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}