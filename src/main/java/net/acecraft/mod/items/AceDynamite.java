package net.acecraft.mod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.entity.EntityDynamite;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class AceDynamite extends Item {
	
	public AceDynamite(){
			this.setCreativeTab(ShopKeeper.acetabCommon);
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player){
		if(!player.capabilities.isCreativeMode){
			--itemstack.stackSize;
		}
		world.playSoundAtEntity(player, "random.fizz", 0.7F, 0.1F);
		if(!world.isRemote){
			world.spawnEntityInWorld(new EntityDynamite(world, player));
		}
		return itemstack;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister){
		this.itemIcon = iconRegister.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5));
	}
	
}
