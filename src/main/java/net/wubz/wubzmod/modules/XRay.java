package net.wubz.wubzmod.modules;

import net.minecraft.block.BlockState;
import net.wubz.wubzmod.WubzMod;

import java.util.HashSet;

public class XRay {
    private static final HashSet<String> blocksToRender = new HashSet<>();

    public static boolean ModuleState(BlockState state){

        if(WubzMod.instance.player!=null && WubzMod.instance.options!=null && WubzMod.XRay){
            Blocks();
            return XRay.renderBlock(state);
        }
        return true;
    }

    private static void Blocks(){
        blocksToRender.add("Block{minecraft:ancient_debris}");
        blocksToRender.add("Block{minecraft:diamond_ore}");
        blocksToRender.add("Block{minecraft:deepslate_diamond_ore}");
        blocksToRender.add("Block{minecraft:gold_ore}");
        blocksToRender.add("Block{minecraft:deepslate_gold_ore}");
        blocksToRender.add("Block{raw_iron_block}");
        blocksToRender.add("Block{minecraft:iron_ore}");
        blocksToRender.add("Block{minecraft:deepslate_iron_ore}");
        blocksToRender.add("Block{minecraft:coal_ore}");
        blocksToRender.add("Block{minecraft:deepslate_coal_ore}");
        blocksToRender.add("Block{minecraft:lapis_ore}");
        blocksToRender.add("Block{minecraft:deepslate_lapis_ore}");
        blocksToRender.add("Block{minecraft:redstone_ore}");
        blocksToRender.add("Block{minecraft:deepslate_redstone_ore}");
        blocksToRender.add("Block{minecraft:lit_redstone_ore}");
        blocksToRender.add("Block{minecraft:emerald_ore}");
        blocksToRender.add("Block{minecraft:deepslate_emerald_ore}");
        blocksToRender.add("Block{minecraft:chest}");
        blocksToRender.add("Block{minecraft:trapped_chest}");
        blocksToRender.add("Block{minecraft:spawner}");
        blocksToRender.add("Block{minecraft:mob_spawner}");
        blocksToRender.add("Block{minecraft:lava}");
        blocksToRender.add("Block{minecraft:water}");
        blocksToRender.add("Block{minecraft:air}");

        //Ancient City Blockss
        blocksToRender.add("Block{sculk_sensor}");
        blocksToRender.add("Block{sculk_shrieker}");

        //amethyst
        blocksToRender.add("Block{amethyst_block}");
    }


    private static boolean renderBlock(BlockState state) {
        return blocksToRender.contains(state.getBlock().toString());
    }
}
