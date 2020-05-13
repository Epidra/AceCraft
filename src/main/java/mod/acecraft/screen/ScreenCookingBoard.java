package mod.acecraft.screen;

import mod.acecraft.AceCraft;
import mod.acecraft.container.ContainerCookingBoard;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.opengl.GL11;

import static mod.acecraft.AceCraft.MODID;

@OnlyIn(Dist.CLIENT)
public class ScreenCookingBoard extends ContainerScreen<ContainerCookingBoard> {

    private final ResourceLocation GUI = new ResourceLocation(MODID, "textures/gui/cookingboard.png");

    public ScreenCookingBoard(ContainerCookingBoard screenContainer, PlayerInventory inv, ITextComponent titleIn) {
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
        if (minecraft == null) {
            return;
        }
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        minecraft.getTextureManager().bindTexture(GUI);
        blit(guiLeft, guiTop, 0, 0, xSize, ySize);
        //if (container.getProgress() > 0) {
        //    int l = (int) Math.ceil(container.getProgress() / 100.0 * 16);
        //    blit(guiLeft + 80, guiTop + 35, 176, 0, l, 16);
        //}
    }
}
