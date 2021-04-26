package mod.acecraft;

import mod.acecraft.crafting.ModifierAddItem;
import mod.acecraft.entity.EntityAlpaca;
import net.minecraft.item.DyeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootPool;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import java.util.Set;

import static mod.acecraft.AceCraft.MODID;

public class Subscriber {

    @ObjectHolder(MODID)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.FORGE)
    public static class RegistryEventsForge {
        @SubscribeEvent(priority = EventPriority.HIGH)
        public static void onBiomesLoading(final BiomeLoadingEvent event) {
            if (event.getName() != null) {
                RegistryKey<Biome> key = RegistryKey.create(Registry.BIOME_REGISTRY, event.getName());
                Set<BiomeDictionary.Type> types = BiomeDictionary.getTypes(key);
                ShopKeeper.registerEntity(event, types);
            }
            if (event.getCategory() == Biome.Category.NETHER) {
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ShopKeeper.SPAWN_GILIUM);
            } else if(event.getCategory() == Biome.Category.THEEND) {
                // empty
            } else {
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ShopKeeper.SPAWN_ZINC);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ShopKeeper.SPAWN_MYTHRIL);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ShopKeeper.SPAWN_TIN);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ShopKeeper.SPAWN_COPPER);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ShopKeeper.SPAWN_AURORITE);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ShopKeeper.SPAWN_SAPPHIRE);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ShopKeeper.SPAWN_RUBY);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ShopKeeper.SPAWN_SALT);
                event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES).add(() -> ShopKeeper.SPAWN_SULFUR);
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




    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @ObjectHolder(MODID)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEventsMod {

        @SubscribeEvent
        public static void registerModifiers(RegistryEvent.Register<GlobalLootModifierSerializer<?>> ev) {
            ev.getRegistry().register(new ModifierAddItem.Serializer().setRegistryName(AceCraft.MODID, "add_item"));
        }

    }
}
