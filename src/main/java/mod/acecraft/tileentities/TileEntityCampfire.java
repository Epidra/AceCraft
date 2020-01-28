package mod.acecraft.tileentities;

import javax.annotation.Nullable;

import mod.acecraft.blocks.MachinaCampfire;
import mod.acecraft.container.ContainerCampfire;
import mod.acecraft.crafting.CampfireRecipes;
import mod.shared.tileentities.ITileEntityFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.MathHelper;

public class TileEntityCampfire extends ITileEntityFurnace implements ITickable, IInventory {
	
	/** Like the old updateEntity(), except more generic. */
    public void update(){
        boolean flag = this.isBurning();
        boolean flag1 = false;
        if (this.isBurning()){
            --this.furnaceBurnTime;
        }
        if (!this.world.isRemote){
            if (this.isBurning() || this.inventory.get(1) != null){
                if (!this.isBurning()){
                    this.furnaceBurnTime = getItemBurnTime(this.inventory.get(1));
                    this.currentItemBurnTime = this.furnaceBurnTime;
                    if (this.isBurning()){
                        flag1 = true;
                        if (this.inventory.get(1) != null){
                            this.inventory.get(1).shrink(1);
                            if (this.inventory.get(1).getCount() == 0){
                                this.inventory.set(1, inventory.get(1).getItem().getContainerItem(inventory.get(1)));
                            }
                        }
                    }
                }
                if (this.isBurning() && this.canSmelt()){
                    ++this.cookTime;
                    if (this.cookTime == this.totalCookTime){
                        this.cookTime = 0;
                        this.totalCookTime = this.getCookTime(this.inventory.get(0));
                        this.smeltItem();
                        flag1 = true;
                    }
                } else {
                    this.cookTime = 0;
                }
            } else if (!this.isBurning() && this.cookTime > 0){
                this.cookTime = MathHelper.clamp(this.cookTime - 2, 0, this.totalCookTime);
            }
            if (flag != this.isBurning()){
                flag1 = true;
                MachinaCampfire.setPowerState(this.isBurning(), this.world, this.pos);
            }
        }
        if (flag1){
            this.markDirty();
        }
    }
    
    public int getCookTime(@Nullable ItemStack stack){
        return 200;
    }
    
    /** Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc. */
    private boolean canSmelt(){
        if (this.inventory.get(0) == null){
            return false;
        } else {
            ItemStack itemstack = CampfireRecipes.instance().getSmeltingResult(this.inventory.get(0));
            if (itemstack == null) return false;
            if ( this.inventory.get(2) == null) return true;
            if (!this.inventory.get(2).isItemEqual(itemstack)) return false;
            int result = inventory.get(2).getCount() + itemstack.getCount();
            return result <= getInventoryStackLimit() && result <= this.inventory.get(2).getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
        }
    }
    
    /** Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack */
    public void smeltItem(){
        if (this.canSmelt()){
            ItemStack itemstack = FurnaceRecipes.instance().getSmeltingResult(this.inventory.get(0));
            if (this.inventory.get(2) == null){
                this.inventory.set(2, itemstack);
            } else if (this.inventory.get(2).getItem() == itemstack.getItem()){
                this.inventory.get(2).grow(itemstack.getCount()); // Forge BugFix: Results may have multiple items
            }
            if (this.inventory.get(0).getItem() == Item.getItemFromBlock(Blocks.SPONGE) && this.inventory.get(0).getMetadata() == 1 && this.inventory.get(1) != null && this.inventory.get(1).getItem() == Items.BUCKET){
                this.inventory.set(1, new ItemStack(Items.WATER_BUCKET));
            }
            this.inventory.get(0).shrink(1);
            if (this.inventory.get(0).getCount() <= 0){
                this.inventory.set(0, null);
            }
        }
    }
	
	public String getGuiID(){
        return "acecraft:furnace";
    }
    
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn){
        return new ContainerCampfire(playerInventory, this);
    }
	
}
