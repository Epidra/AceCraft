package mod.acecraft.render;

public class RenderCrab {

}

//public class RenderCrab extends RenderLiving<EntityCrab> {
//
//    public static final Factory FACTORY = new Factory();
//
//    private static final ResourceLocation CRAB_TEXTURES = new ResourceLocation(AceCraft.modid + ":" + "textures/entity/Crab.png");
//
//    public RenderCrab(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn){
//        super(renderManagerIn, modelBaseIn, shadowSizeIn);
//    }
//
//    /**
//     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
//     */
//    protected ResourceLocation getEntityTexture(EntityCrab entity){
//        return CRAB_TEXTURES;
//    }
//
//    public static class Factory implements IRenderFactory<EntityCrab>{
//        public Render<? super EntityCrab> createRenderFor(RenderManager manager){
//            return new RenderCrab(manager, new ModelCrab(), 1);
//        }
//    }
//
//}
