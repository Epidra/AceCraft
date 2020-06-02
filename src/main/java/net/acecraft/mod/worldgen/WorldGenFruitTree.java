package net.acecraft.mod.worldgen;

import java.util.Random;

import net.minecraft.block.BlockCocoa;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockVine;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class WorldGenFruitTree extends WorldGenAbstractTree{
    /** The minimum height of a generated tree. */
    private final int minTreeHeight;
    /** True if this tree should grow Vines. */
    private final boolean vinesGrow;
    /** The metadata value of the wood to use in tree generation. */
    private final IBlockState metaWood;
    /** The metadata value of the leaves to use in tree generation. */
    private final IBlockState metaLeaves;

    public WorldGenFruitTree(IBlockState _blockLog, IBlockState _blockLeaf){
        this(true, 4, _blockLog, _blockLeaf, false);
    }
    
    public WorldGenFruitTree(boolean superflag, int _mintreeheight, IBlockState _metawood, IBlockState _metaleaves, boolean _vinesgrow){
        super(superflag);
        this.minTreeHeight = _mintreeheight;
        this.metaWood      = _metawood;
        this.metaLeaves    = _metaleaves;
        this.vinesGrow     = _vinesgrow;
    }
    
    public boolean generate(World world, Random rand, BlockPos pos){
        int height = rand.nextInt(3) + this.minTreeHeight;
        
        world.setBlockState(new BlockPos(pos), metaWood);
        
        for(int i = 0; i < height; i++){
        	if(world.getBlockState(pos.up(i)).getBlock() == Blocks.AIR){
        		world.setBlockState(new BlockPos(pos.up(i)), metaWood);
        	}
        }
        
        int leafSize = height / 3;
        int leafHeight = height - leafSize;
        
        
        for(int i = 1; i <= leafSize+1; i++){
        	if(world.getBlockState(pos.up(i+leafHeight-2)).getBlock() == metaWood.getBlock()){
        		int size = 2;
        		if(i == leafSize+1) size = 1;
        		for(int x = -size; x <= size; x++){
        			for(int z = -size; z <= size; z++){
        				if(world.getBlockState(new BlockPos(pos.getX() + x, pos.getY() + leafHeight + i-2, pos.getZ() + z)).getBlock() == Blocks.AIR){
        					world.setBlockState(new BlockPos(pos.getX() + x, pos.getY() + leafHeight + i-2, pos.getZ() + z), metaLeaves);
        					
        					/*if (this.vinesGrow){
                                for (int k3 = position.getY() - 3 + i; k3 <= position.getY() + i; ++k3){
                                    int j4 = k3 - (position.getY() + i);
                                    int k4 = 2 - j4 / 2;
                                    BlockPos.MutableBlockPos blockpos$mutableblockpos1 = new BlockPos.MutableBlockPos();
                                    for (int l4 = position.getX() - k4; l4 <= position.getX() + k4; ++l4){
                                        for (int i5 = position.getZ() - k4; i5 <= position.getZ() + k4; ++i5){
                                            blockpos$mutableblockpos1.setPos(l4, k3, i5);
                                            state = worldIn.getBlockState(blockpos$mutableblockpos1);
                                            if (state.getBlock().isLeaves(state, worldIn, blockpos$mutableblockpos1)){
                                                BlockPos blockpos2 = blockpos$mutableblockpos1.west();
                                                BlockPos blockpos3 = blockpos$mutableblockpos1.east();
                                                BlockPos blockpos4 = blockpos$mutableblockpos1.north();
                                                BlockPos blockpos1 = blockpos$mutableblockpos1.south();
                                                if (rand.nextInt(4) == 0 && worldIn.isAirBlock(blockpos2)){
                                                    this.addHangingVine(worldIn, blockpos2, BlockVine.EAST);
                                                }
                                                if (rand.nextInt(4) == 0 && worldIn.isAirBlock(blockpos3)){
                                                    this.addHangingVine(worldIn, blockpos3, BlockVine.WEST);
                                                }
                                                if (rand.nextInt(4) == 0 && worldIn.isAirBlock(blockpos4)){
                                                    this.addHangingVine(worldIn, blockpos4, BlockVine.SOUTH);
                                                }
                                                if (rand.nextInt(4) == 0 && worldIn.isAirBlock(blockpos1)){
                                                    this.addHangingVine(worldIn, blockpos1, BlockVine.NORTH);
                                                }
                                            }
                                        }
                                    }
                                }
                            }*/
        					
        				}
        			}
        		}
        	}
        }
        return true;
    }

    private void addVine(World worldIn, BlockPos pos, PropertyBool prop){
        this.setBlockAndNotifyAdequately(worldIn, pos, Blocks.VINE.getDefaultState().withProperty(prop, Boolean.valueOf(true)));
    }
    
    private void addHangingVine(World worldIn, BlockPos pos, PropertyBool prop){
        this.addVine(worldIn, pos, prop);
        int i = 4;
        for (pos = pos.down(); worldIn.isAirBlock(pos) && i > 0; --i){
            this.addVine(worldIn, pos, prop);
            pos = pos.down();
        }
    }
}