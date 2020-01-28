package mod.acecraft.blocks;

import mod.shared.blocks.BlockBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class BlockOre extends BlockBlock {

    /** Contructor with predefined BlockProperty */
    public BlockOre(String modid, String name, Block block) {
        super(modid, name, block);
    }

    /**
     * Perform side-effects from block dropping, such as creating silverfish
     */
    public void spawnAdditionalDrops(BlockState state, World worldIn, BlockPos pos, ItemStack stack) {
        super.spawnAdditionalDrops(state, worldIn, pos, stack);
    }

    @Override
    public int getExpDrop(BlockState state, net.minecraft.world.IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
        return silktouch == 0 ? MathHelper.nextInt(RANDOM, 0, 2) : 0;
    }
}
