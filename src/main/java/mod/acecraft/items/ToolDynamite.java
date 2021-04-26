package mod.acecraft.items;

import mod.acecraft.entity.EntityDynamite;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class ToolDynamite extends Item {

    // ...




    //----------------------------------------CONSTRUCTOR----------------------------------------//

    /** Default Constructor */
    public ToolDynamite(){
        super(new Properties().tab(ItemGroup.TAB_TOOLS));
    }




    //----------------------------------------INTERACTION----------------------------------------//

    public ActionResult<ItemStack> use(World p_77659_1_, PlayerEntity p_77659_2_, Hand p_77659_3_) {
        ItemStack itemstack = p_77659_2_.getItemInHand(p_77659_3_);
        p_77659_1_.playSound((PlayerEntity)null, p_77659_2_.getX(), p_77659_2_.getY(), p_77659_2_.getZ(), SoundEvents.SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
        if (!p_77659_1_.isClientSide) {
            EntityDynamite snowballentity = new EntityDynamite(p_77659_1_, p_77659_2_);
            snowballentity.setItem(itemstack);
            snowballentity.shootFromRotation(p_77659_2_, p_77659_2_.xRot, p_77659_2_.yRot, 0.0F, 1.5F, 1.0F);
            p_77659_1_.addFreshEntity(snowballentity);
        }
        p_77659_2_.awardStat(Stats.ITEM_USED.get(this));
        if (!p_77659_2_.abilities.instabuild) {
            itemstack.shrink(1);
        }
        return ActionResult.sidedSuccess(itemstack, p_77659_1_.isClientSide());
    }

}