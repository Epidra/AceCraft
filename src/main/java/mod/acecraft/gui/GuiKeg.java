package mod.acecraft.gui;

import org.lwjgl.opengl.GL11;

import mod.acecraft.AceCraft;
import mod.acecraft.container.ContainerKeg;
import mod.acecraft.tileentities.TileEntityKeg;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiKeg extends GuiContainer {
	
	public static final ResourceLocation texture = new ResourceLocation(AceCraft.modid + ":" + "textures/gui/Keg.png");
	private final InventoryPlayer playerInventory;
    private final TileEntityKeg keg;
	
	public GuiKeg(InventoryPlayer playerInv, IInventory furnaceInv){
		super(new ContainerKeg(playerInv, furnaceInv));
        this.playerInventory = playerInv;
        this.keg = (TileEntityKeg) furnaceInv;
		this.xSize = 176;
		this.ySize = 166;
	}
	
	public void drawGuiContainerForegroundLayer(int i, int j){
		
	}
	
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3){
		GL11.glColor4f(1F, 1F, 1F, 1F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		int j1 = keg.getFillingLevel();
		drawTexturedModalRect(guiLeft + 8, guiTop + 6 + (75 - j1), 176, 75 - j1, 35, j1);
		this.fontRenderer.drawString(keg.getContent(), guiLeft+50, guiTop+70, 4210752);
	}
	
}
