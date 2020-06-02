package net.acecraft.mod.render;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.entity.EntityNugget;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderNugget<T extends EntityNugget> extends RenderSnowball<T>
{
    protected final Item field_177084_a;
    private final RenderItem field_177083_e;

    public RenderNugget(RenderManager renderManagerIn, Item p_i46137_2_, RenderItem p_i46137_3_)
    {
        super(renderManagerIn, p_i46137_2_, p_i46137_3_);
        this.field_177084_a = p_i46137_2_;
        this.field_177083_e = p_i46137_3_;
    }
    
}