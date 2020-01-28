package mod.acecraft.tileentities;

import mod.shared.blocks.IMachinaEnergy;
import mod.shared.tileentities.ITileEntityEnergy;

public class TileEntityWindmill extends ITileEntityEnergy {
	
	public void update(){
    	if(facing == null){
    		facing = world.getBlockState(pos).getValue(IMachinaEnergy.FACING);
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
