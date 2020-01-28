package mod.acecraft.system;

import mod.acecraft.ShopKeeper;
import mod.acecraft.container.ContainerBlastFurnace;
import mod.acecraft.container.ContainerCampfire;
import mod.acecraft.container.ContainerDistillery;
import mod.acecraft.container.ContainerFruitPress;
import mod.acecraft.container.ContainerKeg;
import mod.acecraft.container.ContainerMillstone;
import mod.acecraft.gui.GuiBlastFurnace;
import mod.acecraft.gui.GuiCampfire;
import mod.acecraft.gui.GuiDistillery;
import mod.acecraft.gui.GuiFruitPress;
import mod.acecraft.gui.GuiKeg;
import mod.acecraft.gui.GuiMillstone;
import mod.acecraft.tileentities.TileEntityBlastFurnace;
import mod.acecraft.tileentities.TileEntityCampfire;
import mod.acecraft.tileentities.TileEntityDistillery;
import mod.acecraft.tileentities.TileEntityFruitPress;
import mod.acecraft.tileentities.TileEntityKeg;
import mod.acecraft.tileentities.TileEntityMillstone;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	
	@Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if(te != null){
        	if(ID == ShopKeeper.GuiID.BLASTFURNACE.ordinal()) if(te instanceof TileEntityBlastFurnace){ return new ContainerBlastFurnace(player.inventory, (IInventory)te); }
        	if(ID == ShopKeeper.GuiID.CAMPFIRE.ordinal())     if(te instanceof TileEntityCampfire)    { return new ContainerCampfire    (player.inventory, (IInventory)te); }
        	if(ID == ShopKeeper.GuiID.DISTILLERY.ordinal())   if(te instanceof TileEntityDistillery)  { return new ContainerDistillery  (player.inventory, (IInventory)te); }
        	if(ID == ShopKeeper.GuiID.FRUITPRESS.ordinal())   if(te instanceof TileEntityFruitPress)  { return new ContainerFruitPress  (player.inventory, (IInventory)te); }
        	if(ID == ShopKeeper.GuiID.MILLSTONE.ordinal())    if(te instanceof TileEntityMillstone)   { return new ContainerMillstone   (player.inventory, (IInventory)te); }
        	if(ID == ShopKeeper.GuiID.KEG.ordinal())          if(te instanceof TileEntityKeg)         { return new ContainerKeg         (player.inventory, (IInventory)te); }
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if(te != null){
        	if(ID == ShopKeeper.GuiID.BLASTFURNACE.ordinal()) if(te instanceof TileEntityBlastFurnace){ return new GuiBlastFurnace(player.inventory, (IInventory)te); }
        	if(ID == ShopKeeper.GuiID.CAMPFIRE.ordinal())     if(te instanceof TileEntityCampfire)    { return new GuiCampfire    (player.inventory, (IInventory)te); }
        	if(ID == ShopKeeper.GuiID.DISTILLERY.ordinal())   if(te instanceof TileEntityDistillery)  { return new GuiDistillery  (player.inventory, (IInventory)te); }
        	if(ID == ShopKeeper.GuiID.FRUITPRESS.ordinal())   if(te instanceof TileEntityFruitPress)  { return new GuiFruitPress  (player.inventory, (IInventory)te); }
        	if(ID == ShopKeeper.GuiID.MILLSTONE.ordinal())    if(te instanceof TileEntityMillstone)   { return new GuiMillstone   (player.inventory, (IInventory)te); }
        	if(ID == ShopKeeper.GuiID.KEG.ordinal())          if(te instanceof TileEntityKeg)         { return new GuiKeg         (player.inventory, (IInventory)te); }
        }
        return null;
    }
	
}
