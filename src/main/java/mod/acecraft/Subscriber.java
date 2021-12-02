package mod.acecraft;

import com.google.common.collect.Lists;
import mod.acecraft.crafting.ModifierAddItem;
import mod.acecraft.entity.EntityAlpaca;
import mod.lucky77.util.BiomeDictionaryHelper;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static net.minecraft.world.level.biome.Biome.BiomeCategory.NETHER;
import static net.minecraft.world.level.biome.Biome.BiomeCategory.THEEND;
import static net.minecraft.world.level.levelgen.GenerationStep.Decoration.UNDERGROUND_ORES;

public class Subscriber {

    // ...





    //----------------------------------------EVENT_FORGE----------------------------------------//

    @ObjectHolder(AceCraft.MODID)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.FORGE)
    public static class RegistryEventsForge {
        @SubscribeEvent(priority = EventPriority.HIGH)
        public static void onBiomesLoading(final BiomeLoadingEvent event) {
            if (event.getName() != null) {
                ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, event.getName());
                Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);
                ShopKeeper.registerEntity(event, types);
            }
            if (event.getCategory() == NETHER) {
                event.getGeneration().addFeature(UNDERGROUND_ORES, ShopKeeper.SPAWN_GILIUM);
            } else if(event.getCategory() == THEEND) {
                // empty
            } else {
                event.getGeneration().addFeature(UNDERGROUND_ORES, ShopKeeper.SPAWN_ZINC);
                event.getGeneration().addFeature(UNDERGROUND_ORES, ShopKeeper.SPAWN_MYTHRIL);
                event.getGeneration().addFeature(UNDERGROUND_ORES, ShopKeeper.SPAWN_TIN);
                event.getGeneration().addFeature(UNDERGROUND_ORES, ShopKeeper.SPAWN_AURORITE);
                event.getGeneration().addFeature(UNDERGROUND_ORES, ShopKeeper.SPAWN_SAPPHIRE);
                event.getGeneration().addFeature(UNDERGROUND_ORES, ShopKeeper.SPAWN_RUBY);
                event.getGeneration().addFeature(UNDERGROUND_ORES, ShopKeeper.SPAWN_SALT);
                event.getGeneration().addFeature(UNDERGROUND_ORES, ShopKeeper.SPAWN_SULFUR);
            }
        }

        @SubscribeEvent
        public static void OnInteract(final PlayerInteractEvent.EntityInteract event){
            if(event.getTarget() instanceof EntityAlpaca){
                if(event.getItemStack().getItem() instanceof DyeItem){
                    DyeItem item = (DyeItem) event.getItemStack().getItem();
                    EntityAlpaca alp = (EntityAlpaca) event.getTarget();
                    if(alp.getColor() != item.getDyeColor()){
                        alp.setColor(item.getDyeColor());
                        if(!event.getPlayer().isCreative()){
                            event.getItemStack().shrink(1);
                        }
                    }
                }
            }
        }
    }





    //----------------------------------------EVENT_MOD----------------------------------------//

    @Mod.EventBusSubscriber(modid = "acecraft", bus = Mod.EventBusSubscriber.Bus.MOD)
    public class MobRegistry {
        public static final DeferredRegister<EntityType<?>> ENTITY_DEFERRED = DeferredRegister.create(ForgeRegistries.ENTITIES, "acecraft");
        private static final List<Item> SPAWN_EGGS = Lists.newArrayList();
        private static <T extends Animal> RegistryObject<EntityType<T>> createEntity(String name, EntityType.EntityFactory<T> factory, float width, float height, int eggPrimary, int eggSecondary) {
            ResourceLocation location = new ResourceLocation("acecraft", name);
            EntityType<T> entity = EntityType.Builder.of(factory, MobCategory.CREATURE).sized(width, height).setTrackingRange(64).setUpdateInterval(1).build(location.toString());
            Item spawnEgg = new SpawnEggItem(entity, eggPrimary, eggSecondary, (new Item.Properties()).tab(CreativeModeTab.TAB_MISC));
            spawnEgg.setRegistryName(new ResourceLocation("acecraft", name + "_spawn_egg"));
            SPAWN_EGGS.add(spawnEgg);
            return ENTITY_DEFERRED.register(name, () -> entity);
        }

        @SubscribeEvent
        public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
            SpawnPlacements.register(ShopKeeper.ENTITY_ALPACA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, EntityAlpaca::checkAnimalSpawnRules);
        }

        @SubscribeEvent
        public static void addEntityAttributes(EntityAttributeCreationEvent event) {
            event.put(ShopKeeper.ENTITY_ALPACA.get(), EntityAlpaca.createAttributes().build());
        }

        @SubscribeEvent
        public static void registerModifiers(RegistryEvent.Register<GlobalLootModifierSerializer<?>> ev) {
            ev.getRegistry().register(new ModifierAddItem.Serializer().setRegistryName("acecraft", "add_item"));
        }

        //@SubscribeEvent(priority = EventPriority.HIGH)
        //public static void addSpawn(BiomeLoadingEvent event) {
        //    if (event.getName() != null) {
        //        Biome biome = ForgeRegistries.BIOMES.getValue(event.getName());
        //        if (biome != null) {
        //            ResourceKey<Biome> resourceKey = ResourceKey.create(ForgeRegistries.Keys.BIOMES, event.getName());
        //            List<BiomeDictionary.Type> includeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(Config.ALPACA.include.get()));
        //            List<BiomeDictionary.Type> excludeList = Arrays.asList(BiomeDictionaryHelper.toBiomeTypeArray(Config.ALPACA.exclude.get()));
        //            if (!includeList.isEmpty()) {
        //                Set<BiomeDictionary.Type> biomeTypes = BiomeDictionary.getTypes(resourceKey);
        //                if (biomeTypes.stream().noneMatch(excludeList::contains) && biomeTypes.stream().anyMatch(includeList::contains)) {
        //                    event.getSpawns().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(ShopKeeper.ENTITY_ALPACA.get(), Config.ALPACA.weight.get(), Config.ALPACA.min.get(), Config.ALPACA.max.get()));
        //                }
        //            } else {
        //                throw new IllegalArgumentException("Do not leave the BiomeDictionary type inclusion list empty. If you wish to disable spawning of an entity, set the weight to 0 instead.");
        //            }
        //        }
        //    }
        //}
    }



}
