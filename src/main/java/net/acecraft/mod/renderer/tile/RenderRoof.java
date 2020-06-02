package net.acecraft.mod.renderer.tile;

import net.acecraft.mod.AceCraft;
import net.acecraft.mod.ShopKeeper;
import net.acecraft.mod.model.ModelRoofInsideChild1;
import net.acecraft.mod.model.ModelRoofInsideChild2;
import net.acecraft.mod.model.ModelRoofInsideChild3;
import net.acecraft.mod.model.ModelRoofInsideParent;
import net.acecraft.mod.model.ModelRoofOutsideChild;
import net.acecraft.mod.model.ModelRoofOutsideParent;
import net.acecraft.mod.model.ModelRoofStraightChild1;
import net.acecraft.mod.model.ModelRoofStraightChild2;
import net.acecraft.mod.model.ModelRoofStraightParent;
import net.acecraft.mod.tileentity.TileEntityRoof;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderRoof extends TileEntitySpecialRenderer {
	
	private static final ResourceLocation textureGroundPlanksAcacia     = new ResourceLocation(AceCraft.modid + ":" + "textures/model/roof/RoofGroundPlanksAcacia.png");
	private static final ResourceLocation textureGroundPlanksBigOak     = new ResourceLocation(AceCraft.modid + ":" + "textures/model/roof/RoofGroundPlanksBigOak.png");
	private static final ResourceLocation textureGroundPlanksBirch      = new ResourceLocation(AceCraft.modid + ":" + "textures/model/roof/RoofGroundPlanksBirch.png");
	private static final ResourceLocation textureGroundPlanksJungle     = new ResourceLocation(AceCraft.modid + ":" + "textures/model/roof/RoofGroundPlanksJungle.png");
	private static final ResourceLocation textureGroundPlanksOak        = new ResourceLocation(AceCraft.modid + ":" + "textures/model/roof/RoofGroundPlanksOak.png");
	private static final ResourceLocation textureGroundPlanksSpruce     = new ResourceLocation(AceCraft.modid + ":" + "textures/model/roof/RoofGroundPlanksSpruce.png");
	private static final ResourceLocation textureGroundPlanksFruit      = new ResourceLocation(AceCraft.modid + ":" + "textures/model/roof/RoofGroundPlanksFruit.png");
	private static final ResourceLocation textureGroundPlanksGolden     = new ResourceLocation(AceCraft.modid + ":" + "textures/model/roof/RoofGroundPlanksGolden.png");
	private static final ResourceLocation textureGroundPlanksPalm       = new ResourceLocation(AceCraft.modid + ":" + "textures/model/roof/RoofGroundPlanksPalm.png");
	private static final ResourceLocation textureGroundBrick            = new ResourceLocation(AceCraft.modid + ":" + "textures/model/roof/RoofGroundBrick.png");
	private static final ResourceLocation textureGroundCobblestone      = new ResourceLocation(AceCraft.modid + ":" + "textures/model/roof/RoofGroundCobblestone.png");
	private static final ResourceLocation textureGroundCobblestoneMossy = new ResourceLocation(AceCraft.modid + ":" + "textures/model/roof/RoofGroundCobblestoneMossy.png");
	private static final ResourceLocation textureGroundStonebrick       = new ResourceLocation(AceCraft.modid + ":" + "textures/model/roof/RoofGroundStonebrick.png");
	private static final ResourceLocation textureGroundStonebrickMossy  = new ResourceLocation(AceCraft.modid + ":" + "textures/model/roof/RoofGroundStonebrickMossy.png");
	private static final ResourceLocation textureGroundSandstone        = new ResourceLocation(AceCraft.modid + ":" + "textures/model/roof/RoofGroundSandstone.png");
	private static final ResourceLocation textureGroundNether           = new ResourceLocation(AceCraft.modid + ":" + "textures/model/roof/RoofGroundNether.png");
	private static final ResourceLocation textureGroundQuartz           = new ResourceLocation(AceCraft.modid + ":" + "textures/model/roof/RoofGroundQuartz.png");
	
	private static final ResourceLocation textureCoverStraw      = new ResourceLocation(AceCraft.modid + ":" + "textures/model/roof/RoofCoverStraw.png");
	private static final ResourceLocation textureCoverReeds      = new ResourceLocation(AceCraft.modid + ":" + "textures/model/roof/RoofCoverReeds.png");
	private static final ResourceLocation textureCoverClay       = new ResourceLocation(AceCraft.modid + ":" + "textures/model/roof/RoofCoverClay.png");
	private static final ResourceLocation textureCoverCopper     = new ResourceLocation(AceCraft.modid + ":" + "textures/model/roof/RoofCoverCopper.png");
	private static final ResourceLocation textureCoverTin        = new ResourceLocation(AceCraft.modid + ":" + "textures/model/roof/RoofCoverTin.png");
	private static final ResourceLocation textureCoverBrass      = new ResourceLocation(AceCraft.modid + ":" + "textures/model/roof/RoofCoverBrass.png");
	private static final ResourceLocation textureCoverGold       = new ResourceLocation(AceCraft.modid + ":" + "textures/model/roof/RoofCoverGold.png");
	private static final ResourceLocation textureCoverMythril    = new ResourceLocation(AceCraft.modid + ":" + "textures/model/roof/RoofCoverMythril.png");
	private static final ResourceLocation textureCoverOrichalcum = new ResourceLocation(AceCraft.modid + ":" + "textures/model/roof/RoofCoverOrichalcum.png");
	private static final ResourceLocation textureCoverNether     = new ResourceLocation(AceCraft.modid + ":" + "textures/model/roof/RoofCoverNether.png");
	
	private ModelRoofStraightParent modelS0;
	private ModelRoofStraightChild1 modelS1;
	private ModelRoofStraightChild2 modelS2;
	private ModelRoofOutsideParent  modelO0;
	private ModelRoofOutsideChild   modelO1;
	private ModelRoofInsideParent   modelI0;
	private ModelRoofInsideChild1   modelI1;
	private ModelRoofInsideChild2   modelI3;
	private ModelRoofInsideChild3   modelI2;
	
	private String ground;
	private String cover;
	
	public RenderRoof(String _ground, String _cover){
		this.modelS0 = new ModelRoofStraightParent();
		this.modelS1 = new ModelRoofStraightChild1();
		this.modelS2 = new ModelRoofStraightChild2();
		this.modelO0 = new ModelRoofOutsideParent();
		this.modelO1 = new ModelRoofOutsideChild();
		this.modelI0 = new ModelRoofInsideParent();
		this.modelI1 = new ModelRoofInsideChild1();
		this.modelI3 = new ModelRoofInsideChild2();
		this.modelI2 = new ModelRoofInsideChild3();
		ground = _ground;
		cover  = _cover;
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		ResourceLocation textureGround = getTextureGround(ground);
		ResourceLocation textureCover  = getTextureCover(cover);
		Block block = Blocks.bedrock;
		int i = 0;
		int j = 0;
		int m = 0;
		boolean dS = true;
		boolean dO = false;
		boolean dI = false;
		boolean d1 = false;
		boolean d2 = false;
		boolean turn = false;
        if (tileentity.getWorldObj() != null){
        	TileEntityRoof entity = (TileEntityRoof) tileentity;
        	block = entity.getBlockType();
        	textureGround = getTexture(block, false);
        	textureCover  = getTexture(block,  true);
        	i = entity.meta;
        	m = entity.getBlockMetadata();
        	dS = entity.dS;
        	dI = entity.dI;
        	dO = entity.dO;
        	d1 = entity.d1;
        	d2 = entity.d2;
        	turn = entity.turn;
        }
		if(i == 4) j = 270;
        if(i == 3) j = 180;
        if(i == 5) j =  90;
        if(i == 2) j =   0;
        if(turn) j = j + 90;
		if(dS){
			GL11.glPushMatrix();
		    GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F); 
			Minecraft.getMinecraft().renderEngine.bindTexture(textureGround);
			GL11.glPushMatrix();
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(j, 0.0F, 1.0F, 0F);
            if(i == 0) GL11.glRotatef(180.0F, 0.0F, 1.0F, 0F);
			this.modelS0.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
			
			GL11.glPushMatrix();
		    GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F); 
			Minecraft.getMinecraft().renderEngine.bindTexture(textureCover);
			GL11.glPushMatrix();
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(j, 0.0F, 1.0F, 0F);
            if(i == 0) GL11.glRotatef(180.0F, 0.0F, 1.0F, 0F);
			this.modelS1.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
			if(d1){
				GL11.glPushMatrix();
			    GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F); 
				Minecraft.getMinecraft().renderEngine.bindTexture(textureCover);
				GL11.glPushMatrix();
				GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
	            GL11.glRotatef(j, 0.0F, 1.0F, 0F);
	            if(i == 0) GL11.glRotatef(180.0F, 0.0F, 1.0F, 0F);
				this.modelS2.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
				GL11.glPopMatrix();
			}
		}else if(dO){
			GL11.glPushMatrix();
		    GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F); 
			Minecraft.getMinecraft().renderEngine.bindTexture(textureGround);
			GL11.glPushMatrix();
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(j-90, 0.0F, 1.0F, 0F);
            if(i == 0) GL11.glRotatef(180.0F, 0.0F, 1.0F, 0F);
			this.modelO0.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
			
			GL11.glPushMatrix();
		    GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F); 
			Minecraft.getMinecraft().renderEngine.bindTexture(textureCover);
			GL11.glPushMatrix();
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(j-90, 0.0F, 1.0F, 0F);
            if(i == 0) GL11.glRotatef(180.0F, 0.0F, 1.0F, 0F);
			this.modelO1.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
		}else if(dI){
			GL11.glPushMatrix();
		    GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F); 
			Minecraft.getMinecraft().renderEngine.bindTexture(textureGround);
			GL11.glPushMatrix();
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(j-90, 0.0F, 1.0F, 0F);
            if(i == 0) GL11.glRotatef(180.0F, 0.0F, 1.0F, 0F);
			this.modelI0.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
			
			GL11.glPushMatrix();
		    GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F); 
			Minecraft.getMinecraft().renderEngine.bindTexture(textureCover);
			GL11.glPushMatrix();
			GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
            GL11.glRotatef(j-90, 0.0F, 1.0F, 0F);
            if(i == 0) GL11.glRotatef(180.0F, 0.0F, 1.0F, 0F);
			this.modelI1.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
			if(d1){
				GL11.glPushMatrix();
			    GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F); 
				Minecraft.getMinecraft().renderEngine.bindTexture(textureCover);
				GL11.glPushMatrix();
				GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
	            GL11.glRotatef(j-90, 0.0F, 1.0F, 0F);
	            if(i == 0) GL11.glRotatef(180.0F, 0.0F, 1.0F, 0F);
				this.modelI2.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
				GL11.glPopMatrix();
			}
			if(d2){
				GL11.glPushMatrix();
			    GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F); 
				Minecraft.getMinecraft().renderEngine.bindTexture(textureCover);
				GL11.glPushMatrix();
				GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
	            GL11.glRotatef(j-90, 0.0F, 1.0F, 0F);
	            if(i == 0) GL11.glRotatef(180.0F, 0.0F, 1.0F, 0F);
				this.modelI3.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
				GL11.glPopMatrix();
				GL11.glPopMatrix();
			}
		}
	}
	
	public ResourceLocation getTextureGround(String s){
		
		if(0 == s.compareTo("Acacia"))           return textureGroundPlanksAcacia;
		if(0 == s.compareTo("BigOak"))           return textureGroundPlanksBigOak;
		if(0 == s.compareTo("Birch"))            return textureGroundPlanksBirch;
		if(0 == s.compareTo("Jungle"))           return textureGroundPlanksJungle;
		if(0 == s.compareTo("Oak"))              return textureGroundPlanksOak;
		if(0 == s.compareTo("Spruce"))           return textureGroundPlanksSpruce;
		if(0 == s.compareTo("Fruit"))            return textureGroundPlanksFruit;
		if(0 == s.compareTo("Golden"))           return textureGroundPlanksGolden;
		if(0 == s.compareTo("Palm"))             return textureGroundPlanksPalm;
		if(0 == s.compareTo("Brick"))            return textureGroundBrick;
		if(0 == s.compareTo("Cobblestone"))      return textureGroundCobblestone;
		if(0 == s.compareTo("CobblestoneMossy")) return textureGroundCobblestoneMossy;
		if(0 == s.compareTo("Stonebrick"))       return textureGroundStonebrick;
		if(0 == s.compareTo("StonebrickMossy"))  return textureGroundStonebrickMossy;
		if(0 == s.compareTo("Sandstone"))        return textureGroundSandstone;
		if(0 == s.compareTo("Nether"))           return textureGroundNether;
		if(0 == s.compareTo("Quartz"))           return textureGroundQuartz;
		
		return textureGroundQuartz;
	}
	
	public ResourceLocation getTextureCover(String s){
		
		if(0 == s.compareTo("Straw"))      return textureCoverStraw;
		if(0 == s.compareTo("Reeds"))      return textureCoverReeds;
		if(0 == s.compareTo("Clay"))       return textureCoverClay;
		if(0 == s.compareTo("Copper"))     return textureCoverCopper;
		if(0 == s.compareTo("Tin"))        return textureCoverTin;
		if(0 == s.compareTo("Brass"))      return textureCoverBrass;
		if(0 == s.compareTo("Gold"))       return textureCoverGold;
		if(0 == s.compareTo("Mythril"))    return textureCoverMythril;
		if(0 == s.compareTo("Orichalcum")) return textureCoverOrichalcum;
		if(0 == s.compareTo("Nether"))     return textureCoverNether;
		
		return textureCoverStraw;
	}
	
	public ResourceLocation getTexture(Block block, boolean roof){
		
		if(block == ShopKeeper.roofAcaciaStraw)     { if(roof) { return textureCoverStraw;      } else { return textureGroundPlanksAcacia; } }
		if(block == ShopKeeper.roofAcaciaReeds)     { if(roof) { return textureCoverReeds;      } else { return textureGroundPlanksAcacia; } }
		if(block == ShopKeeper.roofAcaciaClay)      { if(roof) { return textureCoverClay;       } else { return textureGroundPlanksAcacia; } }
		if(block == ShopKeeper.roofAcaciaCopper)    { if(roof) { return textureCoverCopper;     } else { return textureGroundPlanksAcacia; } }
		if(block == ShopKeeper.roofAcaciaTin)       { if(roof) { return textureCoverTin;        } else { return textureGroundPlanksAcacia; } }
		if(block == ShopKeeper.roofAcaciaBrass)     { if(roof) { return textureCoverBrass;      } else { return textureGroundPlanksAcacia; } }
		if(block == ShopKeeper.roofAcaciaGold)      { if(roof) { return textureCoverGold;       } else { return textureGroundPlanksAcacia; } }
		if(block == ShopKeeper.roofAcaciaMythril)   { if(roof) { return textureCoverMythril;    } else { return textureGroundPlanksAcacia; } }
		if(block == ShopKeeper.roofAcaciaOrichalcum){ if(roof) { return textureCoverOrichalcum; } else { return textureGroundPlanksAcacia; } }
		if(block == ShopKeeper.roofAcaciaNether)    { if(roof) { return textureCoverNether;     } else { return textureGroundPlanksAcacia; } }
		
		if(block == ShopKeeper.roofBigOakStraw)     { if(roof) { return textureCoverStraw;      } else { return textureGroundPlanksBigOak; } }
		if(block == ShopKeeper.roofBigOakReeds)     { if(roof) { return textureCoverReeds;      } else { return textureGroundPlanksBigOak; } }
		if(block == ShopKeeper.roofBigOakClay)      { if(roof) { return textureCoverClay;       } else { return textureGroundPlanksBigOak; } }
		if(block == ShopKeeper.roofBigOakCopper)    { if(roof) { return textureCoverCopper;     } else { return textureGroundPlanksBigOak; } }
		if(block == ShopKeeper.roofBigOakTin)       { if(roof) { return textureCoverTin;        } else { return textureGroundPlanksBigOak; } }
		if(block == ShopKeeper.roofBigOakBrass)     { if(roof) { return textureCoverBrass;      } else { return textureGroundPlanksBigOak; } }
		if(block == ShopKeeper.roofBigOakGold)      { if(roof) { return textureCoverGold;       } else { return textureGroundPlanksBigOak; } }
		if(block == ShopKeeper.roofBigOakMythril)   { if(roof) { return textureCoverMythril;    } else { return textureGroundPlanksBigOak; } }
		if(block == ShopKeeper.roofBigOakOrichalcum){ if(roof) { return textureCoverOrichalcum; } else { return textureGroundPlanksBigOak; } }
		if(block == ShopKeeper.roofBigOakNether)    { if(roof) { return textureCoverNether;     } else { return textureGroundPlanksBigOak; } }
		
		if(block == ShopKeeper.roofBirchStraw)     { if(roof) { return textureCoverStraw;      } else { return textureGroundPlanksBirch; } }
		if(block == ShopKeeper.roofBirchReeds)     { if(roof) { return textureCoverReeds;      } else { return textureGroundPlanksBirch; } }
		if(block == ShopKeeper.roofBirchClay)      { if(roof) { return textureCoverClay;       } else { return textureGroundPlanksBirch; } }
		if(block == ShopKeeper.roofBirchCopper)    { if(roof) { return textureCoverCopper;     } else { return textureGroundPlanksBirch; } }
		if(block == ShopKeeper.roofBirchTin)       { if(roof) { return textureCoverTin;        } else { return textureGroundPlanksBirch; } }
		if(block == ShopKeeper.roofBirchBrass)     { if(roof) { return textureCoverBrass;      } else { return textureGroundPlanksBirch; } }
		if(block == ShopKeeper.roofBirchGold)      { if(roof) { return textureCoverGold;       } else { return textureGroundPlanksBirch; } }
		if(block == ShopKeeper.roofBirchMythril)   { if(roof) { return textureCoverMythril;    } else { return textureGroundPlanksBirch; } }
		if(block == ShopKeeper.roofBirchOrichalcum){ if(roof) { return textureCoverOrichalcum; } else { return textureGroundPlanksBirch; } }
		if(block == ShopKeeper.roofBirchNether)    { if(roof) { return textureCoverNether;     } else { return textureGroundPlanksBirch; } }
		
		if(block == ShopKeeper.roofJungleStraw)     { if(roof) { return textureCoverStraw;      } else { return textureGroundPlanksJungle; } }
		if(block == ShopKeeper.roofJungleReeds)     { if(roof) { return textureCoverReeds;      } else { return textureGroundPlanksJungle; } }
		if(block == ShopKeeper.roofJungleClay)      { if(roof) { return textureCoverClay;       } else { return textureGroundPlanksJungle; } }
		if(block == ShopKeeper.roofJungleCopper)    { if(roof) { return textureCoverCopper;     } else { return textureGroundPlanksJungle; } }
		if(block == ShopKeeper.roofJungleTin)       { if(roof) { return textureCoverTin;        } else { return textureGroundPlanksJungle; } }
		if(block == ShopKeeper.roofJungleBrass)     { if(roof) { return textureCoverBrass;      } else { return textureGroundPlanksJungle; } }
		if(block == ShopKeeper.roofJungleGold)      { if(roof) { return textureCoverGold;       } else { return textureGroundPlanksJungle; } }
		if(block == ShopKeeper.roofJungleMythril)   { if(roof) { return textureCoverMythril;    } else { return textureGroundPlanksJungle; } }
		if(block == ShopKeeper.roofJungleOrichalcum){ if(roof) { return textureCoverOrichalcum; } else { return textureGroundPlanksJungle; } }
		if(block == ShopKeeper.roofJungleNether)    { if(roof) { return textureCoverNether;     } else { return textureGroundPlanksJungle; } }
		
		if(block == ShopKeeper.roofOakStraw)     { if(roof) { return textureCoverStraw;      } else { return textureGroundPlanksOak; } }
		if(block == ShopKeeper.roofOakReeds)     { if(roof) { return textureCoverReeds;      } else { return textureGroundPlanksOak; } }
		if(block == ShopKeeper.roofOakClay)      { if(roof) { return textureCoverClay;       } else { return textureGroundPlanksOak; } }
		if(block == ShopKeeper.roofOakCopper)    { if(roof) { return textureCoverCopper;     } else { return textureGroundPlanksOak; } }
		if(block == ShopKeeper.roofOakTin)       { if(roof) { return textureCoverTin;        } else { return textureGroundPlanksOak; } }
		if(block == ShopKeeper.roofOakBrass)     { if(roof) { return textureCoverBrass;      } else { return textureGroundPlanksOak; } }
		if(block == ShopKeeper.roofOakGold)      { if(roof) { return textureCoverGold;       } else { return textureGroundPlanksOak; } }
		if(block == ShopKeeper.roofOakMythril)   { if(roof) { return textureCoverMythril;    } else { return textureGroundPlanksOak; } }
		if(block == ShopKeeper.roofOakOrichalcum){ if(roof) { return textureCoverOrichalcum; } else { return textureGroundPlanksOak; } }
		if(block == ShopKeeper.roofOakNether)    { if(roof) { return textureCoverNether;     } else { return textureGroundPlanksOak; } }
		
		if(block == ShopKeeper.roofSpruceStraw)     { if(roof) { return textureCoverStraw;      } else { return textureGroundPlanksSpruce; } }
		if(block == ShopKeeper.roofSpruceReeds)     { if(roof) { return textureCoverReeds;      } else { return textureGroundPlanksSpruce; } }
		if(block == ShopKeeper.roofSpruceClay)      { if(roof) { return textureCoverClay;       } else { return textureGroundPlanksSpruce; } }
		if(block == ShopKeeper.roofSpruceCopper)    { if(roof) { return textureCoverCopper;     } else { return textureGroundPlanksSpruce; } }
		if(block == ShopKeeper.roofSpruceTin)       { if(roof) { return textureCoverTin;        } else { return textureGroundPlanksSpruce; } }
		if(block == ShopKeeper.roofSpruceBrass)     { if(roof) { return textureCoverBrass;      } else { return textureGroundPlanksSpruce; } }
		if(block == ShopKeeper.roofSpruceGold)      { if(roof) { return textureCoverGold;       } else { return textureGroundPlanksSpruce; } }
		if(block == ShopKeeper.roofSpruceMythril)   { if(roof) { return textureCoverMythril;    } else { return textureGroundPlanksSpruce; } }
		if(block == ShopKeeper.roofSpruceOrichalcum){ if(roof) { return textureCoverOrichalcum; } else { return textureGroundPlanksSpruce; } }
		if(block == ShopKeeper.roofSpruceNether)    { if(roof) { return textureCoverNether;     } else { return textureGroundPlanksSpruce; } }
		
		if(block == ShopKeeper.roofFruitStraw)     { if(roof) { return textureCoverStraw;      } else { return textureGroundPlanksFruit; } }
		if(block == ShopKeeper.roofFruitReeds)     { if(roof) { return textureCoverReeds;      } else { return textureGroundPlanksFruit; } }
		if(block == ShopKeeper.roofFruitClay)      { if(roof) { return textureCoverClay;       } else { return textureGroundPlanksFruit; } }
		if(block == ShopKeeper.roofFruitCopper)    { if(roof) { return textureCoverCopper;     } else { return textureGroundPlanksFruit; } }
		if(block == ShopKeeper.roofFruitTin)       { if(roof) { return textureCoverTin;        } else { return textureGroundPlanksFruit; } }
		if(block == ShopKeeper.roofFruitBrass)     { if(roof) { return textureCoverBrass;      } else { return textureGroundPlanksFruit; } }
		if(block == ShopKeeper.roofFruitGold)      { if(roof) { return textureCoverGold;       } else { return textureGroundPlanksFruit; } }
		if(block == ShopKeeper.roofFruitMythril)   { if(roof) { return textureCoverMythril;    } else { return textureGroundPlanksFruit; } }
		if(block == ShopKeeper.roofFruitOrichalcum){ if(roof) { return textureCoverOrichalcum; } else { return textureGroundPlanksFruit; } }
		if(block == ShopKeeper.roofFruitNether)    { if(roof) { return textureCoverNether;     } else { return textureGroundPlanksFruit; } }
		
		if(block == ShopKeeper.roofGoldenStraw)     { if(roof) { return textureCoverStraw;      } else { return textureGroundPlanksGolden; } }
		if(block == ShopKeeper.roofGoldenReeds)     { if(roof) { return textureCoverReeds;      } else { return textureGroundPlanksGolden; } }
		if(block == ShopKeeper.roofGoldenClay)      { if(roof) { return textureCoverClay;       } else { return textureGroundPlanksGolden; } }
		if(block == ShopKeeper.roofGoldenCopper)    { if(roof) { return textureCoverCopper;     } else { return textureGroundPlanksGolden; } }
		if(block == ShopKeeper.roofGoldenTin)       { if(roof) { return textureCoverTin;        } else { return textureGroundPlanksGolden; } }
		if(block == ShopKeeper.roofGoldenBrass)     { if(roof) { return textureCoverBrass;      } else { return textureGroundPlanksGolden; } }
		if(block == ShopKeeper.roofGoldenGold)      { if(roof) { return textureCoverGold;       } else { return textureGroundPlanksGolden; } }
		if(block == ShopKeeper.roofGoldenMythril)   { if(roof) { return textureCoverMythril;    } else { return textureGroundPlanksGolden; } }
		if(block == ShopKeeper.roofGoldenOrichalcum){ if(roof) { return textureCoverOrichalcum; } else { return textureGroundPlanksGolden; } }
		if(block == ShopKeeper.roofGoldenNether)    { if(roof) { return textureCoverNether;     } else { return textureGroundPlanksGolden; } }
		
		if(block == ShopKeeper.roofPalmStraw)     { if(roof) { return textureCoverStraw;      } else { return textureGroundPlanksPalm; } }
		if(block == ShopKeeper.roofPalmReeds)     { if(roof) { return textureCoverReeds;      } else { return textureGroundPlanksPalm; } }
		if(block == ShopKeeper.roofPalmClay)      { if(roof) { return textureCoverClay;       } else { return textureGroundPlanksPalm; } }
		if(block == ShopKeeper.roofPalmCopper)    { if(roof) { return textureCoverCopper;     } else { return textureGroundPlanksPalm; } }
		if(block == ShopKeeper.roofPalmTin)       { if(roof) { return textureCoverTin;        } else { return textureGroundPlanksPalm; } }
		if(block == ShopKeeper.roofPalmBrass)     { if(roof) { return textureCoverBrass;      } else { return textureGroundPlanksPalm; } }
		if(block == ShopKeeper.roofPalmGold)      { if(roof) { return textureCoverGold;       } else { return textureGroundPlanksPalm; } }
		if(block == ShopKeeper.roofPalmMythril)   { if(roof) { return textureCoverMythril;    } else { return textureGroundPlanksPalm; } }
		if(block == ShopKeeper.roofPalmOrichalcum){ if(roof) { return textureCoverOrichalcum; } else { return textureGroundPlanksPalm; } }
		if(block == ShopKeeper.roofPalmNether)    { if(roof) { return textureCoverNether;     } else { return textureGroundPlanksPalm; } }
		
		if(block == ShopKeeper.roofBrickStraw)     { if(roof) { return textureCoverStraw;      } else { return textureGroundBrick; } }
		if(block == ShopKeeper.roofBrickReeds)     { if(roof) { return textureCoverReeds;      } else { return textureGroundBrick; } }
		if(block == ShopKeeper.roofBrickClay)      { if(roof) { return textureCoverClay;       } else { return textureGroundBrick; } }
		if(block == ShopKeeper.roofBrickCopper)    { if(roof) { return textureCoverCopper;     } else { return textureGroundBrick; } }
		if(block == ShopKeeper.roofBrickTin)       { if(roof) { return textureCoverTin;        } else { return textureGroundBrick; } }
		if(block == ShopKeeper.roofBrickBrass)     { if(roof) { return textureCoverBrass;      } else { return textureGroundBrick; } }
		if(block == ShopKeeper.roofBrickGold)      { if(roof) { return textureCoverGold;       } else { return textureGroundBrick; } }
		if(block == ShopKeeper.roofBrickMythril)   { if(roof) { return textureCoverMythril;    } else { return textureGroundBrick; } }
		if(block == ShopKeeper.roofBrickOrichalcum){ if(roof) { return textureCoverOrichalcum; } else { return textureGroundBrick; } }
		if(block == ShopKeeper.roofBrickNether)    { if(roof) { return textureCoverNether;     } else { return textureGroundBrick; } }
		
		if(block == ShopKeeper.roofCobblestoneStraw)     { if(roof) { return textureCoverStraw;      } else { return textureGroundCobblestone; } }
		if(block == ShopKeeper.roofCobblestoneReeds)     { if(roof) { return textureCoverReeds;      } else { return textureGroundCobblestone; } }
		if(block == ShopKeeper.roofCobblestoneClay)      { if(roof) { return textureCoverClay;       } else { return textureGroundCobblestone; } }
		if(block == ShopKeeper.roofCobblestoneCopper)    { if(roof) { return textureCoverCopper;     } else { return textureGroundCobblestone; } }
		if(block == ShopKeeper.roofCobblestoneTin)       { if(roof) { return textureCoverTin;        } else { return textureGroundCobblestone; } }
		if(block == ShopKeeper.roofCobblestoneBrass)     { if(roof) { return textureCoverBrass;      } else { return textureGroundCobblestone; } }
		if(block == ShopKeeper.roofCobblestoneGold)      { if(roof) { return textureCoverGold;       } else { return textureGroundCobblestone; } }
		if(block == ShopKeeper.roofCobblestoneMythril)   { if(roof) { return textureCoverMythril;    } else { return textureGroundCobblestone; } }
		if(block == ShopKeeper.roofCobblestoneOrichalcum){ if(roof) { return textureCoverOrichalcum; } else { return textureGroundCobblestone; } }
		if(block == ShopKeeper.roofCobblestoneNether)    { if(roof) { return textureCoverNether;     } else { return textureGroundCobblestone; } }
		
		if(block == ShopKeeper.roofCobblestoneMossyStraw)     { if(roof) { return textureCoverStraw;      } else { return textureGroundCobblestoneMossy; } }
		if(block == ShopKeeper.roofCobblestoneMossyReeds)     { if(roof) { return textureCoverReeds;      } else { return textureGroundCobblestoneMossy; } }
		if(block == ShopKeeper.roofCobblestoneMossyClay)      { if(roof) { return textureCoverClay;       } else { return textureGroundCobblestoneMossy; } }
		if(block == ShopKeeper.roofCobblestoneMossyCopper)    { if(roof) { return textureCoverCopper;     } else { return textureGroundCobblestoneMossy; } }
		if(block == ShopKeeper.roofCobblestoneMossyTin)       { if(roof) { return textureCoverTin;        } else { return textureGroundCobblestoneMossy; } }
		if(block == ShopKeeper.roofCobblestoneMossyBrass)     { if(roof) { return textureCoverBrass;      } else { return textureGroundCobblestoneMossy; } }
		if(block == ShopKeeper.roofCobblestoneMossyGold)      { if(roof) { return textureCoverGold;       } else { return textureGroundCobblestoneMossy; } }
		if(block == ShopKeeper.roofCobblestoneMossyMythril)   { if(roof) { return textureCoverMythril;    } else { return textureGroundCobblestoneMossy; } }
		if(block == ShopKeeper.roofCobblestoneMossyOrichalcum){ if(roof) { return textureCoverOrichalcum; } else { return textureGroundCobblestoneMossy; } }
		if(block == ShopKeeper.roofCobblestoneMossyNether)    { if(roof) { return textureCoverNether;     } else { return textureGroundCobblestoneMossy; } }
		
		if(block == ShopKeeper.roofStonebrickStraw)     { if(roof) { return textureCoverStraw;      } else { return textureGroundStonebrick; } }
		if(block == ShopKeeper.roofStonebrickReeds)     { if(roof) { return textureCoverReeds;      } else { return textureGroundStonebrick; } }
		if(block == ShopKeeper.roofStonebrickClay)      { if(roof) { return textureCoverClay;       } else { return textureGroundStonebrick; } }
		if(block == ShopKeeper.roofStonebrickCopper)    { if(roof) { return textureCoverCopper;     } else { return textureGroundStonebrick; } }
		if(block == ShopKeeper.roofStonebrickTin)       { if(roof) { return textureCoverTin;        } else { return textureGroundStonebrick; } }
		if(block == ShopKeeper.roofStonebrickBrass)     { if(roof) { return textureCoverBrass;      } else { return textureGroundStonebrick; } }
		if(block == ShopKeeper.roofStonebrickGold)      { if(roof) { return textureCoverGold;       } else { return textureGroundStonebrick; } }
		if(block == ShopKeeper.roofStonebrickMythril)   { if(roof) { return textureCoverMythril;    } else { return textureGroundStonebrick; } }
		if(block == ShopKeeper.roofStonebrickOrichalcum){ if(roof) { return textureCoverOrichalcum; } else { return textureGroundStonebrick; } }
		if(block == ShopKeeper.roofStonebrickNether)    { if(roof) { return textureCoverNether;     } else { return textureGroundStonebrick; } }
		
		if(block == ShopKeeper.roofStonebrickMossyStraw)     { if(roof) { return textureCoverStraw;      } else { return textureGroundStonebrickMossy; } }
		if(block == ShopKeeper.roofStonebrickMossyReeds)     { if(roof) { return textureCoverReeds;      } else { return textureGroundStonebrickMossy; } }
		if(block == ShopKeeper.roofStonebrickMossyClay)      { if(roof) { return textureCoverClay;       } else { return textureGroundStonebrickMossy; } }
		if(block == ShopKeeper.roofStonebrickMossyCopper)    { if(roof) { return textureCoverCopper;     } else { return textureGroundStonebrickMossy; } }
		if(block == ShopKeeper.roofStonebrickMossyTin)       { if(roof) { return textureCoverTin;        } else { return textureGroundStonebrickMossy; } }
		if(block == ShopKeeper.roofStonebrickMossyBrass)     { if(roof) { return textureCoverBrass;      } else { return textureGroundStonebrickMossy; } }
		if(block == ShopKeeper.roofStonebrickMossyGold)      { if(roof) { return textureCoverGold;       } else { return textureGroundStonebrickMossy; } }
		if(block == ShopKeeper.roofStonebrickMossyMythril)   { if(roof) { return textureCoverMythril;    } else { return textureGroundStonebrickMossy; } }
		if(block == ShopKeeper.roofStonebrickMossyOrichalcum){ if(roof) { return textureCoverOrichalcum; } else { return textureGroundStonebrickMossy; } }
		if(block == ShopKeeper.roofStonebrickMossyNether)    { if(roof) { return textureCoverNether;     } else { return textureGroundStonebrickMossy; } }
		
		if(block == ShopKeeper.roofSandstoneStraw)     { if(roof) { return textureCoverStraw;      } else { return textureGroundSandstone; } }
		if(block == ShopKeeper.roofSandstoneReeds)     { if(roof) { return textureCoverReeds;      } else { return textureGroundSandstone; } }
		if(block == ShopKeeper.roofSandstoneClay)      { if(roof) { return textureCoverClay;       } else { return textureGroundSandstone; } }
		if(block == ShopKeeper.roofSandstoneCopper)    { if(roof) { return textureCoverCopper;     } else { return textureGroundSandstone; } }
		if(block == ShopKeeper.roofSandstoneTin)       { if(roof) { return textureCoverTin;        } else { return textureGroundSandstone; } }
		if(block == ShopKeeper.roofSandstoneBrass)     { if(roof) { return textureCoverBrass;      } else { return textureGroundSandstone; } }
		if(block == ShopKeeper.roofSandstoneGold)      { if(roof) { return textureCoverGold;       } else { return textureGroundSandstone; } }
		if(block == ShopKeeper.roofSandstoneMythril)   { if(roof) { return textureCoverMythril;    } else { return textureGroundSandstone; } }
		if(block == ShopKeeper.roofSandstoneOrichalcum){ if(roof) { return textureCoverOrichalcum; } else { return textureGroundSandstone; } }
		if(block == ShopKeeper.roofSandstoneNether)    { if(roof) { return textureCoverNether;     } else { return textureGroundSandstone; } }
		
		if(block == ShopKeeper.roofNetherStraw)     { if(roof) { return textureCoverStraw;      } else { return textureGroundNether; } }
		if(block == ShopKeeper.roofNetherReeds)     { if(roof) { return textureCoverReeds;      } else { return textureGroundNether; } }
		if(block == ShopKeeper.roofNetherClay)      { if(roof) { return textureCoverClay;       } else { return textureGroundNether; } }
		if(block == ShopKeeper.roofNetherCopper)    { if(roof) { return textureCoverCopper;     } else { return textureGroundNether; } }
		if(block == ShopKeeper.roofNetherTin)       { if(roof) { return textureCoverTin;        } else { return textureGroundNether; } }
		if(block == ShopKeeper.roofNetherBrass)     { if(roof) { return textureCoverBrass;      } else { return textureGroundNether; } }
		if(block == ShopKeeper.roofNetherGold)      { if(roof) { return textureCoverGold;       } else { return textureGroundNether; } }
		if(block == ShopKeeper.roofNetherMythril)   { if(roof) { return textureCoverMythril;    } else { return textureGroundNether; } }
		if(block == ShopKeeper.roofNetherOrichalcum){ if(roof) { return textureCoverOrichalcum; } else { return textureGroundNether; } }
		if(block == ShopKeeper.roofNetherNether)    { if(roof) { return textureCoverNether;     } else { return textureGroundNether; } }
		
		if(block == ShopKeeper.roofQuartzStraw)     { if(roof) { return textureCoverStraw;      } else { return textureGroundQuartz; } }
		if(block == ShopKeeper.roofQuartzReeds)     { if(roof) { return textureCoverReeds;      } else { return textureGroundQuartz; } }
		if(block == ShopKeeper.roofQuartzClay)      { if(roof) { return textureCoverClay;       } else { return textureGroundQuartz; } }
		if(block == ShopKeeper.roofQuartzCopper)    { if(roof) { return textureCoverCopper;     } else { return textureGroundQuartz; } }
		if(block == ShopKeeper.roofQuartzTin)       { if(roof) { return textureCoverTin;        } else { return textureGroundQuartz; } }
		if(block == ShopKeeper.roofQuartzBrass)     { if(roof) { return textureCoverBrass;      } else { return textureGroundQuartz; } }
		if(block == ShopKeeper.roofQuartzGold)      { if(roof) { return textureCoverGold;       } else { return textureGroundQuartz; } }
		if(block == ShopKeeper.roofQuartzMythril)   { if(roof) { return textureCoverMythril;    } else { return textureGroundQuartz; } }
		if(block == ShopKeeper.roofQuartzOrichalcum){ if(roof) { return textureCoverOrichalcum; } else { return textureGroundQuartz; } }
		if(block == ShopKeeper.roofQuartzNether)    { if(roof) { return textureCoverNether;     } else { return textureGroundQuartz; } }
		
		return textureGroundQuartz;
	}

}