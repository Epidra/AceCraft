package mod.acecraft.network;

import mod.acecraft.ShopKeeper;
import mod.acecraft.entity.EntityDynamite;
import mod.acecraft.system.AceCraftPacketHandler;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class MessageDynamiteClient {

    static double posX;
    static double posY;
    static double posZ;
    static float pitch;
    static float yaw;

    public MessageDynamiteClient(double posX, double posY, double posZ, float pitch, float yaw) {
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
        this.pitch = pitch;
        this.yaw = yaw;
    }

    public static void encode (MessageDynamiteClient msg, PacketBuffer buf) {
        buf.writeDouble(msg.posX);
        buf.writeDouble(msg.posY);
        buf.writeDouble(msg.posZ);
        buf.writeFloat(msg.pitch);
        buf.writeFloat(msg.yaw);
    }

    public static MessageDynamiteClient decode (PacketBuffer buf) {
        double _posX  = buf.readDouble();
        double _posY  = buf.readDouble();
        double _posZ  = buf.readDouble();
        float  _pitch = buf.readFloat();
        float  _yaw   = buf.readFloat();
        return new MessageDynamiteClient(_posX, _posY, _posZ, _pitch, _yaw);
    }

    public static class Handler {
        //private boolean isEmpty(ItemStack stack){
        //    if(stack.getItem() == Item.getItemFromBlock(Blocks.AIR)) return true;
        //    return stack.getItem() == null;
        //}
        public static void handle (final MessageDynamiteClient message, Supplier<NetworkEvent.Context> context) {
            // This is the player the packet was sent to the server from
            ServerPlayerEntity serverPlayer = context.get().getSender();

            context.get().enqueueWork(() ->{
                EntityDynamite snowballentity = new EntityDynamite(Minecraft.getInstance().world, message.posX, message.posY, message.posZ);
                snowballentity.setItem(new ItemStack(ShopKeeper.STUFF_DYNAMITE));
                snowballentity.shoot(message.pitch, message.yaw, 0.0F, 1.5F, 1.0F);
                Minecraft.getInstance().world.addEntity(snowballentity);
                //int seed = message.seed;
                //BlockPos pos = new BlockPos(message.x, message.y, message.z);
                //TileEntityBoard te = (TileEntityBoard) context.get().getSender().world.getTileEntity(pos);
                //te.setPlayer(message.name);
                //te.LOGIC.start(seed);
            });
            context.get().setPacketHandled(true);

            //// The value that was sent
            //int amount = message.amount;
            //BlockPos pos = new BlockPos(message.x, message.y, message.z);
            //TileEntityBoard te = (TileEntityBoard) context.get().getSender().world.getTileEntity(pos);
            //context.get().getSender().getServerWorld().addScheduledTask(() -> {
            //    if(amount <= 0) {
            //        te.bet_storage = 0;
            //        te.setToken(new ItemStack(Blocks.AIR));
            //    } else {
            //        te.inventory.set(0, message.stack0);
            //        te.inventory.set(1, message.stack1);
            //        te.inventory.set(4, message.stack4);
            //        te.bet_storage = amount;
            //    }
            //});
            //CasinoPacketHandler.INSTANCE.sendTo(new PacketClientPlayerMessage(false), serverPlayer);
            //CasinoPacketHandler.sendToAll(new PacketClientBlockMessage(
            //        message.stack0,
            //        message.stack1,
            //        message.stack4,
            //        amount,
            //        pos));
            //// No response packet
            //context.get().setPacketHandled(true);
        }
    }

}
