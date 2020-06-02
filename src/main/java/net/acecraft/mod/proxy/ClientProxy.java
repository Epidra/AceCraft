package net.acecraft.mod.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.entity.EntityCarrotRed;
import net.acecraft.mod.entity.EntityCarrotWhite;
import net.acecraft.mod.entity.EntityCrab;
import net.acecraft.mod.entity.EntityDeer;
import net.acecraft.mod.entity.EntityDynamite;
import net.acecraft.mod.entity.EntityElephant;
import net.acecraft.mod.entity.EntityGoat;
import net.acecraft.mod.entity.EntityLlama;
import net.acecraft.mod.entity.EntityMammoth;
import net.acecraft.mod.entity.EntityNugget;
import net.acecraft.mod.entity.EntitySpear;
import net.acecraft.mod.model.ModelCarrot;
import net.acecraft.mod.model.ModelCrab;
import net.acecraft.mod.model.ModelDeer;
import net.acecraft.mod.model.ModelElephant;
import net.acecraft.mod.model.ModelGoat;
import net.acecraft.mod.model.ModelLlama;
import net.acecraft.mod.model.ModelMammoth;
import net.acecraft.mod.renderer.entity.RenderCarrotRed;
import net.acecraft.mod.renderer.entity.RenderCarrotWhite;
import net.acecraft.mod.renderer.entity.RenderCrab;
import net.acecraft.mod.renderer.entity.RenderDeer;
import net.acecraft.mod.renderer.entity.RenderDynamite;
import net.acecraft.mod.renderer.entity.RenderElephant;
import net.acecraft.mod.renderer.entity.RenderGoat;
import net.acecraft.mod.renderer.entity.RenderLlama;
import net.acecraft.mod.renderer.entity.RenderMammoth;
import net.acecraft.mod.renderer.entity.RenderNugget;
import net.acecraft.mod.renderer.entity.RenderSpear;
import net.acecraft.mod.renderer.item.ItemRendererAnchor;
import net.acecraft.mod.renderer.item.ItemRendererAnvil;
import net.acecraft.mod.renderer.item.ItemRendererAxle;
import net.acecraft.mod.renderer.item.ItemRendererBattery;
import net.acecraft.mod.renderer.item.ItemRendererBellows;
import net.acecraft.mod.renderer.item.ItemRendererBlastFurnace;
import net.acecraft.mod.renderer.item.ItemRendererBoiler;
import net.acecraft.mod.renderer.item.ItemRendererBonfire;
import net.acecraft.mod.renderer.item.ItemRendererCable;
import net.acecraft.mod.renderer.item.ItemRendererDistillery;
import net.acecraft.mod.renderer.item.ItemRendererEnergyNode;
import net.acecraft.mod.renderer.item.ItemRendererFruitPress;
import net.acecraft.mod.renderer.item.ItemRendererGenerator;
import net.acecraft.mod.renderer.item.ItemRendererGlobe;
import net.acecraft.mod.renderer.item.ItemRendererIngotBasin;
import net.acecraft.mod.renderer.item.ItemRendererKeg;
import net.acecraft.mod.renderer.item.ItemRendererMillstone;
import net.acecraft.mod.renderer.item.ItemRendererMotor;
import net.acecraft.mod.renderer.item.ItemRendererPipeCrossing;
import net.acecraft.mod.renderer.item.ItemRendererPipeCurve;
import net.acecraft.mod.renderer.item.ItemRendererPipeStraight;
import net.acecraft.mod.renderer.item.ItemRendererPodium;
import net.acecraft.mod.renderer.item.ItemRendererRoof;
import net.acecraft.mod.renderer.item.ItemRendererRope;
import net.acecraft.mod.renderer.item.ItemRendererScaffolding;
import net.acecraft.mod.renderer.item.ItemRendererSewingStation;
import net.acecraft.mod.renderer.item.ItemRendererSolarCollector;
import net.acecraft.mod.renderer.item.ItemRendererSteamVent;
import net.acecraft.mod.renderer.item.ItemRendererStove;
import net.acecraft.mod.renderer.item.ItemRendererTurbine;
import net.acecraft.mod.renderer.item.ItemRendererWaterwheel;
import net.acecraft.mod.renderer.item.ItemRendererWindmillLeather;
import net.acecraft.mod.renderer.item.ItemRendererWindmillWool;
import net.acecraft.mod.renderer.item.ItemRendererWorkbench;
import net.acecraft.mod.renderer.tile.RenderAnchor;
import net.acecraft.mod.renderer.tile.RenderAnvil;
import net.acecraft.mod.renderer.tile.RenderAxle;
import net.acecraft.mod.renderer.tile.RenderBattery;
import net.acecraft.mod.renderer.tile.RenderBellows;
import net.acecraft.mod.renderer.tile.RenderBlastFurnace;
import net.acecraft.mod.renderer.tile.RenderBoiler;
import net.acecraft.mod.renderer.tile.RenderBonfire;
import net.acecraft.mod.renderer.tile.RenderCable;
import net.acecraft.mod.renderer.tile.RenderDistillery;
import net.acecraft.mod.renderer.tile.RenderEnergyNode;
import net.acecraft.mod.renderer.tile.RenderFruitPress;
import net.acecraft.mod.renderer.tile.RenderGenerator;
import net.acecraft.mod.renderer.tile.RenderGlobe;
import net.acecraft.mod.renderer.tile.RenderIngotBasin;
import net.acecraft.mod.renderer.tile.RenderKeg;
import net.acecraft.mod.renderer.tile.RenderMillstone;
import net.acecraft.mod.renderer.tile.RenderMotor;
import net.acecraft.mod.renderer.tile.RenderPipeCrossing;
import net.acecraft.mod.renderer.tile.RenderPipeCurve;
import net.acecraft.mod.renderer.tile.RenderPipeStraight;
import net.acecraft.mod.renderer.tile.RenderPodium;
import net.acecraft.mod.renderer.tile.RenderRoof;
import net.acecraft.mod.renderer.tile.RenderRope;
import net.acecraft.mod.renderer.tile.RenderScaffolding;
import net.acecraft.mod.renderer.tile.RenderSewingStation;
import net.acecraft.mod.renderer.tile.RenderSolarCollector;
import net.acecraft.mod.renderer.tile.RenderSteamVent;
import net.acecraft.mod.renderer.tile.RenderStove;
import net.acecraft.mod.renderer.tile.RenderTurbine;
import net.acecraft.mod.renderer.tile.RenderWaterwheel;
import net.acecraft.mod.renderer.tile.RenderWindmillLeather;
import net.acecraft.mod.renderer.tile.RenderWindmillWool;
import net.acecraft.mod.renderer.tile.RenderWorkbench;
import net.acecraft.mod.tileentity.TileEntityAnchor;
import net.acecraft.mod.tileentity.TileEntityAnvil;
import net.acecraft.mod.tileentity.TileEntityAxle;
import net.acecraft.mod.tileentity.TileEntityBattery;
import net.acecraft.mod.tileentity.TileEntityBellows;
import net.acecraft.mod.tileentity.TileEntityBlastFurnace;
import net.acecraft.mod.tileentity.TileEntityBoiler;
import net.acecraft.mod.tileentity.TileEntityBonfire;
import net.acecraft.mod.tileentity.TileEntityCable;
import net.acecraft.mod.tileentity.TileEntityDistillery;
import net.acecraft.mod.tileentity.TileEntityEnergyNode;
import net.acecraft.mod.tileentity.TileEntityFruitPress;
import net.acecraft.mod.tileentity.TileEntityGenerator;
import net.acecraft.mod.tileentity.TileEntityGlobe;
import net.acecraft.mod.tileentity.TileEntityIngotBasin;
import net.acecraft.mod.tileentity.TileEntityKeg;
import net.acecraft.mod.tileentity.TileEntityMillstone;
import net.acecraft.mod.tileentity.TileEntityMotor;
import net.acecraft.mod.tileentity.TileEntityPipeCrossing;
import net.acecraft.mod.tileentity.TileEntityPipeCurve;
import net.acecraft.mod.tileentity.TileEntityPipeStraight;
import net.acecraft.mod.tileentity.TileEntityPodium;
import net.acecraft.mod.tileentity.TileEntityRoof;
import net.acecraft.mod.tileentity.TileEntityRope;
import net.acecraft.mod.tileentity.TileEntityScaffolding;
import net.acecraft.mod.tileentity.TileEntitySewingStation;
import net.acecraft.mod.tileentity.TileEntitySolarCollector;
import net.acecraft.mod.tileentity.TileEntitySteamVent;
import net.acecraft.mod.tileentity.TileEntityStove;
import net.acecraft.mod.tileentity.TileEntityTurbine;
import net.acecraft.mod.tileentity.TileEntityWaterwheel;
import net.acecraft.mod.tileentity.TileEntityWindmillLeather;
import net.acecraft.mod.tileentity.TileEntityWindmillWool;
import net.acecraft.mod.tileentity.TileEntityWorkbench;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
	
	public void registerRenderThings() {
		
		//BlastFurnace
		TileEntitySpecialRenderer renderBlastFurnace = new RenderBlastFurnace();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlastFurnace.class, renderBlastFurnace);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaBlastFurnaceIdle), new ItemRendererBlastFurnace(renderBlastFurnace, new TileEntityBlastFurnace()));
		
		//Workbench
		TileEntitySpecialRenderer renderWorkbench = new RenderWorkbench();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWorkbench.class, renderWorkbench);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaWorkbench), new ItemRendererWorkbench(renderWorkbench, new TileEntityWorkbench()));
		
		//SewingStation
		TileEntitySpecialRenderer renderSewingStation = new RenderSewingStation();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySewingStation.class, renderSewingStation);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaSewingStation), new ItemRendererSewingStation(renderSewingStation, new TileEntitySewingStation()));
		
		//AnvilIron
		TileEntitySpecialRenderer renderAnvilIron = new RenderAnvil("Iron");
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAnvil.class, renderAnvilIron);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaAnvilIron), new ItemRendererAnvil(renderAnvilIron, new TileEntityAnvil()));
		
		//AnvilCopper
		TileEntitySpecialRenderer renderAnvilCopper = new RenderAnvil("Copper");
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAnvil.class, renderAnvilCopper);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaAnvilCopper), new ItemRendererAnvil(renderAnvilCopper, new TileEntityAnvil()));
		
		//AnvilAluminium
		TileEntitySpecialRenderer renderAnvilAluminium = new RenderAnvil("Aluminium");
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAnvil.class, renderAnvilAluminium);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaAnvilAluminium), new ItemRendererAnvil(renderAnvilAluminium, new TileEntityAnvil()));
		
		//AnvilLead
		TileEntitySpecialRenderer renderAnvilLead = new RenderAnvil("Lead");
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAnvil.class, renderAnvilLead);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaAnvilLead), new ItemRendererAnvil(renderAnvilLead, new TileEntityAnvil()));
		
		//AnvilBronze
		TileEntitySpecialRenderer renderAnvilBronze = new RenderAnvil("Bronze");
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAnvil.class, renderAnvilBronze);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaAnvilBronze), new ItemRendererAnvil(renderAnvilBronze, new TileEntityAnvil()));
		
		//AnvilSteel
		TileEntitySpecialRenderer renderAnvilSteel = new RenderAnvil("Steel");
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAnvil.class, renderAnvilSteel);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaAnvilSteel), new ItemRendererAnvil(renderAnvilSteel, new TileEntityAnvil()));
		
		//AnvilMythril
		TileEntitySpecialRenderer renderAnvilMythril = new RenderAnvil("Mythril");
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAnvil.class, renderAnvilMythril);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaAnvilMythril), new ItemRendererAnvil(renderAnvilMythril, new TileEntityAnvil()));
		
		//AnvilAdamantium
		TileEntitySpecialRenderer renderAnvilAdamantium = new RenderAnvil("Adamantium");
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAnvil.class, renderAnvilAdamantium);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaAnvilAdamantium), new ItemRendererAnvil(renderAnvilAdamantium, new TileEntityAnvil()));
		
		//AnvilUnobtanium
		TileEntitySpecialRenderer renderAnvilUnobtanium = new RenderAnvil("Unobtanium");
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAnvil.class, renderAnvilUnobtanium);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaAnvilUnobtanium), new ItemRendererAnvil(renderAnvilUnobtanium, new TileEntityAnvil()));
		
		//Stove
		TileEntitySpecialRenderer renderStove = new RenderStove();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStove.class, renderStove);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaStove), new ItemRendererStove(renderStove, new TileEntityStove()));
		
		//Bonfire
		TileEntitySpecialRenderer renderBonfire = new RenderBonfire();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBonfire.class, renderBonfire);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaBonfireIdle), new ItemRendererBonfire(renderBonfire, new TileEntityBonfire()));
		
		//Keg
		TileEntitySpecialRenderer renderKeg = new RenderKeg();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityKeg.class, renderKeg);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaKeg), new ItemRendererKeg(renderKeg, new TileEntityKeg()));
				
		//IngotBasin
		TileEntitySpecialRenderer renderIngotBasin = new RenderIngotBasin();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityIngotBasin.class, renderIngotBasin);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaIngotBasin), new ItemRendererIngotBasin(renderIngotBasin, new TileEntityIngotBasin()));
		
				//Distillery
				TileEntitySpecialRenderer renderDistillery = new RenderDistillery();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDistillery.class, renderDistillery);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaDistilleryIdle), new ItemRendererDistillery(renderDistillery, new TileEntityDistillery()));
				
				//Anchor
				TileEntitySpecialRenderer renderAnchor = new RenderAnchor();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAnchor.class, renderAnchor);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaAnchor), new ItemRendererAnchor(renderAnchor, new TileEntityAnchor()));
				
				//Rope
				TileEntitySpecialRenderer renderRope = new RenderRope();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRope.class, renderRope);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaRope), new ItemRendererRope(renderRope, new TileEntityRope()));
				
				//Globe
				TileEntitySpecialRenderer renderGlobe = new RenderGlobe();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGlobe.class, renderGlobe);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaGlobe), new ItemRendererGlobe(renderGlobe, new TileEntityGlobe()));
				
				//Podium
				TileEntitySpecialRenderer renderPodium = new RenderPodium();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPodium.class, renderPodium);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaPodium), new ItemRendererPodium(renderPodium, new TileEntityPodium()));
				
				//WindmillWool
				TileEntitySpecialRenderer renderWindmillWool = new RenderWindmillWool();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWindmillWool.class, renderWindmillWool);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaWindmillWool), new ItemRendererWindmillWool(renderWindmillWool, new TileEntityWindmillWool()));
				
				//WindmillLeather
				TileEntitySpecialRenderer renderWindmillLeather = new RenderWindmillLeather();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWindmillLeather.class, renderWindmillLeather);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaWindmillLeather), new ItemRendererWindmillLeather(renderWindmillLeather, new TileEntityWindmillLeather()));
				
				//Waterwheel
				TileEntitySpecialRenderer renderWaterwheel = new RenderWaterwheel();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWaterwheel.class, renderWaterwheel);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaWaterwheel), new ItemRendererWaterwheel(renderWaterwheel, new TileEntityWaterwheel()));
				
				//Axle
				TileEntitySpecialRenderer renderAxle = new RenderAxle();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAxle.class, renderAxle);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaAxle), new ItemRendererAxle(renderAxle, new TileEntityAxle()));
				
				//FruitPress
				TileEntitySpecialRenderer renderFruitPress = new RenderFruitPress();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFruitPress.class, renderFruitPress);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaFruitPress), new ItemRendererFruitPress(renderFruitPress, new TileEntityFruitPress()));
				
				//Millstone
				TileEntitySpecialRenderer renderMillstone = new RenderMillstone();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMillstone.class, renderMillstone);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaMillstone), new ItemRendererMillstone(renderMillstone, new TileEntityMillstone()));
				
				//Boiler
				TileEntitySpecialRenderer renderBoiler = new RenderBoiler();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBoiler.class, renderBoiler);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaBoilerIdle), new ItemRendererBoiler(renderBoiler, new TileEntityBoiler()));
				
				//PipeStraightLead
				TileEntitySpecialRenderer renderPipeStraightLead = new RenderPipeStraight("Lead");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPipeStraight.class, renderPipeStraightLead);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaPipeStraightLead), new ItemRendererPipeStraight(renderPipeStraightLead, new TileEntityPipeStraight()));
				
				//PipeCurveLead
				TileEntitySpecialRenderer renderPipeCurveLead = new RenderPipeCurve("Lead");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPipeCurve.class, renderPipeCurveLead);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaPipeCurveLead), new ItemRendererPipeCurve(renderPipeCurveLead, new TileEntityPipeCurve()));
				
				//PipeCrossingLead
				TileEntitySpecialRenderer renderPipeCrossingLead = new RenderPipeCrossing("Lead");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPipeCrossing.class, renderPipeCrossingLead);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaPipeCrossingLead), new ItemRendererPipeCrossing(renderPipeCrossingLead, new TileEntityPipeCrossing()));
				
				//PipeStraightBronze
				TileEntitySpecialRenderer renderPipeStraightBronze = new RenderPipeStraight("Bronze");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPipeStraight.class, renderPipeStraightBronze);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaPipeStraightBronze), new ItemRendererPipeStraight(renderPipeStraightBronze, new TileEntityPipeStraight()));
				
				//PipeCurveBronze
				TileEntitySpecialRenderer renderPipeCurveBronze = new RenderPipeCurve("Bronze");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPipeCurve.class, renderPipeCurveBronze);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaPipeCurveBronze), new ItemRendererPipeCurve(renderPipeCurveBronze, new TileEntityPipeCurve()));
				
				//PipeCrossingBronze
				TileEntitySpecialRenderer renderPipeCrossingBronze = new RenderPipeCrossing("Bronze");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPipeCrossing.class, renderPipeCrossingBronze);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaPipeCrossingBronze), new ItemRendererPipeCrossing(renderPipeCrossingBronze, new TileEntityPipeCrossing()));
				
				//SteamVentLead
				TileEntitySpecialRenderer renderSteamVentLead = new RenderSteamVent();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySteamVent.class, renderSteamVentLead);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaSteamVentLead), new ItemRendererSteamVent(renderSteamVentLead, new TileEntitySteamVent()));
				
				//SteamVentBronze
				TileEntitySpecialRenderer renderSteamVentBronze = new RenderSteamVent();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySteamVent.class, renderSteamVentBronze);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaSteamVentBronze), new ItemRendererSteamVent(renderSteamVentBronze, new TileEntitySteamVent()));
				
				//Turbine
				TileEntitySpecialRenderer renderTurbine = new RenderTurbine();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTurbine.class, renderTurbine);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaTurbine), new ItemRendererTurbine(renderTurbine, new TileEntityTurbine()));
				
				//Generator
				TileEntitySpecialRenderer renderGenerator = new RenderGenerator();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGenerator.class, renderGenerator);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaGenerator), new ItemRendererGenerator(renderGenerator, new TileEntityGenerator()));
				
				//Bellows
				TileEntitySpecialRenderer renderBellows = new RenderBellows();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBellows.class, renderBellows);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaBellows), new ItemRendererBellows(renderBellows, new TileEntityBellows()));
				
				//SolarCollector
				TileEntitySpecialRenderer renderSolarCollector = new RenderSolarCollector();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySolarCollector.class, renderSolarCollector);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaSolarCollector), new ItemRendererSolarCollector(renderSolarCollector, new TileEntitySolarCollector()));
				
				//Cable
				TileEntitySpecialRenderer renderCable = new RenderCable();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCable.class, renderCable);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaCable), new ItemRendererCable(renderCable, new TileEntityCable()));
				
				//EnergyNode
				TileEntitySpecialRenderer renderEnergyNode = new RenderEnergyNode();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityEnergyNode.class, renderEnergyNode);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaEnergyNode), new ItemRendererEnergyNode(renderEnergyNode, new TileEntityEnergyNode()));
				
				//Battery
				TileEntitySpecialRenderer renderBattery = new RenderBattery();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBattery.class, renderBattery);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaBattery), new ItemRendererBattery(renderBattery, new TileEntityBattery()));
				
				//Motor
				TileEntitySpecialRenderer renderMotor = new RenderMotor();
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMotor.class, renderMotor);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.machinaMotor), new ItemRendererMotor(renderMotor, new TileEntityMotor()));
				
				
				//Scaffolding
				TileEntitySpecialRenderer renderScaffoldingAcacia = new RenderScaffolding("Acacia");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityScaffolding.class, renderScaffoldingAcacia);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.scaffoldingAcacia), new ItemRendererScaffolding(renderScaffoldingAcacia, new TileEntityScaffolding()));
				
				TileEntitySpecialRenderer renderScaffoldingBigOak = new RenderScaffolding("BigOak");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityScaffolding.class, renderScaffoldingBigOak);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.scaffoldingBigOak), new ItemRendererScaffolding(renderScaffoldingBigOak, new TileEntityScaffolding()));
				
				TileEntitySpecialRenderer renderScaffoldingBirch = new RenderScaffolding("Birch");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityScaffolding.class, renderScaffoldingBirch);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.scaffoldingBirch), new ItemRendererScaffolding(renderScaffoldingBirch, new TileEntityScaffolding()));
				
				TileEntitySpecialRenderer renderScaffoldingJungle = new RenderScaffolding("Jungle");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityScaffolding.class, renderScaffoldingJungle);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.scaffoldingJungle), new ItemRendererScaffolding(renderScaffoldingJungle, new TileEntityScaffolding()));
				
				TileEntitySpecialRenderer renderScaffoldingOak = new RenderScaffolding("Oak");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityScaffolding.class, renderScaffoldingOak);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.scaffoldingOak), new ItemRendererScaffolding(renderScaffoldingOak, new TileEntityScaffolding()));
				
				TileEntitySpecialRenderer renderScaffoldingSpruce = new RenderScaffolding("Spruce");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityScaffolding.class, renderScaffoldingSpruce);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.scaffoldingSpruce), new ItemRendererScaffolding(renderScaffoldingSpruce, new TileEntityScaffolding()));
				
				TileEntitySpecialRenderer renderScaffoldingFruit = new RenderScaffolding("Fruit");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityScaffolding.class, renderScaffoldingFruit);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.scaffoldingFruit), new ItemRendererScaffolding(renderScaffoldingFruit, new TileEntityScaffolding()));
				
				TileEntitySpecialRenderer renderScaffoldingGolden = new RenderScaffolding("Golden");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityScaffolding.class, renderScaffoldingGolden);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.scaffoldingGolden), new ItemRendererScaffolding(renderScaffoldingGolden, new TileEntityScaffolding()));
				
				TileEntitySpecialRenderer renderScaffoldingPalm = new RenderScaffolding("Palm");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityScaffolding.class, renderScaffoldingPalm);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.scaffoldingPalm), new ItemRendererScaffolding(renderScaffoldingPalm, new TileEntityScaffolding()));
				
				TileEntitySpecialRenderer renderScaffoldingAdamantium = new RenderScaffolding("Adamantium");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityScaffolding.class, renderScaffoldingAdamantium);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.scaffoldingAdamantium), new ItemRendererScaffolding(renderScaffoldingAdamantium, new TileEntityScaffolding()));
				
				TileEntitySpecialRenderer renderScaffoldingAluminium = new RenderScaffolding("Aluminium");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityScaffolding.class, renderScaffoldingAluminium);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.scaffoldingAluminium), new ItemRendererScaffolding(renderScaffoldingAluminium, new TileEntityScaffolding()));
				
				TileEntitySpecialRenderer renderScaffoldingBronze = new RenderScaffolding("Bronze");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityScaffolding.class, renderScaffoldingBronze);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.scaffoldingBronze), new ItemRendererScaffolding(renderScaffoldingBronze, new TileEntityScaffolding()));
				
				TileEntitySpecialRenderer renderScaffoldingCopper = new RenderScaffolding("Copper");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityScaffolding.class, renderScaffoldingCopper);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.scaffoldingCopper), new ItemRendererScaffolding(renderScaffoldingCopper, new TileEntityScaffolding()));
				
				TileEntitySpecialRenderer renderScaffoldingIron = new RenderScaffolding("Iron");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityScaffolding.class, renderScaffoldingIron);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.scaffoldingIron), new ItemRendererScaffolding(renderScaffoldingIron, new TileEntityScaffolding()));
				
				TileEntitySpecialRenderer renderScaffoldingMythril = new RenderScaffolding("Mythril");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityScaffolding.class, renderScaffoldingMythril);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.scaffoldingMythril), new ItemRendererScaffolding(renderScaffoldingMythril, new TileEntityScaffolding()));
				
				TileEntitySpecialRenderer renderScaffoldingSteel = new RenderScaffolding("Steel");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityScaffolding.class, renderScaffoldingSteel);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.scaffoldingSteel), new ItemRendererScaffolding(renderScaffoldingSteel, new TileEntityScaffolding()));
				
				TileEntitySpecialRenderer renderScaffoldingUnobtanium = new RenderScaffolding("Unobtanium");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityScaffolding.class, renderScaffoldingUnobtanium);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.scaffoldingUnobtanium), new ItemRendererScaffolding(renderScaffoldingUnobtanium, new TileEntityScaffolding()));
				
				//Roof
				TileEntitySpecialRenderer renderRoofAcaciaStraw = new RenderRoof("Acacia", "Straw");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofAcaciaStraw);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofAcaciaStraw), new ItemRendererRoof(renderRoofAcaciaStraw, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofAcaciaReeds = new RenderRoof("Acacia", "Reeds");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofAcaciaReeds);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofAcaciaReeds), new ItemRendererRoof(renderRoofAcaciaReeds, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofAcaciaClay = new RenderRoof("Acacia", "Clay");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofAcaciaClay);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofAcaciaClay), new ItemRendererRoof(renderRoofAcaciaClay, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofAcaciaCopper = new RenderRoof("Acacia", "Copper");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofAcaciaCopper);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofAcaciaCopper), new ItemRendererRoof(renderRoofAcaciaCopper, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofAcaciaTin = new RenderRoof("Acacia", "Tin");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofAcaciaTin);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofAcaciaTin), new ItemRendererRoof(renderRoofAcaciaTin, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofAcaciaBrass = new RenderRoof("Acacia", "Brass");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofAcaciaBrass);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofAcaciaBrass), new ItemRendererRoof(renderRoofAcaciaBrass, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofAcaciaGold = new RenderRoof("Acacia", "Gold");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofAcaciaGold);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofAcaciaGold), new ItemRendererRoof(renderRoofAcaciaGold, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofAcaciaMythril = new RenderRoof("Acacia", "Mythril");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofAcaciaMythril);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofAcaciaMythril), new ItemRendererRoof(renderRoofAcaciaMythril, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofAcaciaOrichalcum = new RenderRoof("Acacia", "Orichalcum");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofAcaciaOrichalcum);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofAcaciaOrichalcum), new ItemRendererRoof(renderRoofAcaciaOrichalcum, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofAcaciaNether = new RenderRoof("Acacia", "Nether");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofAcaciaNether);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofAcaciaNether), new ItemRendererRoof(renderRoofAcaciaNether, new TileEntityRoof()));
				
				TileEntitySpecialRenderer renderRoofBigOakStraw = new RenderRoof("BigOak", "Straw");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofBigOakStraw);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofBigOakStraw), new ItemRendererRoof(renderRoofBigOakStraw, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofBigOakReeds = new RenderRoof("BigOak", "Reeds");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofBigOakReeds);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofBigOakReeds), new ItemRendererRoof(renderRoofBigOakReeds, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofBigOakClay = new RenderRoof("BigOak", "Clay");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofBigOakClay);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofBigOakClay), new ItemRendererRoof(renderRoofBigOakClay, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofBigOakCopper = new RenderRoof("BigOak", "Copper");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofBigOakCopper);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofBigOakCopper), new ItemRendererRoof(renderRoofBigOakCopper, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofBigOakTin = new RenderRoof("BigOak", "Tin");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofBigOakTin);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofBigOakTin), new ItemRendererRoof(renderRoofBigOakTin, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofBigOakBrass = new RenderRoof("BigOak", "Brass");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofBigOakBrass);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofBigOakBrass), new ItemRendererRoof(renderRoofBigOakBrass, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofBigOakGold = new RenderRoof("BigOak", "Gold");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofBigOakGold);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofBigOakGold), new ItemRendererRoof(renderRoofBigOakGold, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofBigOakMythril = new RenderRoof("BigOak", "Mythril");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofBigOakMythril);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofBigOakMythril), new ItemRendererRoof(renderRoofBigOakMythril, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofBigOakOrichalcum = new RenderRoof("BigOak", "Orichalcum");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofBigOakOrichalcum);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofBigOakOrichalcum), new ItemRendererRoof(renderRoofBigOakOrichalcum, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofBigOakNether = new RenderRoof("BigOak", "Nether");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofBigOakNether);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofBigOakNether), new ItemRendererRoof(renderRoofBigOakNether, new TileEntityRoof()));
				
				TileEntitySpecialRenderer renderRoofBirchStraw = new RenderRoof("Birch", "Straw");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofBirchStraw);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofBirchStraw), new ItemRendererRoof(renderRoofBirchStraw, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofBirchReeds = new RenderRoof("Birch", "Reeds");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofBirchReeds);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofBirchReeds), new ItemRendererRoof(renderRoofBirchReeds, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofBirchClay = new RenderRoof("Birch", "Clay");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofBirchClay);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofBirchClay), new ItemRendererRoof(renderRoofBirchClay, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofBirchCopper = new RenderRoof("Birch", "Copper");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofBirchCopper);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofBirchCopper), new ItemRendererRoof(renderRoofBirchCopper, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofBirchTin = new RenderRoof("Birch", "Tin");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofBirchTin);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofBirchTin), new ItemRendererRoof(renderRoofBirchTin, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofBirchBrass = new RenderRoof("Birch", "Brass");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofBirchBrass);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofBirchBrass), new ItemRendererRoof(renderRoofBirchBrass, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofBirchGold = new RenderRoof("Birch", "Gold");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofBirchGold);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofBirchGold), new ItemRendererRoof(renderRoofBirchGold, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofBirchMythril = new RenderRoof("Birch", "Mythril");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofBirchMythril);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofBirchMythril), new ItemRendererRoof(renderRoofBirchMythril, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofBirchOrichalcum = new RenderRoof("Birch", "Orichalcum");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofBirchOrichalcum);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofBirchOrichalcum), new ItemRendererRoof(renderRoofBirchOrichalcum, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofBirchNether = new RenderRoof("Birch", "Nether");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofBirchNether);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofBirchNether), new ItemRendererRoof(renderRoofBirchNether, new TileEntityRoof()));
				
				TileEntitySpecialRenderer renderRoofJungleStraw = new RenderRoof("Jungle", "Straw");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofJungleStraw);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofJungleStraw), new ItemRendererRoof(renderRoofJungleStraw, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofJungleReeds = new RenderRoof("Jungle", "Reeds");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofJungleReeds);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofJungleReeds), new ItemRendererRoof(renderRoofJungleReeds, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofJungleClay = new RenderRoof("Jungle", "Clay");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofJungleClay);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofJungleClay), new ItemRendererRoof(renderRoofJungleClay, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofJungleCopper = new RenderRoof("Jungle", "Copper");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofJungleCopper);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofJungleCopper), new ItemRendererRoof(renderRoofJungleCopper, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofJungleTin = new RenderRoof("Jungle", "Tin");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofJungleTin);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofJungleTin), new ItemRendererRoof(renderRoofJungleTin, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofJungleBrass = new RenderRoof("Jungle", "Brass");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofJungleBrass);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofJungleBrass), new ItemRendererRoof(renderRoofJungleBrass, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofJungleGold = new RenderRoof("Jungle", "Gold");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofJungleGold);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofJungleGold), new ItemRendererRoof(renderRoofJungleGold, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofJungleMythril = new RenderRoof("Jungle", "Mythril");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofJungleMythril);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofJungleMythril), new ItemRendererRoof(renderRoofJungleMythril, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofJungleOrichalcum = new RenderRoof("Jungle", "Orichalcum");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofJungleOrichalcum);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofJungleOrichalcum), new ItemRendererRoof(renderRoofJungleOrichalcum, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofJungleNether = new RenderRoof("Jungle", "Nether");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofJungleNether);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofJungleNether), new ItemRendererRoof(renderRoofJungleNether, new TileEntityRoof()));
				
				TileEntitySpecialRenderer renderRoofOakStraw = new RenderRoof("Oak", "Straw");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofOakStraw);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofOakStraw), new ItemRendererRoof(renderRoofOakStraw, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofOakReeds = new RenderRoof("Oak", "Reeds");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofOakReeds);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofOakReeds), new ItemRendererRoof(renderRoofOakReeds, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofOakClay = new RenderRoof("Oak", "Clay");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofOakClay);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofOakClay), new ItemRendererRoof(renderRoofOakClay, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofOakCopper = new RenderRoof("Oak", "Copper");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofOakCopper);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofOakCopper), new ItemRendererRoof(renderRoofOakCopper, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofOakTin = new RenderRoof("Oak", "Tin");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofOakTin);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofOakTin), new ItemRendererRoof(renderRoofOakTin, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofOakBrass = new RenderRoof("Oak", "Brass");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofOakBrass);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofOakBrass), new ItemRendererRoof(renderRoofOakBrass, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofOakGold = new RenderRoof("Oak", "Gold");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofOakGold);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofOakGold), new ItemRendererRoof(renderRoofOakGold, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofOakMythril = new RenderRoof("Oak", "Mythril");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofOakMythril);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofOakMythril), new ItemRendererRoof(renderRoofOakMythril, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofOakOrichalcum = new RenderRoof("Oak", "Orichalcum");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofOakOrichalcum);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofOakOrichalcum), new ItemRendererRoof(renderRoofOakOrichalcum, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofOakNether = new RenderRoof("Oak", "Nether");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofOakNether);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofOakNether), new ItemRendererRoof(renderRoofOakNether, new TileEntityRoof()));
				
				TileEntitySpecialRenderer renderRoofSpruceStraw = new RenderRoof("Spruce", "Straw");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofSpruceStraw);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofSpruceStraw), new ItemRendererRoof(renderRoofSpruceStraw, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofSpruceReeds = new RenderRoof("Spruce", "Reeds");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofSpruceReeds);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofSpruceReeds), new ItemRendererRoof(renderRoofSpruceReeds, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofSpruceClay = new RenderRoof("Spruce", "Clay");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofSpruceClay);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofSpruceClay), new ItemRendererRoof(renderRoofSpruceClay, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofSpruceCopper = new RenderRoof("Spruce", "Copper");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofSpruceCopper);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofSpruceCopper), new ItemRendererRoof(renderRoofSpruceCopper, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofSpruceTin = new RenderRoof("Spruce", "Tin");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofSpruceTin);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofSpruceTin), new ItemRendererRoof(renderRoofSpruceTin, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofSpruceBrass = new RenderRoof("Spruce", "Brass");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofSpruceBrass);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofSpruceBrass), new ItemRendererRoof(renderRoofSpruceBrass, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofSpruceGold = new RenderRoof("Spruce", "Gold");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofSpruceGold);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofSpruceGold), new ItemRendererRoof(renderRoofSpruceGold, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofSpruceMythril = new RenderRoof("Spruce", "Mythril");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofSpruceMythril);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofSpruceMythril), new ItemRendererRoof(renderRoofSpruceMythril, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofSpruceOrichalcum = new RenderRoof("Spruce", "Orichalcum");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofSpruceOrichalcum);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofSpruceOrichalcum), new ItemRendererRoof(renderRoofSpruceOrichalcum, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofSpruceNether = new RenderRoof("Spruce", "Nether");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofSpruceNether);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofSpruceNether), new ItemRendererRoof(renderRoofSpruceNether, new TileEntityRoof()));
				
				TileEntitySpecialRenderer renderRoofFruitStraw = new RenderRoof("Fruit", "Straw");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofFruitStraw);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofFruitStraw), new ItemRendererRoof(renderRoofFruitStraw, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofFruitReeds = new RenderRoof("Fruit", "Reeds");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofFruitReeds);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofFruitReeds), new ItemRendererRoof(renderRoofFruitReeds, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofFruitClay = new RenderRoof("Fruit", "Clay");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofFruitClay);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofFruitClay), new ItemRendererRoof(renderRoofFruitClay, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofFruitCopper = new RenderRoof("Fruit", "Copper");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofFruitCopper);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofFruitCopper), new ItemRendererRoof(renderRoofFruitCopper, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofFruitTin = new RenderRoof("Fruit", "Tin");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofFruitTin);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofFruitTin), new ItemRendererRoof(renderRoofFruitTin, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofFruitBrass = new RenderRoof("Fruit", "Brass");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofFruitBrass);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofFruitBrass), new ItemRendererRoof(renderRoofFruitBrass, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofFruitGold = new RenderRoof("Fruit", "Gold");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofFruitGold);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofFruitGold), new ItemRendererRoof(renderRoofFruitGold, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofFruitMythril = new RenderRoof("Fruit", "Mythril");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofFruitMythril);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofFruitMythril), new ItemRendererRoof(renderRoofFruitMythril, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofFruitOrichalcum = new RenderRoof("Fruit", "Orichalcum");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofFruitOrichalcum);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofFruitOrichalcum), new ItemRendererRoof(renderRoofFruitOrichalcum, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofFruitNether = new RenderRoof("Fruit", "Nether");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofFruitNether);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofFruitNether), new ItemRendererRoof(renderRoofFruitNether, new TileEntityRoof()));
				
				TileEntitySpecialRenderer renderRoofGoldenStraw = new RenderRoof("Golden", "Straw");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofGoldenStraw);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofGoldenStraw), new ItemRendererRoof(renderRoofGoldenStraw, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofGoldenReeds = new RenderRoof("Golden", "Reeds");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofGoldenReeds);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofGoldenReeds), new ItemRendererRoof(renderRoofGoldenReeds, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofGoldenClay = new RenderRoof("Golden", "Clay");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofGoldenClay);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofGoldenClay), new ItemRendererRoof(renderRoofGoldenClay, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofGoldenCopper = new RenderRoof("Golden", "Copper");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofGoldenCopper);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofGoldenCopper), new ItemRendererRoof(renderRoofGoldenCopper, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofGoldenTin = new RenderRoof("Golden", "Tin");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofGoldenTin);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofGoldenTin), new ItemRendererRoof(renderRoofGoldenTin, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofGoldenBrass = new RenderRoof("Golden", "Brass");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofGoldenBrass);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofGoldenBrass), new ItemRendererRoof(renderRoofGoldenBrass, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofGoldenGold = new RenderRoof("Golden", "Gold");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofGoldenGold);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofGoldenGold), new ItemRendererRoof(renderRoofGoldenGold, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofGoldenMythril = new RenderRoof("Golden", "Mythril");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofGoldenMythril);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofGoldenMythril), new ItemRendererRoof(renderRoofGoldenMythril, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofGoldenOrichalcum = new RenderRoof("Golden", "Orichalcum");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofGoldenOrichalcum);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofGoldenOrichalcum), new ItemRendererRoof(renderRoofGoldenOrichalcum, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofGoldenNether = new RenderRoof("Golden", "Nether");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofGoldenNether);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofGoldenNether), new ItemRendererRoof(renderRoofGoldenNether, new TileEntityRoof()));
				
				TileEntitySpecialRenderer renderRoofPalmStraw = new RenderRoof("Palm", "Straw");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofPalmStraw);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofPalmStraw), new ItemRendererRoof(renderRoofPalmStraw, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofPalmReeds = new RenderRoof("Palm", "Reeds");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofPalmReeds);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofPalmReeds), new ItemRendererRoof(renderRoofPalmReeds, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofPalmClay = new RenderRoof("Palm", "Clay");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofPalmClay);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofPalmClay), new ItemRendererRoof(renderRoofPalmClay, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofPalmCopper = new RenderRoof("Palm", "Copper");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofPalmCopper);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofPalmCopper), new ItemRendererRoof(renderRoofPalmCopper, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofPalmTin = new RenderRoof("Palm", "Tin");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofPalmTin);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofPalmTin), new ItemRendererRoof(renderRoofPalmTin, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofPalmBrass = new RenderRoof("Palm", "Brass");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofPalmBrass);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofPalmBrass), new ItemRendererRoof(renderRoofPalmBrass, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofPalmGold = new RenderRoof("Palm", "Gold");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofPalmGold);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofPalmGold), new ItemRendererRoof(renderRoofPalmGold, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofPalmMythril = new RenderRoof("Palm", "Mythril");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofPalmMythril);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofPalmMythril), new ItemRendererRoof(renderRoofPalmMythril, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofPalmOrichalcum = new RenderRoof("Palm", "Orichalcum");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofPalmOrichalcum);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofPalmOrichalcum), new ItemRendererRoof(renderRoofPalmOrichalcum, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofPalmNether = new RenderRoof("Palm", "Nether");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofPalmNether);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofPalmNether), new ItemRendererRoof(renderRoofPalmNether, new TileEntityRoof()));
				
				TileEntitySpecialRenderer renderRoofBrickStraw = new RenderRoof("Brick", "Straw");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofBrickStraw);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofBrickStraw), new ItemRendererRoof(renderRoofBrickStraw, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofBrickReeds = new RenderRoof("Brick", "Reeds");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofBrickReeds);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofBrickReeds), new ItemRendererRoof(renderRoofBrickReeds, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofBrickClay = new RenderRoof("Brick", "Clay");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofBrickClay);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofBrickClay), new ItemRendererRoof(renderRoofBrickClay, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofBrickCopper = new RenderRoof("Brick", "Copper");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofBrickCopper);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofBrickCopper), new ItemRendererRoof(renderRoofBrickCopper, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofBrickTin = new RenderRoof("Brick", "Tin");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofBrickTin);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofBrickTin), new ItemRendererRoof(renderRoofBrickTin, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofBrickBrass = new RenderRoof("Brick", "Brass");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofBrickBrass);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofBrickBrass), new ItemRendererRoof(renderRoofBrickBrass, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofBrickGold = new RenderRoof("Brick", "Gold");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofBrickGold);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofBrickGold), new ItemRendererRoof(renderRoofBrickGold, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofBrickMythril = new RenderRoof("Brick", "Mythril");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofBrickMythril);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofBrickMythril), new ItemRendererRoof(renderRoofBrickMythril, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofBrickOrichalcum = new RenderRoof("Brick", "Orichalcum");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofBrickOrichalcum);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofBrickOrichalcum), new ItemRendererRoof(renderRoofBrickOrichalcum, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofBrickNether = new RenderRoof("Brick", "Nether");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofBrickNether);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofBrickNether), new ItemRendererRoof(renderRoofBrickNether, new TileEntityRoof()));
				
				TileEntitySpecialRenderer renderRoofCobblestoneStraw = new RenderRoof("Cobblestone", "Straw");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofCobblestoneStraw);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofCobblestoneStraw), new ItemRendererRoof(renderRoofCobblestoneStraw, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofCobblestoneReeds = new RenderRoof("Cobblestone", "Reeds");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofCobblestoneReeds);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofCobblestoneReeds), new ItemRendererRoof(renderRoofCobblestoneReeds, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofCobblestoneClay = new RenderRoof("Cobblestone", "Clay");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofCobblestoneClay);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofCobblestoneClay), new ItemRendererRoof(renderRoofCobblestoneClay, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofCobblestoneCopper = new RenderRoof("Cobblestone", "Copper");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofCobblestoneCopper);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofCobblestoneCopper), new ItemRendererRoof(renderRoofCobblestoneCopper, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofCobblestoneTin = new RenderRoof("Cobblestone", "Tin");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofCobblestoneTin);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofCobblestoneTin), new ItemRendererRoof(renderRoofCobblestoneTin, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofCobblestoneBrass = new RenderRoof("Cobblestone", "Brass");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofCobblestoneBrass);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofCobblestoneBrass), new ItemRendererRoof(renderRoofCobblestoneBrass, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofCobblestoneGold = new RenderRoof("Cobblestone", "Gold");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofCobblestoneGold);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofCobblestoneGold), new ItemRendererRoof(renderRoofCobblestoneGold, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofCobblestoneMythril = new RenderRoof("Cobblestone", "Mythril");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofCobblestoneMythril);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofCobblestoneMythril), new ItemRendererRoof(renderRoofCobblestoneMythril, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofCobblestoneOrichalcum = new RenderRoof("Cobblestone", "Orichalcum");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofCobblestoneOrichalcum);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofCobblestoneOrichalcum), new ItemRendererRoof(renderRoofCobblestoneOrichalcum, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofCobblestoneNether = new RenderRoof("Cobblestone", "Nether");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofCobblestoneNether);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofCobblestoneNether), new ItemRendererRoof(renderRoofCobblestoneNether, new TileEntityRoof()));
				
				TileEntitySpecialRenderer renderRoofCobblestoneMossyStraw = new RenderRoof("CobblestoneMossy", "Straw");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofCobblestoneMossyStraw);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofCobblestoneMossyStraw), new ItemRendererRoof(renderRoofCobblestoneMossyStraw, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofCobblestoneMossyReeds = new RenderRoof("CobblestoneMossy", "Reeds");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofCobblestoneMossyReeds);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofCobblestoneMossyReeds), new ItemRendererRoof(renderRoofCobblestoneMossyReeds, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofCobblestoneMossyClay = new RenderRoof("CobblestoneMossy", "Clay");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofCobblestoneMossyClay);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofCobblestoneMossyClay), new ItemRendererRoof(renderRoofCobblestoneMossyClay, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofCobblestoneMossyCopper = new RenderRoof("CobblestoneMossy", "Copper");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofCobblestoneMossyCopper);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofCobblestoneMossyCopper), new ItemRendererRoof(renderRoofCobblestoneMossyCopper, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofCobblestoneMossyTin = new RenderRoof("CobblestoneMossy", "Tin");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofCobblestoneMossyTin);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofCobblestoneMossyTin), new ItemRendererRoof(renderRoofCobblestoneMossyTin, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofCobblestoneMossyBrass = new RenderRoof("CobblestoneMossy", "Brass");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofCobblestoneMossyBrass);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofCobblestoneMossyBrass), new ItemRendererRoof(renderRoofCobblestoneMossyBrass, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofCobblestoneMossyGold = new RenderRoof("CobblestoneMossy", "Gold");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofCobblestoneMossyGold);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofCobblestoneMossyGold), new ItemRendererRoof(renderRoofCobblestoneMossyGold, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofCobblestoneMossyMythril = new RenderRoof("CobblestoneMossy", "Mythril");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofCobblestoneMossyMythril);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofCobblestoneMossyMythril), new ItemRendererRoof(renderRoofCobblestoneMossyMythril, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofCobblestoneMossyOrichalcum = new RenderRoof("CobblestoneMossy", "Orichalcum");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofCobblestoneMossyOrichalcum);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofCobblestoneMossyOrichalcum), new ItemRendererRoof(renderRoofCobblestoneMossyOrichalcum, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofCobblestoneMossyNether = new RenderRoof("CobblestoneMossy", "Nether");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofCobblestoneMossyNether);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofCobblestoneMossyNether), new ItemRendererRoof(renderRoofCobblestoneMossyNether, new TileEntityRoof()));
				
				TileEntitySpecialRenderer renderRoofStonebrickStraw = new RenderRoof("Stonebrick", "Straw");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofStonebrickStraw);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofStonebrickStraw), new ItemRendererRoof(renderRoofStonebrickStraw, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofStonebrickReeds = new RenderRoof("Stonebrick", "Reeds");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofStonebrickReeds);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofStonebrickReeds), new ItemRendererRoof(renderRoofStonebrickReeds, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofStonebrickClay = new RenderRoof("Stonebrick", "Clay");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofStonebrickClay);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofStonebrickClay), new ItemRendererRoof(renderRoofStonebrickClay, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofStonebrickCopper = new RenderRoof("Stonebrick", "Copper");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofStonebrickCopper);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofStonebrickCopper), new ItemRendererRoof(renderRoofStonebrickCopper, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofStonebrickTin = new RenderRoof("Stonebrick", "Tin");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofStonebrickTin);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofStonebrickTin), new ItemRendererRoof(renderRoofStonebrickTin, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofStonebrickBrass = new RenderRoof("Stonebrick", "Brass");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofStonebrickBrass);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofStonebrickBrass), new ItemRendererRoof(renderRoofStonebrickBrass, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofStonebrickGold = new RenderRoof("Stonebrick", "Gold");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofStonebrickGold);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofStonebrickGold), new ItemRendererRoof(renderRoofStonebrickGold, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofStonebrickMythril = new RenderRoof("Stonebrick", "Mythril");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofStonebrickMythril);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofStonebrickMythril), new ItemRendererRoof(renderRoofStonebrickMythril, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofStonebrickOrichalcum = new RenderRoof("Stonebrick", "Orichalcum");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofStonebrickOrichalcum);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofStonebrickOrichalcum), new ItemRendererRoof(renderRoofStonebrickOrichalcum, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofStonebrickNether = new RenderRoof("Stonebrick", "Nether");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofStonebrickNether);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofStonebrickNether), new ItemRendererRoof(renderRoofStonebrickNether, new TileEntityRoof()));
				
				TileEntitySpecialRenderer renderRoofStonebrickMossyStraw = new RenderRoof("StonebrickMossy", "Straw");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofStonebrickMossyStraw);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofStonebrickMossyStraw), new ItemRendererRoof(renderRoofStonebrickMossyStraw, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofStonebrickMossyReeds = new RenderRoof("StonebrickMossy", "Reeds");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofStonebrickMossyReeds);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofStonebrickMossyReeds), new ItemRendererRoof(renderRoofStonebrickMossyReeds, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofStonebrickMossyClay = new RenderRoof("StonebrickMossy", "Clay");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofStonebrickMossyClay);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofStonebrickMossyClay), new ItemRendererRoof(renderRoofStonebrickMossyClay, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofStonebrickMossyCopper = new RenderRoof("StonebrickMossy", "Copper");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofStonebrickMossyCopper);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofStonebrickMossyCopper), new ItemRendererRoof(renderRoofStonebrickMossyCopper, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofStonebrickMossyTin = new RenderRoof("StonebrickMossy", "Tin");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofStonebrickMossyTin);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofStonebrickMossyTin), new ItemRendererRoof(renderRoofStonebrickMossyTin, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofStonebrickMossyBrass = new RenderRoof("StonebrickMossy", "Brass");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofStonebrickMossyBrass);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofStonebrickMossyBrass), new ItemRendererRoof(renderRoofStonebrickMossyBrass, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofStonebrickMossyGold = new RenderRoof("StonebrickMossy", "Gold");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofStonebrickMossyGold);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofStonebrickMossyGold), new ItemRendererRoof(renderRoofStonebrickMossyGold, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofStonebrickMossyMythril = new RenderRoof("StonebrickMossy", "Mythril");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofStonebrickMossyMythril);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofStonebrickMossyMythril), new ItemRendererRoof(renderRoofStonebrickMossyMythril, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofStonebrickMossyOrichalcum = new RenderRoof("StonebrickMossy", "Orichalcum");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofStonebrickMossyOrichalcum);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofStonebrickMossyOrichalcum), new ItemRendererRoof(renderRoofStonebrickMossyOrichalcum, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofStonebrickMossyNether = new RenderRoof("StonebrickMossy", "Nether");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofStonebrickMossyNether);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofStonebrickMossyNether), new ItemRendererRoof(renderRoofStonebrickMossyNether, new TileEntityRoof()));
				
				TileEntitySpecialRenderer renderRoofSandstoneStraw = new RenderRoof("Sandstone", "Straw");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofSandstoneStraw);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofSandstoneStraw), new ItemRendererRoof(renderRoofSandstoneStraw, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofSandstoneReeds = new RenderRoof("Sandstone", "Reeds");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofSandstoneReeds);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofSandstoneReeds), new ItemRendererRoof(renderRoofSandstoneReeds, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofSandstoneClay = new RenderRoof("Sandstone", "Clay");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofSandstoneClay);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofSandstoneClay), new ItemRendererRoof(renderRoofSandstoneClay, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofSandstoneCopper = new RenderRoof("Sandstone", "Copper");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofSandstoneCopper);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofSandstoneCopper), new ItemRendererRoof(renderRoofSandstoneCopper, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofSandstoneTin = new RenderRoof("Sandstone", "Tin");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofSandstoneTin);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofSandstoneTin), new ItemRendererRoof(renderRoofSandstoneTin, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofSandstoneBrass = new RenderRoof("Sandstone", "Brass");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofSandstoneBrass);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofSandstoneBrass), new ItemRendererRoof(renderRoofSandstoneBrass, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofSandstoneGold = new RenderRoof("Sandstone", "Gold");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofSandstoneGold);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofSandstoneGold), new ItemRendererRoof(renderRoofSandstoneGold, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofSandstoneMythril = new RenderRoof("Sandstone", "Mythril");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofSandstoneMythril);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofSandstoneMythril), new ItemRendererRoof(renderRoofSandstoneMythril, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofSandstoneOrichalcum = new RenderRoof("Sandstone", "Orichalcum");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofSandstoneOrichalcum);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofSandstoneOrichalcum), new ItemRendererRoof(renderRoofSandstoneOrichalcum, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofSandstoneNether = new RenderRoof("Sandstone", "Nether");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofSandstoneNether);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofSandstoneNether), new ItemRendererRoof(renderRoofSandstoneNether, new TileEntityRoof()));
				
				TileEntitySpecialRenderer renderRoofNetherStraw = new RenderRoof("Nether", "Straw");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofNetherStraw);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofNetherStraw), new ItemRendererRoof(renderRoofNetherStraw, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofNetherReeds = new RenderRoof("Nether", "Reeds");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofNetherReeds);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofNetherReeds), new ItemRendererRoof(renderRoofNetherReeds, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofNetherClay = new RenderRoof("Nether", "Clay");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofNetherClay);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofNetherClay), new ItemRendererRoof(renderRoofNetherClay, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofNetherCopper = new RenderRoof("Nether", "Copper");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofNetherCopper);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofNetherCopper), new ItemRendererRoof(renderRoofNetherCopper, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofNetherTin = new RenderRoof("Nether", "Tin");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofNetherTin);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofNetherTin), new ItemRendererRoof(renderRoofNetherTin, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofNetherBrass = new RenderRoof("Nether", "Brass");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofNetherBrass);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofNetherBrass), new ItemRendererRoof(renderRoofNetherBrass, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofNetherGold = new RenderRoof("Nether", "Gold");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofNetherGold);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofNetherGold), new ItemRendererRoof(renderRoofNetherGold, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofNetherMythril = new RenderRoof("Nether", "Mythril");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofNetherMythril);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofNetherMythril), new ItemRendererRoof(renderRoofNetherMythril, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofNetherOrichalcum = new RenderRoof("Nether", "Orichalcum");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofNetherOrichalcum);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofNetherOrichalcum), new ItemRendererRoof(renderRoofNetherOrichalcum, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofNetherNether = new RenderRoof("Nether", "Nether");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofNetherNether);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofNetherNether), new ItemRendererRoof(renderRoofNetherNether, new TileEntityRoof()));
				
				TileEntitySpecialRenderer renderRoofQuartzStraw = new RenderRoof("Quartz", "Straw");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofQuartzStraw);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofQuartzStraw), new ItemRendererRoof(renderRoofQuartzStraw, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofQuartzReeds = new RenderRoof("Quartz", "Reeds");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofQuartzReeds);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofQuartzReeds), new ItemRendererRoof(renderRoofQuartzReeds, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofQuartzClay = new RenderRoof("Quartz", "Clay");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofQuartzClay);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofQuartzClay), new ItemRendererRoof(renderRoofQuartzClay, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofQuartzCopper = new RenderRoof("Quartz", "Copper");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofQuartzCopper);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofQuartzCopper), new ItemRendererRoof(renderRoofQuartzCopper, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofQuartzTin = new RenderRoof("Quartz", "Tin");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofQuartzTin);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofQuartzTin), new ItemRendererRoof(renderRoofQuartzTin, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofQuartzBrass = new RenderRoof("Quartz", "Brass");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofQuartzBrass);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofQuartzBrass), new ItemRendererRoof(renderRoofQuartzBrass, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofQuartzGold = new RenderRoof("Quartz", "Gold");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofQuartzGold);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofQuartzGold), new ItemRendererRoof(renderRoofQuartzGold, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofQuartzMythril = new RenderRoof("Quartz", "Mythril");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofQuartzMythril);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofQuartzMythril), new ItemRendererRoof(renderRoofQuartzMythril, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofQuartzOrichalcum = new RenderRoof("Quartz", "Orichalcum");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofQuartzOrichalcum);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofQuartzOrichalcum), new ItemRendererRoof(renderRoofQuartzOrichalcum, new TileEntityRoof()));
				TileEntitySpecialRenderer renderRoofQuartzNether = new RenderRoof("Quartz", "Nether");
				ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRoof.class, renderRoofQuartzNether);
				MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ShopKeeper.roofQuartzNether), new ItemRendererRoof(renderRoofQuartzNether, new TileEntityRoof()));
				
				
		//Living Entities
		RenderingRegistry.registerEntityRenderingHandler(EntityNugget  .class, new RenderNugget(ShopKeeper.nuggetIron));
		RenderingRegistry.registerEntityRenderingHandler(EntitySpear   .class, new RenderSpear ());
		RenderingRegistry.registerEntityRenderingHandler(EntityDynamite.class, new RenderDynamite(ShopKeeper.stuffDynamite));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityMammoth    .class, new RenderMammoth    (new ModelMammoth(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityDeer       .class, new RenderDeer       (new ModelDeer(),    0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityLlama      .class, new RenderLlama      (new ModelLlama(),   0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityGoat       .class, new RenderGoat       (new ModelGoat(),    0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityCrab       .class, new RenderCrab       (new ModelCrab(),    0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityCarrotRed  .class, new RenderCarrotRed  (new ModelCarrot(),  0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityCarrotWhite.class, new RenderCarrotWhite(new ModelCarrot(),  0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityElephant   .class, new RenderElephant   (new ModelElephant(),0.3F));
		
	}

	public void registerTileEntitySpecialRenderer() {
		
	}

}