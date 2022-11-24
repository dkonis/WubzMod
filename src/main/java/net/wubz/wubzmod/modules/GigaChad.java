package net.wubz.wubzmod.modules;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.wubz.wubzmod.WubzMod;

import java.util.Objects;

public class GigaChad {

    public static void GigaChad(){
        if(WubzMod.instance.player!=null && WubzMod.GigaChad)
            enableGigaChad();
        if(WubzMod.instance.player!=null && !WubzMod.GigaChad)
            disableGigaChad();
    }

    private static void enableGigaChad(){
        assert WubzMod.instance.player != null;
        WubzMod.instance.player.addStatusEffect(new StatusEffectInstance(Objects.requireNonNull(StatusEffect.byRawId(1)),
                Integer.MAX_VALUE,2, false, false, false));
        WubzMod.instance.player.addStatusEffect(new StatusEffectInstance(Objects.requireNonNull(StatusEffect.byRawId(3)),
                Integer.MAX_VALUE,2, false, false, false));
        WubzMod.instance.player.addStatusEffect(new StatusEffectInstance(Objects.requireNonNull(StatusEffect.byRawId(5)),
                Integer.MAX_VALUE,2, false, false, true));
        WubzMod.instance.player.addStatusEffect(new StatusEffectInstance(Objects.requireNonNull(StatusEffect.byRawId(8)),
                Integer.MAX_VALUE,0, false, false, false));
        WubzMod.instance.player.addStatusEffect(new StatusEffectInstance(Objects.requireNonNull(StatusEffect.byRawId(10)),
                Integer.MAX_VALUE,2, false, false, false));

    }

    private static void disableGigaChad(){
        assert WubzMod.instance.player != null;
        WubzMod.instance.player.removeStatusEffect(StatusEffect.byRawId(1));
        WubzMod.instance.player.removeStatusEffect(StatusEffect.byRawId(3));
        WubzMod.instance.player.removeStatusEffect(StatusEffect.byRawId(5));
        WubzMod.instance.player.removeStatusEffect(StatusEffect.byRawId(8));
        WubzMod.instance.player.removeStatusEffect(StatusEffect.byRawId(10));
    }
}
