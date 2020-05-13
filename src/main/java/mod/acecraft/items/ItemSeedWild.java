package mod.acecraft.items;

import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemSeedWild extends BlockItem {

    public ItemSeedWild() {
        super(Blocks.GRASS, new Properties().group(ItemGroup.MATERIALS));
    }

}

//public class ItemSeedWild extends Item implements IPlantable {
//
//    private Block crops;
//    /** BlockID of the block the seeds can be planted on. */
//    private Block soilBlockID;
//
//    public ItemSeedWild(String name) {
//        this.crops = Blocks.WHEAT;
//        this.soilBlockID = Blocks.FARMLAND;
//        this.setUnlocalizedName(name);
//        this.setRegistryName(name);
//        this.setCreativeTab(CreativeTabs.MATERIALS);
//    }
//
//    /**
//     * Called when a Block is right-clicked with this Item
//     */
//    public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
//        net.minecraft.block.state.IBlockState state = worldIn.getBlockState(pos);
//        if (facing == EnumFacing.UP && player.canPlayerEdit(pos.offset(facing), facing, player.getHeldItem(hand)) && state.getBlock().canSustainPlant(state, worldIn, pos, EnumFacing.UP, this) && worldIn.isAirBlock(pos.up())){
//            worldIn.setBlockState(pos.up(), getCrop());
//            player.getHeldItem(hand).shrink(1);
//            return EnumActionResult.SUCCESS;
//        } else {
//            return EnumActionResult.FAIL;
//        }
//    }
//
//    @Override
//    public net.minecraftforge.common.EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos){
//        return EnumPlantType.Crop;
//    }
//
//    @Override
//    public net.minecraft.block.state.IBlockState getPlant(net.minecraft.world.IBlockAccess world, BlockPos pos){
//        return getCrop();
//    }
//
//    private IBlockState getCrop(){
//        Random rand = new Random();
//        switch(rand.nextInt(8)){
//            case  0: return Blocks.WHEAT            .getDefaultState();
//            case  1: return Blocks.POTATOES         .getDefaultState();
//            case  2: return Blocks.CARROTS          .getDefaultState();
//            case  3: return Blocks.BEETROOTS        .getDefaultState();
//            case  4: return ShopKeeper.CROP_TURNIP  .getDefaultState();
//            //case  5: return ShopKeeper.CROP_TOMATO  .getDefaultState();
//            //case  6: return ShopKeeper.CROP_CUCUMBER.getDefaultState();
//            case  5: return ShopKeeper.CROP_RICE    .getDefaultState();
//            //case  8: return ShopKeeper.CROP_CORN    .getDefaultState();
//            //case  9: return ShopKeeper.CROP_GRAPES  .getDefaultState();
//            case  6: return ShopKeeper.CROP_COFFEE  .getDefaultState();
//            case  7: return ShopKeeper.CROP_HEMP    .getDefaultState();
//        }
//        return Blocks.WHEAT.getDefaultState();
//    }
//
//}
