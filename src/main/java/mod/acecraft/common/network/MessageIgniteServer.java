package mod.acecraft.common.network;

import mod.acecraft.common.block.entity.BlockEntityFoundry;
import mod.acecraft.custom.payload.PayloadEject;
import mod.acecraft.custom.payload.PayloadIgnite;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public class MessageIgniteServer {
	
	public static void handleDataOnNetwork(final PayloadIgnite data, final IPayloadContext context) {
		ItemStack stack = context.player().getMainHandItem();
		ResourceKey<Level> dim = context.player().level().dimension();
		BlockState block = context.player().getCommandSenderWorld().getBlockState(new BlockPos(data.posX(), data.posY(), data.posZ()));
		BlockEntity entity = context.player().getCommandSenderWorld().getBlockEntity(new BlockPos(data.posX(), data.posY(), data.posZ()));
		BlockEntityFoundry BE = (BlockEntityFoundry) context.player().getCommandSenderWorld().getBlockEntity(new BlockPos(data.posX(), data.posY(), data.posZ()));
		context.enqueueWork(() -> {
			BE.ignite();
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
