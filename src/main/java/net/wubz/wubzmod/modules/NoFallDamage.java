package net.wubz.wubzmod.modules;

import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.wubz.wubzmod.WubzMod;

public class NoFallDamage {
    public static void NoFall(){
        if(WubzMod.instance.player!=null && WubzMod.NoFallDamage)
        {
            enableNoFall();
        }
    }
    private static void enableNoFall(){
        if(isFallingFastEnoughToCauseDamage()) {
            assert WubzMod.instance.player != null;
            WubzMod.instance.player.networkHandler.sendPacket(new PlayerMoveC2SPacket.OnGroundOnly(true));
        }
    }

    private static boolean isFallingFastEnoughToCauseDamage()
    {
        assert WubzMod.instance.player != null;
        return WubzMod.instance.player.getVelocity().y < -0.5;
    }
}
