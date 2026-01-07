package mod.acecraft.common.network;

import mod.acecraft.common.block.entity.BlockEntityFoundry;
import mod.acecraft.custom.payload.PayloadEject;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.util.profiling.jfr.event.NetworkSummaryEvent;
import net.minecraft.world.level.ChunkPos;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public class MessageEjectServer {
	
	public static void handleDataOnNetwork(final PayloadEject data, final IPayloadContext context) {
		
		BlockEntityFoundry BE = (BlockEntityFoundry) context.player().getServer().getLevel(context.player().level().dimension()).getBlockEntity(new BlockPos(data.posX(), data.posY(), data.posZ()));
		context.enqueueWork(() -> {
			BE.eject();
		});
		PacketDistributor.sendToAllPlayers(data);
		
		// // Do something with the data, on the network thread
		// blah(data.name());
		//
		// // Do something with the data, on the main thread
		// context.enqueueWork(() -> {
		// 			blah(data.age());
		// 		})
		// 		.exceptionally(e -> {
		// 			// Handle exception
		// 			context.disconnect(Component.translatable("my_mod.networking.failed", e.getMessage()));
		// 			return null;
		// 		});
	}
}
