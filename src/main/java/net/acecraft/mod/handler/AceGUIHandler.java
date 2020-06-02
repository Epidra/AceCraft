package net.acecraft.mod.handler;

import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.container.ContainerAnvilCrafting;
import net.acecraft.mod.container.ContainerAnvilRepair;
import net.acecraft.mod.container.ContainerBlastFurnace;
import net.acecraft.mod.container.ContainerCampfire;
import net.acecraft.mod.container.ContainerDistillery;
import net.acecraft.mod.container.ContainerFruitPress;
import net.acecraft.mod.container.ContainerKeg;
import net.acecraft.mod.container.ContainerMillstone;
import net.acecraft.mod.container.ContainerSewingBench;
import net.acecraft.mod.container.ContainerCookingTable;
import net.acecraft.mod.container.ContainerWorkbench;
import net.acecraft.mod.gui.GuiAnvilCrafting;
import net.acecraft.mod.gui.GuiAnvilRepair;
import net.acecraft.mod.gui.GuiBlastFurnace;
import net.acecraft.mod.gui.GuiCampfire;
import net.acecraft.mod.gui.GuiDistillery;
import net.acecraft.mod.gui.GuiFruitPress;
import net.acecraft.mod.gui.GuiKeg;
import net.acecraft.mod.gui.GuiMillstone;
import net.acecraft.mod.gui.GuiSewingBench;
import net.acecraft.mod.gui.GuiCookingTable;
import net.acecraft.mod.gui.GuiWorkbench;
import net.acecraft.mod.tileentity.TileEntityBlastFurnace;
import net.acecraft.mod.tileentity.TileEntityCampfire;
import net.acecraft.mod.tileentity.TileEntityDistillery;
import net.acecraft.mod.tileentity.TileEntityFruitPress;
import net.acecraft.mod.tileentity.TileEntityKeg;
import net.acecraft.mod.tileentity.TileEntityMillstone;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class AceGUIHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if(te != null){
        	if(ID == ShopKeeper.guiIDBlastFurnace) if(te instanceof TileEntityBlastFurnace){ return new ContainerBlastFurnace(player.inventory, (IInventory)te); }
        	if(ID == ShopKeeper.guiIDCampfire)      if(te instanceof TileEntityCampfire)     { return new ContainerCampfire     (player.inventory, (IInventory)te); }
        	if(ID == ShopKeeper.guiIDDistillery)   if(te instanceof TileEntityDistillery)  { return new ContainerDistillery  (player.inventory, (IInventory)te); }
        	if(ID == ShopKeeper.guiIDFruitPress)   if(te instanceof TileEntityFruitPress)  { return new ContainerFruitPress  (player.inventory, (IInventory)te); }
        	if(ID == ShopKeeper.guiIDMillstone)    if(te instanceof TileEntityMillstone)   { return new ContainerMillstone   (player.inventory, (IInventory)te); }
        	if(ID == ShopKeeper.guiIDKeg)          if(te instanceof TileEntityKeg)         { return new ContainerKeg         (player.inventory, (IInventory)te); }
        }
        if(ID == ShopKeeper.guiIDWorkbench)     if(world.getBlockState(pos).getBlock() == ShopKeeper.machinaWorkbench)  { return new ContainerWorkbench    (player.inventory, world, pos); }
        if(ID == ShopKeeper.guiIDAnvilCrafting) if(world.getBlockState(pos).getBlock() == ShopKeeper.machinaAnvil)      { return new ContainerAnvilCrafting(player.inventory, world, pos); }
        if(ID == ShopKeeper.guiIDAnvilRepair)   if(world.getBlockState(pos).getBlock() == ShopKeeper.machinaAnvil)      { return new ContainerAnvilRepair  (player.inventory, world, pos, player); }
        if(ID == ShopKeeper.guiIDSewingBench)   if(world.getBlockState(pos).getBlock() == ShopKeeper.machinaSewingBench){ return new ContainerSewingBench  (player.inventory, world, pos); }
        if(ID == ShopKeeper.guiIDCookingTable)         if(world.getBlockState(pos).getBlock() == ShopKeeper.machinaStove)      { return new ContainerCookingTable        (player.inventory, world, pos); }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if(te != null){
        	if(ID == ShopKeeper.guiIDBlastFurnace) if(te instanceof TileEntityBlastFurnace){ return new GuiBlastFurnace(player.inventory, (IInventory)te); }
        	if(ID == ShopKeeper.guiIDCampfire)      if(te instanceof TileEntityCampfire)     { return new GuiCampfire     (player.inventory, (IInventory)te); }
        	if(ID == ShopKeeper.guiIDDistillery)   if(te instanceof TileEntityDistillery)  { return new GuiDistillery  (player.inventory, (IInventory)te); }
        	if(ID == ShopKeeper.guiIDFruitPress)   if(te instanceof TileEntityFruitPress)  { return new GuiFruitPress  (player.inventory, (IInventory)te); }
        	if(ID == ShopKeeper.guiIDMillstone)    if(te instanceof TileEntityMillstone)   { return new GuiMillstone   (player.inventory, (IInventory)te); }
        	if(ID == ShopKeeper.guiIDKeg)          if(te instanceof TileEntityKeg)         { return new GuiKeg         (player.inventory, (IInventory)te); }
        }
        if(ID == ShopKeeper.guiIDWorkbench)     if(world.getBlockState(pos).getBlock() == ShopKeeper.machinaWorkbench)  { return new GuiWorkbench    (player.inventory, world, pos); }
        if(ID == ShopKeeper.guiIDAnvilCrafting) if(world.getBlockState(pos).getBlock() == ShopKeeper.machinaAnvil)      { return new GuiAnvilCrafting(player.inventory, world, pos); }
        if(ID == ShopKeeper.guiIDAnvilRepair)   if(world.getBlockState(pos).getBlock() == ShopKeeper.machinaAnvil)      { return new GuiAnvilRepair  (player.inventory, world); }
        if(ID == ShopKeeper.guiIDSewingBench)   if(world.getBlockState(pos).getBlock() == ShopKeeper.machinaSewingBench){ return new GuiSewingBench  (player.inventory, world, pos); }
        if(ID == ShopKeeper.guiIDCookingTable)         if(world.getBlockState(pos).getBlock() == ShopKeeper.machinaStove)      { return new GuiCookingTable        (player.inventory, world, pos); }
        return null;
    }
}