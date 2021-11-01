package mod.acecraft.entity;

import mod.acecraft.ShopKeeper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.FMLPlayMessages;

public class EntitySpear extends AbstractArrowEntity {

    // ...





    //----------------------------------------CONSTRUCTOR----------------------------------------//

    public EntitySpear(EntityType<? extends EntitySpear> type, World worldIn) {
        super(type, worldIn);
    }

    public EntitySpear(FMLPlayMessages.SpawnEntity packet, World worldIn){
        super(ShopKeeper.ENTITY_SPEAR.get(), worldIn);
        PacketBuffer buf = packet.getAdditionalData();
    }

    public EntitySpear(World worldIn, double x, double y, double z) {
        super(EntityType.ARROW, x, y, z, worldIn);
    }

    public EntitySpear(World worldIn, LivingEntity shooter) {
        super(EntityType.ARROW, shooter, worldIn);
    }





    //----------------------------------------SUPPORT----------------------------------------//

    @Override
    protected ItemStack getPickupItem() {
        return null;
    }



}
