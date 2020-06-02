package net.acecraft.mod.gui;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.container.ContainerMillstone;
import net.acecraft.mod.tileentity.TileEntityMillstone;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiMillstone extends GuiContainer {
	
	private static final ResourceLocation texture = new ResourceLocation(AceCraft.modid + ":" + "textures/gui/Millstone.png");
    private TileEntityMillstone tileMillstone;
    
    public GuiMillstone(InventoryPlayer inventory, TileEntityMillstone entity){
        super(new ContainerMillstone(inventory, entity));
        this.tileMillstone = entity;
    }
    
    protected void drawGuiContainerForegroundLayer(int i, int j){
    	this.fontRendererObj.drawString(StatCollector.translateToLocal("Millstone"), 100, 5, 0xFFFFFF);
        String s = this.tileMillstone.hasCustomInventoryName() ? this.tileMillstone.getInventoryName() : I18n.format(this.tileMillstone.getInventoryName(), new Object[0]);
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        //this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    }
    
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3){
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        if (this.tileMillstone.hasEnergy()){
            int i1 = this.tileMillstone.getCookProgressScaled(24);
            this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
            int i2 = this.tileMillstone.getEnergyScaled();
            this.drawTexturedModalRect(guiLeft + 22, guiTop + 18 + (50 - i2), 200, 50 - i2, 20, i2);
        }
    }

}