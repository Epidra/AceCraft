package mod.acecraft.items;

import mod.acecraft.blocks.BlockCrop;
import net.minecraft.block.Block;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.ItemGroup;

public class ItemSeed extends BlockNamedItem {

    public ItemSeed(Block blockIn) {
        super(blockIn, new Properties().group(ItemGroup.MATERIALS));
        BlockCrop crop = (BlockCrop) blockIn;
        crop.setSeeds(this);
    }

}
