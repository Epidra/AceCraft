package net.acecraft.mod.blocks;

import javax.annotation.Nullable;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.container.ContainerCookingTable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;

public class MachinaCookingTable extends IMachinaBasic {
    public MachinaCookingTable(String name){
    	super(name, Material.IRON);
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
        if (worldIn.isRemote){
            return true;
        } else {
        	playerIn.openGui(AceCraft.instance, ShopKeeper.guiIDCookingTable, worldIn, pos.getX(), pos.getY(), pos.getZ());
            playerIn.addStat(StatList.CRAFTING_TABLE_INTERACTION);
            return true;
        }
    }
}