package mod.acecraft.block;

import mod.lucky77.block.BlockBase;
import mod.lucky77.blockentity.BlockEntityBase;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class BlockOre extends BlockBase {

    //...





    //----------------------------------------CONSTRUCTOR----------------------------------------//

    /** Contructor with predefined BlockProperty */
    public BlockOre(Block block) {
        //super(block);
        super(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F));
    }





    //----------------------------------------PLACEMENT----------------------------------------//

    // ...





    //----------------------------------------INTERACTION----------------------------------------//

    @Override
    public void interact(Level world, BlockPos pos, Player player, BlockEntityBase tile) {

    }





    //----------------------------------------SUPPORT----------------------------------------//

    // ...





    //----------------------------------------HELPER----------------------------------------//

    //@Override
    //public int getExpDrop(BlockState state, net.minecraft.world.level.LevelReader reader, BlockPos pos, int fortune, int silktouch) {
    //    return silktouch == 0 ? RANDOM.nextInt(2)+1 : 0;
    //}



}
