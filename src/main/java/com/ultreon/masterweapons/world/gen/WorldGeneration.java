package com.ultreon.masterweapons.world.gen;

import com.ultreon.masterweapons.MasterWeapons;
import com.ultreon.masterweapons.init.ModPlacedFeatures;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

/**
 * @author Qboi123
 */
@Mod.EventBusSubscriber(modid = MasterWeapons.MOD_ID)
public class WorldGeneration {
    private static final Marker MARKER = MarkerFactory.getMarker("WorldGeneration");
    private static boolean initialized = false;

    private WorldGeneration() {
        throw new UnsupportedOperationException("Tried to initialize constructor of utility class.");
    }

    public static boolean isInitialized() {
        return initialized;
    }

    /**
     * Biome loader.
     *
     * @param event a biome loading event.
     */
    @SubscribeEvent
    public static void generate(BiomeLoadingEvent event) {
        if (!initialized) {
            initialized = true;
        }
        MasterWeapons.LOGGER.info(MARKER, "Adding features to biome '{}'", event.getName());
        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ULTRAN_ORE.getHolder().orElseThrow());
    }
}