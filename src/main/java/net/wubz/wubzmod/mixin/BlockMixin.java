package net.wubz.wubzmod.mixin;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.wubz.wubzmod.modules.XRay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(Block.class)
public class BlockMixin {
    @Inject(at = @At("Return"), method = "shouldDrawSide", cancellable = true)
    private static void shouldRenderFace(BlockState state, BlockView world, BlockPos pos, Direction face,
                                            BlockPos blockPos, CallbackInfoReturnable<Boolean> ci) {
        ci.setReturnValue(XRay.XRay(state));
    }
}
