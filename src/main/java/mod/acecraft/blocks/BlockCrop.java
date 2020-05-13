package mod.acecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.CropsBlock;
import net.minecraft.item.Item;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockCrop extends CropsBlock {

    Item seeds;

    /** Contructor with predefined BlockProperty */
    public BlockCrop(Block block) {
        super(Properties.from(block));
    }

    public void setSeeds(Item seed){
        seeds = seed;
    }

    @OnlyIn(Dist.CLIENT)
    protected IItemProvider getSeedsItem() {
        return seeds;
    }

}
