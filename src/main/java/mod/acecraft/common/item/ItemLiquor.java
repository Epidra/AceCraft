package mod.acecraft.common.item;

import mod.acecraft.Register;
import mod.lucky77.register.RegisterSeed;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;

import java.util.Random;

public class ItemLiquor extends Item {
	
	// ...
	
	
	
	
	
	// ---------- ---------- ---------- ----------  CONSTRUCTOR  ---------- ---------- ---------- ---------- //
	
	/** Default Constructor */
	public ItemLiquor(MobEffect effect1, float probability1, MobEffect effect2, float probability2){
		super(new Properties().stacksTo(64).food(new FoodProperties.Builder().nutrition(1).saturationMod(1).alwaysEat().effect(new MobEffectInstance(effect1, 600, 0), probability1).effect(new MobEffectInstance(effect2, 600, 0), probability2).build()));
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SUPPORT  ---------- ---------- ---------- ---------- //
	
	public InteractionResult interactLivingEntity(ItemStack stack, Player player, LivingEntity entity, InteractionHand hand) {
		
		if(entity instanceof Villager villager){
			if(villager.isAlive() && !villager.isBaby() && !villager.hasEffect(MobEffects.CONFUSION)){
				VillagerType biome = villager.getVillagerData().getType();
				Item item = stack.getItem();
				boolean accept = false;
				
				if(biome == VillagerType.DESERT  && item == Register.LIQUOR_COFFEE.get()){ accept = true; }
				if(biome == VillagerType.PLAINS  && item == Register.LIQUOR_WHISKY.get()){ accept = true; }
				if(biome == VillagerType.JUNGLE  && item == Register.LIQUOR_RUM.get()){ accept = true; }
				if(biome == VillagerType.SNOW    && item == Register.LIQUOR_VODKA.get()){ accept = true; }
				if(biome == VillagerType.SAVANNA && item == Register.LIQUOR_SALGAM.get()){ accept = true; }
				if(biome == VillagerType.SWAMP   && item == Register.LIQUOR_SAKE.get()){ accept = true; }
				if(biome == VillagerType.TAIGA   && item == Register.LIQUOR_VODKA.get()){ accept = true; }
				
				if(accept){
					villager.level().playSound(player, villager, SoundEvents.VILLAGER_YES, SoundSource.PLAYERS, 2.0F, 2.0F);
					villager.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100, 5));
					if(villager.canRestock()){
						villager.restock();
						villager.eatAndDigestFood();
						villager.setVillagerXp(villager.getVillagerXp() + 10);
					}
					Random rand = new Random();
					int trigger = rand.nextInt(RegisterSeed.size() * 2);
					if(trigger < RegisterSeed.size()){
						entity.spawnAtLocation(RegisterSeed.GetSeedByID(trigger));
					}
				} else {
					villager.level().playSound(player, villager, SoundEvents.VILLAGER_NO, SoundSource.PLAYERS, 2.0F, 2.0F);
					villager.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100, 5));
				}
				if(!player.level().isClientSide()){
					stack.shrink(1);
				}
				return InteractionResult.sidedSuccess(player.level().isClientSide);
			}

		}
		
		return InteractionResult.PASS;
	}
	
	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.DRINK;
	}
	
	
	
}

