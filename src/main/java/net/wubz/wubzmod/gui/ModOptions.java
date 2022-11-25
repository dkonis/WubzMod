package net.wubz.wubzmod.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.SliderWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import net.wubz.wubzmod.WubzMod;
import net.wubz.wubzmod.modules.GigaChad;

import java.util.Objects;

public class ModOptions extends Screen {
    private final Screen parent;
    private final GameOptions settings;
    private static int TPDistance = 0;

    public ModOptions(Screen parent, GameOptions gameOptions) {
        super(Text.translatable("Wubz's Tools"));
        this.parent = parent;
        this.settings = gameOptions;
    }

    protected void init() {
        this.addDrawableChild(new ButtonWidget(10, 10, 90, 20, Text.translatable("Game Menu"), (button) -> {
            assert this.client != null;
            this.client.setScreen(this.parent);
        }));

        this.addDrawableChild(new ButtonWidget(this.width / 2 - 102, this.height / 6 + 25, 98, 20, Text.translatable("Teleport"), (button) -> {
            assert WubzMod.instance.player != null;
            String direction = WubzMod.instance.player.getHorizontalFacing().asString();
            float pitch = WubzMod.instance.player.getPitch();
            WubzMod.LOGGER.info(direction + WubzMod.instance.player.getPitch());
            Vec3d pos =  WubzMod.instance.player.getPos();
            switch (direction) {
                case "south" -> WubzMod.instance.player.setPos(pos.getX(), pos.getY(), pos.getZ() + TPDistance);
                case "west" -> WubzMod.instance.player.setPos(pos.getX() - TPDistance, pos.getY(), pos.getZ());
                case "north" -> WubzMod.instance.player.setPos(pos.getX(), pos.getY(), pos.getZ() - TPDistance);
                case "east" -> WubzMod.instance.player.setPos(pos.getX() + TPDistance, pos.getY(), pos.getZ());
            }
            if(pitch <= -60.0)
                WubzMod.instance.player.setPos(pos.getX(), pos.getY() + TPDistance, pos.getZ());
            else if(pitch >= 60.0) {
                WubzMod.instance.player.setPos(pos.getX(), pos.getY() - TPDistance, pos.getZ());
            }
        }));

        this.addDrawableChild(new SliderWidget(this.width / 2 + 4, this.height / 6 + 25, 98, 20, Text.translatable("TP Distance: " + TPDistance), (float) (TPDistance / 20)) {
            @Override
            protected void updateMessage() {
                this.setMessage(Text.translatable("TP Distance: " + TPDistance));
            }

            @Override
            protected void applyValue() {
                TPDistance = (int) (this.value * 20);
            }
        });

        this.addDrawableChild(new ButtonWidget(this.width / 2 - 102, this.height / 6 + 50, 98, 20, WubzMod.ModuleStateText(WubzMod.Flying, "Flying:"), (button) -> {
            WubzMod.Flying = !WubzMod.Flying;
            button.setMessage(WubzMod.ModuleStateText(WubzMod.Flying, "Flying:"));
        }));

        this.addDrawableChild(new ButtonWidget(this.width / 2 + 4, this.height / 6 + 50, 98, 20, WubzMod.ModuleStateText(WubzMod.NoFallDamage, "NoFall:"), (button) -> {
            WubzMod.NoFallDamage = !WubzMod.NoFallDamage;
            button.setMessage(WubzMod.ModuleStateText(WubzMod.NoFallDamage, "NoFall:"));
        }));

        this.addDrawableChild(new ButtonWidget(this.width / 2 - 102, this.height / 6 + 75, 204, 20, WubzMod.ModuleStateText(WubzMod.XRay, "XRay:"), (button) -> {
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
                button.setMessage(WubzMod.ModuleStateText(WubzMod.XRay, "XRay:"));
            }
        }));

        this.addDrawableChild(new ButtonWidget(this.width / 2 - 102, this.height / 6 + 100, 204, 20, WubzMod.ModuleStateText(WubzMod.GigaChad, "GigaChad mode:"), (button) -> {
            WubzMod.GigaChad = !WubzMod.GigaChad;
            GigaChad.ModuleState();
            button.setMessage(WubzMod.ModuleStateText(WubzMod.GigaChad, "GigaChad mode:"));
        }));

    }
}
