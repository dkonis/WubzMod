/*
 * Credits to FuFuClient
 */
package net.wubz.wubzmod.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.wubz.wubzmod.WubzMod;

import java.util.ArrayList;
import java.util.List;

public class ModHud extends Screen {
    private final MinecraftClient client = WubzMod.instance;
    private final TextRenderer fontRenderer = WubzMod.instance.textRenderer;
    private ClientPlayerEntity player;
    private MatrixStack matrixStack;
    private String Name = "WubzMod";

    public ModHud() {
        super(Text.translatable("Mod Hud"));

    }

    public void draw(MatrixStack matrixStack) {
        this.player = this.client.player;
        this.matrixStack = matrixStack;
        RenderSystem.enableBlend();
        this.drawWatermak();
        this.drawInfo();
        this.client.getProfiler().pop();
    }
    private void drawInfo() {
        List<String> gameInfo = getGameInfo();
        int lineHeight = this.fontRenderer.fontHeight;
        int height = this.height + 40;
        int width = this.width + 4;

        for (String line : gameInfo) {
            this.fontRenderer.drawWithShadow(this.matrixStack, line, width, height - (lineHeight), 0x00E0E0E0);
            height -= lineHeight + 4;
        }
    }

    private void drawWatermak() {
        if (this.player.getWorld().getRegistryKey().getValue().toString().equals("minecraft:overworld"))
            this.Name = "\u00a7cWubz\u00a78Mod";
        else if (this.player.getWorld().getRegistryKey().getValue().toString().equals("minecraft:the_nether"))
            this.Name = "\u00a7aWubz\u00a78Mod";
        this.fontRenderer.drawWithShadow(this.matrixStack, this.Name, this.width + 4, this.height + 4, 0x00E0E0E0);
    }

    private List<String> getGameInfo() {
        List<String> gameInfo = new ArrayList<>();
        String coordDirectionStatus = "";
        String direction = this.player.getHorizontalFacing().asString();
        String coordsFormat = "%.0f, %.0f, %.0f";

        if (this.player.getWorld().getRegistryKey().getValue().toString().equals("minecraft:overworld"))
            gameInfo.add("\u00a7cNether: \u00a7f" + String.format(coordsFormat, this.player.getX() / 8, this.player.getY(), this.player.getZ() / 8));
        else if (this.player.getWorld().getRegistryKey().getValue().toString().equals("minecraft:the_nether"))
            gameInfo.add("\u00a7aOverworld: \u00a7f" + String.format(coordsFormat, this.player.getX() * 8, this.player.getY(), this.player.getZ() * 8));

        coordDirectionStatus += String.format(coordsFormat, this.player.getX(), this.player.getY(), this.player.getZ());
        coordDirectionStatus += " (" + direction + ")";
        gameInfo.add("\u00a78Cords: \u00a7f"+coordDirectionStatus);

        return gameInfo;
    }
}
