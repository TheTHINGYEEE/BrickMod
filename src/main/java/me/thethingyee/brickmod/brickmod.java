package me.thethingyee.brickmod;

import me.thethingyee.brickmod.bases.*;
import me.thethingyee.brickmod.block.BrickBlock;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class brickmod implements ModInitializer {

    public static String MOD_ID = "brickmod";
    public static BrickBlock BRICK_BLOCK = new BrickBlock();
    public static Item BRICK_INGOT = new Item(new Item.Settings().group(ItemGroup.MISC));
    public static ToolMaterialAll toolMaterial = new ToolMaterialAll();
    public static PickaxeBase BRICK_PICKAXE = new PickaxeBase(toolMaterial);
    public static SwordBase BRICK_SWORD = new SwordBase(toolMaterial);
    public static HoeBase BRICK_HOE = new HoeBase(toolMaterial);
    public static ShovelBase BRICK_SHOVEL = new ShovelBase(toolMaterial);
    public static AxeBase BRICK_AXE = new AxeBase(toolMaterial);
    public static Block BRICK_ORE = new Block(FabricBlockSettings
            .copy(Blocks.IRON_ORE)
            .sounds(BlockSoundGroup.STONE)
            .strength(2.0f, 4.0f)
    );

    public static ConfiguredFeature<?, ?> ORE_BRICK_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    BRICK_ORE.getDefaultState(),
                    4)) // vein size
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0, // bottom offset
                    32, // min y level
                    64))) // max y level
            .spreadHorizontally()
            .repeat(2); // number of veins per chunk



    @Override
    public void onInitialize() {
        // For brick block
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "brick_block"), BRICK_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "brick_block"), new BlockItem(BRICK_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        // For brick ingot
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "brick_ingot"), BRICK_INGOT);

        // For brick tools and combat
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "brick_pickaxe"), BRICK_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "brick_axe"), BRICK_AXE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "brick_sword"), BRICK_SWORD);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "brick_hoe"), BRICK_HOE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "brick_shovel"), BRICK_SHOVEL);

        // For the ore.
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MOD_ID, "ore_brick_overworld"), ORE_BRICK_OVERWORLD);
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "brick_ore"), BRICK_ORE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "brick_ore"), new BlockItem(BRICK_ORE, new Item.Settings().group(ItemGroup.MISC)));

    }
}
