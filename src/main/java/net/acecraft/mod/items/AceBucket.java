package net.acecraft.mod.items;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AceBucket extends Item {
	
    private Block isFull;
    private String material;
    
    public AceBucket(Block block, String s){
        this.maxStackSize = 1;
        this.isFull = block;
        this.setCreativeTab(null);
        this.material = s;
    }
    
    @SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister){
		this.itemIcon = iconRegister.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5));
	}
    
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
        boolean flag = this.isFull == Blocks.air;
        MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, player, flag);
        if (movingobjectposition == null){
            return stack;
        }else{
            FillBucketEvent event = new FillBucketEvent(player, stack, world, movingobjectposition);
            if (MinecraftForge.EVENT_BUS.post(event)){
                return stack;
            }
            if (event.getResult() == Event.Result.ALLOW){
                if (player.capabilities.isCreativeMode){
                    return stack;
                }
                if (--stack.stackSize <= 0){
                    return event.result;
                }
                if (!player.inventory.addItemStackToInventory(event.result)){
                    player.dropPlayerItemWithRandomChoice(event.result, false);
                }
                return stack;
            }
            if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK){
                int i = movingobjectposition.blockX;
                int j = movingobjectposition.blockY;
                int k = movingobjectposition.blockZ;
                if (!world.canMineBlock(player, i, j, k)){
                    return stack;
                }
                if (flag){
                    if (!player.canPlayerEdit(i, j, k, movingobjectposition.sideHit, stack)){
                        return stack;
                    }
                    Material material = world.getBlock(i, j, k).getMaterial();
                    int l = world.getBlockMetadata(i, j, k);
                    if (material == Material.water && l == 0){
                        world.setBlockToAir(i, j, k);
                        return this.func_150910_a(stack, player, setBucket(1));
                    }
                    if (material == Material.lava && l == 0){
                        world.setBlockToAir(i, j, k);
                        return this.func_150910_a(stack, player, setBucket(2));
                    }
                }else{
                    if (this.isFull == Blocks.air){
                        return new ItemStack(setBucket(0));
                    }
                    if (movingobjectposition.sideHit == 0){ --j; }
                    if (movingobjectposition.sideHit == 1){ ++j; }
                    if (movingobjectposition.sideHit == 2){ --k; }
                    if (movingobjectposition.sideHit == 3){ ++k; }
                    if (movingobjectposition.sideHit == 4){ --i; }
                    if (movingobjectposition.sideHit == 5){ ++i; }
                    if (!player.canPlayerEdit(i, j, k, movingobjectposition.sideHit, stack)){
                        return stack;
                    }
                    if (this.tryPlaceContainedLiquid(world, i, j, k) && !player.capabilities.isCreativeMode){
                        return new ItemStack(setBucket(0));
                    }
                }
            }
            return stack;
        }
    }
    
    private ItemStack func_150910_a(ItemStack stack, EntityPlayer player, Item item){
        if (player.capabilities.isCreativeMode){
            return stack;
        }else if (--stack.stackSize <= 0){
            return new ItemStack(item);
        }else{
            if (!player.inventory.addItemStackToInventory(new ItemStack(item))){
                player.dropPlayerItemWithRandomChoice(new ItemStack(item, 1, 0), false);
            }
            return stack;
        }
    }
    
    public boolean tryPlaceContainedLiquid(World world, int x, int y, int z){
        if (this.isFull == Blocks.air){
            return false;
        }else{
            Material material = world.getBlock(x, y, z).getMaterial();
            boolean flag = !material.isSolid();
            if (!world.isAirBlock(x, y, z) && !flag){
                return false;
            }else{
                if (world.provider.isHellWorld && this.isFull == Blocks.flowing_water){
                    world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), "random.fizz", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
                    for (int l = 0; l < 8; ++l){
                        world.spawnParticle("largesmoke", (double)x + Math.random(), (double)y + Math.random(), (double)z + Math.random(), 0.0D, 0.0D, 0.0D);
                    }
                }else{
                    if (!world.isRemote && flag && !material.isLiquid()){
                        world.func_147480_a(x, y, z, true);
                    }
                    world.setBlock(x, y, z, this.isFull, 0, 3);
                }
                return true;
            }
        }
    }
    
    private Item setBucket(int i){
    	if(i == 0){
    		if(0 == material.compareTo("Wood"))       return ShopKeeper.bucketWoodEmpty;
    		if(0 == material.compareTo("Copper"))     return ShopKeeper.bucketCopperEmpty;
    		if(0 == material.compareTo("Iron"))       return ShopKeeper.bucketIronEmpty;
    		if(0 == material.compareTo("Aluminium"))  return ShopKeeper.bucketAluminiumEmpty;
    		if(0 == material.compareTo("Lead"))       return ShopKeeper.bucketLeadEmpty;
    		if(0 == material.compareTo("Bronze"))     return ShopKeeper.bucketBronzeEmpty;
    		if(0 == material.compareTo("Steel"))      return ShopKeeper.bucketSteelEmpty;
    		if(0 == material.compareTo("Mythril"))    return ShopKeeper.bucketMythrilEmpty;
    		if(0 == material.compareTo("Adamantium")) return ShopKeeper.bucketAdamantiumEmpty;
    		if(0 == material.compareTo("Unobtanium")) return ShopKeeper.bucketUnobtaniumEmpty;
    	}
    	if(i == 1){
    		if(0 == material.compareTo("Wood"))       return ShopKeeper.bucketWoodWater;
    		if(0 == material.compareTo("Copper"))     return ShopKeeper.bucketCopperWater;
    		if(0 == material.compareTo("Iron"))       return ShopKeeper.bucketIronWater;
    		if(0 == material.compareTo("Aluminium"))  return ShopKeeper.bucketAluminiumWater;
    		if(0 == material.compareTo("Lead"))       return ShopKeeper.bucketLeadWater;
    		if(0 == material.compareTo("Bronze"))     return ShopKeeper.bucketBronzeWater;
    		if(0 == material.compareTo("Steel"))      return ShopKeeper.bucketSteelWater;
    		if(0 == material.compareTo("Mythril"))    return ShopKeeper.bucketMythrilWater;
    		if(0 == material.compareTo("Adamantium")) return ShopKeeper.bucketAdamantiumWater;
    		if(0 == material.compareTo("Unobtanium")) return ShopKeeper.bucketUnobtaniumWater;
    	}
    	if(i == 2){
    		if(0 == material.compareTo("Copper"))     return ShopKeeper.bucketCopperLava;
    		if(0 == material.compareTo("Iron"))       return ShopKeeper.bucketIronLava;
    		if(0 == material.compareTo("Aluminium"))  return ShopKeeper.bucketAluminiumLava;
    		if(0 == material.compareTo("Lead"))       return ShopKeeper.bucketLeadLava;
    		if(0 == material.compareTo("Bronze"))     return ShopKeeper.bucketBronzeLava;
    		if(0 == material.compareTo("Steel"))      return ShopKeeper.bucketSteelLava;
    		if(0 == material.compareTo("Mythril"))    return ShopKeeper.bucketMythrilLava;
    		if(0 == material.compareTo("Adamantium")) return ShopKeeper.bucketAdamantiumLava;
    		if(0 == material.compareTo("Unobtanium")) return ShopKeeper.bucketUnobtaniumLava;
    	}
    	return Items.bucket;
    }

}