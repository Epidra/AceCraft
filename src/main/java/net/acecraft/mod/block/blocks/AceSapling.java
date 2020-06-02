package net.acecraft.mod.block.blocks;

import java.util.List;
import java.util.Random;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.worldgen.tree.WorldGenAppleTree;
import net.acecraft.mod.worldgen.tree.WorldGenBananaTree;
import net.acecraft.mod.worldgen.tree.WorldGenCherryTree;
import net.acecraft.mod.worldgen.tree.WorldGenCoconutTree;
import net.acecraft.mod.worldgen.tree.WorldGenGoldenTree;
import net.acecraft.mod.worldgen.tree.WorldGenLemonTree;
import net.acecraft.mod.worldgen.tree.WorldGenOrangeTree;
import net.acecraft.mod.worldgen.tree.WorldGenPalmTree;
import net.acecraft.mod.worldgen.tree.WorldGenPeachTree;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class AceSapling extends BlockSapling {
	
	private String id;
	
	public static final String[] sub  = new String[] {"Apple", "Cherry", "Lemon", "Orange", "Peach", "PalmTree", "Coconut", "Banana", "Golden"};
	private static final IIcon[] icon = new IIcon[sub.length];

	public AceSapling(){
		float f = 0.4F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
		this.setCreativeTab(ShopKeeper.acetabCommon);
	}
	
	public void updateTick(World world, int x, int y, int z, Random random){
		if(!world.isRemote){
			super.updateTick(world, x, y, z, random);
			if(world.getBlockLightValue(x, y + 1, z) >= 9 && random.nextInt(7) == 0){
				this.func_149879_c(world, x, y, z, random);
			}
		}
	}
	
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta){
        meta &= 7;
        return icon[MathHelper.clamp_int(meta, 0, 5)];
    }
	
	//MarkOrGrowMarked
	public void func_149879_c(World world, int x, int y, int z, Random random){
		int l = world.getBlockMetadata(x, y, z);
		if((l & 8) == 0){
			world.setBlockMetadataWithNotify(x, y, z, l | 8, 4);
		}else{
			this.func_149878_d(world, x, y, z, random);
		}
	}
	
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs p_149666_2_, List list){
        list.add(new ItemStack(item, 1, 0));
        list.add(new ItemStack(item, 1, 1));
        list.add(new ItemStack(item, 1, 2));
        list.add(new ItemStack(item, 1, 3));
        list.add(new ItemStack(item, 1, 4));
        list.add(new ItemStack(item, 1, 5));
        list.add(new ItemStack(item, 1, 6));
        list.add(new ItemStack(item, 1, 7));
        list.add(new ItemStack(item, 1, 8));
    }
	
	//growTree
	public void func_149878_d(World world, int x, int y, int z, Random random){
		if(!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(world, random, x, y, z)) return;
		Object object = random.nextInt(10) == 0 ? new WorldGenBigTree(true) : new WorldGenTrees(true); //Chances of getting a Big Tree
		int i1 = 0;
		int j1 = 0;
		boolean flag = false;
		int i = world.getBlockMetadata(x, y, z);
		if(i ==  8) object = new WorldGenAppleTree  (ShopKeeper.aceLog, ShopKeeper.leavesAppleEmpty,  false, 5, 3, false);
		if(i ==  9) object = new WorldGenCherryTree (ShopKeeper.aceLog, ShopKeeper.leavesCherryEmpty, false, 5, 3, false);
		if(i == 10) object = new WorldGenLemonTree  (ShopKeeper.aceLog, ShopKeeper.leavesLemonEmpty,  false, 5, 3, false);
		if(i == 11) object = new WorldGenOrangeTree (ShopKeeper.aceLog, ShopKeeper.leavesOrangeEmpty, false, 5, 3, false);
		if(i == 12) object = new WorldGenPeachTree  (ShopKeeper.aceLog, ShopKeeper.leavesPeachEmpty,  false, 5, 3, false);
		if(i == 13) object = new WorldGenPalmTree   (ShopKeeper.aceLog, ShopKeeper.leavesPalmTree,    false, 5, 3, false);
		if(i == 14) object = new WorldGenCoconutTree(ShopKeeper.aceLog, ShopKeeper.leavesPalmTree,    false, 5, 3, false);
		if(i == 15) object = new WorldGenBananaTree (ShopKeeper.aceLog, ShopKeeper.leavesPalmTree,    false, 5, 3, false);
		if(i == 16) object = new WorldGenGoldenTree (ShopKeeper.aceLog, ShopKeeper.leavesGoldenEmpty, false, 5, 3, false);
		Block block = Blocks.air;
		if(flag){
			world.setBlock(x + i1    , y, z + j1    , block, 0, 4);
			world.setBlock(x + i1 + 1, y, z + j1    , block, 0, 4);
			world.setBlock(x + i1    , y, z + j1 + 1, block, 0, 4);
			world.setBlock(x + i1 + 1, y, z + j1 + 1, block, 0, 4);
		}else{
			world.setBlock(x, y, z, block, 0, 4);
		}
		if(!((WorldGenerator)object).generate(world, random, x + i1, y, z + j1)){
			if(flag){
				world.setBlock(x + i1    , y, z + j1    , this, 0, 4);
				world.setBlock(x + i1 + 1, y, z + j1    , this, 0, 4);
				world.setBlock(x + i1    , y, z + j1 + 1, this, 0, 4);
				world.setBlock(x + i1 + 1, y, z + j1 + 1, this, 0, 4);
			}else{
				world.setBlock(x, y, z, this, 0, 4);
			}
		}
	}
	
	//isSameSapling
	public boolean func_149880_a(World world, int x, int y, int z, int par1){
		return world.getBlock(x, y, z) == this && (world.getBlockMetadata(x, y, z) & 7) == par1;
	}
	
	public int damageDropped(int i){
		return super.damageDropped(i);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_){
	    for (int i = 0; i < sub.length; ++i){
	        icon[i] = p_149651_1_.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5) + sub[i]);
	    }
	}
	
	public boolean func_149851_a(World world, int x, int y, int z, int meta, boolean b){
		return true;
	}
	
	public boolean func_149852_a(World world, Random random, int x, int y, int z){
		return (double)world.rand.nextFloat() < 0.45D;
	}
	
	public void func_14853_b(World world, Random random, int x, int y, int z){
		this.func_149879_c(world, x, y, z, random);
	}

}