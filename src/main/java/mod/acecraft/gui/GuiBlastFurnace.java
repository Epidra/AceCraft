package mod.acecraft.gui;

import com.mojang.blaze3d.platform.GlStateManager;
import mod.acecraft.AceCraft;
import mod.acecraft.container.ContainerBlastFurnace;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class GuiBlastFurnace extends ContainerScreen<ContainerBlastFurnace> {

    private static final ResourceLocation background = new ResourceLocation(AceCraft.MODID, "textures/gui/blastfurnace.png");

    private ContainerBlastFurnace container;

    public GuiBlastFurnace(ContainerBlastFurnace container, PlayerInventory playerInventory, ITextComponent title) {
        super(container, playerInventory, title);
        this.container = container;
    }

    public void init() {
        super.init();
    }

    public void tick() {
        super.tick();
    }

    //public void render(int p_render_1_, int p_render_2_, float p_render_3_) {
    //    this.renderBackground();
    //    this.renderHoveredToolTip(p_render_1_, p_render_2_);
    //}

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        //String s = this.title.getFormattedText();
        //this.font.drawString(s, (float)(this.xSize / 2 - this.font.getStringWidth(s) / 2), 6.0F, 4210752);
        //this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F, (float)(this.ySize - 96 + 2), 4210752);
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    /**
     * Draws the background layer of this container (behind the items).
     */
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        this.renderBackground();
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(this.background);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.blit(i, j, 0, 0, this.xSize, this.ySize);
        if ((this.container).func_217061_l()) {
            int k = (this.container).getBurnLeftScaled();
            this.blit(i + 124, j + 43 + 12 - k, 210, 12 - k, 14, k + 1);
        }

        int l = (this.container).getCookProgressionScaled();
        this.blit(i + 86, j + 17, 210, 14, l + 1, 16);
        int z = (this.container).getAmount();
        this.blit(i + 26, j + 6 + 75 - z, 176, 75 - z, 34, z);
        //getMinecraft().getTextureManager().bindTexture(background);
        //blit(guiLeft - 20, guiTop - 12, 0, 0, xSize, ySize + 25);
    }

    public void removed() {
        super.removed();
    }


}
