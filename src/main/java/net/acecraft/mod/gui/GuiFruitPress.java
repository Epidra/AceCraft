package net.acecraft.mod.gui;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.container.ContainerFruitPress;
import net.acecraft.mod.tileentity.TileEntityFruitPress;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiFruitPress extends GuiContainer {
	
	private static final ResourceLocation texture = new ResourceLocation(AceCraft.modid + ":" + "textures/gui/FruitPress.png");
    private TileEntityFruitPress tileFruitPress;
    
    public GuiFruitPress(InventoryPlayer inventory, TileEntityFruitPress entity){
        super(new ContainerFruitPress(inventory, entity));
        this.tileFruitPress = entity;
    }
    
    protected void drawGuiContainerForegroundLayer(int i, int j){
    	this.fontRendererObj.drawString(StatCollector.translateToLocal("FruitPress"), 100, 5, 0xFFFFFF);
        String s = this.tileFruitPress.hasCustomInventoryName() ? this.tileFruitPress.getInventoryName() : I18n.format(this.tileFruitPress.getInventoryName(), new Object[0]);
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        //this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    }
    
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3){
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        if (this.tileFruitPress.hasEnergy()){
            int i1 = this.tileFruitPress.getCookProgressScaled();
            this.drawTexturedModalRect(guiLeft + 60, guiTop + 34, 176, 75, i1 + 1, 16);
            int i2 = this.tileFruitPress.getFillingLevelScaled();
            this.drawTexturedModalRect(guiLeft + 133, guiTop + 6 + (75 - i2), 176, 75 - i2, 35, i2);
            int i3 = this.tileFruitPress.getEnergyScaled();
            this.drawTexturedModalRect(guiLeft + 11, guiTop + 18 + (50 - i3), 211, 50 - i3, 20, i3);
        }
        this.fontRendererObj.drawString(tileFruitPress.getContent(), guiLeft+36, guiTop+60, 4210752);
    }

}