package net.acecraft.mod.tileentity;

import net.acecraft.mod.ShopKeeper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityGenerator extends TileEntity {
	
	public int meta;
	public int energy;
	public int id;
	
	public void readFromNBT(NBTTagCompound nbt){
        super.readFromNBT(nbt);
        NBTTagList nbttaglist = nbt.getTagList("Items", 10);
        for (int i = 0; i < nbttaglist.tagCount(); ++i){
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");
        }
        this.meta   = nbt.getShort("meta");
        this.energy = nbt.getShort("energy");
        this.id     = nbt.getShort("id");
    }
	
    public void writeToNBT(NBTTagCompound nbt){
        super.writeToNBT(nbt);
        nbt.setShort("meta",   (short)this.meta);
        nbt.setShort("energy", (short)this.energy);
        nbt.setShort("id",     (short)this.id);
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
    	if(meta == 0){
    		meta = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
    	}
    	if(meta == 2){ updateEnergy( 0,  0,  1); }
    	if(meta == 3){ updateEnergy( 0,  0, -1); }
    	if(meta == 4){ updateEnergy( 1,  0,  0); }
    	if(meta == 5){ updateEnergy(-1,  0,  0); }
        this.markDirty();
    }
    
    private void updateEnergy(int vX, int vY, int vZ){
    	if(worldObj.getBlock(xCoord+vX, yCoord+vY, zCoord+vZ).equals(ShopKeeper.machinaAxle)){
    		TileEntityAxle entityA = (TileEntityAxle) worldObj.getTileEntity(xCoord+vX, yCoord+vY, zCoord+vZ);
    		if(entityA.meta == revertMeta(meta))
    			energy = entityA.energy;
    	}else{
    		energy = 0;
        }
    }
    
	public void firstSetUp(int m, int e) {
		meta   = m;
		energy = e;
		id = worldObj.rand.nextInt(1000000);
		markDirty();
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