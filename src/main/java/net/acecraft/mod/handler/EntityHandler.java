package net.acecraft.mod.handler;

import java.util.Random;

import net.acecraft.mod.AceCraft;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityHandler {
	
	public static void registerThrowingEntity(Class entityClass, String name){
		int entityID = EntityRegistry.findGlobalUniqueEntityId();
		long x = name.hashCode();
		EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
		EntityRegistry.registerModEntity(entityClass, name, entityID, AceCraft.instance, 64, 1, true);
	}
	
	public static void registerMonsters(Class entityClass, String name){
		int entityID = EntityRegistry.findGlobalUniqueEntityId();
		long x = name.hashCode();
		Random random = new Random(x);
		int mainColor = random.nextInt() * 16777215;
		int  subColor = random.nextInt() * 16777215;
		EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
		registerSpawnBiome(entityClass, name);
		EntityRegistry.registerModEntity(entityClass, name, entityID, AceCraft.instance, 64, 1, true);
		EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, mainColor, subColor));
	}
	
	private static void registerSpawnBiome(Class entityClass, String name){
		      if(0 == name.compareTo("Mammoth")){
		    EntityRegistry.addSpawn(entityClass,  5, 1, 1, EnumCreatureType.creature, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills);
		}else if(0 == name.compareTo("Llama")){
			EntityRegistry.addSpawn(entityClass, 20, 1, 3, EnumCreatureType.creature, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F);
		}else if(0 == name.compareTo("Deer")){
			EntityRegistry.addSpawn(entityClass, 25, 1, 2, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.forest, BiomeGenBase.forestHills);
		}else if(0 == name.compareTo("Goat")){
			EntityRegistry.addSpawn(entityClass, 25, 2, 4, EnumCreatureType.creature, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus);
		}else if(0 == name.compareTo("Crab")){
			EntityRegistry.addSpawn(entityClass, 15, 1, 6, EnumCreatureType.creature, BiomeGenBase.beach, BiomeGenBase.stoneBeach);
		}else if(0 == name.compareTo("CarrotRed")){
			EntityRegistry.addSpawn(entityClass, 10, 1, 8, EnumCreatureType.monster,  BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.roofedForest);
		}else if(0 == name.compareTo("CarrotWhite")){
			EntityRegistry.addSpawn(entityClass,  5, 1, 4, EnumCreatureType.monster,  BiomeGenBase.forest, BiomeGenBase.forestHills);
		}else if(0 == name.compareTo("Elephant")){
			EntityRegistry.addSpawn(entityClass,  5, 1, 4, EnumCreatureType.creature,  BiomeGenBase.savanna, BiomeGenBase.savannaPlateau);
		}else{
			EntityRegistry.addSpawn(entityClass, 50, 2, 4, EnumCreatureType.ambient, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.plains);
		}
	}

}