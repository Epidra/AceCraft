package net.acecraft.mod.items;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.entity.EntityNugget;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AceNugget extends Item {
	
	public AceNugget(){
		this.setCreativeTab(ShopKeeper.acetabCommon);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister){
		this.itemIcon = iconRegister.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5));
	}
	
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player){
        if (!player.capabilities.isCreativeMode){
            --itemStack.stackSize;
        }
        world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        if (!world.isRemote){
            world.spawnEntityInWorld(new EntityNugget(world, player, this.getUnlocalizedName().substring(5)));
        }
        return itemStack;
    }

}