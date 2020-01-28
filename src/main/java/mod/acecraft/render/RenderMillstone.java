package mod.acecraft.render;

import org.lwjgl.opengl.GL11;

import mod.acecraft.AceCraft;
import mod.acecraft.model.ModelMillstoneChild1;
import mod.acecraft.model.ModelMillstoneChild2;
import mod.acecraft.model.ModelMillstoneParent;
import mod.acecraft.tileentities.TileEntityMillstone;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderMillstone<T extends TileEntity> extends TileEntitySpecialRenderer<T> {
	
private static final ResourceLocation texture = new ResourceLocation(AceCraft.modid + ":" + "textures/model/Millstone.png");
	
	private ModelMillstoneParent modelParent;
	private ModelMillstoneChild1 modelChild1;
	private ModelMillstoneChild2 modelChild2;
	private float energy;
	private float rotation;
	private float current;
	
	public RenderMillstone(){
		this.modelParent = new ModelMillstoneParent();
		this.modelChild1 = new ModelMillstoneChild1();
		this.modelChild2 = new ModelMillstoneChild2();
		this.energy = 5;
		this.rotation = 0;
		this.current = 0;
	}

	@Override
	public void render(T te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
		int i = 0;
        if (te.getWorld() != null){
        	Block block = te.getBlockType();
            i = te.getBlockMetadata();
        }
        TileEntityMillstone entity = (TileEntityMillstone) te;
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
		this.modelParent.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F); 
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(j+rotation, 0.0F, 1.0F, 0F);
		this.modelChild1.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F); 
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(j+rotation, 0.0F, 1.0F, 0F);
        GL11.glRotatef(-rotation, 0.0F, 0.0F, 1.0F);
		this.modelChild2.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
		rotation = rotation + energy;
	    if(rotation == 360) rotation = 0;
	    if(current > energy) current = current - 0.001F;
	    if(current < energy) current = current + 0.001F;
	}
	
}
