package mod.acecraft.render;

public class RenderWaterwheel {

}

//public class RenderWaterwheel<T extends TileEntity> extends TileEntitySpecialRenderer<T> {
//
//    private static final ResourceLocation texture = new ResourceLocation(AceCraft.modid + ":" + "textures/model/Waterwheel.png");
//
//    private ModelWaterwheel model;
//    private float energy;
//    private float rotation;
//    private float current;
//
//    public RenderWaterwheel(){
//        this.model = new ModelWaterwheel();
//        this.energy = 5;
//        this.rotation = 0;
//        this.current = 0;
//    }
//
//    @Override
//    public void render(T te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
//        int i = 0;
//        if (te.getWorld() != null){
//            Block block = te.getBlockType();
//            i = te.getBlockMetadata();
//        }
//        TileEntityWaterwheel entity = (TileEntityWaterwheel) te;
//        if(entity != null){
//            if(this.energy != entity.energy){
//                this.energy = entity.energy;
//                this.energy = energy / 200;
//            }
//        }
//        int j = 180;
//        if(i == 5) { j = 270; }
//        if(i == 2) { j = 180; }
//        if(i == 4) { j =  90; }
//        if(i == 3) { j = 360; }
//        if(i == 0){
//            GL11.glPushMatrix();
//            GL11.glTranslatef((float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F);
//            Minecraft.getMinecraft().renderEngine.bindTexture(texture);
//            GL11.glPushMatrix();
//            GL11.glRotatef(180.0F+rotation, 0.0F, 0.0F, 1.0F);
//            GL11.glRotatef(0, 0.0F, 1.0F, 0F);
//            this.model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
//            GL11.glPopMatrix();
//            GL11.glPopMatrix();
//        }else if(i == 2){
//            GL11.glPushMatrix();
//            GL11.glTranslatef((float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F);
//            Minecraft.getMinecraft().renderEngine.bindTexture(texture);
//            GL11.glPushMatrix();
//            GL11.glRotatef(180.0F-rotation, 0.0F, 0.0F, 1.0F);
//            GL11.glRotatef(j, 0.0F, 1.0F, 0F);
//            this.model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
//            GL11.glPopMatrix();
//            GL11.glPopMatrix();
//        }else if(i == 3){
//            GL11.glPushMatrix();
//            GL11.glTranslatef((float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F);
//            Minecraft.getMinecraft().renderEngine.bindTexture(texture);
//            GL11.glPushMatrix();
//            GL11.glRotatef(180.0F+rotation, 0.0F, 0.0F, 1.0F);
//            GL11.glRotatef(j, 0.0F, 1.0F, 0F);
//            this.model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
//            GL11.glPopMatrix();
//            GL11.glPopMatrix();
//        }else if(i == 4){
//            GL11.glPushMatrix();
//            GL11.glTranslatef((float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F);
//            Minecraft.getMinecraft().renderEngine.bindTexture(texture);
//            GL11.glPushMatrix();
//            GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
//            GL11.glRotatef(0F+rotation, 1.0F, 0.0F, 0.0F);
//            GL11.glRotatef(j, 0.0F, 1.0F, 0F);
//            this.model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
//            GL11.glPopMatrix();
//            GL11.glPopMatrix();
//        }else if(i == 5){
//            GL11.glPushMatrix();
//            GL11.glTranslatef((float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F);
//            Minecraft.getMinecraft().renderEngine.bindTexture(texture);
//            GL11.glPushMatrix();
//            GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
//            GL11.glRotatef(0F-rotation, 1.0F, 0.0F, 0.0F);
//            GL11.glRotatef(j, 0.0F, 1.0F, 0F);
//            this.model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
//            GL11.glPopMatrix();
//            GL11.glPopMatrix();
//        }
//        rotation = rotation + energy;
//        if(rotation == 360) rotation = 0;
//        if(current > energy) current = current - 0.001F;
//        if(current < energy) current = current + 0.001F;
//    }
//
//}