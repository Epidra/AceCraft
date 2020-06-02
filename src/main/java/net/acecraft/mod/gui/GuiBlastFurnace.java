package net.acecraft.mod.gui;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.container.ContainerBlastFurnace;
import net.acecraft.mod.tileentity.TileEntityBlastFurnace;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiBlastFurnace extends GuiContainer {
	
	public static final ResourceLocation texture = new ResourceLocation(AceCraft.modid + ":" + "textures/gui/BlastFurnace.png");
	public TileEntityBlastFurnace blastFurnace;
	
	public GuiBlastFurnace(InventoryPlayer inventoryPlayer, TileEntityBlastFurnace entity){
		super(new ContainerBlastFurnace(inventoryPlayer, entity));
		this.blastFurnace = entity;
		this.xSize = 176;
		this.ySize = 166;
	}
	
	public void drawGuiContainerForegroundLayer(int par1, int par2){
		this.fontRendererObj.drawString(StatCollector.translateToLocal("BlastFurnace"), 100, 5, 0xFFFFFF);
	}
	
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3){
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		if(blastFurnace.hasPower()){
			int i1 = blastFurnace.getPowerRemainingScaled(53);
			drawTexturedModalRect(guiLeft + 152, guiTop + 7 + (53 - i1), 202, 0, 16, i1);
		}
		int j1 = blastFurnace.getMasherProgressedScaled(59);
		drawTexturedModalRect(guiLeft + 118, guiTop + 7 + (59 - j1), 188, 0, 13, j1);
	}

}