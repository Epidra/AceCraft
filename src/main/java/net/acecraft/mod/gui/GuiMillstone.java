package net.acecraft.mod.gui;

import org.lwjgl.opengl.GL11;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.container.ContainerMillstone;
import net.acecraft.mod.tileentity.TileEntityMillstone;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiMillstone extends GuiContainer {
	
	private static final ResourceLocation FURNACE_GUI_TEXTURES = new ResourceLocation(AceCraft.modid + ":" + "textures/gui/Millstone.png");
    /** The player inventory bound to this GUI. */
    private final InventoryPlayer playerInventory;
    private final IInventory tileFurnace;
    
    public GuiMillstone(InventoryPlayer playerInv, IInventory furnaceInv){
        super(new ContainerMillstone(playerInv, furnaceInv));
        this.playerInventory = playerInv;
        this.tileFurnace = furnaceInv;
    }
    
    protected void drawGuiContainerForegroundLayer(int i, int j){
    	
    }
    
    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3){
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(FURNACE_GUI_TEXTURES);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        if (((TileEntityMillstone) this.tileFurnace).hasEnergy()){
            int i1 = ((TileEntityMillstone) this.tileFurnace).getCookProgressScaled(24);
            this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
            int i2 = ((TileEntityMillstone) this.tileFurnace).getEnergyScaled();
            this.drawTexturedModalRect(guiLeft + 22, guiTop + 18 + (50 - i2), 200, 50 - i2, 20, i2);
        }
    }

}