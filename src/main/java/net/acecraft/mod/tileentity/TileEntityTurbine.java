package net.acecraft.mod.tileentity;

import net.acecraft.mod.ShopKeeper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityTurbine extends TileEntity {
	
	public int metaIn;
	public int metaOut;
	public int energy;
	
	public void readFromNBT(NBTTagCompound nbt){
        super.readFromNBT(nbt);
        NBTTagList nbttaglist = nbt.getTagList("Items", 10);
        for (int i = 0; i < nbttaglist.tagCount(); ++i){
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");
        }
        this.metaIn   = nbt.getShort("metaIn");
        this.metaOut  = nbt.getShort("metaOut");
        this.energy   = nbt.getShort("energy");
    }
	
    public void writeToNBT(NBTTagCompound nbt){
        super.writeToNBT(nbt);
        nbt.setShort("metaIn",   (short)this.metaIn);
        nbt.setShort("metaOut",  (short)this.metaOut);
        nbt.setShort("energy",   (short)this.energy);
        NBTTagList nbttaglist = new NBTTagList();
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
    	if(metaIn == 2){ updateEnergy( 0,  0, -2); }
    	if(metaIn == 3){ updateEnergy( 0,  0,  2); }
    	if(metaIn == 4){ updateEnergy(-2,  0,  0); }
    	if(metaIn == 5){ updateEnergy( 2,  0,  0); }
    }
    
    private void updateEnergy(int vX, int vY, int vZ){
    	energy = 0;
    	if(worldObj.getBlock(xCoord+vX, yCoord+vY, zCoord+vZ).equals(ShopKeeper.machinaPipeStraightLead) || worldObj.getBlock(xCoord+vX, yCoord+vY, zCoord+vZ).equals(ShopKeeper.machinaPipeStraightBronze)){
    		TileEntityPipeStraight entity = (TileEntityPipeStraight) worldObj.getTileEntity(xCoord+vX, yCoord+vY, zCoord+vZ);
    		if(revertMeta(entity.metaOut) == metaIn){ energy = entity.energy; }
    	}else
    	if(worldObj.getBlock(xCoord+vX, yCoord+vY, zCoord+vZ).equals(ShopKeeper.machinaPipeCurveLead) || worldObj.getBlock(xCoord+vX, yCoord+vY, zCoord+vZ).equals(ShopKeeper.machinaPipeCurveBronze)){
        	TileEntityPipeCurve entity = (TileEntityPipeCurve) worldObj.getTileEntity(xCoord+vX, yCoord+vY, zCoord+vZ);
        	if(revertMeta(entity.metaOut) == metaIn){ energy = entity.energy; }
        }else 
    	if(worldObj.getBlock(xCoord+vX, yCoord+vY, zCoord+vZ).equals(ShopKeeper.machinaPipeCrossingLead) || worldObj.getBlock(xCoord+vX, yCoord+vY, zCoord+vZ).equals(ShopKeeper.machinaPipeCrossingBronze)){
    		TileEntityPipeCrossing entity = (TileEntityPipeCrossing) worldObj.getTileEntity(xCoord+vX, yCoord+vY, zCoord+vZ);
    		if(revertMeta(entity.metaOut) == metaIn){ energy = entity.energy; }
    	}
    }
    
	public void firstSetUp(int m, int e) {
		metaIn  = m;
		metaOut = m;
		energy  = e;
		turnMeta();
	}
	
	private void turnMeta(){
		if(metaIn == 2) metaOut = 4;
		if(metaIn == 3) metaOut = 5;
		if(metaIn == 4) metaOut = 3;
		if(metaIn == 5) metaOut = 2;
	}
	
	private static int revertMeta(int i){
    	if(i == 0) return 1;
    	if(i == 1) return 0;
    	if(i == 2) return 3;
    	if(i == 3) return 2;
    	if(i == 4) return 5;
    	if(i == 5) return 4;
    	return i;
    }

}