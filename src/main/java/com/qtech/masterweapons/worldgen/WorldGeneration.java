package com.qtech.masterweapons.worldgen;

import com.qtech.masterweapons.ModBlocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class WorldGeneration {
    private WorldGeneration() {
        throw new UnsupportedOperationException("Tried to initialize constructor of utility class.");
    }

    public static void generate() {
        ConfiguredFeature<?, ?> feature = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.MASTER_ORE.get().getDefaultState(), 1)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(1, 0, 0, 12))).withPlacement(Placement.CHANCE_PASSTHROUGH.configure(new ChanceConfig(64)));
        for (Biome biome : ForgeRegistries.BIOMES.getValues()) {
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, feature);
        }
    }
}