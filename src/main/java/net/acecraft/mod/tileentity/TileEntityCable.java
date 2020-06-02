package net.acecraft.mod.tileentity;

import java.util.ArrayList;
import java.util.List;

import net.acecraft.mod.EnergyPackage;
import net.acecraft.mod.ShopKeeper;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityCable extends TileEntity {
	
	public int energy;
	public int energyCollected;
	public boolean hasNorth;
	public boolean hasEast;
	public boolean hasSouth;
	public boolean hasWest;
	public List<EnergyPackage> energyList = new ArrayList<EnergyPackage>();
	
	public void readFromNBT(NBTTagCompound nbt){
        super.readFromNBT(nbt);
        NBTTagList nbttaglist = nbt.getTagList("Items", 10);
        for (int i = 0; i < nbttaglist.tagCount(); ++i){
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");
        }
        this.energy = nbt.getShort("energy");
    }
	
    public void writeToNBT(NBTTagCompound nbt){
        super.writeToNBT(nbt);
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
    	if(worldObj.getBlock(xCoord, yCoord, zCoord+1).equals(ShopKeeper.machinaCable)){
    		hasSouth = true;
    		TileEntityCable entity = (TileEntityCable)worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
    		for(int i = 0; i < entity.energyList.size(); i++){
    			boolean temp = true;
    			for(int j = 0; j < energyList.size(); j++){
    				if(entity.energyList.get(i).id == energyList.get(j).id){
    					temp = false;
    					if(0 == energyList.get(j).direction.compareTo("fromsouth")){
    						energyList.get(j).energy = entity.energyList.get(i).energy;
    					}
    				}
    			}
    			if(temp){
    				energyList.add(new EnergyPackage(entity.energyList.get(i).id, entity.energyList.get(i).energy, "fromsouth"));
    			}
    		}
    		for(int j = 0; j < energyList.size(); j++){
    			boolean temp = false;
    			if(0 == energyList.get(j).direction.compareTo("fromsouth")){
    				temp = true;
    				for(int i = 0; i < entity.energyList.size(); i++){
        				if(energyList.get(j).id == entity.energyList.get(i).id){
        					temp = false;
        				}
        			}
				}
    			if(temp){
    				energyList.remove(j);
    				break;
    			}
    		}
    	}else
    	//if(worldObj.getBlock(xCoord, yCoord, zCoord+1).equals(ShopKeeper.machinaBattery)){
    	//	hasSouth = true;
    	//	TileEntityBattery entity = (TileEntityBattery)worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
        //}else
        //if(worldObj.getBlock(xCoord, yCoord, zCoord+1).equals(ShopKeeper.machinaEnergyNode)){
        //	hasSouth = true;
        //}else
    	if(worldObj.getBlock(xCoord, yCoord, zCoord+1).equals(ShopKeeper.machinaGenerator)){
    		if(2 == worldObj.getBlockMetadata(xCoord, yCoord, zCoord+1)){
    			hasSouth = true;
    			TileEntityGenerator entity = (TileEntityGenerator)worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
    			boolean temp = true;
        		for(int i = 0; i < energyList.size(); i++){
        			if(0 == energyList.get(i).direction.compareTo("nexttosouth")){
        				temp = false;
        				energyList.get(i).energy = entity.energy;
        				break;
        			}
        		}
        		if(temp)
        			energyList.add(new EnergyPackage(entity.id, entity.energy, "nexttosouth"));
    		}
    	}else
    	if(worldObj.getBlock(xCoord, yCoord, zCoord+1).equals(ShopKeeper.machinaMotor)){
    		if(3 == worldObj.getBlockMetadata(xCoord, yCoord, zCoord+1)){
    			hasSouth = true;
    		}
    	}else
    	if(worldObj.getBlock(xCoord, yCoord, zCoord+1).equals(ShopKeeper.machinaSolarCollector)){
    		hasSouth = true;
    		TileEntitySolarCollector entity = (TileEntitySolarCollector)worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
    		boolean temp = true;
    		for(int i = 0; i < energyList.size(); i++){
    			if(0 == energyList.get(i).direction.compareTo("nexttosouth")){
    				temp = false;
    				energyList.get(i).energy = entity.energy;
    				break;
    			}
    		}
    		if(temp)
    			energyList.add(new EnergyPackage(entity.id, entity.energy, "nexttosouth"));
    	}else{
    		hasSouth = false;
    		for(int i = 0; i < energyList.size(); i++){
    			if(0 == energyList.get(i).direction.compareTo("nexttosouth")){
    				energyList.remove(i);
    				break;
    			}
    			
    		}
    	}
    	
    	
    	
    	if(worldObj.getBlock(xCoord, yCoord, zCoord-1).equals(ShopKeeper.machinaCable)){
    		hasNorth = true;
    		TileEntityCable entity = (TileEntityCable)worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
    		for(int i = 0; i < entity.energyList.size(); i++){
    			boolean temp = true;
    			for(int j = 0; j < energyList.size(); j++){
    				if(entity.energyList.get(i).id == energyList.get(j).id){
    					temp = false;
    					if(0 == energyList.get(j).direction.compareTo("fromnorth")){
    						energyList.get(j).energy = entity.energyList.get(i).energy;
    					}
    				}
    			}
    			if(temp){
    				energyList.add(new EnergyPackage(entity.energyList.get(i).id, entity.energyList.get(i).energy, "fromnorth"));
    			}
    		}
    		for(int j = 0; j < energyList.size(); j++){
    			boolean temp = false;
    			if(0 == energyList.get(j).direction.compareTo("fromnorth")){
    				temp = true;
    				for(int i = 0; i < entity.energyList.size(); i++){
        				if(energyList.get(j).id == entity.energyList.get(i).id){
        					temp = false;
        				}
        			}
				}
    			if(temp){
    				energyList.remove(j);
    				break;
    			}
    		}
    	}else
    	//if(worldObj.getBlock(xCoord, yCoord, zCoord-1).equals(ShopKeeper.machinaBattery)){
    	//	hasNorth = true;
        //}else
        //if(worldObj.getBlock(xCoord, yCoord, zCoord-1).equals(ShopKeeper.machinaEnergyNode)){
        //	hasNorth = true;
        //}else
    	if(worldObj.getBlock(xCoord, yCoord, zCoord-1).equals(ShopKeeper.machinaGenerator)){
    		if(3 == worldObj.getBlockMetadata(xCoord, yCoord, zCoord-1)){
    			hasNorth = true;
    			TileEntityGenerator entity = (TileEntityGenerator)worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
    			boolean temp = true;
        		for(int i = 0; i < energyList.size(); i++){
        			if(0 == energyList.get(i).direction.compareTo("nexttonorth")){
        				temp = false;
        				energyList.get(i).energy = entity.energy;
        				break;
        			}
        		}
        		if(temp)
        			energyList.add(new EnergyPackage(entity.id, entity.energy, "nexttonorth"));
        	}else{
        		hasNorth = false;
        		for(int i = 0; i < energyList.size(); i++){
        			if(0 == energyList.get(i).direction.compareTo("nexttonorth")){
        				energyList.remove(i);
        				break;
        			}
        			
        		}
    		}
    	}else
    	if(worldObj.getBlock(xCoord, yCoord, zCoord-1).equals(ShopKeeper.machinaMotor)){
    		if(2 == worldObj.getBlockMetadata(xCoord, yCoord, zCoord-1)){
    			hasNorth = true; // ERROR: Doesn't do shit
    		}
    	}else
    	if(worldObj.getBlock(xCoord, yCoord, zCoord-1).equals(ShopKeeper.machinaSolarCollector)){
    		hasNorth = true;
    		TileEntitySolarCollector entity = (TileEntitySolarCollector)worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
    		boolean temp = true;
    		for(int i = 0; i < energyList.size(); i++){
    			if(0 == energyList.get(i).direction.compareTo("nexttonorth")){
    				temp = false;
    				energyList.get(i).energy = entity.energy;
    				break;
    			}
    		}
    		if(temp)
    			energyList.add(new EnergyPackage(entity.id, entity.energy, "nexttonorth"));
    	}else{
    		hasNorth = false;
    		for(int i = 0; i < energyList.size(); i++){
    			if(0 == energyList.get(i).direction.compareTo("nexttonorth")){
    				energyList.remove(i);
    				break;
    			}
    			
    		}
    	}
    	
    	
    	
    	
    	if(worldObj.getBlock(xCoord+1, yCoord, zCoord).equals(ShopKeeper.machinaCable)){
    		hasEast = true;
    		TileEntityCable entity = (TileEntityCable)worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
    		for(int i = 0; i < entity.energyList.size(); i++){
    			boolean temp = true;
    			for(int j = 0; j < energyList.size(); j++){
    				if(entity.energyList.get(i).id == energyList.get(j).id){
    					temp = false;
    					if(0 == energyList.get(j).direction.compareTo("fromeast")){
    						energyList.get(j).energy = entity.energyList.get(i).energy;
    					}
    				}
    			}
    			if(temp){
    				energyList.add(new EnergyPackage(entity.energyList.get(i).id, entity.energyList.get(i).energy, "fromeast"));
    			}
    		}
    		for(int j = 0; j < energyList.size(); j++){
    			boolean temp = false;
    			if(0 == energyList.get(j).direction.compareTo("fromeast")){
    				temp = true;
    				for(int i = 0; i < entity.energyList.size(); i++){
        				if(energyList.get(j).id == entity.energyList.get(i).id){
        					temp = false;
        				}
        			}
				}
    			if(temp){
    				energyList.remove(j);
    				break;
    			}
    		}
    	}else
    	//if(worldObj.getBlock(xCoord+1, yCoord, zCoord).equals(ShopKeeper.machinaBattery)){
    	//	hasEast = true;
        //}else
        //if(worldObj.getBlock(xCoord+1, yCoord, zCoord).equals(ShopKeeper.machinaEnergyNode)){
        //	hasEast = true;
        //}else
    	if(worldObj.getBlock(xCoord+1, yCoord, zCoord).equals(ShopKeeper.machinaGenerator)){
    		if(4 == worldObj.getBlockMetadata(xCoord+1, yCoord, zCoord)){
    			hasEast = true;
    			TileEntityGenerator entity = (TileEntityGenerator)worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
    			boolean temp = true;
        		for(int i = 0; i < energyList.size(); i++){
        			if(0 == energyList.get(i).direction.compareTo("nexttoeast")){
        				temp = false;
        				energyList.get(i).energy = entity.energy;
        				break;
        			}
        		}
        		if(temp)
        			energyList.add(new EnergyPackage(entity.id, entity.energy, "nexttoeast"));
        	}else{
        		hasEast = false;
        		for(int i = 0; i < energyList.size(); i++){
        			if(0 == energyList.get(i).direction.compareTo("nexttoeast")){
        				energyList.remove(i);
        				break;
        			}
        			
        		}
    		}
    	}else
    	if(worldObj.getBlock(xCoord+1, yCoord, zCoord).equals(ShopKeeper.machinaMotor)){
    		if(5 == worldObj.getBlockMetadata(xCoord+1, yCoord, zCoord)){
    			hasEast = true;
    		}
    	}else
    	if(worldObj.getBlock(xCoord+1, yCoord, zCoord).equals(ShopKeeper.machinaSolarCollector)){
    		hasEast = true;
    		TileEntitySolarCollector entity = (TileEntitySolarCollector)worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
    		boolean temp = true;
    		for(int i = 0; i < energyList.size(); i++){
    			if(0 == energyList.get(i).direction.compareTo("nexttoeast")){
    				temp = false;
    				energyList.get(i).energy = entity.energy;
    				break;
    			}
    		}
    		if(temp)
    			energyList.add(new EnergyPackage(entity.id, entity.energy, "nexttoeast"));
    	}else{
    		hasEast = false;
    		for(int i = 0; i < energyList.size(); i++){
    			if(0 == energyList.get(i).direction.compareTo("nexttoeast")){
    				energyList.remove(i);
    				break;
    			}
    			
    		}
    	}
    	
    	
    	
    	
    	if(worldObj.getBlock(xCoord-1, yCoord, zCoord).equals(ShopKeeper.machinaCable)){
    		hasWest = true;
    		TileEntityCable entity = (TileEntityCable)worldObj.getTileEntity(xCoord-1, yCoord, zCoord);
    		for(int i = 0; i < entity.energyList.size(); i++){
    			boolean temp = true;
    			for(int j = 0; j < energyList.size(); j++){
    				if(entity.energyList.get(i).id == energyList.get(j).id){
    					temp = false;
    					if(0 == energyList.get(j).direction.compareTo("fromwest")){
    						energyList.get(j).energy = entity.energyList.get(i).energy;
    					}
    				}
    			}
    			if(temp){
    				energyList.add(new EnergyPackage(entity.energyList.get(i).id, entity.energyList.get(i).energy, "fromwest"));
    			}
    		}
    		for(int j = 0; j < energyList.size(); j++){
    			boolean temp = false;
    			if(0 == energyList.get(j).direction.compareTo("fromwest")){
    				temp = true;
    				for(int i = 0; i < entity.energyList.size(); i++){
        				if(energyList.get(j).id == entity.energyList.get(i).id){
        					temp = false;
        				}
        			}
				}
    			if(temp){
    				energyList.remove(j);
    				break;
    			}
    		}
    	}else
    	//if(worldObj.getBlock(xCoord-1, yCoord, zCoord).equals(ShopKeeper.machinaBattery)){
    	//	hasWest = true;
        //}else
        //if(worldObj.getBlock(xCoord-1, yCoord, zCoord).equals(ShopKeeper.machinaEnergyNode)){
        //	hasWest = true;
        //}else
    	if(worldObj.getBlock(xCoord-1, yCoord, zCoord).equals(ShopKeeper.machinaGenerator)){
    		if(5 == worldObj.getBlockMetadata(xCoord-1, yCoord, zCoord)){
    			hasWest = true;
    			TileEntityGenerator entity = (TileEntityGenerator)worldObj.getTileEntity(xCoord-1, yCoord, zCoord);
        		boolean temp = true;
        		for(int i = 0; i < energyList.size(); i++){
        			if(0 == energyList.get(i).direction.compareTo("nexttowest")){
        				temp = false;
        				energyList.get(i).energy = entity.energy;
        				break;
        			}
        		}
        		if(temp)
        			energyList.add(new EnergyPackage(entity.id, entity.energy, "nexttowest"));
        	}else{
        		hasWest = false;
        		for(int i = 0; i < energyList.size(); i++){
        			if(0 == energyList.get(i).direction.compareTo("nexttowest")){
        				energyList.remove(i);
        				break;
        			}
        			
        		}
    		}
    	}else
    	if(worldObj.getBlock(xCoord-1, yCoord, zCoord).equals(ShopKeeper.machinaMotor)){
    		if(4 == worldObj.getBlockMetadata(xCoord-1, yCoord, zCoord)){
    			hasWest = true;
    		}
    	}else
    	if(worldObj.getBlock(xCoord-1, yCoord, zCoord).equals(ShopKeeper.machinaSolarCollector)){
    		hasWest = true;
    		TileEntitySolarCollector entity = (TileEntitySolarCollector)worldObj.getTileEntity(xCoord-1, yCoord, zCoord);
    		boolean temp = true;
    		for(int i = 0; i < energyList.size(); i++){
    			if(0 == energyList.get(i).direction.compareTo("nexttowest")){
    				temp = false;
    				energyList.get(i).energy = entity.energy;
    				break;
    			}
    		}
    		if(temp)
    			energyList.add(new EnergyPackage(entity.id, entity.energy, "nexttowest"));
    	}else{
    		hasWest = false;
    		for(int i = 0; i < energyList.size(); i++){
    			if(0 == energyList.get(i).direction.compareTo("nexttowest")){
    				energyList.remove(i);
    				break;
    			}
    			
    		}
    	}
    	
    	energyCollected = 0;
    	for(int i = 0; i < energyList.size(); i++){
    		energyCollected = energyCollected + energyList.get(i).energy;
    	}
    	System.out.println("Cable: " + energyCollected);
    	
    }
    
	public void updateEnergy(World world, int x, int y, int z, int e) {
		if(e != energy){
			energy = e;
		}
	}

	public void firstSetUp(int e) {
		energy = e;
		hasNorth = false;
		hasEast  = false;
		hasSouth = false;
		hasWest  = false;
	}
	
}
