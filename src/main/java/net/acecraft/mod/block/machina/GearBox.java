package net.acecraft.mod.block.machina;

import java.util.Random;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.tileentity.TileEntityGearBox;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GearBox extends BlockContainer {
	
	/** Top icon of piston depends on (either sticky or normal) */
    @SideOnly(Side.CLIENT)
    private static IIcon topIcon;
    @SideOnly(Side.CLIENT)
	private static IIcon blockIcon;

    private static final String __OBFID = "CL_00000366";

    public GearBox()
    {
        super(Material.piston);
        this.setStepSound(soundTypePiston);
        this.setHardness(0.5F);
        this.setCreativeTab(ShopKeeper.acetabMachina);
    }

    @SideOnly(Side.CLIENT)
    public void func_150070_b(float p_150070_1_, float p_150070_2_, float p_150070_3_, float p_150070_4_, float p_150070_5_, float p_150070_6_){
        this.setBlockBounds(p_150070_1_, p_150070_2_, p_150070_3_, p_150070_4_, p_150070_5_, p_150070_6_);
    }

    public Item getItemDropped(int i, Random random, int j){
		return Item.getItemFromBlock(ShopKeeper.machinaGearBox);
	}
    
    public TileEntity createNewTileEntity(World world, int i){
		return new TileEntityGearBox();
	}
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta){
        if(side == meta){
        	return topIcon;
        }
        return blockIcon;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register){
        this.blockIcon = register.registerIcon(AceCraft.modid + ":" + "GearBoxSide");
        this.topIcon   = register.registerIcon(AceCraft.modid + ":" + "GearBoxFront");

    }
    
    public boolean isOpaqueCube(){
        return false;
    }
    
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack){
        int meta = determineOrientation(world, x, y, z, player);
        world.setBlockMetadataWithNotify(x, y, z, meta, 2);
        TileEntityGearBox entity = (TileEntityGearBox) world.getTileEntity(x, y, z);
        entity.firstSetUp(meta, 0);
    }
    
    public boolean renderAsNormalBlock(){
        return true;
    }
    
    public static int determineOrientation(World world, int x, int y, int z, EntityLivingBase player){
        if (MathHelper.abs((float)player.posX - (float)x) < 2.0F && MathHelper.abs((float)player.posZ - (float)z) < 2.0F){
            double d0 = player.posY + 1.82D - (double)player.yOffset;
            if (d0 - (double)y > 2.0D){
                return 1;
            }
            if ((double)y - d0 > 0.0D){
                return 0;
            }
        }
        int l = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        return l == 0 ? 2 : (l == 1 ? 5 : (l == 2 ? 3 : (l == 3 ? 4 : 0)));
    }

}