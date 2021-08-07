package mod.acecraft.network;

import mod.acecraft.system.AceCraftPacketHandler;
import mod.acecraft.blockentity.BlockEntityFoundry;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.fmllegacy.network.NetworkEvent;

import java.util.function.Supplier;

public class MessageEjectServer {

    static int x;
    static int y;
    static int z;




    //----------------------------------------CONSTRUCTOR----------------------------------------//

    public MessageEjectServer(BlockPos pos) {
        this.x = pos.getX();
        this.y = pos.getY();
        this.z = pos.getZ();
    }




    //----------------------------------------ENCODE/DECODE----------------------------------------//

    public static void encode (MessageEjectServer msg, FriendlyByteBuf buf) {
        buf.writeInt(msg.x);
        buf.writeInt(msg.y);
        buf.writeInt(msg.z);
    }

    public static MessageEjectServer decode (FriendlyByteBuf buf) {
        int _x = buf.readInt();
        int _y = buf.readInt();
        int _z = buf.readInt();
        return new MessageEjectServer(new BlockPos(_x, _y, _z));
    }




    //----------------------------------------HANDLER----------------------------------------//

    public static class Handler {
        public static void handle (final MessageEjectServer message, Supplier<NetworkEvent.Context> context) {
            BlockPos pos = new BlockPos(message.x, message.y, message.z);
            BlockEntityFoundry te = (BlockEntityFoundry) context.get().getSender().level.getBlockEntity(pos);

            context.get().enqueueWork(() ->{
                te.eject();
            });

            AceCraftPacketHandler.sendToChunk(new MessageEjectClient(new BlockPos(message.x, message.y, message.z)), context.get().getSender().level.getChunkAt(pos));
            context.get().setPacketHandled(true);
        }
    }

}
