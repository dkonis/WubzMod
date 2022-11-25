package net.wubz.wubzmod.mixin;

import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.WorldBorderInitializeS2CPacket;
import net.wubz.wubzmod.WubzMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldBorderInitializeS2CPacket.class)
public class WorldBorderInitializeS2CPacketMixin {
    /**
     * @author
     * Wubz (dkonis)
     * @reason
     * Bypassing LiveOverflow's border by not applying
     * the WorldBorderInitialize Packet
     */
    @Inject(at = @At("HEAD") , method = "apply", cancellable = true)
    public void apply(ClientPlayPacketListener clientPlayPacketListener, CallbackInfo ci) {
        if(WubzMod.LiveOverflowBypass)
            ci.cancel();
    }
}
