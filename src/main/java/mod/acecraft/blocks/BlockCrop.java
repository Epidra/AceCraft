package mod.acecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.CropsBlock;
import net.minecraft.item.Item;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockCrop extends CropsBlock {

    Item seeds;
    int maxAge;

    /** Contructor with predefined BlockProperty */
    public BlockCrop(String modid, String name, int age, Block block) {
        super(Properties.from(block));
        this.setRegistryName(modid, name);
        maxAge = age;
    }

    public void setSeeds(Item seed){
        seeds = seed;
    }

    public int getMaxAge() {
        return maxAge;
    }

    @OnlyIn(Dist.CLIENT)
    protected IItemProvider getSeedsItem() {
        return seeds;
    }

}
