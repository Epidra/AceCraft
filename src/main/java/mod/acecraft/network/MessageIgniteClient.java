package mod.acecraft.network;

import mod.acecraft.blockentity.BlockEntityFoundry;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class MessageIgniteClient {

    static int x;
    static int y;
    static int z;





    //----------------------------------------CONSTRUCTOR----------------------------------------//

    public MessageIgniteClient(BlockPos pos) {
        this.x = pos.getX();
        this.y = pos.getY();
        this.z = pos.getZ();
    }





    //----------------------------------------ENCODE/DECODE----------------------------------------//

    public static void encode (MessageIgniteClient msg, FriendlyByteBuf buf) {
        buf.writeInt(msg.x);
        buf.writeInt(msg.y);
        buf.writeInt(msg.z);
    }

    public static MessageIgniteClient decode (FriendlyByteBuf buf) {
        int _x = buf.readInt();
        int _y = buf.readInt();
        int _z = buf.readInt();
        return new MessageIgniteClient(new BlockPos(_x, _y, _z));
    }





    //----------------------------------------HANDLER----------------------------------------//

    public static class Handler {
        public static void handle (final MessageIgniteClient message, Supplier<NetworkEvent.Context> context) {
            BlockPos pos = new BlockPos(message.x, message.y, message.z);
            BlockEntityFoundry te = (BlockEntityFoundry) Minecraft.getInstance().level.getBlockEntity(pos);
            context.get().enqueueWork(() -> {
                te.ignite();
            });
            context.get().setPacketHandled(true);
        }
    }



}
