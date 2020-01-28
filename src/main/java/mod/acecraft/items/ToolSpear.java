package mod.acecraft.items;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;

public class ToolSpear extends SwordItem {

    public ToolSpear(String modid, String name, IItemTier tier, int attackDamageIn, float attackSpeedIn) {
        super(tier, attackDamageIn, attackSpeedIn, new Properties().group(ItemGroup.COMBAT));
        this.setRegistryName(modid, name);
    }

}

//public class ToolsSpear extends ItemSword {
//
//    public ToolsSpear(String name, ToolMaterial material) {
//        super(material);
//        this.setUnlocalizedName(name);
//        this.setRegistryName(name);
//        this.maxStackSize = 1;
//        this.setMaxDamage(384);
//        this.setCreativeTab(CreativeTabs.COMBAT);
//        this.addPropertyOverride(new ResourceLocation("pull"), new IItemPropertyGetter(){
//            @SideOnly(Side.CLIENT)
//            public float apply(ItemStack stack, World worldIn, EntityLivingBase entityIn){
//                if (entityIn == null){
//                    return 0.0F;
//                } else {
//                    ItemStack itemstack = entityIn.getActiveItemStack();
//                    return itemstack != null && itemstack.getItem() == Items.BOW ? (float)(stack.getMaxItemUseDuration() - entityIn.getItemInUseCount()) / 20.0F : 0.0F;
//                }
//            }
//        });
//        this.addPropertyOverride(new ResourceLocation("pulling"), new IItemPropertyGetter(){
//            @SideOnly(Side.CLIENT)
//            public float apply(ItemStack stack, World worldIn, EntityLivingBase entityIn){
//                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
//            }
//        });
//    }
//
//    private ItemStack func_185060_a(EntityPlayer player){
//        if (this.func_185058_h_(player.getHeldItem(EnumHand.OFF_HAND))){
//            return player.getHeldItem(EnumHand.OFF_HAND);
//        } else if (this.func_185058_h_(player.getHeldItem(EnumHand.MAIN_HAND))){
//            return player.getHeldItem(EnumHand.MAIN_HAND);
//        } else {
//            for (int i = 0; i < player.inventory.getSizeInventory(); ++i){
//                ItemStack itemstack = player.inventory.getStackInSlot(i);
//                if (this.func_185058_h_(itemstack)){
//                    return itemstack;
//                }
//            }
//            return null;
//        }
//    }
//
//    protected boolean func_185058_h_(ItemStack stack){
//        return stack != null && stack.getItem() instanceof ToolsSpear;
//    }
//
//    /**
//     * Called when the player stops using an Item (stops holding the right mouse button).
//     */
//    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft){
//        if (entityLiving instanceof EntityPlayer){
//            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
//            float f = func_185059_b(10);
//            if ((double)f >= 0.1D){
//                if (!worldIn.isRemote){
//                    EntitySpear spear = new EntitySpear(worldIn, entityplayer);
//                    spear.shoot(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, f * 3.0F, 1.0F);
//                    if (f == 1.0F){
//                        spear.setIsCritical(true);
//                    }
//                    int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);
//                    if (j > 0){
//                        spear.setDamage(spear.getDamage() + (double)j * 0.5D + 0.5D);
//                    }
//                    int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);
//                    if (k > 0){
//                        spear.setKnockbackStrength(k);
//                    }
//                    if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0){
//                        spear.setFire(100);
//                    }
//                    stack.damageItem(10, entityplayer);
//                    spear.pickupStatus = EntitySpear.PickupStatus.ALLOWED;
//                    worldIn.spawnEntity(spear);
//                }
//                worldIn.playSound(null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.NEUTRAL, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
//                entityplayer.setItemStackToSlot(getSlot(entityplayer), null);
//                entityplayer.addStat(StatList.getObjectUseStats(this));
//            }
//        }
//    }
//
//    public EntityEquipmentSlot getSlot(EntityPlayer player){
//        if(player.getHeldItem(EnumHand.MAIN_HAND).getItem() == this){
//            return EntityEquipmentSlot.MAINHAND;
//        }
//        if(player.getHeldItem(EnumHand.OFF_HAND).getItem() == this){
//            return EntityEquipmentSlot.OFFHAND;
//        }
//        return EntityEquipmentSlot.MAINHAND;
//    }
//
//    public static float func_185059_b(int p_185059_0_){
//        float f = (float)p_185059_0_ / 20.0F;
//        f = (f * f + f * 2.0F) / 3.0F;
//        if (f > 1.0F){
//            f = 1.0F;
//        }
//        return f;
//    }
//
//    /**
//     * How long it takes to use or consume an item
//     */
//    public int getMaxItemUseDuration(ItemStack stack){
//        return 72000;
//    }
//
//    /**
//     * returns the action that specifies what animation to play when the items is being used
//     */
//    public EnumAction getItemUseAction(ItemStack stack){
//        return EnumAction.BOW;
//    }
//
//    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand){
//        boolean flag = this.func_185060_a(playerIn) != null;
//        ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemStackIn, worldIn, playerIn, hand, true);
//        if (ret != null) return ret;
//        if (!playerIn.capabilities.isCreativeMode && !flag){
//            return !flag ? new ActionResult(EnumActionResult.FAIL, itemStackIn) : new ActionResult(EnumActionResult.PASS, itemStackIn);
//        } else {
//            playerIn.setActiveHand(hand);
//            return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
//        }
//    }
//
//    /**
//     * Return the enchantability factor of the item, most of the time is based on material.
//     */
//    public int getItemEnchantability(){
//        return 1;
//    }
//
//}