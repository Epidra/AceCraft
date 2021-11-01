package mod.acecraft.network;

import mod.acecraft.tileentities.TileFoundry;
import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class MessageEjectClient {

    static int x;
    static int y;
    static int z;





    //----------------------------------------CONSTRUCTOR----------------------------------------//

    public MessageEjectClient(BlockPos pos) {
        this.x = pos.getX();
        this.y = pos.getY();
        this.z = pos.getZ();
    }





    //----------------------------------------ENCODE/DECODE----------------------------------------//

    public static void encode (MessageEjectClient msg, PacketBuffer buf) {
        buf.writeInt(msg.x);
        buf.writeInt(msg.y);
        buf.writeInt(msg.z);
    }

    public static MessageEjectClient decode (PacketBuffer buf) {
        int _x = buf.readInt();
        int _y = buf.readInt();
        int _z = buf.readInt();
        return new MessageEjectClient(new BlockPos(_x, _y, _z));
    }





    //----------------------------------------HANDLER----------------------------------------//

    public static class Handler {
        public static void handle (final MessageEjectClient message, Supplier<NetworkEvent.Context> context) {
            BlockPos pos = new BlockPos(message.x, message.y, message.z);
            TileFoundry te = (TileFoundry) Minecraft.getInstance().level.getBlockEntity(pos);
            context.get().enqueueWork(() -> {
                te.eject();
            });
            context.get().setPacketHandled(true);
        }
    }



}
