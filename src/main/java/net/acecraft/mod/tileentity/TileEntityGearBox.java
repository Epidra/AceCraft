package net.acecraft.mod.tileentity;

import net.acecraft.mod.ShopKeeper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityGearBox extends TileEntity {
	
	private String field;
    public int energy;
    public int meta;
    
    public void func_145951_a(String p_145951_1_){
        this.field = p_145951_1_;
    }
    
    public void readFromNBT(NBTTagCompound nbt){
        super.readFromNBT(nbt);
        NBTTagList nbttaglist = nbt.getTagList("Items", 10);
        this.meta = nbt.getShort("meta");
        this.energy = nbt.getShort("energy");
        if (nbt.hasKey("CustomName", 8)){
            this.field = nbt.getString("CustomName");
        }
    }
    
    public void writeToNBT(NBTTagCompound nbt){
        super.writeToNBT(nbt);
        nbt.setShort("meta", (short)this.meta);
        nbt.setShort("energy", (short)this.energy);
        NBTTagList nbttaglist = new NBTTagList();
        nbt.setTag("Items", nbttaglist);
    }
    
    public void updateEntity(){
    	if(meta == 0){ updateEnergy( 0, -1,  0); }
    	if(meta == 1){ updateEnergy( 0,  1,  0); }
    	if(meta == 2){ updateEnergy( 0,  0, -1); }
    	if(meta == 3){ updateEnergy( 0,  0,  1); }
    	if(meta == 4){ updateEnergy(-1,  0,  0); }
    	if(meta == 5){ updateEnergy( 1,  0,  0); }
        this.markDirty();
    }

    private void updateEnergy(int vX, int vY, int vZ){
    	if(worldObj.getBlock(xCoord+vX, yCoord+vY, zCoord+vZ).equals(ShopKeeper.machinaAxle)){
    		TileEntityAxle entityA = (TileEntityAxle) worldObj.getTileEntity(xCoord+vX, yCoord+vY, zCoord+vZ);
    		energy = entityA.energy;
    	}else
    	if(worldObj.getBlock(xCoord+vX, yCoord+vY, zCoord+vZ).equals(ShopKeeper.machinaWindmillWool)){
    		TileEntityWindmillWool entityW = (TileEntityWindmillWool) worldObj.getTileEntity(xCoord+vX, yCoord+vY, zCoord+vZ);
    		energy = entityW.energy;
    	}else
    	if(worldObj.getBlock(xCoord+vX, yCoord+vY, zCoord+vZ).equals(ShopKeeper.machinaWindmillLeather)){
    		TileEntityWindmillLeather entityW = (TileEntityWindmillLeather) worldObj.getTileEntity(xCoord+vX, yCoord+vY, zCoord+vZ);
    		energy = entityW.energy;
    	}else
    	if(worldObj.getBlock(xCoord+vX, yCoord+vY, zCoord+vZ).equals(ShopKeeper.machinaWaterwheel)){
    		TileEntityWaterwheel entityW = (TileEntityWaterwheel) worldObj.getTileEntity(xCoord+vX, yCoord+vY, zCoord+vZ);
    		energy = entityW.energy;
    	}else{
    		energy = 0;
    	}
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
    
    public void BoxInput(int e){
    	this.energy = e;
    }
    
    public int BoxOutput(){
    	return energy;
    }
    
    public int BoxMeta(){
    	return meta;
    }
    
	public void firstSetUp(int l, int i) {
		this.meta = l;
		this.energy = i;
	}

}