package net.acecraft.mod.gui;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.container.ContainerKeg;
import net.acecraft.mod.tileentity.TileEntityKeg;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiKeg extends GuiContainer {
	
	public static final ResourceLocation texture = new ResourceLocation(AceCraft.modid + ":" + "textures/gui/Keg.png");
	public TileEntityKeg keg;
	
	public GuiKeg(InventoryPlayer inventory, TileEntityKeg entity){
		super(new ContainerKeg(inventory, entity));
		this.keg = entity;
		this.xSize = 176;
		this.ySize = 166;
	}
	
	public void drawGuiContainerForegroundLayer(int i, int j){
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Keg"), 100, 5, 0xFFFFFF);
	}
	
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3){
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		int j1 = keg.getFillingLevel(75);
		drawTexturedModalRect(guiLeft + 8, guiTop + 6 + (75 - j1), 176, 75 - j1, 35, j1);
		this.fontRendererObj.drawString(keg.getContent(), guiLeft+50, guiTop+70, 4210752);
	}

}