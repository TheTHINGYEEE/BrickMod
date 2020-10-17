package me.thethingyee.brickmod.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public class BrickBlock extends Block {

    public BrickBlock() {
        super(FabricBlockSettings
                .copy(Blocks.STONE)
                .strength(2.0F, 0.5f)
        );
    }
}
