package com.qtech.masterweapons.worldgen;

import com.qtech.masterweapons.MasterWeapons;
import com.qtech.masterweapons.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureSpreadConfig;
import net.minecraft.world.gen.feature.ReplaceBlockConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * @author Qboi123
 */
@Mod.EventBusSubscriber(modid = MasterWeapons.MOD_ID)
public class WorldGeneration {
    private static ConfiguredFeature<?, ?> feature;
    private static boolean initialized = false;

    private WorldGeneration() {
        throw new UnsupportedOperationException("Tried to initialize constructor of utility class.");
    }

    /**
     * Biome loader.
     *
     * @param event a biome loading event.
     */
    @SubscribeEvent
    public static void generate(BiomeLoadingEvent event) {
        if (!initialized) {
//            feature = Feature.EMERALD_ORE
//                    .withConfiguration(new ReplaceBlockConfig(Blocks.STONE.getDefaultState(), ModBlocks.MASTER_ORE.get().getDefaultState()))
//                    .withPlacement(Placement.COUNT.configure(new FeatureSpreadConfig(1)))
//                    .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 21)))
//                    .withPlacement(Placement.CHANCE.configure(new ChanceConfig(64)));
            feature = Feature.EMERALD_ORE
                    .withConfiguration(new ReplaceBlockConfig(Blocks.STONE.getDefaultState(), ModBlocks.MASTER_ORE.get().getDefaultState()))
                    .withPlacement(Placement.COUNT.configure(new FeatureSpreadConfig(1)))
                    .withPlacement(Placement.RANGE.configure(new TopSolidRangeConfig(0, 0, 21)))
                    .withPlacement(Placement.CHANCE.configure(new ChanceConfig(64)));

            MasterWeapons.LOGGER.debug("ORE_GEN: " + feature);
            MasterWeapons.LOGGER.debug("ORE_GEN: " + feature);
            MasterWeapons.LOGGER.debug("ORE_GEN: " + feature);
            MasterWeapons.LOGGER.debug("ORE_GEN: " + feature);
            MasterWeapons.LOGGER.debug("ORE_GEN: " + feature);
            MasterWeapons.LOGGER.debug("ORE_GEN: " + feature);
            MasterWeapons.LOGGER.debug("ORE_GEN: " + feature);
            MasterWeapons.LOGGER.debug("ORE_GEN: " + feature);
            MasterWeapons.LOGGER.debug("ORE_GEN: " + feature);
            MasterWeapons.LOGGER.debug("ORE_GEN: " + feature);
            MasterWeapons.LOGGER.debug("ORE_GEN: " + feature);
            MasterWeapons.LOGGER.debug("ORE_GEN: " + feature);
            MasterWeapons.LOGGER.debug("ORE_GEN: " + feature);
            MasterWeapons.LOGGER.debug("ORE_GEN: " + feature);
            initialized = true;
        }
        event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, feature);
    }
}