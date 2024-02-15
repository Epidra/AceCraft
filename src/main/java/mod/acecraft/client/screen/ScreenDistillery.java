package mod.acecraft.client.screen;

import mod.acecraft.client.menu.MenuDistillery;
import mod.lucky77.screen.ScreenBase;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ScreenDistillery extends ScreenBase<MenuDistillery> {
	
	private static final ResourceLocation TEXTURE = new ResourceLocation("acecraft" + ":" + "textures/gui/distillery.png");
	
	
	
	
	
	// ---------- ---------- ---------- ----------  CONSTRUCTOR  ---------- ---------- ---------- ---------- //
	
	public ScreenDistillery(MenuDistillery container, Inventory player, Component name) {
		super(container, player, name, 176, 204);
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  INPUT  ---------- ---------- ---------- ---------- //
	
	// ...
	
	
	
	
	
	// ---------- ---------- ---------- ----------  RENDER  ---------- ---------- ---------- ---------- //
	
	protected void renderLabels(GuiGraphics matrix, int mouseX, int mouseY) {
		matrix.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, 4210752, false);
		matrix.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, 4210752, false);
	}
	
	@Override
	protected void renderBg(GuiGraphics matrix, float partialTicks, int mouseX, int mouseY) {
		int i = this.leftPos;
		int j = this.topPos;
		matrix.blit(TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
		if (this.menu.isLit()) {
			int burnProgress = this.menu.getBurnProgress();
			matrix.blit(TEXTURE, this.leftPos + 56, this.topPos + 48 - burnProgress, 176, 12 - burnProgress, 14, burnProgress + 1);
		}
		
		int cookingProcess = this.menu.getCookingProgress();
		matrix.blit(TEXTURE, this.leftPos + 79, this.topPos + 34, 176, 14, cookingProcess + 1, 16);
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  COMMAND  ---------- ---------- ---------- ---------- //
	
	// ...
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SUPPORT  ---------- ---------- ---------- ---------- //
	
	// ...
	
	
	
}
