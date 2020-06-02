package net.acecraft.mod.handler;

import cpw.mods.fml.common.network.IGuiHandler;
import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.container.ContainerAnvilCrafting;
import net.acecraft.mod.container.ContainerAnvilRepair;
import net.acecraft.mod.container.ContainerBlastFurnace;
import net.acecraft.mod.container.ContainerBoiler;
import net.acecraft.mod.container.ContainerBonfire;
import net.acecraft.mod.container.ContainerDistillery;
import net.acecraft.mod.container.ContainerFruitPress;
import net.acecraft.mod.container.ContainerKeg;
import net.acecraft.mod.container.ContainerMillstone;
import net.acecraft.mod.container.ContainerSewingStation;
import net.acecraft.mod.container.ContainerStove;
import net.acecraft.mod.container.ContainerWorkbench;
import net.acecraft.mod.gui.GuiAnvilCrafting;
import net.acecraft.mod.gui.GuiAnvilRepair;
import net.acecraft.mod.gui.GuiBlastFurnace;
import net.acecraft.mod.gui.GuiBoiler;
import net.acecraft.mod.gui.GuiBonfire;
import net.acecraft.mod.gui.GuiDistillery;
import net.acecraft.mod.gui.GuiFruitPress;
import net.acecraft.mod.gui.GuiKeg;
import net.acecraft.mod.gui.GuiMillstone;
import net.acecraft.mod.gui.GuiSewingStation;
import net.acecraft.mod.gui.GuiStove;
import net.acecraft.mod.gui.GuiWorkbench;
import net.acecraft.mod.tileentity.TileEntityAnvil;
import net.acecraft.mod.tileentity.TileEntityBlastFurnace;
import net.acecraft.mod.tileentity.TileEntityBoiler;
import net.acecraft.mod.tileentity.TileEntityBonfire;
import net.acecraft.mod.tileentity.TileEntityDistillery;
import net.acecraft.mod.tileentity.TileEntityFruitPress;
import net.acecraft.mod.tileentity.TileEntityKeg;
import net.acecraft.mod.tileentity.TileEntityMillstone;
import net.acecraft.mod.tileentity.TileEntitySewingStation;
import net.acecraft.mod.tileentity.TileEntityStove;
import net.acecraft.mod.tileentity.TileEntityWorkbench;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		if(entity != null) {
			switch(ID) {
				case ShopKeeper.guiIDBlastFurnace:  if(entity instanceof TileEntityBlastFurnace)  { return new ContainerBlastFurnace (player.inventory, (TileEntityBlastFurnace)  entity); } return null;
				case ShopKeeper.guiIDKeg:           if(entity instanceof TileEntityKeg)           { return new ContainerKeg          (player.inventory, (TileEntityKeg)           entity); } return null;
				case ShopKeeper.guiIDBonfire:       if(entity instanceof TileEntityBonfire)       { return new ContainerBonfire      (player.inventory, (TileEntityBonfire)       entity); } return null;
				case ShopKeeper.guiIDFruitPress:    if(entity instanceof TileEntityFruitPress)    { return new ContainerFruitPress   (player.inventory, (TileEntityFruitPress)    entity); } return null;
				case ShopKeeper.guiIDMillstone:     if(entity instanceof TileEntityMillstone)     { return new ContainerMillstone    (player.inventory, (TileEntityMillstone)     entity); } return null;
				case ShopKeeper.guiIDDistillery:    if(entity instanceof TileEntityDistillery)    { return new ContainerDistillery   (player.inventory, (TileEntityDistillery)    entity); } return null;
				case ShopKeeper.guiIDBoiler:        if(entity instanceof TileEntityBoiler)        { return new ContainerBoiler       (player.inventory, (TileEntityBoiler)        entity); } return null;
				case ShopKeeper.guiIDWorkbench:     if(entity instanceof TileEntityWorkbench)     { return new ContainerWorkbench    (player.inventory, (TileEntityWorkbench)     entity); } return null;
				case ShopKeeper.guiIDAnvilCrafting: if(entity instanceof TileEntityAnvil)         { return new ContainerAnvilCrafting(player.inventory, (TileEntityAnvil)         entity); } return null;
				case ShopKeeper.guiIDAnvilRepair:   if(entity instanceof TileEntityAnvil)         { return new ContainerAnvilRepair  (player.inventory, (TileEntityAnvil)         entity); } return null;
				case ShopKeeper.guiIDSewingStation: if(entity instanceof TileEntitySewingStation) { return new ContainerSewingStation(player.inventory, (TileEntitySewingStation) entity); } return null;
				case ShopKeeper.guiIDStove:         if(entity instanceof TileEntityStove)         { return new ContainerStove        (player.inventory, (TileEntityStove)         entity); } return null;
			}
			return null;
		}
		return entity;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		if(entity != null) {
			switch(ID) {
				case ShopKeeper.guiIDBlastFurnace:	if(entity instanceof TileEntityBlastFurnace)  { return new GuiBlastFurnace (player.inventory, (TileEntityBlastFurnace)  entity); } return null;
				case ShopKeeper.guiIDKeg:           if(entity instanceof TileEntityKeg)           { return new GuiKeg          (player.inventory, (TileEntityKeg)           entity); } return null;
				case ShopKeeper.guiIDBonfire:       if(entity instanceof TileEntityBonfire)       { return new GuiBonfire      (player.inventory, (TileEntityBonfire)       entity); } return null;
				case ShopKeeper.guiIDFruitPress:    if(entity instanceof TileEntityFruitPress)    { return new GuiFruitPress   (player.inventory, (TileEntityFruitPress)    entity); } return null;
				case ShopKeeper.guiIDMillstone:     if(entity instanceof TileEntityMillstone)     { return new GuiMillstone    (player.inventory, (TileEntityMillstone)     entity); } return null;
				case ShopKeeper.guiIDDistillery:    if(entity instanceof TileEntityDistillery)    { return new GuiDistillery   (player.inventory, (TileEntityDistillery)    entity); } return null;
				case ShopKeeper.guiIDBoiler:        if(entity instanceof TileEntityBoiler)        { return new GuiBoiler       (player.inventory, (TileEntityBoiler)        entity); } return null;
				case ShopKeeper.guiIDWorkbench:	    if(entity instanceof TileEntityWorkbench)     { return new GuiWorkbench    (player.inventory, (TileEntityWorkbench)     entity); } return null;
				case ShopKeeper.guiIDAnvilCrafting:	if(entity instanceof TileEntityAnvil)         { return new GuiAnvilCrafting(player.inventory, (TileEntityAnvil)         entity); } return null;
				case ShopKeeper.guiIDAnvilRepair:	if(entity instanceof TileEntityAnvil)         { return new GuiAnvilRepair  (player.inventory, (TileEntityAnvil)         entity); } return null;
				case ShopKeeper.guiIDSewingStation:	if(entity instanceof TileEntitySewingStation) { return new GuiSewingStation(player.inventory, (TileEntitySewingStation) entity); } return null;
				case ShopKeeper.guiIDStove:	        if(entity instanceof TileEntityStove)         { return new GuiStove        (player.inventory, (TileEntityStove)         entity); } return null;
			}
			return null;
		}
		return entity;
	}

}