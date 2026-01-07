package mod.acecraft.custom.payload;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.joml.Vector3f;
import org.joml.Vector3i;

public record PayloadEject(int posX, int posY, int posZ) implements CustomPacketPayload {
	
	public static final CustomPacketPayload.Type<PayloadEject> TYPE = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath("acecraft", "eject"));
	
	// Each pair of elements defines the stream codec of the element to encode/decode and the getter for the element to encode
	// 'name' will be encoded and decoded as a string
	// 'age' will be encoded and decoded as an integer
	// The final parameter takes in the previous parameters in the order they are provided to construct the payload object
	public static final StreamCodec<ByteBuf, PayloadEject> STREAM_CODEC = StreamCodec.composite(
			ByteBufCodecs.INT,
			PayloadEject::posX,
			ByteBufCodecs.INT,
			PayloadEject::posY,
			ByteBufCodecs.INT,
			PayloadEject::posZ,
			PayloadEject::new
	);
	
	@Override
	public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
		return TYPE;
	}
}
