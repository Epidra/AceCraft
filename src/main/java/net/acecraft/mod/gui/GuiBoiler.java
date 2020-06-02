package net.acecraft.mod.gui;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.acecraft.mod.AceCraft;
import net.acecraft.mod.container.ContainerBoiler;
import net.acecraft.mod.tileentity.TileEntityBoiler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

@SideOnly(Side.CLIENT)
public class GuiBoiler extends GuiContainer {
	
	private static final ResourceLocation texture = new ResourceLocation(AceCraft.modid + ":" + "textures/gui/Boiler.png");
    private TileEntityBoiler tileBoiler;
    
    public GuiBoiler(InventoryPlayer inventory, TileEntityBoiler entity){
        super(new ContainerBoiler(inventory, entity));
        this.tileBoiler = entity;
    }
    
    protected void drawGuiContainerForegroundLayer(int i, int j){
    	this.fontRendererObj.drawString(StatCollector.translateToLocal("Boiler"), 100, 5, 0xFFFFFF);
        String s = this.tileBoiler.hasCustomInventoryName() ? this.tileBoiler.getInventoryName() : I18n.format(this.tileBoiler.getInventoryName(), new Object[0]);
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        //this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
        if(tileBoiler.isCrowned){
        	String s2 = "" + tileBoiler.energyCollected + " e";
        	this.fontRendererObj.drawString(s, guiLeft +  156 - this.fontRendererObj.getStringWidth(s), guiTop + 42, 4210752);
        }
    }
    
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3){
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		int scale = tileBoiler.getEnergyScaled();
		drawTexturedModalRect(guiLeft + 81, guiTop + 16 + (50-scale), 176, 0, 13, scale);
		if(tileBoiler.isCrowned){
			drawTexturedModalRect(guiLeft +  98, guiTop + 41, 189, 0, 22, 15);
			drawTexturedModalRect(guiLeft + 123, guiTop + 40, 211, 0, 36, 18);
		}
		if(tileBoiler.isCrowned){
        	String s2 = "" + tileBoiler.energyCollected + " e";
        	this.fontRendererObj.drawString(s2, guiLeft +  156 - this.fontRendererObj.getStringWidth(s2), guiTop + 42, 4210752);
        }
	}

}