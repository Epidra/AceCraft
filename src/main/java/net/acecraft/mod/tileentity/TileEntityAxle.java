package net.acecraft.mod.tileentity;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityAxle extends TileEntity {
	
	public int meta;
	public int energy;
	
	public void readFromNBT(NBTTagCompound nbt){
        super.readFromNBT(nbt);
        NBTTagList nbttaglist = nbt.getTagList("Items", 10);
        for (int i = 0; i < nbttaglist.tagCount(); ++i){
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");
        }
        this.meta   = nbt.getShort("meta");
        this.energy = nbt.getShort("energy");
    }
	
    public void writeToNBT(NBTTagCompound nbt){
        super.writeToNBT(nbt);
        nbt.setShort("meta",   (short)this.meta);
        nbt.setShort("energy", (short)this.energy);
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
    	if(meta == 1){ updateEnergy( 0, -1,  0); }
    	if(meta == 0){ updateEnergy( 0,  1,  0); }
    	if(meta == 3){ updateEnergy( 0,  0, -1); }
    	if(meta == 2){ updateEnergy( 0,  0,  1); }
    	if(meta == 5){ updateEnergy(-1,  0,  0); }
    	if(meta == 4){ updateEnergy( 1,  0,  0); }
    }
    
    private void updateEnergy(int vX, int vY, int vZ){
    	if(worldObj.getBlock(xCoord+vX, yCoord+vY, zCoord+vZ).equals(ShopKeeper.machinaAxle)){
    		TileEntityAxle entityA = (TileEntityAxle) worldObj.getTileEntity(xCoord+vX, yCoord+vY, zCoord+vZ);
    		energy = entityA.energy;
    	}else
    	if(worldObj.getBlock(xCoord+vX, yCoord+vY, zCoord+vZ).equals(ShopKeeper.machinaGearBox)){
    		TileEntityGearBox entityG = (TileEntityGearBox) worldObj.getTileEntity(xCoord+vX, yCoord+vY, zCoord+vZ);
    		energy = entityG.energy;
    	}else
        if(worldObj.getBlock(xCoord+vX, yCoord+vY, zCoord+vZ).equals(ShopKeeper.machinaTurbine)){
        	TileEntityTurbine entityT = (TileEntityTurbine) worldObj.getTileEntity(xCoord+vX, yCoord+vY, zCoord+vZ);
        	energy = entityT.energy;
        }else
    	if(worldObj.getBlock(xCoord+vX, yCoord+vY, zCoord+vZ).equals(ShopKeeper.machinaMotor)){
        	TileEntityMotor entityM = (TileEntityMotor) worldObj.getTileEntity(xCoord+vX, yCoord+vY, zCoord+vZ);
        	energy = entityM.energy;
        }else{
        	energy = 0;
    	}
    }
    
	public void firstSetUp(int m, int e) {
		meta   = m;
		energy = e;
	}

}