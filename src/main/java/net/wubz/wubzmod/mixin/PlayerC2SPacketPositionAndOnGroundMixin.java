/*
* This solution was provided by LynJuice
 */
package net.wubz.wubzmod.mixin;

import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.wubz.wubzmod.WubzMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(PlayerMoveC2SPacket.PositionAndOnGround.class)
public class PlayerC2SPacketPositionAndOnGroundMixin {
    private static double roundCoordinate(double n) {
        n = Math.round(n * 100) / 100d;
        return Math.nextAfter(n, n + Math.signum(n));
    }
    @ModifyArgs(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/packet/c2s/play/PlayerMoveC2SPacket;<init>(DDDFFZZZ)V"))
    private static void init(Args args) {
        if(WubzMod.LiveOverflowBypass) {
            args.set(0, roundCoordinate(args.get(0)));
            args.set(2, roundCoordinate(args.get(2)));
        }
    }
}
