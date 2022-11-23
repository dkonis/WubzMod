package net.wubz.wubzmod.mixin;

import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.GameStateChangeS2CPacket;
import net.wubz.wubzmod.WubzMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(GameStateChangeS2CPacket.class)
public class GameStateChangeS2CPacketMixin {
    /**
     * @author
     * Wubz (dkonis)
     * @reason
     * Bypassing LiveOverflow's demo by not applying
     * the GameStateChange Packet
     */
    @Overwrite
    public void apply(ClientPlayPacketListener clientPlayPacketListener) {
        GameStateChangeS2CPacket packet = (GameStateChangeS2CPacket) (Object) this;
        if(!WubzMod.LiveOverflowBypass){
            clientPlayPacketListener.onGameStateChange(packet);
        }
    }
}
