package mod.acecraft.screen;

import com.mojang.blaze3d.platform.GlStateManager;
import mod.acecraft.AceCraft;
import mod.acecraft.container.ContainerDistillery;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static mod.acecraft.AceCraft.MODID;

@OnlyIn(Dist.CLIENT)
public class ScreenDistillery extends ContainerScreen<ContainerDistillery> {

    private final ResourceLocation GUI = new ResourceLocation(MODID, "textures/gui/distillery.png");

    public ScreenDistillery(ContainerDistillery screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.blit(i, j, 0, 0, this.xSize, this.ySize);
        if (((ContainerDistillery)this.container).func_217061_l()) {
            int k = ((ContainerDistillery)this.container).getBurnLeftScaled();
            this.blit(i + 56, j + 36 + 12 - k, 176, 12 - k, 14, k + 1);
        }

        int l = ((ContainerDistillery)this.container).getCookProgressionScaled();
        this.blit(i + 79, j + 34, 176, 14, l + 1, 16);
    }
}
