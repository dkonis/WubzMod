package net.wubz.wubzmod.mixin;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.wubz.wubzmod.WubzMod;
import net.wubz.wubzmod.gui.ModOptions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin extends Screen {

    protected TitleScreenMixin(Text title) { super(title); }

    MutableText ModText(boolean modEnabled,String modName) {
        if(modEnabled)
            return Text.translatable(modName + " \u00a7aEnabled");
        else
            return Text.translatable(modName + " \u00a7cDisabled");
    }

    @Inject(at = @At("HEAD"), method = "initWidgetsNormal(II)V")
    private void onInitWigets(int y, int spacingY, CallbackInfo ci){
        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, y + spacingY * 5 - 10, 200, 20, ModText(WubzMod.LiveOverflowBypass, "LiveOverflow Bypass:"), (button) -> {
            WubzMod.LiveOverflowBypass = !WubzMod.LiveOverflowBypass;
            button.setMessage(ModText(WubzMod.LiveOverflowBypass, "LiveOverflow Bypass:"));
        }));
    }
}
