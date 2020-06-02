package net.acecraft.mod.gui;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.container.ContainerCookingTable;
import net.acecraft.mod.container.ContainerWorkbench;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiCookingTable extends GuiContainer{
    private static final ResourceLocation CRAFTING_TABLE_GUI_TEXTURES = new ResourceLocation(AceCraft.modid + ":" + "textures/gui/Stove.png");
    
    /** The X size of the inventory window in pixels. */
    protected int xSize = 176;
    /** The Y size of the inventory window in pixels. */
    protected int ySize = 188;
    
    public GuiCookingTable(InventoryPlayer playerInv, World worldIn){
        this(playerInv, worldIn, BlockPos.ORIGIN);
    }
    
    public GuiCookingTable(InventoryPlayer playerInv, World worldIn, BlockPos blockPosition){
        super(new ContainerCookingTable(playerInv, worldIn, blockPosition));
    }
    
    public void initGui(){
        super.initGui();
        this.mc.thePlayer.openContainer = this.inventorySlots;
        this.guiLeft = (this.width - xSize) / 2;
        this.guiTop = (this.height - ySize) / 2;
    }
    
    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY){
        this.fontRendererObj.drawString(I18n.format("container.stove", new Object[0]), 100, 8, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 100, 90, 4210752);
    }
    
    /**
     * Draws the background layer of this container (behind the items).
     */
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY){
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(CRAFTING_TABLE_GUI_TEXTURES);
        int i = (this.width - xSize) / 2;
        int j = (this.height - ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, xSize, ySize);
    }
}