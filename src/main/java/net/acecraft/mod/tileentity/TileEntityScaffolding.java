package net.acecraft.mod.tileentity;

import net.acecraft.mod.block.machina.Scaffolding;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityScaffolding extends TileEntity {
	
	public int indicator;
	public int shift;
	public boolean top;
	
	public TileEntityScaffolding(){
		
	}
	
	public void readFromNBT(NBTTagCompound nbt){
        super.readFromNBT(nbt);
        this.indicator = nbt.getShort("indicator");
        this.shift = nbt.getShort("shift");
        this.top = nbt.getBoolean("top");
    }
	
    public void writeToNBT(NBTTagCompound nbt){
        super.writeToNBT(nbt);
        nbt.setShort("indicator", (short)this.indicator);
        nbt.setShort("shift", (short)this.shift);
        nbt.setBoolean("top", this.top);
    }
    
    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tagCompound = new NBTTagCompound();
        writeToNBT(tagCompound);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tagCompound);
    }
    
    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
        NBTTagCompound tag = pkt.func_148857_g();
        readFromNBT(tag);
    }
	
    public void updateEntity(){
    	int i = 0;
    	int s = 0;
    	boolean nn = false;
    	boolean ne = false;
    	boolean ee = false;
    	boolean se = false;
    	boolean ss = false;
    	boolean sw = false;
    	boolean ww = false;
    	boolean nw = false;
    	boolean tp = false;
    	if(worldObj.getBlock(xCoord  , yCoord  , zCoord-1) != Blocks.air) nn = true;
    	if(worldObj.getBlock(xCoord+1, yCoord  , zCoord-1) != Blocks.air) ne = true;
    	if(worldObj.getBlock(xCoord+1, yCoord  , zCoord  ) != Blocks.air) ee = true;
    	if(worldObj.getBlock(xCoord+1, yCoord  , zCoord+1) != Blocks.air) se = true;
    	if(worldObj.getBlock(xCoord  , yCoord  , zCoord+1) != Blocks.air) ss = true;
    	if(worldObj.getBlock(xCoord-1, yCoord  , zCoord+1) != Blocks.air) sw = true;
    	if(worldObj.getBlock(xCoord-1, yCoord  , zCoord  ) != Blocks.air) ww = true;
    	if(worldObj.getBlock(xCoord-1, yCoord  , zCoord-1) != Blocks.air) nw = true;
    	if(worldObj.getBlock(xCoord  , yCoord+1, zCoord  ) == Blocks.air) tp = true;
    	     if( nn &&  ne &&  ee &&  se &&  ss &&  sw &&  ww &&  nw){ i = 14; s = 0; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 0f, 1.0f, 1.0f, 1.0f); }
    	else if( nn &&  ne &&  ee &&  se &&  ss &&         ww &&  nw){ i = 13; s = 0; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 0f, 1.0f, 1.0f, 1.0f); }
    	else if( nn &&  ne &&  ee &&  se &&  ss &&  sw &&  ww       ){ i = 13; s = 1; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 0f, 1.0f, 1.0f, 1.0f); }
    	else if( nn &&         ee &&  se &&  ss &&  sw &&  ww &&  nw){ i = 13; s = 2; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 0f, 1.0f, 1.0f, 1.0f); }
    	else if( nn &&  ne &&  ee &&         ss &&  sw &&  ww &&  nw){ i = 13; s = 3; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 0f, 1.0f, 1.0f, 1.0f); }
    	else if( nn &&  ne &&  ee &&         ss &&         ww &&  nw){ i = 12; s = 0; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 0f, 1.0f, 1.0f, 1.0f); }
    	else if( nn &&  ne &&  ee &&  se &&  ss &&         ww       ){ i = 12; s = 1; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 0f, 1.0f, 1.0f, 1.0f); }
    	else if( nn &&         ee &&  se &&  ss &&  sw &&  ww       ){ i = 12; s = 2; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 0f, 1.0f, 1.0f, 1.0f); }
    	else if( nn &&         ee &&         ss &&  sw &&  ww &&  nw){ i = 12; s = 3; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 0f, 1.0f, 1.0f, 1.0f); }
    	else if( nn &&  ne &&  ee &&                       ww &&  nw){ i = 11; s = 0; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 0f, 1.0f, 1.0f, 1.0f); }
    	else if( nn &&  ne &&  ee &&  se &&  ss                     ){ i = 11; s = 1; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 0f, 1.0f, 1.0f, 1.0f); }
    	else if(               ee &&  se &&  ss &&  sw &&  ww       ){ i = 11; s = 2; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 0f, 1.0f, 1.0f, 1.0f); }
    	else if( nn &&                       ss &&  sw &&  ww &&  nw){ i = 11; s = 3; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 0f, 1.0f, 1.0f, 1.0f); }
    	else if( nn &&  ne &&  ee &&         ss &&  sw &&  ww       ){ i = 10; s = 0; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 0f, 1.0f, 1.0f, 1.0f); }
    	else if( nn        &&  ee &&  se &&  ss &&         ww &&  nw){ i = 10; s = 1; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 0f, 1.0f, 1.0f, 1.0f); }
    	else if( nn &&  ne &&  ee &&         ss &&         ww       ){ i =  9; s = 0; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 0f, 1.0f, 1.0f, 1.0f); }
    	else if( nn &&         ee &&  se &&  ss &&         ww       ){ i =  9; s = 1; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 0f, 1.0f, 1.0f, 1.0f); }
    	else if( nn &&         ee &&         ss &&  sw &&  ww       ){ i =  9; s = 2; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 0f, 1.0f, 1.0f, 1.0f); }
    	else if( nn &&         ee &&         ss &&         ww &&  nw){ i =  9; s = 3; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 0f, 1.0f, 1.0f, 1.0f); }
    	else if( nn &&  ne &&  ee &&         ss                     ){ i =  8; s = 0; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(1F/16*5, 0f, 0f, 1.0f, 1.0f, 1.0f); }
    	else if(               ee &&  se &&  ss &&         ww       ){ i =  8; s = 1; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 1F/16*5, 1.0f, 1.0f, 1.0f); }
    	else if( nn                      &&  ss &&  sw &&  ww       ){ i =  8; s = 2; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 0f, 1F/16*11, 1.0f, 1.0f); }
    	else if( nn        &&  ee                      &&  ww &&  nw){ i =  8; s = 3; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 0f, 1.0f, 1.0f, 1F/16*11); }
    	else if( nn &&  ne &&  ee &&                       ww       ){ i =  7; s = 0; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 0f, 1.0f, 1.0f, 1F/16*11); }
    	else if( nn &&         ee &&  se &&  ss                     ){ i =  7; s = 1; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(1F/16*5, 0f, 0f, 1.0f, 1.0f, 1.0f); }
    	else if(               ee &&         ss &&  sw &&  ww       ){ i =  7; s = 2; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 1F/16*5, 1.0f, 1.0f, 1.0f); }
    	else if( nn                      &&  ss        &&  ww &&  nw){ i =  7; s = 3; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 0f, 1F/16*11, 1.0f, 1.0f); }
    	     
    	else if( nn &&  ne &&  ee                                   ){ i =  6; s = 0; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(1F/16*5, 0f, 0f, 1.0f, 1.0f, 1F/16*11); }
    	else if(               ee &&  se &&  ss                     ){ i =  6; s = 1; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(1F/16*5, 0f, 1F/16*5, 1.0f, 1.0f, 1.0f); }
    	else if(                             ss &&  sw &&  ww       ){ i =  6; s = 2; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 1F/16*5, 1F/16*11, 1.0f, 1.0f); }
    	else if( nn &&                                     ww &&  nw){ i =  6; s = 3; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 0f, 1F/16*11, 1.0f, 1F/16*11); }
    	     
    	else if( nn &&         ee &&         ss &&         ww       ){ i =  5; s = 0; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 0f, 1.0f, 1.0f, 1.0f); }
    	     
    	else if( nn &&         ee &&                       ww       ){ i =  4; s = 0; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 0f, 1.0f, 1.0f, 1F/16*11); }
    	else if( nn &&         ee &&         ss                     ){ i =  4; s = 1; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(1F/16*5, 0f, 0f, 1.0f, 1.0f, 1.0f); }
    	else if(               ee &&         ss &&         ww       ){ i =  4; s = 2; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 1F/16*5, 1.0f, 1.0f, 1.0f); }
    	else if( nn &&                       ss &&         ww       ){ i =  4; s = 3; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 0f, 1F/16*11, 1.0f, 1.0f); }
    	     
    	else if( nn &&         ee                                   ){ i =  3; s = 0; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(1F/16*5, 0f, 0f, 1.0f, 1.0f, 1F/16*11); }
    	else if(               ee &&         ss                     ){ i =  3; s = 1; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(1F/16*5, 0f, 1F/16*5, 1.0f, 1.0f, 1.0f); }
    	else if(                             ss &&         ww       ){ i =  3; s = 2; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 1F/16*5, 1F/16*11, 1.0f, 1.0f); }
    	else if( nn &&                                     ww       ){ i =  3; s = 3; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 0f, 1F/16*11, 1.0f, 1F/16*11); }
    	     
    	else if( nn &&                       ss                     ){ i =  2; s = 0; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(1F/16*5, 0f, 0f, 1F/16*11, 1.0f, 1.0f); }
    	else if(               ee &&                       ww       ){ i =  2; s = 1; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 1F/16*5, 1.0f, 1.0f, 1F/16*11); }
    	     
    	else if( nn                                                 ){ i =  1; s = 0; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(1F/16*5, 0f, 0f, 1F/16*11, 1.0f, 1F/16*11); }
    	else if(               ee                                   ){ i =  1; s = 1; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(1F/16*5, 0f, 1F/16*5, 1.0f, 1.0f, 1F/16*11); }
    	else if(                             ss                     ){ i =  1; s = 2; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(1F/16*5, 0f, 1F/16*5, 1F/16*11, 1.0f, 1.0f); }
    	else if(                                           ww       ){ i =  1; s = 3; worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(0f, 0f, 1F/16*5, 1F/16*11, 1.0f, 1F/16*11); }
    	else{
    		worldObj.getBlock(xCoord, yCoord, zCoord).setBlockBounds(1F/16*5, 0f, 1F/16*5, 1F/16*11, 1.0f, 1F/16*11); 
    	}
	     indicator = i;
	     shift = s;
	     top = tp;
	     markDirty();
    }
    
	public void SubmitData(int i, int s, boolean tp){
		indicator = i;
		shift = s;
		top = tp;
		markDirty();
		Scaffolding block = (Scaffolding)worldObj.getBlock(xCoord, yCoord, zCoord);
	}
	
}