package mod.acecraft.system;

import mod.acecraft.network.MessageDynamiteClient;
import mod.acecraft.network.MessageDynamiteServer;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.simple.SimpleChannel;

import java.util.function.Supplier;

public class AceCraftPacketHandler {

    private static final String PROTOCOL_VERSION = Integer.toString(1);

    //private static final SimpleChannel INSTANCE = NetworkRegistry.ChannelBuilder.named(new ResourceLocation(CasinoCraft.MODID, "main_channel"))
    //        .clientAcceptedVersions(PROTOCOL_VERSION::equals)
    //        .serverAcceptedVersions(PROTOCOL_VERSION::equals)
    //        .networkProtocolVersion(() -> PROTOCOL_VERSION)
    //        .simpleChannel();

    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation("acecraft", "main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals
    );

    public static void register(){
        int disc = 0;
        INSTANCE.registerMessage(disc++, MessageDynamiteClient.class, MessageDynamiteClient::encode, MessageDynamiteClient::decode, MessageDynamiteClient.Handler::handle);
        INSTANCE.registerMessage(disc++, MessageDynamiteServer.class, MessageDynamiteServer::encode, MessageDynamiteServer::decode, MessageDynamiteServer.Handler::handle);
    }

    public static <MSG> void send(PacketDistributor.PacketTarget target, MSG message){
        INSTANCE.send(target, message);
    }

    public static void sendToServer(Object message){
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendTo(MSG msg, ServerPlayerEntity player) {
        INSTANCE.send(PacketDistributor.PLAYER.with((Supplier<ServerPlayerEntity>) player), msg);
        //if (!(player instanceof FakePlayer)) {
        //    INSTANCE.sendTo(msg, player.connection.netManager, NetworkDirection.PLAY_TO_CLIENT);
        //}
    }

    public static <MSG> void sendToChunk(MSG msg, Chunk chunk) {
        INSTANCE.send(PacketDistributor.TRACKING_CHUNK.with((Supplier<Chunk>) chunk), msg);
    }

    public static <MSG> void sendToAll(MSG msg) {
        //for (ServerPlayerEntity player : ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayers()) {
        //    sendTo(packet, player);
        //}
        INSTANCE.send(PacketDistributor.ALL.noArg(), msg);
    }

}
