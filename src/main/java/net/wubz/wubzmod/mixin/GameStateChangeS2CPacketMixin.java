package net.wubz.wubzmod.mixin;

import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.GameStateChangeS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(GameStateChangeS2CPacket.class)
public class GameStateChangeS2CPacketMixin {
    @Overwrite
    public void apply(ClientPlayPacketListener clientPlayPacketListener) {
        /**
         * Bypassing LiveOverflow's demo by not applying
         * the GameStateChange Packet
         */
    }

}
