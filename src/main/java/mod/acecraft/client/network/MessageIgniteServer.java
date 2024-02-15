package mod.acecraft.client.network;

import mod.acecraft.common.block.entity.BlockEntityFoundry;
import mod.acecraft.system.PacketHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class MessageIgniteServer {
	
	static BlockPos pos;
	
	
	
	
	
	// ---------- ---------- ---------- ----------  CONSTRUCTOR  ---------- ---------- ---------- ---------- //
	
	public MessageIgniteServer(BlockPos pos) {
		this.pos = pos;
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  ENCODE / DECODE  ---------- ---------- ---------- ---------- //
	
	public static void encode (MessageIgniteServer msg, FriendlyByteBuf buf) {
		buf.writeBlockPos(msg.pos);
	}
	
	public static MessageIgniteServer decode (FriendlyByteBuf buf) {
		return new MessageIgniteServer(buf.readBlockPos());
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  HANDLER  ---------- ---------- ---------- ---------- //
	
	public static class Handler {
		public static void handle (final MessageIgniteServer message, Supplier<NetworkEvent.Context> context) {
			BlockEntityFoundry te = (BlockEntityFoundry) context.get().getSender().level().getChunkAt(message.pos).getBlockEntity(pos);
			context.get().enqueueWork(() ->{
				te.ignite();
			});
			PacketHandler.sendToChunk(new MessageIgniteClient(message.pos), context.get().getSender().level().getChunkAt(pos));
			context.get().setPacketHandled(true);
		}
	}
	
	
	
}
