package net.acecraft.mod.block.blocks;

import java.util.Random;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class AceSeeds extends Item implements IPlantable {
	
	private Block blockCropID;
    private Block blockSoilID;
    private static final String __OBFID = "CL_00000061";

    public AceSeeds(Block crop, Block soil){
        this.blockCropID = crop;
        this.blockSoilID = soil;
        this.setCreativeTab(ShopKeeper.acetabCommon);
    }
    
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int intX, int intY, int intZ, int meta, float floatX, float floatY, float floatZ){
        if (meta != 1){
            return false;
        }else if (player.canPlayerEdit(intX, intY, intZ, meta, stack) && player.canPlayerEdit(intX, intY + 1, intZ, meta, stack)){
            if (world.getBlock(intX, intY, intZ).canSustainPlant(world, intX, intY, intZ, ForgeDirection.UP, this) && world.isAirBlock(intX, intY + 1, intZ)){
                world.setBlock(intX, intY + 1, intZ, getPlantBlock());
                --stack.stackSize;
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z){
        return getPlantBlock() == Blocks.nether_wart ? EnumPlantType.Nether : EnumPlantType.Crop;
    }
    
    @Override
    public Block getPlant(IBlockAccess world, int x, int y, int z){
        if(blockCropID == Blocks.dirt){
        	Random random = new Random();
        	int i = random.nextInt(16);
        	if(i ==  0) return Blocks.wheat;
        	if(i ==  1) return Blocks.potatoes;
        	if(i ==  2) return Blocks.carrots;
        	if(i ==  3) return ShopKeeper.cropTurnip;
        	if(i ==  4) return ShopKeeper.cropGrapes;
        	if(i ==  5) return ShopKeeper.cropOnion;
        	if(i ==  6) return ShopKeeper.cropPineapple;
        	if(i ==  7) return ShopKeeper.cropTomato;
        	if(i ==  8) return ShopKeeper.cropCabbage;
        	if(i ==  9) return ShopKeeper.cropRice;
        	if(i == 10) return ShopKeeper.cropMaise;
        	if(i == 11) return ShopKeeper.cropCoffeeBeans;
        	if(i == 12) return ShopKeeper.cropPeas;
        	if(i == 13) return ShopKeeper.cropPickles;
        	if(i == 14) return ShopKeeper.cropHemp;
        	if(i == 15) return ShopKeeper.cropCotton;
        }
    	return blockCropID;
    }
    
    public Block getPlantBlock(){
    	if(blockCropID == Blocks.dirt){
        	Random random = new Random();
        	int i = random.nextInt(16);
        	if(i ==  0) return Blocks.wheat;
        	if(i ==  1) return Blocks.potatoes;
        	if(i ==  2) return Blocks.carrots;
        	if(i ==  3) return ShopKeeper.cropTurnip;
        	if(i ==  4) return ShopKeeper.cropGrapes;
        	if(i ==  5) return ShopKeeper.cropOnion;
        	if(i ==  6) return ShopKeeper.cropPineapple;
        	if(i ==  7) return ShopKeeper.cropTomato;
        	if(i ==  8) return ShopKeeper.cropCabbage;
        	if(i ==  9) return ShopKeeper.cropRice;
        	if(i == 10) return ShopKeeper.cropMaise;
        	if(i == 11) return ShopKeeper.cropCoffeeBeans;
        	if(i == 12) return ShopKeeper.cropPeas;
        	if(i == 13) return ShopKeeper.cropPickles;
        	if(i == 14) return ShopKeeper.cropHemp;
        	if(i == 15) return ShopKeeper.cropCotton;
        }
    	return blockCropID;
    }
    
    @Override
    public int getPlantMetadata(IBlockAccess world, int x, int y, int z){
        return 0;
    }
	
    @SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister){
		this.itemIcon = iconRegister.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5));
	}

}