package net.wubz.wubzmod.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.network.packet.c2s.play.VehicleMoveC2SPacket;
import net.wubz.wubzmod.WubzMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(VehicleMoveC2SPacket.class)
public class VehicleMoveC2SPacketMixin {

    @Redirect(method = "<init>(Lnet/minecraft/entity/Entity;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;getX()D"))
    public double getRoundX(Entity instance)
    {
        if (WubzMod.LiveOverflowBypass) {
            return WubzMod.roundCoordinate(instance.getX());
        }
        else
        {
            return instance.getX();
        }
    }

    @Redirect(method = "<init>(Lnet/minecraft/entity/Entity;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;getZ()D"))
    public double getRoundZ(Entity instance) {
        if (WubzMod.LiveOverflowBypass) {
            return WubzMod.roundCoordinate(instance.getZ());
        }
        else
        {
            return instance.getX();
        }
    }
}
