package net.acecraft.mod.gui;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.container.ContainerDistillery;
import net.acecraft.mod.tileentity.TileEntityDistillery;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiDistillery extends GuiContainer {
	
	private static final ResourceLocation texture = new ResourceLocation(AceCraft.modid + ":" + "textures/gui/Distillery.png");
    private TileEntityDistillery tileDistillery;
    
    public GuiDistillery(InventoryPlayer inventory, TileEntityDistillery entity){
        super(new ContainerDistillery(inventory, entity));
        this.tileDistillery = entity;
    }
    
    protected void drawGuiContainerForegroundLayer(int i, int j){
    	this.fontRendererObj.drawString(StatCollector.translateToLocal("Distillery"), 100, 5, 0xFFFFFF);
        String s = this.tileDistillery.hasCustomInventoryName() ? this.tileDistillery.getInventoryName() : I18n.format(this.tileDistillery.getInventoryName(), new Object[0]);
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        //this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    }
    
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3){
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        if (this.tileDistillery.isBurning()){
            int i1 = this.tileDistillery.getBurnTimeRemainingScaled(13);
            this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 1);
            i1 = this.tileDistillery.getCookProgressScaled(24);
            this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
        }
    }

}