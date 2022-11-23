package net.wubz.wubzmod.mixin;

import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.wubz.wubzmod.gui.ModOptions;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameMenuScreen.class)
public abstract class GameMenuScreenMixin extends Screen {
    protected GameMenuScreenMixin(Text menu) { super(menu); }

    @Inject(at = @At("HEAD"), method = "initWidgets")
    private void onInitWigets(CallbackInfo ci){
        this.addDrawableChild(new ButtonWidget(10, 10, 90, 20, Text.translatable("Wubz's Tools"), (button) ->{
            assert this.client != null;
            this.client.setScreen(new ModOptions(this, this.client.options));
        } ));
    }
}
