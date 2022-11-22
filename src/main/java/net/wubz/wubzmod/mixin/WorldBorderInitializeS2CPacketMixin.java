package net.wubz.wubzmod.mixin;

import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.WorldBorderInitializeS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(WorldBorderInitializeS2CPacket.class)
public class WorldBorderInitializeS2CPacketMixin {
    @Overwrite
    public void apply(ClientPlayPacketListener clientPlayPacketListener) {
        /**
         * Bypassing LiveOverflow's border by not applying
         * the WorldBorderInitialize Packet
         */
    }
}
