package mod.acecraft.client.network;

import mod.acecraft.common.block.entity.BlockEntityFoundry;
import mod.acecraft.system.PacketHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class MessageEjectServer {
	
	static BlockPos pos;
	
	
	
	
	
	// ---------- ---------- ---------- ----------  CONSTRUCTOR  ---------- ---------- ---------- ---------- //
	
	public MessageEjectServer(BlockPos pos) {
		this.pos = pos;
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  ENCODE / DECODE  ---------- ---------- ---------- ---------- //
	
	public static void encode (MessageEjectServer msg, FriendlyByteBuf buf) {
		buf.writeBlockPos(msg.pos);
	}
	
	public static MessageEjectServer decode (FriendlyByteBuf buf) {
		return new MessageEjectServer(buf.readBlockPos());
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  HANDLER  ---------- ---------- ---------- ---------- //
	
	public static class Handler {
		public static void handle (final MessageEjectServer message, Supplier<NetworkEvent.Context> context) {
			BlockEntityFoundry te = (BlockEntityFoundry) context.get().getSender().level().getChunkAt(message.pos).getBlockEntity(message.pos);
			context.get().enqueueWork(() ->{
				te.eject();
			});
			PacketHandler.sendToChunk(new MessageEjectClient(message.pos), context.get().getSender().level().getChunkAt(message.pos));
			context.get().setPacketHandled(true);
		}
	}
	
	
	
}
