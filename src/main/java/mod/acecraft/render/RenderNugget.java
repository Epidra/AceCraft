package mod.acecraft.render;

import mod.acecraft.entity.EntityNugget;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderNugget extends RenderSnowball<EntityNugget> {
	
public static final Factory FACTORY = new Factory();
	
    public RenderNugget(RenderManager renderManagerIn, RenderItem itemRendererIn){
        super(renderManagerIn, Items.POTIONITEM, itemRendererIn);
    }

    public ItemStack getStackToRender(EntityNugget entityIn){
        return entityIn.getNugget();
    }
    
    public static class Factory implements IRenderFactory<EntityNugget>{
    	public Render<? super EntityNugget> createRenderFor(RenderManager manager){
    		return new RenderNugget(manager, Minecraft.getMinecraft().getRenderItem());
    	}
    }
	
}
