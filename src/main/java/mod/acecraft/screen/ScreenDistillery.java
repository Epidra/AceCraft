package mod.acecraft.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import mod.acecraft.menu.MenuDistillery;
import mod.lucky77.screen.ScreenBase;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ScreenDistillery extends ScreenBase<MenuDistillery> {

    private static final ResourceLocation TEXTURE = new ResourceLocation("acecraft" + ":" + "textures/gui/distillery.png");




    //----------------------------------------CONSTRUCTOR----------------------------------------//

    public ScreenDistillery(MenuDistillery container, Inventory player, Component name) {
        super(container, player, name, 176, 204);
    }




    //----------------------------------------INPUT----------------------------------------//

    // ...




    //----------------------------------------RENDER----------------------------------------//

    protected void renderLabels(PoseStack matrixStack, int mousePosX, int MousePosY) {

    }

    protected void renderBg(PoseStack matrixStack, float partialTick, int mousePosX, int mousePosY) {
        RenderSystem.setShaderTexture(0, this.TEXTURE);
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
