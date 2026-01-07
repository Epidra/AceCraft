package mod.acecraft.client.screen;

import mod.acecraft.client.menu.MenuDistillery;
import mod.lucky77.client.screen.base.ScreenBase;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class ScreenDistillery extends ScreenBase<MenuDistillery> {
	
	private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("acecraft", "textures/gui/distillery.png");
	
	public ScreenDistillery(MenuDistillery menu, Inventory player, Component name){
		super(menu, player, name, 176, 204);
	}
	
	// @Override
	// protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
	//
	// }
	
	@Override
	protected void createButtons() {
	
	}
	
	@Override
	protected void renderSpriteLayer(GuiGraphics guiGraphics, int mousePosX, int mousePosY) {
		int i = this.leftPos;
		int j = this.topPos;
		guiGraphics.blit(TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
		if(this.menu.isLit()){
			int burnProgress = this.menu.getBurnProgress();
			guiGraphics.blit(TEXTURE, this.leftPos + 56, this.topPos + 48 - burnProgress, 176, 12 - burnProgress, 14, burnProgress + 1);
		}
		
		int cookingProcess = this.menu.getCookingProgress();
		guiGraphics.blit(TEXTURE, this.leftPos + 79, this.topPos + 34, 176, 14, cookingProcess + 1, 16);
	}
	
	@Override
	protected void renderOverlay(GuiGraphics guiGraphics) {
		guiGraphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, 4210752, false);
		guiGraphics.drawString(this.font, this.playerInventoryTitle, this.titleLabelX, this.titleLabelY, 4210752, false);
	}
	
	
	
	
	
	// Texture Draw with hidden gui position
	protected void blit(GuiGraphics guiGraphics, ResourceLocation texture, int posX, int posY, int texX, int texY, int width, int height){
		guiGraphics.blit(texture, this.leftPos + posX, this.topPos + posY, texX, texY, width, height);
	}
	
	// Texture Draw with hidden gui position (uses full texture size)
	protected void blit(GuiGraphics guiGraphics, ResourceLocation texture, int posX, int posY, int texX, int texY){
		guiGraphics.blit(texture, this.leftPos + posX, this.topPos + posY, texX, texY, 256, 256);
	}
	
	// Texture Draw with hidden gui position (uses complete texture)
	protected void blit(GuiGraphics guiGraphics, ResourceLocation texture){
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, 256, 256);
	}
}
