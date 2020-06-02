package net.acecraft.mod.container;

import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.acecraft.mod.tileentity.TileEntityAnvil;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class ContainerAnvilRepair extends Container
{
    private static final Logger logger = LogManager.getLogger();
    private IInventory outputSlot = new InventoryCraftResult();
    private IInventory inputSlots = new InventoryBasic("Repair", true, 2){
        public void markDirty(){
            super.markDirty();
            ContainerAnvilRepair.this.onCraftMatrixChanged(this);
        }
    };
    private World theWorld;
    private int x;
    private int y;
    private int z;
    public int maximumCost;
    public int stackSizeToBeUsedInRepair;
    private String repairedItemName;
    private final EntityPlayer thePlayer;
    
    public ContainerAnvilRepair(InventoryPlayer inventory, final TileEntityAnvil entity) {
    	this.theWorld = entity.getWorldObj();
        this.x = entity.xCoord;
        this.y = entity.yCoord;
        this.z = entity.zCoord;
        this.thePlayer = inventory.player;
        this.addSlotToContainer(new Slot(this.inputSlots, 0, 27, 47));
        this.addSlotToContainer(new Slot(this.inputSlots, 1, 76, 47));
        this.addSlotToContainer(new Slot(this.outputSlot, 2, 134, 47){
            public boolean isItemValid(ItemStack stack){
                return false;
            }
            public boolean canTakeStack(EntityPlayer player){
                return (player.capabilities.isCreativeMode || player.experienceLevel >= ContainerAnvilRepair.this.maximumCost) && ContainerAnvilRepair.this.maximumCost > 0 && this.getHasStack();
            }
            public void onPickupFromSlot(EntityPlayer player, ItemStack stack){
                if (!player.capabilities.isCreativeMode){
                    player.addExperienceLevel(-ContainerAnvilRepair.this.maximumCost);
                }
                float breakChance = ForgeHooks.onAnvilRepair(player, stack, ContainerAnvilRepair.this.inputSlots.getStackInSlot(0), ContainerAnvilRepair.this.inputSlots.getStackInSlot(1));
                ContainerAnvilRepair.this.inputSlots.setInventorySlotContents(0, (ItemStack)null);
                if (ContainerAnvilRepair.this.stackSizeToBeUsedInRepair > 0){
                    ItemStack itemstack1 = ContainerAnvilRepair.this.inputSlots.getStackInSlot(1);
                    if (itemstack1 != null && itemstack1.stackSize > ContainerAnvilRepair.this.stackSizeToBeUsedInRepair){
                        itemstack1.stackSize -= ContainerAnvilRepair.this.stackSizeToBeUsedInRepair;
                        ContainerAnvilRepair.this.inputSlots.setInventorySlotContents(1, itemstack1);
                    }else{
                        ContainerAnvilRepair.this.inputSlots.setInventorySlotContents(1, (ItemStack)null);
                    }
                }else{
                    ContainerAnvilRepair.this.inputSlots.setInventorySlotContents(1, (ItemStack)null);
                }
                ContainerAnvilRepair.this.maximumCost = 0;
                if (!player.capabilities.isCreativeMode && !theWorld.isRemote && theWorld.getBlock(entity.xCoord, entity.yCoord, entity.zCoord) == Blocks.anvil && player.getRNG().nextFloat() < breakChance){
                    int i1 = theWorld.getBlockMetadata(entity.xCoord, entity.yCoord, entity.zCoord);
                    int k = i1 & 3;
                    int l = i1 >> 2;
                    ++l;
                    if (l > 2){
                        theWorld.setBlockToAir(entity.xCoord, entity.yCoord, entity.zCoord);
                        theWorld.playAuxSFX(1020, entity.xCoord, entity.yCoord, entity.zCoord, 0);
                    }else{
                        theWorld.setBlockMetadataWithNotify(entity.xCoord, entity.yCoord, entity.zCoord, k | l << 2, 2);
                        theWorld.playAuxSFX(1021, entity.xCoord, entity.yCoord, entity.zCoord, 0);
                    }
                }else if (!theWorld.isRemote){
                    theWorld.playAuxSFX(1021, entity.xCoord, entity.yCoord, entity.zCoord, 0);
                }
            }
        });
        int i;
        for (i = 0; i < 3; ++i){
            for (int j = 0; j < 9; ++j){
                this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (i = 0; i < 9; ++i){
            this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
        }
	}
    
    public void onCraftMatrixChanged(IInventory inventory){
        super.onCraftMatrixChanged(inventory);
        if (inventory == this.inputSlots){
            this.updateRepairOutput();
        }
    }
    
    public void updateRepairOutput(){
        ItemStack itemstack = this.inputSlots.getStackInSlot(0);
        this.maximumCost = 0;
        int i = 0;
        byte b0 = 0;
        int j = 0;
        if (itemstack == null){
            this.outputSlot.setInventorySlotContents(0, (ItemStack)null);
            this.maximumCost = 0;
        }else{
            ItemStack itemstack1 = itemstack.copy();
            ItemStack itemstack2 = this.inputSlots.getStackInSlot(1);
            Map map = EnchantmentHelper.getEnchantments(itemstack1);
            boolean flag = false;
            int k2 = b0 + itemstack.getRepairCost() + (itemstack2 == null ? 0 : itemstack2.getRepairCost());
            this.stackSizeToBeUsedInRepair = 0;
            int k;
            int l;
            int i1;
            int k1;
            int l1;
            Iterator iterator1;
            Enchantment enchantment;
            if (itemstack2 != null){
                //if (!ForgeHooks.onAnvilChange(this, itemstack, itemstack2, outputSlot, repairedItemName, k2)) return;
                flag = itemstack2.getItem() == Items.enchanted_book && Items.enchanted_book.func_92110_g(itemstack2).tagCount() > 0;
                if (itemstack1.isItemStackDamageable() && itemstack1.getItem().getIsRepairable(itemstack, itemstack2)){
                    k = Math.min(itemstack1.getItemDamageForDisplay(), itemstack1.getMaxDamage() / 4);
                    if (k <= 0){
                        this.outputSlot.setInventorySlotContents(0, (ItemStack)null);
                        this.maximumCost = 0;
                        return;
                    }
                    for(l = 0; k > 0 && l < itemstack2.stackSize; ++l){
                        i1 = itemstack1.getItemDamageForDisplay() - k;
                        itemstack1.setItemDamage(i1);
                        i += Math.max(1, k / 100) + map.size();
                        k = Math.min(itemstack1.getItemDamageForDisplay(), itemstack1.getMaxDamage() / 4);
                    }
                    this.stackSizeToBeUsedInRepair = l;
                }else{
                    if (!flag && (itemstack1.getItem() != itemstack2.getItem() || !itemstack1.isItemStackDamageable())){
                        this.outputSlot.setInventorySlotContents(0, (ItemStack)null);
                        this.maximumCost = 0;
                        return;
                    }
                    if (itemstack1.isItemStackDamageable() && !flag){
                        k = itemstack.getMaxDamage() - itemstack.getItemDamageForDisplay();
                        l = itemstack2.getMaxDamage() - itemstack2.getItemDamageForDisplay();
                        i1 = l + itemstack1.getMaxDamage() * 12 / 100;
                        int j1 = k + i1;
                        k1 = itemstack1.getMaxDamage() - j1;
                        if (k1 < 0){
                            k1 = 0;
                        }
                        if (k1 < itemstack1.getItemDamage()){
                            itemstack1.setItemDamage(k1);
                            i += Math.max(1, i1 / 100);
                        }
                    }
                    Map map1 = EnchantmentHelper.getEnchantments(itemstack2);
                    iterator1 = map1.keySet().iterator();
                    while (iterator1.hasNext()){
                        i1 = ((Integer)iterator1.next()).intValue();
                        enchantment = Enchantment.enchantmentsList[i1];
                        k1 = map.containsKey(Integer.valueOf(i1)) ? ((Integer)map.get(Integer.valueOf(i1))).intValue() : 0;
                        l1 = ((Integer)map1.get(Integer.valueOf(i1))).intValue();
                        int i3;
                        if (k1 == l1){
                            ++l1;
                            i3 = l1;
                        }else{
                            i3 = Math.max(l1, k1);
                        }
                        l1 = i3;
                        int i2 = l1 - k1;
                        boolean flag1 = enchantment.canApply(itemstack);
                        if (this.thePlayer.capabilities.isCreativeMode || itemstack.getItem() == Items.enchanted_book){
                            flag1 = true;
                        }
                        Iterator iterator = map.keySet().iterator();
                        while (iterator.hasNext()){
                            int j2 = ((Integer)iterator.next()).intValue();
                            if (j2 != i1 && !enchantment.canApplyTogether(Enchantment.enchantmentsList[j2])){
                                flag1 = false;
                                i += i2;
                            }
                        }
                        if (flag1){
                            if (l1 > enchantment.getMaxLevel()){
                                l1 = enchantment.getMaxLevel();
                            }
                            map.put(Integer.valueOf(i1), Integer.valueOf(l1));
                            int l2 = 0;
                            switch (enchantment.getWeight()){
                                case 1:
                                    l2 = 8;
                                    break;
                                case 2:
                                    l2 = 4;
                                case 3:
                                case 4:
                                case 6:
                                case 7:
                                case 8:
                                case 9:
                                default:
                                    break;
                                case 5:
                                    l2 = 2;
                                    break;
                                case 10:
                                    l2 = 1;
                            }
                            if (flag){
                                l2 = Math.max(1, l2 / 2);
                            }
                            i += l2 * i2;
                        }
                    }
                }
            }
            if (StringUtils.isBlank(this.repairedItemName)){
                if (itemstack.hasDisplayName()){
                    j = itemstack.isItemStackDamageable() ? 7 : itemstack.stackSize * 5;
                    i += j;
                    itemstack1.func_135074_t();
                }
            }else if (!this.repairedItemName.equals(itemstack.getDisplayName())){
                j = itemstack.isItemStackDamageable() ? 7 : itemstack.stackSize * 5;
                i += j;
                if (itemstack.hasDisplayName()){
                    k2 += j / 2;
                }
                itemstack1.setStackDisplayName(this.repairedItemName);
            }
            k = 0;
            for (iterator1 = map.keySet().iterator(); iterator1.hasNext(); k2 += k + k1 * l1){
                i1 = ((Integer)iterator1.next()).intValue();
                enchantment = Enchantment.enchantmentsList[i1];
                k1 = ((Integer)map.get(Integer.valueOf(i1))).intValue();
                l1 = 0;
                ++k;
                switch (enchantment.getWeight()){
                    case 1:
                        l1 = 8;
                        break;
                    case 2:
                        l1 = 4;
                    case 3:
                    case 4:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    default:
                        break;
                    case 5:
                        l1 = 2;
                        break;
                    case 10:
                        l1 = 1;
                }
                if (flag){
                    l1 = Math.max(1, l1 / 2);
                }
            }
            if (flag){
                k2 = Math.max(1, k2 / 2);
            }
            if (flag && !itemstack1.getItem().isBookEnchantable(itemstack1, itemstack2)) itemstack1 = null;
            this.maximumCost = k2 + i;
            if (i <= 0){
                itemstack1 = null;
            }
            if (j == i && j > 0 && this.maximumCost >= 40){
                this.maximumCost = 39;
            }
            if (this.maximumCost >= 40 && !this.thePlayer.capabilities.isCreativeMode){
                itemstack1 = null;
            }
            if (itemstack1 != null){
                l = itemstack1.getRepairCost();
                if (itemstack2 != null && l < itemstack2.getRepairCost()){
                    l = itemstack2.getRepairCost();
                }
                if (itemstack1.hasDisplayName()){
                    l -= 9;
                }
                if (l < 0){
                    l = 0;
                }
                l += 2;
                itemstack1.setRepairCost(l);
                EnchantmentHelper.setEnchantments(map, itemstack1);
            }
            this.outputSlot.setInventorySlotContents(0, itemstack1);
            this.detectAndSendChanges();
        }
    }
    
    public void addCraftingToCrafters(ICrafting icrafting){
        super.addCraftingToCrafters(icrafting);
        icrafting.sendProgressBarUpdate(this, 0, this.maximumCost);
    }
    
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int slot, int value){
        if (slot == 0){
            this.maximumCost = value;
        }
    }
    
    public void onContainerClosed(EntityPlayer player){
        super.onContainerClosed(player);
        if (!this.theWorld.isRemote){
            for (int i = 0; i < this.inputSlots.getSizeInventory(); ++i){
                ItemStack itemstack = this.inputSlots.getStackInSlotOnClosing(i);
                if (itemstack != null){
                    player.dropPlayerItemWithRandomChoice(itemstack, false);
                }
            }
        }
    }
    
    public boolean canInteractWith(EntityPlayer player){
        return true;
    }
    
    public ItemStack transferStackInSlot(EntityPlayer player, int _slot){
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(_slot);
        if (slot != null && slot.getHasStack()){
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (_slot == 2){
                if (!this.mergeItemStack(itemstack1, 3, 39, true)){
                    return null;
                }
                slot.onSlotChange(itemstack1, itemstack);
            }else if (_slot != 0 && _slot != 1){
                if (_slot >= 3 && _slot < 39 && !this.mergeItemStack(itemstack1, 0, 2, false)){
                    return null;
                }
            }else if (!this.mergeItemStack(itemstack1, 3, 39, false)){
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
    
    public void updateItemName(String name){
        this.repairedItemName = name;
        if (this.getSlot(2).getHasStack()){
            ItemStack itemstack = this.getSlot(2).getStack();
            if (StringUtils.isBlank(name)){
                itemstack.func_135074_t();
            }else{
                itemstack.setStackDisplayName(this.repairedItemName);
            }
        }
        this.updateRepairOutput();
    }

}