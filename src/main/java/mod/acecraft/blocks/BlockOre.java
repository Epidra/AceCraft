package mod.acecraft.blocks;

import mod.lucky77.blocks.BlockBase;
import mod.lucky77.tileentities.TileBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class BlockOre extends BlockBase {

    //...




    //----------------------------------------CONSTRUCTOR----------------------------------------//

    /** Contructor with predefined BlockProperty */
    public BlockOre(Block block) {
        super(block);
    }




    //----------------------------------------PLACEMENT----------------------------------------//

    // ...




    //----------------------------------------INTERACTION----------------------------------------//

    @Override
    public void interact(World world, BlockPos blockPos, PlayerEntity playerEntity, TileBase tileBase) {

    }




    //----------------------------------------SUPPORT----------------------------------------//

    // ...




    //----------------------------------------HELPER----------------------------------------//

    @Override
    public int getExpDrop(BlockState state, net.minecraft.world.IWorldReader reader, BlockPos pos, int fortune, int silktouch) {
        return silktouch == 0 ? MathHelper.nextInt(RANDOM, 0, 2) : 0;
    }

}
