package mod.acecraft.client.screen;

import mod.acecraft.client.menu.MenuDistillery;
import mod.acecraft.client.menu.MenuFoundry;
import mod.acecraft.custom.content.ContentFoundry;
import mod.acecraft.custom.payload.PayloadEject;
import mod.acecraft.custom.payload.PayloadIgnite;
import mod.lucky77.client.screen.base.ScreenBase;
import mod.lucky77.custom.vector.Vector2;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.FurnaceScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.level.ChunkPos;
import net.neoforged.neoforge.network.PacketDistributor;

public class ScreenFoundry extends ScreenBase<MenuFoundry> {
	
	private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("acecraft", "textures/gui/foundry.png");
	
	private int amount = 0;
	
	public ScreenFoundry(MenuFoundry menu, Inventory player, Component name){
		super(menu, player, name, 176, 204);
	}
	
	// @Override
	// protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
	//
	// }
	
	@Override
	protected void createButtons() {
		buttonSet.addButton(0, new Vector2(91, 5), new Vector2(176, 86), new Vector2(176, 108), new Vector2(177, 174), new Vector2(70, 22), -1, () -> menu.getCookTime() == 0 && amount > 0 && menu.getCoal() > 0 && amount / 8 < menu.getCoal(), () -> this.commandIgnite());
		buttonSet.addButton(0, new Vector2(91, 29), new Vector2(176, 130), new Vector2(176, 152), new Vector2(177, 174), new Vector2(70, 22), -1, () -> menu.getCookTime() == 0 && amount > 0 /*&& menu.getEject()*/, () -> this.commandEject());
		buttonSet.addTexture(TEXTURE);
	}
	
	// can be overwritten to stop title from being displayed
	// does not by default
	// render over the items
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, 4210752, false);
		guiGraphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, 4210752, false);
	}
	
	
	@Override
	public boolean mouseClicked(double mouseX, double mouseY, int mouseButton){
		buttonSet.interact((this.width - this.imageWidth) / 2, (this.height - this.imageHeight) / 2, mouseX, (int) mouseY);
		
		return super.mouseClicked(mouseX, mouseY, mouseButton);
	}
	
	// rename to renderGUI
	@Override
	protected void renderSpriteLayer(GuiGraphics guiGraphics, int mousePosX, int mousePosY) {
		int posX = (this.width - this.imageWidth) / 2; // <- leftPos
		int posY = (this.height - this.imageHeight) / 2; // <- topPos
		//buttonSet.update(posX, posY, mousePosX, mousePosY); // <- already in base
		guiGraphics.blit(TEXTURE, leftPos, topPos, 0, 0, imageWidth, imageHeight);
		int pos = 0;
		amount = 0;
		int coal = menu.getCoal();
		for(ContentFoundry CF : menu.logic().content){
			if(CF.amount > 0){
				amount += CF.amount;
				guiGraphics.blit(TEXTURE, leftPos + imageWidth + 8, topPos + 8 + 24*pos, 176, 64, 70, 22);
				pos++;
			}
		}
		guiGraphics.blit(TEXTURE, leftPos + 17, topPos + 11 + 64-amount, 176, 64 - amount, 25, amount);
		if(coal > 0){
			guiGraphics.blit(TEXTURE, leftPos + 8, topPos + 11 + 64-coal, 226, 64 - coal, 7, coal);
		}
		
		if(menu.getCookTime() > 0){
			int cook = (int) ((float) menu.getCookTime() / menu.getCookTimeMax() * 100.0f);
			guiGraphics.blit(TEXTURE, leftPos + 17, topPos + 11 + 64-cook, 176+25, 64 - cook, 25, cook);
		}
	}
	
	//merge with renderBackground
	@Override
	protected void renderOverlay(GuiGraphics guiGraphics) {
		int pos = 0;
		for(ContentFoundry CF : menu.logic().content){
			if(CF.amount > 0){
				guiGraphics.drawString(this.font, CF.id + " : " + CF.amount, this.imageWidth + 8+6, 8+6 + 24*pos, 16777215);
				pos++;
				
			}
		}
	}
	
	private void commandEject(){
		PacketDistributor.sendToServer(new PayloadEject(menu.pos().getX(), menu.pos().getY(), menu.pos().getZ()));
	}
	
	private void commandIgnite(){
		PacketDistributor.sendToServer(new PayloadIgnite(menu.pos().getX(), menu.pos().getY(), menu.pos().getZ()));
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
