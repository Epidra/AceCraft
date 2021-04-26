package mod.acecraft.blocks;

import mod.acecraft.ShopKeeper;
import net.minecraft.block.Block;
import net.minecraft.block.CropsBlock;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockCrop extends CropsBlock {

    private final String id;




    //----------------------------------------CONSTRUCTOR----------------------------------------//

    /** Contructor with predefined BlockProperty */
    public BlockCrop(String id, Block block) {
        super(Properties.copy(block));
        this.id = id;
    }




    //----------------------------------------PLACEMENT----------------------------------------//

    // ...




    //----------------------------------------INTERACTION----------------------------------------//

    // ...




    //----------------------------------------SUPPORT----------------------------------------//

    @OnlyIn(Dist.CLIENT)
    protected IItemProvider getBaseSeedId() {
        if(id.matches("cabbage"   )) return ShopKeeper.SEED_CABBAGE.get();
        if(id.matches("corn"      )) return ShopKeeper.SEED_CORN.get();
        if(id.matches("cucumber"  )) return ShopKeeper.SEED_CUCUMBER.get();
        if(id.matches("eggplant"  )) return ShopKeeper.SEED_EGGPLANT.get();
        if(id.matches("grapes"    )) return ShopKeeper.SEED_GRAPES.get();
        if(id.matches("onion"     )) return ShopKeeper.SEED_ONION.get();
        if(id.matches("pineapple" )) return ShopKeeper.SEED_PINEAPPLE.get();
        if(id.matches("strawberry")) return ShopKeeper.SEED_STRAWBERRY.get();
        if(id.matches("tomato"    )) return ShopKeeper.SEED_TOMATO.get();
        if(id.matches("turnip"    )) return ShopKeeper.SEED_TURNIP.get();
        if(id.matches("rice"      )) return ShopKeeper.SEED_RICE.get();
        if(id.matches("coffee"    )) return ShopKeeper.SEED_COFFEE.get();
        if(id.matches("hemp"      )) return ShopKeeper.SEED_HEMP.get();
        return ShopKeeper.SEED_CABBAGE.get();
    }

}
