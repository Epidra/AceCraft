package net.acecraft.mod.blocks;

import java.util.List;
import java.util.Random;

import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.worldgen.WorldGenFruitTree;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenBirchTree;
import net.minecraft.world.gen.feature.WorldGenCanopyTree;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.world.gen.feature.WorldGenMegaPineTree;
import net.minecraft.world.gen.feature.WorldGenSavannaTree;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFruitSapling extends BlockBush implements IGrowable{
    public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
    protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);
    
    int id;
    
    public BlockFruitSapling(String name, int _id){
    	this.setUnlocalizedName(name);
		this.setRegistryName(name);
		id = _id;
        this.setDefaultState(this.blockState.getBaseState().withProperty(STAGE, Integer.valueOf(0)));
        this.setCreativeTab(CreativeTabs.DECORATIONS);
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        return SAPLING_AABB;
    }
    
    /**
     * Gets the localized name of this block. Used for the statistics page.
     */
    public String getLocalizedName(){
        return I18n.translateToLocal(this.getUnlocalizedName() + "." + BlockPlanks.EnumType.OAK.getUnlocalizedName() + ".name");
    }
    
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand){
        if (!worldIn.isRemote){
            super.updateTick(worldIn, pos, state, rand);
            if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0){
                this.grow(worldIn, pos, state, rand);
            }
        }
    }
    
    public void grow(World worldIn, BlockPos pos, IBlockState state, Random rand){
        if (((Integer)state.getValue(STAGE)).intValue() == 0){
            worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
        } else {
            this.generateTree(worldIn, pos, state, rand);
        }
    }
    
    public void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand){
        if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(worldIn, rand, pos)) return;
        IBlockState blockLog = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK);
        IBlockState blockLeaf = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.OAK).withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false));
        switch(id){
        case 0: blockLeaf = ShopKeeper.fruitApple   .getDefaultState().withProperty(BlockFruitLeaf.AGE, Integer.valueOf(0)); blockLog = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK);    break;
        case 1: blockLeaf = ShopKeeper.fruitLemon   .getDefaultState().withProperty(BlockFruitLeaf.AGE, Integer.valueOf(0)); blockLog = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE); break;
        case 2: blockLeaf = ShopKeeper.fruitPeach   .getDefaultState().withProperty(BlockFruitLeaf.AGE, Integer.valueOf(0)); blockLog = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK);    break;
        case 3: blockLeaf = ShopKeeper.fruitOrange  .getDefaultState().withProperty(BlockFruitLeaf.AGE, Integer.valueOf(0)); blockLog = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE); break;
        case 4: blockLeaf = ShopKeeper.fruitCherries.getDefaultState().withProperty(BlockFruitLeaf.AGE, Integer.valueOf(0)); blockLog = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.BIRCH);  break;
        case 5: blockLeaf = ShopKeeper.fruitBanana  .getDefaultState().withProperty(BlockFruitLeaf.AGE, Integer.valueOf(0)); blockLog = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE); break;
        }
        WorldGenerator worldgenerator = (WorldGenerator)(new WorldGenFruitTree(true, 5, blockLog, blockLeaf, true));
        worldgenerator.generate(worldIn, rand, pos);
    }

    /**
     * Whether this IGrowable can grow
     */
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient){
        return true;
    }
    
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state){
        return (double)worldIn.rand.nextFloat() < 0.45D;
    }
    
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state){
        this.grow(worldIn, pos, state, rand);
    }
    
    protected PropertyInteger getAgeProperty(){
        return STAGE;
    }
    
    protected int getAge(IBlockState state){
        return ((Integer)state.getValue(this.getAgeProperty())).intValue();
    }
    
    public IBlockState withAge(int age){
        return this.getDefaultState().withProperty(this.getAgeProperty(), Integer.valueOf(age));
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
        return new BlockStateContainer(this, new IProperty[] {STAGE});
    }
}