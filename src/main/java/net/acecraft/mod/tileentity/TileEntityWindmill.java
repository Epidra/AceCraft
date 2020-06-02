package net.acecraft.mod.tileentity;

import net.acecraft.mod.blocks.IMachinaEnergy;

public class TileEntityWindmill  extends ITileEntityEnergy {
	
	public void update(){
    	if(facing == null){
    		facing = worldObj.getBlockState(pos).getValue(IMachinaEnergy.FACING);
    	} else {
    		if(pos.getY() - 20 != energy){
    			energy = pos.getY() - 20;
    			this.markDirty();
    		}
    	}
    	rotation = rotation + energy;
        if(rotation >= 360) rotation -= 360;
    }
	
}
