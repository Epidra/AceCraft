package net.acecraft.mod.renderer.tile;

import org.lwjgl.opengl.GL11;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.model.ModelScaffolding00;
import net.acecraft.mod.model.ModelScaffolding01;
import net.acecraft.mod.model.ModelScaffolding02;
import net.acecraft.mod.model.ModelScaffolding03;
import net.acecraft.mod.model.ModelScaffolding04;
import net.acecraft.mod.model.ModelScaffolding05;
import net.acecraft.mod.model.ModelScaffolding06;
import net.acecraft.mod.model.ModelScaffolding07;
import net.acecraft.mod.model.ModelScaffolding08;
import net.acecraft.mod.model.ModelScaffolding09;
import net.acecraft.mod.model.ModelScaffolding10;
import net.acecraft.mod.model.ModelScaffolding11;
import net.acecraft.mod.model.ModelScaffolding12;
import net.acecraft.mod.model.ModelScaffolding13;
import net.acecraft.mod.model.ModelScaffolding14;
import net.acecraft.mod.tileentity.TileEntityScaffolding;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderScaffolding extends TileEntitySpecialRenderer {
	
	private static final ResourceLocation textureAcacia     = new ResourceLocation(AceCraft.modid + ":" + "textures/model/ScaffoldingAcacia.png");
	private static final ResourceLocation textureAdamantium = new ResourceLocation(AceCraft.modid + ":" + "textures/model/ScaffoldingAdamantium.png");
	private static final ResourceLocation textureAluminium  = new ResourceLocation(AceCraft.modid + ":" + "textures/model/ScaffoldingAluminium.png");
	private static final ResourceLocation textureBigOak     = new ResourceLocation(AceCraft.modid + ":" + "textures/model/ScaffoldingBigOak.png");
	private static final ResourceLocation textureBirch      = new ResourceLocation(AceCraft.modid + ":" + "textures/model/ScaffoldingBirch.png");
	private static final ResourceLocation textureBronze     = new ResourceLocation(AceCraft.modid + ":" + "textures/model/ScaffoldingBronze.png");
	private static final ResourceLocation textureCopper     = new ResourceLocation(AceCraft.modid + ":" + "textures/model/ScaffoldingCopper.png");
	private static final ResourceLocation textureIron       = new ResourceLocation(AceCraft.modid + ":" + "textures/model/ScaffoldingIron.png");
	private static final ResourceLocation textureJungle     = new ResourceLocation(AceCraft.modid + ":" + "textures/model/ScaffoldingJungle.png");
	private static final ResourceLocation textureMythril    = new ResourceLocation(AceCraft.modid + ":" + "textures/model/ScaffoldingMythril.png");
	private static final ResourceLocation textureOak        = new ResourceLocation(AceCraft.modid + ":" + "textures/model/ScaffoldingOak.png");
	private static final ResourceLocation textureSpruce     = new ResourceLocation(AceCraft.modid + ":" + "textures/model/ScaffoldingSpruce.png");
	private static final ResourceLocation textureSteel      = new ResourceLocation(AceCraft.modid + ":" + "textures/model/ScaffoldingSteel.png");
	private static final ResourceLocation textureUnobtanium = new ResourceLocation(AceCraft.modid + ":" + "textures/model/ScaffoldingUnobtanium.png");
	private static final ResourceLocation textureFruit      = new ResourceLocation(AceCraft.modid + ":" + "textures/model/ScaffoldingFruit.png");
	private static final ResourceLocation textureGolden     = new ResourceLocation(AceCraft.modid + ":" + "textures/model/ScaffoldingGolden.png");
	private static final ResourceLocation texturePalm       = new ResourceLocation(AceCraft.modid + ":" + "textures/model/ScaffoldingPalm.png");
	
	private ModelScaffolding00 model00;
	private ModelScaffolding01 model01;
	private ModelScaffolding02 model02;
	private ModelScaffolding03 model03;
	private ModelScaffolding04 model04;
	private ModelScaffolding05 model05;
	private ModelScaffolding06 model06;
	private ModelScaffolding07 model07;
	private ModelScaffolding08 model08;
	private ModelScaffolding09 model09;
	private ModelScaffolding10 model10;
	private ModelScaffolding11 model11;
	private ModelScaffolding12 model12;
	private ModelScaffolding13 model13;
	private ModelScaffolding14 model14;
	
	private ResourceLocation texture;
	
	public RenderScaffolding(String t){
		this.model00 = new ModelScaffolding00();
		this.model01 = new ModelScaffolding01();
		this.model02 = new ModelScaffolding02();
		this.model03 = new ModelScaffolding03();
		this.model04 = new ModelScaffolding04();
		this.model05 = new ModelScaffolding05();
		this.model06 = new ModelScaffolding06();
		this.model07 = new ModelScaffolding07();
		this.model08 = new ModelScaffolding08();
		this.model09 = new ModelScaffolding09();
		this.model10 = new ModelScaffolding10();
		this.model11 = new ModelScaffolding11();
		this.model12 = new ModelScaffolding12();
		this.model13 = new ModelScaffolding13();
		this.model14 = new ModelScaffolding14();
		CreateTexture(t,14,0,true);
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
        int i = 14;
		int s = 0;
		if (tileentity.getWorldObj() != null){
        	Block block = tileentity.getBlockType();
            TileEntityScaffolding entity = (TileEntityScaffolding) tileentity;
            i = entity.indicator;
            s = entity.shift;
            CreateTexture(block, entity.indicator, entity.shift, entity.top);
        }else{
        	
        }
        GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F); 
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        GL11.glRotatef(s*90 + 180, 0.0F, 1.0F, 0F);
		if(i ==  0) this.model00.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		if(i ==  1) this.model01.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		if(i ==  2) this.model02.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		if(i ==  3) this.model03.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		if(i ==  4) this.model04.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		if(i ==  5) this.model05.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		if(i ==  6) this.model06.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		if(i ==  7) this.model07.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		if(i ==  8) this.model08.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		if(i ==  9) this.model09.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		if(i == 10) this.model10.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		if(i == 11) this.model11.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		if(i == 12) this.model12.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		if(i == 13) this.model13.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		if(i == 14) this.model14.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
	
	private void CreateTexture(Block block, int i, int s, boolean tp){
		String stringA = readBlockType(block);
		String stringB = "";
		if(i<10){
			stringB = "0"+i;
		}else{
			stringB = ""+i;
		}
		String stringC = "";
		String stringD = "";
		if(tp){
			stringC = "Top";
			if(s == 1 || s == 3) stringD = "Invert";
		}
		texture = new ResourceLocation(AceCraft.modid + ":" + "textures/model/scaffolding/Scaffolding" + stringA + stringB + stringC + stringD + ".png");
	}
	
	private void CreateTexture(String t, int i, int s, boolean tp){
		String stringA = t;
		String stringB = "";
		if(i<10){
			stringB = "0"+i;
		}else{
			stringB = ""+i;
		}
		String stringC = "";
		String stringD = "";
		if(tp){
			stringC = "Top";
			if(s == 1 || s == 3) stringD = "Invert";
		}
		texture = new ResourceLocation(AceCraft.modid + ":" + "textures/model/scaffolding/Scaffolding" + stringA + stringB + stringC + stringD + ".png");
	}
	
	private String readBlockType(Block block){
		if(block == ShopKeeper.scaffoldingAcacia)     return "Acacia";
		if(block == ShopKeeper.scaffoldingAdamantium) return "Adamantium";
		if(block == ShopKeeper.scaffoldingAluminium)  return "Aluminium";
		if(block == ShopKeeper.scaffoldingBigOak)     return "BigOak";
		if(block == ShopKeeper.scaffoldingBirch)      return "Birch";
		if(block == ShopKeeper.scaffoldingBronze)     return "Bronze";
		if(block == ShopKeeper.scaffoldingCopper)     return "Copper";
		if(block == ShopKeeper.scaffoldingIron)       return "Iron";
		if(block == ShopKeeper.scaffoldingJungle)     return "Jungle";
		if(block == ShopKeeper.scaffoldingMythril)    return "Mythril";
		if(block == ShopKeeper.scaffoldingOak)        return "Oak";
		if(block == ShopKeeper.scaffoldingSpruce)     return "Spruce";
		if(block == ShopKeeper.scaffoldingSteel)      return "Steel";
		if(block == ShopKeeper.scaffoldingUnobtanium) return "Unobtanium";
		if(block == ShopKeeper.scaffoldingFruit)      return "Fruit";
		if(block == ShopKeeper.scaffoldingGolden)     return "Golden";
		if(block == ShopKeeper.scaffoldingPalm)       return "Palm";
		return "void";
	}

}