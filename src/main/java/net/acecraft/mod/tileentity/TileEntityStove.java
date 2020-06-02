package net.acecraft.mod.tileentity;

import net.acecraft.mod.ShopKeeper;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;

public class TileEntityStove extends TileEntity {
	
	public int direction;
	public boolean hasFurnace;
	public boolean hasCauldron;
	
	public TileEntityStove(){
		hasFurnace = false;
		hasCauldron = false;
	}
	
	public void updateEntity(){
		hasFurnace  = false;
		hasCauldron = false;
		for(int z = -2; z < 3; z++){
			for(int x = -2; x < 3; x++){
				if(worldObj.getBlock(xCoord+x, yCoord, zCoord+z) == Blocks.furnace || worldObj.getBlock(xCoord+x, yCoord, zCoord+z) == ShopKeeper.machinaBonfireIdle || worldObj.getBlock(xCoord+x, yCoord, zCoord+z) == ShopKeeper.machinaBonfireActive){
					hasFurnace = true;
				}
				if(worldObj.getBlock(xCoord+x, yCoord, zCoord+z) == Blocks.cauldron){
					hasCauldron = true;
				}
			}
		}
    }

}