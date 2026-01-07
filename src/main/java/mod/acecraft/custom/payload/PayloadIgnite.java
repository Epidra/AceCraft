package mod.acecraft.custom.payload;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.joml.Vector3f;

public record PayloadIgnite(int posX, int posY, int posZ) implements CustomPacketPayload {
	
	public static final CustomPacketPayload.Type<PayloadIgnite> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath("acecraft", "ignite"));
	
	// Each pair of elements defines the stream codec of the element to encode/decode and the getter for the element to encode
	// 'name' will be encoded and decoded as a string
	// 'age' will be encoded and decoded as an integer
	// The final parameter takes in the previous parameters in the order they are provided to construct the payload object
	public static final StreamCodec<ByteBuf, PayloadIgnite> STREAM_CODEC = StreamCodec.composite(
			ByteBufCodecs.INT,
			PayloadIgnite::posX,
			ByteBufCodecs.INT,
			PayloadIgnite::posY,
			ByteBufCodecs.INT,
			PayloadIgnite::posZ,
			PayloadIgnite::new
	);
	
	@Override
	public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}
}
