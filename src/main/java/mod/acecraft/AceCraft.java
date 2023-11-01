package mod.acecraft;

import mod.acecraft.block.*;
import mod.acecraft.item.*;
import mod.acecraft.system.AceCraftPacketHandler;
import mod.acecraft.system.ClientProxy;
import mod.acecraft.system.CommonProxy;
import mod.acecraft.util.MaterialTool;
import mod.lucky77.block.BlockBlock;
import mod.lucky77.item.ItemFood;
import mod.lucky77.item.ItemItem;
import mod.lucky77.system.SystemStructures;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.level.LevelEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("acecraft")
public class AceCraft {

    // TODO: Add Topaz Geode
    // TODO Add Stone and Deepslate variants for Ores
    // TODO: Fix Dynamite
    // TODO: Fix Ore Throwing
    // TODO: Fix Block GUIs
    // TODO: Make Alpaca smaller
    // TODO: Add Book concerning infos about Alpacas/Llamas
    // TODO: Add Book concerning infos about geodes
    // TODO: Add Book concerning infos about Ores and Alloy smelting

    // The Mod ID
    public static final String MODID = "acecraft";
    // Client/Server Proxy
    public static CommonProxy proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);





    //----------------------------------------CONSTRUCTOR----------------------------------------//

    public AceCraft() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupCommon);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::addCreative);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.spec);
        MinecraftForge.EVENT_BUS.register(this);
        ShopKeeper.register(FMLJavaModLoadingContext.get().getModEventBus());

        // For events that happen after initialization. This is probably going to be use a lot.
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        //forgeBus.addListener(EventPriority.NORMAL, this::addDimensionalSpacing);
        //forgeBus.addListener(EventPriority.NORMAL, StructureRuinedHouse::setupStructureSpawns);
    }





    //----------------------------------------SETUP----------------------------------------//

    private void setupCommon(final FMLCommonSetupEvent event) {
        ShopKeeper.registerOreSpawn();
        ShopKeeper.registerStructureConfigs();
        AceCraftPacketHandler.register();
        ShopKeeper.setup(event);
    }

    private void setupClient(final FMLClientSetupEvent event) {
        ShopKeeper.setup(event);
    }

    public void addDimensionalSpacing(final LevelEvent.Load event){
        //SystemStructures.addDimensionalSpacing(event,
        //        ShopKeeper.STRUCTURE_RUINED_HOUSE.get(),
        //        ShopKeeper.CONFIGURED_RUN_DOWN_HOUSE
        //);
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ShopKeeper.BLOCK_MYTHRIL            );
            event.accept(ShopKeeper.BLOCK_GILIUM             );
            event.accept(ShopKeeper.BLOCK_TIN                );
            event.accept(ShopKeeper.BLOCK_ZINC               );
            event.accept(ShopKeeper.BLOCK_BRONZE             );
            event.accept(ShopKeeper.BLOCK_BRASS              );
            event.accept(ShopKeeper.BLOCK_STEEL              );
            event.accept(ShopKeeper.BLOCK_ORICHALCUM         );
            event.accept(ShopKeeper.BLOCK_ADAMANTIUM         );
            event.accept(ShopKeeper.BLOCK_SALT               );
            event.accept(ShopKeeper.BLOCK_SULFUR             );
            event.accept(ShopKeeper.BLOCK_RUBY               );
            event.accept(ShopKeeper.BLOCK_SAPPHIRE           );
            event.accept(ShopKeeper.BLOCK_AURORITE           );
            event.accept(ShopKeeper.ORE_MYTHRIL_BASE         );
            event.accept(ShopKeeper.ORE_MYTHRIL_DEEP         );
            event.accept(ShopKeeper.ORE_GILIUM               );
            event.accept(ShopKeeper.ORE_TIN_BASE             );
            event.accept(ShopKeeper.ORE_TIN_DEEP             );
            event.accept(ShopKeeper.ORE_ZINC_BASE            );
            event.accept(ShopKeeper.ORE_ZINC_DEEP            );
            event.accept(ShopKeeper.ORE_SALT_BASE            );
            event.accept(ShopKeeper.ORE_SALT_DEEP            );
            event.accept(ShopKeeper.ORE_SULFUR_BASE          );
            event.accept(ShopKeeper.ORE_SULFUR_DEEP          );
            event.accept(ShopKeeper.ORE_RUBY_BASE            );
            event.accept(ShopKeeper.ORE_RUBY_DEEP            );
            event.accept(ShopKeeper.ORE_SAPPHIRE_BASE        );
            event.accept(ShopKeeper.ORE_SAPPHIRE_DEEP        );
            event.accept(ShopKeeper.ORE_AURORITE_BASE        );
            event.accept(ShopKeeper.ORE_AURORITE_DEEP        );
            event.accept(ShopKeeper.NUGGET_MYTHRIL           );
            event.accept(ShopKeeper.NUGGET_GILIUM            );
            event.accept(ShopKeeper.NUGGET_TIN               );
            event.accept(ShopKeeper.NUGGET_ZINC              );
            event.accept(ShopKeeper.INGOT_MYTHRIL            );
            event.accept(ShopKeeper.INGOT_GILIUM             );
            event.accept(ShopKeeper.INGOT_TIN                );
            event.accept(ShopKeeper.INGOT_ZINC               );
            event.accept(ShopKeeper.INGOT_BRONZE             );
            event.accept(ShopKeeper.INGOT_BRASS              );
            event.accept(ShopKeeper.INGOT_STEEL              );
            event.accept(ShopKeeper.INGOT_ORICHALCUM         );
            event.accept(ShopKeeper.INGOT_ADAMANTIUM         );
            event.accept(ShopKeeper.STUFF_SALT               );
            event.accept(ShopKeeper.STUFF_SULFUR             );
            event.accept(ShopKeeper.STUFF_RICE               );
            event.accept(ShopKeeper.STUFF_COFFEE             );
            event.accept(ShopKeeper.STUFF_HEMP               );
            event.accept(ShopKeeper.STUFF_ROPE               );
            event.accept(ShopKeeper.STUFF_SLAG               );
            event.accept(ShopKeeper.STUFF_RUBY               );
            event.accept(ShopKeeper.STUFF_SAPPHIRE           );
            event.accept(ShopKeeper.STUFF_AURORITE           );
            event.accept(ShopKeeper.FOOD_CABBAGE             );
            event.accept(ShopKeeper.FOOD_CORN                );
            event.accept(ShopKeeper.FOOD_CUCUMBER            );
            event.accept(ShopKeeper.FOOD_EGGPLANT            );
            event.accept(ShopKeeper.FOOD_GRAPES              );
            event.accept(ShopKeeper.FOOD_ONION               );
            event.accept(ShopKeeper.FOOD_PINEAPPLE           );
            event.accept(ShopKeeper.FOOD_STRAWBERRY          );
            event.accept(ShopKeeper.FOOD_TOMATO              );
            event.accept(ShopKeeper.FOOD_TURNIP              );
            event.accept(ShopKeeper.FOOD_VICUGNA_RAW         );
            event.accept(ShopKeeper.FOOD_VICUGNA_COOKED      );
            event.accept(ShopKeeper.LIQUOR_COFFEE            );
            event.accept(ShopKeeper.LIQUOR_MOONSHINE         );
            event.accept(ShopKeeper.LIQUOR_RUM               );
            event.accept(ShopKeeper.LIQUOR_SAKE              );
            event.accept(ShopKeeper.LIQUOR_SALGAM            );
            event.accept(ShopKeeper.LIQUOR_VODKA             );
            event.accept(ShopKeeper.LIQUOR_WHISKY            );
            event.accept(ShopKeeper.LIQUOR_BRANDY            );
            event.accept(ShopKeeper.LIQUOR_OIL               );
            event.accept(ShopKeeper.SEED_CABBAGE             );
            event.accept(ShopKeeper.SEED_CORN                );
            event.accept(ShopKeeper.SEED_CUCUMBER            );
            event.accept(ShopKeeper.SEED_EGGPLANT            );
            event.accept(ShopKeeper.SEED_GRAPES              );
            event.accept(ShopKeeper.SEED_ONION               );
            event.accept(ShopKeeper.SEED_PINEAPPLE           );
            event.accept(ShopKeeper.SEED_STRAWBERRY          );
            event.accept(ShopKeeper.SEED_TOMATO              );
            event.accept(ShopKeeper.SEED_TURNIP              );
            event.accept(ShopKeeper.SEED_RICE                );
            event.accept(ShopKeeper.SEED_COFFEE              );
            event.accept(ShopKeeper.SEED_HEMP                );
            event.accept(ShopKeeper.MACHINA_GLOBE            );
            event.accept(ShopKeeper.MACHINA_FOUNDRY          );
            event.accept(ShopKeeper.MACHINA_DISTILLERY       );
            event.accept(ShopKeeper.MACHINA_COOKINGBOARD     );
            event.accept(ShopKeeper.MACHINA_KEG              );
            event.accept(ShopKeeper.MACHINA_ANCHOR           );
            event.accept(ShopKeeper.MACHINA_ROPE             );
            event.accept(ShopKeeper.ARMOR_BOOTS_GILIUM       );
            event.accept(ShopKeeper.ARMOR_BOOTS_ADAMANTIUM   );
            event.accept(ShopKeeper.ARMOR_BOOTS_MYTHRIL      );
            event.accept(ShopKeeper.ARMOR_BOOTS_ORICHALCUM   );
            event.accept(ShopKeeper.ARMOR_BOOTS_COPPER       );
            event.accept(ShopKeeper.ARMOR_BOOTS_BRONZE       );
            event.accept(ShopKeeper.ARMOR_BOOTS_STEEL        );
            event.accept(ShopKeeper.ARMOR_BOOTS_AURORITE     );
            event.accept(ShopKeeper.ARMOR_PLATE_GILIUM       );
            event.accept(ShopKeeper.ARMOR_PLATE_ADAMANTIUM   );
            event.accept(ShopKeeper.ARMOR_PLATE_MYTHRIL      );
            event.accept(ShopKeeper.ARMOR_PLATE_ORICHALCUM   );
            event.accept(ShopKeeper.ARMOR_PLATE_COPPER       );
            event.accept(ShopKeeper.ARMOR_PLATE_BRONZE       );
            event.accept(ShopKeeper.ARMOR_PLATE_STEEL        );
            event.accept(ShopKeeper.ARMOR_PLATE_AURORITE     );
            event.accept(ShopKeeper.ARMOR_LEGGINGS_GILIUM    );
            event.accept(ShopKeeper.ARMOR_LEGGINGS_ADAMANTIUM);
            event.accept(ShopKeeper.ARMOR_LEGGINGS_MYTHRIL   );
            event.accept(ShopKeeper.ARMOR_LEGGINGS_ORICHALCUM);
            event.accept(ShopKeeper.ARMOR_LEGGINGS_COPPER    );
            event.accept(ShopKeeper.ARMOR_LEGGINGS_BRONZE    );
            event.accept(ShopKeeper.ARMOR_LEGGINGS_STEEL     );
            event.accept(ShopKeeper.ARMOR_LEGGINGS_AURORITE  );
            event.accept(ShopKeeper.ARMOR_HELMET_GILIUM      );
            event.accept(ShopKeeper.ARMOR_HELMET_ADAMANTIUM  );
            event.accept(ShopKeeper.ARMOR_HELMET_MYTHRIL     );
            event.accept(ShopKeeper.ARMOR_HELMET_ORICHALCUM  );
            event.accept(ShopKeeper.ARMOR_HELMET_COPPER      );
            event.accept(ShopKeeper.ARMOR_HELMET_BRONZE      );
            event.accept(ShopKeeper.ARMOR_HELMET_STEEL       );
            event.accept(ShopKeeper.ARMOR_HELMET_AURORITE    );
            event.accept(ShopKeeper.TOOL_SWORD_GILIUM        );
            event.accept(ShopKeeper.TOOL_SWORD_ADAMANTIUM    );
            event.accept(ShopKeeper.TOOL_SWORD_MYTHRIL       );
            event.accept(ShopKeeper.TOOL_SWORD_ORICHALCUM    );
            event.accept(ShopKeeper.TOOL_SWORD_COPPER        );
            event.accept(ShopKeeper.TOOL_SWORD_BRONZE        );
            event.accept(ShopKeeper.TOOL_SWORD_STEEL         );
            event.accept(ShopKeeper.TOOL_SWORD_AURORITE      );
            event.accept(ShopKeeper.TOOL_SPEAR_GILIUM        );
            event.accept(ShopKeeper.TOOL_SPEAR_ADAMANTIUM    );
            event.accept(ShopKeeper.TOOL_SPEAR_MYTHRIL       );
            event.accept(ShopKeeper.TOOL_SPEAR_ORICHALCUM    );
            event.accept(ShopKeeper.TOOL_SPEAR_COPPER        );
            event.accept(ShopKeeper.TOOL_SPEAR_BRONZE        );
            event.accept(ShopKeeper.TOOL_SPEAR_STEEL         );
            event.accept(ShopKeeper.TOOL_SPEAR_AURORITE      );
            event.accept(ShopKeeper.TOOL_AXE_GILIUM          );
            event.accept(ShopKeeper.TOOL_AXE_ADAMANTIUM      );
            event.accept(ShopKeeper.TOOL_AXE_MYTHRIL         );
            event.accept(ShopKeeper.TOOL_AXE_ORICHALCUM      );
            event.accept(ShopKeeper.TOOL_AXE_COPPER          );
            event.accept(ShopKeeper.TOOL_AXE_BRONZE          );
            event.accept(ShopKeeper.TOOL_AXE_STEEL           );
            event.accept(ShopKeeper.TOOL_AXE_AURORITE        );
            event.accept(ShopKeeper.TOOL_PICKAXE_GILIUM      );
            event.accept(ShopKeeper.TOOL_PICKAXE_ADAMANTIUM  );
            event.accept(ShopKeeper.TOOL_PICKAXE_MYTHRIL     );
            event.accept(ShopKeeper.TOOL_PICKAXE_ORICHALCUM  );
            event.accept(ShopKeeper.TOOL_PICKAXE_COPPER      );
            event.accept(ShopKeeper.TOOL_PICKAXE_BRONZE      );
            event.accept(ShopKeeper.TOOL_PICKAXE_STEEL       );
            event.accept(ShopKeeper.TOOL_PICKAXE_AURORITE    );
            event.accept(ShopKeeper.TOOL_SHOVEL_GILIUM       );
            event.accept(ShopKeeper.TOOL_SHOVEL_ADAMANTIUM   );
            event.accept(ShopKeeper.TOOL_SHOVEL_MYTHRIL      );
            event.accept(ShopKeeper.TOOL_SHOVEL_ORICHALCUM   );
            event.accept(ShopKeeper.TOOL_SHOVEL_COPPER       );
            event.accept(ShopKeeper.TOOL_SHOVEL_BRONZE       );
            event.accept(ShopKeeper.TOOL_SHOVEL_STEEL        );
            event.accept(ShopKeeper.TOOL_SHOVEL_AURORITE     );
            event.accept(ShopKeeper.TOOL_HOE_GILIUM          );
            event.accept(ShopKeeper.TOOL_HOE_ADAMANTIUM      );
            event.accept(ShopKeeper.TOOL_HOE_MYTHRIL         );
            event.accept(ShopKeeper.TOOL_HOE_ORICHALCUM      );
            event.accept(ShopKeeper.TOOL_HOE_COPPER          );
            event.accept(ShopKeeper.TOOL_HOE_BRONZE          );
            event.accept(ShopKeeper.TOOL_HOE_STEEL           );
            event.accept(ShopKeeper.TOOL_HOE_AURORITE        );

        }
    }



}
