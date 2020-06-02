package net.acecraft.mod.container;

import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.crafting.StoveCraftingManager;
import net.acecraft.mod.tileentity.TileEntityStove;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerStove extends Container {
	
	public InventoryCrafting craftMatrix;
	public IInventory craftResult;
	private World worldObj;
	private int posX;
	private int posY;
	private int posZ;
	TileEntityStove entity;
	
	public ContainerStove(InventoryPlayer invPlayer, World world, int x, int y, int z) {
		craftMatrix = new InventoryCrafting(this, 2, 3);
		craftResult = new InventoryCraftResult();
		worldObj = world;
		posX = x;
		posY = y;
		posZ = z;
		this.addSlotToContainer(new SlotCrafting(invPlayer.player, craftMatrix, craftResult, 0, 70, 67));
		for(int k = 0; k < 6; k++) {
			this.addSlotToContainer(new Slot(craftMatrix, k, 27 + k * 18, 15));
		}
		for (int i = 0; i < 3; i++) {
			for(int k = 0; k < 9; k++) {
				this.addSlotToContainer(new Slot(invPlayer, k + i * 9 + 9, 8 + k * 18, 106 + i * 18));
			}
		}
		for (int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 164));
		}
		onCraftMatrixChanged(craftMatrix);
	}
	
	public ContainerStove(InventoryPlayer inventory, TileEntityStove _entity) {
		craftMatrix = new InventoryCrafting(this, 2, 3);
		craftResult = new InventoryCraftResult();
		worldObj = _entity.getWorldObj();
		this.addSlotToContainer(new SlotCrafting(inventory.player, craftMatrix, craftResult, 0, 70, 67));
		for(int k = 0; k < 6; k++) {
			this.addSlotToContainer(new Slot(craftMatrix, k, 27 + k * 18, 15));
		}
		for (int i = 0; i < 3; i++) {
			for(int k = 0; k < 9; k++) {
				this.addSlotToContainer(new Slot(inventory, k + i * 9 + 9, 8 + k * 18, 106 + i * 18));
			}
		}
		for (int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 164));
		}
		entity = _entity;
		onCraftMatrixChanged(craftMatrix);
	}
	
	public void onCraftMatrixChanged(IInventory iiventory) {
		ItemStack item = StoveCraftingManager.getInstance().findMatchingRecipe(craftMatrix, worldObj);
		if(item != null){
			item = checkRecipe(item, entity.hasFurnace, entity.hasCauldron);
		}
		craftResult.setInventorySlotContents(0, item);
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}
	
	public void onContainerClosed(EntityPlayer player) {
        super.onContainerClosed(player);
        for (int i = 0; i < 6; ++i){
            ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);
            if (itemstack != null){
                player.dropPlayerItemWithRandomChoice(itemstack, false);
            }
        }
    }
	
	public ItemStack transferStackInSlot(EntityPlayer player, int i) {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(i);
        if (slot != null && slot.getHasStack()){
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (i == 0){
                if (!this.mergeItemStack(itemstack1, 10, 46, true)){
                    return null;
                }
                slot.onSlotChange(itemstack1, itemstack);
            }else if (i >= 10 && i < 37){
                if (!this.mergeItemStack(itemstack1, 37, 46, false)){
                    return null;
                }
            }else if (i >= 37 && i < 46){
                if (!this.mergeItemStack(itemstack1, 10, 37, false)){
                    return null;
                }
            }else if (!this.mergeItemStack(itemstack1, 10, 46, false)){
                return null;
            }
            if (itemstack1.stackSize == 0){
                slot.putStack((ItemStack)null);
            }else{
                slot.onSlotChanged();
            }
            if (itemstack1.stackSize == itemstack.stackSize){
                return null;
            }
            slot.onPickupFromSlot(player, itemstack1);
        }
        return itemstack;
    }
	
	private int CheckResult(Item item){
		
		return 0;
	}
	
	private ItemStack checkRecipe(ItemStack stack, boolean hasFurnace, boolean hasCauldron){
		if(stack.getItem() == Items.bread){ if(hasFurnace && hasCauldron){ return stack; }else{ return null; } }
		if(stack.getItem() == Items.cookie){ if(hasFurnace && hasCauldron){ return stack; }else{ return null; } }
		if(stack.getItem() == Items.cake){ if(hasFurnace){ return stack; }else{ return null; } }
		if(stack.getItem() == Items.pumpkin_pie){ if(hasFurnace){ return stack; }else{ return null; } }
		if(stack.getItem() == Items.mushroom_stew){ if(hasCauldron){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.juiceCoffee){ if(hasFurnace){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodDungeonFilet){ if(hasFurnace && hasCauldron){ return stack; }else{ return null; } }
		
		if(stack.getItem() == ShopKeeper.foodStirFry){ if(hasFurnace){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodFriedRice){ if(hasFurnace){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodSavoryPancake){ if(hasFurnace){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodFrenchFries){ if(hasFurnace){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodCroquette){ if(hasFurnace){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodPopcorn){ if(hasFurnace){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodScrambledEggs){ if(hasFurnace){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodOmelet){ if(hasFurnace){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodOmeletRice){ if(hasFurnace){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodAppleSouffle){ if(hasFurnace){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodCurryBread){ if(hasFurnace){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodFrenchToast){ if(hasFurnace){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodDoughnut){ if(hasFurnace){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodFriedNoodles){ if(hasFurnace){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodTempura){ if(hasFurnace){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodPancake){ if(hasFurnace){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodPotSticker){ if(hasFurnace){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodRisotto){ if(hasFurnace){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodDryCurry){ if(hasFurnace){ return stack; }else{ return null; } }
		
		if(stack.getItem() == ShopKeeper.foodPumpkinStew){ if(hasCauldron){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodFishStew){ if(hasCauldron){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodBoiledEgg){ if(hasCauldron){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodDumplings){ if(hasCauldron){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodCheeseFondue){ if(hasCauldron){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodNoodles){ if(hasCauldron){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodCurryNoodles){ if(hasCauldron){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodTempuraNoodles){ if(hasCauldron){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodMountainStew){ if(hasCauldron){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodRiceSoup){ if(hasCauldron){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodPorridge){ if(hasCauldron){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodTempuraRice){ if(hasCauldron){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodEggOverRice){ if(hasCauldron){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodStew){ if(hasCauldron){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodCurryRice){ if(hasCauldron){ return stack; }else{ return null; } }
		
		if(stack.getItem() == ShopKeeper.foodBakedCorn){ if(hasFurnace){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodToastedRiceBall){ if(hasFurnace){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodToast){ if(hasFurnace){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodDinnerRoll){ if(hasFurnace){ return stack; }else{ return null; } }
		if(stack           == new ItemStack(ShopKeeper.foodPizza)){ if(hasFurnace){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodDoria){ if(hasFurnace){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodGratin){ if(hasFurnace){ return stack; }else{ return null; } }
		if(stack           == new ItemStack(ShopKeeper.foodChocolateCake)){ if(hasFurnace){ return stack; }else{ return null; } }
		if(stack           == new ItemStack(ShopKeeper.foodCheesecake)){ if(hasFurnace){ return stack; }else{ return null; } }
		if(stack           == new ItemStack(ShopKeeper.foodApplePie)){ if(hasFurnace){ return stack; }else{ return null; } }
		
		if(stack.getItem() == ShopKeeper.foodSteamedBun){ if(hasFurnace && hasCauldron){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodCheeseSteamedBun){ if(hasFurnace && hasCauldron){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodShaomai){ if(hasFurnace && hasCauldron){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodSteamedEgg){ if(hasFurnace && hasCauldron){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodChineseBun){ if(hasFurnace && hasCauldron){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodCurryBun){ if(hasFurnace && hasCauldron){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodSteamedDumplings){ if(hasFurnace && hasCauldron){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodSpongeCake){ if(hasFurnace && hasCauldron){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodSteamedCake){ if(hasFurnace && hasCauldron){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodPudding){ if(hasFurnace && hasCauldron){ return stack; }else{ return null; } }
		if(stack.getItem() == ShopKeeper.foodPumpkinPudding){ if(hasFurnace && hasCauldron){ return stack; }else{ return null; } }
		return stack;
	}

}