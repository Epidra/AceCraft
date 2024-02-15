package mod.acecraft.system;

import mod.acecraft.client.network.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

import static mod.acecraft.AceCraft.MODID;

public class PacketHandler {
	
	private static final String PROTOCOL_VERSION = Integer.toString(1);
	
	public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(MODID, "main"),
			() -> PROTOCOL_VERSION,
			PROTOCOL_VERSION::equals,
			PROTOCOL_VERSION::equals
	);
	
	
	
	
	
	// ---------- ---------- ---------- ----------  REGISTER  ---------- ---------- ---------- ---------- //
	
	public static void register(){
		int disc = 0;
		INSTANCE.registerMessage(disc++, MessageEjectClient.class,  MessageEjectClient::encode,  MessageEjectClient::decode,  MessageEjectClient.Handler::handle);
		INSTANCE.registerMessage(disc++, MessageEjectServer.class,  MessageEjectServer::encode,  MessageEjectServer::decode,  MessageEjectServer.Handler::handle);
		INSTANCE.registerMessage(disc++, MessageIgniteClient.class, MessageIgniteClient::encode, MessageIgniteClient::decode, MessageIgniteClient.Handler::handle);
		INSTANCE.registerMessage(disc++, MessageIgniteServer.class, MessageIgniteServer::encode, MessageIgniteServer::decode, MessageIgniteServer.Handler::handle);
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  SUPPORT  ---------- ---------- ---------- ---------- //
	
	public static <MSG> void send(PacketDistributor.PacketTarget target, MSG message){
		INSTANCE.send(target, message);
	}
	
	public static void sendToServer(Object message){
		INSTANCE.sendToServer(message);
	}
	
	public static <MSG> void sendTo(MSG msg, ServerPlayer player) {
		INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), msg);
	}
	
	public static <MSG> void sendToChunk(MSG msg, LevelChunk chunk) {
		INSTANCE.send(PacketDistributor.TRACKING_CHUNK.with(() -> chunk), msg);
	}
	
	public static <MSG> void sendToAll(MSG msg) {
		INSTANCE.send(PacketDistributor.ALL.noArg(), msg);
	}
	
	
	
}