package net.acecraft.mod.render;

import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.entity.EntityDynamite;
import net.acecraft.mod.entity.EntityNugget;
import net.acecraft.mod.render.RenderDynamite.Factory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

/*@SideOnly(Side.CLIENT)
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
    
}*/

public class RenderNugget <T extends EntityNugget> extends Render<T> {
	
	public static final Factory FACTORY = new Factory();
	
	protected final Item item;
    private final RenderItem itemRenderer;

    public RenderNugget(RenderManager renderManagerIn, Item itemIn, RenderItem itemRendererIn)
    {
        super(renderManagerIn);
        this.item = itemIn;
        this.itemRenderer = itemRendererIn;
    }

    /**
     * Renders the desired {@code T} type Entity.
     */
    public void doRender(T entity, double x, double y, double z, float entityYaw, float partialTicks){
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.enableRescaleNormal();
        GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate((float)(this.renderManager.options.thirdPersonView == 2 ? -1 : 1) * this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
        this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);

        if (this.renderOutlines)
        {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(entity));
        }

        this.itemRenderer.renderItem(this.getStackToRender(entity), ItemCameraTransforms.TransformType.GROUND);

        if (this.renderOutlines)
        {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }

        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    public ItemStack getStackToRender(T entity){
             if(entity.id.compareTo("NuggetIron")       == 0) { return new ItemStack(ShopKeeper.nuggetIron); }
        else if(entity.id.compareTo("NuggetGold")       == 0) { return new ItemStack(ShopKeeper.nuggetGold); }
        else if(entity.id.compareTo("NuggetCopper")     == 0) { return new ItemStack(ShopKeeper.nuggetCopper); }
        else if(entity.id.compareTo("NuggetBauxite")    == 0) { return new ItemStack(ShopKeeper.nuggetBauxite); }
        else if(entity.id.compareTo("NuggetLead")       == 0) { return new ItemStack(ShopKeeper.nuggetLead); }
        else if(entity.id.compareTo("NuggetTin")        == 0) { return new ItemStack(ShopKeeper.nuggetTin); }
        else if(entity.id.compareTo("NuggetZinc")       == 0) { return new ItemStack(ShopKeeper.nuggetZinc); }
        else if(entity.id.compareTo("NuggetSilver")     == 0) { return new ItemStack(ShopKeeper.nuggetSilver); }
        else if(entity.id.compareTo("NuggetMythril")    == 0) { return new ItemStack(ShopKeeper.nuggetMythril); }
        else if(entity.id.compareTo("NuggetIridium")    == 0) { return new ItemStack(ShopKeeper.nuggetIridium); }
        else if(entity.id.compareTo("NuggetAdamantium") == 0) { return new ItemStack(ShopKeeper.nuggetAdamantium); }
        else if(entity.id.compareTo("NuggetUnobtanium") == 0) { return new ItemStack(ShopKeeper.nuggetUnobtanium); }
    	return new ItemStack(Items.FLINT);
    }

	@Override
	protected ResourceLocation getEntityTexture(T entity) {
		return TextureMap.LOCATION_BLOCKS_TEXTURE;
	}
	
	public static class Factory implements IRenderFactory<EntityNugget>{
    	public Render<? super EntityNugget> createRenderFor(RenderManager manager){
    		return new RenderNugget(manager, ShopKeeper.nuggetIron, Minecraft.getMinecraft().getRenderItem());
    	}
    }
}
