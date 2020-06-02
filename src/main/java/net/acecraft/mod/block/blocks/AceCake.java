package net.acecraft.mod.block.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class AceCake extends Block {
    @SideOnly(Side.CLIENT)
    private IIcon iconTop;
    @SideOnly(Side.CLIENT)
    private IIcon iconBottom;
    @SideOnly(Side.CLIENT)
    private IIcon iconInner;
    
    public AceCake(){
        super(Material.cake);
        this.setTickRandomly(true);
    }
    
    public void setBlockBoundsBasedOnState(IBlockAccess iaccess, int x, int y, int z){
        int l = iaccess.getBlockMetadata(x, y, z);
        float f = 0.0625F;
        float f1 = (float)(1 + l * 2) / 16.0F;
        float f2 = 0.5F;
        this.setBlockBounds(f1, 0.0F, f, 1.0F - f, f2, 1.0F - f);
    }
    
    public void setBlockBoundsForItemRender(){
        float f = 0.0625F;
        float f1 = 0.5F;
        this.setBlockBounds(f, 0.0F, f, 1.0F - f, f1, 1.0F - f);
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z){
        int l = world.getBlockMetadata(x, y, z);
        float f = 0.0625F;
        float f1 = (float)(1 + l * 2) / 16.0F;
        float f2 = 0.5F;
        return AxisAlignedBB.getBoundingBox((double)((float)x + f1), (double)y, (double)((float)z + f), (double)((float)(x + 1) - f), (double)((float)y + f2 - f), (double)((float)(z + 1) - f));
    }
    
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z){
        int l = world.getBlockMetadata(x, y, z);
        float f = 0.0625F;
        float f1 = (float)(1 + l * 2) / 16.0F;
        float f2 = 0.5F;
        return AxisAlignedBB.getBoundingBox((double)((float)x + f1), (double)y, (double)((float)z + f), (double)((float)(x + 1) - f), (double)((float)y + f2), (double)((float)(z + 1) - f));
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta){
        return side == 1 ? this.iconTop : (side == 0 ? this.iconBottom : (meta > 0 && side == 4 ? this.iconInner : this.blockIcon));
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconregister){
        this.blockIcon  = iconregister.registerIcon(this.getTextureName() + "_side");
        this.iconInner  = iconregister.registerIcon(this.getTextureName() + "_inner");
        this.iconTop    = iconregister.registerIcon(this.getTextureName() + "_top");
        this.iconBottom = iconregister.registerIcon(this.getTextureName() + "_bottom");
    }
    
    public boolean renderAsNormalBlock(){
        return false;
    }
    
    public boolean isOpaqueCube(){
        return false;
    }
    
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float fX, float fY, float fZ){
        this.func_150036_b(world, x, y, z, player);
        return true;
    }
    
    public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player){
        this.func_150036_b(world, x, y, z, player);
    }
    
    private void func_150036_b(World world, int x, int y, int z, EntityPlayer player){
        if (player.canEat(false)){
            player.getFoodStats().addStats(2, 0.1F);
            int l = world.getBlockMetadata(x, y, z) + 1;
            if (l >= 6){
                world.setBlockToAir(x, y, z);
            }else{
                world.setBlockMetadataWithNotify(x, y, z, l, 2);
            }
        }
    }
    
    public boolean canPlaceBlockAt(World world, int x, int y, int z){
        return !super.canPlaceBlockAt(world, x, y, z) ? false : this.canBlockStay(world, x, y, z);
    }
    
    public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbour){
        if (!this.canBlockStay(world, x, y, z)){
            world.setBlockToAir(x, y, z);
        }
    }
    
    public boolean canBlockStay(World world, int x, int y, int z){
        return world.getBlock(x, y - 1, z).getMaterial().isSolid();
    }
    
    public int quantityDropped(Random rand){
        return 0;
    }
    
    public Item getItemDropped(int var1, Random rand, int var2){
        return null;
    }
    
    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z){
        return new ItemStack(this).getItem();
    }

}