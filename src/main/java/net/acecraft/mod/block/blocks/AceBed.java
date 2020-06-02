package net.acecraft.mod.block.blocks;

import java.util.Iterator;
import java.util.Random;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Direction;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AceBed extends BlockDirectional {
	
	public static final int[][] field_a = new int[][] {{0, 1}, { -1, 0}, {0, -1}, {1, 0}};
    @SideOnly(Side.CLIENT)
    private IIcon[] field_b;
    @SideOnly(Side.CLIENT)
    private IIcon[] field_M;
    @SideOnly(Side.CLIENT)
    private IIcon[] field_N;
    private static final String __OBFID = "CL_00000198";

    public AceBed(){
        super(Material.cloth);
        this.setResistance(1.0F);
        this.setHardness(0.5F);
        this.func_149978_e();
        this.setCreativeTab(ShopKeeper.acetabCommon);
    }
    
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int var1, float floatx, float floaty, float floatz){
        if (world.isRemote){
            return true;
        }else{
            int i1 = world.getBlockMetadata(x, y, z);
            if (!isBlockHeadOfBed(i1)){
                int j1 = getDirection(i1);
                x += field_a[j1][0];
                z += field_a[j1][1];
                if (world.getBlock(x, y, z) != this){
                    return true;
                }
                i1 = world.getBlockMetadata(x, y, z);
            }
            if (world.provider.canRespawnHere() && world.getBiomeGenForCoords(x, z) != BiomeGenBase.hell){
                if (func_149976_c(i1)){
                    EntityPlayer entityplayer1 = null;
                    Iterator iterator = world.playerEntities.iterator();
                    while (iterator.hasNext()){
                        EntityPlayer entityplayer2 = (EntityPlayer)iterator.next();
                        if (entityplayer2.isPlayerSleeping()){
                            ChunkCoordinates chunkcoordinates = entityplayer2.playerLocation;
                            if (chunkcoordinates.posX == x && chunkcoordinates.posY == y && chunkcoordinates.posZ == z){
                                entityplayer1 = entityplayer2;
                            }
                        }
                    }
                    if (entityplayer1 != null){
                        player.addChatComponentMessage(new ChatComponentTranslation("tile.bed.occupied", new Object[0]));
                        return true;
                    }
                    func_149979_a(world, x, y, z, false);
                }
                EntityPlayer.EnumStatus enumstatus = player.sleepInBedAt(x, y, z);
                if (enumstatus == EntityPlayer.EnumStatus.OK){
                    func_149979_a(world, x, y, z, true);
                    return true;
                }else{
                    if (enumstatus == EntityPlayer.EnumStatus.NOT_POSSIBLE_NOW){
                        player.addChatComponentMessage(new ChatComponentTranslation("tile.bed.noSleep", new Object[0]));
                    }else if (enumstatus == EntityPlayer.EnumStatus.NOT_SAFE){
                        player.addChatComponentMessage(new ChatComponentTranslation("tile.bed.notSafe", new Object[0]));
                    }
                    return true;
                }
            }else{
                double d2 = (double)x + 0.5D;
                double d0 = (double)y + 0.5D;
                double d1 = (double)z + 0.5D;
                world.setBlockToAir(x, y, z);
                int k1 = getDirection(i1);
                x += field_a[k1][0];
                z += field_a[k1][1];
                if (world.getBlock(x, y, z) == this){
                    world.setBlockToAir(x, y, z);
                    d2 = (d2 + (double)x + 0.5D) / 2.0D;
                    d0 = (d0 + (double)y + 0.5D) / 2.0D;
                    d1 = (d1 + (double)z + 0.5D) / 2.0D;
                }
                world.newExplosion((Entity)null, (double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), 5.0F, true, true);
                return true;
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int i, int j){
        if (i == 0){
        	return blockIcon;
            //return Blocks.planks.getBlockTextureFromSide(i);
        }else{
            int k = getDirection(j);
            int l = Direction.bedDirection[k][i];
            int i1 = isBlockHeadOfBed(j) ? 1 : 0;
            return (i1 != 1 || l != 2) && (i1 != 0 || l != 3) ? (l != 5 && l != 4 ? this.field_N[i1] : this.field_M[i1]) : this.field_b[i1];
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_){
        this.field_N = new IIcon[] {p_149651_1_.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5) + "FeetTop"),  p_149651_1_.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5) + "HeadTop")};
        this.field_b = new IIcon[] {p_149651_1_.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5) + "FeetEnd"),  p_149651_1_.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5) + "HeadEnd")};
        this.field_M = new IIcon[] {p_149651_1_.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5) + "FeetSide"), p_149651_1_.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5) + "HeadSide")};
    }
    
    public int getRenderType(){
        return 14;
    }
    
    public boolean renderAsNormalBlock(){
        return false;
    }
    
    public boolean isOpaqueCube(){
        return false;
    }
    
    public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_){
        this.func_149978_e();
    }
    
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block){
        int l = world.getBlockMetadata(x, y, z);
        int i1 = getDirection(l);
        if (isBlockHeadOfBed(l)){
            if (world.getBlock(x - field_a[i1][0], y, z - field_a[i1][1]) != this){
                world.setBlockToAir(x, y, z);
            }
        }else if (world.getBlock(x + field_a[i1][0], y, z + field_a[i1][1]) != this){
            world.setBlockToAir(x, y, z);
            if (!world.isRemote){
                this.dropBlockAsItem(world, x, y, z, l, 0);
            }
        }
    }
    
    public Item getItemDropped(int i, Random random, int j){
        return isBlockHeadOfBed(i) ? Item.getItemById(0) : Item.getItemFromBlock(this);
    }

    private void func_149978_e(){
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5625F, 1.0F);
    }
    
    public static boolean isBlockHeadOfBed(int i){
        return (i & 8) != 0;
    }

    public static boolean func_149976_c(int i){
        return (i & 4) != 0;
    }

    public static void func_149979_a(World world, int x, int y, int z, boolean flag){
        int l = world.getBlockMetadata(x, y, z);
        if (flag){
            l |= 4;
        }else{
            l &= -5;
        }
        world.setBlockMetadataWithNotify(x, y, z, l, 4);
    }
    
    public static ChunkCoordinates func_149977_a(World world, int x, int y, int z, int meta){
        int i1 = world.getBlockMetadata(x, y, z);
        int j1 = BlockDirectional.getDirection(i1);
        for (int k1 = 0; k1 <= 1; ++k1){
            int l1 = x - field_a[j1][0] * k1 - 1;
            int i2 = z - field_a[j1][1] * k1 - 1;
            int j2 = l1 + 2;
            int k2 = i2 + 2;
            for (int l2 = l1; l2 <= j2; ++l2){
                for (int i3 = i2; i3 <= k2; ++i3){
                    if (World.doesBlockHaveSolidTopSurface(world, l2, y - 1, i3) && !world.getBlock(l2, y, i3).getMaterial().isOpaque() && !world.getBlock(l2, y + 1, i3).getMaterial().isOpaque()){
                        if (meta <= 0){
                            return new ChunkCoordinates(l2, y, i3);
                        }
                        --meta;
                    }
                }
            }
        }
        return null;
    }
    
    public Item getItem(World world, int x, int y, int z){
		return Item.getItemFromBlock(ShopKeeper.bedBlack);
	}
    
    public void dropBlockAsItemWithChance(World world, int x, int y, int z, int meta, float f, int var){
        if (!isBlockHeadOfBed(meta)){
            super.dropBlockAsItemWithChance(world, x, y, z, meta, f, 0);
        }
    }
    
    public int getMobilityFlag(){
        return 1;
    }

    public boolean isBed(IBlockAccess world, int x, int y, int z, EntityLivingBase player){
      return true;
    }
    
    public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player){
        if (player.capabilities.isCreativeMode && isBlockHeadOfBed(meta)){
            int i1 = getDirection(meta);
            x -= field_a[i1][0];
            z -= field_a[i1][1];
            if (world.getBlock(x, y, z) == this){
                world.setBlockToAir(x, y, z);
            }
        }
    }

}