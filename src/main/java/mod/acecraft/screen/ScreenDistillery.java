package mod.acecraft.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import mod.acecraft.AceCraft;
import mod.acecraft.container.ContainerDistillery;
import mod.lucky77.screen.ScreenBase;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ScreenDistillery extends ScreenBase<ContainerDistillery> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(AceCraft.MODID + ":" + "textures/gui/distillery.png");




    //----------------------------------------CONSTRUCTOR----------------------------------------//

    public ScreenDistillery(ContainerDistillery container, PlayerInventory player, ITextComponent name) {
        super(container, player, name, 176, 204);
    }




    //----------------------------------------INPUT----------------------------------------//

    // ...




    //----------------------------------------RENDER----------------------------------------//

    protected void renderLabels(MatrixStack matrixStack, int mousePosX, int MousePosY) {

    }

    protected void renderBg(MatrixStack matrixStack, float partialTick, int mousePosX, int mousePosY) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bind(this.TEXTURE);
        int i = this.leftPos;
        int j = this.topPos;
        this.blit(matrixStack, i, j, 0, 0, this.imageWidth, this.imageHeight);
        if (this.menu.isLit()) {
            int k = this.menu.getLitProgress();
            this.blit(matrixStack, i + 56, j + 36 + 12 - k, 176, 12 - k, 14, k + 1);
        }
        int l = this.menu.getBurnProgress();
        this.blit(matrixStack, i + 79, j + 34, 176, 14, l + 1, 16);
    }




    //----------------------------------------COMMAND----------------------------------------//

    // ...




    //----------------------------------------SUPPORT----------------------------------------//

    // ...

}
