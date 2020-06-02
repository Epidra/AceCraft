package net.acecraft.mod.gui;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.acecraft.mod.AceCraft;
import net.acecraft.mod.container.ContainerStove;
import net.acecraft.mod.tileentity.TileEntityStove;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

@SideOnly(Side.CLIENT)
public class GuiStove extends GuiContainer {
	
	private ResourceLocation texture = new ResourceLocation(AceCraft.modid + ":" + "textures/gui/Stove.png");
	
	private ItemStack stack;
	
	public GuiStove(InventoryPlayer inventoryPlayer, TileEntityStove entity) {
		super(new ContainerStove(inventoryPlayer, entity));
		this.xSize = 176;
		this.ySize = 188;
	}
	
	protected void drawGuiContainerForegroundLayer(int i, int j){	
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Stove"), 100, 5, 0xFFFFFF);
	}
	
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}