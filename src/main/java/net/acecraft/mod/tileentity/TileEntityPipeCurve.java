package net.acecraft.mod.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.acecraft.mod.ShopKeeper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityPipeCurve extends TileEntity {
	
	public int metaIn;
	public int metaOut;
	public int energy;
	public int rotation;
	public int temp;
	
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
        this.rotation = nbt.getShort("rotation");
    }
	
    public void writeToNBT(NBTTagCompound nbt){
        super.writeToNBT(nbt);
        nbt.setShort("metaIn",   (short)this.metaIn);
        nbt.setShort("metaOut",  (short)this.metaOut);
        nbt.setShort("energy",   (short)this.energy);
        nbt.setShort("rotation", (short)this.rotation);
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
    	energy = 0;
    	if(metaIn == 0){ updateEnergy( 0,  1,  0); }
    	if(metaIn == 1){ updateEnergy( 0, -1,  0); }
    	if(metaIn == 2){ updateEnergy( 0,  0,  1); }
    	if(metaIn == 3){ updateEnergy( 0,  0, -1); }
    	if(metaIn == 4){ updateEnergy( 1,  0,  0); }
    	if(metaIn == 5){ updateEnergy(-1,  0,  0); }
    }
    
    private void updateEnergy(int vX, int vY, int vZ){
    	if(worldObj.getBlock(xCoord+vX, yCoord+vY, zCoord+vZ).equals(ShopKeeper.machinaPipeStraightLead) || worldObj.getBlock(xCoord+vX, yCoord+vY, zCoord+vZ).equals(ShopKeeper.machinaPipeStraightBronze)){
    		TileEntityPipeStraight entity = (TileEntityPipeStraight) worldObj.getTileEntity(xCoord+vX, yCoord+vY, zCoord+vZ);
    		if(entity.metaOut == metaIn){ energy = entity.energy; }
    	}else
    	if(worldObj.getBlock(xCoord+vX, yCoord+vY, zCoord+vZ).equals(ShopKeeper.machinaPipeCurveLead) || worldObj.getBlock(xCoord+vX, yCoord+vY, zCoord+vZ).equals(ShopKeeper.machinaPipeCurveBronze)){
        	TileEntityPipeCurve entity = (TileEntityPipeCurve) worldObj.getTileEntity(xCoord+vX, yCoord+vY, zCoord+vZ);
        	if(entity.metaOut == metaIn){ energy = entity.energy; }
        }else 
    	if(worldObj.getBlock(xCoord+vX, yCoord+vY, zCoord+vZ).equals(ShopKeeper.machinaPipeCrossingLead) || worldObj.getBlock(xCoord+vX, yCoord+vY, zCoord+vZ).equals(ShopKeeper.machinaPipeCrossingBronze)){
    		TileEntityPipeCrossing entity = (TileEntityPipeCrossing) worldObj.getTileEntity(xCoord+vX, yCoord+vY, zCoord+vZ);
    		if(entity.metaOut == metaIn){ energy = entity.energy; }
    	}else 
        if(worldObj.getBlock(xCoord+vX*2, yCoord+vY*2, zCoord+vZ*2).equals(ShopKeeper.machinaBoilerIdle) || worldObj.getBlock(xCoord+vX*2, yCoord+vY*2, zCoord+vZ*2).equals(ShopKeeper.machinaBoilerActive)){
        	TileEntityBoiler entity = (TileEntityBoiler) worldObj.getTileEntity(xCoord+vX*2, yCoord+vY*2, zCoord+vZ*2);
        	if(entity.isCrowned){ energy = entity.energyCollected; }
        }
    }
    
	public void firstSetUp(int m, int e) {
		metaIn  = m;
		metaOut = m;
		energy  = e;
		adjustOutput();
	}
	
	public void adjustOutput(){
		if(metaOut == 0){
			if(rotation == 0) metaIn = 3;
			if(rotation == 1) metaIn = 5;
			if(rotation == 2) metaIn = 2;
			if(rotation == 3) metaIn = 4;
		}
		if(metaOut == 1){
			if(rotation == 0) metaIn = 2;
			if(rotation == 1) metaIn = 5;
			if(rotation == 2) metaIn = 3;
			if(rotation == 3) metaIn = 4;
		}
		if(metaOut == 2){
			if(rotation == 0) metaIn = 1;
			if(rotation == 1) metaIn = 4;
			if(rotation == 2) metaIn = 0;
			if(rotation == 3) metaIn = 5;
		}
		if(metaOut == 3){
			if(rotation == 0) metaIn = 1;
			if(rotation == 1) metaIn = 5;
			if(rotation == 2) metaIn = 0;
			if(rotation == 3) metaIn = 4;
		}
		if(metaOut == 4){
			if(rotation == 0) metaIn = 2;
			if(rotation == 1) metaIn = 0;
			if(rotation == 2) metaIn = 3;
			if(rotation == 3) metaIn = 1;
		}
		if(metaOut == 5){
			if(rotation == 0) metaIn = 3;
			if(rotation == 1) metaIn = 0;
			if(rotation == 2) metaIn = 2;
			if(rotation == 3) metaIn = 1;
		}
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
	
	public void turnPipe(){
		this.rotation++;
		if(this.rotation > 3)
			this.rotation = 0;
		adjustOutput();
	}

}