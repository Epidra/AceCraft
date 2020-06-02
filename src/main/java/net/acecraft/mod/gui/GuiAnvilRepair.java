package net.acecraft.mod.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

import net.acecraft.mod.container.ContainerAnvilCrafting;
import net.acecraft.mod.container.ContainerAnvilRepair;
import net.acecraft.mod.tileentity.TileEntityAnvil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerRepair;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C17PacketCustomPayload;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.apache.commons.io.Charsets;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiAnvilRepair extends GuiContainer implements ICrafting{
    private static final ResourceLocation field_147093_u = new ResourceLocation("textures/gui/container/anvil.png");
    private ContainerAnvilRepair container;
    private GuiTextField textfield;
    private InventoryPlayer inventory;
    
    public GuiAnvilRepair(InventoryPlayer _inventory, TileEntityAnvil entity) {
    	super(new ContainerAnvilRepair(_inventory, entity));
    	container = new ContainerAnvilRepair(_inventory, entity);
    	this.xSize = 176;
    	this.ySize = 188;
    	inventory = _inventory;
	}
    
    public void initGui(){
        super.initGui();
        Keyboard.enableRepeatEvents(true);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.textfield = new GuiTextField(this.fontRendererObj, i + 62, j + 24, 103, 12);
        this.textfield.setTextColor(-1);
        this.textfield.setDisabledTextColour(-1);
        this.textfield.setEnableBackgroundDrawing(false);
        this.textfield.setMaxStringLength(40);
        this.inventorySlots.removeCraftingFromCrafters(this);
        this.inventorySlots.addCraftingToCrafters(this);
    }
    
    public void onGuiClosed(){
        super.onGuiClosed();
        Keyboard.enableRepeatEvents(false);
        this.inventorySlots.removeCraftingFromCrafters(this);
    }
    
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_){
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_BLEND);
        this.fontRendererObj.drawString(I18n.format("container.repair", new Object[0]), 60, 6, 4210752);
        if (this.container.maximumCost > 0){
            int k = 8453920;
            boolean flag = true;
            String s = I18n.format("container.repair.cost", new Object[] {Integer.valueOf(this.container.maximumCost)});
            if (this.container.maximumCost >= 40 && !this.mc.thePlayer.capabilities.isCreativeMode){
                s = I18n.format("container.repair.expensive", new Object[0]);
                k = 16736352;
            }else if (!this.container.getSlot(2).getHasStack()){
                flag = false;
            }else if (!this.container.getSlot(2).canTakeStack(this.inventory.player)){
                k = 16736352;
            }
            if (flag){
                int l = -16777216 | (k & 16579836) >> 2 | k & -16777216;
                int i1 = this.xSize - 8 - this.fontRendererObj.getStringWidth(s);
                byte b0 = 67;
                if (this.fontRendererObj.getUnicodeFlag()){
                    drawRect(i1 - 3, b0 - 2, this.xSize - 7, b0 + 10, -16777216);
                    drawRect(i1 - 2, b0 - 1, this.xSize - 8, b0 + 9, -12895429);
                }else{
                    this.fontRendererObj.drawString(s, i1, b0 + 1, l);
                    this.fontRendererObj.drawString(s, i1 + 1, b0, l);
                    this.fontRendererObj.drawString(s, i1 + 1, b0 + 1, l);
                }
                this.fontRendererObj.drawString(s, i1, b0, k);
            }
        }
        GL11.glEnable(GL11.GL_LIGHTING);
    }
    
    protected void keyTyped(char p_73869_1_, int p_73869_2_){
        if (this.textfield.textboxKeyTyped(p_73869_1_, p_73869_2_)){
            this.func_147090_g();
        }else{
            super.keyTyped(p_73869_1_, p_73869_2_);
        }
    }
    
    private void func_147090_g(){
        String s = this.textfield.getText();
        Slot slot = this.container.getSlot(0);
        if (slot != null && slot.getHasStack() && !slot.getStack().hasDisplayName() && s.equals(slot.getStack().getDisplayName())){
            s = "";
        }
        this.container.updateItemName(s);
        this.mc.thePlayer.sendQueue.addToSendQueue(new C17PacketCustomPayload("MC|ItemName", s.getBytes(Charsets.UTF_8)));
    }
    
    protected void mouseClicked(int p_73864_1_, int p_73864_2_, int p_73864_3_){
        super.mouseClicked(p_73864_1_, p_73864_2_, p_73864_3_);
        this.textfield.mouseClicked(p_73864_1_, p_73864_2_, p_73864_3_);
    }
    
    public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_){
        super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_BLEND);
        this.textfield.drawTextBox();
    }
    
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_){
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(field_147093_u);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        this.drawTexturedModalRect(k + 59, l + 20, 0, this.ySize + (this.container.getSlot(0).getHasStack() ? 0 : 16), 110, 16);
        if ((this.container.getSlot(0).getHasStack() || this.container.getSlot(1).getHasStack()) && !this.container.getSlot(2).getHasStack()){
            this.drawTexturedModalRect(k + 99, l + 45, this.xSize, 0, 28, 21);
        }
    }
    
    public void sendContainerAndContentsToPlayer(Container p_71110_1_, List p_71110_2_){
        this.sendSlotContents(p_71110_1_, 0, p_71110_1_.getSlot(0).getStack());
    }
    
    public void sendSlotContents(Container p_71111_1_, int p_71111_2_, ItemStack p_71111_3_){
        if (p_71111_2_ == 0){
            this.textfield.setText(p_71111_3_ == null ? "" : p_71111_3_.getDisplayName());
            this.textfield.setEnabled(p_71111_3_ != null);
            if (p_71111_3_ != null){
                this.func_147090_g();
            }
        }
    }
    
    public void sendProgressBarUpdate(Container p_71112_1_, int p_71112_2_, int p_71112_3_) {}

}