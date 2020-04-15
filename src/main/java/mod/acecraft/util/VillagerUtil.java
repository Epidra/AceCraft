package mod.acecraft.util;


import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.entity.villager.IVillagerDataHolder;
import net.minecraft.entity.villager.IVillagerType;
import net.minecraft.item.*;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionBrewing;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.MapData;
import net.minecraft.world.storage.MapDecoration;

import javax.annotation.Nullable;
import java.util.*;
import java.util.stream.Collectors;


// From ExplorerCraft
// https://github.com/Zathrox/Explorercraft/blob/1.14.4/src/main/java/com/zathrox/explorercraft/core/util/ExplorerVillagerUtil.java


public class VillagerUtil {

    public static Int2ObjectMap<VillagerTrades.ITrade[]> newTradeMap(ImmutableMap<Integer, VillagerTrades.ITrade[]> map) {

        return new Int2ObjectOpenHashMap<>(map);

    }





    static class Trade implements VillagerTrades.ITrade {

        private final ItemStack firstBuyStack;

        private final ItemStack secondBuyStack;

        private final ItemStack sellingStack;

        private final int maxUses;

        private final int experience;

        private final float priceMultiplier;

        private final boolean allowFluxation;



        public Trade(ItemStack firstBuyStack, ItemStack sellingStack, int maxUses, int experience, float priceMultiplier, boolean allowFluxation) {

            this.firstBuyStack = firstBuyStack;

            this.secondBuyStack = ItemStack.EMPTY;

            this.sellingStack = sellingStack;

            this.maxUses = maxUses;

            this.experience = experience;

            this.priceMultiplier = priceMultiplier;

            this.allowFluxation = allowFluxation;

        }



        public Trade(ItemStack firstBuyStack, ItemStack secondBuyStack, ItemStack sellingStack, int maxUses, int experience, float priceMultiplier, boolean allowFluxation) {

            this.firstBuyStack = firstBuyStack;

            this.secondBuyStack = secondBuyStack;

            this.sellingStack = sellingStack;

            this.maxUses = maxUses;

            this.experience = experience;

            this.priceMultiplier = priceMultiplier;

            this.allowFluxation = allowFluxation;

        }



        @Override

        public MerchantOffer getOffer(Entity trader, Random rand) {

            //this.firstBuyStack.setCount(MathHelper.clamp(Math.max(this.firstBuyStack.getCount() - 4, 1) + rand.nextInt(8) + 1, 1, 64));

            if (!this.secondBuyStack.isEmpty() && allowFluxation) {

                this.secondBuyStack.setCount(MathHelper.clamp(Math.max(this.secondBuyStack.getCount() - 4, 1) + rand.nextInt(8) + 1, 1, 64));

            }

            return new MerchantOffer(this.firstBuyStack, this.secondBuyStack, this.sellingStack, this.maxUses, this.experience, this.priceMultiplier);

        }

    }





    public static class ItemsForGemTrade implements VillagerTrades.ITrade {

        private final ItemStack firstBuyStack;

        private final int amount;

        private final int buyingStack;

        private final int maxUses;

        private final int experience;

        private final float priceMultiplier;



        public ItemsForGemTrade(Block block, int buyingAmount, int maxUses, int experience, int priceMultiplier) {

            this(new ItemStack(block), buyingAmount, maxUses, experience, priceMultiplier);

        }



        public ItemsForGemTrade(Item item, int buyingAmount, int experience, int priceMultiplier) {

            this(new ItemStack(item), buyingAmount, experience, 12, priceMultiplier);

        }



        public ItemsForGemTrade(Item item, int buyingAmount, int maxUses, int experience, int priceMultiplier) {

            this(new ItemStack(item), buyingAmount, maxUses, experience, priceMultiplier);

        }



        public ItemsForGemTrade(ItemStack itemStack, int amount, int buyingStack, int maxUses, int experience) {

            this(itemStack, amount, buyingStack, maxUses, experience, 0.05F);

        }



        public ItemsForGemTrade(ItemStack itemStack, int amount, int buyingStack, int maxUses, int experience, float priceMultiplier) {

            this.firstBuyStack = itemStack;

            this.amount = amount;

            this.buyingStack = buyingStack;

            this.maxUses = maxUses;

            this.experience = experience;

            this.priceMultiplier = priceMultiplier;

        }



        public MerchantOffer getOffer(Entity entity, Random random) {

            int j = random.nextInt(getGems().size());

            return new MerchantOffer(new ItemStack(this.firstBuyStack.getItem(), this.amount), new ItemStack(getGems().get(j), this.buyingStack), this.maxUses, this.experience, this.priceMultiplier);

        }

    }



    public static List<Item> getGems() {

        List<Item> gemList = new ArrayList<>();

        gemList.add(Items.DIAMOND);

        gemList.add(Items.EMERALD);

        gemList.add(Items.LAPIS_LAZULI);

        return gemList;

    }



    /**

     * Builder Class for Basic Emerald Trading

     */

    public static class ItemsForEmeraldsTrade implements VillagerTrades.ITrade {

        private final ItemStack itemstack;

        private final int stackSize;

        private final int recievedSize;

        private final int maxUses;

        private final int givenExp;

        private final float priceMultiplier;



        public ItemsForEmeraldsTrade(Block block, int stackSize, int recievedSize, int maxUses, int givenExp) {

            this(new ItemStack(block), stackSize, recievedSize, maxUses, givenExp);

        }



        public ItemsForEmeraldsTrade(Item item, int stackSize, int recievedSize, int givenExp) {

            this(new ItemStack(item), stackSize, recievedSize, 12, givenExp);

        }



        public ItemsForEmeraldsTrade(Item item, int stackSize, int recievedSize, int maxUses, int givenExp) {

            this(new ItemStack(item), stackSize, recievedSize, maxUses, givenExp);

        }



        public ItemsForEmeraldsTrade(ItemStack stack, int stackSize, int recievedSize, int maxUses, int givenExp) {

            this(stack, stackSize, recievedSize, maxUses, givenExp, 0.05F);

        }



        public ItemsForEmeraldsTrade(ItemStack stack, int stackSize, int recievedSize, int maxUses, int givenExp, float priceMultiplier) {

            this.itemstack = stack;

            this.stackSize = stackSize;

            this.recievedSize = recievedSize;

            this.maxUses = maxUses;

            this.givenExp = givenExp;

            this.priceMultiplier = priceMultiplier;

        }



        public MerchantOffer getOffer(Entity p_221182_1_, Random p_221182_2_) {

            return new MerchantOffer(new ItemStack(Items.EMERALD, this.stackSize), new ItemStack(this.itemstack.getItem(), this.recievedSize), this.maxUses, this.givenExp, this.priceMultiplier);

        }

    }



    public static class EmeraldForItemsTrade implements VillagerTrades.ITrade {

        private final Item itemstack;

        private final int stackSize;

        private final int recievedSize;

        private final int maxUses;

        private final float givenExp;



        public EmeraldForItemsTrade(IItemProvider item, int amount, int maxUses, int p_i50539_4_) {

            this.itemstack = item.asItem();

            this.stackSize = amount;

            this.recievedSize = maxUses;

            this.maxUses = p_i50539_4_;

            this.givenExp = 0.05F;

        }



        public MerchantOffer getOffer(Entity player, Random random) {

            ItemStack itemstack = new ItemStack(this.itemstack, this.stackSize);

            return new MerchantOffer(itemstack, new ItemStack(Items.EMERALD), this.recievedSize, this.maxUses, this.givenExp);

        }

    }



    public static class SuspiciousStewForEmeraldTrade implements VillagerTrades.ITrade {

        final Effect field_221214_a;

        final int field_221215_b;

        final int field_221216_c;

        private final float field_221217_d;



        public SuspiciousStewForEmeraldTrade(Effect p_i50527_1_, int p_i50527_2_, int p_i50527_3_) {

            this.field_221214_a = p_i50527_1_;

            this.field_221215_b = p_i50527_2_;

            this.field_221216_c = p_i50527_3_;

            this.field_221217_d = 0.05F;

        }



        @Nullable

        public MerchantOffer getOffer(Entity p_221182_1_, Random p_221182_2_) {

            ItemStack itemstack = new ItemStack(Items.SUSPICIOUS_STEW, 1);

            SuspiciousStewItem.addEffect(itemstack, this.field_221214_a, this.field_221215_b);

            return new MerchantOffer(new ItemStack(Items.EMERALD, 1), itemstack, 12, this.field_221216_c, this.field_221217_d);

        }

    }



    public static class DyedArmorForEmeraldsTrade implements VillagerTrades.ITrade {

        private final Item field_221233_a;

        private final int field_221234_b;

        private final int field_221235_c;

        private final int field_221236_d;



        public DyedArmorForEmeraldsTrade(Item p_i50540_1_, int p_i50540_2_) {

            this(p_i50540_1_, p_i50540_2_, 12, 1);

        }



        public DyedArmorForEmeraldsTrade(Item p_i50541_1_, int p_i50541_2_, int p_i50541_3_, int p_i50541_4_) {

            this.field_221233_a = p_i50541_1_;

            this.field_221234_b = p_i50541_2_;

            this.field_221235_c = p_i50541_3_;

            this.field_221236_d = p_i50541_4_;

        }



        public MerchantOffer getOffer(Entity p_221182_1_, Random p_221182_2_) {

            ItemStack itemstack = new ItemStack(Items.EMERALD, this.field_221234_b);

            ItemStack itemstack1 = new ItemStack(this.field_221233_a);

            if (this.field_221233_a instanceof DyeableArmorItem) {

                List<DyeItem> list = Lists.newArrayList();

                list.add(func_221232_a(p_221182_2_));

                if (p_221182_2_.nextFloat() > 0.7F) {

                    list.add(func_221232_a(p_221182_2_));

                }



                if (p_221182_2_.nextFloat() > 0.8F) {

                    list.add(func_221232_a(p_221182_2_));

                }



                itemstack1 = IDyeableArmorItem.dyeItem(itemstack1, list);

            }



            return new MerchantOffer(itemstack, itemstack1, this.field_221235_c, this.field_221236_d, 0.2F);

        }



        private static DyeItem func_221232_a(Random p_221232_0_) {

            return DyeItem.getItem(DyeColor.byId(p_221232_0_.nextInt(16)));

        }

    }



    public static class EmeraldForMapTrade implements VillagerTrades.ITrade {

        private final int count;

        private final String structureName;

        private final MapDecoration.Type mapDecorationType;

        private final int maxUses;

        private final int xpValue;



        public EmeraldForMapTrade(int countIn, String structureNameIn, MapDecoration.Type decoration, int maxUsesIn, int xpValueIn) {

            this.count = countIn;

            this.structureName = structureNameIn;

            this.mapDecorationType = decoration;

            this.maxUses = maxUsesIn;

            this.xpValue = xpValueIn;

        }



        @Nullable

        public MerchantOffer getOffer(Entity trader, Random rand) {

            if (!(trader.world instanceof ServerWorld)) {

                return null;

            } else {

                ServerWorld serverworld = (ServerWorld) trader.world;

                BlockPos blockpos = serverworld.findNearestStructure(this.structureName, new BlockPos(trader), 100, true);

                if (blockpos != null) {

                    ItemStack itemstack = FilledMapItem.setupNewMap(serverworld, blockpos.getX(), blockpos.getZ(), (byte) 2, true, true);

                    FilledMapItem.func_226642_a_(serverworld, itemstack);

                    MapData.addTargetDecoration(itemstack, blockpos, "+", this.mapDecorationType);

                    itemstack.setDisplayName(new TranslationTextComponent("filled_map." + this.structureName.toLowerCase(Locale.ROOT)));

                    return new MerchantOffer(new ItemStack(Items.EMERALD, this.count), new ItemStack(Items.COMPASS), itemstack, this.maxUses, this.xpValue, 0.2F);

                } else {

                    System.out.println("NO STRUCTURE FOUND, SO NO MAP CREATED");

                    return null;

                }

            }

        }

    }



    public static class EmeraldForVillageTypeItemTrade implements VillagerTrades.ITrade {

        private final Map<IVillagerType, Item> field_221190_a;

        private final int field_221191_b;

        private final int field_221192_c;

        private final int field_221193_d;



        public EmeraldForVillageTypeItemTrade(int p_i50538_1_, int p_i50538_2_, int p_i50538_3_, Map<IVillagerType, Item> p_i50538_4_) {

            Registry.VILLAGER_TYPE.stream().filter((p_221188_1_) -> {

                return !p_i50538_4_.containsKey(p_221188_1_);

            }).findAny().ifPresent((p_221189_0_) -> {

                throw new IllegalStateException("Missing trade for villager type: " + Registry.VILLAGER_TYPE.getKey(p_221189_0_));

            });

            this.field_221190_a = p_i50538_4_;

            this.field_221191_b = p_i50538_1_;

            this.field_221192_c = p_i50538_2_;

            this.field_221193_d = p_i50538_3_;

        }



        @Nullable

        public MerchantOffer getOffer(Entity p_221182_1_, Random p_221182_2_) {

            if (p_221182_1_ instanceof IVillagerDataHolder) {

                ItemStack itemstack = new ItemStack(this.field_221190_a.get(((IVillagerDataHolder) p_221182_1_).getVillagerData().getType()), this.field_221191_b);

                return new MerchantOffer(itemstack, new ItemStack(Items.EMERALD), this.field_221192_c, this.field_221193_d, 0.05F);

            } else {

                return null;

            }

        }

    }



    public static class EnchantedBookForEmeraldsTrade implements VillagerTrades.ITrade {

        private final int field_221194_a;



        public EnchantedBookForEmeraldsTrade(int p_i50537_1_) {

            this.field_221194_a = p_i50537_1_;

        }



        public MerchantOffer getOffer(Entity p_221182_1_, Random p_221182_2_) {

            Enchantment enchantment = Registry.ENCHANTMENT.getRandom(p_221182_2_);

            int i = MathHelper.nextInt(p_221182_2_, enchantment.getMinLevel(), enchantment.getMaxLevel());

            ItemStack itemstack = EnchantedBookItem.getEnchantedItemStack(new EnchantmentData(enchantment, i));

            int j = 2 + p_221182_2_.nextInt(5 + i * 10) + 3 * i;

            if (enchantment.isTreasureEnchantment()) {

                j *= 2;

            }



            if (j > 64) {

                j = 64;

            }



            return new MerchantOffer(new ItemStack(Items.EMERALD, j), new ItemStack(Items.BOOK), itemstack, 12, this.field_221194_a, 0.2F);

        }

    }



    public static class EnchantedItemForEmeraldsTrade implements VillagerTrades.ITrade {

        private final ItemStack field_221195_a;

        private final int field_221196_b;

        private final int field_221197_c;

        private final int field_221198_d;

        private final float field_221199_e;



        public EnchantedItemForEmeraldsTrade(Item p_i50535_1_, int p_i50535_2_, int p_i50535_3_, int p_i50535_4_) {

            this(p_i50535_1_, p_i50535_2_, p_i50535_3_, p_i50535_4_, 0.05F);

        }



        public EnchantedItemForEmeraldsTrade(Item p_i50536_1_, int p_i50536_2_, int p_i50536_3_, int p_i50536_4_, float p_i50536_5_) {

            this.field_221195_a = new ItemStack(p_i50536_1_);

            this.field_221196_b = p_i50536_2_;

            this.field_221197_c = p_i50536_3_;

            this.field_221198_d = p_i50536_4_;

            this.field_221199_e = p_i50536_5_;

        }



        public MerchantOffer getOffer(Entity p_221182_1_, Random p_221182_2_) {

            int i = 5 + p_221182_2_.nextInt(15);

            ItemStack itemstack = EnchantmentHelper.addRandomEnchantment(p_221182_2_, new ItemStack(this.field_221195_a.getItem()), i, false);

            int j = Math.min(this.field_221196_b + i, 64);

            ItemStack itemstack1 = new ItemStack(Items.EMERALD, j);

            return new MerchantOffer(itemstack1, itemstack, this.field_221197_c, this.field_221198_d, this.field_221199_e);

        }

    }



    public static class ItemWithPotionForEmeraldsAndItemsTrade implements VillagerTrades.ITrade {

        private final ItemStack field_221219_a;

        private final int field_221220_b;

        private final int field_221221_c;

        private final int field_221222_d;

        private final int field_221223_e;

        private final Item field_221224_f;

        private final int field_221225_g;

        private final float field_221226_h;



        public ItemWithPotionForEmeraldsAndItemsTrade(Item p_i50526_1_, int p_i50526_2_, Item p_i50526_3_, int p_i50526_4_, int p_i50526_5_, int p_i50526_6_, int p_i50526_7_) {

            this.field_221219_a = new ItemStack(p_i50526_3_);

            this.field_221221_c = p_i50526_5_;

            this.field_221222_d = p_i50526_6_;

            this.field_221223_e = p_i50526_7_;

            this.field_221224_f = p_i50526_1_;

            this.field_221225_g = p_i50526_2_;

            this.field_221220_b = p_i50526_4_;

            this.field_221226_h = 0.05F;

        }



        public MerchantOffer getOffer(Entity p_221182_1_, Random p_221182_2_) {

            ItemStack itemstack = new ItemStack(Items.EMERALD, this.field_221221_c);

            List<Potion> list = Registry.POTION.stream().filter((p_221218_0_) -> {

                return !p_221218_0_.getEffects().isEmpty() && PotionBrewing.func_222124_a(p_221218_0_);

            }).collect(Collectors.toList());

            Potion potion = list.get(p_221182_2_.nextInt(list.size()));

            ItemStack itemstack1 = PotionUtils.addPotionToItemStack(new ItemStack(this.field_221219_a.getItem(), this.field_221220_b), potion);

            return new MerchantOffer(itemstack, new ItemStack(this.field_221224_f, this.field_221225_g), itemstack1, this.field_221222_d, this.field_221223_e, this.field_221226_h);

        }

    }



    public static class ItemsForEmeraldsAndItemsTrade implements VillagerTrades.ITrade {

        private final ItemStack field_221200_a;

        private final int field_221201_b;

        private final int field_221202_c;

        private final ItemStack field_221203_d;

        private final int field_221204_e;

        private final int field_221205_f;

        private final int field_221206_g;

        private final float field_221207_h;



        public ItemsForEmeraldsAndItemsTrade(IItemProvider p_i50533_1_, int p_i50533_2_, Item p_i50533_3_, int p_i50533_4_, int p_i50533_5_, int p_i50533_6_) {

            this(p_i50533_1_, p_i50533_2_, 1, p_i50533_3_, p_i50533_4_, p_i50533_5_, p_i50533_6_);

        }



        public ItemsForEmeraldsAndItemsTrade(IItemProvider p_i50534_1_, int p_i50534_2_, int p_i50534_3_, Item p_i50534_4_, int p_i50534_5_, int p_i50534_6_, int p_i50534_7_) {

            this.field_221200_a = new ItemStack(p_i50534_1_);

            this.field_221201_b = p_i50534_2_;

            this.field_221202_c = p_i50534_3_;

            this.field_221203_d = new ItemStack(p_i50534_4_);

            this.field_221204_e = p_i50534_5_;

            this.field_221205_f = p_i50534_6_;

            this.field_221206_g = p_i50534_7_;

            this.field_221207_h = 0.05F;

        }



        @Nullable

        public MerchantOffer getOffer(Entity p_221182_1_, Random p_221182_2_) {

            return new MerchantOffer(new ItemStack(Items.EMERALD, this.field_221202_c), new ItemStack(this.field_221200_a.getItem(), this.field_221201_b), new ItemStack(this.field_221203_d.getItem(), this.field_221204_e), this.field_221205_f, this.field_221206_g, this.field_221207_h);

        }

    }

}
