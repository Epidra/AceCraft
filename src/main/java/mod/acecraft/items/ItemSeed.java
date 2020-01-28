package mod.acecraft.items;

import mod.acecraft.blocks.BlockCrop;
import net.minecraft.block.Block;
import net.minecraft.item.BlockNamedItem;

public class ItemSeed extends BlockNamedItem {

    public ItemSeed(String modid, String name, Block blockIn, Properties properties) {
        super(blockIn, properties);
        this.setRegistryName(modid, name);
        BlockCrop crop = (BlockCrop) blockIn;
        crop.setSeeds(this);
    }

}
