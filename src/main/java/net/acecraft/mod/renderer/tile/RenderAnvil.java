package net.acecraft.mod.renderer.tile;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.model.ModelAnvil;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderAnvil extends TileEntitySpecialRenderer {
	
	private static final ResourceLocation textureIron       = new ResourceLocation(AceCraft.modid + ":" + "textures/model/AnvilIron.png");
	private static final ResourceLocation textureCopper     = new ResourceLocation(AceCraft.modid + ":" + "textures/model/AnvilCopper.png");
	private static final ResourceLocation textureAluminium  = new ResourceLocation(AceCraft.modid + ":" + "textures/model/AnvilAluminium.png");
	private static final ResourceLocation textureLead       = new ResourceLocation(AceCraft.modid + ":" + "textures/model/AnvilLead.png");
	private static final ResourceLocation textureBronze     = new ResourceLocation(AceCraft.modid + ":" + "textures/model/AnvilBronze.png");
	private static final ResourceLocation textureSteel      = new ResourceLocation(AceCraft.modid + ":" + "textures/model/AnvilSteel.png");
	private static final ResourceLocation textureMythril    = new ResourceLocation(AceCraft.modid + ":" + "textures/model/AnvilMythril.png");
	private static final ResourceLocation textureAdamantium = new ResourceLocation(AceCraft.modid + ":" + "textures/model/AnvilAdamantium.png");
	private static final ResourceLocation textureUnobtanium = new ResourceLocation(AceCraft.modid + ":" + "textures/model/AnvilUnobtanium.png");
	
	private ModelAnvil model;
	private String texture;
	
	public RenderAnvil(String t){
		this.model = new ModelAnvil();
		texture = t;
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		int i = 0;
        if (tileentity.getWorldObj() != null) {
        	Block block = tileentity.getBlockType();
            i = tileentity.getBlockMetadata();
            texture = readBlockType(block);
        }
        int j = 180;
		if(i == 4) { j = 270; }
        if(i == 3) { j = 180; }
        if(i == 5) { j =  90; }
        if(i == 2) { j = 360; }
			GL11.glPushMatrix();
		    GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F); 
			Minecraft.getMinecraft().renderEngine.bindTexture(getTexture(texture));
			GL11.glPushMatrix();
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(j, 0.0F, 1.0F, 0F);
			this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
	}
	
	private ResourceLocation getTexture(String t){
		if(0 == t.compareTo("Iron"))       return textureIron;
		if(0 == t.compareTo("Copper"))     return textureCopper;
		if(0 == t.compareTo("Aluminium"))  return textureAluminium;
		if(0 == t.compareTo("Lead"))       return textureLead;
		if(0 == t.compareTo("Bronze"))     return textureBronze;
		if(0 == t.compareTo("Steel"))      return textureSteel;
		if(0 == t.compareTo("Mythril"))    return textureMythril;
		if(0 == t.compareTo("Adamantium")) return textureAdamantium;
		if(0 == t.compareTo("Unobtanium")) return textureUnobtanium;
		return textureUnobtanium;
	}
	
	private String readBlockType(Block block){
		if(block == ShopKeeper.machinaAnvilIron)       return "Iron";
		if(block == ShopKeeper.machinaAnvilCopper)     return "Copper";
		if(block == ShopKeeper.machinaAnvilAluminium)  return "Aluminium";
		if(block == ShopKeeper.machinaAnvilLead)       return "Lead";
		if(block == ShopKeeper.machinaAnvilBronze)     return "Bronze";
		if(block == ShopKeeper.machinaAnvilSteel)      return "Steel";
		if(block == ShopKeeper.machinaAnvilMythril)    return "Mythril";
		if(block == ShopKeeper.machinaAnvilAdamantium) return "Adamantium";
		if(block == ShopKeeper.machinaAnvilUnobtanium) return "Unobtanium";
		return "void";
	}
	
}
