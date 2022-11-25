package net.wubz.wubzmod.mixin;

import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.GameStateChangeS2CPacket;
import net.wubz.wubzmod.modules.LiveOverflowBypass;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameStateChangeS2CPacket.class)
public class GameStateChangeS2CPacketMixin {
    /**
     * @author
     * Wubz (dkonis)
     * @reason
     * Bypassing LiveOverflow's demo by not applying
     * the GameStateChange Packet
     */
    @Inject(at = @At("HEAD") , method = "apply", cancellable = true)
    public void apply(ClientPlayPacketListener clientPlayPacketListener, CallbackInfo ci) {
        GameStateChangeS2CPacket packet = (GameStateChangeS2CPacket) (Object) this;
        if(LiveOverflowBypass.GameStateBypass(packet))
            ci.cancel();
    }
}
