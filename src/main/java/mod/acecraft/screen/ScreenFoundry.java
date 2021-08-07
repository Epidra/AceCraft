package mod.acecraft.screen;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import mod.acecraft.menu.MenuFoundry;
import mod.acecraft.network.MessageEjectServer;
import mod.acecraft.network.MessageIgniteServer;
import mod.acecraft.system.AceCraftPacketHandler;
import mod.acecraft.util.FoundryContent;
import mod.lucky77.screen.ScreenBase;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ScreenFoundry extends ScreenBase<MenuFoundry> {

    private static final ResourceLocation TEXTURE = new ResourceLocation("acecraft" + ":" + "textures/gui/foundry.png");




    //----------------------------------------CONSTRUCTOR----------------------------------------//

    public ScreenFoundry(MenuFoundry container, Inventory player, Component name) {
        super(container, player, name, 176, 204);
    }




    //----------------------------------------INPUT----------------------------------------//

    /** Called when the mouse is clicked. Args : mouseX, mouseY, clickedButton */
    public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        if (mouseButton == 0){ if(mouseRect( 91, 29, 70, 22, mouseX, mouseY)) { commandEject();  } }
        if (mouseButton == 0){ if(mouseRect( 91,  5, 70, 22, mouseX, mouseY)) { commandIgnite(); } }

        return false;
    }




    //----------------------------------------RENDER----------------------------------------//

    /** Draw the foreground layer for the GuiContainer (everything in front of the items) */
    protected void renderLabels(PoseStack matrixstack, int mouseX, int mouseY){
        int pos = 0;
        for(FoundryContent fc : menu.logic().content){
            if(fc.amount > 0){
                font.draw(matrixstack, fc.id + " : " + fc.amount, this.imageWidth + 8+6, 8+6 + 24*pos, 9876543);
                pos++;
            }
        }
    }

    /** Draws the background layer of this container (behind the items). */
    protected void renderBg(PoseStack matrixstack, float partialTicks, int mouseX, int mouseY){
        RenderSystem.setShaderTexture(0, TEXTURE);
        int i = (this.width  - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        this.blit(matrixstack, i, j, 0, 0, this.imageWidth, this.imageHeight);
        int pos = 0;
        int amount = 0;
        int coal = menu.getCoal();
        for(FoundryContent fc : menu.logic().content){
            if(fc.amount > 0){
                amount += fc.amount;
                this.blit(matrixstack, i + this.imageWidth + 8, j + 8 + 24*pos, 176, 64, 70, 22);
                pos++;
            }
        }
        this.blit(matrixstack, i + 17, j + 11 + 64-amount, 176, 64 - amount, 25, amount);
        if(coal > 0){
            this.blit(matrixstack, i + 8, j + 11 + 64-coal, 226, 64 - coal, 7, coal);
        }
        if(menu.getCookTime() == 0 && amount > 0){
            this.blit(matrixstack, i + 91, j + 29, 176, 130, 70, 22);
        }
        if(menu.getCookTime() == 0 && amount > 0 && coal > 0 && amount / 8 < coal){
            this.blit(matrixstack, i + 91, j + 5, 176, 86, 70, 22);
        }
        if(menu.getCookTime() > 0){
            int cook = (int)((float) menu.getCookTime() / menu.getCookTimeMax() * 100.0f);
            this.blit(matrixstack, i + 17, j + 11 + 64-cook, 176+25, 64 - cook, 25, cook);
        }
    }




    //----------------------------------------COMMAND----------------------------------------//

    private void commandEject(){
        AceCraftPacketHandler.sendToServer(new MessageEjectServer(menu.pos()));
    }

    private void commandIgnite(){
        AceCraftPacketHandler.sendToServer(new MessageIgniteServer(menu.pos()));
    }




    //----------------------------------------SUPPORT----------------------------------------//

    /** Checks if mouse is inside a rectangle **/
    protected boolean mouseRect(int x, int y, int width, int height, double mouseX, double mouseY){
        if(leftPos + x < mouseX && mouseX < leftPos + x + width){
            return topPos + y < mouseY && mouseY < topPos + y + height;
        }
        return false;
    }

}
