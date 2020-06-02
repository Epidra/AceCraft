package net.acecraft.mod.gui;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.container.ContainerSewingStation;
import net.acecraft.mod.container.ContainerWorkbench;
import net.acecraft.mod.tileentity.TileEntityWorkbench;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiWorkbench extends GuiContainer {
	
	private ResourceLocation texture = new ResourceLocation(AceCraft.modid + ":" + "textures/gui/Workbench.png");
	
	public GuiWorkbench(InventoryPlayer inventoryPlayer, TileEntityWorkbench entity) {
		super(new ContainerWorkbench(inventoryPlayer, entity));
		this.xSize = 176;
		this.ySize = 188;
	}
	
	protected void drawGuiContainerForegroundLayer(int i, int j){	
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Workbench"), 100, 5, 0xFFFFFF);
	}
	
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}