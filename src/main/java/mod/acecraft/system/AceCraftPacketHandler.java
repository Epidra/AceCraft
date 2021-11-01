package mod.acecraft.system;

import mod.acecraft.network.MessageEjectClient;
import mod.acecraft.network.MessageEjectServer;
import mod.acecraft.network.MessageIgniteClient;
import mod.acecraft.network.MessageIgniteServer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class AceCraftPacketHandler {

    private static final String PROTOCOL_VERSION = Integer.toString(1);





    //----------------------------------------INSTANCE----------------------------------------//

    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation("acecraft", "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );





    //----------------------------------------REGISTER----------------------------------------//

    public static void register(){
        int disc = 0;
        INSTANCE.registerMessage(disc++, MessageEjectClient.class,  MessageEjectClient::encode,  MessageEjectClient::decode,  MessageEjectClient.Handler::handle);
        INSTANCE.registerMessage(disc++, MessageEjectServer.class,  MessageEjectServer::encode,  MessageEjectServer::decode,  MessageEjectServer.Handler::handle);
        INSTANCE.registerMessage(disc++, MessageIgniteClient.class, MessageIgniteClient::encode, MessageIgniteClient::decode, MessageIgniteClient.Handler::handle);
        INSTANCE.registerMessage(disc++, MessageIgniteServer.class, MessageIgniteServer::encode, MessageIgniteServer::decode, MessageIgniteServer.Handler::handle);
    }





    //----------------------------------------SEND----------------------------------------//

    public static <MSG> void send(PacketDistributor.PacketTarget target, MSG message){
        INSTANCE.send(target, message);
    }

    public static void sendToServer(Object message){
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendTo(MSG msg, ServerPlayerEntity player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), msg);
    }

    public static <MSG> void sendToChunk(MSG msg, Chunk chunk) {
        INSTANCE.send(PacketDistributor.TRACKING_CHUNK.with(() -> chunk), msg);
    }

    public static <MSG> void sendToAll(MSG msg) {
        INSTANCE.send(PacketDistributor.ALL.noArg(), msg);
    }



}
