package net.wubz.wubzmod.mixin;

import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.GameStateChangeS2CPacket;
import net.minecraft.network.packet.s2c.play.WorldBorderInitializeS2CPacket;
import net.wubz.wubzmod.WubzMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(WorldBorderInitializeS2CPacket.class)
public class WorldBorderInitializeS2CPacketMixin {
    /**
     * @author
     * Wubz (dkonis)
     * @reason
     * Bypassing LiveOverflow's border by not applying
     * the WorldBorderInitialize Packet
     */
    @Overwrite
    public void apply(ClientPlayPacketListener clientPlayPacketListener) {
        WorldBorderInitializeS2CPacket packet = (WorldBorderInitializeS2CPacket) (Object) this;
        if(!WubzMod.LiveOverflowBypass){
            clientPlayPacketListener.onWorldBorderInitialize(packet);
        }
    }
}
