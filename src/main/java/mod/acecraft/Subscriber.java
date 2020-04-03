package mod.acecraft;

import com.google.common.base.Preconditions;
import mod.acecraft.entity.EntityCrab;
import mod.acecraft.util.CustomBiomeColors;
import net.minecraft.block.Block;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.GrassColors;
import net.minecraft.world.biome.BiomeColors;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static net.minecraftforge.versions.forge.ForgeVersion.MOD_ID;

public class Subscriber {

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            ShopKeeper.registerBlocks();
        }
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
            ShopKeeper.registerItems();
        }

        @SubscribeEvent
        public static void onRegisterSerializers(final RegistryEvent.Register<IRecipeSerializer<?>> event) {
            //event.getRegistry().register(ShopKeeper.WOODCUTTING.setRegistryName(new ResourceLocation(MOD_ID, "woodcutting")));
        }

        @OnlyIn(Dist.CLIENT)
        @SubscribeEvent
        public static void registerBlockColorHandlers(final ColorHandlerEvent.Block event) {
            event.getBlockColors().register((x, reader, pos, u) -> reader != null
                    && pos != null ? CustomBiomeColors.getGrassColor(reader, pos)
                    : GrassColors.get(0.5D, 1.0D), ShopKeeper.FLOWER_TOYFLOWER);
        }



        // @SubscribeEvent
        // public static void registerContainers(RegistryEvent.Register<ContainerType<?>> event) {
        //     IForgeRegistry<ContainerType<?>> registry = event.getRegistry();
        //     ShopKeeper.registerContainer(registry);
        // }

        //@SubscribeEvent
        // public static void registerTiles(RegistryEvent.Register<TileEntityType<?>> event) {
        //     IForgeRegistry<TileEntityType<?>> registry = event.getRegistry();
        //     ShopKeeper.TYPE_BLASTFURNACE_TILE = TileEntityType.Builder.create((Supplier<TileEntity>) TileBlastFurnace::new,
        //             ShopKeeper.MACHINA_BLASTFURNACE
        //     ).build(null);
        //     ShopKeeper.TYPE_BLASTFURNACE_TILE.setRegistryName(MODID, "summoningpedestal");
        //     event.getRegistry().register(ShopKeeper.TYPE_BLASTFURNACE_TILE);
        //     //registry.register(TileEntityType.Builder.create(TileBlastFurnace::new, ShopKeeper.MACHINA_BLASTFURNACE).build(null).setRegistryName(MODID, "blastfurnace"));
        // }

        @SubscribeEvent
        public static void registerPenguins(RegistryEvent.Register<EntityType<?>> event) {
            for (EntityType entity : ShopKeeper.entities) {
                Preconditions.checkNotNull(entity.getRegistryName(), "registryName");
                event.getRegistry().register(entity);
                EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, EntityCrab::func_223316_b);
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
            for (SoundEvent sound : ShopKeeper.sounds) {
                event.getRegistry().register(sound);
            }
        }

    }
}
