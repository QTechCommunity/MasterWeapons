package com.ultreon.mods.masterweapons.world.gen;

import com.ultreon.mods.masterweapons.MasterWeapons;
import dev.architectury.hooks.level.biome.BiomeProperties;
import dev.architectury.registry.level.biome.BiomeModifications;
import net.minecraft.tags.BiomeTags;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import static com.ultreon.mods.masterweapons.MasterWeapons.LOGGER;
import static net.minecraft.world.level.levelgen.GenerationStep.Decoration.UNDERGROUND_ORES;

/**
 * @author XyperCode
 */
public class WorldGeneration {

    private static final Marker MARKER = MarkerFactory.getMarker("WorldGen");

    private WorldGeneration() {

    }

    public static void init() {
        BiomeModifications.addProperties(context -> context.hasTag(BiomeTags.IS_OVERWORLD),
                WorldGeneration::modifyBiome);
    }

    private static void modifyBiome(BiomeModifications.BiomeContext context, BiomeProperties.Mutable properties) {
        context.getKey().ifPresent(biomeId -> LOGGER.info(MARKER, "Modifying biome: " + biomeId));
        properties.getGenerationProperties().addFeature(UNDERGROUND_ORES, WorldGenKeys.PLACED_ULTRAN_ORE);
    }
}