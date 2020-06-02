package net.acecraft.mod.items;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AceFood extends ItemFood {
	
	boolean isDrink;
	boolean returnBowl;
	
	public AceFood(int _hunger, float _saturation, boolean _wolfFood, boolean _isDrink, boolean _returnBowl) {
		super(_hunger, _saturation, _wolfFood);
		this.setCreativeTab(ShopKeeper.acetabCommon);
		isDrink = _isDrink;
		returnBowl = _returnBowl;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister){
		this.itemIcon = iconRegister.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5));
	}
	
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
        if (!player.capabilities.isCreativeMode) {
            --stack.stackSize;
        }
        if (!world.isRemote) {
        	if(stack.getItem() == ShopKeeper.juiceMilk || stack.getItem() == ShopKeeper.juiceCoconutMilk || stack.getItem() == ShopKeeper.juiceChocolateMilk){
        		player.curePotionEffects(stack);
        	}
        	if(stack.getItem() == ShopKeeper.foodSeaSaltIceCream){
        		player.inventory.addItemStackToInventory(new ItemStack(Items.stick));
        	}
        	if(returnBowl && !isDrink){
        		player.inventory.addItemStackToInventory(new ItemStack(Items.bowl));
        	}
        	if(returnBowl &&  isDrink){
        		player.inventory.addItemStackToInventory(new ItemStack(Items.glass_bottle));
        	}
        	
        	if(stack.getItem() == ShopKeeper.juiceCoffee){
        		player.addPotionEffect(new PotionEffect(Potion.digSpeed .id, 3000, 0));
        		player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 3000, 0));
        		player.addPotionEffect(new PotionEffect(Potion.hunger   .id, 3000, 1));
        	}
        	
        	if(stack.getItem() == ShopKeeper.liquorCoconutRum){
        		player.addPotionEffect(new PotionEffect(Potion.confusion  .id, 3000, 1));
        		player.addPotionEffect(new PotionEffect(Potion.blindness  .id, 3000, 1));
        		player.addPotionEffect(new PotionEffect(Potion.digSpeed   .id, 3000, 1));
        		player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 3000, 1));
        	}
        	if(stack.getItem() == ShopKeeper.liquorCider){
        		player.addPotionEffect(new PotionEffect(Potion.confusion.id, 3000, 1));
        		player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 3000, 1));
        	}
        	if(stack.getItem() == ShopKeeper.liquorRum){
        		player.addPotionEffect(new PotionEffect(Potion.confusion   .id, 3000, 1));
        		player.addPotionEffect(new PotionEffect(Potion.blindness   .id, 3000, 1));
        		player.addPotionEffect(new PotionEffect(Potion.digSpeed    .id, 3000, 4));
        		player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 3000, 0));
        	}
        	if(stack.getItem() == ShopKeeper.liquorBeer){
        		player.addPotionEffect(new PotionEffect(Potion.confusion   .id, 3000, 0));
        		player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 3000, 1));
        		player.addPotionEffect(new PotionEffect(Potion.damageBoost .id, 3000, 2));
        	}
        	if(stack.getItem() == ShopKeeper.liquorSalgam){
        		player.addPotionEffect(new PotionEffect(Potion.confusion.id, 3000, 0));
        		player.addPotionEffect(new PotionEffect(Potion.blindness.id, 3000, 1));
        		player.addPotionEffect(new PotionEffect(Potion.jump     .id, 3000, 2));
        	}
        	if(stack.getItem() == ShopKeeper.liquorVodka){
        		player.addPotionEffect(new PotionEffect(Potion.confusion   .id, 3000, 2));
        		player.addPotionEffect(new PotionEffect(Potion.blindness   .id, 3000, 3));
        		player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 3000, 1));
        		player.addPotionEffect(new PotionEffect(Potion.damageBoost .id, 3000, 4));
        		player.addPotionEffect(new PotionEffect(Potion.resistance  .id, 3000, 3));
        	}
        	if(stack.getItem() == ShopKeeper.liquorCactusJack){
        		player.addPotionEffect(new PotionEffect(Potion.confusion     .id, 3000, 2));
        		player.addPotionEffect(new PotionEffect(Potion.blindness     .id, 3000, 3));
        		player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 3000, 3));
        		player.addPotionEffect(new PotionEffect(Potion.resistance    .id, 3000, 2));
        	}
        	if(stack.getItem() == ShopKeeper.liquorSake){
        		player.addPotionEffect(new PotionEffect(Potion.confusion  .id, 3000, 0));
        		player.addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 3000, 0));
        		player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 3000, 1));
        	}
        	if(stack.getItem() == ShopKeeper.liquorMead){
        		player.addPotionEffect(new PotionEffect(Potion.confusion  .id, 3000, 0));
        		player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 3000, 0));
        	}
        	if(stack.getItem() == ShopKeeper.liquorWineGrapes){
        		player.addPotionEffect(new PotionEffect(Potion.confusion   .id, 3000, 0));
        		player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 3000, 0));
        		player.addPotionEffect(new PotionEffect(Potion.weakness    .id, 3000, 0));
        		player.addPotionEffect(new PotionEffect(Potion.digSpeed    .id, 3000, 2));
        	}
        	if(stack.getItem() == ShopKeeper.liquorWineCherry){
        		player.addPotionEffect(new PotionEffect(Potion.confusion   .id, 3000, 0));
        		player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 3000, 1));
        		player.addPotionEffect(new PotionEffect(Potion.weakness    .id, 3000, 0));
        		player.addPotionEffect(new PotionEffect(Potion.digSpeed    .id, 3000, 3));
        	}
        	if(stack.getItem() == ShopKeeper.liquorWinePineapple){
        		player.addPotionEffect(new PotionEffect(Potion.confusion   .id, 3000, 1));
        		player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 3000, 0));
        		player.addPotionEffect(new PotionEffect(Potion.digSpeed    .id, 3000, 2));
        	}
        }
        player.getFoodStats().func_151686_a(this, stack);
        world.playSoundAtEntity(player, "random.burp", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);
        this.onFoodEaten(stack, world, player);
        return stack;
    }

    public int getMaxItemUseDuration(ItemStack stack) {
        return 32;
    }

    public EnumAction getItemUseAction(ItemStack stack) {
    	if(isDrink){
    		return EnumAction.drink;
    	}else{
    		return EnumAction.eat;
    	}
    }

}