package net.acecraft.mod.items;

import java.util.Random;

import net.acecraft.mod.ShopKeeper;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class ItemSeedWild extends Item implements IPlantable{
	
	private Block crops;
    /** BlockID of the block the seeds can be planted on. */
    private Block soilBlockID;
	
	public ItemSeedWild(String name) {
		this.crops = Blocks.wheat;
		this.soilBlockID = Blocks.farmland;
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}
	
    /**
     * Called when a Block is right-clicked with this Item
     */
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        net.minecraft.block.state.IBlockState state = worldIn.getBlockState(pos);
        if (facing == EnumFacing.UP && playerIn.canPlayerEdit(pos.offset(facing), facing, stack) && state.getBlock().canSustainPlant(state, worldIn, pos, EnumFacing.UP, this) && worldIn.isAirBlock(pos.up())){
            worldIn.setBlockState(pos.up(), getCrop());
            --stack.stackSize;
            return EnumActionResult.SUCCESS;
        } else {
            return EnumActionResult.FAIL;
        }
    }
    
    @Override
    public net.minecraftforge.common.EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos){
        return EnumPlantType.Crop;
    }
	
	@Override
    public net.minecraft.block.state.IBlockState getPlant(net.minecraft.world.IBlockAccess world, BlockPos pos){
		return getCrop();
    }
	
	private IBlockState getCrop(){
		Random rand = new Random();
		switch(rand.nextInt(16)){
			case  0: return Blocks.wheat              .getDefaultState();
			case  1: return Blocks.potatoes           .getDefaultState();
			case  2: return Blocks.carrots            .getDefaultState();
			case  3: return Blocks.beetroots          .getDefaultState();
			case  4: return ShopKeeper.cropTurnip     .getDefaultState();
			case  5: return ShopKeeper.cropGrapes     .getDefaultState();
			case  6: return ShopKeeper.cropOnion      .getDefaultState();
			case  7: return ShopKeeper.cropPineapple  .getDefaultState();
			case  8: return ShopKeeper.cropTomato     .getDefaultState();
			case  9: return ShopKeeper.cropCabbage    .getDefaultState();
			case 10: return ShopKeeper.cropRice       .getDefaultState();
			case 11: return ShopKeeper.cropMaise      .getDefaultState();
			case 12: return ShopKeeper.cropCoffeeBeans.getDefaultState();
			case 13: return ShopKeeper.cropCucumber   .getDefaultState();
			case 14: return ShopKeeper.cropHemp       .getDefaultState();
			case 15: return ShopKeeper.cropCotton     .getDefaultState();
		}
        return Blocks.wheat.getDefaultState();
	}
	
}
