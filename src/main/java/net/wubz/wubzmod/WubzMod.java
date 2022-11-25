package net.wubz.wubzmod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WubzMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("wubzmod");
    public static boolean LiveOverflowBypass = true;
    public static boolean Flying = false;
    public static boolean NoFallDamage = false;
    public static boolean XRay = false;
    public static boolean GigaChad = false;

    public static MutableText ModuleStateText(boolean modEnabled, String modName) {
        if(modEnabled)
            return Text.translatable(modName + " \u00a7aEnabled");
        else
            return Text.translatable(modName + " \u00a7cDisabled");
    }

    public static MinecraftClient instance = MinecraftClient.getInstance();


    @Override
    public void onInitialize() {
        LOGGER.info("WubzMod 1.19.2");
    }
}
