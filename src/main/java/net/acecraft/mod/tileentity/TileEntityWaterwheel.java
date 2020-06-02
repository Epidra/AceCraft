package net.acecraft.mod.tileentity;

import net.acecraft.mod.ShopKeeper;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityWaterwheel extends TileEntity {
	
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
		int energy = 0;
		if(meta == 2){
			if(worldObj.getBlock(xCoord-1, yCoord-2, zCoord).equals(Blocks.water) || worldObj.getBlock(xCoord-1, yCoord-2, zCoord).equals(Blocks.flowing_water)) energy = energy + 17;
			if(worldObj.getBlock(xCoord  , yCoord-2, zCoord).equals(Blocks.water) || worldObj.getBlock(xCoord  , yCoord-2, zCoord).equals(Blocks.flowing_water)) energy = energy + 27;
			if(worldObj.getBlock(xCoord+1, yCoord-2, zCoord).equals(Blocks.water) || worldObj.getBlock(xCoord+1, yCoord-2, zCoord).equals(Blocks.flowing_water)) energy = energy + 17;
			if(worldObj.getBlock(xCoord+2, yCoord-1, zCoord).equals(Blocks.water) || worldObj.getBlock(xCoord+2, yCoord-1, zCoord).equals(Blocks.flowing_water)) energy = energy + 17;
			if(worldObj.getBlock(xCoord+2, yCoord  , zCoord).equals(Blocks.water) || worldObj.getBlock(xCoord+2, yCoord  , zCoord).equals(Blocks.flowing_water)) energy = energy + 27;
			if(worldObj.getBlock(xCoord+2, yCoord+1, zCoord).equals(Blocks.water) || worldObj.getBlock(xCoord+2, yCoord+1, zCoord).equals(Blocks.flowing_water)) energy = energy + 17;
		}
		if(meta == 3){
			if(worldObj.getBlock(xCoord+1, yCoord-2, zCoord).equals(Blocks.water) || worldObj.getBlock(xCoord+1, yCoord-2, zCoord).equals(Blocks.flowing_water)) energy = energy + 17;
			if(worldObj.getBlock(xCoord  , yCoord-2, zCoord).equals(Blocks.water) || worldObj.getBlock(xCoord  , yCoord-2, zCoord).equals(Blocks.flowing_water)) energy = energy + 27;
			if(worldObj.getBlock(xCoord-1, yCoord-2, zCoord).equals(Blocks.water) || worldObj.getBlock(xCoord-1, yCoord-2, zCoord).equals(Blocks.flowing_water)) energy = energy + 17;
			if(worldObj.getBlock(xCoord-2, yCoord-1, zCoord).equals(Blocks.water) || worldObj.getBlock(xCoord-2, yCoord-1, zCoord).equals(Blocks.flowing_water)) energy = energy + 17;
			if(worldObj.getBlock(xCoord-2, yCoord  , zCoord).equals(Blocks.water) || worldObj.getBlock(xCoord-2, yCoord  , zCoord).equals(Blocks.flowing_water)) energy = energy + 27;
			if(worldObj.getBlock(xCoord-2, yCoord+1, zCoord).equals(Blocks.water) || worldObj.getBlock(xCoord-2, yCoord+1, zCoord).equals(Blocks.flowing_water)) energy = energy + 17;
		}
		if(meta == 4){
			if(worldObj.getBlock(xCoord, yCoord-2, zCoord+1).equals(Blocks.water) || worldObj.getBlock(xCoord, yCoord-2, zCoord+1).equals(Blocks.flowing_water)) energy = energy + 17;
			if(worldObj.getBlock(xCoord, yCoord-2, zCoord  ).equals(Blocks.water) || worldObj.getBlock(xCoord, yCoord-2, zCoord  ).equals(Blocks.flowing_water)) energy = energy + 27;
			if(worldObj.getBlock(xCoord, yCoord-2, zCoord-1).equals(Blocks.water) || worldObj.getBlock(xCoord, yCoord-2, zCoord-1).equals(Blocks.flowing_water)) energy = energy + 17;
			if(worldObj.getBlock(xCoord, yCoord-1, zCoord-2).equals(Blocks.water) || worldObj.getBlock(xCoord, yCoord-1, zCoord-2).equals(Blocks.flowing_water)) energy = energy + 17;
			if(worldObj.getBlock(xCoord, yCoord  , zCoord-2).equals(Blocks.water) || worldObj.getBlock(xCoord, yCoord  , zCoord-2).equals(Blocks.flowing_water)) energy = energy + 27;
			if(worldObj.getBlock(xCoord, yCoord+1, zCoord-2).equals(Blocks.water) || worldObj.getBlock(xCoord, yCoord+2, zCoord-2).equals(Blocks.flowing_water)) energy = energy + 17;
		}
		if(meta == 5){
			if(worldObj.getBlock(xCoord, yCoord-2, zCoord-1).equals(Blocks.water) || worldObj.getBlock(xCoord, yCoord-2, zCoord-1).equals(Blocks.flowing_water)) energy = energy + 17;
			if(worldObj.getBlock(xCoord, yCoord-2, zCoord  ).equals(Blocks.water) || worldObj.getBlock(xCoord, yCoord-2, zCoord  ).equals(Blocks.flowing_water)) energy = energy + 27;
			if(worldObj.getBlock(xCoord, yCoord-2, zCoord+1).equals(Blocks.water) || worldObj.getBlock(xCoord, yCoord-2, zCoord+1).equals(Blocks.flowing_water)) energy = energy + 17;
			if(worldObj.getBlock(xCoord, yCoord-1, zCoord+2).equals(Blocks.water) || worldObj.getBlock(xCoord, yCoord-1, zCoord+2).equals(Blocks.flowing_water)) energy = energy + 17;
			if(worldObj.getBlock(xCoord, yCoord  , zCoord+2).equals(Blocks.water) || worldObj.getBlock(xCoord, yCoord  , zCoord+2).equals(Blocks.flowing_water)) energy = energy + 27;
			if(worldObj.getBlock(xCoord, yCoord+1, zCoord+2).equals(Blocks.water) || worldObj.getBlock(xCoord, yCoord+2, zCoord+2).equals(Blocks.flowing_water)) energy = energy + 17;
		}
	}
	
	public void firstSetUp(int m, int e) {
		meta   = m;
		energy = e;
	}

}