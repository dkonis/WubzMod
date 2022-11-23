package net.wubz.wubzmod.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import net.wubz.wubzmod.WubzMod;
import net.wubz.wubzmod.modules.GigaChad;

import java.util.Objects;

public class ModOptions extends Screen {
    private final Screen parent;
    private final GameOptions settings;

    public ModOptions(Screen parent, GameOptions gameOptions) {
        super(Text.translatable("Wubz's Tools"));
        this.parent = parent;
        this.settings = gameOptions;
    }

    MutableText ModText(boolean modEnabled,String modName) {
        if(modEnabled)
            return Text.translatable(modName + " \u00a7aEnabled");
        else
            return Text.translatable(modName + " \u00a7cDisabled");
    }

    protected void init() {
        this.addDrawableChild(new ButtonWidget(10, 10, 90, 20, Text.translatable("Game Menu"), (button) -> {
            assert this.client != null;
            this.client.setScreen(this.parent);
        }));

        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height / 6 + 25, 60, 20, Text.translatable("TP X"), (button) -> {
            Vec3d pos =  WubzMod.instance.player.getPos();
            WubzMod.instance.player.setPos(pos.getX()+ 5, pos.getY(), pos.getZ());
            WubzMod.instance.player.kill();
        }));

        this.addDrawableChild(new ButtonWidget(this.width / 2 - 30, this.height / 6 + 25, 60, 20, Text.translatable("TP Y"), (button) -> {
            Vec3d pos =  WubzMod.instance.player.getPos();
            WubzMod.instance.player.setPos(pos.getX(), pos.getY() + 5, pos.getZ() + 5);
        }));

        this.addDrawableChild(new ButtonWidget(this.width / 2 + 40, this.height / 6 + 25, 60, 20, Text.translatable("TP Z"), (button) -> {
            Vec3d pos =  WubzMod.instance.player.getPos();
            WubzMod.instance.player.setPos(pos.getX(), pos.getY(), pos.getZ() + 5);
        }));

        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height / 6 + 50, 200, 20, ModText(WubzMod.Flying, "Flying hack:"), (button) -> {
            WubzMod.Flying = !WubzMod.Flying;
            button.setMessage(ModText(WubzMod.Flying, "Flying hack:"));
        }));

        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height / 6 + 75, 200, 20, ModText(WubzMod.XRay, "XRay hack:"), (button) -> {
            assert client != null;
            if(client.worldRenderer.isTerrainRenderComplete()) {
                WubzMod.XRay = !WubzMod.XRay;
                if(WubzMod.instance.player!=null && WubzMod.instance.options!=null && WubzMod.XRay){
                    WubzMod.instance.player.addStatusEffect(new StatusEffectInstance(Objects.requireNonNull(StatusEffect.byRawId(16)),
                            Integer.MAX_VALUE,0, false, false, false));
                }
                if(WubzMod.instance.player!=null && WubzMod.instance.options!=null && !WubzMod.XRay) {
                    WubzMod.instance.player.removeStatusEffect(StatusEffect.byRawId(16));
                }
                client.worldRenderer.reload();
                button.setMessage(ModText(WubzMod.XRay, "XRay hack:"));
            }
        }));

        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height / 6 + 100, 200, 20, ModText(WubzMod.GigaChad, "GigaChad hack:"), (button) -> {
            WubzMod.GigaChad = !WubzMod.GigaChad;
            GigaChad.GigaChad();
            button.setMessage(ModText(WubzMod.GigaChad, "GigaChad hack:"));
        }));

    }
}
