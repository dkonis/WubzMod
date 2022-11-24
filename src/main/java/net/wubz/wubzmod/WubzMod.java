package net.wubz.wubzmod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WubzMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("wubzmod");
    public static boolean LiveOverflowBypass = true;


    public static boolean Flying = false;
    public static boolean XRay = false;
    public static boolean GigaChad = false;

    public static MinecraftClient instance = MinecraftClient.getInstance();


    @Override
    public void onInitialize() {
        LOGGER.info("WubzMod 1.19.2");
    }
}
