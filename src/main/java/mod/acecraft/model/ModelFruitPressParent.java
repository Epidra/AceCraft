package mod.acecraft.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelFruitPressParent <T extends Entity> extends EntityModel<T> {

    //fields
    ModelRenderer Shape201;
    ModelRenderer Shape202;
    ModelRenderer Shape203;
    ModelRenderer Shape204;
    ModelRenderer Shape301;
    ModelRenderer Shape302;
    ModelRenderer Shape303;
    ModelRenderer Shape304;
    ModelRenderer Shape305;
    ModelRenderer Shape306;
    ModelRenderer Shape307;
    ModelRenderer Shape308;
    ModelRenderer Shape401;
    ModelRenderer Shape402;
    ModelRenderer Shape403;
    ModelRenderer Shape404;
    ModelRenderer Shape405;
    ModelRenderer Shape406;
    ModelRenderer Shape407;
    ModelRenderer Shape408;
    ModelRenderer Shape501;
    ModelRenderer Shape502;
    ModelRenderer Shape503;
    ModelRenderer Shape504;
    ModelRenderer Shape505;
    ModelRenderer Shape506;
    ModelRenderer Shape507;
    ModelRenderer Shape508;
    ModelRenderer Shape509;
    ModelRenderer Shape510;
    ModelRenderer Shape511;
    ModelRenderer Shape512;
    ModelRenderer Shape601;
    ModelRenderer Shape701;
    ModelRenderer Shape801;
    ModelRenderer Shape901;
    ModelRenderer Shape1001;
    ModelRenderer Shape1101;
    ModelRenderer Shape1201;
    ModelRenderer Shape1301;
    ModelRenderer Shape702;
    ModelRenderer Shape802;
    ModelRenderer Shape902;
    ModelRenderer Shape1002;
    ModelRenderer Shape1102;
    ModelRenderer Shape1202;
    ModelRenderer Shape1302;
    ModelRenderer Shape602;
    ModelRenderer Shape703;
    ModelRenderer Shape803;
    ModelRenderer Shape903;
    ModelRenderer Shape1003;
    ModelRenderer Shape1103;
    ModelRenderer Shape1203;
    ModelRenderer Shape1303;
    ModelRenderer Shape704;
    ModelRenderer Shape804;
    ModelRenderer Shape904;
    ModelRenderer Shape1004;
    ModelRenderer Shape1104;
    ModelRenderer Shape1204;
    ModelRenderer Shape1304;

    public ModelFruitPressParent()
    {
        textureWidth = 128;
        textureHeight = 64;

        Shape201 = new ModelRenderer(this, 18, 0);
        Shape201.addBox(-4F, -10F, -1F, 8, 20, 1);
        Shape201.setRotationPoint(0F, 14F, -14F);
        Shape201.setTextureSize(128, 64);
        Shape201.mirror = true;
        setRotation(Shape201, 0F, 0F, 0F);
        Shape202 = new ModelRenderer(this, 18, 0);
        Shape202.addBox(-4F, -10F, -1F, 8, 20, 1);
        Shape202.setRotationPoint(-14F, 14F, 0F);
        Shape202.setTextureSize(128, 64);
        Shape202.mirror = true;
        setRotation(Shape202, 0F, 1.570796F, 0F);
        Shape203 = new ModelRenderer(this, 18, 0);
        Shape203.addBox(-4F, -10F, -1F, 8, 20, 1);
        Shape203.setRotationPoint(14F, 14F, 0F);
        Shape203.setTextureSize(128, 64);
        Shape203.mirror = true;
        setRotation(Shape203, 0F, -1.570796F, 0F);
        Shape204 = new ModelRenderer(this, 18, 0);
        Shape204.addBox(-4F, -10F, -1F, 8, 20, 1);
        Shape204.setRotationPoint(0F, 14F, 14F);
        Shape204.setTextureSize(128, 64);
        Shape204.mirror = true;
        setRotation(Shape204, 0F, 3.141593F, 0F);
        Shape301 = new ModelRenderer(this, 10, 0);
        Shape301.addBox(-1.5F, -10F, -1F, 3, 20, 1);
        Shape301.setRotationPoint(-5.5F, 14F, -13F);
        Shape301.setTextureSize(128, 64);
        Shape301.mirror = true;
        setRotation(Shape301, 0F, 0F, 0F);
        Shape302 = new ModelRenderer(this, 10, 0);
        Shape302.addBox(-1.5F, -10F, -1F, 3, 20, 1);
        Shape302.setRotationPoint(5.5F, 14F, -13F);
        Shape302.setTextureSize(128, 64);
        Shape302.mirror = true;
        setRotation(Shape302, 0F, 0F, 0F);
        Shape303 = new ModelRenderer(this, 10, 0);
        Shape303.addBox(-1.5F, -10F, -1F, 3, 20, 1);
        Shape303.setRotationPoint(-13F, 14F, -5.5F);
        Shape303.setTextureSize(128, 64);
        Shape303.mirror = true;
        setRotation(Shape303, 0F, 1.570796F, 0F);
        Shape304 = new ModelRenderer(this, 10, 0);
        Shape304.addBox(-1.5F, -10F, -1F, 3, 20, 1);
        Shape304.setRotationPoint(-13F, 14F, 5.5F);
        Shape304.setTextureSize(128, 64);
        Shape304.mirror = true;
        setRotation(Shape304, 0F, 1.570796F, 0F);
        Shape305 = new ModelRenderer(this, 10, 0);
        Shape305.addBox(-1.5F, -10F, -1F, 3, 20, 1);
        Shape305.setRotationPoint(13F, 14F, -5.5F);
        Shape305.setTextureSize(128, 64);
        Shape305.mirror = true;
        setRotation(Shape305, 0F, -1.570796F, 0F);
        Shape306 = new ModelRenderer(this, 10, 0);
        Shape306.addBox(-1.5F, -10F, -1F, 3, 20, 1);
        Shape306.setRotationPoint(13F, 14F, 5.5F);
        Shape306.setTextureSize(128, 64);
        Shape306.mirror = true;
        setRotation(Shape306, 0F, -1.570796F, 0F);
        Shape307 = new ModelRenderer(this, 10, 0);
        Shape307.addBox(-1.5F, -10F, -1F, 3, 20, 1);
        Shape307.setRotationPoint(-5.5F, 14F, 13F);
        Shape307.setTextureSize(128, 64);
        Shape307.mirror = true;
        setRotation(Shape307, 0F, 3.141593F, 0F);
        Shape308 = new ModelRenderer(this, 10, 0);
        Shape308.addBox(-1.5F, -10F, 0F, 3, 20, 1);
        Shape308.setRotationPoint(5.5F, 14F, 13F);
        Shape308.setTextureSize(128, 64);
        Shape308.mirror = true;
        setRotation(Shape308, 0F, 0F, 0F);
        Shape401 = new ModelRenderer(this, 4, 0);
        Shape401.addBox(-1F, -10F, -1F, 2, 20, 1);
        Shape401.setRotationPoint(-9F, 14F, -11F);
        Shape401.setTextureSize(128, 64);
        Shape401.mirror = true;
        setRotation(Shape401, 0F, 0F, 0F);
        Shape402 = new ModelRenderer(this, 4, 0);
        Shape402.addBox(-1F, -10F, -1F, 2, 20, 1);
        Shape402.setRotationPoint(9F, 14F, -11F);
        Shape402.setTextureSize(128, 64);
        Shape402.mirror = true;
        setRotation(Shape402, 0F, 0F, 0F);
        Shape403 = new ModelRenderer(this, 4, 0);
        Shape403.addBox(-1F, -10F, -1F, 2, 20, 1);
        Shape403.setRotationPoint(-11F, 14F, -9F);
        Shape403.setTextureSize(128, 64);
        Shape403.mirror = true;
        setRotation(Shape403, 0F, 1.570796F, 0F);
        Shape404 = new ModelRenderer(this, 4, 0);
        Shape404.addBox(-1F, -10F, -1F, 2, 20, 1);
        Shape404.setRotationPoint(-11F, 14F, 9F);
        Shape404.setTextureSize(128, 64);
        Shape404.mirror = true;
        setRotation(Shape404, 0F, 1.570796F, 0F);
        Shape405 = new ModelRenderer(this, 4, 0);
        Shape405.addBox(-1F, -10F, -1F, 2, 20, 1);
        Shape405.setRotationPoint(11F, 14F, -9F);
        Shape405.setTextureSize(128, 64);
        Shape405.mirror = true;
        setRotation(Shape405, 0F, -1.570796F, 0F);
        Shape406 = new ModelRenderer(this, 4, 0);
        Shape406.addBox(-1F, -10F, -1F, 2, 20, 1);
        Shape406.setRotationPoint(11F, 14F, 9F);
        Shape406.setTextureSize(128, 64);
        Shape406.mirror = true;
        setRotation(Shape406, 0F, -1.570796F, 0F);
        Shape407 = new ModelRenderer(this, 4, 0);
        Shape407.addBox(-1F, -10F, -1F, 2, 20, 1);
        Shape407.setRotationPoint(-9F, 14F, 11F);
        Shape407.setTextureSize(128, 64);
        Shape407.mirror = true;
        setRotation(Shape407, 0F, 3.141593F, 0F);
        Shape408 = new ModelRenderer(this, 4, 0);
        Shape408.addBox(-1F, -10F, -1F, 2, 20, 1);
        Shape408.setRotationPoint(9F, 14F, 11F);
        Shape408.setTextureSize(128, 64);
        Shape408.mirror = true;
        setRotation(Shape408, 0F, -3.141593F, 0F);
        Shape501 = new ModelRenderer(this, 0, 0);
        Shape501.addBox(-0.5F, -10F, -1F, 1, 20, 1);
        Shape501.setRotationPoint(-7.5F, 14F, -12F);
        Shape501.setTextureSize(128, 64);
        Shape501.mirror = true;
        setRotation(Shape501, 0F, 0F, 0F);
        Shape502 = new ModelRenderer(this, 0, 0);
        Shape502.addBox(-0.5F, -10F, -1F, 1, 20, 1);
        Shape502.setRotationPoint(7.5F, 14F, -12F);
        Shape502.setTextureSize(128, 64);
        Shape502.mirror = true;
        setRotation(Shape502, 0F, 0F, 0F);
        Shape503 = new ModelRenderer(this, 0, 0);
        Shape503.addBox(-0.5F, -10F, -1F, 1, 20, 1);
        Shape503.setRotationPoint(-12F, 14F, -7.5F);
        Shape503.setTextureSize(128, 64);
        Shape503.mirror = true;
        setRotation(Shape503, 0F, 1.570796F, 0F);
        Shape504 = new ModelRenderer(this, 0, 0);
        Shape504.addBox(-0.5F, -10F, -1F, 1, 20, 1);
        Shape504.setRotationPoint(-12F, 14F, 7.5F);
        Shape504.setTextureSize(128, 64);
        Shape504.mirror = true;
        setRotation(Shape504, 0F, 1.570796F, 0F);
        Shape505 = new ModelRenderer(this, 0, 0);
        Shape505.addBox(-0.5F, -10F, -1F, 1, 20, 1);
        Shape505.setRotationPoint(12F, 14F, -7.5F);
        Shape505.setTextureSize(128, 64);
        Shape505.mirror = true;
        setRotation(Shape505, 0F, -1.570796F, 0F);
        Shape506 = new ModelRenderer(this, 0, 0);
        Shape506.addBox(-0.5F, -10F, -1F, 1, 20, 1);
        Shape506.setRotationPoint(12F, 14F, 7.5F);
        Shape506.setTextureSize(128, 64);
        Shape506.mirror = true;
        setRotation(Shape506, 0F, -1.570796F, 0F);
        Shape507 = new ModelRenderer(this, 0, 0);
        Shape507.addBox(-0.5F, -10F, -1F, 1, 20, 1);
        Shape507.setRotationPoint(-7.5F, 14F, 12F);
        Shape507.setTextureSize(128, 64);
        Shape507.mirror = true;
        setRotation(Shape507, 0F, 3.141593F, 0F);
        Shape508 = new ModelRenderer(this, 0, 0);
        Shape508.addBox(-0.5F, -10F, -1F, 1, 20, 1);
        Shape508.setRotationPoint(7.5F, 14F, 12F);
        Shape508.setTextureSize(128, 64);
        Shape508.mirror = true;
        setRotation(Shape508, 0F, -3.141593F, 0F);
        Shape509 = new ModelRenderer(this, 0, 0);
        Shape509.addBox(-0.5F, -10F, -1F, 1, 20, 1);
        Shape509.setRotationPoint(-10F, 14F, -10.5F);
        Shape509.setTextureSize(128, 64);
        Shape509.mirror = true;
        setRotation(Shape509, 0F, 1.570796F, 0F);
        Shape510 = new ModelRenderer(this, 0, 0);
        Shape510.addBox(-0.5F, -10F, -1F, 1, 20, 1);
        Shape510.setRotationPoint(10F, 14F, -10.5F);
        Shape510.setTextureSize(128, 64);
        Shape510.mirror = true;
        setRotation(Shape510, 0F, -1.570796F, 0F);
        Shape511 = new ModelRenderer(this, 0, 0);
        Shape511.addBox(-0.5F, -10F, -1F, 1, 20, 1);
        Shape511.setRotationPoint(-10F, 14F, 10.5F);
        Shape511.setTextureSize(128, 64);
        Shape511.mirror = true;
        setRotation(Shape511, 0F, 1.570796F, 0F);
        Shape512 = new ModelRenderer(this, 0, 0);
        Shape512.addBox(-0.5F, -10F, -1F, 1, 20, 1);
        Shape512.setRotationPoint(10F, 14F, 10.5F);
        Shape512.setTextureSize(128, 64);
        Shape512.mirror = true;
        setRotation(Shape512, 0F, -1.570796F, 0F);
        Shape601 = new ModelRenderer(this, 37, 18);
        Shape601.addBox(-14F, 0F, -4F, 28, 1, 8);
        Shape601.setRotationPoint(0F, 23F, 0F);
        Shape601.setTextureSize(128, 64);
        Shape601.mirror = true;
        setRotation(Shape601, 0F, 0F, 0F);
        Shape701 = new ModelRenderer(this, 44, 14);
        Shape701.addBox(-13F, 0F, -1.5F, 26, 1, 3);
        Shape701.setRotationPoint(0F, 23F, -5.5F);
        Shape701.setTextureSize(128, 64);
        Shape701.mirror = true;
        setRotation(Shape701, 0F, 0F, 0F);
        Shape801 = new ModelRenderer(this, 48, 12);
        Shape801.addBox(-12F, 0F, -0.5F, 24, 1, 1);
        Shape801.setRotationPoint(0F, 23F, -7.5F);
        Shape801.setTextureSize(128, 64);
        Shape801.mirror = true;
        setRotation(Shape801, 0F, 0F, 0F);
        Shape901 = new ModelRenderer(this, 49, 9);
        Shape901.addBox(-11F, 0F, -1F, 22, 1, 2);
        Shape901.setRotationPoint(0F, 23F, -9F);
        Shape901.setTextureSize(128, 64);
        Shape901.mirror = true;
        setRotation(Shape901, 0F, 0F, 0F);
        Shape1001 = new ModelRenderer(this, 52, 7);
        Shape1001.addBox(-10F, 0F, -0.5F, 20, 1, 1);
        Shape1001.setRotationPoint(0F, 23F, -10.5F);
        Shape1001.setTextureSize(128, 64);
        Shape1001.mirror = true;
        setRotation(Shape1001, 0F, 0F, 0F);
        Shape1101 = new ModelRenderer(this, 56, 5);
        Shape1101.addBox(-8F, 0F, -0.5F, 16, 1, 1);
        Shape1101.setRotationPoint(0F, 23F, -11.5F);
        Shape1101.setTextureSize(128, 64);
        Shape1101.mirror = true;
        setRotation(Shape1101, 0F, 0F, 0F);
        Shape1201 = new ModelRenderer(this, 58, 3);
        Shape1201.addBox(-7F, 0F, -0.5F, 14, 1, 1);
        Shape1201.setRotationPoint(0F, 23F, -12.5F);
        Shape1201.setTextureSize(128, 64);
        Shape1201.mirror = true;
        setRotation(Shape1201, 0F, 0F, 0F);
        Shape1301 = new ModelRenderer(this, 64, 1);
        Shape1301.addBox(-4F, 0F, -0.5F, 8, 1, 1);
        Shape1301.setRotationPoint(0F, 23F, -13.5F);
        Shape1301.setTextureSize(128, 64);
        Shape1301.mirror = true;
        setRotation(Shape1301, 0F, 0F, 0F);
        Shape702 = new ModelRenderer(this, 44, 27);
        Shape702.addBox(-13F, 0F, -1.5F, 26, 1, 3);
        Shape702.setRotationPoint(0F, 23F, 5.5F);
        Shape702.setTextureSize(128, 64);
        Shape702.mirror = true;
        setRotation(Shape702, 0F, 0F, 0F);
        Shape802 = new ModelRenderer(this, 48, 31);
        Shape802.addBox(-12F, 0F, -0.5F, 24, 1, 1);
        Shape802.setRotationPoint(0F, 23F, 7.5F);
        Shape802.setTextureSize(128, 64);
        Shape802.mirror = true;
        setRotation(Shape802, 0F, 0F, 0F);
        Shape902 = new ModelRenderer(this, 49, 33);
        Shape902.addBox(-11F, 0F, -1F, 22, 1, 2);
        Shape902.setRotationPoint(0F, 23F, 9F);
        Shape902.setTextureSize(128, 64);
        Shape902.mirror = true;
        setRotation(Shape902, 0F, 0F, 0F);
        Shape1002 = new ModelRenderer(this, 52, 36);
        Shape1002.addBox(-10F, 0F, -0.5F, 20, 1, 1);
        Shape1002.setRotationPoint(0F, 23F, 10.5F);
        Shape1002.setTextureSize(128, 64);
        Shape1002.mirror = true;
        setRotation(Shape1002, 0F, 0F, 0F);
        Shape1102 = new ModelRenderer(this, 56, 38);
        Shape1102.addBox(-8F, 0F, -0.5F, 16, 1, 1);
        Shape1102.setRotationPoint(0F, 23F, 11.5F);
        Shape1102.setTextureSize(128, 64);
        Shape1102.mirror = true;
        setRotation(Shape1102, 0F, 0F, 0F);
        Shape1202 = new ModelRenderer(this, 58, 40);
        Shape1202.addBox(-7F, 0F, -0.5F, 14, 1, 1);
        Shape1202.setRotationPoint(0F, 23F, 11.5F);
        Shape1202.setTextureSize(128, 64);
        Shape1202.mirror = true;
        setRotation(Shape1202, 0F, 0F, 0F);
        Shape1302 = new ModelRenderer(this, 64, 42);
        Shape1302.addBox(-4F, 0F, -0.5F, 8, 1, 1);
        Shape1302.setRotationPoint(0F, 23F, 13.5F);
        Shape1302.setTextureSize(128, 64);
        Shape1302.mirror = true;
        setRotation(Shape1302, 0F, 0F, 0F);
        Shape602 = new ModelRenderer(this, 37, 18);
        Shape602.addBox(-14F, -1F, -4F, 28, 1, 8);
        Shape602.setRotationPoint(0F, 12F, 0F);
        Shape602.setTextureSize(128, 64);
        Shape602.mirror = true;
        setRotation(Shape602, 0F, 0F, 0F);
        Shape703 = new ModelRenderer(this, 44, 14);
        Shape703.addBox(-13F, -1F, -1.5F, 26, 1, 3);
        Shape703.setRotationPoint(0F, 12F, -5.5F);
        Shape703.setTextureSize(128, 64);
        Shape703.mirror = true;
        setRotation(Shape703, 0F, 0F, 0F);
        Shape803 = new ModelRenderer(this, 48, 12);
        Shape803.addBox(-12F, -1F, -0.5F, 24, 1, 1);
        Shape803.setRotationPoint(0F, 12F, -7.5F);
        Shape803.setTextureSize(128, 64);
        Shape803.mirror = true;
        setRotation(Shape803, 0F, 0F, 0F);
        Shape903 = new ModelRenderer(this, 49, 9);
        Shape903.addBox(-11F, -1F, -1F, 22, 1, 2);
        Shape903.setRotationPoint(0F, 12F, -9F);
        Shape903.setTextureSize(128, 64);
        Shape903.mirror = true;
        setRotation(Shape903, 0F, 0F, 0F);
        Shape1003 = new ModelRenderer(this, 52, 7);
        Shape1003.addBox(-10F, -1F, -0.5F, 20, 1, 1);
        Shape1003.setRotationPoint(0F, 12F, -10.5F);
        Shape1003.setTextureSize(128, 64);
        Shape1003.mirror = true;
        setRotation(Shape1003, 0F, 0F, 0F);
        Shape1103 = new ModelRenderer(this, 56, 5);
        Shape1103.addBox(-8F, -1F, -0.5F, 16, 1, 1);
        Shape1103.setRotationPoint(0F, 12F, -11.5F);
        Shape1103.setTextureSize(128, 64);
        Shape1103.mirror = true;
        setRotation(Shape1103, 0F, 0F, 0F);
        Shape1203 = new ModelRenderer(this, 58, 3);
        Shape1203.addBox(-7F, -1F, -0.5F, 14, 1, 1);
        Shape1203.setRotationPoint(0F, 12F, -12.5F);
        Shape1203.setTextureSize(128, 64);
        Shape1203.mirror = true;
        setRotation(Shape1203, 0F, 0F, 0F);
        Shape1303 = new ModelRenderer(this, 64, 1);
        Shape1303.addBox(-4F, -1F, -0.5F, 8, 1, 1);
        Shape1303.setRotationPoint(0F, 12F, -13.5F);
        Shape1303.setTextureSize(128, 64);
        Shape1303.mirror = true;
        setRotation(Shape1303, 0F, 0F, 0F);
        Shape704 = new ModelRenderer(this, 44, 27);
        Shape704.addBox(-13F, -1F, -1.5F, 26, 1, 3);
        Shape704.setRotationPoint(0F, 12F, 5.5F);
        Shape704.setTextureSize(128, 64);
        Shape704.mirror = true;
        setRotation(Shape704, 0F, 0F, 0F);
        Shape804 = new ModelRenderer(this, 48, 31);
        Shape804.addBox(-12F, -1F, -0.5F, 24, 1, 1);
        Shape804.setRotationPoint(0F, 12F, 7.5F);
        Shape804.setTextureSize(128, 64);
        Shape804.mirror = true;
        setRotation(Shape804, 0F, 0F, 0F);
        Shape904 = new ModelRenderer(this, 49, 33);
        Shape904.addBox(-11F, -1F, -1F, 22, 1, 2);
        Shape904.setRotationPoint(0F, 12F, 9F);
        Shape904.setTextureSize(128, 64);
        Shape904.mirror = true;
        setRotation(Shape904, 0F, 0F, 0F);
        Shape1004 = new ModelRenderer(this, 52, 36);
        Shape1004.addBox(-10F, -1F, -0.5F, 20, 1, 1);
        Shape1004.setRotationPoint(0F, 12F, 10.5F);
        Shape1004.setTextureSize(128, 64);
        Shape1004.mirror = true;
        setRotation(Shape1004, 0F, 0F, 0F);
        Shape1104 = new ModelRenderer(this, 56, 38);
        Shape1104.addBox(-8F, -1F, -0.5F, 16, 1, 1);
        Shape1104.setRotationPoint(0F, 12F, 11.5F);
        Shape1104.setTextureSize(128, 64);
        Shape1104.mirror = true;
        setRotation(Shape1104, 0F, 0F, 0F);
        Shape1204 = new ModelRenderer(this, 58, 40);
        Shape1204.addBox(-7F, -1F, -0.5F, 14, 1, 1);
        Shape1204.setRotationPoint(0F, 12F, 12.5F);
        Shape1204.setTextureSize(128, 64);
        Shape1204.mirror = true;
        setRotation(Shape1204, 0F, 0F, 0F);
        Shape1304 = new ModelRenderer(this, 64, 42);
        Shape1304.addBox(-4F, -1F, -0.5F, 8, 1, 1);
        Shape1304.setRotationPoint(0F, 12F, 13.5F);
        Shape1304.setTextureSize(128, 64);
        Shape1304.mirror = true;
        setRotation(Shape1304, 0F, 0F, 0F);
    }

    @Override
    public void render(T t, float v, float v1, float v2, float v3, float v4) {

    }

   // public void render(T entity, float f, float f1, float f2, float f3, float f4, float f5)
   // {
   //     super.render(entity, f, f1, f2, f3, f4, f5);
   //     setRotationAngles(entity, f, f1, f2, f3, f4, f5);
   //     Shape201.render(f5);
   //     Shape202.render(f5);
   //     Shape203.render(f5);
   //     Shape204.render(f5);
   //     Shape301.render(f5);
   //     Shape302.render(f5);
   //     Shape303.render(f5);
   //     Shape304.render(f5);
   //     Shape305.render(f5);
   //     Shape306.render(f5);
   //     Shape307.render(f5);
   //     Shape308.render(f5);
   //     Shape401.render(f5);
   //     Shape402.render(f5);
   //     Shape403.render(f5);
   //     Shape404.render(f5);
   //     Shape405.render(f5);
   //     Shape406.render(f5);
   //     Shape407.render(f5);
   //     Shape408.render(f5);
   //     Shape501.render(f5);
   //     Shape502.render(f5);
   //     Shape503.render(f5);
   //     Shape504.render(f5);
   //     Shape505.render(f5);
   //     Shape506.render(f5);
   //     Shape507.render(f5);
   //     Shape508.render(f5);
   //     Shape509.render(f5);
   //     Shape510.render(f5);
   //     Shape511.render(f5);
   //     Shape512.render(f5);
   //     Shape601.render(f5);
   //     Shape701.render(f5);
   //     Shape801.render(f5);
   //     Shape901.render(f5);
   //     Shape1001.render(f5);
   //     Shape1101.render(f5);
   //     Shape1201.render(f5);
   //     Shape1301.render(f5);
   //     Shape702.render(f5);
   //     Shape802.render(f5);
   //     Shape902.render(f5);
   //     Shape1002.render(f5);
   //     Shape1102.render(f5);
   //     Shape1202.render(f5);
   //     Shape1302.render(f5);
   //     Shape602.render(f5);
   //     Shape703.render(f5);
   //     Shape803.render(f5);
   //     Shape903.render(f5);
   //     Shape1003.render(f5);
   //     Shape1103.render(f5);
   //     Shape1203.render(f5);
   //     Shape1303.render(f5);
   //     Shape704.render(f5);
   //     Shape804.render(f5);
   //     Shape904.render(f5);
   //     Shape1004.render(f5);
   //     Shape1104.render(f5);
   //     Shape1204.render(f5);
   //     Shape1304.render(f5);
   // }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(T entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        //super.setRotationAngles(entity, f, f1, f2, f3, f4, f5);
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder iVertexBuilder, int i, int i1, float v, float v1, float v2, float v3) {

    }
}
