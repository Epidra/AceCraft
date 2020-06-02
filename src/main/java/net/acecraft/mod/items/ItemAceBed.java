package net.acecraft.mod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.block.blocks.AceBed;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemAceBed extends ItemBlock {
	
	public final Block block;
    @SideOnly(Side.CLIENT)
    private IIcon icon;
    private static final String __OBFID = "CL_00001772";
	
	public ItemAceBed(Block _block) {
		super(_block);
		block = _block;
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iiconregister){
        String s = block.getItemIconName();
        if (s != null){
            icon = iiconregister.registerIcon(AceCraft.modid + ":" + this.getUnlocalizedName().substring(5));
        }
    }
	
	public IIcon getIcon(ItemStack stack, int pass)
    {
        /**
         * Gets an icon index based on an item's damage value and the given render pass
         */
        return icon;
    }
	
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int intX, int intY, int intZ, int meta, float fX, float fY, float fZ){
        if (world.isRemote){
            return true;
        }
        else if (meta != 1){
            return false;
        }else{
            ++intY;
            AceBed blockbed;
                  if(0 == this.getUnlocalizedName().compareTo("tile.BedBlack")){     blockbed = (AceBed)ShopKeeper.bedBlack;
            }else if(0 == this.getUnlocalizedName().compareTo("tile.BedBlue")) {     blockbed = (AceBed)ShopKeeper.bedBlue;
            }else if(0 == this.getUnlocalizedName().compareTo("tile.BedBrown")){     blockbed = (AceBed)ShopKeeper.bedBrown;
            }else if(0 == this.getUnlocalizedName().compareTo("tile.BedCyan")) {     blockbed = (AceBed)ShopKeeper.bedCyan;
            }else if(0 == this.getUnlocalizedName().compareTo("tile.BedGreen")){     blockbed = (AceBed)ShopKeeper.bedGreen;
            }else if(0 == this.getUnlocalizedName().compareTo("tile.BedGrey")) {     blockbed = (AceBed)ShopKeeper.bedGrey;
            }else if(0 == this.getUnlocalizedName().compareTo("tile.BedLightBlue")){ blockbed = (AceBed)ShopKeeper.bedLightBlue;
            }else if(0 == this.getUnlocalizedName().compareTo("tile.BedLime"))    {  blockbed = (AceBed)ShopKeeper.bedLime;
            }else if(0 == this.getUnlocalizedName().compareTo("tile.BedMagenta")) {  blockbed = (AceBed)ShopKeeper.bedMagenta;
            }else if(0 == this.getUnlocalizedName().compareTo("tile.BedOrange"))  {  blockbed = (AceBed)ShopKeeper.bedOrange;
            }else if(0 == this.getUnlocalizedName().compareTo("tile.BedPink"))    {  blockbed = (AceBed)ShopKeeper.bedPink;
            }else if(0 == this.getUnlocalizedName().compareTo("tile.BedPurple"))  {  blockbed = (AceBed)ShopKeeper.bedPurple;
            }else if(0 == this.getUnlocalizedName().compareTo("tile.BedRed"))     {  blockbed = (AceBed)ShopKeeper.bedRed;
            }else if(0 == this.getUnlocalizedName().compareTo("tile.BedSilver"))  {  blockbed = (AceBed)ShopKeeper.bedSilver;
            }else if(0 == this.getUnlocalizedName().compareTo("tile.BedWhite"))   {  blockbed = (AceBed)ShopKeeper.bedWhite;
            }else if(0 == this.getUnlocalizedName().compareTo("tile.BedYellow"))  {  blockbed = (AceBed)ShopKeeper.bedYellow;
            }else{
            	blockbed = (AceBed)ShopKeeper.bedRed;
            }
            int i1 = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
            byte b0 = 0;
            byte b1 = 0;
            if (i1 == 0){ b1 =  1; }
            if (i1 == 1){ b0 = -1; }
            if (i1 == 2){ b1 = -1; }
            if (i1 == 3){ b0 =  1; }
            if (player.canPlayerEdit(intX, intY, intZ, meta, stack) && player.canPlayerEdit(intX + b0, intY, intZ + b1, meta, stack)){
                if (world.isAirBlock(intX, intY, intZ) && world.isAirBlock(intX + b0, intY, intZ + b1) && World.doesBlockHaveSolidTopSurface(world, intX, intY - 1, intZ) && World.doesBlockHaveSolidTopSurface(world, intX + b0, intY - 1, intZ + b1)){
                    world.setBlock(intX, intY, intZ, blockbed, i1, 3);
                    if (world.getBlock(intX, intY, intZ) == blockbed){
                        world.setBlock(intX + b0, intY, intZ + b1, blockbed, i1 + 8, 3);
                    }
                    --stack.stackSize;
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
    }

}