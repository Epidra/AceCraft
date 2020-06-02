package net.acecraft.mod.renderer.entity;

import net.acecraft.mod.entity.EntityNugget;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPotion;
import net.minecraft.potion.PotionHelper;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderNugget extends Render {
	private Item fieldItem;
    private int fieldInteger;
    
    public RenderNugget(Item item, int i){
        this.fieldItem = item;
        this.fieldInteger = i;
    }
    
    public RenderNugget(Item item){
        this(item, 0);
    }
    
    public void doRender(Entity entity, double dX, double dY, double dZ, float fA, float fB){
        IIcon iicon = this.fieldItem.getIconFromDamage(this.fieldInteger);
        if (iicon != null){
            GL11.glPushMatrix();
            GL11.glTranslatef((float)dX, (float)dY, (float)dZ);
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glScalef(0.5F, 0.5F, 0.5F);
            this.bindEntityTexture(entity);
            Tessellator tessellator = Tessellator.instance;
            if (iicon == ItemPotion.func_94589_d("bottle_splash")){
                int i = PotionHelper.func_77915_a(((EntityPotion)entity).getPotionDamage(), false);
                float f2 = (float)(i >> 16 & 255) / 255.0F;
                float f3 = (float)(i >> 8 & 255) / 255.0F;
                float f4 = (float)(i & 255) / 255.0F;
                GL11.glColor3f(f2, f3, f4);
                GL11.glPushMatrix();
                this.func_77026_a(tessellator, ItemPotion.func_94589_d("overlay"));
                GL11.glPopMatrix();
                GL11.glColor3f(1.0F, 1.0F, 1.0F);
            }
            this.func_77026_a(tessellator, iicon);
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
            GL11.glPopMatrix();
        }
    }
    
    protected ResourceLocation getEntityTexture(Entity entity){
        return TextureMap.locationItemsTexture;
    }
    
    private void func_77026_a(Tessellator tessellator, IIcon icon){
        float f  = icon.getMinU();
        float f1 = icon.getMaxU();
        float f2 = icon.getMinV();
        float f3 = icon.getMaxV();
        float f4 = 1.0F;
        float f5 = 0.5F;
        float f6 = 0.25F;
        GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        tessellator.addVertexWithUV((double)(0.0F - f5), (double)(0.0F - f6), 0.0D, (double)f , (double)f3);
        tessellator.addVertexWithUV((double)(  f4 - f5), (double)(0.0F - f6), 0.0D, (double)f1, (double)f3);
        tessellator.addVertexWithUV((double)(  f4 - f5), (double)(  f4 - f6), 0.0D, (double)f1, (double)f2);
        tessellator.addVertexWithUV((double)(0.0F - f5), (double)(  f4 - f6), 0.0D, (double)f , (double)f2);
        tessellator.draw();
    }
}
