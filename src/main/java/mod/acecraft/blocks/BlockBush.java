package mod.acecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BushBlock;

public class BlockBush extends BushBlock {

    /** Contructor with predefined BlockProperty */
    public BlockBush(Block block) {
        super(Properties.from(block));
    }

}
