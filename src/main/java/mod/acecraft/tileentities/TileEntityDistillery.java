package mod.acecraft.tileentities;

import javax.annotation.Nullable;

import mod.acecraft.blocks.MachinaDistillery;
import mod.acecraft.container.ContainerDistillery;
import mod.acecraft.crafting.DistilleryRecipes;
import mod.shared.tileentities.ITileEntityFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.MathHelper;

public class TileEntityDistillery extends ITileEntityFurnace implements ITickable, IInventory {
    
	public TileEntityDistillery(){
		super(4);
	}
	
    /** Returns the number of slots in the inventory. */
    public int getSizeInventory(){
        return this.inventory.size();
    }
    
    /** Returns the stack in the given slot. */
    @Nullable
    public ItemStack getStackInSlot(int index){
        return this.inventory.get(index);
    }
    
    /** Removes up to a specified number of items from an inventory slot and returns them in a new stack. */
    @Nullable
    public ItemStack decrStackSize(int index, int count){
        return ItemStackHelper.getAndSplit(this.inventory, index, count);
    }
    
    /** Removes a stack from the given slot and returns it. */
    @Nullable
    public ItemStack removeStackFromSlot(int index){
        return ItemStackHelper.getAndRemove(this.inventory, index);
    }
    
    /**
     * Like the old updateEntity(), except more generic.
     */
    public void update(){
        boolean flag = this.isBurning();
        boolean flag1 = false;
        if (this.isBurning()){
            --this.furnaceBurnTime;
        }
        if (!this.world.isRemote){
            if (this.isBurning() || this.inventory.get(1) != null && this.inventory.get(0) != null){
                if (!this.isBurning() && this.canSmelt()){
                    this.furnaceBurnTime = getItemBurnTime(this.inventory.get(2));
                    this.currentItemBurnTime = this.furnaceBurnTime;
                    if (this.isBurning()){
                        flag1 = true;
                        if (this.inventory.get(2) != null){
                            this.inventory.get(2).shrink(1);
                            if (this.inventory.get(2).getCount() == 0){
                                this.inventory.set(2, inventory.get(1).getItem().getContainerItem(inventory.get(1)));
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
                MachinaDistillery.setPowerState(this.isBurning(), this.world, this.pos);
            }
        }
        if (flag1){
            this.markDirty();
        }
    }
    
    /**
     * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canSmelt(){
        if (this.inventory.get(0) == null || this.inventory.get(1) == null || this.inventory.get(0).getItem() != Items.GLASS_BOTTLE){
            return false;
        } else {
            ItemStack itemstack = DistilleryRecipes.instance().getSmeltingResult(this.inventory.get(1));
            if (itemstack == null) return false;
            if (this.inventory.get(3).getItem() == Item.getItemFromBlock(Blocks.AIR)) return true;
            if (!this.inventory.get(3).isItemEqual(itemstack)) return false;
            int result = inventory.get(3).getCount() + itemstack.getCount();
            return result <= getInventoryStackLimit() && result <= this.inventory.get(3).getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
        }
    }
    
    /**
     * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
     */
    public void smeltItem(){
        if (this.canSmelt()){
            ItemStack itemstack = DistilleryRecipes.instance().getSmeltingResult(this.inventory.get(1));
            if (this.inventory.get(3).getItem() == Item.getItemFromBlock(Blocks.AIR)){
                this.inventory.set(3, itemstack);
            } else if (this.inventory.get(3).getItem() == itemstack.getItem()){
                this.inventory.get(3).grow(itemstack.getCount()); // Forge BugFix: Results may have multiple items
            }
            this.inventory.get(0).shrink(1);
            if (this.inventory.get(0).getCount() <= 0){
                this.inventory.set(0, null);
            }
            this.inventory.get(1).shrink(1);
            if (this.inventory.get(1).getCount() <= 0){
                this.inventory.set(1, null);
            }
        }
    }
    
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn){
        return new ContainerDistillery(playerInventory, this);
    }
    
    public void clear(){
        for (int i = 0; i < this.inventory.size(); ++i){
            this.inventory.set(i, null);
        }
    }
	
}
