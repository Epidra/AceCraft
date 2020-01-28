package mod.acecraft.render;

public class RenderGoat {

}

//public class RenderGoat extends RenderLiving<EntityGoat> {
//
//    public static final Factory FACTORY = new Factory();
//
//    private static final ResourceLocation GOAT_TEXTURES = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/Goat.png");
//
//    public RenderGoat(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn){
//        super(renderManagerIn, modelBaseIn, shadowSizeIn);
//    }
//
//    /**
//     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
//     */
//    protected ResourceLocation getEntityTexture(EntityGoat entity){
//        return GOAT_TEXTURES;
//    }
//
//    public static class Factory implements IRenderFactory<EntityGoat>{
//        public Render<? super EntityGoat> createRenderFor(RenderManager manager){
//            return new RenderGoat(manager, new ModelGoat(), 1);
//        }
//    }
//
//}
