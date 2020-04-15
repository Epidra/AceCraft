package mod.acecraft;

import com.google.common.base.Preconditions;
import mod.acecraft.container.ContainerBlastFurnace;
import mod.acecraft.container.ContainerDestille;
import mod.acecraft.container.ContainerStove;
import mod.acecraft.crafting.RecipeDestille;
import mod.acecraft.crafting.RecipeDestilleSerializer;
import mod.acecraft.crafting.RecipeStove;
import mod.acecraft.crafting.RecipeStoveSerializer;
import mod.acecraft.tileentities.TileEntityDestille;
import mod.acecraft.tileentities.TileEntityStove;
import mod.acecraft.util.CustomBiomeColors;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.GrassColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

import static mod.acecraft.AceCraft.MODID;

public class Subscriber {

    public static final RecipeDestilleSerializer serializerDestille = null;
    public static final RecipeStoveSerializer serializerStove    = null;

    public static final TileEntityType<TileEntityDestille> tileDestille = null;
    public static final TileEntityType<TileEntityStove> tileStove = null;

    public static final ContainerType<ContainerDestille> containerDestille = IForgeContainerType.create(ContainerDestille::new);
    public static final ContainerType<ContainerStove> containerStove    = IForgeContainerType.create(ContainerStove::new);

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @ObjectHolder(MODID)
    @Mod.EventBusSubscriber(bus= Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent

        public static void registerSerializer(RegistryEvent.Register<IRecipeSerializer<?>> event) {
            IForgeRegistry<IRecipeSerializer<?>> registry = event.getRegistry();
            registry.register(new RecipeDestilleSerializer(RecipeDestille::new).setRegistryName(MODID, "destille"));
            registry.register(new RecipeStoveSerializer(RecipeStove::new).setRegistryName(MODID, "stove"));
        }

        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            ShopKeeper.registerBlocks();
        }
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
            ShopKeeper.registerItems();
        }

        //@OnlyIn(Dist.CLIENT)
        //@SubscribeEvent
        //public static void registerBlockColorHandlers(final ColorHandlerEvent.Block event) {
        //    event.getBlockColors().register((x, reader, pos, u) -> reader != null
        //            && pos != null ? CustomBiomeColors.getGrassColor(reader, pos)
        //            : GrassColors.get(0.5D, 1.0D), ShopKeeper.FLOWER_TOYFLOWER);
        //    //BlockColors blockColors = event.getBlockColors();
        //    //blockColors.register((state, world, pos, tint_index) -> {
        //    //    return world != null && pos != null ? BiomeColors.getGrassColor(world, pos) : GrassColors.get(0.5D, 1.0D);
        //    //}, block1, block2, blokc3, blokc4);
        //}

        @SubscribeEvent
        public static void registerContainer(RegistryEvent.Register<ContainerType<?>> event) {
            IForgeRegistry<ContainerType<?>> registry = event.getRegistry();
            //registry.register(containerDestille.setRegistryName(MODID, "destille"));
            //registry.register(containerStove.setRegistryName(MODID, "stove"));
            registry.register(ContainerBlastFurnace.TYPE);
            registry.register(ContainerDestille.TYPE);
            registry.register(ContainerStove.TYPE);

        }

        @SubscribeEvent
        public static void registerTileEntities(final RegistryEvent.Register<TileEntityType<?>> event){
            ShopKeeper.registerTileEntities(event);
        }

        //@SubscribeEvent
        //public static void registerTileEntity(RegistryEvent.Register<TileEntityType<?>> event) {
        //    IForgeRegistry<TileEntityType<?>> registry = event.getRegistry();
        //    registry.register(TileEntityType.Builder.create(TileBlastFurnace::new,   ShopKeeper.MACHINA_BLASTFURNACE).build(null).setRegistryName("blast_furnace"));
        //    registry.register(TileEntityType.Builder.create(TileEntityDestille::new, ShopKeeper.MACHINA_DESTILLERY).build(null).setRegistryName("destille"));
        //    registry.register(TileEntityType.Builder.create(TileEntityStove::new,    ShopKeeper.MACHINA_STOVE).build(null).setRegistryName("stove"));
        //}

        @SubscribeEvent
        public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
            for (EntityType entity : ShopKeeper.entities) {
                Preconditions.checkNotNull(entity.getRegistryName(), "registryName");
                event.getRegistry().register(entity);
                //EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityCrab::func_223316_b);
            }
        }

        @SubscribeEvent
        public static void registerSpawnEggs(RegistryEvent.Register<Item> event) {
            for (Item spawnEgg : ShopKeeper.spawnEggs) {
                Preconditions.checkNotNull(spawnEgg.getRegistryName(), "registryName");
                event.getRegistry().register(spawnEgg);
            }
        }

        @SubscribeEvent
        public static void registerSound(RegistryEvent.Register<SoundEvent> event) {
            //for (SoundEvent sound : ShopKeeper.sounds) {
            //    event.getRegistry().register(sound);
            //}
        }
    }
}
