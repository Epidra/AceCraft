package mod.acecraft.client.network;

import mod.acecraft.common.block.entity.BlockEntityFoundry;
import mod.acecraft.custom.payload.PayloadEject;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public class MessageEjectClient {
	
	public static void handleDataOnNetwork(final PayloadEject data, final IPayloadContext context) {
		
		BlockEntityFoundry BE = (BlockEntityFoundry) Minecraft.getInstance().level.getBlockEntity(new BlockPos(data.posX(), data.posY(), data.posZ()));
		context.enqueueWork(() -> {
			BE.eject();
		});
		
		
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
