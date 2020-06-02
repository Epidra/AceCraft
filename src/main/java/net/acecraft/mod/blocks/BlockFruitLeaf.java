package net.acecraft.mod.blocks;

import java.util.List;
import java.util.Random;
import javax.annotation.Nullable;

import net.acecraft.mod.ShopKeeper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFruitLeaf extends BlockLeaves implements IGrowable{
    public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 3);
    
    Item  fruit;
    Block sapling;
    
    public BlockFruitLeaf(String name, Item _fruit, Block _sapling){
    	this.setUnlocalizedName(name);
		this.setRegistryName(name);
		fruit = _fruit;
		sapling = _sapling;
        this.setDefaultState(this.blockState.getBaseState().withProperty(this.getAgeProperty(), Integer.valueOf(0)));
        this.setTickRandomly(true);
        this.setCreativeTab(null);
        this.setHardness(0.0F);
        this.setSoundType(SoundType.PLANT);
        this.disableStats();
    }
    
    public boolean isOpaqueCube(IBlockState state){
        return false;
    }
    
    protected PropertyInteger getAgeProperty(){
        return AGE;
    }
    
    public int getMaxAge(){
        return 3;
    }
    
    protected int getAge(IBlockState state){
        return ((Integer)state.getValue(this.getAgeProperty())).intValue();
    }
    
    public IBlockState withAge(int age){
        return this.getDefaultState().withProperty(this.getAgeProperty(), Integer.valueOf(age));
    }
    
    public boolean isMaxAge(IBlockState state){
        return ((Integer)state.getValue(this.getAgeProperty())).intValue() >= this.getMaxAge();
    }
    
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand){
        //super.updateTick(worldIn, pos, state, rand);
        if (worldIn.getLightFromNeighbors(pos.up()) >= 9){
            int i = this.getAge(state);
            if (i < this.getMaxAge()){
                if (rand.nextInt(35) == 0){
                    worldIn.setBlockState(pos, this.withAge(i + 1), 2);
                }
            }
        }
    }
    
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
		if(world.isRemote){
			return true;
		} else if(!player.isSneaking()){
			if(isMaxAge(state)){
				if(player.inventory.addItemStackToInventory(new ItemStack(fruit))){
					world.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ()), state.getBlock().getDefaultState().withProperty(BlockFruitLeaf.AGE, Integer.valueOf(0)));
				}
			}
		}
		return true;
    }
    
    public void grow(World worldIn, BlockPos pos, IBlockState state){
        int i = this.getAge(state);
        int j = this.getMaxAge();
        if (i > j){
            i = j;
        }
        worldIn.setBlockState(pos, this.withAge(i), 2);
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    @Nullable
    public Item getItemDropped(IBlockState state, Random rand, int fortune){
        return this.isMaxAge(state) ? fruit : Item.getItemFromBlock(sapling);
    }
    
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state){
        return new ItemStack(sapling);
    }
    
    /**
     * Whether this IGrowable can grow
     */
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient){
        return !this.isMaxAge(state);
    }
    
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state){
        return false;
    }
    
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state){
        this.grow(worldIn, pos, state);
    }
    
    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta){
        return this.withAge(meta);
    }
    
    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state){
        return this.getAge(state);
    }
    
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[] {AGE});
    }
    
	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnumType getWoodType(int meta) {
		// TODO Auto-generated method stub
		return null;
	}
}