package mod.acecraft.network;

import mod.acecraft.system.AceCraftPacketHandler;
import mod.acecraft.tileentities.TileFoundry;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class MessageIgniteServer {

    static int x;
    static int y;
    static int z;





    //----------------------------------------CONSTRUCTOR----------------------------------------//

    public MessageIgniteServer(BlockPos pos) {
        this.x = pos.getX();
        this.y = pos.getY();
        this.z = pos.getZ();
    }





    //----------------------------------------ENCODE/DECODE----------------------------------------//

    public static void encode (MessageIgniteServer msg, PacketBuffer buf) {
        buf.writeInt(msg.x);
        buf.writeInt(msg.y);
        buf.writeInt(msg.z);
    }

    public static MessageIgniteServer decode (PacketBuffer buf) {
        int _x = buf.readInt();
        int _y = buf.readInt();
        int _z = buf.readInt();
        return new MessageIgniteServer(new BlockPos(_x, _y, _z));
    }





    //----------------------------------------HANDLER----------------------------------------//

    public static class Handler {
        public static void handle (final MessageIgniteServer message, Supplier<NetworkEvent.Context> context) {
            BlockPos pos = new BlockPos(message.x, message.y, message.z);
            TileFoundry te = (TileFoundry) context.get().getSender().level.getBlockEntity(pos);
            context.get().enqueueWork(() ->{
                te.ignite();
            });
            AceCraftPacketHandler.sendToChunk(new MessageIgniteClient(new BlockPos(message.x, message.y, message.z)), context.get().getSender().level.getChunkAt(pos));
            context.get().setPacketHandled(true);
        }
    }



}
