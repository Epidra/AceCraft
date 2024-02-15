package mod.acecraft.client.screen;

import mod.acecraft.client.menu.MenuFoundry;
import mod.acecraft.client.network.MessageEjectServer;
import mod.acecraft.client.network.MessageIgniteServer;
import mod.acecraft.system.PacketHandler;
import mod.acecraft.util.FoundryContent;
import mod.lucky77.screen.ScreenBase;
import mod.lucky77.util.Vector2;
import mod.lucky77.util.button.ButtonSet;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ScreenFoundry extends ScreenBase<MenuFoundry> {
	
	private static final ResourceLocation TEXTURE = new ResourceLocation("acecraft" + ":" + "textures/gui/foundry.png");
	
	protected ButtonSet buttonSet = new ButtonSet();
	
	private int amount = 0;
	
	
	
	
	
	// ---------- ---------- ---------- ----------  CONSTRUCTOR  ---------- ---------- ---------- ---------- //
	
	public ScreenFoundry(MenuFoundry container, Inventory player, Component name) {
		super(container, player, name, 176, 204);
		createButtons();
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  CREATE  ---------- ---------- ---------- ---------- //
	
	private void createButtons(){
		buttonSet.addButton(1, new Vector2(91,  5), new Vector2(176,  86), new Vector2(176, 108), new Vector2(177, 174), new Vector2(70, 22), -1, () -> menu.getCookTime() == 0 && amount > 0 && menu.getCoal( ) > 0 && amount / 8 < menu.getCoal(), () -> this.commandIgnite());
		buttonSet.addButton(0, new Vector2(91, 29), new Vector2(176, 130), new Vector2(176, 152), new Vector2(177, 174), new Vector2(70, 22), -1, () -> menu.getCookTime() == 0 && amount > 0 && menu.getEject()                                   , () -> this.commandEject( ));
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  INPUT  ---------- ---------- ---------- ---------- //
	
	/** Called when the mouse is clicked. Args : mouseX, mouseY, clickedButton */
	public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		buttonSet.interact((this.width  - this.imageWidth) / 2, (this.height - this.imageHeight) / 2, mouseX, mouseY);
		return false;
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  RENDER  ---------- ---------- ---------- ---------- //
	
	/** Draw the foreground layer for the GuiContainer (everything in front of the items) */
	protected void renderLabels(GuiGraphics matrix, int mouseX, int mouseY){
		int pos = 0;
		for(FoundryContent fc : menu.logic().content){
			if(fc.amount > 0){
				matrix.drawString(this.font, fc.id + " : " + fc.amount, this.imageWidth + 8+6, 8+6 + 24*pos, 16777215);
				pos++;
			}
		}
	}
	
	/** Draws the background layer of this container (behind the items). */
	protected void renderBg(GuiGraphics matrix, float partialTicks, int mouseX, int mouseY){
		int posX = (this.width  - this.imageWidth) / 2;
		int posY = (this.height - this.imageHeight) / 2;
		buttonSet.update(posX, posY, mouseX, mouseY);
		matrix.blit(TEXTURE, posX, posY, 0, 0, this.imageWidth, this.imageHeight);
		int pos = 0;
		amount = 0;
		int coal = menu.getCoal();
		for(FoundryContent fc : menu.logic().content){
			if(fc.amount > 0){
				amount += fc.amount;
				matrix.blit(TEXTURE, posX + this.imageWidth + 8, posY + 8 + 24*pos, 176, 64, 70, 22);
				pos++;
			}
		}
		matrix.blit(TEXTURE, posX + 17, posY + 11 + 64-amount, 176, 64 - amount, 25, amount);
		if(coal > 0){
			matrix.blit(TEXTURE, posX + 8, posY + 11 + 64-coal, 226, 64 - coal, 7, coal);
		}
		
		if(menu.getCookTime() > 0){
			int cook = (int)((float) menu.getCookTime() / menu.getCookTimeMax() * 100.0f);
			matrix.blit(TEXTURE, posX + 17, posY + 11 + 64-cook, 176+25, 64 - cook, 25, cook);
		}
		while (buttonSet.next()){
			if(buttonSet.isVisible()    ){ matrix.blit(TEXTURE, posX + buttonSet.pos().X, posY + buttonSet.pos().Y, buttonSet.map().X,       buttonSet.map().Y,       buttonSet.sizeX(), buttonSet.sizeY()); }
			if(buttonSet.isHighlighted()){ matrix.blit(TEXTURE, posX + buttonSet.pos().X, posY + buttonSet.pos().Y, buttonSet.highlight().X, buttonSet.highlight().Y, buttonSet.sizeX(), buttonSet.sizeY()); }
		}
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  COMMAND  ---------- ---------- ---------- ---------- //
	
	private void commandEject(){
		PacketHandler.sendToServer(new MessageEjectServer(menu.pos()));
	}
	
	private void commandIgnite(){
		PacketHandler.sendToServer(new MessageIgniteServer(menu.pos()));
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SUPPORT  ---------- ---------- ---------- ---------- //
	
	// ...
	
	
	
}
