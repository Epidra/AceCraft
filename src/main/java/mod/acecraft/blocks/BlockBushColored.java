package mod.acecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BushBlock;

public class BlockBushColored extends BushBlock {

    /** Contructor with predefined BlockProperty */
    public BlockBushColored(String modid, String name, Block block) {
        super(Properties.from(block));
        this.setRegistryName(modid, name);
    }

}
