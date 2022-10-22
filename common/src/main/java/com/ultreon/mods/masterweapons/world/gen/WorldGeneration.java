package com.ultreon.mods.masterweapons.world.gen;

import com.ultreon.mods.masterweapons.MasterWeapons;
import com.ultreon.mods.masterweapons.init.ModBlocks;
import dev.architectury.hooks.level.biome.BiomeProperties;
import dev.architectury.registry.level.biome.BiomeModifications;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ReplaceBlockConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.util.List;

/**
 * @author Qboi123
 */
public class WorldGeneration {
    private static final Marker MARKER = MarkerFactory.getMarker("WorldGeneration");
    private static final boolean initialized = false;

    private WorldGeneration() {

    }

    public static void init() {
        BiomeModifications.addProperties(WorldGeneration::modify);
    }

    private static void modify(BiomeModifications.BiomeContext biomeContext, BiomeProperties.Mutable mutable) {
        Holder<ConfiguredFeature<ReplaceBlockConfiguration, ?>> configuredUltranOre = FeatureUtils.register(MasterWeapons.MOD_ID + ":ultran_ore", Feature.REPLACE_SINGLE_BLOCK, new ReplaceBlockConfiguration(List.of(
                OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.ULTRAN_ORE.get().defaultBlockState()),
                OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_ULTRAN_ORE.get().defaultBlockState()))));
        Holder<PlacedFeature> placedUltranOre = PlacementUtils.register(MasterWeapons.MOD_ID + ":ultran_ore", configuredUltranOre,
                List.of(CountPlacement.of(1),
                        HeightRangePlacement.uniform(VerticalAnchor.TOP, VerticalAnchor.BOTTOM),
                        RarityFilter.onAverageOnceEvery(64),
                        BiomeFilter.biome()));
        MasterWeapons.LOGGER.info(MARKER, "Adding features to biome '{}'", biomeContext.getKey());
        mutable.getGenerationProperties().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, placedUltranOre);
    }

    public static boolean isInitialized() {
        return initialized;
    }
}