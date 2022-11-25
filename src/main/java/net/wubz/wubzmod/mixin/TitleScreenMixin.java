package net.wubz.wubzmod.mixin;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.wubz.wubzmod.WubzMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin extends Screen {

    protected TitleScreenMixin(Text title) { super(title); }

    @Inject(at = @At("HEAD"), method = "initWidgetsNormal(II)V")
    private void onInitWigets(int y, int spacingY, CallbackInfo ci){
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, y + spacingY * 5 - 10, 200, 20, WubzMod.ModuleStateText(WubzMod.LiveOverflowBypass, "LiveOverflow Bypass:"), (button) -> {
            WubzMod.LiveOverflowBypass = !WubzMod.LiveOverflowBypass;
            button.setMessage(WubzMod.ModuleStateText(WubzMod.LiveOverflowBypass, "LiveOverflow Bypass:"));
        }));
    }
}
