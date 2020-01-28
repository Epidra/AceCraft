package mod.acecraft.render;

public class RenderAxle {

}

//public class RenderAxle extends TileEntitySpecialRenderer {
//
//    private static final ResourceLocation texture = new ResourceLocation(AceCraft.modid + ":" + "textures/model/Axle.png");
//
//    private ModelAxle model;
//    private float energy;
//    private float rotation;
//    private float current;
//
//    public RenderAxle(){
//        this.model = new ModelAxle();
//        this.energy = 5;
//        this.rotation = 0;
//        this.current = 0;
//    }
//
//    public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float partialTicks, int destroyStage){
//        int i = 0;
//        if (tileentity.getWorld() != null){
//            Block block = tileentity.getBlockType();
//            i = tileentity.getBlockMetadata();
//        }
//        TileEntityAxle entity = (TileEntityAxle) tileentity;
//        if(entity != null){
//            if(this.energy != entity.energy){
//                this.energy = entity.energy;
//                this.energy = energy / 200;
//            }
//        }
//        GL11.glPushMatrix();
//        GL11.glTranslatef((float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F);
//        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
//        GL11.glPushMatrix();
//        if(i == 0){
//            GL11.glRotatef(     180F, 0.0F, 0.0F, 1.0F);
//            GL11.glRotatef(+rotation, 0.0F, 1.0F, 0.0F);
//            GL11.glRotatef(      90F, 1.0F, 0.0F, 0.0F);
//        }else if(i == 1){
//            GL11.glRotatef(     180F, 0.0F, 0.0F, 1.0F);
//            GL11.glRotatef(-rotation, 0.0F, 1.0F, 0.0F);
//            GL11.glRotatef(     270F, 1.0F, 0.0F, 0.0F);
//        }else if(i == 2){
//            GL11.glRotatef(+rotation, 0.0F, 0.0F, 1.0F);
//            GL11.glRotatef(     180F, 0.0F, 1.0F, 0.0F);
//            GL11.glRotatef(       0F, 1.0F, 0.0F, 0.0F);
//        }else if(i == 3){
//            GL11.glRotatef(-rotation, 0.0F, 0.0F, 1.0F);
//            GL11.glRotatef(       0F, 0.0F, 1.0F, 0.0F);
//            GL11.glRotatef(       0F, 1.0F, 0.0F, 0.0F);
//        }else if(i == 4){
//            GL11.glRotatef(-rotation, 1.0F, 0.0F, 0.0F);
//            GL11.glRotatef(      90F, 0.0F, 1.0F, 0.0F);
//            GL11.glRotatef(       0F, 0.0F, 0.0F, 1.0F);
//        }else if(i == 5){
//            GL11.glRotatef(+rotation, 1.0F, 0.0F, 0.0F);
//            GL11.glRotatef(     270F, 0.0F, 1.0F, 0.0F);
//            GL11.glRotatef(       0F, 0.0F, 0.0F, 1.0F);
//        }
//        this.model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
//        GL11.glPopMatrix();
//        GL11.glPopMatrix();
//        rotation = rotation + energy;
//        if(rotation == 360) rotation = 0;
//        if(current > energy) current = current - 0.001F;
//        if(current < energy) current = current + 0.001F;
//    }
//
//}

