package net.wubz.wubzmod.modules;

import net.minecraft.network.ClientConnection;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.util.math.Vec3d;
import net.wubz.wubzmod.WubzMod;

public class Flying {
    private static int counter = 0;
    private final static double FALL_PACKET = 0.2;

    public static void Flying(){
        if(WubzMod.instance.player!=null && WubzMod.Flying) {
            enableFlying();
        }
        else if (WubzMod.instance.player != null) {
            disableFlying();
        }
    }

    private static void enableFlying(){
        assert WubzMod.instance.player != null;

        if (!WubzMod.instance.player.getAbilities().allowFlying) {
            WubzMod.instance.player.getAbilities().allowFlying = true;
        }

        if(counter==0 && !WubzMod.instance.player.isOnGround()) {
            ClientConnection conn = WubzMod.instance.player.networkHandler.getConnection();
            Vec3d pos =  WubzMod.instance.player.getPos().subtract(0.0, FALL_PACKET, 0.0);
            Packet packet = new PlayerMoveC2SPacket.PositionAndOnGround(pos.getX(), pos.getY(), pos.getZ(), false);
            conn.send(packet);
        }

        if(counter == 0)
            counter = 20;
        counter --;

    }

    private static void disableFlying(){
        assert WubzMod.instance.player != null;
        if (WubzMod.instance.player.getAbilities().allowFlying)
            WubzMod.instance.player.getAbilities().allowFlying = false;
    }
}
