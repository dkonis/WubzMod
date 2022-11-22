package net.wubz.wubzmod.mixin;

import net.minecraft.client.MinecraftClient;
import net.wubz.wubzmod.modules.Flying;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {
    @Inject(at = @At("TAIL"), method = "tick")
    private void tick(CallbackInfo ci) {
        Flying.Flying();
    }
}
