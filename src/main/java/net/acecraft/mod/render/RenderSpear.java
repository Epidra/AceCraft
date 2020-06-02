package net.acecraft.mod.render;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.entity.EntitySpear;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;

public class RenderSpear<T extends EntitySpear> extends RenderArrow<T>
{
	
	private static final ResourceLocation arrowTextures = new ResourceLocation("textures/entity/arrow.png");
	
    public RenderSpear(RenderManager renderItem)
    {
        super(renderItem);
    }
    
    protected ResourceLocation getEntityTexture(T entity){
    	EntitySpear spear = (EntitySpear)entity;
    	     if(spear.id.compareTo("ToolSpearFlint")      == 0) { return new ResourceLocation(AceCraft.modid + ":" + "textures/entity/SpearFlint.png"); }
    	else if(spear.id.compareTo("ToolSpearObsidian")   == 0) { return new ResourceLocation(AceCraft.modid + ":" + "textures/entity/SpearObsidian.png"); }
        else if(spear.id.compareTo("ToolSpearIron")       == 0) { return new ResourceLocation(AceCraft.modid + ":" + "textures/entity/SpearIron.png"); }
        else if(spear.id.compareTo("ToolSpearGold")       == 0) { return new ResourceLocation(AceCraft.modid + ":" + "textures/entity/SpearGold.png"); }
        else if(spear.id.compareTo("ToolSpearCopper")     == 0) { return new ResourceLocation(AceCraft.modid + ":" + "textures/entity/SpearCopper.png"); }
        else if(spear.id.compareTo("ToolSpearBronze")     == 0) { return new ResourceLocation(AceCraft.modid + ":" + "textures/entity/SpearBronze.png"); }
        else if(spear.id.compareTo("ToolSpearSteel")      == 0) { return new ResourceLocation(AceCraft.modid + ":" + "textures/entity/SpearSteel.png"); }
        else if(spear.id.compareTo("ToolSpearMythril")    == 0) { return new ResourceLocation(AceCraft.modid + ":" + "textures/entity/SpearMythril.png"); }
        else if(spear.id.compareTo("ToolSpearIridium")    == 0) { return new ResourceLocation(AceCraft.modid + ":" + "textures/entity/SpearIridium.png"); }
        else if(spear.id.compareTo("ToolSpearAdamantium") == 0) { return new ResourceLocation(AceCraft.modid + ":" + "textures/entity/SpearAdamantium.png"); }
        else if(spear.id.compareTo("ToolSpearUnobtanium") == 0) { return new ResourceLocation(AceCraft.modid + ":" + "textures/entity/SpearUnobtanium.png"); }
        else{ return new ResourceLocation("textures/entity/arrow.png"); }
    	
    }
}