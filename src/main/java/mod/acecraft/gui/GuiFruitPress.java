package mod.acecraft.gui;

public class GuiFruitPress {

}

//@SideOnly(Side.CLIENT)
//public class GuiFruitPress extends GuiContainer {
//
//    private static final ResourceLocation FURNACE_GUI_TEXTURES = new ResourceLocation(AceCraft.modid + ":" + "textures/gui/FruitPress.png");
//    /** The player inventory bound to this GUI. */
//    private final InventoryPlayer playerInventory;
//    private final IInventory tileFurnace;
//
//    public GuiFruitPress(InventoryPlayer playerInv, IInventory furnaceInv){
//        super(new ContainerFruitPress(playerInv, furnaceInv));
//        this.playerInventory = playerInv;
//        this.tileFurnace = furnaceInv;
//    }
//
//    protected void drawGuiContainerForegroundLayer(int i, int j){
//
//    }
//
//    protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3){
//        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
//        this.mc.getTextureManager().bindTexture(FURNACE_GUI_TEXTURES);
//        int k = (this.width - this.xSize) / 2;
//        int l = (this.height - this.ySize) / 2;
//        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
//        if (((TileEntityFruitPress) this.tileFurnace).hasEnergy()){
//            int i1 = ((TileEntityFruitPress) this.tileFurnace).getCookProgressScaled();
//            this.drawTexturedModalRect(guiLeft + 60, guiTop + 34, 176, 75, i1 + 1, 16);
//            int i2 = ((TileEntityFruitPress) this.tileFurnace).getFillingLevelScaled();
//            this.drawTexturedModalRect(guiLeft + 133, guiTop + 6 + (75 - i2), 176, 75 - i2, 35, i2);
//            int i3 = ((TileEntityFruitPress) this.tileFurnace).getEnergyScaled();
//            this.drawTexturedModalRect(guiLeft + 11, guiTop + 18 + (50 - i3), 211, 50 - i3, 20, i3);
//        }
//        this.fontRenderer.drawString(((TileEntityFruitPress) tileFurnace).getContent(), guiLeft+36, guiTop+60, 4210752);
//    }
//
//}
