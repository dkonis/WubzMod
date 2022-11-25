package net.wubz.wubzmod.modules;

import net.minecraft.entity.Entity;
import net.minecraft.network.packet.s2c.play.GameStateChangeS2CPacket;
import net.wubz.wubzmod.WubzMod;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

public class LiveOverflowBypass {
    public static void PlayerMoveBypass(Args args){
        if(WubzMod.LiveOverflowBypass) {
            args.set(0, WubzMod.roundCoordinate(args.get(0)));
            args.set(2, WubzMod.roundCoordinate(args.get(2)));
        }
    }
/*
*  VehicleMoveBypass is not working currently
 */

//    public static double VehicleMoveBypass(Entity entity, char cord){
//        if(WubzMod.LiveOverflowBypass) {
//            if(cord == 'x') {
//                return WubzMod.roundCoordinate(entity.getX());
//            }
//            else{
//                return WubzMod.roundCoordinate(entity.getY());
//            }
//        }
//        else
//        {
//            if(cord == 'x') {
//                return entity.getX();
//            }
//            else{
//                return  entity.getY();
//            }
//        }
//    }

    public static boolean GameStateBypass(GameStateChangeS2CPacket packet){
        return WubzMod.LiveOverflowBypass && (packet.getValue() == 1.0 || packet.getValue() == 0.0 || packet.getValue() == 101.0
                || packet.getValue() == 102.0 || packet.getValue() == 103.0 || packet.getValue() == 104.0);
    }

    public static boolean WorldBorderBypass(){
        return WubzMod.LiveOverflowBypass;
    }
}
