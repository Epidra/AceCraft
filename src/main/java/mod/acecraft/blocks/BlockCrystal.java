package mod.acecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCrystal extends Block {
	
	public BlockCrystal(String name) {
		super(Material.ROCK);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		this.setHardness(2.50f);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.STONE);
		this.setLightOpacity(16);
		this.setLightLevel(0);
		this.setHarvestLevel("pickaxe", 1);
		this.setTickRandomly(false);
	}
	
	//public Item getItemDropped(IBlockState state, Random rand, int fortune){
	//	return ShopKeeper.STUFF_CRYSTAL;
	//}
	
    //public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune){
    //    List<ItemStack> ret = new java.util.ArrayList<ItemStack>();
    //    ret.add(new ItemStack(ShopKeeper.STUFF_CRYSTAL));
    //    for(int i = 0; i < fortune; i++){
    //    	ret.add(new ItemStack(ShopKeeper.STUFF_CRYSTAL));
    //    }
    //    return ret;
    //}
    
    public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player){
        return true;
    }
	
}
