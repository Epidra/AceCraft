package net.acecraft.mod.gui;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.container.ContainerBlastFurnace;
import net.acecraft.mod.tileentity.TileEntityBlastFurnace;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiBlastFurnace extends GuiContainer{
    private static final ResourceLocation FURNACE_GUI_TEXTURES = new ResourceLocation(AceCraft.modid + ":" + "textures/gui/BlastFurnace.png");
    /** The player inventory bound to this GUI. */
    private final InventoryPlayer playerInventory;
    private final IInventory blastEntity;
    
    public GuiBlastFurnace(InventoryPlayer playerInv, IInventory furnaceInv){
        super(new ContainerBlastFurnace(playerInv, furnaceInv));
        this.playerInventory = playerInv;
        this.blastEntity = furnaceInv;
    }
    
    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY){
    	
    }
    
    /**
     * Draws the background layer of this container (behind the items).
     */
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY){
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(FURNACE_GUI_TEXTURES);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
        
		int i1 = getPowerScaled(53);
		drawTexturedModalRect(guiLeft + 152, guiTop + 7 + (53 - i1), 202, 0, 16, i1);
		
		int k1 = getTotalScaled(59);
		drawTexturedModalRect(guiLeft + 135, guiTop + 7 + (59 - k1), 176, 0, 13, k1);
		
		int j1 = getSmeltingScaled(59);
		drawTexturedModalRect(guiLeft + 118, guiTop + 7 + (59 - j1), 188, 0, 13, j1);
    }
    
    private int getPowerScaled(int pixels){
    	return blastEntity.getField(0) * pixels / blastEntity.getField(1);
    }
    
    private int getTotalScaled(int pixels){
    	return blastEntity.getField(3) * pixels / 200;
    }
    
    private int getSmeltingScaled(int pixels){
    	return blastEntity.getField(2) * pixels / blastEntity.getField(3);
    }
    
}