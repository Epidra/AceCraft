package net.acecraft.mod.tileentity;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityRoof extends TileEntity {
	
	public int meta;
	public int direction;
	public boolean dS = false;
	public boolean dO = false;
	public boolean dI = false;
	public boolean d1 = false;
	public boolean d2 = false;
	public boolean turn = false;
	
	public void readFromNBT(NBTTagCompound nbt){
        super.readFromNBT(nbt);
        NBTTagList nbttaglist = nbt.getTagList("Items", 10);
        for (int i = 0; i < nbttaglist.tagCount(); ++i){
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");
        }
        this.meta = nbt.getShort("meta");
        this.dS = nbt.getBoolean("dS");
        this.dO = nbt.getBoolean("dO");
        this.dI = nbt.getBoolean("dI");
        this.d1 = nbt.getBoolean("d1");
        this.d2 = nbt.getBoolean("d2");
        this.turn = nbt.getBoolean("turn");
    }
	
    public void writeToNBT(NBTTagCompound nbt){
        super.writeToNBT(nbt);
        nbt.setShort("meta", (short)this.meta);
        nbt.setBoolean("dS", this.dS);
        nbt.setBoolean("dO", this.dO);
        nbt.setBoolean("dI", this.dI);
        nbt.setBoolean("d1", this.d1);
        nbt.setBoolean("d2", this.d2);
        nbt.setBoolean("turn", this.turn);
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
    	dS = true;
    	dO = false;
    	dI = false;
    	d1 = false;
    	d2 = false;
    	turn = false;
    	boolean temp1 = false;
    	boolean temp2 = false;
    	if(meta == 2){
    		if(compareBlock(worldObj.getBlock(xCoord+1, yCoord, zCoord))){ // To the Left
    			TileEntityRoof entity = (TileEntityRoof) worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
    			if(entity.meta == 5 && worldObj.isAirBlock(xCoord+1, yCoord+1, zCoord)) d2 = true;
    			if(entity.meta == 2) temp1 = true;
    			if(entity.meta == 2 && entity.turn) d2 = true;
    		}
    		if(compareBlock(worldObj.getBlock(xCoord-1, yCoord, zCoord))){ // To the Right
    			TileEntityRoof entity = (TileEntityRoof) worldObj.getTileEntity(xCoord-1, yCoord, zCoord);
    			if(entity.meta == 2) temp2 = true;
    		}
    		if(compareBlock(worldObj.getBlock(xCoord, yCoord, zCoord-1))){ // In Front
    			TileEntityRoof entity = (TileEntityRoof) worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
    			if(entity.meta == 4) dI = true;
    			if(entity.meta == 5){dI = true; turn = true;}
    		}
    		if(compareBlock(worldObj.getBlock(xCoord, yCoord, zCoord+1))){ // Behind
    			TileEntityRoof entity = (TileEntityRoof) worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
    			if(entity.meta == 4) if(!dI && !temp2) dO = true;
    			if(entity.meta == 5) if(!dI && !temp1){dO = true; turn = true;}
    			if(entity.meta == 3 && worldObj.isAirBlock(xCoord, yCoord+1, zCoord+1)) d1 = true;
    		}
    	}
    	if(meta == 3){
    		if(compareBlock(worldObj.getBlock(xCoord-1, yCoord, zCoord))){ // To the Left
    			TileEntityRoof entity = (TileEntityRoof) worldObj.getTileEntity(xCoord-1, yCoord, zCoord);
    			if(entity.meta == 4 && worldObj.isAirBlock(xCoord-1, yCoord+1, zCoord)) d2 = true;
    			if(entity.meta == 3) temp1 = true;
    			if(entity.meta == 3 && entity.turn) d2 = true;
    		}
    		if(compareBlock(worldObj.getBlock(xCoord+1, yCoord, zCoord))){ // To the Right
    			TileEntityRoof entity = (TileEntityRoof) worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
    			if(entity.meta == 3) temp2 = true;
    		}
    		if(compareBlock(worldObj.getBlock(xCoord, yCoord, zCoord+1))){ // In Front
    			TileEntityRoof entity = (TileEntityRoof) worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
    			if(entity.meta == 5) dI = true;
    			if(entity.meta == 4){dI = true; turn = true;}
    		}
    		if(compareBlock(worldObj.getBlock(xCoord, yCoord, zCoord-1))){ // Behind
    			TileEntityRoof entity = (TileEntityRoof) worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
    			if(entity.meta == 5) if(!dI && !temp2) dO = true;
    			if(entity.meta == 4) if(!dI && !temp1){dO = true; turn = true;}
    			if(entity.meta == 2 && worldObj.isAirBlock(xCoord, yCoord+1, zCoord+1)) d1 = true;
    		}
    	}
    	if(meta == 4){
        	if(compareBlock(worldObj.getBlock(xCoord, yCoord, zCoord+1))){ // To the Left
        		TileEntityRoof entity = (TileEntityRoof) worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
        		if(entity.meta == 3 && worldObj.isAirBlock(xCoord, yCoord+1, zCoord+1)) d2 = true;
        		if(entity.meta == 4) temp1 = true;
        		if(entity.meta == 4 && entity.turn) d2 = true;
        	}
        	if(compareBlock(worldObj.getBlock(xCoord, yCoord, zCoord-1))){ // To the Right
        		TileEntityRoof entity = (TileEntityRoof) worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
        		if(entity.meta == 4) temp2 = true;
        	}
        	if(compareBlock(worldObj.getBlock(xCoord-1, yCoord, zCoord))){ // In Front
        		TileEntityRoof entity = (TileEntityRoof) worldObj.getTileEntity(xCoord-1, yCoord, zCoord);
        		if(entity.meta == 3) dI = true;
        		if(entity.meta == 2){dI = true; turn = true;}
        	}
        	if(compareBlock(worldObj.getBlock(xCoord+1, yCoord, zCoord))){ // Behind
        		TileEntityRoof entity = (TileEntityRoof) worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
        		if(entity.meta == 3) if(!dI && !temp2) dO = true;
        		if(entity.meta == 2) if(!dI && !temp1){dO = true; turn = true;}
        		if(entity.meta == 5 && worldObj.isAirBlock(xCoord+1, yCoord+1, zCoord)) d1 = true;
        	}
        }
    	if(meta == 5){
        	if(compareBlock(worldObj.getBlock(xCoord, yCoord, zCoord-1))){ // To the Left
        		TileEntityRoof entity = (TileEntityRoof) worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
        		if(entity.meta == 2 && worldObj.isAirBlock(xCoord, yCoord+1, zCoord-1)) d2 = true;
        		if(entity.meta == 5) temp1 = true;
        		if(entity.meta == 5 && entity.turn) d2 = true;
        	}
        	if(compareBlock(worldObj.getBlock(xCoord, yCoord, zCoord+1))){ // To the Right
        		TileEntityRoof entity = (TileEntityRoof) worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
        		if(entity.meta == 5) temp2 = true;
        	}
        	if(compareBlock(worldObj.getBlock(xCoord+1, yCoord, zCoord))){ // In Front
        		TileEntityRoof entity = (TileEntityRoof) worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
        		if(entity.meta == 2) dI = true;
        		if(entity.meta == 3){dI = true; turn = true;}
        	}
        	if(compareBlock(worldObj.getBlock(xCoord-1, yCoord, zCoord))){ // Behind
        		TileEntityRoof entity = (TileEntityRoof) worldObj.getTileEntity(xCoord-1, yCoord, zCoord);
        		if(entity.meta == 2) if(!dI && !temp2) dO = true;
        		if(entity.meta == 3) if(!dI && !temp1){dO = true; turn = true;}
        		if(entity.meta == 4 && worldObj.isAirBlock(xCoord-1, yCoord+1, zCoord)) d1 = true;
        	}
        }
    	
    	if(dO || dI) dS = false;
    	markDirty();
    }
    
	public void firstSetUp(int m, String s) {
		meta = m;
		markDirty();
	}
	
	public boolean compareBlock(Block block){
		
		if(block == null) return false;
		
		if(block == ShopKeeper.roofAcaciaStraw)      return true;
		if(block == ShopKeeper.roofAcaciaReeds)      return true;
		if(block == ShopKeeper.roofAcaciaClay)       return true;
		if(block == ShopKeeper.roofAcaciaCopper)     return true;
		if(block == ShopKeeper.roofAcaciaTin)        return true;
		if(block == ShopKeeper.roofAcaciaBrass)      return true;
		if(block == ShopKeeper.roofAcaciaGold)       return true;
		if(block == ShopKeeper.roofAcaciaMythril)    return true;
		if(block == ShopKeeper.roofAcaciaOrichalcum) return true;
		if(block == ShopKeeper.roofAcaciaNether)     return true;
		
		if(block == ShopKeeper.roofBigOakStraw)      return true;
		if(block == ShopKeeper.roofBigOakReeds)      return true;
		if(block == ShopKeeper.roofBigOakClay)       return true;
		if(block == ShopKeeper.roofBigOakCopper)     return true;
		if(block == ShopKeeper.roofBigOakTin)        return true;
		if(block == ShopKeeper.roofBigOakBrass)      return true;
		if(block == ShopKeeper.roofBigOakGold)       return true;
		if(block == ShopKeeper.roofBigOakMythril)    return true;
		if(block == ShopKeeper.roofBigOakOrichalcum) return true;
		if(block == ShopKeeper.roofBigOakNether)     return true;
		
		if(block == ShopKeeper.roofBirchStraw)      return true;
		if(block == ShopKeeper.roofBirchReeds)      return true;
		if(block == ShopKeeper.roofBirchClay)       return true;
		if(block == ShopKeeper.roofBirchCopper)     return true;
		if(block == ShopKeeper.roofBirchTin)        return true;
		if(block == ShopKeeper.roofBirchBrass)      return true;
		if(block == ShopKeeper.roofBirchGold)       return true;
		if(block == ShopKeeper.roofBirchMythril)    return true;
		if(block == ShopKeeper.roofBirchOrichalcum) return true;
		if(block == ShopKeeper.roofBirchNether)     return true;
		
		if(block == ShopKeeper.roofJungleStraw)      return true;
		if(block == ShopKeeper.roofJungleReeds)      return true;
		if(block == ShopKeeper.roofJungleClay)       return true;
		if(block == ShopKeeper.roofJungleCopper)     return true;
		if(block == ShopKeeper.roofJungleTin)        return true;
		if(block == ShopKeeper.roofJungleBrass)      return true;
		if(block == ShopKeeper.roofJungleGold)       return true;
		if(block == ShopKeeper.roofJungleMythril)    return true;
		if(block == ShopKeeper.roofJungleOrichalcum) return true;
		if(block == ShopKeeper.roofJungleNether)     return true;
		
		if(block == ShopKeeper.roofOakStraw)      return true;
		if(block == ShopKeeper.roofOakReeds)      return true;
		if(block == ShopKeeper.roofOakClay)       return true;
		if(block == ShopKeeper.roofOakCopper)     return true;
		if(block == ShopKeeper.roofOakTin)        return true;
		if(block == ShopKeeper.roofOakBrass)      return true;
		if(block == ShopKeeper.roofOakGold)       return true;
		if(block == ShopKeeper.roofOakMythril)    return true;
		if(block == ShopKeeper.roofOakOrichalcum) return true;
		if(block == ShopKeeper.roofOakNether)     return true;
		
		if(block == ShopKeeper.roofSpruceStraw)      return true;
		if(block == ShopKeeper.roofSpruceReeds)      return true;
		if(block == ShopKeeper.roofSpruceClay)       return true;
		if(block == ShopKeeper.roofSpruceCopper)     return true;
		if(block == ShopKeeper.roofSpruceTin)        return true;
		if(block == ShopKeeper.roofSpruceBrass)      return true;
		if(block == ShopKeeper.roofSpruceGold)       return true;
		if(block == ShopKeeper.roofSpruceMythril)    return true;
		if(block == ShopKeeper.roofSpruceOrichalcum) return true;
		if(block == ShopKeeper.roofSpruceNether)     return true;
		
		if(block == ShopKeeper.roofFruitStraw)      return true;
		if(block == ShopKeeper.roofFruitReeds)      return true;
		if(block == ShopKeeper.roofFruitClay)       return true;
		if(block == ShopKeeper.roofFruitCopper)     return true;
		if(block == ShopKeeper.roofFruitTin)        return true;
		if(block == ShopKeeper.roofFruitBrass)      return true;
		if(block == ShopKeeper.roofFruitGold)       return true;
		if(block == ShopKeeper.roofFruitMythril)    return true;
		if(block == ShopKeeper.roofFruitOrichalcum) return true;
		if(block == ShopKeeper.roofFruitNether)     return true;
		
		if(block == ShopKeeper.roofGoldenStraw)      return true;
		if(block == ShopKeeper.roofGoldenReeds)      return true;
		if(block == ShopKeeper.roofGoldenClay)       return true;
		if(block == ShopKeeper.roofGoldenCopper)     return true;
		if(block == ShopKeeper.roofGoldenTin)        return true;
		if(block == ShopKeeper.roofGoldenBrass)      return true;
		if(block == ShopKeeper.roofGoldenGold)       return true;
		if(block == ShopKeeper.roofGoldenMythril)    return true;
		if(block == ShopKeeper.roofGoldenOrichalcum) return true;
		if(block == ShopKeeper.roofGoldenNether)     return true;
		
		if(block == ShopKeeper.roofPalmStraw)      return true;
		if(block == ShopKeeper.roofPalmReeds)      return true;
		if(block == ShopKeeper.roofPalmClay)       return true;
		if(block == ShopKeeper.roofPalmCopper)     return true;
		if(block == ShopKeeper.roofPalmTin)        return true;
		if(block == ShopKeeper.roofPalmBrass)      return true;
		if(block == ShopKeeper.roofPalmGold)       return true;
		if(block == ShopKeeper.roofPalmMythril)    return true;
		if(block == ShopKeeper.roofPalmOrichalcum) return true;
		if(block == ShopKeeper.roofPalmNether)     return true;
		
		if(block == ShopKeeper.roofBrickStraw)      return true;
		if(block == ShopKeeper.roofBrickReeds)      return true;
		if(block == ShopKeeper.roofBrickClay)       return true;
		if(block == ShopKeeper.roofBrickCopper)     return true;
		if(block == ShopKeeper.roofBrickTin)        return true;
		if(block == ShopKeeper.roofBrickBrass)      return true;
		if(block == ShopKeeper.roofBrickGold)       return true;
		if(block == ShopKeeper.roofBrickMythril)    return true;
		if(block == ShopKeeper.roofBrickOrichalcum) return true;
		if(block == ShopKeeper.roofBrickNether)     return true;
		
		if(block == ShopKeeper.roofCobblestoneStraw)      return true;
		if(block == ShopKeeper.roofCobblestoneReeds)      return true;
		if(block == ShopKeeper.roofCobblestoneClay)       return true;
		if(block == ShopKeeper.roofCobblestoneCopper)     return true;
		if(block == ShopKeeper.roofCobblestoneTin)        return true;
		if(block == ShopKeeper.roofCobblestoneBrass)      return true;
		if(block == ShopKeeper.roofCobblestoneGold)       return true;
		if(block == ShopKeeper.roofCobblestoneMythril)    return true;
		if(block == ShopKeeper.roofCobblestoneOrichalcum) return true;
		if(block == ShopKeeper.roofCobblestoneNether)     return true;
		
		if(block == ShopKeeper.roofCobblestoneMossyStraw)      return true;
		if(block == ShopKeeper.roofCobblestoneMossyReeds)      return true;
		if(block == ShopKeeper.roofCobblestoneMossyClay)       return true;
		if(block == ShopKeeper.roofCobblestoneMossyCopper)     return true;
		if(block == ShopKeeper.roofCobblestoneMossyTin)        return true;
		if(block == ShopKeeper.roofCobblestoneMossyBrass)      return true;
		if(block == ShopKeeper.roofCobblestoneMossyGold)       return true;
		if(block == ShopKeeper.roofCobblestoneMossyMythril)    return true;
		if(block == ShopKeeper.roofCobblestoneMossyOrichalcum) return true;
		if(block == ShopKeeper.roofCobblestoneMossyNether)     return true;
		
		if(block == ShopKeeper.roofStonebrickStraw)      return true;
		if(block == ShopKeeper.roofStonebrickReeds)      return true;
		if(block == ShopKeeper.roofStonebrickClay)       return true;
		if(block == ShopKeeper.roofStonebrickCopper)     return true;
		if(block == ShopKeeper.roofStonebrickTin)        return true;
		if(block == ShopKeeper.roofStonebrickBrass)      return true;
		if(block == ShopKeeper.roofStonebrickGold)       return true;
		if(block == ShopKeeper.roofStonebrickMythril)    return true;
		if(block == ShopKeeper.roofStonebrickOrichalcum) return true;
		if(block == ShopKeeper.roofStonebrickNether)     return true;
		
		if(block == ShopKeeper.roofStonebrickMossyStraw)      return true;
		if(block == ShopKeeper.roofStonebrickMossyReeds)      return true;
		if(block == ShopKeeper.roofStonebrickMossyClay)       return true;
		if(block == ShopKeeper.roofStonebrickMossyCopper)     return true;
		if(block == ShopKeeper.roofStonebrickMossyTin)        return true;
		if(block == ShopKeeper.roofStonebrickMossyBrass)      return true;
		if(block == ShopKeeper.roofStonebrickMossyGold)       return true;
		if(block == ShopKeeper.roofStonebrickMossyMythril)    return true;
		if(block == ShopKeeper.roofStonebrickMossyOrichalcum) return true;
		if(block == ShopKeeper.roofStonebrickMossyNether)     return true;
		
		if(block == ShopKeeper.roofSandstoneStraw)      return true;
		if(block == ShopKeeper.roofSandstoneReeds)      return true;
		if(block == ShopKeeper.roofSandstoneClay)       return true;
		if(block == ShopKeeper.roofSandstoneCopper)     return true;
		if(block == ShopKeeper.roofSandstoneTin)        return true;
		if(block == ShopKeeper.roofSandstoneBrass)      return true;
		if(block == ShopKeeper.roofSandstoneGold)       return true;
		if(block == ShopKeeper.roofSandstoneMythril)    return true;
		if(block == ShopKeeper.roofSandstoneOrichalcum) return true;
		if(block == ShopKeeper.roofSandstoneNether)     return true;
		
		if(block == ShopKeeper.roofNetherStraw)      return true;
		if(block == ShopKeeper.roofNetherReeds)      return true;
		if(block == ShopKeeper.roofNetherClay)       return true;
		if(block == ShopKeeper.roofNetherCopper)     return true;
		if(block == ShopKeeper.roofNetherTin)        return true;
		if(block == ShopKeeper.roofNetherBrass)      return true;
		if(block == ShopKeeper.roofNetherGold)       return true;
		if(block == ShopKeeper.roofNetherMythril)    return true;
		if(block == ShopKeeper.roofNetherOrichalcum) return true;
		if(block == ShopKeeper.roofNetherNether)     return true;
		
		if(block == ShopKeeper.roofQuartzStraw)      return true;
		if(block == ShopKeeper.roofQuartzReeds)      return true;
		if(block == ShopKeeper.roofQuartzClay)       return true;
		if(block == ShopKeeper.roofQuartzCopper)     return true;
		if(block == ShopKeeper.roofQuartzTin)        return true;
		if(block == ShopKeeper.roofQuartzBrass)      return true;
		if(block == ShopKeeper.roofQuartzGold)       return true;
		if(block == ShopKeeper.roofQuartzMythril)    return true;
		if(block == ShopKeeper.roofQuartzOrichalcum) return true;
		if(block == ShopKeeper.roofQuartzNether)     return true;
		
		return false;
	}

}