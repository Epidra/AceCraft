package mod.acecraft.client.network;

import mod.acecraft.common.block.entity.BlockEntityFoundry;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class MessageEjectClient {
	
	static BlockPos pos;
	
	
	
	
	
	// ---------- ---------- ---------- ----------  CONSTRUCTOR  ---------- ---------- ---------- ---------- //
	
	public MessageEjectClient(BlockPos pos) {
		this.pos = pos;
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  ENCODE / DECODE  ---------- ---------- ---------- ---------- //
	
	public static void encode (MessageEjectClient msg, FriendlyByteBuf buf) {
		buf.writeBlockPos(msg.pos);
	}
	
	public static MessageEjectClient decode (FriendlyByteBuf buf) {
		return new MessageEjectClient(buf.readBlockPos());
	}
	
	
	
	
	
	// ---------- ---------- ---------- ----------  HANDLER  ---------- ---------- ---------- ---------- //
	
	public static class Handler {
		public static void handle (final MessageEjectClient message, Supplier<NetworkEvent.Context> context) {
			BlockEntityFoundry te = (BlockEntityFoundry) Minecraft.getInstance().level.getBlockEntity(message.pos);
			context.get().enqueueWork(() -> {
				te.eject();
			});
			context.get().setPacketHandled(true);
		}
	}
	
	
	
}
