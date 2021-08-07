package mod.acecraft.item;

import mod.acecraft.entity.EntityNugget;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SnowballItem;
import net.minecraft.world.level.Level;

import static net.minecraft.sounds.SoundSource.NEUTRAL;

public class ItemNugget extends Item {

    // ...




    //----------------------------------------CONSTRUCTOR----------------------------------------//

    /** Default Constructor */
    public ItemNugget() {
        super(new Properties().tab(CreativeModeTab.TAB_MATERIALS));
    }




    //----------------------------------------INTERACTION----------------------------------------//

    //public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
    //    ItemStack itemstack = player.getItemInHand(hand);
    //    level.playSound((Player) null, player.getX(), player.getY(), player.getZ(), SoundEvents.SNOWBALL_THROW, NEUTRAL, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));
    //    if (!level.isClientSide) {
    //        EntityNugget snowballentity = new EntityNugget(level, player, itemstack);
    //        snowballentity.setItem(itemstack);
    //        snowballentity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
    //        level.addFreshEntity(snowballentity);
    //    }
    //    player.awardStat(Stats.ITEM_USED.get(this));
    //    if (!player.getAbilities().instabuild) {
    //        itemstack.shrink(1);
    //    }
    //    return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    //}

}