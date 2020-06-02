package net.acecraft.mod.tileentity;

import net.acecraft.mod.ShopKeeper;
import net.minecraft.tileentity.TileEntity;

public class TileEntityRope extends TileEntity {	
	public int direction;
	
	public void updateEntity(){
		if(worldObj.getBlock(xCoord, yCoord+1, zCoord) != ShopKeeper.machinaAnchor && worldObj.getBlock(xCoord, yCoord+1, zCoord) != ShopKeeper.machinaRope){
			worldObj.getBlock(xCoord, yCoord, zCoord).dropBlockAsItem(worldObj, xCoord, yCoord, zCoord, direction, blockMetadata);
			worldObj.setBlockToAir(xCoord, yCoord, zCoord);
		}
	}

}