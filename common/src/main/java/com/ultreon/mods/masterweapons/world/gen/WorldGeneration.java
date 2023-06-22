package com.ultreon.mods.masterweapons.world.gen;

import com.ultreon.mods.masterweapons.MasterWeapons;
import com.ultreon.mods.masterweapons.init.ModPlacedFeatures;
import dev.architectury.registry.level.biome.BiomeModifications;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * @author Qboi123
 */
public class WorldGeneration {
    private static final Marker MARKER = MarkerFactory.getMarker("WorldGeneration");
    private static final boolean initialized = false;

    private WorldGeneration() {

    }

    public static void init() {
        BiomeModifications.addProperties((biomeContext, mutable) -> {
            MasterWeapons.LOGGER.info(MARKER, "Adding features to biome '{}'", biomeContext.getKey());
            mutable.getGenerationProperties().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ResourceKey.create(Registries.PLACED_FEATURE, ModPlacedFeatures.ULTRAN_ORE.getId()));
        });
    }

    public static boolean isInitialized() {
        return initialized;
    }
}